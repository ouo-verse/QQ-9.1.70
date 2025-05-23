package com.tencent.guildlive.aio.msglist.holder;

import android.util.SparseArray;
import android.view.View;
import com.tencent.guild.aio.msglist.holder.config.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u001a\u0010\u0010R0\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\"\u0010\u0010R#\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010$\u001a\u0004\b\f\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/GuildLiveMsgItemComponentProvider;", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "get", "Landroid/view/View;", "a", "Landroid/view/View;", "f", "()Landroid/view/View;", "root", "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "j", "(Lkotlin/jvm/functions/Function1;)V", "avatarComponentGetter", "c", "d", "l", "nickComponentGetter", h.F, "o", "statusComponentGetter", "e", "k", "contentComponentGetter", "i", "p", "tailComponentGetter", "g", DomainData.DOMAIN_NAME, "selectComponentGetter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "replyComponentGetter", "Lkotlin/Lazy;", "()Landroid/util/SparseArray;", "componentList", "<init>", "(Landroid/view/View;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveMsgItemComponentProvider implements d {

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
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> statusComponentGetter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> contentComponentGetter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> tailComponentGetter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> selectComponentGetter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> replyComponentGetter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy componentList;

    public GuildLiveMsgItemComponentProvider(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.avatarComponentGetter = new Function1() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$avatarComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.nickComponentGetter = new Function1() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$nickComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.statusComponentGetter = new Function1() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$statusComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.contentComponentGetter = new Function1() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$contentComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.tailComponentGetter = new Function1() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$tailComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.selectComponentGetter = new Function1() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$selectComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        this.replyComponentGetter = new Function1() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$replyComponentGetter$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<com.tencent.guild.aio.msglist.holder.component.a>>() { // from class: com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider$componentList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<com.tencent.guild.aio.msglist.holder.component.a> invoke() {
                SparseArray<com.tencent.guild.aio.msglist.holder.component.a> sparseArray = new SparseArray<>();
                GuildLiveMsgItemComponentProvider guildLiveMsgItemComponentProvider = GuildLiveMsgItemComponentProvider.this;
                sparseArray.put(0, guildLiveMsgItemComponentProvider.a().invoke(guildLiveMsgItemComponentProvider.getRoot()));
                sparseArray.put(1, guildLiveMsgItemComponentProvider.d().invoke(guildLiveMsgItemComponentProvider.getRoot()));
                sparseArray.put(2, guildLiveMsgItemComponentProvider.h().invoke(guildLiveMsgItemComponentProvider.getRoot()));
                sparseArray.put(3, guildLiveMsgItemComponentProvider.c().invoke(guildLiveMsgItemComponentProvider.getRoot()));
                sparseArray.put(4, guildLiveMsgItemComponentProvider.i().invoke(guildLiveMsgItemComponentProvider.getRoot()));
                sparseArray.put(6, guildLiveMsgItemComponentProvider.g().invoke(guildLiveMsgItemComponentProvider.getRoot()));
                sparseArray.put(8, guildLiveMsgItemComponentProvider.e().invoke(guildLiveMsgItemComponentProvider.getRoot()));
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
        return this.selectComponentGetter;
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.d
    @NotNull
    public SparseArray<com.tencent.guild.aio.msglist.holder.component.a> get() {
        return b();
    }

    @NotNull
    public final Function1<View, com.tencent.guild.aio.msglist.holder.component.a> h() {
        return this.statusComponentGetter;
    }

    @NotNull
    public final Function1<View, com.tencent.guild.aio.msglist.holder.component.a> i() {
        return this.tailComponentGetter;
    }

    public final void j(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.avatarComponentGetter = function1;
    }

    public final void k(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.contentComponentGetter = function1;
    }

    public final void l(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.nickComponentGetter = function1;
    }

    public final void m(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.replyComponentGetter = function1;
    }

    public final void n(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.selectComponentGetter = function1;
    }

    public final void o(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.statusComponentGetter = function1;
    }

    public final void p(@NotNull Function1<? super View, ? extends com.tencent.guild.aio.msglist.holder.component.a> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.tailComponentGetter = function1;
    }
}
