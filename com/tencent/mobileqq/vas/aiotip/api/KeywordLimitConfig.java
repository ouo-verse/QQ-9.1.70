package com.tencent.mobileqq.vas.aiotip.api;

import androidx.fragment.app.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/aiotip/api/KeywordLimitConfig;", "", "c2cEnable", "", "c2cFreq", "", "groupEnable", "groupFreq", "discussEnable", "discussFreq", "(IJIJIJ)V", "getC2cEnable", "()I", "getC2cFreq", "()J", "getDiscussEnable", "getDiscussFreq", "getGroupEnable", "getGroupFreq", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class KeywordLimitConfig {
    private final int c2cEnable;
    private final long c2cFreq;
    private final int discussEnable;
    private final long discussFreq;
    private final int groupEnable;
    private final long groupFreq;

    public KeywordLimitConfig(int i3, long j3, int i16, long j16, int i17, long j17) {
        this.c2cEnable = i3;
        this.c2cFreq = j3;
        this.groupEnable = i16;
        this.groupFreq = j16;
        this.discussEnable = i17;
        this.discussFreq = j17;
    }

    public static /* synthetic */ KeywordLimitConfig copy$default(KeywordLimitConfig keywordLimitConfig, int i3, long j3, int i16, long j16, int i17, long j17, int i18, Object obj) {
        int i19;
        long j18;
        int i26;
        long j19;
        int i27;
        long j26;
        if ((i18 & 1) != 0) {
            i19 = keywordLimitConfig.c2cEnable;
        } else {
            i19 = i3;
        }
        if ((i18 & 2) != 0) {
            j18 = keywordLimitConfig.c2cFreq;
        } else {
            j18 = j3;
        }
        if ((i18 & 4) != 0) {
            i26 = keywordLimitConfig.groupEnable;
        } else {
            i26 = i16;
        }
        if ((i18 & 8) != 0) {
            j19 = keywordLimitConfig.groupFreq;
        } else {
            j19 = j16;
        }
        if ((i18 & 16) != 0) {
            i27 = keywordLimitConfig.discussEnable;
        } else {
            i27 = i17;
        }
        if ((i18 & 32) != 0) {
            j26 = keywordLimitConfig.discussFreq;
        } else {
            j26 = j17;
        }
        return keywordLimitConfig.copy(i19, j18, i26, j19, i27, j26);
    }

    /* renamed from: component1, reason: from getter */
    public final int getC2cEnable() {
        return this.c2cEnable;
    }

    /* renamed from: component2, reason: from getter */
    public final long getC2cFreq() {
        return this.c2cFreq;
    }

    /* renamed from: component3, reason: from getter */
    public final int getGroupEnable() {
        return this.groupEnable;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGroupFreq() {
        return this.groupFreq;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDiscussEnable() {
        return this.discussEnable;
    }

    /* renamed from: component6, reason: from getter */
    public final long getDiscussFreq() {
        return this.discussFreq;
    }

    @NotNull
    public final KeywordLimitConfig copy(int c2cEnable, long c2cFreq, int groupEnable, long groupFreq, int discussEnable, long discussFreq) {
        return new KeywordLimitConfig(c2cEnable, c2cFreq, groupEnable, groupFreq, discussEnable, discussFreq);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeywordLimitConfig)) {
            return false;
        }
        KeywordLimitConfig keywordLimitConfig = (KeywordLimitConfig) other;
        if (this.c2cEnable == keywordLimitConfig.c2cEnable && this.c2cFreq == keywordLimitConfig.c2cFreq && this.groupEnable == keywordLimitConfig.groupEnable && this.groupFreq == keywordLimitConfig.groupFreq && this.discussEnable == keywordLimitConfig.discussEnable && this.discussFreq == keywordLimitConfig.discussFreq) {
            return true;
        }
        return false;
    }

    public final int getC2cEnable() {
        return this.c2cEnable;
    }

    public final long getC2cFreq() {
        return this.c2cFreq;
    }

    public final int getDiscussEnable() {
        return this.discussEnable;
    }

    public final long getDiscussFreq() {
        return this.discussFreq;
    }

    public final int getGroupEnable() {
        return this.groupEnable;
    }

    public final long getGroupFreq() {
        return this.groupFreq;
    }

    public int hashCode() {
        return (((((((((this.c2cEnable * 31) + a.a(this.c2cFreq)) * 31) + this.groupEnable) * 31) + a.a(this.groupFreq)) * 31) + this.discussEnable) * 31) + a.a(this.discussFreq);
    }

    @NotNull
    public String toString() {
        return "KeywordLimitConfig(c2cEnable=" + this.c2cEnable + ", c2cFreq=" + this.c2cFreq + ", groupEnable=" + this.groupEnable + ", groupFreq=" + this.groupFreq + ", discussEnable=" + this.discussEnable + ", discussFreq=" + this.discussFreq + ")";
    }

    public /* synthetic */ KeywordLimitConfig(int i3, long j3, int i16, long j16, int i17, long j17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i18 & 2) != 0 ? 86400L : j3, i16, (i18 & 8) != 0 ? 86400L : j16, i17, (i18 & 32) != 0 ? 86400L : j17);
    }
}
