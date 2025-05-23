package com.tencent.mobileqq.zplan.authorize.api;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qv4.aw;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", "Ljava/io/Serializable;", "", "toString", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParamsAfterCheck", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "getEnterParamsAfterCheck", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "setEnterParamsAfterCheck", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;)V", "", "cloudServerStatus", "I", "getCloudServerStatus", "()I", "setCloudServerStatus", "(I)V", "Lqv4/aw;", "modUpdateInfo", "Lqv4/aw;", "getModUpdateInfo", "()Lqv4/aw;", "setModUpdateInfo", "(Lqv4/aw;)V", QzoneIPCModule.RESULT_CODE, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(ILcom/tencent/mobileqq/zootopia/ZootopiaSource;Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;ILqv4/aw;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class EnterModCheckResult extends CheckResult {
    private int cloudServerStatus;
    private ZootopiaEnterParams enterParamsAfterCheck;
    private aw modUpdateInfo;

    public /* synthetic */ EnterModCheckResult(int i3, ZootopiaSource zootopiaSource, ZootopiaEnterParams zootopiaEnterParams, int i16, aw awVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, zootopiaSource, zootopiaEnterParams, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) != 0 ? null : awVar);
    }

    public final int getCloudServerStatus() {
        return this.cloudServerStatus;
    }

    public final ZootopiaEnterParams getEnterParamsAfterCheck() {
        return this.enterParamsAfterCheck;
    }

    public final aw getModUpdateInfo() {
        return this.modUpdateInfo;
    }

    public final void setCloudServerStatus(int i3) {
        this.cloudServerStatus = i3;
    }

    public final void setEnterParamsAfterCheck(ZootopiaEnterParams zootopiaEnterParams) {
        this.enterParamsAfterCheck = zootopiaEnterParams;
    }

    public final void setModUpdateInfo(aw awVar) {
        this.modUpdateInfo = awVar;
    }

    public String toString() {
        return "resultCode = " + getResultCode() + " source = " + getSource() + ", cloudServerStatus=" + this.cloudServerStatus + " processInner=" + getProcessInner();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterModCheckResult(int i3, ZootopiaSource source, ZootopiaEnterParams zootopiaEnterParams, int i16, aw awVar) {
        super(i3, source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.enterParamsAfterCheck = zootopiaEnterParams;
        this.cloudServerStatus = i16;
        this.modUpdateInfo = awVar;
    }
}
