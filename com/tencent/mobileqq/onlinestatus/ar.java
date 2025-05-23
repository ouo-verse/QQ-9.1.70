package com.tencent.mobileqq.onlinestatus;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    public static final AppRuntime.Status[] f255483a = {AppRuntime.Status.online, AppRuntime.Status.qme, AppRuntime.Status.away, AppRuntime.Status.busy, AppRuntime.Status.dnd, AppRuntime.Status.invisiable};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f255484a;

        static {
            int[] iArr = new int[AppRuntime.Status.values().length];
            f255484a = iArr;
            try {
                iArr[AppRuntime.Status.online.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f255484a[AppRuntime.Status.qme.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f255484a[AppRuntime.Status.away.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f255484a[AppRuntime.Status.busy.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f255484a[AppRuntime.Status.dnd.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f255484a[AppRuntime.Status.invisiable.ordinal()] = 6;
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

    public static int b(AppRuntime.Status status) {
        if (status == null) {
            return R.id.f163894bh;
        }
        switch (a.f255484a[status.ordinal()]) {
            case 1:
                return R.id.f163894bh;
            case 2:
                return R.id.f163895bi;
            case 3:
                return R.id.f163890bc;
            case 4:
                return R.id.f163891bd;
            case 5:
                return R.id.f163892be;
            case 6:
                return R.id.f163893bf;
            default:
                QLog.d(LogTag.TAG_ONLINE_STATUS, 1, "getButtonId changed to online , status: " + status);
                return R.id.f163894bh;
        }
    }

    public static Drawable c(AppRuntime.Status status) {
        return d(status, 0);
    }

    public static Drawable d(AppRuntime.Status status, int i3) {
        Drawable drawable;
        Drawable drawable2 = null;
        try {
            if (status != null) {
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                switch (a.f255484a[status.ordinal()]) {
                    case 1:
                        drawable = mobileQQ.getResources().getDrawable(R.drawable.bzf);
                        drawable2 = drawable;
                        break;
                    case 2:
                        drawable = mobileQQ.getResources().getDrawable(R.drawable.bzh);
                        drawable2 = drawable;
                        break;
                    case 3:
                        drawable = mobileQQ.getResources().getDrawable(R.drawable.bz7);
                        drawable2 = drawable;
                        break;
                    case 4:
                        drawable = mobileQQ.getResources().getDrawable(R.drawable.bz9);
                        drawable2 = drawable;
                        break;
                    case 5:
                        drawable = mobileQQ.getResources().getDrawable(R.drawable.bzb);
                        drawable2 = drawable;
                        break;
                    case 6:
                        drawable = mobileQQ.getResources().getDrawable(R.drawable.bzd);
                        drawable2 = drawable;
                        break;
                    default:
                        QLog.d(LogTag.TAG_ONLINE_STATUS, 1, "getStatusIcon, not find status: " + status);
                        break;
                }
            } else {
                QLog.d(LogTag.TAG_ONLINE_STATUS, 1, "getStatusIcon, status == null");
            }
        } catch (Exception e16) {
            QLog.d(LogTag.TAG_ONLINE_STATUS, 1, "getStatusDrawable", e16);
        }
        if (drawable2 != null && i3 > 0) {
            drawable2.setBounds(0, 0, i3, i3);
        }
        return drawable2;
    }

    public static AppRuntime.Status e(int i3) {
        switch (i3) {
            case 1:
                return AppRuntime.Status.online;
            case 2:
                return AppRuntime.Status.offline;
            case 3:
                return AppRuntime.Status.away;
            case 4:
                return AppRuntime.Status.invisiable;
            case 5:
                return AppRuntime.Status.busy;
            case 6:
                return AppRuntime.Status.qme;
            case 7:
                return AppRuntime.Status.dnd;
            default:
                return null;
        }
    }

    public static String f(AppRuntime.Status status) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (status != null) {
            switch (a.f255484a[status.ordinal()]) {
                case 1:
                    return mobileQQ.getString(R.string.hpt);
                case 2:
                    return mobileQQ.getString(R.string.hpu);
                case 3:
                    return mobileQQ.getString(R.string.hpd);
                case 4:
                    return mobileQQ.getString(R.string.hpg);
                case 5:
                    return mobileQQ.getString(R.string.hpm);
                case 6:
                    return mobileQQ.getString(R.string.hpp);
                default:
                    QLog.d(LogTag.TAG_ONLINE_STATUS, 1, "getStatusName, not find status: " + status);
                    break;
            }
        } else {
            QLog.d(LogTag.TAG_ONLINE_STATUS, 1, "getStatusName, status is null");
        }
        return "";
    }
}
