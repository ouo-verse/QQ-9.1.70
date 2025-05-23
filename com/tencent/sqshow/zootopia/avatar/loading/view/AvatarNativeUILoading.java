package com.tencent.sqshow.zootopia.avatar.loading.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ad;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u0014\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R&\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00170#j\b\u0012\u0004\u0012\u00020\u0017`$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010,R\u0016\u0010/\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010!R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006="}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/view/AvatarNativeUILoading;", "Landroid/widget/FrameLayout;", "Lc84/a;", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "", tl.h.F, DomainData.DOMAIN_NAME, "j", "y", "B", "u", "t", "r", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "i", "v", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "Lcom/tencent/sqshow/zootopia/scene/component/c;", "originHandler", ReportConstant.COSTREPORT_PREFIX, "", "loadingHint", "setHintText", "d", "I", "mCurrentProgress", "e", "Z", "mPageDataIsError", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "f", "Ljava/util/HashSet;", "mPageDataRetryHandlerSet", "mUeIsError", "Ln74/p;", "Ln74/p;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", BdhLogUtil.LogTag.Tag_Conn, "mNativeUiLoadingShow", "", "D", "J", "mShowTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarNativeUILoading extends FrameLayout implements c84.a, com.tencent.sqshow.zootopia.scene.component.d {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mNativeUiLoadingShow;

    /* renamed from: D, reason: from kotlin metadata */
    private long mShowTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mCurrentProgress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mPageDataIsError;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private HashSet<com.tencent.sqshow.zootopia.scene.component.c> mPageDataRetryHandlerSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mUeIsError;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final p mBinding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private j mChannel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarNativeUILoading(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(null, "zootopia_loadingComponent");
    }

    private final void B() {
        this.mBinding.f419396j.setProgress(this.mCurrentProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Context context, AvatarNativeUILoading this$0, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.finish();
        }
        j jVar = this$0.mChannel;
        if (jVar == null) {
            return;
        }
        Map<String, Object> b16 = jVar.getReporter().b();
        b16.put("zplan_is_loading", "1");
        ZplanViewReportHelper mReporter = jVar.getReporter().getMReporter();
        FrameLayout frameLayout = this$0.mBinding.f419389c;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.backArea");
        mReporter.e(frameLayout, "em_zplan_back_btn", b16);
    }

    private final void h() {
        float statusBarHeight = ImmersiveUtils.getStatusBarHeight(r0) + getContext().getResources().getDimension(R.dimen.f122771);
        ViewGroup.LayoutParams layoutParams = this.mBinding.f419389c.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        layoutParams.height = (int) statusBarHeight;
        layoutParams.width = -2;
        this.mBinding.f419389c.setLayoutParams(layoutParams);
    }

    private final void j() {
        y();
        this.mPageDataIsError = false;
        this.mUeIsError = false;
        Iterator<T> it = this.mPageDataRetryHandlerSet.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.scene.component.c) it.next()).yd();
        }
        this.mPageDataRetryHandlerSet.clear();
        n();
    }

    private final void n() {
        if (!this.mPageDataIsError && !this.mUeIsError) {
            this.mBinding.f419392f.setVisibility(0);
            this.mBinding.f419393g.setVisibility(8);
        } else {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AvatarNativeUILoading.q(AvatarNativeUILoading.this, view);
                }
            };
            this.mBinding.f419392f.setVisibility(4);
            this.mBinding.f419393g.setVisibility(0);
            this.mBinding.f419393g.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AvatarNativeUILoading this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
    }

    private final void r() {
        j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        Map<String, Object> b16 = jVar.getReporter().b();
        long j3 = this.mShowTime;
        if (j3 == 0) {
            return;
        }
        this.mShowTime = 0L;
        b16.put("zplan_loading_lvtm", String.valueOf(System.currentTimeMillis() - j3));
        QLog.i("AvatarNativeUILoading_", 1, "reportHideEvent " + b16);
        jVar.getReporter().getMReporter().b().d("ev_zplan_manual_sculpt_loading_success", b16);
    }

    private final void t() {
        this.mShowTime = System.currentTimeMillis();
        j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        Map<String, Object> b16 = jVar.getReporter().b();
        QLog.i("AvatarNativeUILoading_", 1, "reportShowEvent " + b16);
        jVar.getReporter().getMReporter().b().d("ev_zplan_manual_sculpt_loading_start", b16);
    }

    private final void u() {
        j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        Map<String, Object> b16 = jVar.getReporter().b();
        b16.put("zplan_is_loading", "1");
        ZplanViewReportHelper mReporter = jVar.getReporter().getMReporter();
        FrameLayout frameLayout = this.mBinding.f419389c;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.backArea");
        mReporter.g(frameLayout, "em_zplan_back_btn", (r16 & 4) != 0 ? null : b16, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AvatarNativeUILoading this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    private final void y() {
        ((IZPlanHotPatchApi) QRoute.api(IZPlanHotPatchApi.class)).interruptHotPatching();
        ad.f373254a.b();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.e
            @Override // java.lang.Runnable
            public final void run() {
                AvatarNativeUILoading.A();
            }
        }, 1000L);
    }

    public final void i(j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getMNativeUiLoadingShow() {
        return this.mNativeUiLoadingShow;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public boolean s(com.tencent.sqshow.zootopia.scene.component.c originHandler) {
        Intrinsics.checkNotNullParameter(originHandler, "originHandler");
        this.mPageDataIsError = true;
        this.mPageDataRetryHandlerSet.add(originHandler);
        n();
        return true;
    }

    public final void setHintText(String loadingHint) {
        Intrinsics.checkNotNullParameter(loadingHint, "loadingHint");
        this.mBinding.f419394h.setText(loadingHint);
    }

    @Override // c84.a
    public void setProgress(int progress) {
        if (this.mCurrentProgress == 100) {
            return;
        }
        this.mCurrentProgress = progress;
        B();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarNativeUILoading(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view) {
        QLog.i("AvatarNativeUILoading_", 1, "clicked!");
    }

    public final void v() {
        setVisibility(0);
        this.mNativeUiLoadingShow = true;
        t();
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.d
            @Override // java.lang.Runnable
            public final void run() {
                AvatarNativeUILoading.w(AvatarNativeUILoading.this);
            }
        });
    }

    public /* synthetic */ AvatarNativeUILoading(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void l() {
        setVisibility(8);
        this.mNativeUiLoadingShow = false;
        r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarNativeUILoading(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPageDataRetryHandlerSet = new HashSet<>();
        p g16 = p.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        URLImageView _init_$lambda$0 = g16.f419391e;
        _init_$lambda$0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String str = QQTheme.isNowThemeIsNight() ? "https://static-res.qq.com/static-res/zplan/background/zplan_bg_dark.png" : "https://static-res.qq.com/static-res/zplan/background/zplan_bg_light.png";
        Intrinsics.checkNotNullExpressionValue(_init_$lambda$0, "_init_$lambda$0");
        CommonExKt.v(_init_$lambda$0, str, R.drawable.qui_common_bg_bottom_standard_bg, null, 4, null);
        if (ZPlanQQMC.INSTANCE.enableBottomLoadingHint()) {
            g16.f419394h.setVisibility(0);
        } else {
            g16.f419394h.setVisibility(8);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarNativeUILoading.f(view);
            }
        });
        h();
        g16.f419389c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarNativeUILoading.g(context, this, view);
            }
        });
        setVisibility(8);
    }
}
