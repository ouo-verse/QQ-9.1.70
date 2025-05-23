package com.tencent.luggage.wxa.f6;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends MutableContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public boolean f125398a;

    /* renamed from: b, reason: collision with root package name */
    public final ContextThemeWrapper f125399b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends ContextThemeWrapper {

        /* renamed from: a, reason: collision with root package name */
        public volatile LayoutInflater f125400a;

        public a(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            LayoutInflater layoutInflater;
            if ("layout_inflater".equals(str)) {
                synchronized (this) {
                    if (this.f125400a == null) {
                        this.f125400a = (LayoutInflater) super.getSystemService(str);
                    }
                    layoutInflater = this.f125400a;
                }
                return layoutInflater;
            }
            return super.getSystemService(str);
        }
    }

    public j(Context context, int i3) {
        super(context);
        this.f125398a = false;
        a aVar = new a(context.getApplicationContext(), i3);
        this.f125399b = aVar;
        if (!(context instanceof ContextThemeWrapper)) {
            super.setBaseContext(aVar);
        } else {
            context.setTheme(i3);
        }
        this.f125398a = context instanceof Activity;
    }

    public static j a(Context context) {
        return new j(context, R.style.atv);
    }

    @Override // android.content.MutableContextWrapper
    public void setBaseContext(Context context) {
        if (context == getBaseContext()) {
            return;
        }
        if (this.f125398a) {
            w.d("MicroMsg.AppBrandRuntimePersistentContextWrapper", "setBaseContext hash:%d, new:%s, old:%s, stack:%s", Integer.valueOf(hashCode()), context, super.getBaseContext(), Log.getStackTraceString(new Throwable()));
        }
        if (context instanceof Activity) {
            super.setBaseContext(context);
            this.f125398a = true;
        } else {
            if (context instanceof e) {
                super.setBaseContext(context);
                return;
            }
            if (context instanceof j) {
                j jVar = (j) context;
                if (jVar.getBaseContext() instanceof Activity) {
                    super.setBaseContext(jVar.getBaseContext());
                    this.f125398a = true;
                    return;
                }
            }
            super.setBaseContext(this.f125399b);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e16) {
            w.a("MicroMsg.AppBrandRuntimePersistentContextWrapper", e16, "[CAPTURED CRASH]", new Object[0]);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e16) {
            w.b("MicroMsg.AppBrandRuntimePersistentContextWrapper", "unregisterReceiver IllegalArgumentException %s", e16);
        }
    }
}
