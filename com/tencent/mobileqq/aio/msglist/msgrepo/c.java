package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010\u0017\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/c;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "aioContext", DomainData.DOMAIN_NAME, "r", "Landroid/os/Bundle;", "bundle", "p", "o", "", "source", "extra", "b", "", "i", "J", "lastMsgId", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "msgRepo", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastMsgId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64146);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        }
    }

    private final boolean n(com.tencent.aio.api.runtime.a aioContext) {
        Bundle l3 = aioContext.g().l();
        if (!p(l3) && !o(l3) && r()) {
            return false;
        }
        return true;
    }

    private final boolean o(Bundle bundle) {
        return bundle.getBoolean("key_is_forward_preview_aio", false);
    }

    private final boolean p(Bundle bundle) {
        return bundle.getBoolean("key_is_miniaio", false);
    }

    private final boolean q(AIOMsgItem item) {
        if ((item instanceof ah) && ((ah) item).n2() == 11) {
            return true;
        }
        return false;
    }

    private final boolean r() {
        int e16 = d().g().r().c().e();
        if (e16 == 1 || e16 == 104 || e16 == 119) {
            return true;
        }
        return false;
    }

    private final void s(List<com.tencent.aio.data.msglist.a> list) {
        int size = list.size();
        if (QLog.isColorLevel()) {
            QLog.i("MsgActionAbility", 2, "[updateMsgActionFlag]");
        }
        boolean z16 = true;
        for (int i3 = size - 1; -1 < i3; i3--) {
            com.tencent.aio.data.msglist.a aVar = list.get(i3);
            if (aVar instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                if (!q(aIOMsgItem)) {
                    if (!z16) {
                        if (aIOMsgItem.I()) {
                            AIOMsgItem cloneNewInstance = aIOMsgItem.cloneNewInstance();
                            cloneNewInstance.r1(false);
                            Unit unit = Unit.INSTANCE;
                            list.set(i3, cloneNewInstance);
                        }
                    } else {
                        boolean z17 = !aVar.isSelf();
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MsgActionAbility", 4, "[updateMsgActionFlag]: lastRobotMsg flag is " + z17);
                        }
                        AIOMsgItem aIOMsgItem2 = (AIOMsgItem) aVar;
                        if (aIOMsgItem2.I() != z17) {
                            if (QLog.isDevelopLevel()) {
                                QLog.i("MsgActionAbility", 4, "[updateMsgActionFlag]: lastMsgId is " + aVar.getMsgId() + ", flag is " + z17);
                            }
                            AIOMsgItem cloneNewInstance2 = aIOMsgItem2.cloneNewInstance();
                            cloneNewInstance2.r1(z17);
                            Unit unit2 = Unit.INSTANCE;
                            list.set(i3, cloneNewInstance2);
                        }
                        z16 = false;
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        Object last;
        AIOMsgItem aIOMsgItem;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, source, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        if (list.isEmpty()) {
            return;
        }
        if (!n(d())) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            if (last instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) last;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null) {
                j3 = aIOMsgItem.getMsgId();
            } else {
                j3 = 0;
            }
            if (this.lastMsgId != j3 || Intrinsics.areEqual(source, "msg_update") || Intrinsics.areEqual(source, "handle_first_page") || Intrinsics.areEqual(source, "remove_fake_loading_msg")) {
                s(list);
            }
            this.lastMsgId = j3;
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("MsgActionAbility", 4, "[beforeNotifyMsgChange]: filter aio, ignore recommend.");
        }
    }
}
