package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ad extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ad(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        int i3;
        String str = this.f307441f.get("roomcode");
        String str2 = this.f307441f.get("fromid");
        String str3 = this.f307441f.get("isgroupcode");
        String str4 = this.f307441f.get("backtype");
        String str5 = this.f307441f.get(QCircleSchemeAttr.WebView.OPEN_TYPE);
        String str6 = this.f307441f.get("extra");
        com.tencent.mobileqq.intervideo.groupvideo.h hVar = (com.tencent.mobileqq.intervideo.groupvideo.h) this.f307436a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
        try {
            i3 = Integer.parseInt(str3);
        } catch (Exception unused) {
            i3 = 1;
        }
        QLog.i("GroupVideoAction", 1, "[goToGroupVideoPlugin], roomId:" + str + ",fromId:" + str2 + " isGroupCode:" + str3);
        hVar.e(this.f307437b, str, this.f307436a.getCurrentUin(), i3, "download", str2, str4, str5, str6);
        return true;
    }

    private boolean G() {
        com.tencent.mobileqq.intervideo.groupvideo.h hVar = (com.tencent.mobileqq.intervideo.groupvideo.h) this.f307436a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
        QLog.i("GroupVideoAction", 1, "[goToPreLoadGroupVideoPlugin]");
        hVar.c(null);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if ("openroom".equals(this.f307440e)) {
                return F();
            }
            if (!"preload".equals(this.f307440e)) {
                return false;
            }
            return G();
        } catch (Exception e16) {
            QLog.e("GroupVideoAction", 1, "doAction error: " + e16.getMessage());
            i("GroupVideoAction");
            return false;
        }
    }
}
