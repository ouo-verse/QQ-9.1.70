package b25;

import android.os.Message;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class k extends e {
    public k(o oVar) {
        super(oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b25.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(c25.e eVar, Message message) {
        Object a16;
        int i3 = message.what;
        if (i3 == 0) {
            String str = (String) message.obj;
            if (TextUtils.isEmpty(str)) {
                a16 = null;
            } else {
                a16 = eVar.a(str);
            }
            message.obj = a16;
            return true;
        }
        if (i3 == 1) {
            eVar.b(message.arg1, (String) message.obj);
            return true;
        }
        return false;
    }
}
