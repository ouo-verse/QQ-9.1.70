package com.tencent.mobileqq.webview.util;

import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tenpay.sdk.Cgi;

/* compiled from: P */
/* loaded from: classes20.dex */
public class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f314886a;

    /* renamed from: b, reason: collision with root package name */
    public static String[] f314887b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49595);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314886a = new String[]{"game.qq.com", "mail.qq.com", "qzone.qq.com", FlockBaseRequest.QUN_DOMAIN, "openmobile.qq.com", Cgi.TENPAY_DOMAIN, "connect.qq.com", FlockBaseRequest.QUN_DOMAIN, "qqweb.qq.com", "office.qq.com", "ti.qq.com", "mma.qq.com", ITeamWorkHandler.DOCS_DOMAIN, "vip.qq.com", "gamecenter.qq.com"};
            f314887b = new String[]{"http://htdata.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080", "http://htdata2.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080"};
        }
    }
}
