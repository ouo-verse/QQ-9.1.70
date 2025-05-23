package com.tencent.qqnt.base.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0003\u0006\t\rB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/base/utils/b;", "", "Lcom/tencent/qqnt/base/utils/b$b;", "listener", "f", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "b", "Lcom/tencent/qqnt/base/utils/b$b;", "mOnItemClickListener", "Landroid/view/View$OnClickListener;", "c", "Landroid/view/View$OnClickListener;", "mOnClickListener", "Landroid/view/View$OnLongClickListener;", "d", "Landroid/view/View$OnLongClickListener;", "mOnLongClickListener", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "e", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "mAttachListener", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mRecyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC9516b mOnItemClickListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener mOnClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLongClickListener mOnLongClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView.OnChildAttachStateChangeListener mAttachListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/base/utils/b$a;", "", "Landroidx/recyclerview/widget/RecyclerView;", "view", "Lcom/tencent/qqnt/base/utils/b;", "a", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.base.utils.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final b a(@NotNull RecyclerView view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Object tag = view.getTag(R.id.f71913pf);
            if (!(tag instanceof b)) {
                tag = new b(view);
            }
            return (b) tag;
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/base/utils/b$b;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "position", "Landroid/view/View;", "v", "", "a", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.base.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC9516b {
        void a(@Nullable RecyclerView recyclerView, int position, @Nullable View v3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/base/utils/b$c;", "", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/base/utils/b$d", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onChildViewAttachedToWindow", "onChildViewDetachedFromWindow", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements RecyclerView.OnChildAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            if (b.this.mOnItemClickListener != null) {
                view.setOnClickListener(b.this.mOnClickListener);
            }
            b.d(b.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/base/utils/b$e", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_LONG_CLICK, "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class e implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@Nullable View v3) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3)).booleanValue();
            } else {
                b.d(b.this);
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(v3);
            return z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41055);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull RecyclerView mRecyclerView) {
        Intrinsics.checkNotNullParameter(mRecyclerView, "mRecyclerView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mRecyclerView);
            return;
        }
        this.mRecyclerView = mRecyclerView;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.base.utils.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.e(b.this, view);
            }
        };
        this.mOnLongClickListener = new e();
        d dVar = new d();
        this.mAttachListener = dVar;
        mRecyclerView.setTag(R.id.f71913pf, this);
        mRecyclerView.addOnChildAttachStateChangeListener(dVar);
    }

    public static final /* synthetic */ c d(b bVar) {
        bVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mOnItemClickListener != null) {
            RecyclerView.ViewHolder childViewHolder = this$0.mRecyclerView.getChildViewHolder(view);
            Intrinsics.checkNotNullExpressionValue(childViewHolder, "mRecyclerView.getChildViewHolder(view)");
            InterfaceC9516b interfaceC9516b = this$0.mOnItemClickListener;
            Intrinsics.checkNotNull(interfaceC9516b);
            interfaceC9516b.a(this$0.mRecyclerView, childViewHolder.getAdapterPosition(), view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final b f(@Nullable InterfaceC9516b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        }
        this.mOnItemClickListener = listener;
        return this;
    }
}
