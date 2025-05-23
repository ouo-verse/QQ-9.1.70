package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProOnlineMemberInfo {
    public String onlineMemberCnt = "";
    public ArrayList<String> onlineMemberAvatars = new ArrayList<>();
    public String hotIcon = "";

    public String getHotIcon() {
        return this.hotIcon;
    }

    public ArrayList<String> getOnlineMemberAvatars() {
        return this.onlineMemberAvatars;
    }

    public String getOnlineMemberCnt() {
        return this.onlineMemberCnt;
    }

    public String toString() {
        return "GProOnlineMemberInfo{onlineMemberCnt=" + this.onlineMemberCnt + ",onlineMemberAvatars=" + this.onlineMemberAvatars + ",hotIcon=" + this.hotIcon + ",}";
    }
}
