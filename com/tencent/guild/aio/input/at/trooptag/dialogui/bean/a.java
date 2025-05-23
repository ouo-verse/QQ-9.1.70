package com.tencent.guild.aio.input.at.trooptag.dialogui.bean;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.IGuildAioPopupPanelConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import ip0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B/\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020\u001a\u0012\u0006\u0010+\u001a\u00020\u001a\u0012\u0006\u0010,\u001a\u00020\u0012\u00a2\u0006\u0004\b-\u0010.J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\\\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`\u001b2\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010%\u001a\u0004\u0018\u00010!2\b\u0010\u0013\u001a\u0004\u0018\u00010!8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&\u00a8\u00060"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "Lxe1/a;", "Lip0/c;", "", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "j", "Lcom/tencent/common/app/AppInterface;", "e", "Lcom/tencent/common/app/AppInterface;", "k", "()Lcom/tencent/common/app/AppInterface;", "qqAppInterface", "", "f", "Z", "getEnableTroopList", "()Z", "enableTroopList", "", "<set-?>", "g", "I", "l", "()I", "scene", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", h.F, "Ljava/util/HashMap;", "getExtra", "()Ljava/util/HashMap;", "extra", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "i", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "()Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "itemAnimatorListener", "Ljava/util/List;", "pageList", "Landroid/content/Context;", "context", "guildId", "channelId", "channelType", "<init>", "(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends xe1.a<c> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface qqAppInterface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean enableTroopList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int scene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> extra;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b itemAnimatorListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends HashTagPageType> pageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R2\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001cj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a$a;", "", "", "scene", "d", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "itemAnimatorListener", "b", "", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "pageList", "c", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "a", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/common/app/AppInterface;", "qqAppInterface", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "Ljava/lang/String;", "guildId", "channelId", "e", "I", "channelType", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "extra", h.F, "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "i", "Ljava/util/List;", "<init>", "(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1192a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AppInterface qqAppInterface;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int channelType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int scene;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashMap<String, String> extra;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private b itemAnimatorListener;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends HashTagPageType> pageList;

        public C1192a(@NotNull AppInterface qqAppInterface, @NotNull Context context, @NotNull String guildId, @NotNull String channelId, int i3) {
            List<? extends HashTagPageType> emptyList;
            Intrinsics.checkNotNullParameter(qqAppInterface, "qqAppInterface");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.qqAppInterface = qqAppInterface;
            this.context = context;
            this.guildId = guildId;
            this.channelId = channelId;
            this.channelType = i3;
            this.extra = new HashMap<>();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.pageList = emptyList;
        }

        @NotNull
        public final a a() {
            List list;
            a aVar = new a(this.qqAppInterface, this.context, this.guildId, this.channelId, this.channelType);
            aVar.scene = this.scene;
            aVar.extra = this.extra;
            aVar.itemAnimatorListener = this.itemAnimatorListener;
            if (!this.pageList.isEmpty()) {
                list = CollectionsKt___CollectionsKt.toList(this.pageList);
                aVar.pageList = list;
            }
            return aVar;
        }

        @NotNull
        public final C1192a b(@Nullable b itemAnimatorListener) {
            this.itemAnimatorListener = itemAnimatorListener;
            return this;
        }

        @NotNull
        public final C1192a c(@NotNull List<? extends HashTagPageType> pageList) {
            Intrinsics.checkNotNullParameter(pageList, "pageList");
            this.pageList = pageList;
            return this;
        }

        @NotNull
        public final C1192a d(int scene) {
            this.scene = scene;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull AppInterface qqAppInterface, @NotNull Context context, @NotNull String guildId, @NotNull String channelId, int i3) {
        super(context, guildId, channelId, i3);
        List<? extends HashTagPageType> listOf;
        Intrinsics.checkNotNullParameter(qqAppInterface, "qqAppInterface");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.qqAppInterface = qqAppInterface;
        this.enableTroopList = ((IGuildAioPopupPanelConfigApi) QRoute.api(IGuildAioPopupPanelConfigApi.class)).isEnableTroopList();
        this.extra = new HashMap<>();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new HashTagPageType[]{HashTagPageType.Troop_Page, HashTagPageType.Channel_Page});
        this.pageList = listOf;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final b getItemAnimatorListener() {
        return this.itemAnimatorListener;
    }

    @NotNull
    public final List<HashTagPageType> j() {
        boolean z16;
        if (this.enableTroopList) {
            return this.pageList;
        }
        List<? extends HashTagPageType> list = this.pageList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((HashTagPageType) obj) != HashTagPageType.Troop_Page) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final AppInterface getQqAppInterface() {
        return this.qqAppInterface;
    }

    /* renamed from: l, reason: from getter */
    public final int getScene() {
        return this.scene;
    }
}
