package com.tencent.qqnt.msgselect.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msgselect.MsgSelectActivity;
import com.tencent.qqnt.msgselect.api.IMsgSelectApi;
import com.tencent.qqnt.msgselect.api.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/msgselect/api/impl/MsgSelectApiNtImpl;", "Lcom/tencent/qqnt/msgselect/api/IMsgSelectApi;", "Lcom/tencent/qqnt/msgselect/api/a;", "msgSelectReq", "", "startMsgSelect", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgSelectApiNtImpl implements IMsgSelectApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "MsgSelectApiNtImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msgselect/api/impl/MsgSelectApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msgselect.api.impl.MsgSelectApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgSelectApiNtImpl() {
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
        QLog.d(TAG, 1, "startMsgSelect chatType:" + msgSelectReq + ".chatType, uid:" + msgSelectReq + ".uid, from:" + msgSelectReq + ".from reqCode:" + msgSelectReq + ".requestCode");
        Intent intent = new Intent(msgSelectReq.b(), (Class<?>) MsgSelectActivity.class);
        intent.putExtra("key_peerId", msgSelectReq.i());
        intent.putExtra("key_chat_type", msgSelectReq.a());
        intent.putExtra("key_chat_name", msgSelectReq.f());
        intent.putExtra("key_from", msgSelectReq.c());
        longArray = CollectionsKt___CollectionsKt.toLongArray(msgSelectReq.h());
        intent.putExtra("key_selected_msg_id", longArray);
        intent.putExtra("key_limited_count", msgSelectReq.d());
        intent.putExtra("key_limited_time", msgSelectReq.e());
        msgSelectReq.b().startActivityForResult(intent, msgSelectReq.g());
    }
}
