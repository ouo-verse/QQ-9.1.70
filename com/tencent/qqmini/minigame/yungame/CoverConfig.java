package com.tencent.qqmini.minigame.yungame;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getCoverUrl", "()Ljava/lang/String;", "coverUrl", "b", "getJumpGuildUrl", "jumpGuildUrl", "c", "getPagUrl", "setPagUrl", "(Ljava/lang/String;)V", "pagUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qqmini.minigame.yungame.a, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class CoverConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpGuildUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String pagUrl;

    public CoverConfig(@NotNull String coverUrl, @NotNull String jumpGuildUrl, @NotNull String pagUrl) {
        Intrinsics.checkParameterIsNotNull(coverUrl, "coverUrl");
        Intrinsics.checkParameterIsNotNull(jumpGuildUrl, "jumpGuildUrl");
        Intrinsics.checkParameterIsNotNull(pagUrl, "pagUrl");
        this.coverUrl = coverUrl;
        this.jumpGuildUrl = jumpGuildUrl;
        this.pagUrl = pagUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CoverConfig) {
                CoverConfig coverConfig = (CoverConfig) other;
                if (!Intrinsics.areEqual(this.coverUrl, coverConfig.coverUrl) || !Intrinsics.areEqual(this.jumpGuildUrl, coverConfig.jumpGuildUrl) || !Intrinsics.areEqual(this.pagUrl, coverConfig.pagUrl)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.coverUrl;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.jumpGuildUrl;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.pagUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "CoverConfig(coverUrl=" + this.coverUrl + ", jumpGuildUrl=" + this.jumpGuildUrl + ", pagUrl=" + this.pagUrl + ")";
    }
}
