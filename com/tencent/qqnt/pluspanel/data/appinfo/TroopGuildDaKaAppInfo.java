package com.tencent.qqnt.pluspanel.data.appinfo;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/TroopGuildDaKaAppInfo;", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "uinType", "", "(I)V", "dakaAppId", "defaultDrawableID", "getAppID", "getRedDotID", "getTitle", "", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class TroopGuildDaKaAppInfo extends PlusPanelAppInfo {
    static IPatchRedirector $redirector_;
    private final int dakaAppId;

    public TroopGuildDaKaAppInfo(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.dakaAppId = com.tencent.qqnt.pluspanel.utils.a.INSTANCE.r0();
        }
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int defaultDrawableID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (QQTheme.isNowSimpleUI()) {
            return R.drawable.obc;
        }
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            return R.drawable.obb;
        }
        return R.drawable.oba;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getAppID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.dakaAppId;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getRedDotID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.dakaAppId;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String string = BaseApplication.getContext().getString(R.string.f174812wv);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ring.plus_panel_app_daka)");
        return string;
    }
}
