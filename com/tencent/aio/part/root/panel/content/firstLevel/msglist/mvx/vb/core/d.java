package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core;

import android.view.View;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.m;
import com.tencent.aio.exception.AIOException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/d;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "", "e", "d", "recyclerView", "", "dx", "dy", "onScrolled", "I", "firstVisibleItemPosition", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "firstVisibleItemView", "f", "lastVisibleItemPosition", h.F, "lastVisibleItemView", "Landroidx/recyclerview/widget/AIOLayoutManager;", "i", "Landroidx/recyclerview/widget/AIOLayoutManager;", "layoutManager", "<init>", "(Landroidx/recyclerview/widget/AIOLayoutManager;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class d extends RecyclerView.OnScrollListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int firstVisibleItemPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<View> firstVisibleItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastVisibleItemPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private WeakReference<View> lastVisibleItemView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AIOLayoutManager layoutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/d$a;", "", "", "INVALID_INDEX", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull AIOLayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutManager);
            return;
        }
        this.layoutManager = layoutManager;
        this.firstVisibleItemPosition = -1;
        this.lastVisibleItemPosition = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r3.getParent(), r4)) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d(View view, RecyclerView recycleView) {
        boolean z16;
        if (view.getParent() != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                throw new AIOException("View " + view + " is not a direct child of " + this);
            }
            return;
        }
        Object childViewHolder = recycleView.getChildViewHolder(view);
        if (!(childViewHolder instanceof m)) {
            childViewHolder = null;
        }
        m mVar = (m) childViewHolder;
        if (mVar != null) {
            mVar.g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r3.getParent(), r4)) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(View view, RecyclerView recycleView) {
        boolean z16;
        if (view.getParent() != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                throw new AIOException("View " + view + " is not a direct child of " + this);
            }
            return;
        }
        Object childViewHolder = recycleView.getChildViewHolder(view);
        if (!(childViewHolder instanceof m)) {
            childViewHolder = null;
        }
        m mVar = (m) childViewHolder;
        if (mVar != null) {
            mVar.k();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
        WeakReference<View> weakReference;
        View it;
        WeakReference<View> weakReference2;
        View it5;
        View it6;
        View it7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx5, dy5);
        int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if (this.firstVisibleItemPosition == -1) {
            this.firstVisibleItemPosition = findFirstVisibleItemPosition;
        }
        if (this.lastVisibleItemPosition == -1) {
            this.lastVisibleItemPosition = findLastVisibleItemPosition;
        }
        if (this.firstVisibleItemPosition < findFirstVisibleItemPosition) {
            WeakReference<View> weakReference3 = this.firstVisibleItemView;
            if (weakReference3 != null && (it7 = weakReference3.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(it7, "it");
                e(it7, recyclerView);
            }
        } else if (this.lastVisibleItemPosition > findLastVisibleItemPosition && (weakReference = this.lastVisibleItemView) != null && (it = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            e(it, recyclerView);
        }
        if (this.firstVisibleItemPosition > findFirstVisibleItemPosition) {
            WeakReference<View> weakReference4 = this.firstVisibleItemView;
            if (weakReference4 != null && (it6 = weakReference4.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(it6, "it");
                d(it6, recyclerView);
            }
        } else if (this.lastVisibleItemPosition < findLastVisibleItemPosition && (weakReference2 = this.lastVisibleItemView) != null && (it5 = weakReference2.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            d(it5, recyclerView);
        }
        this.firstVisibleItemPosition = findFirstVisibleItemPosition;
        this.lastVisibleItemPosition = findLastVisibleItemPosition;
        this.firstVisibleItemView = new WeakReference<>(recyclerView.getChildAt(0));
        this.lastVisibleItemView = new WeakReference<>(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
    }
}
