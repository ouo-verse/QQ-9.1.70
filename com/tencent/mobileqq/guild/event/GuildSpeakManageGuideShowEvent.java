package com.tencent.mobileqq.guild.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/event/GuildSpeakManageGuideShowEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "hintText", "Ljava/lang/String;", "getHintText", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/data/j;", CacheTable.TABLE_NAME, "Lcom/tencent/mobileqq/guild/data/j;", "getReportInfo", "()Lcom/tencent/mobileqq/guild/data/j;", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/data/j;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSpeakManageGuideShowEvent extends SimpleBaseEvent {

    @NotNull
    private final String hintText;

    @NotNull
    private final GuildSpeakParamsInfo reportInfo;

    public GuildSpeakManageGuideShowEvent(@NotNull String hintText, @NotNull GuildSpeakParamsInfo reportInfo) {
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        this.hintText = hintText;
        this.reportInfo = reportInfo;
    }

    @NotNull
    public final String getHintText() {
        return this.hintText;
    }

    @NotNull
    public final GuildSpeakParamsInfo getReportInfo() {
        return this.reportInfo;
    }
}
