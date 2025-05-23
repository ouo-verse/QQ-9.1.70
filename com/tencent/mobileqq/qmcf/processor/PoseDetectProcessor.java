package com.tencent.mobileqq.qmcf.processor;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.sveffects.SLog;

/* loaded from: classes16.dex */
public class PoseDetectProcessor extends BaseQmcfProcessor {
    static IPatchRedirector $redirector_;
    String ProcessorResult;
    protected String TAG;
    boolean couldRunSnpe;
    float[] keypoints;
    private long mNativeObj;
    final int numOfpoints;

    public PoseDetectProcessor(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.TAG = "PoseDetectProcessor";
        this.ProcessorResult = "";
        this.mNativeObj = 0L;
        this.numOfpoints = 18;
        this.keypoints = new float[109];
        this.couldRunSnpe = false;
        setInputSize(i3, i16);
    }

    public float[] getKeyPoints() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (float[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        synchronized (BaseQmcfProcessor.mNativeLock) {
            if (this.couldRunSnpe) {
                BaseQmcfProcessor.qmcfLinker.snpeSkeletonPose(this.keypoints);
            } else {
                BaseQmcfProcessor.qmcfLinker.getSkeletonPose(this.mNativeObj, this.keypoints);
            }
        }
        return this.keypoints;
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
                    BaseQmcfProcessor.qmcfLinker.PoseDestroy(this.mNativeObj);
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
        if (qmcfModelItem == null) {
            this.ProcessorResult = "init model is null";
        } else {
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
                    if (this.couldRunSnpe) {
                        this.ProcessorResult = BaseQmcfProcessor.qmcfLinker.snpePoseInit(getInputHeight(), getInputWidth(), BaseQmcfProcessor.qmcfManager.CommonPrefixPath, qmcfModelItem.modelDlcPath, 18, qmcfModelItem.modelEncrypt);
                        SLog.i("poseInfo", "doInit result:" + this.ProcessorResult + " ,availableType:" + i3);
                    } else {
                        String replaceModelSize = replaceModelSize(qmcfModelItem.modelDeployString, getInputHeight(), getInputWidth());
                        if (this.mNativeObj != 0) {
                            modelDestroy();
                        }
                        long PoseInit = BaseQmcfProcessor.qmcfLinker.PoseInit(QmcfManager.getInstance().getRunType(), getInputHeight(), getInputWidth(), getInputHeight(), getInputWidth(), 18, replaceModelSize, qmcfModelItem.modelParamPath, BaseQmcfProcessor.qmcfManager.CommonPrefixPath);
                        this.mNativeObj = PoseInit;
                        if (PoseInit != 0) {
                            this.ProcessorResult = "success";
                        } else {
                            this.ProcessorResult = BaseQmcfProcessor.INIT_ERROR;
                        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            synchronized (BaseQmcfProcessor.mNativeLock) {
                if (this.couldRunSnpe) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.ProcessorResult = BaseQmcfProcessor.qmcfLinker.snpePoseProcess(i3, i16);
                    Log.d("poseInfo", "doProcess cost:" + (System.currentTimeMillis() - currentTimeMillis));
                } else {
                    long j3 = this.mNativeObj;
                    if (j3 != 0) {
                        this.ProcessorResult = BaseQmcfProcessor.qmcfLinker.PoseProcess(j3, i3, i16);
                    }
                }
            }
        } catch (UnsatisfiedLinkError unused) {
            this.ProcessorResult = BaseQmcfProcessor.LINK_ERROR;
        }
        return this.ProcessorResult;
    }
}
