package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;

/* loaded from: classes9.dex */
public class MMProgressWheel extends View {
    public int C;
    public Paint D;
    public Paint E;
    public RectF F;
    public float G;
    public long H;
    public boolean I;
    public float J;
    public float K;
    public boolean L;
    public ProgressCallback M;
    public boolean N;

    /* renamed from: a, reason: collision with root package name */
    public final int f153656a;

    /* renamed from: b, reason: collision with root package name */
    public final int f153657b;

    /* renamed from: c, reason: collision with root package name */
    public final long f153658c;

    /* renamed from: d, reason: collision with root package name */
    public int f153659d;

    /* renamed from: e, reason: collision with root package name */
    public int f153660e;

    /* renamed from: f, reason: collision with root package name */
    public int f153661f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f153662g;

    /* renamed from: h, reason: collision with root package name */
    public double f153663h;

    /* renamed from: i, reason: collision with root package name */
    public double f153664i;

    /* renamed from: j, reason: collision with root package name */
    public float f153665j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f153666k;

    /* renamed from: l, reason: collision with root package name */
    public long f153667l;

    /* renamed from: m, reason: collision with root package name */
    public int f153668m;

    /* loaded from: classes9.dex */
    public interface ProgressCallback {
        void onProgressUpdate(float f16);
    }

    /* loaded from: classes9.dex */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() { // from class: com.tencent.mm.ui.widget.progress.MMProgressWheel.WheelSavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WheelSavedState[] newArray(int i3) {
                return new WheelSavedState[i3];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public float f153669a;

        /* renamed from: b, reason: collision with root package name */
        public float f153670b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f153671c;

        /* renamed from: d, reason: collision with root package name */
        public float f153672d;

        /* renamed from: e, reason: collision with root package name */
        public int f153673e;

        /* renamed from: f, reason: collision with root package name */
        public int f153674f;

        /* renamed from: g, reason: collision with root package name */
        public int f153675g;

        /* renamed from: h, reason: collision with root package name */
        public int f153676h;

        /* renamed from: i, reason: collision with root package name */
        public int f153677i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f153678j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f153679k;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeFloat(this.f153669a);
            parcel.writeFloat(this.f153670b);
            parcel.writeByte(this.f153671c ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.f153672d);
            parcel.writeInt(this.f153673e);
            parcel.writeInt(this.f153674f);
            parcel.writeInt(this.f153675g);
            parcel.writeInt(this.f153676h);
            parcel.writeInt(this.f153677i);
            parcel.writeByte(this.f153678j ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f153679k ? (byte) 1 : (byte) 0);
        }

        public WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f153669a = parcel.readFloat();
            this.f153670b = parcel.readFloat();
            this.f153671c = parcel.readByte() != 0;
            this.f153672d = parcel.readFloat();
            this.f153673e = parcel.readInt();
            this.f153674f = parcel.readInt();
            this.f153675g = parcel.readInt();
            this.f153676h = parcel.readInt();
            this.f153677i = parcel.readInt();
            this.f153678j = parcel.readByte() != 0;
            this.f153679k = parcel.readByte() != 0;
        }
    }

    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153656a = 16;
        this.f153657b = 270;
        this.f153658c = 200L;
        this.f153659d = 28;
        this.f153660e = 4;
        this.f153661f = 4;
        this.f153662g = false;
        this.f153663h = 0.0d;
        this.f153664i = 460.0d;
        this.f153665j = 0.0f;
        this.f153666k = true;
        this.f153667l = 0L;
        this.f153668m = -1442840576;
        this.C = 16777215;
        this.D = new Paint();
        this.E = new Paint();
        this.F = new RectF();
        this.G = 230.0f;
        this.H = 0L;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = false;
        a(context.obtainStyledAttributes(attributeSet, R.styleable.MMProgressWheel));
        b();
    }

    public final void a(int i3, int i16) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.f153662g) {
            int i17 = (i3 - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i17, (i16 - paddingBottom) - paddingTop), (this.f153659d * 2) - (this.f153660e * 2));
            int i18 = ((i17 - min) / 2) + paddingLeft;
            int i19 = ((((i16 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i26 = this.f153660e;
            this.F = new RectF(i18 + i26, i19 + i26, (i18 + min) - i26, (i19 + min) - i26);
            return;
        }
        int i27 = this.f153660e;
        this.F = new RectF(paddingLeft + i27, paddingTop + i27, (i3 - paddingRight) - i27, (i16 - paddingBottom) - i27);
    }

    public final void b() {
        boolean z16;
        if (Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.N = z16;
    }

    public final void c() {
        this.D.setColor(this.f153668m);
        this.D.setAntiAlias(true);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(this.f153660e);
        this.E.setColor(this.C);
        this.E.setAntiAlias(true);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(this.f153661f);
    }

    public int getBarColor() {
        return this.f153668m;
    }

    public int getBarWidth() {
        return this.f153660e;
    }

    public int getCircleRadius() {
        return this.f153659d;
    }

    public float getProgress() {
        if (this.L) {
            return -1.0f;
        }
        return this.J / 360.0f;
    }

    public int getRimColor() {
        return this.C;
    }

    public int getRimWidth() {
        return this.f153661f;
    }

    public float getSpinSpeed() {
        return this.G / 360.0f;
    }

    public boolean isSpinning() {
        return this.L;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f16;
        float f17;
        super.onDraw(canvas);
        canvas.drawArc(this.F, 360.0f, 360.0f, false, this.E);
        if (!this.N) {
            return;
        }
        float f18 = 0.0f;
        boolean z16 = true;
        if (this.L) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.H;
            float f19 = (((float) uptimeMillis) * this.G) / 1000.0f;
            a(uptimeMillis);
            float f26 = this.J + f19;
            this.J = f26;
            if (f26 > 360.0f) {
                this.J = f26 - 360.0f;
                a(-1.0f);
            }
            this.H = SystemClock.uptimeMillis();
            float f27 = this.J - 90.0f;
            float f28 = this.f153665j + 16.0f;
            if (isInEditMode()) {
                f28 = 135.0f;
                f17 = 0.0f;
            } else {
                f17 = f27;
            }
            canvas.drawArc(this.F, f17, f28, false, this.D);
        } else {
            float f29 = this.J;
            if (f29 != this.K) {
                this.J = Math.min(this.J + ((((float) (SystemClock.uptimeMillis() - this.H)) / 1000.0f) * this.G), this.K);
                this.H = SystemClock.uptimeMillis();
            } else {
                z16 = false;
            }
            if (f29 != this.J) {
                a();
            }
            float f36 = this.J;
            if (!this.I) {
                f18 = ((float) (1.0d - Math.pow(1.0f - (f36 / 360.0f), 4.0f))) * 360.0f;
                f36 = ((float) (1.0d - Math.pow(1.0f - (this.J / 360.0f), 2.0f))) * 360.0f;
            }
            if (isInEditMode()) {
                f16 = 360.0f;
            } else {
                f16 = f36;
            }
            canvas.drawArc(this.F, f18 - 90.0f, f16, false, this.D);
        }
        if (z16) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int paddingLeft = this.f153659d + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f153659d + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 != 1073741824 && mode != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = Math.min(paddingTop, size2);
            }
        } else {
            paddingTop = size2;
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.J = wheelSavedState.f153669a;
        this.K = wheelSavedState.f153670b;
        this.L = wheelSavedState.f153671c;
        this.G = wheelSavedState.f153672d;
        this.f153660e = wheelSavedState.f153673e;
        this.f153668m = wheelSavedState.f153674f;
        this.f153661f = wheelSavedState.f153675g;
        this.C = wheelSavedState.f153676h;
        this.f153659d = wheelSavedState.f153677i;
        this.I = wheelSavedState.f153678j;
        this.f153662g = wheelSavedState.f153679k;
        this.H = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f153669a = this.J;
        wheelSavedState.f153670b = this.K;
        wheelSavedState.f153671c = this.L;
        wheelSavedState.f153672d = this.G;
        wheelSavedState.f153673e = this.f153660e;
        wheelSavedState.f153674f = this.f153668m;
        wheelSavedState.f153675g = this.f153661f;
        wheelSavedState.f153676h = this.C;
        wheelSavedState.f153677i = this.f153659d;
        wheelSavedState.f153678j = this.I;
        wheelSavedState.f153679k = this.f153662g;
        return wheelSavedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        a(i3, i16);
        c();
        invalidate();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (i3 == 0) {
            this.H = SystemClock.uptimeMillis();
        }
    }

    public void resetCount() {
        this.J = 0.0f;
        this.K = 0.0f;
        invalidate();
    }

    public void setBarColor(int i3) {
        this.f153668m = i3;
        c();
        if (!this.L) {
            invalidate();
        }
    }

    public void setBarWidth(int i3) {
        this.f153660e = i3;
        if (!this.L) {
            invalidate();
        }
    }

    public void setCallback(ProgressCallback progressCallback) {
        this.M = progressCallback;
        if (!this.L) {
            a();
        }
    }

    public void setCircleRadius(int i3) {
        this.f153659d = i3;
        if (!this.L) {
            invalidate();
        }
    }

    public void setInstantProgress(float f16) {
        if (this.L) {
            this.J = 0.0f;
            this.L = false;
        }
        if (f16 > 1.0f) {
            f16 -= 1.0f;
        } else if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        if (Math.abs(f16 - this.K) <= 0.0f) {
            return;
        }
        float min = Math.min(f16 * 360.0f, 360.0f);
        this.K = min;
        this.J = min;
        this.H = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z16) {
        this.I = z16;
        if (!this.L) {
            invalidate();
        }
    }

    public void setProgress(float f16) {
        if (this.L) {
            this.J = 0.0f;
            this.L = false;
            a();
        }
        if (f16 > 1.0f) {
            f16 -= 1.0f;
        } else if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        if (Math.abs(f16 - this.K) <= 0.0f) {
            return;
        }
        if (this.J == this.K) {
            this.H = SystemClock.uptimeMillis();
        }
        this.K = Math.min(f16 * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i3) {
        this.C = i3;
        c();
        if (!this.L) {
            invalidate();
        }
    }

    public void setRimWidth(int i3) {
        this.f153661f = i3;
        if (!this.L) {
            invalidate();
        }
    }

    public void setSpinSpeed(float f16) {
        this.G = f16 * 360.0f;
    }

    public void spin() {
        this.H = SystemClock.uptimeMillis();
        this.L = true;
        invalidate();
    }

    public void stopSpinning() {
        this.L = false;
        this.J = 0.0f;
        this.K = 0.0f;
        invalidate();
    }

    public final void a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f153660e = (int) TypedValue.applyDimension(1, this.f153660e, displayMetrics);
        this.f153661f = (int) TypedValue.applyDimension(1, this.f153661f, displayMetrics);
        int applyDimension = (int) TypedValue.applyDimension(1, this.f153659d, displayMetrics);
        this.f153659d = applyDimension;
        this.f153659d = (int) typedArray.getDimension(R.styleable.MMProgressWheel_matProg_circleRadius, applyDimension);
        this.f153662g = typedArray.getBoolean(R.styleable.MMProgressWheel_matProg_fillRadius, false);
        this.f153660e = (int) typedArray.getDimension(R.styleable.MMProgressWheel_matProg_barWidth, this.f153660e);
        this.f153661f = (int) typedArray.getDimension(R.styleable.MMProgressWheel_matProg_rimWidth, this.f153661f);
        this.G = typedArray.getFloat(R.styleable.MMProgressWheel_matProg_spinSpeed, this.G / 360.0f) * 360.0f;
        this.f153664i = typedArray.getInt(R.styleable.MMProgressWheel_matProg_barSpinCycleTime, (int) this.f153664i);
        this.f153668m = typedArray.getColor(R.styleable.MMProgressWheel_matProg_barColor, this.f153668m);
        this.C = typedArray.getColor(R.styleable.MMProgressWheel_matProg_rimColor, this.C);
        this.I = typedArray.getBoolean(R.styleable.MMProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(R.styleable.MMProgressWheel_matProg_progressIndeterminate, false)) {
            spin();
        }
        typedArray.recycle();
    }

    public MMProgressWheel(Context context) {
        super(context);
        this.f153656a = 16;
        this.f153657b = 270;
        this.f153658c = 200L;
        this.f153659d = 28;
        this.f153660e = 4;
        this.f153661f = 4;
        this.f153662g = false;
        this.f153663h = 0.0d;
        this.f153664i = 460.0d;
        this.f153665j = 0.0f;
        this.f153666k = true;
        this.f153667l = 0L;
        this.f153668m = -1442840576;
        this.C = 16777215;
        this.D = new Paint();
        this.E = new Paint();
        this.F = new RectF();
        this.G = 230.0f;
        this.H = 0L;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = false;
        b();
    }

    public final void a(long j3) {
        long j16 = this.f153667l;
        if (j16 >= 200) {
            double d16 = this.f153663h + j3;
            this.f153663h = d16;
            double d17 = this.f153664i;
            if (d16 > d17) {
                this.f153663h = d16 - d17;
                this.f153667l = 0L;
                this.f153666k = !this.f153666k;
            }
            float cos = (((float) Math.cos(((this.f153663h / d17) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.f153666k) {
                this.f153665j = cos * 254.0f;
                return;
            }
            float f16 = (1.0f - cos) * 254.0f;
            this.J += this.f153665j - f16;
            this.f153665j = f16;
            return;
        }
        this.f153667l = j16 + j3;
    }

    public final void a(float f16) {
        ProgressCallback progressCallback = this.M;
        if (progressCallback != null) {
            progressCallback.onProgressUpdate(f16);
        }
    }

    public final void a() {
        if (this.M != null) {
            this.M.onProgressUpdate(Math.round((this.J * 100.0f) / 360.0f) / 100.0f);
        }
    }
}
