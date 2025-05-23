package com.vivo.datashare.permission;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.vivo.datashare.permission.b;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class a<E extends com.vivo.datashare.permission.b> {

    /* renamed from: a, reason: collision with root package name */
    private Context f387540a;

    /* renamed from: c, reason: collision with root package name */
    BroadcastReceiver f387542c = new C10085a();

    /* renamed from: b, reason: collision with root package name */
    private E f387541b = d();

    /* compiled from: P */
    /* renamed from: com.vivo.datashare.permission.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    class C10085a extends BroadcastReceiver {
        C10085a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean a16 = wy4.a.a();
            if (a16) {
                Log.d("AbsPermission", "onReceive");
            }
            if (intent != null && intent.getAction() != null) {
                if (a16) {
                    Log.d("AbsPermission", "action=" + intent.getAction());
                }
                if (TextUtils.equals(intent.getAction(), "com.vivo.assistant.authorization.response")) {
                    try {
                        intent.getIntExtra("extra_response_data", 0);
                        intent.getStringExtra("extra_response_permission_key");
                        intent.getIntExtra("extra_response_code", 0);
                        a.a(a.this);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface b {
    }

    public a(Context context) {
        this.f387540a = context;
    }

    static /* synthetic */ b a(a aVar) {
        aVar.getClass();
        return null;
    }

    public Context b() {
        return this.f387540a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public E c() {
        return this.f387541b;
    }

    protected abstract E d();
}
