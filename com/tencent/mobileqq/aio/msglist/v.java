package com.tencent.mobileqq.aio.msglist;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qui.quiblurview.f;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/v;", "Lcom/tencent/qui/quiblurview/f$b;", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "b", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "", "[I", "loc", "", "c", "I", "scrollY", "d", "childCount", "e", "chatListLocY", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
final class v implements f.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] loc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int scrollY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int childCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int chatListLocY;

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.loc = new int[2];
        this.scrollY = -1;
        this.childCount = -1;
        this.chatListLocY = -1;
    }

    @Override // com.tencent.qui.quiblurview.f.b
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            return false;
        }
        int childCount = recyclerView.getChildCount();
        if (this.childCount != childCount) {
            this.childCount = childCount;
            return true;
        }
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        if (this.scrollY != computeVerticalScrollOffset) {
            this.scrollY = computeVerticalScrollOffset;
            return true;
        }
        recyclerView.getLocationInWindow(this.loc);
        int i3 = this.loc[1];
        if (this.chatListLocY == i3) {
            return false;
        }
        this.chatListLocY = i3;
        return true;
    }

    public final void b(@Nullable RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView);
        } else {
            this.recyclerView = recyclerView;
        }
    }
}
