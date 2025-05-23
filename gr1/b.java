package gr1;

import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lgr1/b;", "", "", "msgTimeMillis", "", "g", "timeSecond", "", "e", "b", "d", "timeToCompare", "nowTimeMillis", "f", "timeIntervalInSecond", "c", "a", "J", "getDuration", "()J", "setDuration", "(J)V", "duration", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f403085a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long duration = 60;

    b() {
    }

    private final String b(long timeSecond) {
        long j3 = 1000;
        long j16 = timeSecond * j3;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j17 = (timeInMillis - j16) / j3;
        String res = en.p(j16, true, "yy-MM-dd");
        if (j17 >= 0) {
            if (j17 < 86400) {
                if (j17 < 60) {
                    res = "\u521a\u521a";
                } else if (j17 < 3600) {
                    res = (j17 / 60) + "\u5206\u949f\u524d";
                } else {
                    res = (j17 / 3600) + "\u5c0f\u65f6\u524d";
                }
            } else if (f(j16, timeInMillis)) {
                res = "\u6628\u5929";
            } else if (c(j17)) {
                res = (j17 / 86400) + "\u5929\u524d";
            }
        }
        QLog.d("GuildTimeFormatterHelper", 2, "time = ", res, ", now = ", Long.valueOf(timeInMillis), ", msgTimeMillis = ", Long.valueOf(j16));
        Intrinsics.checkNotNullExpressionValue(res, "res");
        return res;
    }

    private final boolean c(long timeIntervalInSecond) {
        if (timeIntervalInSecond > 86400 && timeIntervalInSecond < JoinTimeType.SEVEN_DAY) {
            return true;
        }
        return false;
    }

    private final boolean d(long msgTimeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(msgTimeMillis);
        if (calendar.get(1) == Calendar.getInstance().get(1)) {
            return true;
        }
        return false;
    }

    private final boolean e(long timeSecond) {
        if ((Calendar.getInstance().getTimeInMillis() / 1000) - timeSecond < JoinTimeType.SEVEN_DAY) {
            return true;
        }
        return false;
    }

    private final boolean f(long timeToCompare, long nowTimeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(nowTimeMillis);
        calendar.add(6, -1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(timeToCompare);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }

    private final String g(long msgTimeMillis) {
        if (d(msgTimeMillis)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(msgTimeMillis);
            int i3 = calendar.get(2) + 1;
            int i16 = calendar.get(5);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format + "-" + format2;
        }
        String p16 = en.p(msgTimeMillis, true, "yy-MM-dd");
        Intrinsics.checkNotNullExpressionValue(p16, "{\n            TimeFormat\u2026ue, \"yy-MM-dd\")\n        }");
        return p16;
    }

    @NotNull
    public final String a(long timeSecond) {
        if (e(timeSecond)) {
            return b(timeSecond);
        }
        return g(timeSecond * 1000);
    }
}
