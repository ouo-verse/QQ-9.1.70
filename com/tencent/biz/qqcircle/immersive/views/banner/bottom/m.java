package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.ap;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomVideoContainerItemView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ea\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0006\u0082\u0001\u0083\u0001\u0084\u0001B\u0011\u0012\u0006\u0010\u007f\u001a\u00020~\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010#\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010#\u001a\u00020'H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020\u0010H\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010.\u001a\u00020)H\u0002J\u0010\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020)H\u0002J\b\u00102\u001a\u00020\u0010H\u0002J\b\u00104\u001a\u000203H\u0002J\u001a\u00107\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\f2\u0006\u00106\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\b\u0010<\u001a\u00020\u0010H\u0014J\b\u0010=\u001a\u00020\u0010H\u0014J\u0012\u0010@\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010A\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010C\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010D\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010H\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040F0Ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040F`GH\u0016J\u0012\u0010J\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010IH\u0016R\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010\u0017R\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010\u0017R\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010\u0017R\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010[R\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010^R\u0016\u0010`\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010UR\u0016\u0010c\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010bR\u0016\u0010f\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010eR\u0016\u0010i\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010hR\u0016\u0010j\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010UR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010lR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010OR\u0016\u0010p\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0016\u0010q\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010s\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010rR\u0014\u0010v\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010uR\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010uR\u0014\u0010z\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010yR\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020\f0{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010|\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/m;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/util/Size;", "J", "", "U", "W", "V", "", "Le30/b;", "O", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Y", "T", "H", "d0", "I", "K", "Z", "b0", "j0", ExifInterface.LATITUDE_SOUTH, "l0", "L", "k0", "a0", "e0", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "i0", "Lcom/tencent/biz/qqcircle/immersive/events/QFSSeekEvent;", "event", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qqcircle/events/QCirclePanelStateEvent;", "P", "Lcom/tencent/biz/qqcircle/immersive/feed/event/ap;", BdhLogUtil.LogTag.Tag_Req, "", "index", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView;", "M", "f0", "targetIndex", "c0", "clickIndex", "X", "g0", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/m$d;", "N", "data", "position", tl.h.F, "getPriority", "isElementCanActivate", "onElementActivated", "onElementInactivated", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onPaused", "e", "v", NodeProps.ON_CLICK, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "f", "D", "isEnable", "E", "isOpening", UserInfo.SEX_FEMALE, "isOpMaskOnInFeedList", "Landroid/view/ViewStub;", "G", "Landroid/view/ViewStub;", "viewStub", "Landroid/view/View;", "containerView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "infoView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "bottomListFrame", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "titleRelative", "actionZone", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "actionText", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "actionImg", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "divideLine", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/c;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/c;", "adapter", "", "bottomHeight", "containerWidth", "currentPlayingIndex", "Landroid/util/Size;", "itemSize", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "showRunnable", "attachPlayVideoRunnable", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "itemPlayListener", "", "Ljava/util/List;", "containerVideoList", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "b", "c", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class m extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isEnable;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isOpening;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isOpMaskOnInFeedList;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ViewStub viewStub;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ViewGroup infoView;

    /* renamed from: J, reason: from kotlin metadata */
    private RoundCorneredFrameLayout bottomListFrame;

    /* renamed from: K, reason: from kotlin metadata */
    private RelativeLayout titleRelative;

    /* renamed from: L, reason: from kotlin metadata */
    private View actionZone;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView actionText;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView actionImg;

    /* renamed from: P, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: Q, reason: from kotlin metadata */
    private View divideLine;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c adapter;

    /* renamed from: S, reason: from kotlin metadata */
    private float bottomHeight;

    /* renamed from: T, reason: from kotlin metadata */
    private int containerWidth;

    /* renamed from: U, reason: from kotlin metadata */
    private int currentPlayingIndex;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Size itemSize;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Runnable showRunnable;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Runnable attachPlayVideoRunnable;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final QFSBottomVideoContainerItemView.b itemPlayListener;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final List<e30.b> containerVideoList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/m$a", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "", "currentIndex", "", HippyQQPagView.EventName.ON_PLAY_END, "index", NodeProps.ON_CLICK, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements QFSBottomVideoContainerItemView.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomVideoContainerItemView.b
        public void onClick(int index) {
            m.this.X(index);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomVideoContainerItemView.b
        public void onPlayEnd(int currentIndex) {
            m.this.c0(currentIndex + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/m$c;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", ReportConstant.COSTREPORT_PREFIX, "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/m;", "a", "Ljava/lang/ref/WeakReference;", "wrfView", "itemView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/m;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<m> wrfView;

        public c(@NotNull m itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.wrfView = new WeakReference<>(itemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@NotNull String s16) {
            String str;
            Intrinsics.checkNotNullParameter(s16, "s");
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            if (this.wrfView.get() == null) {
                Intrinsics.checkNotNullExpressionValue(map, "map");
                return map;
            }
            m mVar = this.wrfView.get();
            if (mVar != null) {
                Map<String, Object> e16 = ua0.c.e(mVar.f90602e);
                Intrinsics.checkNotNullExpressionValue(e16, "convertDataToDTParamsMap(it.mFeed)");
                map.putAll(e16);
                Intrinsics.checkNotNullExpressionValue(map, "map");
                if (mVar.isOpening) {
                    str = "open";
                } else {
                    str = QCircleDaTongConstant.ElementParamValue.CONTAINER_STATUS_STOW;
                }
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str);
            }
            Intrinsics.checkNotNullExpressionValue(map, "map");
            return map;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/m$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "setHasShow", "(Z)V", "hasShow", "b", "I", "()I", "setPlayingIndex", "(I)V", "playingIndex", "c", "setOpen", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "<init>", "(ZIZ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.banner.bottom.m$d, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class QFSBottomVideoContainerInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasShow;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int playingIndex;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isOpen;

        public QFSBottomVideoContainerInfo() {
            this(false, 0, false, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasShow() {
            return this.hasShow;
        }

        /* renamed from: b, reason: from getter */
        public final int getPlayingIndex() {
            return this.playingIndex;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsOpen() {
            return this.isOpen;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QFSBottomVideoContainerInfo)) {
                return false;
            }
            QFSBottomVideoContainerInfo qFSBottomVideoContainerInfo = (QFSBottomVideoContainerInfo) other;
            if (this.hasShow == qFSBottomVideoContainerInfo.hasShow && this.playingIndex == qFSBottomVideoContainerInfo.playingIndex && this.isOpen == qFSBottomVideoContainerInfo.isOpen) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.hasShow;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = ((r06 * 31) + this.playingIndex) * 31;
            boolean z17 = this.isOpen;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "QFSBottomVideoContainerInfo(hasShow=" + this.hasShow + ", playingIndex=" + this.playingIndex + ", isOpen=" + this.isOpen + ")";
        }

        public QFSBottomVideoContainerInfo(boolean z16, int i3, boolean z17) {
            this.hasShow = z16;
            this.playingIndex = i3;
            this.isOpen = z17;
        }

        public /* synthetic */ QFSBottomVideoContainerInfo(boolean z16, int i3, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? false : z17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/m$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            m.this.isOpening = true;
            ViewGroup viewGroup = m.this.infoView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            View view = m.this.divideLine;
            RecyclerView recyclerView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
                view = null;
            }
            view.setVisibility(8);
            RecyclerView recyclerView2 = m.this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            VideoReport.traversePage(recyclerView);
            m mVar = m.this;
            mVar.c0(mVar.currentPlayingIndex);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/m$f", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f extends RecyclerView.ItemDecoration {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = DisplayUtil.dip2px(m.this.j(), 12.0f);
            } else {
                outRect.left = 0;
            }
            if (childAdapterPosition == 3) {
                outRect.right = 0;
            } else {
                outRect.right = DisplayUtil.dip2px(m.this.j(), 5.0f);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/m$g", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class g implements Animation.AnimationListener {
        g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            RoundCorneredFrameLayout roundCorneredFrameLayout = m.this.bottomListFrame;
            RecyclerView recyclerView = null;
            if (roundCorneredFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomListFrame");
                roundCorneredFrameLayout = null;
            }
            roundCorneredFrameLayout.setVisibility(8);
            View view = m.this.divideLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
                view = null;
            }
            view.setVisibility(0);
            RecyclerView recyclerView2 = m.this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            VideoReport.traversePage(recyclerView);
            m.this.a0();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.containerVideoList = new ArrayList();
        Size J = J();
        this.itemSize = J;
        this.bottomHeight = (J.getHeight() + j().getResources().getDimension(R.dimen.d09)) - j().getResources().getDimension(R.dimen.d0_);
        this.containerWidth = (J.getWidth() * 4) + ImmersiveUtils.dpToPx(12.0f) + (ImmersiveUtils.dpToPx(5.0f) * 3);
        this.itemPlayListener = new a();
        this.showRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.k
            @Override // java.lang.Runnable
            public final void run() {
                m.v(m.this);
            }
        };
        this.attachPlayVideoRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.l
            @Override // java.lang.Runnable
            public final void run() {
                m.w(m.this);
            }
        };
    }

    private final void H() {
        if (this.containerVideoList.isEmpty()) {
            this.containerVideoList.addAll(O());
        }
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c cVar = this.adapter;
        if (cVar != null) {
            cVar.k0(this.itemSize);
        }
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c cVar2 = this.adapter;
        if (cVar2 != null) {
            cVar2.i0(this.f90602e);
        }
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c cVar3 = this.adapter;
        if (cVar3 != null) {
            cVar3.setDatas(this.containerVideoList);
        }
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c cVar4 = this.adapter;
        if (cVar4 != null) {
            cVar4.j0(this.itemPlayListener);
        }
    }

    private final void I() {
        String str;
        PBStringField pBStringField;
        RelativeLayout relativeLayout = this.titleRelative;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
            relativeLayout = null;
        }
        VideoReport.setElementId(relativeLayout, QCircleDaTongConstant.ElementId.EM_XSJ_CONTAINER_OPEN_FOLD_BUTTON);
        RelativeLayout relativeLayout3 = this.titleRelative;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
            relativeLayout3 = null;
        }
        VideoReport.setEventDynamicParams(relativeLayout3, new c(this));
        RelativeLayout relativeLayout4 = this.titleRelative;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
            relativeLayout4 = null;
        }
        VideoReport.setElementClickPolicy(relativeLayout4, ClickPolicy.REPORT_ALL);
        RelativeLayout relativeLayout5 = this.titleRelative;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
            relativeLayout5 = null;
        }
        VideoReport.setElementExposePolicy(relativeLayout5, ExposurePolicy.REPORT_ALL);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        RelativeLayout relativeLayout6 = this.titleRelative;
        if (relativeLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
        } else {
            relativeLayout2 = relativeLayout6;
        }
        VideoReport.setElementReuseIdentifier(relativeLayout2, QCircleDaTongConstant.ElementId.EM_XSJ_CONTAINER_OPEN_FOLD_BUTTON + str);
    }

    private final Size J() {
        int j3 = (((bz.j() - DisplayUtil.dip2px(j(), 62.0f)) - DisplayUtil.dip2px(j(), 12.0f)) - (DisplayUtil.dip2px(j(), 5.0f) * 3)) / 4;
        int i3 = (int) (j3 * 1.3333334f);
        int dip2px = DisplayUtil.dip2px(j(), 120.0f);
        if (i3 > dip2px) {
            j3 = DisplayUtil.dip2px(j(), 90.0f);
            i3 = dip2px;
        }
        return new Size(j3, i3);
    }

    private final void K() {
        n().removeCallbacks(this.showRunnable);
        n().removeCallbacks(this.attachPlayVideoRunnable);
    }

    private final void L() {
        i0(false);
        e30.b bVar = this.f90601d;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        com.tencent.biz.qqcircle.immersive.utils.r.X0(bVar, false, recyclerView.computeHorizontalScrollOffset(), true);
        e0();
        k0();
    }

    private final QFSBottomVideoContainerItemView M(int index) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(index);
        if (!(findViewHolderForAdapterPosition instanceof c.b)) {
            return null;
        }
        View view = ((c.b) findViewHolderForAdapterPosition).itemView;
        if (!(view instanceof QFSBottomVideoContainerItemView)) {
            return null;
        }
        return (QFSBottomVideoContainerItemView) view;
    }

    private final QFSBottomVideoContainerInfo N() {
        Object obj;
        e30.b bVar = this.f90601d;
        QFSBottomVideoContainerInfo qFSBottomVideoContainerInfo = null;
        if (bVar != null) {
            obj = bVar.b("FEED_BOTTOM_VIDEO_CONTAINER_INFO");
        } else {
            obj = null;
        }
        if (obj instanceof QFSBottomVideoContainerInfo) {
            qFSBottomVideoContainerInfo = (QFSBottomVideoContainerInfo) obj;
        }
        if (qFSBottomVideoContainerInfo == null) {
            return new QFSBottomVideoContainerInfo(false, 0, false, 7, null);
        }
        return qFSBottomVideoContainerInfo;
    }

    private final List<e30.b> O() {
        boolean z16;
        PBRepeatField<Integer> pBRepeatField;
        List<Integer> list;
        ArrayList<e30.b> arrayList = new ArrayList();
        List<e30.b> feedList = o().getFeedList();
        Intrinsics.checkNotNullExpressionValue(feedList, "qfsFeedIoc.feedList");
        arrayList.addAll(feedList);
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (e30.b bVar : arrayList) {
            FeedCloudMeta$StFeed g16 = bVar.g();
            if (g16 != null && (pBRepeatField = g16.opMask2) != null && (list = pBRepeatField.get()) != null && list.contains(57)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.isOpMaskOnInFeedList = true;
            }
            if (com.tencent.biz.qqcircle.immersive.adapter.n.e(bVar.g()) == 1003 && (i3 = i3 + 1) != 1 && i3 <= 5) {
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private final void P(QCirclePanelStateEvent event) {
        if (QCirclePanelStateEvent.isBottomPanelShowing()) {
            QFSBottomVideoContainerItemView M = M(this.currentPlayingIndex);
            if (M != null) {
                M.pause();
                return;
            }
            return;
        }
        QFSBottomVideoContainerItemView M2 = M(this.currentPlayingIndex);
        if (M2 != null) {
            M2.y0();
        }
    }

    private final void Q(QFSSeekEvent event) {
        if (!this.isEnable && !N().getHasShow()) {
            return;
        }
        if (event.mIsOnSeek) {
            View view = this.containerView;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.containerView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (this.isOpening) {
            ViewGroup viewGroup = this.infoView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.infoView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
    }

    private final void R(ap event) {
        String str;
        PBStringField pBStringField;
        if (!event.b()) {
            String a16 = event.a();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(a16, str) && !N().getHasShow() && !this.isOpening) {
                K();
                n().postDelayed(this.showRunnable, 3000L);
            }
        }
    }

    private final void S() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.bottomHeight, 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new e());
        ViewGroup viewGroup = this.infoView;
        if (viewGroup != null) {
            viewGroup.startAnimation(animationSet);
        }
    }

    private final void T() {
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(j());
        safeLinearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(safeLinearLayoutManager);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.getLayoutParams().height = this.itemSize.getHeight();
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addItemDecoration(new f());
        this.adapter = new com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c();
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.setAdapter(this.adapter);
    }

    private final boolean U() {
        boolean z16;
        boolean z17;
        PBRepeatField<Integer> pBRepeatField;
        List<Integer> list;
        boolean z18 = false;
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            QLog.d("QFSFeedBottomVideoContainerView", 1, "[isEnableShow] low device, return");
            return false;
        }
        if (this.f90601d == null) {
            QLog.d("QFSFeedBottomVideoContainerView", 1, "[isEnableShow] mFeedBlockData is null, return");
            return false;
        }
        if (p().getPageId() == 503 && this.f90603f == 0 && QCirclePluginUtil.isTabMode() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && com.tencent.biz.qqcircle.immersive.adapter.n.e(this.f90602e) == 1003 && !W()) {
            boolean V = V();
            if (!this.isOpMaskOnInFeedList) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
                if (feedCloudMeta$StFeed != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && (list = pBRepeatField.get()) != null && list.contains(57)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && !com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_FIRST_FEED_VIDEO_CONTAINER, 0)) {
                    z16 = false;
                    if (z16 && V) {
                        z18 = true;
                    }
                    QLog.d("QFSFeedBottomVideoContainerView", 1, "[isEnableShow] " + z18);
                }
            }
            z16 = true;
            if (z16) {
                z18 = true;
            }
            QLog.d("QFSFeedBottomVideoContainerView", 1, "[isEnableShow] " + z18);
        }
        return z18;
    }

    private final boolean V() {
        boolean z16;
        this.containerVideoList.clear();
        this.containerVideoList.addAll(O());
        if (this.containerVideoList.size() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QFSFeedBottomVideoContainerView", 1, "[isFeedListValid] " + z16);
        return z16;
    }

    private final boolean W() {
        long f16 = uq3.k.a().f("qfs_first_feed_video_container_show_timestamp", 0L);
        if (f16 > 0) {
            return uq3.n.c(f16, System.currentTimeMillis());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int clickIndex) {
        e30.b bVar;
        List list;
        List<e30.b> dataList;
        ArrayList arrayList = new ArrayList();
        List<e30.b> feedList = o().getFeedList();
        Intrinsics.checkNotNullExpressionValue(feedList, "qfsFeedIoc.feedList");
        arrayList.addAll(feedList);
        if (clickIndex >= arrayList.size()) {
            QLog.d("QFSFeedBottomVideoContainerView", 1, "[jumpToTargetVideo] out of size, clickIndex: " + clickIndex);
            return;
        }
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c cVar = this.adapter;
        RecyclerView recyclerView = null;
        if (cVar != null && (dataList = cVar.getDataList()) != null) {
            bVar = dataList.get(clickIndex);
        } else {
            bVar = null;
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        int b16 = bj.b(list, bVar);
        if (b16 <= 0) {
            QLog.d("QFSFeedBottomVideoContainerView", 1, "[jumpToTargetVideo] can not find target feed.");
            return;
        }
        ViewParent parent = this.f90604h.getParent();
        if (parent instanceof RecyclerView) {
            recyclerView = (RecyclerView) parent;
        }
        if (recyclerView != null) {
            recyclerView.scrollToPosition(b16);
        }
    }

    private final void Y(View rootView) {
        View view;
        if (this.viewStub != null) {
            return;
        }
        this.viewStub = (ViewStub) rootView.findViewById(R.id.f40001d7);
        this.infoView = (ViewGroup) rootView.findViewById(R.id.v_p);
        ViewStub viewStub = this.viewStub;
        RelativeLayout relativeLayout = null;
        if (viewStub != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        this.containerView = view;
        View findViewById = view.findViewById(R.id.f33130vm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "inflateView.findViewById(R.id.qfs_action_zone)");
        this.actionZone = findViewById;
        View findViewById2 = view.findViewById(R.id.f34390z1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "inflateView.findViewById\u2026_bottom_feed_action_icon)");
        this.actionImg = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f34440z6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "inflateView.findViewById\u2026eed_recommend_action_txt)");
        this.actionText = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f34460z8);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "inflateView.findViewById\u2026ed_recommend_recycleView)");
        this.recyclerView = (RecyclerView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f34490za);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "inflateView.findViewById\u2026id.qfs_bottom_frame_list)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById5;
        this.bottomListFrame = roundCorneredFrameLayout;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomListFrame");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(DisplayUtil.dip2px(j(), 4.0f));
        View findViewById6 = view.findViewById(R.id.f34480z_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "inflateView.findViewById\u2026tom_feed_recommend_title)");
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById6;
        this.titleRelative = relativeLayout2;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
            relativeLayout2 = null;
        }
        relativeLayout2.getLayoutParams().width = this.containerWidth;
        RelativeLayout relativeLayout3 = this.titleRelative;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
        } else {
            relativeLayout = relativeLayout3;
        }
        relativeLayout.setOnClickListener(this);
        View findViewById7 = view.findViewById(R.id.f34430z5);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "inflateView.findViewById\u2026qfs_bottom_feed_rec_line)");
        this.divideLine = findViewById7;
        View findViewById8 = view.findViewById(R.id.f34450z7);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "inflateView.findViewById\u2026ottom_feed_recommend_des)");
        ((TextView) findViewById8).setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f196404h8));
        View findViewById9 = view.findViewById(R.id.f34470z9);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "inflateView.findViewById\u2026ommend_recycleView_shade)");
        findViewById9.setVisibility(8);
        T();
    }

    private final void Z() {
        boolean z16;
        if (this.isOpening) {
            L();
            QFSBottomVideoContainerItemView M = M(this.currentPlayingIndex);
            if (M != null) {
                M.pause();
            }
            z16 = false;
        } else {
            b0();
            z16 = true;
        }
        this.isOpening = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        ViewGroup viewGroup = this.infoView;
        if (viewGroup != null) {
            viewGroup.startAnimation(alphaAnimation);
        }
        ViewGroup viewGroup2 = this.infoView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
    }

    private final void b0() {
        e30.b bVar = this.f90601d;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        com.tencent.biz.qqcircle.immersive.utils.r.X0(bVar, true, recyclerView.computeHorizontalScrollOffset(), true);
        i0(true);
        j0();
        S();
        l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(int targetIndex) {
        this.currentPlayingIndex = targetIndex;
        if (targetIndex >= 4) {
            QLog.d("QFSFeedBottomVideoContainerView", 1, "[playNextVideo] out of bounds, index: " + targetIndex);
            return;
        }
        QFSBottomVideoContainerItemView M = M(targetIndex);
        if (M != null) {
            M.y0();
        }
        QLog.d("QFSFeedBottomVideoContainerView", 1, "[playNextVideo] start play, index: " + this.currentPlayingIndex);
    }

    private final void d0() {
        View view = this.containerView;
        if (view != null) {
            view.setVisibility(0);
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout = null;
        if (this.isOpening) {
            View view2 = this.divideLine;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
                view2 = null;
            }
            view2.setVisibility(8);
            RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.bottomListFrame;
            if (roundCorneredFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomListFrame");
            } else {
                roundCorneredFrameLayout = roundCorneredFrameLayout2;
            }
            roundCorneredFrameLayout.setVisibility(0);
            ViewGroup viewGroup = this.infoView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            n().postDelayed(this.attachPlayVideoRunnable, 500L);
        } else {
            View view3 = this.divideLine;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
                view3 = null;
            }
            view3.setVisibility(0);
            RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.bottomListFrame;
            if (roundCorneredFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomListFrame");
            } else {
                roundCorneredFrameLayout = roundCorneredFrameLayout3;
            }
            roundCorneredFrameLayout.setVisibility(8);
            ViewGroup viewGroup2 = this.infoView;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            ViewGroup viewGroup3 = this.infoView;
            if (viewGroup3 != null) {
                viewGroup3.setAlpha(1.0f);
            }
        }
        i0(this.isOpening);
    }

    private final void e0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.bottomHeight);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.bottomListFrame;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomListFrame");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.startAnimation(animationSet);
        animationSet.setAnimationListener(new g());
    }

    private final void f0() {
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.c cVar = this.adapter;
        if (cVar != null) {
            int itemCount = cVar.getItemCount();
            for (int i3 = 0; i3 < itemCount; i3++) {
                QFSBottomVideoContainerItemView M = M(i3);
                if (M != null) {
                    M.release();
                }
            }
        }
    }

    private final void g0() {
        if (!this.isEnable && !N().getHasShow()) {
            return;
        }
        QFSBottomVideoContainerInfo qFSBottomVideoContainerInfo = new QFSBottomVideoContainerInfo(true, this.currentPlayingIndex, this.isOpening);
        QLog.d("QFSFeedBottomVideoContainerView", 1, "saveShowInfo isOpen: " + this.isOpening);
        e30.b bVar = this.f90601d;
        if (bVar != null) {
            bVar.o("FEED_BOTTOM_VIDEO_CONTAINER_INFO", qFSBottomVideoContainerInfo);
        }
    }

    private final void i0(boolean isOpen) {
        int i3;
        float f16;
        if (isOpen) {
            i3 = R.string.f183183ih;
        } else {
            i3 = R.string.f183193ii;
        }
        TextView textView = this.actionText;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionText");
            textView = null;
        }
        textView.setText(com.tencent.biz.qqcircle.utils.h.a(i3));
        ImageView imageView2 = this.actionImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionImg");
        } else {
            imageView = imageView2;
        }
        if (isOpen) {
            f16 = 0.0f;
        } else {
            f16 = 180.0f;
        }
        imageView.setRotation(f16);
    }

    private final void j0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.bottomHeight, 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.bottomListFrame;
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomListFrame");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setVisibility(0);
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.bottomListFrame;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomListFrame");
        } else {
            roundCorneredFrameLayout2 = roundCorneredFrameLayout3;
        }
        roundCorneredFrameLayout2.startAnimation(animationSet);
    }

    private final void k0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.bottomHeight);
        translateAnimation.setDuration(200L);
        RelativeLayout relativeLayout = this.titleRelative;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
            relativeLayout = null;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    private final void l0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.bottomHeight, 0.0f);
        translateAnimation.setDuration(200L);
        RelativeLayout relativeLayout = this.titleRelative;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRelative");
            relativeLayout = null;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean U = this$0.U();
        this$0.isEnable = U;
        if (U) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pre_inflate_video_container_item", true)) {
                RFWLayoutLoaderStrategy c16 = l30.a.a().c();
                Intrinsics.checkNotNullExpressionValue(c16, "getInstance().layoutLoaderStrategy");
                RFWLayoutPreLoader layoutLoader = RFWLayoutPreLoaderFactory.getLayoutLoader(c16);
                Context context = this$0.j();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                layoutLoader.preloadView(context, R.layout.g8n, 4);
            }
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(this$0.getContextHashCode(), this$0.getGroup(), this$0.getGroupExtraKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c0(this$0.currentPlayingIndex);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void e(@Nullable RFWFeedSelectInfo selectInfo) {
        super.e(selectInfo);
        if (this.isOpening) {
            d0();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        super.f(event);
        if (event instanceof ap) {
            R((ap) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSSeekEvent.class, QCirclePanelStateEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 114;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(@Nullable e30.b data, int position) {
        super.h(data, position);
        this.isEnable = false;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.f90601d != null && this.f90602e != null) {
            if (this.f90603f != 0) {
                return false;
            }
            if (this.isEnable || N().getHasShow()) {
                return true;
            }
            return false;
        }
        QLog.d("QFSFeedBottomVideoContainerView", 1, "feed is null.");
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f34480z_) {
            Z();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        View mRootView = this.f90604h;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        Y(mRootView);
        if (this.containerView == null) {
            return;
        }
        QFSBottomVideoContainerInfo N = N();
        boolean hasShow = N.getHasShow();
        this.isOpening = N.getIsOpen();
        this.currentPlayingIndex = N.getPlayingIndex();
        H();
        d0();
        if (!hasShow) {
            b0();
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        I();
        uq3.k.a().n("qfs_first_feed_video_container_show_timestamp", System.currentTimeMillis());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        K();
        View view = this.containerView;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup = this.infoView;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        f0();
        g0();
        this.isOpening = false;
        this.isEnable = false;
        this.isOpMaskOnInFeedList = false;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        if (!this.isEnable && !N().getHasShow()) {
            QLog.d("QFSFeedBottomVideoContainerView", 1, "[onPaused] container no show.");
            return;
        }
        K();
        f0();
        QLog.d("QFSFeedBottomVideoContainerView", 1, "[onPaused] container release.");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSSeekEvent) {
            Q((QFSSeekEvent) event);
        } else if (event instanceof QCirclePanelStateEvent) {
            P((QCirclePanelStateEvent) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        K();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
