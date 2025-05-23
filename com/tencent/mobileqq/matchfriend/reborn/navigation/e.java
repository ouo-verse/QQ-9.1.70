package com.tencent.mobileqq.matchfriend.reborn.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.QQStrangerJumpProfilePageEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.QQStrangerMainFragment;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerJumpHomePageEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerOnPostThemeChanged;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.QQStrangerMsgFragment;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerEnableUpdateTabUnreadNumEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionPushEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionUnreadUpdateEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.q;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerScrollToNextUnreadEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.matchfriend.reborn.drag.DragViewProviderPriority;
import com.tencent.mobileqq.matchfriend.reborn.drag.QQStrangerDragLayoutPart;
import com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyEvent;
import com.tencent.mobileqq.matchfriend.reborn.navigation.e;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.matchfriend.reborn.titlebar.QQStrangerOnPageBackEvent;
import com.tencent.mobileqq.matchfriend.reborn.titlebar.QQStrangerTitleUpdateEvent;
import com.tencent.mobileqq.matchfriend.reborn.utils.p;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0004\u008d\u0001\u0091\u0001\u0018\u0000 \u0097\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u0098\u0001B\u0019\u0012\u0006\u0010R\u001a\u00020M\u0012\u0006\u0010U\u001a\u00020\u001e\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0003J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\u0014\u0010\u001d\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0014\u0010\u001f\u001a\u00020\u001b*\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0011H\u0016J\u0012\u00104\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u00109\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u0001052\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010:\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010=\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\b\u0010>\u001a\u00020\rH\u0016J\"\u0010B\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010D\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010E\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010F\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010H\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010L\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040J0Ij\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040J`KH\u0016R\u0017\u0010R\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010aR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010oR\u0016\u0010w\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010uR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010vR\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u00a8\u0006\u0099\u0001"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/navigation/e;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "K9", "", "tabId", "Landroid/view/View;", "G9", "", "Q9", "", "E9", "ea", "aa", "", AdMetricTag.EVENT_NAME, "T9", "Landroid/widget/ImageView;", "iconView", "ca", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$f;", "M9", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/widget/TabLayoutCompat$f;", "ba", "Landroidx/fragment/app/FragmentTransaction;", "id", "Z9", "Landroidx/fragment/app/FragmentManager;", "O9", "Lcom/tencent/mobileqq/app/QBaseFragment;", "J9", "F9", "P9", "Lcom/tencent/mobileqq/matchfriend/reborn/navigation/RedNumTab;", "redNumTab", WidgetCacheConstellationData.NUM, "da", "Y9", "enable", "H9", "S9", "ga", "N9", "R9", "X9", "W9", "L9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/content/Intent;", "newIntent", "onNewIntent", "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "tab", "c", "l3", "J8", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "e", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/tencent/qqnt/kernel/api/aa;", "f", "Lcom/tencent/qqnt/kernel/api/aa;", "recentContactService", h.F, "Lcom/tencent/mobileqq/matchfriend/reborn/navigation/RedNumTab;", "tabRedNum", "i", "Ljava/lang/Integer;", "currentTabId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "mContentView", BdhLogUtil.LogTag.Tag_Conn, "bgView", "D", "mainBgView", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "E", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "tabBarView", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/app/QBaseFragment;", "currentFragment", "G", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$f;", "mainTab", "H", "profileTab", "I", "msgTab", "J", "Z", "mainTabCreate", "", "K", "initRedTouchTimestamp", "Ll82/b;", "L", "Ll82/b;", "mainBubbleGuideElement", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "M", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragHost", "N", "enableUpdateTabUnreadNum", "Lcom/tencent/relation/common/servlet/b;", "P", "Lcom/tencent/relation/common/servlet/b;", "relationObserver", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "publishGuideRunnable", "com/tencent/mobileqq/matchfriend/reborn/navigation/e$c", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/matchfriend/reborn/navigation/e$c;", "priorityDragViewProvider", "com/tencent/mobileqq/matchfriend/reborn/navigation/e$b", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/matchfriend/reborn/navigation/e$b;", "expandRecentContactListener", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/fragment/app/FragmentManager;)V", "T", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends Part implements TabLayoutCompat.c, SimpleEventReceiver<SimpleBaseEvent> {
    private static final Integer[] U = {0, 1, 2};
    private static final Map<Integer, Integer> V;
    private static final Map<Integer, Integer> W;

    /* renamed from: C, reason: from kotlin metadata */
    private View bgView;

    /* renamed from: D, reason: from kotlin metadata */
    private View mainBgView;

    /* renamed from: E, reason: from kotlin metadata */
    private TabLayoutCompat tabBarView;

    /* renamed from: F, reason: from kotlin metadata */
    private QBaseFragment currentFragment;

    /* renamed from: G, reason: from kotlin metadata */
    private TabLayoutCompat.f mainTab;

    /* renamed from: H, reason: from kotlin metadata */
    private TabLayoutCompat.f profileTab;

    /* renamed from: I, reason: from kotlin metadata */
    private TabLayoutCompat.f msgTab;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mainTabCreate;

    /* renamed from: K, reason: from kotlin metadata */
    private long initRedTouchTimestamp;

    /* renamed from: L, reason: from kotlin metadata */
    private l82.b mainBubbleGuideElement;

    /* renamed from: M, reason: from kotlin metadata */
    private QUIBadgeDragLayout dragHost;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean enableUpdateTabUnreadNum;

    /* renamed from: P, reason: from kotlin metadata */
    private final com.tencent.relation.common.servlet.b relationObserver;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Runnable publishGuideRunnable;

    /* renamed from: R, reason: from kotlin metadata */
    private final c priorityDragViewProvider;

    /* renamed from: S, reason: from kotlin metadata */
    private b expandRecentContactListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final FragmentManager fragmentManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private aa recentContactService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RedNumTab tabRedNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Integer currentTabId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mContentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/navigation/e$c", "Lcom/tencent/mobileqq/matchfriend/reborn/drag/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/drag/DragViewProviderPriority;", "getPriority", "", "Landroid/view/View;", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements com.tencent.mobileqq.matchfriend.reborn.drag.a {
        c() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.drag.a
        public List<View> a() {
            ArrayList arrayList = new ArrayList();
            RedNumTab redNumTab = e.this.tabRedNum;
            if (redNumTab != null && redNumTab.f().isShown()) {
                arrayList.add(redNumTab.f());
            }
            return arrayList;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.drag.a
        public DragViewProviderPriority getPriority() {
            return DragViewProviderPriority.MSG_TAB;
        }
    }

    static {
        Map<Integer, Integer> mapOf;
        Map<Integer, Integer> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, Integer.valueOf(R.drawable.qui_message)), TuplesKt.to(1, Integer.valueOf(R.drawable.g0s)), TuplesKt.to(2, Integer.valueOf(R.drawable.qui_user)));
        V = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(0, Integer.valueOf(R.drawable.g0z)), TuplesKt.to(1, Integer.valueOf(R.drawable.g0n)), TuplesKt.to(2, Integer.valueOf(R.drawable.f159747g15)));
        W = mapOf2;
    }

    public e(CoroutineScope scope, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.scope = scope;
        this.fragmentManager = fragmentManager;
        this.enableUpdateTabUnreadNum = true;
        this.relationObserver = new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.navigation.c
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                e.V9(e.this, i3, z16, obj);
            }
        };
        this.publishGuideRunnable = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.navigation.d
            @Override // java.lang.Runnable
            public final void run() {
                e.U9(e.this);
            }
        };
        this.priorityDragViewProvider = new c();
        this.expandRecentContactListener = new b();
    }

    private final View G9(int tabId) {
        Integer num = V.get(Integer.valueOf(tabId));
        int intValue = num != null ? num.intValue() : R.drawable.qui_qq;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(ie0.a.f().o(getContext(), intValue, R.color.qui_common_icon_secondary, 1000));
        imageView.setLayoutParams(new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.c_8), getContext().getResources().getDimensionPixelSize(R.dimen.c_8)));
        R9(imageView, tabId);
        return imageView;
    }

    private final void H9(final boolean enable) {
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.navigation.b
            @Override // java.lang.Runnable
            public final void run() {
                e.I9(enable, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(boolean z16, e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("QQStrangerNavigationPart", 2, "enableUpdateTabUnreadNum enable: " + z16);
        }
        this$0.enableUpdateTabUnreadNum = z16;
    }

    private final QBaseFragment J9(int id5) {
        Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(String.valueOf(id5));
        if (findFragmentByTag instanceof QBaseFragment) {
            return (QBaseFragment) findFragmentByTag;
        }
        return null;
    }

    private final QQAppInterface K9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final int L9(int tabId) {
        if (tabId == 0) {
            return 1;
        }
        if (tabId != 1) {
            if (tabId == 2) {
                return 2;
            }
            return 3;
        }
        return 4;
    }

    private final int N9() {
        return (int) QQStrangerRecentContactHelper.f244865a.h();
    }

    private final FragmentTransaction O9(FragmentManager fragmentManager, int i3) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        Integer[] numArr = U;
        ArrayList arrayList = new ArrayList();
        for (Integer num : numArr) {
            if (num.intValue() != i3) {
                arrayList.add(num);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(String.valueOf(((Number) it.next()).intValue()));
            if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
                beginTransaction.hide(findFragmentByTag);
            }
        }
        return beginTransaction;
    }

    private final void P9() {
        String str;
        View view = this.bgView;
        if (view != null) {
            View findViewById = view.findViewById(R.id.on9);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            boolean z16 = QQTheme.isNowThemeIsNight() || QQTheme.isNowThemeSimpleNight();
            view.findViewById(R.id.ona).setBackgroundResource(!z16 ? R.drawable.g1r : R.drawable.f159750g22);
            if (z16) {
                view.findViewById(R.id.ona).setAlpha(0.3f);
            }
            View findViewById2 = view.findViewById(R.id.onc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.qqstranger_bg_texture)");
            if (!z16) {
                str = "https://downv6.qq.com/extendfriend/qqstranger_homepage_texture.png";
            } else {
                str = "https://downv6.qq.com/extendfriend/qqstranger_homepage_texture_night.png";
            }
            p.b(findViewById2, str, null, false, 8, null);
        }
    }

    private final void Q9() {
        View b16;
        TabLayoutCompat.f fVar = this.msgTab;
        if (fVar == null || (b16 = fVar.b()) == null) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        RedNumTab c16 = new RedNumTab(context, b16).j(53).l(-5.0f).k(-13.0f).c();
        QUIBadgeDragLayout qUIBadgeDragLayout = this.dragHost;
        if (qUIBadgeDragLayout != null) {
            c16.setOnModeChangeListener(qUIBadgeDragLayout);
        }
        this.tabRedNum = c16;
        ViewParent parent = b16.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        Object parent2 = viewGroup != null ? viewGroup.getParent() : null;
        ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup2 != null) {
            viewGroup2.setClipChildren(false);
        }
        int N9 = N9();
        QLog.i("QQStrangerNavigationPart", 1, "onInitView initRedTouchView,unread=" + N9);
        RedNumTab redNumTab = this.tabRedNum;
        if (redNumTab != null) {
            da(redNumTab, N9);
            this.initRedTouchTimestamp = System.currentTimeMillis();
        }
    }

    private final void R9(ImageView iconView, int tabId) {
        VideoReport.setElementId(iconView, "em_bas_bottom_tab_entry");
        VideoReport.setElementParam(iconView, EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, Integer.valueOf(L9(tabId)));
        VideoReport.setElementExposePolicy(iconView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(iconView, ClickPolicy.REPORT_NONE);
    }

    private final void S9() {
        Integer num = this.currentTabId;
        if (num != null && num.intValue() == 2) {
            return;
        }
        TabLayoutCompat.f fVar = this.profileTab;
        if (fVar != null) {
            fVar.j();
        }
        QLog.i("QQStrangerNavigationPart", 1, "invoke jump profileTab");
    }

    private final void T9(String eventName) {
        TabLayoutCompat.f fVar;
        if (Intrinsics.areEqual(eventName, "JIEBAN_EXIT_MY_PROFILE_EVENT")) {
            Integer num = this.currentTabId;
            if ((num != null && num.intValue() == 1) || (fVar = this.mainTab) == null) {
                return;
            }
            fVar.j();
            return;
        }
        if (Intrinsics.areEqual(eventName, "JIEBAN_OPEN_MY_PROFILE_EVENT")) {
            S9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(e this$0) {
        View b16;
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TabLayoutCompat.f fVar = this$0.mainTab;
        if (fVar == null || (b16 = fVar.b()) == null || (num = this$0.currentTabId) == null || num.intValue() != 1) {
            return;
        }
        Rect rect = new Rect();
        b16.getGlobalVisibleRect(rect);
        if (!rect.isEmpty()) {
            l82.b bVar = this$0.mainBubbleGuideElement;
            if (bVar != null) {
                m82.a.f416439a.b().notifyGroupActivate(bVar, RFWOrderElementManager.OrderMode.WAIT_MODE, 1500L);
                return;
            }
            return;
        }
        QLog.d("QQStrangerNavigationPart", 2, "[publishGuideRunnable] main tab is invisible, cancel show.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(e this$0, int i3, boolean z16, Object obj) {
        RedNumTab redNumTab;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 14 || (redNumTab = this$0.tabRedNum) == null) {
            return;
        }
        this$0.da(redNumTab, this$0.N9());
    }

    private final void W9(View iconView) {
        HashMap hashMap = new HashMap();
        hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, 4);
        VideoReport.reportEvent("dt_clck", iconView, hashMap);
    }

    private final void X9(ImageView iconView, int tabId) {
        Integer num;
        Integer num2 = this.currentTabId;
        if (num2 != null && tabId == num2.intValue()) {
            HashMap hashMap = new HashMap();
            int L9 = L9(tabId);
            if (tabId == 1 && ((num = this.currentTabId) == null || num.intValue() != tabId)) {
                L9 = 3;
            }
            hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, Integer.valueOf(L9));
            VideoReport.reportEvent("dt_clck", iconView, hashMap);
        }
    }

    private final boolean Y9() {
        Activity activity = getActivity();
        if ((activity != null && activity.isTaskRoot()) && getContext() != null) {
            QLog.d("QQStrangerNavigationPart", 1, "shouldHandleAsTaskRoot match friend isTaskRoot = true");
            Context context = getContext();
            if (context != null) {
                Intent aliasIntent = SplashActivity.getAliasIntent(context);
                aliasIntent.addFlags(67108864);
                aliasIntent.addFlags(536870912);
                Activity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.startActivity(aliasIntent);
                }
                return true;
            }
        }
        return false;
    }

    private final FragmentTransaction Z9(FragmentTransaction fragmentTransaction, int i3) {
        QBaseFragment J9 = J9(i3);
        if (J9 == null) {
            J9 = F9(i3);
        }
        this.currentFragment = J9;
        if (!J9.isAdded()) {
            fragmentTransaction.add(R.id.onh, J9, String.valueOf(i3));
            return fragmentTransaction;
        }
        if (!J9.isVisible()) {
            fragmentTransaction.show(J9);
        }
        return fragmentTransaction;
    }

    private final void aa() {
        View view = this.bgView;
        if (view != null) {
            Integer num = this.currentTabId;
            view.setVisibility((num != null && num.intValue() == 0) ? 8 : 0);
        }
        Integer num2 = this.currentTabId;
        if (num2 != null && num2.intValue() == 2) {
            View view2 = this.mContentView;
            if (view2 != null) {
                view2.setBackgroundResource(0);
            }
            View view3 = this.mainBgView;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(8);
            return;
        }
        Integer num3 = this.currentTabId;
        if (num3 != null && num3.intValue() == 0) {
            View view4 = this.mContentView;
            if (view4 != null) {
                view4.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            }
            View view5 = this.mainBgView;
            if (view5 == null) {
                return;
            }
            view5.setVisibility(8);
            return;
        }
        View view6 = this.mContentView;
        if (view6 != null) {
            view6.setBackgroundResource(0);
        }
        View view7 = this.mainBgView;
        if (view7 != null) {
            view7.setVisibility(0);
        }
        View view8 = this.mainBgView;
        if (view8 != null) {
            view8.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
    }

    private final void ba() {
        Integer num = this.currentTabId;
        if (num == null) {
            return;
        }
        FragmentManager fragmentManager = this.fragmentManager;
        Intrinsics.checkNotNull(num);
        FragmentTransaction O9 = O9(fragmentManager, num.intValue());
        Integer num2 = this.currentTabId;
        Intrinsics.checkNotNull(num2);
        Z9(O9, num2.intValue()).commitNowAllowingStateLoss();
        QLog.i(getTAG(), 1, "updateFragment,tabId=" + this.currentTabId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(RedNumTab redNumTab, int num) {
        redNumTab.setNum(num);
        if (this.enableUpdateTabUnreadNum) {
            QUIBadge f16 = redNumTab.f();
            Boolean valueOf = Boolean.valueOf(num > 0);
            f16.setVisibility(0);
            if (((View) au.a(valueOf, f16)) == null) {
                f16.setVisibility(8);
            }
        }
    }

    private final void ea() {
        if (this.currentTabId == null) {
            return;
        }
        QQStrangerTitleUpdateEvent qQStrangerTitleUpdateEvent = new QQStrangerTitleUpdateEvent();
        Integer num = this.currentTabId;
        Intrinsics.checkNotNull(num);
        qQStrangerTitleUpdateEvent.setTabId(num.intValue());
        SimpleEventBus.getInstance().dispatchEvent(qQStrangerTitleUpdateEvent);
    }

    private final void ga() {
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.navigation.a
            @Override // java.lang.Runnable
            public final void run() {
                e.ha(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RedNumTab redNumTab = this$0.tabRedNum;
        if (redNumTab != null) {
            int N9 = this$0.N9();
            QLog.i("QQStrangerNavigationPart", 1, "updateUnreadFromPush initRedTouchView,unread=" + N9);
            this$0.da(redNumTab, N9);
        }
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void c(TabLayoutCompat.f tab) {
        TabLayoutCompat.f fVar;
        View b16;
        if (this.mainTabCreate) {
            Object f16 = tab != null ? tab.f() : null;
            Integer num = f16 instanceof Integer ? (Integer) f16 : null;
            if (num != null) {
                int intValue = num.intValue();
                Integer num2 = this.currentTabId;
                if ((num2 != null && num2.intValue() == intValue) || !E9(intValue)) {
                    return;
                }
                if (intValue == 1 && (fVar = this.mainTab) != null && (b16 = fVar.b()) != null) {
                    Rect rect = new Rect();
                    b16.getGlobalVisibleRect(rect);
                    if (!rect.isEmpty()) {
                        ThreadManagerV2.getUIHandlerV2().postDelayed(this.publishGuideRunnable, 2000L);
                    } else {
                        QLog.d("QQStrangerNavigationPart", 2, "[publishGuideRunnable] main tab is invisible, cancel show.");
                    }
                }
                this.currentTabId = Integer.valueOf(intValue);
                TabLayoutCompat tabLayoutCompat = this.tabBarView;
                if (tabLayoutCompat != null) {
                    int A = tabLayoutCompat.A();
                    for (int i3 = 0; i3 < A; i3++) {
                        TabLayoutCompat.f z16 = tabLayoutCompat.z(i3);
                        if (z16 != null) {
                            Intrinsics.checkNotNullExpressionValue(z16, "it.getTabAt(i) ?: continue");
                            Object f17 = z16.f();
                            Integer num3 = f17 instanceof Integer ? (Integer) f17 : null;
                            if (num3 != null) {
                                int intValue2 = num3.intValue();
                                View b17 = z16.b();
                                ImageView imageView = b17 instanceof ImageView ? (ImageView) b17 : null;
                                if (imageView != null) {
                                    ca(imageView, intValue2);
                                }
                            }
                        }
                    }
                }
                QLog.i(getTAG(), 1, "onTabSelected,tabId=" + intValue);
                ba();
                aa();
                ea();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQStrangerJumpHomePageEvent.class);
        arrayList.add(QQStrangerJumpProfilePageEvent.class);
        arrayList.add(QQStrangerOnPageBackEvent.class);
        arrayList.add(QQStrangerOnPostThemeChanged.class);
        arrayList.add(QQStrangerLiteActionPushEvent.class);
        arrayList.add(QQStrangerLiteActionUnreadUpdateEvent.class);
        arrayList.add(QQStrangerKuiklyEvent.class);
        arrayList.add(QQStrangerEnableUpdateTabUnreadNumEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQStrangerNavigationPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QBaseFragment qBaseFragment = this.currentFragment;
        if (qBaseFragment != null) {
            qBaseFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QBaseFragment qBaseFragment = this.currentFragment;
        return (qBaseFragment != null ? qBaseFragment.onBackEvent() : false) || super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        View anchorView;
        TabLayoutCompat tabLayoutCompat;
        TabLayoutCompat.f E;
        TabLayoutCompat.f o16;
        super.onInitView(rootView);
        int intExtra = getActivity().getIntent().getIntExtra("key_tab_id", 1);
        if (rootView != null) {
            this.dragHost = (QUIBadgeDragLayout) rootView.findViewById(R.id.oni);
            this.mainTabCreate = false;
            this.mContentView = rootView.findViewById(R.id.opc);
            TabLayoutCompat tabLayoutCompat2 = (TabLayoutCompat) rootView.findViewById(R.id.onf);
            this.tabBarView = tabLayoutCompat2;
            if (tabLayoutCompat2 != null) {
                tabLayoutCompat2.setSelectedTabIndicatorColor(0);
            }
            this.bgView = rootView.findViewById(R.id.onb);
            this.mainBgView = rootView.findViewById(R.id.on_);
            P9();
            QQStrangerDragLayoutPart.INSTANCE.a(this.priorityDragViewProvider);
            TabLayoutCompat tabLayoutCompat3 = this.tabBarView;
            if (tabLayoutCompat3 != null) {
                tabLayoutCompat3.g(this);
            }
            TabLayoutCompat tabLayoutCompat4 = this.tabBarView;
            if (tabLayoutCompat4 != null) {
                tabLayoutCompat4.setTabGravity(0);
            }
            Iterator it = ArrayIteratorKt.iterator(U);
            TabLayoutCompat.f fVar = null;
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                View G9 = G9(intValue);
                TabLayoutCompat tabLayoutCompat5 = this.tabBarView;
                TabLayoutCompat.f m3 = (tabLayoutCompat5 == null || (E = tabLayoutCompat5.E()) == null || (o16 = E.o(Integer.valueOf(intValue))) == null) ? null : o16.m(G9);
                if (m3 != null && (tabLayoutCompat = this.tabBarView) != null) {
                    tabLayoutCompat.j(m3, false);
                }
                if (intValue == 0) {
                    this.msgTab = m3;
                } else if (intValue == 1) {
                    this.mainTab = m3;
                } else if (intValue == 2) {
                    this.profileTab = m3;
                }
                if (intValue == intExtra) {
                    fVar = m3;
                }
            }
            Q9();
            this.mainTabCreate = true;
            if (fVar != null) {
                fVar.j();
            }
            TabLayoutCompat.f fVar2 = this.mainTab;
            if (fVar2 != null && (anchorView = fVar2.b()) != null) {
                Intrinsics.checkNotNullExpressionValue(anchorView, "anchorView");
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                this.mainBubbleGuideElement = new l82.b(anchorView, activity);
            }
            l82.b bVar = this.mainBubbleGuideElement;
            if (bVar != null) {
                m82.a.f416439a.b().addElement(bVar);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent newIntent) {
        TabLayoutCompat.f M9;
        super.onNewIntent(newIntent);
        Integer valueOf = newIntent != null ? Integer.valueOf(newIntent.getIntExtra("key_tab_id", -1)) : null;
        if (Intrinsics.areEqual(valueOf, this.currentTabId) || (M9 = M9(valueOf)) == null) {
            return;
        }
        M9.j();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        this.recentContactService = recentContactService;
        if (recentContactService != null) {
            recentContactService.addExpandRecentContactListener(this.expandRecentContactListener);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        QQAppInterface K9 = K9();
        if (K9 != null) {
            K9.addObserver(this.relationObserver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QQStrangerDragLayoutPart.INSTANCE.b(this.priorityDragViewProvider);
        aa aaVar = this.recentContactService;
        if (aaVar != null) {
            aaVar.removeExpandRecentContactListener(this.expandRecentContactListener);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QQAppInterface K9 = K9();
        if (K9 != null) {
            K9.removeObserver(this.relationObserver);
        }
        l82.b bVar = this.mainBubbleGuideElement;
        if (bVar != null) {
            m82.a.f416439a.b().inactivateElement((IOrderElement) bVar, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerNavigationPart", 2, "Inactive mainGuideBubbleElement. Notify the group for competing.");
        }
        TabLayoutCompat tabLayoutCompat = this.tabBarView;
        if (tabLayoutCompat != null) {
            tabLayoutCompat.H(this);
        }
        this.tabBarView = null;
        this.currentFragment = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerJumpHomePageEvent) {
            Integer num = this.currentTabId;
            if (num != null && num.intValue() == 1) {
                return;
            }
            TabLayoutCompat.f fVar = this.mainTab;
            if (fVar != null) {
                fVar.j();
            }
            QLog.i("QQStrangerNavigationPart", 1, "invoke jump homepage");
            return;
        }
        if (event instanceof QQStrangerOnPageBackEvent) {
            Integer num2 = this.currentTabId;
            if (num2 == null || num2.intValue() != 1) {
                TabLayoutCompat.f fVar2 = this.mainTab;
                if (fVar2 != null) {
                    fVar2.j();
                    return;
                }
                return;
            }
            Y9();
            Activity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        if (event instanceof QQStrangerOnPostThemeChanged) {
            P9();
            return;
        }
        if (!(event instanceof QQStrangerLiteActionPushEvent) && !(event instanceof QQStrangerLiteActionUnreadUpdateEvent)) {
            if (event instanceof QQStrangerJumpProfilePageEvent) {
                S9();
                return;
            } else if (event instanceof QQStrangerKuiklyEvent) {
                T9(((QQStrangerKuiklyEvent) event).getEventName());
                return;
            } else {
                if (event instanceof QQStrangerEnableUpdateTabUnreadNumEvent) {
                    H9(((QQStrangerEnableUpdateTabUnreadNumEvent) event).getEnable());
                    return;
                }
                return;
            }
        }
        ga();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/navigation/e$b", "Lcom/tencent/qqnt/kernel/invorker/d;", "", "listType", "unreadCnt", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "", "O0", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements com.tencent.qqnt.kernel.invorker.d {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int d16 = i3 + q.f244623a.d();
            RedNumTab redNumTab = this$0.tabRedNum;
            if (redNumTab != null) {
                this$0.da(redNumTab, d16);
            }
        }

        @Override // com.tencent.qqnt.kernel.invorker.d
        public void O0(int listType, final int unreadCnt, List<RecentContactInfo> changedList) {
            if (listType == 8) {
                final e eVar = e.this;
                eVar.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.navigation.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.b(unreadCnt, eVar);
                    }
                });
            }
        }
    }

    private final TabLayoutCompat.f M9(Integer tabId) {
        if (tabId != null && tabId.intValue() == 1) {
            return this.mainTab;
        }
        if (tabId != null && tabId.intValue() == 0) {
            return this.msgTab;
        }
        if (tabId != null && tabId.intValue() == 2) {
            return this.profileTab;
        }
        return null;
    }

    private final void ca(ImageView iconView, int tabId) {
        Drawable o16;
        int dimensionPixelSize;
        if (tabId == 1) {
            Integer num = this.currentTabId;
            if (num != null && tabId == num.intValue()) {
                dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.c_a);
            } else {
                dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.c_8);
            }
            iconView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        }
        Context context = getContext();
        Resources resources = context != null ? context.getResources() : null;
        if (resources == null) {
            return;
        }
        Integer num2 = this.currentTabId;
        int i3 = R.drawable.qui_qq;
        if (num2 != null && tabId == num2.intValue()) {
            Integer num3 = W.get(Integer.valueOf(tabId));
            if (num3 != null) {
                i3 = num3.intValue();
            }
            o16 = resources.getDrawable(i3);
        } else {
            ie0.a f16 = ie0.a.f();
            Context context2 = getContext();
            Integer num4 = V.get(Integer.valueOf(tabId));
            if (num4 != null) {
                i3 = num4.intValue();
            }
            o16 = f16.o(context2, i3, R.color.qui_common_icon_secondary, 1000);
        }
        if (o16 == null) {
            return;
        }
        iconView.setImageDrawable(o16);
        X9(iconView, tabId);
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void J8(TabLayoutCompat.f tab) {
        Object f16 = tab != null ? tab.f() : null;
        Integer num = f16 instanceof Integer ? (Integer) f16 : null;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue != 0) {
                if (intValue != 1 || u.a().b() || QQStrangerGuestHelper.f245363a.b(getActivity())) {
                    return;
                }
                com.tencent.mobileqq.matchfriend.reborn.publish.a aVar = com.tencent.mobileqq.matchfriend.reborn.publish.a.f245245a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.mobileqq.matchfriend.reborn.publish.a.b(aVar, context, null, 2, null);
                View e16 = tab.e();
                if (e16 != null) {
                    W9(e16);
                    return;
                }
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(QQStrangerScrollToNextUnreadEvent.INSTANCE);
        }
    }

    private final boolean E9(int tabId) {
        if (tabId != 1 && QQStrangerGuestHelper.f245363a.b(getActivity())) {
            TabLayoutCompat.f fVar = this.mainTab;
            if (fVar != null) {
                fVar.j();
            }
            return false;
        }
        if (tabId == 2) {
            Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
            if ((a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null) == null) {
                QQToastUtil.showQQToastInUiThread(1, "\u8d44\u6599\u52a0\u8f7d\u4e2d...");
                TabLayoutCompat.f fVar2 = this.mainTab;
                if (fVar2 != null) {
                    fVar2.j();
                }
                return false;
            }
        }
        return true;
    }

    private final QBaseFragment F9(int id5) {
        if (id5 == 0) {
            return new QQStrangerMsgFragment();
        }
        if (id5 != 2) {
            return new QQStrangerMainFragment();
        }
        return e82.a.f395872a.b();
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void l3(TabLayoutCompat.f tab) {
    }
}
