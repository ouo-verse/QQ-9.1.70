package ia1;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private Activity f407358a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f407359b;

    /* renamed from: c, reason: collision with root package name */
    private List<a> f407360c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f407361d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void onTranslucentConversionComplete(boolean z16);
    }

    public c(Activity activity, boolean z16) {
        this.f407358a = activity;
        this.f407359b = z16;
    }

    public void a(a aVar) {
        this.f407360c.add(aVar);
    }

    public void b() {
        Activity activity;
        if (!this.f407361d && (activity = this.f407358a) != null) {
            this.f407361d = true;
            com.tencent.mobileqq.colornote.swipe.c.a(activity, this);
        }
    }

    public boolean c() {
        return this.f407359b;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equalsIgnoreCase("onTranslucentConversionComplete") && objArr != null && objArr.length > 0) {
            this.f407359b = true;
            Object obj2 = objArr[0];
            if (QLog.isColorLevel()) {
                QLog.d("TranslucentConvertor", 2, "onTranslucentConversionComplete: " + obj2);
            }
            Boolean bool = Boolean.FALSE;
            if (obj2 instanceof Boolean) {
                bool = (Boolean) obj2;
            }
            Iterator<a> it = this.f407360c.iterator();
            while (it.hasNext()) {
                it.next().onTranslucentConversionComplete(bool.booleanValue());
            }
            return null;
        }
        return null;
    }
}
