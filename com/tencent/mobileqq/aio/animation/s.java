package com.tencent.mobileqq.aio.animation;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.animation.api.IAioAnimationApi;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/s;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "", "a", "b", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/mobileqq/aio/animation/data/b;", "c", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f188155a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f188155a = new s();
        }
    }

    s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(AIOMsgItem msg2) {
        if (msg2.getMsgRecord().sendStatus != 2 && msg2.getMsgRecord().sendStatus != 3) {
            return false;
        }
        return true;
    }

    private final boolean b(AIOMsgItem msg2) {
        if (!com.tencent.mobileqq.aio.utils.d.Z(msg2) && !com.tencent.mobileqq.aio.utils.d.E(msg2) && msg2.getMsgRecord().msgType != 9 && msg2.getMsgRecord().msgType != 4) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<com.tencent.mobileqq.aio.animation.data.b> c(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgList);
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        ArrayList arrayList = new ArrayList();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList2 = new ArrayList();
        for (Object obj : msgList) {
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
            s sVar = f188155a;
            if (sVar.a(aIOMsgItem) && sVar.b(aIOMsgItem)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        for (com.tencent.aio.data.msglist.a aVar2 : arrayList2) {
            IAioAnimationApi iAioAnimationApi = (IAioAnimationApi) QRoute.api(IAioAnimationApi.class);
            Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            arrayList.add(iAioAnimationApi.convertMsgRecord(((AIOMsgItem) aVar2).getMsgRecord()));
        }
        return arrayList;
    }
}
