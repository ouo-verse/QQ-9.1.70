package cr3;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends ClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private Context f391704a;

    public b(ClassLoader classLoader, Context context) {
        super(classLoader);
        this.f391704a = context.getApplicationContext();
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        if (str.startsWith("com.tencent.qmethod.pandoraex.monitor")) {
            return this.f391704a.getClassLoader().loadClass(str);
        }
        return super.findClass(str);
    }
}
