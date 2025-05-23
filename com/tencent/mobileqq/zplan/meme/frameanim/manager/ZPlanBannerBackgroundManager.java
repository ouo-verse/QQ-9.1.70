package com.tencent.mobileqq.zplan.meme.frameanim.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.meme.frameanim.ZPlanAvatarBannerParams;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.view.ZPlanSuperBackgroundView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.common.model.AppTheme;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import t74.l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010'\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\"\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001b0\u001b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanBannerBackgroundManager;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/b;", "", "g", "", tl.h.F, "Lcom/tencent/zplan/common/model/AppTheme;", "appTheme", "k", "Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView$b;", "params", "j", "i", "c", "b", "a", "", PanoramaConfig.KEY_CURRENT_UIN, "d", "Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", "bannerParams", "Lmqq/util/WeakReference;", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "backgroundContainerWeak", "Landroid/content/Context;", "contextWeak", "Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView;", "Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView;", "backgroundView", "e", "Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView$b;", "currentBackgroundParam", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "backgroundDefaultDrawable", "context", "backgroundContainer", "<init>", "(Landroid/content/Context;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/zplan/meme/frameanim/i;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanBannerBackgroundManager extends com.tencent.mobileqq.zplan.meme.frameanim.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZPlanAvatarBannerParams bannerParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<FrameLayout> backgroundContainerWeak;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Context> contextWeak;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanSuperBackgroundView backgroundView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZPlanSuperBackgroundView.SuperParam currentBackgroundParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Drawable backgroundDefaultDrawable;

    public ZPlanBannerBackgroundManager(Context context, FrameLayout backgroundContainer, ZPlanAvatarBannerParams bannerParams) {
        AppTheme appTheme;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backgroundContainer, "backgroundContainer");
        Intrinsics.checkNotNullParameter(bannerParams, "bannerParams");
        this.bannerParams = bannerParams;
        this.backgroundContainerWeak = new WeakReference<>(backgroundContainer);
        this.contextWeak = new WeakReference<>(context);
        this.backgroundView = new ZPlanSuperBackgroundView(context, null, 0, 6, null);
        g();
        if (QQTheme.isNowThemeIsNight()) {
            appTheme = AppTheme.NIGHT;
        } else {
            appTheme = AppTheme.DAY;
        }
        k(appTheme);
    }

    private final void g() {
        FrameLayout frameLayout = this.backgroundContainerWeak.get();
        if (frameLayout != null) {
            frameLayout.addView(this.backgroundView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private final boolean h() {
        return this.bannerParams.getScene() == 3 || this.bannerParams.getScene() == 2;
    }

    private final void i() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_xiaowo_entrance_dongtai_background");
        hashMap.put("zplan_action_type", "imp");
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(ZPlanSuperBackgroundView.SuperParam params, AppTheme appTheme) {
        if (!params.c()) {
            k(appTheme);
            return;
        }
        if (Intrinsics.areEqual(params, this.currentBackgroundParam)) {
            i();
            QLog.w("ZPlanBannerBackgroundManager", 1, "setStaticBackground background already set, param=" + params);
            return;
        }
        try {
            this.backgroundView.x(params);
            i();
            QLog.i("ZPlanBannerBackgroundManager", 1, "setBackground param=" + params);
        } catch (Throwable th5) {
            QLog.w("ZPlanBannerBackgroundManager", 1, "setStaticBackground error", th5);
        }
    }

    private final void k(AppTheme appTheme) {
        Drawable drawable;
        try {
            Context context = this.contextWeak.get();
            if (context == null) {
                QLog.e("ZPlanBannerBackgroundManager", 1, "setDefaultBackground failed, context null: true");
                return;
            }
            AppTheme appTheme2 = AppTheme.NIGHT;
            Drawable drawable2 = null;
            if (appTheme == appTheme2) {
                drawable = context.getResources().getDrawable(R.drawable.nzx, null);
                Intrinsics.checkNotNullExpressionValue(drawable, "{\n                contex\u2026ight, null)\n            }");
            } else {
                drawable = context.getResources().getDrawable(R.drawable.nzw, null);
                Intrinsics.checkNotNullExpressionValue(drawable, "{\n                contex\u2026n_bg, null)\n            }");
            }
            this.backgroundDefaultDrawable = drawable;
            this.backgroundView.setBackgroundColor(appTheme == appTheme2 ? -16777216 : -1);
            ZPlanSuperBackgroundView zPlanSuperBackgroundView = this.backgroundView;
            Drawable drawable3 = this.backgroundDefaultDrawable;
            if (drawable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundDefaultDrawable");
                drawable3 = null;
            }
            zPlanSuperBackgroundView.setImageDrawable(drawable3);
            ZPlanSuperBackgroundView zPlanSuperBackgroundView2 = this.backgroundView;
            Drawable drawable4 = this.backgroundDefaultDrawable;
            if (drawable4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundDefaultDrawable");
            } else {
                drawable2 = drawable4;
            }
            zPlanSuperBackgroundView2.setDefaultLoadingDrawable(drawable2);
        } catch (Throwable th5) {
            QLog.w("ZPlanBannerBackgroundManager", 1, "setDefaultBackground error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String currentUin, final ZPlanBannerBackgroundManager this$0) {
        final AppTheme appTheme;
        final String str;
        Intrinsics.checkNotNullParameter(currentUin, "$currentUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QQTheme.isNowThemeIsNight()) {
            appTheme = AppTheme.NIGHT;
        } else {
            appTheme = AppTheme.DAY;
        }
        com.tencent.mobileqq.zplan.model.g userBackgroundInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserBackgroundInfo(currentUin);
        final String str2 = null;
        if (userBackgroundInfo != null) {
            str = userBackgroundInfo.g(Boolean.valueOf(appTheme == AppTheme.NIGHT));
        } else {
            str = null;
        }
        if (!this$0.h()) {
            str2 = "";
        } else if (userBackgroundInfo != null) {
            str2 = userBackgroundInfo.j(Boolean.valueOf(appTheme == AppTheme.NIGHT));
        }
        l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanBannerBackgroundManager$updateBackground$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ZPlanBannerBackgroundManager.this.j(new ZPlanSuperBackgroundView.SuperParam(str, str2), appTheme);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.b
    public void a() {
        this.backgroundView.u();
        FrameLayout frameLayout = this.backgroundContainerWeak.get();
        if (frameLayout != null) {
            frameLayout.removeView(this.backgroundView);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.b
    public void b() {
        this.backgroundView.v();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.b
    public void c() {
        this.backgroundView.w();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.b
    public void d(final String currentUin) {
        Intrinsics.checkNotNullParameter(currentUin, "currentUin");
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanBannerBackgroundManager.l(currentUin, this);
            }
        });
    }
}
