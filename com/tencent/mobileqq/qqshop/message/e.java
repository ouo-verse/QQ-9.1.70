package com.tencent.mobileqq.qqshop.message;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.api.IQQShopKuiklyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.b;
import com.tencent.qqnt.msg.data.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/e;", "Lcom/tencent/qqnt/msg/api/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "c", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "onRecvMsg", "<init>", "()V", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e implements com.tencent.qqnt.msg.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/e$a;", "", "", "logTag", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.message.e$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull String logTag, @NotNull MsgRecord msgRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) logTag, (Object) msgRecord);
                return;
            }
            Intrinsics.checkNotNullParameter(logTag, "logTag");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            d dVar = d.f274478a;
            String e16 = dVar.e(msgRecord);
            dVar.m(msgRecord);
            dVar.n(msgRecord);
            boolean x16 = dVar.x(msgRecord);
            int d16 = dVar.d(msgRecord);
            dVar.p(msgRecord);
            QLog.d("QQShopNotifyMsgCallback", 2, logTag + " adId = " + e16 + " reportClick = " + x16 + " actionType = " + d16 + " advertId = " + dVar.t(msgRecord));
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30020);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(MsgRecord msgRecord) {
        com.tencent.mobileqq.qqshop.report.dev.b.f274713a.j(Long.valueOf(System.currentTimeMillis()));
        d dVar = d.f274478a;
        if (dVar.h(msgRecord)) {
            a.f274473a.x();
        } else if (dVar.w(msgRecord)) {
            a.f274473a.w();
        } else {
            a.f274473a.y();
        }
        a.f274473a.u(msgRecord, true);
        if (QLog.isColorLevel()) {
            INSTANCE.a("onQQShopMsgArrived", msgRecord);
        }
        com.tencent.mobileqq.qqshop.report.gdt.b.f274718a.g(msgRecord);
        com.tencent.mobileqq.qqshop.report.a.f274706a.a(msgRecord);
    }

    private final void d() {
        QRouteApi api = QRoute.api(IQQShopKuiklyApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQShopKuiklyApi::class.java)");
        IQQShopKuiklyApi.a.a((IQQShopKuiklyApi) api, null, 1, null);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void a(@NotNull h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) hVar);
        } else {
            b.a.h(this, hVar);
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void b(@NotNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        } else {
            b.a.g(this, bArr);
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
        } else {
            b.a.a(this, arrayList);
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGroupGuildUpdate(@NotNull GroupGuildNotifyInfo groupGuildNotifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) groupGuildNotifyInfo);
        } else {
            b.a.b(this, groupGuildNotifyInfo);
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag guildMsgAbFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) guildMsgAbFlag);
        } else {
            b.a.c(this, guildMsgAbFlag);
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvGroupGuildFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            b.a.d(this, i3);
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvMsg(@NotNull ArrayList<MsgRecord> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        boolean z16 = false;
        for (MsgRecord msgRecord : msgList) {
            if (Intrinsics.areEqual(msgRecord.senderUid, "u_2ZRcriDgt2a46svnxKPPMw") && msgRecord.chatType == 103) {
                c(msgRecord);
                z16 = true;
            }
        }
        if (z16) {
            d();
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvUDCFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            b.a.f(this, i3);
        }
    }
}
