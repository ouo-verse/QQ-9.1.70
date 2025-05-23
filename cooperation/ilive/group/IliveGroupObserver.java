package cooperation.ilive.group;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import o05.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class IliveGroupObserver implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        Object[] objArr;
        final String str;
        Object obj2;
        Object obj3;
        if (i3 != 1 || (objArr = (Object[]) obj) == null) {
            return;
        }
        final a aVar = null;
        if (objArr.length > 1 && (obj3 = objArr[0]) != null && (obj3 instanceof String)) {
            str = (String) obj3;
        } else {
            str = null;
        }
        if (objArr.length == 2 && (obj2 = objArr[1]) != null && (obj2 instanceof a)) {
            aVar = (a) obj2;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.ilive.group.IliveGroupObserver.1
            @Override // java.lang.Runnable
            public void run() {
                IliveGroupObserver.this.a(str, aVar);
            }
        });
    }

    public void b() {
    }

    public void a(String str, a aVar) {
    }
}
