package com.tencent.biz.pubaccount.weishi.teenmode;

import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0003\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/teenmode/f;", "", "", "c", "", "a", "", "key", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f81610a = new f();

    f() {
    }

    @JvmStatic
    public static final int a() {
        return bb.Y(b("interval_days"), 0);
    }

    @JvmStatic
    private static final String b(String key) {
        String str;
        Map<String, String> u16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().u();
        return (u16 == null || (str = u16.get(key)) == null) ? "" : str;
    }

    @JvmStatic
    public static final boolean c() {
        return Intrinsics.areEqual("1", b("show"));
    }
}
