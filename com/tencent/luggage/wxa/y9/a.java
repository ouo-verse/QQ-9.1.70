package com.tencent.luggage.wxa.y9;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.y9.a;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends Toast {

    /* renamed from: h, reason: collision with root package name */
    public static AtomicBoolean f145483h;

    /* renamed from: i, reason: collision with root package name */
    public static d f145484i = new d() { // from class: v41.a
        @Override // com.tencent.luggage.wxa.y9.a.d
        public final void a(Context context, CharSequence charSequence, View view, a.c cVar, a.b bVar, int i3) {
            com.tencent.luggage.wxa.y9.a.a(context, charSequence, view, cVar, bVar, i3);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Context f145485a;

    /* renamed from: b, reason: collision with root package name */
    public int f145486b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f145487c;

    /* renamed from: d, reason: collision with root package name */
    public View f145488d;

    /* renamed from: e, reason: collision with root package name */
    public c f145489e;

    /* renamed from: f, reason: collision with root package name */
    public b f145490f;

    /* renamed from: g, reason: collision with root package name */
    public final Toast f145491g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public float f145492a;

        /* renamed from: b, reason: collision with root package name */
        public float f145493b;

        public b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public int f145494a;

        /* renamed from: b, reason: collision with root package name */
        public int f145495b;

        /* renamed from: c, reason: collision with root package name */
        public int f145496c;

        public c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(Context context, CharSequence charSequence, View view, c cVar, b bVar, int i3);
    }

    public a(Context context, CharSequence charSequence, int i3) {
        super(context);
        Context applicationContext = context.getApplicationContext();
        this.f145485a = applicationContext;
        this.f145487c = charSequence;
        this.f145486b = i3;
        this.f145491g = Toast.makeText(applicationContext, charSequence, i3);
    }

    public static Toast makeText(Context context, int i3, int i16) {
        return makeText(context, context.getResources().getText(i3), i16);
    }

    @Override // android.widget.Toast
    public void cancel() {
        try {
            this.f145491g.cancel();
        } catch (Throwable th5) {
            Log.e("MicroMsg.ToastCompat", "inner toast cancel failed: " + th5.getMessage());
        }
    }

    @Override // android.widget.Toast
    public void setDuration(int i3) {
        Toast toast = this.f145491g;
        this.f145486b = i3;
        toast.setDuration(i3);
        super.setDuration(i3);
    }

    @Override // android.widget.Toast
    public void setGravity(int i3, int i16, int i17) {
        if (this.f145489e == null) {
            this.f145489e = new c();
        }
        Toast toast = this.f145491g;
        c cVar = this.f145489e;
        cVar.f145494a = i3;
        cVar.f145495b = i16;
        cVar.f145496c = i17;
        toast.setGravity(i3, i16, i17);
        super.setGravity(i3, i16, i17);
    }

    @Override // android.widget.Toast
    public void setMargin(float f16, float f17) {
        if (this.f145490f == null) {
            this.f145490f = new b();
        }
        Toast toast = this.f145491g;
        b bVar = this.f145490f;
        bVar.f145493b = f16;
        bVar.f145492a = f17;
        toast.setMargin(f16, f17);
        super.setMargin(f16, f17);
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        Toast toast = this.f145491g;
        this.f145487c = charSequence;
        toast.setText(charSequence);
        try {
            super.setText(charSequence);
        } catch (RuntimeException unused) {
            TextView textView = new TextView(this.f145485a);
            textView.setText(charSequence);
            super.setView(textView);
        }
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        Toast toast = this.f145491g;
        this.f145488d = view;
        toast.setView(view);
        super.setView(view);
    }

    @Override // android.widget.Toast
    public void show() {
        Runnable runnable = new Runnable() { // from class: v41.b
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.y9.a.this.a();
            }
        };
        if (Looper.myLooper() == null) {
            new Handler(Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }

    public static /* synthetic */ void a(Context context, CharSequence charSequence, View view, c cVar, b bVar, int i3) {
        Toast toast = new Toast(context);
        toast.setDuration(i3);
        if (view != null) {
            toast.setView(view);
        } else {
            TextView textView = new TextView(context);
            textView.setText(charSequence);
            toast.setView(textView);
        }
        if (cVar != null) {
            toast.setGravity(cVar.f145494a, cVar.f145495b, cVar.f145496c);
        }
        if (bVar != null) {
            toast.setMargin(bVar.f145493b, bVar.f145492a);
        }
        toast.show();
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i3) {
        if (a(context)) {
            return Toast.makeText(context.getApplicationContext(), charSequence, i3);
        }
        return new a(context, charSequence, i3);
    }

    @Override // android.widget.Toast
    public void setText(int i3) {
        setText(this.f145485a.getText(i3));
    }

    public static boolean a(Context context) {
        AtomicBoolean atomicBoolean = f145483h;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        if (Build.VERSION.SDK_INT >= 30 && context.getApplicationInfo().targetSdkVersion >= 30) {
            if (Arrays.asList(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO).contains(String.valueOf(Build.MANUFACTURER).toLowerCase())) {
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                f145483h = atomicBoolean2;
                return atomicBoolean2.get();
            }
        }
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(true);
        f145483h = atomicBoolean3;
        return atomicBoolean3.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            this.f145491g.show();
        } catch (Throwable th5) {
            Log.e("MicroMsg.ToastCompat", "inner toast failed: " + th5.getMessage());
            Log.e("MicroMsg.ToastCompat", "try safeToast");
            try {
                f145484i.a(this.f145485a, this.f145487c, this.f145488d, this.f145489e, this.f145490f, this.f145486b);
            } catch (Throwable th6) {
                Log.e("MicroMsg.ToastCompat", "safe toast failed: " + th6.getMessage());
            }
        }
    }
}
