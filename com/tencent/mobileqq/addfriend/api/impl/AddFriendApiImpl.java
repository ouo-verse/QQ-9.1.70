package com.tencent.mobileqq.addfriend.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.processor.switchprocessor.AddFriendSettingProcessor;
import com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment;
import com.tencent.mobileqq.addfriend.ui.fornt.AddFriendForNtLauncher;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$FriendSysMsg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendApiImpl implements IAddFriendApi {
    static IPatchRedirector $redirector_;

    public AddFriendApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public void addOpenId(String str, OpenID openID, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, openID, appRuntime);
        } else {
            com.tencent.mobileqq.addfriend.helper.b.b().a(str, openID);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public boolean couldAddFriendSuccessDirectly(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
        }
        return com.tencent.mobileqq.addfriend.utils.a.d(i3, i16, z16);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public int countByByte(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        return com.tencent.mobileqq.addfriend.utils.a.e(str);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public String getGroupName(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, i3);
        }
        return com.tencent.mobileqq.addfriend.utils.a.i(appInterface, i3);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public int getLocalSelfAddFriendSetting(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appRuntime)).intValue();
        }
        return AddFriendSettingProcessor.b(appRuntime);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public String getRemark(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.addfriend.utils.a.j(str);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public void getSelfAddFriendSetting(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) appRuntime);
        } else {
            AddFriendSettingProcessor.c(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public String getsOpenId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (com.tencent.mobileqq.util.e.c()) {
            return AddFriendForNtLauncher.ph();
        }
        return AddFriendCheckFragment.Sh();
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public boolean isIfShowAFDlg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (com.tencent.mobileqq.util.e.c()) {
            return AddFriendForNtLauncher.rh();
        }
        return AddFriendCheckFragment.Yh();
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public void launchAddFriend(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) intent);
        } else if (com.tencent.mobileqq.util.e.c()) {
            AddFriendForNtLauncher.sh(context, intent);
        } else {
            AddFriendCheckFragment.bi(context, intent);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public void launchAddFriendForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, activity, intent, Integer.valueOf(i3));
        } else if (com.tencent.mobileqq.util.e.c()) {
            AddFriendForNtLauncher.th(activity, intent, i3);
        } else {
            AddFriendCheckFragment.ci(activity, intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public void setIfShowAFDlg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else if (com.tencent.mobileqq.util.e.c()) {
            AddFriendForNtLauncher.uh(z16);
        } else {
            AddFriendCheckFragment.fi(z16);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public void setsOpenId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else if (com.tencent.mobileqq.util.e.c()) {
            AddFriendForNtLauncher.vh(str);
        } else {
            AddFriendCheckFragment.gi(str);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public boolean shouldReqAutoInfo(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str)).booleanValue();
        }
        return com.tencent.mobileqq.addfriend.utils.a.o(i3, str);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public boolean shouldUseLocalRemark(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        return com.tencent.mobileqq.addfriend.utils.a.p(i3);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, this, context, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, str5, str6, str7);
        }
        if (com.tencent.mobileqq.util.e.c()) {
            return AddFriendForNtLauncher.wh(context, i3, str, str2, i16, i17, str3, str4, str5, str6, str7);
        }
        return AddFriendCheckFragment.ki(context, i3, str, str2, i16, i17, str3, str4, str5, str6, str7);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public Intent startMultiAddContact(Context context, List<PhoneContact> list, int i3, String str, String str2, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Intent) iPatchRedirector.redirect((short) 13, this, context, list, Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16));
        }
        return AddFriendCheckFragment.ni(context, list, i3, str, str2, str3, i16);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, byte[] bArr, String str3, String str4, String str5, String str6, String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Intent) iPatchRedirector.redirect((short) 9, this, context, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), bArr, str3, str4, str5, str6, str7);
        }
        if (com.tencent.mobileqq.util.e.c()) {
            return AddFriendForNtLauncher.xh(context, i3, str, str2, i16, i17, bArr, str3, str4, str5, str6, str7, null);
        }
        return AddFriendCheckFragment.li(context, i3, str, str2, i16, i17, bArr, str3, str4, str5, str6, str7, null);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, String str7, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Intent) iPatchRedirector.redirect((short) 10, this, context, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, str5, str6, str7, bArr);
        }
        if (com.tencent.mobileqq.util.e.c()) {
            return AddFriendForNtLauncher.xh(context, i3, str, str2, i16, i17, null, str3, str4, str5, str6, str7, bArr);
        }
        return AddFriendCheckFragment.li(context, i3, str, str2, i16, i17, null, str3, str4, str5, str6, str7, bArr);
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Intent) iPatchRedirector.redirect((short) 11, this, context, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, bArr);
        }
        Intent startAddFriend = startAddFriend(context, i3, str, str2, i16, i17, str3, null, null, null, null);
        Bundle bundleExtra = startAddFriend.getBundleExtra("flc_extra_param");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        if (bArr != null && bArr.length > 0) {
            FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg = new FrdSysMsg$FriendSysMsg();
            frdSysMsg$FriendSysMsg.bytes_paster_info.set(ByteStringMicro.copyFrom(bArr));
            bundleExtra.putByteArray("friend_src_desc", frdSysMsg$FriendSysMsg.toByteArray());
        }
        startAddFriend.putExtra("flc_extra_param", bundleExtra);
        return startAddFriend;
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendApi
    public Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Intent) iPatchRedirector.redirect((short) 12, this, context, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, str5);
        }
        Intent startAddFriend = startAddFriend(context, i3, str, str2, i16, i17, str3, str4, null, null, null);
        Bundle bundleExtra = startAddFriend.getBundleExtra("flc_extra_param");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        if (str5 != null) {
            FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg = new FrdSysMsg$FriendSysMsg();
            frdSysMsg$FriendSysMsg.bytes_guild_src_url.set(ByteStringMicro.copyFrom(str5.getBytes()));
            bundleExtra.putByteArray("friend_src_desc", frdSysMsg$FriendSysMsg.toByteArray());
        }
        startAddFriend.putExtra("flc_extra_param", bundleExtra);
        return startAddFriend;
    }
}
