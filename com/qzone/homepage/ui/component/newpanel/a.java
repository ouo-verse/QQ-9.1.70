package com.qzone.homepage.ui.component.newpanel;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name */
    private Context f47753d;

    /* renamed from: e, reason: collision with root package name */
    protected final long f47754e;

    /* renamed from: f, reason: collision with root package name */
    protected final long f47755f;

    /* renamed from: h, reason: collision with root package name */
    protected final boolean f47756h;

    /* compiled from: P */
    /* renamed from: com.qzone.homepage.ui.component.newpanel.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0394a {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
    }

    public a(Context context, long j3) {
        this.f47753d = context;
        this.f47754e = j3;
        long uin = LoginData.getInstance().getUin();
        this.f47755f = uin;
        this.f47756h = j3 != uin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context a() {
        return this.f47753d;
    }

    public InterfaceC0394a b() {
        return null;
    }

    public b c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Resources d() {
        return this.f47753d.getResources();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        c();
        EventCollector.getInstance().onViewLongClicked(view);
        return false;
    }
}
