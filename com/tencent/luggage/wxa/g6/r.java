package com.tencent.luggage.wxa.g6;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mm.ui.BaseActivity;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class r implements LifecycleOwner, ViewModelStoreOwner, a {

    /* renamed from: a, reason: collision with root package name */
    public final t f126566a;

    public r(t tVar) {
        this.f126566a = tVar;
    }

    public void a(Intent intent) {
    }

    public void b() {
        if (g() != 0) {
            this.f126566a.setContentView(g());
        }
    }

    public View findViewById(int i3) {
        return this.f126566a.findViewById(i3);
    }

    public void finish() {
        this.f126566a.finish();
    }

    public int g() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.g6.a
    public Context getContext() {
        return this.f126566a.getContext();
    }

    @Override // com.tencent.luggage.wxa.g6.a
    public Intent getIntent() {
        return this.f126566a.getIntent();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f126566a.getLifecycle();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        return this.f126566a.get_viewModelStore();
    }

    public Window getWindow() {
        return this.f126566a.getWindow();
    }

    public boolean h() {
        return false;
    }

    public void hideActionbarLine() {
        this.f126566a.hideActionbarLine();
    }

    public void i() {
        this.f126566a.superOnBackPressed();
    }

    @Override // com.tencent.luggage.wxa.g6.a
    public void overridePendingTransition(int i3, int i16) {
        this.f126566a.overridePendingTransition(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.g6.a
    public void runOnUiThread(Runnable runnable) {
        this.f126566a.runOnUiThread(runnable);
    }

    public void setActionBarColor(int i3) {
        this.f126566a.setActionBarColor(i3);
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        setBackBtn(onMenuItemClickListener, 0, BaseActivity.h.BACK);
    }

    public void setContentView(int i3) {
        this.f126566a.setContentView(i3);
    }

    public void setIntent(Intent intent) {
        this.f126566a.setIntent(intent);
    }

    public void setResult(int i3) {
        this.f126566a.setResult(i3);
    }

    public void setTitle(int i3) {
        this.f126566a.setTitle(i3);
    }

    public void showActionbarLine() {
        this.f126566a.showActionbarLine();
    }

    public void a(Configuration configuration) {
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i3, BaseActivity.h hVar) {
        this.f126566a.setBackBtn(onMenuItemClickListener, i3, hVar);
    }

    @Override // com.tencent.luggage.wxa.g6.a
    public void setResult(int i3, Intent intent) {
        this.f126566a.setResult(i3, intent);
    }

    public void setTitle(CharSequence charSequence) {
        this.f126566a.setTitle(charSequence);
    }

    public void n() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
