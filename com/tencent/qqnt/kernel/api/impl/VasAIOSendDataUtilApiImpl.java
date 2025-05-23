package com.tencent.qqnt.kernel.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.IVasAIOSendDataUtilApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/VasAIOSendDataUtilApiImpl;", "Lcom/tencent/qqnt/kernel/api/IVasAIOSendDataUtilApi;", "()V", "detailVasMsgDataAttrs", "", Node.ATTRS_ATTR, "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", QQBrowserActivity.KEY_MSG_TYPE, "kernel_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class VasAIOSendDataUtilApiImpl implements IVasAIOSendDataUtilApi {
    static IPatchRedirector $redirector_;

    public VasAIOSendDataUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IVasAIOSendDataUtilApi
    public void detailVasMsgDataAttrs(@NotNull HashMap<Integer, MsgAttributeInfo> attrs, @NotNull Contact contact, int msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, attrs, contact, Integer.valueOf(msgType));
            return;
        }
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(contact, "contact");
        com.tencent.qqnt.kernel.aio.msg.a.f357212a.a(attrs, contact, msgType);
    }
}
