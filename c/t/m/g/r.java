package c.t.m.g;

import android.content.SharedPreferences;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes.dex */
public class r extends Observable implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f29955a = "cc_c_t_m_l_";

    /* renamed from: b, reason: collision with root package name */
    public static volatile r f29956b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile SharedPreferences f29957c;

    public r() {
        f29957c = k1.a(f29955a);
    }

    public static void a(String str) {
        f29955a = "cc_c_t_m_l_" + str;
    }

    public synchronized SharedPreferences b() {
        if (f29957c == null) {
            f29957c = k1.a(f29955a);
        }
        return f29957c;
    }

    public synchronized void c() {
        if (f29957c != null) {
            addObserver(q.b());
            f29957c.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public synchronized void d() {
        if (f29957c != null) {
            f29957c.unregisterOnSharedPreferenceChangeListener(this);
            deleteObserver(q.b());
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        setChanged();
        notifyObservers(str);
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (f29956b == null) {
                synchronized (r.class) {
                    f29956b = new r();
                }
            }
            rVar = f29956b;
        }
        return rVar;
    }
}
