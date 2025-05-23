package com.tencent.mobileqq.vas.kuikly;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieImageAsset;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import i01.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001\nB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016JI\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u0011H\u0016R;\u0010\u0016\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R;\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasLottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "Li01/c;", "", "u", "", "propKey", "", "propValue", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "animatorStartListener", BdhLogUtil.LogTag.Tag_Conn, "animatorEndListener", "D", "Ljava/lang/String;", "_scaleType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasLottieAnimationView extends LottieAnimationView implements i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> animatorEndListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String _scaleType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> animatorStartListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasLottieAnimationView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this._scaleType = "";
        setScaleType(ImageView.ScaleType.FIT_XY);
        addAnimatorListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap t(String path, LottieImageAsset lottieImageAsset) {
        Intrinsics.checkNotNullParameter(path, "$path");
        String str = path + File.separator + lottieImageAsset.getFileName();
        if (!new File(str).exists()) {
            QLog.e("VasLottieAnimationView", 1, "fetchBitmap  bitmapPath is not exists: " + str);
            return null;
        }
        return LottieHelper.a(str);
    }

    private final void u() {
        String str = this._scaleType;
        int hashCode = str.hashCode();
        if (hashCode != -1362001767) {
            if (hashCode != -797304696) {
                if (hashCode == 727618043 && str.equals("aspectFill")) {
                    setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                }
                return;
            }
            if (str.equals(PTSNodeAttributeConstant.MODE_SCALE_TO_FILL)) {
                setScaleType(ImageView.ScaleType.FIT_XY);
                return;
            }
            return;
        }
        if (str.equals("aspectFit")) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        boolean z16;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1877911644:
                if (propKey.equals("scaleType")) {
                    this._scaleType = (String) propValue;
                    u();
                    return true;
                }
                break;
            case -1001078227:
                if (propKey.equals("progress")) {
                    setProgress(((Float) propValue).floatValue());
                    return true;
                }
                break;
            case -878289888:
                if (propKey.equals("imagePath")) {
                    final String str = (String) propValue;
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.vas.kuikly.s
                            @Override // com.airbnb.lottie.ImageAssetDelegate
                            public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                                Bitmap t16;
                                t16 = VasLottieAnimationView.t(str, lottieImageAsset);
                                return t16;
                            }
                        });
                    } else {
                        setImageAssetDelegate(null);
                    }
                    return true;
                }
                break;
            case -867346454:
                if (propKey.equals("animationFromFile")) {
                    setAnimation(new FileInputStream((String) propValue), "kuikly-" + propValue.hashCode());
                    return true;
                }
                break;
            case -867217578:
                if (propKey.equals("animationFromJson")) {
                    setAnimationFromJson((String) propValue, "kuikly-" + propValue.hashCode());
                    return true;
                }
                break;
            case 110583105:
                if (propKey.equals("animationFromUrl")) {
                    setAnimationFromUrl((String) propValue, "kuikly-" + propValue.hashCode());
                    return true;
                }
                break;
            case 353786527:
                if (propKey.equals("minProgress")) {
                    setMinProgress(((Float) propValue).floatValue());
                    return true;
                }
                break;
            case 1031219121:
                if (propKey.equals("maxProgress")) {
                    setMaxProgress(((Float) propValue).floatValue());
                    return true;
                }
                break;
            case 1159370206:
                if (propKey.equals("repeatMode")) {
                    if (Intrinsics.areEqual(propValue, "restart")) {
                        setRepeatMode(1);
                    } else if (Intrinsics.areEqual(propValue, "reverse")) {
                        setRepeatMode(2);
                    }
                    return true;
                }
                break;
            case 1571519540:
                if (propKey.equals("repeatCount")) {
                    setRepeatCount(((Integer) propValue).intValue());
                    return true;
                }
                break;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1453954796:
                if (method.equals("setAnimationStartListener")) {
                    this.animatorStartListener = callback;
                    return Unit.INSTANCE;
                }
                break;
            case -1296995794:
                if (method.equals("pauseAnimation")) {
                    pauseAnimation();
                    return Unit.INSTANCE;
                }
                break;
            case 85887754:
                if (method.equals("getDuration")) {
                    if (callback != null) {
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("duration", Long.valueOf(getDuration())));
                        callback.invoke(mapOf);
                    }
                    return Unit.INSTANCE;
                }
                break;
            case 681804813:
                if (method.equals("setAnimationEndListener")) {
                    this.animatorEndListener = callback;
                    return Unit.INSTANCE;
                }
                break;
            case 868223664:
                if (method.equals(QZoneJsConstants.METHOD_PLAY)) {
                    playAnimation();
                    return Unit.INSTANCE;
                }
                break;
            case 1236882903:
                if (method.equals("resumeAnimation")) {
                    resumeAnimation();
                    return Unit.INSTANCE;
                }
                break;
            case 1379317290:
                if (method.equals("cancelAnimation")) {
                    cancelAnimation();
                    setProgress(0.0f);
                    return Unit.INSTANCE;
                }
                break;
        }
        return c.a.b(this, method, params, callback);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasLottieAnimationView$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            Map mapOf;
            QLog.i("VasLottieAnimationView", 1, "animation end");
            Function1 function1 = VasLottieAnimationView.this.animatorEndListener;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("event", "end"));
                function1.invoke(mapOf);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            Map mapOf;
            QLog.i("VasLottieAnimationView", 1, "animation start");
            Function1 function1 = VasLottieAnimationView.this.animatorStartListener;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("event", "start"));
                function1.invoke(mapOf);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
