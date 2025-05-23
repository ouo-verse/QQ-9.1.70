package com.tencent.mobileqq.vas.profilecard.diybg.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.ab.ABTest;
import com.tencent.mobileqq.vas.ab.b;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.profilecard.diybg.IVasDiyCardBgKuikly;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/profilecard/diybg/impl/VasDiyCardBgKuiklyImpl;", "Lcom/tencent/mobileqq/vas/profilecard/diybg/IVasDiyCardBgKuikly;", "", "isEnable", "", "getScheme", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "toggle", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "Z", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasDiyCardBgKuiklyImpl implements IVasDiyCardBgKuikly {

    @NotNull
    private static final String DIY_CARD_KUIKLY_SCHEME = "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_diy_card_bg_menu&bundle_name=vas_diy_card_bg&kr_turbo_display=1&modal_mode=1";

    @NotNull
    private static final String TAG = "VasDiyCardBgKuiklyImpl";
    private final boolean isEnable;

    @NotNull
    private final UnitedProxy toggle;

    public VasDiyCardBgKuiklyImpl() {
        UnitedProxy b16 = ar.INSTANCE.b("rizzhuang", "2024-08-30", "vas_diy_card_bg_kuikly_config");
        this.toggle = b16;
        this.isEnable = b16.isEnable(false);
    }

    @Override // com.tencent.mobileqq.vas.profilecard.diybg.IVasDiyCardBgKuikly
    @NotNull
    public String getScheme() {
        String optString = this.toggle.getJson().optString(ZPlanPublishSource.FROM_SCHEME, DIY_CARD_KUIKLY_SCHEME);
        Intrinsics.checkNotNullExpressionValue(optString, "toggle.getJson().optStri\u2026, DIY_CARD_KUIKLY_SCHEME)");
        return optString;
    }

    @Override // com.tencent.mobileqq.vas.profilecard.diybg.IVasDiyCardBgKuikly
    public boolean isEnable() {
        if (!this.isEnable) {
            QLog.i(TAG, 1, "DIY\u540d\u7247\u80cc\u666f \u5f00\u5173\u672a\u5f00\u542f");
            return false;
        }
        if (this.toggle.getJson().optInt(FileReaderHelper.OPEN_FILE_FROM_FORCE) == 1) {
            QLog.i(TAG, 1, "DIY\u540d\u7247\u80cc\u666f \u5f3a\u5236\u5f00\u542f");
            return true;
        }
        String abTestName = this.toggle.getJson().optString("abtest_name");
        if (TextUtils.isEmpty(abTestName)) {
            QLog.i(TAG, 1, "DIY\u540d\u7247\u80cc\u666f \u672a\u914d\u7f6eab\u5b9e\u9a8c\u540d\u79f0");
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(abTestName, "abTestName");
        ABTest component1 = new b(abTestName).a().component1();
        if (component1 == ABTest.B) {
            QLog.i(TAG, 1, "DIY\u540d\u7247\u80cc\u666f \u547d\u4e2d\u5b9e\u9a8c\u7ec4");
            return true;
        }
        QLog.i(TAG, 1, "DIY\u540d\u7247\u80cc\u666f \u547d\u4e2d\u5bf9\u7167\u7ec4 \u6216 miss: " + component1);
        return false;
    }
}
