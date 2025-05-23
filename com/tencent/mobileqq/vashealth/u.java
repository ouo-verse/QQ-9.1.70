package com.tencent.mobileqq.vashealth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class u extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        QLog.i("health_manager", 1, "MyServlet onReceive." + fromServiceMsg.getServiceCmd());
        if (fromServiceMsg.isSuccess() && fromServiceMsg.getServiceCmd().equals(StepCounterConstants.CMD_REFRESH_STEPS)) {
            Bundle bundle = new Bundle();
            HashMap<String, Object> attributes = fromServiceMsg.getAttributes();
            if (attributes.containsKey(StepCounterConstants.ATTR_STEP_COUNT_HISTORY)) {
                bundle.putSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY, (Serializable) attributes.get(StepCounterConstants.ATTR_STEP_COUNT_HISTORY));
            }
            if (attributes.containsKey(StepCounterConstants.ATTR_HAS_SHUTDOWN_FLAG)) {
                bundle.putBoolean(StepCounterConstants.ATTR_HAS_SHUTDOWN_FLAG, ((Boolean) attributes.get(StepCounterConstants.ATTR_HAS_SHUTDOWN_FLAG)).booleanValue());
            }
            if (attributes.containsKey(StepCounterConstants.ATTR_LAST_SENSOR_EVENT_TIME)) {
                bundle.putLong(StepCounterConstants.ATTR_LAST_SENSOR_EVENT_TIME, ((Long) attributes.get(StepCounterConstants.ATTR_LAST_SENSOR_EVENT_TIME)).longValue());
            }
            if (intent.getExtras().getString("json_getstepcallback") != null) {
                bundle.putString("json_getstepcallback", intent.getExtras().getString("json_getstepcallback"));
            }
            if (attributes.containsKey(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE)) {
                bundle.putBoolean(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE, ((Boolean) attributes.get(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE)).booleanValue());
            }
            String stringExtra = intent.getStringExtra("json_string");
            if (!TextUtils.isEmpty(stringExtra)) {
                bundle.putString("json_string", stringExtra);
            }
            notifyObserver(intent, 0, true, bundle, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        if (r7.equals(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.CMD_RESET_STEP) == false) goto L4;
     */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("msf_cmd_type");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, "0", stringExtra);
        toServiceMsg.setMsfCommand(MsfCommand.msf_step_counter);
        char c16 = 1;
        toServiceMsg.setNeedCallback(true);
        toServiceMsg.setTimeout(30000L);
        stringExtra.hashCode();
        switch (stringExtra.hashCode()) {
            case -1091551638:
                if (stringExtra.equals(StepCounterConstants.CMD_UPDATE_CONFIG)) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -991606815:
                break;
            case -764895618:
                if (stringExtra.equals(StepCounterConstants.CMD_REFRESH_STEPS)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 166945745:
                if (stringExtra.equals(StepCounterConstants.CMD_UPDATE_LAST_REPORT_TIME)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1588344882:
                if (stringExtra.equals(StepCounterConstants.CMD_HEALTH_SWITCH)) {
                    c16 = 4;
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
                g43.f fVar = (g43.f) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100506");
                toServiceMsg.addAttribute(StepCounterConstants.ATTR_STEP_COUNTER_MODE, Integer.valueOf(fVar.getCom.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.ATTR_STEP_COUNTER_MODE java.lang.String()));
                toServiceMsg.addAttribute(StepCounterConstants.ATTR_STEP_CADENCE, Integer.valueOf(fVar.getCom.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.ATTR_STEP_CADENCE java.lang.String()));
                toServiceMsg.addAttribute(StepCounterConstants.ATTR_ACTIVE_REPORT_INTERVAL, Integer.valueOf(fVar.getCom.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.ATTR_ACTIVE_REPORT_INTERVAL java.lang.String()));
                toServiceMsg.addAttribute(StepCounterConstants.ATTR_PASSIVE_REPORT_INTERVAL, Integer.valueOf(fVar.getPassiveReportInterval()));
                toServiceMsg.addAttribute(StepCounterConstants.ATTR_MAX_RECORD_DAYS, Integer.valueOf(fVar.getCom.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.ATTR_MAX_RECORD_DAYS java.lang.String()));
                toServiceMsg.setNeedCallback(false);
                break;
            case 1:
                int intExtra = intent.getIntExtra("server_step", -1);
                if (-1 != intExtra) {
                    toServiceMsg.addAttribute("server_step", Integer.valueOf(intExtra));
                    break;
                }
                break;
            case 2:
                toServiceMsg.addAttribute(StepCounterConstants.ATTR_IS_REPORT_STEP, Boolean.valueOf(intent.getBooleanExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, false)));
                break;
            case 3:
                Long valueOf = Long.valueOf(intent.getLongExtra("last_report_time", 0L));
                Boolean valueOf2 = Boolean.valueOf(intent.getBooleanExtra("has_report_yes", false));
                toServiceMsg.addAttribute("last_report_time", valueOf);
                toServiceMsg.addAttribute("has_report_yes", valueOf2);
                toServiceMsg.setNeedCallback(false);
                break;
            case 4:
                toServiceMsg.addAttribute(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, Boolean.valueOf(intent.getBooleanExtra(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, false)));
                break;
        }
        sendToMSF(intent, toServiceMsg);
    }
}
