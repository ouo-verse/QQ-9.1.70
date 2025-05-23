package com.tencent.guild.aio.component.combinestyle;

import android.util.SparseArray;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0016\u0010\u0010R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u001c\u0010\u0010R#\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\f\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/GuildMediaCombineStyleMsgItemComponentProvider;", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "get", "Landroid/view/View;", "a", "Landroid/view/View;", "f", "()Landroid/view/View;", "root", "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", tl.h.F, "(Lkotlin/jvm/functions/Function1;)V", "avatarComponentGetter", "c", "d", "j", "nickComponentGetter", "i", "contentComponentGetter", "e", "g", "l", "statusComponentGetter", "k", "replyComponentGetter", "Lkotlin/Lazy;", "()Landroid/util/SparseArray;", "componentList", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMediaCombineStyleMsgItemComponentProvider implements com.tencent.guild.aio.msglist.holder.config.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> avatarComponentGetter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> nickComponentGetter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> contentComponentGetter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> statusComponentGetter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> replyComponentGetter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy componentList;

    public GuildMediaCombineStyleMsgItemComponentProvider(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.avatarComponentGetter = new Function1() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleMsgItemComponentProvider$avatarComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.nickComponentGetter = new Function1() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleMsgItemComponentProvider$nickComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.contentComponentGetter = new Function1() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleMsgItemComponentProvider$contentComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.statusComponentGetter = new Function1() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleMsgItemComponentProvider$statusComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.replyComponentGetter = new Function1() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleMsgItemComponentProvider$replyComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<com.tencent.guild.aio.msglist.holder.component.a>>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleMsgItemComponentProvider$componentList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<com.tencent.guild.aio.msglist.holder.component.a> invoke() {
                SparseArray<com.tencent.guild.aio.msglist.holder.component.a> sparseArray = new SparseArray<>();
                GuildMediaCombineStyleMsgItemComponentProvider guildMediaCombineStyleMsgItemComponentProvider = GuildMediaCombineStyleMsgItemComponentProvider.this;
                sparseArray.put(0, guildMediaCombineStyleMsgItemComponentProvider.a().invoke(guildMediaCombineStyleMsgItemComponentProvider.getRoot()));
                sparseArray.put(1, guildMediaCombineStyleMsgItemComponentProvider.d().invoke(guildMediaCombineStyleMsgItemComponentProvider.getRoot()));
                sparseArray.put(3, guildMediaCombineStyleMsgItemComponentProvider.c().invoke(guildMediaCombineStyleMsgItemComponentProvider.getRoot()));
                sparseArray.put(8, guildMediaCombineStyleMsgItemComponentProvider.e().invoke(guildMediaCombineStyleMsgItemComponentProvider.getRoot()));
                sparseArray.put(2, guildMediaCombineStyleMsgItemComponentProvider.g().invoke(guildMediaCombineStyleMsgItemComponentProvider.getRoot()));
                return sparseArray;
            }
        });
        this.componentList = lazy;
    }

    private final SparseArray<com.tencent.guild.aio.msglist.holder.component.a> b() {
        return (SparseArray) this.componentList.getValue();
    }

    @NotNull
    public final Function1<View, com.tencent.guild.aio.msglist.holder.component.a> a() {
        return this.avatarComponentGetter;
    }

    @NotNull
    public final Function1<View, com.tencent.guild.aio.msglist.holder.component.a> c() {
        return this.contentComponentGetter;
    }

    @NotNull
    public final Function1<View, com.tencent.guild.aio.msglist.holder.component.a> d() {
        return this.nickComponentGetter;
    }

    @NotNull
    public final Function1<View, com.tencent.guild.aio.msglist.holder.component.a> e() {
        return this.replyComponentGetter;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final View getRoot() {
        return this.root;
    }

    @NotNull
    public final Function1<View, com.tencent.guild.aio.msglist.holder.component.a> g() {
        return this.statusComponentGetter;
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.d
    @NotNull
    public SparseArray<com.tencent.guild.aio.msglist.holder.component.a> get() {
        return b();
    }

    public final void h(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.avatarComponentGetter = function1;
    }

    public final void i(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.contentComponentGetter = function1;
    }

    public final void j(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.nickComponentGetter = function1;
    }

    public final void k(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.replyComponentGetter = function1;
    }

    public final void l(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.statusComponentGetter = function1;
    }
}
