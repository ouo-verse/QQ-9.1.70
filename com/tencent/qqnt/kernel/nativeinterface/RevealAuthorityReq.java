package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RevealAuthorityReq {
    public ArrayList<LastTofu> lastTofus;
    public long uin;

    public RevealAuthorityReq() {
        this.lastTofus = new ArrayList<>();
    }

    public ArrayList<LastTofu> getLastTofus() {
        return this.lastTofus;
    }

    public long getUin() {
        return this.uin;
    }

    public RevealAuthorityReq(long j3, ArrayList<LastTofu> arrayList) {
        new ArrayList();
        this.uin = j3;
        this.lastTofus = arrayList;
    }
}
