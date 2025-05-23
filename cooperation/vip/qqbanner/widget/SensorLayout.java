package cooperation.vip.qqbanner.widget;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SensorLayout extends FrameLayout implements SensorEventListener {
    private double C;
    private double D;
    private boolean E;
    private int F;
    private boolean G;
    private int H;
    private double I;
    private double J;
    private int K;

    /* renamed from: d, reason: collision with root package name */
    private SensorManager f391363d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f391364e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f391365f;

    /* renamed from: h, reason: collision with root package name */
    private Scroller f391366h;

    /* renamed from: i, reason: collision with root package name */
    private double f391367i;

    /* renamed from: m, reason: collision with root package name */
    private double f391368m;

    /* compiled from: P */
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes28.dex */
    public @interface ADirection {
    }

    public SensorLayout(@NonNull Context context) {
        this(context, null);
    }

    public void a() {
        if (this.f391363d != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) getContext().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f391363d = sensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
            Sensor defaultSensor2 = SensorMonitor.getDefaultSensor(this.f391363d, 2);
            SensorMonitor.registerListener(this.f391363d, this, defaultSensor, 2);
            SensorMonitor.registerListener(this.f391363d, this, defaultSensor2, 2);
        }
    }

    public void b(int i3, int i16) {
        int scrollY = getScrollY();
        int scrollX = getScrollX();
        Scroller scroller = this.f391366h;
        scroller.startScroll(scrollX, scrollY, i3 - scrollX, i16 - scrollY, 200);
        invalidate();
    }

    public void c() {
        SensorManager sensorManager = this.f391363d;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f391363d = null;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f391366h.computeScrollOffset()) {
            scrollTo(this.f391366h.getCurrX(), this.f391366h.getCurrY());
            postInvalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSensorChanged(SensorEvent sensorEvent) {
        int finalX;
        int finalY;
        float[] fArr;
        if (sensorEvent.sensor.getType() == 1) {
            this.f391364e = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.f391365f = sensorEvent.values;
        }
        float[] fArr2 = new float[3];
        float[] fArr3 = new float[9];
        float[] fArr4 = this.f391365f;
        if (fArr4 != null && (fArr = this.f391364e) != null) {
            SensorManager.getRotationMatrix(fArr3, null, fArr, fArr4);
        }
        SensorManager.getOrientation(fArr3, fArr2);
        fArr2[1] = (float) Math.toDegrees(fArr2[1]);
        float degrees = (float) Math.toDegrees(fArr2[2]);
        fArr2[2] = degrees;
        double d16 = fArr2[1];
        double d17 = degrees;
        if (d17 <= 0.0d) {
            double d18 = this.f391367i;
            if (d17 > d18) {
                this.E = true;
                this.F = (int) ((d17 / Math.abs(d18)) * this.I * this.K);
                if (d16 <= 0.0d) {
                    double d19 = this.C;
                    if (d16 > d19) {
                        this.G = true;
                        this.H = (int) ((d16 / Math.abs(d19)) * this.J * this.K);
                        if (this.E) {
                            finalX = this.F;
                        } else {
                            finalX = this.f391366h.getFinalX();
                        }
                        if (this.G) {
                            finalY = this.H;
                        } else {
                            finalY = this.f391366h.getFinalY();
                        }
                        b(finalX, finalY);
                    }
                }
                if (d16 > 0.0d) {
                    double d26 = this.D;
                    if (d16 < d26) {
                        this.G = true;
                        this.H = (int) ((d16 / Math.abs(d26)) * this.J * this.K);
                    }
                }
                if (this.E) {
                }
                if (this.G) {
                }
                b(finalX, finalY);
            }
        }
        if (d17 > 0.0d) {
            double d27 = this.f391368m;
            if (d17 < d27) {
                this.E = true;
                this.F = (int) ((d17 / Math.abs(d27)) * this.I * this.K);
            }
        }
        if (d16 <= 0.0d) {
        }
        if (d16 > 0.0d) {
        }
        if (this.E) {
        }
        if (this.G) {
        }
        b(finalX, finalY);
    }

    public void setDegreeXMax(double d16) {
        this.D = d16;
    }

    public void setDegreeXMin(double d16) {
        this.C = d16;
    }

    public void setDegreeYMax(double d16) {
        this.f391368m = d16;
    }

    public void setDegreeYMin(double d16) {
        this.f391367i = d16;
    }

    public void setDirection(int i3) {
        this.K = i3;
    }

    public void setXMoveDistance(double d16) {
        this.I = d16;
    }

    public void setYMoveDistance(double d16) {
        this.J = d16;
    }

    public SensorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SensorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f391367i = -50.0d;
        this.f391368m = 50.0d;
        this.C = -70.0d;
        this.D = 0.0d;
        this.I = 40.0d;
        this.J = 20.0d;
        this.K = 1;
        this.f391366h = new Scroller(getContext());
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
