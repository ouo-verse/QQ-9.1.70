package com.tencent.sqshow.zootopia.avatar.mall;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.guide.q;
import com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendActivity;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleEvent;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import n74.ak;
import qv4.bh;
import qv4.bi;
import qv4.bk;
import t74.n;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0002TUB'\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\u0018\u00a2\u0006\u0004\bQ\u0010RJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J(\u0010\u000f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0002J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010!\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0012\u0010&\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J*\u0010-\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+H\u0002R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006V"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarRoleTitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "K0", "onResume", "Lcom/tencent/sqshow/zootopia/avatar/mall/l;", "theListener", "T0", "Lqv4/bk;", "data", "", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/a;", "bannerDataList", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "S0", "show", "hide", "", NodeProps.VISIBLE, "setTitleVisible", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "view", "", "endMargin", "J0", "e1", "Lqv4/bi;", "info", "Y0", "U0", "W0", "Q0", "L0", "c1", "bannerData", "O0", "M0", "f1", "", "startAplha", "endAplha", "Lkotlin/Function0;", "endCallback", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Ln74/ak;", "d", "Ln74/ak;", "mBinding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "e", "Lkotlin/Lazy;", "d1", "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReport", "f", "Lqv4/bk;", "titleData", tl.h.F, "Ljava/util/List;", "titleBannerDataList", "i", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/avatar/mall/l;", "listener", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleEvent;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "createRoleEventReceiver", "D", "Z", "hasCreateRole", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarRoleTitleView extends ConstraintLayout {
    private static int F = ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;

    /* renamed from: C, reason: from kotlin metadata */
    private SimpleEventReceiver<CreateRoleEvent> createRoleEventReceiver;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasCreateRole;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ak mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy mReport;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private bk titleData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> titleBannerDataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource sourceCurrent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private l listener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR+\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarRoleTitleView$a;", "", "", "c", "", "a", "", "e", "Lqv4/bh;", "Lqv4/bh;", "bannerInfo", "", "<set-?>", "b", "Lkotlin/properties/ReadWriteProperty;", "()J", "d", "(J)V", "lastClickTimestampMs", "<init>", "(Lqv4/bh;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final bh bannerInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ReadWriteProperty lastClickTimestampMs;

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f370084d = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "lastClickTimestampMs", "getLastClickTimestampMs()J", 0))};

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarRoleTitleView$a$a;", "", "", "b", "Lqv4/bh;", "Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarRoleTitleView$a;", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final long b() {
                return NetConnInfoCenter.getServerTimeMillis();
            }

            public final a c(bh bhVar) {
                Intrinsics.checkNotNullParameter(bhVar, "<this>");
                return new a(bhVar);
            }

            Companion() {
            }
        }

        public a(bh bannerInfo) {
            Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
            this.bannerInfo = bannerInfo;
            QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
            this.lastClickTimestampMs = t74.i.a((IZPlanMMKVApi) api, "BannerInfoDisplayConfig_LCT_" + c() + "_" + bannerInfo.f430061a, 0L);
        }

        private final long b() {
            return ((Number) this.lastClickTimestampMs.getValue(this, f370084d[0])).longValue();
        }

        private final String c() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                return peekAppRuntime.getCurrentUin();
            }
            return null;
        }

        private final void d(long j3) {
            this.lastClickTimestampMs.setValue(this, f370084d[0], Long.valueOf(j3));
        }

        public final boolean a() {
            return true;
        }

        public final void e() {
            d(INSTANCE.b());
            bh bhVar = this.bannerInfo;
            QLog.i("AvatarNativeTitleView_", 1, "bannerInfo id:" + bhVar.f430061a + ", name:" + bhVar.f430062b + " update click timestamp to " + b());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.sqshow.zootopia.recommend.characterV2.data.a) t17).getBanner().f430065e), Long.valueOf(((com.tencent.sqshow.zootopia.recommend.characterV2.data.a) t16).getBanner().f430065e));
            return compareValues;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarRoleTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Context context, AvatarRoleTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activityFromContext = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getActivityFromContext(context);
        ZPlanMainRecommendActivity zPlanMainRecommendActivity = activityFromContext instanceof ZPlanMainRecommendActivity ? (ZPlanMainRecommendActivity) activityFromContext : null;
        if (zPlanMainRecommendActivity != null) {
            zPlanMainRecommendActivity.T2(false);
        }
        ZplanViewReportHelper d16 = this$0.d1();
        ImageView imageView = this$0.mBinding.f418641e;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
        ZplanViewReportHelper.f(d16, imageView, "em_zplan_back_btn", null, 4, null);
    }

    private final void J0(View view, int endMargin) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(endMargin);
            view.setLayoutParams(layoutParams);
        }
    }

    private final void L0() {
        List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> list;
        bk bkVar = this.titleData;
        if (bkVar != null && (list = this.titleBannerDataList) != null) {
            Intrinsics.checkNotNull(bkVar);
            QLog.i("AvatarNativeTitleView_", 1, "bindActivityCenterEntrance bannerList:" + list + ", continueLoginTask:" + bkVar.f430084j);
            this.mBinding.f418639c.setVisibility(8);
            this.mBinding.f418642f.setVisibility(8);
            com.tencent.sqshow.zootopia.recommend.characterV2.data.a c16 = c1();
            if (c16 != null) {
                O0(c16);
                return;
            }
            bk bkVar2 = this.titleData;
            Intrinsics.checkNotNull(bkVar2);
            M0(bkVar2.f430084j);
            return;
        }
        QLog.w("AvatarNativeTitleView_", 1, "bindActivityCenterEntrance no data, tilteData: " + (bkVar != null) + ", bannerList:" + (this.titleBannerDataList != null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(AvatarRoleTitleView this$0, bi biVar, IRedTouchManager iRedTouchManager, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = biVar.f430066a;
        if (str == null) {
            str = "";
        }
        iSchemeApi.launchScheme(context, str);
        ZplanViewReportHelper d16 = this$0.d1();
        ZPlanMediaView zPlanMediaView = this$0.mBinding.f418645i;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.createRoleView");
        ZplanViewReportHelper.f(d16, zPlanMediaView, "em_zplan_active_welfare_ent", null, 4, null);
        if (this$0.mBinding.f418640d.getVisibility() == 0) {
            this$0.mBinding.f418640d.setVisibility(8);
            if (iRedTouchManager != null) {
                iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_ZPLAN_PORTAL_ACTIVITY_WELFARE, 31);
            }
        }
    }

    private final void O0(final com.tencent.sqshow.zootopia.recommend.characterV2.data.a bannerData) {
        final Map mapOf;
        QLog.i("AvatarNativeTitleView_", 1, "bindBannerInfoEntrance bannerData:" + bannerData);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_act_id", String.valueOf(bannerData.getBanner().f430061a)));
        this.mBinding.f418642f.setVisibility(0);
        URLImageView uRLImageView = this.mBinding.f418643g;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.bannerInfoImage");
        String str = bannerData.getBanner().f430063c;
        Intrinsics.checkNotNullExpressionValue(str, "bannerData.banner.picUrl");
        n.f(uRLImageView, str, com.tencent.mobileqq.urldrawable.b.f306350a, null, 4, null);
        FrameLayout frameLayout = this.mBinding.f418642f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.bannerInfoContainer");
        aa.d(frameLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.mall.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarRoleTitleView.P0(com.tencent.sqshow.zootopia.recommend.characterV2.data.a.this, this, mapOf, view);
            }
        });
        bannerData.d();
        ZplanViewReportHelper d16 = d1();
        URLImageView uRLImageView2 = this.mBinding.f418643g;
        Intrinsics.checkNotNullExpressionValue(uRLImageView2, "mBinding.bannerInfoImage");
        d16.g(uRLImageView2, "em_zplan_top_resource", (r16 & 4) != 0 ? null : mapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(com.tencent.sqshow.zootopia.recommend.characterV2.data.a bannerData, AvatarRoleTitleView this$0, Map reportExtra, View view) {
        Intrinsics.checkNotNullParameter(bannerData, "$bannerData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportExtra, "$reportExtra");
        bannerData.c();
        ZplanViewReportHelper d16 = this$0.d1();
        URLImageView uRLImageView = this$0.mBinding.f418643g;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.bannerInfoImage");
        d16.e(uRLImageView, "em_zplan_top_resource", reportExtra);
        a.INSTANCE.c(bannerData.getBanner()).e();
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = bannerData.getBanner().f430064d;
        if (str == null) {
            str = "";
        }
        iSchemeApi.launchScheme(context, str);
        l lVar = this$0.listener;
        if (lVar != null) {
            lVar.a(bannerData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(bi biVar, AvatarRoleTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        ZootopiaSource zootopiaSource = this$0.sourceCurrent;
        bundle.putString("key_refer_external_entrance", (zootopiaSource != null ? ah.b(zootopiaSource) : null) + "_icon");
        bundle.putBoolean("key_stay_in_page_when_has_registered", true);
        xb4.b bVar = xb4.b.f447772a;
        String str = biVar.f430066a;
        Intrinsics.checkNotNullExpressionValue(str, "info.jumpUrl");
        String d16 = bVar.d(str, bundle);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, d16);
        ZplanViewReportHelper d17 = this$0.d1();
        ZPlanMediaView zPlanMediaView = this$0.mBinding.f418645i;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.createRoleView");
        ZplanViewReportHelper.f(d17, zPlanMediaView, "em_zplan_create_icon", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(AvatarRoleTitleView this$0, bi biVar, View view) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = biVar.f430066a;
        if (str == null) {
            str = "";
        }
        iSchemeApi.launchScheme(context, str);
        ZplanViewReportHelper d16 = this$0.d1();
        FrameLayout frameLayout = this$0.mBinding.f418655s;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.zplanIvMail");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_redpoint_type", Integer.valueOf(this$0.mBinding.f418646j.getReddotStatus())));
        d16.e(frameLayout, "em_zplan_msg_entrance", hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(AvatarRoleTitleView this$0, bi biVar, View view) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = biVar.f430066a;
        if (str == null) {
            str = "";
        }
        iSchemeApi.launchScheme(context, str);
        ZplanViewReportHelper d16 = this$0.d1();
        FrameLayout frameLayout = this$0.mBinding.f418656t;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.zplanIvMenu");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_redpoint_type", Integer.valueOf(this$0.mBinding.f418649m.getReddotStatus())));
        d16.e(frameLayout, "em_zplan_task_entrance", hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(AvatarRoleTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iZPlanApi.startSettingV2Activity(context, IZPlanApi.FROM_ZPLAN_STORE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r0, new com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.tencent.sqshow.zootopia.recommend.characterV2.data.a c1() {
        List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> sortedWith;
        List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> list = this.titleBannerDataList;
        if (!(list == null || list.isEmpty()) && (r0 = this.titleBannerDataList) != null && sortedWith != null) {
            for (com.tencent.sqshow.zootopia.recommend.characterV2.data.a aVar : sortedWith) {
                if (a.INSTANCE.c(aVar.getBanner()).a()) {
                    return aVar;
                }
            }
        }
        return null;
    }

    private final ZplanViewReportHelper d1() {
        return (ZplanViewReportHelper) this.mReport.getValue();
    }

    private final void e1() {
        bk bkVar = this.titleData;
        Q0(bkVar != null ? bkVar.f430082h : null);
    }

    private final void f1() {
        if (this.createRoleEventReceiver != null) {
            return;
        }
        this.createRoleEventReceiver = new AvatarRoleTitleView$registerCreateRoleEventReceiver$1(this);
        SimpleEventBus.getInstance().registerReceiver(this.createRoleEventReceiver);
    }

    public final void K0() {
        int c16 = u.INSTANCE.c(getContext());
        int pxToDp = ViewUtils.pxToDp(c16);
        QLog.d("AvatarNativeTitleView_", 1, " get width: " + c16 + ", " + pxToDp + " ");
        ViewGroup.LayoutParams layoutParams = null;
        if (pxToDp < F) {
            int b16 = com.tencent.sqshow.zootopia.utils.i.b(5);
            FrameLayout frameLayout = this.mBinding.f418654r;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.zplanEndContainer");
            J0(frameLayout, b16);
            FrameLayout frameLayout2 = this.mBinding.f418642f;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "mBinding.bannerInfoContainer");
            J0(frameLayout2, b16);
            FrameLayout frameLayout3 = this.mBinding.f418639c;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "mBinding.activityWelfareContainer");
            J0(frameLayout3, b16);
            FrameLayout frameLayout4 = this.mBinding.f418644h;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "mBinding.createRoleContainer");
            J0(frameLayout4, b16);
            FrameLayout frameLayout5 = this.mBinding.f418655s;
            Intrinsics.checkNotNullExpressionValue(frameLayout5, "mBinding.zplanIvMail");
            J0(frameLayout5, b16);
            FrameLayout frameLayout6 = this.mBinding.f418656t;
            Intrinsics.checkNotNullExpressionValue(frameLayout6, "mBinding.zplanIvMenu");
            J0(frameLayout6, b16);
            ImageView imageView = this.mBinding.f418641e;
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            if (layoutParams2 != null) {
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(b16);
                }
                layoutParams = layoutParams2;
            }
            imageView.setLayoutParams(layoutParams);
            return;
        }
        FrameLayout frameLayout7 = this.mBinding.f418654r;
        Intrinsics.checkNotNullExpressionValue(frameLayout7, "mBinding.zplanEndContainer");
        J0(frameLayout7, com.tencent.sqshow.zootopia.utils.i.b(16));
        int b17 = com.tencent.sqshow.zootopia.utils.i.b(8);
        FrameLayout frameLayout8 = this.mBinding.f418642f;
        Intrinsics.checkNotNullExpressionValue(frameLayout8, "mBinding.bannerInfoContainer");
        J0(frameLayout8, b17);
        FrameLayout frameLayout9 = this.mBinding.f418639c;
        Intrinsics.checkNotNullExpressionValue(frameLayout9, "mBinding.activityWelfareContainer");
        J0(frameLayout9, b17);
        FrameLayout frameLayout10 = this.mBinding.f418644h;
        Intrinsics.checkNotNullExpressionValue(frameLayout10, "mBinding.createRoleContainer");
        J0(frameLayout10, b17);
        FrameLayout frameLayout11 = this.mBinding.f418655s;
        Intrinsics.checkNotNullExpressionValue(frameLayout11, "mBinding.zplanIvMail");
        J0(frameLayout11, b17);
        FrameLayout frameLayout12 = this.mBinding.f418656t;
        Intrinsics.checkNotNullExpressionValue(frameLayout12, "mBinding.zplanIvMenu");
        J0(frameLayout12, b17);
        ImageView imageView2 = this.mBinding.f418641e;
        ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
        if (layoutParams3 != null) {
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams3).setMarginStart(com.tencent.sqshow.zootopia.utils.i.b(16));
            }
            layoutParams = layoutParams3;
        }
        imageView2.setLayoutParams(layoutParams);
    }

    public final void S0(bk data, List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> bannerDataList, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("AvatarNativeTitleView_", 1, "bindEnterData(). bannerDataList.count: " + (bannerDataList != null ? Integer.valueOf(bannerDataList.size()) : null) + ", data:" + data);
        this.titleData = data;
        this.titleBannerDataList = bannerDataList;
        this.sourceCurrent = source;
        Y0(data != null ? data.f430075a : null);
        U0(data != null ? data.f430080f : null);
        W0(data != null ? data.f430079e : null);
        Q0(data != null ? data.f430082h : null);
        L0();
    }

    public final void T0(l theListener) {
        Intrinsics.checkNotNullParameter(theListener, "theListener");
        this.listener = theListener;
    }

    public final void hide() {
        a1(1.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView$hide$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AvatarRoleTitleView.this.setVisibility(4);
                AvatarRoleTitleView.this.setAlpha(1.0f);
            }
        });
    }

    public final void onDestroy() {
        this.mBinding.f418645i.setPagListener(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this.createRoleEventReceiver);
    }

    public final void onResume() {
        e1();
        L0();
    }

    public final void setTitleVisible(boolean visible) {
        this.mBinding.f418651o.setVisibility(visible ? 0 : 8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarRoleTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a1(float startAplha, float endAplha, Function0<Unit> endCallback) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, startAplha, endAplha);
        ofFloat.addListener(new c(ofFloat, endCallback));
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    public final void show() {
        setVisibility(0);
        b1(this, 0.0f, 1.0f, null, 4, null);
    }

    public /* synthetic */ AvatarRoleTitleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void U0(final bi info) {
        boolean z16;
        HashMap hashMapOf;
        if (info != null) {
            String str = info.f430066a;
            if (str != null) {
                if (str.length() == 0) {
                    z16 = true;
                    if (!z16) {
                        this.mBinding.f418646j.setVisibility(0);
                        this.mBinding.f418646j.h(info.f430068c);
                        this.mBinding.f418655s.setVisibility(0);
                        this.mBinding.f418658v.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        FrameLayout frameLayout = this.mBinding.f418655s;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.zplanIvMail");
                        aa.d(frameLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.mall.g
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                AvatarRoleTitleView.V0(AvatarRoleTitleView.this, info, view);
                            }
                        });
                        ZplanViewReportHelper d16 = d1();
                        FrameLayout frameLayout2 = this.mBinding.f418655s;
                        Intrinsics.checkNotNullExpressionValue(frameLayout2, "mBinding.zplanIvMail");
                        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_redpoint_type", Integer.valueOf(this.mBinding.f418646j.getReddotStatus())));
                        d16.g(frameLayout2, "em_zplan_msg_entrance", (r16 & 4) != 0 ? null : hashMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
                        return;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        this.mBinding.f418655s.setVisibility(8);
        this.mBinding.f418646j.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void W0(final bi info) {
        boolean z16;
        HashMap hashMapOf;
        if (info != null) {
            String str = info.f430066a;
            if (str != null) {
                if (str.length() == 0) {
                    z16 = true;
                    if (!z16) {
                        this.mBinding.f418649m.setVisibility(0);
                        this.mBinding.f418649m.h(info.f430068c);
                        this.mBinding.f418656t.setVisibility(0);
                        FrameLayout frameLayout = this.mBinding.f418656t;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.zplanIvMenu");
                        aa.d(frameLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.mall.i
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                AvatarRoleTitleView.X0(AvatarRoleTitleView.this, info, view);
                            }
                        });
                        ZplanViewReportHelper d16 = d1();
                        FrameLayout frameLayout2 = this.mBinding.f418656t;
                        Intrinsics.checkNotNullExpressionValue(frameLayout2, "mBinding.zplanIvMenu");
                        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_redpoint_type", Integer.valueOf(this.mBinding.f418649m.getReddotStatus())));
                        d16.g(frameLayout2, "em_zplan_task_entrance", (r16 & 4) != 0 ? null : hashMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
                        return;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        this.mBinding.f418656t.setVisibility(8);
        this.mBinding.f418649m.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarRoleTitleView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        ak f16 = ak.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZplanViewReportHelper>() { // from class: com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView$mReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanViewReportHelper invoke() {
                return new ZplanViewReportHelper();
            }
        });
        this.mReport = lazy;
        ImageView imageView = f16.f418641e;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
        aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.mall.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarRoleTitleView.G0(context, this, view);
            }
        });
        ZplanViewReportHelper d16 = d1();
        ImageView imageView2 = f16.f418641e;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.backIgv");
        d16.g(imageView2, "em_zplan_back_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        K0();
    }

    private final void Q0(final bi info) {
        if ((info != null ? info.f430067b : null) != null) {
            String str = info.f430066a;
            if (!(str == null || str.length() == 0)) {
                f1();
                if (this.hasCreateRole) {
                    this.mBinding.f418644h.setVisibility(8);
                    QLog.w("AvatarNativeTitleView_", 1, "bindCreateRoleEntrance hasCreateRole");
                    return;
                }
                if (q.f370741a.m()) {
                    QLog.w("AvatarNativeTitleView_", 1, "bindCreateRoleEntrance warning, bubble is showing");
                    this.mBinding.f418644h.setVisibility(8);
                    return;
                }
                if (this.mBinding.f418644h.getVisibility() == 0) {
                    return;
                }
                this.mBinding.f418644h.setVisibility(0);
                this.mBinding.f418645i.setDefaultDrawable(getResources().getDrawable(R.drawable.ifa));
                ZPlanMediaView zPlanMediaView = this.mBinding.f418645i;
                pu4.g gVar = info.f430067b;
                Intrinsics.checkNotNullExpressionValue(gVar, "info.material");
                zPlanMediaView.e(gVar);
                ZPlanMediaView zPlanMediaView2 = this.mBinding.f418645i;
                Intrinsics.checkNotNullExpressionValue(zPlanMediaView2, "mBinding.createRoleView");
                aa.d(zPlanMediaView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.mall.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AvatarRoleTitleView.R0(bi.this, this, view);
                    }
                });
                ZplanViewReportHelper d16 = d1();
                ZPlanMediaView zPlanMediaView3 = this.mBinding.f418645i;
                Intrinsics.checkNotNullExpressionValue(zPlanMediaView3, "mBinding.createRoleView");
                d16.g(zPlanMediaView3, "em_zplan_create_icon", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
                return;
            }
        }
        this.mBinding.f418644h.setVisibility(8);
        QLog.w("AvatarNativeTitleView_", 1, "bindCreateRoleEntrance no data, jumpUrl=" + (info != null ? info.f430066a : null));
    }

    private final void Y0(bi info) {
        if (info != null) {
            String str = info.f430066a;
            if (!(str == null || str.length() == 0)) {
                this.mBinding.f418652p.setVisibility(0);
                this.mBinding.f418652p.h(info.f430068c);
                this.mBinding.f418657u.setVisibility(0);
                ImageView imageView = this.mBinding.f418657u;
                Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.zplanIvSetting");
                aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.mall.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AvatarRoleTitleView.Z0(AvatarRoleTitleView.this, view);
                    }
                });
                return;
            }
        }
        this.mBinding.f418657u.setVisibility(0);
        this.mBinding.f418652p.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void b1(AvatarRoleTitleView avatarRoleTitleView, float f16, float f17, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        avatarRoleTitleView.a1(f16, f17, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0(final bi info) {
        PBInt32Field pBInt32Field;
        AppRuntime peekAppRuntime;
        r2 = null;
        Integer num = null;
        if ((info != null ? info.f430067b : null) != null) {
            String str = info.f430066a;
            if ((str == null || str.length() == 0) == false) {
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                final IRedTouchManager iRedTouchManager = (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) ? null : (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
                this.mBinding.f418639c.setVisibility(0);
                ZPlanMediaView zPlanMediaView = this.mBinding.f418638b;
                pu4.g gVar = info.f430067b;
                Intrinsics.checkNotNullExpressionValue(gVar, "info.material");
                zPlanMediaView.e(gVar);
                FrameLayout frameLayout = this.mBinding.f418639c;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.activityWelfareContainer");
                aa.d(frameLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.mall.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AvatarRoleTitleView.N0(AvatarRoleTitleView.this, info, iRedTouchManager, view);
                    }
                });
                ZplanViewReportHelper d16 = d1();
                ZPlanMediaView zPlanMediaView2 = this.mBinding.f418638b;
                Intrinsics.checkNotNullExpressionValue(zPlanMediaView2, "mBinding.activityWelfare");
                d16.g(zPlanMediaView2, "em_zplan_active_welfare_ent", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
                if (iRedTouchManager != null) {
                    BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath("140127");
                    if (appInfoByPath != null && (pBInt32Field = appInfoByPath.iNewFlag) != null) {
                        num = Integer.valueOf(pBInt32Field.get());
                    }
                    QLog.i("AvatarNativeTitleView_", 1, "bindActivityWelfareEntrance red dot, appInfo.iNewFlag=" + num);
                    if (appInfoByPath != null) {
                        PBInt32Field pBInt32Field2 = appInfoByPath.iNewFlag;
                        if (pBInt32Field2 != null && pBInt32Field2.get() == 0) {
                            return;
                        }
                        this.mBinding.f418640d.setVisibility(0);
                        iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_ZPLAN_PORTAL_ACTIVITY_WELFARE, 30);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.mBinding.f418639c.setVisibility(8);
        QLog.w("AvatarNativeTitleView_", 1, "bindActivityWelfareEntrance no data, jumpUrl=" + (info != null ? info.f430066a : null));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/avatar/mall/AvatarRoleTitleView$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f370087d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f370088e;

        c(ObjectAnimator objectAnimator, Function0<Unit> function0) {
            this.f370087d = objectAnimator;
            this.f370088e = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f370087d.removeAllListeners();
            Function0<Unit> function0 = this.f370088e;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
