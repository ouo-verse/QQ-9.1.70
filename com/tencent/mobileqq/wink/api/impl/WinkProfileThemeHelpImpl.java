package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u000e\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkProfileThemeHelpImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkProfileThemeHelp;", "", "intentOrBundle", "", "addUseProfileThemeFlag", "Landroid/content/Context;", "context", "", "isWinkIndexAct", "Lh93/a;", "getWinkProfileTheme", "isEnableSwitchOn$delegate", "Lkotlin/Lazy;", "isEnableSwitchOn", "()Z", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkProfileThemeHelpImpl implements IWinkProfileThemeHelp {

    @NotNull
    private static final String TAG = "WinkProfileThemeHelpImpl";

    /* renamed from: isEnableSwitchOn$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isEnableSwitchOn;

    public WinkProfileThemeHelpImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.api.impl.WinkProfileThemeHelpImpl$isEnableSwitchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_profile_theme_switch", true));
            }
        });
        this.isEnableSwitchOn = lazy;
    }

    private final boolean isEnableSwitchOn() {
        return ((Boolean) this.isEnableSwitchOn.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp
    public void addUseProfileThemeFlag(@NotNull Object intentOrBundle) {
        Intrinsics.checkNotNullParameter(intentOrBundle, "intentOrBundle");
        if (intentOrBundle instanceof Intent) {
            ((Intent) intentOrBundle).putExtra(QQWinkConstants.WINK_USE_PROFILE_THEME, true);
        } else if (intentOrBundle instanceof Bundle) {
            ((Bundle) intentOrBundle).putBoolean(QQWinkConstants.WINK_USE_PROFILE_THEME, true);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp
    @NotNull
    public h93.a getWinkProfileTheme(@NotNull Context context, boolean isWinkIndexAct) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        WinkContext.Companion companion = WinkContext.INSTANCE;
        boolean z17 = false;
        if (companion.l() && companion.d().u("QCIRCLE")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isEnableSwitchOn() && (isWinkIndexAct || z16)) {
            z17 = true;
        }
        QLog.d(TAG, 1, "isEnableSwitchOn:" + isEnableSwitchOn() + ", isWinkIndexAct:" + isWinkIndexAct + ", isEntryQCircle:" + z16);
        return new h93.b(context, z17);
    }
}
