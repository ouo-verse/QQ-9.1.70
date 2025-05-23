package com.tencent.mobileqq.vas.adv.base.support.app;

import android.content.Context;
import android.view.View;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH&J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0004H&J(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H&J\u001a\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u001a\u001a\u00020\u000bH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "", "Landroid/content/Context;", "f", "", "i", "Ljava/lang/Runnable;", "runnable", "", "networkJob", "autoRetrieve", "", "a", "delay", "d", "", "cmd", "cmdKey", "", "reqBytes", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "callback", "c", "context", PushClientConstants.TAG_PKG_NAME, "isAppInstalled", "initTbsEnvironment", "Landroid/view/View;", "g", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        public static /* synthetic */ void a(c cVar, Runnable runnable, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    z17 = true;
                }
                cVar.a(runnable, z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }

        public static /* synthetic */ void b(c cVar, Runnable runnable, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                cVar.d(runnable, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runOnUiThread");
        }
    }

    void a(@NotNull Runnable runnable, boolean networkJob, boolean autoRetrieve);

    void c(@NotNull String cmd, @NotNull String cmdKey, @NotNull byte[] reqBytes, @NotNull d callback);

    void d(@NotNull Runnable runnable, long delay);

    @NotNull
    Context f();

    @Nullable
    View g();

    long i();

    void initTbsEnvironment();

    boolean isAppInstalled(@NotNull Context context, @Nullable String pkgName);
}
