package com.tencent.mobileqq.qqlive.sail.trtc.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trtc.TRTCStatistics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnStatisticsEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/TrtcBaseEvent;", "appId", "", "statistic", "Lcom/tencent/trtc/TRTCStatistics;", "(Ljava/lang/String;Lcom/tencent/trtc/TRTCStatistics;)V", "getStatistic", "()Lcom/tencent/trtc/TRTCStatistics;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class OnStatisticsEvent extends TrtcBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final TRTCStatistics statistic;

    public /* synthetic */ OnStatisticsEvent(String str, TRTCStatistics tRTCStatistics, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : tRTCStatistics);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, tRTCStatistics, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Nullable
    public final TRTCStatistics getStatistic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TRTCStatistics) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.statistic;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnStatisticsEvent(@NotNull String appId, @Nullable TRTCStatistics tRTCStatistics) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.statistic = tRTCStatistics;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appId, (Object) tRTCStatistics);
        }
    }
}
