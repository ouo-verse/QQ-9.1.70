package com.tencent.mobileqq.activity.troop.config;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l extends com.tencent.mobileqq.troop.api.config.j {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void e(QQAppInterface qQAppInterface, List<TroopInfo> list) {
        for (TroopInfo troopInfo : list) {
            TroopUtils.N(qQAppInterface, troopInfo.troopuin, troopInfo.discussUin, troopInfo.discussMaxSeq, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.api.config.j
    public void c(final AppInterface appInterface, final List<TroopInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) list);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            e((QQAppInterface) appInterface, list);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.troop.config.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.e(appInterface, list);
                }
            }, 16, null, true);
        }
    }
}
