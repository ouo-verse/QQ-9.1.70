package com.tencent.mobileqq.guild.event;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.performance.report.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/event/GuildFeedDetailReportEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", AdMetricTag.EVENT_NAME, "", "to", "currTime", "", "isReport", "", "(Ljava/lang/String;Ljava/lang/String;JZ)V", "endTime", "isColdStart", "(JZ)V", "isEnd", "linkEndTime", "logEvent", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedDetailReportEvent extends SimpleBaseEvent {
    private long currTime;

    @NotNull
    private String eventName;
    private boolean isColdStart;
    private boolean isEnd;
    private boolean isReport;
    private long linkEndTime;

    @NotNull
    private String to;

    public GuildFeedDetailReportEvent(@NotNull String eventName, @NotNull String to5, long j3, boolean z16) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(to5, "to");
        this.isColdStart = true;
        this.eventName = eventName;
        this.to = to5;
        this.currTime = j3;
        this.isReport = z16;
    }

    public final void logEvent() {
        if (this.isEnd) {
            w.f231064i.j(this.linkEndTime, this.isColdStart);
        } else if (this.isReport) {
            w.f231064i.l(this.eventName, this.to, this.currTime);
        } else {
            w.f231064i.k(this.to, this.currTime);
        }
    }

    public GuildFeedDetailReportEvent(long j3, boolean z16) {
        this.eventName = "";
        this.to = "";
        this.isReport = true;
        this.isEnd = true;
        this.linkEndTime = j3;
        this.isColdStart = z16;
    }
}
