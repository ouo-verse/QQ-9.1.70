package com.tencent.qqnt.msgselect.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msgselect.api.IMsgSelectApi;
import com.tencent.qqnt.msgselect.api.IMsgSelectFragmentApi;
import com.tencent.qqnt.msgselect.api.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/msgselect/api/impl/MsgSelectApiImpl;", "Lcom/tencent/qqnt/msgselect/api/IMsgSelectApi;", "Lcom/tencent/qqnt/msgselect/api/a;", "msgSelectReq", "", "startMsgSelect", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgSelectApiImpl implements IMsgSelectApi {
    static IPatchRedirector $redirector_;

    public MsgSelectApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msgselect.api.IMsgSelectApi
    public void startMsgSelect(@NotNull a msgSelectReq) {
        long[] longArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgSelectReq);
            return;
        }
        Intrinsics.checkNotNullParameter(msgSelectReq, "msgSelectReq");
        QLog.d("MsgSelectApiImpl", 1, "startMsgSelect chatType:" + msgSelectReq + ".chatType, uid:" + msgSelectReq + ".uid, from:" + msgSelectReq + ".from reqCode:" + msgSelectReq + ".requestCode");
        Intent intent = new Intent();
        intent.putExtra("key_peerId", msgSelectReq.i());
        intent.putExtra("key_chat_type", msgSelectReq.a());
        intent.putExtra("key_chat_name", msgSelectReq.f());
        intent.putExtra("key_from", msgSelectReq.c());
        longArray = CollectionsKt___CollectionsKt.toLongArray(msgSelectReq.h());
        intent.putExtra("key_selected_msg_id", longArray);
        intent.putExtra("key_limited_count", msgSelectReq.d());
        intent.putExtra("key_limited_time", msgSelectReq.e());
        Class<?> fragmentClass = ((IMsgSelectFragmentApi) QRoute.api(IMsgSelectFragmentApi.class)).getFragmentClass();
        intent.putExtra("public_fragment_window_feature", 1);
        Activity b16 = msgSelectReq.b();
        Intrinsics.checkNotNull(fragmentClass, "null cannot be cast to non-null type java.lang.Class<out com.tencent.mobileqq.fragment.QPublicBaseFragment>");
        QPublicFragmentActivity.startForResult(b16, intent, (Class<? extends QPublicBaseFragment>) fragmentClass, msgSelectReq.g());
    }
}
