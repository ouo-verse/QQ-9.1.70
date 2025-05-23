package com.tencent.biz.pubaccount.weishi.verticalvideo.onemore;

import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/c;", "", "", "key", "c", "", "d", "", "b", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f82219a = new c();

    c() {
    }

    private final String c(String key) {
        String str;
        Map<String, String> m3 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().m();
        return (m3 == null || (str = m3.get(key)) == null) ? "" : str;
    }

    public final int a() {
        return bb.Y(c("first_insert_pos"), 0);
    }

    public final int b() {
        return bb.Y(c("max_feed_num"), 5);
    }

    public final boolean d() {
        return Intrinsics.areEqual("1", c(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }
}
