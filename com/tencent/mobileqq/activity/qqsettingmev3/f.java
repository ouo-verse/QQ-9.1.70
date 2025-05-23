package com.tencent.mobileqq.activity.qqsettingmev3;

import MQQ.LhLogoResources;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.vas.update.entity.UpdateListenerParams;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.i> f185087h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f185088i;

    /* renamed from: j, reason: collision with root package name */
    private final IVasLiangNum.b f185089j;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements IVasLiangNum.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.api.IVasLiangNum.b
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                f.this.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.i> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f185091d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f185091d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.i iVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar);
                return;
            }
            this.f185091d.L(iVar);
            if (this.f185091d.k() != null) {
                this.f185091d.k().N.postValue(iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            } else {
                f.this.e();
            }
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185087h = new MutableLiveData<>();
            this.f185089j = new a();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f185087h.observe(this.f259743d, new b(aVar));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.i iVar = new com.tencent.mobileqq.activity.qqsettingme.bean.i();
        IVasLiangNum iVasLiangNum = (IVasLiangNum) QRoute.api(IVasLiangNum.class);
        boolean isEnable = iVasLiangNum.getIsEnable();
        int selfLiangId = iVasLiangNum.getSelfLiangId();
        if (isEnable && selfLiangId > 0) {
            QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 350L);
            if (businessInstance.isFileExists(selfLiangId)) {
                FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(businessInstance.getSavePath(selfLiangId) + "/lianghao.png").g(new a.c() { // from class: com.tencent.mobileqq.activity.qqsettingmev3.e
                    @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                    public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                        kVar.y(1);
                    }
                }).a();
                a16.setLoopCount(1);
                iVar.f184913d = a16;
                this.f185087h.postValue(iVar);
                return;
            }
            businessInstance.addDownLoadListener(selfLiangId, new c());
            businessInstance.startDownload(selfLiangId);
        }
        if (PrettyAccountUtil.getLhFlagValue() == 1 && PrettyAccountUtil.manageOpen()) {
            z16 = true;
        } else {
            z16 = false;
        }
        iVar.f184910a = z16;
        if (!z16) {
            this.f185087h.postValue(iVar);
            return;
        }
        LhLogoResources lhLogoResources = PrettyAccountUtil.getLhLogoResources(PrettyAccountUtil.getLhLevelValue());
        iVar.f184911b = lhLogoResources;
        if (lhLogoResources == null) {
            this.f185087h.postValue(iVar);
            return;
        }
        if (!this.f185088i) {
            PrettyAccountUtil.reportLhEvent("0X800B231", PrettyAccountUtil.getLhFlagValue(), PrettyAccountUtil.getLhLevelValue());
            this.f185088i = true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 1);
        iVar.f184912c = VasApngUtil.getApngURLDrawable(iVar.f184911b.logoUrl, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, bundle, null);
        iVar.f184914e = ThemeUtil.isNowThemeIsNight(null, false, null);
        this.f185087h.postValue(iVar);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            PrettyAccountUtil.jumpAccountInfoPage();
            PrettyAccountUtil.reportLhEvent("0X800B232", PrettyAccountUtil.getLhFlagValue(), PrettyAccountUtil.getLhLevelValue());
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).unregisterLiangIdChangedListener(this.f185089j);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPause();
            this.f185088i = false;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.preload();
            ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).registerLiangIdChangedListener(this.f185089j);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_pretty_num";
    }
}
