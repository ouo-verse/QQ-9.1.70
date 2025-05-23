package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/b;", "", "", "time", "", "pattern", "", "a", "b", "<init>", "()V", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f264085a = new b();

    b() {
    }

    private final boolean a(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.SIMPLIFIED_CHINESE);
        return Intrinsics.areEqual(simpleDateFormat.format(date), simpleDateFormat.format(new Date(NetConnInfoCenter.getServerTimeMillis())));
    }

    public final boolean b(long time) {
        return a(time, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }
}
