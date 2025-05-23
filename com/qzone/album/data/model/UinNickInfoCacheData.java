package com.qzone.album.data.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UinNickInfoCacheData implements SmartParcelable {

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public String nick = "";

    public String toString() {
        return "(uin, " + this.uin + ")\n(nick, " + this.nick + ")\n";
    }
}
