package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REALTIMELOG.REALTIMELOG$StReportLogRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import java.util.ArrayList;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppRealTimeLogReportServlet extends MiniAppAbstractServlet {
    public static final String KEY_FILTER_MSG = "key_filter_msg";
    public static final String KEY_JSLIB_VERSION = "key_jslib_version";
    public static final String KEY_LOG_ITEMS = "key_log_items";
    public static final String KEY_PAGE = "key_page";
    public static final String TAG = "[mini] MiniAppRealTimeLogReportServlet";

    public MiniAppRealTimeLogReportServlet() {
        this.observerId = 1075;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        new REALTIMELOG$StReportLogRsp().mergeFrom(bArr);
        notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_page");
        String[] stringArrayExtra = intent.getStringArrayExtra(KEY_FILTER_MSG);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(KEY_LOG_ITEMS);
        String stringExtra2 = intent.getStringExtra(KEY_JSLIB_VERSION);
        String stringExtra3 = intent.getStringExtra("key_appid");
        byte[] encode = new RealTimeLogReportRequest(stringExtra, stringExtra2, stringExtra3, stringArrayExtra, parcelableArrayListExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(RealTimeLogReportRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        super.onSend(intent, packet);
    }
}
