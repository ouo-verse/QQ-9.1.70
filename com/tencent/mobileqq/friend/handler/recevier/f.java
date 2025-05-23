package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import friendlist.GetAutoInfoResp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    public f(@NotNull AppInterface appInterface, @NotNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "friendlist.GetAutoInfoReq";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg toServiceMsg, @NotNull FromServiceMsg fromServiceMsg, @Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            f(toServiceMsg, fromServiceMsg, obj);
        }
    }

    protected void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        Bundle bundle = toServiceMsg.extraData;
        GetAutoInfoResp getAutoInfoResp = (GetAutoInfoResp) obj;
        if (fromServiceMsg.isSuccess() && getAutoInfoResp != null && getAutoInfoResp.errorCode == 0) {
            bundle.putInt("group_id", getAutoInfoResp.cGroupID);
            bundle.putString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, getAutoInfoResp.strRemark);
            d().notifyUI(33, true, bundle);
            return;
        }
        d().notifyUI(33, false, bundle);
    }
}
