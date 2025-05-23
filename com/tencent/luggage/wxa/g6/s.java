package com.tencent.luggage.wxa.g6;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s extends com.tencent.luggage.wxa.mo.b implements t, q {
    public final r Q = createPage();
    public boolean R;

    private final void i() {
        TextView textView = (TextView) findViewById(R.id.text1);
        if (textView == null) {
            return;
        }
        textView.setTextColor(ContextCompat.getColor(a(getContext(), this.R), com.tencent.mobileqq.R.color.b3s));
    }

    public final Context a(Context context, boolean z16) {
        int i3;
        if (z16) {
            i3 = 32;
        } else {
            i3 = 16;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.uiMode = i3 | (configuration.uiMode & (-49));
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(createConfigurationContext, "context.createConfigurationContext(config)");
        return createConfigurationContext;
    }

    public abstract r createPage();

    @Override // com.tencent.luggage.wxa.g6.q
    @NotNull
    public p getNavigator() {
        return c.f126467a;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    @NotNull
    public r getPage() {
        return this.Q;
    }

    @Nullable
    public v getPageStack() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void hideActionbarLine() {
        try {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setElevation(0.0f);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.Q.i();
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.Q.a(newConfig);
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Q.b();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.Q.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.Q.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.Q.n();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.Q.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.Q.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.Q.onStop();
    }

    @Override // com.tencent.mm.ui.BaseActivity, com.tencent.luggage.wxa.g6.t
    public void setActionBarColor(int i3) {
        super.setActionBarColor(i3);
        this.R = com.tencent.luggage.wxa.lo.m.a(i3);
        i();
    }

    @Override // android.app.Activity, com.tencent.luggage.wxa.g6.t
    public void setTitle(int i3) {
        super.setTitle(i3);
        i();
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void showActionbarLine() {
        try {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setElevation(1.0f);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void superOnBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.mm.ui.BaseActivity, android.app.Activity, com.tencent.luggage.wxa.g6.t
    public void setTitle(@Nullable CharSequence charSequence) {
        super.setTitle(charSequence);
        i();
    }

    @Override // com.tencent.luggage.wxa.g6.t, com.tencent.luggage.wxa.g6.a
    @NotNull
    public Context getContext() {
        return this;
    }
}
