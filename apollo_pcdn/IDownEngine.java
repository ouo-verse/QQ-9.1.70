package apollo_pcdn;

import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes.dex */
public class IDownEngine {
    protected transient boolean pcdnCMemOwn;
    private transient long pcdnCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public IDownEngine(long j3, boolean z16) {
        this.pcdnCMemOwn = z16;
        this.pcdnCPtr = j3;
    }

    public static long getCPtr(IDownEngine iDownEngine) {
        if (iDownEngine == null) {
            return 0L;
        }
        return iDownEngine.pcdnCPtr;
    }

    public float GetCurrentP2PSharingRatio() {
        return apollo_pcdnJNI.IDownEngine_GetCurrentP2PSharingRatio(this.pcdnCPtr, this);
    }

    public float GetCurrentPCDNSharingRatio() {
        return apollo_pcdnJNI.IDownEngine_GetCurrentPCDNSharingRatio(this.pcdnCPtr, this);
    }

    public double GetCurrentSpeed() {
        return apollo_pcdnJNI.IDownEngine_GetCurrentSpeed(this.pcdnCPtr, this);
    }

    public String GetErrContent(long j3) {
        return apollo_pcdnJNI.IDownEngine_GetErrContent(this.pcdnCPtr, this, j3);
    }

    public long GetInterfaceLastError() {
        return apollo_pcdnJNI.IDownEngine_GetInterfaceLastError(this.pcdnCPtr, this);
    }

    public BigInteger GetTransferBytes() {
        return apollo_pcdnJNI.IDownEngine_GetTransferBytes__PCDN_1(this.pcdnCPtr, this);
    }

    public boolean InitDownEngine(DownEngineConfig downEngineConfig) {
        return apollo_pcdnJNI.IDownEngine_InitDownEngine(this.pcdnCPtr, this, DownEngineConfig.getCPtr(downEngineConfig), downEngineConfig);
    }

    public boolean Pause() {
        return apollo_pcdnJNI.IDownEngine_Pause(this.pcdnCPtr, this);
    }

    public boolean Resume() {
        return apollo_pcdnJNI.IDownEngine_Resume(this.pcdnCPtr, this);
    }

    public void SetBackGroundSwitch(boolean z16) {
        apollo_pcdnJNI.IDownEngine_SetBackGroundSwitch(this.pcdnCPtr, this, z16);
    }

    public void SetEnableP2P(boolean z16) {
        apollo_pcdnJNI.IDownEngine_SetEnableP2P(this.pcdnCPtr, this, z16);
    }

    public boolean SetOption(DownEngineOption downEngineOption, String str) {
        return apollo_pcdnJNI.IDownEngine_SetOption__PCDN_1(this.pcdnCPtr, this, downEngineOption.pcdnValue(), str);
    }

    public void SetUniDevId(String str) {
        apollo_pcdnJNI.IDownEngine_SetUniDevId(this.pcdnCPtr, this, str);
    }

    public boolean SetupCallBack(CallbackFuncPtrs callbackFuncPtrs) {
        return apollo_pcdnJNI.IDownEngine_SetupCallBack(this.pcdnCPtr, this, CallbackFuncPtrs.getCPtr(callbackFuncPtrs), callbackFuncPtrs);
    }

    public long StartTask(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        return apollo_pcdnJNI.IDownEngine_StartTask__PCDN_0(this.pcdnCPtr, this, str, bigInteger, bigInteger2);
    }

    public boolean StopAllTasks() {
        return apollo_pcdnJNI.IDownEngine_StopAllTasks(this.pcdnCPtr, this);
    }

    public boolean StopTask(long j3) {
        return apollo_pcdnJNI.IDownEngine_StopTask(this.pcdnCPtr, this, j3);
    }

    public boolean UnitDownEngine() {
        return apollo_pcdnJNI.IDownEngine_UnitDownEngine(this.pcdnCPtr, this);
    }

    public synchronized void delete() {
        long j3 = this.pcdnCPtr;
        if (j3 != 0) {
            if (this.pcdnCMemOwn) {
                this.pcdnCMemOwn = false;
                apollo_pcdnJNI.delete_IDownEngine(j3);
            }
            this.pcdnCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    public BigInteger GetTransferBytes(long j3) {
        return apollo_pcdnJNI.IDownEngine_GetTransferBytes__PCDN_0(this.pcdnCPtr, this, j3);
    }

    public boolean SetOption(DownEngineOption downEngineOption, BigInteger bigInteger) {
        return apollo_pcdnJNI.IDownEngine_SetOption__PCDN_0(this.pcdnCPtr, this, downEngineOption.pcdnValue(), bigInteger);
    }
}
