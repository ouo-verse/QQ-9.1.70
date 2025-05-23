package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017B!\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u0013\u0010\u001aJ\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter;", "Lcom/tencent/qqnt/chats/view/SkinnableRecycleView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "Landroid/view/View;", "view", "D", "E", BdhLogUtil.LogTag.Tag_Conn, "", "i", "Ljava/util/List;", "mHeaders", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mFooters", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class NTChatRecyclerViewWithHeaderFooter extends SkinnableRecycleView {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<View> mHeaders;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<View> mFooters;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.NTChatRecyclerViewWithHeaderFooter$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$b;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$c;", "a", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$c;", "mAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", "b", "Landroidx/recyclerview/widget/GridLayoutManager;", "mLayoutManager", "c", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "mInnerSpanSizeLookup", "adapter", "layoutManager", "<init>", "(Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$c;Landroidx/recyclerview/widget/GridLayoutManager;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c mAdapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GridLayoutManager mLayoutManager;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private GridLayoutManager.SpanSizeLookup mInnerSpanSizeLookup;

        public b(@NotNull c adapter, @NotNull GridLayoutManager layoutManager) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) adapter, (Object) layoutManager);
            } else {
                this.mAdapter = adapter;
                this.mLayoutManager = layoutManager;
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, position)).intValue();
            }
            if (!this.mAdapter.isHeaderPosition(position) && !this.mAdapter.isFooterPosition(position)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return this.mLayoutManager.getSpanCount();
            }
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.mInnerSpanSizeLookup;
            if (spanSizeLookup == null) {
                return 1;
            }
            Intrinsics.checkNotNull(spanSizeLookup);
            return spanSizeLookup.getSpanSize(position - this.mAdapter.m0());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52957);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTChatRecyclerViewWithHeaderFooter(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mHeaders = new ArrayList();
            this.mFooters = new ArrayList();
        }
    }

    public final void C(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mFooters.add(view);
        }
    }

    public final void D(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mHeaders.add(view);
        }
    }

    public final void E(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mHeaders.remove(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) adapter);
            return;
        }
        GridLayoutManager gridLayoutManager = null;
        if (adapter == null) {
            adapter = null;
        }
        if (adapter == null) {
            return;
        }
        if (this.mHeaders.size() > 0 || this.mFooters.size() > 0) {
            c cVar = new c(adapter);
            Iterator<View> it = this.mHeaders.iterator();
            while (it.hasNext()) {
                cVar.k0(it.next());
            }
            Iterator<View> it5 = this.mFooters.iterator();
            while (it5.hasNext()) {
                cVar.j0(it5.next());
            }
            cVar.setHasStableIds(adapter.hasStableIds());
            if (getLayoutManager() instanceof GridLayoutManager) {
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    gridLayoutManager = (GridLayoutManager) layoutManager;
                }
                if (gridLayoutManager == null) {
                    return;
                } else {
                    gridLayoutManager.setSpanSizeLookup(new b(cVar, gridLayoutManager));
                }
            }
            adapter = cVar;
        }
        super.setAdapter(adapter);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B\u0015\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "l0", "k0", "j0", "", "viewType", "", "o0", "n0", "Landroid/view/ViewGroup;", "viewGroup", "onCreateViewHolder", "viewHolder", "position", "", "", "payloads", "onBindViewHolder", "getItemCount", "getItemViewType", "holder", "onViewRecycled", "", "getItemId", "onViewAttachedToWindow", "onViewDetachedFromWindow", "m0", "isHeaderPosition", "isFooterPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "wrappedAdapter", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mHeaders", "D", "mFooters", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "E", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final List<View> mHeaders;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final List<View> mFooters;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView.Adapter<RecyclerView.ViewHolder> wrappedAdapter;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$c$b;", "", "", "FOOTER_VIEW_TYPE", "I", "HEADER_VIEW_TYPE", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.NTChatRecyclerViewWithHeaderFooter$c$b, reason: from kotlin metadata */
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
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$c$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.NTChatRecyclerViewWithHeaderFooter$c$c, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C7200c extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C7200c(@NotNull View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52951);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 20)) {
                redirector.redirect((short) 20);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public c(@NotNull RecyclerView.Adapter<RecyclerView.ViewHolder> wrappedAdapter) {
            Intrinsics.checkNotNullParameter(wrappedAdapter, "wrappedAdapter");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) wrappedAdapter);
                return;
            }
            this.wrappedAdapter = wrappedAdapter;
            this.mHeaders = new ArrayList();
            this.mFooters = new ArrayList();
            wrappedAdapter.registerAdapterDataObserver(new a());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.mHeaders.size() + this.wrappedAdapter.getNUM_BACKGOURND_ICON() + this.mFooters.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, position)).longValue();
            }
            if (position < this.mHeaders.size()) {
                hashCode = this.mHeaders.get(position).hashCode();
            } else {
                if (position < this.mHeaders.size() + this.wrappedAdapter.getNUM_BACKGOURND_ICON()) {
                    return this.wrappedAdapter.getItemId(position - this.mHeaders.size());
                }
                hashCode = this.mFooters.get((position - this.mHeaders.size()) - this.wrappedAdapter.getNUM_BACKGOURND_ICON()).hashCode();
            }
            return hashCode;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, position)).intValue();
            }
            if (position < this.mHeaders.size()) {
                return position - 1000;
            }
            if (position < this.mHeaders.size() + this.wrappedAdapter.getNUM_BACKGOURND_ICON()) {
                return this.wrappedAdapter.getItemViewType(position - this.mHeaders.size());
            }
            return ((position - 2000) - this.mHeaders.size()) - this.wrappedAdapter.getNUM_BACKGOURND_ICON();
        }

        public final boolean isFooterPosition(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, position)).booleanValue();
            }
            if (position >= getNUM_BACKGOURND_ICON() - this.mFooters.size()) {
                return true;
            }
            return false;
        }

        public final boolean isHeaderPosition(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, position)).booleanValue();
            }
            if (position < this.mHeaders.size()) {
                return true;
            }
            return false;
        }

        public final void j0(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                Intrinsics.checkNotNullParameter(view, "view");
                this.mFooters.add(view);
            }
        }

        public final void k0(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intrinsics.checkNotNullParameter(view, "view");
                this.mHeaders.add(view);
            }
        }

        public final int m0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return this.mHeaders.size();
        }

        public final boolean n0(int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, viewType)).booleanValue();
            }
            if (viewType >= -2000 && viewType < this.mFooters.size() - 2000) {
                return true;
            }
            return false;
        }

        public final boolean o0(int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, viewType)).booleanValue();
            }
            if (viewType >= -1000 && viewType < this.mHeaders.size() - 1000) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position, @NotNull List<? extends Object> payloads) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, viewHolder, Integer.valueOf(position), payloads);
                return;
            }
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if (position >= this.mHeaders.size() && position < this.mHeaders.size() + this.wrappedAdapter.getNUM_BACKGOURND_ICON()) {
                this.wrappedAdapter.onBindViewHolder(viewHolder, position - this.mHeaders.size(), payloads);
            } else {
                super.onBindViewHolder(viewHolder, position, payloads);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
            RecyclerView.ViewHolder onCreateViewHolder;
            ViewGroup viewGroup2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup, viewType);
            }
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            if (o0(viewType)) {
                View view = this.mHeaders.get(Math.abs(viewType + 1000));
                l0(view);
                onCreateViewHolder = new C7200c(view);
            } else if (n0(viewType)) {
                View view2 = this.mFooters.get(Math.abs(viewType + 2000));
                l0(view2);
                onCreateViewHolder = new C7200c(view2);
            } else {
                onCreateViewHolder = this.wrappedAdapter.onCreateViewHolder(viewGroup, viewType);
            }
            Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "if (isHeader(viewType)) \u2026, viewType)\n            }");
            if (onCreateViewHolder.itemView.getParent() != null) {
                QLog.e("NTChatRecyclerViewWithHeaderFooter", 1, "onCreateViewHolder find itemView attached! viewType=" + viewType);
                ViewParent parent = onCreateViewHolder.itemView.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) parent;
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 != null) {
                    viewGroup2.removeView(onCreateViewHolder.itemView);
                }
                QLog.i("NTChatRecyclerViewWithHeaderFooter", 1, "onCreateViewHolder, remove viewParent result=" + onCreateViewHolder.itemView.getParent());
            }
            return onCreateViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) holder);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewAttachedToWindow(holder);
            if (!(holder instanceof C7200c)) {
                this.wrappedAdapter.onViewAttachedToWindow(holder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) holder);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewDetachedFromWindow(holder);
            if (!(holder instanceof C7200c)) {
                this.wrappedAdapter.onViewDetachedFromWindow(holder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(@NotNull RecyclerView.ViewHolder holder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) holder);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewRecycled(holder);
            if (!(holder instanceof C7200c)) {
                this.wrappedAdapter.onViewRecycled(holder);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter$c$a", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "", "positionStart", "itemCount", "onItemRangeChanged", "", "payload", "onItemRangeInserted", "onItemRangeRemoved", "fromPosition", "toPosition", "onItemRangeMoved", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes10.dex */
        public static final class a extends RecyclerView.AdapterDataObserver {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            @SuppressLint({"NotifyDataSetChanged"})
            public void onChanged() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    c.this.notifyDataSetChanged();
                } catch (Exception e16) {
                    QLog.e("NTChatRecyclerViewWithHeaderFooter", 1, e16.getMessage(), e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int positionStart, int itemCount) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                    return;
                }
                try {
                    c cVar = c.this;
                    cVar.notifyItemRangeChanged(positionStart + cVar.mHeaders.size(), itemCount);
                } catch (Exception e16) {
                    QLog.e("NTChatRecyclerViewWithHeaderFooter", 1, e16.getMessage(), e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                    return;
                }
                try {
                    c cVar = c.this;
                    cVar.notifyItemRangeInserted(positionStart + cVar.mHeaders.size(), itemCount);
                } catch (Exception e16) {
                    QLog.e("NTChatRecyclerViewWithHeaderFooter", 1, e16.getMessage(), e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition), Integer.valueOf(itemCount));
                    return;
                }
                try {
                    c cVar = c.this;
                    cVar.notifyItemMoved(fromPosition + cVar.mHeaders.size(), toPosition + c.this.mHeaders.size());
                } catch (Exception e16) {
                    QLog.e("NTChatRecyclerViewWithHeaderFooter", 1, e16.getMessage(), e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                    return;
                }
                try {
                    c cVar = c.this;
                    cVar.notifyItemRangeRemoved(positionStart + cVar.mHeaders.size(), itemCount);
                } catch (Exception e16) {
                    QLog.e("NTChatRecyclerViewWithHeaderFooter", 1, e16.getMessage(), e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount), payload);
                    return;
                }
                try {
                    c cVar = c.this;
                    cVar.notifyItemRangeChanged(positionStart + cVar.mHeaders.size(), itemCount, payload);
                } catch (Exception e16) {
                    QLog.e("NTChatRecyclerViewWithHeaderFooter", 1, e16.getMessage(), e16);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
            StaggeredGridLayoutManager.LayoutParams layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) viewHolder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (position >= this.mHeaders.size() && position < this.mHeaders.size() + this.wrappedAdapter.getNUM_BACKGOURND_ICON()) {
                this.wrappedAdapter.onBindViewHolder(viewHolder, position - this.mHeaders.size());
                return;
            }
            if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams())) {
                ViewGroup.LayoutParams layoutParams2 = viewHolder.itemView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                viewHolder.itemView.setLayoutParams(layoutParams);
            }
            layoutParams.setFullSpan(true);
        }

        private final void l0(View view) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTChatRecyclerViewWithHeaderFooter(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attrs);
        } else {
            this.mHeaders = new ArrayList();
            this.mFooters = new ArrayList();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTChatRecyclerViewWithHeaderFooter(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attrs, Integer.valueOf(i3));
        } else {
            this.mHeaders = new ArrayList();
            this.mFooters = new ArrayList();
        }
    }
}
