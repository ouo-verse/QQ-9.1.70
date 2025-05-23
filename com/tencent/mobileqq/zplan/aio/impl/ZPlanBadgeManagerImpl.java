package com.tencent.mobileqq.zplan.aio.impl;

import android.app.Activity;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager;
import com.tencent.mobileqq.zplan.aio.badge.ZPlanBrandAnimHelper;
import com.tencent.mobileqq.zplan.aio.impl.ZPlanBadgeManagerImpl;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.ak;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.v;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.util.TokenResUtils;
import com.tencent.util.URLUtil;
import com.tencent.widget.RedWidgetUtil;
import com.tencent.xweb.FileReaderHelper;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00ac\u00012\u00020\u00012\u00020\u0002:\u0002\u00ad\u0001B\t\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0002J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020\rH\u0002J\u001a\u0010/\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u00102\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000100H\u0002J$\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\tH\u0002J\u0018\u00108\u001a\u00020\u00062\u0006\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\u0003H\u0002J\u0010\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u000200H\u0002J\u0012\u0010;\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u000100H\u0002J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u000200H\u0002J,\u0010B\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\u00172\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u0017H\u0002J\b\u0010C\u001a\u00020\u0006H\u0002J\u0018\u0010D\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u0017H\u0002J\b\u0010E\u001a\u00020\u0003H\u0002JS\u0010L\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\r2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0004\bL\u0010MJ\b\u0010N\u001a\u00020\u0006H\u0002J\u0010\u0010O\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010T\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RH\u0016J\b\u0010U\u001a\u00020\u0006H\u0016J\u0010\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0017H\u0016J\u0010\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u0017H\u0016J\u0018\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010]\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020$H\u0016J\b\u0010^\u001a\u00020\u0006H\u0016J\b\u0010_\u001a\u00020\u0006H\u0016J\b\u0010`\u001a\u00020\u0006H\u0016J\b\u0010a\u001a\u00020\u0006H\u0016J\b\u0010b\u001a\u00020\u0006H\u0016J\b\u0010c\u001a\u00020\u0006H\u0016J\b\u0010d\u001a\u00020\u0006H\u0016J\b\u0010e\u001a\u00020\u0006H\u0016J\b\u0010f\u001a\u00020\u0006H\u0016J\b\u0010g\u001a\u00020\u0003H\u0016R\u0016\u0010h\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010nR\u0018\u0010u\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010g\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010zR\u0016\u0010{\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010zR\u0016\u0010|\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010zR\u0016\u0010}\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0016\u0010\u007f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010zR\u0019\u0010<\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u0080\u0001R\u001c\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001b\u0010\u008f\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0017\u00103\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b3\u0010\u0090\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0095\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009a\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009a\u0001\u0010zR\u0018\u0010\u009b\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010zR\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010\u009f\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009f\u0001\u0010zR\u0018\u0010\u00a1\u0001\u001a\u00030\u00a0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0018\u0010\u00a4\u0001\u001a\u00030\u00a3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001a\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a6\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00a7\u0001\u0010\u00a8\u0001\u00a8\u0006\u00ae\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/impl/ZPlanBadgeManagerImpl;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/zplan/aio/IZPlanBadgeManager;", "", "isFirstTime", "isFromBanner", "", "checkAccessibleAndUpdateEntranceBtn", "shouldForceShowChatAIEntrance", "", "uin", "checkChatAIEntrance", "reportChatBotImp", "", "showAIChatIcon", "checkZPlanEntrance", "needGuide", "getEntryInfo", "isChangeUser", "updateEntranceUI", "shouldShowGuideTip", "saveGuideTipSp", FileReaderHelper.TXT_EXT, "", "time", "showGuideTips", WidgetCacheConstellationData.NUM, "showNumRedDot", "getShowNum", "Low4/b;", "entry", "updateEntryInfo", "setAdId", "setEntryIcon", "reportSquareImp", "showBubbleIfNeed", "Landroid/view/View;", "view", "needClickReport", "handleZplanClickEvent", "isNewRedDot", "haveShowRedTouch", "clickJump", "str", "safelyEncodeString", WadlProxyConsts.KEY_JUMP_URL, "tianshuAdId", "tryRebuildSchemeForOpenSmallHome", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "info", "isClearNum", "adId", "delay", "getRedTouchAppInfoAsyncAndRefreshUI", "newRedInfo", "needClear", "handleRefreshRedTouch", "redInfo", "redTouchExposure", "handleExtendTips", "redDotAppInfo", "handleBubbleAd", "text", "lifeTime", "ignoreCheckForeground", "type", "showTipsView", "safelyCloseTipsIfShowing", "canShowTips", "checkIsTipsShowing", "from", "entranceContainerV", "redTouchV", "numRedDotV", "animImageViewV", "normalRedDotV", "adjustVisibility", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "hideAllViews", "doDnsAsyncForSquareIfNeed", "Landroid/app/Activity;", EventKey.ACT, "", "conversationTitleBtnCtrl", "init", "onPostThemeChanged", "color", "setTitleEntranceImageColorFilter", com.tencent.luggage.wxa.c8.c.f123400v, "setTitleEntranceImageAlpha", "parentView", "onCreateView", "v", NodeProps.ON_CLICK, "refreshRedTouch", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBeforeAccountChanged", "onAccountChanged", "resetVisibility", "hideEntrance", "updateVisibility", "isEntranceShow", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "Lcom/tencent/mobileqq/activity/ConversationTitleBtnCtrl;", "titleBtnCtrl", "Lcom/tencent/mobileqq/activity/ConversationTitleBtnCtrl;", "entranceContainer", "Landroid/view/View;", "Landroid/widget/ImageView;", "entranceIcon", "Landroid/widget/ImageView;", "animImageView", "normalRedDot", "Landroid/widget/TextView;", "numRedDot", "Landroid/widget/TextView;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "Z", "hasRedDot", "hasBubbleAd", "bubbleDismissTime", "J", "hasRedNum", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "Lcom/tencent/mobileqq/zplan/aio/badge/k;", "zplanEntranceTips", "Lcom/tencent/mobileqq/zplan/aio/badge/k;", "Lcom/tencent/mobileqq/zootopia/utils/e;", "fastClickUtils", "Lcom/tencent/mobileqq/zootopia/utils/e;", "Lcom/tencent/mobileqq/zplan/aio/badge/ZPlanBrandAnimHelper;", "brandAnimHelper", "Lcom/tencent/mobileqq/zplan/aio/badge/ZPlanBrandAnimHelper;", "Lcom/tencent/mobileqq/zplan/aio/badge/i;", "normalAnimHelper", "Lcom/tencent/mobileqq/zplan/aio/badge/i;", "curEntry", "Low4/b;", "requestUin", "Ljava/lang/String;", "Lz23/b;", "zplanEntryService", "Lz23/b;", "curColorFilter", "Ljava/lang/Integer;", "curAlpha", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaReportApi;", "reportApi", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaReportApi;", "hasUpdateVisibility", "isReportBubble", "Ljava/lang/Runnable;", "pendingShowTipsRunnable", "Ljava/lang/Runnable;", "paused", "Lcom/tencent/mobileqq/zplan/servlet/b;", "requestObserver", "Lcom/tencent/mobileqq/zplan/servlet/b;", "Lji3/i;", "accessibleChangeListener", "Lji3/i;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanBadgeManagerImpl implements View.OnClickListener, IZPlanBadgeManager {
    private static final int DISMISS_TIME = 500;
    private static final String TAG = "ZPlanBadgeManager";
    private final ji3.i accessibleChangeListener;
    private Activity activity;
    private ImageView animImageView;
    private ZPlanBrandAnimHelper brandAnimHelper;
    private long bubbleDismissTime;
    private Integer curAlpha;
    private Integer curColorFilter;
    private ow4.b curEntry;
    private View entranceContainer;
    private ImageView entranceIcon;
    private boolean hasBubbleAd;
    private boolean hasRedDot;
    private boolean hasRedNum;
    private boolean hasUpdateVisibility;
    private boolean isEntranceShow;
    private boolean isReportBubble;
    private com.tencent.mobileqq.zplan.aio.badge.i normalAnimHelper;
    private View normalRedDot;
    private TextView numRedDot;
    private boolean paused;
    private Runnable pendingShowTipsRunnable;
    private BusinessInfoCheckUpdate.AppInfo redDotAppInfo;
    private RedTouch redTouch;
    private final IZootopiaReportApi reportApi;
    private final com.tencent.mobileqq.zplan.servlet.b requestObserver;
    private String requestUin;
    private ConversationTitleBtnCtrl titleBtnCtrl;
    private com.tencent.mobileqq.zplan.aio.badge.k zplanEntranceTips;
    private final com.tencent.mobileqq.zootopia.utils.e fastClickUtils = new com.tencent.mobileqq.zootopia.utils.e();
    private String adId = "";
    private final z23.b zplanEntryService = new z23.b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanBadgeManagerImpl$b", "Lji3/i;", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "detail", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ji3.i {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ZPlanBadgeManagerImpl this$0, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z16 ^ this$0.isEntranceShow) {
                this$0.isEntranceShow = !this$0.isEntranceShow;
                this$0.updateEntranceUI(false);
            }
        }

        @Override // ji3.i
        public void a(AccessibleDetail detail) {
            QQAppInterface app = ZPlanBadgeManagerImpl.this.getApp();
            if (app == null) {
                return;
            }
            long longAccountUin = app.getLongAccountUin();
            final boolean z16 = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(100007L, longAccountUin) || ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1001L, longAccountUin) || ZPlanBadgeManagerImpl.this.shouldForceShowChatAIEntrance();
            if (QLog.isColorLevel()) {
                QLog.d(ZPlanBadgeManagerImpl.TAG, 1, "onAccessibleChange, isInWhiteList:" + z16);
            }
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final ZPlanBadgeManagerImpl zPlanBadgeManagerImpl = ZPlanBadgeManagerImpl.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.q
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBadgeManagerImpl.b.c(ZPlanBadgeManagerImpl.this, z16);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanBadgeManagerImpl$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Low4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ow4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<ZPlanBadgeManagerImpl> f331056d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f331057e;

        c(WeakReference<ZPlanBadgeManagerImpl> weakReference, String str) {
            this.f331056d = weakReference;
            this.f331057e = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ow4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZPlanBadgeManagerImpl zPlanBadgeManagerImpl = this.f331056d.get();
            if (zPlanBadgeManagerImpl == null) {
                return;
            }
            QLog.i(ZPlanBadgeManagerImpl.TAG, 1, "getEntry success, type:" + result.f424389a + " adId:" + result.f424393e);
            zPlanBadgeManagerImpl.requestUin = this.f331057e;
            zPlanBadgeManagerImpl.updateEntryInfo(result);
            ImageView imageView = zPlanBadgeManagerImpl.entranceIcon;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            String currentUin;
            ZPlanBadgeManagerImpl zPlanBadgeManagerImpl = this.f331056d.get();
            if (zPlanBadgeManagerImpl == null) {
                return;
            }
            QLog.i(ZPlanBadgeManagerImpl.TAG, 1, "getEntry fail " + error + " " + message);
            ImageView imageView = zPlanBadgeManagerImpl.entranceIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            QQAppInterface app = zPlanBadgeManagerImpl.getApp();
            ZPlanBadgeManagerImpl.showGuideTips$default(zPlanBadgeManagerImpl, (app == null || (currentUin = app.getCurrentUin()) == null) ? 0L : Long.parseLong(currentUin), null, 0, 6, null);
            zPlanBadgeManagerImpl.adId = "140102";
            ZPlanBadgeManagerImpl.getRedTouchAppInfoAsyncAndRefreshUI$default(zPlanBadgeManagerImpl, zPlanBadgeManagerImpl.adId, false, 0L, 6, null);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JI\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanBadgeManagerImpl$d", "Lcom/tencent/mobileqq/zplan/aio/badge/b;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "a", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "info", "", "c", "", "from", "", "entranceContainerV", "redTouchV", "numRedDotV", "animImageViewV", "normalRedDotV", "b", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zplan.aio.badge.b {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.aio.badge.b
        public RedTouch a() {
            return ZPlanBadgeManagerImpl.this.redTouch;
        }

        @Override // com.tencent.mobileqq.zplan.aio.badge.b
        public void b(String from, Integer entranceContainerV, Integer redTouchV, Integer numRedDotV, Integer animImageViewV, Integer normalRedDotV) {
            Intrinsics.checkNotNullParameter(from, "from");
            ZPlanBadgeManagerImpl.this.adjustVisibility(from, entranceContainerV, redTouchV, numRedDotV, animImageViewV, normalRedDotV);
        }

        @Override // com.tencent.mobileqq.zplan.aio.badge.b
        public void c(BusinessInfoCheckUpdate.AppInfo info) {
            ZPlanBadgeManagerImpl.this.handleExtendTips(info);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JI\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanBadgeManagerImpl$e", "Lcom/tencent/mobileqq/zplan/aio/badge/b;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "a", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "info", "", "c", "", "from", "", "entranceContainerV", "redTouchV", "numRedDotV", "animImageViewV", "normalRedDotV", "b", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zplan.aio.badge.b {
        e() {
        }

        @Override // com.tencent.mobileqq.zplan.aio.badge.b
        public RedTouch a() {
            return ZPlanBadgeManagerImpl.this.redTouch;
        }

        @Override // com.tencent.mobileqq.zplan.aio.badge.b
        public void b(String from, Integer entranceContainerV, Integer redTouchV, Integer numRedDotV, Integer animImageViewV, Integer normalRedDotV) {
            Intrinsics.checkNotNullParameter(from, "from");
            ZPlanBadgeManagerImpl.this.adjustVisibility(from, entranceContainerV, redTouchV, numRedDotV, animImageViewV, normalRedDotV);
        }

        @Override // com.tencent.mobileqq.zplan.aio.badge.b
        public void c(BusinessInfoCheckUpdate.AppInfo info) {
            ZPlanBadgeManagerImpl.this.handleExtendTips(info);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanBadgeManagerImpl$f", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements com.tencent.mobileqq.zplan.servlet.b {
        f() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (type == 4) {
                ZPlanBadgeManagerImpl.this.showNumRedDot(((Integer) data).intValue());
            }
        }
    }

    public ZPlanBadgeManagerImpl() {
        QRouteApi api = QRoute.api(IZootopiaReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaReportApi::class.java)");
        this.reportApi = (IZootopiaReportApi) api;
        this.requestObserver = new f();
        this.accessibleChangeListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustVisibility(String from, Integer entranceContainerV, Integer redTouchV, Integer numRedDotV, Integer animImageViewV, Integer normalRedDotV) {
        if (!this.isEntranceShow) {
            hideAllViews();
            return;
        }
        if (entranceContainerV != null) {
            int intValue = entranceContainerV.intValue();
            View view = this.entranceContainer;
            if (view != null) {
                view.setVisibility(intValue);
            }
        }
        if (redTouchV != null) {
            int intValue2 = redTouchV.intValue();
            RedTouch redTouch = this.redTouch;
            if (redTouch != null) {
                redTouch.setVisibility(intValue2);
            }
        }
        if (numRedDotV != null) {
            int intValue3 = numRedDotV.intValue();
            TextView textView = this.numRedDot;
            if (textView != null) {
                textView.setVisibility(intValue3);
            }
        }
        if (animImageViewV != null) {
            int intValue4 = animImageViewV.intValue();
            ImageView imageView = this.animImageView;
            if (imageView != null) {
                imageView.setVisibility(intValue4);
            }
        }
        if (normalRedDotV != null) {
            int intValue5 = normalRedDotV.intValue();
            View view2 = this.normalRedDot;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(intValue5);
        }
    }

    private final boolean canShowTips(boolean ignoreCheckForeground, int type) {
        boolean z16;
        FrameHelperActivity ji5;
        y yVar;
        Activity activity = this.activity;
        ConversationTitleBtnCtrl conversationTitleBtnCtrl = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        boolean z17 = false;
        boolean isShowing = (baseActivity == null || OnlineStatusToggleUtils.e() || (ji5 = FrameHelperActivity.ji(baseActivity)) == null || (yVar = ji5.H) == null) ? false : yVar.isShowing();
        if (!ignoreCheckForeground) {
            ConversationTitleBtnCtrl conversationTitleBtnCtrl2 = this.titleBtnCtrl;
            if (conversationTitleBtnCtrl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBtnCtrl");
            } else {
                conversationTitleBtnCtrl = conversationTitleBtnCtrl2;
            }
            if (!conversationTitleBtnCtrl.h() || isShowing) {
                z16 = false;
                boolean a16 = ak.f335774a.a();
                boolean z18 = type != 1 || type == 2;
                if (z16 && !a16 && z18 && !this.paused) {
                    z17 = true;
                }
                QLog.d(TAG, 1, "canShowTips:" + z17 + ", foreground:" + z16 + ", drawerOpen:" + a16 + " isAccountPanelShow " + isShowing + ", type: " + type + ", paused:" + this.paused);
                return z17;
            }
        }
        z16 = true;
        boolean a162 = ak.f335774a.a();
        if (type != 1) {
        }
        if (z16) {
            z17 = true;
        }
        QLog.d(TAG, 1, "canShowTips:" + z17 + ", foreground:" + z16 + ", drawerOpen:" + a162 + " isAccountPanelShow " + isShowing + ", type: " + type + ", paused:" + this.paused);
        return z17;
    }

    private final void checkAccessibleAndUpdateEntranceBtn(boolean isFirstTime, boolean isFromBanner) {
        QLog.i(TAG, 1, "checkAccessibleAndUpdateEntranceBtn enter!");
        QQAppInterface app = getApp();
        if (app == null) {
            return;
        }
        long longAccountUin = app.getLongAccountUin();
        if (longAccountUin <= 0) {
            QLog.e(TAG, 1, "checkAccessibleAndUpdateEntranceBtn request uin is empty");
        } else {
            checkChatAIEntrance(longAccountUin, isFirstTime, isFromBanner);
        }
    }

    private final void checkChatAIEntrance(final long uin, final boolean isFirstTime, final boolean isFromBanner) {
        final WeakReference weakReference = new WeakReference(this);
        uk3.g.f439121a.e(100007L, uin, new nk3.n() { // from class: com.tencent.mobileqq.zplan.aio.impl.d
            @Override // nk3.n
            public final void a(AccessibleDetail accessibleDetail) {
                ZPlanBadgeManagerImpl.checkChatAIEntrance$lambda$1(weakReference, this, uin, isFirstTime, isFromBanner, accessibleDetail);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkChatAIEntrance$lambda$1(WeakReference weak, ZPlanBadgeManagerImpl this$0, final long j3, final boolean z16, boolean z17, AccessibleDetail accessibleDetail) {
        Intrinsics.checkNotNullParameter(weak, "$weak");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ZPlanBadgeManagerImpl zPlanBadgeManagerImpl = (ZPlanBadgeManagerImpl) weak.get();
        if (zPlanBadgeManagerImpl == null) {
            return;
        }
        if (!this$0.shouldForceShowChatAIEntrance() && (accessibleDetail == null || !accessibleDetail.isAccessible())) {
            QLog.i(TAG, 1, "checkChatAIEntrance, ai chat entrance not supported, detail=" + accessibleDetail);
            zPlanBadgeManagerImpl.checkZPlanEntrance(j3, z16, z17);
            return;
        }
        QLog.i(TAG, 1, "checkChatAIEntrance, ai chat entrance enabled");
        this$0.reportChatBotImp();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanBadgeManagerImpl.checkChatAIEntrance$lambda$1$lambda$0(ZPlanBadgeManagerImpl.this, z16, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkChatAIEntrance$lambda$1$lambda$0(ZPlanBadgeManagerImpl self, boolean z16, long j3) {
        Intrinsics.checkNotNullParameter(self, "$self");
        self.showAIChatIcon(z16, String.valueOf(j3));
    }

    private final boolean checkIsTipsShowing() {
        com.tencent.mobileqq.zplan.aio.badge.k kVar = this.zplanEntranceTips;
        if (kVar != null) {
            return kVar.c();
        }
        return false;
    }

    private final void checkZPlanEntrance(final long uin, final boolean isFirstTime, final boolean isFromBanner) {
        uk3.g.f439121a.e(1001L, uin, new nk3.n() { // from class: com.tencent.mobileqq.zplan.aio.impl.j
            @Override // nk3.n
            public final void a(AccessibleDetail accessibleDetail) {
                ZPlanBadgeManagerImpl.checkZPlanEntrance$lambda$6(ZPlanBadgeManagerImpl.this, uin, isFirstTime, isFromBanner, accessibleDetail);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkZPlanEntrance$lambda$6(final ZPlanBadgeManagerImpl this$0, final long j3, final boolean z16, final boolean z17, final AccessibleDetail accessibleDetail) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (accessibleDetail == null) {
            QLog.w(TAG, 1, "updateEntranceBtn, getAccessibleDetail null ");
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBadgeManagerImpl.checkZPlanEntrance$lambda$6$lambda$5(ZPlanBadgeManagerImpl.this, j3, accessibleDetail, z16, z17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkZPlanEntrance$lambda$6$lambda$5(final ZPlanBadgeManagerImpl this$0, long j3, final AccessibleDetail accessibleDetail, final boolean z16, final boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final boolean shouldShowGuideTip = this$0.shouldShowGuideTip(j3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanBadgeManagerImpl.checkZPlanEntrance$lambda$6$lambda$5$lambda$4(AccessibleDetail.this, this$0, z16, shouldShowGuideTip, z17);
            }
        });
        if (accessibleDetail.isAccessible()) {
            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).preLoadCoreDatas();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkZPlanEntrance$lambda$6$lambda$5$lambda$4(AccessibleDetail accessibleDetail, ZPlanBadgeManagerImpl this$0, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (accessibleDetail.isAccessible()) {
            QLog.i(TAG, 1, "updateEntranceBtn, ZplanAccessable ZPALN_IN_WHITE_LIST ");
            this$0.isEntranceShow = true;
            this$0.updateEntranceUI(z16);
            this$0.getEntryInfo(z17, z18);
            return;
        }
        QLog.i(TAG, 1, "updateEntranceBtn, ZplanAccessable ZPALN_NOT_IN_WHITE_LIST ");
        this$0.updateEntranceUI(z16);
    }

    private final void doDnsAsyncForSquareIfNeed(ow4.b entry) {
        if (entry.f424389a == 4) {
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.o
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBadgeManagerImpl.doDnsAsyncForSquareIfNeed$lambda$31();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doDnsAsyncForSquareIfNeed$lambda$31() {
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).doDns();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface getApp() {
        return bb.f335811a.j();
    }

    private final void getEntryInfo(boolean needGuide, boolean isFromBanner) {
        ow4.b bVar = this.curEntry;
        if (isFromBanner && bVar != null && !isChangeUser()) {
            QLog.i(TAG, 1, "getEntryInfo isFromBanner:  " + isFromBanner);
            updateEntryInfo(bVar);
            ImageView imageView = this.entranceIcon;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(0);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        this.zplanEntryService.e(needGuide, new c(new WeakReference(this), currentUin));
    }

    private final void getRedTouchAppInfoAsyncAndRefreshUI(String adId, boolean needGuide, long delay) {
        if (adId.length() == 0) {
            QLog.e(TAG, 1, "asyncGetRedTouchInfoAndRefresh, adId is empty return!!");
        } else {
            v.f335848a.c(15, adId, delay, new ZPlanBadgeManagerImpl$getRedTouchAppInfoAsyncAndRefreshUI$1(this, needGuide));
        }
    }

    private final void handleBubbleAd(BusinessInfoCheckUpdate.AppInfo redDotAppInfo) {
        QLog.i(TAG, 1, "handleBubbleAd, enter");
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = redDotAppInfo.red_display_info;
        v vVar = v.f335848a;
        if (showTipsView$default(this, vVar.k(redDisplayInfo, 4, ""), vVar.i(redDisplayInfo, 11, 0), false, 0, 12, null)) {
            this.hasBubbleAd = true;
            QLog.i(TAG, 1, "handleBubbleAd, finish");
            redTouchExposure(redDotAppInfo);
        }
    }

    private final void handleZplanClickEvent(View view) {
        if (this.fastClickUtils.a()) {
            return;
        }
        boolean hasRedTouch = RedTouch.hasRedTouch(this.redDotAppInfo);
        boolean needClickReport = needClickReport(view);
        boolean z16 = false;
        if (needClickReport) {
            QQAppInterface app = getApp();
            Intrinsics.checkNotNull(app);
            IRuntimeService runtimeService = app.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app!!.getRuntimeService(\u2026va, ProcessConstant.MAIN)");
            IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
            BusinessInfoCheckUpdate.AppInfo appInfo = this.redDotAppInfo;
            if (appInfo != null && appInfo.type.get() != 3) {
                iRedTouchManager.onRedTouchItemClick(appInfo, null);
                appInfo.iNewFlag.set(0);
            }
            QLog.i(TAG, 1, "zplan button on onRedTouchItemClick");
        }
        clickJump(hasRedTouch, needClickReport);
        getRedTouchAppInfoAsyncAndRefreshUI(this.adId, true, 500L);
        ZPlanBrandAnimHelper zPlanBrandAnimHelper = this.brandAnimHelper;
        if (zPlanBrandAnimHelper != null) {
            zPlanBrandAnimHelper.i();
        }
        ow4.b bVar = this.curEntry;
        if (bVar != null && bVar.f424389a == 4) {
            z16 = true;
        }
        if (z16) {
            IZootopiaReportApi iZootopiaReportApi = this.reportApi;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_action_type", "click");
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_main_square");
            Unit unit = Unit.INSTANCE;
            iZootopiaReportApi.reportEvent("ev_zplan_external_entrance_action", linkedHashMap);
            return;
        }
        rj3.b.f431586a.a(this.redDotAppInfo, this.hasRedDot, this.hasRedNum, this.hasBubbleAd);
    }

    private final boolean isChangeUser() {
        String str = this.requestUin;
        if (str == null) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (Intrinsics.areEqual(str, peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null)) {
            return false;
        }
        QLog.e(TAG, 1, "request uin is " + this.requestUin);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (r0.hasRedTouch() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean needClickReport(View view) {
        boolean z16;
        RedTouch redTouch = this.redTouch;
        if (view != redTouch) {
            if (redTouch != null) {
                Intrinsics.checkNotNull(redTouch);
            }
            z16 = false;
            boolean z17 = !this.hasBubbleAd && (this.bubbleDismissTime == 0 || System.currentTimeMillis() - this.bubbleDismissTime < 500);
            QLog.i(TAG, 1, "needClickReport hasRed " + z16 + " hasShowBubbleAd " + z17);
            return !z16 || z17;
        }
        z16 = true;
        if (this.hasBubbleAd) {
        }
        QLog.i(TAG, 1, "needClickReport hasRed " + z16 + " hasShowBubbleAd " + z17);
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAccountChanged$lambda$25(ZPlanBadgeManagerImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkAccessibleAndUpdateEntranceBtn(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$10(ZPlanBadgeManagerImpl this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkAccessibleAndUpdateEntranceBtn(true, z16);
    }

    private final void redTouchExposure(BusinessInfoCheckUpdate.AppInfo redInfo) {
        IRedTouchManager iRedTouchManager;
        QQAppInterface app = getApp();
        if (app == null || (iRedTouchManager = (IRedTouchManager) app.getRuntimeService(IRedTouchManager.class, "")) == null) {
            return;
        }
        iRedTouchManager.onRedTouchItemExposure(redInfo, null);
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        appInfo.set(redInfo);
        int i3 = appInfo.exposure_max.get() - 1;
        if (i3 == 0) {
            i3 = -1;
        }
        appInfo.exposure_max.set(i3);
        iRedTouchManager.updateAppInfo(appInfo, false);
    }

    private final void reportChatBotImp() {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", "em_bas_agent_entry");
        hashMap.put("qq_pgid", "pg_bas_msglist");
        hashMap.put("qq_pgstp", 1);
        hashMap.put("qq_ref_pgid", PageUtils.VR_PAGE_NONE);
        QQAppInterface app = getApp();
        String currentUid = app != null ? app.getCurrentUid() : null;
        String str = "";
        if (currentUid == null) {
            currentUid = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(currentUid, "app?.currentUid ?: \"\"");
        }
        hashMap.put("uid", currentUid);
        QQAppInterface app2 = getApp();
        String currentUin = app2 != null ? app2.getCurrentUin() : null;
        if (currentUin != null) {
            Intrinsics.checkNotNullExpressionValue(currentUin, "app?.currentUin ?: \"\"");
            str = currentUin;
        }
        hashMap.put("home_uin", str);
        hashMap.put("msglist_type", 0);
        VideoReport.reportEvent("qq_imp", hashMap);
    }

    private final void reportSquareImp() {
        ow4.b bVar = this.curEntry;
        if (bVar == null || isChangeUser()) {
            return;
        }
        IZootopiaReportApi iZootopiaReportApi = this.reportApi;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_action_type", "imp");
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_main_square");
        ow4.a aVar = bVar.f424391c;
        int i3 = 0;
        if (!TextUtils.isEmpty(aVar != null ? aVar.f424387a : null)) {
            ow4.a aVar2 = bVar.f424391c;
            if ((aVar2 != null ? aVar2.f424388b : 0) > 0 && !this.isReportBubble) {
                i3 = 1;
                this.isReportBubble = true;
            }
        }
        linkedHashMap.put("zplan_have_new_bubble", Integer.valueOf(i3));
        Unit unit = Unit.INSTANCE;
        iZootopiaReportApi.reportEvent("ev_zplan_external_entrance_action", linkedHashMap);
    }

    private final void safelyCloseTipsIfShowing() {
        if (checkIsTipsShowing()) {
            try {
                com.tencent.mobileqq.zplan.aio.badge.k kVar = this.zplanEntranceTips;
                if (kVar != null) {
                    kVar.b();
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "safelyCloseTipsWindow, err", th5);
            }
        }
    }

    private final String safelyEncodeString(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "safelyEncodeString.", th5);
            return null;
        }
    }

    private final synchronized void saveGuideTipSp(long uin) {
        cl.j(BaseApplication.getContext(), uin + "_zplan_entrance_tip_sp_key", "1");
    }

    private final void setAdId(ow4.b entry) {
        if (TextUtils.isEmpty(entry.f424393e)) {
            return;
        }
        String str = this.adId;
        String str2 = entry.f424393e;
        Intrinsics.checkNotNullExpressionValue(str2, "entry.adId");
        this.adId = str2;
        if (Intrinsics.areEqual(str, str2)) {
            return;
        }
        getRedTouchAppInfoAsyncAndRefreshUI$default(this, this.adId, false, 0L, 6, null);
    }

    private final void setEntryIcon(ow4.b entry) {
        int i3 = entry.f424389a;
        if (i3 == -1) {
            ImageView imageView = this.entranceIcon;
            if (imageView != null) {
                imageView.setImageResource(TokenResUtils.getTokenRes(R.drawable.qui_robot, R.drawable.qui_robot));
            }
        } else if (i3 == 2 || i3 == 3) {
            ImageView imageView2 = this.entranceIcon;
            if (imageView2 != null) {
                imageView2.setImageResource(TokenResUtils.getTokenRes(R.drawable.f159793gq3, R.drawable.gp7));
            }
        } else if (i3 != 4) {
            ImageView imageView3 = this.entranceIcon;
            if (imageView3 != null) {
                imageView3.setImageResource(TokenResUtils.getTokenRes(R.drawable.lvg, R.drawable.qui_super_qq_show_icon_navigation_01_selector));
            }
        } else {
            if (this.hasUpdateVisibility) {
                reportSquareImp();
            }
            ImageView imageView4 = this.entranceIcon;
            if (imageView4 != null) {
                imageView4.setImageResource(TokenResUtils.getTokenRes(R.drawable.f159794gq4, R.drawable.gpc));
            }
        }
        if (QQTheme.isNowThemeIsSuperTheme()) {
            ImageView imageView5 = this.entranceIcon;
            if (imageView5 != null) {
                imageView5.setColorFilter((ColorFilter) null);
            }
        } else {
            Integer num = this.curColorFilter;
            if (num != null) {
                int intValue = num.intValue();
                ImageView imageView6 = this.entranceIcon;
                if (imageView6 != null) {
                    imageView6.setColorFilter(intValue);
                }
            }
        }
        Integer num2 = this.curAlpha;
        if (num2 != null) {
            int intValue2 = num2.intValue();
            ImageView imageView7 = this.entranceIcon;
            if (imageView7 != null) {
                imageView7.setAlpha(intValue2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldForceShowChatAIEntrance() {
        return false;
    }

    private final synchronized boolean shouldShowGuideTip(long uin) {
        boolean z16;
        String d16 = cl.d(BaseApplication.getContext(), uin + "_zplan_entrance_tip_sp_key");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isShowBubble");
        sb5.append(uin);
        z16 = false;
        boolean z17 = !from.decodeBool(sb5.toString(), false);
        QLog.i(TAG, 1, "shouldShowGuideTip, value=" + d16 + " needShow=" + z17);
        if (TextUtils.isEmpty(d16) && z17) {
            z16 = true;
        }
        return z16;
    }

    private final void showBubbleIfNeed(ow4.b entry) {
        ow4.a aVar = entry.f424391c;
        if (aVar == null || TextUtils.isEmpty(aVar.f424387a) || aVar.f424388b <= 0) {
            return;
        }
        QQAppInterface app = getApp();
        long longAccountUin = app != null ? app.getLongAccountUin() : 0L;
        String str = aVar.f424387a;
        Intrinsics.checkNotNullExpressionValue(str, "bubble.text");
        showGuideTips(longAccountUin, str, aVar.f424388b);
    }

    private final void showGuideTips(final long uin, final String txt, final int time) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanBadgeManagerImpl.showGuideTips$lambda$8(ZPlanBadgeManagerImpl.this, uin, txt, time);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGuideTips$lambda$8(final ZPlanBadgeManagerImpl this$0, long j3, final String txt, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(txt, "$txt");
        if (this$0.isEntranceShow && this$0.shouldShowGuideTip(j3)) {
            View view = this$0.entranceContainer;
            boolean z16 = false;
            if (view != null && view.getVisibility() == 8) {
                z16 = true;
            }
            long j16 = z16 ? 80L : 0L;
            final long j17 = j16;
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBadgeManagerImpl.showGuideTips$lambda$8$lambda$7(ZPlanBadgeManagerImpl.this, txt, i3, j17);
                }
            }, j16);
            this$0.saveGuideTipSp(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGuideTips$lambda$8$lambda$7(ZPlanBadgeManagerImpl this$0, String txt, int i3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(txt, "$txt");
        QLog.i(TAG, 1, "showGuideTips, delay:" + j3 + ", result:" + showTipsView$default(this$0, txt, i3, true, 0, 8, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNumRedDot(final int num) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanBadgeManagerImpl.showNumRedDot$lambda$9(ZPlanBadgeManagerImpl.this, num);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNumRedDot$lambda$9(ZPlanBadgeManagerImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.numRedDot == null) {
            return;
        }
        QLog.i(TAG, 1, "showNumRedDot, num:" + i3);
        TextView textView = this$0.numRedDot;
        Intrinsics.checkNotNull(textView);
        textView.setText(this$0.getShowNum(i3));
        RedWidgetUtil.fixTextViewLayout(this$0.numRedDot, i3, 99, R.drawable.skin_tips_newmessage);
        if (i3 <= 0) {
            adjustVisibility$default(this$0, "showNum-0", null, null, 8, null, null, 54, null);
            return;
        }
        RedTouch redTouch = this$0.redTouch;
        if (redTouch != null) {
            redTouch.clearRedTouch();
        }
        adjustVisibility$default(this$0, "showNum", 0, null, 0, 8, null, 36, null);
        ZPlanBrandAnimHelper zPlanBrandAnimHelper = this$0.brandAnimHelper;
        if (zPlanBrandAnimHelper != null) {
            zPlanBrandAnimHelper.i();
        }
        com.tencent.mobileqq.zplan.aio.badge.i iVar = this$0.normalAnimHelper;
        if (iVar != null) {
            iVar.e();
        }
        this$0.hasRedNum = true;
    }

    private final boolean showTipsView(final String text, final int lifeTime, final boolean ignoreCheckForeground, final int type) {
        com.tencent.mobileqq.zplan.aio.badge.c cVar;
        if (!canShowTips(ignoreCheckForeground, type)) {
            this.pendingShowTipsRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.l
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBadgeManagerImpl.showTipsView$lambda$20(ZPlanBadgeManagerImpl.this, text, lifeTime, ignoreCheckForeground, type);
                }
            };
            return false;
        }
        safelyCloseTipsIfShowing();
        if (type == 2) {
            cVar = new com.tencent.mobileqq.zplan.aio.badge.a(type, text, lifeTime, v.f335848a.h(this.redDotAppInfo, "head_uins"));
        } else {
            cVar = new com.tencent.mobileqq.zplan.aio.badge.c(type, text, lifeTime);
        }
        QLog.i(TAG, 1, "showTipsView: data = " + cVar);
        QQAppInterface app = getApp();
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        com.tencent.mobileqq.zplan.aio.badge.k kVar = new com.tencent.mobileqq.zplan.aio.badge.k(app, activity, cVar);
        this.bubbleDismissTime = 0L;
        kVar.e(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.zplan.aio.impl.m
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ZPlanBadgeManagerImpl.showTipsView$lambda$23$lambda$21(ZPlanBadgeManagerImpl.this);
            }
        });
        if (type == 2) {
            kVar.d(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.impl.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanBadgeManagerImpl.showTipsView$lambda$23$lambda$22(ZPlanBadgeManagerImpl.this, view);
                }
            });
        }
        kVar.f(this.entranceContainer);
        this.zplanEntranceTips = kVar;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTipsView$lambda$20(ZPlanBadgeManagerImpl this$0, String text, int i3, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(text, "$text");
        if (this$0.showTipsView(text, i3, z16, i16)) {
            QLog.i(TAG, 1, "show tipsView => " + text + ", type\uff1a " + i16);
            this$0.pendingShowTipsRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTipsView$lambda$23$lambda$21(ZPlanBadgeManagerImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bubbleDismissTime = System.currentTimeMillis();
        QLog.i(TAG, 1, "bubble dismiss");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTipsView$lambda$23$lambda$22(ZPlanBadgeManagerImpl this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RedTouch redTouch = this$0.redTouch;
        if (redTouch != null) {
            redTouch.performClick();
        }
        this$0.safelyCloseTipsIfShowing();
    }

    private final String tryRebuildSchemeForOpenSmallHome(String jumpUrl, String tianshuAdId) {
        boolean startsWith;
        boolean contains;
        startsWith = StringsKt__StringsJVMKt.startsWith(jumpUrl, WadlProxyConsts.HIPPY_OPEN_SCHEME, true);
        if (startsWith) {
            contains = StringsKt__StringsKt.contains((CharSequence) jumpUrl, (CharSequence) "tryLaunchSmallHomeFirst=true", true);
            if (contains) {
                String safelyEncodeString = safelyEncodeString(jumpUrl);
                if (safelyEncodeString == null) {
                    return jumpUrl;
                }
                ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                ZootopiaSource a16 = ZootopiaSource.INSTANCE.a(Source.Conversation);
                Bundle bundle = new Bundle();
                bundle.putBoolean("openDetailNotReady", true);
                bundle.putInt("openDetailType", 1);
                bundle.putString("openDetailScheme", safelyEncodeString);
                Unit unit = Unit.INSTANCE;
                return iSchemeApi.buildMapScheme(a16, AdMetricID.Click.SUCCESS, bundle);
            }
        }
        if (tianshuAdId == null) {
            return jumpUrl;
        }
        ISchemeApi iSchemeApi2 = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString("tianshuID", tianshuAdId);
        Unit unit2 = Unit.INSTANCE;
        return iSchemeApi2.appendPageDataToScheme(jumpUrl, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEntranceUI(boolean isFirstTime) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "updateEntranceUI:" + isFirstTime);
        }
        ConversationTitleBtnCtrl conversationTitleBtnCtrl = this.titleBtnCtrl;
        if (conversationTitleBtnCtrl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBtnCtrl");
            conversationTitleBtnCtrl = null;
        }
        conversationTitleBtnCtrl.x(isFirstTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEntryInfo(ow4.b entry) {
        int i3 = entry.f424389a;
        String str = entry.f424393e;
        ow4.a aVar = entry.f424391c;
        QLog.i(TAG, 1, "updateEntryInfo, use entry " + i3 + " " + str + " " + (aVar != null ? aVar.f424387a : null) + " " + (aVar != null ? Integer.valueOf(aVar.f424388b) : null));
        if (!Intrinsics.areEqual(this.curEntry, entry)) {
            this.curEntry = entry;
        }
        setEntryIcon(entry);
        doDnsAsyncForSquareIfNeed(entry);
        setAdId(entry);
        showBubbleIfNeed(entry);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void hideEntrance() {
        QLog.i(TAG, 1, "hideEntrance\uff0c entranceShow:" + this.isEntranceShow);
        this.isEntranceShow = false;
        hideAllViews();
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void init(Activity act, Object conversationTitleBtnCtrl) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(conversationTitleBtnCtrl, "conversationTitleBtnCtrl");
        this.activity = act;
        this.titleBtnCtrl = (ConversationTitleBtnCtrl) conversationTitleBtnCtrl;
        uk3.g.f439121a.d(1001L, this.accessibleChangeListener);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    /* renamed from: isEntranceShow, reason: from getter */
    public boolean getIsEntranceShow() {
        return this.isEntranceShow;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void onBeforeAccountChanged() {
        QQAppInterface app = getApp();
        if (app != null) {
            app.removeObserver(this.requestObserver);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        QLog.i(TAG, 1, "startPortalActivity");
        handleZplanClickEvent(v3);
        this.hasRedDot = false;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void onCreateView(View parentView, final boolean isFromBanner) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        QLog.i(TAG, 1, "onCreateView, parentView:" + parentView + ", isFromBanner:" + isFromBanner);
        this.entranceContainer = parentView.findViewById(R.id.u9c);
        View findViewById = parentView.findViewById(R.id.u9d);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        this.entranceIcon = imageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(TokenResUtils.getTokenRes(R.drawable.lvg, R.drawable.qui_super_qq_show_icon_navigation_01_selector));
        ImageView imageView2 = this.entranceIcon;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setVisibility(4);
        View findViewById2 = parentView.findViewById(R.id.u9e);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.animImageView = (ImageView) findViewById2;
        this.normalRedDot = parentView.findViewById(R.id.f126807pr);
        View findViewById3 = parentView.findViewById(R.id.u9f);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.numRedDot = (TextView) findViewById3;
        this.redTouch = new RedTouch(parentView.getContext(), this.entranceContainer).setGravity(53).applyTo();
        View view = this.entranceContainer;
        Intrinsics.checkNotNull(view);
        view.setOnClickListener(this);
        RedTouch redTouch = this.redTouch;
        Intrinsics.checkNotNull(redTouch);
        redTouch.setOnClickListener(this);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanBadgeManagerImpl.onCreateView$lambda$10(ZPlanBadgeManagerImpl.this, isFromBanner);
            }
        });
        QQAppInterface app = getApp();
        if (app != null) {
            app.addObserver(this.requestObserver);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void onDestroy() {
        QQAppInterface app = getApp();
        if (app != null) {
            app.removeObserver(this.requestObserver);
        }
        com.tencent.mobileqq.zplan.aio.badge.i iVar = this.normalAnimHelper;
        if (iVar != null) {
            iVar.e();
        }
        ZPlanBrandAnimHelper zPlanBrandAnimHelper = this.brandAnimHelper;
        if (zPlanBrandAnimHelper != null) {
            zPlanBrandAnimHelper.i();
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void onPause() {
        QLog.i(TAG, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.paused = true;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void onPostThemeChanged() {
        com.tencent.mobileqq.zplan.aio.badge.i iVar = this.normalAnimHelper;
        if (iVar != null) {
            iVar.k();
        }
        ZPlanBrandAnimHelper zPlanBrandAnimHelper = this.brandAnimHelper;
        if (zPlanBrandAnimHelper != null) {
            zPlanBrandAnimHelper.p();
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void refreshRedTouch() {
        getRedTouchAppInfoAsyncAndRefreshUI$default(this, this.adId, false, 0L, 6, null);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void resetVisibility() {
        QLog.d(TAG, 1, "resetVisibility, entranceShow:" + this.isEntranceShow);
        if (this.isEntranceShow) {
            return;
        }
        hideAllViews();
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void setTitleEntranceImageAlpha(int alpha) {
        this.curAlpha = Integer.valueOf(alpha);
        ImageView imageView = this.entranceIcon;
        if (imageView != null) {
            imageView.setAlpha(alpha);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void setTitleEntranceImageColorFilter(int color) {
        QLog.i(TAG, 1, "setTitleEntranceImageColorFilter " + color + "!");
        this.curColorFilter = Integer.valueOf(color);
        ImageView imageView = this.entranceIcon;
        if (imageView != null) {
            imageView.setColorFilter(color);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        if ((r0 != null && r0.getVisibility() == 0) == false) goto L33;
     */
    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateVisibility() {
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        QLog.d(TAG, 1, "updateVisibility enter, entranceShow:" + this.isEntranceShow + ", isStudyMode:" + studyModeSwitch);
        if (studyModeSwitch && ZPlanQQMC.INSTANCE.enableBadgeVisibilityControlByStudyMode()) {
            QLog.i(TAG, 1, "hideAllViews for studyMode!");
            hideAllViews();
            return;
        }
        if (!this.isEntranceShow) {
            hideAllViews();
            return;
        }
        ImageView imageView = this.animImageView;
        if (!(imageView != null && imageView.getVisibility() == 0)) {
            RedTouch redTouch = this.redTouch;
            if (redTouch != null && redTouch.getVisibility() == 0) {
                View view = this.entranceContainer;
            }
            adjustVisibility$default(this, "updateVisit", 0, 0, null, null, null, 56, null);
        }
        this.hasUpdateVisibility = true;
        if (this.entranceContainer != null) {
            ImageView imageView2 = this.entranceIcon;
            if (imageView2 != null && imageView2.getVisibility() == 0) {
                ow4.b bVar = this.curEntry;
                if (bVar != null && bVar.f424389a == 4) {
                    reportSquareImp();
                } else {
                    if (isChangeUser()) {
                        return;
                    }
                    rj3.b.f431586a.b(this.redDotAppInfo, this.hasRedDot, this.hasRedNum, this.hasBubbleAd);
                }
            }
        }
    }

    private final void hideAllViews() {
        QLog.d(TAG, 1, "hideAllViews");
        View view = this.entranceContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        RedTouch redTouch = this.redTouch;
        if (redTouch != null) {
            redTouch.setVisibility(8);
        }
        TextView textView = this.numRedDot;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.animImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view2 = this.normalRedDot;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        safelyCloseTipsIfShowing();
    }

    private final void showAIChatIcon(boolean isFirstTime, String uin) {
        this.isEntranceShow = true;
        updateEntranceUI(isFirstTime);
        this.requestUin = uin;
        ow4.b bVar = new ow4.b();
        bVar.f424389a = -1;
        bVar.f424392d = "mqqapi://adelie/open_home?source=1";
        updateEntryInfo(bVar);
        ImageView imageView = this.entranceIcon;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void onAccountChanged() {
        QLog.i(TAG, 1, "onAccountChanged enter!");
        hideEntrance();
        updateEntryInfo(new ow4.b());
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanBadgeManagerImpl.onAccountChanged$lambda$25(ZPlanBadgeManagerImpl.this);
            }
        });
        QQAppInterface app = getApp();
        if (app != null) {
            app.addObserver(this.requestObserver);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager
    public void onResume() {
        QLog.i(TAG, 1, "onResume");
        this.paused = false;
        Runnable runnable = this.pendingShowTipsRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final String getShowNum(int num) {
        if (num <= 0) {
            return "";
        }
        if (num > 99) {
            return "99+";
        }
        return String.valueOf(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleExtendTips(BusinessInfoCheckUpdate.AppInfo info) {
        PBUInt32Field pBUInt32Field;
        v vVar = v.f335848a;
        int i3 = vVar.i(info != null ? info.red_display_info : null, 24, 0);
        QLog.i(TAG, 1, "handleExtendTips, type:" + ((info == null || (pBUInt32Field = info.type) == null) ? null : Integer.valueOf(pBUInt32Field.get())) + ", hasTips:" + i3);
        if (i3 == 0) {
            return;
        }
        String l3 = v.l(vVar, info != null ? info.red_display_info : null, 26, null, 4, null);
        int i16 = vVar.i(info != null ? info.red_display_info : null, 11, 15);
        if (l3 == null || l3.length() == 0) {
            QLog.d(TAG, 1, "handleExtendTips, content isNullOrEmpty");
            return;
        }
        QLog.d(TAG, 1, "handleExtendTips, showed:" + showTipsView$default(this, l3, i16, false, i3, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRefreshRedTouch(BusinessInfoCheckUpdate.AppInfo newRedInfo, boolean needClear) {
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        if (this.entranceContainer != null && this.redTouch != null) {
            ImageView imageView = this.animImageView;
            adjustVisibility$default(this, "refresh", null, Integer.valueOf(imageView != null && imageView.getVisibility() == 0 ? 4 : 0), null, null, null, 58, null);
            BusinessInfoCheckUpdate.AppInfo appInfo = this.redDotAppInfo;
            if (isClearNum(newRedInfo)) {
                TextView textView = this.numRedDot;
                if (!(textView != null && textView.getVisibility() == 0)) {
                    if (!needClear) {
                        QLog.i(TAG, 1, "rec clearNumRed but not show numRed");
                        redTouchExposure(newRedInfo);
                        return;
                    }
                    boolean hasRedTouch = RedTouch.hasRedTouch(appInfo);
                    RedTouch redTouch = this.redTouch;
                    Intrinsics.checkNotNull(redTouch);
                    boolean hasRedTouch2 = redTouch.hasRedTouch();
                    QLog.i(TAG, 1, "rec clearNumRed but not show numRed now " + hasRedTouch + " " + hasRedTouch2);
                    if (!hasRedTouch && hasRedTouch2) {
                        RedTouch redTouch2 = this.redTouch;
                        Intrinsics.checkNotNull(redTouch2);
                        redTouch2.clearRedTouch();
                        ImageView imageView2 = this.animImageView;
                        if (!(imageView2 != null && imageView2.getVisibility() == 0)) {
                            adjustVisibility$default(this, "refresh-clear", 0, null, null, null, null, 60, null);
                        }
                    }
                    redTouchExposure(newRedInfo);
                    return;
                }
            }
            Activity activity = null;
            if (!Intrinsics.areEqual((newRedInfo == null || (pBUInt32Field2 = newRedInfo.modify_ts) == null) ? null : Integer.valueOf(pBUInt32Field2.get()), (appInfo == null || (pBUInt32Field = appInfo.modify_ts) == null) ? null : Integer.valueOf(pBUInt32Field.get())) || needClear) {
                this.redDotAppInfo = newRedInfo;
                boolean hasRedTouch3 = RedTouch.hasRedTouch(newRedInfo);
                RedTouch redTouch3 = this.redTouch;
                Intrinsics.checkNotNull(redTouch3);
                boolean hasRedTouch4 = redTouch3.hasRedTouch();
                if (!hasRedTouch3) {
                    if (hasRedTouch4) {
                        QLog.i(TAG, 1, "refreshRedTouch, red point need clear");
                        RedTouch redTouch4 = this.redTouch;
                        Intrinsics.checkNotNull(redTouch4);
                        redTouch4.clearRedTouch();
                        ImageView imageView3 = this.animImageView;
                        if (imageView3 != null && imageView3.getVisibility() == 0) {
                            return;
                        }
                        adjustVisibility$default(this, "refresh-clear", 0, null, null, null, null, 60, null);
                        return;
                    }
                    return;
                }
                BusinessInfoCheckUpdate.AppInfo appInfo2 = this.redDotAppInfo;
                Intrinsics.checkNotNull(appInfo2);
                int i3 = appInfo2.type.get();
                if (i3 == 0) {
                    adjustVisibility$default(this, "type-0", 0, null, 8, 8, null, 36, null);
                    RedTouch redTouch5 = this.redTouch;
                    Intrinsics.checkNotNull(redTouch5);
                    redTouch5.parseRedTouch(this.redDotAppInfo);
                    com.tencent.mobileqq.zplan.aio.badge.i iVar = this.normalAnimHelper;
                    if (iVar != null) {
                        iVar.e();
                    }
                    ZPlanBrandAnimHelper zPlanBrandAnimHelper = this.brandAnimHelper;
                    if (zPlanBrandAnimHelper != null) {
                        zPlanBrandAnimHelper.i();
                    }
                    if (!com.tencent.mobileqq.zplan.aio.badge.i.INSTANCE.a(appInfo, this.redDotAppInfo)) {
                        handleExtendTips(this.redDotAppInfo);
                    }
                } else if (i3 == 3) {
                    v vVar = v.f335848a;
                    BusinessInfoCheckUpdate.AppInfo appInfo3 = this.redDotAppInfo;
                    Intrinsics.checkNotNull(appInfo3);
                    showNumRedDot(vVar.i(appInfo3.red_display_info, 4, 0));
                } else if (i3 == 18) {
                    if (this.normalAnimHelper == null) {
                        Activity activity2 = this.activity;
                        if (activity2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                        } else {
                            activity = activity2;
                        }
                        this.normalAnimHelper = new com.tencent.mobileqq.zplan.aio.badge.i(activity, this.animImageView, new d());
                    }
                    ZPlanBrandAnimHelper zPlanBrandAnimHelper2 = this.brandAnimHelper;
                    if (zPlanBrandAnimHelper2 != null) {
                        zPlanBrandAnimHelper2.i();
                    }
                    com.tencent.mobileqq.zplan.aio.badge.i iVar2 = this.normalAnimHelper;
                    if (iVar2 != null) {
                        iVar2.h(this.redDotAppInfo, this.redTouch);
                    }
                } else if (i3 == 21) {
                    BusinessInfoCheckUpdate.AppInfo appInfo4 = this.redDotAppInfo;
                    Intrinsics.checkNotNull(appInfo4);
                    handleBubbleAd(appInfo4);
                    return;
                } else if (i3 == 22) {
                    TextView textView2 = this.numRedDot;
                    if (textView2 != null && textView2.getVisibility() == 0) {
                        QLog.w(TAG, 1, "has numRedDot, ignore");
                        return;
                    }
                    if (this.brandAnimHelper == null) {
                        this.brandAnimHelper = new ZPlanBrandAnimHelper(this.animImageView, new e());
                    }
                    com.tencent.mobileqq.zplan.aio.badge.i iVar3 = this.normalAnimHelper;
                    if (iVar3 != null) {
                        iVar3.e();
                    }
                    ZPlanBrandAnimHelper zPlanBrandAnimHelper3 = this.brandAnimHelper;
                    if (zPlanBrandAnimHelper3 != null) {
                        zPlanBrandAnimHelper3.k(this.redDotAppInfo, this.redTouch);
                    }
                }
                this.hasBubbleAd = false;
                this.hasRedDot = true;
                BusinessInfoCheckUpdate.AppInfo appInfo5 = this.redDotAppInfo;
                if (appInfo5 != null) {
                    redTouchExposure(appInfo5);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "refreshRedTouch, not inited");
    }

    private final boolean isClearNum(BusinessInfoCheckUpdate.AppInfo info) {
        return info != null && info.type.get() == 3 && v.f335848a.i(info.red_display_info, 4, 0) <= 0;
    }

    static /* synthetic */ void showGuideTips$default(ZPlanBadgeManagerImpl zPlanBadgeManagerImpl, long j3, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "\u62a2\u9c9c\u4f53\u9a8c\u8d85\u7ea7QQ\u79c0";
        }
        if ((i16 & 4) != 0) {
            i3 = 15;
        }
        zPlanBadgeManagerImpl.showGuideTips(j3, str, i3);
    }

    private final void clickJump(boolean isNewRedDot, boolean haveShowRedTouch) {
        String addParameter;
        String e16 = (haveShowRedTouch || isNewRedDot) ? v.f335848a.e(this.redDotAppInfo) : null;
        QLog.i(TAG, 1, "tianshuAdID: " + e16 + ", isNewRedDot: " + isNewRedDot + ", haveShowRedTouch: " + haveShowRedTouch);
        ow4.b bVar = this.curEntry;
        if (bVar != null && !TextUtils.isEmpty(bVar.f424392d)) {
            String jumpUrl = bVar.f424392d;
            if (bVar.f424389a == 4 && isNewRedDot) {
                long g16 = v.f335848a.g(this.redDotAppInfo, "target_uin");
                if (g16 == 0) {
                    addParameter = bVar.f424392d;
                } else {
                    addParameter = URLUtil.addParameter(bVar.f424392d, LauncherConst.KEY_LOCATE_TO_UIN, String.valueOf(g16));
                }
                jumpUrl = addParameter;
            }
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
            String jumpUrl2 = tryRebuildSchemeForOpenSmallHome(jumpUrl, e16);
            QLog.i(TAG, 1, "zplan button on click launchScheme " + bVar.f424392d + ", " + jumpUrl2);
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            Intrinsics.checkNotNullExpressionValue(jumpUrl2, "jumpUrl");
            iZPlanApi.launchScheme(context, jumpUrl2);
            return;
        }
        QLog.i(TAG, 1, "zplan button on click startPortalActivity");
        Bundle bundle = new Bundle();
        bundle.putBoolean("needShowGuide", true);
        if (e16 != null) {
            bundle.putString("tianshuID", e16);
        }
        IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
        BaseApplication context2 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        iZootopiaApi.startPortalActivity(context2, ZootopiaSource.INSTANCE.a(Source.Conversation), bundle);
    }

    static /* synthetic */ boolean showTipsView$default(ZPlanBadgeManagerImpl zPlanBadgeManagerImpl, String str, int i3, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            z16 = false;
        }
        if ((i17 & 8) != 0) {
            i16 = 1;
        }
        return zPlanBadgeManagerImpl.showTipsView(str, i3, z16, i16);
    }

    static /* synthetic */ void getRedTouchAppInfoAsyncAndRefreshUI$default(ZPlanBadgeManagerImpl zPlanBadgeManagerImpl, String str, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        zPlanBadgeManagerImpl.getRedTouchAppInfoAsyncAndRefreshUI(str, z16, j3);
    }

    static /* synthetic */ void adjustVisibility$default(ZPlanBadgeManagerImpl zPlanBadgeManagerImpl, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i3, Object obj) {
        zPlanBadgeManagerImpl.adjustVisibility(str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? null : num4, (i3 & 32) == 0 ? num5 : null);
    }
}
