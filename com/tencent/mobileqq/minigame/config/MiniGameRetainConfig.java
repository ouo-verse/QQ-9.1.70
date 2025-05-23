package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameRetainConfig;", "Lcom/tencent/freesia/IConfigData;", "jumpLink", "", "(Ljava/lang/String;)V", "getJumpLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class MiniGameRetainConfig implements IConfigData {
    private final String jumpLink;

    public MiniGameRetainConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getJumpLink() {
        return this.jumpLink;
    }

    public final MiniGameRetainConfig copy(String jumpLink) {
        return new MiniGameRetainConfig(jumpLink);
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }

    public int hashCode() {
        String str = this.jumpLink;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "MiniGameRetainConfig(jumpLink=" + this.jumpLink + ")";
    }

    public MiniGameRetainConfig(String str) {
        this.jumpLink = str;
    }

    public /* synthetic */ MiniGameRetainConfig(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str);
    }

    public static /* synthetic */ MiniGameRetainConfig copy$default(MiniGameRetainConfig miniGameRetainConfig, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = miniGameRetainConfig.jumpLink;
        }
        return miniGameRetainConfig.copy(str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MiniGameRetainConfig) && Intrinsics.areEqual(this.jumpLink, ((MiniGameRetainConfig) other).jumpLink);
    }
}
