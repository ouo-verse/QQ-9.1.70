package com.qq.e.comm.plugin.stat;

import android.content.Context;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.k.x;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class k extends a<i> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.stat.a
    public void a(Set<Integer> set) {
        g.a(this.f39698a).b().a(set);
    }

    @Override // com.qq.e.comm.plugin.stat.a
    void c(List<i> list) {
        Response response;
        if (list != null && !list.isEmpty()) {
            if (System.currentTimeMillis() - d() < e()) {
                b(list);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONArray.mo162put(new x(list.get(i3).c()).a());
            }
            if (!ac.a(this.f39698a)) {
                GDTLogger.d("Send stat failed for no available network");
                return;
            }
            Future<Response> a16 = o.a(jSONArray);
            if (a16 != null) {
                try {
                    response = a16.get();
                } catch (Exception unused) {
                    GDTLogger.d("Report stat failed: ");
                    b(list);
                    return;
                }
            } else {
                response = null;
            }
            if (response != null && response.getStatusCode() == 200) {
                a(list);
            } else {
                b(list);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.stat.a
    public void d(List<i> list) {
        g.a(this.f39698a).b().a(list);
    }

    @Override // com.qq.e.comm.plugin.stat.a
    boolean g() {
        if (System.currentTimeMillis() - d() < e() || !f.i()) {
            return false;
        }
        if (!f.f() && this.f39699b.size() + g.a(this.f39698a).b().b() < f.h() && (System.currentTimeMillis() / 1000) - c() <= f.g()) {
            return false;
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.stat.a
    public List<i> h() {
        return g.a(this.f39698a).b().a();
    }
}
