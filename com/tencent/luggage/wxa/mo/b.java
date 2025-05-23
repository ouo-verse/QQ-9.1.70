package com.tencent.luggage.wxa.mo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends BaseActivity implements LuggageActivityHelper.g {
    public final Object O = new byte[0];
    public volatile LayoutInflater P = null;

    public final boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return w0.a(str.toLowerCase(), str2.toLowerCase());
    }

    @Override // com.tencent.mm.ui.BaseActivity
    public int getLayoutId() {
        return R.layout.dxx;
    }

    @Override // android.app.Activity
    @NonNull
    public LayoutInflater getLayoutInflater() {
        return k();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return com.tencent.luggage.wxa.tn.z.j();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        if ("layout_inflater".equals(str)) {
            return k();
        }
        return super.getSystemService(str);
    }

    public final boolean j() {
        if (!a("y83a") && !a("y83") && !a("v1732a") && !a("v1732t")) {
            return false;
        }
        return true;
    }

    public final LayoutInflater k() {
        if (this.P == null) {
            synchronized (this.O) {
                if (this.P == null) {
                    this.P = f.f134788a.h(this);
                }
            }
        }
        return this.P;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        LuggageActivityHelper.FOR(this).onActivityResult(i3, i16, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        LuggageActivityHelper.FOR(this).onRequestPermissionsResult(i3, strArr, iArr);
    }

    public void setNavigationbarColor(int i3) {
        int i16;
        if (Build.VERSION.SDK_INT >= 26 && !j()) {
            getWindow().setNavigationBarColor(i3);
            boolean a16 = com.tencent.luggage.wxa.lo.m.a(i3);
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (a16) {
                i16 = systemUiVisibility & (-17);
            } else {
                i16 = systemUiVisibility | 16;
            }
            decorView.setSystemUiVisibility(i16);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        try {
            super.setRequestedOrientation(i3);
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.BaseLuggageActivity", th5, "AndroidOSafety.safety uncaught", new Object[0]);
        }
    }

    public final boolean a(String str) {
        String g16 = com.tencent.luggage.wxa.t9.l.g();
        String str2 = Build.DEVICE;
        if (g16 == null && str2 == null) {
            return false;
        }
        return a(g16, str) || a(str2, str);
    }
}
