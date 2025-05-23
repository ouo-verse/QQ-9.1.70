package b03;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import b03.f;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.proavatar.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.mask.VasMaskUtils;
import com.tencent.mobileqq.vas.pendant.api.ILoadResultCallback;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.pendant.api.impl.SpecialShapeAvatarMaskLayerImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0002JX\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016\u00a8\u0006\u0017"}, d2 = {"Lb03/f;", "Lcom/tencent/mobileqq/proavatar/c;", "Lcom/tencent/qqnt/avatar/layer/d;", "", "curLayer", "", "e", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/mobileqq/proavatar/k;", "viewConfig", "Lkotlin/Function0;", "", "drawSelf", "drawableInvalidateSelf", "", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f implements com.tencent.mobileqq.proavatar.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f27646b = ar.INSTANCE.b("shouyouye", "2024-08-02", "vas_fix_special_shape_draw_abnormal").isEnable(true);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Paint f27647c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<String> f27648d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJD\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lb03/f$a;", "", "Landroid/graphics/Rect;", "bounds", "", "uin", "", "specialShapeMaskId", "Lkotlin/Function0;", "", "drawableInvalidateSelf", "Landroid/graphics/Canvas;", PM.CANVAS, "drawSelf", "", "b", "", "MASK_RATIO", UserInfo.SEX_FEMALE, "TAG", "Ljava/lang/String;", "fixShapeDrawAbnormal", "Z", "Landroid/graphics/Paint;", "maskPaint", "Landroid/graphics/Paint;", "", "taskHashMap", "Ljava/util/List;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: b03.f$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"b03/f$a$a", "Lcom/tencent/mobileqq/vas/pendant/api/ILoadResultCallback;", "", "code", "", "message", "", "onFailure", "onSuccess", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: b03.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0083a implements ILoadResultCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f27649a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f27650b;

            C0083a(String str, Function0<Unit> function0) {
                this.f27649a = str;
                this.f27650b = function0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(String uin, Function0 drawableInvalidateSelf) {
                Intrinsics.checkNotNullParameter(uin, "$uin");
                Intrinsics.checkNotNullParameter(drawableInvalidateSelf, "$drawableInvalidateSelf");
                f.f27648d.add(uin);
                drawableInvalidateSelf.invoke();
            }

            @Override // com.tencent.mobileqq.vas.pendant.api.ILoadResultCallback
            public void onFailure(int code, @NotNull String message) {
                Intrinsics.checkNotNullParameter(message, "message");
            }

            @Override // com.tencent.mobileqq.vas.pendant.api.ILoadResultCallback
            public void onSuccess() {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final String str = this.f27649a;
                final Function0<Unit> function0 = this.f27650b;
                uIHandlerV2.post(new Runnable() { // from class: b03.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.Companion.C0083a.b(str, function0);
                    }
                });
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b(Rect bounds, String uin, int specialShapeMaskId, Function0<Unit> drawableInvalidateSelf, Canvas canvas, Function0<Unit> drawSelf) {
            int width = bounds.width();
            int height = bounds.height();
            if (width == 0 || height == 0) {
                return false;
            }
            float f16 = width;
            float f17 = f16 * 1.0f;
            float f18 = height;
            float f19 = f18 * 1.0f;
            ISpecialShapeAvatarMaskLayer iSpecialShapeAvatarMaskLayer = (ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Bitmap maskLayer = iSpecialShapeAvatarMaskLayer.getMaskLayer(context, uin, specialShapeMaskId, (int) f17, (int) f19);
            if (maskLayer == null) {
                ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).startLoadLayer(uin, specialShapeMaskId, new C0083a(uin, drawableInvalidateSelf));
                return false;
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, f17, f19, null);
            drawSelf.invoke();
            if (f.f27646b) {
                canvas.drawBitmap(maskLayer, new Rect(0, 0, maskLayer.getWidth(), maskLayer.getHeight()), bounds, f.f27647c);
            } else {
                float f26 = 2;
                canvas.drawBitmap(maskLayer, (f16 - f17) / f26, (f18 - f19) / f26, f.f27647c);
            }
            canvas.restoreToCount(saveLayer);
            return true;
        }

        Companion() {
        }
    }

    static {
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        f27647c = paint;
        f27648d = new ArrayList();
    }

    private final int e(com.tencent.qqnt.avatar.layer.d<? extends Object> curLayer) {
        com.tencent.qqnt.avatar.bean.a b16 = curLayer.b();
        int i3 = 0;
        if (b16 instanceof com.tencent.qqnt.avatar.meta.b) {
            com.tencent.qqnt.avatar.bean.a b17 = curLayer.b();
            Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.qqnt.avatar.meta.MetaAvatarBean");
            i3 = ((com.tencent.qqnt.avatar.meta.b) b17).i("vas_mask_id", 0);
        } else if (b16 instanceof com.tencent.mobileqq.avatar.utils.e) {
            com.tencent.qqnt.avatar.bean.a b18 = curLayer.b();
            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mobileqq.avatar.utils.VasAvatarBean");
            i3 = ((com.tencent.mobileqq.avatar.utils.e) b18).k();
        }
        if (i3 == 0) {
            return VasMaskUtils.INSTANCE.getDefSpecialShapeMaskId(curLayer.b().c());
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
    
        if (r12 == true) goto L12;
     */
    @Override // com.tencent.mobileqq.proavatar.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NotNull com.tencent.qqnt.avatar.layer.d<? extends Object> curLayer, @NotNull Canvas canvas, @NotNull Rect bounds, @Nullable Paint paint, @Nullable k viewConfig, @NotNull Function0<Unit> drawSelf, @NotNull Function0<Unit> drawableInvalidateSelf) {
        boolean z16;
        int e16;
        Intrinsics.checkNotNullParameter(curLayer, "curLayer");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(drawSelf, "drawSelf");
        Intrinsics.checkNotNullParameter(drawableInvalidateSelf, "drawableInvalidateSelf");
        if (SpecialShapeAvatarMaskLayerImpl.INSTANCE.b() && curLayer.b().b() != 3) {
            if (viewConfig != null) {
                boolean b16 = viewConfig.b();
                z16 = true;
            }
            z16 = false;
            if (z16 || (e16 = e(curLayer)) <= 0) {
                return false;
            }
            try {
                Companion companion = INSTANCE;
                String c16 = curLayer.b().c();
                Intrinsics.checkNotNull(c16);
                return companion.b(bounds, c16, e16, drawableInvalidateSelf, canvas, drawSelf);
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
