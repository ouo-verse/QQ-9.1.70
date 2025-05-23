package com.tencent.qqnt.push.processor;

import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$GroupMemberProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/push/processor/g;", "Lcom/tencent/qqnt/push/a;", "Ltencent/im/s2c/msgtype0x210/submsgtype0x27/SubMsgType0x27$ForwardBody;", "forwardBody", "", "b", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g implements com.tencent.qqnt.push.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/push/processor/g$a;", "", "", "OP_TYPE_MOD_GROUP_INFO", "I", "OP_TYPE_MOD_GROUP_MEMBER_CARD", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.g$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62609);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(SubMsgType0x27$ForwardBody forwardBody) {
        if ((!forwardBody.uint32_notify_type.has() || forwardBody.uint32_notify_type.get() != 1) && forwardBody.uint32_op_type.has()) {
            String valueOf = String.valueOf(forwardBody.msg_mod_group_member_profile.uint64_group_code.get());
            String valueOf2 = String.valueOf(forwardBody.msg_mod_group_member_profile.uint64_uin.get());
            if (forwardBody.uint32_op_type.get() == 81) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopModDetailPushProcessor", 2, "handlePush: OP_TYPE_MOD_GROUP_MEMBER_CARD");
                }
                List<SubMsgType0x27$GroupMemberProfileInfo> changeInfos = forwardBody.msg_mod_group_member_profile.rpt_msg_group_member_profile_infos.get();
                Intrinsics.checkNotNullExpressionValue(changeInfos, "changeInfos");
                Iterator<T> it = changeInfos.iterator();
                while (it.hasNext()) {
                    ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).updateTroopMemberCard(valueOf, valueOf2, (SubMsgType0x27$GroupMemberProfileInfo) it.next());
                }
            }
        }
    }

    @Override // com.tencent.qqnt.push.a
    public void a(@Nullable ArrayList<Byte> msgBuf) {
        byte[] byteArray;
        PBBytesField pBBytesField;
        byte[] a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgBuf);
            return;
        }
        if (msgBuf == null || bg.f() == null) {
            return;
        }
        msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
        byteArray = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
        msg_comm_msg.mergeFrom(byteArray);
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body;
        if (im_msg_body_msgbody != null && (pBBytesField = im_msg_body_msgbody.msg_content) != null && (a16 = es2.a.a(pBBytesField)) != null) {
            SubMsgType0x27$MsgBody subMsgType0x27$MsgBody = new SubMsgType0x27$MsgBody();
            subMsgType0x27$MsgBody.mergeFrom(a16);
            List<SubMsgType0x27$ForwardBody> modInfos = subMsgType0x27$MsgBody.rpt_msg_mod_infos.get();
            Intrinsics.checkNotNullExpressionValue(modInfos, "modInfos");
            for (SubMsgType0x27$ForwardBody it : modInfos) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                b(it);
            }
        }
    }
}
