package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StRichMsg;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonRichMsgKt {
    public static final CommonRichMsg toCommon(StRichMsg stRichMsg) {
        int collectionSizeOrDefault;
        CommonRichMsg commonRichMsg = new CommonRichMsg();
        commonRichMsg.setType(Integer.valueOf(stRichMsg.type));
        commonRichMsg.setContent(stRichMsg.content);
        commonRichMsg.setUid(stRichMsg.uid);
        commonRichMsg.setName(stRichMsg.name);
        Integer num = stRichMsg.who;
        commonRichMsg.setWho(num != null ? num.intValue() : 0);
        commonRichMsg.setUrl(stRichMsg.url);
        commonRichMsg.setUin(stRichMsg.uin);
        List<StMedia> list = stRichMsg.mediaItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonMediaKt.toCommon((StMedia) it.next()));
        }
        commonRichMsg.setMediaItems(arrayList);
        return commonRichMsg;
    }

    public static final StRichMsg toPb(CommonRichMsg commonRichMsg) {
        int collectionSizeOrDefault;
        List mutableList;
        Integer type = commonRichMsg.getType();
        int intValue = type != null ? type.intValue() : 0;
        String content = commonRichMsg.getContent();
        String uid = commonRichMsg.getUid();
        String name = commonRichMsg.getName();
        Integer valueOf = Integer.valueOf(commonRichMsg.getWho());
        String url = commonRichMsg.getUrl();
        String uin = commonRichMsg.getUin();
        List<CommonMedia> mediaItems = commonRichMsg.getMediaItems();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaItems, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = mediaItems.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonMediaKt.toPb((CommonMedia) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StRichMsg(intValue, content, uid, name, valueOf, url, uin, mutableList, null, 256, null);
    }
}
