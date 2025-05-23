package com.tencent.mobileqq.proavatar.mask;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.proavatar.c;
import com.tencent.mobileqq.proavatar.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.layer.d;
import com.tencent.qqnt.avatar.meta.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002JX\u0010\u0016\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/proavatar/mask/FrameAvatarMask;", "Lcom/tencent/mobileqq/proavatar/c;", "", "frameSize", "frameColor", "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Canvas;", PM.CANVAS, "Lkotlin/Function0;", "", "drawSelf", "", "b", "Lcom/tencent/qqnt/avatar/layer/d;", "", "curLayer", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/mobileqq/proavatar/k;", "viewConfig", "drawableInvalidateSelf", "a", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class FrameAvatarMask implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Paint> f259652b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/proavatar/mask/FrameAvatarMask$a;", "", "", "DEFAULT_COLOR", "I", "", "TAG", "Ljava/lang/String;", "Lkotlin/Lazy;", "Landroid/graphics/Paint;", "maskPaint", "Lkotlin/Lazy;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.mask.FrameAvatarMask$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Paint> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18005);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(FrameAvatarMask$Companion$maskPaint$1.INSTANCE);
        f259652b = lazy;
    }

    public FrameAvatarMask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(int frameSize, int frameColor, Rect bounds, Canvas canvas, Function0<Unit> drawSelf) {
        int width;
        int height;
        float coerceAtMost;
        if (frameSize <= 0) {
            return false;
        }
        if (ProAvatarComponentUtils.k()) {
            width = bounds.width();
        } else {
            width = canvas.getWidth();
        }
        if (ProAvatarComponentUtils.k()) {
            height = bounds.height();
        } else {
            height = canvas.getHeight();
        }
        if (width <= 0 || height <= 0) {
            return false;
        }
        float f16 = width;
        float f17 = f16 * 0.5f;
        float f18 = height;
        float f19 = f18 * 0.5f;
        float f26 = frameSize;
        if (f26 >= f17 || f26 >= f19) {
            f26 = Math.min(f17, f19) * 0.2f;
        }
        if (f26 <= 0.0f) {
            return false;
        }
        try {
            f259652b.getValue().setColor(frameColor);
        } catch (Exception unused) {
            f259652b.getValue().setColor(-1);
        }
        float f27 = (f17 - f26) / f17;
        float f28 = (f19 - f26) / f19;
        float f29 = f16 / 2.0f;
        float f36 = f18 / 2.0f;
        if (ProAvatarComponentUtils.k()) {
            Lazy<Paint> lazy = f259652b;
            lazy.getValue().setStrokeWidth(f26);
            lazy.getValue().setStyle(Paint.Style.STROKE);
            float f37 = 2;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(f16, f18);
            canvas.drawCircle(f29, f36, (coerceAtMost / f37) - (f26 / f37), lazy.getValue());
        } else {
            Lazy<Paint> lazy2 = f259652b;
            lazy2.getValue().setStyle(Paint.Style.FILL);
            float f38 = 2;
            float f39 = f16 / f38;
            float f46 = f18 / f38;
            canvas.drawOval(f29 - f39, f36 - f46, f29 + f39, f36 + f46, lazy2.getValue());
        }
        canvas.save();
        canvas.scale(f27, f28, f17, f19);
        drawSelf.invoke();
        canvas.restore();
        return true;
    }

    @Override // com.tencent.mobileqq.proavatar.c
    public boolean a(@NotNull d<? extends Object> curLayer, @NotNull Canvas canvas, @NotNull Rect bounds, @Nullable Paint paint, @Nullable k viewConfig, @NotNull Function0<Unit> drawSelf, @NotNull Function0<Unit> drawableInvalidateSelf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, curLayer, canvas, bounds, paint, viewConfig, drawSelf, drawableInvalidateSelf)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(curLayer, "curLayer");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(drawSelf, "drawSelf");
        Intrinsics.checkNotNullParameter(drawableInvalidateSelf, "drawableInvalidateSelf");
        if (viewConfig != null && b(viewConfig.d(), viewConfig.c(), bounds, canvas, drawSelf)) {
            return true;
        }
        if (!(curLayer.b() instanceof b)) {
            return false;
        }
        com.tencent.qqnt.avatar.bean.a b16 = curLayer.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.avatar.meta.MetaAvatarBean");
        b bVar = (b) b16;
        return b(bVar.i(FaceConstant.KEY_PRO_AVATAR_FRAME_SIZE, 0), bVar.i(FaceConstant.KEY_PRO_AVATAR_FRAME_COLOR, -1), bounds, canvas, drawSelf);
    }
}
