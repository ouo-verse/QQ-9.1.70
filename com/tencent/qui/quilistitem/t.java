package com.tencent.qui.quilistitem;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qui.quilistitem.Group;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H$\u00a2\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005J*\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ%\u0010\u0019\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qui/quilistitem/t;", "Landroid/view/View;", "V", "Lcom/tencent/qui/quilistitem/a;", "Lcom/tencent/qui/quilistitem/w;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "o", "(Landroid/view/ViewGroup;)Landroid/view/View;", "view", "", "position", "", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/view/View;ILjava/util/List;)V", "Lcom/tencent/qui/quilistitem/Group$b;", "outMargin", "k", "(Landroid/view/View;Lcom/tencent/qui/quilistitem/Group$b;)V", "p", "viewHolder", DomainData.DOMAIN_NAME, "l", "(Lcom/tencent/qui/quilistitem/w;Lcom/tencent/qui/quilistitem/Group$b;)V", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public abstract class t<V extends View> extends a<w<V>> {
    static IPatchRedirector $redirector_;

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    protected abstract void k(@NotNull V view, @NotNull Group.b outMargin);

    @Override // com.tencent.qui.quilistitem.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void b(@NotNull w<V> viewHolder, @NotNull Group.b outMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        super.b(viewHolder, outMargin);
        k(viewHolder.getView(), outMargin);
    }

    protected abstract void m(@NotNull V view, int position, @NotNull List<? extends Object> payloads);

    @Override // com.tencent.qui.quilistitem.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void g(@NotNull w<V> viewHolder, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, viewHolder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        m(viewHolder.getView(), position, payloads);
    }

    @NotNull
    protected abstract V o(@NotNull ViewGroup parent);

    @Override // com.tencent.qui.quilistitem.a
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final w<V> h(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (w) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new w<>(o(parent));
    }
}
