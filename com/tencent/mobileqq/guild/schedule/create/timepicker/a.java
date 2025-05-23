package com.tencent.mobileqq.guild.schedule.create.timepicker;

import android.content.Context;
import com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements GuildScheduleIphonePickerView.h {

    /* renamed from: a, reason: collision with root package name */
    private final int f233119a;

    /* renamed from: b, reason: collision with root package name */
    private Calendar f233120b = Calendar.getInstance();

    /* renamed from: c, reason: collision with root package name */
    private Calendar f233121c;

    /* renamed from: d, reason: collision with root package name */
    private long f233122d;

    /* renamed from: e, reason: collision with root package name */
    private final int f233123e;

    /* renamed from: f, reason: collision with root package name */
    private final int f233124f;

    public a(long j3) {
        Calendar calendar = Calendar.getInstance();
        this.f233121c = calendar;
        int maximum = calendar.getMaximum(1);
        this.f233119a = maximum;
        this.f233122d = j3;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        int i3 = calendar2.get(1);
        this.f233123e = i3;
        this.f233124f = (int) ((this.f233121c.getTimeInMillis() - this.f233122d) / 86400000);
        QLog.d("Guild.sch.GuildScheduleTimeAdapter", 2, "start_YEAR:" + i3 + ", MAX_YEAR:" + maximum);
    }

    public static b a(Context context, long j3, long j16) {
        a aVar = new a(j3);
        b bVar = new b(context, aVar);
        i(bVar, aVar, j16);
        return bVar;
    }

    private String b(int i3) {
        if (1 == i3) {
            return "\u5468\u65e5";
        }
        if (2 == i3) {
            return "\u5468\u4e00";
        }
        if (3 == i3) {
            return "\u5468\u4e8c";
        }
        if (4 == i3) {
            return "\u5468\u4e09";
        }
        if (5 == i3) {
            return "\u5468\u56db";
        }
        if (6 == i3) {
            return "\u5468\u4e94";
        }
        if (7 == i3) {
            return "\u5468\u516d";
        }
        return "\u672a\u5b9a\u4e49";
    }

    private String c(Calendar calendar) {
        String b16;
        StringBuilder sb5 = new StringBuilder();
        int i3 = this.f233121c.get(1);
        int i16 = this.f233121c.get(2);
        int i17 = this.f233121c.get(5);
        int i18 = this.f233121c.get(7);
        int i19 = this.f233120b.get(1);
        int i26 = this.f233120b.get(2);
        int i27 = this.f233120b.get(5);
        if (i3 == i19 && i16 == i26) {
            if (i17 == i27) {
                b16 = "\u4eca\u5929";
            } else if (i17 - i27 == 1) {
                b16 = "\u660e\u65e5";
            } else {
                b16 = b(i18);
            }
        } else {
            b16 = b(i18);
        }
        sb5.append(String.valueOf(i16 + 1));
        sb5.append("\u6708");
        sb5.append(i17);
        sb5.append("\u65e5");
        sb5.append("  ");
        sb5.append(b16);
        return sb5.toString();
    }

    public static Date d(b bVar, int i3) {
        if (bVar != null && (bVar.n() instanceof a)) {
            a aVar = (a) bVar.n();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(aVar.f233122d + (i3 * 86400000));
            return calendar.getTime();
        }
        return null;
    }

    public static int f(b bVar, int i3) {
        return i3 * 1;
    }

    public static long g(b bVar, int i3, int i16, int i17) {
        if (bVar != null && (bVar.n() instanceof a)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d(bVar, i3));
            calendar.set(11, e(bVar, i16));
            calendar.set(12, f(bVar, i17));
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }
        QLog.w("Guild.sch.GuildScheduleTimeAdapter", 1, "getTimeStamp error:timePicker =null,or timePicker is not created by GuildScheduleTimeAdapter");
        return 0L;
    }

    private static long h(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(11, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        calendar2.set(13, 0);
        calendar2.set(12, 0);
        calendar2.set(11, 0);
        calendar2.set(14, 0);
        return timeInMillis - calendar2.getTimeInMillis();
    }

    public static void i(b bVar, a aVar, long j3) {
        if (bVar != null && aVar != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            int i3 = calendar.get(11);
            int i16 = calendar.get(12) / 1;
            bVar.s(0, (int) (h(j3, aVar.f233122d) / 86400000));
            bVar.s(1, i3);
            bVar.s(2, i16);
        }
    }

    @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView.h
    public int getColumnCount() {
        return 3;
    }

    @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView.h
    public int getRowCount(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return 0;
                }
                return 60;
            }
            return 24;
        }
        return (this.f233119a - this.f233123e) + 1;
    }

    @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView.h
    public String getText(int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i17 = i16 * 1;
                    sb5.append(i17);
                    this.f233121c.set(12, i17);
                }
            } else {
                sb5.append(i16);
                this.f233121c.set(11, i16);
            }
        } else {
            this.f233121c.setTimeInMillis(this.f233122d + (i16 * 86400000));
            sb5.append(c(this.f233121c));
        }
        return sb5.toString();
    }

    public static int e(b bVar, int i3) {
        return i3;
    }
}
