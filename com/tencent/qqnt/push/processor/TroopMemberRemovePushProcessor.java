package com.tencent.qqnt.push.processor;

import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopGagUtils;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.troop.bin_0x22$Body;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/push/processor/TroopMemberRemovePushProcessor;", "Lcom/tencent/qqnt/push/a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class TroopMemberRemovePushProcessor implements com.tencent.qqnt.push.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/push/processor/TroopMemberRemovePushProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.TroopMemberRemovePushProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62605);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberRemovePushProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.push.a
    public void a(@Nullable ArrayList<Byte> msgBuf) {
        final AppRuntime f16;
        byte[] byteArray;
        PBBytesField pBBytesField;
        byte[] a16;
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
            bin_0x22$Body bin_0x22_body = new bin_0x22$Body();
            bin_0x22_body.mergeFrom(a16);
            final long j3 = bin_0x22_body.group_code.get();
            String str = bin_0x22_body.member_uid.get();
            final int i3 = (int) bin_0x22_body.opt.get();
            TroopMemberListRepo.INSTANCE.fetchTroopMemberUin(str, new Function2<Boolean, String, Unit>(i3, f16, j3) { // from class: com.tencent.qqnt.push.processor.TroopMemberRemovePushProcessor$onPushReceive$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AppRuntime $app;
                final /* synthetic */ int $optType;
                final /* synthetic */ long $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$optType = i3;
                    this.$app = f16;
                    this.$troopUin = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(i3), f16, Long.valueOf(j3));
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                    invoke(bool.booleanValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String uin) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), uin);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(uin, "uin");
                    if (!z16) {
                        QLog.e("TroopMemberRemovePushProcessor", 1, "onPushReceive: uid to uin failed");
                        return;
                    }
                    int i16 = this.$optType;
                    if ((i16 == 1 || i16 == 3) && Intrinsics.areEqual(uin, this.$app.getCurrentAccountUin())) {
                        ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) bg.l(ITroopMemberInfoService.class);
                        if (iTroopMemberInfoService != null) {
                            iTroopMemberInfoService.deleteTroopMember(String.valueOf(this.$troopUin), uin, false);
                            return;
                        }
                        return;
                    }
                    ITroopMemberInfoService iTroopMemberInfoService2 = (ITroopMemberInfoService) bg.l(ITroopMemberInfoService.class);
                    if (iTroopMemberInfoService2 != null) {
                        iTroopMemberInfoService2.deleteTroopMember(String.valueOf(this.$troopUin), uin, true);
                    }
                }
            });
            ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).clearMySelfGagInfo(String.valueOf(j3));
        }
    }
}
