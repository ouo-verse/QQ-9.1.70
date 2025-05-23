package oicq.wlogin_sdk.pow;

import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f422814a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f422815b;

    public b(int i3, byte[] bArr) {
        this.f422814a = i3;
        this.f422815b = bArr;
    }

    public static void a(byte[] bArr) {
        try {
            new BaseThread(new b(0, bArr), "Wtlogin_asynCalcPow").start();
            util.LOGI("aysncCalcPow started", "");
        } catch (Throwable th5) {
            util.LOGI("aysncCalcPow error " + Log.getStackTraceString(th5), "");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i3 = this.f422814a;
        if (i3 == 0) {
            byte[] bArr = this.f422815b;
            if (bArr != null && bArr.length > 0) {
                byte[] a16 = new ClientPow().a(this.f422815b);
                if (a16 != null && a16.length != 0) {
                    u.f422932i0 = a16;
                    return;
                } else {
                    util.LOGI("outBuf is null", "");
                    return;
                }
            }
            str = "inBuf is null ";
        } else if (i3 == 1) {
            try {
                byte[] nativeGetTestData = new ClientPow().nativeGetTestData();
                if (nativeGetTestData != null && nativeGetTestData.length != 0) {
                    u.f422933j0 = nativeGetTestData;
                    util.LOGI("get performance" + nativeGetTestData.length, "");
                } else {
                    util.LOGI("outBuf is null", "");
                }
                return;
            } catch (Throwable th5) {
                str = "getPerformance " + Log.getStackTraceString(th5);
            }
        } else {
            str = "error type:" + this.f422814a;
        }
        util.LOGI(str, "");
    }
}
