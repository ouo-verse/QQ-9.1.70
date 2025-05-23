package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class as {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f255485a;

        static {
            int[] iArr = new int[AppRuntime.Status.values().length];
            f255485a = iArr;
            try {
                iArr[AppRuntime.Status.online.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f255485a[AppRuntime.Status.qme.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f255485a[AppRuntime.Status.away.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f255485a[AppRuntime.Status.busy.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f255485a[AppRuntime.Status.dnd.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f255485a[AppRuntime.Status.invisiable.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static boolean a(AppRuntime.Status status) {
        if (status != AppRuntime.Status.away && status != AppRuntime.Status.busy && status != AppRuntime.Status.dnd) {
            return false;
        }
        return true;
    }

    public static void b(AppRuntime appRuntime) {
        if (appRuntime != null) {
            ReportController.o(appRuntime, "dc00898", "", "", "0X8009DDD", "0X8009DDD", 0, 0, "", "", "", "");
        }
    }

    public static void c(AppRuntime appRuntime, AppRuntime.Status status, long j3, AutoReplyText autoReplyText) {
        int i3;
        if (appRuntime != null && autoReplyText != null && a(status)) {
            if (autoReplyText.getTextId() == Integer.MAX_VALUE) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X8009DDC", "0X8009DDC", i3, 0, "", "", "", "");
        }
    }

    public static void d(AppRuntime appRuntime, boolean z16) {
        String str;
        String str2;
        if (appRuntime != null) {
            if (z16) {
                str = "0X8009DDE";
            } else {
                str = "0X8009DDF";
            }
            if (z16) {
                str2 = "0X8009DDE";
            } else {
                str2 = "0X8009DDF";
            }
            ReportController.o(appRuntime, "dc00898", "", "", str, str2, 0, 0, "", "", "", "");
        }
    }

    public static void e(AppRuntime appRuntime, AppRuntime.Status status, long j3) {
        int i3;
        if (appRuntime != null && status != null) {
            switch (a.f255485a[status.ordinal()]) {
                case 1:
                    i3 = 1;
                    break;
                case 2:
                    i3 = 2;
                    break;
                case 3:
                    i3 = 3;
                    break;
                case 4:
                    i3 = 4;
                    break;
                case 5:
                    i3 = 5;
                    break;
                case 6:
                    i3 = 6;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 == 1 && j3 > 0) {
                i3 = (int) j3;
            }
            int i16 = i3;
            if (i16 != 0) {
                ReportController.o(appRuntime, "dc00898", "", "", "0X8009DDB", "0X8009DDB", i16, 0, "", "", "", "");
            }
        }
    }

    public static void f(AppRuntime appRuntime, AppRuntime.Status status, long j3) {
        int i3;
        String str;
        switch (a.f255485a[status.ordinal()]) {
            case 1:
                i3 = 1;
                break;
            case 2:
                i3 = 2;
                break;
            case 3:
                i3 = 3;
                break;
            case 4:
                i3 = 4;
                break;
            case 5:
                i3 = 5;
                break;
            case 6:
                i3 = 6;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 == 1 && j3 > 0) {
            i3 = (int) j3;
        }
        int i16 = i3;
        if (be.p()) {
            if (((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getAvatarStatusIdByStatusId(status, j3).f256383a)) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X8009DE0", "0X8009DE0", i16, 0, str, "", "", "");
            return;
        }
        ReportController.o(appRuntime, "dc00898", "", "", "0X8009DE0", "0X8009DE0", i16, 0, "", "", "", "");
    }

    public static void g(AppRuntime.Status status, long j3) {
        int i3;
        if (status == null) {
            return;
        }
        switch (a.f255485a[status.ordinal()]) {
            case 1:
                i3 = 1;
                break;
            case 2:
                i3 = 2;
                break;
            case 3:
                i3 = 3;
                break;
            case 4:
                i3 = 4;
                break;
            case 5:
                i3 = 5;
                break;
            case 6:
                i3 = 6;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 == 1 && j3 > 0) {
            i3 = (int) j3;
        }
        bv.b("0X800AF3D", i3);
    }
}
