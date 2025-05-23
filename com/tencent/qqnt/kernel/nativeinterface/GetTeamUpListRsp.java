package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetTeamUpListRsp {
    public int isEnd;
    public ArrayList<TeamUpTeamDetail> details = new ArrayList<>();
    public byte[] cookie = new byte[0];

    public byte[] getCookie() {
        return this.cookie;
    }

    public ArrayList<TeamUpTeamDetail> getDetails() {
        return this.details;
    }

    public int getIsEnd() {
        return this.isEnd;
    }

    public String toString() {
        return "GetTeamUpListRsp{details=" + this.details + ",isEnd=" + this.isEnd + ",cookie=" + this.cookie + ",}";
    }
}
