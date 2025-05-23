package com.tencent.qqnt.chathistory.ui.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.x2k.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/g;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "", "f", "()I", "itemViewType", "<init>", "()V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g extends com.tencent.qqnt.expandRecyclerView.adapter.provider.c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/g$a;", "", "", "TYPE_GROUP", "I", "TYPE_ILLEGAL", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.base.g$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g this$0, com.tencent.qqnt.expandRecyclerView.adapter.a helper, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b m3 = this$0.m();
        if (m3 != null) {
            com.tencent.qqnt.expandRecyclerView.adapter.provider.b.M0(m3, helper.getAdapterPosition(), false, false, null, 14, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    @NotNull
    public View c(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new x(context, null, 2, null).getMRv();
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull final com.tencent.qqnt.expandRecyclerView.adapter.a helper, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) helper, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.qqnt.chathistory.ui.base.item.a aVar = (com.tencent.qqnt.chathistory.ui.base.item.a) item;
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.base.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.p(g.this, helper, view);
            }
        });
        ((CheckBox) helper.getView(R.id.dv_)).setChecked(aVar.d());
        String a16 = com.tencent.qqnt.chathistory.ui.base.item.c.a(aVar);
        helper.l(R.id.jjc, a16);
        TextView textView = (TextView) helper.getView(R.id.jjc);
        if (aVar.d()) {
            str = "\u5df2\u5c55\u5f00";
        } else {
            str = "\u5df2\u6536\u8d77";
        }
        textView.setContentDescription(a16 + " " + str);
    }
}
