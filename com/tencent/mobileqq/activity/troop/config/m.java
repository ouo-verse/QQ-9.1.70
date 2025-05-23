package com.tencent.mobileqq.activity.troop.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.aj;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m extends com.tencent.mobileqq.troop.api.config.h {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.h
    public void a(AppInterface appInterface, long j3, boolean z16, boolean z17) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (appInterface instanceof QQAppInterface) {
            aj ajVar = (aj) ((QQAppInterface) appInterface).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            if (z16) {
                if (j3 == 0) {
                    i3 = R.string.ekh;
                } else {
                    i3 = R.string.emr;
                }
                ajVar.g(i3, true);
                return;
            }
            int i16 = R.string.ekg;
            if (z17) {
                if (j3 != 0) {
                    i16 = R.string.emp;
                }
                ajVar.g(i16, false);
            } else {
                if (j3 != 0) {
                    i16 = R.string.emq;
                }
                ajVar.g(i16, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.h
    public void b(AppInterface appInterface, long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Long.valueOf(j3));
            return;
        }
        if (appInterface instanceof QQAppInterface) {
            aj ajVar = (aj) ((QQAppInterface) appInterface).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            if (j3 == 0) {
                i3 = R.string.ekf;
            } else {
                i3 = R.string.emo;
            }
            ajVar.g(i3, false);
        }
    }
}
