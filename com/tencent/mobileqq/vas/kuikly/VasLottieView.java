package com.tencent.mobileqq.vas.kuikly;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasLottieView;", "Lcom/airbnb/lottie/LottieAnimationView;", "Li01/c;", "", "u", "Lcom/airbnb/lottie/LottieComposition;", "composition", "t", "", "propKey", "", "propValue", "", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "jsonPath", BdhLogUtil.LogTag.Tag_Conn, "imagePath", "", "D", "I", "animIndex", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasLottieView extends LottieAnimationView implements i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String imagePath;

    /* renamed from: D, reason: from kotlin metadata */
    private int animIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jsonPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasLottieView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.jsonPath = "";
        this.imagePath = "";
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private final void t(LottieComposition composition) {
        setComposition(composition);
        setProgress(0.0f);
        setRepeatCount(-1);
        playAnimation();
    }

    private final void u() {
        boolean z16;
        boolean z17 = false;
        if (this.jsonPath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.imagePath.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                this.animIndex++;
                cancelAnimation();
                setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.vas.kuikly.t
                    @Override // com.airbnb.lottie.ImageAssetDelegate
                    public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                        Bitmap v3;
                        v3 = VasLottieView.v(VasLottieView.this, lottieImageAsset);
                        return v3;
                    }
                });
                try {
                    final int i3 = this.animIndex;
                    LottieComposition.Factory.fromInputStream(new FileInputStream(this.jsonPath), new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.vas.kuikly.u
                        @Override // com.airbnb.lottie.OnCompositionLoadedListener
                        public final void onCompositionLoaded(LottieComposition lottieComposition) {
                            VasLottieView.w(i3, this, lottieComposition);
                        }
                    });
                    return;
                } catch (Exception e16) {
                    QLog.e("VasLottieView", 1, ColorScreenJsPlugin.BUSINESS_NAME, e16);
                    return;
                }
            }
        }
        QLog.e("VasLottieView", 1, "jsonPath=" + this.jsonPath + " imagePath=" + this.imagePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap v(VasLottieView this$0, LottieImageAsset lottieImageAsset) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.imagePath + File.separator + lottieImageAsset.getFileName();
        if (!new File(str).exists()) {
            QLog.e("VasLottieView", 1, "fetchBitmap  bitmapPath is not exists: " + str);
            return null;
        }
        return LottieHelper.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final int i3, final VasLottieView this$0, final LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (lottieComposition == null) {
            QLog.d("VasLottieView", 1, "onCompositionLoaded: composition=null");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.v
                @Override // java.lang.Runnable
                public final void run() {
                    VasLottieView.x(i3, this$0, lottieComposition);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3, VasLottieView this$0, LottieComposition composition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == this$0.animIndex) {
            Intrinsics.checkNotNullExpressionValue(composition, "composition");
            this$0.t(composition);
        }
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "jsonPath")) {
            this.jsonPath = (String) propValue;
            u();
            return true;
        }
        if (Intrinsics.areEqual(propKey, "imagePath")) {
            this.imagePath = (String) propValue;
            u();
            return true;
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
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }
}
