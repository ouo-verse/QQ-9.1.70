package com.tenpay.sdk.net.core.log;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/sdk/net/core/log/ILogAgent;", "", "d", "", "tag", "", "msg", "e", "", "i", "v", "w", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface ILogAgent {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void d$default(ILogAgent iLogAgent, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    th5 = null;
                }
                iLogAgent.d(str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }

        public static /* synthetic */ void e$default(ILogAgent iLogAgent, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    th5 = null;
                }
                iLogAgent.e(str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }

        public static /* synthetic */ void i$default(ILogAgent iLogAgent, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    th5 = null;
                }
                iLogAgent.i(str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }

        public static /* synthetic */ void v$default(ILogAgent iLogAgent, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    th5 = null;
                }
                iLogAgent.v(str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
        }

        public static /* synthetic */ void w$default(ILogAgent iLogAgent, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    th5 = null;
                }
                iLogAgent.w(str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
    }

    void d(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16);

    void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16);

    void i(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16);

    void v(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16);

    void w(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16);
}
