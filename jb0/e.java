package jb0;

import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerVideoConverter;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideoUrl;
import feedcloud.FeedCloudMeta$StSingleVideoUrlAttachOption;
import feedcloud.FeedCloudMeta$StVideo;
import feedcloud.FeedCloudMeta$StVideoUrl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e implements IRFWPlayerVideoConverter<FeedCloudMeta$StVideo> {
    private List<FeedCloudMeta$StVideoUrl> c(RFWStVideo rFWStVideo) {
        ArrayList arrayList = new ArrayList();
        for (RFWStVideoUrl rFWStVideoUrl : rFWStVideo.getVecVideoUrl()) {
            FeedCloudMeta$StVideoUrl feedCloudMeta$StVideoUrl = new FeedCloudMeta$StVideoUrl();
            feedCloudMeta$StVideoUrl.playUrl.set(rFWStVideoUrl.getPlayUrl());
            feedCloudMeta$StVideoUrl.hasWatermark.set(rFWStVideoUrl.isHasWatermark());
            feedCloudMeta$StVideoUrl.videoPrior.set(rFWStVideoUrl.getVideoPrior());
            feedCloudMeta$StVideoUrl.height.set(rFWStVideoUrl.getHeight());
            feedCloudMeta$StVideoUrl.width.set(rFWStVideoUrl.getWidth());
            feedCloudMeta$StVideoUrl.videoRate.set(rFWStVideoUrl.getVideoRate());
            feedCloudMeta$StVideoUrl.videoClarityScore.set(rFWStVideoUrl.getVideoClarityScore());
            feedCloudMeta$StVideoUrl.levelType.set(rFWStVideoUrl.getLevelType());
            feedCloudMeta$StVideoUrl.transStatus.set(rFWStVideoUrl.getTransStatus());
            arrayList.add(feedCloudMeta$StVideoUrl);
        }
        return arrayList;
    }

    private List<RFWStVideoUrl> d(FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StVideoUrl feedCloudMeta$StVideoUrl : feedCloudMeta$StVideo.vecVideoUrl.get()) {
            RFWStVideoUrl rFWStVideoUrl = new RFWStVideoUrl();
            rFWStVideoUrl.setPlayUrl(feedCloudMeta$StVideoUrl.playUrl.get()).setHasWatermark(feedCloudMeta$StVideoUrl.hasWatermark.get()).setVideoPrior(feedCloudMeta$StVideoUrl.videoPrior.get()).setHeight(feedCloudMeta$StVideoUrl.height.get()).setWidth(feedCloudMeta$StVideoUrl.width.get()).setVideoRate(feedCloudMeta$StVideoUrl.videoRate.get()).setVideoClarityScore(feedCloudMeta$StVideoUrl.videoClarityScore.get()).setLevelType(feedCloudMeta$StVideoUrl.levelType.get()).setTransStatus(feedCloudMeta$StVideoUrl.transStatus.get());
            arrayList.add(rFWStVideoUrl);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerVideoConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FeedCloudMeta$StVideo convertToBusinessVideo(RFWStVideo rFWStVideo) {
        if (rFWStVideo == null) {
            return null;
        }
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
        feedCloudMeta$StVideo.fileId.set(rFWStVideo.getFileId());
        feedCloudMeta$StVideo.playUrl.set(rFWStVideo.getPlayUrl());
        feedCloudMeta$StVideo.duration.set(rFWStVideo.getDuration());
        FeedCloudMeta$StSingleVideoUrlAttachOption feedCloudMeta$StSingleVideoUrlAttachOption = new FeedCloudMeta$StSingleVideoUrlAttachOption();
        feedCloudMeta$StSingleVideoUrlAttachOption.isHdrVideo.set(rFWStVideo.isHdrVideo());
        feedCloudMeta$StVideo.attachOption.set(feedCloudMeta$StSingleVideoUrlAttachOption);
        feedCloudMeta$StVideo.width.set(rFWStVideo.getWidth());
        feedCloudMeta$StVideo.height.set(rFWStVideo.getHeight());
        feedCloudMeta$StVideo.isQuic.set(rFWStVideo.isQuic());
        feedCloudMeta$StVideo.videoMD5.set(rFWStVideo.getVideoMD5());
        feedCloudMeta$StVideo.videoPrior.set(rFWStVideo.getVideoPrior());
        feedCloudMeta$StVideo.orientation.set(rFWStVideo.getOrientation());
        feedCloudMeta$StVideo.fileSize.set(rFWStVideo.getFileSize());
        feedCloudMeta$StVideo.videoRate.set(rFWStVideo.getVideoRate());
        feedCloudMeta$StVideo.mediaQualityScore.set(rFWStVideo.getMediaQualityScore());
        feedCloudMeta$StVideo.transStatus.set(rFWStVideo.getTransStatus());
        feedCloudMeta$StVideo.vecVideoUrl.set(c(rFWStVideo));
        return feedCloudMeta$StVideo;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerVideoConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RFWStVideo convertToRFWStVideo(FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        boolean z16;
        if (feedCloudMeta$StVideo == null) {
            return null;
        }
        RFWStVideo rFWStVideo = new RFWStVideo();
        RFWStVideo duration = rFWStVideo.setFileId(feedCloudMeta$StVideo.fileId.get()).setPlayUrl(feedCloudMeta$StVideo.playUrl.get()).setDuration(feedCloudMeta$StVideo.duration.get());
        FeedCloudMeta$StSingleVideoUrlAttachOption feedCloudMeta$StSingleVideoUrlAttachOption = feedCloudMeta$StVideo.attachOption;
        if (feedCloudMeta$StSingleVideoUrlAttachOption != null && feedCloudMeta$StSingleVideoUrlAttachOption.isHdrVideo.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        duration.setHdrVideo(z16).setWidth(feedCloudMeta$StVideo.width.get()).setHeight(feedCloudMeta$StVideo.height.get()).setQuic(feedCloudMeta$StVideo.isQuic.get()).setVideoMD5(feedCloudMeta$StVideo.videoMD5.get()).setVideoPrior(feedCloudMeta$StVideo.videoPrior.get()).setOrientation(feedCloudMeta$StVideo.orientation.get()).setVideoRate(feedCloudMeta$StVideo.videoRate.get()).setFileSize(feedCloudMeta$StVideo.fileSize.get()).setMediaQualityScore(feedCloudMeta$StVideo.mediaQualityScore.get()).setTransStatus(feedCloudMeta$StVideo.transStatus.get()).setVecVideoUrl(d(feedCloudMeta$StVideo));
        return rFWStVideo;
    }
}
