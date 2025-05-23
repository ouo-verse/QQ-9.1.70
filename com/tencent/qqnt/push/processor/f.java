package com.tencent.qqnt.push.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/push/processor/f;", "Lcom/tencent/qqnt/push/a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f implements com.tencent.qqnt.push.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/push/processor/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.f$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62597);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
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
        boolean z16;
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
            Submsgtype0x3b$MsgBody submsgtype0x3b$MsgBody = new Submsgtype0x3b$MsgBody();
            submsgtype0x3b$MsgBody.mergeFrom(a16);
            String valueOf = String.valueOf(submsgtype0x3b$MsgBody.uint64_group_code.get());
            int i3 = submsgtype0x3b$MsgBody.uint32_user_show_flag.get();
            int i16 = submsgtype0x3b$MsgBody.uint32_member_level_changed.get();
            int i17 = submsgtype0x3b$MsgBody.uint32_member_level_new_changed.get();
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberLevelInfoChangePushProcessor", 2, "onPushReceive: troopUin=" + valueOf + ", userSwitch.has=" + submsgtype0x3b$MsgBody.uint32_user_show_flag.has() + ", userSwitch=" + i3 + ", memberLevelChanged.has=" + submsgtype0x3b$MsgBody.uint32_member_level_changed.has() + ", memberLevelChanged=" + i16 + ", newMemberLevelChanged.has=" + submsgtype0x3b$MsgBody.uint32_member_level_new_changed.has() + ", newMemberLevelChanged=" + i17);
            }
            boolean z17 = false;
            if (valueOf.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !Intrinsics.areEqual(valueOf, "0")) {
                if (submsgtype0x3b$MsgBody.uint32_user_show_flag.has()) {
                    TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(valueOf);
                    AppInterface appInterface = null;
                    ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopLevelSwitch(valueOf, Byte.valueOf((byte) i3), null);
                    if (f16 instanceof AppInterface) {
                        appInterface = (AppInterface) f16;
                    }
                    if (appInterface != null) {
                        AppInterface appInterface2 = (AppInterface) f16;
                        appInterface2.getBusinessHandler(TroopInfoHandler.class.getName()).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, valueOf);
                        BusinessHandler businessHandler = appInterface2.getBusinessHandler(TroopInfoHandler.class.getName());
                        int i18 = com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_TROOP_RANK_SWITCH_CHANGE;
                        Object[] objArr = new Object[2];
                        objArr[0] = valueOf;
                        if (i3 == 1) {
                            z17 = true;
                        }
                        objArr[1] = Boolean.valueOf(z17);
                        businessHandler.notifyUI(i18, true, objArr);
                    }
                    if (troopInfoFromCache != null && troopInfoFromCache.extDBInfo.cGroupRankUserFlag == 1) {
                        ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).fetchTroopLevelInfo(valueOf, true);
                    }
                }
                if (submsgtype0x3b$MsgBody.uint32_member_level_changed.has() || submsgtype0x3b$MsgBody.uint32_member_level_new_changed.has()) {
                    ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).fetchTroopLevelInfo(valueOf, true);
                }
            }
        }
    }
}
