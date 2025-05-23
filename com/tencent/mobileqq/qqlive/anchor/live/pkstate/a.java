package com.tencent.mobileqq.qqlive.anchor.live.pkstate;

import hn3.LinkScreenEvent;
import io3.LinkMuteEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/a;", "", "Lhn3/b;", "event", "", "c", "a", "Lio3/a;", "muteEvent", "b", "", "userID", "", "available", "onUserVideoAvailable", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a {
    void a();

    void b(@NotNull LinkMuteEvent muteEvent);

    void c(@NotNull LinkScreenEvent event);

    void onUserVideoAvailable(@NotNull String userID, boolean available);
}
