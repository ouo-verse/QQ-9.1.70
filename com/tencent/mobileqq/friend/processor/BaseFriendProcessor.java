package com.tencent.mobileqq.friend.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyRsp;
import com.tencent.qqnt.remote.d;
import friendlist.AddFriendResp;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpateBuffer;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$ExtSnsFrdData;

/* loaded from: classes12.dex */
public abstract class BaseFriendProcessor {
    static IPatchRedirector $redirector_;
    protected AppRuntime mApp;

    public BaseFriendProcessor(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mApp = null;
        }
    }

    public void onAddFriendSuccess(AddBuddyRsp addBuddyRsp, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) addBuddyRsp, (Object) dVar);
    }

    public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> list, com.tencent.mobileqq.friend.data.a aVar, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, aVar, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    public void onGetFriendInfoFinish(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
    }

    public void onGetFriendListFinish(boolean z16, ArrayList<String> arrayList, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), arrayList, aVar);
        }
    }

    public void onReportFriendListNetLoad(long j3, long j16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void onUpdateExtensionInfo(ExtensionInfo extensionInfo, FriendInfo friendInfo, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, extensionInfo, friendInfo, aVar);
        }
    }

    public void onUpdateFriendInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) friends, (Object) friendInfo);
        }
    }

    public void onUpdateSelfInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) friends, (Object) friendInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Oidb_0xd50$ExtSnsFrdData parseExtSnsFrdData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Oidb_0xd50$ExtSnsFrdData) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
        }
        Oidb_0xd50$ExtSnsFrdData oidb_0xd50$ExtSnsFrdData = new Oidb_0xd50$ExtSnsFrdData();
        try {
            oidb_0xd50$ExtSnsFrdData.mergeFrom(bArr);
            return oidb_0xd50$ExtSnsFrdData;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Oidb_0x5d0$SnsUpateBuffer parseSnsUpdateBuffer(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Oidb_0x5d0$SnsUpateBuffer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
        }
        Oidb_0x5d0$SnsUpateBuffer oidb_0x5d0$SnsUpateBuffer = new Oidb_0x5d0$SnsUpateBuffer();
        try {
            oidb_0x5d0$SnsUpateBuffer.mergeFrom(bArr);
            return oidb_0x5d0$SnsUpateBuffer;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void onAddFriendSuccess(AddFriendResp addFriendResp, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) addFriendResp, (Object) toServiceMsg);
    }
}
