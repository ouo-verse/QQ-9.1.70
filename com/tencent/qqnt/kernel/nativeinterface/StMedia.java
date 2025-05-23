package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StMedia {
    public long batchId;
    public StMediaComment comment;
    public String desc;
    public ArrayList<Entry> ext;
    public StImage image;
    public StLBS lbs;
    public int lbsSource;
    public StMediaLike like;
    public long linkId;
    public ArrayList<Integer> opMask;
    public long shootTime;
    public int type;
    public int uploadOrder;
    public long uploadTime;
    public StUser uploadUser;
    public String uploader;
    public StVideo video;

    public StMedia() {
        this.image = new StImage();
        this.video = new StVideo();
        this.desc = "";
        this.lbs = new StLBS();
        this.uploader = "";
        this.like = new StMediaLike();
        this.comment = new StMediaComment();
        this.uploadUser = new StUser();
        this.ext = new ArrayList<>();
        this.opMask = new ArrayList<>();
    }

    public long getBatchId() {
        return this.batchId;
    }

    public StMediaComment getComment() {
        return this.comment;
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<Entry> getExt() {
        return this.ext;
    }

    public StImage getImage() {
        return this.image;
    }

    public StLBS getLbs() {
        return this.lbs;
    }

    public int getLbsSource() {
        return this.lbsSource;
    }

    public StMediaLike getLike() {
        return this.like;
    }

    public long getLinkId() {
        return this.linkId;
    }

    public ArrayList<Integer> getOpMask() {
        return this.opMask;
    }

    public long getShootTime() {
        return this.shootTime;
    }

    public int getType() {
        return this.type;
    }

    public int getUploadOrder() {
        return this.uploadOrder;
    }

    public long getUploadTime() {
        return this.uploadTime;
    }

    public StUser getUploadUser() {
        return this.uploadUser;
    }

    public String getUploader() {
        return this.uploader;
    }

    public StVideo getVideo() {
        return this.video;
    }

    public void setBatchId(long j3) {
        this.batchId = j3;
    }

    public void setComment(StMediaComment stMediaComment) {
        this.comment = stMediaComment;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExt(ArrayList<Entry> arrayList) {
        this.ext = arrayList;
    }

    public void setImage(StImage stImage) {
        this.image = stImage;
    }

    public void setLbs(StLBS stLBS) {
        this.lbs = stLBS;
    }

    public void setLbsSource(int i3) {
        this.lbsSource = i3;
    }

    public void setLike(StMediaLike stMediaLike) {
        this.like = stMediaLike;
    }

    public void setLinkId(long j3) {
        this.linkId = j3;
    }

    public void setOpMask(ArrayList<Integer> arrayList) {
        this.opMask = arrayList;
    }

    public void setShootTime(long j3) {
        this.shootTime = j3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setUploadOrder(int i3) {
        this.uploadOrder = i3;
    }

    public void setUploadTime(long j3) {
        this.uploadTime = j3;
    }

    public void setUploadUser(StUser stUser) {
        this.uploadUser = stUser;
    }

    public void setUploader(String str) {
        this.uploader = str;
    }

    public void setVideo(StVideo stVideo) {
        this.video = stVideo;
    }

    public StMedia(int i3, StImage stImage, StVideo stVideo, String str, StLBS stLBS, String str2, long j3, long j16, int i16, StMediaLike stMediaLike, StMediaComment stMediaComment, StUser stUser, ArrayList<Entry> arrayList, long j17, long j18, ArrayList<Integer> arrayList2, int i17) {
        this.image = new StImage();
        this.video = new StVideo();
        this.desc = "";
        this.lbs = new StLBS();
        this.uploader = "";
        this.like = new StMediaLike();
        this.comment = new StMediaComment();
        this.uploadUser = new StUser();
        this.ext = new ArrayList<>();
        new ArrayList();
        this.type = i3;
        this.image = stImage;
        this.video = stVideo;
        this.desc = str;
        this.lbs = stLBS;
        this.uploader = str2;
        this.batchId = j3;
        this.uploadTime = j16;
        this.uploadOrder = i16;
        this.like = stMediaLike;
        this.comment = stMediaComment;
        this.uploadUser = stUser;
        this.ext = arrayList;
        this.shootTime = j17;
        this.linkId = j18;
        this.opMask = arrayList2;
        this.lbsSource = i17;
    }
}
