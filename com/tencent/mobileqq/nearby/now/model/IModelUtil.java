package com.tencent.mobileqq.nearby.now.model;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IModelUtil extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
    }

    int getFeedsProtocolMediaInfoTextFeeds();

    VideoData parseImageData(int i3, List<Object> list, Object obj, ArrayList<VideoData> arrayList);

    VideoData parseShortVideoData(int i3, List<Object> list, Object obj, ArrayList<VideoData> arrayList);

    void parseTextFeeds(int i3, List<Object> list, Object obj, ArrayList<VideoData> arrayList);

    VideoData parseTopicInfoToVideoData(List<Object> list, VideoData videoData);
}
