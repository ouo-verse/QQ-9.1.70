package com.tencent.state.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/data/JumpInfo;", "", "jumpType", "", WadlProxyConsts.KEY_JUMP_URL, "", "(ILjava/lang/String;)V", "getJumpType", "()I", "getJumpUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final /* data */ class JumpInfo {
    private final int jumpType;

    @NotNull
    private final String jumpUrl;

    public JumpInfo(int i3, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.jumpType = i3;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ JumpInfo copy$default(JumpInfo jumpInfo, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = jumpInfo.jumpType;
        }
        if ((i16 & 2) != 0) {
            str = jumpInfo.jumpUrl;
        }
        return jumpInfo.copy(i3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final JumpInfo copy(int jumpType, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new JumpInfo(jumpType, jumpUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof JumpInfo) {
                JumpInfo jumpInfo = (JumpInfo) other;
                if (this.jumpType != jumpInfo.jumpType || !Intrinsics.areEqual(this.jumpUrl, jumpInfo.jumpUrl)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        int i3;
        int i16 = this.jumpType * 31;
        String str = this.jumpUrl;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "JumpInfo(jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
