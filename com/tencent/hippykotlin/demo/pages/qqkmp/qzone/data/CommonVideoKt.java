package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StVideo;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonVideoKt {
    public static final CommonVideo toCommon(StVideo stVideo) {
        int collectionSizeOrDefault;
        if (stVideo == null) {
            return null;
        }
        CommonVideo commonVideo = new CommonVideo();
        commonVideo.setId(stVideo.id);
        commonVideo.setUrl(stVideo.url);
        commonVideo.setCover(CommonImageKt.toCommon(stVideo.cover));
        Integer num = stVideo.width;
        commonVideo.setWidth(num != null ? num.intValue() : 0);
        Integer num2 = stVideo.height;
        commonVideo.setHeight(num2 != null ? num2.intValue() : 0);
        Long l3 = stVideo.videoTime;
        commonVideo.setVideoTime(l3 != null ? l3.longValue() : 0L);
        List<StPicSpecUrlEntry> list = stVideo.videoUrl;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonPicSpecUrlEntryKt.toCommon((StPicSpecUrlEntry) it.next()));
        }
        commonVideo.setVideoUrl(arrayList);
        Long l16 = stVideo.size;
        commonVideo.setSize(l16 != null ? l16.longValue() : 0L);
        Boolean bool = stVideo.hasRaw;
        commonVideo.setHasRaw(bool != null ? bool.booleanValue() : false);
        return commonVideo;
    }

    public static final StVideo toPb(CommonVideo commonVideo) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonVideo == null) {
            return null;
        }
        String id5 = commonVideo.getId();
        String url = commonVideo.getUrl();
        StImage pb5 = CommonImageKt.toPb(commonVideo.getCover());
        Integer valueOf = Integer.valueOf(commonVideo.getWidth());
        Integer valueOf2 = Integer.valueOf(commonVideo.getHeight());
        Long valueOf3 = Long.valueOf(commonVideo.getVideoTime());
        List<CommonPicSpecUrlEntry> videoUrl = commonVideo.getVideoUrl();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(videoUrl, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = videoUrl.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonPicSpecUrlEntryKt.toPb((CommonPicSpecUrlEntry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StVideo(id5, url, pb5, valueOf, valueOf2, valueOf3, mutableList, Long.valueOf(commonVideo.getSize()), Boolean.valueOf(commonVideo.getHasRaw()));
    }
}
