package com.huya.huyasdk.jce;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OpenSubscribeReq {

    @Nullable
    public UserId tId = null;
    public long lToUid = 0;

    @Nullable
    public String sFromNick = "";

    @Nullable
    public String sFromAvatar = "";
    public int iAction = 0;

    public String toString() {
        return "OpenSubscribeReq{tId=" + this.tId + ", lToUid=" + this.lToUid + ", sFromNick='" + this.sFromNick + "', sFromAvatar='" + this.sFromAvatar + "', iAction=" + this.iAction + '}';
    }
}
