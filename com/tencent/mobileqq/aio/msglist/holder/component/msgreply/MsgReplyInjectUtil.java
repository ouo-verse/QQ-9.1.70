package com.tencent.mobileqq.aio.msglist.holder.component.msgreply;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.p;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fRF\u0010\u0018\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00100\u000fj\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0010`\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bRB\u0010 \u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00100\u000fj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0010`\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001d\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/MsgReplyInjectUtil;", "", "", "f", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/c;", "g", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/d;", h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/f;", "extInfo", "e", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "i", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getSMsgReplyClickProcessorClzs", "()Ljava/util/ArrayList;", "setSMsgReplyClickProcessorClzs", "(Ljava/util/ArrayList;)V", "sMsgReplyClickProcessorClzs", "c", "Lkotlin/Lazy;", "()Ljava/util/List;", "sMsgReplyClickProcessors", "d", "getSMsgReplyExposureReporterClzs", "setSMsgReplyExposureReporterClzs", "sMsgReplyExposureReporterClzs", "sMsgReplyExposureReporters", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MsgReplyInjectUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MsgReplyInjectUtil f191195a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msgreply/Inject_msgreply_processor.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends c>> sMsgReplyClickProcessorClzs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sMsgReplyClickProcessors;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msgreply/Inject_msgreply_processor.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends d>> sMsgReplyExposureReporterClzs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sMsgReplyExposureReporters;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62008);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f191195a = new MsgReplyInjectUtil();
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        sMsgReplyClickProcessorClzs = arrayList;
        arrayList.add(p.class);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) MsgReplyInjectUtil$sMsgReplyClickProcessors$2.INSTANCE);
        sMsgReplyClickProcessors = lazy;
        ArrayList<Class<? extends d>> arrayList2 = new ArrayList<>();
        sMsgReplyExposureReporterClzs = arrayList2;
        arrayList2.add(q.class);
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) MsgReplyInjectUtil$sMsgReplyExposureReporters$2.INSTANCE);
        sMsgReplyExposureReporters = lazy2;
        f();
    }

    MsgReplyInjectUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<c> c() {
        return (List) sMsgReplyClickProcessors.getValue();
    }

    private final List<d> d() {
        return (List) sMsgReplyExposureReporters.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<c> g() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sMsgReplyClickProcessorClzs.iterator();
        while (it.hasNext()) {
            c cVar = (c) ((Class) it.next()).newInstance();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<d> h() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sMsgReplyExposureReporterClzs.iterator();
        while (it.hasNext()) {
            d dVar = (d) ((Class) it.next()).newInstance();
            if (dVar != null) {
                Intrinsics.checkNotNullExpressionValue(dVar, "newInstance()");
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public final void e(@NotNull f extInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) extInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        for (c cVar : c()) {
            if (cVar.a(extInfo)) {
                QLog.d("LIAInjectUtil", 1, "[handleClick] it=" + cVar.getClass().getName());
                return;
            }
        }
    }

    public final void i(@NotNull AIOMsgItem aioMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aioMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Iterator<T> it = d().iterator();
        while (it.hasNext() && !((d) it.next()).a(aioMsgItem)) {
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void f() {
    }
}
