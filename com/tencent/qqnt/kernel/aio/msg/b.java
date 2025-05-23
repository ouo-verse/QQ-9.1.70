package com.tencent.qqnt.kernel.aio.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.kernel.api.AIOSendMsgResultData;
import com.tencent.qqnt.kernel.api.c;
import com.tencent.qqnt.kernel.api.d;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0003JR\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012R6\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015`\n8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019R0\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\bj\b\u0012\u0004\u0012\u00020\u001b`\n8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/kernel/aio/msg/b;", "", "", "a", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "msgAttrs", "b", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData;", "result", "c", "Ljava/lang/Class;", "Lcom/tencent/qqnt/kernel/api/d;", "Ljava/util/ArrayList;", "getAioSendMsgProcessorClassList$annotations", "()V", "aioSendMsgProcessorClassList", "Lcom/tencent/qqnt/kernel/api/c;", "getAioSendMsgListenerList", "()Ljava/util/ArrayList;", "getAioSendMsgListenerList$annotations", "aioSendMsgListenerList", "<init>", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f357214a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msg/Inject_AIO_SendMsg_Processor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<d>> aioSendMsgProcessorClassList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/msg/Inject_AIO_SendMsg_Processor.yml", version = 1)
    @NotNull
    private static final ArrayList<c> aioSendMsgListenerList;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f357217d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36633);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f357217d = arrayList;
        arrayList.add(com.tencent.mobileqq.aio.msg.report.b.class);
        b bVar = new b();
        f357214a = bVar;
        ArrayList<Class<d>> arrayList2 = new ArrayList<>();
        aioSendMsgProcessorClassList = arrayList2;
        arrayList2.add(com.tencent.mobileqq.aio.robot.c.class);
        arrayList2.add(com.tencent.guild.aio.sendmsg.c.class);
        aioSendMsgListenerList = new ArrayList<>();
        bVar.a();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @QAutoInitMethod
    private final void a() {
        com.tencent.mobileqq.qroute.utils.b.c(f357217d, aioSendMsgListenerList);
    }

    public final void b(long msgId, @NotNull Contact contact, @NotNull ArrayList<MsgElement> msgElements, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), contact, msgElements, msgAttrs);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(msgAttrs, "msgAttrs");
        Iterator<Class<d>> it = aioSendMsgProcessorClassList.iterator();
        while (it.hasNext()) {
            it.next().newInstance().a(msgId, contact, msgElements, msgAttrs);
        }
    }

    public final void c(@NotNull AIOSendMsgResultData result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<T> it = aioSendMsgListenerList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(result);
        }
    }
}
