package com.tencent.mobileqq.vas.qqmc;

import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/QVipQidSwitchConfig;", "", "()V", "QID_EDIT_JUMP_URL", "", "QID_SET_DEFAULT_URL", "configEnable", "", "isEnableQid", "qidProfileEnable", "getHomePageUrl", "getQidUrl", "isQidProfileEnable", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QVipQidSwitchConfig {

    @NotNull
    private static final String QID_EDIT_JUMP_URL = "https://club.vip.qq.com/qid/card?wv=16781315&_proxy=1";

    @NotNull
    private static final String QID_SET_DEFAULT_URL = "https://club.vip.qq.com/qid/mine?_wv=16777218&_proxy=1";
    private static final boolean isEnableQid = true;
    private static final boolean qidProfileEnable = true;

    @NotNull
    public static final QVipQidSwitchConfig INSTANCE = new QVipQidSwitchConfig();
    private static final boolean configEnable = VasLongToggle.VAS_QID_NAME_PLATE_CONFIG.isEnable(true);

    QVipQidSwitchConfig() {
    }

    @NotNull
    public final String getHomePageUrl() {
        String stringDataSet;
        if (!configEnable || (stringDataSet = VasLongToggle.VAS_QID_NAME_PLATE_CONFIG.getStringDataSet("homePageUrl", QID_SET_DEFAULT_URL)) == null) {
            return QID_SET_DEFAULT_URL;
        }
        return stringDataSet;
    }

    @NotNull
    public final String getQidUrl() {
        String stringDataSet;
        if (!configEnable || (stringDataSet = VasLongToggle.VAS_QID_NAME_PLATE_CONFIG.getStringDataSet("qidProfileUrl", QID_EDIT_JUMP_URL)) == null) {
            return QID_EDIT_JUMP_URL;
        }
        return stringDataSet;
    }

    public final boolean isEnableQid() {
        if (!configEnable) {
            return true;
        }
        return Intrinsics.areEqual(VasLongToggle.VAS_QID_NAME_PLATE_CONFIG.getStringDataSet("isEnable", "1"), "1");
    }

    public final boolean isQidProfileEnable() {
        if (!configEnable) {
            return true;
        }
        return Intrinsics.areEqual(VasLongToggle.VAS_QID_NAME_PLATE_CONFIG.getStringDataSet("qidProfileEnable", "1"), "1");
    }
}
