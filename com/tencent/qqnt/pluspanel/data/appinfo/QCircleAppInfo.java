package com.tencent.qqnt.pluspanel.data.appinfo;

import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/QCircleAppInfo;", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "uinType", "", "(I)V", "defaultDrawableID", "getAppID", "getManageConfigID", "getRedDotID", "getTitle", "", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class QCircleAppInfo extends PlusPanelAppInfo {
    static IPatchRedirector $redirector_;

    public QCircleAppInfo(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int defaultDrawableID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            return R.drawable.npy;
        }
        return R.drawable.mqn;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getAppID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return com.tencent.qqnt.pluspanel.utils.a.INSTANCE.C();
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getManageConfigID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (isC2C()) {
            return com.tencent.qqnt.pluspanel.utils.a.INSTANCE.x0();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getRedDotID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (isC2C()) {
            return getManageConfigID();
        }
        return getAppID();
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Constants.Business.QQCIRCLE;
    }
}
