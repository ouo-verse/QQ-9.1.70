package com.tencent.mobileqq.zplan.resource.api.data;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.zplan.resource.data.ZPlanUEResInfo;
import hv4.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001c\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\t\u0010\f\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/data/b;", "", "Lcom/tencent/mobileqq/zplan/resource/api/data/d;", "itemDownloadResult", "", "e", "", "", "Lcom/tencent/zplan/resource/data/ZPlanUEResInfo;", "b", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "c", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getUniqueId", "()Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "Lcom/tencent/mobileqq/zplan/resource/api/data/c;", "Ljava/util/List;", "()Ljava/util/List;", "downloadInfoList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "resultList", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/concurrent/CopyOnWriteArrayList;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.resource.api.data.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanResourceBatchDownloadResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uniqueId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ZPlanResourceDownloadTask> downloadInfoList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> resultList;

    public ZPlanResourceBatchDownloadResult(String uniqueId, List<ZPlanResourceDownloadTask> downloadInfoList, CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> resultList) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(downloadInfoList, "downloadInfoList");
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        this.uniqueId = uniqueId;
        this.downloadInfoList = downloadInfoList;
        this.resultList = resultList;
    }

    public final List<ZPlanResourceDownloadTask> a() {
        return this.downloadInfoList;
    }

    public final Map<String, ZPlanUEResInfo> b() {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> copyOnWriteArrayList = this.resultList;
        ArrayList<ZPlanResourceItemDownloadResult> arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            if (((ZPlanResourceItemDownloadResult) obj).getIsSuccess()) {
                arrayList.add(obj);
            }
        }
        for (ZPlanResourceItemDownloadResult zPlanResourceItemDownloadResult : arrayList) {
            s directUrlResource = zPlanResourceItemDownloadResult.getDownloadTaskInfo().getDirectUrlResource();
            if (directUrlResource != null) {
                String str3 = directUrlResource.f406494b;
                Intrinsics.checkNotNullExpressionValue(str3, "urlResource.path");
                ZPlanResDownloadUrlRsp fullUrlInfo = zPlanResourceItemDownloadResult.getFullUrlInfo();
                if (fullUrlInfo == null || (str = fullUrlInfo.getFullUrl()) == null) {
                    str = directUrlResource.f406493a;
                }
                String str4 = "";
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "downloadResult.fullUrlIn\u2026 ?: urlResource.url ?: \"\"");
                }
                String fileSavePath = zPlanResourceItemDownloadResult.getFileSavePath();
                if (fileSavePath == null) {
                    fileSavePath = "";
                }
                ZPlanResDownloadUrlRsp fullUrlInfo2 = zPlanResourceItemDownloadResult.getFullUrlInfo();
                if (fullUrlInfo2 == null || (str2 = fullUrlInfo2.getMd5()) == null) {
                    str2 = directUrlResource.f406495c;
                }
                if (str2 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "downloadResult.fullUrlIn\u2026 ?: urlResource.md5 ?: \"\"");
                    str4 = str2;
                }
                ZPlanUEResInfo zPlanUEResInfo = new ZPlanUEResInfo(str3, str, fileSavePath, str4);
                String str5 = directUrlResource.f406494b;
                Intrinsics.checkNotNullExpressionValue(str5, "urlResource.path");
                hashMap.put(str5, zPlanUEResInfo);
            }
        }
        return hashMap;
    }

    public final ZPlanResHubResultInfo c() {
        CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> copyOnWriteArrayList = this.resultList;
        ArrayList<ZPlanResourceItemDownloadResult> arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            if (((ZPlanResourceItemDownloadResult) obj).getIsSuccess()) {
                arrayList.add(obj);
            }
        }
        for (ZPlanResourceItemDownloadResult zPlanResourceItemDownloadResult : arrayList) {
            if (zPlanResourceItemDownloadResult.getDownloadTaskInfo().getResHubIdInfo() != null && !TextUtils.isEmpty(zPlanResourceItemDownloadResult.getResHubLocalPath())) {
                return new ZPlanResHubResultInfo(zPlanResourceItemDownloadResult.getResHubExtraDesc(), zPlanResourceItemDownloadResult.getResHubLocalPath(), zPlanResourceItemDownloadResult.getResHubOriginalPath(), null, zPlanResourceItemDownloadResult.getDownloadTaskInfo().getResHubIdInfo().getAppId(), zPlanResourceItemDownloadResult.getDownloadTaskInfo().getResHubIdInfo().getAppKey(), zPlanResourceItemDownloadResult.getDownloadTaskInfo().getResHubIdInfo().getEnv(), zPlanResourceItemDownloadResult.getDownloadTaskInfo().getResHubIdInfo().getResHubInfoDetail().f406420a);
            }
        }
        return null;
    }

    public final CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> d() {
        return this.resultList;
    }

    public final void e(ZPlanResourceItemDownloadResult itemDownloadResult) {
        Object obj;
        Intrinsics.checkNotNullParameter(itemDownloadResult, "itemDownloadResult");
        Iterator<T> it = this.resultList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((ZPlanResourceItemDownloadResult) obj).getDownloadTaskInfo().getUniqueTaskId(), itemDownloadResult.getDownloadTaskInfo().getUniqueTaskId())) {
                    break;
                }
            }
        }
        ZPlanResourceItemDownloadResult zPlanResourceItemDownloadResult = (ZPlanResourceItemDownloadResult) obj;
        if (zPlanResourceItemDownloadResult == null) {
            this.resultList.add(itemDownloadResult);
        } else {
            zPlanResourceItemDownloadResult.l(itemDownloadResult);
        }
    }

    public int hashCode() {
        return (((this.uniqueId.hashCode() * 31) + this.downloadInfoList.hashCode()) * 31) + this.resultList.hashCode();
    }

    public String toString() {
        return "ZPlanResourceBatchDownloadResult(uniqueId=" + this.uniqueId + ", downloadInfoList=" + this.downloadInfoList + ", resultList=" + this.resultList + ")";
    }

    public /* synthetic */ ZPlanResourceBatchDownloadResult(String str, List list, CopyOnWriteArrayList copyOnWriteArrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i3 & 4) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanResourceBatchDownloadResult)) {
            return false;
        }
        ZPlanResourceBatchDownloadResult zPlanResourceBatchDownloadResult = (ZPlanResourceBatchDownloadResult) other;
        return Intrinsics.areEqual(this.uniqueId, zPlanResourceBatchDownloadResult.uniqueId) && Intrinsics.areEqual(this.downloadInfoList, zPlanResourceBatchDownloadResult.downloadInfoList) && Intrinsics.areEqual(this.resultList, zPlanResourceBatchDownloadResult.resultList);
    }
}
