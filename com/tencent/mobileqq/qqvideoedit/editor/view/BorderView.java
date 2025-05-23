package com.tencent.mobileqq.qqvideoedit.editor.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size;
import com.tencent.mobileqq.qqvideoedit.utils.i;
import com.tencent.mobileqq.qqvideoedit.utils.l;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BorderView extends FrameLayout {
    public static int W = 300;

    /* renamed from: a0, reason: collision with root package name */
    public static int f275840a0 = 150;
    private VideoStickerModel C;
    private Size D;
    private a E;
    private b F;
    private PointF G;
    private PointF H;
    private long I;
    private int J;
    private PointF K;
    private boolean L;
    private float M;
    private float N;
    private float P;
    private float Q;
    private float R;
    private int[] S;
    private boolean T;
    private boolean U;
    public boolean V;

    /* renamed from: d, reason: collision with root package name */
    private final PointF f275841d;

    /* renamed from: e, reason: collision with root package name */
    private final int f275842e;

    /* renamed from: f, reason: collision with root package name */
    private float f275843f;

    /* renamed from: h, reason: collision with root package name */
    private float f275844h;

    /* renamed from: i, reason: collision with root package name */
    public int f275845i;

    /* renamed from: m, reason: collision with root package name */
    private float f275846m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public enum Direction {
        Left,
        Right
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void Lb(Direction direction);

        int getRenderHeight();

        int getRenderWidth();

        boolean nh(boolean z16, int[] iArr);
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void M0();

        void O7(@Nullable VideoStickerModel videoStickerModel);

        void T();

        void T6(VideoStickerModel videoStickerModel, PointF pointF);

        VideoStickerModel U(PointF pointF, PointF pointF2);

        void Z1(@Nullable VideoStickerModel videoStickerModel);

        void i();

        Size k();

        VideoStickerModel o8(float f16, float f17);

        void s4(@Nullable VideoStickerModel videoStickerModel);
    }

    public BorderView(@NonNull Context context) {
        this(context, null);
    }

    private float b(double d16, double d17) {
        return (float) Math.toDegrees(Math.atan2(d17, d16));
    }

    private void h(Float f16) {
        if (f16.floatValue() < 0.2f) {
            f16 = Float.valueOf(0.2f);
        }
        if (f16.floatValue() > 10.0f) {
            f16 = Float.valueOf(10.0f);
        }
        if (this.f275846m == f16.floatValue()) {
            return;
        }
        float floatValue = f16.floatValue();
        this.f275846m = floatValue;
        if (floatValue == 0.2f) {
            l.f276256a.b(getContext(), 100L);
        }
    }

    private boolean i(MotionEvent motionEvent) {
        if (this.K == null) {
            return false;
        }
        int i3 = this.f275842e * 6;
        if (Math.abs(motionEvent.getX() - this.K.x) <= this.f275842e || Math.abs(motionEvent.getY() - this.K.y) >= i3) {
            return false;
        }
        return true;
    }

    private boolean j(MotionEvent motionEvent) {
        if (this.G == null || Math.abs(motionEvent.getX() - this.G.x) >= this.f275842e || Math.abs(motionEvent.getY() - this.G.y) >= this.f275842e) {
            return true;
        }
        return false;
    }

    private void k(float f16, float f17, float f18) {
        VideoStickerModel a16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.b.a(this.C, f16, f17);
        a16.updatePositionInView((int) (this.E.getRenderWidth() * f18), (int) (this.E.getRenderHeight() * f18), a16.scale, a16.centerX, a16.centerY);
        this.F.T6(a16, new PointF(a16.getLeftTopInView().f275793x, a16.getLeftTopInView().f275794y));
    }

    private void l(float f16, float f17, float f18) {
        VideoStickerModel videoStickerModel = this.C;
        if (videoStickerModel != null) {
            VideoStickerModel b16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.b.b(videoStickerModel, f17, f16);
            b16.updatePositionInView((int) (this.E.getRenderWidth() * f18), (int) (this.E.getRenderHeight() * f18), b16.scale, b16.centerX, b16.centerY);
            this.F.T6(b16, null);
        }
    }

    private void m(float f16, float f17, float f18) {
        float b16 = (b(f16, f17) - this.f275844h) + this.C.getLastDownRotate();
        if (b16 < 0.0f) {
            b16 += 360.0f;
        } else if (b16 > 360.0f) {
            b16 -= 360.0f;
        }
        if (this.f275843f > 0.0f) {
            h(Float.valueOf((((float) Math.sqrt((f16 * f16) + (f17 * f17))) / this.f275843f) * this.C.getLastDownScale()));
        }
        this.C.setDownScaleRecord(b16);
        l(this.f275846m, b16 * (-1.0f), f18);
    }

    float a() {
        return Math.min((getMeasuredHeight() * 1.0f) / this.E.getRenderHeight(), (getMeasuredWidth() * 1.0f) / this.E.getRenderWidth());
    }

    public boolean c(MotionEvent motionEvent) {
        this.f275841d.x = motionEvent.getX();
        this.f275841d.y = motionEvent.getY();
        PointF pointF = this.f275841d;
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        this.G = pointF2;
        if (this.H == null) {
            this.H = pointF2;
        }
        if (this.I == 0) {
            this.I = System.currentTimeMillis();
        }
        b bVar = this.F;
        PointF pointF3 = this.f275841d;
        this.C = bVar.o8(pointF3.x, pointF3.y);
        this.D = this.F.k();
        if (this.C == null) {
            PointF pointF4 = this.f275841d;
            this.K = new PointF(pointF4.x, pointF4.y);
            return this.V;
        }
        if (QLog.isColorLevel()) {
            ms.a.f("VideoBorderView", "Sticker model got: " + this.C.id);
        }
        this.M = this.C.getLeftTopInView().f275793x;
        this.N = this.C.getLeftTopInView().f275794y;
        VideoStickerModel videoStickerModel = this.C;
        this.P = videoStickerModel.centerX;
        this.Q = videoStickerModel.centerY;
        videoStickerModel.setLastDownScale(videoStickerModel.scale);
        VideoStickerModel videoStickerModel2 = this.C;
        videoStickerModel2.setLastDownRotate(videoStickerModel2.getDownScaleRecord());
        return true;
    }

    public boolean d(MotionEvent motionEvent) {
        if (this.C == null) {
            return true;
        }
        float a16 = a();
        if (motionEvent.getPointerCount() == 2) {
            m(motionEvent.getX(1) - motionEvent.getX(0), motionEvent.getY(1) - motionEvent.getY(0), a16);
        } else if (motionEvent.getPointerCount() == 1) {
            float x16 = motionEvent.getX() - this.f275841d.x;
            float y16 = motionEvent.getY() - this.f275841d.y;
            float renderWidth = this.P + ((x16 * 2.0f) / (this.E.getRenderWidth() * a16));
            float renderHeight = this.Q - ((y16 * 2.0f) / (this.E.getRenderHeight() * a16));
            if (j(motionEvent)) {
                this.L = true;
                this.C.getMaterial().additionalFields.put("hasMoved", "1");
                if (this.S == null) {
                    int[] iArr = new int[2];
                    getLocationOnScreen(iArr);
                    this.S = iArr;
                }
                this.U = this.E.nh(true, new int[]{this.S[0] + ((int) motionEvent.getX()), this.S[1] + ((int) motionEvent.getY())});
                if (!this.T) {
                    this.T = true;
                    this.F.T();
                }
                if (renderWidth < -1.0f) {
                    renderWidth = -1.0f;
                } else if (renderWidth > 1.0f) {
                    renderWidth = 1.0f;
                }
                if (renderHeight > 1.0f) {
                    renderHeight = 1.0f;
                }
                k(renderWidth, renderHeight, a16);
                this.R = renderHeight;
            }
        }
        return true;
    }

    public boolean e(MotionEvent motionEvent) {
        if (this.C == null) {
            VideoStickerModel U = this.F.U(new PointF(motionEvent.getX(0), motionEvent.getY(0)), new PointF(motionEvent.getX(1), motionEvent.getY(1)));
            this.C = U;
            if (U == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                ms.a.f("VideoBorderView", "sticker model get with two finger: " + this.C.id);
            }
            VideoStickerModel videoStickerModel = this.C;
            videoStickerModel.setLastDownScale(videoStickerModel.scale);
            VideoStickerModel videoStickerModel2 = this.C;
            videoStickerModel2.setLastDownRotate(videoStickerModel2.getDownScaleRecord());
        }
        PointF pointF = new PointF(motionEvent.getX(this.f275845i), motionEvent.getY(this.f275845i));
        float x16 = motionEvent.getX(1) - motionEvent.getX(0);
        float y16 = motionEvent.getY(1) - motionEvent.getY(0);
        this.f275843f = i.f276251a.g(pointF, this.f275841d);
        this.f275844h = b(x16, y16);
        return true;
    }

    public boolean f(MotionEvent motionEvent) {
        if (motionEvent.getPointerId(this.f275845i) == 0) {
            this.f275841d.x = motionEvent.getX(1);
            this.f275841d.y = motionEvent.getY(1);
        } else if (motionEvent.getPointerId(this.f275845i) == 1) {
            this.f275841d.x = motionEvent.getX(0);
            this.f275841d.y = motionEvent.getY(0);
        }
        this.C = null;
        this.K = null;
        return true;
    }

    public boolean g(MotionEvent motionEvent) {
        boolean z16;
        Direction direction;
        if (!j(motionEvent) && !this.L) {
            z16 = true;
        } else {
            z16 = false;
        }
        VideoStickerModel videoStickerModel = this.C;
        if (videoStickerModel != null) {
            videoStickerModel.setLastDownScale(this.f275846m);
            if (z16) {
                int i3 = this.J + 1;
                this.J = i3;
                if (i3 == 2) {
                    if (System.currentTimeMillis() - this.I < W && Math.abs(motionEvent.getX() - this.H.x) < f275840a0 && Math.abs(motionEvent.getY() - this.H.y) < f275840a0) {
                        this.F.Z1(this.C);
                    } else {
                        this.F.Z1(null);
                    }
                    this.J = 0;
                    this.I = 0L;
                    this.H = null;
                }
                this.F.s4(this.C);
            } else if (this.L) {
                if (this.U) {
                    this.F.O7(this.C);
                } else if (this.R < -1.0f) {
                    k(this.P, this.Q, a());
                }
            }
        } else if (z16) {
            this.F.s4(null);
        }
        if (this.K != null && this.C == null && i(motionEvent)) {
            a aVar = this.E;
            if (motionEvent.getX() > this.K.x) {
                direction = Direction.Right;
            } else {
                direction = Direction.Left;
            }
            aVar.Lb(direction);
        }
        this.L = false;
        this.C = null;
        this.E.nh(false, null);
        if (this.T) {
            this.T = false;
            this.F.i();
        }
        this.F.M0();
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f275845i = motionEvent.getActionIndex();
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return false;
                            }
                            return f(motionEvent);
                        }
                        return e(motionEvent);
                    }
                } else {
                    return d(motionEvent);
                }
            }
            return g(motionEvent);
        }
        return c(motionEvent);
    }

    public void setBorderViewEventConsumable(boolean z16) {
        this.V = z16;
    }

    public void setGestureDetectorCallback(@NonNull a aVar) {
        this.E = aVar;
    }

    public void setOperationCallback(@Nullable b bVar) {
        this.F = bVar;
    }

    public BorderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f275841d = new PointF();
        this.f275842e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f275843f = 0.0f;
        this.f275844h = 0.0f;
        this.f275845i = 0;
        this.f275846m = 1.0f;
        this.I = 0L;
        this.J = 0;
        this.U = false;
        this.V = true;
    }
}
