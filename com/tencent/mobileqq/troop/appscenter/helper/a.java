package com.tencent.mobileqq.troop.appscenter.helper;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.appscenter.adapter.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/helper/a;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "", "position", "", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vh", "getMovementFlags", "target", "", "onMove", "", "onSwiped", "actionState", "onSelectedChanged", "clearView", "Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "adapter", "b", "I", "fromPosition", "<init>", "(Lcom/tencent/mobileqq/troop/appscenter/adapter/h;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ItemTouchHelper.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h adapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int fromPosition;

    public a(@NotNull h adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) adapter);
        } else {
            this.adapter = adapter;
            this.fromPosition = -1;
        }
    }

    private final String a(RecyclerView rv5, int position) {
        GridLayoutManager gridLayoutManager;
        RecyclerView.LayoutManager layoutManager = rv5.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) layoutManager;
        } else {
            gridLayoutManager = null;
        }
        if (gridLayoutManager == null) {
            return "";
        }
        int spanCount = gridLayoutManager.getSpanCount();
        return ((position / spanCount) + 1) + "\u884c" + ((position % spanCount) + 1) + "\u5217";
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView rv5, @NotNull RecyclerView.ViewHolder vh5) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rv5, (Object) vh5);
            return;
        }
        Intrinsics.checkNotNullParameter(rv5, "rv");
        Intrinsics.checkNotNullParameter(vh5, "vh");
        super.clearView(rv5, vh5);
        if (AppSetting.f99565y && (i3 = this.fromPosition) != -1) {
            vh5.itemView.announceForAccessibility(this.adapter.q0(i3));
        }
        this.fromPosition = -1;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView rv5, @NotNull RecyclerView.ViewHolder vh5) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rv5, (Object) vh5)).intValue();
        }
        Intrinsics.checkNotNullParameter(rv5, "rv");
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (this.adapter.o0(vh5.getAdapterPosition()) && this.adapter.p0()) {
            i3 = 15;
        } else {
            i3 = 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i3, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView rv5, @NotNull RecyclerView.ViewHolder vh5, @NotNull RecyclerView.ViewHolder target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, rv5, vh5, target)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(rv5, "rv");
        Intrinsics.checkNotNullParameter(vh5, "vh");
        Intrinsics.checkNotNullParameter(target, "target");
        this.fromPosition = vh5.getAdapterPosition();
        int adapterPosition = target.getAdapterPosition();
        if (this.adapter.p0() && this.adapter.o0(this.fromPosition) && this.adapter.o0(adapterPosition)) {
            this.adapter.B0(this.fromPosition, adapterPosition);
            if (AppSetting.f99565y) {
                String q06 = this.adapter.q0(adapterPosition);
                rv5.announceForAccessibility(a(rv5, adapterPosition) + " " + q06);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder vh5, int actionState) {
        int i3;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) vh5, actionState);
            return;
        }
        super.onSelectedChanged(vh5, actionState);
        if (AppSetting.f99565y && actionState == 2) {
            if (vh5 != null) {
                i3 = vh5.getAdapterPosition();
            } else {
                i3 = 0;
            }
            if (vh5 != null && (view = vh5.itemView) != null) {
                view.announceForAccessibility(this.adapter.q0(i3));
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder vh5, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) vh5, position);
        } else {
            Intrinsics.checkNotNullParameter(vh5, "vh");
        }
    }
}
