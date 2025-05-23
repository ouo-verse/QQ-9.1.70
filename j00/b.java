package j00;

import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.qphone.base.util.BaseApplication;
import h00.e;
import h00.f;
import h00.g;
import h00.h;
import h00.i;
import h00.k;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements a {
    @Override // j00.a
    public h00.a a(h00.c cVar) {
        boolean c16 = l.c(BaseApplication.getContext());
        if (!TextUtils.isEmpty(cVar.g().qqSchema)) {
            return new i(cVar);
        }
        if (c16 && !TextUtils.isEmpty(cVar.g().schema)) {
            return new e(cVar);
        }
        if (!TextUtils.isEmpty(cVar.g().miniAppSchema)) {
            return new h(cVar);
        }
        if (!c16 && cVar.b()) {
            return new g(cVar);
        }
        if (!TextUtils.isEmpty(cVar.g().H5Url)) {
            return new k(cVar);
        }
        if (c16) {
            return new e(cVar);
        }
        return new f(cVar);
    }
}
