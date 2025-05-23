package com.tencent.mobileqq.troop.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.IAddTroopAccountIdentityApi;
import com.tencent.mobileqq.troop.troopconfig.api.impl.TroopConfigHandler;
import com.tencent.robot.api.IRobotInfoUpdateService;
import java.util.HashSet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AddTroopAccountIdentityApiImpl implements IAddTroopAccountIdentityApi {
    static IPatchRedirector $redirector_;
    private static final HashSet<Integer> mNeedAccountIdentitySourceIdSet;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63886);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        mNeedAccountIdentitySourceIdSet = hashSet;
        hashSet.add(30003);
        hashSet.add(30005);
        hashSet.add(30007);
        hashSet.add(Integer.valueOf(BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY));
        hashSet.add(Integer.valueOf(BaseConstants.ERR_SVR_FRIENDSHIP_GROUP_COUNT_LIMIT));
        hashSet.add(Integer.valueOf(BaseConstants.ERR_SVR_FRIENDSHIP_BLACKLIST_LIMIT));
        hashSet.add(30015);
        hashSet.add(30017);
        hashSet.add(30019);
        hashSet.add(30002);
        hashSet.add(30004);
        hashSet.add(30006);
        hashSet.add(Integer.valueOf(BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT));
        hashSet.add(Integer.valueOf(BaseConstants.ERR_SVR_FRIENDSHIP_COUNT_LIMIT));
        hashSet.add(Integer.valueOf(BaseConstants.ERR_SVR_FRIENDSHIP_PENDENCY_LIMIT));
        hashSet.add(Integer.valueOf(BaseConstants.ERR_SVR_FRIENDSHIP_PEER_FRIEND_LIMIT));
        hashSet.add(30016);
        hashSet.add(30018);
        hashSet.add(30020);
        hashSet.add(10003);
        hashSet.add(10008);
        hashSet.add(10007);
    }

    public AddTroopAccountIdentityApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initRobotConfig$0(AppRuntime appRuntime) {
        if (appRuntime instanceof AppInterface) {
            new TroopConfigHandler((AppInterface) appRuntime).I2();
        }
        ((IRobotInfoUpdateService) appRuntime.getRuntimeService(IRobotInfoUpdateService.class, "")).initUpdateListener();
    }

    @Override // com.tencent.mobileqq.troop.api.IAddTroopAccountIdentityApi
    public void initRobotConfig(final AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    AddTroopAccountIdentityApiImpl.lambda$initRobotConfig$0(AppRuntime.this);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IAddTroopAccountIdentityApi
    public boolean isNeedAccountIdentity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        return mNeedAccountIdentitySourceIdSet.contains(Integer.valueOf(i3));
    }
}
