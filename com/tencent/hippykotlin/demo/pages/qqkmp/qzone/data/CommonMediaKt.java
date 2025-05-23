package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonMediaKt {
    public static final CommonMedia toCommon(StMedia stMedia) {
        int collectionSizeOrDefault;
        CommonMedia commonMedia = new CommonMedia();
        commonMedia.setType(stMedia.type);
        commonMedia.setImage(CommonImageKt.toCommon(stMedia.image));
        commonMedia.setVideo(CommonVideoKt.toCommon(stMedia.video));
        commonMedia.setDesc(stMedia.desc);
        commonMedia.setLbs(CommonLBSKt.toCommon(stMedia.lbs));
        commonMedia.setUploader(stMedia.uploader);
        Long l3 = stMedia.batchId;
        commonMedia.setBatchId(l3 != null ? l3.longValue() : 0L);
        Long l16 = stMedia.uploadTime;
        commonMedia.setUploadTime(l16 != null ? l16.longValue() : 0L);
        Integer num = stMedia.uploadOrder;
        commonMedia.setUploadOrder(num != null ? num.intValue() : 0);
        commonMedia.setLike(CommonMediaLikeKt.toCommon(stMedia.like));
        commonMedia.setComment(CommonMediaCommentKt.toCommon(stMedia.comment));
        commonMedia.setUploadUser(CommonUserKt.toCommon(stMedia.uploadUser));
        List<Entry> list = stMedia.ext;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonEntryKt.toCommon((Entry) it.next()));
        }
        commonMedia.setExt(arrayList);
        Long l17 = stMedia.shootTime;
        commonMedia.setShootTime(l17 != null ? l17.longValue() : 0L);
        Long l18 = stMedia.linkId;
        commonMedia.setLinkId(l18 != null ? l18.longValue() : 0L);
        commonMedia.setOpMask(stMedia.opMask);
        commonMedia.setLbsSource(stMedia.lbsSource);
        Boolean bool = stMedia.isLivePhoto;
        commonMedia.setLivePhoto(bool != null ? bool.booleanValue() : false);
        return commonMedia;
    }

    public static final StMedia toPb(CommonMedia commonMedia) {
        int collectionSizeOrDefault;
        List mutableList;
        Integer type = commonMedia.getType();
        StImage pb5 = CommonImageKt.toPb(commonMedia.getImage());
        StVideo pb6 = CommonVideoKt.toPb(commonMedia.getVideo());
        String desc = commonMedia.getDesc();
        StLBS pb7 = CommonLBSKt.toPb(commonMedia.getLbs());
        String uploader = commonMedia.getUploader();
        Long valueOf = Long.valueOf(commonMedia.getBatchId());
        Long valueOf2 = Long.valueOf(commonMedia.getUploadTime());
        Integer valueOf3 = Integer.valueOf(commonMedia.getUploadOrder());
        StMediaLike pb8 = CommonMediaLikeKt.toPb(commonMedia.getLike());
        StMediaComment pb9 = CommonMediaCommentKt.toPb(commonMedia.getComment());
        StUser pb10 = CommonUserKt.toPb(commonMedia.getUploadUser());
        List<CommonEntry> ext = commonMedia.getExt();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(ext, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = ext.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonEntryKt.toPb((CommonEntry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StMedia(type, pb5, pb6, desc, pb7, uploader, valueOf, valueOf2, valueOf3, pb8, pb9, pb10, mutableList, Long.valueOf(commonMedia.getShootTime()), Long.valueOf(commonMedia.getLinkId()), commonMedia.getOpMask(), commonMedia.getLbsSource(), Boolean.valueOf(commonMedia.getIsLivePhoto()));
    }
}
