package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private boolean f298279c;

    public b(QQAppInterface qQAppInterface, String str) {
        super(qQAppInterface, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
        } else {
            this.f298279c = false;
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "GameCardProcessor";
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f298278b != null && !TextUtils.isEmpty(this.f298277a)) {
            this.f298279c = false;
            if (QLog.isColorLevel()) {
                QLog.d("GameCardProcessor", 2, "initTroopSettingRedPointInfo : needShowGameCardRedPoint = " + this.f298279c);
            }
            ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.f298278b, this.f298277a, "troop", 3, this.f298279c ? 1 : 0);
        }
    }
}
