package com.tencent.mobileqq.troop.shortcut.ui;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUIDoubleLineListItem;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.c.a;
import com.tencent.mobileqq.widget.listitem.c.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0017\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\u0006\u0010\u0010\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/ui/a;", "Lcom/tencent/mobileqq/widget/listitem/c$a;", "L", "Lcom/tencent/mobileqq/widget/listitem/c$b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/QUIDoubleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "l", "r", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/c$a;Lcom/tencent/mobileqq/widget/listitem/c$b;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a<L extends c.a, R extends c.b> extends com.tencent.mobileqq.widget.listitem.c<L, R> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull L l3, @NotNull R r16) {
        super(l3, r16);
        Intrinsics.checkNotNullParameter(l3, "l");
        Intrinsics.checkNotNullParameter(r16, "r");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3, (Object) r16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.c, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(@NotNull QUIDoubleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        view.setBackgroundType(QUIListItemBackgroundType.FullWidthWithTransparent);
    }
}
