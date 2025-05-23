package com.tencent.qqmini.minigame.yungame.va;

import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/va/a;", "", "", "process", "", "a", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "b", "reset", "enable", "c", "Lcom/tencent/qqmini/minigame/yungame/va/a$a;", "caller", "d", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/va/a$a;", "", "", "showDualChannelTips", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.yungame.va.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC9397a {
        boolean showDualChannelTips();
    }

    void a(int process);

    void b(boolean r16);

    void c(boolean enable);

    void d(@Nullable InterfaceC9397a caller);

    void reset();
}
