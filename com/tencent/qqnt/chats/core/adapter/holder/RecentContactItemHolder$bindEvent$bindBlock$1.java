package com.tencent.qqnt.chats.core.adapter.holder;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class RecentContactItemHolder$bindEvent$bindBlock$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.g $item;
    final /* synthetic */ int $position;
    final /* synthetic */ RecentContactItemHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentContactItemHolder$bindEvent$bindBlock$1(RecentContactItemHolder recentContactItemHolder, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        super(0);
        this.this$0 = recentContactItemHolder;
        this.$position = i3;
        this.$item = gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, recentContactItemHolder, Integer.valueOf(i3), gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RecentContactItemHolder this$0, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        com.tencent.qqnt.chats.core.adapter.h hVar = this$0.listener;
        if (hVar != null) {
            hVar.a(i3, item, this$0.y());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(RecentContactItemHolder this$0, com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        com.tencent.qqnt.chats.core.adapter.h hVar = this$0.listener;
        if (hVar != null) {
            hVar.a(this$0.getAdapterPosition(), item, this$0.y());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(RecentContactItemHolder this$0, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        com.tencent.qqnt.chats.core.adapter.h hVar = this$0.listener;
        if (hVar != null) {
            return hVar.b(i3, item, this$0.y());
        }
        return false;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        RelativeLayout b16 = this.this$0.y().b();
        final RecentContactItemHolder recentContactItemHolder = this.this$0;
        final int i3 = this.$position;
        final com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = this.$item;
        b16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.adapter.holder.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecentContactItemHolder$bindEvent$bindBlock$1.d(RecentContactItemHolder.this, i3, gVar, view);
            }
        });
        View avatarLayout = this.this$0.y().a().getAvatarLayout();
        final RecentContactItemHolder recentContactItemHolder2 = this.this$0;
        final com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 = this.$item;
        avatarLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.adapter.holder.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecentContactItemHolder$bindEvent$bindBlock$1.e(RecentContactItemHolder.this, gVar2, view);
            }
        });
        RelativeLayout b17 = this.this$0.y().b();
        final RecentContactItemHolder recentContactItemHolder3 = this.this$0;
        final int i16 = this.$position;
        final com.tencent.qqnt.chats.core.adapter.itemdata.g gVar3 = this.$item;
        b17.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qqnt.chats.core.adapter.holder.n
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean f16;
                f16 = RecentContactItemHolder$bindEvent$bindBlock$1.f(RecentContactItemHolder.this, i16, gVar3, view);
                return f16;
            }
        });
    }
}
