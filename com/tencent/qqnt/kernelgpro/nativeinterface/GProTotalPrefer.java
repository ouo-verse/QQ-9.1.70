package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTotalPrefer implements Serializable {
    public int preferCount;
    public int preferCountWithoutLike;
    public int preferStatus;
    long serialVersionUID = 1;

    public int getPreferCount() {
        return this.preferCount;
    }

    public int getPreferCountWithoutLike() {
        return this.preferCountWithoutLike;
    }

    public int getPreferStatus() {
        return this.preferStatus;
    }

    public String toString() {
        return "GProTotalPrefer{preferCount=" + this.preferCount + ",preferStatus=" + this.preferStatus + ",preferCountWithoutLike=" + this.preferCountWithoutLike + ",}";
    }
}
