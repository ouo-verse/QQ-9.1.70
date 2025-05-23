package com.qzone.publish.business.publishqueue.intimate;

import com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams;
import com.qzone.publish.business.model.intimate.IntimateUploadMediaInfo;
import com.qzone.publish.business.model.intimate.IntimateUploadMediaResult;
import com.qzone.publish.business.model.intimate.IntimateUploadTaskBatchInfo;
import com.qzone.publish.business.model.intimate.IntimateUploadTaskGeneralInfo;
import com.qzone.publish.business.model.intimate.PublishStage;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J@\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bJ\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/publish/business/publishqueue/intimate/c;", "", "", "d", "f", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "params", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskBatchInfo;", "a", "", "batchId", "", "", "", "resultBoolMap", "Lqzone/QZoneBaseMeta$StMedia;", "resultMap", "b", "", "originalPathList", "e", "Lcom/qzone/publish/business/model/intimate/PublishStage;", "stage", "g", "c", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskGeneralInfo;", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskGeneralInfo;", "taskGeneralInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IntimateUploadTaskGeneralInfo taskGeneralInfo;

    public c() {
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x003a, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d() {
        IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo;
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "restoreGeneralInfo, start ");
        byte[] e16 = com.qzone.reborn.util.i.b().e("intimate_upload_task_general_info", null);
        if (e16 != null) {
            intimateUploadTaskGeneralInfo = IntimateUploadTaskGeneralInfo.INSTANCE.a(e16);
            if (intimateUploadTaskGeneralInfo != null) {
                RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "restoreGeneralInfo, from cache , ret:" + intimateUploadTaskGeneralInfo);
            } else {
                intimateUploadTaskGeneralInfo = null;
            }
        }
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "restoreGeneralInfo, from default ");
        intimateUploadTaskGeneralInfo = new IntimateUploadTaskGeneralInfo(null, 1, null);
        this.taskGeneralInfo = intimateUploadTaskGeneralInfo;
    }

    private final void f() {
        IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (intimateUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            intimateUploadTaskGeneralInfo = null;
        }
        RFWLog.d("IntimateUploadTaskBatchUtil", RFWLog.DEV, "updateGeneralInfo, generalInfo:" + intimateUploadTaskGeneralInfo);
        byte[] bytes = intimateUploadTaskGeneralInfo.toBytes();
        if (bytes != null) {
            com.qzone.reborn.util.i.b().m("intimate_upload_task_general_info", bytes);
        }
    }

    public final IntimateUploadTaskBatchInfo a(IntimateUploadAlbumParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "addBatchInfo, params:" + params);
        IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (intimateUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            intimateUploadTaskGeneralInfo = null;
        }
        ConcurrentHashMap<Long, IntimateUploadTaskBatchInfo> batchInfoMap = intimateUploadTaskGeneralInfo.getBatchInfoMap();
        Long valueOf = Long.valueOf(params.getBatchId());
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo = batchInfoMap.get(valueOf);
        if (intimateUploadTaskBatchInfo == null) {
            RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "addBatchInfo, put default batch info ");
            intimateUploadTaskBatchInfo = new IntimateUploadTaskBatchInfo(null, null, null, null, 15, null);
            IntimateUploadTaskBatchInfo putIfAbsent = batchInfoMap.putIfAbsent(valueOf, intimateUploadTaskBatchInfo);
            if (putIfAbsent != null) {
                intimateUploadTaskBatchInfo = putIfAbsent;
            }
        }
        IntimateUploadTaskBatchInfo batchInfo = intimateUploadTaskBatchInfo;
        batchInfo.setUploadParams(params);
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "addBatchInfo, batchInfo:" + batchInfo);
        f();
        Intrinsics.checkNotNullExpressionValue(batchInfo, "batchInfo");
        return IntimateUploadTaskBatchInfo.copy$default(batchInfo, null, null, null, null, 15, null);
    }

    public final IntimateUploadTaskBatchInfo b(long batchId, Map<String, Boolean> resultBoolMap, Map<String, QZoneBaseMeta$StMedia> resultMap) {
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo;
        int mapCapacity;
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "appendBatchInfo, batchId:" + batchId + ", resultBoolMap:" + resultBoolMap + ", resultMap:" + resultMap);
        IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (intimateUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            intimateUploadTaskGeneralInfo = null;
        }
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo2 = intimateUploadTaskGeneralInfo.getBatchInfoMap().get(Long.valueOf(batchId));
        if (intimateUploadTaskBatchInfo2 != null) {
            if (resultBoolMap != null) {
                intimateUploadTaskBatchInfo2.getUploadResultBoolMap().putAll(resultBoolMap);
            }
            if (resultMap != null) {
                ConcurrentHashMap<String, IntimateUploadMediaResult> uploadResultMap = intimateUploadTaskBatchInfo2.getUploadResultMap();
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(resultMap.size());
                LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                Iterator<T> it = resultMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), IntimateUploadMediaResult.INSTANCE.a((QZoneBaseMeta$StMedia) entry.getValue()));
                }
                uploadResultMap.putAll(linkedHashMap);
            }
            intimateUploadTaskBatchInfo = intimateUploadTaskBatchInfo2;
        } else {
            intimateUploadTaskBatchInfo = null;
        }
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "appendBatchInfo, batchInfo:" + intimateUploadTaskBatchInfo);
        if (intimateUploadTaskBatchInfo == null) {
            return null;
        }
        f();
        return IntimateUploadTaskBatchInfo.copy$default(intimateUploadTaskBatchInfo, null, null, null, null, 15, null);
    }

    public final void c(long batchId) {
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "removeBatchInfo, batchId:" + batchId);
        IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (intimateUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            intimateUploadTaskGeneralInfo = null;
        }
        intimateUploadTaskGeneralInfo.getBatchInfoMap().remove(Long.valueOf(batchId));
        f();
    }

    public final IntimateUploadTaskBatchInfo e(long batchId, List<String> originalPathList) {
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo;
        Set set;
        Intrinsics.checkNotNullParameter(originalPathList, "originalPathList");
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "subtractBatchInfo, batchId:" + batchId + ", originalPathList:" + originalPathList);
        IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (intimateUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            intimateUploadTaskGeneralInfo = null;
        }
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo2 = intimateUploadTaskGeneralInfo.getBatchInfoMap().get(Long.valueOf(batchId));
        if (intimateUploadTaskBatchInfo2 != null) {
            CopyOnWriteArrayList<IntimateUploadMediaInfo> localMediaList = intimateUploadTaskBatchInfo2.getUploadParams().getLocalMediaList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : localMediaList) {
                if (originalPathList.contains(((IntimateUploadMediaInfo) obj).getOriginalPath())) {
                    arrayList.add(obj);
                }
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            localMediaList.removeAll(set);
            for (String str : originalPathList) {
                intimateUploadTaskBatchInfo2.getUploadResultBoolMap().remove(str);
                intimateUploadTaskBatchInfo2.getUploadResultMap().remove(str);
            }
            intimateUploadTaskBatchInfo = intimateUploadTaskBatchInfo2;
        } else {
            intimateUploadTaskBatchInfo = null;
        }
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "subtractBatchInfo, batchInfo:" + intimateUploadTaskBatchInfo);
        if (intimateUploadTaskBatchInfo == null) {
            return null;
        }
        f();
        return IntimateUploadTaskBatchInfo.copy$default(intimateUploadTaskBatchInfo, null, null, null, null, 15, null);
    }

    public final IntimateUploadTaskBatchInfo g(long batchId, PublishStage stage) {
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo;
        Intrinsics.checkNotNullParameter(stage, "stage");
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "updatePublishStage, batchId:" + batchId + ", stage:" + stage);
        IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (intimateUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            intimateUploadTaskGeneralInfo = null;
        }
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo2 = intimateUploadTaskGeneralInfo.getBatchInfoMap().get(Long.valueOf(batchId));
        if (intimateUploadTaskBatchInfo2 != null) {
            intimateUploadTaskBatchInfo2.setPublishStage(stage);
            intimateUploadTaskBatchInfo = intimateUploadTaskBatchInfo2;
        } else {
            intimateUploadTaskBatchInfo = null;
        }
        RFWLog.i("IntimateUploadTaskBatchUtil", RFWLog.USR, "updatePublishStage, batchInfo:" + intimateUploadTaskBatchInfo);
        if (intimateUploadTaskBatchInfo == null) {
            return null;
        }
        if (intimateUploadTaskBatchInfo.isPublishEnd()) {
            f();
        }
        return IntimateUploadTaskBatchInfo.copy$default(intimateUploadTaskBatchInfo, null, null, null, null, 15, null);
    }
}
