package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u000f\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\b5\u00106J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J&\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005R(\u0010'\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010-\u001a\u00020(8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0011\u00104\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/b;", "Landroid/view/View;", "view", "", "viewType", "holder", "", "i0", "position", "", "q0", "p0", "m0", "v0", "u0", "", "getItemId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "t0", "getItemViewType", "", "", "payloads", "s0", "r0", "getItemCount", "o0", "n0", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/AutoCancelAsyncListDiffer;", "Lcom/tencent/aio/data/msglist/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/AutoCancelAsyncListDiffer;", "j0", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/AutoCancelAsyncListDiffer;", "w0", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/AutoCancelAsyncListDiffer;)V", "differ", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/footer/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/footer/a;", "k0", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/footer/a;", "footerManager", "Let/a;", "D", "Let/a;", "itemBuilder", "l0", "()I", "footerViewPosition", "<init>", "(Let/a;)V", "E", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.footer.a footerManager;

    /* renamed from: D, reason: from kotlin metadata */
    private final et.a itemBuilder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> differ;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a$a;", "", "", "LOAD_MORE_VIEW", "I", "REFRESH_VIEW", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull et.a itemBuilder) {
        Intrinsics.checkNotNullParameter(itemBuilder, "itemBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) itemBuilder);
        } else {
            this.itemBuilder = itemBuilder;
            this.footerManager = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.footer.a(this);
        }
    }

    private final void i0(View view, int viewType, b holder) {
        if (view.getParent() == null) {
            return;
        }
        throw new IllegalAccessException("onCreateViewHolder but view have attach, view type is: " + viewType + ", viewHolder is: " + holder + " parent " + view.getParent());
    }

    private final int m0() {
        return this.footerManager.b();
    }

    private final boolean p0(int position) {
        if (position >= n0() + o0()) {
            return true;
        }
        return false;
    }

    private final boolean q0(int position) {
        if (position < n0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return n0() + m0() + o0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, position)).longValue();
        }
        if (position == -1) {
            return -1L;
        }
        if (q0(position)) {
            return 268435729;
        }
        if (p0(position)) {
            return 268436002;
        }
        int n06 = position - n0();
        AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> autoCancelAsyncListDiffer = this.differ;
        if (autoCancelAsyncListDiffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("differ");
        }
        return autoCancelAsyncListDiffer.t().get(n06).getStableId$sdk_debug();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, position)).intValue();
        }
        if (q0(position)) {
            return 268435729;
        }
        if (p0(position)) {
            return 268436002;
        }
        AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> autoCancelAsyncListDiffer = this.differ;
        if (autoCancelAsyncListDiffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("differ");
        }
        return com.tencent.aio.data.msglist.b.b(autoCancelAsyncListDiffer.t().get(position - n0()));
    }

    @NotNull
    public final AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AutoCancelAsyncListDiffer) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> autoCancelAsyncListDiffer = this.differ;
        if (autoCancelAsyncListDiffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("differ");
        }
        return autoCancelAsyncListDiffer;
    }

    @NotNull
    public final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.footer.a k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.footer.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.footerManager;
    }

    public final int l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return n0() + o0();
    }

    public final int n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 0;
    }

    public final int o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> autoCancelAsyncListDiffer = this.differ;
        if (autoCancelAsyncListDiffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("differ");
        }
        return autoCancelAsyncListDiffer.t().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder.getItemViewType() != 268436002) {
            int n06 = position - n0();
            et.a aVar = this.itemBuilder;
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar2 = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) holder;
            AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> autoCancelAsyncListDiffer = this.differ;
            if (autoCancelAsyncListDiffer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("differ");
            }
            aVar.o(aVar2, n06, autoCancelAsyncListDiffer.t().get(n06), payloads);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 268436002) {
            return this.footerManager.a();
        }
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a R0 = this.itemBuilder.R0(parent, viewType);
        View view = R0.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        i0(view, viewType, R0);
        return R0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public boolean onFailedToRecycleView(@NotNull b holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull b holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.onViewRecycled();
        }
    }

    public final void w0(@NotNull AutoCancelAsyncListDiffer<com.tencent.aio.data.msglist.a> autoCancelAsyncListDiffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) autoCancelAsyncListDiffer);
        } else {
            Intrinsics.checkNotNullParameter(autoCancelAsyncListDiffer, "<set-?>");
            this.differ = autoCancelAsyncListDiffer;
        }
    }
}
