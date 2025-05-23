package com.tencent.qqnt.contacts.widget.adapter.provider;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.contacts.widget.adapter.BaseProviderMultiAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/contacts/widget/adapter/provider/c;", "Lcom/tencent/qqnt/contacts/widget/adapter/provider/a;", "Lcom/tencent/qqnt/contacts/widget/adapter/node/b;", "Lcom/tencent/qqnt/contacts/widget/adapter/provider/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class c extends a<com.tencent.qqnt.contacts.widget.adapter.node.b> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        BaseProviderMultiAdapter d16 = super.d();
        if (d16 instanceof b) {
            return (b) d16;
        }
        return null;
    }
}
