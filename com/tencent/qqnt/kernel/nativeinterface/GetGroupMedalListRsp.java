package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetGroupMedalListRsp {
    public boolean isShowMedal;
    public ArrayList<GroupMedalInfo> medalInfoArray = new ArrayList<>();
    public MemberRole memberType = MemberRole.values()[0];
    public String medalListUrl = "";
    public String medalDetailUrl = "";

    public boolean getIsShowMedal() {
        return this.isShowMedal;
    }

    public String getMedalDetailUrl() {
        return this.medalDetailUrl;
    }

    public ArrayList<GroupMedalInfo> getMedalInfoArray() {
        return this.medalInfoArray;
    }

    public String getMedalListUrl() {
        return this.medalListUrl;
    }

    public MemberRole getMemberType() {
        return this.memberType;
    }

    public String toString() {
        return "GetGroupMedalListRsp{medalInfoArray=" + this.medalInfoArray + ",isShowMedal=" + this.isShowMedal + ",memberType=" + this.memberType + ",medalListUrl=" + this.medalListUrl + ",medalDetailUrl=" + this.medalDetailUrl + ",}";
    }
}
