package com.tencent.mobileqq.graycheck.business;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.msf.service.protocol.kqqconfig.GrayUinCheckResp;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import mqq.app.Foreground;
import mqq.app.NewIntent;
import protocol.GrayVersion.ApplyResp;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes12.dex */
public class GrayCheckHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f213663d;

    protected GrayCheckHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f213663d = appInterface;
        }
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        if (businessFailCode != 1002 && businessFailCode != 1013) {
            if (businessFailCode == 1000) {
                if (!(obj instanceof ApplyResp)) {
                    QLog.d("GrayCheck.tag", 1, "role gray check fail, data is not instanceof ApplyResp");
                    return;
                }
                ApplyResp applyResp = (ApplyResp) obj;
                int i3 = applyResp.ret;
                if (i3 == 0) {
                    notifyUI(2001, true, applyResp);
                    return;
                } else if (i3 == -10) {
                    notifyUI(2003, false, applyResp);
                    return;
                } else {
                    notifyUI(2000, false, applyResp);
                    return;
                }
            }
            return;
        }
        notifyUI(2002, false, null);
    }

    private long convertUin(String str) {
        if (str != null && str.length() > 0) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong < 10000) {
                    return 0L;
                }
                return parseLong;
            } catch (NumberFormatException e16) {
                QLog.e("GrayCheck.tag", 1, "[convertUin] error, ", e16);
            }
        }
        return 0L;
    }

    public void F2(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getBusinessFailCode() == 1000) {
            GrayUinCheckResp grayUinCheckResp = (GrayUinCheckResp) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_GRAY_CHECK, null);
            if (grayUinCheckResp == null) {
                QLog.d("GrayCheck.tag", 1, "GrayUinCheckResp is null");
                return;
            } else if (grayUinCheckResp.status == 1) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(grayUinCheckResp, fromServiceMsg.getUin()) { // from class: com.tencent.mobileqq.graycheck.business.GrayCheckHandler.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ GrayUinCheckResp f213664d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f213665e;

                    {
                        this.f213664d = grayUinCheckResp;
                        this.f213665e = r9;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, GrayCheckHandler.this, grayUinCheckResp, r9);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        String str2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            str = new String(this.f213664d.err_msg, "UTF-8");
                        } catch (UnsupportedEncodingException unused) {
                            str = this.f213665e + " not in gray list";
                        }
                        if (this.f213664d.can_apply) {
                            str2 = NewIntent.ACTION_GRAY_APPLY;
                        } else {
                            str2 = NewIntent.ACTION_GRAY_EXPIRED;
                        }
                        Intent intent = new Intent(str2);
                        intent.putExtra("title", this.f213664d.is_yingyongbao);
                        intent.putExtra("msg", str);
                        try {
                            RouteUtils.startActivity(Foreground.getTopActivity(), intent, RouterConstants.UI_ROUTER_NOTIFICATION);
                        } catch (Exception e16) {
                            QLog.e("GrayCheck.tag", 1, "startActivity error, ", e16);
                            GrayCheckHandler.this.f213663d.exit(false);
                        }
                    }
                }, 2000L);
                return;
            } else {
                QLog.d("GrayCheck.tag", 1, "role gray check success");
                return;
            }
        }
        QLog.d("GrayCheck.tag", 1, "role gray check fail " + fromServiceMsg);
    }

    public void G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("VCService", this.f213663d.getCurrentAccountUin(), BaseConstants.CMD_GRAY_APPLY);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.extraData.putLong("uin", convertUin(this.f213663d.getCurrentAccountUin()));
        toServiceMsg.extraData.putLong("appid", this.f213663d.getAppid());
        send(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(BaseConstants.CMD_GRAY_APPLY);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public boolean msgCmdFilter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (this.allowCmdSet == null) {
            this.allowCmdSet = getCommandList();
        }
        Set<String> set = this.allowCmdSet;
        if (set != null && !set.contains(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("GrayCheck.tag", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        if (BaseConstants.CMD_GRAY_APPLY.equals(fromServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
