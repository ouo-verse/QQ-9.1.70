package com.tencent.guild.aio.article.msglist.holder.provider;

import android.util.SparseArray;
import android.view.View;
import com.tencent.guild.aio.article.msglist.holder.GuildArticleReplyComponent;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarComponent;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleCheckBoxComponent;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleContentComponent;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleMsgStatusComponent;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleTailComponent;
import com.tencent.guild.aio.msglist.holder.component.a;
import com.tencent.guild.aio.msglist.holder.component.newmsgline.GuildBubbleNewMsgLineComponent;
import com.tencent.guild.aio.msglist.holder.component.nick.c;
import com.tencent.guild.aio.msglist.holder.config.d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u00ff\u0001\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000eR%\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000eR%\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000eR%\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0010\u0010\u000eR%\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0018\u0010\u000eR%\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000eR%\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001d\u0010\u000eR%\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u0016\u0010\u000eR%\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0013\u0010\u000eR%\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u001a\u0010\u000eR#\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b\f\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/holder/provider/GuildArticleMsgItemComponentProvider;", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "get", "Landroid/view/View;", "a", "Landroid/view/View;", "i", "()Landroid/view/View;", "root", "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "avatarComponentGetter", "c", "f", "nickComponentGetter", "d", "k", "statusComponentGetter", "e", "contentComponentGetter", "l", "tailComponentGetter", "g", "j", "selectComponentGetter", h.F, "replyComponentGetter", "newMsgLineComponentGetter", "msgReactionComponentGetter", "replyAndContentContainerGetter", "Lkotlin/Lazy;", "()Landroid/util/SparseArray;", "componentList", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleMsgItemComponentProvider implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> avatarComponentGetter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> nickComponentGetter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> statusComponentGetter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> contentComponentGetter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> tailComponentGetter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> selectComponentGetter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> replyComponentGetter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> newMsgLineComponentGetter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> msgReactionComponentGetter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, a> replyAndContentContainerGetter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy componentList;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildArticleMsgItemComponentProvider(@NotNull View root, @NotNull Function1<? super View, ? extends a> avatarComponentGetter, @NotNull Function1<? super View, ? extends a> nickComponentGetter, @NotNull Function1<? super View, ? extends a> statusComponentGetter, @NotNull Function1<? super View, ? extends a> contentComponentGetter, @NotNull Function1<? super View, ? extends a> tailComponentGetter, @NotNull Function1<? super View, ? extends a> selectComponentGetter, @NotNull Function1<? super View, ? extends a> replyComponentGetter, @NotNull Function1<? super View, ? extends a> newMsgLineComponentGetter, @NotNull Function1<? super View, ? extends a> msgReactionComponentGetter, @NotNull Function1<? super View, ? extends a> replyAndContentContainerGetter) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(avatarComponentGetter, "avatarComponentGetter");
        Intrinsics.checkNotNullParameter(nickComponentGetter, "nickComponentGetter");
        Intrinsics.checkNotNullParameter(statusComponentGetter, "statusComponentGetter");
        Intrinsics.checkNotNullParameter(contentComponentGetter, "contentComponentGetter");
        Intrinsics.checkNotNullParameter(tailComponentGetter, "tailComponentGetter");
        Intrinsics.checkNotNullParameter(selectComponentGetter, "selectComponentGetter");
        Intrinsics.checkNotNullParameter(replyComponentGetter, "replyComponentGetter");
        Intrinsics.checkNotNullParameter(newMsgLineComponentGetter, "newMsgLineComponentGetter");
        Intrinsics.checkNotNullParameter(msgReactionComponentGetter, "msgReactionComponentGetter");
        Intrinsics.checkNotNullParameter(replyAndContentContainerGetter, "replyAndContentContainerGetter");
        this.root = root;
        this.avatarComponentGetter = avatarComponentGetter;
        this.nickComponentGetter = nickComponentGetter;
        this.statusComponentGetter = statusComponentGetter;
        this.contentComponentGetter = contentComponentGetter;
        this.tailComponentGetter = tailComponentGetter;
        this.selectComponentGetter = selectComponentGetter;
        this.replyComponentGetter = replyComponentGetter;
        this.newMsgLineComponentGetter = newMsgLineComponentGetter;
        this.msgReactionComponentGetter = msgReactionComponentGetter;
        this.replyAndContentContainerGetter = replyAndContentContainerGetter;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<a>>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider$componentList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<a> invoke() {
                SparseArray<a> sparseArray = new SparseArray<>();
                GuildArticleMsgItemComponentProvider guildArticleMsgItemComponentProvider = GuildArticleMsgItemComponentProvider.this;
                sparseArray.put(0, guildArticleMsgItemComponentProvider.a().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(1, guildArticleMsgItemComponentProvider.f().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(2, guildArticleMsgItemComponentProvider.k().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(3, guildArticleMsgItemComponentProvider.c().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(4, guildArticleMsgItemComponentProvider.l().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(6, guildArticleMsgItemComponentProvider.j().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(8, guildArticleMsgItemComponentProvider.h().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(7, guildArticleMsgItemComponentProvider.e().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(5, guildArticleMsgItemComponentProvider.d().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                sparseArray.put(9, guildArticleMsgItemComponentProvider.g().invoke(guildArticleMsgItemComponentProvider.getRoot()));
                return sparseArray;
            }
        });
        this.componentList = lazy;
    }

    private final SparseArray<a> b() {
        return (SparseArray) this.componentList.getValue();
    }

    @NotNull
    public final Function1<View, a> a() {
        return this.avatarComponentGetter;
    }

    @NotNull
    public final Function1<View, a> c() {
        return this.contentComponentGetter;
    }

    @NotNull
    public final Function1<View, a> d() {
        return this.msgReactionComponentGetter;
    }

    @NotNull
    public final Function1<View, a> e() {
        return this.newMsgLineComponentGetter;
    }

    @NotNull
    public final Function1<View, a> f() {
        return this.nickComponentGetter;
    }

    @NotNull
    public final Function1<View, a> g() {
        return this.replyAndContentContainerGetter;
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.d
    @NotNull
    public SparseArray<a> get() {
        return b();
    }

    @NotNull
    public final Function1<View, a> h() {
        return this.replyComponentGetter;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final View getRoot() {
        return this.root;
    }

    @NotNull
    public final Function1<View, a> j() {
        return this.selectComponentGetter;
    }

    @NotNull
    public final Function1<View, a> k() {
        return this.statusComponentGetter;
    }

    @NotNull
    public final Function1<View, a> l() {
        return this.tailComponentGetter;
    }

    public /* synthetic */ GuildArticleMsgItemComponentProvider(final View view, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i3 & 2) != 0 ? new Function1<View, GuildBubbleAvatarComponent>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildBubbleAvatarComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildBubbleAvatarComponent(view);
            }
        } : function1, (i3 & 4) != 0 ? new Function1<View, c>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final c invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new c(view);
            }
        } : function12, (i3 & 8) != 0 ? new Function1<View, GuildBubbleMsgStatusComponent>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildBubbleMsgStatusComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildBubbleMsgStatusComponent(view);
            }
        } : function13, (i3 & 16) != 0 ? new Function1<View, GuildBubbleContentComponent>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildBubbleContentComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildBubbleContentComponent(view);
            }
        } : function14, (i3 & 32) != 0 ? new Function1<View, GuildBubbleTailComponent>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildBubbleTailComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildBubbleTailComponent(view);
            }
        } : function15, (i3 & 64) != 0 ? new Function1<View, GuildBubbleCheckBoxComponent>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildBubbleCheckBoxComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildBubbleCheckBoxComponent(view);
            }
        } : function16, (i3 & 128) != 0 ? new Function1<View, GuildArticleReplyComponent>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildArticleReplyComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildArticleReplyComponent(view);
            }
        } : function17, (i3 & 256) != 0 ? new Function1<View, GuildBubbleNewMsgLineComponent>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildBubbleNewMsgLineComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildBubbleNewMsgLineComponent(view);
            }
        } : function18, (i3 & 512) != 0 ? new Function1<View, com.tencent.guild.aio.article.msglist.holder.component.a>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.article.msglist.holder.component.a invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.component.a(view);
            }
        } : function19, (i3 & 1024) != 0 ? new Function1<View, hq0.a>() { // from class: com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final hq0.a invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new hq0.a(view);
            }
        } : function110);
    }
}
