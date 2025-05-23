package com.tencent.biz.pubaccount.weishi.verticalvideo;

import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/c;", "", "", "key", "d", "", "e", "", "a", "f", "b", "c", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f81916a = new c();

    c() {
    }

    private final String d(String key) {
        String str;
        Map<String, String> s16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().s();
        return (s16 == null || (str = s16.get(key)) == null) ? "" : str;
    }

    public final int a() {
        int Y = bb.Y(d("trigger_process"), 110);
        if (Y < 0 || Y > 100) {
            return 110;
        }
        return Y;
    }

    public final int b() {
        return bb.Y(d("icon_style"), -1);
    }

    public final String c() {
        String d16 = d("icon_fix_url");
        return d16 == null ? "" : d16;
    }

    public final boolean e() {
        return Intrinsics.areEqual("1", d(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public final boolean f() {
        return e() && Intrinsics.areEqual("1", d("trigger_with_opr"));
    }
}
