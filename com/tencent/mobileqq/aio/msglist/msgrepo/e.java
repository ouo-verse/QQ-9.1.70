package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import com.huawei.hms.common.data.DataBufferUtils;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/e;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", "source", "Landroid/os/Bundle;", "extra", "", "b", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64169);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Contact it, HashMap msgEventInfo) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(msgEventInfo, "$msgEventInfo");
        ((IMsgService) QRoute.api(IMsgService.class)).setCurOnScreenMsgForMsgEvent(it, msgEventInfo);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, source, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        switch (source.hashCode()) {
            case -2103107547:
                if (!source.equals("receive_msg")) {
                    return;
                }
                break;
            case -966138055:
                if (!source.equals("top_page")) {
                    return;
                }
                break;
            case -653505721:
                if (!source.equals("msg_update")) {
                    return;
                }
                break;
            case -204114635:
                if (!source.equals("handle_first_page")) {
                    return;
                }
                break;
            case 29445854:
                if (!source.equals("get_last_db")) {
                    return;
                }
                break;
            case 1217097819:
                if (!source.equals(DataBufferUtils.NEXT_PAGE)) {
                    return;
                }
                break;
            case 1247781450:
                if (!source.equals("send_msg")) {
                    return;
                }
                break;
            case 1764921069:
                if (!source.equals("delete_msg")) {
                    return;
                }
                break;
            default:
                return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("MsgEventInfoAbility", 4, "[beforeNotifyMsgChange]: from is " + source);
        }
        final HashMap hashMap = new HashMap();
        final Contact contact = null;
        for (com.tencent.aio.data.msglist.a aVar : list) {
            if (aVar instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                Contact v3 = aIOMsgItem.v();
                if (aIOMsgItem.getMsgRecord().msgEventInfo != null) {
                    Long valueOf = Long.valueOf(aVar.getMsgSeq());
                    byte[] bArr = ((AIOMsgItem) aVar).getMsgRecord().msgEventInfo;
                    Intrinsics.checkNotNullExpressionValue(bArr, "msgItem.msgRecord.msgEventInfo");
                    hashMap.put(valueOf, bArr);
                }
                contact = v3;
            }
        }
        if (contact != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.o(Contact.this, hashMap);
                }
            }, 16, null, false);
        }
    }
}
