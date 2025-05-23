package j00;

import com.tencent.biz.qqstory.utils.l;
import com.tencent.qphone.base.util.BaseApplication;
import h00.e;
import h00.h;
import h00.i;
import h00.k;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c implements a {
    private h00.a b(h00.c cVar) {
        if (l.c(BaseApplication.getContext())) {
            return new e(cVar);
        }
        return c(cVar);
    }

    private h00.a c(h00.c cVar) {
        return new k(cVar);
    }

    @Override // j00.a
    public h00.a a(h00.c cVar) {
        int i3 = cVar.g().type;
        if (i3 == 1) {
            return new h(cVar);
        }
        if (i3 == 2) {
            return b(cVar);
        }
        if (i3 == 3) {
            return c(cVar);
        }
        if (i3 != 4) {
            return null;
        }
        return new i(cVar);
    }
}
