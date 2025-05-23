package com.tencent.mobileqq.profilecard.view.vas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 62\u00020\u0001:\u0003678B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J0\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020'H\u0014J\u0012\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020!H\u0002J.\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00101\u001a\u00020'J \u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020'H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "workHandler", "Landroid/os/Handler;", "isFront", "", "(Landroid/content/Context;Landroid/os/Handler;Z)V", "bottomSolid", "Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidToPlaneHelper;", "duration", "", "lastUpdateTimeMillis", "meshBgColors", "", "meshFgColors", "meshVerts", "", "paintBG", "Landroid/graphics/Paint;", "startTimeMillis", "texture", "Landroid/graphics/Bitmap;", "topSolid", "updateTask", "Ljava/lang/Runnable;", "waitUpdate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "xDegree", "", "zDegree", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "postTask", "setTexture", "bm", "filterColor", "update", "yDegree", "updateSolid", "viewWidth", "Companion", "SolidToPlaneHelper", "SolidVertex", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SurroundView extends View {
    public static final int NUMS = 100;
    private final SolidToPlaneHelper bottomSolid;
    private long duration;
    private final boolean isFront;
    private long lastUpdateTimeMillis;
    private final int[] meshBgColors;
    private final int[] meshFgColors;
    private final float[] meshVerts;
    private final Paint paintBG;
    private long startTimeMillis;
    private Bitmap texture;
    private final SolidToPlaneHelper topSolid;
    private final Runnable updateTask;
    private final AtomicBoolean waitUpdate;
    private final Handler workHandler;
    private double xDegree;
    private double zDegree;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;", "", HippyTKDListViewAdapter.X, "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(DDD)V", "getX", "()D", "setX", "(D)V", "getY", "setY", "getZ", "setZ", "copyFrom", "", "dst", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class SolidVertex {
        private double x;
        private double y;
        private double z;

        public SolidVertex(double d16, double d17, double d18) {
            this.x = d16;
            this.y = d17;
            this.z = d18;
        }

        public final void copyFrom(SolidVertex dst) {
            Intrinsics.checkNotNullParameter(dst, "dst");
            this.x = dst.x;
            this.y = dst.y;
            this.z = dst.z;
        }

        public final double getX() {
            return this.x;
        }

        public final double getY() {
            return this.y;
        }

        public final double getZ() {
            return this.z;
        }

        public final void setX(double d16) {
            this.x = d16;
        }

        public final void setY(double d16) {
            this.y = d16;
        }

        public final void setZ(double d16) {
            this.z = d16;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurroundView(Context context, Handler handler, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.workHandler = handler;
        this.isFront = z16;
        Paint paint = new Paint();
        this.paintBG = paint;
        this.duration = 5000L;
        this.topSolid = new SolidToPlaneHelper(100, 0.0d, 0.0d, 6, null);
        this.bottomSolid = new SolidToPlaneHelper(100, 0.0d, 0.0d, 6, null);
        this.meshVerts = new float[404];
        this.meshBgColors = new int[202];
        this.meshFgColors = new int[202];
        this.waitUpdate = new AtomicBoolean(false);
        this.updateTask = new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.a
            @Override // java.lang.Runnable
            public final void run() {
                SurroundView.updateTask$lambda$0(SurroundView.this);
            }
        };
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f, -1.0f, 0.0f, 100.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f});
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        paint.getXfermode();
    }

    private final void postTask() {
        Handler handler = this.workHandler;
        if (handler == null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).runOnUiThread(this.updateTask);
            return;
        }
        handler.post(this.updateTask);
    }

    private final void update(double yDegree, double xDegree, double zDegree) {
        SolidVertex[] dstVertexs;
        SolidVertex[] dstVertexs2;
        synchronized (this.topSolid) {
            dstVertexs = this.topSolid.task().rotateByY(yDegree).rotateByX(xDegree).rotateByZ(zDegree).getDstVertexs();
            dstVertexs2 = this.bottomSolid.task().rotateByY(yDegree).rotateByX(xDegree).rotateByZ(zDegree).getDstVertexs();
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.meshVerts) {
            int length = this.meshVerts.length / 2;
            int length2 = this.meshBgColors.length / 2;
            for (int i3 = 0; i3 < 101; i3++) {
                int i16 = i3 * 2;
                this.meshVerts[i16] = (float) dstVertexs[i3].getX();
                this.meshVerts[i16 + 1] = (float) dstVertexs[i3].getY();
                this.meshVerts[length + i16] = (float) dstVertexs2[i3].getX();
                this.meshVerts[length + 1 + i16] = (float) dstVertexs2[i3].getY();
                if (dstVertexs[i3].getZ() < 0.0d) {
                    int[] iArr = this.meshBgColors;
                    iArr[i3] = -1;
                    int i17 = length2 + i3;
                    iArr[i17] = -1;
                    int[] iArr2 = this.meshFgColors;
                    iArr2[i3] = 16777215;
                    iArr2[i17] = 16777215;
                } else {
                    int[] iArr3 = this.meshBgColors;
                    iArr3[i3] = 16777215;
                    int i18 = length2 + i3;
                    iArr3[i18] = 16777215;
                    int[] iArr4 = this.meshFgColors;
                    iArr4[i3] = -1;
                    iArr4[i18] = -1;
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void updateSolid(int viewWidth) {
        if (this.texture == null) {
            return;
        }
        synchronized (this.topSolid) {
            double d16 = viewWidth / 2.2d;
            this.topSolid.reInit(d16, -(r0.getHeight() / 3));
            this.bottomSolid.reInit(d16, r0.getHeight() / 3);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTask$lambda$0(SurroundView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long uptimeMillis = SystemClock.uptimeMillis();
        this$0.lastUpdateTimeMillis = uptimeMillis;
        long j3 = uptimeMillis - this$0.startTimeMillis;
        long j16 = this$0.duration;
        this$0.update((((float) (j3 % j16)) / ((float) j16)) * 360.0d, this$0.xDegree, this$0.zDegree);
        this$0.waitUpdate.set(true);
        this$0.postInvalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.texture;
        if (bitmap == null) {
            super.draw(canvas);
            return;
        }
        if (!this.isFront) {
            canvas.save();
            canvas.translate(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f);
            synchronized (this.meshVerts) {
                canvas.drawBitmapMesh(bitmap, 100, 1, this.meshVerts, 0, this.meshBgColors, 0, this.paintBG);
                Unit unit = Unit.INSTANCE;
            }
            canvas.restore();
        }
        super.draw(canvas);
        if (this.isFront) {
            canvas.save();
            canvas.translate(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f);
            synchronized (this.meshVerts) {
                canvas.drawBitmapMesh(bitmap, 100, 1, this.meshVerts, 0, this.meshFgColors, 0, null);
                Unit unit2 = Unit.INSTANCE;
            }
            canvas.restore();
        }
        if (this.waitUpdate.compareAndSet(true, false) || SystemClock.uptimeMillis() - this.lastUpdateTimeMillis > 3000) {
            postTask();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            updateSolid(right - left);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public final void setTexture(Bitmap bm5, double xDegree, double zDegree, long duration, int filterColor) {
        Intrinsics.checkNotNullParameter(bm5, "bm");
        this.texture = bm5;
        this.xDegree = xDegree;
        this.zDegree = zDegree;
        this.startTimeMillis = SystemClock.uptimeMillis();
        this.duration = duration;
        this.paintBG.setColorFilter(new LightingColorFilter(0, filterColor));
        updateSolid(getWidth());
        postTask();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidToPlaneHelper;", "", "numsX", "", "solidX", "", "solidY", "(IDD)V", "getNumsX", "()I", "originVertexes", "", "Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;", "[Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;", "outputVertexes", "reInit", "", "task", "Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidToPlaneHelper$RotateTask;", "RotateTask", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class SolidToPlaneHelper {
        private final int numsX;
        private final SolidVertex[] originVertexes;
        private final SolidVertex[] outputVertexes;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidToPlaneHelper$RotateTask;", "", "originVertexs", "", "Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;", "dstVertexs", "([Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;[Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;)V", "[Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;", "finish", "()[Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;", "rotateByX", "degree", "", "rotateByY", "rotateByZ", "Companion", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class RotateTask {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final SolidVertex[] dstVertexs;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidToPlaneHelper$RotateTask$Companion;", "", "()V", "rotateByX", "", TtmlNode.ATTR_TTS_ORIGIN, "Lcom/tencent/mobileqq/profilecard/view/vas/SurroundView$SolidVertex;", "dst", "degree", "", "rotateByY", "rotateByZ", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes35.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final void rotateByX(SolidVertex origin, SolidVertex dst, double degree) {
                    Intrinsics.checkNotNullParameter(origin, "origin");
                    Intrinsics.checkNotNullParameter(dst, "dst");
                    double radians = Math.toRadians(degree);
                    double x16 = origin.getX();
                    double y16 = (origin.getY() * Math.cos(radians)) - (origin.getZ() * Math.sin(radians));
                    double z16 = (origin.getZ() * Math.cos(radians)) + (origin.getY() * Math.sin(radians));
                    dst.setX(x16);
                    dst.setY(y16);
                    dst.setZ(z16);
                }

                public final void rotateByY(SolidVertex origin, SolidVertex dst, double degree) {
                    Intrinsics.checkNotNullParameter(origin, "origin");
                    Intrinsics.checkNotNullParameter(dst, "dst");
                    double radians = Math.toRadians(degree);
                    double x16 = (origin.getX() * Math.cos(radians)) - (origin.getZ() * Math.sin(radians));
                    double y16 = origin.getY();
                    double z16 = (origin.getZ() * Math.cos(radians)) + (origin.getX() * Math.sin(radians));
                    dst.setX(x16);
                    dst.setY(y16);
                    dst.setZ(z16);
                }

                public final void rotateByZ(SolidVertex origin, SolidVertex dst, double degree) {
                    Intrinsics.checkNotNullParameter(origin, "origin");
                    Intrinsics.checkNotNullParameter(dst, "dst");
                    double radians = Math.toRadians(degree);
                    double x16 = (origin.getX() * Math.cos(radians)) - (origin.getY() * Math.sin(radians));
                    double y16 = (origin.getY() * Math.cos(radians)) + (origin.getX() * Math.sin(radians));
                    double z16 = origin.getZ();
                    dst.setX(x16);
                    dst.setY(y16);
                    dst.setZ(z16);
                }

                Companion() {
                }
            }

            public RotateTask(SolidVertex[] originVertexs, SolidVertex[] dstVertexs) {
                Intrinsics.checkNotNullParameter(originVertexs, "originVertexs");
                Intrinsics.checkNotNullParameter(dstVertexs, "dstVertexs");
                this.dstVertexs = dstVertexs;
                int length = originVertexs.length;
                for (int i3 = 0; i3 < length; i3++) {
                    this.dstVertexs[i3].copyFrom(originVertexs[i3]);
                }
            }

            /* renamed from: finish, reason: from getter */
            public final SolidVertex[] getDstVertexs() {
                return this.dstVertexs;
            }

            public final RotateTask rotateByX(double degree) {
                int length = this.dstVertexs.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Companion companion = INSTANCE;
                    SolidVertex solidVertex = this.dstVertexs[i3];
                    companion.rotateByX(solidVertex, solidVertex, degree);
                }
                return this;
            }

            public final RotateTask rotateByY(double degree) {
                int length = this.dstVertexs.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Companion companion = INSTANCE;
                    SolidVertex solidVertex = this.dstVertexs[i3];
                    companion.rotateByY(solidVertex, solidVertex, degree);
                }
                return this;
            }

            public final RotateTask rotateByZ(double degree) {
                int length = this.dstVertexs.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Companion companion = INSTANCE;
                    SolidVertex solidVertex = this.dstVertexs[i3];
                    companion.rotateByZ(solidVertex, solidVertex, degree);
                }
                return this;
            }
        }

        public SolidToPlaneHelper(int i3, double d16, double d17) {
            this.numsX = i3;
            int i16 = i3 + 1;
            SolidVertex[] solidVertexArr = new SolidVertex[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                SolidVertex solidVertex = new SolidVertex(d16, d17, 0.0d);
                RotateTask.INSTANCE.rotateByY(solidVertex, solidVertex, -((360.0d / this.numsX) * i17));
                solidVertexArr[i17] = solidVertex;
            }
            this.originVertexes = solidVertexArr;
            int i18 = this.numsX + 1;
            SolidVertex[] solidVertexArr2 = new SolidVertex[i18];
            for (int i19 = 0; i19 < i18; i19++) {
                solidVertexArr2[i19] = new SolidVertex(0.0d, 0.0d, 0.0d);
            }
            this.outputVertexes = solidVertexArr2;
        }

        public final int getNumsX() {
            return this.numsX;
        }

        public final void reInit(double solidX, double solidY) {
            SolidVertex[] solidVertexArr = this.originVertexes;
            int length = solidVertexArr.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                SolidVertex solidVertex = solidVertexArr[i3];
                solidVertex.setX(solidX);
                solidVertex.setY(solidY);
                solidVertex.setZ(0.0d);
                RotateTask.INSTANCE.rotateByY(solidVertex, solidVertex, -((360.0d / this.numsX) * i16));
                i3++;
                i16++;
            }
        }

        public final RotateTask task() {
            return new RotateTask(this.originVertexes, this.outputVertexes);
        }

        public /* synthetic */ SolidToPlaneHelper(int i3, double d16, double d17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? 0.0d : d16, (i16 & 4) != 0 ? 0.0d : d17);
        }
    }

    public /* synthetic */ SurroundView(Context context, Handler handler, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : handler, (i3 & 4) != 0 ? true : z16);
    }
}
