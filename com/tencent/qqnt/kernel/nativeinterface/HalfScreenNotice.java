package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class HalfScreenNotice {
    public String noticeId = "";
    public String title = "";
    public String desc = "";
    public ArrayList<HalfScreenImage> images = new ArrayList<>();
    public HalfScreenButton confirmOp = new HalfScreenButton();
    public HalfScreenButton otherOp = new HalfScreenButton();

    public HalfScreenButton getConfirmOp() {
        return this.confirmOp;
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<HalfScreenImage> getImages() {
        return this.images;
    }

    public String getNoticeId() {
        return this.noticeId;
    }

    public HalfScreenButton getOtherOp() {
        return this.otherOp;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "HalfScreenNotice{noticeId=" + this.noticeId + ",title=" + this.title + ",desc=" + this.desc + ",images=" + this.images + ",confirmOp=" + this.confirmOp + ",otherOp=" + this.otherOp + ",}";
    }
}
