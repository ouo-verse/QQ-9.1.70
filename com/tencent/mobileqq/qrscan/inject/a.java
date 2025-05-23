package com.tencent.mobileqq.qrscan.inject;

import com.tencent.biz.qrcode.processor.ArkQRProcessor;
import com.tencent.biz.qrcode.processor.CardQRProcessor;
import com.tencent.biz.qrcode.processor.HippyQRProcessor;
import com.tencent.biz.qrcode.processor.KuiklyCodeQRProcessor;
import com.tencent.biz.qrcode.processor.LoginQRProcessor;
import com.tencent.biz.qrcode.processor.MicroAppQRProcessor;
import com.tencent.biz.qrcode.processor.MiniAppQRProcessor;
import com.tencent.biz.qrcode.processor.MiniCodeQRProcessor;
import com.tencent.biz.qrcode.processor.MsgBackupQRProcessor;
import com.tencent.biz.qrcode.processor.PublicAccountQRProcessor;
import com.tencent.biz.qrcode.processor.QLinkQRProcessor;
import com.tencent.biz.qrcode.processor.QQIDQRProcessor;
import com.tencent.biz.qrcode.processor.QWalletNativePayQRProcessor;
import com.tencent.biz.qrcode.processor.QWalletQRProcessor;
import com.tencent.biz.qrcode.processor.QimQRProcessor;
import com.tencent.biz.qrcode.processor.UrlQRProcessor;
import com.tencent.biz.qrcode.processor.WxPayQRProcessor;
import com.tencent.mobileqq.flashtransfer.processor.FlashTransferProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qrcode.processor.O3QRProcessor;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.qrscan.f;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.robot.inject.RobotProfileQRProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QRScanImpl/Inject_QRScanProcessor.yml", version = 1)
    private static ArrayList<Class<? extends f>> f276641a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27612);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends f>> arrayList = new ArrayList<>();
        f276641a = arrayList;
        arrayList.add(O3QRProcessor.class);
        f276641a.add(MiniCodeQRProcessor.class);
        f276641a.add(ArkQRProcessor.class);
        f276641a.add(CardQRProcessor.class);
        f276641a.add(LoginQRProcessor.class);
        f276641a.add(MicroAppQRProcessor.class);
        f276641a.add(MiniAppQRProcessor.class);
        f276641a.add(MsgBackupQRProcessor.class);
        f276641a.add(PublicAccountQRProcessor.class);
        f276641a.add(QimQRProcessor.class);
        f276641a.add(QLinkQRProcessor.class);
        f276641a.add(QWalletQRProcessor.class);
        f276641a.add(QQIDQRProcessor.class);
        f276641a.add(HippyQRProcessor.class);
        f276641a.add(WxPayQRProcessor.class);
        f276641a.add(RobotProfileQRProcessor.class);
        f276641a.add(FlashTransferProcessor.class);
        f276641a.add(UrlQRProcessor.class);
        f276641a.add(KuiklyCodeQRProcessor.class);
        f276641a.add(QWalletNativePayQRProcessor.class);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public List<f> a(AppRuntime appRuntime, k kVar) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) kVar);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Class<? extends f>> it = f276641a.iterator();
        while (it.hasNext()) {
            Class<? extends f> next = it.next();
            if (QLog.isColorLevel()) {
                QLog.d("IQRScanConst_QRScanProcessorFactory", 2, "initBusinessProcessors| " + next.getName());
            }
            try {
                fVar = next.getConstructor(AppRuntime.class, k.class).newInstance(appRuntime, kVar);
            } catch (Exception e16) {
                QLog.d("IQRScanConst_QRScanProcessorFactory", 1, "initBusinessProcessors fail.", e16);
                fVar = null;
            }
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }
}
