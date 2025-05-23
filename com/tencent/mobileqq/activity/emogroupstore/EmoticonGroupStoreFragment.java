package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupDataSource;
import com.tencent.mobileqq.activity.emogroupstore.m;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.util.AnimateUtils;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00e2\u00012\u00020\u00012\u00020\u0002:\u0002\u00e3\u0001B\t\u00a2\u0006\u0006\b\u00e0\u0001\u0010\u00e1\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u001e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0012\u0010!\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\"\u001a\u00020\u0003H\u0002J\b\u0010#\u001a\u00020\u0003H\u0002J\b\u0010$\u001a\u00020\u0003H\u0002J\b\u0010%\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020\u0003H\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0014J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020.H\u0014J\u0012\u00101\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010.H\u0016J\"\u00105\u001a\u00020\u00032\u0006\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206H\u0016J\b\u00109\u001a\u00020\u0003H\u0016J\b\u0010:\u001a\u00020(H\u0016J\u000e\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020(J\b\u0010=\u001a\u00020\u0003H\u0016J\b\u0010>\u001a\u00020\u0003H\u0016J\b\u0010?\u001a\u00020\u0003H\u0004R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010\\\u001a\u00060Xj\u0002`Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010cR\u001e\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010lR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010uR\u0018\u0010z\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010uR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010uR\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010uR\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010cR\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010cR\u0019\u0010\u0088\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0087\u0001R\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010NR\u001a\u0010\u008c\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010uR\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u008f\u0001R\u001a\u0010\u0094\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010uR\u001a\u0010\u0096\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010uR\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0099\u0001R\u0019\u0010\u009e\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u0087\u0001R\u0019\u0010\u00a0\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0087\u0001R.\u0010\u00a4\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0017\u0018\u00010\u00a1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R!\u0010\u00a7\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00a5\u0001\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a6\u0001\u0010lR\u001c\u0010\u00ab\u0001\u001a\u0005\u0018\u00010\u00a8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u001c\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u00ac\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u001a\u0010\u00b1\u0001\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b0\u0001\u0010NR\u001a\u0010\u00b3\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b2\u0001\u0010cR\u001a\u0010\u00b5\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b4\u0001\u0010cR\u001c\u0010\u00b7\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00b6\u0001\u0010lR\u001a\u0010\u00b9\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b8\u0001\u0010uR\u001c\u0010\u00bb\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00ba\u0001\u0010lR)\u0010\u00bd\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0005\u0012\u00030\u00a5\u0001\u0018\u00010\u00a1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00a3\u0001R\u001a\u0010\u00bf\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00be\u0001\u0010cR\u001a\u0010\u00c3\u0001\u001a\u00030\u00c0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R!\u0010\u00c8\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c5\u00010\u00c4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u001a\u0010\u00cc\u0001\u001a\u00030\u00c9\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00cb\u0001R\u0018\u0010\u00d0\u0001\u001a\u00030\u00cd\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u001a\u0010\u00d4\u0001\u001a\u00030\u00d1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001R\u0017\u0010\u00d7\u0001\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001R,\u0010\u00df\u0001\u001a\u0005\u0018\u00010\u00d8\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d9\u0001\u0010\u00da\u0001\u001a\u0006\b\u00db\u0001\u0010\u00dc\u0001\"\u0006\b\u00dd\u0001\u0010\u00de\u0001\u00a8\u0006\u00e4\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupStoreFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "initViews", "initUI", "Xh", "Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource$b;", "emoListResult", "Mh", "Zh", "", "Lcom/tencent/mobileqq/data/EmoticonFromGroupEntity;", "data", "fi", "di", "bi", "emos", "Qh", "Th", "Sh", "ii", "entity", "", "Landroid/graphics/drawable/Drawable;", "headShowDrawables", "Ph", "", "headHintStrWithCount", WidgetCacheLunarData.JI, "emo", "Landroid/content/Intent;", "Lh", "li", "Uh", "Rh", "hi", "Oh", "Nh", "ki", "", "access", "Kh", "", "Wh", "getContentLayoutId", "Landroid/os/Bundle;", "init", Constants.FILE_INSTANCE_STATE, "onCreate", "requestCode", QzoneIPCModule.RESULT_CODE, "intent", "onActivityResult", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "onDestroyView", "onBackEvent", "enable", "enableFlingRight", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "finish", "Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupViewModel;", "viewModel", "Lcom/tencent/mobileqq/app/QBaseActivity;", "D", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mActivity", "Lcom/tencent/mobileqq/app/QQAppInterface;", "E", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mTxtHeadHint", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerPicSelect", "Lcom/tencent/mobileqq/activity/emogroupstore/q;", "H", "Lcom/tencent/mobileqq/activity/emogroupstore/q;", "mPicSelectAdapter", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "I", "Ljava/lang/StringBuilder;", "headHintPlaceHolder", "Landroid/text/SpannableString;", "J", "Landroid/text/SpannableString;", "ssHeadHint", "Landroid/widget/Button;", "K", "Landroid/widget/Button;", "mBtnEmoGroupStore", "Landroid/widget/RelativeLayout;", "L", "Landroid/widget/RelativeLayout;", "mLayoutGroupEmoAdd2Fav", "M", "mBtnEmoGroupAddToFav", "N", "Ljava/util/List;", "mStoreContent", "P", "mCacheData", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "mForwardMsgElement", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "mPreviewView", ExifInterface.LATITUDE_SOUTH, "mPlaceHolder", "T", "mPreviewLayout", "Landroidx/viewpager/widget/ViewPager;", "U", "Landroidx/viewpager/widget/ViewPager;", "mPreviewPager", "V", "mBtnPreviewLeft", "W", "mBtnPreviewRight", "X", "mBtnPreviewSend2Friend", "Y", "mBtnPreviewAdd2Emo", "Z", "downloadFlag", "a0", "mTxtEmoStoreHint", "b0", "filterGrayView", "Landroid/view/animation/AlphaAnimation;", "c0", "Landroid/view/animation/AlphaAnimation;", "mFilterAlphaAnimEnter", "d0", "mFilterAlphaAnimExit", "e0", "filterView", "f0", "filterPlaceHolderView", "Landroid/view/animation/TranslateAnimation;", "g0", "Landroid/view/animation/TranslateAnimation;", "mFilterTranslateAnimEnter", "h0", "mFilterTranslateAnimExit", "i0", "mFilterShow", "j0", "mFilterClicked", "", "k0", "Ljava/util/Map;", "mFilterMapData", "Lcom/tencent/mobileqq/activity/emogroupstore/m$a;", "l0", "mFilterListData", "Landroid/widget/ListView;", "m0", "Landroid/widget/ListView;", "mFilterList", "Lcom/tencent/mobileqq/activity/emogroupstore/m;", "n0", "Lcom/tencent/mobileqq/activity/emogroupstore/m;", "mFilterAdapter", "o0", "mTxtFilterHint", "p0", "mBtnFilterReset", "q0", "mBtnFilterConfirm", "r0", "mFilterUin", "s0", "mEmptyView", "t0", "mClickedUin", "u0", "mUinItemContentMap", "v0", "rightFilterBtn", "Lcom/tencent/mobileqq/emosm/favroaming/l;", "w0", "Lcom/tencent/mobileqq/emosm/favroaming/l;", "emoticonFromGroupManager", "Lcom/tencent/mobileqq/emosm/api/IFavroamingDBManagerService;", "Lcom/tencent/mobileqq/data/CustomEmotionData;", "x0", "Lcom/tencent/mobileqq/emosm/api/IFavroamingDBManagerService;", "favDbManager", "Lcom/tencent/mobileqq/activity/emogroupstore/report/a;", "y0", "Lcom/tencent/mobileqq/activity/emogroupstore/report/a;", "mDTReportUtil", "Ljb1/a;", "z0", "Ljb1/a;", "favListener", "Lcom/tencent/mobileqq/app/SVIPObserver;", "A0", "Lcom/tencent/mobileqq/app/SVIPObserver;", "mVipStatusObserver", "B0", "Landroid/view/View$OnClickListener;", "mCancelBtnListener", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "C0", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "getMGestureLayout", "()Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "setMGestureLayout", "(Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;)V", "mGestureLayout", "<init>", "()V", "D0", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class EmoticonGroupStoreFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: D0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: A0, reason: from kotlin metadata */
    @NotNull
    private SVIPObserver mVipStatusObserver;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener mCancelBtnListener;

    /* renamed from: C, reason: from kotlin metadata */
    private EmoticonGroupViewModel viewModel;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private TopGestureLayout mGestureLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QBaseActivity mActivity;

    /* renamed from: E, reason: from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mTxtHeadHint;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mRecyclerPicSelect;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private q mPicSelectAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final StringBuilder headHintPlaceHolder;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private SpannableString ssHeadHint;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Button mBtnEmoGroupStore;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout mLayoutGroupEmoAdd2Fav;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Button mBtnEmoGroupAddToFav;

    /* renamed from: N, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public List<EmoticonFromGroupEntity> mStoreContent;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final List<EmoticonFromGroupEntity> mCacheData;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private MsgElement mForwardMsgElement;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private View mPreviewView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private View mPlaceHolder;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private View mPreviewLayout;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ViewPager mPreviewPager;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private View mBtnPreviewLeft;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private View mBtnPreviewRight;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Button mBtnPreviewSend2Friend;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private Button mBtnPreviewAdd2Emo;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean downloadFlag;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTxtEmoStoreHint;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View filterGrayView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AlphaAnimation mFilterAlphaAnimEnter;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AlphaAnimation mFilterAlphaAnimExit;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View filterView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View filterPlaceHolderView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TranslateAnimation mFilterTranslateAnimEnter;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TranslateAnimation mFilterTranslateAnimExit;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mFilterShow;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mFilterClicked;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, ? extends List<EmoticonFromGroupEntity>> mFilterMapData;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends m.a> mFilterListData;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ListView mFilterList;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private m mFilterAdapter;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTxtFilterHint;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button mBtnFilterReset;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button mBtnFilterConfirm;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mFilterUin;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mEmptyView;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mClickedUin;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, ? extends m.a> mUinItemContentMap;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button rightFilterBtn;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.emosm.favroaming.l emoticonFromGroupManager;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private IFavroamingDBManagerService<CustomEmotionData> favDbManager;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.emogroupstore.report.a mDTReportUtil;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jb1.a favListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupStoreFragment$a;", "", "", "ANIM_DURATION_TIME", "I", "COUNT_PER_LINE_SHOW", "", "EMO_STORE_HINT", "Ljava/lang/String;", "EMPTY_IMG_URL", "HEAD_SHOW_COUNT", "", "HEAD_TEXT_HINT_DRAWABLE_SIZE", UserInfo.SEX_FEMALE, "LOAD_FIRST_SCREEN", "MARGIN_BETWEEN_PIC", "MARGIN_WITH_SCREEN", "MAX_COUNT_EVERY_ADD", "REQUEST_FORWARD", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/activity/emogroupstore/EmoticonGroupStoreFragment$b", "Ljb1/a;", "", "onUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements jb1.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonGroupStoreFragment.this);
            }
        }

        @Override // jb1.a
        public void onUpdate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.mobileqq.emosm.favroaming.l lVar = EmoticonGroupStoreFragment.this.emoticonFromGroupManager;
                IFavroamingDBManagerService iFavroamingDBManagerService = null;
                if (lVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
                    lVar = null;
                }
                lVar.g();
                IFavroamingDBManagerService iFavroamingDBManagerService2 = EmoticonGroupStoreFragment.this.favDbManager;
                if (iFavroamingDBManagerService2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("favDbManager");
                } else {
                    iFavroamingDBManagerService = iFavroamingDBManagerService2;
                }
                iFavroamingDBManagerService.removeFavRoamingUpdateListener(this);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class c<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((EmoticonFromGroupEntity) t17).timestamp), Long.valueOf(((EmoticonFromGroupEntity) t16).timestamp));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/emogroupstore/EmoticonGroupStoreFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonGroupStoreFragment.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            q qVar = EmoticonGroupStoreFragment.this.mPicSelectAdapter;
            Intrinsics.checkNotNull(qVar);
            String o06 = qVar.o0(findFirstVisibleItemPosition);
            if (o06 == null || findFirstVisibleItemPosition < 1) {
                TextView textView = EmoticonGroupStoreFragment.this.mTxtHeadHint;
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            }
            TextView textView2 = EmoticonGroupStoreFragment.this.mTxtHeadHint;
            if (textView2 != null) {
                textView2.setText(o06);
                textView2.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/emogroupstore/EmoticonGroupStoreFragment$e", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonGroupStoreFragment.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            EmoticonGroupStoreFragment.this.enableFlingRight(true);
            EmoticonGroupStoreFragment.this.mFilterShow = false;
            EmoticonGroupStoreFragment emoticonGroupStoreFragment = EmoticonGroupStoreFragment.this;
            emoticonGroupStoreFragment.titleRoot.removeView(emoticonGroupStoreFragment.filterGrayView);
            EmoticonGroupStoreFragment emoticonGroupStoreFragment2 = EmoticonGroupStoreFragment.this;
            emoticonGroupStoreFragment2.titleRoot.removeView(emoticonGroupStoreFragment2.filterView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/activity/emogroupstore/EmoticonGroupStoreFragment$f", "Lcom/tencent/mobileqq/app/SVIPObserver;", "", "onVipStatusChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class f extends SVIPObserver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonGroupStoreFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onVipStatusChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonFromGroup_Fragment", 2, "vip status change in EmoticonGroupStoreFragment.");
            }
            QQAppInterface qQAppInterface = EmoticonGroupStoreFragment.this.mApp;
            IFavroamingDBManagerService iFavroamingDBManagerService = null;
            if (qQAppInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface = null;
            }
            IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IFavroamingManagerService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(\n\u2026:class.java\n            )");
            ((IFavroamingManagerService) runtimeService).syncRoaming();
            IFavroamingDBManagerService iFavroamingDBManagerService2 = EmoticonGroupStoreFragment.this.favDbManager;
            if (iFavroamingDBManagerService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favDbManager");
            } else {
                iFavroamingDBManagerService = iFavroamingDBManagerService2;
            }
            iFavroamingDBManagerService.addFavRoamingUpdateListener(EmoticonGroupStoreFragment.this.favListener);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmoticonGroupStoreFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.headHintPlaceHolder = new StringBuilder("    ");
        this.mStoreContent = new ArrayList();
        this.mCacheData = new CopyOnWriteArrayList();
        this.mFilterUin = new ArrayList();
        this.mClickedUin = new ArrayList();
        this.favListener = new b();
        this.mVipStatusObserver = new f();
        this.mCancelBtnListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.emogroupstore.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonGroupStoreFragment.ai(EmoticonGroupStoreFragment.this, view);
            }
        };
    }

    private final void Kh(boolean access) {
        if (AppSetting.f99565y) {
            View view = ((QIphoneTitleBarFragment) this).mContentView;
            if (view != null) {
                AccessibilityUtil.e(view.findViewById(R.id.sh_), access);
            }
            TextView textView = this.leftView;
            if (textView != null) {
                AccessibilityUtil.n(textView, access);
            }
            TextView textView2 = this.centerView;
            if (textView2 != null) {
                AccessibilityUtil.n(textView2, access);
            }
            Button button = this.rightFilterBtn;
            if (button != null) {
                AccessibilityUtil.n(button, access);
            }
        }
    }

    private final Intent Lh(EmoticonFromGroupEntity emo) {
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        intent.putExtra(AppConstants.Key.FORWARD_NT_MSG_ID, emo.msgRecord.msgId);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID, emo.msgRecord.peerUid);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, 8);
        intent.putExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, emo.msgRecord.chatType);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, emo.thumbURL);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, emo.bigURL);
        intent.putExtra("forward _key_nojump", true);
        intent.putExtra("not_forward", true);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(EmoticonGroupDataSource.b emoListResult) {
        List<EmoticonFromGroupEntity> d16 = emoListResult.d();
        if (d16.isEmpty()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonFromGroup_Fragment", 2, "dealData Begin");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d16);
        long c16 = emoListResult.c();
        if (c16 == 0) {
            this.mCacheData.clear();
        } else {
            arrayList.addAll(this.mCacheData);
        }
        List<EmoticonFromGroupEntity> Th = Th(Sh(Qh(arrayList)));
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonFromGroup_Fragment", 2, "dealData end. finalData.size=" + Th.size());
        }
        if (Th.isEmpty()) {
            bi();
        } else {
            this.mCacheData.clear();
            com.tencent.mobileqq.emosm.favroaming.l lVar = this.emoticonFromGroupManager;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
                lVar = null;
            }
            lVar.d(Th);
            this.mCacheData.addAll(Th);
            di(this.mCacheData);
            fi(this.mCacheData);
            if (this.filterView != null) {
                Uh();
            }
        }
        int b16 = emoListResult.b();
        if (c16 == 0 && emoListResult.a() && b16 < 500) {
            LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new EmoticonGroupStoreFragment$dealData$1(emoListResult, this, b16, null));
        }
    }

    private final void Nh() {
        Button button = this.rightFilterBtn;
        if (button != null) {
            button.setBackgroundResource(R.drawable.jsa);
            button.setEnabled(false);
        }
    }

    private final void Oh() {
        Button button = this.rightFilterBtn;
        if (button != null) {
            button.setBackgroundResource(R.drawable.jsb);
            button.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(EmoticonFromGroupEntity entity, List<Drawable> headShowDrawables) {
        com.tencent.mobileqq.emosm.favroaming.l lVar = this.emoticonFromGroupManager;
        URLDrawable uRLDrawable = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
            lVar = null;
        }
        Drawable j3 = lVar.j(entity, 65537, Wh(), null);
        if (j3 instanceof URLDrawable) {
            uRLDrawable = (URLDrawable) j3;
        }
        if (uRLDrawable != null) {
            headShowDrawables.add(uRLDrawable);
            this.headHintPlaceHolder.append(" ");
        }
    }

    private final List<EmoticonFromGroupEntity> Qh(List<? extends EmoticonFromGroupEntity> emos) {
        int mapCapacity;
        List<EmoticonFromGroupEntity> sortedWith;
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : emos) {
            String str = ((EmoticonFromGroupEntity) obj2).md5;
            Object obj3 = linkedHashMap.get(str);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(str, obj3);
            }
            ((List) obj3).add(obj2);
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterator it = ((Iterable) entry.getValue()).iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                Object next = it.next();
                if (it.hasNext()) {
                    long j3 = ((EmoticonFromGroupEntity) next).timestamp;
                    do {
                        Object next2 = it.next();
                        long j16 = ((EmoticonFromGroupEntity) next2).timestamp;
                        if (j3 < j16) {
                            next = next2;
                            j3 = j16;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            }
            Intrinsics.checkNotNull(obj);
            linkedHashMap2.put(key, (EmoticonFromGroupEntity) obj);
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(linkedHashMap2.values(), new c());
        return sortedWith;
    }

    private final void Rh() {
        ViewParent viewParent;
        View view = this.filterView;
        if (view != null) {
            RelativeLayout relativeLayout = this.titleRoot;
            ViewParent viewParent2 = null;
            if (view != null) {
                viewParent = view.getParent();
            } else {
                viewParent = null;
            }
            if (relativeLayout == viewParent) {
                RelativeLayout relativeLayout2 = this.titleRoot;
                View view2 = this.filterView;
                if (view2 != null) {
                    viewParent2 = view2.getParent();
                }
                if (relativeLayout2 == viewParent2) {
                    View view3 = this.filterGrayView;
                    if (view3 != null) {
                        view3.startAnimation(this.mFilterAlphaAnimExit);
                    }
                    View view4 = this.filterView;
                    if (view4 != null) {
                        view4.startAnimation(this.mFilterTranslateAnimExit);
                    }
                }
            }
        }
    }

    private final List<EmoticonFromGroupEntity> Sh(List<? extends EmoticonFromGroupEntity> emos) {
        List<CustomEmotionData> mutableList;
        boolean z16;
        IFavroamingDBManagerService<CustomEmotionData> iFavroamingDBManagerService = this.favDbManager;
        if (iFavroamingDBManagerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favDbManager");
            iFavroamingDBManagerService = null;
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList == null) {
            emoticonDataList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : emoticonDataList) {
            CustomEmotionData customEmotionData = (CustomEmotionData) obj;
            String str = customEmotionData.RomaingType;
            boolean z17 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 || !Intrinsics.areEqual("needDel", customEmotionData.RomaingType)) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        QLog.i("EmoticonFromGroup_Fragment", 2, "filterFavEmo validateList Size=" + mutableList.size());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : emos) {
            EmoticonFromGroupEntity emoticonFromGroupEntity = (EmoticonFromGroupEntity) obj2;
            com.tencent.mobileqq.emosm.favroaming.l lVar = this.emoticonFromGroupManager;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
                lVar = null;
            }
            if (!lVar.h(mutableList, emoticonFromGroupEntity)) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    private final List<EmoticonFromGroupEntity> Th(List<? extends EmoticonFromGroupEntity> emos) {
        List<EmoticonFromGroupEntity> take;
        take = CollectionsKt___CollectionsKt.take(emos, 300);
        return take;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Uh() {
        int i3;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (EmoticonFromGroupEntity emoticonFromGroupEntity : this.mCacheData) {
            if (concurrentHashMap.containsKey(emoticonFromGroupEntity.troopUin)) {
                List list = (List) concurrentHashMap.get(emoticonFromGroupEntity.troopUin);
                if (list != null) {
                    list.add(emoticonFromGroupEntity);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(emoticonFromGroupEntity);
                String str = emoticonFromGroupEntity.troopUin;
                Intrinsics.checkNotNullExpressionValue(str, "emo.troopUin");
                concurrentHashMap.put(str, arrayList);
            }
        }
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List list2 = (List) ((Map.Entry) it.next()).getValue();
            m.a aVar = new m.a();
            EmoticonFromGroupEntity emoticonFromGroupEntity2 = (EmoticonFromGroupEntity) list2.get(0);
            if (2 == emoticonFromGroupEntity2.fromType) {
                if (TroopUtils.n(emoticonFromGroupEntity2.troopUin)) {
                    i3 = 4;
                } else {
                    i3 = 113;
                }
                QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
                qQProAvatarDrawable.q(getContext(), i3, emoticonFromGroupEntity2.troopUin);
                QQAppInterface qQAppInterface = this.mApp;
                if (qQAppInterface == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mApp");
                    qQAppInterface = null;
                }
                String g06 = ac.g0(qQAppInterface, emoticonFromGroupEntity2.troopUin, true);
                aVar.f182143a = emoticonFromGroupEntity2.troopUin;
                aVar.f182144b = qQProAvatarDrawable;
                aVar.f182147e = false;
                aVar.f182145c = g06;
                aVar.f182146d = list2.size();
                copyOnWriteArrayList.add(aVar);
                String str2 = aVar.f182143a;
                Intrinsics.checkNotNullExpressionValue(str2, "itemContent.uin");
                concurrentHashMap2.put(str2, aVar);
            }
        }
        this.mFilterMapData = concurrentHashMap;
        this.mFilterListData = copyOnWriteArrayList;
        this.mUinItemContentMap = concurrentHashMap2;
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.f
                @Override // java.lang.Runnable
                public final void run() {
                    EmoticonGroupStoreFragment.Vh(EmoticonGroupStoreFragment.this);
                }
            });
            return;
        }
        m mVar = this.mFilterAdapter;
        if (mVar != 0) {
            mVar.setData(this.mFilterListData);
            mVar.notifyDataSetChanged();
        }
        TextView textView = this.mTxtFilterHint;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.f171943m71) + this.mCacheData.size() + HardCodeUtil.qqStr(R.string.m7c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Vh(EmoticonGroupStoreFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m mVar = this$0.mFilterAdapter;
        if (mVar != 0) {
            mVar.setData(this$0.mFilterListData);
            mVar.notifyDataSetChanged();
        }
        TextView textView = this$0.mTxtFilterHint;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.m76) + this$0.mCacheData.size() + HardCodeUtil.qqStr(R.string.m6u));
        }
    }

    private final int Wh() {
        int dip2px = ScreenUtil.dip2px(11.0f);
        if (FontSettingManager.getFontScale() > 1.0f) {
            return (int) (dip2px / FontSettingManager.getFontScale());
        }
        return dip2px;
    }

    private final void Xh() {
        QQAppInterface qQAppInterface;
        QQAppInterface qQAppInterface2 = this.mApp;
        com.tencent.mobileqq.activity.emogroupstore.report.a aVar = null;
        if (qQAppInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        } else {
            qQAppInterface = qQAppInterface2;
        }
        com.tencent.mobileqq.emosm.favroaming.l lVar = this.emoticonFromGroupManager;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
            lVar = null;
        }
        q qVar = new q(qQAppInterface, this, lVar.b(), this.mPreviewView, this.mPreviewPager, this.mBtnEmoGroupAddToFav, LifecycleOwnerKt.getLifecycleScope(this));
        this.mPicSelectAdapter = qVar;
        com.tencent.mobileqq.activity.emogroupstore.report.a aVar2 = this.mDTReportUtil;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDTReportUtil");
        } else {
            aVar = aVar2;
        }
        qVar.t0(aVar);
        RecyclerView recyclerView = this.mRecyclerPicSelect;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.mPicSelectAdapter);
            recyclerView.addOnScrollListener(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(EmoticonGroupStoreFragment this$0, AdapterView adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<? extends m.a> list = this$0.mFilterListData;
        Intrinsics.checkNotNull(list);
        m.a aVar = list.get(i3);
        boolean z16 = aVar.f182147e;
        if (z16) {
            if (this$0.mFilterUin.contains(aVar.f182143a)) {
                this$0.mFilterUin.remove(aVar.f182143a);
            }
        } else {
            List<String> list2 = this$0.mFilterUin;
            String str = aVar.f182143a;
            Intrinsics.checkNotNullExpressionValue(str, "itemContent.uin");
            list2.add(str);
        }
        List<? extends m.a> list3 = this$0.mFilterListData;
        Intrinsics.checkNotNull(list3);
        list3.get(i3).f182147e = !z16;
        m mVar = this$0.mFilterAdapter;
        Intrinsics.checkNotNull(mVar);
        mVar.notifyDataSetChanged();
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    private final void Zh() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new EmoticonGroupStoreFragment$loadDataAsync$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(EmoticonGroupStoreFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (EmoticonFromGroupEntity emoticonFromGroupEntity : this$0.mStoreContent) {
            if (emoticonFromGroupEntity != null) {
                emoticonFromGroupEntity.status = -1;
            }
        }
        this$0.mStoreContent.clear();
        RelativeLayout relativeLayout = this$0.mLayoutGroupEmoAdd2Fav;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        Button button = this$0.mBtnEmoGroupStore;
        if (button != null) {
            button.setVisibility(0);
        }
        q qVar = this$0.mPicSelectAdapter;
        if (qVar != null) {
            qVar.L = false;
            qVar.s0(false);
            qVar.notifyDataSetChanged();
        }
        this$0.Oh();
        this$0.enableFlingRight(true);
        this$0.resetLeftButton();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void bi() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.i
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonGroupStoreFragment.ci(EmoticonGroupStoreFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(EmoticonGroupStoreFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Button button = this$0.rightFilterBtn;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this$0.mEmptyView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private final void di(final List<? extends EmoticonFromGroupEntity> data) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.g
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonGroupStoreFragment.ei(EmoticonGroupStoreFragment.this, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(EmoticonGroupStoreFragment this$0, List data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.ii(data);
    }

    private final void fi(final List<? extends EmoticonFromGroupEntity> data) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.h
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonGroupStoreFragment.gi(data, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(List data, EmoticonGroupStoreFragment this$0) {
        q qVar;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = data;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list);
            com.tencent.mobileqq.emosm.favroaming.l lVar = this$0.emoticonFromGroupManager;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
                lVar = null;
            }
            Map<String, List<EmoticonFromGroupEntity>> f16 = lVar.f(arrayList);
            if (f16 != null && (qVar = this$0.mPicSelectAdapter) != null) {
                qVar.q0(f16, arrayList);
            }
        }
    }

    private final void hi() {
        List<? extends m.a> list = this.mFilterListData;
        Intrinsics.checkNotNull(list);
        Iterator<? extends m.a> it = list.iterator();
        while (it.hasNext()) {
            it.next().f182147e = false;
        }
        if (!this.mFilterUin.isEmpty()) {
            this.mFilterUin.clear();
        }
    }

    private final void ii(List<? extends EmoticonFromGroupEntity> data) {
        int i3;
        boolean z16;
        List<EmoticonFromGroupEntity> take;
        if (data != null) {
            i3 = data.size();
        } else {
            i3 = 0;
        }
        List<? extends EmoticonFromGroupEntity> list = data;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && getQBaseActivity() != null) {
            final ArrayList arrayList = new ArrayList();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.bnl);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026ring.group_emo_head_hint)");
            final String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            take = CollectionsKt___CollectionsKt.take(data, 3);
            for (final EmoticonFromGroupEntity emoticonFromGroupEntity : take) {
                ExtensionsKt.e(emoticonFromGroupEntity.thumbURL, new Function0<Unit>(this, arrayList, format) { // from class: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$setHeadHintTxt$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String $headHintStrWithCount;
                    final /* synthetic */ List<Drawable> $mHeadShowDrawables;
                    final /* synthetic */ EmoticonGroupStoreFragment this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                        this.$mHeadShowDrawables = arrayList;
                        this.$headHintStrWithCount = format;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, EmoticonFromGroupEntity.this, this, arrayList, format);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        PicSize picSize = PicSize.PIC_DOWNLOAD_THUMB;
                        MsgRecord msgRecord = EmoticonFromGroupEntity.this.msgRecord;
                        Intrinsics.checkNotNullExpressionValue(msgRecord, "entity.msgRecord");
                        EmoticonFromGroupEntity emoticonFromGroupEntity2 = EmoticonFromGroupEntity.this;
                        ExtensionsKt.d(picSize, msgRecord, emoticonFromGroupEntity2.msgElement, new Function1<FileTransNotifyInfo, Unit>(this.this$0, this.$mHeadShowDrawables, this.$headHintStrWithCount) { // from class: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$setHeadHintTxt$1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ String $headHintStrWithCount;
                            final /* synthetic */ List<Drawable> $mHeadShowDrawables;
                            final /* synthetic */ EmoticonGroupStoreFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.this$0 = r6;
                                this.$mHeadShowDrawables = r7;
                                this.$headHintStrWithCount = r8;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, EmoticonFromGroupEntity.this, r6, r7, r8);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                                invoke2(fileTransNotifyInfo);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull FileTransNotifyInfo it) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                    return;
                                }
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.i("EmoticonFromGroup_Fragment", 1, "downloadPicsInMsgRecord result:" + it.fileErrCode + " path:" + it.filePath);
                                EmoticonFromGroupEntity emoticonFromGroupEntity3 = EmoticonFromGroupEntity.this;
                                emoticonFromGroupEntity3.thumbURL = it.filePath;
                                this.this$0.Ph(emoticonFromGroupEntity3, this.$mHeadShowDrawables);
                                this.this$0.ji(this.$headHintStrWithCount, this.$mHeadShowDrawables);
                            }
                        });
                    }
                }, new Function1<File, Unit>(emoticonFromGroupEntity, arrayList, format) { // from class: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$setHeadHintTxt$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ EmoticonFromGroupEntity $entity;
                    final /* synthetic */ String $headHintStrWithCount;
                    final /* synthetic */ List<Drawable> $mHeadShowDrawables;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$entity = emoticonFromGroupEntity;
                        this.$mHeadShowDrawables = arrayList;
                        this.$headHintStrWithCount = format;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, EmoticonGroupStoreFragment.this, emoticonFromGroupEntity, arrayList, format);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(File file) {
                        invoke2(file);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull File it) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        EmoticonGroupStoreFragment.this.Ph(this.$entity, this.$mHeadShowDrawables);
                        EmoticonGroupStoreFragment.this.ji(this.$headHintStrWithCount, this.$mHeadShowDrawables);
                    }
                });
            }
        }
    }

    private final void initUI() {
        this.leftView.setVisibility(0);
        this.leftView.setText(R.string.bnm);
        this.leftView.setTextColor(getResources().getColor(R.color.black));
        this.centerView.setTextColor(getResources().getColor(R.color.black));
        Button button = this.rightFilterBtn;
        if (button != null) {
            button.setBackgroundResource(R.drawable.jsb);
            button.setOnClickListener(this);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(500L);
        this.mFilterAlphaAnimEnter = alphaAnimation;
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setFillAfter(true);
        alphaAnimation2.setDuration(500L);
        this.mFilterAlphaAnimExit = alphaAnimation2;
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(500L);
        this.mFilterTranslateAnimEnter = translateAnimation;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setDuration(500L);
        translateAnimation2.setAnimationListener(new e());
        this.mFilterTranslateAnimExit = translateAnimation2;
        Xh();
        RelativeLayout relativeLayout = this.mLayoutGroupEmoAdd2Fav;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.mEmptyView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void initViews() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f112986pe);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.mTxtHeadHint = (TextView) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.fsk);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
        linearLayoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerPicSelect = recyclerView;
        View findViewById3 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164664ah4);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById3;
        button.setOnClickListener(this);
        button.setContentDescription(getString(R.string.ypn));
        this.mBtnEmoGroupStore = button;
        View findViewById4 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.cxs);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mLayoutGroupEmoAdd2Fav = (RelativeLayout) findViewById4;
        View findViewById5 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ahs);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.Button");
        Button button2 = (Button) findViewById5;
        button2.setOnClickListener(this);
        this.mBtnEmoGroupAddToFav = button2;
        View inflate = LayoutInflater.from(this.titleRoot.getContext()).inflate(R.layout.f168956bc4, (ViewGroup) this.titleRoot, false);
        View findViewById6 = inflate.findViewById(R.id.buv);
        findViewById6.setOnClickListener(this);
        this.mPlaceHolder = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.buw);
        findViewById7.setOnClickListener(this);
        this.mPreviewLayout = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.bux);
        Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        this.mPreviewPager = (ViewPager) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f164662ah2);
        findViewById9.setOnClickListener(this);
        this.mBtnPreviewLeft = findViewById9;
        View findViewById10 = inflate.findViewById(R.id.f164663ah3);
        findViewById10.setOnClickListener(this);
        this.mBtnPreviewRight = findViewById10;
        View findViewById11 = inflate.findViewById(R.id.ahu);
        Intrinsics.checkNotNull(findViewById11, "null cannot be cast to non-null type android.widget.Button");
        Button button3 = (Button) findViewById11;
        button3.setOnClickListener(this);
        this.mBtnPreviewSend2Friend = button3;
        View findViewById12 = inflate.findViewById(R.id.aht);
        Intrinsics.checkNotNull(findViewById12, "null cannot be cast to non-null type android.widget.Button");
        Button button4 = (Button) findViewById12;
        button4.setOnClickListener(this);
        this.mBtnPreviewAdd2Emo = button4;
        this.mPreviewView = inflate;
        View findViewById13 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.kdl);
        Intrinsics.checkNotNull(findViewById13, "null cannot be cast to non-null type android.widget.TextView");
        this.mTxtEmoStoreHint = (TextView) findViewById13;
        View view = new View(this.titleRoot.getContext());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setBackgroundColor(Color.parseColor(getString(R.color.by)));
        this.filterGrayView = view;
        try {
            View inflate2 = LayoutInflater.from(this.titleRoot.getContext()).inflate(R.layout.bbz, (ViewGroup) this.titleRoot, false);
            View findViewById14 = inflate2.findViewById(R.id.caj);
            findViewById14.setOnClickListener(this);
            this.filterPlaceHolderView = findViewById14;
            View findViewById15 = inflate2.findViewById(R.id.f166155ei0);
            Intrinsics.checkNotNull(findViewById15, "null cannot be cast to non-null type android.widget.ListView");
            ListView listView = (ListView) findViewById15;
            this.mFilterList = listView;
            if (listView != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.activity.emogroupstore.d
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i3, long j3) {
                        EmoticonGroupStoreFragment.Yh(EmoticonGroupStoreFragment.this, adapterView, view2, i3, j3);
                    }
                });
            }
            m mVar = new m(this.mActivity);
            this.mFilterAdapter = mVar;
            ListView listView2 = this.mFilterList;
            if (listView2 != null) {
                listView2.setAdapter((ListAdapter) mVar);
            }
            View findViewById16 = inflate2.findViewById(R.id.kdt);
            Intrinsics.checkNotNull(findViewById16, "null cannot be cast to non-null type android.widget.TextView");
            this.mTxtFilterHint = (TextView) findViewById16;
            View findViewById17 = inflate2.findViewById(R.id.ahc);
            Intrinsics.checkNotNull(findViewById17, "null cannot be cast to non-null type android.widget.Button");
            Button button5 = (Button) findViewById17;
            button5.setOnClickListener(this);
            this.mBtnFilterReset = button5;
            View findViewById18 = inflate2.findViewById(R.id.ahb);
            Intrinsics.checkNotNull(findViewById18, "null cannot be cast to non-null type android.widget.Button");
            Button button6 = (Button) findViewById18;
            button6.setOnClickListener(this);
            this.mBtnFilterConfirm = button6;
            this.filterView = inflate2;
        } catch (OutOfMemoryError unused) {
            QLog.e("EmoticonFromGroup_Fragment", 2, "oom error occur!");
        }
        View findViewById19 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.cxt);
        View findViewById20 = findViewById19.findViewById(R.id.dgr);
        Intrinsics.checkNotNull(findViewById20, "null cannot be cast to non-null type com.tencent.image.URLImageView");
        ((URLImageView) findViewById20).setImageDrawable(URLDrawable.getDrawable("https://imgcache.gtimg.cn/ACT/svip_act/act_img/public/201802/m1517913373_empty_img_1.png"));
        this.mEmptyView = findViewById19;
        Button button7 = new Button(this.mActivity);
        button7.setId(R.id.j8q);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(21.0f), ScreenUtil.dip2px(20.0f));
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        layoutParams.rightMargin = 8;
        button7.setLayoutParams(layoutParams);
        button7.setContentDescription(getString(R.string.ypj));
        this.rightFilterBtn = button7;
        this.f211174vg.addView(button7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(String headHintStrWithCount, List<Drawable> headShowDrawables) {
        List<Drawable> take;
        QLog.d("EmoticonFromGroup_Fragment", 1, "setTextHeadHint headShowDrawables size=" + headShowDrawables.size());
        take = CollectionsKt___CollectionsKt.take(headShowDrawables, 3);
        QLog.d("EmoticonFromGroup_Fragment", 1, "setTextHeadHint headShowDrawablesResult size=" + take.size());
        int Wh = Wh();
        SpannableString spannableString = new SpannableString(this.headHintPlaceHolder.toString() + headHintStrWithCount);
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        p pVar = new p(qQAppInterface);
        pVar.a(take, Wh);
        pVar.setBounds(0, 0, Wh * 3, Wh * 2);
        spannableString.setSpan(new ImageSpan(pVar, 0), 0, this.headHintPlaceHolder.length() - 4, 17);
        this.ssHeadHint = spannableString;
        TextView textView = this.mTxtHeadHint;
        if (textView != null) {
            textView.setText(spannableString);
        }
        q qVar = this.mPicSelectAdapter;
        if (qVar != null) {
            qVar.u0(this.ssHeadHint);
        }
    }

    private final void ki() {
        this.f211174vg.changeBg(true, QQTheme.isNowThemeIsNight());
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null && (qBaseActivity instanceof QPublicFragmentActivity)) {
            SystemBarActivityModule.getSystemBarComp(qBaseActivity);
            QBaseActivity qBaseActivity2 = this.mActivity;
            Intrinsics.checkNotNull(qBaseActivity2);
            if (ThemeUtil.isInNightMode(qBaseActivity2.getAppRuntime())) {
                Button button = this.mBtnPreviewSend2Friend;
                if (button != null) {
                    button.setTextColor(getResources().getColor(R.color.f157062iu));
                    return;
                }
                return;
            }
            Button button2 = this.mBtnPreviewSend2Friend;
            if (button2 != null) {
                button2.setTextColor(getResources().getColor(R.color.aii));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(EmoticonFromGroupEntity emo) {
        com.tencent.mobileqq.emosm.favroaming.l lVar = this.emoticonFromGroupManager;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
            lVar = null;
        }
        if (lVar.c(emo)) {
            Button button = this.mBtnPreviewAdd2Emo;
            if (button != null) {
                button.setText(HardCodeUtil.qqStr(R.string.m6t));
                button.setTextColor(Color.parseColor("#FFBBBBBB"));
                button.setBackgroundDrawable(button.getResources().getDrawable(R.drawable.a98));
                button.setEnabled(false);
            }
            q qVar = this.mPicSelectAdapter;
            if (qVar != null) {
                qVar.notifyDataSetChanged();
            }
        }
    }

    public final void enableFlingRight(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, enable);
            return;
        }
        if (this.mGestureLayout == null) {
            View decorView = getQBaseActivity().getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) decorView;
            int childCount = viewGroup.getChildCount();
            View view = null;
            for (int i3 = 0; i3 < childCount; i3++) {
                view = viewGroup.getChildAt(i3);
                if (view instanceof DragFrameLayout) {
                    view = ((DragFrameLayout) view).getChildAt(0);
                }
                if (view instanceof TopGestureLayout) {
                    break;
                }
            }
            if (view != null && (view instanceof TopGestureLayout)) {
                this.mGestureLayout = (TopGestureLayout) view;
            }
        }
        TopGestureLayout topGestureLayout = this.mGestureLayout;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(enable);
        }
    }

    protected final void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f168954bc2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void init(@NotNull Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init start.");
        }
        super.init(data);
        super.setTitle(HardCodeUtil.qqStr(R.string.f171944m72));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.mDTReportUtil = new com.tencent.mobileqq.activity.emogroupstore.report.a(requireContext);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            this.mActivity = qBaseActivity;
        } else {
            QLog.e("EmoticonFromGroup_Fragment", 1, "activity is null");
            finish();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) peekAppRuntime;
        } else {
            QLog.e("EmoticonFromGroup_Fragment", 1, "app is null");
            finish();
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.vas.VasExtensionManager");
        com.tencent.mobileqq.emosm.favroaming.l lVar = ((ao) manager).f308430h;
        Intrinsics.checkNotNullExpressionValue(lVar, "app.getManager(QQManager\u2026mEmoticonFromGroupManager");
        this.emoticonFromGroupManager = lVar;
        QQAppInterface qQAppInterface = this.mApp;
        QQAppInterface qQAppInterface2 = null;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        Intrinsics.checkNotNull(runtimeService, "null cannot be cast to non-null type com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService<com.tencent.mobileqq.data.CustomEmotionData>");
        this.favDbManager = (IFavroamingDBManagerService) runtimeService;
        IRuntimeService runtimeService2 = peekAppRuntime.getRuntimeService(IFavroamingManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        ((IFavroamingManagerService) runtimeService2).syncRoaming();
        QQAppInterface qQAppInterface3 = this.mApp;
        if (qQAppInterface3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
        } else {
            qQAppInterface2 = qQAppInterface3;
        }
        qQAppInterface2.addObserver(this.mVipStatusObserver);
        initViews();
        initUI();
        Zh();
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "PageView", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init end.");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), intent);
            return;
        }
        MsgElement msgElement = this.mForwardMsgElement;
        if (resultCode == -1 && requestCode == 0 && intent != null && intent.getExtras() != null && msgElement != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                int i3 = extras.getInt("uintype", -1);
                String string = extras.getString("uin");
                if (string == null) {
                    return;
                }
                if (i3 == 10014) {
                    com.tencent.mobileqq.forward.utils.d.f211078a.f(intent);
                } else {
                    com.tencent.mobileqq.forward.utils.d dVar = com.tencent.mobileqq.forward.utils.d.f211078a;
                    dVar.e(i3, string, msgElement);
                    dVar.d(intent, i3, string);
                }
                QLog.d("EmoticonFromGroup_Fragment", 2, "onActivityResult: " + requestCode + " uinType=" + i3);
            } else {
                return;
            }
        }
        this.mForwardMsgElement = null;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        q qVar = this.mPicSelectAdapter;
        if (qVar != null) {
            Intrinsics.checkNotNull(qVar);
            if (qVar.L) {
                for (EmoticonFromGroupEntity emoticonFromGroupEntity : this.mStoreContent) {
                    if (emoticonFromGroupEntity != null) {
                        emoticonFromGroupEntity.status = -1;
                    }
                }
                this.mStoreContent.clear();
                RelativeLayout relativeLayout = this.mLayoutGroupEmoAdd2Fav;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                Button button = this.mBtnEmoGroupStore;
                if (button != null) {
                    button.setVisibility(0);
                }
                q qVar2 = this.mPicSelectAdapter;
                if (qVar2 != null) {
                    qVar2.L = false;
                    qVar2.s0(false);
                    qVar2.notifyDataSetChanged();
                }
                Oh();
                enableFlingRight(true);
                resetLeftButton();
                return true;
            }
        }
        RelativeLayout relativeLayout2 = this.titleRoot;
        View view = this.mPreviewView;
        Intrinsics.checkNotNull(view);
        if (relativeLayout2 == view.getParent()) {
            this.titleRoot.removeView(this.mPreviewView);
            enableFlingRight(true);
        } else if (this.mFilterShow) {
            hi();
            Rh();
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        } else {
            finish();
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        List<EmoticonFromGroupEntity> emptyList;
        EmoticonFromGroupEntity emoticonFromGroupEntity;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            if (id5 == R.id.f164664ah4) {
                TextView textView = this.mTxtEmoStoreHint;
                Intrinsics.checkNotNull(textView);
                if (textView.getVisibility() == 0) {
                    TextView textView2 = this.mTxtEmoStoreHint;
                    Intrinsics.checkNotNull(textView2);
                    textView2.setVisibility(8);
                }
                Nh();
                enableFlingRight(false);
                setLeftButton(HardCodeUtil.qqStr(R.string.j6l), this.mCancelBtnListener);
                this.leftViewNotBack.setTextColor(getResources().getColor(R.color.black));
                Button button = this.mBtnEmoGroupStore;
                if (button != null) {
                    button.setVisibility(8);
                }
                Button button2 = this.mBtnEmoGroupAddToFav;
                if (button2 != null) {
                    button2.setTextColor(Color.parseColor("#FFBFBFBF"));
                    button2.setBackgroundDrawable(button2.getResources().getDrawable(R.drawable.a98));
                    button2.setEnabled(false);
                }
                RelativeLayout relativeLayout = this.mLayoutGroupEmoAdd2Fav;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                q qVar = this.mPicSelectAdapter;
                if (qVar != null) {
                    qVar.s0(true);
                    qVar.L = true;
                    qVar.notifyDataSetChanged();
                }
                VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMutiSel", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            } else {
                com.tencent.mobileqq.emosm.favroaming.l lVar = null;
                QQAppInterface qQAppInterface = null;
                com.tencent.mobileqq.activity.emogroupstore.report.a aVar = null;
                com.tencent.mobileqq.emosm.favroaming.l lVar2 = null;
                if (id5 == R.id.ahs) {
                    Button button3 = this.mBtnEmoGroupStore;
                    if (button3 != null) {
                        button3.setVisibility(0);
                    }
                    RelativeLayout relativeLayout2 = this.mLayoutGroupEmoAdd2Fav;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(8);
                    }
                    q qVar2 = this.mPicSelectAdapter;
                    if (qVar2 != null) {
                        qVar2.s0(false);
                    }
                    q qVar3 = this.mPicSelectAdapter;
                    if (qVar3 != null) {
                        qVar3.L = false;
                    }
                    com.tencent.mobileqq.emosm.favroaming.l lVar3 = this.emoticonFromGroupManager;
                    if (lVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
                        lVar3 = null;
                    }
                    lVar3.i(new ArrayList(this.mStoreContent));
                    for (EmoticonFromGroupEntity emoticonFromGroupEntity2 : this.mStoreContent) {
                        if (emoticonFromGroupEntity2 != null) {
                            emoticonFromGroupEntity2.status = 0;
                        }
                    }
                    QQAppInterface qQAppInterface2 = this.mApp;
                    if (qQAppInterface2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mApp");
                    } else {
                        qQAppInterface = qQAppInterface2;
                    }
                    IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IEmoticonFromGroupDBManagerService.class);
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(\n\u2026ss.java\n                )");
                    IEmoticonFromGroupDBManagerService iEmoticonFromGroupDBManagerService = (IEmoticonFromGroupDBManagerService) runtimeService;
                    iEmoticonFromGroupDBManagerService.setCountOfSpare(iEmoticonFromGroupDBManagerService.getCountOfSpare() - this.mStoreContent.size());
                    this.mStoreContent.clear();
                    q qVar4 = this.mPicSelectAdapter;
                    if (qVar4 != null) {
                        qVar4.notifyDataSetChanged();
                    }
                    Oh();
                    enableFlingRight(true);
                    resetLeftButton();
                    VasWebviewUtil.reportCommercialDrainage("", "QLbq", "AddMutibq", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                } else if (id5 == R.id.buv) {
                    RelativeLayout relativeLayout3 = this.titleRoot;
                    View view = this.mPreviewView;
                    Intrinsics.checkNotNull(view);
                    if (relativeLayout3 == view.getParent()) {
                        AbstractGifImage.pauseAll();
                        this.titleRoot.removeView(this.mPreviewView);
                        enableFlingRight(true);
                    }
                } else if (id5 != R.id.buw) {
                    if (id5 == R.id.f164662ah2) {
                        ViewPager viewPager = this.mPreviewPager;
                        if (viewPager != null) {
                            viewPager.arrowScroll(17);
                        }
                        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                    } else if (id5 == R.id.f164663ah3) {
                        ViewPager viewPager2 = this.mPreviewPager;
                        if (viewPager2 != null) {
                            viewPager2.arrowScroll(66);
                        }
                        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                    } else if (id5 == R.id.ahu) {
                        ViewPager viewPager3 = this.mPreviewPager;
                        Intrinsics.checkNotNull(viewPager3);
                        o oVar = (o) viewPager3.getAdapter();
                        if (oVar != null) {
                            ViewPager viewPager4 = this.mPreviewPager;
                            Intrinsics.checkNotNull(viewPager4);
                            emoticonFromGroupEntity = oVar.f(viewPager4.getCurrentItem());
                        } else {
                            emoticonFromGroupEntity = null;
                        }
                        if ((emoticonFromGroupEntity != null ? emoticonFromGroupEntity.msgRecord : null) != null) {
                            this.mForwardMsgElement = emoticonFromGroupEntity.msgElement;
                            ForwardBaseOption.startForwardActivityForResult(this.mActivity, Lh(emoticonFromGroupEntity), 0);
                        } else {
                            QLog.e("EmoticonFromGroup_Fragment.msgnull", 1, "preview send msg is null.");
                        }
                        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SendFriend", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                    } else if (id5 == R.id.aht) {
                        ViewPager viewPager5 = this.mPreviewPager;
                        if (viewPager5 != null) {
                            o oVar2 = (o) viewPager5.getAdapter();
                            final EmoticonFromGroupEntity f16 = oVar2 != null ? oVar2.f(viewPager5.getCurrentItem()) : null;
                            if (f16 != null && !this.downloadFlag) {
                                ExtensionsKt.e(f16.bigURL, new Function0<Unit>(f16) { // from class: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$onClick$3$1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ EmoticonFromGroupEntity $emo;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        this.$emo = f16;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonGroupStoreFragment.this, (Object) f16);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        EmoticonGroupStoreFragment.this.downloadFlag = true;
                                        PicSize picSize = PicSize.PIC_DOWNLOAD_ORI;
                                        MsgRecord msgRecord = this.$emo.msgRecord;
                                        Intrinsics.checkNotNullExpressionValue(msgRecord, "emo.msgRecord");
                                        EmoticonFromGroupEntity emoticonFromGroupEntity3 = this.$emo;
                                        ExtensionsKt.d(picSize, msgRecord, emoticonFromGroupEntity3.msgElement, new Function1<FileTransNotifyInfo, Unit>(EmoticonGroupStoreFragment.this) { // from class: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$onClick$3$1.1
                                            static IPatchRedirector $redirector_;
                                            final /* synthetic */ EmoticonGroupStoreFragment this$0;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                                this.this$0 = r5;
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) EmoticonFromGroupEntity.this, (Object) r5);
                                                }
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                                                invoke2(fileTransNotifyInfo);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull FileTransNotifyInfo result) {
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                    iPatchRedirector3.redirect((short) 2, (Object) this, (Object) result);
                                                    return;
                                                }
                                                Intrinsics.checkNotNullParameter(result, "result");
                                                QLog.i("EmoticonFromGroup_Fragment", 1, "downloadPicsInMsgRecord result:" + result.fileErrCode + " path:" + result.filePath);
                                                EmoticonFromGroupEntity.this.bigURL = result.filePath;
                                                this.this$0.downloadFlag = false;
                                                this.this$0.li(EmoticonFromGroupEntity.this);
                                            }
                                        });
                                    }
                                }, new Function1<File, Unit>(f16) { // from class: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$onClick$3$2
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ EmoticonFromGroupEntity $emo;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                        this.$emo = f16;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonGroupStoreFragment.this, (Object) f16);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(File file) {
                                        invoke2(file);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull File it) {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                        } else {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            EmoticonGroupStoreFragment.this.li(this.$emo);
                                        }
                                    }
                                });
                                QQAppInterface qQAppInterface3 = this.mApp;
                                if (qQAppInterface3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mApp");
                                    qQAppInterface3 = null;
                                }
                                EmoticonOperateReport.reportFavAddEmotionEvent(qQAppInterface3, 4, f16.md5, null);
                            }
                        }
                        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "Addbq", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
                    } else if (id5 == R.id.j8q) {
                        if (this.filterView == null) {
                            if (QLog.isColorLevel()) {
                                QLog.i("EmoticonFromGroup_Fragment", 2, "click right img useless, filterView is null.");
                            }
                        } else {
                            enableFlingRight(false);
                            this.mFilterShow = true;
                            RelativeLayout relativeLayout4 = this.titleRoot;
                            View view2 = this.filterGrayView;
                            if (relativeLayout4 != (view2 != null ? view2.getParent() : null)) {
                                this.titleRoot.addView(this.filterGrayView);
                            }
                            RelativeLayout relativeLayout5 = this.titleRoot;
                            View view3 = this.filterView;
                            if (relativeLayout5 != (view3 != null ? view3.getParent() : null)) {
                                this.titleRoot.addView(this.filterView);
                            }
                            View view4 = this.filterGrayView;
                            if (view4 != null) {
                                view4.startAnimation(this.mFilterAlphaAnimEnter);
                            }
                            View view5 = this.filterView;
                            if (view5 != null) {
                                view5.startAnimation(this.mFilterTranslateAnimEnter);
                            }
                            for (String str : this.mClickedUin) {
                                this.mFilterUin.add(str);
                                Map<String, ? extends m.a> map = this.mUinItemContentMap;
                                Intrinsics.checkNotNull(map);
                                m.a aVar2 = map.get(str);
                                Intrinsics.checkNotNull(aVar2);
                                aVar2.f182147e = true;
                            }
                            if (!this.mFilterClicked) {
                                this.mFilterClicked = true;
                                Uh();
                            }
                            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilter", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                            com.tencent.mobileqq.activity.emogroupstore.report.a aVar3 = this.mDTReportUtil;
                            if (aVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mDTReportUtil");
                            } else {
                                aVar = aVar3;
                            }
                            aVar.h();
                            Kh(false);
                        }
                    } else if (id5 == R.id.caj) {
                        hi();
                        Rh();
                        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        Kh(true);
                    } else if (id5 == R.id.ahb) {
                        if (!this.mClickedUin.isEmpty()) {
                            this.mClickedUin.clear();
                        }
                        int size = this.mFilterUin.size();
                        if (size == 0) {
                            ArrayList arrayList = new ArrayList(this.mCacheData);
                            com.tencent.mobileqq.emosm.favroaming.l lVar4 = this.emoticonFromGroupManager;
                            if (lVar4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
                            } else {
                                lVar2 = lVar4;
                            }
                            Map<String, List<EmoticonFromGroupEntity>> f17 = lVar2.f(arrayList);
                            if (f17 != null) {
                                ii(arrayList);
                                q qVar5 = this.mPicSelectAdapter;
                                if (qVar5 != null) {
                                    qVar5.q0(f17, arrayList);
                                }
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (String str2 : this.mFilterUin) {
                                this.mClickedUin.add(str2);
                                Map<String, ? extends List<EmoticonFromGroupEntity>> map2 = this.mFilterMapData;
                                if (map2 == null || (emptyList = map2.get(str2)) == null) {
                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                }
                                arrayList2.addAll(emptyList);
                            }
                            CollectionsKt__MutableCollectionsJVMKt.sort(arrayList2);
                            com.tencent.mobileqq.emosm.favroaming.l lVar5 = this.emoticonFromGroupManager;
                            if (lVar5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("emoticonFromGroupManager");
                            } else {
                                lVar = lVar5;
                            }
                            Map<String, List<EmoticonFromGroupEntity>> f18 = lVar.f(arrayList2);
                            if (f18 != null) {
                                ii(arrayList2);
                                q qVar6 = this.mPicSelectAdapter;
                                if (qVar6 != null) {
                                    qVar6.q0(f18, arrayList2);
                                }
                            }
                        }
                        hi();
                        Rh();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(size);
                        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterConfirm", "0", 1, 0, 0, "", "", sb5.toString(), "", "", "", "", 0, 0, 0, 0);
                        Kh(true);
                    } else if (id5 == R.id.ahc) {
                        hi();
                        m mVar = this.mFilterAdapter;
                        if (mVar != null) {
                            mVar.notifyDataSetChanged();
                        }
                        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReset", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                    }
                }
            }
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this).get(EmoticonGroupViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026oupViewModel::class.java)");
        this.viewModel = (EmoticonGroupViewModel) viewModel;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new EmoticonGroupStoreFragment$onCreate$1(this, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Message obtainMessage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroyView();
        this.mStoreContent.clear();
        QQAppInterface qQAppInterface = this.mApp;
        QQAppInterface qQAppInterface2 = null;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        MqqHandler handler = qQAppInterface.getHandler(ChatActivity.class);
        if (handler != null && (obtainMessage = handler.obtainMessage(10)) != null) {
            obtainMessage.sendToTarget();
        }
        QQAppInterface qQAppInterface3 = this.mApp;
        if (qQAppInterface3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
        } else {
            qQAppInterface2 = qQAppInterface3;
        }
        qQAppInterface2.removeObserver(this.mVipStatusObserver);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onPause();
        AbstractGifImage.pauseAll();
        com.tencent.mobileqq.activity.emogroupstore.report.a aVar = this.mDTReportUtil;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDTReportUtil");
            aVar = null;
        }
        com.tencent.mobileqq.activity.emogroupstore.report.a.j(aVar, null, 1, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewPager viewPager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.mobileqq.activity.emogroupstore.report.a aVar = this.mDTReportUtil;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDTReportUtil");
            aVar = null;
        }
        com.tencent.mobileqq.activity.emogroupstore.report.a.l(aVar, null, 1, null);
        ki();
        AbstractGifImage.resumeAll();
        q qVar = this.mPicSelectAdapter;
        if (qVar != null) {
            qVar.notifyDataSetChanged();
        }
        if (this.mBtnPreviewAdd2Emo != null && (viewPager = this.mPreviewPager) != null) {
            Intrinsics.checkNotNull(viewPager);
            o oVar = (o) viewPager.getAdapter();
            Intrinsics.checkNotNull(oVar);
            ViewPager viewPager2 = this.mPreviewPager;
            Intrinsics.checkNotNull(viewPager2);
            EmoticonFromGroupEntity f16 = oVar.f(viewPager2.getCurrentItem());
            oVar.notifyDataSetChanged();
            if (f16 != null) {
                if (f16.status == 0) {
                    Button button = this.mBtnPreviewAdd2Emo;
                    if (button != null) {
                        button.setText(HardCodeUtil.qqStr(R.string.m7z));
                        button.setTextColor(Color.parseColor("#FFBBBBBB"));
                        button.setBackgroundDrawable(button.getResources().getDrawable(R.drawable.a98));
                        button.setEnabled(false);
                    }
                } else {
                    Button button2 = this.mBtnPreviewAdd2Emo;
                    if (button2 != null) {
                        button2.setText(HardCodeUtil.qqStr(R.string.m6x));
                        button2.setTextColor(Color.parseColor("#FFFFFFFF"));
                        button2.setBackgroundDrawable(button2.getResources().getDrawable(R.drawable.a97));
                        button2.setEnabled(true);
                    }
                }
            }
            View view = this.mPreviewView;
            if (view != null) {
                view.invalidate();
            }
        }
    }
}
