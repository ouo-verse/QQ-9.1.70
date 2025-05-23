package com.tencent.qqnt.kernel.aio.msg;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.vas.am;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0013J:\u0010\u000b\u001a\u00020\n2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003R6\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r`\u000f8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/kernel/aio/msg/a;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", QQBrowserActivity.KEY_MSG_TYPE, "", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/kernel/api/b;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getAioSendDataProcessorClassList$annotations", "()V", "aioSendDataProcessorClassList", "<init>", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f357212a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msg/Inject_AIO_SendData_Processor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.kernel.api.b>> aioSendDataProcessorClassList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f357212a = new a();
        ArrayList<Class<com.tencent.qqnt.kernel.api.b>> arrayList = new ArrayList<>();
        aioSendDataProcessorClassList = arrayList;
        arrayList.add(am.class);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull HashMap<Integer, MsgAttributeInfo> attrs, @NotNull Contact contact, int msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, attrs, contact, Integer.valueOf(msgType));
            return;
        }
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Iterator<Class<com.tencent.qqnt.kernel.api.b>> it = aioSendDataProcessorClassList.iterator();
        while (it.hasNext()) {
            it.next().newInstance().a(attrs, contact, msgType);
        }
    }
}
