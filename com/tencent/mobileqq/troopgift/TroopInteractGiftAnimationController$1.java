package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.am;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
class TroopInteractGiftAnimationController$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f302817d;
    final /* synthetic */ j this$0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController$1$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f302818d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopInteractGiftAnimationController$1 f302819e;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            JSONObject jSONObject = this.f302818d;
            if (jSONObject == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopInteractGiftAnimationController", 2, "TroopGiftUtil.getInteractConfig = null, packageId: " + this.f302819e.f302817d);
                    return;
                }
                return;
            }
            jSONObject.optInt("type", 2);
            this.f302819e.getClass();
            throw null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            am.h(this.f302817d);
            throw null;
        }
    }
}
