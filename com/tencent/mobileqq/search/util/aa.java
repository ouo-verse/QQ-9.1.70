package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    public static int f284983a;

    /* renamed from: b, reason: collision with root package name */
    private static int f284984b;

    public static void a() {
        f284984b = 0;
    }

    public static int b(int i3) {
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 21) {
            return 1;
        }
        return 3;
    }

    public static String c(com.tencent.mobileqq.search.j jVar) {
        if ((jVar instanceof com.tencent.mobileqq.search.d) && jVar.h() != null) {
            int i3 = ((SearchHistory) jVar.h()).type;
            if (i3 != 0) {
                if (i3 == 1) {
                    return "2";
                }
                switch (i3) {
                    case AppConstants.VALUE.UIN_TYPE_UNBIND_PHONE_CONTACT /* 56938 */:
                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_FRIEND /* 56939 */:
                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_SELFUNBIND /* 56940 */:
                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_BIND /* 56941 */:
                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_UNBIND /* 56942 */:
                        return "1";
                    default:
                        return "3";
                }
            }
            return "1";
        }
        return "";
    }

    public static void d(String str) {
        f(str, "", -1);
    }

    public static void e(String str, com.tencent.mobileqq.search.j jVar, int i3) {
        f(str, c(jVar), i3);
    }

    public static void f(String str, String str2, int i3) {
        String valueOf;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i16 = f284983a;
        if (i3 < 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(i3 + 1);
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", str, str, i16, 0, str2, valueOf, "", "");
    }

    public static void g(String str, com.tencent.mobileqq.search.j jVar, int i3) {
        int i16 = 1 << i3;
        if ((f284984b & i16) != 0) {
            return;
        }
        e(str, jVar, i3);
        f284984b |= i16;
    }

    public static void h(String str, boolean z16) {
        int i3;
        if (z16) {
            i3 = Integer.MIN_VALUE;
        } else {
            i3 = 1073741824;
        }
        if ((f284984b & i3) != 0) {
            return;
        }
        d(str);
        f284984b |= i3;
    }

    public static void i() {
        f284984b &= -16777216;
    }
}
