package com.tencent.mobileqq.vas.profilecard.colorscreen.impl;

import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.profilecard.a;
import com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/profilecard/colorscreen/impl/VasColorScreenKuiklyImpl;", "Lcom/tencent/mobileqq/vas/profilecard/colorscreen/IVasColorScreenKuikly;", "", "isEnable", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/vas/profilecard/a;", "getClazz", "", "getScheme", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "toggle", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "enable", "Z", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasColorScreenKuiklyImpl implements IVasColorScreenKuikly {

    @NotNull
    private static final String SCHEME = "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_colorful_screen&bundle_name=vas_colorful_screen&kr_turbo_display=1&modal_mode=1&sync_rendering=0";

    @NotNull
    private static final String TAG = "VasColorScreenKuiklyImpl";
    private final boolean enable;

    @NotNull
    private final UnitedProxy toggle;

    public VasColorScreenKuiklyImpl() {
        UnitedProxy b16 = ar.INSTANCE.b("rizzhuang", "2024-07-08", "vas_kuikly_floatscreen_config");
        this.toggle = b16;
        boolean z16 = false;
        if (!b16.isEnable(false)) {
            QLog.i(TAG, 1, "\u70ab\u5f69\u6d6e\u5c4f \u5f00\u5173\u672a\u5f00\u542f");
        } else {
            QLog.i(TAG, 1, "\u70ab\u5f69\u6d6e\u5c4f \u5f00\u5173\u5f00\u542f");
            z16 = true;
        }
        this.enable = z16;
    }

    @Override // com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly
    @NotNull
    public Class<a> getClazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly
    @NotNull
    public String getScheme() {
        return this.toggle.getStringData(SCHEME);
    }

    @Override // com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly
    /* renamed from: isEnable, reason: from getter */
    public boolean getEnable() {
        return this.enable;
    }
}
