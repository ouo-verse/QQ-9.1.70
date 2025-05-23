package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellMediaKt {
    public static final CommonCellMedia toCommon(StFeedCellMedia stFeedCellMedia) {
        int collectionSizeOrDefault;
        if (stFeedCellMedia == null) {
            return null;
        }
        CommonCellMedia commonCellMedia = new CommonCellMedia();
        List<StMedia> list = stFeedCellMedia.mediaItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonMediaKt.toCommon((StMedia) it.next()));
        }
        commonCellMedia.setMediaItems(arrayList);
        commonCellMedia.setAlbumName(stFeedCellMedia.albumName);
        commonCellMedia.setAlbumId(stFeedCellMedia.albumId);
        Integer num = stFeedCellMedia.uploadNum;
        commonCellMedia.setUploadNum(num != null ? num.intValue() : 0);
        Long l3 = stFeedCellMedia.batchId;
        commonCellMedia.setBatchId(l3 != null ? l3.longValue() : 0L);
        commonCellMedia.setAlbumCover(CommonImageKt.toCommon(stFeedCellMedia.albumCover));
        Integer num2 = stFeedCellMedia.albumUploadNum;
        commonCellMedia.setAlbumUploadNum(num2 != null ? num2.intValue() : 0);
        Boolean bool = stFeedCellMedia.longPicsBrowsingMode;
        commonCellMedia.setLongPicsBrowsingMode(bool != null ? bool.booleanValue() : false);
        return commonCellMedia;
    }

    public static final StFeedCellMedia toPb(CommonCellMedia commonCellMedia) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellMedia == null) {
            return null;
        }
        List<CommonMedia> mediaItems = commonCellMedia.getMediaItems();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaItems, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = mediaItems.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonMediaKt.toPb((CommonMedia) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeedCellMedia(mutableList, commonCellMedia.getAlbumName(), commonCellMedia.getAlbumId(), Integer.valueOf(commonCellMedia.getUploadNum()), Long.valueOf(commonCellMedia.getBatchId()), CommonImageKt.toPb(commonCellMedia.getAlbumCover()), Integer.valueOf(commonCellMedia.getAlbumUploadNum()), Boolean.valueOf(commonCellMedia.getLongPicsBrowsingMode()));
    }
}
