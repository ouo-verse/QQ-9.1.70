package com.qzone.common.friend.business.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Friend implements SmartParcelable {

    @NeedParcel
    public String mName;

    @NeedParcel
    public String mNickName;

    @NeedParcel
    public String mRemark;

    @NeedParcel
    public long mUin;

    @NeedParcel
    public String uinKey;

    @NeedParcel
    public int vipLevel;

    @NeedParcel
    public int who;

    public Friend(long j3, String str, String str2, String str3, int i3, String str4) {
        this.vipLevel = -1;
        this.mUin = j3;
        this.mName = str;
        this.mNickName = str2;
        this.mRemark = str3;
        this.who = i3;
        this.uinKey = str4;
    }

    public Friend() {
        this.mUin = -1L;
        this.mName = "";
        this.mNickName = "";
        this.mRemark = "";
        this.vipLevel = -1;
        this.who = 0;
        this.uinKey = "";
    }
}
