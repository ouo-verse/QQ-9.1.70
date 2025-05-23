package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006*"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsArea;", "", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "endShootTime", "", "getEndShootTime", "()J", "setEndShootTime", "(J)V", "lbsInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;", "getLbsInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;", "setLbsInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;)V", "lbsPhotoNum", "", "getLbsPhotoNum", "()I", "setLbsPhotoNum", "(I)V", "photoNum", "getPhotoNum", "setPhotoNum", "sceneryName", "getSceneryName", "setSceneryName", "startShootTime", "getStartShootTime", "setStartShootTime", "userConfirmed", "", "getUserConfirmed", "()Z", "setUserConfirmed", "(Z)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonMediaLbsArea {
    public static final int $stable = 8;
    private long endShootTime;
    private int lbsPhotoNum;
    private int photoNum;
    private long startShootTime;
    private boolean userConfirmed;
    private CommonStLBS lbsInfo = new CommonStLBS();
    private String desc = "";
    private String sceneryName = "";

    public final String getDesc() {
        return this.desc;
    }

    public final long getEndShootTime() {
        return this.endShootTime;
    }

    public final CommonStLBS getLbsInfo() {
        return this.lbsInfo;
    }

    public final int getLbsPhotoNum() {
        return this.lbsPhotoNum;
    }

    public final int getPhotoNum() {
        return this.photoNum;
    }

    public final String getSceneryName() {
        return this.sceneryName;
    }

    public final long getStartShootTime() {
        return this.startShootTime;
    }

    public final boolean getUserConfirmed() {
        return this.userConfirmed;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setEndShootTime(long j3) {
        this.endShootTime = j3;
    }

    public final void setLbsInfo(CommonStLBS commonStLBS) {
        this.lbsInfo = commonStLBS;
    }

    public final void setLbsPhotoNum(int i3) {
        this.lbsPhotoNum = i3;
    }

    public final void setPhotoNum(int i3) {
        this.photoNum = i3;
    }

    public final void setSceneryName(String str) {
        this.sceneryName = str;
    }

    public final void setStartShootTime(long j3) {
        this.startShootTime = j3;
    }

    public final void setUserConfirmed(boolean z16) {
        this.userConfirmed = z16;
    }
}
