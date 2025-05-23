package org.extra.tools;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class b implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    private static final b f423596c = new b();

    /* renamed from: b, reason: collision with root package name */
    private final Map f423598b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f423597a = new Handler(Looper.getMainLooper(), this);

    b() {
    }

    public static b a() {
        return f423596c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            FragmentManager fragmentManager = (FragmentManager) message.obj;
            c cVar = (c) fragmentManager.findFragmentByTag("io.pag.manager");
            if (fragmentManager.isDestroyed()) {
                Log.w("Lifecycle", "Parent was destroyed before our Fragment could be added.");
            } else if (cVar != this.f423598b.get(fragmentManager)) {
                Log.w("Lifecycle", "adding Fragment failed.");
            }
            this.f423598b.remove(fragmentManager);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        if ((view.getContext() instanceof Activity) && (view instanceof d)) {
            Activity activity = (Activity) view.getContext();
            if (activity.isDestroyed()) {
                return;
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            c cVar = (c) this.f423598b.get(fragmentManager);
            if (cVar == null) {
                c cVar2 = (c) fragmentManager.findFragmentByTag("io.pag.manager");
                if (cVar2 == null) {
                    cVar2 = new c();
                    this.f423598b.put(fragmentManager, cVar2);
                    fragmentManager.beginTransaction().add(cVar2, "io.pag.manager").commitAllowingStateLoss();
                    this.f423597a.obtainMessage(1, fragmentManager).sendToTarget();
                }
                cVar = cVar2;
            }
            cVar.a((d) view);
        }
    }
}
