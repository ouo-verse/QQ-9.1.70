package com.tencent.zplan.utils;

import com.tencent.ams.adcore.mma.api.Global;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/zplan/utils/a;", "", "", "b", "a", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f386200a = new a();

    a() {
    }

    @NotNull
    public final String a() {
        Integer num;
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        if (aVar != null) {
            num = Integer.valueOf(aVar.getCarrier());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            return "\u4e2d\u56fd\u79fb\u52a8";
        }
        if (num != null && num.intValue() == 2) {
            return "\u4e2d\u56fd\u8054\u901a";
        }
        if (num != null && num.intValue() == 3) {
            return "\u4e2d\u56fd\u7535\u4fe1";
        }
        return "\u672a\u77e5\u8fd0\u8425\u5546";
    }

    @NotNull
    public final String b() {
        Integer num;
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        if (aVar != null) {
            num = Integer.valueOf(aVar.getNetWorkType());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            return "";
        }
        if (num != null && num.intValue() == 1) {
            return Global.TRACKING_WIFI;
        }
        if (num != null && num.intValue() == 2) {
            return "2G";
        }
        if (num != null && num.intValue() == 3) {
            return "3G";
        }
        if (num != null && num.intValue() == 4) {
            return "4G";
        }
        if (num != null && num.intValue() == 6) {
            return "5G";
        }
        return "\u672a\u77e5\u7f51\u7edc";
    }
}
