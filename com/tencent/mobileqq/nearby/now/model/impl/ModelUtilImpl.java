package com.tencent.mobileqq.nearby.now.model.impl;

import com.tencent.mobileqq.nearby.now.model.IModelUtil;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.model.b;
import com.tencent.mobileqq.nearby.now.model.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.now.FeedsProtocol$LbsInfo;
import com.tencent.pb.now.FeedsProtocol$PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol$PicInfo;
import com.tencent.pb.now.FeedsProtocol$RichTitleElement;
import com.tencent.pb.now.FeedsProtocol$ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol$TextFeed;
import com.tencent.pb.now.FeedsProtocol$TopicCfg;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ModelUtilImpl implements IModelUtil {
    @Override // com.tencent.mobileqq.nearby.now.model.IModelUtil
    public int getFeedsProtocolMediaInfoTextFeeds() {
        return 6;
    }

    @Override // com.tencent.mobileqq.nearby.now.model.IModelUtil
    public VideoData parseImageData(int i3, List<Object> list, Object obj, ArrayList<VideoData> arrayList) {
        FeedsProtocol$PicFeedsInfo feedsProtocol$PicFeedsInfo = (FeedsProtocol$PicFeedsInfo) obj;
        VideoData videoData = new VideoData();
        videoData.f252695e = feedsProtocol$PicFeedsInfo.feeds_id.get().toStringUtf8();
        videoData.U = feedsProtocol$PicFeedsInfo.create_time.get();
        videoData.X = feedsProtocol$PicFeedsInfo.share_url.get().toStringUtf8();
        videoData.N = feedsProtocol$PicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
        videoData.D = feedsProtocol$PicFeedsInfo.user_info.uid.get();
        videoData.F = feedsProtocol$PicFeedsInfo.user_info.explicit_uid.get();
        videoData.E = feedsProtocol$PicFeedsInfo.user_info.tinyid.get();
        videoData.G = feedsProtocol$PicFeedsInfo.user_info.id_type.get();
        videoData.P = feedsProtocol$PicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
        videoData.Q = feedsProtocol$PicFeedsInfo.user_info.uid.get();
        videoData.R = feedsProtocol$PicFeedsInfo.user_info.explicit_uid.get();
        videoData.S = feedsProtocol$PicFeedsInfo.user_info.id_type.get();
        videoData.T = feedsProtocol$PicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
        videoData.I = feedsProtocol$PicFeedsInfo.is_listen.get() != 0;
        videoData.J = feedsProtocol$PicFeedsInfo.is_like.get() != 0;
        videoData.C = feedsProtocol$PicFeedsInfo.like_num.get();
        videoData.H = feedsProtocol$PicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
        videoData.K = feedsProtocol$PicFeedsInfo.view_times.get();
        videoData.L = feedsProtocol$PicFeedsInfo.user_info.age.get();
        videoData.M = feedsProtocol$PicFeedsInfo.user_info.user_gender.get();
        videoData.Y = feedsProtocol$PicFeedsInfo.user_info.uid.get();
        videoData.Z = feedsProtocol$PicFeedsInfo.user_info.explicit_uid.get();
        videoData.f252690a0 = feedsProtocol$PicFeedsInfo.user_info.id_type.get();
        videoData.W = "";
        videoData.f252692c0 = feedsProtocol$PicFeedsInfo.feed_type.get();
        videoData.f252705k0 = i3;
        for (FeedsProtocol$PicInfo feedsProtocol$PicInfo : feedsProtocol$PicFeedsInfo.pic_infos.get()) {
            videoData.f252703i0.add(new b(feedsProtocol$PicInfo.url.get().toStringUtf8(), feedsProtocol$PicInfo.width.get(), feedsProtocol$PicInfo.hight.get()));
        }
        for (FeedsProtocol$RichTitleElement feedsProtocol$RichTitleElement : feedsProtocol$PicFeedsInfo.rpt_msg_rich_title.get()) {
            if (feedsProtocol$RichTitleElement.type.get() == 1) {
                videoData.W += feedsProtocol$RichTitleElement.text.get().toStringUtf8();
            } else if (feedsProtocol$RichTitleElement.type.get() == 2) {
                videoData.W += "#" + feedsProtocol$RichTitleElement.text.get().toStringUtf8() + "#";
            }
        }
        FeedsProtocol$LbsInfo feedsProtocol$LbsInfo = feedsProtocol$PicFeedsInfo.lbs_info;
        if (feedsProtocol$LbsInfo != null) {
            FeedsProtocol$LbsInfo feedsProtocol$LbsInfo2 = feedsProtocol$LbsInfo.get();
            LocationInfo locationInfo = new LocationInfo();
            videoData.f252698f0 = locationInfo;
            locationInfo.init(feedsProtocol$LbsInfo2.lng.get().toStringUtf8(), feedsProtocol$LbsInfo2.lat.get().toStringUtf8(), feedsProtocol$LbsInfo2.city.get().toStringUtf8(), feedsProtocol$LbsInfo2.name.get().toStringUtf8());
        } else {
            videoData.f252698f0 = new LocationInfo();
        }
        arrayList.add(((IModelUtil) QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(list, videoData));
        return videoData;
    }

    @Override // com.tencent.mobileqq.nearby.now.model.IModelUtil
    public VideoData parseShortVideoData(int i3, List<Object> list, Object obj, ArrayList<VideoData> arrayList) {
        FeedsProtocol$ShortVideoInfo feedsProtocol$ShortVideoInfo = (FeedsProtocol$ShortVideoInfo) obj;
        VideoData videoData = new VideoData();
        videoData.f252695e = feedsProtocol$ShortVideoInfo.feeds_id.get().toStringUtf8();
        videoData.f252693d = 2;
        videoData.U = feedsProtocol$ShortVideoInfo.create_time.get();
        videoData.f252702i = feedsProtocol$ShortVideoInfo.doodle_pic_url.get().toStringUtf8();
        videoData.X = feedsProtocol$ShortVideoInfo.share_url.get().toStringUtf8();
        videoData.f252700h = feedsProtocol$ShortVideoInfo.pic_url.get().toStringUtf8();
        videoData.f252697f = feedsProtocol$ShortVideoInfo.video_url.get().toStringUtf8();
        videoData.N = feedsProtocol$ShortVideoInfo.anchor_info.get().anchor_name.get().toStringUtf8();
        videoData.D = feedsProtocol$ShortVideoInfo.anchor_info.get().uid.get();
        videoData.F = feedsProtocol$ShortVideoInfo.anchor_info.explicit_uid.get();
        videoData.E = feedsProtocol$ShortVideoInfo.anchor_info.tinyid.get();
        videoData.G = feedsProtocol$ShortVideoInfo.anchor_info.id_type.get();
        videoData.P = feedsProtocol$ShortVideoInfo.user_info.anchor_name.get().toStringUtf8();
        videoData.Q = feedsProtocol$ShortVideoInfo.user_info.uid.get();
        videoData.R = feedsProtocol$ShortVideoInfo.user_info.explicit_uid.get();
        videoData.S = feedsProtocol$ShortVideoInfo.user_info.id_type.get();
        videoData.T = feedsProtocol$ShortVideoInfo.user_info.head_img_url.get().toStringUtf8();
        videoData.I = feedsProtocol$ShortVideoInfo.is_listen.get() != 0;
        videoData.J = feedsProtocol$ShortVideoInfo.is_like.get() != 0;
        videoData.C = feedsProtocol$ShortVideoInfo.like_num.get();
        videoData.H = feedsProtocol$ShortVideoInfo.anchor_info.get().head_img_url.get().toStringUtf8();
        videoData.K = feedsProtocol$ShortVideoInfo.view_times.get();
        videoData.L = feedsProtocol$ShortVideoInfo.user_info.age.get();
        videoData.M = feedsProtocol$ShortVideoInfo.user_info.user_gender.get();
        videoData.Y = feedsProtocol$ShortVideoInfo.user_info.uid.get();
        videoData.Z = feedsProtocol$ShortVideoInfo.user_info.explicit_uid.get();
        videoData.f252690a0 = feedsProtocol$ShortVideoInfo.user_info.id_type.get();
        videoData.W = "";
        videoData.f252692c0 = feedsProtocol$ShortVideoInfo.feed_type.get();
        videoData.f252694d0 = feedsProtocol$ShortVideoInfo.video_hight.get();
        videoData.f252696e0 = feedsProtocol$ShortVideoInfo.video_width.get();
        videoData.V = feedsProtocol$ShortVideoInfo.video_time.get();
        videoData.f252705k0 = i3;
        for (FeedsProtocol$RichTitleElement feedsProtocol$RichTitleElement : feedsProtocol$ShortVideoInfo.rpt_msg_rich_title.get()) {
            if (feedsProtocol$RichTitleElement.type.get() == 1) {
                videoData.W += feedsProtocol$RichTitleElement.text.get().toStringUtf8();
            } else if (feedsProtocol$RichTitleElement.type.get() == 2) {
                videoData.W += "#" + feedsProtocol$RichTitleElement.text.get().toStringUtf8() + "#";
            }
        }
        if (feedsProtocol$ShortVideoInfo.lbs_info.get() != null) {
            FeedsProtocol$LbsInfo feedsProtocol$LbsInfo = feedsProtocol$ShortVideoInfo.lbs_info.get();
            LocationInfo locationInfo = new LocationInfo();
            videoData.f252698f0 = locationInfo;
            locationInfo.init(feedsProtocol$LbsInfo.lng.get().toStringUtf8(), feedsProtocol$LbsInfo.lat.get().toStringUtf8(), feedsProtocol$LbsInfo.city.get().toStringUtf8(), feedsProtocol$LbsInfo.name.get().toStringUtf8());
        } else {
            videoData.f252698f0 = new LocationInfo();
        }
        arrayList.add(((IModelUtil) QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(list, videoData));
        return videoData;
    }

    @Override // com.tencent.mobileqq.nearby.now.model.IModelUtil
    public void parseTextFeeds(int i3, List<Object> list, Object obj, ArrayList<VideoData> arrayList) {
        FeedsProtocol$TextFeed feedsProtocol$TextFeed = (FeedsProtocol$TextFeed) obj;
        VideoData videoData = new VideoData();
        videoData.f252695e = feedsProtocol$TextFeed.feeds_id.get();
        videoData.U = feedsProtocol$TextFeed.create_time.get();
        videoData.X = feedsProtocol$TextFeed.share_url.get();
        int i16 = VideoData.f252689l0;
        videoData.f252693d = i16;
        videoData.N = feedsProtocol$TextFeed.user_info.anchor_name.get().toStringUtf8();
        videoData.D = feedsProtocol$TextFeed.user_info.uid.get();
        videoData.F = feedsProtocol$TextFeed.user_info.explicit_uid.get();
        videoData.E = feedsProtocol$TextFeed.user_info.tinyid.get();
        videoData.G = feedsProtocol$TextFeed.user_info.id_type.get();
        videoData.P = feedsProtocol$TextFeed.user_info.anchor_name.get().toStringUtf8();
        videoData.Q = feedsProtocol$TextFeed.user_info.uid.get();
        videoData.R = feedsProtocol$TextFeed.user_info.explicit_uid.get();
        videoData.S = feedsProtocol$TextFeed.user_info.id_type.get();
        videoData.T = feedsProtocol$TextFeed.user_info.head_img_url.get().toStringUtf8();
        videoData.H = feedsProtocol$TextFeed.user_info.head_img_url.get().toStringUtf8();
        videoData.L = feedsProtocol$TextFeed.user_info.age.get();
        videoData.M = feedsProtocol$TextFeed.user_info.user_gender.get();
        videoData.Y = feedsProtocol$TextFeed.user_info.uid.get();
        videoData.Z = feedsProtocol$TextFeed.user_info.explicit_uid.get();
        videoData.f252690a0 = feedsProtocol$TextFeed.user_info.id_type.get();
        videoData.I = feedsProtocol$TextFeed.is_listen.get() != 0;
        videoData.J = feedsProtocol$TextFeed.is_like.get() != 0;
        videoData.C = feedsProtocol$TextFeed.like_num.get();
        videoData.H = feedsProtocol$TextFeed.user_info.head_img_url.get().toStringUtf8();
        videoData.K = feedsProtocol$TextFeed.view_times.get();
        videoData.f252692c0 = i16;
        videoData.f252705k0 = i3;
        videoData.W = "";
        for (FeedsProtocol$RichTitleElement feedsProtocol$RichTitleElement : feedsProtocol$TextFeed.rpt_msg_rich_title.get()) {
            if (feedsProtocol$RichTitleElement.type.get() == 1) {
                videoData.W += feedsProtocol$RichTitleElement.text.get().toStringUtf8();
            } else if (feedsProtocol$RichTitleElement.type.get() == 2) {
                feedsProtocol$RichTitleElement.text.get().toStringUtf8();
            }
        }
        FeedsProtocol$LbsInfo feedsProtocol$LbsInfo = feedsProtocol$TextFeed.lbs_info;
        if (feedsProtocol$LbsInfo != null) {
            FeedsProtocol$LbsInfo feedsProtocol$LbsInfo2 = feedsProtocol$LbsInfo.get();
            LocationInfo locationInfo = new LocationInfo();
            videoData.f252698f0 = locationInfo;
            locationInfo.init(feedsProtocol$LbsInfo2.lng.get().toStringUtf8(), feedsProtocol$LbsInfo2.lat.get().toStringUtf8(), feedsProtocol$LbsInfo2.city.get().toStringUtf8(), feedsProtocol$LbsInfo2.name.get().toStringUtf8());
        } else {
            videoData.f252698f0 = new LocationInfo();
        }
        arrayList.add(((IModelUtil) QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(list, videoData));
    }

    @Override // com.tencent.mobileqq.nearby.now.model.IModelUtil
    public VideoData parseTopicInfoToVideoData(List<Object> list, VideoData videoData) {
        if (list != null && !list.isEmpty()) {
            FeedsProtocol$TopicCfg feedsProtocol$TopicCfg = (FeedsProtocol$TopicCfg) list.get(0);
            e eVar = new e();
            videoData.f252704j0 = eVar;
            eVar.d(feedsProtocol$TopicCfg.jump_url.get());
            videoData.f252704j0.e(feedsProtocol$TopicCfg.topic_name.get());
            videoData.f252704j0.c(feedsProtocol$TopicCfg.topic_desc.get());
            videoData.f252704j0.f(feedsProtocol$TopicCfg.topic_parti_num.get());
            videoData.f252704j0.g(feedsProtocol$TopicCfg.topic_pic_url.get());
            videoData.f252704j0.h(feedsProtocol$TopicCfg.topic_tag.get());
            videoData.f252704j0.i(feedsProtocol$TopicCfg.topic_type.get());
        }
        return videoData;
    }
}
