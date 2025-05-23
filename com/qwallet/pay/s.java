package com.qwallet.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.qwallet.activity.QPayCompactActivity;
import com.qwallet.pay.b;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    private static volatile s f41672b;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<com.qwallet.pay.b> f41673a = new SparseArray<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements b.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qwallet.pay.b f41674d;

        a(com.qwallet.pay.b bVar) {
            this.f41674d = bVar;
        }

        @Override // com.qwallet.pay.b.a
        public void x2(Context context) {
            this.f41674d.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements b.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qwallet.pay.b f41676d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b.a f41677e;

        b(com.qwallet.pay.b bVar, b.a aVar) {
            this.f41676d = bVar;
            this.f41677e = aVar;
        }

        @Override // com.qwallet.pay.b.a
        public void x2(Context context) {
            this.f41676d.onDestroy();
            b.a aVar = this.f41677e;
            if (aVar != null) {
                aVar.x2(context);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements b.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qwallet.pay.b f41679d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b.a f41680e;

        c(com.qwallet.pay.b bVar, b.a aVar) {
            this.f41679d = bVar;
            this.f41680e = aVar;
        }

        @Override // com.qwallet.pay.b.a
        public void x2(Context context) {
            this.f41679d.onDestroy();
            b.a aVar = this.f41680e;
            if (aVar != null) {
                aVar.x2(context);
            }
        }
    }

    s() {
    }

    private com.qwallet.pay.b a(Context context, Intent intent) {
        return PayLogicFactory.a(context, intent);
    }

    private void c(Context context, com.qwallet.pay.b bVar) {
        if (bVar.b()) {
            this.f41673a.append(bVar.hashCode(), bVar);
            QPayCompactActivity.ph(context, bVar.hashCode());
        } else {
            bVar.a(context);
        }
    }

    public static s e() {
        if (f41672b == null) {
            synchronized (s.class) {
                if (f41672b == null) {
                    f41672b = new s();
                }
            }
        }
        return f41672b;
    }

    public static int f(Intent intent) {
        try {
            return intent.getBundleExtra(IQWalletHelper.QWALLET_EXTRA_KEY_PAY_BUNDLE).getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        } catch (Throwable th5) {
            QLog.e("Q.qwallet.pay.PayPluginLogicManager", 1, "", th5);
            return -1;
        }
    }

    public com.qwallet.pay.b b(Context context, Intent intent, b.a aVar) {
        com.qwallet.pay.b a16 = a(context, intent);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.qwallet.pay.PayPluginLogicManager", 2, "logic is null");
                return null;
            }
            return null;
        }
        a16.c(new c(a16, aVar));
        return a16;
    }

    public void d(Activity activity, int i3, b.a aVar) {
        com.qwallet.pay.b g16 = g(i3);
        if (g16 == null) {
            if (aVar != null) {
                aVar.x2(activity);
            }
        } else {
            g16.c(new b(g16, aVar));
            g16.a(activity);
        }
    }

    public com.qwallet.pay.b g(int i3) {
        return this.f41673a.get(i3);
    }

    public void h(int i3) {
        this.f41673a.remove(i3);
    }

    public void i(Context context, Intent intent) {
        if (context != null && intent != null) {
            com.qwallet.pay.b a16 = a(context, intent);
            if (a16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.qwallet.pay.PayPluginLogicManager", 2, "logic is null");
                    return;
                }
                return;
            } else {
                a16.c(new a(a16));
                c(context, a16);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.qwallet.pay.PayPluginLogicManager", 2, "context or intent is null, context =" + context + ",intent=" + intent);
        }
    }
}
