package com.tencent.ark.data;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppElement {
    public String appName;
    public String bizSrc;

    public ArkAppElement(String str, String str2) {
        this.appName = str;
        this.bizSrc = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArkAppElement arkAppElement = (ArkAppElement) obj;
        if (Objects.equals(this.appName, arkAppElement.appName) && Objects.equals(this.bizSrc, arkAppElement.bizSrc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.appName, this.bizSrc);
    }

    public String toString() {
        return "ArkAppElement{appName='" + this.appName + "', bizSrc='" + this.bizSrc + "'}";
    }
}
