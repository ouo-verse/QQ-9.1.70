package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildLabel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVideo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProContentRecommendFeed implements IGProContentRecommendFeed {
    public final GProContentRecommendFeed mInfo;

    public GGProContentRecommendFeed(GProContentRecommendFeed gProContentRecommendFeed) {
        this.mInfo = gProContentRecommendFeed;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getAuditStatus() {
        return this.mInfo.getAuditStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProMVPBusinessCard getBusinessCard() {
        return new GGProMVPBusinessCard(this.mInfo.getBusinessCard());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProImage getCustomCover() {
        return new GGProImage(this.mInfo.getCustomCover());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getFeedContentType() {
        return this.mInfo.getFeedContentType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProFeedStat getFeedStat() {
        return new GGProFeedStat(this.mInfo.getFeedStat());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getFeedType() {
        return this.mInfo.getFeedType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public ArrayList<Integer> getFunctionList() {
        return this.mInfo.getFunctionList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProFeedGuildInfo getGuildInfo() {
        return new GGProFeedGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public String getIdd() {
        return this.mInfo.getIdd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProImage getImage() {
        return new GGProImage(this.mInfo.getImage());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public long getLastModifiedTime() {
        return this.mInfo.getLastModifiedTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public boolean getNeedWebview() {
        return this.mInfo.getNeedWebview();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProPoster getPoster() {
        return new GGProPoster(this.mInfo.getPoster());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProMVPRichText getRichText() {
        return new GGProMVPRichText(this.mInfo.getRichText());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public ArrayList<IGProGuildLabel> getTags() {
        ArrayList<GProGuildLabel> tags = this.mInfo.getTags();
        ArrayList<IGProGuildLabel> arrayList = new ArrayList<>();
        Iterator<GProGuildLabel> it = tags.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getTotalImageCount() {
        return this.mInfo.getTotalImageCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public ArrayList<IGProVideo> getVideos() {
        ArrayList<GProVideo> videos = this.mInfo.getVideos();
        ArrayList<IGProVideo> arrayList = new ArrayList<>();
        Iterator<GProVideo> it = videos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProVideo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public String toString() {
        return this.mInfo.toString();
    }
}
