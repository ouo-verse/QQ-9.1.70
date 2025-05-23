package com.tencent.aio.stranger.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aio.stranger.api.IStrangerAdapterApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerAdapterApiImpl;", "Lcom/tencent/aio/stranger/api/IStrangerAdapterApi;", "()V", "addContactFriend", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "uid", "", "nickName", "addFriendFromStrangerChat", IProfileProtocolConst.PARAM_TROOP_CODE, "chatType", "", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StrangerAdapterApiImpl implements IStrangerAdapterApi {
    static IPatchRedirector $redirector_;

    public StrangerAdapterApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addFriendFromStrangerChat$lambda$0(String uid, Activity activity, String troopCode, int i3, int i16, String nickName, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(troopCode, "$troopCode");
        Intrinsics.checkNotNullParameter(nickName, "$nickName");
        Long l3 = (Long) hashMap.get(uid);
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 2, String.valueOf(l3), troopCode, i3, i16, nickName, null, null, "\u8fd4\u56de", null);
        QLog.d("StrangerAdapterNTImpl", 1, "\u6dfb\u52a0\u597d\u53cb: " + nickName + " - " + troopCode + " - " + l3 + " - " + uid);
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(activity, startAddFriend);
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAdapterApi
    public void addContactFriend(@NotNull Activity activity, @NotNull String uid, @NotNull String nickName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, uid, nickName);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 2, uid, null, 3006, 12, nickName, null, null, "\u8fd4\u56de", null));
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAdapterApi
    public void addFriendFromStrangerChat(@NotNull final Activity activity, @NotNull final String nickName, @NotNull final String troopCode, @NotNull final String uid, int chatType) {
        int i3;
        HashSet<String> hashSetOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, nickName, troopCode, uid, Integer.valueOf(chatType));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(troopCode, "troopCode");
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (chatType != 100) {
            if (chatType != 102) {
                if (chatType != 117) {
                    i3 = BuddySource.DEFAULT;
                } else {
                    i3 = 3008;
                }
            } else {
                i3 = 3072;
            }
        } else {
            i3 = 3004;
        }
        if (chatType != 100) {
            if (chatType != 102) {
                if (chatType != 117) {
                    i16 = 0;
                } else {
                    i16 = 12;
                }
            } else {
                i16 = 1;
            }
        }
        ag uixConvertService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getUixConvertService();
        if (uixConvertService != null) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(uid);
            final int i17 = i3;
            final int i18 = i16;
            uixConvertService.getUin(hashSetOf, new IKernelGetUinInfoCallback() { // from class: com.tencent.aio.stranger.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                public final void onResult(HashMap hashMap) {
                    StrangerAdapterApiImpl.addFriendFromStrangerChat$lambda$0(uid, activity, troopCode, i17, i18, nickName, hashMap);
                }
            });
        }
    }
}
