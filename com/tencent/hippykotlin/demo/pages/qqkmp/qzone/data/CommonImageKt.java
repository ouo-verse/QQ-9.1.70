package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicSpecUrlEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonImageKt {
    public static final CommonImage toCommon(StImage stImage) {
        int collectionSizeOrDefault;
        if (stImage == null) {
            return null;
        }
        CommonImage commonImage = new CommonImage();
        commonImage.setName(stImage.name);
        commonImage.setSloc(stImage.sloc);
        commonImage.setLloc(stImage.lloc);
        List<StPicSpecUrlEntry> list = stImage.photoUrl;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonPicSpecUrlEntryKt.toCommon((StPicSpecUrlEntry) it.next()));
        }
        commonImage.setPhotoUrl(arrayList);
        commonImage.setDefaultUrl(CommonPicUrlKt.toCommon(stImage.defaultUrl));
        Boolean bool = stImage.isGif;
        commonImage.setGif(bool != null ? bool.booleanValue() : false);
        commonImage.setType(stImage.type);
        Boolean bool2 = stImage.hasRaw;
        commonImage.setHasRaw(bool2 != null ? bool2.booleanValue() : false);
        return commonImage;
    }

    public static final StImage toPb(CommonImage commonImage) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonImage == null) {
            return null;
        }
        String name = commonImage.getName();
        String sloc = commonImage.getSloc();
        String lloc = commonImage.getLloc();
        List<CommonPicSpecUrlEntry> photoUrl = commonImage.getPhotoUrl();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(photoUrl, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = photoUrl.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonPicSpecUrlEntryKt.toPb((CommonPicSpecUrlEntry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        CommonPicUrl defaultUrl = commonImage.getDefaultUrl();
        return new StImage(name, sloc, lloc, mutableList, defaultUrl != null ? CommonPicUrlKt.toPb(defaultUrl) : null, Boolean.valueOf(commonImage.getIsGif()), commonImage.getType(), Boolean.valueOf(commonImage.getHasRaw()));
    }
}
