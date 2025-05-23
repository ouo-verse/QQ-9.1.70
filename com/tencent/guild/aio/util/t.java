package com.tencent.guild.aio.util;

import android.view.View;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a=\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0014\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001\u00a2\u0006\u0004\b\t\u0010\n\u001a=\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0014\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001\u00a2\u0006\u0004\b\u000b\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/config/d;", "P", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "VB", "provider", "vb", "", tl.h.F, "(Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/aio/api/list/a;)V", "e", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class t {
    public static final <P extends com.tencent.guild.aio.msglist.holder.config.d, VB extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>> void e(@NotNull P provider, @NotNull final VB vb5) {
        View containerView;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        vb5.getHostView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guild.aio.util.r
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean f16;
                f16 = t.f(com.tencent.aio.api.list.a.this, view);
                return f16;
            }
        });
        com.tencent.guild.aio.msglist.holder.component.a aVar = provider.get().get(3);
        if (aVar != null && (containerView = aVar.getContainerView()) != null) {
            containerView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guild.aio.util.s
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean g16;
                    g16 = t.g(com.tencent.aio.api.list.a.this, view);
                    return g16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(com.tencent.aio.api.list.a vb5, View view) {
        Intrinsics.checkNotNullParameter(vb5, "$vb");
        QLog.i("MsgBubblePressHandler", 4, "msg item long press");
        vb5.sendIntent(new a.d(vb5.getHostView()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(com.tencent.aio.api.list.a vb5, View it) {
        Intrinsics.checkNotNullParameter(vb5, "$vb");
        QLog.i("MsgBubblePressHandler", 4, "msg bubble long press");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        vb5.sendIntent(new a.d(it));
        return true;
    }

    public static final <P extends com.tencent.guild.aio.msglist.holder.config.d, VB extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>> void h(@NotNull P provider, @NotNull final VB vb5) {
        View d16;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        com.tencent.guild.aio.msglist.holder.component.a aVar = provider.get().get(3);
        if (aVar != null && (d16 = aVar.d1()) != null) {
            d16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.util.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.i(com.tencent.aio.api.list.a.this, view);
                }
            });
        }
        vb5.getHostView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.util.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.j(com.tencent.aio.api.list.a.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(com.tencent.aio.api.list.a vb5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(vb5, "$vb");
        QLog.i("MsgBubblePressHandler", 4, "msg item bubble click");
        vb5.sendIntent(new a.c(view));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(com.tencent.aio.api.list.a vb5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(vb5, "$vb");
        vb5.sendIntent(a.b.f110459d);
        EventCollector.getInstance().onViewClicked(view);
    }
}
