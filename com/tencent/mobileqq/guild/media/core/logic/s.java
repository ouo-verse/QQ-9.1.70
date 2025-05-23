package com.tencent.mobileqq.guild.media.core.logic;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/s;", "", "", "privateMapKey", "", "a", "", "enable", "needCheckRsp", tl.h.F, "g", "needSet", "d", "b", "needLaunchImmediately", "e", "c", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface s {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static /* synthetic */ void a(s sVar, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z17 = false;
                }
                sVar.h(z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportScreenState");
        }
    }

    void a(@NotNull String privateMapKey);

    boolean b();

    void c();

    void d(boolean needSet);

    void e(boolean needLaunchImmediately);

    void f();

    void g();

    void h(boolean enable, boolean needCheckRsp);
}
