package com.tencent.mobileqq.main.api;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/main/api/c;", "", "Lcom/tencent/mobileqq/main/api/d;", "proxy", "", "d", "e", "j", "f", h.F, "onPostThemeChanged", "i", "a", "c", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "g", "b", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@UiThread
/* loaded from: classes15.dex */
public interface c {
    void a(@NotNull d proxy);

    void b(@NotNull d proxy, boolean isLogin);

    void c(@NotNull d proxy);

    void d(@NotNull d proxy);

    void e(@NotNull d proxy);

    void f(@NotNull d proxy);

    void g(@NotNull d proxy, boolean isLogin);

    void h(@NotNull d proxy);

    void i(@NotNull d proxy);

    void j(@NotNull d proxy);

    void onPostThemeChanged();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static void a(@NotNull c cVar, @NotNull d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void b(@NotNull c cVar, @NotNull d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void c(@NotNull c cVar, @NotNull d proxy, boolean z16) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void d(@NotNull c cVar, @NotNull d proxy, boolean z16) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void e(@NotNull c cVar, @NotNull d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void f(@NotNull c cVar, @NotNull d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void g(@NotNull c cVar, @NotNull d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void h(@NotNull c cVar, @NotNull d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void j(@NotNull c cVar, @NotNull d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }

        public static void i(@NotNull c cVar) {
        }
    }
}
