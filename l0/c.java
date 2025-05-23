package l0;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.util.cl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f413555a;

    /* renamed from: b, reason: collision with root package name */
    private List<l0.b> f413556b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private k f413557c = new a();

    /* renamed from: d, reason: collision with root package name */
    public l0.b f413558d;

    /* renamed from: e, reason: collision with root package name */
    private b f413559e;

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a extends k {
        a() {
        }

        @Override // com.tencent.mobileqq.app.k
        protected void f() {
            c.this.h(1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i3);
    }

    public c(QQAppInterface qQAppInterface) {
        this.f413555a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3) {
        d();
        b bVar = this.f413559e;
        if (bVar != null) {
            bVar.a(i3);
        }
    }

    public boolean b() {
        if (((RegisterProxySvcPackHandler) this.f413555a.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).P2() != 0) {
            return true;
        }
        return false;
    }

    public l0.b c(String str) {
        if (str != null) {
            l0.a aVar = new l0.a();
            aVar.f413550b = 1;
            aVar.f413551c = 0L;
            aVar.f413549a = str;
            aVar.f413554f = true;
            aVar.f413553e = true;
            aVar.f413552d = true;
            return aVar;
        }
        return null;
    }

    public List<l0.b> d() {
        this.f413556b.clear();
        List<String> list = ((DataLineHandler) this.f413555a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).D.f194906c;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f413556b.add(c(it.next()));
            }
        }
        return this.f413556b;
    }

    public l0.b e() {
        String currentAccountUin = this.f413555a.getCurrentAccountUin();
        String d16 = cl.d(this.f413555a.getApplication(), currentAccountUin + "_last_printer");
        d();
        return g(d16);
    }

    public l0.b f(long j3) {
        if (j3 != 0 && this.f413556b.size() > 0) {
            for (l0.b bVar : this.f413556b) {
                if (bVar.f413551c == j3) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public l0.b g(String str) {
        if (str != null && this.f413556b.size() > 0) {
            for (l0.b bVar : this.f413556b) {
                if (bVar.f413549a.equals(str)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public void i(b bVar) {
        QQAppInterface qQAppInterface = this.f413555a;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.f413557c);
        }
        this.f413559e = bVar;
    }

    public void j(String str) {
        if (str == null) {
            return;
        }
        String currentAccountUin = this.f413555a.getCurrentAccountUin();
        cl.j(this.f413555a.getApplication(), currentAccountUin + "_last_printer", str);
    }

    public void k() {
        QQAppInterface qQAppInterface = this.f413555a;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f413557c);
        }
        this.f413559e = null;
    }
}
