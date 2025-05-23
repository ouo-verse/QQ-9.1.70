package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import c45.a;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BytesEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellCommon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellCommon;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellCommonKt {
    public static final CommonCellCommon toCommon(StFeedCellCommon stFeedCellCommon) {
        int collectionSizeOrDefault;
        if (stFeedCellCommon == null) {
            return null;
        }
        CommonCellCommon commonCellCommon = new CommonCellCommon();
        Integer num = stFeedCellCommon.appId;
        commonCellCommon.setAppId(num != null ? num.intValue() : 0);
        Integer num2 = stFeedCellCommon.subId;
        commonCellCommon.setSubId(num2 != null ? num2.intValue() : 0);
        Long l3 = stFeedCellCommon.time;
        commonCellCommon.setTime(l3 != null ? l3.longValue() : 0L);
        commonCellCommon.setFeedId(stFeedCellCommon.feedId);
        commonCellCommon.setCurLikeKey(stFeedCellCommon.curLikeKey);
        commonCellCommon.setBizId(stFeedCellCommon.bizId);
        commonCellCommon.setClientKey(stFeedCellCommon.clientKey);
        List<BytesEntry> list = stFeedCellCommon.extendInfo;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonBytesEntryKt.toCommon((BytesEntry) it.next()));
        }
        commonCellCommon.setExtendInfo(arrayList);
        commonCellCommon.setUgckey(stFeedCellCommon.ugckey);
        commonCellCommon.setUnusedStr(stFeedCellCommon.unusedStr);
        commonCellCommon.setFeedType(stFeedCellCommon.feedType);
        commonCellCommon.setFeedSubType(stFeedCellCommon.feedSubType);
        commonCellCommon.setExtInfo(stFeedCellCommon.extInfo);
        commonCellCommon.setUnionId(CommonUnionIDKt.toCommon(stFeedCellCommon.unionId));
        Integer num3 = stFeedCellCommon.feedBizType;
        commonCellCommon.setFeedBizType(num3 != null ? num3.intValue() : 0);
        Integer num4 = stFeedCellCommon.featureFlag;
        commonCellCommon.setFeatureFlag(num4 != null ? num4.intValue() : 0);
        Integer num5 = stFeedCellCommon.operateMask;
        commonCellCommon.setOperateMask(num5 != null ? num5.intValue() : 0);
        Long l16 = stFeedCellCommon.utime;
        commonCellCommon.setUtime(l16 != null ? l16.longValue() : 0L);
        long j3 = stFeedCellCommon.selfDeleteTime;
        if (j3 == null) {
            j3 = 0L;
        }
        commonCellCommon.setSelfDeleteTime(j3);
        commonCellCommon.setCellId(stFeedCellCommon.cellId);
        return commonCellCommon;
    }

    public static final StFeedCellCommon toPb(CommonCellCommon commonCellCommon) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellCommon == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(commonCellCommon.getAppId());
        Integer valueOf2 = Integer.valueOf(commonCellCommon.getSubId());
        Long valueOf3 = Long.valueOf(commonCellCommon.getTime());
        String feedId = commonCellCommon.getFeedId();
        String curLikeKey = commonCellCommon.getCurLikeKey();
        Integer bizId = commonCellCommon.getBizId();
        String clientKey = commonCellCommon.getClientKey();
        List<CommonBytesEntry> extendInfo = commonCellCommon.getExtendInfo();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(extendInfo, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = extendInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonBytesEntryKt.toPb((CommonBytesEntry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        String ugckey = commonCellCommon.getUgckey();
        String unusedStr = commonCellCommon.getUnusedStr();
        Integer feedType = commonCellCommon.getFeedType();
        Integer feedSubType = commonCellCommon.getFeedSubType();
        a extInfo = commonCellCommon.getExtInfo();
        CommonUnionID unionId = commonCellCommon.getUnionId();
        return new StFeedCellCommon(valueOf, valueOf2, valueOf3, feedId, curLikeKey, bizId, clientKey, mutableList, ugckey, unusedStr, null, feedType, feedSubType, extInfo, unionId != null ? CommonUnionIDKt.toPb(unionId) : null, Integer.valueOf(commonCellCommon.getFeedBizType()), Integer.valueOf(commonCellCommon.getFeatureFlag()), Integer.valueOf(commonCellCommon.getOperateMask()), Long.valueOf(commonCellCommon.getUtime()), commonCellCommon.getSelfDeleteTime(), commonCellCommon.getCellId(), 1024, null);
    }
}
