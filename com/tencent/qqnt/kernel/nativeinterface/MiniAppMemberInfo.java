package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MiniAppMemberInfo {
    public MemberRole memberRole = MemberRole.values()[0];

    public MemberRole getMemberRole() {
        return this.memberRole;
    }

    public String toString() {
        return "MiniAppMemberInfo{memberRole=" + this.memberRole + ",}";
    }
}
