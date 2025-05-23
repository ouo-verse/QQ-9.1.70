package com.tencent.qzonehub.api.impl;

import com.qzone.reborn.feedx.util.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qzonehub/api/impl/QZoneActiveRedCountInfoApiImpl;", "Lcom/tencent/qzonehub/api/IQZoneActiveRedCountInfoApi;", "()V", "checkIsNeedToBatchDeleteCountInfo", "", "stMapCountInfo", "Ljava/util/HashMap;", "", "Lcooperation/qzone/UndealCount/QZoneCountInfo;", "checkIsNeedToSingleDeleteCountInfo", "countInfo", "countId", "daTongClickReport", "", "daTongExposeReport", "deleteRedCountInfo", "existQZoneActiveRedCountInfo", "getRedCountInfoTimestamp", "", "isNeedToRemoveMomentActiveRedCountInfo", "isNeedToRemoveMomentPassiveRedCountInfo", "isValidPublishPlusIconRedDot", "saveRedCountInfo", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class QZoneActiveRedCountInfoApiImpl implements IQZoneActiveRedCountInfoApi {
    private final boolean isNeedToRemoveMomentActiveRedCountInfo(QZoneCountInfo countInfo, int countId) {
        return com.tencent.mobileqq.service.qzone.b.o(countId) && com.tencent.mobileqq.service.qzone.b.r(countInfo);
    }

    private final boolean isNeedToRemoveMomentPassiveRedCountInfo(QZoneCountInfo countInfo, int countId) {
        return com.tencent.mobileqq.service.qzone.b.p(countId) && com.tencent.mobileqq.service.qzone.b.q(countInfo, countId);
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public boolean checkIsNeedToBatchDeleteCountInfo(HashMap<Integer, QZoneCountInfo> stMapCountInfo) {
        Intrinsics.checkNotNullParameter(stMapCountInfo, "stMapCountInfo");
        j jVar = j.f55760a;
        boolean a16 = jVar.a(stMapCountInfo);
        if (jVar.b(stMapCountInfo)) {
            a16 = true;
        }
        if (com.tencent.mobileqq.service.qzone.b.n(stMapCountInfo)) {
            return true;
        }
        return a16;
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public boolean checkIsNeedToSingleDeleteCountInfo(QZoneCountInfo countInfo, int countId) {
        Intrinsics.checkNotNullParameter(countInfo, "countInfo");
        j jVar = j.f55760a;
        boolean n3 = jVar.n(countInfo, countId);
        if (jVar.d(countInfo, countId)) {
            n3 = true;
        }
        if (isNeedToRemoveMomentPassiveRedCountInfo(countInfo, countId)) {
            n3 = true;
        }
        if (isNeedToRemoveMomentActiveRedCountInfo(countInfo, countId)) {
            return true;
        }
        return n3;
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public void daTongClickReport() {
        dh.d.f393812a.h();
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public void daTongExposeReport() {
        dh.d.f393812a.i();
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public void deleteRedCountInfo(int countId) {
        j.f55760a.g(countId);
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public boolean existQZoneActiveRedCountInfo() {
        return dh.d.f393812a.E();
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public long getRedCountInfoTimestamp(int countId) {
        return j.f55760a.j(countId);
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public void saveRedCountInfo(int countId, QZoneCountInfo countInfo) {
        j.f55760a.p(countId, countInfo);
    }

    @Override // com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi
    public boolean isValidPublishPlusIconRedDot(QZoneCountInfo countInfo) {
        if (countInfo == null) {
            return false;
        }
        long j3 = j.f55760a.j(1028);
        QLog.i("LebaPluginQzoneRedViewHolder", 1, "last time stamp is " + j3 + ", new time stamp is " + countInfo.cTime);
        long j16 = countInfo.cTime;
        if (j16 <= j3) {
            QLog.e("LebaPluginQzoneRedViewHolder", 1, "timestamp is old, cTime is " + j16 + ", redCountInfoTimestamp is " + j3);
            return false;
        }
        byte[] bArr = countInfo.tianshuTrans;
        if (bArr != null) {
            Intrinsics.checkNotNullExpressionValue(bArr, "countInfo.tianshuTrans");
            if (!(bArr.length == 0)) {
                QLog.i("LebaPluginQzoneRedViewHolder", 1, "valid publish plus icon red count info");
                return true;
            }
        }
        QLog.e("LebaPluginQzoneRedViewHolder", 1, "count info tian shu trans is empty");
        return false;
    }
}
