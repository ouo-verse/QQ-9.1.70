package er;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final DateFormat f397040a = new SimpleDateFormat("mm:ss", Locale.CHINA);

    public static String b(long j3) {
        String str;
        String str2;
        String str3;
        long a16 = a(j3);
        long j16 = a16 % 3600000;
        int round = Math.round(((float) (j16 % 60000)) / 1000.0f);
        int i3 = ((int) j16) / 60000;
        int i16 = (int) (a16 / 3600000);
        int i17 = 0;
        if (round == 60) {
            i3++;
            round = 0;
        }
        if (i3 == 60) {
            i16++;
        } else {
            i17 = i3;
        }
        String str4 = "";
        if (round < 10) {
            str = "0" + round;
        } else {
            str = "" + round;
        }
        if (i17 < 10) {
            str2 = "0" + i17;
        } else {
            str2 = "" + i17;
        }
        if (i16 < 10) {
            str3 = "0" + i16;
        } else {
            str3 = "" + i16;
        }
        if (i16 > 0) {
            str4 = str3 + ":";
        }
        return str4 + str2 + ":" + str;
    }

    public static long a(long j3) {
        return Math.max(j3, 0L);
    }
}
