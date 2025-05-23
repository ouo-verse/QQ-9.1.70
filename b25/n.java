package b25;

import android.os.Handler;
import android.os.Message;
import c25.b;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes28.dex */
class n implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f27787d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f27787d = mVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Vector vector;
        Vector vector2;
        Object obj;
        c25.f d16;
        Vector vector3;
        Vector vector4;
        try {
            p.a("KcSdkShellManager", "OnChangeListener");
            vector = this.f27787d.f27786c;
        } catch (Throwable th5) {
            p.b(th5);
        }
        synchronized (vector) {
            vector2 = this.f27787d.f27786c;
            if (vector2.size() != 0 && message != null && (obj = message.obj) != null) {
                d16 = this.f27787d.d(obj);
                int i3 = message.what;
                if (i3 == 0) {
                    vector4 = this.f27787d.f27786c;
                    Iterator it = vector4.iterator();
                    while (it.hasNext()) {
                        ((b.a) it.next()).a(d16);
                    }
                } else if (i3 == 1) {
                    vector3 = this.f27787d.f27786c;
                    Iterator it5 = vector3.iterator();
                    while (it5.hasNext()) {
                        ((b.a) it5.next()).b(d16);
                    }
                }
                return false;
            }
            return false;
        }
    }
}
