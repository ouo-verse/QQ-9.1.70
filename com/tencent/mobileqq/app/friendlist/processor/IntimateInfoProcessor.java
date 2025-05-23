package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class IntimateInfoProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public IntimateInfoProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> list, com.tencent.mobileqq.friend.data.a aVar, long j3, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, aVar, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.IntimateInfoProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        for (Pair<ExtensionInfo, FriendInfo> pair : list) {
            ExtensionInfo extensionInfo = (ExtensionInfo) pair.first;
            FriendInfo friendInfo = (FriendInfo) pair.second;
            if (friendInfo.groupId >= 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                FriendIntimateRelationshipHelper.i(qQAppInterface, extensionInfo, friendInfo.vecIntimateInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateExtensionInfo(ExtensionInfo extensionInfo, FriendInfo friendInfo, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, extensionInfo, friendInfo, aVar);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        boolean z16 = true;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.IntimateInfoProcessor", 1, "onUpdateExtensionInfo| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        if (friendInfo.groupId < 0) {
            z16 = false;
        }
        if (z16) {
            FriendIntimateRelationshipHelper.i(qQAppInterface, extensionInfo, friendInfo.vecIntimateInfo);
        }
    }
}
