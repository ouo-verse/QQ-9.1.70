package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardMiniAppUpdatableMsgOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardMiniAppUpdatableMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    private void l(int i3, String str) {
        this.mActivity.startActivity(BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), new int[]{2}).putExtra("uintype", i3).putExtra("uin", str));
    }

    private void m(int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("miniAppShareIsComplete", true);
        bundle.putInt("uintype", i3);
        bundle.putString("uin", str);
        bundle.putString("miniAppShareAppid", this.mExtraData.getString("miniAppShareAppid"));
        bundle.putString("miniAppShareTemplateId", this.mExtraData.getString("miniAppShareTemplateId"));
        bundle.putInt("miniAppShareUpdatableMsgFrom", this.mExtraData.getInt("miniAppShareUpdatableMsgFrom"));
        bundle.putString("miniAppShareEvent", this.mExtraData.getString("miniAppShareEvent"));
        bundle.putInt("miniAppShareCallbackId", this.mExtraData.getInt("miniAppShareCallbackId"));
        bundle.putInt("miniAppShareSubScene", this.mExtraData.getInt("miniAppShareSubScene"));
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_CREATE_UPDATABLE_MSG_CALLBACK, bundle, null);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
            return;
        }
        if (bundle == null) {
            QLog.e("ForwardMiniAppUpdatableMsgOption", 2, "buildForwardDialog, error, extra is null");
            this.mActivity.finish();
            return;
        }
        int i16 = bundle.getInt("uintype");
        String string = bundle.getString("uin");
        QLog.d("ForwardMiniAppUpdatableMsgOption", 2, "buildForwardDialog, name:" + bundle.getString("uinname") + ", uinType:" + i16 + ", uin:" + string);
        m(i16, string);
        l(i16, string);
        this.mActivity.finish();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void endForwardCallback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        QLog.d("ForwardMiniAppUpdatableMsgOption", 2, "endForwardCallback, isCompleted:" + z16);
        Bundle bundle = new Bundle();
        bundle.putBoolean("miniAppShareIsComplete", false);
        bundle.putString("miniAppShareAppid", this.mExtraData.getString("miniAppShareAppid"));
        bundle.putString("miniAppShareTemplateId", this.mExtraData.getString("miniAppShareTemplateId"));
        bundle.putInt("miniAppShareUpdatableMsgFrom", this.mExtraData.getInt("miniAppShareUpdatableMsgFrom"));
        bundle.putString("miniAppShareEvent", this.mExtraData.getString("miniAppShareEvent"));
        bundle.putInt("miniAppShareCallbackId", this.mExtraData.getInt("miniAppShareCallbackId"));
        bundle.putInt("miniAppShareSubScene", this.mExtraData.getInt("miniAppShareSubScene"));
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_CREATE_UPDATABLE_MSG_CALLBACK, bundle, null);
    }
}
