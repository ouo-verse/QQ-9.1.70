package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper;
import com.tencent.mobileqq.mutualmark.nt.f;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class MutualMarkProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public MutualMarkProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f.f252196a.p((String) it.next());
        }
    }

    private void c(final ArrayList<String> arrayList) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.friendlist.processor.a
            @Override // java.lang.Runnable
            public final void run() {
                MutualMarkProcessor.b(arrayList);
            }
        }, 16, null, true, 2000L);
    }

    private static void d(QQAppInterface qQAppInterface, boolean z16, boolean z17, long j3) {
        for (int i3 = 1; i3 < 19; i3++) {
            if ((z17 || i3 != 16) && ((z16 || i3 != 18) && i3 != 13)) {
                qQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i3, j3).commit();
            }
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> list, com.tencent.mobileqq.friend.data.a aVar, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, aVar, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        ArrayList<String> arrayList = new ArrayList<>();
        for (Pair<ExtensionInfo, FriendInfo> pair : list) {
            ExtensionInfo extensionInfo = (ExtensionInfo) pair.first;
            FriendInfo friendInfo = (FriendInfo) pair.second;
            String valueOf = String.valueOf(friendInfo.friendUin);
            if (aVar.f211606c == 0 && MutualMarkDataS2CHandleHelper.g(qQAppInterface, extensionInfo, valueOf, friendInfo.vecMutualMarkData)) {
                arrayList.add(valueOf);
            }
        }
        c(arrayList);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        for (Pair<Friends, FriendInfo> pair : list) {
            Friends friends = (Friends) pair.first;
            ExtSnsFrdDataHandleHelper.s(qQAppInterface, friends, friends.uin, parseExtSnsFrdData(((FriendInfo) pair.second).vecExtSnsFrdData));
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onGetFriendListFinish(boolean z16, ArrayList<String> arrayList, com.tencent.mobileqq.friend.data.a aVar) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), arrayList, aVar);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetFriendListComplete| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        QQProfileItem.c(qQAppInterface, "775_hot_friend_new_boat_clear_version");
        QQProfileItem.c(qQAppInterface, "top_position_and_disturb_clear_version");
        QQProfileItem.c(qQAppInterface, "check_message_preview_version_clear");
        if (aVar.f211607d == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (aVar.f211606c == 0) {
            z18 = true;
        }
        d(qQAppInterface, z17, z18, aVar.f211604a);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateExtensionInfo(ExtensionInfo extensionInfo, FriendInfo friendInfo, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, extensionInfo, friendInfo, aVar);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onUpdateExtensionInfo| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        FriendIntimateRelationshipHelper.i(qQAppInterface, extensionInfo, friendInfo.vecIntimateInfo);
        if (aVar.f211606c == 0) {
            MutualMarkDataS2CHandleHelper.g(qQAppInterface, extensionInfo, extensionInfo.uin, friendInfo.vecMutualMarkData);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateFriendInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) friends, (Object) friendInfo);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
        } else {
            ExtSnsFrdDataHandleHelper.s((QQAppInterface) appRuntime, friends, friends.uin, parseExtSnsFrdData(friendInfo.vecExtSnsFrdData));
        }
    }
}
