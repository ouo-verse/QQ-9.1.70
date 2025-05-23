package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVideo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProVideo implements IGProVideo {
    public final GProVideo mInfo;

    public GGProVideo(GProVideo gProVideo) {
        this.mInfo = gProVideo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public IGProImage getCover() {
        return new GGProImage(this.mInfo.getCover());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public int getDisplayIndex() {
        return this.mInfo.getDisplayIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public int getDuration() {
        return this.mInfo.getDuration();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public String getFileId() {
        return this.mInfo.getFileId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public int getFileSize() {
        return this.mInfo.getFileSize();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public int getHeight() {
        return this.mInfo.getHeight();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public String getPlayUrl() {
        return this.mInfo.getPlayUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public int getPrior() {
        return this.mInfo.getPrior();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public int getRate() {
        return this.mInfo.getRate();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public ArrayList<IGProTransVideo> getTransVideos() {
        ArrayList<GProTransVideo> transVideos = this.mInfo.getTransVideos();
        ArrayList<IGProTransVideo> arrayList = new ArrayList<>();
        Iterator<GProTransVideo> it = transVideos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProTransVideo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public int getWidth() {
        return this.mInfo.getWidth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo
    public String toString() {
        return this.mInfo.toString();
    }
}
