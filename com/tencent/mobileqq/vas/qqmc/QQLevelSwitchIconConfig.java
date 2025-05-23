package com.tencent.mobileqq.vas.qqmc;

import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/QQLevelSwitchIconConfig;", "", "()V", "KEY_ENABLE_PAY_TIP", "", "KEY_EXPIRED_PAY_TIS", "KEY_PAY_TIS", "configEnable", "", "mExpiredNotifyPaymentText", "mNotifyPaymentText", "getExpiredNotifyPaymentText", "getNotifyPaymentText", "isNotifyPayment", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QQLevelSwitchIconConfig {

    @NotNull
    private static final String KEY_ENABLE_PAY_TIP = "rushfeeswitch";

    @NotNull
    private static final String KEY_EXPIRED_PAY_TIS = "expiredtips";

    @NotNull
    private static final String KEY_PAY_TIS = "rushfeetips";

    @NotNull
    private static String mExpiredNotifyPaymentText;

    @NotNull
    private static String mNotifyPaymentText;

    @NotNull
    public static final QQLevelSwitchIconConfig INSTANCE = new QQLevelSwitchIconConfig();
    private static final boolean configEnable = VasLongToggle.VAS_QQ_LEVEL_ICON_CONFIG.isEnable(true);

    static {
        mNotifyPaymentText = "";
        mExpiredNotifyPaymentText = "";
        Resources resources = BaseApplication.getContext().getResources();
        String string = resources.getString(R.string.vos);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026.qvip_level_rushfee_tips)");
        mNotifyPaymentText = string;
        String string2 = resources.getString(R.string.vop);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026.qvip_level_expired_tips)");
        mExpiredNotifyPaymentText = string2;
    }

    QQLevelSwitchIconConfig() {
    }

    @NotNull
    public final String getExpiredNotifyPaymentText() {
        if (!configEnable) {
            return mExpiredNotifyPaymentText;
        }
        String stringDataSet = VasLongToggle.VAS_QQ_LEVEL_ICON_CONFIG.getStringDataSet(KEY_EXPIRED_PAY_TIS, mExpiredNotifyPaymentText);
        if (stringDataSet == null) {
            return mExpiredNotifyPaymentText;
        }
        return stringDataSet;
    }

    @NotNull
    public final String getNotifyPaymentText() {
        if (!configEnable) {
            return mNotifyPaymentText;
        }
        String stringDataSet = VasLongToggle.VAS_QQ_LEVEL_ICON_CONFIG.getStringDataSet(KEY_PAY_TIS, mNotifyPaymentText);
        if (stringDataSet == null) {
            return mNotifyPaymentText;
        }
        return stringDataSet;
    }

    public final boolean isNotifyPayment() {
        if (!configEnable) {
            return true;
        }
        return Intrinsics.areEqual(VasLongToggle.VAS_QQ_LEVEL_ICON_CONFIG.getStringDataSet(KEY_ENABLE_PAY_TIP, "1"), "1");
    }
}
