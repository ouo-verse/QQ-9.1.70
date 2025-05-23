package e43;

import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.vasgift.countdown.CountDownController;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f395682b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, CountDownController> f395683a = new ConcurrentHashMap();

    public static a d() {
        if (f395682b == null) {
            synchronized (a.class) {
                if (f395682b == null) {
                    f395682b = new a();
                }
            }
        }
        return f395682b;
    }

    public static boolean e(d dVar) {
        d.c cVar;
        if (dVar != null && dVar.F == 1 && (cVar = dVar.G) != null && cVar.f264891d > 0) {
            return true;
        }
        return false;
    }

    public void a(String str) {
        CountDownController countDownController = new CountDownController(str);
        countDownController.j();
        this.f395683a.put(str, countDownController);
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftCountDownManager", 2, "[enterRoom] key:" + str + ",mCountDownControlMapSize:" + this.f395683a.size());
        }
    }

    public void b(String str) {
        CountDownController remove = this.f395683a.remove(str);
        if (remove != null) {
            remove.k();
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftCountDownManager", 2, "[exitRoom] key:" + str + ",mCountDownControlMapSize:" + this.f395683a.size());
        }
    }

    public CountDownController c(String str) {
        return this.f395683a.get(str);
    }

    public void f(String str) {
        CountDownController countDownController = this.f395683a.get(str);
        if (countDownController != null) {
            countDownController.t();
        } else {
            QLog.w("QQGiftCountDownManager", 1, "[hidePanel] key:" + str + ",ctrl is null");
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftCountDownManager", 2, "[hidePanel] key:" + str + ",mCountDownControlMapSize:" + this.f395683a.size());
        }
    }

    public void g(String str) {
        CountDownController countDownController = new CountDownController(str);
        this.f395683a.put(str, countDownController);
        countDownController.u();
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftCountDownManager", 2, "[showPanel] key:" + str + ",mCountDownControlMapSize:" + this.f395683a.size());
        }
    }
}
