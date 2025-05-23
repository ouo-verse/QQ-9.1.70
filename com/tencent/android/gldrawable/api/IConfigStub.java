package com.tencent.android.gldrawable.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/android/gldrawable/api/IConfigStub;", "", "deleteCacheFiles", "", "disable", "init", "isEnable", "", "log", "msg", "", "e", "", "setDebugGL", "isDebug", "setFpsLimit", "limit", "", "setLogger", "logger", "Lcom/tencent/android/gldrawable/api/IReporter;", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public interface IConfigStub {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void log$default(IConfigStub iConfigStub, String str, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    th5 = null;
                }
                iConfigStub.log(str, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
    }

    void deleteCacheFiles();

    void disable();

    void init();

    boolean isEnable();

    void log(@NotNull String msg2, @Nullable Throwable e16);

    void setDebugGL(boolean isDebug);

    void setFpsLimit(int limit);

    void setLogger(@Nullable IReporter logger);
}
