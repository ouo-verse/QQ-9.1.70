package com.tencent.guild.aio.util;

import java.util.Calendar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/util/z;", "", "", "time1", "time2", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z f112475a = new z();

    z() {
    }

    public final boolean a(long time1, long time2) {
        Calendar calendar = Calendar.getInstance();
        long j3 = 1000;
        calendar.setTimeInMillis(time1 * j3);
        int i3 = calendar.get(6);
        int i16 = calendar.get(1);
        calendar.setTimeInMillis(time2 * j3);
        int i17 = calendar.get(6);
        int i18 = calendar.get(1);
        if (i3 == i17 && i16 == i18) {
            return true;
        }
        return false;
    }
}
