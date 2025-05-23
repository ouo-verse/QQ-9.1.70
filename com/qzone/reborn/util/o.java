package com.qzone.reborn.util;

import com.qzone.util.ToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/util/o;", "", "", "msg", "", "a", "b", "", "msgResId", "type", "c", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f59556a = new o();

    o() {
    }

    public final void a(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    public final void c(int msgResId, int type) {
        d(com.qzone.util.l.a(msgResId), type);
    }

    public final void b(String msg2) {
        if (msg2 != null) {
            f59556a.d(msg2, 1);
        }
    }

    public final void d(String msg2, int type) {
        if (msg2 != null) {
            ToastUtil.s(msg2, type);
        }
    }
}
