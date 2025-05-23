package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/fj;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "channelId", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "pollingType", "d", "I", "()I", "source", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class fj {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> pollingType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int source;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final ArrayList<Integer> c() {
        return this.pollingType;
    }

    /* renamed from: d, reason: from getter */
    public final int getSource() {
        return this.source;
    }
}
