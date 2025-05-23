package com.tencent.qqnt.chats.core.ui.highlight;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.chats.core.adapter.ChatsListAdapter;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.utils.f;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001+\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010#\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR.\u0010*\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010&\u001a\u0004\b\u0017\u0010'\"\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;", "", "Landroid/view/View;", "view", "", "i", "", "j", "f", "g", h.F, "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "b", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "()Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "adapter", "", "c", "I", "d", "()I", "l", "(I)V", "curPos", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curPosOffset", "getHighLightType", DomainData.DOMAIN_NAME, "highLightType", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "value", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "k", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "curItem", "com/tencent/qqnt/chats/core/ui/highlight/HighLightManager$listener$1", "Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager$listener$1;", "listener", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class HighLightManager {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatsListAdapter adapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int curPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curPosOffset;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int highLightType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecentContactInfo curItem;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HighLightManager$listener$1 listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager$a;", "", "", "TYPE_SCROLL_ITEM", "I", "TYPE_SCROLL_NONE", "TYPE_SCROLL_POS", "TYPE_SCROLL_TOP", "TYPE_SCROLL_UNREAD", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.ui.highlight.HighLightManager$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47469);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.qqnt.chats.core.ui.highlight.HighLightManager$listener$1, androidx.recyclerview.widget.RecyclerView$OnScrollListener] */
    public HighLightManager(@NotNull RecyclerView recyclerView, @NotNull ChatsListAdapter adapter) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) adapter);
            return;
        }
        this.recyclerView = recyclerView;
        this.adapter = adapter;
        this.curPos = -1;
        ?? r56 = new RecyclerView.OnScrollListener() { // from class: com.tencent.qqnt.chats.core.ui.highlight.HighLightManager$listener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HighLightManager.this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int newState) {
                final RecentContactInfo c16;
                RecyclerView.ViewHolder findViewHolderForAdapterPosition;
                boolean i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView2, newState);
                    return;
                }
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, newState);
                if (newState != 0 || (c16 = HighLightManager.this.c()) == null || (findViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(HighLightManager.this.b().u0(new Function1<g, Boolean>() { // from class: com.tencent.qqnt.chats.core.ui.highlight.HighLightManager$listener$1$onScrollStateChanged$vh$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RecentContactInfo.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull g it) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (Boolean) iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it);
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(f.f355547a.a(it, RecentContactInfo.this));
                    }
                }))) == null) {
                    return;
                }
                HighLightManager highLightManager = HighLightManager.this;
                View view = findViewHolderForAdapterPosition.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
                i3 = highLightManager.i(view);
                if (i3 && (findViewHolderForAdapterPosition instanceof com.tencent.qqnt.chats.core.adapter.holder.b)) {
                    if (!HighLightManager.this.h()) {
                        ((com.tencent.qqnt.chats.core.adapter.holder.b) findViewHolderForAdapterPosition).o();
                    }
                    HighLightManager.this.j();
                }
            }
        };
        this.listener = r56;
        recyclerView.addOnScrollListener(r56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(View view) {
        boolean z16;
        boolean z17;
        int i3 = view.getResources().getDisplayMetrics().heightPixels;
        int y16 = (int) view.getY();
        if (y16 >= 0 && y16 <= i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        int y17 = ((int) view.getY()) + view.getHeight();
        if (y17 >= 0 && y17 <= i3) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ChatsListAdapter b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ChatsListAdapter) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.adapter;
    }

    @Nullable
    public final RecentContactInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RecentContactInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.curItem;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.curPos;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.curPosOffset;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.highLightType == 3) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.highLightType == 1) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.highLightType == 2) {
            return true;
        }
        return false;
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            k(null);
            this.highLightType = 0;
        }
    }

    public final void k(@Nullable final RecentContactInfo recentContactInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) recentContactInfo);
            return;
        }
        if (recentContactInfo == null) {
            this.curItem = null;
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(this.adapter.u0(new Function1<g, Boolean>() { // from class: com.tencent.qqnt.chats.core.ui.highlight.HighLightManager$curItem$vh$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactInfo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull g it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(f.f355547a.a(it, RecentContactInfo.this));
            }
        }));
        if (findViewHolderForAdapterPosition != null) {
            View view = findViewHolderForAdapterPosition.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
            if (i(view) && (findViewHolderForAdapterPosition instanceof com.tencent.qqnt.chats.core.adapter.holder.b)) {
                if (!h()) {
                    ((com.tencent.qqnt.chats.core.adapter.holder.b) findViewHolderForAdapterPosition).o();
                }
                recentContactInfo = null;
            }
        }
        this.curItem = recentContactInfo;
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.curPos = i3;
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.curPosOffset = i3;
        }
    }

    public final void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.highLightType = i3;
        }
    }
}
