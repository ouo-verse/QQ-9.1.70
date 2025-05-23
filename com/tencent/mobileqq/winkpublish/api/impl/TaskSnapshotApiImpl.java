package com.tencent.mobileqq.winkpublish.api.impl;

import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.export.model.CancelSnapshotBean;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkpublish.util.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J8\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u001c\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002J,\u0010\u0019\u001a\u00020\u00182\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0017J\b\u0010#\u001a\u00020\u0018H\u0016R\u001b\u0010'\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010,R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010/R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00102R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00104R\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/impl/TaskSnapshotApiImpl;", "Lcom/tencent/mobileqq/winkpublish/api/ITaskSnapshotApi;", "", "key", "", "computeKeyCost", "feat", "getFeatCostMs", "", "exportType", "videoDurationMs", "exportProgress", "uploadProgress", "", "", "judgeCancelReason", "", "map", "mapToJson", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "localMediaInfo", "durationUs", "", "saveOriginalMediaInfo", "onFeatStart", "type", "onUpdateExportType", "recSize", "totalSize", "onUpdateUploadInfo", "onFeatEnd", "progressText", "getSnapshotInfo", QCircleLpReportDc05507.KEY_CLEAR, "", "isSwitchOn$delegate", "Lkotlin/Lazy;", "isSwitchOn", "()Z", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv$delegate", "getMmkv", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv", "featKeyMap", "Ljava/util/Map;", "endFeatCostMap", "notEndFeatCostMap", "I", "exportStartTimeMs", "J", "uploadRecFileSize", "uploadTotalFileSize", "currentFeat", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TaskSnapshotApiImpl implements ITaskSnapshotApi {
    private static final String KEY = "CANCEL_TASK_SNAPSHOT";
    private static final String REASON_EXPORT = "export";
    private static final String REASON_UNKNOWN = "unknown";
    private static final String REASON_UPLOAD = "upload";
    private static final String REASON_UWE = "uwe";
    private static final String TAG = "TaskSnapshotApiImpl";
    private String currentFeat;
    private final Map<String, Long> endFeatCostMap;
    private long exportStartTimeMs;
    private int exportType;
    private final Map<String, Long> featKeyMap;

    /* renamed from: isSwitchOn$delegate, reason: from kotlin metadata */
    private final Lazy isSwitchOn;

    /* renamed from: mmkv$delegate, reason: from kotlin metadata */
    private final Lazy mmkv;
    private final Map<String, Long> notEndFeatCostMap;
    private long uploadRecFileSize;
    private long uploadTotalFileSize;

    public TaskSnapshotApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.winkpublish.api.impl.TaskSnapshotApiImpl$isSwitchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_enable_get_cancel_snapshot", true));
            }
        });
        this.isSwitchOn = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.winkpublish.api.impl.TaskSnapshotApiImpl$mmkv$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(BaseApplication.getContext(), "QCIRCLE_MMKV_COMMON");
            }
        });
        this.mmkv = lazy2;
        this.featKeyMap = new LinkedHashMap();
        this.endFeatCostMap = new LinkedHashMap();
        this.notEndFeatCostMap = new LinkedHashMap();
        this.exportType = -1;
        this.currentFeat = "";
    }

    private final long computeKeyCost(String key) {
        Long remove;
        if (!this.featKeyMap.containsKey(key) || (remove = this.featKeyMap.remove(key)) == null) {
            return 0L;
        }
        return System.currentTimeMillis() - remove.longValue();
    }

    private final long getFeatCostMs(String feat) {
        Long l3;
        if (this.endFeatCostMap.containsKey(feat)) {
            Long l16 = this.endFeatCostMap.get(feat);
            if (l16 != null) {
                return l16.longValue();
            }
            return 0L;
        }
        if (!this.notEndFeatCostMap.containsKey(feat) || (l3 = this.notEndFeatCostMap.get(feat)) == null) {
            return 0L;
        }
        return l3.longValue();
    }

    private final MMKVOptionEntity getMmkv() {
        return (MMKVOptionEntity) this.mmkv.getValue();
    }

    private final boolean isSwitchOn() {
        return ((Boolean) this.isSwitchOn.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<Object, Object> judgeCancelReason(int exportType, long videoDurationMs, int exportProgress, int uploadProgress) {
        String str;
        long j3;
        Object obj;
        String str2;
        QLog.i(TAG, 1, "judgeCancelReason: exportType:" + exportType + "\uff0cvideoDurationMs:" + videoDurationMs + ", exportProgress:" + exportProgress + ", uploadProgress:" + uploadProgress);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        str = "unknown";
        if (this.notEndFeatCostMap.containsKey(ITaskSnapshotApi.FEAT_VIDEO_EXPORT_UPLOAD)) {
            double longValue = (this.notEndFeatCostMap.get(ITaskSnapshotApi.FEAT_VIDEO_EXPORT_UPLOAD) != null ? r6.longValue() : 0L) - ((e.f327447a.a(exportType, videoDurationMs) * exportProgress) * 0.01d);
            str = longValue > 0.0d ? REASON_UWE : "unknown";
            linkedHashMap.put("uweCostDiff", String.valueOf(longValue));
        } else if (this.notEndFeatCostMap.containsKey(ITaskSnapshotApi.FEAT_WAIT_VIDEO_EXPORT)) {
            double longValue2 = (this.notEndFeatCostMap.get(ITaskSnapshotApi.FEAT_WAIT_VIDEO_EXPORT) != null ? r6.longValue() : 0L) - ((e.f327447a.a(exportType, videoDurationMs) * exportProgress) * 0.01d);
            str = longValue2 > 0.0d ? "export" : "unknown";
            linkedHashMap.put("exportCostDiff", String.valueOf(longValue2));
        } else if (this.notEndFeatCostMap.containsKey(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO)) {
            Long l3 = this.notEndFeatCostMap.get(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO);
            long longValue3 = l3 != null ? l3.longValue() : 0L;
            if (this.uploadRecFileSize > 0) {
                long j16 = this.uploadTotalFileSize;
                if (j16 > 0) {
                    long b16 = e.f327447a.b(j16);
                    long j17 = this.uploadRecFileSize;
                    obj = "exportCostDiff";
                    long j18 = j17 / this.uploadTotalFileSize;
                    j3 = 0;
                    if (longValue3 > 0) {
                        str2 = "unknown";
                        linkedHashMap.put("uploadSpeed", String.valueOf(j17 / longValue3));
                    } else {
                        str2 = "unknown";
                    }
                    Long.signum(b16);
                    long j19 = longValue3 - (b16 * j18);
                    str = j19 > 0 ? "upload" : str2;
                    linkedHashMap.put("uploadCostDiff", String.valueOf(j19));
                    if (this.endFeatCostMap.containsKey(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO)) {
                        Long l16 = this.endFeatCostMap.get(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO);
                        linkedHashMap.put(obj, String.valueOf((l16 != null ? l16.longValue() : j3) - e.f327447a.a(exportType, videoDurationMs)));
                    }
                }
            }
            j3 = 0;
            obj = "exportCostDiff";
            str = "upload";
            if (this.endFeatCostMap.containsKey(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO)) {
            }
        }
        linkedHashMap.put("reason", str);
        return linkedHashMap;
    }

    private final String mapToJson(Map<String, ? extends Object> map) {
        try {
            String jSONObject = new JSONObject(map).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(map).toString()");
            return jSONObject;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "mapToJson error:" + e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi
    public String getSnapshotInfo(String progressText, int exportProgress, int uploadProgress) {
        Intrinsics.checkNotNullParameter(progressText, "progressText");
        if (!isSwitchOn()) {
            return "";
        }
        CancelSnapshotBean cancelSnapshotBean = (CancelSnapshotBean) getMmkv().decodeParcelable(KEY, CancelSnapshotBean.class, new CancelSnapshotBean());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QuotaFileSystem.STAT_FILE_COUNT, String.valueOf(cancelSnapshotBean.getFileCount()));
        linkedHashMap.put("fileTotalDurationMs", String.valueOf(cancelSnapshotBean.getVideoTotalDurationMs()));
        for (Map.Entry<String, Long> entry : this.featKeyMap.entrySet()) {
            this.notEndFeatCostMap.put(entry.getKey(), Long.valueOf(System.currentTimeMillis() - entry.getValue().longValue()));
        }
        long currentTimeMillis = System.currentTimeMillis() - this.exportStartTimeMs;
        linkedHashMap.put("curFeat", this.currentFeat);
        linkedHashMap.put("startToCancelCostMs", String.valueOf(currentTimeMillis));
        linkedHashMap.put("progressText", progressText);
        linkedHashMap.put("exportProgress", String.valueOf(exportProgress));
        linkedHashMap.put("uploadProgress", String.valueOf(uploadProgress));
        if (getFeatCostMs(ITaskSnapshotApi.FEAT_WAIT_VIDEO_EXPORT) > 0) {
            linkedHashMap.put("exportCostMs", String.valueOf(getFeatCostMs(ITaskSnapshotApi.FEAT_WAIT_VIDEO_EXPORT)));
        }
        if (getFeatCostMs(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO) > 0) {
            linkedHashMap.put("uploadVideoCostMs", String.valueOf(getFeatCostMs(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO)));
        }
        if (getFeatCostMs(ITaskSnapshotApi.FEAT_VIDEO_EXPORT_UPLOAD) > 0) {
            linkedHashMap.put("uweCostMs", String.valueOf(getFeatCostMs(ITaskSnapshotApi.FEAT_VIDEO_EXPORT_UPLOAD)));
        }
        if (getFeatCostMs(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO_COVER) > 0) {
            linkedHashMap.put("uploadCoverCostMs", String.valueOf(getFeatCostMs(ITaskSnapshotApi.FEAT_UPLOAD_VIDEO_COVER)));
        }
        linkedHashMap.put("cancelJudgeReason", new JSONObject(judgeCancelReason(this.exportType, cancelSnapshotBean.getVideoTotalDurationMs(), exportProgress, uploadProgress)));
        return mapToJson(linkedHashMap);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi
    public void onFeatEnd(String feat) {
        Intrinsics.checkNotNullParameter(feat, "feat");
        if (isSwitchOn()) {
            QLog.i(TAG, 1, "onFeatEnd:" + feat);
            long computeKeyCost = computeKeyCost(feat);
            if (computeKeyCost > 0) {
                this.endFeatCostMap.put(feat, Long.valueOf(computeKeyCost));
            }
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi
    public void onFeatStart(String feat) {
        Intrinsics.checkNotNullParameter(feat, "feat");
        QLog.i(TAG, 1, "onFeatStart:" + feat);
        this.featKeyMap.put(feat, Long.valueOf(System.currentTimeMillis()));
        this.currentFeat = feat;
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi
    public void onUpdateExportType(int type) {
        QLog.i(TAG, 1, "onUpdateExportType " + type);
        this.exportType = type;
        this.exportStartTimeMs = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi
    public void onUpdateUploadInfo(long recSize, long totalSize) {
        this.uploadRecFileSize = recSize;
        this.uploadTotalFileSize = totalSize;
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi
    public void saveOriginalMediaInfo(ArrayList<LocalMediaInfo> localMediaInfo, long durationUs) {
        if (isSwitchOn()) {
            long j3 = durationUs / 1000;
            QLog.i(TAG, 1, "saveOriginalMediaInfo, durationMs:" + j3);
            int i3 = 0;
            if (localMediaInfo != null) {
                Iterator<T> it = localMediaInfo.iterator();
                while (it.hasNext()) {
                    if (((LocalMediaInfo) it.next()).mDuration > 0) {
                        i3++;
                    }
                }
            }
            CancelSnapshotBean cancelSnapshotBean = new CancelSnapshotBean();
            cancelSnapshotBean.e(j3);
            cancelSnapshotBean.c(i3);
            getMmkv().encodeParcelable(KEY, cancelSnapshotBean);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi
    public void clear() {
        QLog.i(TAG, 1, QCircleLpReportDc05507.KEY_CLEAR);
        this.featKeyMap.clear();
        this.endFeatCostMap.clear();
        this.notEndFeatCostMap.clear();
        this.exportType = -1;
        this.uploadRecFileSize = 0L;
        this.uploadTotalFileSize = 0L;
        this.currentFeat = "";
        getMmkv().removeKey(KEY);
    }
}
