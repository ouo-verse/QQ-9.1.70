package com.qzone.album.data.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import photo_share_struct.client_attr;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SharingAlbumClientAttr implements SmartParcelable {
    public static final long GENDER_FEMALE = 2;
    public static final long GENDER_MALE = 1;
    public static final long GENDER_NONE = 0;

    @NeedParcel
    public int action;

    @NeedParcel
    public long gender;
    public boolean needShowResend;

    @NeedParcel
    public String qq_nick;

    @NeedParcel
    public long uin;

    @NeedParcel
    public SharingOwnerUinAttr uinAttr;

    public SharingAlbumClientAttr() {
        this.uin = 0L;
        this.uinAttr = null;
        this.qq_nick = "";
        this.action = 0;
        this.gender = 0L;
        this.needShowResend = true;
    }

    public String toString() {
        return "(uin, " + this.uin + ")\n++(uinAttr, " + this.uinAttr + ")++\n(qq_nick, " + this.qq_nick + ")\n(action, " + this.action + ")\n(gender, " + this.gender + ")\n(needShowResend, " + this.needShowResend + ")";
    }

    public SharingAlbumClientAttr(long j3, SharingOwnerUinAttr sharingOwnerUinAttr, String str, int i3) {
        this.needShowResend = true;
        this.uin = j3;
        this.uinAttr = sharingOwnerUinAttr;
        this.qq_nick = str;
        this.action = i3;
        this.gender = 0L;
    }

    public SharingAlbumClientAttr(client_attr client_attrVar) {
        this.uin = 0L;
        this.uinAttr = null;
        this.qq_nick = "";
        this.action = 0;
        this.gender = 0L;
        this.needShowResend = true;
        this.uin = client_attrVar.uin;
        this.uinAttr = SharingOwnerUinAttr.createFromJce(client_attrVar.attr);
        this.qq_nick = client_attrVar.qq_nick;
        this.action = client_attrVar.action;
        this.gender = client_attrVar.gender;
    }
}
