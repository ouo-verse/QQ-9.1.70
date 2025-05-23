package com.tencent.aio.widget.textView.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/widget/textView/api/b;", "Lcom/tencent/aio/widget/textView/api/e;", "", "Lcom/tencent/aio/widget/textView/creator/a;", "a", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements e {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.aio.widget.textView.api.e
    @NotNull
    public List<com.tencent.aio.widget.textView.creator.a> a() {
        List<com.tencent.aio.widget.textView.creator.a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.widget.textView.creator.a[]{new com.tencent.aio.widget.textView.creator.strategy.a(), new com.tencent.aio.widget.textView.creator.strategy.b()});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
