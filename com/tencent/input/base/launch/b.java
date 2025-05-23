package com.tencent.input.base.launch;

import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/input/base/launch/b;", "", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "a", "", "actionCode", "Lcom/tencent/mvi/base/route/a;", "action1", "b", "c", "Lcom/tencent/mvi/base/route/b;", "actionR1", "d", "e", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface b {
    void a(@NotNull MsgIntent msgIntent);

    void b(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.a action1);

    void c(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.a action1);

    void d(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.b actionR1);

    void e(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.b actionR1);
}
