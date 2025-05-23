package com.tencent.mobileqq.vas.adv.qzone.data;

import androidx.fragment.app.a;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaParam;", "", "uin", "", "advPos", "", "qzoneBusiInfo", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneBusiMsg;", "refer", "(JILcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneBusiMsg;I)V", "getAdvPos", "()I", "getQzoneBusiInfo", "()Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneBusiMsg;", "getRefer", "getUin", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class VasAdMetaParam {
    private final int advPos;

    @Nullable
    private final vac_adv_get.QzoneBusiMsg qzoneBusiInfo;
    private final int refer;
    private final long uin;

    public VasAdMetaParam(long j3, int i3, @Nullable vac_adv_get.QzoneBusiMsg qzoneBusiMsg, int i16) {
        this.uin = j3;
        this.advPos = i3;
        this.qzoneBusiInfo = qzoneBusiMsg;
        this.refer = i16;
    }

    public static /* synthetic */ VasAdMetaParam copy$default(VasAdMetaParam vasAdMetaParam, long j3, int i3, vac_adv_get.QzoneBusiMsg qzoneBusiMsg, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            j3 = vasAdMetaParam.uin;
        }
        long j16 = j3;
        if ((i17 & 2) != 0) {
            i3 = vasAdMetaParam.advPos;
        }
        int i18 = i3;
        if ((i17 & 4) != 0) {
            qzoneBusiMsg = vasAdMetaParam.qzoneBusiInfo;
        }
        vac_adv_get.QzoneBusiMsg qzoneBusiMsg2 = qzoneBusiMsg;
        if ((i17 & 8) != 0) {
            i16 = vasAdMetaParam.refer;
        }
        return vasAdMetaParam.copy(j16, i18, qzoneBusiMsg2, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAdvPos() {
        return this.advPos;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final vac_adv_get.QzoneBusiMsg getQzoneBusiInfo() {
        return this.qzoneBusiInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRefer() {
        return this.refer;
    }

    @NotNull
    public final VasAdMetaParam copy(long uin, int advPos, @Nullable vac_adv_get.QzoneBusiMsg qzoneBusiInfo, int refer) {
        return new VasAdMetaParam(uin, advPos, qzoneBusiInfo, refer);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasAdMetaParam)) {
            return false;
        }
        VasAdMetaParam vasAdMetaParam = (VasAdMetaParam) other;
        if (this.uin == vasAdMetaParam.uin && this.advPos == vasAdMetaParam.advPos && Intrinsics.areEqual(this.qzoneBusiInfo, vasAdMetaParam.qzoneBusiInfo) && this.refer == vasAdMetaParam.refer) {
            return true;
        }
        return false;
    }

    public final int getAdvPos() {
        return this.advPos;
    }

    @Nullable
    public final vac_adv_get.QzoneBusiMsg getQzoneBusiInfo() {
        return this.qzoneBusiInfo;
    }

    public final int getRefer() {
        return this.refer;
    }

    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((a.a(this.uin) * 31) + this.advPos) * 31;
        vac_adv_get.QzoneBusiMsg qzoneBusiMsg = this.qzoneBusiInfo;
        if (qzoneBusiMsg == null) {
            hashCode = 0;
        } else {
            hashCode = qzoneBusiMsg.hashCode();
        }
        return ((a16 + hashCode) * 31) + this.refer;
    }

    @NotNull
    public String toString() {
        return "VasAdMetaParam(uin=" + this.uin + ", advPos=" + this.advPos + ", qzoneBusiInfo=" + this.qzoneBusiInfo + ", refer=" + this.refer + ')';
    }
}
