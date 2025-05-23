package com.tencent.mobileqq.guild.event;

import androidx.core.util.Supplier;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fR#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/event/GuildFeedSharePanelLaunchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "position", "", "stFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "dtParamSupplier", "Landroidx/core/util/Supplier;", "", "", "", "mediaIndex", "(ILcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Landroidx/core/util/Supplier;I)V", "getDtParamSupplier", "()Landroidx/core/util/Supplier;", "getMediaIndex", "()I", "getPosition", "getStFeed", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedSharePanelLaunchEvent extends SimpleBaseEvent {

    @NotNull
    private final Supplier<Map<String, Object>> dtParamSupplier;
    private final int mediaIndex;
    private final int position;

    @NotNull
    private final GProStFeed stFeed;

    public GuildFeedSharePanelLaunchEvent(int i3, @NotNull GProStFeed stFeed, @NotNull Supplier<Map<String, Object>> dtParamSupplier, int i16) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(dtParamSupplier, "dtParamSupplier");
        this.position = i3;
        this.stFeed = stFeed;
        this.dtParamSupplier = dtParamSupplier;
        this.mediaIndex = i16;
    }

    @NotNull
    public final Supplier<Map<String, Object>> getDtParamSupplier() {
        return this.dtParamSupplier;
    }

    public final int getMediaIndex() {
        return this.mediaIndex;
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final GProStFeed getStFeed() {
        return this.stFeed;
    }
}
