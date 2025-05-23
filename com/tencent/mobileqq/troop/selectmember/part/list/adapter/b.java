package com.tencent.mobileqq.troop.selectmember.part.list.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J.\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/b;", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/b$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "holder", "", "payloads", "", "l", "<init>", "()V", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends AbsTroopSelectMemberDelegate<com.tencent.mobileqq.troop.selectmember.bean.a, C8765b> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.part.list.adapter.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "containerView", "<init>", "(Landroid/widget/TextView;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.part.list.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8765b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView containerView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8765b(@NotNull TextView containerView) {
            super(containerView);
            Intrinsics.checkNotNullParameter(containerView, "containerView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) containerView);
            } else {
                this.containerView = containerView;
            }
        }

        @NotNull
        public final TextView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.containerView;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54956);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a item, @NotNull List<com.tencent.mobileqq.troop.selectmember.bean.a> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a data, @NotNull C8765b holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.l().setVisibility(8);
        QLog.e("TroopMemberIllegalDataDelegate", 1, "[onBindViewHolder] illegal data:" + data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C8765b onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C8765b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new C8765b(textView);
    }
}
