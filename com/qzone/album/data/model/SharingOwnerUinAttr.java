package com.qzone.album.data.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import photo_share_struct.uin_attr;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SharingOwnerUinAttr implements SmartParcelable {

    @NeedParcel
    public long add_time;

    @NeedParcel
    public String nick;

    @NeedParcel
    public byte priv;

    @NeedParcel
    public String shareAlbumId;

    @NeedParcel
    public int status;

    public SharingOwnerUinAttr() {
        this.status = 0;
        this.nick = "";
        this.priv = (byte) 3;
        this.shareAlbumId = "";
        this.add_time = 0L;
    }

    public static SharingOwnerUinAttr createFromJce(uin_attr uin_attrVar) {
        return new SharingOwnerUinAttr(uin_attrVar.status, uin_attrVar.nick, uin_attrVar.priv, uin_attrVar.share_albumid, uin_attrVar.add_time);
    }

    public uin_attr generateJceFromCache() {
        return new uin_attr(this.status, this.nick, this.priv, this.shareAlbumId, this.add_time);
    }

    public String toString() {
        return "(status, " + this.status + ")\n(nick, " + this.nick + ")\n(priv, " + ((int) this.priv) + ")\n(shareAlbumId, " + this.shareAlbumId + ")\n(add_time, " + this.add_time + ")\n";
    }

    public SharingOwnerUinAttr(int i3, String str, byte b16, String str2, long j3) {
        this.status = i3;
        this.nick = str;
        this.priv = b16;
        this.shareAlbumId = str2;
        this.add_time = j3;
    }
}
