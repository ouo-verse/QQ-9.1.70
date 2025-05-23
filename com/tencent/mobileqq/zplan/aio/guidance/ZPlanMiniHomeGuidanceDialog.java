package com.tencent.mobileqq.zplan.aio.guidance;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController;
import com.tencent.mobileqq.zplan.minihome.GuidanceSource;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanMiniHomeGuidanceConfig;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.AppSetting;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import fi3.at;
import fi3.au;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t74.i;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B=\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/guidance/ZPlanMiniHomeGuidanceDialog;", "Landroid/app/Dialog;", "Lcom/tencent/sqshow/utils/featureswitch/model/ab;", "content", "", "j", "g", "i", "cancel", "", "d", "Ljava/lang/String;", "parentSource", "Lcom/tencent/mobileqq/zplan/minihome/GuidanceSource;", "e", "Lcom/tencent/mobileqq/zplan/minihome/GuidanceSource;", "source", "Lkotlin/Function1;", "", "f", "Lkotlin/jvm/functions/Function1;", "resultCallback", "", h.F, "I", "panelHeight", "Lfi3/au;", "Lfi3/au;", "binding", "Lfi3/at;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfi3/at;", "contentBinding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/minihome/GuidanceSource;Lcom/tencent/sqshow/utils/featureswitch/model/ab;Lkotlin/jvm/functions/Function1;)V", BdhLogUtil.LogTag.Tag_Conn, "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanMiniHomeGuidanceDialog extends Dialog {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReadWriteProperty<Object, String> D;
    private static final ReadWriteProperty<Object, Long> E;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String parentSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final GuidanceSource source;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function1<Boolean, Unit> resultCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int panelHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final au binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final at contentBinding;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aio/guidance/ZPlanMiniHomeGuidanceDialog$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            ConstraintLayout root = ZPlanMiniHomeGuidanceDialog.this.contentBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "contentBinding.root");
            return root;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aio/guidance/ZPlanMiniHomeGuidanceDialog$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), TypedValue.applyDimension(1, 8.0f, view.getContext().getResources().getDisplayMetrics()));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002R+\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/guidance/ZPlanMiniHomeGuidanceDialog$c;", "", "", "a", "", "<set-?>", "mmkvLastAskVersion$delegate", "Lkotlin/properties/ReadWriteProperty;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "mmkvLastAskVersion", "", "mmkvShownTimestamp$delegate", "c", "()J", "e", "(J)V", "mmkvShownTimestamp", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.guidance.ZPlanMiniHomeGuidanceDialog$c, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f331040a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvLastAskVersion", "getMmkvLastAskVersion()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvShownTimestamp", "getMmkvShownTimestamp()J", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            if (c() != 0) {
                QLog.i("ZPlanMiniHomeGuidanceDialog", 2, "askShow \u5df2\u66fe\u5c55\u793a\u8fc7 \u5c55\u793a\u65f6\u523b " + c());
                return false;
            }
            QQAppInterface l3 = bb.f335811a.l();
            Long valueOf = l3 != null ? Long.valueOf(l3.getLongAccountUin()) : null;
            if (valueOf == null) {
                QLog.e("ZPlanMiniHomeGuidanceDialog", 1, "askShow longAccountUin == null");
                return false;
            }
            String b16 = b();
            String reportVersionName = AppSetting.getReportVersionName();
            if (Intrinsics.areEqual(b16, reportVersionName)) {
                QLog.i("ZPlanMiniHomeGuidanceDialog", 2, "askShow \u7248\u672c\u672a\u66f4\u65b0 lastShowVersion == nowVersion == " + b16);
                return false;
            }
            d(reportVersionName);
            if (((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getZPlanMiniHomeSettingSwitch(valueOf.longValue())) {
                QLog.i("ZPlanMiniHomeGuidanceDialog", 2, "askShow \u8ff7\u4f60\u5c0f\u7a9d\u5df2\u5f00\u542f");
                return false;
            }
            QLog.i("ZPlanMiniHomeGuidanceDialog", 1, "askShow \u5c55\u793a\u6210\u529f " + b16 + " -> " + reportVersionName);
            e(System.currentTimeMillis());
            return true;
        }

        public final String b() {
            return (String) ZPlanMiniHomeGuidanceDialog.D.getValue(this, f331040a[0]);
        }

        public final long c() {
            return ((Number) ZPlanMiniHomeGuidanceDialog.E.getValue(this, f331040a[1])).longValue();
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ZPlanMiniHomeGuidanceDialog.D.setValue(this, f331040a[0], str);
        }

        public final void e(long j3) {
            ZPlanMiniHomeGuidanceDialog.E.setValue(this, f331040a[1], Long.valueOf(j3));
        }

        Companion() {
        }
    }

    static {
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        D = i.e((IZPlanMMKVApi) api, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.aio.guidance.ZPlanMiniHomeGuidanceDialog$Companion$mmkvLastAskVersion$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_ZPlanMiniHomeGuidanceDialog_lastAskVersion_" + bb.f335811a.e();
            }
        }, "");
        QRouteApi api2 = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IZPlanMMKVApi::class.java)");
        E = i.d((IZPlanMMKVApi) api2, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.aio.guidance.ZPlanMiniHomeGuidanceDialog$Companion$mmkvShownTimestamp$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_ZPlanMiniHomeGuidanceDialog_shownTimestamp_" + bb.f335811a.e();
            }
        }, 0L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanMiniHomeGuidanceDialog(Context context, String str, GuidanceSource source, ZPlanMiniHomeGuidanceConfig content, Function1<? super Boolean, Unit> resultCallback) {
        super(context, R.style.f173283zs);
        float b16;
        Window window;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        this.parentSource = str;
        this.source = source;
        this.resultCallback = resultCallback;
        b16 = c.b(context, 432.66f);
        this.panelHeight = (int) b16;
        QLog.i("ZPlanMiniHomeGuidanceDialog", 1, "ZPlanMiniHomeGuidanceDialog init source : " + source);
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        if (QQTheme.isNowThemeIsNight() && (window = getWindow()) != null) {
            window.setNavigationBarColor(0);
        }
        au g16 = au.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        at g17 = at.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.from(context))");
        this.contentBinding = g17;
        setContentView(g16.getRoot());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = g16.f398940b;
        qUSHalfScreenFloatingView.setQUSDragFloatController(new a());
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.zplan.aio.guidance.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ZPlanMiniHomeGuidanceDialog.h(ZPlanMiniHomeGuidanceDialog.this);
            }
        });
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        g17.f398937d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.guidance.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanMiniHomeGuidanceDialog.c(ZPlanMiniHomeGuidanceDialog.this, view);
            }
        });
        g17.f398936c.setClipToOutline(true);
        g17.f398936c.setOutlineProvider(new b());
        g17.f398936c.getLayoutParams().height = (context.getResources().getDisplayMetrics().widthPixels * 461) / com.tencent.luggage.wxa.sm.e.O;
        j(content);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ZPlanMiniHomeGuidanceDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.resultCallback.invoke(Boolean.TRUE);
        this$0.i();
        this$0.dismiss();
    }

    private final void g() {
        Map mapOf;
        VideoReport.setPageId(this.binding.getRoot(), "pg_user_profile_new");
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardConst.IS_BLACK_LIST, Integer.valueOf(((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).getProfileCardBlacklistReportType(bb.f335811a.e())));
        VideoReport.setPageContentId(this.binding.getRoot(), QZoneHelper.QZONE_PRELOAD_FROM_FRIEND_PROFILE);
        VideoReport.setPageParams(this.binding.getRoot(), new PageParams(hashMap));
        VideoReport.setPageReportPolicy(this.binding.getRoot(), PageReportPolicy.REPORT_ALL);
        VideoReport.setElementId(this.contentBinding.f398937d, "em_zplan_experience_btn");
        QUIButton qUIButton = this.contentBinding.f398937d;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, Integer.valueOf(this.source.getReportSource()));
        String str = this.parentSource;
        if (str == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("zplan_sub_source", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.setElementParams(qUIButton, mapOf);
        VideoReport.setElementExposePolicy(this.contentBinding.f398937d, ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementClickPolicy(this.contentBinding.f398937d, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", this.contentBinding.f398937d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZPlanMiniHomeGuidanceDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("ZPlanMiniHomeGuidanceDialog", 1, "dismiss!!!");
        this$0.resultCallback.invoke(Boolean.FALSE);
        ZPlanMiniHomeGuidanceBubbleViewController.INSTANCE.j();
        this$0.dismiss();
    }

    private final void i() {
        VideoReport.reportEvent("clck", this.contentBinding.f398937d, null);
    }

    private final void j(ZPlanMiniHomeGuidanceConfig content) {
        at atVar = this.contentBinding;
        atVar.f398938e.setText(content.getTitle());
        atVar.f398935b.setText(content.getDescription());
        atVar.f398936c.setImageDrawable(URLDrawable.getDrawable(content.getImageUrl(), URLDrawable.URLDrawableOptions.obtain()));
        atVar.f398937d.setText(content.getOkText());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        this.binding.f398940b.t();
    }
}
