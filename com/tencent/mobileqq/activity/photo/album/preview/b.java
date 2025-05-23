package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements IBrowserBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.photo.album.preview.presenter.c f184318a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.activity.photo.album.preview.view.c f184319b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.activity.photo.album.preview.model.a f184320c;

    /* renamed from: d, reason: collision with root package name */
    private b04.a f184321d;

    /* renamed from: e, reason: collision with root package name */
    public e<? extends OtherCommonData> f184322e;

    public b(e<? extends OtherCommonData> eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        } else {
            this.f184322e = eVar;
        }
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.activity.photo.album.preview.presenter.c getPresenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.activity.photo.album.preview.presenter.c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f184318a;
    }

    public void b(b04.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f184321d = aVar;
        }
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f184318a.buildComplete();
        this.f184319b.buildComplete();
        this.f184320c.buildComplete();
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f184320c.buildModel();
        }
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildParams(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        this.f184318a.buildParams(intent);
        this.f184319b.buildParams(intent);
        this.f184320c.buildParams(intent);
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildPresenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.photo.album.preview.presenter.c cVar = new com.tencent.mobileqq.activity.photo.album.preview.presenter.c();
        this.f184318a = cVar;
        e<? extends OtherCommonData> eVar = this.f184322e;
        eVar.f184337i = cVar;
        cVar.q(eVar);
        this.f184318a.setParamsBuilder(this.f184321d);
        com.tencent.mobileqq.activity.photo.album.preview.view.c cVar2 = new com.tencent.mobileqq.activity.photo.album.preview.view.c(this.f184322e.f184333d, this.f184318a);
        this.f184319b = cVar2;
        cVar2.t(this.f184322e);
        this.f184318a.p(this.f184319b);
        com.tencent.mobileqq.activity.photo.album.preview.model.a aVar = new com.tencent.mobileqq.activity.photo.album.preview.model.a(this.f184318a);
        this.f184320c = aVar;
        this.f184318a.o(aVar);
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f184319b.buildView();
        }
    }
}
