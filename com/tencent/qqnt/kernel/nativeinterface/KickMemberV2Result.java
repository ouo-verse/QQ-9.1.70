package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class KickMemberV2Result {
    public long groupCode;
    public ArrayList<KickMemberResult> rptKickResult = new ArrayList<>();

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<KickMemberResult> getRptKickResult() {
        return this.rptKickResult;
    }

    public String toString() {
        return "KickMemberV2Result{groupCode=" + this.groupCode + ",rptKickResult=" + this.rptKickResult + ",}";
    }
}
