package com.tencent.mobileqq.aio.msglist.msgprocessor;

import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.kernel.api.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/a;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "list", "f", "", "j", "", "uinStr", tl.h.F, "", "chatType", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "g", "msgPosition", "i", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgprocessor.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        }
    }

    private final List<AIOMsgItem> f(List<? extends AIOMsgItem> list) {
        ArrayList arrayList = new ArrayList();
        for (AIOMsgItem aIOMsgItem : list) {
            if (com.tencent.mobileqq.aio.doutu.c.f188260a.d(aIOMsgItem)) {
                arrayList.add(aIOMsgItem);
            }
        }
        return arrayList;
    }

    private final void g(int chatType, List<? extends AIOMsgItem> list, AIOParam aioParam) {
        Object lastOrNull;
        boolean z16;
        int handleDui;
        Object last;
        if (list != null && !list.isEmpty()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
                QLog.e("AIOMsgDoutuProcessor", 1, "handleAioMsgForDoutu error, app is not BaseQQAppInterface!");
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IDoutuService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(ID\u2026va, ProcessConstant.MAIN)");
            IDoutuService iDoutuService = (IDoutuService) runtimeService;
            String b16 = su3.c.b(aioParam);
            String valueOf = String.valueOf(su3.c.c(aioParam));
            if (h(b16) && (chatType == 2 || chatType == 3)) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                b16 = ((AIOMsgItem) last).r0();
            }
            if (h(b16)) {
                QLog.e("AIOMsgDoutuProcessor", 1, "handleAioMsgForDoutu error, illegal uin " + b16);
                return;
            }
            if (Utils.G(b16)) {
                return;
            }
            iDoutuService.initChatSessionInfo(b16, valueOf);
            if (j(list)) {
                return;
            }
            List<AIOMsgItem> f16 = f(list);
            if (f16.isEmpty()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AIOMsgDoutuProcessor", 4, "handleAioMsgForDoutu return, doutuList is empty!");
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<AIOMsgItem> it = f16.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mobileqq.aio.doutu.c.f188260a.a(it.next()));
            }
            try {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
                com.tencent.qqnt.doutu.d dVar = (com.tencent.qqnt.doutu.d) lastOrNull;
                if (dVar != null && dVar.f356101l) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && (handleDui = iDoutuService.handleDui(arrayList)) != -1) {
                    f16.get(handleDui).h1(true);
                }
                iDoutuService.handleCombo(arrayList, 0);
            } catch (Throwable th5) {
                QLog.e("AIOMsgDoutuProcessor", 1, "handleAioMsgForDoutu error! ", th5);
            }
        }
    }

    private final boolean h(String uinStr) {
        if (!TextUtils.isEmpty(uinStr) && !TextUtils.equals(uinStr, "0")) {
            return false;
        }
        return true;
    }

    private final void i(int msgPosition) {
        HashMap hashMap = new HashMap();
        hashMap.put(AIOMsgItemPayloadType.DOUTU_STATUS_PAYLOAD, a.l.f192665a);
        b().e().h(new AIOMsgListEvent.MsgContentChangeEvent(msgPosition, hashMap));
    }

    private final boolean j(List<? extends AIOMsgItem> list) {
        if (list == null || list.isEmpty() || AIOUtil.f194084a.p(list)) {
            return true;
        }
        int size = list.size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            AIOMsgItem aIOMsgItem = list.get(i3);
            if (aIOMsgItem.F0()) {
                aIOMsgItem.h1(false);
                i(i3);
            }
            if (com.tencent.mobileqq.aio.utils.d.H(aIOMsgItem)) {
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r0 != false) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (com.tencent.mobileqq.aio.a.d(b())) {
            return displayList;
        }
        AIOContact c16 = b().g().r().c();
        int e16 = c16.e();
        if (e16 != 2 && e16 != 3) {
            if (e16 == 1) {
                m b16 = com.tencent.qqnt.msg.f.b();
                if (b16 != null) {
                    z16 = Intrinsics.areEqual(b16.isBuddy(c16.j()), Boolean.TRUE);
                } else {
                    z16 = false;
                }
            }
            return displayList;
        }
        AIOParam g16 = b().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        g(e16, displayList, g16);
        return displayList;
    }
}
