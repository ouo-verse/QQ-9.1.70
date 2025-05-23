package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ActivateFriendItem {
    public long birthSendTime;
    public String birthdayDesc;
    public String nickName;
    public int type;
    public long uin;

    public ActivateFriendItem(int i3, long j3) {
        this.type = i3;
        this.uin = j3;
    }

    public ActivateFriendItem(int i3, long j3, String str) {
        this.type = i3;
        this.uin = j3;
        this.nickName = str;
    }
}
