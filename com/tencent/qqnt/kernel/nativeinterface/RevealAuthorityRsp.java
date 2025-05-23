package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RevealAuthorityRsp {
    public ArrayList<LastTofu> lastTofus;

    public RevealAuthorityRsp() {
        this.lastTofus = new ArrayList<>();
    }

    public ArrayList<LastTofu> getLastTofus() {
        return this.lastTofus;
    }

    public RevealAuthorityRsp(ArrayList<LastTofu> arrayList) {
        new ArrayList();
        this.lastTofus = arrayList;
    }
}
