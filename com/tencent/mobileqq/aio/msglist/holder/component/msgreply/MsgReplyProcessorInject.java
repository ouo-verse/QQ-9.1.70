package com.tencent.mobileqq.aio.msglist.holder.component.msgreply;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAMsgReplyProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007RF\u0010\u0014\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\f0\u000bj\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\f`\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/MsgReplyProcessorInject;", "", "", "c", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/e;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Lcom/tencent/mobileqq/aio/msg/v;", "e", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getSMsgReplyProcessorClzs", "()Ljava/util/ArrayList;", "setSMsgReplyProcessorClzs", "(Ljava/util/ArrayList;)V", "sMsgReplyProcessorClzs", "Lkotlin/Lazy;", "()Ljava/util/List;", "sMsgReplyProcessors", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MsgReplyProcessorInject {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MsgReplyProcessorInject f191200a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msgreply/Inject_msgreply_processor.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends e>> sMsgReplyProcessorClzs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sMsgReplyProcessors;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48746);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f191200a = new MsgReplyProcessorInject();
        ArrayList<Class<? extends e>> arrayList = new ArrayList<>();
        sMsgReplyProcessorClzs = arrayList;
        arrayList.add(LIAMsgReplyProcessor.class);
        lazy = LazyKt__LazyJVMKt.lazy(MsgReplyProcessorInject$sMsgReplyProcessors$2.INSTANCE);
        sMsgReplyProcessors = lazy;
        c();
    }

    MsgReplyProcessorInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<e> b() {
        return (List) sMsgReplyProcessors.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<e> d() {
        e eVar;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sMsgReplyProcessorClzs.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            if (cls != null && (eVar = (e) cls.newInstance()) != null) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    @Nullable
    public final v e(@NotNull AIOMsgItem aioMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (v) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioMsgItem);
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        v vVar = new v();
        for (e eVar : b()) {
            if (eVar != null) {
                eVar.a(aioMsgItem, vVar);
            }
        }
        return vVar;
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void c() {
    }
}
