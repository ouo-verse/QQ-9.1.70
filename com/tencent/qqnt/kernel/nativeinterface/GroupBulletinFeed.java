package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupBulletinFeed {

    /* renamed from: cn, reason: collision with root package name */
    public int f359178cn;

    /* renamed from: fn, reason: collision with root package name */
    public int f359179fn;
    public int isAllConfirm;
    public int isRead;
    public int pinned;
    public long publishTime;
    public int readNum;
    public int type;
    public long uin;

    /* renamed from: vn, reason: collision with root package name */
    public int f359181vn;
    public String feedId = "";

    /* renamed from: msg, reason: collision with root package name */
    public GroupBulletinFeedMsg f359180msg = new GroupBulletinFeedMsg();
    public GroupBulletinFeedSetting settings = new GroupBulletinFeedSetting();

    public int getCn() {
        return this.f359178cn;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getFn() {
        return this.f359179fn;
    }

    public int getIsAllConfirm() {
        return this.isAllConfirm;
    }

    public int getIsRead() {
        return this.isRead;
    }

    public GroupBulletinFeedMsg getMsg() {
        return this.f359180msg;
    }

    public int getPinned() {
        return this.pinned;
    }

    public long getPublishTime() {
        return this.publishTime;
    }

    public int getReadNum() {
        return this.readNum;
    }

    public GroupBulletinFeedSetting getSettings() {
        return this.settings;
    }

    public int getType() {
        return this.type;
    }

    public long getUin() {
        return this.uin;
    }

    public int getVn() {
        return this.f359181vn;
    }

    public String toString() {
        return "GroupBulletinFeed{uin=" + this.uin + ",feedId=" + this.feedId + ",publishTime=" + this.publishTime + ",msg=" + this.f359180msg + ",type=" + this.type + ",fn=" + this.f359179fn + ",cn=" + this.f359178cn + ",vn=" + this.f359181vn + ",settings=" + this.settings + ",pinned=" + this.pinned + ",readNum=" + this.readNum + ",isRead=" + this.isRead + ",isAllConfirm=" + this.isAllConfirm + ",}";
    }
}
