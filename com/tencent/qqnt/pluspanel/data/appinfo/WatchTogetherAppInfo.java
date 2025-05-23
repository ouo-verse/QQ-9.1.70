package com.tencent.qqnt.pluspanel.data.appinfo;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/WatchTogetherAppInfo;", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "uinType", "", "(I)V", "defaultDrawableID", "getAppID", "getRedDotID", "getTitle", "", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class WatchTogetherAppInfo extends PlusPanelAppInfo {
    static IPatchRedirector $redirector_;

    public WatchTogetherAppInfo(int i3) {
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
        return R.drawable.chat_tool_qav_watch_together;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getAppID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (isC2C()) {
            return 0;
        }
        return com.tencent.qqnt.pluspanel.utils.a.INSTANCE.w0();
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getRedDotID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (isC2C()) {
            return 0;
        }
        return getAppID();
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    @Nullable
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "\u4e00\u8d77\u770b";
    }
}
