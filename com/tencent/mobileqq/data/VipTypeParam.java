package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\n\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/data/VipTypeParam;", "", "LQQService/EVIPSPEC;", "spec", "", "isServiceEnabled", "", "getServiceType", "", "toString", "hashCode", "other", "equals", "qqVipInfo", "I", "getQqVipInfo", "()I", "setQqVipInfo", "(I)V", "superQqInfo", "getSuperQqInfo", "setSuperQqInfo", "superVipInfo", "getSuperVipInfo", "setSuperVipInfo", "bigClubInfo", "getBigClubInfo", "setBigClubInfo", "<init>", "(IIII)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class VipTypeParam {
    private int bigClubInfo;
    private int qqVipInfo;
    private int superQqInfo;
    private int superVipInfo;

    public VipTypeParam() {
        this(0, 0, 0, 0, 15, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VipTypeParam)) {
            return false;
        }
        VipTypeParam vipTypeParam = (VipTypeParam) other;
        if (this.qqVipInfo == vipTypeParam.qqVipInfo && this.superQqInfo == vipTypeParam.superQqInfo && this.superVipInfo == vipTypeParam.superVipInfo && this.bigClubInfo == vipTypeParam.bigClubInfo) {
            return true;
        }
        return false;
    }

    public final int getServiceType(@NotNull EVIPSPEC spec) {
        int i3;
        Intrinsics.checkNotNullParameter(spec, "spec");
        int value = spec.value();
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return 0;
                    }
                    i3 = this.bigClubInfo;
                } else {
                    i3 = this.superVipInfo;
                }
            } else {
                i3 = this.superQqInfo;
            }
        } else {
            i3 = this.qqVipInfo;
        }
        return (i3 & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16;
    }

    public int hashCode() {
        return (((((this.qqVipInfo * 31) + this.superQqInfo) * 31) + this.superVipInfo) * 31) + this.bigClubInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if ((r4.bigClubInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        if ((r4.superVipInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        if ((r4.superQqInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        if ((r4.qqVipInfo & (-16777216)) != 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isServiceEnabled(@NotNull EVIPSPEC spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        int value = spec.value();
        boolean z16 = true;
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return false;
                    }
                }
            }
        }
    }

    @NotNull
    public String toString() {
        return "VipTypeParam(qqVipInfo=" + this.qqVipInfo + ", superQqInfo=" + this.superQqInfo + ", superVipInfo=" + this.superVipInfo + ", bigClubInfo=" + this.bigClubInfo + ")";
    }

    public VipTypeParam(int i3, int i16, int i17, int i18) {
        this.qqVipInfo = i3;
        this.superQqInfo = i16;
        this.superVipInfo = i17;
        this.bigClubInfo = i18;
    }

    public /* synthetic */ VipTypeParam(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
    }
}
