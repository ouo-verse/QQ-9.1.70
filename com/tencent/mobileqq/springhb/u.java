package com.tencent.mobileqq.springhb;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.spring_hb.ReportData$NYReportRsp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u extends MSFServlet {
    static IPatchRedirector $redirector_;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.Servlet
    public void notifyObserver(Intent intent, int i3, boolean z16, Bundle bundle, Class<? extends BusinessObserver> cls) {
        BusinessObserver observer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Boolean.valueOf(z16), bundle, cls);
        } else if ((intent instanceof NewIntent) && (observer = ((NewIntent) intent).getObserver()) != null) {
            observer.onReceive(i3, z16, bundle);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        bVar.f("Springhb_report.SpringHbReportServlet", false, "[onReceive] cmd=trpc.group_pro.redpacketreport.SsoReport.SsoReport,success=" + fromServiceMsg.isSuccess() + ", retCode=" + fromServiceMsg.getResultCode());
        com.tencent.mobileqq.springhb.debug.b bVar2 = com.tencent.mobileqq.springhb.debug.b.f289046a;
        if (bVar2.c()) {
            bVar.f("Springhb_report.SpringHbReportServlet", false, "[onReceive] needHook");
            Bundle bundle = new Bundle();
            ReportData$NYReportRsp d16 = bVar2.d();
            bundle.putInt(WadlProxyConsts.EXTRA_RESULT_CODE, fromServiceMsg.getResultCode());
            bundle.putByteArray("data", d16.toByteArray());
            if (intent != null) {
                bundle.putLong("report_cnt", intent.getLongExtra("report_cnt", 0L));
            }
            if (d16.ret.get() != 0 && d16.ret.get() != 110002) {
                z16 = false;
            } else {
                z16 = true;
            }
            notifyObserver(intent, 0, z16, bundle, null);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(WadlProxyConsts.EXTRA_RESULT_CODE, fromServiceMsg.getResultCode());
        bundle2.putByteArray("data", bArr);
        if (intent != null) {
            bundle2.putLong("report_cnt", intent.getLongExtra("report_cnt", 0L));
        }
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle2, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        long longExtra = intent.getLongExtra("timeout", 30000L);
        packet.setSSOCommand("trpc.group_pro.redpacketreport.SsoReport.SsoReport");
        packet.setTimeout(longExtra);
        if (com.tencent.mobileqq.springhb.debug.b.f289046a.c()) {
            packet.setTimeout(r5.h());
        }
        packet.putSendData(fh.b(byteArrayExtra));
    }
}
