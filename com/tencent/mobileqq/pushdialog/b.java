package com.tencent.mobileqq.pushdialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f261336a;

    /* renamed from: b, reason: collision with root package name */
    private Context f261337b;

    /* renamed from: c, reason: collision with root package name */
    private SessionInfo f261338c;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f261339d;

    /* renamed from: e, reason: collision with root package name */
    private a61.c f261340e;

    public b(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private boolean a() {
        if (!this.f261336a.toLowerCase().startsWith("http://") && !this.f261336a.toLowerCase().startsWith("https://")) {
            return false;
        }
        return true;
    }

    private boolean b() {
        return this.f261336a.toLowerCase().startsWith("mqq://jubao.qq.com");
    }

    private boolean c() {
        return this.f261336a.toLowerCase().startsWith("mqq://");
    }

    private void f() {
        SessionInfo sessionInfo;
        if (this.f261337b != null && (sessionInfo = this.f261338c) != null && this.f261339d != null) {
            String str = sessionInfo.f179557e;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String j3 = NewReportPlugin.j(str, NewReportPlugin.p(2));
                if (QLog.isColorLevel()) {
                    QLog.i("HttpMqqJumper", 2, "openMoreOptions uin:" + str + " uinCode:" + j3);
                }
                QQMessageFacade messageFacade = this.f261339d.getMessageFacade();
                SessionInfo sessionInfo2 = this.f261338c;
                List<ChatMessage> n16 = messageFacade.n1(sessionInfo2.f179557e, sessionInfo2.f179555d, -1L, sessionInfo2.S, false);
                ArrayList arrayList = new ArrayList();
                if (n16 != null) {
                    arrayList.addAll(n16);
                }
                String s16 = NewReportPlugin.s(str, this.f261339d.getCurrentAccountUin(), 25004, 10, arrayList);
                String replaceAll = s16.replaceAll(str, j3);
                Bundle H = NewReportPlugin.H(this.f261338c);
                if (QLog.isColorLevel()) {
                    QLog.i("HttpMqqJumper", 2, "openMoreOptions safetyReport reportMsgOrg: " + s16 + "  reportMsg: " + replaceAll);
                }
                NewReportPlugin.S(this.f261340e.f25579d, str, j3, null, null, this.f261339d.getCurrentAccountUin(), 25004, replaceAll, H);
            } catch (Throwable th5) {
                QLog.e("HttpMqqJumper", 1, "openMoreOptions safetyReport error" + th5.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        ax c16;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f261337b != null && !TextUtils.isEmpty(this.f261336a)) {
            if (b()) {
                this.f261336a = this.f261336a.replace("mqq://", "https://");
                f();
            } else {
                if (a()) {
                    intent = new Intent(this.f261337b, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", this.f261336a);
                    if (intent == null) {
                        this.f261337b.startActivity(intent);
                        return;
                    }
                    return;
                }
                if (c()) {
                    QQAppInterface qQAppInterface = this.f261339d;
                    if (qQAppInterface != null && (c16 = bi.c(qQAppInterface, this.f261337b, this.f261336a)) != null) {
                        c16.z();
                        c16.b();
                        return;
                    }
                    return;
                }
            }
            intent = null;
            if (intent == null) {
            }
        }
    }

    public b e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.f261336a = str;
        return this;
    }

    public b(Context context, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) qQAppInterface);
        } else {
            this.f261337b = context;
            this.f261339d = qQAppInterface;
        }
    }
}
