package com.tencent.mobileqq.leba.zplan.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.leba.zplan.view.ZPlanMaintainingFrameLayout;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import ni3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0002R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/leba/zplan/view/ZPlanMaintainingFrameLayout;", "Landroid/widget/FrameLayout;", "", "e", "d", "", "b", "Landroid/view/View;", "view", "g", "", "viewWidth", "viewHeight", "f", "c", "i", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mAvatarIv", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "mOnPreDrawListener", ExifInterface.LATITUDE_SOUTH, "mShowedGender", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ZPlanMaintainingFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mAvatarIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private short mShowedGender;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMaintainingFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShowedGender = (short) -1;
        LayoutInflater.from(context).inflate(R.layout.gxs, this);
        e();
        d();
    }

    private final short b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
        Card profileCardFromCache = ((IProfileDataService) runtimeService).getProfileCardFromCache(peekAppRuntime.getCurrentAccountUin());
        if (profileCardFromCache != null) {
            return profileCardFromCache.shGender;
        }
        return (short) -1;
    }

    private final void d() {
        String str;
        QLog.d("ZPlanMaintainingFrameLayout", 4, "initAvatar");
        View findViewById = findViewById(R.id.f126097nu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<URLImageView>(R.id.zplan_avatar)");
        this.mAvatarIv = (ImageView) findViewById;
        short b16 = b();
        this.mShowedGender = b16;
        if (b16 == 0) {
            str = "https://static-res.qq.com/static-res/zplan/maintenance/zplan_stop_service_male.png";
        } else {
            str = "https://static-res.qq.com/static-res/zplan/maintenance/zplan_stop_service_female.png";
        }
        ImageView imageView = this.mAvatarIv;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
            imageView = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPriority = (byte) 2;
        Drawable drawable = b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        ImageView imageView3 = this.mAvatarIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
        } else {
            imageView2 = imageView3;
        }
        g(imageView2);
    }

    private final void e() {
        QLog.d("ZPlanMaintainingFrameLayout", 4, "initBackground");
        ImageView imageView = (ImageView) findViewById(R.id.f126137ny);
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mPriority = (byte) 2;
            Drawable drawable = b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            Unit unit = Unit.INSTANCE;
            imageView.setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/zplan/maintenance/zplan_stop_service_backgroud.png", obtain));
        } catch (OutOfMemoryError e16) {
            QLog.w("ZPlanMaintainingFrameLayout", 1, "decode background error", e16);
        }
    }

    private final void f(View view, int viewWidth, int viewHeight) {
        int roundToInt;
        float min = Math.min(viewWidth / 1500.0f, viewHeight / 1920.0f) * 1.0f;
        roundToInt = MathKt__MathJVMKt.roundToInt(1920 * min);
        float f16 = (viewHeight - roundToInt) / 2;
        float f17 = (240 * min) + f16;
        float f18 = f16 + (800 * min);
        if (a.f420201a.e() == null) {
            QLog.e("ZPlanMaintainingFrameLayout", 1, "scaleAndTranslate failed, initHeight null.");
            return;
        }
        float intValue = r5.intValue() - f18;
        if (intValue + f17 < 0.0f) {
            intValue = -f17;
        }
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationY(intValue);
    }

    private final void g(final View view) {
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            f(view, view.getWidth(), view.getHeight());
        } else if (this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: a72.b
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    boolean h16;
                    h16 = ZPlanMaintainingFrameLayout.h(view, this);
                    return h16;
                }
            };
            view.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(View view, ZPlanMaintainingFrameLayout this$0) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            this$0.f(view, view.getWidth(), view.getHeight());
            view.getViewTreeObserver().removeOnPreDrawListener(this$0.mOnPreDrawListener);
            this$0.mOnPreDrawListener = null;
            return true;
        }
        return true;
    }

    /* renamed from: c, reason: from getter */
    public final short getMShowedGender() {
        return this.mShowedGender;
    }

    public final void i() {
        d();
    }
}
