package com.tencent.mobileqq.qmcf.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.sveffects.SLog;

/* loaded from: classes16.dex */
public class ArtFilterProcessor extends BaseQmcfProcessor {
    static IPatchRedirector $redirector_;
    String ProcessorResult;
    protected String TAG;
    private long mNativeObj;

    public ArtFilterProcessor(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.TAG = "ArtFilterProcessor";
        this.ProcessorResult = "";
        this.mNativeObj = 0L;
        setInputSize(i3, i16);
    }

    @Override // com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
    protected String modelDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.mNativeObj == 0) {
            return this.ProcessorResult;
        }
        try {
            synchronized (BaseQmcfProcessor.mNativeLock) {
                BaseQmcfProcessor.qmcfLinker.ArtDestroy(this.mNativeObj);
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
        if (qmcfModelItem == null) {
            this.ProcessorResult = "init model is null";
        } else {
            try {
                synchronized (BaseQmcfProcessor.mNativeLock) {
                    long ArtInit = BaseQmcfProcessor.qmcfLinker.ArtInit(QmcfManager.getInstance().getRunType(), getInputWidth(), getInputHeight(), replaceModelSize(qmcfModelItem.modelDeployString, getInputWidth(), getInputHeight()), qmcfModelItem.modelParamPath, BaseQmcfProcessor.qmcfManager.CommonPrefixPath);
                    this.mNativeObj = ArtInit;
                    if (ArtInit != 0) {
                        this.ProcessorResult = "success";
                    } else {
                        this.ProcessorResult = BaseQmcfProcessor.INIT_ERROR;
                    }
                }
            } catch (UnsatisfiedLinkError unused) {
                this.ProcessorResult = BaseQmcfProcessor.LINK_ERROR;
            }
        }
        return this.ProcessorResult;
    }

    @Override // com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
    protected String modelProcess(int i3, int i16) {
        String ArtProcess;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        synchronized (BaseQmcfProcessor.mNativeLock) {
            ArtProcess = BaseQmcfProcessor.qmcfLinker.ArtProcess(this.mNativeObj, i3, i16);
            this.ProcessorResult = ArtProcess;
        }
        return ArtProcess;
    }

    @Override // com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
    protected boolean modelSwitch(QmcfModelItem qmcfModelItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qmcfModelItem)).booleanValue();
        }
        if (qmcfModelItem == null) {
            this.ProcessorResult = "switch model is null";
        } else {
            synchronized (BaseQmcfProcessor.mNativeLock) {
                this.ProcessorResult = BaseQmcfProcessor.qmcfLinker.ArtSwitchModel(this.mNativeObj, replaceModelSize(qmcfModelItem.modelDeployString, getInputWidth(), getInputHeight()), qmcfModelItem.modelParamPath, BaseQmcfProcessor.qmcfManager.CommonPrefixPath);
            }
        }
        boolean equals = "success".equals(this.ProcessorResult);
        if (!equals && SLog.isEnable()) {
            SLog.d(this.TAG, "modelSwitch error:" + this.ProcessorResult);
        }
        return equals;
    }
}
