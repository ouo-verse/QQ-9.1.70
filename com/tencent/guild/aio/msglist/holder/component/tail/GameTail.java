package com.tencent.guild.aio.msglist.holder.component.tail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/tail/GameTail;", "Lcom/tencent/guild/aio/msglist/holder/component/tail/a;", "Lcom/tencent/aio/data/msglist/a;", "", "i", "", "d", "msg", "", "b", "Landroid/widget/LinearLayout;", "j", "", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lkotlin/Lazy;", "g", "()Landroid/widget/LinearLayout;", "mGameTailLayout", "Landroid/widget/TextView;", h.F, "()Landroid/widget/TextView;", "mGameTailTextView", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GameTail implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGameTailLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGameTailTextView;

    public GameTail(@NotNull Context mContext) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.GameTail$mGameTailLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                Context context;
                context = GameTail.this.mContext;
                View inflate = LayoutInflater.from(context).inflate(R.layout.eeh, (ViewGroup) null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                return (LinearLayout) inflate;
            }
        });
        this.mGameTailLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.GameTail$mGameTailTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                LinearLayout g16;
                g16 = GameTail.this.g();
                View findViewById = g16.findViewById(R.id.f165327vk0);
                Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                return (TextView) findViewById;
            }
        });
        this.mGameTailTextView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout g() {
        return (LinearLayout) this.mGameTailLayout.getValue();
    }

    private final TextView h() {
        return (TextView) this.mGameTailTextView.getValue();
    }

    private final String i(com.tencent.aio.data.msglist.a aVar) {
        if (!(aVar instanceof GuildMsgItem)) {
            return "";
        }
        nt_im_msg_general_flags_body$ResvAttr f16 = com.tencent.guild.api.data.msglist.a.f((GuildMsgItem) aVar);
        if (!f16.game_meta_data.has()) {
            return "";
        }
        String str = f16.game_meta_data.get().data_from.get();
        Intrinsics.checkNotNullExpressionValue(str, "metaData.data_from.get()");
        return str;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public boolean b(@NotNull com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (i(msg2).length() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public void c(@NotNull com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        h().setText(i(msg2));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public int d() {
        return 1;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public LinearLayout a() {
        return g();
    }
}
