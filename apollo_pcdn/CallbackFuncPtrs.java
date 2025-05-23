package apollo_pcdn;

/* loaded from: classes.dex */
public class CallbackFuncPtrs {
    protected transient boolean pcdnCMemOwn;
    private transient long pcdnCPtr;

    public CallbackFuncPtrs() {
        this(apollo_pcdnJNI.new_CallbackFuncPtrs(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(CallbackFuncPtrs callbackFuncPtrs) {
        if (callbackFuncPtrs == null) {
            return 0L;
        }
        return callbackFuncPtrs.pcdnCPtr;
    }

    public int OnEngineUpdateAndGetNetStateCallback() {
        return ApolloNetworkState.kApolloReachableViaWiFi.pcdnValue();
    }

    public synchronized void delete() {
        long j3 = this.pcdnCPtr;
        if (j3 != 0) {
            if (this.pcdnCMemOwn) {
                this.pcdnCMemOwn = false;
                apollo_pcdnJNI.delete_CallbackFuncPtrs(j3);
            }
            this.pcdnCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    protected CallbackFuncPtrs(long j3, boolean z16) {
        this.pcdnCMemOwn = z16;
        this.pcdnCPtr = j3;
    }

    public void OnCompleteCallback(long j3) {
    }

    public void OnDestoryDownEngineCallback(String str) {
    }

    public void OnHeaderCallback(String str) {
    }

    public void OnErrorCallback(long j3, int i3) {
    }

    public void OnDataCallback(long j3, byte[] bArr, long j16, long j17) {
    }
}
