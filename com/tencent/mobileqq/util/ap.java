package com.tencent.mobileqq.util;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u001b\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/util/ap;", "", "", "uin", "", "l", "a", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "featureRuntimeService", "", "d", DomainData.DOMAIN_NAME, "", "g", "e", "f", "b", "c", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", tl.h.F, "i", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "Lcom/tencent/qphone/base/util/BaseApplication;", "mContext", "I", "mResetTime", "mMaxCreateCount", "mMaxRetryCount", "<init>", "()V", "qqconnectface-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ap f306581a = new ap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final BaseApplication mContext = BaseApplication.getContext();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int mResetTime = 1440;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int mMaxCreateCount = 30;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int mMaxRetryCount = 30;

    ap() {
    }

    private final void a(String uin) {
        long serverTime = NetConnInfoCenter.getServerTime() / 60;
        int i3 = mResetTime;
        long j3 = (serverTime / i3) * i3;
        BaseApplication baseApplication = mContext;
        long b16 = cl.b(baseApplication, "face_identification_frequency_control_sp" + uin, "last_reset_time", 0L);
        QLog.i("IdentificationFrequencyController", 2, "checkClearCount curTimeMinute = " + serverTime + ", startTimeMinute = " + j3 + ", lastResetTimeMinute = " + b16);
        if (b16 < j3) {
            cl.k(baseApplication, "face_identification_frequency_control_sp" + uin, "last_reset_time", String.valueOf(j3));
            cl.k(baseApplication, "face_identification_frequency_control_sp" + uin, "cur_create_count", "0");
            cl.k(baseApplication, "face_identification_frequency_control_sp" + uin, "cur_retry_count", "0");
            QLog.i("IdentificationFrequencyController", 2, "clear curCount, lastResetTimeMinute = " + j3);
        }
    }

    private final int b(String uin) {
        return cl.a(mContext, "face_identification_frequency_control_sp" + uin, "cur_create_count", 0);
    }

    private final int c(String uin) {
        return cl.a(mContext, "face_identification_frequency_control_sp" + uin, "cur_retry_count", 0);
    }

    private final Map<String, String> d(IFeatureRuntimeService featureRuntimeService) {
        if (!j(featureRuntimeService)) {
            return new HashMap();
        }
        Map<String, String> isEnabledWithDataSet = featureRuntimeService.isEnabledWithDataSet("face_identification_frequecy_control", "");
        QLog.i("IdentificationFrequencyController", 2, "featureSwitchParams paramMap = " + isEnabledWithDataSet);
        if (isEnabledWithDataSet == null) {
            return new HashMap();
        }
        return isEnabledWithDataSet;
    }

    private final int e(String uin) {
        return cl.a(mContext, "face_identification_frequency_control_sp" + uin, "max_create_count", 30);
    }

    private final int f(String uin) {
        return cl.a(mContext, "face_identification_frequency_control_sp" + uin, "max_retry_count", 30);
    }

    private final int g(String uin) {
        return cl.a(mContext, "face_identification_frequency_control_sp" + uin, "reset_time", 1440);
    }

    private final boolean j(IFeatureRuntimeService featureRuntimeService) {
        if (featureRuntimeService == null) {
            QLog.e("IdentificationFrequencyController", 1, "isFeatureSwitchEnable featureRuntimeService is null");
            return false;
        }
        boolean isFeatureSwitchEnable = featureRuntimeService.isFeatureSwitchEnable("face_identification_frequecy_control");
        QLog.i("IdentificationFrequencyController", 2, "isFeatureSwitchEnable enable = " + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    private final void l(String uin) {
        n(uin);
        a(uin);
    }

    private final void n(String uin) {
        mResetTime = g(uin);
        mMaxCreateCount = e(uin);
        mMaxRetryCount = f(uin);
    }

    public final synchronized void h(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        l(uin);
        int b16 = b(uin) + 1;
        QLog.i("IdentificationFrequencyController", 2, "countFrequency curCreateCount = " + b16);
        cl.k(mContext, "face_identification_frequency_control_sp" + uin, "cur_create_count", String.valueOf(b16));
    }

    public final synchronized void i(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        l(uin);
        int c16 = c(uin) + 1;
        QLog.i("IdentificationFrequencyController", 2, "countFrequency curRetryCount = " + c16);
        cl.k(mContext, "face_identification_frequency_control_sp" + uin, "cur_retry_count", String.valueOf(c16));
    }

    public final boolean k(@NotNull String uin) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        l(uin);
        int b16 = b(uin);
        int i3 = mMaxCreateCount;
        int c16 = c(uin);
        int i16 = mMaxRetryCount;
        if (b16 < i3 && c16 < i16) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.i("IdentificationFrequencyController", 1, "isLimited curCreateCount = " + b16 + " maxCreateCount = " + i3 + " curRetryCount = " + c16 + " maxRetryCount = " + i16 + " result = " + z16);
        return z16;
    }

    public final void m() {
        int i3;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.waitAppRuntime\u2026ava, ProcessConstant.ALL)");
        Map<String, String> d16 = d((IFeatureRuntimeService) runtimeService);
        int i16 = 1440;
        mResetTime = 1440;
        int i17 = 30;
        mMaxCreateCount = 30;
        mMaxRetryCount = 30;
        try {
            String str = d16.get("reset_time");
            if (str != null) {
                i16 = Integer.parseInt(str);
            }
            mResetTime = i16;
            String str2 = d16.get("max_create_count");
            if (str2 != null) {
                i3 = Integer.parseInt(str2);
            } else {
                i3 = 30;
            }
            mMaxCreateCount = i3;
            String str3 = d16.get("max_retry_count");
            if (str3 != null) {
                i17 = Integer.parseInt(str3);
            }
            mMaxRetryCount = i17;
        } catch (NumberFormatException e16) {
            QLog.e("IdentificationFrequencyController", 1, "refreshFeatureSwitch featureSwitchParams = " + d16, e16);
        } catch (JSONException e17) {
            QLog.e("IdentificationFrequencyController", 1, "refreshFeatureSwitch featureSwitchParams = " + d16, e17);
        }
        String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        BaseApplication baseApplication = mContext;
        cl.k(baseApplication, "face_identification_frequency_control_sp" + currentAccountUin, "reset_time", String.valueOf(mResetTime));
        cl.k(baseApplication, "face_identification_frequency_control_sp" + currentAccountUin, "max_create_count", String.valueOf(mMaxCreateCount));
        cl.k(baseApplication, "face_identification_frequency_control_sp" + currentAccountUin, "max_retry_count", String.valueOf(mMaxRetryCount));
        QLog.i("IdentificationFrequencyController", 2, "refreshFeatureSwitch uin = " + currentAccountUin + ", resetTime = " + mResetTime + " maxCreateCount = " + mMaxCreateCount + " maxRetryCount = " + mMaxRetryCount);
    }
}
