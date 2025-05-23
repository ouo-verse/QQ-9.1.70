package com.tencent.mobileqq.zplan.aio.badge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.aio.badge.b;
import com.tencent.mobileqq.zplan.utils.ar;
import com.tencent.mobileqq.zplan.utils.as;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0010B!\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/i;", "", "", "themeId", "", "j", "filePath", "i", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "info", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", tl.h.F, "e", "k", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "f", "()Landroid/widget/ImageView;", "animImageView", "Lcom/tencent/mobileqq/zplan/aio/badge/b;", "c", "Lcom/tencent/mobileqq/zplan/aio/badge/b;", "g", "()Lcom/tencent/mobileqq/zplan/aio/badge/b;", "zplanBadgeUI", "Lcom/airbnb/lottie/LottieDrawable;", "d", "Lcom/airbnb/lottie/LottieDrawable;", "lottieDrawable", "", "Z", "isActive", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "redDotAppInfo", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "animatorListener", "<init>", "(Landroid/app/Activity;Landroid/widget/ImageView;Lcom/tencent/mobileqq/zplan/aio/badge/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ImageView animImageView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.aio.badge.b zplanBadgeUI;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LottieDrawable lottieDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BusinessInfoCheckUpdate.AppInfo redDotAppInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Animator.AnimatorListener animatorListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/i$a;", "", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "oldInfo", "newInfo", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.badge.i$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final boolean a(BusinessInfoCheckUpdate.AppInfo oldInfo, BusinessInfoCheckUpdate.AppInfo newInfo) {
            PBUInt32Field pBUInt32Field;
            PBUInt32Field pBUInt32Field2;
            PBUInt32Field pBUInt32Field3;
            PBUInt32Field pBUInt32Field4;
            Integer num = null;
            Integer valueOf = (oldInfo == null || (pBUInt32Field4 = oldInfo.modify_ts) == null) ? null : Integer.valueOf(pBUInt32Field4.get());
            Integer valueOf2 = (newInfo == null || (pBUInt32Field3 = newInfo.modify_ts) == null) ? null : Integer.valueOf(pBUInt32Field3.get());
            Integer valueOf3 = (oldInfo == null || (pBUInt32Field2 = oldInfo.exposure_max) == null) ? null : Integer.valueOf(pBUInt32Field2.get());
            if (newInfo != null && (pBUInt32Field = newInfo.exposure_max) != null) {
                num = Integer.valueOf(pBUInt32Field.get());
            }
            QLog.d("ZplanNormalAnimHelper", 1, "isSameModifyTs, oldTs:" + valueOf + ", newTs:" + valueOf2 + ", oldMax:" + valueOf3 + ", newMax:" + num);
            return valueOf != null && Intrinsics.areEqual(valueOf, valueOf2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aio/badge/i$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.i("ZplanNormalAnimHelper", 1, "normal, animatorListener, onAnimationEnd, active:" + i.this.isActive);
            if (i.this.isActive) {
                b.a.a(i.this.getZplanBadgeUI(), "normal-anim-end", 0, 0, null, 8, null, 40, null);
                RedTouch a16 = i.this.getZplanBadgeUI().a();
                if (a16 != null) {
                    a16.parseRedTouch(i.this.redDotAppInfo);
                }
                i.this.isActive = false;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/aio/badge/i$c", "Lcom/tencent/mobileqq/zplan/utils/as;", "", "onSuccess", "onFail", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements as {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.utils.as
        public void onFail() {
            QLog.e("ZplanNormalAnimHelper", 1, "normal, loadZplanLottieAnim fail! active:" + i.this.isActive);
            if (i.this.isActive) {
                b.a.a(i.this.getZplanBadgeUI(), "normal-anim-fail", 0, 0, null, 8, null, 40, null);
            }
        }

        @Override // com.tencent.mobileqq.zplan.utils.as
        public void onSuccess() {
            QLog.i("ZplanNormalAnimHelper", 1, "normal, loadZplanLottieAnim success! active:" + i.this.isActive);
            if (i.this.isActive) {
                ImageView animImageView = i.this.getAnimImageView();
                if (animImageView != null) {
                    i iVar = i.this;
                    ViewGroup.LayoutParams layoutParams = animImageView.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.tencent.sqshow.zootopia.utils.i.a(2.5f);
                        layoutParams2.removeRule(15);
                        layoutParams2.width = com.tencent.sqshow.zootopia.utils.i.b(34);
                        layoutParams2.height = com.tencent.sqshow.zootopia.utils.i.b(36);
                    }
                    animImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    animImageView.setPadding(0, 0, 0, 0);
                    animImageView.requestLayout();
                    animImageView.setImageDrawable(iVar.lottieDrawable);
                }
                b.a.a(i.this.getZplanBadgeUI(), "normal-anim-load", 4, 4, null, 0, null, 40, null);
                LottieDrawable lottieDrawable = i.this.lottieDrawable;
                if (lottieDrawable != null) {
                    lottieDrawable.setRepeatCount(1);
                }
                LottieDrawable lottieDrawable2 = i.this.lottieDrawable;
                if (lottieDrawable2 != null) {
                    lottieDrawable2.start();
                }
            }
        }
    }

    public i(Activity activity, ImageView imageView, com.tencent.mobileqq.zplan.aio.badge.b zplanBadgeUI) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(zplanBadgeUI, "zplanBadgeUI");
        this.activity = activity;
        this.animImageView = imageView;
        this.zplanBadgeUI = zplanBadgeUI;
        b bVar = new b();
        this.animatorListener = bVar;
        LottieDrawable lottieDrawable = new LottieDrawable();
        this.lottieDrawable = lottieDrawable;
        Intrinsics.checkNotNull(lottieDrawable);
        lottieDrawable.addAnimatorListener(bVar);
    }

    private final void i(String filePath) {
        Activity activity;
        if (this.lottieDrawable != null && (activity = this.activity) != null) {
            ar arVar = ar.f335790a;
            Intrinsics.checkNotNull(activity);
            LottieDrawable lottieDrawable = this.lottieDrawable;
            Intrinsics.checkNotNull(lottieDrawable);
            arVar.e(activity, filePath, lottieDrawable, new c());
            return;
        }
        QLog.e("ZplanNormalAnimHelper", 1, "normal, loadZplanLottieAnim fail!");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (r2.equals("2971") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r2.equals("2921") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r2.equals("2920") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        i("zplan_top_right_btn_lottie/data_night.json");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        if (r2.equals("1103") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r2.equals("3064") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        i("zplan_top_right_btn_lottie/data_black.json");
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0009. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(String themeId) {
        if (this.isActive) {
            switch (themeId.hashCode()) {
                case 1508387:
                    break;
                case 1545925:
                    break;
                case 1545926:
                    break;
                case 1546081:
                    break;
                case 1567195:
                    break;
                default:
                    i("zplan_top_right_btn_lottie/data.json");
                    return;
            }
        }
    }

    public final void e() {
        QLog.i("ZplanNormalAnimHelper", 1, "normal, clear, active:" + this.isActive);
        this.isActive = false;
        this.redDotAppInfo = null;
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.clearComposition();
        }
    }

    /* renamed from: f, reason: from getter */
    public final ImageView getAnimImageView() {
        return this.animImageView;
    }

    /* renamed from: g, reason: from getter */
    public final com.tencent.mobileqq.zplan.aio.badge.b getZplanBadgeUI() {
        return this.zplanBadgeUI;
    }

    public final void h(BusinessInfoCheckUpdate.AppInfo info, RedTouch redTouch) {
        boolean a16 = INSTANCE.a(this.redDotAppInfo, info);
        QLog.i("ZplanNormalAnimHelper", 1, "normal, handle, active:" + this.isActive + ", isSame:" + a16);
        if (a16) {
            if (redTouch != null) {
                redTouch.parseRedTouch(info);
            }
        } else {
            this.isActive = true;
            this.redDotAppInfo = info;
            this.zplanBadgeUI.c(info);
            String currentThemeId = ThemeUtil.getCurrentThemeId();
            Intrinsics.checkNotNullExpressionValue(currentThemeId, "getCurrentThemeId()");
            j(currentThemeId);
        }
    }

    public final void k() {
        QLog.i("ZplanNormalAnimHelper", 1, "normal, onPostThemeChanged, active:" + this.isActive);
        if (this.isActive) {
            String currentThemeId = ThemeUtil.getCurrentThemeId();
            Intrinsics.checkNotNullExpressionValue(currentThemeId, "getCurrentThemeId()");
            j(currentThemeId);
        }
    }
}
