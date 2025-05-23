package com.tencent.aio.api.factory;

import android.content.Context;
import com.tencent.aio.api.factory.h;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\u0005\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u000b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\t\u0012\u0006\b\u0001\u0012\u00020\n0\bH&J\b\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/aio/api/factory/h;", "Lcom/tencent/aio/base/mvvm/a;", "", "a", "d", "Lcom/tencent/aio/api/refreshLoad/e;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "g", "Lcom/tencent/aio/api/list/f;", "b", "Landroid/content/Context;", "context", "", "c", "e", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface j extends h {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static com.tencent.aio.base.mvvm.a<Object, Object> a(@NotNull j jVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.base.mvvm.a<Object, Object> b(@NotNull j jVar) {
            return null;
        }

        public static int c(@NotNull j jVar, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return 0;
        }

        public static int d(@NotNull j jVar, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return 0;
        }

        @Nullable
        public static com.tencent.aio.api.b e(@NotNull j jVar) {
            return h.a.a(jVar);
        }
    }

    @Nullable
    com.tencent.aio.base.mvvm.a<Object, Object> a();

    @NotNull
    com.tencent.aio.api.list.f b();

    int c(@NotNull Context context);

    @Nullable
    com.tencent.aio.base.mvvm.a<Object, Object> d();

    int e(@NotNull Context context);

    @Nullable
    com.tencent.aio.api.refreshLoad.e f();

    @NotNull
    AbsMsgListVB<? extends at.b, ? extends MsgListUiState> g();
}
