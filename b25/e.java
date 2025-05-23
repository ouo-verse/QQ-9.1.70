package b25;

import android.os.Handler;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class e implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    public o f27776d;

    public e(o oVar) {
        this.f27776d = oVar;
    }

    abstract boolean a(Object obj, Message message);

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object b16;
        if (message != null && (b16 = this.f27776d.b()) != null) {
            try {
                return a(b16, message);
            } catch (Throwable th5) {
                p.b(th5);
            }
        }
        return false;
    }
}
