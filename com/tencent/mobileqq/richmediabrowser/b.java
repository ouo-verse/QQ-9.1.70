package com.tencent.mobileqq.richmediabrowser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements IBrowserBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Context f281793a;

    /* renamed from: b, reason: collision with root package name */
    private AIOBrowserPresenter f281794b;

    /* renamed from: c, reason: collision with root package name */
    private AIOBrowserScene f281795c;

    /* renamed from: d, reason: collision with root package name */
    private tm2.a f281796d;

    /* renamed from: e, reason: collision with root package name */
    private b04.a f281797e;

    public b(Context context) {
        this.f281793a = context;
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AIOBrowserPresenter getPresenter() {
        return this.f281794b;
    }

    public void b(b04.a aVar) {
        this.f281797e = aVar;
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildComplete() {
        this.f281794b.buildComplete();
        this.f281795c.buildComplete();
        this.f281796d.buildComplete();
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildModel() {
        this.f281796d.buildModel();
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildParams(Intent intent) {
        this.f281794b.buildParams(intent);
        this.f281795c.buildParams(intent);
        this.f281796d.buildParams(intent);
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildPresenter() {
        AIOBrowserPresenter aIOBrowserPresenter = new AIOBrowserPresenter(this.f281793a.getResources().getConfiguration().orientation);
        this.f281794b = aIOBrowserPresenter;
        aIOBrowserPresenter.setParamsBuilder(this.f281797e);
        AIOBrowserScene aIOBrowserScene = new AIOBrowserScene(this.f281793a, this.f281794b);
        this.f281795c = aIOBrowserScene;
        this.f281794b.Y(aIOBrowserScene);
        tm2.a aVar = new tm2.a(this.f281794b);
        this.f281796d = aVar;
        this.f281794b.X(aVar);
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildView() {
        this.f281795c.buildView();
    }
}
