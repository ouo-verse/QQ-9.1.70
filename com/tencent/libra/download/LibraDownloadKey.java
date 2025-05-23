package com.tencent.libra.download;

import com.tencent.libra.cache.Key;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraDownloadKey implements Key {
    private String mStorePath;

    public LibraDownloadKey(String str) {
        this.mStorePath = str;
    }

    @Override // com.tencent.libra.cache.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.mStorePath, ((LibraDownloadKey) obj).mStorePath);
        }
        return false;
    }

    public String getStorePath() {
        return this.mStorePath;
    }

    @Override // com.tencent.libra.cache.Key
    public int hashCode() {
        return Objects.hash(this.mStorePath);
    }

    public void setStorePath(String str) {
        this.mStorePath = str;
    }

    public String toString() {
        return "LibraDownloadKey{mStorePath='" + this.mStorePath + "'}";
    }
}
