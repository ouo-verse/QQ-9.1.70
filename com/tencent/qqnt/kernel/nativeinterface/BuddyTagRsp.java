package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyTagRsp {
    public AccountInfo targetInfo = new AccountInfo();
    public String nickname = "";
    public ArrayList<PersonTag> tags = new ArrayList<>();

    public String getNickname() {
        return this.nickname;
    }

    public ArrayList<PersonTag> getTags() {
        return this.tags;
    }

    public AccountInfo getTargetInfo() {
        return this.targetInfo;
    }
}
