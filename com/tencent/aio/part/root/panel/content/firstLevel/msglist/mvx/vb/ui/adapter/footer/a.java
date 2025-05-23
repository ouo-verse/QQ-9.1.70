package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.footer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/footer/a;", "Lcom/tencent/aio/api/list/c;", "", "c", "Landroid/view/View;", "view", "", "index", "", "B", "K", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/b;", "a", "b", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "footerLayout", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "e", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "aioListAdapter", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout footerLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aioListAdapter;

    public a(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aioListAdapter) {
        Intrinsics.checkNotNullParameter(aioListAdapter, "aioListAdapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aioListAdapter);
        } else {
            this.aioListAdapter = aioListAdapter;
        }
    }

    private final boolean c() {
        LinearLayout linearLayout = this.footerLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
            }
            if (linearLayout.getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.aio.api.list.c
    public void B(@NotNull View view, int index) {
        int l06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, index);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.footerLayout == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.footerLayout = linearLayout;
            linearLayout.setOrientation(1);
            LinearLayout linearLayout2 = this.footerLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
            }
            linearLayout2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
        LinearLayout linearLayout3 = this.footerLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
        }
        int childCount = linearLayout3.getChildCount();
        if (index < 0 || index > childCount) {
            index = childCount;
        }
        LinearLayout linearLayout4 = this.footerLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
        }
        linearLayout4.addView(view, index);
        LinearLayout linearLayout5 = this.footerLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
        }
        if (linearLayout5.getChildCount() == 1 && (l06 = this.aioListAdapter.l0()) != -1) {
            this.aioListAdapter.notifyItemInserted(l06);
        }
    }

    @Override // com.tencent.aio.api.list.c
    public void K(@NotNull View view) {
        int l06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (!c()) {
            return;
        }
        LinearLayout linearLayout = this.footerLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
        }
        linearLayout.removeView(view);
        LinearLayout linearLayout2 = this.footerLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
        }
        if (linearLayout2.getChildCount() == 0 && (l06 = this.aioListAdapter.l0()) != -1) {
            this.aioListAdapter.notifyItemRemoved(l06);
        }
    }

    @NotNull
    public final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        LinearLayout linearLayout = this.footerLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
        }
        ViewParent parent = linearLayout.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            LinearLayout linearLayout2 = this.footerLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
            }
            viewGroup.removeView(linearLayout2);
        }
        LinearLayout linearLayout3 = this.footerLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerLayout");
        }
        return new b(linearLayout3);
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return c() ? 1 : 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }
}
