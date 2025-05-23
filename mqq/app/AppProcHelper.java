package mqq.app;

import android.content.Context;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;

/* loaded from: classes28.dex */
public class AppProcHelper {
    public static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";

    public static String getLocalVerify(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    public static boolean isContainsProc(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = MobileQQ.processName;
            if (str != null && str.equals(arrayList.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLegalBroadcast(String str, ArrayList<String> arrayList) {
        if (Foreground.getActivityCount() > 0 || str == null || str.length() == 0) {
            return false;
        }
        if (!str.equals(getLocalVerify(arrayList, false)) && !str.equals(getLocalVerify(arrayList, true))) {
            return false;
        }
        return true;
    }
}
