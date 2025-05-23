package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AppLangItem extends aabq {
    public static final Parcelable.Creator<AppLangItem> CREATOR = new aabq.aab(AppLangItem.class);
    private static final String TAG = "AppLangItem";

    @aaby(id = 3)
    private String appIconPath;

    @aaby(id = 1)
    private String appId;

    @aaby(id = 2)
    private String appName;

    @aabw
    public AppLangItem(@aabv(id = 1) String str, @aabv(id = 2) String str2, @aabv(id = 3) String str3) {
        aabz.aabb(TAG, "AppLangItem() SafePrimary ");
        this.appId = str;
        this.appName = str2;
        this.appIconPath = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppLangItem.class != obj.getClass()) {
            return false;
        }
        AppLangItem appLangItem = (AppLangItem) obj;
        if (Objects.equals(this.appId, appLangItem.appId) && Objects.equals(this.appName, appLangItem.appName) && Objects.equals(this.appIconPath, appLangItem.appIconPath)) {
            return true;
        }
        return false;
    }

    public String getAppIconPath() {
        return this.appIconPath;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public int hashCode() {
        return Objects.hash(this.appId, this.appName, this.appIconPath);
    }

    public void setAppIconPath(String str) {
        this.appIconPath = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String toString() {
        StringBuilder aab = com.huawei.hms.health.aab.aab("AppLangItem{appId='");
        aab.append(this.appId);
        aab.append('\'');
        aab.append(", appName='");
        aab.append(this.appName);
        aab.append('\'');
        aab.append(", appIconPath='");
        aab.append(this.appIconPath);
        aab.append('\'');
        aab.append('}');
        return aab.toString();
    }
}
