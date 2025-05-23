package com.tencent.mobileqq.guild.summary;

import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0000J7\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/b;", "", "", h.F, "a", "hasDraft", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", "sendState", "", "Lcom/tencent/mobileqq/guild/summary/GuildSummaryText;", "summaryContents", "", "lastTime", "b", "", "toString", "", "hashCode", "other", "equals", "Z", "d", "()Z", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", "f", "()Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", "c", "Ljava/util/List;", "g", "()Ljava/util/List;", "J", "e", "()J", "<init>", "(ZLcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;Ljava/util/List;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.summary.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildSummaryUIData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasDraft;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LastMessage.SendState sendState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GuildSummaryText> summaryContents;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long lastTime;

    public GuildSummaryUIData() {
        this(false, null, null, 0L, 15, null);
    }

    public static /* synthetic */ GuildSummaryUIData c(GuildSummaryUIData guildSummaryUIData, boolean z16, LastMessage.SendState sendState, List list, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = guildSummaryUIData.hasDraft;
        }
        if ((i3 & 2) != 0) {
            sendState = guildSummaryUIData.sendState;
        }
        LastMessage.SendState sendState2 = sendState;
        if ((i3 & 4) != 0) {
            list = guildSummaryUIData.summaryContents;
        }
        List list2 = list;
        if ((i3 & 8) != 0) {
            j3 = guildSummaryUIData.lastTime;
        }
        return guildSummaryUIData.b(z16, sendState2, list2, j3);
    }

    @NotNull
    public final GuildSummaryUIData a() {
        return c(this, false, null, new ArrayList(this.summaryContents), 0L, 11, null);
    }

    @NotNull
    public final GuildSummaryUIData b(boolean hasDraft, @NotNull LastMessage.SendState sendState, @NotNull List<GuildSummaryText> summaryContents, long lastTime) {
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(summaryContents, "summaryContents");
        return new GuildSummaryUIData(hasDraft, sendState, summaryContents, lastTime);
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHasDraft() {
        return this.hasDraft;
    }

    /* renamed from: e, reason: from getter */
    public final long getLastTime() {
        return this.lastTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSummaryUIData)) {
            return false;
        }
        GuildSummaryUIData guildSummaryUIData = (GuildSummaryUIData) other;
        if (this.hasDraft == guildSummaryUIData.hasDraft && this.sendState == guildSummaryUIData.sendState && Intrinsics.areEqual(this.summaryContents, guildSummaryUIData.summaryContents) && this.lastTime == guildSummaryUIData.lastTime) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final LastMessage.SendState getSendState() {
        return this.sendState;
    }

    @NotNull
    public final List<GuildSummaryText> g() {
        return this.summaryContents;
    }

    public final boolean h() {
        return this.summaryContents.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.hasDraft;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.sendState.hashCode()) * 31) + this.summaryContents.hashCode()) * 31) + androidx.fragment.app.a.a(this.lastTime);
    }

    @NotNull
    public String toString() {
        return "GuildSummaryUIData(hasDraft=" + this.hasDraft + ", sendState=" + this.sendState + ", summaryContents=" + this.summaryContents + ", lastTime=" + this.lastTime + ")";
    }

    public GuildSummaryUIData(boolean z16, @NotNull LastMessage.SendState sendState, @NotNull List<GuildSummaryText> summaryContents, long j3) {
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(summaryContents, "summaryContents");
        this.hasDraft = z16;
        this.sendState = sendState;
        this.summaryContents = summaryContents;
        this.lastTime = j3;
    }

    public /* synthetic */ GuildSummaryUIData(boolean z16, LastMessage.SendState sendState, List list, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? LastMessage.SendState.SEND_SUCCESS : sendState, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? 0L : j3);
    }
}
