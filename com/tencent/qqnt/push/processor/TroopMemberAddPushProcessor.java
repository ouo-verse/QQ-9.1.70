package com.tencent.qqnt.push.processor;

import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.troop.bin_0x21$Body;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/push/processor/TroopMemberAddPushProcessor;", "Lcom/tencent/qqnt/push/a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class TroopMemberAddPushProcessor implements com.tencent.qqnt.push.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/push/processor/TroopMemberAddPushProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_MEMBER_ADD_BY_APPLY", "I", "TYPE_MEMBER_ADD_BY_APPLY_2", "TYPE_MEMBER_ADD_BY_INVITE", "TYPE_MEMBER_ADD_BY_INVITE_2", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.TroopMemberAddPushProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberAddPushProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.push.a
    public void a(@Nullable ArrayList<Byte> msgBuf) {
        AppRuntime f16;
        byte[] byteArray;
        PBBytesField pBBytesField;
        byte[] a16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgBuf);
            return;
        }
        if (msgBuf == null || (f16 = bg.f()) == null) {
            return;
        }
        msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
        byteArray = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
        msg_comm_msg.mergeFrom(byteArray);
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body;
        if (im_msg_body_msgbody != null && (pBBytesField = im_msg_body_msgbody.msg_content) != null && (a16 = es2.a.a(pBBytesField)) != null) {
            bin_0x21$Body bin_0x21_body = new bin_0x21$Body();
            bin_0x21_body.mergeFrom(a16);
            long j3 = bin_0x21_body.group_code.get();
            String str2 = bin_0x21_body.member_uid.get();
            int i3 = (int) bin_0x21_body.opt.get();
            String str3 = bin_0x21_body.admin_uid.get();
            if (j3 > 0 && !Intrinsics.areEqual(str2, "") && !Intrinsics.areEqual(str2, "0")) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberAddPushProcessor", 2, "onPushReceive: byte troopUin=" + j3 + ", memberUid=" + str2 + ", optType=" + Util.toHexString(i3) + ", adminUid=" + str3);
                }
                AppRuntime f17 = bg.f();
                if (f17 != null) {
                    str = f17.getCurrentUid();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str2, str)) {
                    com.tencent.qqnt.push.impl.a.f360711a.a(String.valueOf(j3));
                    return;
                } else {
                    TroopMemberListRepo.INSTANCE.fetchTroopMemberUin(str2, new TroopMemberAddPushProcessor$onPushReceive$1(i3, str2, f16, j3));
                    return;
                }
            }
            QLog.e("TroopMemberAddPushProcessor", 1, "onPushReceive: error args troopUin=" + j3 + " memberUin=" + str2);
        }
    }
}
