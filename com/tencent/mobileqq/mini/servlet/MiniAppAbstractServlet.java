package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
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
/* loaded from: classes33.dex */
public class MiniAppAbstractServlet extends MSFServlet {
    public static final String EXTRA_TIMEOUT = "timeout";
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_APP_STORE_GET_APP_LIST_TYPE = "key_app_store_get_app_list_type";
    public static final String KEY_CMD_NAME = "key_cmd_name";
    public static final String KEY_CODE = "key_code";
    public static final String KEY_CODE_TYPE = "key_code_type";
    public static final String KEY_DATA = "key_data";
    public static final String KEY_LANG = "key_lang";
    public static final String KEY_LINK = "key_link";
    public static final String KEY_LINK_TYPE = "key_link_type";
    public static final String KEY_NUM = "key_num";
    public static final String KEY_PAGE = "key_page";
    public static final String KEY_REPORT_DATA = "reportData";
    private static final String KEY_SSO_CMD_START_TIME_MILLIS = "key_sso_cmd_start_time_millis";
    public static final String KEY_UIN = "key_uin";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VERSION = "key_version";
    public static final String KEY_WITH_CREDENTIAL = "key_with_credential";
    public static final String TAG = "MiniAppAbstractServlet";
    private MiniAppConfig miniAppConfig;
    private String page;
    protected int observerId = 0;
    private boolean shouldPerformDCReport = true;

    private void reportSSOResult(Intent intent, int i3, String str, int i16) {
        if (this.shouldPerformDCReport) {
            MiniReportManager.reportEventType(this.miniAppConfig, i3, this.page, intent != null ? intent.getStringExtra("traceid") : null, str, i16, MiniReportManager.getAppType(this.miniAppConfig), (intent == null || !intent.hasExtra(KEY_SSO_CMD_START_TIME_MILLIS)) ? 0L : System.currentTimeMillis() - intent.getLongExtra(KEY_SSO_CMD_START_TIME_MILLIS, System.currentTimeMillis()), null);
        }
    }

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
        if (this.shouldPerformDCReport && toServiceMsg != null && intent != null) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            String stringExtra = intent.getStringExtra("key_appid");
            this.page = intent.getStringExtra("key_page");
            intent.putExtra(KEY_SSO_CMD_START_TIME_MILLIS, System.currentTimeMillis());
            if (!TextUtils.isEmpty(stringExtra) && !"0000000000".equals(stringExtra)) {
                MiniAppInfo miniAppInfo = new MiniAppInfo();
                miniAppInfo.appId = stringExtra;
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                this.miniAppConfig = miniAppConfig;
                miniAppConfig.launchParam = new LaunchParam();
                this.miniAppConfig.launchParam.miniAppId = stringExtra;
            } else {
                this.miniAppConfig = MiniProgramReportHelper.miniAppConfigForPreload();
            }
            MiniReportManager.reportEventType(this.miniAppConfig, 600, this.page, null, serviceCmd, 0);
        }
        if (toServiceMsg != null) {
            QLog.i("miniapp-cmd", 1, "send request cmd=" + toServiceMsg.getServiceCmd() + " traceId=" + (intent != null ? intent.getStringExtra("traceid") : null));
        }
    }

    public void setShouldPerformDCReport(boolean z16) {
        this.shouldPerformDCReport = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doReport(Intent intent, FromServiceMsg fromServiceMsg) {
        reportSSOResult(intent, 601, fromServiceMsg != null ? fromServiceMsg.getServiceCmd() : null, fromServiceMsg != null ? fromServiceMsg.getResultCode() : 0);
        if (fromServiceMsg != null) {
            QLog.i("miniapp-cmd", 1, "receive response cmd=" + fromServiceMsg.getServiceCmd() + " resultCode=" + fromServiceMsg.getResultCode() + " traceId=" + (intent != null ? intent.getStringExtra("traceid") : null));
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        long j3;
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
                    long j16 = stQWebRsp.retCode.get();
                    if (j16 == 0) {
                        onProcessData(intent, bundle, stQWebRsp.busiBuff.get().toByteArray());
                        j3 = j16;
                    } else {
                        j3 = j16;
                        notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
                        QLog.d(TAG, 2, "onReceive. " + MiniAppObserver.getCmdByObserverId(this.observerId) + " failed : retCode: " + stQWebRsp.retCode.get() + "  errMsg:" + stQWebRsp.errMsg.get().toStringUtf8());
                    }
                    reportSSOResult(intent, 599, fromServiceMsg.getServiceCmd(), (int) j3);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onReceive. " + MiniAppObserver.getCmdByObserverId(this.observerId) + " failed: " + fromServiceMsg.getBusinessFailCode() + "  errMsg:" + fromServiceMsg.getBusinessFailMsg());
                    }
                    bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                    notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform  resultcode fail.");
                }
                notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + "onReceive error");
            notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
    }
}
