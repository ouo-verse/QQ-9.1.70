package cooperation.plugin;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
class Dex2Oat$StreamConsumer$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ InputStream f390173d;

    @Override // java.lang.Runnable
    public void run() {
        if (this.f390173d == null) {
            return;
        }
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th5) {
                try {
                    this.f390173d.close();
                } catch (Exception unused2) {
                }
                throw th5;
            }
        } while (this.f390173d.read(new byte[256]) > 0);
        try {
            this.f390173d.close();
        } catch (Exception unused3) {
        }
    }
}
