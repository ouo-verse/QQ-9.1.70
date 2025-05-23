package com.tencent.aio.stranger.api.impl;

import android.app.Activity;
import com.tencent.aio.stranger.api.IStrangerAdapterApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerAdapterApiNtImpl;", "Lcom/tencent/aio/stranger/api/IStrangerAdapterApi;", "()V", "addFriendFromStrangerChat", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "nickName", "", IProfileProtocolConst.PARAM_TROOP_CODE, "uid", "chatType", "", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StrangerAdapterApiNtImpl implements IStrangerAdapterApi {
    static IPatchRedirector $redirector_;

    public StrangerAdapterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAdapterApi
    public void addContactFriend(@NotNull Activity activity, @NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, str, str2);
        } else {
            IStrangerAdapterApi.a.a(this, activity, str, str2);
        }
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAdapterApi
    public void addFriendFromStrangerChat(@NotNull Activity activity, @NotNull String nickName, @NotNull String troopCode, @NotNull String uid, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, nickName, troopCode, uid, Integer.valueOf(chatType));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(troopCode, "troopCode");
        Intrinsics.checkNotNullParameter(uid, "uid");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new StrangerAdapterApiNtImpl$addFriendFromStrangerChat$1(activity, nickName, null), 2, null);
        QLog.d("StrangerAdapterNTImpl", 1, "\u6dfb\u52a0\u597d\u53cb: " + nickName + " - " + troopCode + " - " + uid);
    }
}
