package com.qzone.reborn.part.plus;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import eo.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import ve.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00016B\u0017\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/qzone/reborn/part/plus/d;", "Lcom/qzone/reborn/base/k;", "", "G9", "K9", "", "isLongClick", "H9", "J9", "Landroid/widget/ImageView;", "imageView", "E9", "I9", "Lcooperation/qzone/report/lp/LpReportInfo_pf00064;", "F9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "action", "", "args", "handleBroadcastMessage", "Lve/i;", "d", "Lve/i;", "getBuilder", "()Lve/i;", "builder", "", "e", "I", "getMPageId", "()I", "mPageId", "f", "Landroid/view/View;", "mFloatPlusIconContainer", h.F, "Landroid/widget/ImageView;", "mFloatPlusIcon", "i", "mFloatPlusIconBackground", "Lcom/qzone/reborn/part/plus/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/part/plus/f;", "mPlusMenuHelper", "<init>", "(Lve/i;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final i builder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mPageId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mFloatPlusIconContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mFloatPlusIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mFloatPlusIconBackground;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private f mPlusMenuHelper;

    public d(i builder, int i3) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.mPageId = i3;
    }

    private final LpReportInfo_pf00064 F9() {
        String str;
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        String str2 = "1";
        if (QzoneFrame.isNewConciseFragment()) {
            str = "1";
        } else {
            str = "0";
        }
        lpReportInfo_pf00064.reserves8 = str;
        if (!QQTheme.isNowSimpleUI()) {
            str2 = "0";
        }
        lpReportInfo_pf00064.reserves9 = str2;
        lpReportInfo_pf00064.reserves10 = this.builder.c();
        return lpReportInfo_pf00064;
    }

    private final void G9() {
        this.mPlusMenuHelper = new f(getActivity(), this.builder.c());
        if (this.mFloatPlusIconContainer == null || this.mFloatPlusIcon == null || this.mFloatPlusIconBackground == null) {
            View findViewById = getPartRootView().findViewById(R.id.n18);
            this.mFloatPlusIconContainer = findViewById;
            AccessibilityUtil.p(findViewById, "\u53d1\u8868\u52a8\u6001");
            com.tencent.mobileqq.qui.b.f276860a.a(this.mFloatPlusIconContainer, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
            View findViewById2 = getPartRootView().findViewById(R.id.mvj);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            this.mFloatPlusIcon = (ImageView) findViewById2;
            View findViewById3 = getPartRootView().findViewById(R.id.mvk);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            this.mFloatPlusIconBackground = (ImageView) findViewById3;
            fo.c.o(this.mFloatPlusIconContainer, "em_qz_plus_suspend", new fo.b().h(new c.a()));
        }
    }

    private final void H9(boolean isLongClick) {
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0(this.builder.c());
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        qZonePublishMoodInitBean.o0(Boolean.valueOf(isLongClick));
        l.f59550a.d0(qZonePublishMoodInitBean);
        ho.i.w().c(getActivity(), qZonePublishMoodInitBean);
    }

    private final void I9() {
        LpReportInfo_pf00064 F9 = F9();
        F9.actionType = 309;
        F9.subactionType = 102;
        F9.reserves = 2;
        LpReportManager.getInstance().reportToPF00064(F9, false, false);
    }

    private final void J9() {
        if (getContext() == null) {
            return;
        }
        ImageView imageView = this.mFloatPlusIconBackground;
        if (imageView != null) {
            imageView.setColorFilter(getContext().getColor(R.color.qui_common_brand_standard));
        }
        ImageView imageView2 = this.mFloatPlusIcon;
        if (imageView2 != null) {
            imageView2.setColorFilter(getContext().getColor(R.color.qui_common_on_brand_primary));
        }
    }

    private final void K9() {
        G9();
        View view = this.mFloatPlusIconContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mFloatPlusIconContainer;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.plus.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    d.L9(d.this, view3);
                }
            });
        }
        if (com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp_qzone_pluslongpress", null, 2, null)) {
            QLog.i("QZoneFeedXFloatPlusIconPart", 1, "init long click listener");
            View view3 = this.mFloatPlusIconContainer;
            if (view3 != null) {
                view3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.part.plus.c
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view4) {
                        boolean M9;
                        M9 = d.M9(d.this, view4);
                        return M9;
                    }
                });
            }
        }
        ImageView imageView = this.mFloatPlusIcon;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.nws);
        }
        E9(this.mFloatPlusIcon);
        LpReportInfo_pf00064.allReport(137, 4, 1);
        I9();
        if (this.mPageId > 0) {
            eo.a.f396875a.d(2);
        }
        J9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.qzone.reborn.util.e.c("QZoneFeedXFloatPlusIconPart", 1000L)) {
            eo.c.f396879a.b();
            if (!l.f59550a.T(this$0.getActivity(), this$0.getHostFragment())) {
                this$0.H9(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M9(d this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZoneFeedXFloatPlusIconPart", 1, "long click plus icon");
        l.f59550a.a0(false);
        eo.c cVar = eo.c.f396879a;
        cVar.b();
        HashMap hashMap = new HashMap();
        hashMap.putAll(this$0.builder.b());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, cVar.c());
        if (TextUtils.equals("pg_discover_feeds_page", this$0.builder.a())) {
            str = "em_qz_plus_sign";
        } else {
            str = "em_qz_plus_suspend";
        }
        hashMap.put("qq_eid", str);
        String a16 = this$0.builder.a();
        Intrinsics.checkNotNullExpressionValue(a16, "builder.dtPageId");
        hashMap.put("qq_pgid", a16);
        fo.c.c("ev_qz_long_press_float_plus", hashMap);
        this$0.H9(true);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedXFloatPlusIconPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        View view;
        Intrinsics.checkNotNullParameter(action, "action");
        super.handleBroadcastMessage(action, args);
        if (!Intrinsics.areEqual(action, "DISMISS_PLUS_MENU") || (view = this.mFloatPlusIconContainer) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        view.sendAccessibilityEvent(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        K9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    private final void E9(ImageView imageView) {
        if (imageView == null || !(imageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = ImmersiveUtils.dpToPx(20.0f);
        layoutParams2.width = ImmersiveUtils.dpToPx(20.0f);
    }
}
