package com.tencent.mobileqq.vas.aio;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/d;", "", "Landroid/content/SharedPreferences;", "c", "", "uin", "keyPrefix", "Lcom/tencent/mobileqq/vas/aio/c;", "b", "", "type", "result", "prefix", "", "e", "", "a", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f308368a = new d();

    d() {
    }

    private final SharedPreferences c() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return null;
        }
        return PreferenceManager.getGlobalPreference(mobileQQ, "sp_zplan_vas");
    }

    private final void e(String uin, int type, VasZplanAIOData result, String prefix) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        String str;
        SharedPreferences c16;
        SharedPreferences.Editor edit3;
        boolean isBlank;
        boolean z16 = true;
        if (type == 1) {
            VasZplanBubble bubble = result.getBubble();
            if (bubble != null) {
                SharedPreferences c17 = f308368a.c();
                if (c17 != null && (edit = c17.edit()) != null) {
                    SharedPreferences.Editor putLong = edit.putLong(prefix + uin + "sp_bubble_key", bubble.getSeq());
                    if (putLong != null) {
                        putLong.apply();
                    }
                }
                QLog.i("ZplanVasAIOSmallHomeSPUtil", 1, "save bubble seq  " + bubble.getSeq());
                return;
            }
            return;
        }
        if (type != 2) {
            JSONObject jSONObject = new JSONObject();
            try {
                VasZplanCycleIcon cycleIcon = result.getCycleIcon();
                if (cycleIcon != null) {
                    jSONObject.put("cycleSeq", cycleIcon.getSeq());
                    jSONObject.put("cycleUrl", cycleIcon.getUrl());
                    jSONObject.put("cycleType", cycleIcon.getType());
                    jSONObject.put("beginTime", cycleIcon.getStartTime());
                    jSONObject.put("endTime", cycleIcon.getEndTime());
                    QLog.i("ZplanVasAIOSmallHomeSPUtil", 1, "save cycle icon  " + cycleIcon);
                }
                try {
                    str = URLEncoder.encode(jSONObject.toString(), "UTF-8");
                } catch (Throwable th5) {
                    QLog.e("ZplanVasAIOSmallHomeSPUtil", 1, "encodeError, ", th5);
                    str = null;
                }
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z16 = false;
                    }
                }
                if (z16 || (c16 = c()) == null || (edit3 = c16.edit()) == null) {
                    return;
                }
                SharedPreferences.Editor putString = edit3.putString(prefix + uin + "sp_bubble_cycle_icon_key", str);
                if (putString != null) {
                    putString.apply();
                    return;
                }
                return;
            } catch (Throwable th6) {
                QLog.e("ZplanVasAIOSmallHomeSPUtil", 1, "saveData, json err, ", th6);
                return;
            }
        }
        VasZplanAdvIcon advIcon = result.getAdvIcon();
        if (advIcon != null) {
            SharedPreferences c18 = f308368a.c();
            if (c18 != null && (edit2 = c18.edit()) != null) {
                SharedPreferences.Editor putLong2 = edit2.putLong(prefix + uin + "sp_bubble_once_icon_key", advIcon.getSeq());
                if (putLong2 != null) {
                    putLong2.apply();
                }
            }
            QLog.i("ZplanVasAIOSmallHomeSPUtil", 1, "save onceIcon seq  " + advIcon.getSeq());
        }
    }

    public final VasZplanAIOData a(long uin) {
        return b(String.valueOf(uin), "small_home_entrance");
    }

    public final void d(long uin, int type, VasZplanAIOData result) {
        Intrinsics.checkNotNullParameter(result, "result");
        e(String.valueOf(uin), type, result, "small_home_entrance");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final VasZplanAIOData b(String uin, String keyPrefix) {
        long j3;
        long j16;
        String str;
        boolean z16;
        int i3;
        String str2;
        JSONObject jSONObject;
        VasZplanBubble vasZplanBubble;
        boolean isBlank;
        SharedPreferences c16 = c();
        if (c16 != null) {
            j3 = c16.getLong(keyPrefix + uin + "sp_bubble_key", 0L);
        } else {
            j3 = 0;
        }
        SharedPreferences c17 = c();
        if (c17 != null) {
            j16 = c17.getLong(keyPrefix + uin + "sp_bubble_once_icon_key", 0L);
        } else {
            j16 = 0;
        }
        VasZplanAIOData vasZplanAIOData = new VasZplanAIOData(0, new VasZplanBubble(j3, null, 0, 6, null), new VasZplanAdvIcon(j16, null, 0, 6, null), new VasZplanCycleIcon(0L, "", 0, 0, 0), null, null, 49, null);
        SharedPreferences c18 = c();
        String str3 = null;
        if (c18 != null) {
            str = c18.getString(keyPrefix + uin + "sp_bubble_cycle_icon_key", null);
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZplanVasAIOSmallHomeSPUtil", 1, "from sp: " + str);
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return vasZplanAIOData;
                }
                try {
                    str3 = URLDecoder.decode(str, "UTF-8");
                } catch (Throwable th5) {
                    QLog.e("ZplanVasAIOSmallHomeSPUtil", 1, "decodeError", th5);
                }
                if (TextUtils.isEmpty(str3)) {
                    return vasZplanAIOData;
                }
                try {
                    jSONObject = new JSONObject(str3);
                    vasZplanBubble = new VasZplanBubble(j3, null, 0, 6, null);
                    i3 = 1;
                    str2 = "ZplanVasAIOSmallHomeSPUtil";
                } catch (Throwable th6) {
                    th = th6;
                    i3 = 1;
                    str2 = "ZplanVasAIOSmallHomeSPUtil";
                }
                try {
                    VasZplanAdvIcon vasZplanAdvIcon = new VasZplanAdvIcon(j16, null, 0, 6, null);
                    long optLong = jSONObject.optLong("cycleSeq", 0L);
                    String optString = jSONObject.optString("cycleUrl", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "cachedJson.optString(Vas\u2026SPConst.iconCycleUrl, \"\")");
                    return new VasZplanAIOData(0, vasZplanBubble, vasZplanAdvIcon, new VasZplanCycleIcon(optLong, optString, jSONObject.optInt("cycleType", 0), jSONObject.optInt("beginTime", 0), jSONObject.optInt("endTime", 0)), null, null, 49, null);
                } catch (Throwable th7) {
                    th = th7;
                    QLog.e(str2, i3, "getDataFromSPCache, json err", th);
                    return vasZplanAIOData;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
