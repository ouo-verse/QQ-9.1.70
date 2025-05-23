package com.tencent.gamecenter.wadl.util;

import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/gamecenter/wadl/util/h;", "", "", "d", "", "c", "Ljava/util/Calendar;", "calendarA", "calendarB", "b", "a", "<init>", "()V", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f107667a = new h();

    h() {
    }

    private final boolean a(Calendar calendarA, Calendar calendarB) {
        if (calendarA.get(1) == calendarB.get(1) && calendarA.get(6) == calendarB.get(6)) {
            return true;
        }
        return false;
    }

    private final boolean b(Calendar calendarA, Calendar calendarB) {
        if (calendarA.get(1) == calendarB.get(1) && calendarA.get(3) == calendarB.get(3)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void c() {
        QLog.d("QQGameListStatUtil", 1, "saveRecentStatTs");
        p03.a a16 = p03.a.INSTANCE.a(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        String str = "mmkv_key_game_list_rencent_stat_ts_a";
        long e16 = a16.e("mmkv_key_game_list_rencent_stat_ts_a", 0L);
        long e17 = a16.e("mmkv_key_game_list_rencent_stat_ts_b", 0L);
        if (e16 != 0 && (e17 == 0 || e16 > e17)) {
            str = "mmkv_key_game_list_rencent_stat_ts_b";
        }
        a16.j(str, System.currentTimeMillis());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0061, code lost:
    
        if (r1.b(r0, r3) != false) goto L16;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean d() {
        p03.a a16 = p03.a.INSTANCE.a(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        long e16 = a16.e("mmkv_key_game_list_rencent_stat_ts_a", 0L);
        long e17 = a16.e("mmkv_key_game_list_rencent_stat_ts_b", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (e16 > 0 && e17 > 0) {
            Calendar rencentACalendar = Calendar.getInstance();
            rencentACalendar.setTimeInMillis(e16);
            Calendar rencentBCalendar = Calendar.getInstance();
            rencentBCalendar.setTimeInMillis(e17);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTimeInMillis(currentTimeMillis);
            h hVar = f107667a;
            Intrinsics.checkNotNullExpressionValue(currentCalendar, "currentCalendar");
            Intrinsics.checkNotNullExpressionValue(rencentACalendar, "rencentACalendar");
            if (hVar.b(currentCalendar, rencentACalendar)) {
                Intrinsics.checkNotNullExpressionValue(rencentBCalendar, "rencentBCalendar");
            }
            if (!hVar.a(currentCalendar, rencentACalendar)) {
                Intrinsics.checkNotNullExpressionValue(rencentBCalendar, "rencentBCalendar");
                if (!hVar.a(currentCalendar, rencentBCalendar)) {
                    return true;
                }
            }
            return false;
        }
        if (e16 <= 0 && e17 <= 0) {
            return true;
        }
        long max = Math.max(e16, e17);
        Calendar currentCalendar2 = Calendar.getInstance();
        currentCalendar2.setTimeInMillis(currentTimeMillis);
        Calendar rencentCalendar = Calendar.getInstance();
        rencentCalendar.setTimeInMillis(max);
        h hVar2 = f107667a;
        Intrinsics.checkNotNullExpressionValue(currentCalendar2, "currentCalendar");
        Intrinsics.checkNotNullExpressionValue(rencentCalendar, "rencentCalendar");
        return true ^ hVar2.a(currentCalendar2, rencentCalendar);
    }
}
