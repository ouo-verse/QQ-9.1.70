package com.tencent.thumbplayer.api.asset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPRtcMediaAsset extends ITPUrlMediaAsset {
    public static final String TP_ASSET_PARAM_KEY_BOOL_SERVER_ABR = "tp_asset_param_key_bool_server_abr";
    public static final int TP_SDP_EXCHANGE_MODE_CUSTOM = 2;
    public static final int TP_SDP_EXCHANGE_MODE_MINI = 1;
    public static final int TP_SDP_EXCHANGE_MODE_NORMAL = 0;

    /* loaded from: classes26.dex */
    public interface ITPRtcSdpExchangeListener {
        TPRemoteSdpInfo onSdpExchange(String str, int i3);
    }

    /* loaded from: classes26.dex */
    public static class TPRemoteSdpInfo {
        private boolean mIsSuccess;
        private String mRemoteSdp;
        private int mSessionID = -1;

        public String getRemoteSdp() {
            return this.mRemoteSdp;
        }

        public int getSessionID() {
            return this.mSessionID;
        }

        public boolean isSuccess() {
            return this.mIsSuccess;
        }

        public void setIsSuccess(boolean z16) {
            this.mIsSuccess = z16;
        }

        public void setRemoteSdp(String str) {
            this.mRemoteSdp = str;
        }

        public void setSessionID(int i3) {
            this.mSessionID = i3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPSdpExchangeMode {
    }

    void setSdpExchangeListener(ITPRtcSdpExchangeListener iTPRtcSdpExchangeListener);

    void setSdpExchangeMode(int i3);

    void setSdpServerUrl(String str);
}
