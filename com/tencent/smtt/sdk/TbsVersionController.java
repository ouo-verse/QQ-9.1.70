package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.exception.BusinessLimitException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsVersionController {

    /* renamed from: a, reason: collision with root package name */
    private static IntervalChoice f369177a = IntervalChoice.SIX_HOUR;

    /* renamed from: b, reason: collision with root package name */
    private static String f369178b = "";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface CallBack {
        void canLocalVersionUsed(int i3, boolean z16);

        void latestVersion(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum IntervalChoice {
        TEN_MINUTE(600000),
        HALF_HOUR(1800000),
        ONE_HOUR(3600000),
        SIX_HOUR(com.tencent.mobileqq.msf.core.auth.d.f247418d),
        TWELVE_HOUR(43200000);

        public final int value;

        IntervalChoice(int i3) {
            this.value = i3;
        }
    }

    public static void checkVersion(Context context, CallBack callBack) {
        throw new BusinessLimitException();
    }

    public static String getExtraUserAgent() {
        return " " + f369178b;
    }

    public static void setCheckInterval(IntervalChoice intervalChoice) {
        throw new UnsupportedOperationException("Current TBS SDK doesn't support");
    }

    public static void setExtraUserAgent(String str) {
        if (str != null) {
            if (str.length() <= 20) {
                f369178b = str;
                return;
            }
            throw new IllegalArgumentException("input ua can not longer then 20, current is " + str);
        }
        throw new IllegalArgumentException("input ua can not be null");
    }
}
