package com.tencent.mobileqq.nearby.api;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e {
    public static boolean a(int i3) {
        if (i3 != 0 && i3 != 4) {
            return false;
        }
        return true;
    }

    public static void c(String str) {
        t(str, INearbySPUtil.KEY_NEARBY_RED_DOT_CORNER_TEXT, "");
        t(str, INearbySPUtil.KEY_NEARBY_RED_DOT_ASSIST_TEXT, "");
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return e(str, "NEARBY_FLAG_SP", 4, str2);
    }

    public static boolean e(String str, String str2, int i3, String str3) {
        boolean z16;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3) || !a(i3)) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            z16 = i(str2, str, i3).contains(str3);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b("contains", th5);
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            l.b("contains", str, str2, str3);
        }
        return z16;
    }

    public static boolean f(String str) {
        return ((Boolean) m(str, "dating_recv_msg", Boolean.TRUE)).booleanValue();
    }

    public static boolean g(String str) {
        boolean z16;
        try {
            z16 = ((Boolean) m(str, BaseApplicationImpl.getApplication().getResources().getString(R.string.cyx), Boolean.FALSE)).booleanValue();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b("getLocVisiblityForPeople", th5);
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            l.b("getLocVisiblityForPeople", str, Boolean.valueOf(z16));
        }
        return z16;
    }

    public static SosoLbsInfo h(String str) {
        try {
            JSONObject jSONObject = new JSONObject((String) m(str, INearbySPUtil.KEY_LAST_NEARBY_LOC, ""));
            if (!jSONObject.has(QCircleSchemeAttr.Polymerize.LAT) || !jSONObject.has("lon")) {
                return null;
            }
            SosoLbsInfo sosoLbsInfo = new SosoLbsInfo();
            SosoLocation sosoLocation = new SosoLocation();
            sosoLbsInfo.mLocation = sosoLocation;
            sosoLocation.mLat02 = jSONObject.getDouble(QCircleSchemeAttr.Polymerize.LAT);
            sosoLbsInfo.mLocation.mLon02 = jSONObject.getDouble("lon");
            return sosoLbsInfo;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("NearbySPUtil", 2, "getNearbyLastLocation exp:" + e16.toString());
            return null;
        }
    }

    public static SharedPreferences i(String str, String str2, int i3) {
        return BaseApplicationImpl.getApplication().getSharedPreferences(str + str2, i3);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008f -> B:11:0x0090). Please report as a decompilation issue!!! */
    public static Object k(SharedPreferences sharedPreferences, String str, Object obj) {
        Object obj2;
        if (sharedPreferences == null || TextUtils.isEmpty(str) || obj == null) {
            return obj;
        }
        try {
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b(HippyTextInputController.COMMAND_getValue, th5);
            }
        }
        if (obj.getClass() == Boolean.class) {
            obj2 = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        } else if (obj.getClass() == Integer.class) {
            obj2 = Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        } else if (obj.getClass() == Long.class) {
            obj2 = Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        } else if (obj.getClass() == Float.class) {
            obj2 = Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        } else {
            if (obj.getClass() == String.class) {
                obj2 = sharedPreferences.getString(str, (String) obj);
            }
            obj2 = obj;
        }
        if (QLog.isColorLevel()) {
            l.b(HippyTextInputController.COMMAND_getValue, sharedPreferences, str, obj, obj2, obj.getClass());
        }
        return obj2;
    }

    public static Object l(String str, String str2, int i3, String str3, Object obj) {
        Object obj2;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3) || obj == null || !a(i3)) {
            return obj;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            obj2 = k(i(str2, str, i3), str3, obj);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b(HippyTextInputController.COMMAND_getValue, th5);
            }
            obj2 = obj;
        }
        if (QLog.isColorLevel()) {
            l.b(HippyTextInputController.COMMAND_getValue, str, str2, str3, obj, obj2, obj.getClass());
        }
        return obj2;
    }

    public static Object m(String str, String str2, Object obj) {
        return TextUtils.isEmpty(str) ? obj : l(str, "NEARBY_FLAG_SP", 4, str2, obj);
    }

    public static boolean n(String str) {
        return ((Boolean) m(str, BaseApplicationImpl.getApplication().getResources().getString(R.string.cyf), Boolean.FALSE)).booleanValue();
    }

    public static void o(String str) {
        try {
            SharedPreferences i3 = i(INearbySPUtil.NEARBY_PROCESS_PRELOAD_FILE, str, 4);
            int i16 = i3.getInt(INearbySPUtil.KEY_PRELOAD_UNHIT_COUNT, 0) + 1;
            i3.edit().putInt(INearbySPUtil.KEY_PRELOAD_FAIL_COUNT, 0).putInt(INearbySPUtil.KEY_PRELOAD_UNHIT_COUNT, i16).commit();
            if (QLog.isColorLevel()) {
                l.b("preloadNearbyProcessSuc", INearbySPUtil.KEY_PRELOAD_UNHIT_COUNT, Integer.valueOf(i16));
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static boolean q(String str, boolean z16) {
        return t(str, BaseApplicationImpl.getApplication().getResources().getString(R.string.cyf), Boolean.valueOf(z16));
    }

    public static boolean r(SharedPreferences sharedPreferences, String str, Object obj) {
        boolean z16;
        if (sharedPreferences == null || TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (obj.getClass() == Boolean.class) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj.getClass() == Integer.class) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj.getClass() == Long.class) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj.getClass() == Float.class) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj.getClass() == String.class) {
                edit.putString(str, (String) obj);
            }
            z16 = edit.commit();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b(HippyTextInputController.COMMAND_setValue, th5);
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            l.b(HippyTextInputController.COMMAND_setValue, sharedPreferences, str, obj, Boolean.valueOf(z16), obj.getClass());
        }
        return z16;
    }

    public static boolean s(String str, String str2, int i3, String str3, Object obj) {
        boolean z16;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3) || obj == null || !a(i3)) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            z16 = r(i(str2, str, i3), str3, obj);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b(HippyTextInputController.COMMAND_setValue, th5);
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            l.b(HippyTextInputController.COMMAND_setValue, str, str3, obj, Boolean.valueOf(z16), obj.getClass());
        }
        return z16;
    }

    public static boolean t(String str, String str2, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s(str, "NEARBY_FLAG_SP", 4, str2, obj);
    }

    public static boolean u(String str, boolean z16) {
        boolean z17;
        try {
            String string = BaseApplicationImpl.getApplication().getResources().getString(R.string.cyx);
            SharedPreferences.Editor edit = i("NEARBY_FLAG_SP", str, 4).edit();
            edit.putBoolean(string, z16);
            if (!z16) {
                edit.putLong(INearbySPUtil.NEARBY_ENTER_TIME, 0L).commit();
            }
            z17 = edit.commit();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b("setVisibilityForPeople", th5);
            }
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            l.b("setVisibilityForPeople", str, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        return z17;
    }

    public static boolean v(String str, long j3, int i3) {
        boolean z16;
        try {
            z16 = i("NEARBY_FLAG_SP", str, 4).edit().putLong(INearbySPUtil.VOTE_COUNT, j3).putInt(INearbySPUtil.VOTE_INCREMENT, i3).commit();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                l.b("setVoteInfo", th5);
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            l.b("setVoteInfo", str, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        return z16;
    }

    public static boolean b(String str) {
        int i3;
        int i16;
        boolean z16;
        boolean z17 = true;
        try {
            SharedPreferences i17 = i(INearbySPUtil.NEARBY_PROCESS_PRELOAD_FILE, str, 4);
            i3 = i17.getInt(INearbySPUtil.KEY_PRELOAD_FAIL_COUNT, 0);
            i16 = i17.getInt(INearbySPUtil.KEY_PRELOAD_UNHIT_COUNT, 0);
            z16 = i3 < 2 && i16 < 2;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (!QLog.isColorLevel()) {
                return z16;
            }
            l.b("checkPreload", Integer.valueOf(i3), Integer.valueOf(i16));
            return z16;
        } catch (Throwable th6) {
            th = th6;
            z17 = z16;
            th.printStackTrace();
            return z17;
        }
    }

    public static int j(String str, String str2) {
        return ((Integer) l(str, INearbySPUtil.NEARBY_EVENT_FILE, 4, str2, 0)).intValue();
    }

    public static void p(String str, SosoLbsInfo sosoLbsInfo) {
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, sosoLbsInfo.mLocation.mLat02);
                jSONObject.put("lon", sosoLbsInfo.mLocation.mLon02);
                t(str, INearbySPUtil.KEY_LAST_NEARBY_LOC, jSONObject.toString());
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("NearbySPUtil", 2, "setNearbyLastLocation exp:" + e16.toString());
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("NearbySPUtil", 2, "setNearbyLastLocation, null return, sosoInfo=" + sosoLbsInfo);
        }
    }
}
