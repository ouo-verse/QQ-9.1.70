package com.tencent.qqnt.aio.adapter.emoticon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.EmosmEmoticonConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.emocompat.IHostEmoticonMainApi;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emosm.p;
import com.tencent.mobileqq.emosm.q;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.AIEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallbackWithShowPanel;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.emoticonview.ExtAniStickerEmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteLottieEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonDelApi;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabContentBuilder;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabHelperBuilder;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabListener;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmotionPanelBusinessParam;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.event.a;
import com.tencent.mobileqq.event.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmotionPanelBuilder;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi;
import com.tencent.qqnt.aio.api.e;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LB\u0011\u0012\u0006\u0010o\u001a\u00020m\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020 H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020 H\u0002J \u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\nH\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u00103\u001a\u00020/2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u00104\u001a\u00020/2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u00105\u001a\u00020/2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u00106\u001a\u00020&2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u00107\u001a\u00020&2\u0006\u0010.\u001a\u00020 H\u0002J\u0012\u00108\u001a\u0004\u0018\u00010\"2\u0006\u0010.\u001a\u00020 H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u0010:\u001a\u00020$2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u0010;\u001a\u00020&2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010.\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\u0012\u0010@\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010>H\u0002J\u0012\u0010C\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010AH\u0002J*\u0010G\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010&2\u0006\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\n2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020>H\u0016J\u0018\u0010L\u001a\u00020\u00072\u0006\u0010B\u001a\u00020A2\u0006\u0010K\u001a\u00020JH\u0016J\u0006\u0010N\u001a\u00020MJ\b\u0010O\u001a\u00020\u0007H\u0007J\b\u0010P\u001a\u00020\u0007H\u0007J\b\u0010Q\u001a\u00020\u0007H\u0007J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020RH\u0016J\b\u0010U\u001a\u00020\u0007H\u0016J\u0006\u0010V\u001a\u00020\nJ\u0006\u0010X\u001a\u00020WJ\u0006\u0010Y\u001a\u00020/J\b\u0010Z\u001a\u00020\u0007H\u0016J\u0012\u0010[\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010 H\u0016J\b\u0010[\u001a\u00020\u0007H\u0016J\u0012\u0010\\\u001a\u00020/2\b\u0010\u001e\u001a\u0004\u0018\u00010 H\u0016J&\u0010a\u001a\u00020\u00072\b\u0010]\u001a\u0004\u0018\u00010 2\b\u0010^\u001a\u0004\u0018\u00010 2\b\u0010`\u001a\u0004\u0018\u00010_H\u0016J\u0012\u0010b\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010 H\u0016J\b\u0010c\u001a\u00020\u0007H\u0016J\b\u0010d\u001a\u00020\u0007H\u0016J\u0010\u0010e\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\nH\u0016J2\u0010k\u001a\u00020\u00072\u0006\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020/2\b\u0010i\u001a\u0004\u0018\u00010&2\u0006\u0010j\u001a\u00020\nH\u0016J\n\u0010l\u001a\u0004\u0018\u00010MH\u0016R\u0014\u0010o\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010nR\u0016\u0010q\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010w\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010xR\u0016\u0010|\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010\u007f\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010~R*\u0010\u0085\u0001\u001a\r \u0081\u0001*\u0005\u0018\u00010\u0080\u00010\u0080\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b<\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0017\u0010\u0086\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010HR\u0017\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b-\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/emoticon/NTEmoticonPanelProvider;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/qqnt/aio/api/e;", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallbackWithShowPanel;", "Lcom/tencent/mobileqq/emoticonview/api/IEmoticonMainPanelService$PanelBuilder;", "panelBuilder", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "", "v", "", "Lcom/tencent/mobileqq/data/BaseEmotionPanelBusinessParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "M", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "O", "Lcom/tencent/mobileqq/aio/input/fullscreen/FullScreenMsgIntent$OnFullScreenModeChanged;", "N", "p0", "a0", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/data/Emoticon;", "e", "n0", "Lcom/tencent/mobileqq/emoticonview/FavoriteLottieEmoticonInfo;", "info", "h0", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "i0", "Lcom/tencent/qqnt/msg/data/g;", "B", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "searchItem", "", "searchWord", "picSubType", "m0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d0", "panelType", UserInfo.SEX_FEMALE, "emoInfo", "", "X", "T", "U", "W", "Y", BdhLogUtil.LogTag.Tag_Req, HippyTKDListViewAdapter.X, "I", "K", "J", BdhLogUtil.LogTag.Tag_Conn, "w", "D", "L", "Landroid/view/View;", "panelView", "o0", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "y", "originEmoMd5", "fromSearch", "picIndex", "c0", "Z", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/widget/EditText;", "editText", "a", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", ReportConstant.COSTREPORT_PREFIX, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/api/e$a;", "callback", "b", "c", "E", "Landroid/view/ViewGroup;", "t", ExifInterface.LATITUDE_SOUTH, "delete", "send", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "showEmoticonPanel", NodeProps.VISIBLE, "bottom", "clearWord", "word", "width", "setEmotionSearchPanelVisible", "getEmoPanel", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "panelContainer", "f", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "mainPanel", tl.h.F, "Lcom/tencent/qqnt/aio/api/e$a;", "emoCallbackDelegate", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/EditText;", "mEditText", "Lcom/tencent/mobileqq/emosm/q;", "Lcom/tencent/mobileqq/emosm/q;", "mEmotionSearchPanel", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "u", "()Lmqq/app/AppRuntime;", "appRuntime", "mIsPanelShowing", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction1", "Lzv3/c;", "G", "Lzv3/c;", "emotionEventObserver", "<init>", "(Landroid/content/Context;)V", "H", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTEmoticonPanelProvider implements LifecycleObserver, com.tencent.qqnt.aio.api.e, IAIOEmoticonUIHelper, EmoticonCallbackWithShowPanel {

    /* renamed from: C, reason: from kotlin metadata */
    private q mEmotionSearchPanel;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy appRuntime;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsPanelShowing;

    /* renamed from: F, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: G, reason: from kotlin metadata */
    private final zv3.c emotionEventObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup panelContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IEmoticonMainPanel mainPanel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private e.a emoCallbackDelegate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/emoticon/NTEmoticonPanelProvider$b", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements zv3.c {
        b() {
        }

        @Override // zv3.c
        public void B5(zv3.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof a.C7508a) {
                NTEmoticonPanelProvider.this.c();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/emoticon/NTEmoticonPanelProvider$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            NTEmoticonPanelProvider.this.M(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public NTEmoticonPanelProvider(Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.qqnt.aio.adapter.emoticon.NTEmoticonPanelProvider$appRuntime$2
            @Override // kotlin.jvm.functions.Function0
            public final AppRuntime invoke() {
                return MobileQQ.sMobileQQ.peekAppRuntime();
            }
        });
        this.appRuntime = lazy;
        this.mAction1 = new c();
        this.emotionEventObserver = new b();
    }

    private final com.tencent.qqnt.msg.data.g B(EmoticonInfo info) {
        int i3;
        if ((info instanceof FavoriteEmoticonInfo) && (i3 = ((FavoriteEmoticonInfo) info).jumpId) > 0) {
            return new com.tencent.qqnt.msg.data.g(null, null, null, new EmojiMall(i3, 0), null, null, 0, 119, null);
        }
        return null;
    }

    private final EmotionSearchItem C(EmoticonInfo emoInfo) {
        EmotionSearchItem searchItem = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getSearchItem(emoInfo);
        Intrinsics.checkNotNullExpressionValue(searchItem, "api(IEmoticonBusinessPro\u2026a).getSearchItem(emoInfo)");
        return searchItem;
    }

    private final String D(EmoticonInfo emoInfo) {
        String searchWord = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getSearchWord(emoInfo);
        Intrinsics.checkNotNullExpressionValue(searchWord, "api(IEmoticonBusinessPro\u2026a).getSearchWord(emoInfo)");
        return searchWord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(NTEmoticonPanelProvider this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QRoute.createNavigator(this$0.context, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY).request();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final String I(EmoticonInfo emoInfo) {
        String zPlanEmoPath = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getZPlanEmoPath(emoInfo);
        Intrinsics.checkNotNullExpressionValue(zPlanEmoPath, "api(IEmoticonBusinessPro\u2026.getZPlanEmoPath(emoInfo)");
        return zPlanEmoPath;
    }

    private final String J(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getZPlanEmoTextSummary(emoInfo);
    }

    private final com.tencent.qqnt.msg.data.g K(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getZPlanPicExtBizInfo(emoInfo);
    }

    private final void L() {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        EmojiHomeUiPlugin.openEmojiHomePage((Activity) context, u().getAccount(), 6);
        ReportController.o(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(MsgIntent i3) {
        if (i3 instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            O((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) i3);
        } else if (i3 instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            N((FullScreenMsgIntent.OnFullScreenModeChanged) i3);
        }
    }

    private final void O(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent i3) {
        IEmoticonMainPanel iEmoticonMainPanel;
        if (i3.b() && i3.a() == 1001) {
            int v3 = v();
            QLog.i("NTEmoticonPanelProvider", 2, "handlePanelChanged: type=" + v3);
            if (this.mIsPanelShowing && v3 == -1) {
                QLog.d("NTEmoticonPanelProvider", 1, "Already Show");
                return;
            }
            this.mIsPanelShowing = true;
            if (v3 != -1) {
                showEmoticonPanel(v3);
                if ((v3 == 12 || v3 == 17 || v3 == 20) && (iEmoticonMainPanel = this.mainPanel) != null) {
                    iEmoticonMainPanel.onShow();
                }
            } else {
                IEmoticonMainPanel iEmoticonMainPanel2 = this.mainPanel;
                if (iEmoticonMainPanel2 != null) {
                    iEmoticonMainPanel2.onShow();
                }
            }
            a0();
            return;
        }
        if (this.mIsPanelShowing) {
            this.mIsPanelShowing = false;
            IEmoticonMainPanel iEmoticonMainPanel3 = this.mainPanel;
            if (iEmoticonMainPanel3 != null) {
                iEmoticonMainPanel3.onHide(false);
            }
        }
    }

    private final void P(IEmoticonMainPanelService.PanelBuilder panelBuilder) {
        IEmoticonMainPanelApp emoticonMainPanelApp = panelBuilder.getEmoticonMainPanelApp();
        QRouteApi api = QRoute.api(IHotPicSearchTabContentBuilder.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IHotPicSearchTabContentBuilder::class.java)");
        IHotPicSearchTabContentBuilder iHotPicSearchTabContentBuilder = (IHotPicSearchTabContentBuilder) api;
        iHotPicSearchTabContentBuilder.init(emoticonMainPanelApp, 4, 20, 18, this);
        EmotionInjectionInfo emotionInjectionInfo = new EmotionInjectionInfo(18, 4, R.drawable.qui_search_selector_01, iHotPicSearchTabContentBuilder);
        emotionInjectionInfo.setEmotionPanelLifecycleObserver(((IHotPicSearchTabHelperBuilder) QRoute.api(IHotPicSearchTabHelperBuilder.class)).build(12));
        emotionInjectionInfo.setEmotionTabCreateListener(((IHotPicSearchTabListener) QRoute.api(IHotPicSearchTabListener.class)).build(emoticonMainPanelApp));
        panelBuilder.addEmotionInjectionInfo("search", emotionInjectionInfo);
    }

    private final void Q(IEmoticonMainPanelService.PanelBuilder panelBuilder) {
        IEmoticonMainPanelApp emoticonMainPanelApp = panelBuilder.getEmoticonMainPanelApp();
        IZPlanEmotionPanelBuilder iZPlanEmotionPanelBuilder = (IZPlanEmotionPanelBuilder) QRoute.api(IZPlanEmotionPanelBuilder.class);
        Context context = this.context;
        ViewGroup t16 = t();
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        panelBuilder.addEmotionInjectionInfo("zplan", iZPlanEmotionPanelBuilder.init(emoticonMainPanelApp, context, 19, 17, this, t16, su3.b.a(g16)));
    }

    private final boolean R(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isAIEmoticon(emoInfo);
    }

    private final boolean T(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isFavoriteEmoticonType(emoInfo);
    }

    private final boolean U(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isHotPicType(emoInfo);
    }

    private final boolean W(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isHotPicFromSearchType(emoInfo);
    }

    private final boolean X(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isMarketFaceEmoticonType(emoInfo);
    }

    private final boolean Y(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isZPlanEmoticonType(emoInfo);
    }

    private final void Z() {
        String qqStr;
        SearchEmotionPanelBusinessParam searchEmotionPanelBusinessParam = new SearchEmotionPanelBusinessParam();
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        int e16 = aVar.g().r().c().e();
        if (e16 != 2 && e16 != 3 && e16 != 9) {
            qqStr = HardCodeUtil.qqStr(R.string.yq9);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.yq_);
        }
        searchEmotionPanelBusinessParam.searchWord = qqStr;
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(new EmotionPanelMsgIntent.SetEmotionPanelBusinessParam(18, searchEmotionPanelBusinessParam));
        QLog.d("NTEmoticonPanelProvider", 1, "[showEmoticonPanel] git tab is hide, redirect to search tab.");
    }

    private final void a0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.a
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoticonPanelProvider.b0(NTEmoticonPanelProvider.this);
            }
        }, 16, null, false);
    }

    private final void d0(final EmoticonInfo info) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.f
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoticonPanelProvider.e0(EmoticonInfo.this, this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(NTEmoticonPanelProvider this$0, String path, com.tencent.qqnt.msg.data.g picExtBizInfo, EmoticonInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(picExtBizInfo, "$picExtBizInfo");
        Intrinsics.checkNotNullParameter(info, "$info");
        e.a aVar = this$0.emoCallbackDelegate;
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(path, "path");
            AIEmoticonInfo aIEmoticonInfo = info instanceof AIEmoticonInfo ? (AIEmoticonInfo) info : null;
            e.a.C9450a.a(aVar, path, 14, null, picExtBizInfo, aIEmoticonInfo != null ? aIEmoticonInfo.md5 : null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(NTEmoticonPanelProvider this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.context, R.string.f174462vx, 0).show();
    }

    private final void h0(FavoriteLottieEmoticonInfo info) {
        Integer intOrNull;
        String str = info.eId;
        Intrinsics.checkNotNullExpressionValue(str, "info.eId");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull == null) {
            QLog.e("NTEmoticonPanelProvider", 1, "[sendFavLottieEmotion] error, invalidate eId=" + info.eId);
            return;
        }
        e.a aVar = this.emoCallbackDelegate;
        if (aVar != null) {
            aVar.e(intOrNull.intValue(), true);
        }
    }

    private final void i0(final EmoticonInfo info) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.d
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoticonPanelProvider.j0(NTEmoticonPanelProvider.this, info);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final NTEmoticonPanelProvider this$0, final EmoticonInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        long currentTimeMillis = System.currentTimeMillis();
        final String x16 = this$0.x(info);
        boolean fileExists = FileUtils.fileExists(x16);
        if (!fileExists) {
            QLog.w("NTEmoticonPanelProvider", 1, "sendFavPicEmotion file not exists, try download!");
            URL url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB, x16);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mExtraInfo = info;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(downloadURL, options)");
            drawable.downloadImediatly(false);
            if (drawable.getStatus() != 4 && drawable.getStatus() != 1) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTEmoticonPanelProvider.k0();
                    }
                });
                QLog.e("NTEmoticonPanelProvider", 1, "sendFavPicEmotion failed! urlDrawable.status=", Integer.valueOf(drawable.getStatus()));
                return;
            }
        }
        QLog.d("NTEmoticonPanelProvider", 1, "sendFavPicEmotion prepare file, path:" + x16 + ", fileExist:" + fileExists + ", duration:" + (System.currentTimeMillis() - currentTimeMillis));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.h
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoticonPanelProvider.l0(x16, this$0, info);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0() {
        QQToast.makeText(BaseApplication.getContext(), R.string.fkh, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(String path, NTEmoticonPanelProvider this$0, EmoticonInfo info) {
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        QLog.d("NTEmoticonPanelProvider", 1, "[sendFavPicEmotion] path=" + path + ", emoCallbackDelegate=" + (this$0.emoCallbackDelegate != null));
        e.a aVar = this$0.emoCallbackDelegate;
        if (aVar != null) {
            com.tencent.qqnt.msg.data.g B = this$0.B(info);
            FavoriteEmoticonInfo favoriteEmoticonInfo = info instanceof FavoriteEmoticonInfo ? (FavoriteEmoticonInfo) info : null;
            e.a.C9450a.a(aVar, path, 1, null, B, favoriteEmoticonInfo != null ? favoriteEmoticonInfo.emojiMd5 : null, 4, null);
        }
    }

    private final void m0(EmotionSearchItem searchItem, String searchWord, int picSubType) {
        String str;
        File diskFile = com.tencent.mobileqq.hotpic.b.getDiskFile(searchItem.originalUrl);
        if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
            str = diskFile.getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.d("NTEmoticonPanelProvider", 2, "senHotPic, urlHotPicOringinal = " + searchItem.originalUrl + ", paths = " + str);
            }
        } else if (((IHotPicPageApi) QRoute.api(IHotPicPageApi.class)).checkAndDownLoadHotPic(searchItem) == 0) {
            str = com.tencent.mobileqq.hotpic.b.getDiskFile(searchItem.url).getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.d("NTEmoticonPanelProvider", 2, "senHotPic, urlHotPic = " + searchItem.url + ", paths = " + str);
            }
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 == null) {
            QQToast.makeText(BaseApplication.getContext(), R.string.fkh, 0).show();
            return;
        }
        c0(searchItem.getOriginEmoMd5(), picSubType == 13, searchItem.picIndex, searchWord);
        e.a aVar = this.emoCallbackDelegate;
        if (aVar != null) {
            aVar.h(str2, picSubType, null, A(searchItem), searchItem.getOriginEmoMd5());
        }
    }

    private final void o0(View panelView) {
        VideoReport.setElementId(panelView, EmotionReportDtImpl.EM_AIO_STICKERS_PANEL);
        VideoReport.setElementExposePolicy(panelView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(panelView, ClickPolicy.REPORT_NONE);
    }

    private final void p0() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(EmotionPanelMsgIntent.ShowGuideBubble.f205392d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(RelativeLayout view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        QLog.d("NTEmoticonPanelProvider", 2, "mainPanel View: height=" + view.getHeight() + ", width=" + view.getWidth());
    }

    private final AppRuntime u() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    private final int v() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(EmotionPanelMsgIntent.GetAndResetEmotionPanelDefaultType.f205386d);
        b.c cVar = k3 instanceof b.c ? (b.c) k3 : null;
        if (cVar != null) {
            return cVar.a();
        }
        return -1;
    }

    private final String w(EmoticonInfo emoInfo) {
        String emoticonMD5 = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getEmoticonMD5(emoInfo);
        Intrinsics.checkNotNullExpressionValue(emoticonMD5, "api(IEmoticonBusinessPro\u2026).getEmoticonMD5(emoInfo)");
        return emoticonMD5;
    }

    private final String x(EmoticonInfo emoInfo) {
        String favEmoPath = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getFavEmoPath(emoInfo);
        Intrinsics.checkNotNullExpressionValue(favEmoPath, "api(IEmoticonBusinessPro\u2026a).getFavEmoPath(emoInfo)");
        return favEmoPath;
    }

    private final Map<Integer, BaseEmotionPanelBusinessParam> z() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(EmotionPanelMsgIntent.GetAndResetEmotionPanelBusinessParam.f205385d);
        b.C7509b c7509b = k3 instanceof b.C7509b ? (b.C7509b) k3 : null;
        if (c7509b != null) {
            return c7509b.a();
        }
        return null;
    }

    public final int E() {
        return l.D(this.context) + ImmersiveUtils.getStatusBarHeight(this.context);
    }

    public final boolean S() {
        return QQTheme.isNowSimpleUI();
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void a(com.tencent.aio.api.runtime.a aioContext, EditText editText) {
        final RelativeLayout view;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(editText, "editText");
        if (QLog.isColorLevel()) {
            QLog.d("NTEmoticonPanelProvider", 2, "bindView");
        }
        this.mEditText = editText;
        this.mAIOContext = aioContext;
        com.tencent.aio.api.runtime.a aVar = null;
        if (this.mainPanel == null) {
            this.mainPanel = s();
            ViewGroup viewGroup = this.panelContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                viewGroup = null;
            }
            viewGroup.removeAllViews();
            IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
            if (iEmoticonMainPanel != null && (view = iEmoticonMainPanel.getView()) != null) {
                ViewGroup viewGroup2 = this.panelContainer;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                    viewGroup2 = null;
                }
                viewGroup2.addView(view);
                o0(view);
                view.post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTEmoticonPanelProvider.r(view);
                    }
                });
            } else {
                QLog.e("NTEmoticonPanelProvider", 1, "createPanel Failed!");
            }
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.d().getLifecycle().addObserver(this);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        aVar3.e().d(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class).getQualifiedName(), this.mAction1);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar4;
        }
        aVar.e().d(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class).getQualifiedName(), this.mAction1);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(a.C7508a.class, this.emotionEventObserver);
        IHostEmoticonMainApi iHostEmoticonMainApi = (IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class);
        IEmoticonMainPanel iEmoticonMainPanel2 = this.mainPanel;
        Intrinsics.checkNotNull(iEmoticonMainPanel2);
        iHostEmoticonMainApi.onInit(iEmoticonMainPanel2);
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void b(e.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.emoCallbackDelegate = callback;
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void c() {
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.updateFavEmoticonPanel();
        }
    }

    @Override // com.tencent.qqnt.aio.api.e
    public View createView() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        this.panelContainer = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IEmoticonDelApi iEmoticonDelApi = (IEmoticonDelApi) QRoute.api(IEmoticonDelApi.class);
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        iEmoticonDelApi.delete(editText);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        L();
    }

    @Override // com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper
    /* renamed from: getEmoPanel, reason: from getter */
    public IEmoticonMainPanel getMainPanel() {
        return this.mainPanel;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo info) {
        return false;
    }

    public final IEmoticonMainPanel s() {
        EditText editText;
        com.tencent.aio.api.runtime.a aVar;
        int F = F(v());
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        boolean y16 = y(aVar2);
        IEmoticonMainPanelService iEmoticonMainPanelService = (IEmoticonMainPanelService) u().getRuntimeService(IEmoticonMainPanelService.class, "");
        Context context = this.context;
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        AIOParam g16 = aVar4.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        IEmoticonMainPanelService.PanelBuilder disableGuide = iEmoticonMainPanelService.newBuilder(context, aVar3, su3.b.c(g16)).setCallBack(this).setOnlySysAndEmoji(y16).setHideAllSettingTabs(y16).setDisableMoreEmotionButton(true).setDisableGuide(false);
        Context context2 = this.context;
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        } else {
            editText = editText2;
        }
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        } else {
            aVar = aVar5;
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder = disableGuide.setPanelInteractionListener(new k(context2, editText, aVar, this, this)).setDefaultPanelType(F).setTextGifOpen(true).setToastOffset(E()).keepLottieMerged(false).setPanelBusinessParam(z());
        if (S()) {
            panelBuilder.setTopTab();
        }
        Intrinsics.checkNotNullExpressionValue(panelBuilder, "panelBuilder");
        Q(panelBuilder);
        P(panelBuilder);
        a0();
        p0();
        IEmoticonMainPanel create = panelBuilder.create();
        Intrinsics.checkNotNullExpressionValue(create, "panelBuilder.create()");
        return create;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo info) {
        String w3;
        if (info == 0) {
            return;
        }
        boolean z16 = info instanceof FavoriteLottieEmoticonInfo;
        if (z16) {
            h0((FavoriteLottieEmoticonInfo) info);
        } else if (T(info)) {
            i0(info);
        } else if (U(info)) {
            m0(C(info), D(info), W(info) ? 13 : 2);
        } else if (X(info)) {
            if ((info instanceof IPicEmoticonInfo) && (u() instanceof QQAppInterface)) {
                IPicEmoticonInfo iPicEmoticonInfo = (IPicEmoticonInfo) info;
                if (iPicEmoticonInfo.getImageJobType() != 2 && iPicEmoticonInfo.getImageJobType() != 4) {
                    AppRuntime u16 = u();
                    Intrinsics.checkNotNull(u16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                    Emoticon emoticon = iPicEmoticonInfo.getEmoticon();
                    Intrinsics.checkNotNullExpressionValue(emoticon, "info.emoticon");
                    n0((QQAppInterface) u16, emoticon);
                } else if (QLog.isColorLevel()) {
                    QLog.d("NTEmoticonPanelProvider", 2, "magic emoticon cannot be sent");
                }
            }
        } else if (Y(info)) {
            String I = I(info);
            com.tencent.qqnt.msg.data.g K = K(info);
            String J = J(info);
            e.a aVar = this.emoCallbackDelegate;
            if (aVar != null) {
                e.a.C9450a.a(aVar, I, 1, J, K, null, 16, null);
            }
        } else {
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (info instanceof ExtAniStickerEmoticonInfo) {
                int convertToServer = QQSysFaceUtil.convertToServer(((ExtAniStickerEmoticonInfo) info).code);
                e.a aVar3 = this.emoCallbackDelegate;
                if (aVar3 != null) {
                    aVar3.e(convertToServer, true);
                }
                QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
                com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar2 = aVar4;
                }
                resImpl.reportEmoClick(convertToServer, 1, com.tencent.nt.adapter.session.c.l(aVar2.g().r().c().e()));
            } else if (R(info)) {
                d0(info);
            } else {
                AppRuntime u17 = u();
                Context context = this.context;
                EditText editText = this.mEditText;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    editText = null;
                }
                com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar2 = aVar5;
                }
                AIOParam g16 = aVar2.g();
                Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
                info.send(u17, context, editText, su3.b.a(g16));
            }
        }
        if ((T(info) || X(info)) && info.srcType == 2) {
            if (z16) {
                w3 = ((FavoriteLottieEmoticonInfo) info).eId;
            } else {
                w3 = w(info);
            }
            ReportController.o(u(), "dc00898", "", "", "0X800C505", "0X800C505", 0, 0, "", "", w3, "");
        }
    }

    @Override // com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper
    public void setEmotionSearchPanelVisible(boolean visible, int bottom, boolean clearWord, String word, int width) {
        int realHeight;
        int height;
        Window window;
        View decorView;
        IEmoticonPanelController emoController;
        QLog.i("NTEmoticonPanelProvider", 4, "setEmotionSearchPanelVisible visible=" + visible + " bottom=" + bottom + " clearWord=" + clearWord + " word=" + word + " with=" + width);
        if (visible) {
            IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
            p pVar = (p) ((iEmoticonMainPanel == null || (emoController = iEmoticonMainPanel.getEmoController()) == null) ? null : emoController.getHelper(6));
            if (pVar == null) {
                return;
            }
            if (this.mEmotionSearchPanel == null) {
                KeyEvent.Callback inflate = View.inflate(this.context, R.layout.f167593dv1, null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.emosm.IEmotionSearchPanel");
                this.mEmotionSearchPanel = (q) inflate;
            }
            q qVar = this.mEmotionSearchPanel;
            if (qVar != null) {
                qVar.showEmotionSearchWindow();
            }
            Context context = this.context;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                realHeight = decorView.getHeight();
            } else {
                realHeight = ScreenUtil.getRealHeight(this.context);
            }
            int statusBarHeight = (realHeight - bottom) - ImmersiveUtils.getStatusBarHeight(this.context);
            if (ThemeUtil.isNowThemeIsSimple(u(), false, null)) {
                Rect rect = new Rect();
                EditText editText = this.mEditText;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    editText = null;
                }
                editText.getGlobalVisibleRect(rect);
                height = bottom - rect.bottom;
            } else {
                EditText editText2 = this.mEditText;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    editText2 = null;
                }
                height = editText2.getHeight();
            }
            int i3 = height;
            q qVar2 = this.mEmotionSearchPanel;
            if (qVar2 != null) {
                AppRuntime u16 = u();
                Intrinsics.checkNotNull(u16, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) u16;
                IEmoticonMainPanel iEmoticonMainPanel2 = this.mainPanel;
                qVar2.init(baseQQAppInterface, iEmoticonMainPanel2 != null ? iEmoticonMainPanel2.getPanelInteractionListener() : null, statusBarHeight, clearWord, word, i3, width, pVar);
            }
            if (clearWord) {
                pVar.loadHotPicData();
                return;
            }
            return;
        }
        q qVar3 = this.mEmotionSearchPanel;
        if (qVar3 != null) {
            qVar3.onDestory();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest((Activity) context, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY);
        activityURIRequest.extra().putInt(EmosmEmoticonConstant.EXTRA_LAUNCH_SOURCE, 1);
        activityURIRequest.extra().putInt("extra_launch_mode", 2);
        ReportController.o(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallbackWithShowPanel
    public void showEmoticonPanel(int panelType) {
        RelativeLayout view;
        BaseEmotionPanelBusinessParam baseEmotionPanelBusinessParam;
        IEmoticonMainPanel iEmoticonMainPanel;
        int F = F(panelType);
        Map<Integer, BaseEmotionPanelBusinessParam> z16 = z();
        if (z16 != null && (baseEmotionPanelBusinessParam = z16.get(Integer.valueOf(F))) != null && (iEmoticonMainPanel = this.mainPanel) != null) {
            iEmoticonMainPanel.updatePanelBusinessParam(F, baseEmotionPanelBusinessParam);
        }
        IEmoticonMainPanel iEmoticonMainPanel2 = this.mainPanel;
        boolean z17 = false;
        if (iEmoticonMainPanel2 != null && (view = iEmoticonMainPanel2.getView()) != null && view.getVisibility() == 0) {
            z17 = true;
        }
        if (z17) {
            IEmoticonMainPanel iEmoticonMainPanel3 = this.mainPanel;
            if (iEmoticonMainPanel3 != null) {
                iEmoticonMainPanel3.initEmoticonView(F);
            }
        } else {
            IEmoticonMainPanel iEmoticonMainPanel4 = this.mainPanel;
            if (iEmoticonMainPanel4 != null) {
                iEmoticonMainPanel4.initEmoticonView(F);
            }
            IEmoticonMainPanel iEmoticonMainPanel5 = this.mainPanel;
            if (iEmoticonMainPanel5 != null) {
                iEmoticonMainPanel5.preloadWebProcess();
            }
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("NTEmoticonPanelProvider", 1001, false, 0, 12, null));
    }

    public final ViewGroup t() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        View requireView = aVar.c().requireView();
        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) requireView;
    }

    private final void N(FullScreenMsgIntent.OnFullScreenModeChanged i3) {
        QLog.d("NTEmoticonPanelProvider", 1, "Change To FullScreenMode");
        this.mainPanel = s();
        ViewGroup viewGroup = this.panelContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        ViewGroup viewGroup3 = this.panelContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        Intrinsics.checkNotNull(iEmoticonMainPanel);
        viewGroup2.addView(iEmoticonMainPanel.getView());
        IEmoticonMainPanel iEmoticonMainPanel2 = this.mainPanel;
        Intrinsics.checkNotNull(iEmoticonMainPanel2);
        o0(iEmoticonMainPanel2.getView());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        QLog.i("NTEmoticonPanelProvider", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class)).onClear();
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onDestory();
        }
        com.tencent.aio.api.runtime.a aVar = null;
        this.mainPanel = null;
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.d().getLifecycle().removeObserver(this);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        aVar3.e().b(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class).getQualifiedName(), this.mAction1);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar4;
        }
        aVar.e().b(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class).getQualifiedName(), this.mAction1);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(a.C7508a.class, this.emotionEventObserver);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        QLog.i("NTEmoticonPanelProvider", 4, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onPause();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("NTEmoticonPanelProvider", 4, "onResume");
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onResume();
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(NTEmoticonPanelProvider this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            l61.a.b(baseQQAppInterface, "0X8005CAD", com.tencent.nt.adapter.session.c.c(aVar.g().r().c().e()));
            VasWebviewUtil.reportCommercialDrainage(baseQQAppInterface.getCurrentUin(), "ep_mall", "0X8005795", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
    }

    private final void c0(String originEmoMd5, boolean fromSearch, int picIndex, String searchWord) {
        String str;
        if (originEmoMd5 != null) {
            str = originEmoMd5.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase()");
        } else {
            str = null;
        }
        if (fromSearch) {
            ReportController.o(u(), "dc00898", "", "", EmoticonOperateReport.REPORT_TAG_0X800AE2E, EmoticonOperateReport.REPORT_TAG_0X800AE2E, 0, 0, "2", String.valueOf(picIndex + 1), str, searchWord);
        }
        ReportController.o(u(), "dc00898", "", "", EmoticonOperateReport.REPORT_TAG_0X800AE20, EmoticonOperateReport.REPORT_TAG_0X800AE20, fromSearch ? 2 : 1, 0, "2", String.valueOf(picIndex), str, "");
    }

    private final com.tencent.qqnt.msg.data.g A(EmotionSearchItem searchItem) {
        if (searchItem == null || TextUtils.isEmpty(searchItem.appid) || !TextUtils.isDigitsOnly(searchItem.appid)) {
            return null;
        }
        com.tencent.qqnt.msg.data.g gVar = new com.tencent.qqnt.msg.data.g(null, null, null, null, null, null, 0, 127, null);
        String str = searchItem.appid;
        Intrinsics.checkNotNullExpressionValue(str, "it.appid");
        gVar.h(new EmojiMall(Integer.parseInt(str), 0));
        return gVar;
    }

    private final boolean y(com.tencent.aio.api.runtime.a aioContext) {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.k k3 = (aioContext == null || (e16 = aioContext.e()) == null) ? null : e16.k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        e.a aVar = k3 instanceof e.a ? (e.a) k3 : null;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(final EmoticonInfo info, final NTEmoticonPanelProvider this$0) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Option url = Option.obtain().setUrl(info.getBigImageURL());
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        final String picLocalPath = qQPicLoader.d().getPicLocalPath(url);
        if (!FileUtils.fileExistsAndNotEmpty(picLocalPath)) {
            qQPicLoader.d().download(url, null);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.i
                @Override // java.lang.Runnable
                public final void run() {
                    NTEmoticonPanelProvider.g0(NTEmoticonPanelProvider.this);
                }
            });
            return;
        }
        boolean z16 = info instanceof AIEmoticonInfo;
        AIEmoticonInfo aIEmoticonInfo = z16 ? (AIEmoticonInfo) info : null;
        int i3 = aIEmoticonInfo != null ? aIEmoticonInfo.templateId : 0;
        final com.tencent.qqnt.msg.data.g gVar = new com.tencent.qqnt.msg.data.g(null, null, null, null, null, null, i3, 63, null);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.j
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoticonPanelProvider.f0(NTEmoticonPanelProvider.this, picLocalPath, gVar, info);
            }
        });
        ReportController.o(null, "dc00898", "", "", "0X800C60A", "0X800C60A", 0, 0, "", "", "", "");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, Integer.valueOf(i3));
        AIEmoticonInfo aIEmoticonInfo2 = z16 ? (AIEmoticonInfo) info : null;
        pairArr[1] = TuplesKt.to("ref_id", Integer.valueOf(aIEmoticonInfo2 != null ? aIEmoticonInfo2.refId : 0));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        com.tencent.mobileqq.aio.utils.b.l("em_bas_ai_emoji", mapOf);
    }

    private final void n0(final QQAppInterface app, final Emoticon e16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("emoji_id", e16.epId);
            ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("DressVip", "pg_aio", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "send", "", "4", 102, 0, 0, "", jSONObject.toString(), "");
        } catch (Exception e17) {
            QLog.i("NTEmoticonPanelProvider", 1, "report action failed", e17);
        }
        int i3 = e16.jobType;
        if ((i3 == 0 || i3 == 2 || i3 == 4) && !e16.hasEncryptKey()) {
            Context context = this.context;
            QQToast.makeText(context, context.getString(R.string.b2g), 0).show();
            ChatActivityFacade.a1(app, e16);
            String str = e16.epId;
            String str2 = e16.eId;
            int networkType = NetworkUtil.getNetworkType(this.context);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(networkType);
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "2", str, str2, sb5.toString(), "", "", "", "");
            String str3 = e16.name;
            if (str3 == null) {
                str3 = "~";
            }
            String str4 = e16.epId;
            if (str4 == null) {
                str4 = "~";
            }
            String str5 = e16.eId;
            QLog.e("NTEmoticonPanelProvider", 1, "sendEmosmMsg emoticon Encrypt Key is null.name:" + str3 + ", epid_eid:" + str4 + "_" + (str5 != null ? str5 : "~"));
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.emoticon.NTEmoticonPanelProvider$sendMarketFace$runnable$1
            /* JADX WARN: Code restructure failed: missing block: B:17:0x00ac, code lost:
            
                r1 = r3.emoCallbackDelegate;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                e.a aVar;
                Context context2;
                IRuntimeService runtimeService = QQAppInterface.this.getRuntimeService(IEmoticonManagerService.class);
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IE\u2026nagerService::class.java)");
                EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) runtimeService).syncFindEmoticonPackageById(e16.epId);
                if (syncFindEmoticonPackageById == null) {
                    Emoticon emoticon = e16;
                    String str6 = emoticon.name;
                    if (str6 == null) {
                        str6 = "~";
                    }
                    String str7 = emoticon.epId;
                    if (str7 == null) {
                        str7 = "~";
                    }
                    String str8 = emoticon.eId;
                    QLog.e("NTEmoticonPanelProvider", 1, "sendEmosmMsg ePackage == null name:" + str6 + ", epid_eid:" + str7 + "_" + (str8 != null ? str8 : "~"));
                    Emoticon emoticon2 = e16;
                    String str9 = emoticon2.epId;
                    String str10 = emoticon2.eId;
                    context2 = this.context;
                    int networkType2 = NetworkUtil.getNetworkType(context2);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(networkType2);
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "3", str9, str10, sb6.toString(), "", "", "", "");
                    return;
                }
                MarkFaceMessage g06 = ChatActivityFacade.g0(QQAppInterface.this, syncFindEmoticonPackageById, e16);
                Intrinsics.checkNotNullExpressionValue(g06, "getMarkFaceMessage(app, ePackage, e)");
                MarkFaceMessage convertToNtMarkFaceMessage = ((IAIOEmoPanelApi) QRoute.api(IAIOEmoPanelApi.class)).convertToNtMarkFaceMessage(g06);
                if (convertToNtMarkFaceMessage == null || aVar == null) {
                    return;
                }
                aVar.c(convertToNtMarkFaceMessage);
            }
        }, 32, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo oldInfo, EmoticonInfo newInfo, Drawable d16) {
        boolean z16 = false;
        if (newInfo != 0 && newInfo.type == 6) {
            IPicEmoticonInfo iPicEmoticonInfo = newInfo instanceof IPicEmoticonInfo ? (IPicEmoticonInfo) newInfo : null;
            if (iPicEmoticonInfo != null && iPicEmoticonInfo.isSound()) {
                z16 = true;
            }
            if (z16) {
                MediaPlayerManager.q(u()).D(true);
            }
        }
    }

    private final int F(int panelType) {
        if (panelType == 6 || panelType == 10) {
            return panelType;
        }
        IRuntimeService runtimeService = u().getRuntimeService(IEmoticonManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nstant.MAIN\n            )");
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) runtimeService;
        if (((IHotPicSearchTabListener) QRoute.api(IHotPicSearchTabListener.class)).isMergeHotPicExperiment()) {
            if (panelType != 12) {
                return panelType;
            }
            Z();
            return 18;
        }
        CommonTabEmojiInfo ntOfficialCommonTabEmojiInfo = iEmoticonManagerService.getNtOfficialCommonTabEmojiInfo(panelType);
        if (ntOfficialCommonTabEmojiInfo == null || !ntOfficialCommonTabEmojiInfo.isHide) {
            return panelType;
        }
        if (panelType == 12) {
            Z();
            return 18;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.context.getString(R.string.f209445ff);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026anel_tab_open_guide_tips)");
        String str = ntOfficialCommonTabEmojiInfo.tabName;
        String format = String.format(string, Arrays.copyOf(new Object[]{str, str}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        Context context = this.context;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, ntOfficialCommonTabEmojiInfo.tabName + context.getString(R.string.r2z), format, this.context.getString(R.string.b2i), this.context.getString(R.string.f171757kt3), new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.emoticon.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NTEmoticonPanelProvider.G(NTEmoticonPanelProvider.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.emoticon.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NTEmoticonPanelProvider.H(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026                       })");
        createCustomDialog.show();
        return panelType;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        e.a aVar = this.emoCallbackDelegate;
        if (aVar != null) {
            aVar.send();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo info) {
    }
}
