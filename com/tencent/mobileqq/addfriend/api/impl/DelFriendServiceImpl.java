package com.tencent.mobileqq.addfriend.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IDelFriendService;
import com.tencent.mobileqq.addfriend.handler.NTDelFriendHandler;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/impl/DelFriendServiceImpl;", "Lcom/tencent/mobileqq/addfriend/api/IDelFriendService;", "()V", "delFriend", "", "callFrom", "", "friendUin", "delType", "", "notShieldTmpSession", "", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class DelFriendServiceImpl implements IDelFriendService {
    static IPatchRedirector $redirector_;

    public DelFriendServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IDelFriendService
    public void delFriend(@NotNull String callFrom, @Nullable String friendUin, byte delType, int notShieldTmpSession) {
        boolean z16;
        AppRuntime appRuntime;
        AppInterface appInterface;
        BaseBusinessHandler baseBusinessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, callFrom, friendUin, Byte.valueOf(delType), Integer.valueOf(notShieldTmpSession));
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        if (StringUtil.isEmpty(friendUin)) {
            QLog.e("AddFriendServiceApiImpl", 1, "delFriend empty");
            return;
        }
        if (delType == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (notShieldTmpSession == 0) {
            z17 = true;
        }
        String friendUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(friendUin);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        NTDelFriendHandler nTDelFriendHandler = null;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            baseBusinessHandler = appInterface.getBusinessHandler(NTDelFriendHandler.class.getName());
        } else {
            baseBusinessHandler = null;
        }
        if (baseBusinessHandler instanceof NTDelFriendHandler) {
            nTDelFriendHandler = (NTDelFriendHandler) baseBusinessHandler;
        }
        if (nTDelFriendHandler != null) {
            Intrinsics.checkNotNullExpressionValue(friendUid, "friendUid");
            nTDelFriendHandler.D2(callFrom, friendUid, z16, z17);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
