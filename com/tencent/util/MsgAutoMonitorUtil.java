package com.tencent.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MsgAutoMonitorUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String ADD_MSG_NUM_KEY = "MSG_AddMsgNum";
    public static final String ADD_MSG_TIME_KEY = "MSG_AddMsgTime";
    public static final String DB_IO_NUM_KEY = "MSG_DbIoNum";
    public static final String DB_IO_TIME_KEY = "MSG_DbIoTime";
    public static final String DB_IO_TRANSACTION_KEY = "MSG_DbIoTransaction";
    public static final String DB_TABLE_NUM_KEY = "MSG_DbTableNum";
    public static final String MSG_DECODE_C2C_NUM_KEY = "MSG_DecodeC2CMsgNum";
    public static final String MSG_DECODE_C2C_TIME_KEY = "MSG_DecodeC2CMsgTime";
    public static final String MSG_DECODE_GRPDIS_NUM_KEY = "MSG_DecodeGrpDisMsgNum";
    public static final String MSG_DECODE_GRPDIS_TIME_KEY = "MSG_DecodeGrpDisMsgTime";
    public static final String MSG_FILTER_NUM_KEY = "MSG_MsgFilterNum";
    public static final String MSG_FILTER_TIME_KEY = "MSG_MsgFilterTime";
    public static final String MSG_INIT_MSG_NUM = "MSG_InitMsgNum";
    public static final String MSG_INIT_TAG = "AutoMonitor";
    public static final String MSG_INIT_TIME_KEY = "MSG_InitCostTime";
    public static final String MSG_NOTIFY_FIN_C2C = "MSG_NOTIFY_FIN_C2C";
    public static final String MSG_NOTIFY_FIN_DIS = "MSG_NOTIFY_FIN_DIS";
    public static final String MSG_NOTIFY_FIN_GRP = "MSG_NOTIFY_FIN_GRP";
    public static final String MSG_OBSERVER_NOTIFY_NUM = "MSG_ObserverNotifyNum";
    public static final String MSG_OBSERVER_TIME_KEY = "MSG_ObserverTime";
    public static final String MSG_PROXY_INIT_TIME_KEY = "MSG_ProxyInitTime";
    public static final String MSG_PROXY_SEQ_DIS = "MSG_PROXY_SEQ_DIS_T";
    public static final String MSG_PROXY_SEQ_GRP = "MSG_PROXY_SEQ_GRP_T";
    public static final String MSG_PROXY_THREAD_NUM_BEGIN = "MSG_PROXY_THREAD_NUM_BEGIN";
    public static final String MSG_PROXY_THREAD_NUM_END = "MSG_PROXY_THREAD_NUM_END";
    public static final String MSG_TABLE_NUM_KEY = "MSG_TableNum";
    private static MsgAutoMonitorUtil util;
    private long addMsgNum;
    private long addMsgTime;
    private long dbIoNum;
    private long dbIoTime;
    private long dbIoTransaction;
    private long decodeC2CNum;
    private long decodeC2CTime;
    private long decodeGrpDisNum;
    private long decodeGrpDisTime;
    private long msgFilterNum;
    private long msgFilterTime;
    private int msgObserverNotifyNum;
    private long msgObserverTime;
    private long msgProxyThreadNumBegin;
    private long msgProxyThreadNumEnd;
    private long notifyMsgFinishTimeC2C;
    private long notifyMsgFinishTimeC2CS;
    private long notifyMsgFinishTimeDisS;
    private long notifyMsgFinishTimeGrp;
    private long notifyMsgFinishTimeGrpS;
    private long notufyMsgFinishTimeDis;
    private long proxySeqTimeDis;
    private long proxySeqTimeGrp;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            util = null;
        }
    }

    MsgAutoMonitorUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.dbIoTime = 0L;
        this.dbIoNum = 0L;
        this.dbIoTransaction = 0L;
        this.msgObserverTime = 0L;
        this.msgObserverNotifyNum = 0;
        this.decodeC2CTime = 0L;
        this.decodeC2CNum = 0L;
        this.decodeGrpDisTime = 0L;
        this.decodeGrpDisNum = 0L;
        this.addMsgTime = 0L;
        this.addMsgNum = 0L;
        this.msgFilterTime = 0L;
        this.msgFilterNum = 0L;
        this.proxySeqTimeDis = 0L;
        this.proxySeqTimeGrp = 0L;
        this.notifyMsgFinishTimeC2C = 0L;
        this.notifyMsgFinishTimeC2CS = 0L;
        this.notifyMsgFinishTimeGrp = 0L;
        this.notifyMsgFinishTimeGrpS = 0L;
        this.notufyMsgFinishTimeDis = 0L;
        this.notifyMsgFinishTimeDisS = 0L;
        this.msgProxyThreadNumBegin = 0L;
        this.msgProxyThreadNumEnd = 0L;
    }

    public static MsgAutoMonitorUtil getInstance() {
        if (util == null) {
            util = new MsgAutoMonitorUtil();
        }
        return util;
    }

    public void addAddMsgTime(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.addMsgTime += j3;
            this.addMsgNum += j16;
        }
    }

    public void addDbIoTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.dbIoTime += j3;
            this.dbIoNum++;
        }
    }

    public void addDbIoTransaction(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.dbIoTransaction += j3;
        }
    }

    public void addDecodeC2CMsgTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.decodeC2CTime += j3;
            this.decodeC2CNum++;
        }
    }

    public void addDecodeGrpDisMsgTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
        } else {
            this.decodeGrpDisTime += j3;
            this.decodeGrpDisNum++;
        }
    }

    public void addMsgFilterTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.msgFilterTime += j3;
            this.msgFilterNum++;
        }
    }

    public void addMsgObserverNotifyNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.msgObserverNotifyNum++;
        }
    }

    public void addMsgObserverTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.msgObserverTime += j3;
        }
    }

    public void addProxySeqTime_Dis(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.proxySeqTimeDis += j3;
        }
    }

    public void addProxySeqTime_Grp(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.proxySeqTimeGrp += j3;
        }
    }

    public void markC2CFinishCost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.notifyMsgFinishTimeC2C = System.currentTimeMillis() - this.notifyMsgFinishTimeC2CS;
        }
    }

    public void markC2CFinishTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.notifyMsgFinishTimeC2CS = System.currentTimeMillis();
        }
    }

    public void markDisFinishCost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.notufyMsgFinishTimeDis = System.currentTimeMillis() - this.notifyMsgFinishTimeDisS;
        }
    }

    public void markDisFinishTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.notifyMsgFinishTimeDisS = System.currentTimeMillis();
        }
    }

    public void markGrpFinishCost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.notifyMsgFinishTimeGrp = System.currentTimeMillis() - this.notifyMsgFinishTimeGrpS;
        }
    }

    public void markGrpFinishTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.notifyMsgFinishTimeGrpS = System.currentTimeMillis();
        }
    }

    public void markMsgProxyThreadNumBegin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.msgProxyThreadNumBegin = i3;
        }
    }

    public void markMsgProxyThreadNumEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.msgProxyThreadNumEnd = i3;
        }
    }

    public void printDbAutoMonitorValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        printKeyAndValue(DB_IO_TIME_KEY, this.dbIoTime + "");
        this.dbIoTime = 0L;
        printKeyAndValue(DB_IO_NUM_KEY, this.dbIoNum + "");
        this.dbIoNum = 0L;
        printKeyAndValue(DB_IO_TRANSACTION_KEY, this.dbIoTransaction + "");
        this.dbIoTransaction = 0L;
    }

    public void printKeyAndValue(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AutoMonitor", 2, str + ", cost=" + str2);
            return;
        }
        Log.i("AutoMonitor", str + ", cost=" + str2);
    }

    public void printMsgInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        printKeyAndValue(MSG_DECODE_C2C_NUM_KEY, String.valueOf(this.decodeC2CNum));
        printKeyAndValue(MSG_DECODE_C2C_TIME_KEY, String.valueOf(this.decodeC2CTime));
        printKeyAndValue(MSG_DECODE_GRPDIS_NUM_KEY, String.valueOf(this.decodeGrpDisNum));
        printKeyAndValue(MSG_DECODE_GRPDIS_TIME_KEY, String.valueOf(this.decodeGrpDisTime));
        printKeyAndValue(ADD_MSG_NUM_KEY, String.valueOf(this.addMsgNum));
        printKeyAndValue(ADD_MSG_TIME_KEY, String.valueOf(this.addMsgTime));
        printKeyAndValue(MSG_FILTER_NUM_KEY, String.valueOf(this.msgFilterNum));
        printKeyAndValue(MSG_FILTER_TIME_KEY, String.valueOf(this.msgFilterTime));
        printKeyAndValue(MSG_PROXY_SEQ_DIS, String.valueOf(this.proxySeqTimeDis));
        printKeyAndValue(MSG_PROXY_SEQ_GRP, String.valueOf(this.proxySeqTimeGrp));
        printDbAutoMonitorValue();
        printMsgObserverAutoMonitorValue();
        printKeyAndValue(MSG_NOTIFY_FIN_C2C, String.valueOf(this.notifyMsgFinishTimeC2C));
        printKeyAndValue(MSG_NOTIFY_FIN_GRP, String.valueOf(this.notifyMsgFinishTimeGrp));
        printKeyAndValue(MSG_NOTIFY_FIN_DIS, String.valueOf(this.notufyMsgFinishTimeDis));
        printKeyAndValue(MSG_PROXY_THREAD_NUM_BEGIN, String.valueOf(this.msgProxyThreadNumBegin));
        printKeyAndValue(MSG_PROXY_THREAD_NUM_END, String.valueOf(this.msgProxyThreadNumEnd));
    }

    public void printMsgObserverAutoMonitorValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        printKeyAndValue(MSG_OBSERVER_TIME_KEY, this.msgObserverTime + "");
        printKeyAndValue(MSG_OBSERVER_NOTIFY_NUM, this.msgObserverNotifyNum + "");
        this.msgObserverTime = 0L;
        this.msgObserverNotifyNum = 0;
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            util = null;
        }
    }
}
