package com.tencent.mobileqq.troop.homework.common.upload;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/upload/c;", "", "", "localPath", "", "progress", "", "onProgress", "httpUrl", "onSuccess", "", "errorCode", "errorMsg", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static void a(@NotNull c cVar, @NotNull String localPath, float f16) {
            Intrinsics.checkNotNullParameter(localPath, "localPath");
        }
    }

    void a(@NotNull String localPath, int errorCode, @Nullable String errorMsg);

    void onProgress(@NotNull String localPath, float progress);

    void onSuccess(@NotNull String localPath, @NotNull String httpUrl);
}
