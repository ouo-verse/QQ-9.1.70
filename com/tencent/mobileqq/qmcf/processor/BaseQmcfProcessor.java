package com.tencent.mobileqq.qmcf.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.mobileqq.qmcf.QmcfReporter;
import com.tencent.sveffects.SLog;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class BaseQmcfProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final String INIT_ERROR = "InitError";
    public static final String LINK_ERROR = "UnsatisfiedLinkError";
    public static final String RES_ERROR = "ResError";
    public static final String SUCCESS = "success";
    protected static volatile Object mNativeLock;
    protected static QMCF qmcfLinker;
    protected static QmcfManager qmcfManager;
    protected String TAG;
    private int inputHeight;
    private int inputWidth;
    private long processCost;
    private String processResult;
    private boolean processorDestroyed;
    private long startPorcessTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13411);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        mNativeLock = new Object();
        qmcfLinker = new QMCF();
        qmcfManager = QmcfManager.getInstance();
    }

    public BaseQmcfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "BaseQmcfProcessor";
        this.processorDestroyed = true;
        this.processResult = "";
        this.startPorcessTime = 0L;
        this.processCost = 0L;
    }

    public String doDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        this.processorDestroyed = true;
        return modelDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doInit() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!this.processorDestroyed) {
            QmcfManager qmcfManager2 = qmcfManager;
            if (!qmcfManager2.modeChanged) {
                if (qmcfManager2.modelSwitched) {
                    qmcfManager2.modelSwitched = false;
                    QmcfModelItem qmcfModelItem = qmcfManager2.getQmcfModelItem();
                    if (qmcfModelItem != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean modelSwitch = modelSwitch(qmcfModelItem);
                        if (SLog.isEnable()) {
                            SLog.d(this.TAG, String.format("switchModel result[%s], cost[%s]", Boolean.valueOf(modelSwitch), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                            return;
                        }
                        return;
                    }
                    SLog.i(this.TAG, "error occur while switchModel!");
                    return;
                }
                return;
            }
        }
        if (SLog.isEnable()) {
            SLog.d(this.TAG, String.format("initProcessor processorDestroyed[%s], modeChanged[%s]", Boolean.valueOf(this.processorDestroyed), Boolean.valueOf(qmcfManager.modeChanged)));
        }
        int currQmcfMode = qmcfManager.getCurrQmcfMode();
        int currFrameType = qmcfManager.getCurrFrameType();
        if (QmcfManager.getInstance().hasQmcfEntrance(currQmcfMode, true)) {
            long j3 = -1;
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                qmcfManager.checkPathValid();
                qmcfManager.setQmcfRunSupported(false, true, currQmcfMode);
                QmcfModelItem qmcfModelItem2 = qmcfManager.getQmcfModelItem();
                if (qmcfModelItem2 == null) {
                    str = "NotNativeError";
                } else {
                    str = modelInit(qmcfModelItem2);
                }
                j3 = System.currentTimeMillis() - currentTimeMillis2;
                SLog.d(this.TAG, String.format("initProcessor, result[%s], cost[%s], width[%s], heigth[%s], mode[%s], type[%s]", str, Long.valueOf(j3), Integer.valueOf(getInputWidth()), Integer.valueOf(getInputHeight()), Integer.valueOf(currQmcfMode), Integer.valueOf(currFrameType)));
            } catch (Error e16) {
                SLog.e(this.TAG, "initProcessor error", e16);
                str = "NotNativeError";
                if ("success".equals(str)) {
                }
                this.processorDestroyed = false;
                QmcfManager qmcfManager3 = qmcfManager;
                qmcfManager3.modeChanged = false;
                qmcfManager3.modelSwitched = false;
            } catch (Exception e17) {
                SLog.e(this.TAG, "initProcessor excep", e17);
                str = "NotNativeError";
                if ("success".equals(str)) {
                }
                this.processorDestroyed = false;
                QmcfManager qmcfManager32 = qmcfManager;
                qmcfManager32.modeChanged = false;
                qmcfManager32.modelSwitched = false;
            }
            if ("success".equals(str)) {
                qmcfManager.setQmcfRunSupported(true, true, currQmcfMode);
                qmcfManager.setQmcfInitSuccess(true);
                if (j3 > 3000) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(QmcfReporter.SVAF_PARAM_COST, String.valueOf(j3));
                    hashMap.put(QmcfReporter.SVAF_PARAM_QMCF_MODE, String.valueOf(currQmcfMode));
                    QmcfReporter.report(QmcfReporter.SVAF_EVENT_INIT_COST3S, hashMap, true);
                }
            } else {
                if ("NotNativeError".equals(str)) {
                    QmcfManager.getInstance().setQmcfRunSupported(true, true, currQmcfMode);
                } else {
                    QmcfManager.getInstance().setQmcfInitSuccess(false);
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put(QmcfReporter.SVAF_PARAM_RESULT, String.valueOf(str));
                hashMap2.put(QmcfReporter.SVAF_PARAM_COST, String.valueOf(j3));
                hashMap2.put(QmcfReporter.SVAF_PARAM_QMCF_MODE, String.valueOf(currQmcfMode));
                QmcfReporter.report(QmcfReporter.SVAF_EVENT_INIT_ERROR, hashMap2, true);
                qmcfManager.setCurrQmcfMode(0);
            }
        }
        this.processorDestroyed = false;
        QmcfManager qmcfManager322 = qmcfManager;
        qmcfManager322.modeChanged = false;
        qmcfManager322.modelSwitched = false;
    }

    public String doProcess(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        this.startPorcessTime = System.currentTimeMillis();
        this.processResult = modelProcess(i3, i16);
        this.processCost = System.currentTimeMillis() - this.startPorcessTime;
        if (this.processResult.startsWith("suc")) {
            QmcfManager.getInstance().setQmcfProcessConsume(this.processCost);
        }
        return this.processResult;
    }

    public int getInputHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.inputHeight;
    }

    public int getInputWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.inputWidth;
    }

    protected String modelDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "success";
    }

    protected String modelInit(QmcfModelItem qmcfModelItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qmcfModelItem);
        }
        return "success";
    }

    protected String modelProcess(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return "success";
    }

    protected boolean modelSwitch(QmcfModelItem qmcfModelItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qmcfModelItem)).booleanValue();
        }
        return false;
    }

    public String replaceModelSize(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            return str.replaceFirst("\\d{2,4}\\s\\d{2,4}", String.format("%d %d", Integer.valueOf(i3), Integer.valueOf(i16)));
        } catch (Exception e16) {
            e16.printStackTrace();
            return str;
        }
    }

    public void setInputSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.inputWidth = i3;
            this.inputHeight = i16;
        }
    }
}
