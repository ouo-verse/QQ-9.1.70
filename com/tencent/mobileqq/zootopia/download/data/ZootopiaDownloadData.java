package com.tencent.mobileqq.zootopia.download.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.z1.download.data.ZootopiaExtraData;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.download.data.ZootopiaSummaryData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0006\u0010\u0019\u001a\u00020\u0014J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "Ljava/io/Serializable;", "summaryData", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;", "resData", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;", "(Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;)V", "getExtraData", "()Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;", "getResData", "()Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "getSummaryData", "()Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "isGameType", "toString", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ZootopiaDownloadData implements Serializable {
    private final ZootopiaExtraData extraData;
    private final ZootopiaResData resData;
    private final ZootopiaSummaryData summaryData;

    public ZootopiaDownloadData(ZootopiaSummaryData summaryData, ZootopiaResData resData, ZootopiaExtraData extraData) {
        Intrinsics.checkNotNullParameter(summaryData, "summaryData");
        Intrinsics.checkNotNullParameter(resData, "resData");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.summaryData = summaryData;
        this.resData = resData;
        this.extraData = extraData;
    }

    /* renamed from: component1, reason: from getter */
    public final ZootopiaSummaryData getSummaryData() {
        return this.summaryData;
    }

    /* renamed from: component2, reason: from getter */
    public final ZootopiaResData getResData() {
        return this.resData;
    }

    /* renamed from: component3, reason: from getter */
    public final ZootopiaExtraData getExtraData() {
        return this.extraData;
    }

    public final ZootopiaDownloadData copy(ZootopiaSummaryData summaryData, ZootopiaResData resData, ZootopiaExtraData extraData) {
        Intrinsics.checkNotNullParameter(summaryData, "summaryData");
        Intrinsics.checkNotNullParameter(resData, "resData");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        return new ZootopiaDownloadData(summaryData, resData, extraData);
    }

    public final ZootopiaExtraData getExtraData() {
        return this.extraData;
    }

    public final ZootopiaResData getResData() {
        return this.resData;
    }

    public final ZootopiaSummaryData getSummaryData() {
        return this.summaryData;
    }

    public int hashCode() {
        return (((this.summaryData.hashCode() * 31) + this.resData.hashCode()) * 31) + this.extraData.hashCode();
    }

    public final boolean isGameType() {
        return this.summaryData.getType() == 2;
    }

    public String toString() {
        return "ZootopiaDownloadData(summaryData=" + this.summaryData + ", resData=" + this.resData + ", extraData=" + this.extraData + ")";
    }

    public static /* synthetic */ ZootopiaDownloadData copy$default(ZootopiaDownloadData zootopiaDownloadData, ZootopiaSummaryData zootopiaSummaryData, ZootopiaResData zootopiaResData, ZootopiaExtraData zootopiaExtraData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            zootopiaSummaryData = zootopiaDownloadData.summaryData;
        }
        if ((i3 & 2) != 0) {
            zootopiaResData = zootopiaDownloadData.resData;
        }
        if ((i3 & 4) != 0) {
            zootopiaExtraData = zootopiaDownloadData.extraData;
        }
        return zootopiaDownloadData.copy(zootopiaSummaryData, zootopiaResData, zootopiaExtraData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaDownloadData)) {
            return false;
        }
        ZootopiaDownloadData zootopiaDownloadData = (ZootopiaDownloadData) other;
        return Intrinsics.areEqual(this.summaryData, zootopiaDownloadData.summaryData) && Intrinsics.areEqual(this.resData, zootopiaDownloadData.resData) && Intrinsics.areEqual(this.extraData, zootopiaDownloadData.extraData);
    }
}
