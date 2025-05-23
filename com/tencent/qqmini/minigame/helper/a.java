package com.tencent.qqmini.minigame.helper;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqmini/minigame/helper/a;", "", "", PoiListCacheRecord.TIMESTAMP, "timestamp2", "", "a", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f346475a = new a();

    a() {
    }

    @JvmStatic
    public static final boolean a(long timestamp1, long timestamp2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(timestamp2);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }
}
