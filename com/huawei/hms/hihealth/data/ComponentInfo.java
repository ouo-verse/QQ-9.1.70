package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ComponentInfo extends aabq {
    public static final Parcelable.Creator<ComponentInfo> CREATOR = new aabq.aab(ComponentInfo.class);

    @aaby(id = 3)
    private String appType;

    @aaby(id = 2)
    private String className;

    @aaby(id = 1)
    private String packageName;

    public ComponentInfo() {
    }

    @aabw
    public ComponentInfo(@aabv(id = 1) String str, @aabv(id = 2) String str2, @aabv(id = 3) String str3) {
        this.packageName = str;
        this.className = str2;
        this.appType = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComponentInfo)) {
            return false;
        }
        ComponentInfo componentInfo = (ComponentInfo) obj;
        if (Objects.equals(this.packageName, componentInfo.packageName) && Objects.equals(this.className, componentInfo.className) && Objects.equals(this.appType, componentInfo.appType)) {
            return true;
        }
        return false;
    }

    public String getAppType() {
        return this.appType;
    }

    public String getClassName() {
        return this.className;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return Objects.hash(this.packageName, this.className, this.appType);
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        StringBuilder aab = com.huawei.hms.health.aab.aab("ComponentInfo{packageName='");
        aab.append(this.packageName);
        aab.append('\'');
        aab.append(", className='");
        aab.append(this.className);
        aab.append('\'');
        aab.append(", OS='");
        aab.append(this.appType);
        aab.append('\'');
        aab.append('}');
        return aab.toString();
    }
}
