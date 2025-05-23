package com.tencent.qqnt.emotion.relatedemo.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.relatedemo.api.IRelatedEmoPanelApi;
import com.tencent.qqnt.emotion.relatedemo.c;
import com.tencent.qqnt.emotion.relatedemo.d;
import com.tencent.qqnt.emotion.relatedemo.ui.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/api/impl/RelatedEmoPanelApiImpl;", "Lcom/tencent/qqnt/emotion/relatedemo/api/IRelatedEmoPanelApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/emotion/relatedemo/d;", "vm", "Lcom/tencent/qqnt/emotion/relatedemo/c;", "getPanelVB", "getPanelVM", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RelatedEmoPanelApiImpl implements IRelatedEmoPanelApi {
    static IPatchRedirector $redirector_;

    public RelatedEmoPanelApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.api.IRelatedEmoPanelApi
    @NotNull
    public c getPanelVB(@NotNull Context context, @NotNull d vm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) vm5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        return new b(context, vm5);
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.api.IRelatedEmoPanelApi
    @NotNull
    public d getPanelVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.qqnt.emotion.relatedemo.logic.c();
    }
}
