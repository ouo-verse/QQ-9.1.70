package com.tencent.mobileqq.vas.qqmc;

import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/QVipAutoPttConfig;", "", "()V", "TAG", "", "configEnable", "", "defaultPayUrl", "defaultStage", "", "getPayUrl", "getStage", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QVipAutoPttConfig {

    @NotNull
    private static final String TAG = "QVipAutoPttConfig";

    @NotNull
    private static final String defaultPayUrl = "https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&type=!svip&aid={aid}";
    private static final int defaultStage = 3;

    @NotNull
    public static final QVipAutoPttConfig INSTANCE = new QVipAutoPttConfig();
    private static final boolean configEnable = VasLongToggle.VAS_VOICE_TO_TEXT_STAGE_GRAY_CONFIG.isEnable(true);

    QVipAutoPttConfig() {
    }

    @NotNull
    public final String getPayUrl() {
        if (!configEnable) {
            return defaultPayUrl;
        }
        try {
            String stringDataSet = VasLongToggle.VAS_VOICE_TO_TEXT_STAGE_GRAY_CONFIG.getStringDataSet("pay_url", defaultPayUrl);
            if (stringDataSet == null) {
                return defaultPayUrl;
            }
            return stringDataSet;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse error " + e16);
            return defaultPayUrl;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getStage() {
        Integer intOrNull;
        if (!configEnable) {
            return 3;
        }
        try {
            String stringDataSet = VasLongToggle.VAS_VOICE_TO_TEXT_STAGE_GRAY_CONFIG.getStringDataSet("stage", "3");
            if (stringDataSet == null || intOrNull == null) {
                return 3;
            }
            return intOrNull.intValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse error " + e16);
            return 3;
        }
    }
}
