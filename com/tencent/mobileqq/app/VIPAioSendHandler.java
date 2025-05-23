package com.tencent.mobileqq.app;

import VIP.AIOSendRes;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.graytips.api.IVasGrayTips;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip$FromChannel;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

/* loaded from: classes11.dex */
public class VIPAioSendHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f195180e;

    /* renamed from: f, reason: collision with root package name */
    public static String f195181f;

    /* renamed from: h, reason: collision with root package name */
    public static String f195182h;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195183d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70025);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f195180e = 1;
        f195181f = "AIOSendSvc.CheckPopGrayStips";
        f195182h = "AIOSendSvc.getUserKeyWordStips";
    }

    protected VIPAioSendHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195183d = qQAppInterface;
        }
    }

    public void D2(String str, int i3, String str2, boolean z16) {
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16));
            return;
        }
        int transformFrom = ((IVasGrayTips) QRoute.api(IVasGrayTips.class)).transformFrom(i3);
        UniGrayTip$FromChannel uniGrayTip$FromChannel = new UniGrayTip$FromChannel();
        uniGrayTip$FromChannel.channel.set(transformFrom);
        PBStringField pBStringField = uniGrayTip$FromChannel.fromUin;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        HashMap hashMap = new HashMap();
        hashMap.put("matchKey", str2);
        if (z16) {
            valueOf = String.valueOf(1);
        } else {
            valueOf = String.valueOf(0);
        }
        hashMap.put(QQBrowserActivity.KEY_MSG_TYPE, valueOf);
        ((IVasGrayTips) QRoute.api(IVasGrayTips.class)).requestUnitGrayTips(1, uniGrayTip$FromChannel, hashMap, null);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return dk.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            if (f195181f.equals(toServiceMsg.getServiceCmd())) {
                com.tencent.mobileqq.vip.a.a().c(this.f195183d, (AIOSendRes) obj);
            }
            notifyUI(f195180e, true, obj);
            return;
        }
        notifyUI(f195180e, false, null);
    }
}
