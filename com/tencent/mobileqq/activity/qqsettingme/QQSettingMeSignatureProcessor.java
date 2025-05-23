package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.state.data.SquareJSConst;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes10.dex */
public class QQSettingMeSignatureProcessor extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> f184722h;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.n> f184723i;

    /* renamed from: j, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.l> f184724j;

    /* renamed from: k, reason: collision with root package name */
    private StatusManager f184725k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.mobileqq.richstatus.h f184726l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.richstatus.e f184727m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.mobileqq.richstatus.d f184728n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f184729o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f184730p;

    /* loaded from: classes10.dex */
    class a implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.n> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184737d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184737d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.n nVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar);
                return;
            }
            this.f184737d.s(nVar);
            QQSettingMeViewModel k3 = this.f184737d.k();
            if (k3 != null) {
                k3.E.postValue(nVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.l> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184739d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184739d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.l lVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lVar);
                return;
            }
            this.f184739d.Q(lVar);
            QQSettingMeViewModel k3 = this.f184739d.k();
            if (k3 != null) {
                k3.F.postValue(lVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    class c implements Observer<BusinessInfoCheckUpdate.AppInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184741d;

        c(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184741d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(BusinessInfoCheckUpdate.AppInfo appInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInfo);
                return;
            }
            this.f184741d.P(appInfo);
            QQSettingMeViewModel k3 = this.f184741d.k();
            if (k3 != null) {
                k3.D.postValue(appInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements com.tencent.mobileqq.richstatus.h {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.richstatus.h
        public void onChangeStatus(int i3, RichStatus richStatus, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), richStatus, obj);
                return;
            }
            QBaseActivity qBaseActivity = (QBaseActivity) ((com.tencent.mobileqq.processor.c) QQSettingMeSignatureProcessor.this).f259741b.get();
            if (qBaseActivity != null && QQSettingMeSignatureProcessor.this.f184729o) {
                if (i3 != 100) {
                    QQToast.makeText(qBaseActivity, R.string.f170712zo, 0).show(qBaseActivity.getTitleBarHeight());
                }
                QQSettingMeSignatureProcessor.this.e();
            }
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onGetSyncShuoShuo(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onSetSyncShuoShuo(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            QQSettingMeSignatureProcessor.this.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Bitmap bitmap, int i3, int i16) {
            if (QQSettingMeSignatureProcessor.this.f184729o && bitmap != null && QQSettingMeSignatureProcessor.this.f184725k != null && QQSettingMeSignatureProcessor.this.f184725k.Q().actionId == i3 && i16 == 200) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeSignatureProcessor.e.this.c();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(final int i3, final int i16, final Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.ap
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeSignatureProcessor.e.this.d(bitmap, i3, i16);
                    }
                }, 32, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements com.tencent.mobileqq.richstatus.d {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.d
        public void v2(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (QQSettingMeSignatureProcessor.this.f184729o && i3 == 102 && i16 == 300) {
                QQSettingMeSignatureProcessor.this.e();
            }
        }
    }

    public QQSettingMeSignatureProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184722h = new MutableLiveData<>();
        this.f184723i = new MutableLiveData<>();
        this.f184724j = new MutableLiveData<>();
    }

    @NonNull
    private com.tencent.mobileqq.activity.qqsettingme.bean.l q() {
        if (this.f184724j.getValue() == null) {
            return new com.tencent.mobileqq.activity.qqsettingme.bean.l();
        }
        return this.f184724j.getValue();
    }

    private void r() {
        d dVar = new d();
        this.f184726l = dVar;
        this.f184725k.C(dVar);
        e eVar = new e();
        this.f184727m = eVar;
        this.f184725k.C(eVar);
        f fVar = new f();
        this.f184728n = fVar;
        this.f184725k.C(fVar);
    }

    private void s() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.f184725k = (StatusManager) peekAppRuntime.getManager(QQManagerFactory.STATUS_MANAGER);
        ThreadManagerV2.excute(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f184734d;

            {
                this.f184734d = peekAppRuntime;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this, (Object) peekAppRuntime);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.activity.qqsettingme.bean.n nVar = new com.tencent.mobileqq.activity.qqsettingme.bean.n();
                SharedPreferences sharedPreferences = this.f184734d.getApp().getSharedPreferences("qqsettingme_signature" + this.f184734d.getAccount(), 0);
                nVar.f184929b = sharedPreferences.getString("actionText", "");
                nVar.f184928a = sharedPreferences.getInt("actionId", 0);
                nVar.f184930c = sharedPreferences.getString("dataText", "");
                nVar.f184932e = sharedPreferences.getString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, "");
                nVar.f184931d = sharedPreferences.getString(MessageForRichState.SIGN_MSG_TOPICS, "");
                nVar.f184933f = sharedPreferences.getString("plainMixTopic", "");
                if (QQSettingMeSignatureProcessor.this.f184725k != null) {
                    nVar.f184934g = QQSettingMeSignatureProcessor.this.f184725k.K(nVar.f184928a, 200);
                }
                ThreadManager.getUIHandler().post(new Runnable(nVar) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.6.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.n f184735d;

                    {
                        this.f184735d = nVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) nVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QQSettingMeSignatureProcessor.this.f184723i.setValue(this.f184735d);
                        }
                    }
                });
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
            return;
        }
        if (this.f184730p) {
            StatusManager statusManager = this.f184725k;
            if (statusManager != null) {
                statusManager.b0(this.f184726l);
                this.f184725k.b0(this.f184727m);
                this.f184725k.b0(this.f184728n);
            }
            e();
        }
        this.f259740a = new WeakReference<>(appRuntime);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.f184723i.observe(this.f259743d, new a(aVar));
        this.f184724j.observe(this.f259743d, new b(aVar));
        this.f184722h.observe(this.f259743d, new c(aVar));
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        StatusManager statusManager = (StatusManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.STATUS_MANAGER);
        this.f184725k = statusManager;
        if (statusManager == null) {
            return;
        }
        if (this.f184726l == null) {
            r();
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.l lVar = new com.tencent.mobileqq.activity.qqsettingme.bean.l();
        RichStatus R = this.f184725k.R(false);
        lVar.f184922a = R;
        if (R != null && !R.isEmpty()) {
            lVar.f184923b = this.f184725k.K(lVar.f184922a.actionId, 200);
            this.f184724j.setValue(lVar);
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable(lVar) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.l f184731d;

                {
                    this.f184731d = lVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeSignatureProcessor.this, (Object) lVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    StatusManager statusManager2 = (StatusManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.STATUS_MANAGER);
                    if (statusManager2 != null) {
                        this.f184731d.f184922a = statusManager2.R(true);
                        com.tencent.mobileqq.activity.qqsettingme.bean.l lVar2 = this.f184731d;
                        lVar2.f184923b = statusManager2.K(lVar2.f184922a.actionId, 200);
                        QQSettingMeSignatureProcessor.this.f184724j.postValue(this.f184731d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SIGNATURE));
        am.b(appInfoByPath);
        if (this.f184729o) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(peekAppRuntime, appInfoByPath) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f184732d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f184733e;

                {
                    this.f184732d = peekAppRuntime;
                    this.f184733e = appInfoByPath;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQSettingMeSignatureProcessor.this, peekAppRuntime, appInfoByPath);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        am.a(this.f184732d, this.f184733e, ((com.tencent.mobileqq.processor.c) QQSettingMeSignatureProcessor.this).f259744e);
                        QQSettingMeSignatureProcessor.this.f184722h.setValue(this.f184733e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("from_type", 0);
        Intent intent = new Intent();
        intent.putExtra(SquareJSConst.Params.PARAMS_RICH_STATUS, q().f184922a);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", "com.tencent.mobileqq.signature.SignTextEditFragment");
        intent.setClass(qBaseActivity, QPublicFragmentActivity.class);
        qBaseActivity.startActivityForResult(intent, -1);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X80072D8", "0X80072D8", 0, 0, "", "", "", "");
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800A669", "0X800A669", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        StatusManager statusManager = this.f184725k;
        if (statusManager != null) {
            statusManager.b0(this.f184726l);
            this.f184725k.b0(this.f184727m);
            this.f184725k.b0(this.f184728n);
            this.f184725k = null;
            this.f184726l = null;
            this.f184727m = null;
            this.f184728n = null;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPause();
            this.f184729o = false;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        e();
        this.f184729o = true;
        this.f184730p = true;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            s();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_signature";
    }
}
