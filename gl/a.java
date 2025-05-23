package gl;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lgl/a;", "", "", "i", "", "a", "", "time", "Ljava/util/Calendar;", "now", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f402373a = new a();

    a() {
    }

    public final String b(long time, Calendar now) {
        Intrinsics.checkNotNullParameter(now, "now");
        long g16 = com.qzone.proxy.feedcomponent.util.c.g(now);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        long timeInMillis = now.getTimeInMillis() - time;
        long j3 = g16 - time;
        int i3 = calendar.get(11);
        int i16 = calendar.get(12);
        if (timeInMillis >= 0) {
            if (j3 < 0) {
                return a(i3) + ":" + a(i16);
            }
            if (j3 < 86400000) {
                return "\u6628\u5929 " + a(i3) + ":" + a(i16);
            }
            if (j3 <= 172800500) {
                return "\u524d\u5929 " + a(i3) + ":" + a(i16);
            }
        } else if (j3 < 0 && com.qzone.proxy.feedcomponent.util.c.i(now.getTimeInMillis(), time)) {
            return a(i3) + ":" + a(i16);
        }
        int i17 = calendar.get(1);
        int i18 = calendar.get(2) + 1;
        int i19 = calendar.get(5);
        if (now.get(1) != i17) {
            return i17 + "-" + a(i18) + "-" + a(i19);
        }
        return a(i18) + "-" + a(i19);
    }

    private final String a(int i3) {
        if (i3 < 10) {
            return "0" + i3;
        }
        return String.valueOf(i3);
    }

    public static /* synthetic */ String c(a aVar, long j3, Calendar calendar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        }
        return aVar.b(j3, calendar);
    }
}
