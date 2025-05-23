package com.qzone.reborn.albumx.qzone.local;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/j;", "Lia/d;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "recommend", "", "b", "data", "", "a", "", "recommends", "", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "getCanShowUpdateFlagMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "canShowUpdateFlagMap", "getShowHistoryInfos", "showHistoryInfos", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j implements ia.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<RFWClassifyInfo, Long> canShowUpdateFlagMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<RFWClassifyInfo, String> showHistoryInfos = new ConcurrentHashMap<>();

    private final String b(RFWUploadRecommendInfo recommend) {
        return "qz_local_recommend_config_last_update" + recommend.getClassifyInfo().getClassifyId() + recommend.getClassifyInfo().getSubClassifyId();
    }

    @Override // ia.d
    public boolean a(RFWUploadRecommendInfo data) {
        List split$default;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.canShowUpdateFlagMap.containsKey(data.getClassifyInfo())) {
            return true;
        }
        String str = this.showHistoryInfos.get(data.getClassifyInfo());
        if (str == null) {
            str = com.qzone.reborn.util.i.b().j(b(data), "");
            if (str == null) {
                str = "";
            }
            this.showHistoryInfos.put(data.getClassifyInfo(), str);
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            return false;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) split$default.get(0));
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        int parseInt = Integer.parseInt((String) split$default.get(1));
        if (longValue == 0 || parseInt == 0 || !RFWRecommendDateUtils.isDifferentDay(longValue, data.getLastScanTime()) || data.getRecommendCount() <= parseInt) {
            return false;
        }
        RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[canShowUpdateFlag] add show type:" + data);
        this.canShowUpdateFlagMap.put(data.getClassifyInfo(), Long.valueOf(longValue));
        return true;
    }

    public final void c(List<RFWUploadRecommendInfo> recommends) {
        Intrinsics.checkNotNullParameter(recommends, "recommends");
        long currentTimeMillis = System.currentTimeMillis();
        for (RFWUploadRecommendInfo rFWUploadRecommendInfo : recommends) {
            RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "[onRecommendInfoShow] " + rFWUploadRecommendInfo + "\uff0clastScanTime:" + rFWUploadRecommendInfo.getLastScanTime() + ",count:" + rFWUploadRecommendInfo.getRecommendCount());
            long lastScanTime = rFWUploadRecommendInfo.getLastScanTime();
            int recommendCount = rFWUploadRecommendInfo.getRecommendCount();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(lastScanTime);
            sb5.append("_");
            sb5.append(recommendCount);
            String sb6 = sb5.toString();
            com.qzone.reborn.util.i.b().r(b(rFWUploadRecommendInfo), sb6);
            this.showHistoryInfos.put(rFWUploadRecommendInfo.getClassifyInfo(), sb6);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.DEV, "[onRecommendInfoShow] cost" + currentTimeMillis2);
    }
}
