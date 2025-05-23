package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScopeLangItem extends aabq {
    public static final Parcelable.Creator<ScopeLangItem> CREATOR = new aabq.aab(ScopeLangItem.class);
    private static final String TAG = "ScopeLangItem";

    @aaby(id = 4)
    private String appIconPath;

    @aaby(id = 3)
    private String appName;

    @aaby(id = 2)
    private String authTime;

    @aaby(id = 1)
    private Map<String, String> url2Desc;

    @aabw
    public ScopeLangItem(@aabv(id = 1) Map<String, String> map, @aabv(id = 2) String str, @aabv(id = 3) String str2, @aabv(id = 4) String str3) {
        aabz.aabb(TAG, "ScopeLangItem() SafePrimary ");
        this.url2Desc = map;
        this.authTime = str;
        this.appName = str2;
        this.appIconPath = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScopeLangItem)) {
            return false;
        }
        ScopeLangItem scopeLangItem = (ScopeLangItem) obj;
        if (this.url2Desc.equals(scopeLangItem.url2Desc) && this.authTime.equals(scopeLangItem.authTime) && this.appName.equals(scopeLangItem.appName) && this.appIconPath.equals(scopeLangItem.appIconPath)) {
            return true;
        }
        return false;
    }

    public String getAppIconPath() {
        return this.appIconPath;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAuthTime() {
        return this.authTime;
    }

    public Map<String, String> getUrl2Desc() {
        return this.url2Desc;
    }

    public int hashCode() {
        return Objects.hash(this.url2Desc, this.authTime, this.appName, this.appIconPath);
    }

    public void setAppIconPath(String str) {
        this.appIconPath = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAuthTime(String str) {
        this.authTime = str;
    }

    public void setUrl2Desc(Map<String, String> map) {
        this.url2Desc = map;
    }

    public String toString() {
        StringBuilder aab = com.huawei.hms.health.aab.aab("ScopeLangItem{id2Desc=");
        aab.append(this.url2Desc);
        aab.append(", authTime='");
        aab.append(this.authTime);
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
