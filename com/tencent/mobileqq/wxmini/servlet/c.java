package com.tencent.mobileqq.wxmini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c extends MSFServlet {

    /* renamed from: e, reason: collision with root package name */
    private String f327818e;

    /* renamed from: d, reason: collision with root package name */
    protected int f327817d = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f327819f = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTraceId() {
        String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        sb5.append(account);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        return sb5.toString();
    }

    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        throw null;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                    bundle.putLong("retCode", stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    bundle.putString("key_appid", String.valueOf(fromServiceMsg.getAppId()));
                    if (stQWebRsp.retCode.get() == 0) {
                        onProcessData(intent, bundle, stQWebRsp.busiBuff.get().toByteArray());
                        return;
                    }
                    notifyObserver(intent, this.f327817d, false, bundle, WxMiniAppObserver.class);
                    QLog.d(MiniAppAbstractServlet.TAG, 2, "onReceive. " + WxMiniAppObserver.b(this.f327817d) + " failed : retCode: " + stQWebRsp.retCode.get() + "  errMsg:" + stQWebRsp.errMsg.get().toStringUtf8());
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(MiniAppAbstractServlet.TAG, 2, "onReceive. " + WxMiniAppObserver.b(this.f327817d) + " failed: " + fromServiceMsg.getBusinessFailCode() + "  errMsg:" + fromServiceMsg.getBusinessFailMsg());
                }
                bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                notifyObserver(intent, this.f327817d, false, bundle, WxMiniAppObserver.class);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(MiniAppAbstractServlet.TAG, 2, "onReceive. inform  resultcode fail.");
            }
            notifyObserver(intent, this.f327817d, false, bundle, WxMiniAppObserver.class);
        } catch (Throwable th5) {
            QLog.e(MiniAppAbstractServlet.TAG, 1, th5 + "onReceive error");
            notifyObserver(intent, this.f327817d, false, bundle, WxMiniAppObserver.class);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        int f16 = MiniAppConfProcessor.f(QzoneConfig.SECONDARY_MINI_APP_MSF_TIMEOUT_VALUE, 10000);
        if (packet != null) {
            packet.setTimeout(f16);
            toServiceMsg = packet.toMsg();
        } else {
            toServiceMsg = null;
        }
        if (this.f327819f && toServiceMsg != null && intent != null) {
            this.f327818e = intent.getStringExtra("key_page");
            intent.putExtra("key_sso_cmd_start_time_millis", System.currentTimeMillis());
        }
        if (toServiceMsg != null) {
            QLog.i("miniapp-cmd", 1, "send request cmd=" + toServiceMsg.getServiceCmd() + " traceId=" + (intent != null ? intent.getStringExtra("traceid") : null));
        }
    }
}
