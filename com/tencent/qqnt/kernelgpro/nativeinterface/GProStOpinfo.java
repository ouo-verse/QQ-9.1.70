package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStOpinfo implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<Long> createTimeList = new ArrayList<>();

    public ArrayList<Long> getCreateTimeList() {
        return this.createTimeList;
    }

    public String toString() {
        return "GProStOpinfo{createTimeList=" + this.createTimeList + ",}";
    }
}
