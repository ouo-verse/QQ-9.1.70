package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ApolloLottieAnim;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyLottieView extends FrameLayout implements HippyViewBase {
    public static final String D = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/{LOTTIE_ZIP_HASHCODE}" + File.separator;
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private VasLottieAnimationView f309507d;

    /* renamed from: e, reason: collision with root package name */
    private ApolloLottieAnim f309508e;

    /* renamed from: f, reason: collision with root package name */
    private String f309509f;

    /* renamed from: h, reason: collision with root package name */
    private int f309510h;

    /* renamed from: i, reason: collision with root package name */
    private int f309511i;

    /* renamed from: m, reason: collision with root package name */
    private int f309512m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements LottieListener<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th5) {
            QLog.e("HippyLottieView", 2, "onReqFailed " + th5);
        }
    }

    public HippyLottieView(Context context) {
        super(context);
        c(context);
    }

    private void c(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.f169172i33, this);
        VasLottieAnimationView vasLottieAnimationView = (VasLottieAnimationView) findViewById(R.id.f166150yv0);
        this.f309507d = vasLottieAnimationView;
        vasLottieAnimationView.setFailureListener(new a());
    }

    public void a() {
        QLog.d("HippyLottieView", 1, "HippyLottieView destroy");
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.destroyDrawingCache();
        }
    }

    public void b(HippyMap hippyMap) {
        QLog.d("HippyLottieView", 1, "HippyLottieView init");
        if (this.f309507d != null) {
            h();
        }
    }

    public void d() {
        if (this.f309507d != null && this.f309510h <= this.f309511i) {
            if (!TextUtils.isEmpty(this.f309509f)) {
                try {
                    this.f309507d.setAnimationFromUrl(this.f309509f);
                } catch (OutOfMemoryError e16) {
                    QLog.e("HippyLottieView", 1, e16, new Object[0]);
                }
            }
            this.f309507d.setMinFrame(0);
            this.f309507d.setMaxFrame(this.f309511i);
            this.f309507d.setMinFrame(this.f309510h);
            this.f309507d.setRepeatCount(this.f309512m);
            this.f309507d.setSpeed(this.C);
        }
    }

    public void e() {
        QLog.d("HippyLottieView", 1, "HippyLottieView pause");
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.pauseAnimation();
        }
    }

    public void f() {
        QLog.d("HippyLottieView", 1, "HippyLottieView play");
        d();
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.playAnimation();
        }
    }

    public void g(int i3, int i16) {
        QLog.d("HippyLottieView", 1, "HippyLottieView play startFrame:", Integer.valueOf(i3), ",endFrame:", Integer.valueOf(i16));
        this.f309510h = i3;
        this.f309511i = i16;
        d();
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.playAnimation();
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public void h() {
        QLog.d("HippyLottieView", 1, "HippyLottieView postDraw");
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public void i() {
        QLog.d("HippyLottieView", 1, "HippyLottieView resume");
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.resumeAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (getChildAt(0) != null) {
            getChildAt(0).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildAt(0) != null) {
            getChildAt(0).measure(i3, i16);
        }
    }

    public void setEndFrame(int i3) {
        this.f309511i = i3;
    }

    public void setFitFullScreenXY() {
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    public void setFrame(int i3) {
        QLog.d("HippyLottieView", 1, "HippyLottieView setFrame");
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.setFrame(i3);
        }
    }

    public void setProgress(float f16) {
        QLog.d("HippyLottieView", 1, "HippyLottieView setProgress");
        VasLottieAnimationView vasLottieAnimationView = this.f309507d;
        if (vasLottieAnimationView != null) {
            vasLottieAnimationView.setProgress(f16);
        }
    }

    public void setRepeatCount(int i3) {
        this.f309512m = i3;
    }

    public void setSpeed(int i3) {
        this.C = i3;
    }

    public void setSrc(String str) {
        this.f309509f = str;
    }

    public void setStartFrame(int i3) {
        this.f309510h = i3;
    }

    public void setZipSrc(@NotNull String str) {
        if (this.f309508e == null) {
            this.f309508e = new ApolloLottieAnim(null, getContext());
        }
        try {
            String replace = D.replace("{LOTTIE_ZIP_HASHCODE}", str.hashCode() + "");
            if (this.f309508e.j(replace)) {
                this.f309508e.f(getContext(), this.f309507d, replace, true);
            } else {
                this.f309508e.h(this.f309507d, str, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/{LOTTIE_ZIP_HASHCODE}.zip".replace("{LOTTIE_ZIP_HASHCODE}", str.hashCode() + ""), true);
            }
        } catch (Exception e16) {
            QLog.e("HippyLottieView", 1, "setZipSrc Exception:" + e16);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
