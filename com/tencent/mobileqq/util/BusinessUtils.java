package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.crashdefend.report.ReportSaveInfoHelper;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BusinessUtils extends Utils {
    public static boolean X(Context context) {
        if (context != null && !TextUtils.isEmpty(Utils.f306522e) && !TextUtils.isEmpty(Utils.f306522e.trim())) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", Utils.f306522e.trim());
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    public static void Z(AppRuntime appRuntime, final String str) {
        if (!(appRuntime instanceof QQAppInterface)) {
            return;
        }
        final QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.util.BusinessUtils.1
            @Override // java.lang.Runnable
            public void run() {
                QQAppInterface.this.mLoginTime = NetConnInfoCenter.getServerTime();
            }
        }, null, false);
        try {
            StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact(str);
            QQCrashReportManager.d(str);
            ReportSaveInfoHelper.l(qQAppInterface.getApplicationContext(), str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("login", 2, "loginSuccess throwable: " + th5);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("login", 2, "loginSuccess set CURRENT_ACCOUNT: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.k
                @Override // java.lang.Runnable
                public final void run() {
                    AutoLoginUtil.setAutoLogin(str, true);
                }
            }, 64, null, false);
        } else {
            AutoLoginUtil.setAutoLogin(str, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> a0(String str, int i3, int i16, ArrayList<AtTroopMemberInfo> arrayList, ArrayList<ArrayList<AtTroopMemberInfo>> arrayList2) {
        AtTroopMemberInfo atTroopMemberInfo;
        int f16;
        String str2;
        String str3;
        String str4;
        String str5;
        int i17;
        int i18;
        int i19;
        int i26;
        short s16;
        String str6 = str;
        ArrayList<AtTroopMemberInfo> arrayList3 = arrayList;
        ArrayList<String> arrayList4 = new ArrayList<>();
        int length = str.length();
        StringBuilder sb5 = new StringBuilder();
        int i27 = 0;
        ArrayList<AtTroopMemberInfo> arrayList5 = null;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        while (i27 < length) {
            int codePointAt = str6.codePointAt(i27);
            if (arrayList3 != null) {
                while (i28 < arrayList.size()) {
                    atTroopMemberInfo = arrayList3.get(i28);
                    if (atTroopMemberInfo != null && atTroopMemberInfo.isValid()) {
                        break;
                    }
                    i28++;
                }
            }
            atTroopMemberInfo = null;
            if (atTroopMemberInfo != null && (s16 = atTroopMemberInfo.startPos) == i27) {
                str2 = str6.substring(s16, atTroopMemberInfo.textLen + s16);
                f16 = Utils.g(str2) + 11 + 8;
                atTroopMemberInfo.startPos = (short) (atTroopMemberInfo.startPos + i29);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList<>();
                }
                arrayList5.add(atTroopMemberInfo);
                i28++;
            } else {
                if (codePointAt == 20) {
                    int i37 = i27 + 1;
                    if (i37 < length && (str6.charAt(i37) == '\u00ff' || str6.charAt(i37) == '\u01ff')) {
                        str2 = null;
                        f16 = 20;
                    } else if (i37 < length && str6.charAt(i37) >= '\u0104') {
                        f16 = 40;
                    } else {
                        f16 = 12;
                    }
                } else {
                    f16 = Utils.f(codePointAt);
                }
                str2 = null;
            }
            i36 += f16;
            int i38 = i28;
            if (i36 > i3) {
                String sb6 = sb5.toString();
                if (arrayList5 != null) {
                    str4 = "TroopMemberUtil";
                    str5 = "there is no other char behind EMO_HEAD_CODE,msg is:";
                    i17 = f16;
                    i18 = 0;
                    sb5.setLength(0);
                } else {
                    int length2 = sb6.length() - i16;
                    i17 = f16;
                    str4 = "TroopMemberUtil";
                    int i39 = 0;
                    int i46 = -1;
                    while (true) {
                        char[] cArr = Utils.f306518a;
                        if (i39 < cArr.length) {
                            i26 = sb6.lastIndexOf(cArr[i39]);
                            if (i26 > length2) {
                                break;
                            }
                            i39++;
                            i46 = i26;
                        } else {
                            i26 = i46;
                            break;
                        }
                    }
                    int lastIndexOf = sb6.lastIndexOf(20);
                    if (i26 > length2 && lastIndexOf == -1) {
                        int i47 = i26 + 1;
                        String substring = sb5.substring(0, i47);
                        String substring2 = sb5.substring(i47);
                        sb5.setLength(0);
                        int g16 = Utils.g(substring2);
                        sb5.append(substring2);
                        str5 = "there is no other char behind EMO_HEAD_CODE,msg is:";
                        sb6 = substring;
                        i19 = g16;
                    } else {
                        int i48 = lastIndexOf - 2;
                        if (i48 >= 0) {
                            str5 = "there is no other char behind EMO_HEAD_CODE,msg is:";
                            if (sb6.charAt(lastIndexOf - 1) == '\u00ff' && sb6.charAt(i48) == 20) {
                                lastIndexOf -= 2;
                            }
                        } else {
                            str5 = "there is no other char behind EMO_HEAD_CODE,msg is:";
                        }
                        if (lastIndexOf > length2) {
                            String substring3 = sb5.substring(0, lastIndexOf);
                            String substring4 = sb5.substring(lastIndexOf);
                            sb5.setLength(0);
                            i19 = Utils.g(substring4);
                            sb5.append(substring4);
                            sb6 = substring3;
                        } else {
                            i18 = 0;
                            sb5.setLength(0);
                        }
                    }
                    i29 -= sb6.length();
                    arrayList4.add(sb6);
                    arrayList2.add(arrayList5);
                    if (str2 == null) {
                        sb5.append(str2);
                        if (atTroopMemberInfo != null) {
                            i27 += atTroopMemberInfo.textLen - 1;
                        }
                    } else if (codePointAt > 65535) {
                        sb5.appendCodePoint(codePointAt);
                        i27++;
                    } else {
                        sb5.append((char) codePointAt);
                    }
                    if (codePointAt == 20) {
                        int i49 = i27 + 1;
                        if (i49 >= length) {
                            if (QLog.isColorLevel()) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(str5);
                                str3 = str;
                                sb7.append(str3);
                                QLog.e(str4, 2, sb7.toString());
                            }
                        } else {
                            str3 = str;
                            if ('\u00ff' == str3.charAt(i49)) {
                                int i56 = i27 + 4;
                                if (i56 < length) {
                                    sb5.append(str3.charAt(i49));
                                    sb5.append(str3.charAt(i27 + 2));
                                    sb5.append(str3.charAt(i27 + 3));
                                    sb5.append(str3.charAt(i56));
                                    i27 = i56;
                                }
                            } else {
                                sb5.append(str3.charAt(i49));
                                i27 = i49;
                            }
                        }
                        i36 = i19 + i17;
                        arrayList5 = null;
                    }
                    str3 = str;
                    i36 = i19 + i17;
                    arrayList5 = null;
                }
                i19 = i18;
                i29 -= sb6.length();
                arrayList4.add(sb6);
                arrayList2.add(arrayList5);
                if (str2 == null) {
                }
                if (codePointAt == 20) {
                }
                str3 = str;
                i36 = i19 + i17;
                arrayList5 = null;
            } else {
                str3 = str6;
                if (str2 != null) {
                    sb5.append(str2);
                    if (atTroopMemberInfo != null) {
                        i27 += atTroopMemberInfo.textLen - 1;
                    }
                } else if (codePointAt > 65535) {
                    sb5.appendCodePoint(codePointAt);
                    i27++;
                } else {
                    sb5.append((char) codePointAt);
                }
                if (codePointAt == 20) {
                    int i57 = i27 + 1;
                    if (i57 >= length) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopMemberUtil", 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + str3);
                        }
                    } else if ('\u00ff' == str3.charAt(i57)) {
                        int i58 = i27 + 4;
                        if (i58 < length) {
                            sb5.append(str3.charAt(i57));
                            sb5.append(str3.charAt(i27 + 2));
                            sb5.append(str3.charAt(i27 + 3));
                            sb5.append(str3.charAt(i58));
                            i27 = i58;
                        }
                    } else {
                        sb5.append(str3.charAt(i57));
                        i27 = i57;
                    }
                }
            }
            i27++;
            arrayList3 = arrayList;
            str6 = str3;
            i28 = i38;
        }
        if (sb5.length() > 0) {
            arrayList4.add(sb5.toString());
            arrayList2.add(arrayList5);
        }
        return arrayList4;
    }
}
