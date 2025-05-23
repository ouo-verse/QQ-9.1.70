package com.tencent.mobileqq.mutualmark.mqqapi;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends ax {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    private void F() {
        IntimateInfoHandler intimateInfoHandler = (IntimateInfoHandler) this.f307436a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
        if (intimateInfoHandler == null) {
            QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail, IntimateInfoHandler is null");
            return;
        }
        String str = this.f307441f.get("uin");
        String str2 = this.f307441f.get("id");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                intimateInfoHandler.S2(Long.parseLong(str), Long.parseLong(str2));
                return;
            } catch (NumberFormatException e16) {
                QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail", e16);
                return;
            }
        }
        QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail, params empty");
    }

    private void G() {
        IntimateInfoHandler intimateInfoHandler = (IntimateInfoHandler) this.f307436a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
        if (intimateInfoHandler == null) {
            QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail, IntimateInfoHandler is null");
            return;
        }
        String str = this.f307441f.get("uin");
        String str2 = this.f307441f.get("id");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                intimateInfoHandler.V2(Long.parseLong(str), Long.parseLong(str2), false);
                return;
            } catch (NumberFormatException e16) {
                QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail", e16);
                return;
            }
        }
        QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail, params empty");
    }

    private void H() {
        IntimateInfoHandler intimateInfoHandler = (IntimateInfoHandler) this.f307436a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
        if (intimateInfoHandler == null) {
            QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail, IntimateInfoHandler is null");
            return;
        }
        String str = this.f307441f.get("uin");
        String str2 = this.f307441f.get("id");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                intimateInfoHandler.V2(Long.parseLong(str), Long.parseLong(str2), true);
                return;
            } catch (NumberFormatException e16) {
                QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail", e16);
                return;
            }
        }
        QLog.e("MutualMarkOpenPageAction", 1, "wearMutualMark fail, params empty");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f A[Catch: Exception -> 0x0083, TRY_LEAVE, TryCatch #0 {Exception -> 0x0083, blocks: (B:10:0x0038, B:23:0x0077, B:24:0x007b, B:25:0x007f, B:26:0x004e, B:29:0x0059, B:32:0x0064), top: B:9:0x0038 }] */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.d("MutualMarkOpenPageAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        try {
            String str = this.f307440e;
            int hashCode = str.hashCode();
            if (hashCode != -840124008) {
                if (hashCode != 3446681) {
                    if (hashCode == 3645311 && str.equals("wear")) {
                        c16 = 0;
                        if (c16 == 0) {
                            if (c16 != 1) {
                                if (c16 == 2) {
                                    F();
                                }
                            } else {
                                G();
                            }
                        } else {
                            H();
                        }
                        return true;
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                    return true;
                }
                if (str.equals("poke")) {
                    c16 = 2;
                    if (c16 == 0) {
                    }
                    return true;
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
                return true;
            }
            if (str.equals("unwear")) {
                c16 = 1;
                if (c16 == 0) {
                }
                return true;
            }
            c16 = '\uffff';
            if (c16 == 0) {
            }
            return true;
        } catch (Exception e16) {
            QLog.e("MutualMarkOpenPageAction", 1, "doAction error: " + e16.getMessage());
            i("MutualMarkOpenPageAction");
            return false;
        }
    }
}
