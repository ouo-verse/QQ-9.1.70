package hx1;

import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f406549b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static a f406550c;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<InterfaceC10478a> f406551a = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    /* renamed from: hx1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC10478a {
        void a(CommonBotInfo commonBotInfo);
    }

    a() {
    }

    public static a a() {
        if (f406550c == null) {
            synchronized (f406549b) {
                if (f406550c == null) {
                    f406550c = new a();
                }
            }
        }
        return f406550c;
    }

    public void b(CommonBotInfo commonBotInfo) {
        Iterator<InterfaceC10478a> it = this.f406551a.iterator();
        while (it.hasNext()) {
            it.next().a(commonBotInfo);
        }
    }

    public void c(InterfaceC10478a interfaceC10478a) {
        d(interfaceC10478a);
        this.f406551a.add(interfaceC10478a);
    }

    public void d(InterfaceC10478a interfaceC10478a) {
        this.f406551a.remove(interfaceC10478a);
    }
}
