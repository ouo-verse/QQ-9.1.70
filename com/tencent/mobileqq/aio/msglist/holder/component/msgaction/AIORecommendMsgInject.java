package com.tencent.mobileqq.aio.msglist.holder.component.msgaction;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tRF\u0010\u0016\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u000e0\rj\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u000e`\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/AIORecommendMsgInject;", "", "", "Ld81/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "buttonInfo", "", "c", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getSMsgRecommendClickProcessorClzs", "()Ljava/util/ArrayList;", "setSMsgRecommendClickProcessorClzs", "(Ljava/util/ArrayList;)V", "sMsgRecommendClickProcessorClzs", "Lkotlin/Lazy;", "()Ljava/util/List;", "sMsgRecommendClickProcessors", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIORecommendMsgInject {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIORecommendMsgInject f191165a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/recommend/Inject_msg_recommend_processor.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends d81.a>> sMsgRecommendClickProcessorClzs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sMsgRecommendClickProcessors;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61904);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f191165a = new AIORecommendMsgInject();
        ArrayList<Class<? extends d81.a>> arrayList = new ArrayList<>();
        sMsgRecommendClickProcessorClzs = arrayList;
        arrayList.add(g.class);
        sMsgRecommendClickProcessorClzs.add(e.class);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) AIORecommendMsgInject$sMsgRecommendClickProcessors$2.INSTANCE);
        sMsgRecommendClickProcessors = lazy;
    }

    AIORecommendMsgInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<d81.a> b() {
        return (List) sMsgRecommendClickProcessors.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<d81.a> d() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sMsgRecommendClickProcessorClzs.iterator();
        while (it.hasNext()) {
            d81.a aVar = (d81.a) ((Class) it.next()).newInstance();
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public final void c(@NotNull com.tencent.aio.api.runtime.a context, @Nullable AIOMsgItem msgItem, @NotNull InlineKeyboardButton buttonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, msgItem, buttonInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        for (d81.a aVar : b()) {
            if (aVar.a(context, msgItem, buttonInfo)) {
                QLog.d("AIORecommendMsgInject", 1, "[handleClick] it=" + aVar.getClass().getName());
                return;
            }
        }
    }
}
