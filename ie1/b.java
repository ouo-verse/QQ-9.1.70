package ie1;

import com.tencent.mobileqq.app.BusinessObserver;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private int f407562d;

    public b(int i3) {
        this.f407562d = i3;
    }

    private boolean a(int i3, Object obj) {
        if (b(i3, obj)) {
            return true;
        }
        if (i3 != 8224) {
            if (i3 != 8225) {
                switch (i3) {
                    case 8273:
                        g(obj);
                        return true;
                    case 8274:
                        o((JSONObject) obj);
                        return true;
                    case 8275:
                        f((JSONObject) obj);
                        return true;
                    case 8276:
                        m(obj);
                        return true;
                    case 8277:
                        p(obj);
                        return true;
                    default:
                        return false;
                }
            }
            e(obj);
            return true;
        }
        d(obj);
        return true;
    }

    private boolean b(int i3, Object obj) {
        if (i3 != 8261) {
            if (i3 != 8262) {
                switch (i3) {
                    case 8226:
                        h(obj);
                        return true;
                    case 8227:
                        i(obj);
                        return true;
                    case 8228:
                        l(obj);
                        return true;
                    default:
                        return false;
                }
            }
            q(obj);
            return true;
        }
        r(obj);
        return true;
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f407562d != aVar.f407560a) {
                return;
            }
            Object obj2 = aVar.f407561b;
            if (a(i3, obj2)) {
                return;
            }
            if (i3 != 8272) {
                if (i3 != 8278) {
                    if (i3 != 8279) {
                        switch (i3) {
                            case 8263:
                                c(obj2);
                                return;
                            case 8264:
                                n(obj2);
                                return;
                            case 8265:
                                t();
                                return;
                            default:
                                return;
                        }
                    }
                    k(obj2);
                    return;
                }
                s(obj2);
                return;
            }
            j();
        }
    }

    public void j() {
    }

    public void t() {
    }

    public void c(Object obj) {
    }

    public void d(Object obj) {
    }

    public void e(Object obj) {
    }

    public void f(JSONObject jSONObject) {
    }

    public void g(Object obj) {
    }

    public void h(Object obj) {
    }

    public void i(Object obj) {
    }

    public void k(Object obj) {
    }

    public void l(Object obj) {
    }

    public void m(Object obj) {
    }

    public void n(Object obj) {
    }

    public void o(JSONObject jSONObject) {
    }

    public void p(Object obj) {
    }

    public void q(Object obj) {
    }

    public void r(Object obj) {
    }

    public void s(Object obj) {
    }
}
