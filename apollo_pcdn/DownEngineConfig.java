package apollo_pcdn;

import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes.dex */
public class DownEngineConfig {
    protected transient boolean pcdnCMemOwn;
    private transient long pcdnCPtr;

    public DownEngineConfig() {
        this(apollo_pcdnJNI.new_DownEngineConfig(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(DownEngineConfig downEngineConfig) {
        if (downEngineConfig == null) {
            return 0L;
        }
        return downEngineConfig.pcdnCPtr;
    }

    public synchronized void delete() {
        long j3 = this.pcdnCPtr;
        if (j3 != 0) {
            if (this.pcdnCMemOwn) {
                this.pcdnCMemOwn = false;
                apollo_pcdnJNI.delete_DownEngineConfig(j3);
            }
            this.pcdnCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    public ApolloNetworkState getCurNetworkState() {
        return ApolloNetworkState.pcdnToEnum(apollo_pcdnJNI.DownEngineConfig_curNetworkState_get(this.pcdnCPtr, this));
    }

    public boolean getIs4gEnablePcdn() {
        return apollo_pcdnJNI.DownEngineConfig_is4gEnablePcdn_get(this.pcdnCPtr, this);
    }

    public boolean getIsEnableP2p() {
        return apollo_pcdnJNI.DownEngineConfig_isEnableP2p_get(this.pcdnCPtr, this);
    }

    public ApolloDownEngineLogLevel getLogLevel() {
        return ApolloDownEngineLogLevel.pcdnToEnum(apollo_pcdnJNI.DownEngineConfig_logLevel_get(this.pcdnCPtr, this));
    }

    public String getLogSavePath() {
        return apollo_pcdnJNI.DownEngineConfig_logSavePath_get(this.pcdnCPtr, this);
    }

    public long getMaxHttpDownloadSpeed() {
        return apollo_pcdnJNI.DownEngineConfig_maxHttpDownloadSpeed_get(this.pcdnCPtr, this);
    }

    public long getMaxP2PDownloadSpeed() {
        return apollo_pcdnJNI.DownEngineConfig_maxP2PDownloadSpeed_get(this.pcdnCPtr, this);
    }

    public long getMaxP2PUploadSpeed() {
        return apollo_pcdnJNI.DownEngineConfig_maxP2PUploadSpeed_get(this.pcdnCPtr, this);
    }

    public BigInteger getMaxUsableDiskSize() {
        return apollo_pcdnJNI.DownEngineConfig_maxUsableDiskSize_get(this.pcdnCPtr, this);
    }

    public long getOpenProgressCallBack() {
        return apollo_pcdnJNI.DownEngineConfig_openProgressCallBack_get(this.pcdnCPtr, this);
    }

    public long getUiAppId() {
        return apollo_pcdnJNI.DownEngineConfig_uiAppId_get(this.pcdnCPtr, this);
    }

    public void setCurNetworkState(ApolloNetworkState apolloNetworkState) {
        apollo_pcdnJNI.DownEngineConfig_curNetworkState_set(this.pcdnCPtr, this, apolloNetworkState.pcdnValue());
    }

    public void setIs4gEnablePcdn(boolean z16) {
        apollo_pcdnJNI.DownEngineConfig_is4gEnablePcdn_set(this.pcdnCPtr, this, z16);
    }

    public void setIsEnableP2p(boolean z16) {
        apollo_pcdnJNI.DownEngineConfig_isEnableP2p_set(this.pcdnCPtr, this, z16);
    }

    public void setLogLevel(ApolloDownEngineLogLevel apolloDownEngineLogLevel) {
        apollo_pcdnJNI.DownEngineConfig_logLevel_set(this.pcdnCPtr, this, apolloDownEngineLogLevel.pcdnValue());
    }

    public void setLogSavePath(String str) {
        apollo_pcdnJNI.DownEngineConfig_logSavePath_set(this.pcdnCPtr, this, str);
    }

    public void setMaxHttpDownloadSpeed(long j3) {
        apollo_pcdnJNI.DownEngineConfig_maxHttpDownloadSpeed_set(this.pcdnCPtr, this, j3);
    }

    public void setMaxP2PDownloadSpeed(long j3) {
        apollo_pcdnJNI.DownEngineConfig_maxP2PDownloadSpeed_set(this.pcdnCPtr, this, j3);
    }

    public void setMaxP2PUploadSpeed(long j3) {
        apollo_pcdnJNI.DownEngineConfig_maxP2PUploadSpeed_set(this.pcdnCPtr, this, j3);
    }

    public void setMaxUsableDiskSize(BigInteger bigInteger) {
        apollo_pcdnJNI.DownEngineConfig_maxUsableDiskSize_set(this.pcdnCPtr, this, bigInteger);
    }

    public void setOpenProgressCallBack(long j3) {
        apollo_pcdnJNI.DownEngineConfig_openProgressCallBack_set(this.pcdnCPtr, this, j3);
    }

    public void setUiAppId(long j3) {
        apollo_pcdnJNI.DownEngineConfig_uiAppId_set(this.pcdnCPtr, this, j3);
    }

    protected DownEngineConfig(long j3, boolean z16) {
        this.pcdnCMemOwn = z16;
        this.pcdnCPtr = j3;
    }
}
