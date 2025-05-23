package com.tencent.mobileqq.qwallet.impl.servlet;

import Wallet.AuthCodeReq;
import Wallet.AuthCodeRsp;
import Wallet.FocusMpIdReq;
import Wallet.FocusMpIdRsp;
import Wallet.GetMiniAppReq;
import Wallet.GetMiniAppRsp;
import Wallet.IsUinFocusMpIdReq;
import Wallet.IsUinFocusMpIdRsp;
import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailReq;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailRsp;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.ReportTypeReq;
import com.tencent.mobileqq.qqgamepub.data.ReportTypeRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Deprecated
/* loaded from: classes16.dex */
public class QWalletTempServlet extends MSFServlet {
    private Bundle a(Intent intent, FromServiceMsg fromServiceMsg, JceStruct jceStruct) {
        JceStruct jceStruct2;
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess() && (jceStruct2 = (JceStruct) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", jceStruct)) != null) {
            bundle.putSerializable("rsp", jceStruct2);
        }
        bundle.putSerializable("req", intent.getSerializableExtra("req"));
        return bundle;
    }

    public static void b(JceStruct jceStruct, BusinessObserver businessObserver) {
        int i3;
        try {
            if (jceStruct instanceof AuthCodeReq) {
                i3 = 22;
            } else if (jceStruct instanceof GetMiniAppReq) {
                i3 = 23;
            } else if (jceStruct instanceof IsUinFocusMpIdReq) {
                i3 = 24;
            } else if (jceStruct instanceof FocusMpIdReq) {
                i3 = 25;
            } else if (jceStruct instanceof GetArkTailReq) {
                i3 = 29;
            } else if (jceStruct instanceof ReportTypeReq) {
                i3 = 30;
            } else if (jceStruct instanceof GmpEnterInfoReq) {
                i3 = 31;
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                c(jceStruct, i3, businessObserver);
                QLog.d("QWalletCommonServlet", 2, "send " + jceStruct.toString());
                return;
            }
            QLog.w("QWalletCommonServlet", 2, "sendRequest find invalid req:" + jceStruct.toString());
        } catch (Throwable th5) {
            QLog.e("QWalletCommonServlet", 2, "sendRequest|" + th5.toString());
        }
    }

    private static void c(JceStruct jceStruct, int i3, BusinessObserver businessObserver) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), QWalletTempServlet.class);
        newIntent.putExtra("req", jceStruct);
        newIntent.putExtra("cmd_type", i3);
        newIntent.putExtra("callback_thread_type", 0);
        newIntent.setObserver(businessObserver);
        waitAppRuntime.startServlet(newIntent);
    }

    private static void d(Intent intent, Packet packet, String str, String str2, String str3) {
        try {
            packet.addRequestPacket("req", (JceStruct) intent.getSerializableExtra("req"));
            packet.setSSOCommand(str);
            packet.setFuncName(str2);
            packet.setServantName(str3);
        } catch (OutOfMemoryError e16) {
            QLog.w("QWalletCommonServlet", 2, "OOM occur: " + str, e16);
        }
    }

    @Override // mqq.app.Servlet
    public void notifyObserver(Intent intent, final int i3, final boolean z16, final Bundle bundle, Class<? extends BusinessObserver> cls) {
        final BusinessObserver observer;
        if (intent.getIntExtra("callback_thread_type", 0) == 0) {
            super.notifyObserver(intent, i3, z16, bundle, cls);
        } else if ((intent instanceof NewIntent) && (observer = ((NewIntent) intent).getObserver()) != null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.impl.servlet.QWalletTempServlet.1
                @Override // java.lang.Runnable
                public void run() {
                    observer.onReceive(i3, z16, bundle);
                }
            }, 5, null, true);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
    
        if (r1.equals("VacThirdCodeSvc.fetchCodes") == false) goto L8;
     */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        JceStruct getArkTailRsp;
        int i3;
        char c16 = 2;
        if (fromServiceMsg != null && intent != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            serviceCmd.hashCode();
            switch (serviceCmd.hashCode()) {
                case -1353296110:
                    if (serviceCmd.equals("GameCenterWebSvc.13571")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1353296109:
                    if (serviceCmd.equals("GameCenterWebSvc.13572")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1022787370:
                    break;
                case -312489443:
                    if (serviceCmd.equals("MiniAppSvc.focus_mpid")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 403339687:
                    if (serviceCmd.equals("MiniAppSvc.is_uin_focus_mpid")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1387831843:
                    if (serviceCmd.equals("GameMpSvc.EnterInfo")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1767655450:
                    if (serviceCmd.equals("MiniAppSvc.get_mini_app")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    getArkTailRsp = new GetArkTailRsp();
                    i3 = 29;
                    break;
                case 1:
                    getArkTailRsp = new ReportTypeRsp();
                    i3 = 30;
                    break;
                case 2:
                    getArkTailRsp = new AuthCodeRsp();
                    i3 = 22;
                    break;
                case 3:
                    getArkTailRsp = new FocusMpIdRsp();
                    i3 = 25;
                    break;
                case 4:
                    getArkTailRsp = new IsUinFocusMpIdRsp();
                    i3 = 24;
                    break;
                case 5:
                    getArkTailRsp = new GmpEnterInfoRsp();
                    i3 = 31;
                    break;
                case 6:
                    getArkTailRsp = new GetMiniAppRsp();
                    i3 = 23;
                    break;
                default:
                    return;
            }
            notifyObserver(intent, i3, fromServiceMsg.isSuccess(), a(intent, fromServiceMsg, getArkTailRsp), null);
            return;
        }
        QLog.i("QWalletCommonServlet", 2, "onReceive request or response is null");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        switch (intent.getExtras().getInt("cmd_type")) {
            case 22:
                d(intent, packet, "VacThirdCodeSvc.fetchCodes", "fetchCodes", "VAC.AuthCodeCoroServer.AuthCodeCoroObj");
                return;
            case 23:
                d(intent, packet, "MiniAppSvc.get_mini_app", "get_mini_app", "Wallet.MiniAppServer.MiniAppObj");
                return;
            case 24:
                d(intent, packet, "MiniAppSvc.is_uin_focus_mpid", "is_uin_focus_mpid", "Wallet.MiniAppServer.MiniAppObj");
                return;
            case 25:
                d(intent, packet, "MiniAppSvc.focus_mpid", "focus_mpid", "Wallet.MiniAppServer.MiniAppObj");
                return;
            case 26:
            case 27:
            case 28:
            default:
                return;
            case 29:
                d(intent, packet, "GameCenterWebSvc.13571", "GetArkTail", "GameCenter.GameContentAdaptServer.GameContentAdaptObj");
                return;
            case 30:
                d(intent, packet, "GameCenterWebSvc.13572", "ReportType", "GameCenter.GameContentAdaptServer.GameContentAdaptObj");
                return;
            case 31:
                d(intent, packet, "GameMpSvc.EnterInfo", "EnterInfo", "GameCenter.GameMpoperServer.GameMpoperObj");
                return;
        }
    }
}
