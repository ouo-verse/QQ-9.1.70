package com.tencent.mobileqq.qqguildsdk.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/cp;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "dealCode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "dealWording", "c", "Z", "getRemove", "()Z", "remove", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "()Lcom/tencent/mobileqq/qqguildsdk/data/co;", "guildNotice", "<init>", "(ILjava/lang/String;ZLcom/tencent/mobileqq/qqguildsdk/data/co;)V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqguildsdk.data.cp, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class GuildNoticeDealResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int dealCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dealWording;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean remove;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final co guildNotice;

    public GuildNoticeDealResult(int i3, @NotNull String dealWording, boolean z16, @NotNull co guildNotice) {
        Intrinsics.checkNotNullParameter(dealWording, "dealWording");
        Intrinsics.checkNotNullParameter(guildNotice, "guildNotice");
        this.dealCode = i3;
        this.dealWording = dealWording;
        this.remove = z16;
        this.guildNotice = guildNotice;
    }

    /* renamed from: a, reason: from getter */
    public final int getDealCode() {
        return this.dealCode;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDealWording() {
        return this.dealWording;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final co getGuildNotice() {
        return this.guildNotice;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildNoticeDealResult)) {
            return false;
        }
        GuildNoticeDealResult guildNoticeDealResult = (GuildNoticeDealResult) other;
        if (this.dealCode == guildNoticeDealResult.dealCode && Intrinsics.areEqual(this.dealWording, guildNoticeDealResult.dealWording) && this.remove == guildNoticeDealResult.remove && Intrinsics.areEqual(this.guildNotice, guildNoticeDealResult.guildNotice)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.dealCode * 31) + this.dealWording.hashCode()) * 31;
        boolean z16 = this.remove;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.guildNotice.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildNoticeDealResult(dealCode=" + this.dealCode + ", dealWording=" + this.dealWording + ", remove=" + this.remove + ", guildNotice=" + this.guildNotice + ')';
    }
}
