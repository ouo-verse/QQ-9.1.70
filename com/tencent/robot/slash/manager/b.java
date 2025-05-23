package com.tencent.robot.slash.manager;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&R\u001c\u0010\u0010\u001a\u00020\u00078&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/slash/manager/b;", "", "", "keyword", "robotUin", "", "d", "", "a", "dismissDialog", "destroy", "c", "e", "()Z", "setWaitingSearchResult", "(Z)V", "isWaitingSearchResult", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {
    boolean a();

    void c();

    void d(@NotNull String keyword, @NotNull String robotUin);

    void destroy();

    void dismissDialog();

    boolean e();
}
