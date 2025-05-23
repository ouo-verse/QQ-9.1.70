package com.tencent.mobileqq.aio.animation;

import com.tencent.mobileqq.aio.animation.AIOAnimationEvent;
import com.tencent.mobileqq.aio.animation.api.IAioAnimationApi;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/r;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "Lcom/tencent/mobileqq/aio/animation/data/b;", tl.h.F, "msgRecord", "", "f", "g", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class r extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        }
    }

    private final boolean f(MsgRecord msgRecord) {
        int i3 = msgRecord.sendStatus;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    private final boolean g(MsgRecord msgRecord) {
        int i3;
        if (!com.tencent.mobileqq.aio.utils.d.a0(msgRecord) && !MsgExtKt.y(msgRecord) && (i3 = msgRecord.msgType) != 9 && i3 != 4) {
            return false;
        }
        return true;
    }

    private final List<com.tencent.mobileqq.aio.animation.data.b> h(List<MsgRecord> msgRecordList) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : msgRecordList) {
            MsgRecord msgRecord = (MsgRecord) obj;
            if (f(msgRecord) && g(msgRecord)) {
                z16 = true;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("AIOMsgProcessor", 2, "[translateAIOMsg] ignore msg, msgId=" + msgRecord.msgId + " msgSeq=" + msgRecord.msgSeq + " msgType=" + msgRecord.msgType + " sendStatus=" + msgRecord.sendStatus);
                }
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).convertMsgRecord((MsgRecord) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Object last;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (!displayList.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
            if (((com.tencent.mobileqq.aio.msg.b) last).i2()) {
                return displayList;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : displayList) {
                if (!((com.tencent.mobileqq.aio.msg.b) obj).i2()) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((com.tencent.mobileqq.aio.msg.b) it.next()).getMsgRecord());
                }
                b().e().h(new AIOAnimationEvent.OnUpdateMsg(h(arrayList2)));
            }
            return displayList;
        }
        return displayList;
    }
}
