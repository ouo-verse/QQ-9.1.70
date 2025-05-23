package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchFeedImageEntity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGuildFeed;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildSearchGuildFeed implements IGProGuildSearchGuildFeed {
    public final GProGuildSearchGuildFeed mInfo;

    public GGProGuildSearchGuildFeed(GProGuildSearchGuildFeed gProGuildSearchGuildFeed) {
        this.mInfo = gProGuildSearchGuildFeed;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public long getCommentCount() {
        return this.mInfo.getCommentCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public long getFavorCount() {
        return this.mInfo.getFavorCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public String getFeedId() {
        return this.mInfo.getFeedId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public int getFeedType() {
        return this.mInfo.getFeedType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public ArrayList<Integer> getFunctionList() {
        return this.mInfo.getFunctionList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public ArrayList<IGProGuildSearchFeedImageEntity> getImages() {
        ArrayList<GProGuildSearchFeedImageEntity> images = this.mInfo.getImages();
        ArrayList<IGProGuildSearchFeedImageEntity> arrayList = new ArrayList<>();
        Iterator<GProGuildSearchFeedImageEntity> it = images.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildSearchFeedImageEntity(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public boolean getNeedWebview() {
        return this.mInfo.getNeedWebview();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public byte[] getOriContents() {
        return this.mInfo.getOriContents();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public ArrayList<IGProGuildSearchFeedImageEntity> getVideos() {
        ArrayList<GProGuildSearchFeedImageEntity> videos = this.mInfo.getVideos();
        ArrayList<IGProGuildSearchFeedImageEntity> arrayList = new ArrayList<>();
        Iterator<GProGuildSearchFeedImageEntity> it = videos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildSearchFeedImageEntity(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed
    public String toString() {
        return this.mInfo.toString();
    }
}
