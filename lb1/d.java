package lb1;

import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 2) {
            if (i3 == 4) {
                a(obj);
                return;
            }
            return;
        }
        b(obj);
    }

    public void a(Object obj) {
    }

    public void b(Object obj) {
    }
}
