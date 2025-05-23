package com.tencent.mobileqq.qmcf.processor;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.sveffects.SLog;

/* loaded from: classes16.dex */
public class BigHeadProcessor extends BaseQmcfProcessor {
    static IPatchRedirector $redirector_;
    String ProcessorResult;
    protected String TAG;
    boolean couldRunSnpe;
    private long mNativeObj;
    private boolean runInSNPE;

    public BigHeadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "BigHeadProcessor";
        this.ProcessorResult = "";
        this.mNativeObj = 0L;
        this.runInSNPE = false;
        this.couldRunSnpe = false;
    }

    @Override // com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
    protected String modelDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mNativeObj == 0) {
            return this.ProcessorResult;
        }
        try {
            synchronized (BaseQmcfProcessor.mNativeLock) {
                if (this.couldRunSnpe) {
                    BaseQmcfProcessor.qmcfLinker.snpeBigHeadDestroy(this.mNativeObj);
                } else {
                    BaseQmcfProcessor.qmcfLinker.BigHeadDestroy(this.mNativeObj);
                }
            }
            this.mNativeObj = 0L;
            this.ProcessorResult = "success";
        } catch (UnsatisfiedLinkError unused) {
            this.ProcessorResult = BaseQmcfProcessor.LINK_ERROR;
        }
        return this.ProcessorResult;
    }

    @Override // com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
    protected String modelInit(QmcfModelItem qmcfModelItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qmcfModelItem);
        }
        try {
            synchronized (BaseQmcfProcessor.mNativeLock) {
                int i3 = 0;
                if (QmcfManager.hasSNPESo) {
                    int snpeAvaliableType = BaseQmcfProcessor.qmcfLinker.snpeAvaliableType();
                    if (snpeAvaliableType > 0) {
                        QmcfManager.getInstance().setCurrFrameType(1);
                        this.couldRunSnpe = true;
                    } else {
                        QmcfManager.getInstance().setCurrFrameType(3);
                        this.couldRunSnpe = false;
                    }
                    i3 = snpeAvaliableType;
                }
                boolean z16 = this.couldRunSnpe & this.runInSNPE;
                this.couldRunSnpe = z16;
                if (z16) {
                    this.mNativeObj = BaseQmcfProcessor.qmcfLinker.snpeBigHeadInit(getInputHeight(), getInputWidth(), qmcfModelItem.modelDlcPath, "", qmcfModelItem.modelEncrypt, BaseQmcfProcessor.qmcfManager.CommonPrefixPath);
                    Log.d("bigheadInfo", "doInit result:" + this.mNativeObj + " ,availableType:" + i3);
                } else {
                    this.mNativeObj = BaseQmcfProcessor.qmcfLinker.BigHeadInit(QmcfManager.getInstance().getRunType(), getInputHeight(), getInputWidth(), qmcfModelItem.modelDeployString, qmcfModelItem.modelParamPath, BaseQmcfProcessor.qmcfManager.CommonPrefixPath, false);
                }
            }
            if (this.mNativeObj != 0) {
                this.ProcessorResult = "success";
            } else {
                this.ProcessorResult = BaseQmcfProcessor.INIT_ERROR;
            }
        } catch (UnsatisfiedLinkError unused) {
            this.ProcessorResult = BaseQmcfProcessor.LINK_ERROR;
        }
        return this.ProcessorResult;
    }

    @Override // com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
    protected String modelProcess(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (BaseQmcfProcessor.mNativeLock) {
                if (this.couldRunSnpe) {
                    this.ProcessorResult = BaseQmcfProcessor.qmcfLinker.snpeBigHeadProcess(this.mNativeObj, i3, i16);
                } else {
                    long j3 = this.mNativeObj;
                    if (j3 != 0) {
                        this.ProcessorResult = BaseQmcfProcessor.qmcfLinker.BigHeadProcess(j3, i3, i16);
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (SLog.isEnable()) {
                SLog.d(this.TAG, "BigHead processGLShareSafe cost=" + (currentTimeMillis2 - currentTimeMillis));
            }
        } catch (UnsatisfiedLinkError unused) {
            this.ProcessorResult = BaseQmcfProcessor.LINK_ERROR;
        }
        return this.ProcessorResult;
    }
}
