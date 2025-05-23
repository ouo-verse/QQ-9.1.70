package com.tencent.mobileqq.zplan.dresskey.api;

import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/dresskey/api/DressInfoIPCData;", "Ljava/io/Serializable;", "infoJson", "", QzoneIPCModule.RESULT_CODE, "", "resultMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getInfoJson", "()Ljava/lang/String;", "getResultCode", "()I", "getResultMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class DressInfoIPCData implements Serializable {
    private final String infoJson;
    private final int resultCode;
    private final String resultMsg;

    public DressInfoIPCData(String infoJson, int i3, String resultMsg) {
        Intrinsics.checkNotNullParameter(infoJson, "infoJson");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        this.infoJson = infoJson;
        this.resultCode = i3;
        this.resultMsg = resultMsg;
    }

    /* renamed from: component1, reason: from getter */
    public final String getInfoJson() {
        return this.infoJson;
    }

    /* renamed from: component2, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final DressInfoIPCData copy(String infoJson, int resultCode, String resultMsg) {
        Intrinsics.checkNotNullParameter(infoJson, "infoJson");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        return new DressInfoIPCData(infoJson, resultCode, resultMsg);
    }

    public final String getInfoJson() {
        return this.infoJson;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public int hashCode() {
        return (((this.infoJson.hashCode() * 31) + this.resultCode) * 31) + this.resultMsg.hashCode();
    }

    public String toString() {
        return "DressInfoIPCData(infoJson=" + this.infoJson + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ")";
    }

    public /* synthetic */ DressInfoIPCData(String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? "" : str2);
    }

    public static /* synthetic */ DressInfoIPCData copy$default(DressInfoIPCData dressInfoIPCData, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = dressInfoIPCData.infoJson;
        }
        if ((i16 & 2) != 0) {
            i3 = dressInfoIPCData.resultCode;
        }
        if ((i16 & 4) != 0) {
            str2 = dressInfoIPCData.resultMsg;
        }
        return dressInfoIPCData.copy(str, i3, str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressInfoIPCData)) {
            return false;
        }
        DressInfoIPCData dressInfoIPCData = (DressInfoIPCData) other;
        return Intrinsics.areEqual(this.infoJson, dressInfoIPCData.infoJson) && this.resultCode == dressInfoIPCData.resultCode && Intrinsics.areEqual(this.resultMsg, dressInfoIPCData.resultMsg);
    }
}
