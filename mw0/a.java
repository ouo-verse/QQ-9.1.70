package mw0;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.icgame.game.liveroom.impl.room.payguide.model.DialogShowValModel;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f417704a = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault());

    private static String a(long j3, int i3) {
        String str = "prefix_qqlive_guide_dialog_" + j3 + "_" + i3 + "_";
        QLog.i("ICGameDialogShowPolicy", 1, "getCurRoomShowKey key=" + str);
        return str;
    }

    public static DialogShowValModel b(long j3, int i3) {
        String a16 = a(j3, i3);
        String f16 = rx0.a.f(a16, "");
        QLog.i("ICGameDialogShowPolicy", 1, "getCurRoomShowKey key=" + a16);
        return DialogShowValModel.getModel(f16);
    }

    private static String c(int i3) {
        String str = "prefix_qqlive_guide_dialog_" + i3 + "_";
        QLog.i("ICGameDialogShowPolicy", 1, "getTodayShowKey key=" + str);
        return str;
    }

    public static DialogShowValModel d(int i3) {
        String c16 = c(i3);
        String f16 = rx0.a.f(c16, "");
        QLog.i("ICGameDialogShowPolicy", 1, "getCurRoomShowKey key=" + c16);
        return DialogShowValModel.getModel(f16);
    }

    public static boolean e(long j3, int i3, int i16, int i17) {
        QLog.i("ICGameDialogShowPolicy", 1, "isShowAtCurRoom roomId=" + j3 + ",activityType=" + i3 + ",roomTimes=" + i16 + ",totalTimes");
        DialogShowValModel d16 = d(i3);
        DialogShowValModel b16 = b(j3, i3);
        boolean z16 = false;
        if (d16 == null || b16 == null ? !(i16 <= 0 || i17 <= 0) : !(d16.hasShowCount >= i17 || b16.hasShowCount >= i16)) {
            z16 = true;
        }
        QLog.i("ICGameDialogShowPolicy", 1, "isShowAtCurRoom isShow=" + z16);
        return z16;
    }

    public static void f(long j3, int i3) {
        DialogShowValModel b16 = b(j3, i3);
        DialogShowValModel d16 = d(i3);
        String format = f417704a.format(Long.valueOf(System.currentTimeMillis()));
        b16.hasShowCount++;
        if (!TextUtils.equals(format, b16.curDate)) {
            b16.curDate = format;
        }
        d16.hasShowCount++;
        if (!TextUtils.equals(format, d16.curDate)) {
            d16.curDate = format;
        }
        rx0.a.k(a(j3, i3), b16.toString());
        rx0.a.k(c(i3), d16.toString());
    }
}
