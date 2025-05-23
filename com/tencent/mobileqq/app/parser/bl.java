package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bl extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public bl(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:8|(14:33|34|35|11|(2:28|29)|13|14|15|16|17|18|19|20|21)|10|11|(0)|13|14|15|16|17|18|19|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
    
        r0.printStackTrace();
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
    
        r0.printStackTrace();
        r2 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean F() {
        String decode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String str = this.f307441f.get("roomid");
        String str2 = this.f307441f.get("fromid");
        String str3 = "";
        if (!TextUtils.isEmpty(this.f307441f.get("vasname"))) {
            try {
                decode = URLDecoder.decode(this.f307441f.get("vasname"), "utf-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            if (!TextUtils.isEmpty(this.f307441f.get("userdata"))) {
                try {
                    str3 = URLDecoder.decode(this.f307441f.get("vasname"), "utf-8");
                } catch (UnsupportedEncodingException e17) {
                    e17.printStackTrace();
                }
            }
            String str4 = str3;
            long j3 = Long.parseLong(str);
            long j16 = j3;
            int i3 = Integer.parseInt(str2);
            ((com.tencent.mobileqq.intervideo.od.d) this.f307436a.getManager(QQManagerFactory.ODPROXY_MGR)).b(this.f307437b, j16, "launcher", decode, str4, i3);
            return true;
        }
        decode = "";
        if (!TextUtils.isEmpty(this.f307441f.get("userdata"))) {
        }
        String str42 = str3;
        long j36 = Long.parseLong(str);
        long j162 = j36;
        int i36 = Integer.parseInt(str2);
        ((com.tencent.mobileqq.intervideo.od.d) this.f307436a.getManager(QQManagerFactory.ODPROXY_MGR)).b(this.f307437b, j162, "launcher", decode, str42, i36);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("OnlineDatingAction", 1, "doAction error: " + e16.getMessage());
            i("OnlineDatingAction");
            return false;
        }
    }
}
