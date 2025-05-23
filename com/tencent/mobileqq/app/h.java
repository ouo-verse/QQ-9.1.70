package com.tencent.mobileqq.app;

import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.util.Pair;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceRespInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    protected void b(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void c(boolean z16, AppShareID appShareID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), appShareID);
        }
    }

    protected void d(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void e(Boolean bool, Boolean bool2, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bool, bool2, str, str2, str3);
        }
    }

    protected void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
    }

    protected void g(Boolean bool, Boolean bool2, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bool, bool2, str, str2, str3);
        }
    }

    protected void h(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        }
    }

    protected void j(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    protected void k(String str, int i3, ArrayList<QQOperationViopTipTask> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), arrayList);
        }
    }

    protected void l(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str);
        }
    }

    protected void m(boolean z16, GetResourceRespInfo getResourceRespInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), getResourceRespInfo);
        }
    }

    protected void n(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        switch (i3) {
            case 1:
                a(z16, ((GetResourceRespInfo) obj).uiNewVer);
                return;
            case 2:
                m(z16, (GetResourceRespInfo) obj);
                return;
            case 3:
                l(z16, (String) obj);
                return;
            case 4:
                p(z16, (UpgradeDetailWrapper) obj);
                return;
            case 5:
                c(z16, (AppShareID) obj);
                return;
            case 6:
                j(z16, ((GetResourceRespInfo) obj).uiNewVer);
                return;
            case 7:
                n(z16, ((Integer) obj).intValue());
                return;
            case 8:
                if (obj != null && (obj instanceof OperateVoipTipsInfo)) {
                    OperateVoipTipsInfo operateVoipTipsInfo = (OperateVoipTipsInfo) obj;
                    k(operateVoipTipsInfo.uin, operateVoipTipsInfo.uinType, operateVoipTipsInfo.taskList);
                    break;
                }
                break;
            case 9:
                break;
            case 10:
                Pair pair = (Pair) obj;
                d(z16, (String) pair.first, (String) pair.second);
                return;
            case 11:
                b(z16, ((Boolean) obj).booleanValue());
                return;
            case 12:
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    h(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                    return;
                }
                return;
            case 13:
                if (obj instanceof Object[]) {
                    Object[] objArr2 = (Object[]) obj;
                    e((Boolean) objArr2[0], (Boolean) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                    return;
                }
                return;
            case 14:
                if (obj instanceof Object[]) {
                    Object[] objArr3 = (Object[]) obj;
                    if (objArr3.length > 4) {
                        g((Boolean) objArr3[0], (Boolean) objArr3[1], (String) objArr3[2], (String) objArr3[3], (String) objArr3[4]);
                        return;
                    }
                    return;
                }
                return;
            case 15:
                if (obj instanceof Object[]) {
                    f(((Boolean) ((Object[]) obj)[0]).booleanValue());
                    return;
                }
                return;
            case 16:
                if (obj instanceof Boolean) {
                    i(((Boolean) obj).booleanValue());
                    return;
                }
                return;
            default:
                return;
        }
        o(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z16, UpgradeDetailWrapper upgradeDetailWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), upgradeDetailWrapper);
        }
    }
}
