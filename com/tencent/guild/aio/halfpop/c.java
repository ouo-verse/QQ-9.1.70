package com.tencent.guild.aio.halfpop;

import com.tencent.guild.aio.halfpop.menu.EmotionMenuItem;
import com.tencent.guild.aio.halfpop.menu.SaveToEmojiMenuItem;
import com.tencent.guild.aio.halfpop.menu.SetChosenActionItem;
import com.tencent.guild.aio.halfpop.menu.aa;
import com.tencent.guild.aio.halfpop.menu.d;
import com.tencent.guild.aio.halfpop.menu.g;
import com.tencent.guild.aio.halfpop.menu.j;
import com.tencent.guild.aio.halfpop.menu.l;
import com.tencent.guild.aio.halfpop.menu.m;
import com.tencent.guild.aio.halfpop.menu.o;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.aio.halfpop.menu.u;
import com.tencent.guild.aio.halfpop.menu.v;
import com.tencent.guild.aio.halfpop.menu.w;
import com.tencent.guild.aio.halfpop.menu.x;
import com.tencent.guild.aio.halfpop.menu.z;
import com.tencent.guild.aio.reserve2.busi.chosen.menu.RemoveChosenMsgItem;
import com.tencent.guild.aio.reserve2.busi.chosen.menu.f;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import do0.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R+\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR+\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\u0006\u0010\tR-\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\tR+\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000b\u0010\tR-\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0007\u001a\u0004\b\r\u0010\tR-\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0012\u0010\tR%\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/halfpop/c;", "", "", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/halfpop/menu/b;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "b", "Ljava/util/List;", "f", "()Ljava/util/List;", "MENUS_FOR_LONG_PRESS_MSG", "c", "MENUS_CHOSEN_FOR_LONG_PRESS_MSG", "d", "e", "MENUS_FOR_LONG_PRESS_CHOSEN_BAR", "MENUS_FOR_ARTICLE_MAIN_MSG", "MENUS_FOR_DELETE_GRAY_TIPS", "g", "MENUS_FOR_RESEND_MSG", "Lcom/tencent/guild/aio/halfpop/menu/t;", h.F, "a", "DEBUG_MSG", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f110667a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> MENUS_FOR_LONG_PRESS_MSG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> MENUS_CHOSEN_FOR_LONG_PRESS_MSG;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> MENUS_FOR_LONG_PRESS_CHOSEN_BAR;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> MENUS_FOR_ARTICLE_MAIN_MSG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> MENUS_FOR_DELETE_GRAY_TIPS;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> MENUS_FOR_RESEND_MSG;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Class<? extends t>> DEBUG_MSG;

    static {
        List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> listOf;
        List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> listOf2;
        List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> listOf3;
        List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> listOf4;
        List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> listOf5;
        List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> listOf6;
        List<Class<? extends t>> listOf7;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{EmotionMenuItem.class, w.class, d.class, u.class, SaveToEmojiMenuItem.class, x.class, v.class, SetChosenActionItem.class, z.class, aa.class});
        MENUS_FOR_LONG_PRESS_MSG = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{EmotionMenuItem.class, w.class, d.class, l.class, SaveToEmojiMenuItem.class, com.tencent.guild.aio.halfpop.menu.c.class, SetChosenActionItem.class, z.class, aa.class});
        MENUS_CHOSEN_FOR_LONG_PRESS_MSG = listOf2;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{com.tencent.guild.aio.reserve2.busi.chosen.menu.a.class, o.class, f.class, o.class, RemoveChosenMsgItem.class, com.tencent.guild.aio.reserve2.busi.chosen.menu.h.class, com.tencent.guild.aio.reserve2.busi.chosen.menu.b.class});
        MENUS_FOR_LONG_PRESS_CHOSEN_BAR = listOf3;
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{EmotionMenuItem.class, w.class, d.class, x.class, v.class, SetChosenActionItem.class, z.class});
        MENUS_FOR_ARTICLE_MAIN_MSG = listOf4;
        listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{j.class, o.class, g.class, com.tencent.guild.aio.reserve2.busi.chosen.menu.h.class, com.tencent.guild.aio.reserve2.busi.chosen.menu.b.class});
        MENUS_FOR_DELETE_GRAY_TIPS = listOf5;
        listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{m.class, com.tencent.guild.aio.reserve2.busi.chosen.menu.h.class, com.tencent.guild.aio.reserve2.busi.chosen.menu.b.class});
        MENUS_FOR_RESEND_MSG = listOf6;
        listOf7 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{do0.a.class, e.class});
        DEBUG_MSG = listOf7;
    }

    c() {
    }

    @NotNull
    public final List<Class<? extends t>> a() {
        return DEBUG_MSG;
    }

    @NotNull
    public final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> b() {
        return MENUS_CHOSEN_FOR_LONG_PRESS_MSG;
    }

    @NotNull
    public final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> c() {
        return MENUS_FOR_ARTICLE_MAIN_MSG;
    }

    @NotNull
    public final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> d() {
        return MENUS_FOR_DELETE_GRAY_TIPS;
    }

    @NotNull
    public final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> e() {
        return MENUS_FOR_LONG_PRESS_CHOSEN_BAR;
    }

    @NotNull
    public final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem>>> f() {
        return MENUS_FOR_LONG_PRESS_MSG;
    }

    @NotNull
    public final List<Class<? extends com.tencent.guild.aio.halfpop.menu.b<? extends Object>>> g() {
        return MENUS_FOR_RESEND_MSG;
    }
}
