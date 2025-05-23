package com.tencent.rfix.loader.verify;

import android.content.Context;
import com.tencent.rfix.loader.storage.AbsStorableInfo;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RemoteVerifyInfo extends AbsStorableInfo {
    private static final String APP_ID = "app_id";
    private static final String APP_KEY = "app_key";
    private static final String APP_VERSION = "app_version";
    private static final String TAG = "RFix.RemoteVerifyInfo";
    public String appId;
    public String appKey;
    public String appVersion;

    public RemoteVerifyInfo(Context context, boolean z16) {
        super(context, "remote_verify_info", z16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteVerifyInfo)) {
            return false;
        }
        RemoteVerifyInfo remoteVerifyInfo = (RemoteVerifyInfo) obj;
        if (Objects.equals(this.appId, remoteVerifyInfo.appId) && Objects.equals(this.appKey, remoteVerifyInfo.appKey) && Objects.equals(this.appVersion, remoteVerifyInfo.appVersion)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void loadStoreInfo() {
        super.loadStoreInfo();
        this.appId = this.storage.getString("app_id", null);
        this.appKey = this.storage.getString("app_key", null);
        this.appVersion = this.storage.getString("app_version", null);
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void saveStoreInfo() {
        this.storage.putString("app_id", this.appId);
        this.storage.putString("app_key", this.appKey);
        this.storage.putString("app_version", this.appVersion);
        super.saveStoreInfo();
    }

    public String toString() {
        return "RemoteVerifyInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', appVersion='" + this.appVersion + "'}";
    }
}
