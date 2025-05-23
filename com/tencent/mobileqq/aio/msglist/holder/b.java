package com.tencent.mobileqq.aio.msglist.holder;

import android.view.ViewGroup;
import com.tencent.mobileqq.aio.msglist.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J<\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/i;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "", "viewType", "subViewType", "Lcom/tencent/mobileqq/aio/msglist/x;", "factoryProvider", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "b", "Lcom/tencent/aio/api/list/b;", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/h;", "Lcom/tencent/mobileqq/aio/msglist/holder/h;", "delegate", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/h;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h delegate;

    public b(@NotNull h delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) delegate);
        } else {
            this.delegate = delegate;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.i
    @NotNull
    public com.tencent.aio.api.list.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.list.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.delegate.c();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.i
    @NotNull
    public com.tencent.aio.api.list.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> b(@NotNull ViewGroup parent, boolean isSelf, int viewType, int subViewType, @NotNull x factoryProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.list.a) iPatchRedirector.redirect((short) 2, this, parent, Boolean.valueOf(isSelf), Integer.valueOf(viewType), Integer.valueOf(subViewType), factoryProvider);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        return this.delegate.b(parent, isSelf, viewType, subViewType, factoryProvider);
    }
}
