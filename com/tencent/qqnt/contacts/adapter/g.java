package com.tencent.qqnt.contacts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/contacts/adapter/g;", "Lcom/tencent/qqnt/contacts/widget/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/contacts/widget/adapter/a;", "helper", "Lcom/tencent/qqnt/contacts/widget/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "", "f", "()I", "itemViewType", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g extends com.tencent.qqnt.contacts.widget.adapter.provider.c {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g this$0, com.tencent.qqnt.contacts.widget.adapter.a helper, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        com.tencent.qqnt.contacts.widget.adapter.provider.b m3 = this$0.m();
        if (m3 != null) {
            com.tencent.qqnt.contacts.widget.adapter.provider.b.z0(m3, helper.getAdapterPosition(), false, false, null, 14, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.contacts.widget.adapter.provider.a
    @NotNull
    public View c(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        ConstraintLayout root = sw3.a.g(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent, false).root");
        return root;
    }

    @Override // com.tencent.qqnt.contacts.widget.adapter.provider.a
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.contacts.widget.adapter.provider.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull final com.tencent.qqnt.contacts.widget.adapter.a helper, @NotNull com.tencent.qqnt.contacts.widget.adapter.node.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) helper, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.qqnt.contacts.data.item.a aVar = (com.tencent.qqnt.contacts.data.item.a) item;
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.contacts.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.p(g.this, helper, view);
            }
        });
        ((TextView) helper.getView(R.id.tsu)).setText(aVar.d());
        ((CheckBox) helper.getView(R.id.dv_)).setChecked(aVar.b());
    }
}
