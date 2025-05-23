package com.tencent.mobileqq.activity.home.impl;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tab.g;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001ej\b\u0012\u0004\u0012\u00020\u0005`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/activity/home/impl/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/activity/home/impl/e$b;", "", "getItemCount", "Lcom/tencent/mobileqq/tab/g;", "bean", "", "i0", "position", "Lcom/tencent/mobileqq/activity/home/impl/c;", "l0", "", "tabKey", "Landroid/view/View;", "k0", "j0", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "m0", "Lcom/tencent/mobileqq/app/FrameFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/app/FrameFragment;", "getFragment", "()Lcom/tencent/mobileqq/app/FrameFragment;", "fragment", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mBeanList", "<init>", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "D", "a", "b", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<g> mBeanList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameFragment fragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/home/impl/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.impl.e$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/activity/home/impl/e$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "l", "()Landroid/view/ViewGroup;", "itemView2", "<init>", "(Landroid/view/ViewGroup;)V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ViewGroup itemView2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ViewGroup itemView2) {
            super(itemView2);
            Intrinsics.checkNotNullParameter(itemView2, "itemView2");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView2);
            } else {
                this.itemView2 = itemView2;
            }
        }

        @NotNull
        public final ViewGroup l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.itemView2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33138);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull FrameFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment);
        } else {
            this.fragment = fragment;
            this.mBeanList = new ArrayList<>();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mBeanList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, position)).intValue();
        }
        return l0(position).m().hashCode();
    }

    public final void i0(@NotNull g bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bean);
            return;
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        QLog.d("FrameUtil.TabLayoutViewAdapter", 1, "addItem bean.key=" + bean.b().m());
        this.mBeanList.add(bean);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("FrameUtil.TabLayoutViewAdapter", 1, "clearAllItem");
        this.mBeanList.clear();
        notifyDataSetChanged();
    }

    @Nullable
    public final View k0(@NotNull String tabKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) tabKey);
        }
        Intrinsics.checkNotNullParameter(tabKey, "tabKey");
        return this.fragment.mTabViewMap.get(tabKey);
    }

    @NotNull
    public final c l0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this, position);
        }
        return this.mBeanList.get(position).b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        c l06 = l0(position);
        View contentView = this.fragment.createTabContent(l06.k().getName());
        QLog.d("FrameUtil.TabLayoutViewAdapter", 1, "onBindViewHolder position=" + position + ", key=" + l06.m());
        if (Intrinsics.areEqual(contentView.getParent(), holder.l())) {
            QLog.d("FrameUtil.TabLayoutViewAdapter", 1, "onBindViewHolder \u590d\u7528position=" + position);
            return;
        }
        if (contentView.getParent() != null) {
            QLog.d("FrameUtil.TabLayoutViewAdapter", 1, "onBindViewHolder removeFromParent, position=" + position);
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            ab.c(contentView);
        }
        holder.l().addView(contentView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (b) iPatchRedirector.redirect((short) 9, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        QLog.d("FrameUtil.TabLayoutViewAdapter", 1, "onCreateViewHolder viewType=" + viewType);
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(ViewCompat.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new b(frameLayout);
    }
}
