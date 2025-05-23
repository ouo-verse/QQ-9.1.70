package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.common.reporter.upload.EntranceResponseProcessor;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class as extends ar {
    public as(Context context, byte[] bArr, String str, String str2, ap apVar) {
        super(context, 1001, 840, bArr, str, str2, apVar, 0, 0, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(byte[] bArr) {
        boolean z16;
        boolean z17;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("next_time_in_sec")) {
                long j3 = jSONObject.getLong("next_time_in_sec");
                s sVar = t.f98555b;
                long j16 = j3 * 1000;
                if (0 < j16 && j16 < 604800000) {
                    sVar.f98537a = j16;
                    ba.c("userInfoMinInterval", String.valueOf(j16));
                }
            }
            if (jSONObject.has("code")) {
                if (jSONObject.optInt("code") == 0) {
                    z17 = true;
                    if (!z17) {
                        try {
                            EntranceResponseProcessor.onEntranceResponse("metric", "union_dau", jSONObject);
                            a(null, true, 2, "success");
                            return z17;
                        } catch (Throwable th5) {
                            z16 = z17;
                            th = th5;
                            av.e(new String(bArr), new Object[0]);
                            av.b(th);
                            return z16;
                        }
                    }
                    return z17;
                }
            }
            z17 = false;
            if (!z17) {
            }
        } catch (Throwable th6) {
            th = th6;
            z16 = false;
        }
    }

    @Override // com.tencent.bugly.proguard.ar, java.lang.Runnable
    public final void run() {
        try {
            this.f98095i = 0;
            this.f98096j = 0L;
            this.f98097k = 0L;
            String c16 = c();
            if (c16 != null) {
                a(null, false, 0, c16);
                return;
            }
            byte[] bArr = this.f98090d;
            if (bArr == null) {
                a(null, false, 0, "failed to zip request body");
                return;
            }
            Map<String, String> b16 = b();
            a();
            String str = this.f98093g;
            this.f98091e.c();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int i17 = i3 + 1;
                if (i3 < this.f98087a) {
                    if (i17 > 1) {
                        av.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i17));
                        ba.b(this.f98088b);
                        if (i17 == this.f98087a) {
                            av.d("[Upload] Use the back-up url at the last time: %s", this.f98094h);
                            str = this.f98094h;
                        }
                    }
                    av.c("[Upload] Send %d bytes", Integer.valueOf(bArr.length));
                    av.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str, Integer.valueOf(this.f98089c), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] a16 = this.f98092f.a(str, bArr, this, b16);
                    if (ai.c().a()) {
                        if (a16 == null) {
                            a(null, false, 2, "response is null");
                            i3 = i17;
                        } else if (a(a16)) {
                            return;
                        } else {
                            a(null, false, 2, "failed from server");
                        }
                    } else if (!a(a16, this.f98092f.f98054c)) {
                        return;
                    }
                    i16 = 1;
                    i3 = i17;
                } else {
                    a(null, false, i16, "failed after many attempts");
                    return;
                }
            }
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }
}
