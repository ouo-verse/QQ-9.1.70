package lu;

import com.tencent.av.business.handler.SafetyHandler;
import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        d(z16, obj);
                        return;
                    }
                    return;
                }
                b(z16, (SafetyHandler.a) obj);
                return;
            }
            c(z16, (SafetyHandler.b) obj);
            return;
        }
        a(z16, obj);
    }

    public void a(boolean z16, Object obj) {
    }

    public void b(boolean z16, SafetyHandler.a aVar) {
    }

    public void c(boolean z16, SafetyHandler.b bVar) {
    }

    public void d(boolean z16, Object obj) {
    }
}
