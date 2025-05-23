package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.ITextSetting;
import kotlin.Metadata;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TextSettingNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITextSetting;", "()V", "dp2Px", "", "dp", "getChatTextSize", "getChatTextSizeType", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class TextSettingNtImpl implements ITextSetting {
    static IPatchRedirector $redirector_;

    public TextSettingNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int dp2Px(int dp5) {
        return (int) (dp5 * MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITextSetting
    public int getChatTextSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return dp2Px(17);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITextSetting
    public int getChatTextSizeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }
}
