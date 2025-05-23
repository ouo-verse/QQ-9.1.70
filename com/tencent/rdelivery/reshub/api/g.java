package com.tencent.rdelivery.reshub.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/g;", "", "", "getResId", "e", "", "getVersion", "getSize", "baseResVersion", "c", "a", "b", "d", "getDescription", "getTaskId", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface g {
    @Nullable
    String a();

    @Nullable
    String b();

    long c(long baseResVersion);

    @Nullable
    String d();

    @NotNull
    String e();

    @Nullable
    String getDescription();

    @NotNull
    String getResId();

    long getSize();

    @Nullable
    String getTaskId();

    long getVersion();
}
