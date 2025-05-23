package com.tencent.turingcam;

import android.hardware.Camera;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.DO0IX;
import com.tencent.turingcam.spXPg;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BijG2 extends spXPg {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private int f381730b;

    /* renamed from: c, reason: collision with root package name */
    private long f381731c;

    /* renamed from: d, reason: collision with root package name */
    private int f381732d;

    /* renamed from: e, reason: collision with root package name */
    private float f381733e;

    /* renamed from: f, reason: collision with root package name */
    private int f381734f;

    /* renamed from: g, reason: collision with root package name */
    private int f381735g;

    /* renamed from: h, reason: collision with root package name */
    private int f381736h;

    /* renamed from: i, reason: collision with root package name */
    private long f381737i;

    public BijG2() {
        super("5");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381731c = 0L;
            this.f381732d = 0;
        }
    }

    @Override // com.tencent.turingcam.spXPg
    public long a(DO0IX.spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) spxpg)).longValue();
        }
        Camera.Parameters parameters = spxpg.a().getParameters();
        if (parameters.getMaxExposureCompensation() == parameters.getMinExposureCompensation()) {
            return -1002L;
        }
        this.f381730b = parameters.getExposureCompensation();
        this.f381734f = spxpg.e(300);
        this.f381735g = spxpg.d(1000);
        this.f381736h = spxpg.c(300);
        this.f381733e = spxpg.c();
        this.f381732d = 0;
        this.f381731c = System.currentTimeMillis();
        this.f381737i = System.currentTimeMillis();
        return 0L;
    }

    @Override // com.tencent.turingcam.spXPg
    public boolean a(spXPg.C10028spXPg c10028spXPg, Camera camera2, EQsUZ eQsUZ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, c10028spXPg, camera2, eQsUZ)).booleanValue();
        }
        if (System.currentTimeMillis() - this.f381737i < this.f381736h) {
            return false;
        }
        float f16 = this.f381733e;
        Camera.Parameters parameters = camera2.getParameters();
        parameters.setExposureCompensation(Math.max(Math.min(Math.round(f16 / parameters.getExposureCompensationStep()), parameters.getMaxExposureCompensation()), parameters.getMinExposureCompensation()));
        camera2.setParameters(parameters);
        Camera.Parameters parameters2 = camera2.getParameters();
        int i3 = parameters2.getPreviewSize().width;
        int i16 = parameters2.getPreviewSize().height;
        if (System.currentTimeMillis() - this.f381731c > this.f381734f) {
            int i17 = (int) (i3 * 0.1f);
            int i18 = (int) (i16 * 0.1f);
            byte[] bArr = new byte[i17 * i18];
            byte[] bArr2 = c10028spXPg.f382373b;
            int i19 = (i16 - i18) / 2;
            int i26 = (i3 - i17) / 2;
            for (int i27 = 0; i27 < i18; i27++) {
                System.arraycopy(bArr2, ((i19 + i27) * i3) + i26, bArr, i17 * i27, i17);
            }
            uAnWx uanwx = new uAnWx();
            uanwx.f382396a = a();
            int i28 = this.f381732d;
            this.f381732d = i28 + 1;
            uanwx.f382397b = i28;
            uanwx.f382399d = i17;
            uanwx.f382400e = i18;
            uanwx.f382398c = bArr;
            eQsUZ.f381792a.add(uanwx);
            this.f381731c = System.currentTimeMillis();
            if (this.f381732d >= this.f381735g / this.f381734f) {
                parameters2.setExposureCompensation(this.f381730b);
                camera2.setParameters(parameters2);
                return true;
            }
        }
        return false;
    }
}
