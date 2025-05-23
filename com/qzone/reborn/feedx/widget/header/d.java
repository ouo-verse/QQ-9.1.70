package com.qzone.reborn.feedx.widget.header;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.business.result.QZoneResult;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class d implements b {

    /* renamed from: d, reason: collision with root package name */
    private final View f56247d;

    /* renamed from: e, reason: collision with root package name */
    public a f56248e;

    public d(View view) {
        this.f56247d = view;
    }

    public void a(a aVar) {
        this.f56248e = aVar;
        jo.h hVar = jo.h.f410717a;
        hVar.g("header_element_init").h(j());
        l();
        hVar.g("header_element_init").b(j());
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public boolean c(float f16, float f17) {
        return false;
    }

    public View d() {
        return this.f56248e.getContainerView();
    }

    public View e() {
        return this.f56247d;
    }

    public Handler f() {
        return this.f56248e.Z();
    }

    public Activity g() {
        return (Activity) this.f56247d.getContext();
    }

    public Lifecycle h() {
        return this.f56248e.getLifecycleOwner().getLifecycle();
    }

    public LifecycleOwner i() {
        return this.f56248e.getLifecycleOwner();
    }

    protected String j() {
        return getClass().getSimpleName();
    }

    public <VM extends ViewModel> VM k(Class<VM> cls) {
        return (VM) this.f56248e.E(cls);
    }

    public abstract void l();

    public void m(int i3) {
        if (e() == null) {
            return;
        }
        e().setVisibility(i3);
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void M() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onPostThemeChanged() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onStart() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onStop() {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onWindowFocusChanged(boolean z16) {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void r(RecyclerView recyclerView) {
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void b(RecyclerView recyclerView, int i3, int i16) {
    }
}
