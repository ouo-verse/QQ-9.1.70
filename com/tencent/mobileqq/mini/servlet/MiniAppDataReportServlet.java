package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.utils.fh;
import mqq.app.AppRuntime;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppDataReportServlet extends MiniAppAbstractServlet {
    public static final String KEY_CMD = "key_cmd";
    public static final String TAG = "MiniAppDataReportServlet";

    public MiniAppDataReportServlet() {
        this.observerId = 1005;
    }

    private boolean notReport() {
        SpringFestivalEntryManager springFestivalEntryManager;
        BaseActivityData G;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof QQAppInterface) && (G = (springFestivalEntryManager = (SpringFestivalEntryManager) runtime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).G()) != null) {
            return G.type == 2 && springFestivalEntryManager.O(G.f289093id).leftCountDownDuration != 0;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        APP_REPORT_TRANSFER.StDataReportRsp stDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
        stDataReportRsp.mergeFrom(bArr);
        bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
        int i3 = stDataReportRsp.ret.get();
        if (i3 == 0) {
            notifyObserver(intent, 1005, true, bundle, MiniAppObserver.class);
        } else {
            bundle.putInt("ret", i3);
            notifyObserver(intent, 1005, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        setShouldPerformDCReport(false);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        byte[] encode = new DataReportRequest(byteArrayExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        if (notReport()) {
            return;
        }
        packet.setSSOCommand("LightAppSvc.mini_app_report_transfer.DataReport");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
