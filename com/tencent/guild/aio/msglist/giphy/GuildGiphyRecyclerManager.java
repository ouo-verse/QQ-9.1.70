package com.tencent.guild.aio.msglist.giphy;

import com.giphy.sdk.ui.views.GPHMediaView;
import com.tencent.guild.aio.msglist.giphy.util.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/msglist/giphy/GuildGiphyRecyclerManager;", "", "Lcom/tencent/guild/aio/msglist/giphy/util/c;", "Lcom/giphy/sdk/ui/views/GPHMediaView;", "b", "Lkotlin/Lazy;", "a", "()Lcom/tencent/guild/aio/msglist/giphy/util/c;", "imgRecycler", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiphyRecyclerManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildGiphyRecyclerManager f111293a = new GuildGiphyRecyclerManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy imgRecycler;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c<GPHMediaView>>() { // from class: com.tencent.guild.aio.msglist.giphy.GuildGiphyRecyclerManager$imgRecycler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c<GPHMediaView> invoke() {
                return new c<>(GPHMediaView.class);
            }
        });
        imgRecycler = lazy;
    }

    GuildGiphyRecyclerManager() {
    }

    @NotNull
    public final c<GPHMediaView> a() {
        return (c) imgRecycler.getValue();
    }
}
