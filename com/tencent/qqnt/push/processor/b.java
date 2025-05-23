package com.tencent.qqnt.push.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.troop.bin_0x2c$Body;
import tencent.im.troop.bin_0x2c$ChangeOwner;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/push/processor/b;", "Lcom/tencent/qqnt/push/a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements com.tencent.qqnt.push.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/push/processor/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62580);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
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
        AppInterface appInterface;
        BusinessHandler businessHandler;
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
            bin_0x2c$Body bin_0x2c_body = new bin_0x2c$Body();
            bin_0x2c_body.mergeFrom(a16);
            long j3 = bin_0x2c_body.group_code.get();
            int i3 = (int) bin_0x2c_body.opt.get();
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 255) {
                        QLog.e("TroopChangeAdminPushProcessor", 1, "onPushReceive: unknow opt troopUin=" + j3 + " opt=" + i3);
                    } else {
                        bin_0x2c$ChangeOwner bin_0x2c_changeowner = bin_0x2c_body.msg_body.msgChangeOwner;
                        PBUInt64Field pBUInt64Field = bin_0x2c_changeowner.oldOwnerUid;
                        PBUInt64Field pBUInt64Field2 = bin_0x2c_changeowner.newOwnerUid;
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopChangeAdminPushProcessor", 2, "onPushReceive: troopUin=" + j3 + " transfer, oldOwnerUid=" + pBUInt64Field + " newOwnerUid=" + pBUInt64Field2);
                        }
                    }
                } else {
                    PBUInt64Field pBUInt64Field3 = bin_0x2c_body.msg_body.msgSetAdmin.memberUid;
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopChangeAdminPushProcessor", 2, "onPushReceive: troopUin=" + j3 + " setAdmin, memberUid=" + pBUInt64Field3);
                    }
                }
            } else {
                PBUInt64Field pBUInt64Field4 = bin_0x2c_body.msg_body.msgResetAdmin.memberUid;
                if (QLog.isColorLevel()) {
                    QLog.d("TroopChangeAdminPushProcessor", 2, "onPushReceive: troopUin=" + j3 + " resetAdmin, memberUid=" + pBUInt64Field4);
                }
            }
            if (f16 instanceof AppInterface) {
                appInterface = (AppInterface) f16;
            } else {
                appInterface = null;
            }
            if (appInterface != null && (businessHandler = appInterface.getBusinessHandler(TroopInfoHandler.class.getName())) != null) {
                businessHandler.notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_ADMIN_CHANGED, true, String.valueOf(j3));
            }
        }
    }
}
