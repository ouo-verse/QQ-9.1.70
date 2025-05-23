package com.tencent.biz.qqcircle.tedgers2.bean;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.tedgers2.bean.pb.TEdgeItem$Item;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.proto.TEdgeCommon$MapEntry;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import seal.SealEdgeComputing$ClientItemInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSEdgeItem extends EdgeItem {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_CATE_ID = "cateId";
    public static final String KEY_EXTEND = "extend";
    public static final String KEY_PRE_RECOMMEND_SCORE = "preRecommendScore";
    private static final String KEY_REQ_ID = "KEY_REQ_ID";
    public static final String KEY_SUB_CATE_ID = "subCateId";
    public static final String KEY_VIDEO_TIME = "videoTime";
    private static final String TAG = "TEDGEQFS_TEdgeItem";
    private final TEdgeItem$Item mEdgeItem;
    private b mFeedBlockData;
    private long mTimeStamp;

    public QFSEdgeItem(b bVar, int i3) {
        this.mFeedBlockData = bVar;
        this.mEdgeItem = convertData(bVar, i3);
    }

    private static TEdgeItem$Item convertData(b bVar, int i3) {
        int i16;
        TEdgeItem$Item tEdgeItem$Item = new TEdgeItem$Item();
        if (bVar != null && bVar.g() != null) {
            SealEdgeComputing$ClientItemInfo sealEdgeComputing$ClientItemInfo = new SealEdgeComputing$ClientItemInfo();
            try {
                FeedCloudMeta$StFeed g16 = bVar.g();
                sealEdgeComputing$ClientItemInfo.mergeFrom(g16.recomInfo.clientSealData.get().toByteArray());
                tEdgeItem$Item.item_id.set(g16.f398449id.get());
                if (bVar.g().feedType.get() == 4) {
                    PBEnumField pBEnumField = tEdgeItem$Item.item_type;
                    if (bVar.g().iscachedAdsFeeds.get()) {
                        i16 = 3;
                    } else {
                        i16 = 1;
                    }
                    pBEnumField.set(i16);
                } else {
                    tEdgeItem$Item.item_type.set(0);
                }
                tEdgeItem$Item.item_source.set(i3);
                tEdgeItem$Item.category.set(sealEdgeComputing$ClientItemInfo.cate_name.get());
                tEdgeItem$Item.sub_category.set(sealEdgeComputing$ClientItemInfo.sub_cate_name.get());
                tEdgeItem$Item.physical_duration.set(g16.video.duration.get());
                tEdgeItem$Item.attributes.get().add(ic0.b.d(KEY_EXTEND, sealEdgeComputing$ClientItemInfo.extend.get()));
                tEdgeItem$Item.attributes.get().add(ic0.b.d(KEY_AUTHOR_ID, g16.poster.f398463id.get()));
                tEdgeItem$Item.attributes.get().add(ic0.b.d(KEY_PRE_RECOMMEND_SCORE, String.valueOf(sealEdgeComputing$ClientItemInfo.seal_score.get())));
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "convertData error:" + e16);
            }
            return tEdgeItem$Item;
        }
        QLog.e(TAG, 1, "[convertData] feedBlockData is null");
        return tEdgeItem$Item;
    }

    public String getClintRecommendTrace() {
        TEdgeItem$Item tEdgeItem$Item = this.mEdgeItem;
        if (tEdgeItem$Item == null) {
            return "";
        }
        List<TEdgeCommon$MapEntry> list = tEdgeItem$Item.attributes.get();
        for (int i3 = 0; i3 < list.size(); i3++) {
            TEdgeCommon$MapEntry tEdgeCommon$MapEntry = list.get(i3);
            if (tEdgeCommon$MapEntry != null && TextUtils.equals(tEdgeCommon$MapEntry.key.get(), KEY_EXTEND)) {
                return tEdgeCommon$MapEntry.value.get();
            }
        }
        return "";
    }

    public b getFeedBlockData() {
        return this.mFeedBlockData;
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeItem
    public String getItemID() {
        return this.mEdgeItem.item_id.get();
    }

    public TEdgeItem$Item getItemInfo() {
        return this.mEdgeItem;
    }

    public String getRecommendTrace() {
        b bVar = this.mFeedBlockData;
        if (bVar == null) {
            return "";
        }
        return bVar.g().recomInfo.recomTrace.get();
    }

    public String getReqId() {
        b bVar = this.mFeedBlockData;
        if (bVar == null) {
            return null;
        }
        return bVar.f();
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void plantRankMark(String str, String str2) {
        b bVar = this.mFeedBlockData;
        if (bVar == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        this.mFeedBlockData.n(str);
        String str3 = g16.recomInfo.recomTrace.get();
        if (!str3.contains(str2)) {
            this.mFeedBlockData.g().recomInfo.recomTrace.set(str3 + ContainerUtils.FIELD_DELIMITER + str2);
        }
    }

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public byte[] readBussinessData() {
        return this.mEdgeItem.toByteArray();
    }

    public void setFeedBlockData(b bVar) {
        this.mFeedBlockData = bVar;
    }

    public void setTimeStamp(long j3) {
        this.mTimeStamp = j3;
    }

    public QFSEdgeItem(TEdgeItem$Item tEdgeItem$Item) {
        this.mEdgeItem = tEdgeItem$Item;
    }
}
