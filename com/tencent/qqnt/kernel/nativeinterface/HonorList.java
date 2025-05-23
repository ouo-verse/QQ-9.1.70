package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class HonorList {
    public long groupCode;

    /* renamed from: id, reason: collision with root package name */
    public ArrayList<Integer> f359187id = new ArrayList<>();
    public int isGray;

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<Integer> getId() {
        return this.f359187id;
    }

    public int getIsGray() {
        return this.isGray;
    }

    public String toString() {
        return "HonorList{groupCode=" + this.groupCode + ",id=" + this.f359187id + ",isGray=" + this.isGray + ",}";
    }
}
