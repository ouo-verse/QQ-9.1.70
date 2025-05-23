package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/h;", "", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragHost", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "lightInterActionView", "Landroid/view/View;", "a", "view", "", "b", "e", "d", "c", "Landroid/content/Context;", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext", "Landroid/view/View;", "mContentView", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "Lcom/tencent/qqnt/chats/core/mvi/a;", "mChatsVM", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l;", "mChatsVB", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View mContentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private l mChatsVB;

    public h(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    public final void b(View view, QUIBadgeDragLayout dragHost, LIAAnimView lightInterActionView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        this.mContentView = view;
        QRouteApi api = QRoute.api(IChatsViewModelCreator.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IChatsViewModelCreator::class.java)");
        IChatsViewModelCreator iChatsViewModelCreator = (IChatsViewModelCreator) api;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        this.mChatsVM = (com.tencent.qqnt.chats.core.mvi.a) IChatsViewModelCreator.a.b(iChatsViewModelCreator, LifecycleOwnerKt.getLifecycleScope((QBaseActivity) context), this.mContext, new f(), null, 8, null);
        a(dragHost, lightInterActionView);
    }

    public final void c() {
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        l lVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.d.f355084a);
        l lVar2 = this.mChatsVB;
        if (lVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            lVar = lVar2;
        }
        lVar.e0();
    }

    public final void d() {
        l lVar = this.mChatsVB;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            lVar = null;
        }
        lVar.f0();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar = aVar2;
        }
        aVar.o(b.h.f355088a);
    }

    public final void e() {
        l lVar = this.mChatsVB;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            lVar = null;
        }
        lVar.onResume();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar = aVar2;
        }
        aVar.o(b.i.f355089a);
    }

    private final View a(QUIBadgeDragLayout dragHost, LIAAnimView lightInterActionView) {
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar;
        View view = this.mContentView;
        l lVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.ojp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.drag_area)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        } else {
            aVar = aVar2;
        }
        l lVar2 = new l(aVar, new QQStrangerChatListBuilder(), true, false, 8, null);
        this.mChatsVB = lVar2;
        View view2 = this.mContentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.oj9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.chats_list)");
        lVar2.d0(new ChatsListVB.b((RecyclerView) findViewById2, dragHost, null, this.mContext, null, null, lightInterActionView, null, 176, null));
        l lVar3 = this.mChatsVB;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            lVar3 = null;
        }
        View view3 = new View(this.mContext);
        view3.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        Unit unit = Unit.INSTANCE;
        lVar3.p0(-1, view3);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar3 = null;
        }
        l lVar4 = this.mChatsVB;
        if (lVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            lVar4 = null;
        }
        aVar3.d(lVar4);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar4 = this.mChatsVM;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar4 = null;
        }
        aVar4.o(b.c.f355083a);
        l lVar5 = this.mChatsVB;
        if (lVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            lVar = lVar5;
        }
        com.tencent.qqnt.chats.api.b v3 = lVar.v();
        if (v3 != null) {
            b.C9561b.a(v3, viewGroup, null, null, null, 14, null);
        }
        return viewGroup;
    }
}
