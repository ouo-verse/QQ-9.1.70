package com.tencent.mobileqq.emoticonview.searchemo.dialog;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IPopupEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmotionSearchDialogUtil;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.SearchEmoticonUtils;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsEmoRuntimeServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.PopupEmotionSearchManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emoticonview.searchemo.IEmoticonEventCallback;
import com.tencent.mobileqq.emoticonview.searchemo.ISearchEmoticonMgrApi;
import com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb;
import com.tencent.mobileqq.emoticonview.searchemo.KeyboardVisibilityHelper;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerView;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerViewManager;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoUtil;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoticonListAdapter;
import com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog;
import com.tencent.mobileqq.emoticonview.searchemo.impl.SearchEmoticonMgrApiImpl;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.open.agent.util.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.utils.j;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicEmojiType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchSceneType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextMallEmojiInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\n*\u0002\u0082\u0001\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001BE\u0012\u0006\u0010I\u001a\u00020\t\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010T\u001a\u00020\u000f\u0012\u0006\u0010V\u001a\u00020\u0004\u0012\u0006\u0010X\u001a\u00020\u0004\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J$\u0010\u001b\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0002J \u0010*\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'H\u0002J,\u0010-\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0002J \u0010.\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'H\u0002J\b\u0010/\u001a\u00020\u0006H\u0014J\b\u00100\u001a\u00020\u0006H\u0014J\u000e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\fJ\u000e\u00104\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\fJ\u000e\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u00020\fJ\u0016\u00107\u001a\u00020\u00062\u0006\u00103\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000fJ\u0012\u0010:\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u000108H\u0017J\u001c\u0010>\u001a\u00020\f\"\u0004\b\u0000\u0010;2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?H\u0016J\u0006\u0010B\u001a\u00020\u0006J\u0006\u0010C\u001a\u00020\u000fJ\u000e\u0010D\u001a\u00020'2\u0006\u00106\u001a\u00020\u000fJ\u0010\u0010G\u001a\u00020\f2\u0006\u0010F\u001a\u00020EH\u0016J\b\u0010H\u001a\u00020\u0006H\u0016R\u0014\u0010I\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010WR\u0017\u0010Y\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R$\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010m\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u001c\u0010p\u001a\b\u0018\u00010oR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010ZR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010}\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001f\u0010\u0080\u0001\u001a\b\u0018\u00010\u007fR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;", "Landroid/app/Dialog;", "Landroid/content/DialogInterface$OnDismissListener;", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;", "", IProfileCardConst.KEY_FROM_TYPE, "", "reportForShow", "initWindow", "Landroid/content/Context;", "context", "initKeyboardVisibilityListener", "", "searchWordsIsEmpty", "initDialogSoftInputMode", "", "enterSearchWords", "initUI", "Landroid/view/View;", "parentView", "initHeaderView", "initRecyclerView", "Lcom/tencent/mobileqq/emoticonview/ipc/QQEmoticonMainPanelApp;", "qqEmoticonMainPanelApp", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchTask;", "task", "searchCallBack", "pushEmotionSearchTask", "resetEmoticonSearch", "resetKeyboardHelper", "view", "Lcom/tencent/mobileqq/emoticonview/HotPicSearchEmoticonInfo;", "emoticonInfo", "showAddCustomPopup", "addCustomEmoticon", "compositePicAndAddCustom", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchTextMallEmojiInfo;", "mallEmojiInfo", "addCustomEmotionForMall", "", EmojiManagerServiceProxy.EPID, "eId", "downloadJsonAndAddCustom", "Lcom/tencent/mobileqq/data/Emoticon;", "emo", "downloadImageAndAddCustom", "realAddCustomEmotionForMall", "onStart", DKHippyEvent.EVENT_STOP, "draggable", "setFloatingViewDraggable", "isComposite", "getLastTaskSearchWords", "onLoadMore", "searchWord", "loadSearchPicData", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchResult;", "result", "onSearchCallBack", "T", "", "list", "isEmpty", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "aioDestroy", "getSearchWords", "getKeywords", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "onBackPressed", "mContext", "Landroid/content/Context;", "Lmqq/app/AppRuntime;", "mAppRuntime", "Lmqq/app/AppRuntime;", "Lcom/tencent/mobileqq/emoticonview/searchemo/impl/SearchEmoticonMgrApiImpl;", "mEmotionDialogImpl", "Lcom/tencent/mobileqq/emoticonview/searchemo/impl/SearchEmoticonMgrApiImpl;", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "mEmoticonCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "mEnterSearchWords", "Ljava/lang/CharSequence;", "mFromType", "I", "mDefaultSelectTabIndex", "mSupportCompositeEmo", "Z", "getMSupportCompositeEmo", "()Z", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView;", "mHeaderView", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView;", "getMHeaderView", "()Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView;", "setMHeaderView", "(Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView;)V", "mMainPanelApp", "Lcom/tencent/mobileqq/emoticonview/ipc/QQEmoticonMainPanelApp;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerViewManager;", "mRecyclerViewManager", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerViewManager;", "Landroid/content/res/Configuration;", "mConfiguration", "Landroid/content/res/Configuration;", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$ConfigurationChangedListener;", "mConfigChangedListener", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$ConfigurationChangedListener;", "Ljava/lang/Runnable;", "mLoadPicDataRunnable", "Ljava/lang/Runnable;", "Lcom/tencent/mobileqq/emoticonview/searchemo/KeyboardVisibilityHelper;", "mKeyboardHelper", "Lcom/tencent/mobileqq/emoticonview/searchemo/KeyboardVisibilityHelper;", "mKeyboardVisible", "Landroid/widget/PopupWindow;", "mTipsPopupWindow", "Landroid/widget/PopupWindow;", "Landroid/graphics/Typeface;", "mTypeface", "Landroid/graphics/Typeface;", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$MallEmotionJsonDownloadListener;", "mJsonDownloadListener", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$MallEmotionJsonDownloadListener;", "com/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$infoAndActionCb$1", "infoAndActionCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$infoAndActionCb$1;", "<init>", "(Landroid/content/Context;Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/emoticonview/searchemo/impl/SearchEmoticonMgrApiImpl;Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;Ljava/lang/CharSequence;II)V", "Companion", "ConfigurationChangedListener", "LoadPicDataRunnable", "MallEmotionJsonDownloadListener", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class SearchEmoticonDialog extends ReportDialog implements DialogInterface.OnDismissListener, IEmotionSearchManagerService.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int FIRST_PULL_COUNTS = 32;
    public static final int ITEM_TYPE_INIT = 0;
    public static final int LOAD_MORE_COUNTS = 24;
    private static final long LOAD_PIC_DATA_DELAY = 500;

    @NotNull
    private static final String TAG = "SearchEmoticonDialog";

    @NotNull
    private final SearchEmoticonDialog$infoAndActionCb$1 infoAndActionCb;

    @Nullable
    private AppRuntime mAppRuntime;

    @Nullable
    private ConfigurationChangedListener mConfigChangedListener;

    @Nullable
    private Configuration mConfiguration;

    @NotNull
    private final Context mContext;
    private int mDefaultSelectTabIndex;

    @NotNull
    private IEmoticonEventCallback mEmoticonCallback;

    @Nullable
    private SearchEmoticonMgrApiImpl mEmotionDialogImpl;

    @NotNull
    private CharSequence mEnterSearchWords;

    @Nullable
    private QUSHalfScreenFloatingView mFloatingView;
    private int mFromType;

    @Nullable
    private SearchEmoHeaderView mHeaderView;

    @Nullable
    private volatile MallEmotionJsonDownloadListener mJsonDownloadListener;

    @Nullable
    private KeyboardVisibilityHelper mKeyboardHelper;
    private boolean mKeyboardVisible;

    @Nullable
    private Runnable mLoadPicDataRunnable;

    @Nullable
    private QQEmoticonMainPanelApp mMainPanelApp;

    @Nullable
    private SearchEmoRecyclerViewManager mRecyclerViewManager;
    private final boolean mSupportCompositeEmo;

    @Nullable
    private PopupWindow mTipsPopupWindow;

    @Nullable
    private volatile Typeface mTypeface;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$Companion;", "", "()V", "FIRST_PULL_COUNTS", "", "ITEM_TYPE_INIT", "LOAD_MORE_COUNTS", "LOAD_PIC_DATA_DELAY", "", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$ConfigurationChangedListener;", "Landroid/content/ComponentCallbacks;", "(Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;)V", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    private final class ConfigurationChangedListener implements ComponentCallbacks {
        static IPatchRedirector $redirector_;

        public ConfigurationChangedListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            IBinder iBinder;
            SearchEmoRecyclerView curRecyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newConfig);
                return;
            }
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            Object systemService = SearchEmoticonDialog.this.mContext.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = SearchEmoticonDialog.this.mRecyclerViewManager;
            if (searchEmoRecyclerViewManager != null && (curRecyclerView = searchEmoRecyclerViewManager.getCurRecyclerView()) != null) {
                iBinder = curRecyclerView.getWindowToken();
            } else {
                iBinder = null;
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = SearchEmoticonDialog.this.mFloatingView;
            if (qUSHalfScreenFloatingView != null) {
                qUSHalfScreenFloatingView.t();
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$LoadPicDataRunnable;", "Ljava/lang/Runnable;", "mSearchWords", "", "isComposite", "", "(Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;Ljava/lang/CharSequence;Z)V", TencentLocation.RUN_MODE, "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public final class LoadPicDataRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private final boolean isComposite;

        @NotNull
        private final CharSequence mSearchWords;
        final /* synthetic */ SearchEmoticonDialog this$0;

        public LoadPicDataRunnable(@NotNull SearchEmoticonDialog searchEmoticonDialog, CharSequence mSearchWords, boolean z16) {
            Intrinsics.checkNotNullParameter(mSearchWords, "mSearchWords");
            this.this$0 = searchEmoticonDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, searchEmoticonDialog, mSearchWords, Boolean.valueOf(z16));
            } else {
                this.mSearchWords = mSearchWords;
                this.isComposite = z16;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.loadSearchPicData(this.isComposite, this.mSearchWords);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog$MallEmotionJsonDownloadListener;", "Lcom/tencent/mobileqq/emoticon/EmotionJsonDownloadListener;", "(Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;)V", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "eId", "", EmojiManagerServiceProxy.EPID, "onJsonComplete", "", "ep", "Lcom/tencent/mobileqq/data/EmoticonPackage;", QzoneIPCModule.RESULT_CODE, "", "params", "Landroid/os/Bundle;", "setVars", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public final class MallEmotionJsonDownloadListener extends EmotionJsonDownloadListener {
        static IPatchRedirector $redirector_;

        @Nullable
        private WeakReference<Context> context;

        @Nullable
        private String eId;

        @Nullable
        private String epId;

        public MallEmotionJsonDownloadListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
        public void onJsonComplete(@NotNull EmoticonPackage ep5, int resultCode, @Nullable Bundle params) {
            WeakReference<Context> weakReference;
            Context context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, ep5, Integer.valueOf(resultCode), params);
                return;
            }
            Intrinsics.checkNotNullParameter(ep5, "ep");
            QLog.d(SearchEmoticonDialog.TAG, 1, "onJsonComplete:" + ep5.epId);
            if (resultCode == 0 && Intrinsics.areEqual(ep5.epId, this.epId) && this.epId != null && this.eId != null && (weakReference = this.context) != null && (context = weakReference.get()) != null) {
                SearchEmoticonDialog searchEmoticonDialog = SearchEmoticonDialog.this;
                String str = this.epId;
                Intrinsics.checkNotNull(str);
                String str2 = this.eId;
                Intrinsics.checkNotNull(str2);
                SearchEmoticonDialog.downloadImageAndAddCustom$default(searchEmoticonDialog, context, str, str2, null, 8, null);
            }
        }

        public final void setVars(@NotNull Context context, @NotNull String epId, @NotNull String eId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, epId, eId);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            this.context = new WeakReference<>(context);
            this.epId = epId;
            this.eId = eId;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23700);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$infoAndActionCb$1] */
    public SearchEmoticonDialog(@NotNull Context mContext, @Nullable AppRuntime appRuntime, @Nullable SearchEmoticonMgrApiImpl searchEmoticonMgrApiImpl, @NotNull IEmoticonEventCallback mEmoticonCallback, @NotNull CharSequence mEnterSearchWords, int i3, int i16) {
        super(mContext, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mEmoticonCallback, "mEmoticonCallback");
        Intrinsics.checkNotNullParameter(mEnterSearchWords, "mEnterSearchWords");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, appRuntime, searchEmoticonMgrApiImpl, mEmoticonCallback, mEnterSearchWords, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mContext = mContext;
        this.mAppRuntime = appRuntime;
        this.mEmotionDialogImpl = searchEmoticonMgrApiImpl;
        this.mEmoticonCallback = mEmoticonCallback;
        this.mEnterSearchWords = mEnterSearchWords;
        this.mFromType = i3;
        this.mDefaultSelectTabIndex = i16;
        boolean useCompositeEmoticon = SearchEmoticonUtils.INSTANCE.useCompositeEmoticon();
        this.mSupportCompositeEmo = useCompositeEmoticon;
        this.infoAndActionCb = new InfoAndActionCb() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$infoAndActionCb$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            public void clickCompositeTitle() {
                AppRuntime appRuntime2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                SearchEmoHeaderView mHeaderView = SearchEmoticonDialog.this.getMHeaderView();
                if (mHeaderView != null) {
                    mHeaderView.selectTab(1);
                }
                appRuntime2 = SearchEmoticonDialog.this.mAppRuntime;
                ReportController.o(appRuntime2, "dc00898", "", "", "0X800C581", "0X800C581", 0, 0, "", "", "", SearchEmoticonDialog.this.getSearchWords().toString());
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            public void clickEmoticonSetting() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                } else {
                    QRoute.createNavigator(SearchEmoticonDialog.this.mContext, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY).request();
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            public void clickEmoticonShop() {
                QQEmoticonMainPanelApp qQEmoticonMainPanelApp;
                QQEmoticonMainPanelApp qQEmoticonMainPanelApp2;
                QQEmoticonMainPanelApp qQEmoticonMainPanelApp3;
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 5)) {
                    qQEmoticonMainPanelApp = SearchEmoticonDialog.this.mMainPanelApp;
                    if (qQEmoticonMainPanelApp != null) {
                        SearchEmoticonDialog searchEmoticonDialog = SearchEmoticonDialog.this;
                        IEmosmService iEmosmService = (IEmosmService) QRoute.api(IEmosmService.class);
                        Context context = searchEmoticonDialog.mContext;
                        qQEmoticonMainPanelApp2 = searchEmoticonDialog.mMainPanelApp;
                        qQEmoticonMainPanelApp3 = searchEmoticonDialog.mMainPanelApp;
                        if (qQEmoticonMainPanelApp3 != null) {
                            str = qQEmoticonMainPanelApp3.getAccount();
                        } else {
                            str = null;
                        }
                        iEmosmService.openEmojiHomePage(context, qQEmoticonMainPanelApp2, str, 13, false, "", true);
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800C523", "0X800C523", 0, 0, "", "", "", "");
                    return;
                }
                iPatchRedirector2.redirect((short) 5, (Object) this);
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            public void clickFooterView(boolean isComposite) {
                SearchEmoticonListAdapter curAdapter;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 7)) {
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = SearchEmoticonDialog.this.mRecyclerViewManager;
                    if (searchEmoRecyclerViewManager != null) {
                        searchEmoRecyclerViewManager.updateLoadingStatus(isComposite, 5);
                    }
                    CharSequence curSearchWords = getCurSearchWords();
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager2 = SearchEmoticonDialog.this.mRecyclerViewManager;
                    boolean z16 = false;
                    if (searchEmoRecyclerViewManager2 != null && (curAdapter = searchEmoRecyclerViewManager2.getCurAdapter()) != null && curAdapter.checkDataContainEmotion()) {
                        z16 = true;
                    }
                    if (z16) {
                        SearchEmoticonDialog.this.onLoadMore(isComposite);
                        return;
                    } else {
                        SearchEmoticonDialog.this.loadSearchPicData(isComposite, curSearchWords);
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 7, (Object) this, isComposite);
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            @NotNull
            public CharSequence getCurSearchWords() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    return (CharSequence) iPatchRedirector2.redirect((short) 8, (Object) this);
                }
                return SearchEmoticonDialog.this.getSearchWords();
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            public int getLoadingStatus() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = SearchEmoticonDialog.this.mRecyclerViewManager;
                    if (searchEmoRecyclerViewManager != null) {
                        if (searchEmoRecyclerViewManager.checkIsCompositeTab()) {
                            return searchEmoRecyclerViewManager.getMCompositeLoadingStatus();
                        }
                        return searchEmoRecyclerViewManager.getMRecommendLoadingStatus();
                    }
                    return 0;
                }
                return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this)).intValue();
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            @Nullable
            public Typeface getTypeface() {
                Typeface typeface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 9)) {
                    typeface = SearchEmoticonDialog.this.mTypeface;
                    return typeface;
                }
                return (Typeface) iPatchRedirector2.redirect((short) 9, (Object) this);
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            public void sendEmotionHappened() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    QUSHalfScreenFloatingView qUSHalfScreenFloatingView = SearchEmoticonDialog.this.mFloatingView;
                    if (qUSHalfScreenFloatingView != null) {
                        qUSHalfScreenFloatingView.t();
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 3, (Object) this);
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb
            public void showAddCustomPopup(@NotNull View view, @Nullable HotPicSearchEmoticonInfo emoticonInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 10)) {
                    iPatchRedirector2.redirect((short) 10, (Object) this, (Object) view, (Object) emoticonInfo);
                } else {
                    Intrinsics.checkNotNullParameter(view, "view");
                    SearchEmoticonDialog.this.showAddCustomPopup(view, emoticonInfo);
                }
            }
        };
        QLog.i(TAG, 1, "init  mFromType:" + this.mFromType + ", mEnterSearchWords:" + ((Object) this.mEnterSearchWords));
        this.mMainPanelApp = new QQEmoticonMainPanelApp();
        initWindow();
        initKeyboardVisibilityListener(mContext);
        initDialogSoftInputMode(TextUtils.isEmpty(this.mEnterSearchWords));
        initUI(this.mEnterSearchWords);
        setOnDismissListener(this);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SearchEmoticonDialog._init_$lambda$0(SearchEmoticonDialog.this, dialogInterface);
            }
        });
        if (useCompositeEmoticon) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.g
                @Override // java.lang.Runnable
                public final void run() {
                    SearchEmoticonDialog._init_$lambda$1(SearchEmoticonDialog.this);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SearchEmoticonDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reportForShow(this$0.mFromType);
        EmotionDaTongReportUtil.INSTANCE.reportPageIn(this$0.mFloatingView, EmotionDaTongReportUtil.PG_BAS_MAGNIFYING_GLASS_EMOJI_SEARCH);
        SearchEmoHeaderView searchEmoHeaderView = this$0.mHeaderView;
        if (searchEmoHeaderView != null) {
            searchEmoHeaderView.onShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(SearchEmoticonDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mTypeface = SearchEmoUtil.INSTANCE.getTypeface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addCustomEmoticon(HotPicSearchEmoticonInfo emoticonInfo) {
        int i3;
        EmojiHotPicSearchTextMallEmojiInfo emojiHotPicSearchTextMallEmojiInfo;
        if (emoticonInfo.mSearchItem.emojiType == EmojiHotPicEmojiType.KMALL.ordinal() && (emojiHotPicSearchTextMallEmojiInfo = emoticonInfo.mSearchItem.mallEmojiInfo) != null) {
            Context context = this.mContext;
            Intrinsics.checkNotNullExpressionValue(emojiHotPicSearchTextMallEmojiInfo, "emoticonInfo.mSearchItem.mallEmojiInfo");
            addCustomEmotionForMall(context, emojiHotPicSearchTextMallEmojiInfo);
            return;
        }
        EmotionSearchItem emotionSearchItem = emoticonInfo.mSearchItem;
        if (emotionSearchItem.textComposeInfo == null) {
            if (!TextUtils.isEmpty(emotionSearchItem.appid) && TextUtils.isDigitsOnly(emoticonInfo.mSearchItem.appid)) {
                String str = emoticonInfo.mSearchItem.appid;
                Intrinsics.checkNotNullExpressionValue(str, "emoticonInfo.mSearchItem.appid");
                i3 = Integer.parseInt(str);
            } else {
                i3 = 0;
            }
            ((IEmosmService) QRoute.api(IEmosmService.class)).addToCustomEmotionForPic(this.mContext, emoticonInfo.mSearchItem.url, true, i3);
            return;
        }
        compositePicAndAddCustom(emoticonInfo);
    }

    private final void addCustomEmotionForMall(final Context context, final EmojiHotPicSearchTextMallEmojiInfo mallEmojiInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.c
            @Override // java.lang.Runnable
            public final void run() {
                SearchEmoticonDialog.addCustomEmotionForMall$lambda$17(EmojiHotPicSearchTextMallEmojiInfo.this, this, context);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCustomEmotionForMall$lambda$17(EmojiHotPicSearchTextMallEmojiInfo mallEmojiInfo, SearchEmoticonDialog this$0, Context context) {
        Intrinsics.checkNotNullParameter(mallEmojiInfo, "$mallEmojiInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        String valueOf = String.valueOf(mallEmojiInfo.mallEmojiPackId);
        String eId = mallEmojiInfo.mallEmojiPicId;
        j.Companion companion = com.tencent.qqnt.emotion.utils.j.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(eId, "eId");
        File file = new File(companion.f(valueOf, eId));
        QLog.i(TAG, 1, "addCustomEmotionForMall  path:" + file.getAbsolutePath() + "  exist:" + file.exists());
        if (file.exists()) {
            this$0.realAddCustomEmotionForMall(context, valueOf, eId);
        } else {
            this$0.downloadJsonAndAddCustom(context, valueOf, eId);
        }
    }

    private final void compositePicAndAddCustom(final HotPicSearchEmoticonInfo emoticonInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.j
            @Override // java.lang.Runnable
            public final void run() {
                SearchEmoticonDialog.compositePicAndAddCustom$lambda$16(HotPicSearchEmoticonInfo.this, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void compositePicAndAddCustom$lambda$16(HotPicSearchEmoticonInfo emoticonInfo, final SearchEmoticonDialog this$0) {
        String str;
        Pair<Integer, Integer> pair;
        Intrinsics.checkNotNullParameter(emoticonInfo, "$emoticonInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IHotPicApi iHotPicApi = (IHotPicApi) QRoute.api(IHotPicApi.class);
        String str2 = emoticonInfo.mSearchItem.originalUrl;
        Intrinsics.checkNotNullExpressionValue(str2, "emoticonInfo.mSearchItem.originalUrl");
        File diskFile = iHotPicApi.getDiskFile(str2);
        if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
            str = diskFile.getAbsolutePath();
            QLog.d(TAG, 1, "addCompositePicToCustom  originalUrl:" + emoticonInfo.mSearchItem.originalUrl + ", path:" + str);
            pair = new Pair<>(Integer.valueOf(emoticonInfo.mSearchItem.originalWidth), Integer.valueOf(emoticonInfo.mSearchItem.originalHeight));
        } else {
            IHotPicPageApi iHotPicPageApi = (IHotPicPageApi) QRoute.api(IHotPicPageApi.class);
            EmotionSearchItem emotionSearchItem = emoticonInfo.mSearchItem;
            Intrinsics.checkNotNullExpressionValue(emotionSearchItem, "emoticonInfo.mSearchItem");
            int checkAndDownLoadHotPic = iHotPicPageApi.checkAndDownLoadHotPic(emotionSearchItem);
            String str3 = null;
            if (checkAndDownLoadHotPic == 0) {
                IHotPicApi iHotPicApi2 = (IHotPicApi) QRoute.api(IHotPicApi.class);
                String str4 = emoticonInfo.mSearchItem.url;
                Intrinsics.checkNotNullExpressionValue(str4, "emoticonInfo.mSearchItem.url");
                File diskFile2 = iHotPicApi2.getDiskFile(str4);
                if (diskFile2 != null) {
                    str3 = diskFile2.getAbsolutePath();
                }
                QLog.d(TAG, 1, "addCompositePicToCustom  url:" + emoticonInfo.mSearchItem.url + ", path:" + str3);
            }
            str = str3;
            pair = new Pair<>(Integer.valueOf(emoticonInfo.mSearchItem.width), Integer.valueOf(emoticonInfo.mSearchItem.height));
        }
        String str5 = str;
        Pair<Integer, Integer> pair2 = pair;
        if (str5 == null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.b
                @Override // java.lang.Runnable
                public final void run() {
                    SearchEmoticonDialog.compositePicAndAddCustom$lambda$16$lambda$14(SearchEmoticonDialog.this);
                }
            });
            QLog.i(TAG, 1, "addCompositePicToCustom filePath is null");
            return;
        }
        Typeface typeface = this$0.mTypeface;
        if (typeface == null) {
            QLog.i(TAG, 1, "typeface is null");
            return;
        }
        IEmotionSearchDialogUtil iEmotionSearchDialogUtil = (IEmotionSearchDialogUtil) QRoute.api(IEmotionSearchDialogUtil.class);
        Context context = this$0.mContext;
        EmotionSearchItem emotionSearchItem2 = emoticonInfo.mSearchItem;
        Intrinsics.checkNotNullExpressionValue(emotionSearchItem2, "emoticonInfo.mSearchItem");
        String str6 = emoticonInfo.mSearchWord;
        Intrinsics.checkNotNullExpressionValue(str6, "emoticonInfo.mSearchWord");
        iEmotionSearchDialogUtil.addCompositePicToCustom(context, emotionSearchItem2, str6, str5, pair2, typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void compositePicAndAddCustom$lambda$16$lambda$14(SearchEmoticonDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.mContext, R.string.cwa, 0).show();
    }

    private final void downloadImageAndAddCustom(final Context context, final String epId, final String eId, Emoticon emo) {
        IEmoticonManagerService iEmoticonManagerService;
        URLDrawable drawable = URLDrawable.getDrawable(new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_PANEL, com.tencent.qqnt.emotion.constant.e.b(epId, eId)), URLDrawable.URLDrawableOptions.obtain());
        String str = "";
        String str2 = null;
        if (emo == null) {
            AppRuntime appRuntime = this.mAppRuntime;
            if (appRuntime != null && (iEmoticonManagerService = (IEmoticonManagerService) appRuntime.getRuntimeService(IEmoticonManagerService.class, "")) != null) {
                emo = iEmoticonManagerService.syncFindEmoticonById(epId, eId);
            } else {
                emo = null;
            }
        }
        drawable.setTag(emo);
        AppRuntime appRuntime2 = this.mAppRuntime;
        if (appRuntime2 != null) {
            str2 = appRuntime2.getCurrentUin();
        }
        if (str2 != null) {
            str = str2;
        }
        drawable.addHeader("my_uin", str);
        drawable.setDownloadListener(new URLDrawable.DownloadListener(context, epId, eId) { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$downloadImageAndAddCustom$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ String $eId;
            final /* synthetic */ String $epId;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$context = context;
                this.$epId = epId;
                this.$eId = eId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SearchEmoticonDialog.this, context, epId, eId);
                }
            }

            @Override // com.tencent.image.URLDrawable.DownloadListener
            public void onFileDownloadFailed(int errorCode) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, errorCode);
                    return;
                }
                QLog.e("SearchEmoticonDialog", 1, "onFileDownloadFailed  errorCode:" + errorCode);
            }

            @Override // com.tencent.image.URLDrawable.DownloadListener
            public void onFileDownloadStarted() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QLog.i("SearchEmoticonDialog", 1, "onFileDownloadStarted");
                }
            }

            @Override // com.tencent.image.URLDrawable.DownloadListener
            public void onFileDownloadSucceed(long fileSize) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, fileSize);
                    return;
                }
                QLog.i("SearchEmoticonDialog", 1, "onFileDownloadSucceed  fileSize:" + fileSize);
                SearchEmoticonDialog.this.realAddCustomEmotionForMall(this.$context, this.$epId, this.$eId);
            }
        });
        drawable.startDownload();
        ((IEmotionSearchDialogUtil) QRoute.api(IEmotionSearchDialogUtil.class)).fetchEmosmKey(this.mAppRuntime, emo);
        QLog.i(TAG, 1, "downloadImageAndAddCustom startDownload epId:" + epId + ", eId:" + eId);
    }

    static /* synthetic */ void downloadImageAndAddCustom$default(SearchEmoticonDialog searchEmoticonDialog, Context context, String str, String str2, Emoticon emoticon, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            emoticon = null;
        }
        searchEmoticonDialog.downloadImageAndAddCustom(context, str, str2, emoticon);
    }

    private final void downloadJsonAndAddCustom(Context context, String epId, String eId) {
        Emoticon emoticon;
        IEmojiManagerService iEmojiManagerService;
        IEmoticonManagerService iEmoticonManagerService;
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime != null && (iEmoticonManagerService = (IEmoticonManagerService) appRuntime.getRuntimeService(IEmoticonManagerService.class, "")) != null) {
            emoticon = iEmoticonManagerService.syncFindEmoticonById(epId, eId);
        } else {
            emoticon = null;
        }
        if (emoticon == null) {
            AppRuntime appRuntime2 = this.mAppRuntime;
            if (appRuntime2 != null && (iEmojiManagerService = (IEmojiManagerService) appRuntime2.getRuntimeService(IEmojiManagerService.class, "")) != null) {
                MallEmotionJsonDownloadListener mallEmotionJsonDownloadListener = this.mJsonDownloadListener;
                if (mallEmotionJsonDownloadListener == null) {
                    mallEmotionJsonDownloadListener = new MallEmotionJsonDownloadListener();
                    iEmojiManagerService.getEmojiListenerManager().addEmotionJsonDownloadListener(mallEmotionJsonDownloadListener);
                    this.mJsonDownloadListener = mallEmotionJsonDownloadListener;
                }
                mallEmotionJsonDownloadListener.setVars(context, epId, eId);
                iEmojiManagerService.startDownloadEmosmJson(epId, com.tencent.qqnt.emotion.constant.c.f356199a);
                QLog.i(TAG, 1, "downloadJsonAndAddCustom  epId:" + epId);
                return;
            }
            return;
        }
        downloadImageAndAddCustom(context, epId, eId, emoticon);
    }

    private final void initDialogSoftInputMode(boolean searchWordsIsEmpty) {
        int i3;
        if (searchWordsIsEmpty) {
            i3 = 4;
        } else {
            i3 = 2;
        }
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(i3 | 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initHeaderView(View parentView, final CharSequence enterSearchWords) {
        SearchEmoHeaderView searchEmoHeaderView = (SearchEmoHeaderView) parentView.findViewById(R.id.utq);
        this.mHeaderView = searchEmoHeaderView;
        if (searchEmoHeaderView != null) {
            searchEmoHeaderView.setEmotionEventCallback(this.mEmoticonCallback);
        }
        SearchEmoHeaderView searchEmoHeaderView2 = this.mHeaderView;
        if (searchEmoHeaderView2 != null) {
            searchEmoHeaderView2.setInfoAndActionCb(this.infoAndActionCb);
        }
        SearchEmoHeaderView searchEmoHeaderView3 = this.mHeaderView;
        if (searchEmoHeaderView3 != null) {
            searchEmoHeaderView3.setCallback(new SearchEmoHeaderView.HeaderViewCb(enterSearchWords) { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$initHeaderView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CharSequence $enterSearchWords;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$enterSearchWords = enterSearchWords;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this, (Object) enterSearchWords);
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView.HeaderViewCb
                public void clickCancelIcon() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = SearchEmoticonDialog.this.mFloatingView;
                        if (qUSHalfScreenFloatingView != null) {
                            qUSHalfScreenFloatingView.t();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 4, (Object) this);
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView.HeaderViewCb
                @NotNull
                public String getEnterSearchWords() {
                    CharSequence charSequence;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                        charSequence = SearchEmoticonDialog.this.mEnterSearchWords;
                        return charSequence.toString();
                    }
                    return (String) iPatchRedirector.redirect((short) 7, (Object) this);
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView.HeaderViewCb
                public boolean getKeyboardVisible() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                        z16 = SearchEmoticonDialog.this.mKeyboardVisible;
                        return z16;
                    }
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView.HeaderViewCb
                public void initViewsFinish() {
                    QQEmoticonMainPanelApp qQEmoticonMainPanelApp;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    SearchEmoHeaderView mHeaderView = SearchEmoticonDialog.this.getMHeaderView();
                    if (mHeaderView != null) {
                        mHeaderView.updateSearchWords(this.$enterSearchWords);
                    }
                    SearchEmoHeaderView mHeaderView2 = SearchEmoticonDialog.this.getMHeaderView();
                    if (mHeaderView2 != null) {
                        qQEmoticonMainPanelApp = SearchEmoticonDialog.this.mMainPanelApp;
                        mHeaderView2.getDefaultPageData(qQEmoticonMainPanelApp);
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView.HeaderViewCb
                public boolean isInMultiWindowMode() {
                    Activity activity;
                    boolean isInMultiWindowMode;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        Context context = SearchEmoticonDialog.this.mContext;
                        if (context instanceof Activity) {
                            activity = (Activity) context;
                        } else {
                            activity = null;
                        }
                        if (activity != null) {
                            isInMultiWindowMode = activity.isInMultiWindowMode();
                            return isInMultiWindowMode;
                        }
                        return false;
                    }
                    return false;
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView.HeaderViewCb
                public void pageTabChanged(int position, boolean fromUserClick) {
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                        iPatchRedirector.redirect((short) 8, this, Integer.valueOf(position), Boolean.valueOf(fromUserClick));
                        return;
                    }
                    if (position == 0) {
                        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager2 = SearchEmoticonDialog.this.mRecyclerViewManager;
                        if (searchEmoRecyclerViewManager2 != null) {
                            searchEmoRecyclerViewManager2.switchTab(false, SearchEmoticonDialog.this.getSearchWords());
                            return;
                        }
                        return;
                    }
                    if (position == 1 && (searchEmoRecyclerViewManager = SearchEmoticonDialog.this.mRecyclerViewManager) != null) {
                        searchEmoRecyclerViewManager.switchTab(true, SearchEmoticonDialog.this.getSearchWords());
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView.HeaderViewCb
                public void searchWordsChanged(@NotNull CharSequence searchWords) {
                    Runnable runnable;
                    Runnable runnable2;
                    boolean z16;
                    Runnable runnable3;
                    long j3;
                    Runnable runnable4;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) searchWords);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(searchWords, "searchWords");
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = SearchEmoticonDialog.this.mRecyclerViewManager;
                    if (searchEmoRecyclerViewManager != null) {
                        searchEmoRecyclerViewManager.clearData();
                    }
                    boolean z17 = false;
                    if (TextUtils.isEmpty(SearchEmoticonDialog.this.getKeywords(searchWords))) {
                        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager2 = SearchEmoticonDialog.this.mRecyclerViewManager;
                        if (searchEmoRecyclerViewManager2 != null) {
                            searchEmoRecyclerViewManager2.updateLoadingStatus(0);
                        }
                        runnable4 = SearchEmoticonDialog.this.mLoadPicDataRunnable;
                        if (runnable4 != null) {
                            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable4);
                            return;
                        }
                        return;
                    }
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager3 = SearchEmoticonDialog.this.mRecyclerViewManager;
                    if (searchEmoRecyclerViewManager3 != null) {
                        searchEmoRecyclerViewManager3.updateLoadingStatus(5);
                    }
                    runnable = SearchEmoticonDialog.this.mLoadPicDataRunnable;
                    if (runnable != null) {
                        runnable2 = SearchEmoticonDialog.this.mLoadPicDataRunnable;
                        if (runnable2 != null) {
                            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable2);
                        }
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    SearchEmoticonDialog searchEmoticonDialog = SearchEmoticonDialog.this;
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager4 = searchEmoticonDialog.mRecyclerViewManager;
                    if (searchEmoRecyclerViewManager4 != null) {
                        z17 = searchEmoRecyclerViewManager4.getMIsCompositeTab();
                    }
                    searchEmoticonDialog.mLoadPicDataRunnable = new SearchEmoticonDialog.LoadPicDataRunnable(searchEmoticonDialog, searchWords, z17);
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    runnable3 = SearchEmoticonDialog.this.mLoadPicDataRunnable;
                    Intrinsics.checkNotNull(runnable3, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog.LoadPicDataRunnable");
                    SearchEmoticonDialog.LoadPicDataRunnable loadPicDataRunnable = (SearchEmoticonDialog.LoadPicDataRunnable) runnable3;
                    if (z16) {
                        j3 = 0;
                    } else {
                        j3 = 500;
                    }
                    uIHandlerV2.postDelayed(loadPicDataRunnable, j3);
                }
            });
        }
    }

    private final void initKeyboardVisibilityListener(Context context) {
        Window window = getWindow();
        if (window == null) {
            QLog.d(TAG, 1, "dialog window is null, initKeyboardVisibilityListener failed");
        } else {
            this.mKeyboardHelper = new KeyboardVisibilityHelper(context, window.getDecorView(), new KeyboardVisibilityHelper.KeyboardCallback() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.a
                @Override // com.tencent.mobileqq.emoticonview.searchemo.KeyboardVisibilityHelper.KeyboardCallback
                public final void onKeyboardHeightChanged(int i3, boolean z16) {
                    SearchEmoticonDialog.initKeyboardVisibilityListener$lambda$3(SearchEmoticonDialog.this, i3, z16);
                }
            }, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initKeyboardVisibilityListener$lambda$3(SearchEmoticonDialog this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchEmoHeaderView searchEmoHeaderView = this$0.mHeaderView;
        if (searchEmoHeaderView != null) {
            searchEmoHeaderView.updateSearchInputFocus(z16);
        }
        QLog.d(TAG, 1, "keyboardHeight:" + i3 + ", visible:" + this$0.mKeyboardVisible + " -> " + z16);
        this$0.mKeyboardVisible = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initRecyclerView(View parentView, CharSequence enterSearchWords) {
        this.mRecyclerViewManager = new SearchEmoRecyclerViewManager(this.mAppRuntime, this.mContext, parentView, enterSearchWords, this.mFromType, this.mEmoticonCallback, this.infoAndActionCb, this);
    }

    private final void initUI(final CharSequence enterSearchWords) {
        setContentView(R.layout.e3i);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        this.mFloatingView = qUSHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setQUSDragFloatController(new com.tencent.mobileqq.widget.qus.e(enterSearchWords) { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$initUI$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CharSequence $enterSearchWords;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$enterSearchWords = enterSearchWords;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this, (Object) enterSearchWords);
                    }
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public boolean canScrollDown(float x16, float y16) {
                    boolean z16;
                    SearchEmoRecyclerView searchEmoRecyclerView;
                    Object obj;
                    boolean z17;
                    View childAt;
                    SearchEmoRecyclerView curRecyclerView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
                    }
                    SearchEmoHeaderView mHeaderView = SearchEmoticonDialog.this.getMHeaderView();
                    if (mHeaderView != null && mHeaderView.touchInHeaderViewArea((int) x16, (int) y16)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = SearchEmoticonDialog.this.mRecyclerViewManager;
                        LinearLayoutManager linearLayoutManager = null;
                        if (searchEmoRecyclerViewManager != null) {
                            searchEmoRecyclerView = searchEmoRecyclerViewManager.getCurRecyclerView();
                        } else {
                            searchEmoRecyclerView = null;
                        }
                        if (searchEmoRecyclerView != null) {
                            SearchEmoRecyclerViewManager searchEmoRecyclerViewManager2 = SearchEmoticonDialog.this.mRecyclerViewManager;
                            if (searchEmoRecyclerViewManager2 != null && (curRecyclerView = searchEmoRecyclerViewManager2.getCurRecyclerView()) != null) {
                                obj = curRecyclerView.getLayoutManager();
                            } else {
                                obj = null;
                            }
                            if (obj instanceof LinearLayoutManager) {
                                linearLayoutManager = (LinearLayoutManager) obj;
                            }
                            if (linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17 || (childAt = ((LinearLayoutManager) obj).getChildAt(0)) == null || childAt.getTop() != 0) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    return true;
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public boolean canScrollUp(float x16, float y16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                        return true;
                    }
                    return ((Boolean) iPatchRedirector.redirect((short) 6, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
                }

                @Override // com.tencent.mobileqq.widget.qus.d
                @Nullable
                /* renamed from: createContentView */
                public View getF57179d() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (View) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    View view = LayoutInflater.from(SearchEmoticonDialog.this.mContext).inflate(R.layout.e6z, (ViewGroup) null);
                    view.setFitsSystemWindows(true);
                    SearchEmoticonDialog searchEmoticonDialog = SearchEmoticonDialog.this;
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    searchEmoticonDialog.initHeaderView(view, this.$enterSearchWords);
                    SearchEmoticonDialog.this.initRecyclerView(view, this.$enterSearchWords);
                    return view;
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public int maxHeight() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                    }
                    return (int) (SearchEmoticonDialog.this.mContext.getResources().getDisplayMetrics().heightPixels * 0.85d);
                }

                @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
                public int showMode() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                    }
                    return 1;
                }
            });
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.e
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    SearchEmoticonDialog.initUI$lambda$4(SearchEmoticonDialog.this);
                }
            });
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.i(new QUSBaseHalfScreenFloatingView.n() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$initUI$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this);
                    }
                }

                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
                public void onFinishDrag() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
                public void onStartDrag() {
                    SearchEmoRecyclerView curRecyclerView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.d("SearchEmoticonDialog", 1, "start drag, animation stop");
                    AbstractGifImage.pauseAll();
                    SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = SearchEmoticonDialog.this.mRecyclerViewManager;
                    if (searchEmoRecyclerViewManager != null && (curRecyclerView = searchEmoRecyclerViewManager.getCurRecyclerView()) != null) {
                        int childCount = curRecyclerView.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = curRecyclerView.getChildAt(i3);
                            if (childAt instanceof SearchEmoLinearLayout) {
                                ((SearchEmoLinearLayout) childAt).removeLongClickCb(true);
                            }
                        }
                    }
                }
            });
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mFloatingView;
        if (qUSHalfScreenFloatingView4 != null) {
            qUSHalfScreenFloatingView4.j(new com.tencent.mobileqq.widget.qus.a() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$initUI$4
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this);
                    }
                }

                @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
                public void onShowTotal() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        AbstractGifImage.resumeAll();
                        QUIImmersiveHelper.u(SearchEmoticonDialog.this.getWindow(), true, true);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUI$lambda$4(SearchEmoticonDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "floating view dismiss");
        AbstractGifImage.resumeAll();
        SearchEmoticonMgrApiImpl searchEmoticonMgrApiImpl = this$0.mEmotionDialogImpl;
        if (searchEmoticonMgrApiImpl != null) {
            searchEmoticonMgrApiImpl.dialogDismiss();
        }
        this$0.dismiss();
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            QLog.d(TAG, 1, "dialog window is null, return");
            return;
        }
        window.setLayout(-1, -1);
        window.getAttributes().gravity = 80;
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSearchCallBack$lambda$9(SearchEmoticonDialog this$0, IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mSupportCompositeEmo && emotionSearchResult.allowComposite) {
            z16 = true;
        } else {
            z16 = false;
        }
        SearchEmoHeaderView searchEmoHeaderView = this$0.mHeaderView;
        if (searchEmoHeaderView != null) {
            searchEmoHeaderView.setShowComposite(z16);
        }
        if (z16 && (i3 = this$0.mDefaultSelectTabIndex) == 1) {
            SearchEmoHeaderView searchEmoHeaderView2 = this$0.mHeaderView;
            if (searchEmoHeaderView2 != null) {
                searchEmoHeaderView2.selectTab(i3);
            }
            this$0.mDefaultSelectTabIndex = -1;
        }
        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = this$0.mRecyclerViewManager;
        if (searchEmoRecyclerViewManager != null) {
            searchEmoRecyclerViewManager.onHandleResult(emotionSearchResult);
        }
    }

    private final void pushEmotionSearchTask(QQEmoticonMainPanelApp qqEmoticonMainPanelApp, IEmotionSearchManagerService.EmotionSearchTask task, IEmotionSearchManagerService.a searchCallBack) {
        String str;
        long j3;
        long j16;
        boolean z16 = true;
        if (qqEmoticonMainPanelApp == null) {
            QLog.e(TAG, 1, "pushEmotionSearchTask is error, app is null!");
            return;
        }
        QLog.d(TAG, 1, "pushEmotionSearchTask ");
        AbsEmoRuntimeServiceProxy<? extends IRuntimeService> runtimeService = qqEmoticonMainPanelApp.getRuntimeService(IPopupEmotionSearchManagerService.class);
        Intrinsics.checkNotNull(runtimeService, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.ipc.proxy.PopupEmotionSearchManagerServiceProxy");
        PopupEmotionSearchManagerServiceProxy popupEmotionSearchManagerServiceProxy = (PopupEmotionSearchManagerServiceProxy) runtimeService;
        if (task.sceneType != EmojiHotPicSearchSceneType.KMAGNIFIERCOMPOSE.ordinal()) {
            z16 = false;
        }
        popupEmotionSearchManagerServiceProxy.resetData(z16);
        popupEmotionSearchManagerServiceProxy.setSearchCallBack(searchCallBack);
        int chatType = popupEmotionSearchManagerServiceProxy.getChatType(this.mContext);
        task.chatType = chatType;
        task.aioType = popupEmotionSearchManagerServiceProxy.getAioType(chatType);
        AIOContact aioContact = popupEmotionSearchManagerServiceProxy.getAioContact(getContext());
        int a16 = aioContact.a();
        String b16 = aioContact.b();
        String c16 = aioContact.c();
        if (popupEmotionSearchManagerServiceProxy.isC2COrTempChat(a16)) {
            str = b16;
        } else {
            str = "";
        }
        task.guestUid = str;
        long j17 = 0;
        if (popupEmotionSearchManagerServiceProxy.isGroupOrGuildGroup(a16)) {
            j3 = o.c(b16);
        } else {
            j3 = 0;
        }
        task.groupCode = j3;
        if (popupEmotionSearchManagerServiceProxy.isGuildOrGuildGroup(a16)) {
            j16 = o.c(c16);
        } else {
            j16 = 0;
        }
        task.guildId = j16;
        if (a16 == 4) {
            j17 = o.c(b16);
        }
        task.channelId = j17;
        popupEmotionSearchManagerServiceProxy.pushEmotionSearchTask(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void realAddCustomEmotionForMall(Context context, String epId, String eId) {
        FragmentActivity fragmentActivity;
        LifecycleCoroutineScope lifecycleScope;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) == null || CorountineFunKt.e(lifecycleScope, TAG, null, null, null, new SearchEmoticonDialog$realAddCustomEmotionForMall$1(context, epId, eId, null), 14, null) == null) {
            QLog.i(TAG, 1, "addCustomEmotionForMall error can't get lifecycleScope");
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void reportForShow(int fromType) {
        String str;
        if (fromType == 1) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(null, "dc00898", "", "", "0X800C51F", "0X800C51F", 0, 0, str, "", "", "");
    }

    private final void resetEmoticonSearch() {
        IPopupEmotionSearchManagerService iPopupEmotionSearchManagerService;
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.mMainPanelApp;
        if (qQEmoticonMainPanelApp != null) {
            iPopupEmotionSearchManagerService = (IPopupEmotionSearchManagerService) qQEmoticonMainPanelApp.getService(IPopupEmotionSearchManagerService.class);
        } else {
            iPopupEmotionSearchManagerService = null;
        }
        if (iPopupEmotionSearchManagerService == null) {
            return;
        }
        iPopupEmotionSearchManagerService.resetData();
    }

    private final void resetKeyboardHelper() {
        KeyboardVisibilityHelper keyboardVisibilityHelper = this.mKeyboardHelper;
        if (keyboardVisibilityHelper != null) {
            if (keyboardVisibilityHelper != null) {
                keyboardVisibilityHelper.dismiss();
            }
            this.mKeyboardHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddCustomPopup(final View view, final HotPicSearchEmoticonInfo emoticonInfo) {
        final LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        TextView textView = new TextView(this.mContext);
        textView.setId(R.id.f164035i0);
        textView.setOnClickListener(new View.OnClickListener(emoticonInfo) { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog$showAddCustomPopup$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ HotPicSearchEmoticonInfo $emoticonInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$emoticonInfo = emoticonInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonDialog.this, (Object) emoticonInfo);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(@Nullable View v3) {
                PopupWindow popupWindow;
                PopupWindow popupWindow2;
                PopupWindow popupWindow3;
                EventCollector.getInstance().onViewClickedBefore(v3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                } else {
                    QLog.d("SearchEmoticonDialog", 1, "showAddCustomPopup");
                    popupWindow = SearchEmoticonDialog.this.mTipsPopupWindow;
                    if (popupWindow != null) {
                        popupWindow2 = SearchEmoticonDialog.this.mTipsPopupWindow;
                        Intrinsics.checkNotNull(popupWindow2);
                        if (popupWindow2.isShowing()) {
                            QLog.i("SearchEmoticonDialog", 1, "showAddCustomPopup  emoticonInfo:" + this.$emoticonInfo);
                            HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo = this.$emoticonInfo;
                            if (hotPicSearchEmoticonInfo != null) {
                                SearchEmoticonDialog searchEmoticonDialog = SearchEmoticonDialog.this;
                                if (hotPicSearchEmoticonInfo.mSearchItem != null) {
                                    searchEmoticonDialog.addCustomEmoticon(hotPicSearchEmoticonInfo);
                                }
                            }
                            popupWindow3 = SearchEmoticonDialog.this.mTipsPopupWindow;
                            if (popupWindow3 != null) {
                                popupWindow3.dismiss();
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(v3);
            }
        });
        textView.setTextColor(this.mContext.getResources().getColor(R.color.f158017al3));
        textView.setTextSize(14.0f);
        textView.setGravity(17);
        textView.setText(R.string.f209185eq);
        textView.setBackgroundResource(R.drawable.cay);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(ViewUtils.dip2px(65.0f), ViewUtils.dip2px(46.0f)));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.cau));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(10.0f)));
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = -EmotionUtils.a(7.0f, this.mContext.getResources());
        layoutParams2.bottomMargin = EmotionUtils.a(3.0f, this.mContext.getResources());
        imageView.setLayoutParams(layoutParams2);
        PopupWindow popupWindow = new PopupWindow(linearLayout, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.h
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                SearchEmoticonDialog.showAddCustomPopup$lambda$13$lambda$11(SearchEmoticonDialog.this);
            }
        });
        linearLayout.measure(0, 0);
        view.post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.i
            @Override // java.lang.Runnable
            public final void run() {
                SearchEmoticonDialog.showAddCustomPopup$lambda$13$lambda$12(SearchEmoticonDialog.this, view, linearLayout);
            }
        });
        this.mTipsPopupWindow = popupWindow;
        ((ISearchEmoticonMgrApi) QRoute.api(ISearchEmoticonMgrApi.class)).setFloatingViewDraggable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAddCustomPopup$lambda$13$lambda$11(SearchEmoticonDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mTipsPopupWindow = null;
        ((ISearchEmoticonMgrApi) QRoute.api(ISearchEmoticonMgrApi.class)).setFloatingViewDraggable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAddCustomPopup$lambda$13$lambda$12(SearchEmoticonDialog this$0, View view, LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(linearLayout, "$linearLayout");
        Context context = this$0.mContext;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            PopupWindow popupWindow = this$0.mTipsPopupWindow;
            if (popupWindow != null) {
                popupWindow.showAtLocation(view, 48, (int) (iArr[0] - (view.getMeasuredWidth() * 1.5f)), iArr[1] - linearLayout.getMeasuredHeight());
            }
        }
    }

    public final void aioDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.mFloatingView != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "aio destroy, mFloatingView need dismiss");
            }
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mFloatingView;
            if (qUSHalfScreenFloatingView != null) {
                qUSHalfScreenFloatingView.t();
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        IBinder iBinder;
        SearchEmoRecyclerView curRecyclerView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int actionMasked = ev5.getActionMasked();
        boolean z17 = true;
        if (actionMasked != 0) {
            if (actionMasked == 1 && (qUSHalfScreenFloatingView2 = this.mFloatingView) != null) {
                qUSHalfScreenFloatingView2.setDraggable(true);
            }
        } else {
            SearchEmoHeaderView searchEmoHeaderView = this.mHeaderView;
            if (searchEmoHeaderView != null && searchEmoHeaderView.touchInHeaderViewArea((int) ev5.getRawX(), (int) ev5.getRawY())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (qUSHalfScreenFloatingView = this.mFloatingView) != null) {
                qUSHalfScreenFloatingView.setDraggable(false);
            }
            SearchEmoHeaderView searchEmoHeaderView2 = this.mHeaderView;
            if (searchEmoHeaderView2 == null || !searchEmoHeaderView2.touchInHeaderViewInputArea((int) ev5.getRawX(), (int) ev5.getRawY())) {
                z17 = false;
            }
            if (!z17) {
                this.mEmoticonCallback.showPanel();
                Object systemService = this.mContext.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = this.mRecyclerViewManager;
                if (searchEmoRecyclerViewManager != null && (curRecyclerView = searchEmoRecyclerViewManager.getCurRecyclerView()) != null) {
                    iBinder = curRecyclerView.getWindowToken();
                } else {
                    iBinder = null;
                }
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    @NotNull
    public final String getKeywords(@NotNull CharSequence searchWord) {
        String replace$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) searchWord);
        }
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        if (searchWord instanceof QQTextBuilder) {
            try {
                String plainText = ((QQTextBuilder) searchWord).toPlainText();
                Intrinsics.checkNotNullExpressionValue(plainText, "searchWord.toPlainText()");
                replace$default = StringsKt__StringsJVMKt.replace$default(plainText, GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI, "", false, 4, (Object) null);
                return replace$default;
            } catch (StringIndexOutOfBoundsException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return searchWord.toString();
            }
        }
        return searchWord.toString();
    }

    @NotNull
    public final CharSequence getLastTaskSearchWords(boolean isComposite) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this, isComposite);
        }
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.mMainPanelApp;
        if (qQEmoticonMainPanelApp == null) {
            QLog.i(TAG, 1, "mMainPanelApp is null, return");
            return "";
        }
        AbsEmoRuntimeServiceProxy<? extends IRuntimeService> runtimeService = qQEmoticonMainPanelApp.getRuntimeService(IPopupEmotionSearchManagerService.class);
        Intrinsics.checkNotNull(runtimeService, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.ipc.proxy.PopupEmotionSearchManagerServiceProxy");
        IEmotionSearchManagerService.EmotionSearchTask lastTask = ((PopupEmotionSearchManagerServiceProxy) runtimeService).getLastTask(isComposite);
        if (lastTask == null) {
            QLog.i(TAG, 1, "lastTask is null, return");
            return "";
        }
        String str = lastTask.searchKeyWords;
        Intrinsics.checkNotNullExpressionValue(str, "lastTask.searchKeyWords");
        return str;
    }

    @Nullable
    public final SearchEmoHeaderView getMHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SearchEmoHeaderView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mHeaderView;
    }

    public final boolean getMSupportCompositeEmo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mSupportCompositeEmo;
    }

    @NotNull
    public final CharSequence getSearchWords() {
        CharSequence searchWords;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CharSequence) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        SearchEmoHeaderView searchEmoHeaderView = this.mHeaderView;
        if (searchEmoHeaderView == null || (searchWords = searchEmoHeaderView.getSearchWords()) == null) {
            return "";
        }
        return searchWords;
    }

    public final <T> boolean isEmpty(@Nullable List<? extends T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) list)).booleanValue();
        }
        List<? extends T> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void loadSearchPicData(boolean isComposite, @NotNull CharSequence searchWord) {
        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager;
        EmojiHotPicSearchSceneType emojiHotPicSearchSceneType;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(isComposite), searchWord);
            return;
        }
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        if (!TextUtils.isEmpty(searchWord) && (searchEmoRecyclerViewManager = this.mRecyclerViewManager) != null) {
            if (searchEmoRecyclerViewManager != null) {
                SearchEmoRecyclerViewManager.clearData$default(searchEmoRecyclerViewManager, isComposite, null, 2, null);
            }
            SearchEmoRecyclerViewManager searchEmoRecyclerViewManager2 = this.mRecyclerViewManager;
            if (searchEmoRecyclerViewManager2 != null) {
                searchEmoRecyclerViewManager2.updateLoadingStatus(isComposite, 5);
            }
            String keywords = getKeywords(searchWord);
            if (!isComposite) {
                i3 = 1;
            }
            IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask = new IEmotionSearchManagerService.EmotionSearchTask(i3, keywords);
            emotionSearchTask.setFirstTimePullCount(32);
            emotionSearchTask.setLoadMorePullCount(24);
            if (isComposite) {
                emojiHotPicSearchSceneType = EmojiHotPicSearchSceneType.KMAGNIFIERCOMPOSE;
            } else {
                emojiHotPicSearchSceneType = EmojiHotPicSearchSceneType.KMANGIFIER;
            }
            emotionSearchTask.sceneType = emojiHotPicSearchSceneType.ordinal();
            emotionSearchTask.isSupportCompose = true;
            emotionSearchTask.isSupportMall = true;
            pushEmotionSearchTask(this.mMainPanelApp, emotionSearchTask, this);
            ReportController.o(null, "dc00898", "", "", "0X800C524", "0X800C524", 0, 0, "", "", "", keywords);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        AppRuntime appRuntime;
        IEmojiManagerService iEmojiManagerService;
        IEmojiListenerManager emojiListenerManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        QLog.i(TAG, 1, "onDismiss");
        resetEmoticonSearch();
        resetKeyboardHelper();
        EmotionDaTongReportUtil.INSTANCE.reportPageOut(this.mFloatingView, EmotionDaTongReportUtil.PG_BAS_MAGNIFYING_GLASS_EMOJI_SEARCH);
        SearchEmoHeaderView searchEmoHeaderView = this.mHeaderView;
        if (searchEmoHeaderView != null) {
            searchEmoHeaderView.onDestroy();
        }
        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = this.mRecyclerViewManager;
        if (searchEmoRecyclerViewManager != null) {
            searchEmoRecyclerViewManager.destroy();
        }
        this.mEnterSearchWords = "";
        this.mAppRuntime = null;
        this.mMainPanelApp = null;
        this.mEmotionDialogImpl = null;
        MallEmotionJsonDownloadListener mallEmotionJsonDownloadListener = this.mJsonDownloadListener;
        if (mallEmotionJsonDownloadListener != null && (appRuntime = this.mAppRuntime) != null && (iEmojiManagerService = (IEmojiManagerService) appRuntime.getRuntimeService(IEmojiManagerService.class, "")) != null && (emojiListenerManager = iEmojiManagerService.getEmojiListenerManager()) != null) {
            emojiListenerManager.removeEmotionJsonDownloadListener(mallEmotionJsonDownloadListener);
        }
    }

    public final void onLoadMore(boolean isComposite) {
        IPopupEmotionSearchManagerService iPopupEmotionSearchManagerService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isComposite);
            return;
        }
        QLog.d(TAG, 1, "start onLoadMore");
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.mMainPanelApp;
        if (qQEmoticonMainPanelApp != null) {
            iPopupEmotionSearchManagerService = (IPopupEmotionSearchManagerService) qQEmoticonMainPanelApp.getService(IPopupEmotionSearchManagerService.class);
        } else {
            iPopupEmotionSearchManagerService = null;
        }
        if (iPopupEmotionSearchManagerService == null) {
            return;
        }
        iPopupEmotionSearchManagerService.loadMore(isComposite);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.a
    @WorkerThread
    public void onSearchCallBack(@Nullable final IEmotionSearchManagerService.EmotionSearchResult result) {
        Integer num;
        Typeface typeface;
        Typeface typeface2;
        IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) result);
            return;
        }
        Integer num2 = null;
        if (result != null && (emotionSearchTask = result.searchTask) != null) {
            num = Integer.valueOf(emotionSearchTask.taskType);
        } else {
            num = null;
        }
        if (result != null) {
            num2 = Integer.valueOf(result.getResult());
        }
        QLog.d(TAG, 1, "onSearchCallBack  taskType:" + num + ", result:" + num2);
        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager = this.mRecyclerViewManager;
        if (searchEmoRecyclerViewManager == null) {
            return;
        }
        boolean z16 = false;
        if (result == null) {
            searchEmoRecyclerViewManager.setMRecommendLoadMore(false);
            return;
        }
        IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask2 = result.searchTask;
        if (emotionSearchTask2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "result.searchTask is null, return");
                return;
            }
            return;
        }
        if (emotionSearchTask2.taskType == 2) {
            z16 = true;
        }
        if (result.getResult() != -101 && result.getResult() != -103) {
            if (z16) {
                if (this.mTypeface == null && (typeface2 = SearchEmoUtil.INSTANCE.getTypeface()) != null) {
                    this.mTypeface = typeface2;
                    Unit unit = Unit.INSTANCE;
                }
                if (this.mTypeface == null) {
                    result.setResult(-100);
                    QLog.i(TAG, 1, "onSearchCallBack  typeface is null");
                }
            } else {
                ArrayList<EmotionSearchItem> arrayList = result.topCompositeList;
                if (arrayList != null) {
                    Intrinsics.checkNotNullExpressionValue(arrayList, "result.topCompositeList");
                    if (!arrayList.isEmpty()) {
                        if (this.mTypeface == null && (typeface = SearchEmoUtil.INSTANCE.getTypeface()) != null) {
                            this.mTypeface = typeface;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        if (this.mTypeface == null) {
                            result.topCompositeList = new ArrayList<>();
                            QLog.i(TAG, 1, "onSearchCallBack  typeface is null");
                        }
                    }
                }
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.searchemo.dialog.d
                @Override // java.lang.Runnable
                public final void run() {
                    SearchEmoticonDialog.onSearchCallBack$lambda$9(SearchEmoticonDialog.this, result);
                }
            });
            return;
        }
        SearchEmoRecyclerViewManager searchEmoRecyclerViewManager2 = this.mRecyclerViewManager;
        if (searchEmoRecyclerViewManager2 != null) {
            searchEmoRecyclerViewManager2.updateLoadMore(z16);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onStart();
        this.mConfiguration = this.mContext.getResources().getConfiguration();
        this.mConfigChangedListener = new ConfigurationChangedListener();
        getContext().registerComponentCallbacks(this.mConfigChangedListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStop();
            getContext().unregisterComponentCallbacks(this.mConfigChangedListener);
        }
    }

    public final void setFloatingViewDraggable(boolean draggable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, draggable);
            return;
        }
        QLog.i(TAG, 1, "\u8bbe\u7f6emFloating draggable: " + draggable);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setDraggable(draggable);
        }
    }

    public final void setMHeaderView(@Nullable SearchEmoHeaderView searchEmoHeaderView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) searchEmoHeaderView);
        } else {
            this.mHeaderView = searchEmoHeaderView;
        }
    }
}
