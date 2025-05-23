package com.huya.huyasdk.jce;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OpenSubscribedNotice {
    public long lSubscribeToUid = 0;
    public long lSubscribeFromUid = 0;

    @Nullable
    public String sSubscribeFromNick = "";

    @Nullable
    public String sSubscribeFromAvatar = "";

    public String toString() {
        return "OpenSubscribedNotice{lSubscribeToUid=" + this.lSubscribeToUid + ", lSubscribeFromUid=" + this.lSubscribeFromUid + ", sSubscribeFromNick='" + this.sSubscribeFromNick + "', sSubscribeFromAvatar='" + this.sSubscribeFromAvatar + "'}";
    }
}
