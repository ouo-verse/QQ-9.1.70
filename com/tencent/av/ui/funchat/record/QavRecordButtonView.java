package com.tencent.av.ui.funchat.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavRecordButtonView extends View {
    private b C;

    /* renamed from: d, reason: collision with root package name */
    private Paint f75813d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f75814e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f75815f;

    /* renamed from: h, reason: collision with root package name */
    private int f75816h;

    /* renamed from: i, reason: collision with root package name */
    private float f75817i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f75818m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (QavRecordButtonView.this.f75816h != 1) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        view.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                }
                view.setAlpha(0.5f);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void onStateChange(int i3);
    }

    public QavRecordButtonView(Context context) {
        super(context);
        this.f75813d = null;
        this.f75814e = null;
        this.f75815f = null;
        this.f75816h = 1;
        this.f75817i = 0.0f;
        this.f75818m = null;
        d();
    }

    private Bitmap b(int i3) {
        try {
            return BitmapFactory.decodeResource(getResources(), i3);
        } catch (OutOfMemoryError e16) {
            QLog.e("QavRecordButtonView", 1, "decodeBitmap oom", e16);
            return null;
        } catch (Throwable th5) {
            QLog.e("QavRecordButtonView", 1, "decodeBitmap Throwable", th5);
            return null;
        }
    }

    private void d() {
        Paint paint = new Paint();
        this.f75813d = paint;
        paint.setAntiAlias(true);
        this.f75813d.setStyle(Paint.Style.STROKE);
        this.f75814e = new RectF();
        this.f75815f = new Rect();
        this.f75818m = b(R.drawable.mrh);
        super.setOnTouchListener(new a());
    }

    public int c() {
        return this.f75816h;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f75816h == 3) {
            Bitmap bitmap = this.f75818m;
            if (bitmap != null) {
                this.f75815f.set(0, 0, bitmap.getWidth(), this.f75818m.getHeight());
                this.f75814e.set(0.0f, 0.0f, width, height);
                canvas.drawBitmap(this.f75818m, this.f75815f, this.f75814e, this.f75813d);
            }
            float f16 = width;
            float f17 = 0.08571429f * f16;
            float min = ((Math.min(width, height) / 2) - f17) - (f16 * 0.0028571428f);
            this.f75813d.setStrokeWidth(f17);
            float f18 = width / 2;
            float f19 = height / 2;
            this.f75814e.set(f18 - min, f19 - min, f18 + min, f19 + min);
            float f26 = (1.0f - this.f75817i) * 360.0f;
            this.f75813d.setColor(-1);
            canvas.drawArc(this.f75814e, 0.0f, 360.0f, false, this.f75813d);
            this.f75813d.setColor(-48606);
            canvas.drawArc(this.f75814e, -90.0f, 360.0f - f26, false, this.f75813d);
        }
    }

    public void e() {
        Bitmap bitmap = this.f75818m;
        if (bitmap != null) {
            bitmap.recycle();
            this.f75818m = null;
        }
        this.C = null;
    }

    public void setListener(b bVar) {
        this.C = bVar;
    }

    public void setProgress(long j3, long j16) {
        this.f75817i = Math.min(1.0f, Math.max((((float) j3) * 1.0f) / ((float) j16), 0.0f));
        if (this.f75816h == 3) {
            invalidate();
        }
    }

    public void setShowState(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordButtonView", 2, "setShowState, state=" + i3 + ", talkBack=" + z16);
        }
        if (i3 == this.f75816h) {
            return;
        }
        this.f75816h = i3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (z16) {
                        super.setContentDescription(getResources().getString(R.string.dhz));
                    }
                    this.f75817i = 0.0f;
                }
            } else if (z16) {
                super.setContentDescription(getResources().getString(R.string.dhy));
            }
        } else {
            super.setAlpha(1.0f);
            if (z16) {
                super.setContentDescription("");
            }
        }
        invalidate();
        b bVar = this.C;
        if (bVar != null) {
            bVar.onStateChange(this.f75816h);
        }
    }

    public QavRecordButtonView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75813d = null;
        this.f75814e = null;
        this.f75815f = null;
        this.f75816h = 1;
        this.f75817i = 0.0f;
        this.f75818m = null;
        d();
    }

    public QavRecordButtonView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75813d = null;
        this.f75814e = null;
        this.f75815f = null;
        this.f75816h = 1;
        this.f75817i = 0.0f;
        this.f75818m = null;
        d();
    }
}
