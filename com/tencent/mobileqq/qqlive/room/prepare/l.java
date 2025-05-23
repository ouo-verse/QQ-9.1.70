package com.tencent.mobileqq.qqlive.room.prepare;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;

/* compiled from: P */
/* loaded from: classes17.dex */
public class l extends com.tencent.mobileqq.mvvm.b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements Observer<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.room.prepare.d f271960d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f271961e;

        a(com.tencent.mobileqq.qqlive.room.prepare.d dVar, k kVar) {
            this.f271960d = dVar;
            this.f271961e = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) kVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            } else {
                this.f271960d.Ma(this.f271961e.N1());
                this.f271960d.W3(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements Observer<CoverInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.room.prepare.d f271962d;

        b(com.tencent.mobileqq.qqlive.room.prepare.d dVar) {
            this.f271962d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(CoverInfo coverInfo) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) coverInfo);
                return;
            }
            if (coverInfo != null) {
                str = coverInfo.roomLogo16v9;
            } else {
                str = "";
            }
            this.f271962d.b3(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements Observer<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.room.prepare.d f271963d;

        c(com.tencent.mobileqq.qqlive.room.prepare.d dVar) {
            this.f271963d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.f271963d.ie(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d implements Observer<com.tencent.mobileqq.qqlive.room.prepare.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.room.prepare.d f271964d;

        d(com.tencent.mobileqq.qqlive.room.prepare.d dVar) {
            this.f271964d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.qqlive.room.prepare.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                this.f271964d.p5(aVar);
            }
        }
    }

    public static void g(LifecycleOwner lifecycleOwner, k kVar, com.tencent.mobileqq.qqlive.room.prepare.d dVar, Bundle bundle) {
        kVar.H.removeObservers(lifecycleOwner);
        kVar.H.observe(lifecycleOwner, new a(dVar, kVar));
        kVar.E.removeObservers(lifecycleOwner);
        kVar.E.observe(lifecycleOwner, new b(dVar));
        kVar.F.removeObservers(lifecycleOwner);
        kVar.F.observe(lifecycleOwner, new c(dVar));
        kVar.I.removeObservers(lifecycleOwner);
        kVar.I.observe(lifecycleOwner, new d(dVar));
        kVar.t2(bundle.getString(QQLiveReportConstants.INTENT_TRACE_ID, ""));
        kVar.s2(bundle.getInt("source", 0));
    }
}
