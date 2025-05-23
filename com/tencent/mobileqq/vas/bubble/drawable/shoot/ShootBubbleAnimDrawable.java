package com.tencent.mobileqq.vas.bubble.drawable.shoot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010B\u001a\u00020!\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010%R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010'R\u0016\u0010*\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010)R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010'R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010'R\u0018\u00107\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010CR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u00109R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00109\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/ShootBubbleAnimDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/b;", "Lc03/a;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "f", "draw", "restart", "stop", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", "d", "Lkotlin/Function1;", "block", "setLoadedListener", "destroy", "", "p0", "setAlpha", "Landroid/graphics/ColorFilter;", "setColorFilter", "getOpacity", "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/f;", DownloadInfo.spKey_Config, "e", "g", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameData", "c", "", "time", "", "b", "a", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "I", "mFirstFrameTime", "J", "mInvalidateTimeMs", h.F, "mLoopCount", "i", "mFrameCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCurLooper", BdhLogUtil.LogTag.Tag_Conn, "mShouldFrameIndex", "D", "mCurFrameIndex", "E", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "mListener", "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/e;", "producer", "Lf03/d;", "G", "Lf03/d;", "shootAnimationConfig", "H", "Z", "isDirectLeft", "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/f;", "curDrawableConfig", "", "startXPx", "K", "startYPx", "<init>", "(FFLf03/d;Z)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ShootBubbleAnimDrawable extends Drawable implements com.tencent.cachedrawable.dynamicdrawable.b, c03.a {

    /* renamed from: C, reason: from kotlin metadata */
    private int mShouldFrameIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private int mCurFrameIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private d.a mListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private e producer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private f03.d shootAnimationConfig;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isDirectLeft;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private f curDrawableConfig;

    /* renamed from: J, reason: from kotlin metadata */
    private float startXPx;

    /* renamed from: K, reason: from kotlin metadata */
    private float startYPx;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mFirstFrameTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mInvalidateTimeMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mLoopCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mFrameCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCurLooper;

    public ShootBubbleAnimDrawable(float f16, float f17, @NotNull f03.d shootAnimationConfig, boolean z16) {
        Intrinsics.checkNotNullParameter(shootAnimationConfig, "shootAnimationConfig");
        this.mPaint = new Paint();
        this.mLoopCount = 1;
        this.shootAnimationConfig = shootAnimationConfig;
        this.isDirectLeft = z16;
        this.startXPx = f16;
        this.startYPx = f17;
    }

    private final void f(Canvas canvas) {
        Set<XARect> b16;
        f fVar = this.curDrawableConfig;
        if (fVar != null) {
            Paint paint = this.mPaint;
            if (paint != null) {
                Intrinsics.checkNotNull(fVar);
                paint.setAlpha((int) (fVar.getAlpha() * 255));
            }
            f fVar2 = this.curDrawableConfig;
            if (fVar2 != null && (b16 = fVar2.b()) != null) {
                for (XARect xARect : b16) {
                    Rect rect = new Rect((int) xARect.getX(), (int) xARect.getY(), (int) (xARect.getX() + xARect.getW()), (int) (xARect.getY() + xARect.getH()));
                    int save = canvas.save();
                    Bitmap bitmap = xARect.getBitmap();
                    if (bitmap != null) {
                        canvas.rotate(xARect.getRotate(), xARect.a(), xARect.b());
                        canvas.drawBitmap(bitmap, (Rect) null, rect, this.mPaint);
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.b
    public boolean b(long time) {
        long j3 = (time - this.mFirstFrameTime) / this.mInvalidateTimeMs;
        if (this.mLoopCount > 0) {
            j3 = Math.min(j3, (r0 * this.mFrameCount) - 1);
        }
        int i3 = this.mFrameCount;
        this.mCurLooper = (int) ((1 + j3) / i3);
        int i16 = (int) (j3 % i3);
        this.mShouldFrameIndex = i16;
        if (this.mCurFrameIndex != i16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.b
    public void c(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameData) {
        Intrinsics.checkNotNullParameter(frameData, "frameData");
    }

    @Override // c03.a
    public void d(@NotNull d.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    @Override // c03.a
    public void destroy() {
        e eVar = this.producer;
        if (eVar != null) {
            eVar.destroy();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        int i3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.producer == null) {
            e eVar = new e(this.startXPx, this.startYPx, canvas.getWidth(), canvas.getHeight(), this.shootAnimationConfig, this.isDirectLeft);
            this.producer = eVar;
            Intrinsics.checkNotNull(eVar);
            this.mFrameCount = eVar.h();
            e eVar2 = this.producer;
            Intrinsics.checkNotNull(eVar2);
            this.mInvalidateTimeMs = eVar2.i();
            e eVar3 = this.producer;
            Intrinsics.checkNotNull(eVar3);
            eVar3.l(this);
        }
        if (Intrinsics.compare(this.mFirstFrameTime, 0) == 0) {
            this.mFirstFrameTime = (int) SystemClock.uptimeMillis();
            d.a aVar = this.mListener;
            if (aVar != null) {
                aVar.onStart();
            }
        }
        int i16 = this.mLoopCount;
        if (i16 != -1 && (i3 = this.mCurLooper) >= i16) {
            if (i3 == i16) {
                d.a aVar2 = this.mListener;
                if (aVar2 != null) {
                    aVar2.onEnd();
                }
                this.mListener = null;
                e eVar4 = this.producer;
                if (eVar4 != null) {
                    eVar4.destroy();
                }
            }
        } else {
            int i17 = this.mShouldFrameIndex;
            int i18 = this.mCurFrameIndex;
            if (i17 == i18) {
                e eVar5 = this.producer;
                if (eVar5 != null) {
                    eVar5.b((i18 + 1) % this.mFrameCount);
                }
            } else {
                this.mCurFrameIndex = i17;
                e eVar6 = this.producer;
                if (eVar6 != null) {
                    eVar6.b(i17);
                }
            }
        }
        f(canvas);
    }

    public final void e(@NotNull f config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.curDrawableConfig = config;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            invalidateSelf();
        } else {
            com.tencent.qqnt.aio.util.d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.shoot.ShootBubbleAnimDrawable$consumerConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    ShootBubbleAnimDrawable.this.invalidateSelf();
                }
            });
        }
    }

    /* renamed from: g, reason: from getter */
    public final int getMFirstFrameTime() {
        return this.mFirstFrameTime;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int p06) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setAlpha(p06);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter p06) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColorFilter(p06);
        }
    }

    @Override // c03.a
    public void setLoadedListener(@NotNull Function1<? super c03.a, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.b
    public void a() {
    }

    @Override // c03.a
    public void restart() {
    }

    @Override // c03.a
    public void stop() {
    }
}
