package com.tencent.mobileqq.profile.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profile.api.IAddFriendShareApi;
import com.tencent.mobileqq.profile.util.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ac;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/profile/api/impl/AddFriendShareApiImpl;", "Lcom/tencent/mobileqq/profile/api/IAddFriendShareApi;", "()V", "openMyQRCode", "", "shareSelfToWeiXin", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class AddFriendShareApiImpl implements IAddFriendShareApi {
    static IPatchRedirector $redirector_;

    public AddFriendShareApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profile.api.IAddFriendShareApi
    public void openMyQRCode() {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || !(peekAppRuntime instanceof AppInterface)) {
            return;
        }
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        String currentAccountUin = appInterface.getCurrentAccountUin();
        String f16 = ac.f(appInterface, currentAccountUin);
        Intent intent = new Intent(topActivity, (Class<?>) QRDisplayActivity.class);
        intent.putExtra("from", "ScannerActivity");
        intent.putExtra("my_qrcode_pg_source", "1");
        intent.putExtra("title", HardCodeUtil.qqStr(R.string.g2w));
        intent.putExtra("nick", f16);
        intent.putExtra("uin", currentAccountUin);
        intent.putExtra("type", 1);
        f.c(intent, topActivity);
    }

    @Override // com.tencent.mobileqq.profile.api.IAddFriendShareApi
    public void shareSelfToWeiXin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            e.f260359a.f();
        }
    }
}
