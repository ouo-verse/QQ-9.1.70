package com.qzone.reborn.feedpro.widget.header;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class d implements c {

    /* renamed from: d, reason: collision with root package name */
    private final View f54610d;

    /* renamed from: e, reason: collision with root package name */
    public b f54611e;

    public d(View view) {
        this.f54610d = view;
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public boolean c(float f16, float f17) {
        return false;
    }

    public void g(b bVar) {
        this.f54611e = bVar;
        jo.h hVar = jo.h.f410717a;
        hVar.g("header_element_init").h(k());
        onInit();
        hVar.g("header_element_init").b(k());
    }

    public View h() {
        return this.f54611e.getContainerView();
    }

    public Activity i() {
        return (Activity) this.f54610d.getContext();
    }

    public LifecycleOwner j() {
        return this.f54611e.getLifecycleOwner();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        return getClass().getSimpleName();
    }

    public <VM extends ViewModel> VM l(Class<VM> cls) {
        return (VM) this.f54611e.p(cls);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void M() {
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onDestroy() {
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onPostThemeChanged() {
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void L(RecyclerView recyclerView) {
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void N(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void g0(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void b(RecyclerView recyclerView, int i3, int i16) {
    }
}
