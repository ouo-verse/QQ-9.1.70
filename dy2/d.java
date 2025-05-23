package dy2;

import android.media.AudioManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private AudioManager f395207a;

    /* renamed from: b, reason: collision with root package name */
    private float f395208b = -1.0f;

    public d() {
        if (RFWApplication.getApplication() != null) {
            this.f395207a = (AudioManager) RFWApplication.getApplication().getSystemService("audio");
        }
    }

    public float a() {
        try {
            return SystemMethodProxy.getStreamVolume(this.f395207a, 3);
        } catch (Exception unused) {
            return 50.0f;
        }
    }

    public float b() {
        try {
            return this.f395207a.getStreamMaxVolume(3);
        } catch (Exception unused) {
            return 100.0f;
        }
    }

    public void c(float f16) {
        this.f395208b = f16;
        if (f16 > 1.0f) {
            this.f395208b = 1.0f;
        }
        if (this.f395208b < 0.0f) {
            this.f395208b = 0.0f;
        }
        try {
            this.f395207a.setStreamVolume(3, (int) (this.f395208b * b()), 0);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
