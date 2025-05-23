package o4;

import com.qzone.album.util.QZoneAlbumUtil;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static String a() {
        Calendar calendar = Calendar.getInstance();
        if (calendar != null) {
            return calendar.get(1) + "." + (calendar.get(2) + 1) + "." + calendar.get(5);
        }
        return "";
    }

    public static void c(int i3, boolean z16) {
        String str = "7";
        if (i3 != 1) {
            if (i3 == 8) {
                str = "2";
            } else if (i3 == 9) {
                str = "3";
            } else if (i3 == 11) {
                str = "4";
            } else if (i3 == 12) {
                str = "5";
            }
        } else if (z16) {
            str = "6";
        }
        com.qzone.album.env.common.a.m().P(368, 2, str, true, null);
    }

    public static String b(long j3, int i3) {
        if (j3 != 0) {
            return (QZoneAlbumUtil.k(j3) + i3) + "." + QZoneAlbumUtil.h(j3) + "." + QZoneAlbumUtil.g(j3);
        }
        return "";
    }
}
