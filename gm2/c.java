package gm2;

import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f402407a;

    /* renamed from: d, reason: collision with root package name */
    private long f402410d;

    /* renamed from: e, reason: collision with root package name */
    private long f402411e;

    /* renamed from: b, reason: collision with root package name */
    private int f402408b = 125;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f402409c = new int[256];

    /* renamed from: f, reason: collision with root package name */
    public int f402412f = 0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void c(boolean z16);
    }

    public void a(byte[] bArr, int i3, int i16, a aVar) {
        int i17;
        if (aVar != null && bArr != null) {
            int[] darkModeDPCValues = ShortVideoUtils.getDarkModeDPCValues();
            if (darkModeDPCValues[0] == 1) {
                int i18 = this.f402412f + 1;
                this.f402412f = i18;
                if (i18 % 8 == 0) {
                    this.f402407a = ((i3 * i16) * (100 - darkModeDPCValues[1])) / 100;
                    this.f402408b = darkModeDPCValues[2];
                    Arrays.fill(this.f402409c, 0);
                    int i19 = 1;
                    while (true) {
                        i17 = 255;
                        if (i19 >= i16) {
                            break;
                        }
                        for (int i26 = 1; i26 < i3; i26 += 8) {
                            int i27 = (i19 * i3) + i26;
                            if (i27 < bArr.length) {
                                int[] iArr = this.f402409c;
                                int i28 = bArr[i27] & 255;
                                iArr[i28] = iArr[i28] + 64;
                            }
                        }
                        i19 += 8;
                    }
                    int i29 = 0;
                    int i36 = 255;
                    while (true) {
                        if (i17 >= 51) {
                            i29 += this.f402409c[i17];
                            if (i29 >= this.f402407a) {
                                break;
                            }
                            int i37 = i17;
                            i17--;
                            i36 = i37;
                        } else {
                            i17 = i36;
                            break;
                        }
                    }
                    if (i17 <= this.f402408b) {
                        QLog.w("DarkModeChecker", 1, "darkmode = true!");
                        this.f402411e = 0L;
                        long j3 = this.f402410d;
                        if (j3 == 0) {
                            this.f402410d = System.currentTimeMillis();
                            return;
                        }
                        if (j3 > 0 && System.currentTimeMillis() - this.f402410d >= 1500) {
                            this.f402410d = -1L;
                            QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE on!");
                            this.f402411e = 0L;
                            aVar.c(true);
                            return;
                        }
                        return;
                    }
                    if (this.f402410d > 0) {
                        this.f402410d = 0L;
                    }
                    long j16 = this.f402411e;
                    if (j16 == 0) {
                        this.f402411e = System.currentTimeMillis();
                        return;
                    }
                    if (j16 > 0 && System.currentTimeMillis() - this.f402411e >= 2000) {
                        this.f402411e = -1L;
                        QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE off!");
                        this.f402410d = 0L;
                        aVar.c(false);
                    }
                }
            }
        }
    }

    public void b() {
        this.f402410d = 0L;
        this.f402411e = 0L;
        if (QLog.isColorLevel()) {
            QLog.d("DarkModeChecker", 2, "refreshTimer ");
        }
    }
}
