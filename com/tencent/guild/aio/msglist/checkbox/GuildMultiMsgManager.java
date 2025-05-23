package com.tencent.guild.aio.msglist.checkbox;

import android.text.TextUtils;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zp0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0003\u0011$,B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003J\u001c\u0010\u0015\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003J\u001e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\"\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00022\u0006\u0010\b\u001a\u00020\u0007R-\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R-\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0&0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b,\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager;", "", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "", "o", "Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$d;", SessionDbHelper.SESSION_ID, "", "selectMode", DomainData.DOMAIN_NAME, "i", "", "f", "g", "msg", "b", "k", "", "msgSeqs", "l", "j", "msgItem", h.F, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "enable", "", "source", "p", "Ljava/util/ArrayList;", "Lzp0/b$a;", "msgSeqList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Lkotlin/Lazy;", "e", "()Ljava/util/concurrent/ConcurrentHashMap;", "msgSelectedCache", "d", "msgInitSelectCache", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMultiMsgManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildMultiMsgManager> f111242d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f111243e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy msgSelectedCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy msgInitSelectCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$a", "Ljava/util/Comparator;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "o1", "o2", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements Comparator<GuildMsgItem> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@Nullable GuildMsgItem o16, @Nullable GuildMsgItem o26) {
            if (o16 == null || o26 == null) {
                return 0;
            }
            if (o16.getMsgRecord().msgSeq > o26.getMsgRecord().msgSeq) {
                return 1;
            }
            if (o16.getMsgRecord().msgSeq >= o26.getMsgRecord().msgSeq) {
                return 0;
            }
            return -1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$b;", "", "Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager;", "sInstance", "", "TAG", "Ljava/lang/String;", "com/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$a", "comparator", "Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager$b, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildMultiMsgManager b() {
            return (GuildMultiMsgManager) GuildMultiMsgManager.f111242d.getValue();
        }

        @NotNull
        public final GuildMultiMsgManager a() {
            return b();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "bMultiSelect", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager$c, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class MultiSelectMode {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean bMultiSelect;

        public MultiSelectMode(boolean z16) {
            this.bMultiSelect = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getBMultiSelect() {
            return this.bMultiSelect;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof MultiSelectMode) && this.bMultiSelect == ((MultiSelectMode) other).bMultiSelect) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.bMultiSelect;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "MultiSelectMode(bMultiSelect=" + this.bMultiSelect + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$d;", "", "other", "", "equals", "", "toString", "", "hashCode", "a", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "channelId", "b", "I", "getFromScene", "()I", "fromScene", "<init>", "(Ljava/lang/String;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int fromScene;

        public d(@NotNull String channelId, int i3) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.channelId = channelId;
            this.fromScene = i3;
        }

        public boolean equals(@Nullable Object other) {
            if ((other instanceof d) && !TextUtils.isEmpty(this.channelId)) {
                d dVar = (d) other;
                if (this.channelId.equals(dVar.channelId) && this.fromScene == dVar.fromScene) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.channelId.hashCode() * 31) + this.fromScene;
        }

        @NotNull
        public String toString() {
            return "GuildChatSession{channelId = " + this.channelId + ", from = " + this.fromScene + ", hashCode = " + hashCode() + "}";
        }
    }

    static {
        Lazy<GuildMultiMsgManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GuildMultiMsgManager>() { // from class: com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMultiMsgManager invoke() {
                return new GuildMultiMsgManager(null);
            }
        });
        f111242d = lazy;
        f111243e = new a();
    }

    public /* synthetic */ GuildMultiMsgManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final ConcurrentHashMap<d, CopyOnWriteArrayList<b.a>> d() {
        return (ConcurrentHashMap) this.msgInitSelectCache.getValue();
    }

    private final ConcurrentHashMap<d, CopyOnWriteArrayList<GuildMsgItem>> e() {
        return (ConcurrentHashMap) this.msgSelectedCache.getValue();
    }

    public final void b(@NotNull d session, @NotNull GuildMsgItem msg2) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        synchronized (e()) {
            n(session, true);
            CopyOnWriteArrayList<GuildMsgItem> copyOnWriteArrayList = e().get(session);
            Intrinsics.checkNotNull(copyOnWriteArrayList);
            copyOnWriteArrayList.add(msg2);
        }
        j(session, msg2);
    }

    @NotNull
    public final List<b.a> c(@NotNull d session) {
        List<b.a> arrayList;
        Intrinsics.checkNotNullParameter(session, "session");
        synchronized (d()) {
            if (d().containsKey(session) && d().get(session) != null) {
                CopyOnWriteArrayList<b.a> copyOnWriteArrayList = d().get(session);
                Intrinsics.checkNotNull(copyOnWriteArrayList);
                arrayList = CollectionsKt___CollectionsKt.toList(copyOnWriteArrayList);
            } else {
                arrayList = new ArrayList<>();
            }
        }
        return arrayList;
    }

    public final int f(@NotNull d session) {
        Intrinsics.checkNotNullParameter(session, "session");
        return g(session).size();
    }

    @NotNull
    public final List<GuildMsgItem> g(@NotNull d session) {
        List<GuildMsgItem> arrayList;
        Intrinsics.checkNotNullParameter(session, "session");
        synchronized (e()) {
            if (e().containsKey(session) && e().get(session) != null) {
                CopyOnWriteArrayList<GuildMsgItem> copyOnWriteArrayList = e().get(session);
                Intrinsics.checkNotNull(copyOnWriteArrayList);
                arrayList = CollectionsKt___CollectionsKt.toList(copyOnWriteArrayList);
            } else {
                arrayList = new ArrayList<>();
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        if (r4 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(@NotNull d session, @NotNull GuildMsgItem msgItem) {
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!i(session)) {
            return false;
        }
        Object obj2 = null;
        if (e().get(session) != null) {
            CopyOnWriteArrayList<GuildMsgItem> copyOnWriteArrayList = e().get(session);
            Intrinsics.checkNotNull(copyOnWriteArrayList);
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((GuildMsgItem) obj).getMsgId() == msgItem.getMsgId()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
        }
        if (d().get(session) == null) {
            return false;
        }
        CopyOnWriteArrayList<b.a> copyOnWriteArrayList2 = d().get(session);
        Intrinsics.checkNotNull(copyOnWriteArrayList2);
        Iterator<T> it5 = copyOnWriteArrayList2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((b.a) next).getMsgSeq() == msgItem.getMsgSeq()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj2 = next;
                break;
            }
        }
        if (obj2 == null) {
            return false;
        }
        return true;
    }

    public final boolean i(@NotNull d session) {
        boolean containsKey;
        Intrinsics.checkNotNullParameter(session, "session");
        synchronized (e()) {
            containsKey = e().containsKey(session);
        }
        return containsKey;
    }

    public final void j(@NotNull d session, @NotNull final GuildMsgItem msg2) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        synchronized (d()) {
            if (!d().containsKey(session)) {
                return;
            }
            CopyOnWriteArrayList<b.a> copyOnWriteArrayList = d().get(session);
            if (copyOnWriteArrayList != null) {
                Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "msgInitSelectCache[session]");
                CollectionsKt__MutableCollectionsKt.removeAll((List) copyOnWriteArrayList, (Function1) new Function1<b.a, Boolean>() { // from class: com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager$removeInitMsg$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(b.a aVar) {
                        return Boolean.valueOf(aVar.getMsgSeq() == GuildMsgItem.this.getMsgSeq());
                    }
                });
            }
        }
    }

    public final void k(@NotNull d session, @NotNull final GuildMsgItem msg2) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        synchronized (e()) {
            if (!e().containsKey(session)) {
                return;
            }
            CopyOnWriteArrayList<GuildMsgItem> copyOnWriteArrayList = e().get(session);
            if (copyOnWriteArrayList != null) {
                Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "msgSelectedCache[session]");
                CollectionsKt__MutableCollectionsKt.removeAll((List) copyOnWriteArrayList, (Function1) new Function1<GuildMsgItem, Boolean>() { // from class: com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager$removeMsg$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(GuildMsgItem guildMsgItem) {
                        return Boolean.valueOf(guildMsgItem.getMsgId() == GuildMsgItem.this.getMsgId());
                    }
                });
            }
            j(session, msg2);
        }
    }

    public final void l(@NotNull d session, @NotNull List<Long> msgSeqs) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(msgSeqs, "msgSeqs");
        synchronized (e()) {
            if (!e().containsKey(session)) {
                return;
            }
            CopyOnWriteArrayList<GuildMsgItem> copyOnWriteArrayList = e().get(session);
            if (copyOnWriteArrayList != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : copyOnWriteArrayList) {
                    if (!msgSeqs.contains(Long.valueOf(((GuildMsgItem) obj).getMsgRecord().msgSeq))) {
                        arrayList.add(obj);
                    }
                }
                CopyOnWriteArrayList<GuildMsgItem> copyOnWriteArrayList2 = e().get(session);
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.clear();
                }
                CopyOnWriteArrayList<GuildMsgItem> copyOnWriteArrayList3 = e().get(session);
                if (copyOnWriteArrayList3 != null) {
                    copyOnWriteArrayList3.addAll(arrayList);
                }
            }
        }
    }

    public final void m(@NotNull d session, @NotNull ArrayList<b.a> msgSeqList) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
        synchronized (d()) {
            d().put(session, new CopyOnWriteArrayList<>(msgSeqList));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void n(@NotNull d session, boolean selectMode) {
        Intrinsics.checkNotNullParameter(session, "session");
        synchronized (e()) {
            if (selectMode) {
                if (e().containsKey(session)) {
                } else {
                    e().put(session, new CopyOnWriteArrayList<>());
                }
            } else {
                e().remove(session);
            }
        }
    }

    public final void o(@Nullable List<? extends GuildMsgItem> msgList) {
        if (msgList != null && (!msgList.isEmpty())) {
            Collections.sort(msgList, f111243e);
        }
    }

    public final void p(@NotNull com.tencent.aio.api.runtime.a aioContext, boolean enable, @NotNull String source) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(source, "source");
        n(new d(aioContext.g().r().c().j(), com.tencent.guild.aio.util.ex.a.d(aioContext)), false);
        aioContext.e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent(source, enable));
    }

    public final void q(@NotNull d session) {
        Intrinsics.checkNotNullParameter(session, "session");
        synchronized (d()) {
            d().remove(session);
        }
    }

    GuildMultiMsgManager() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<d, CopyOnWriteArrayList<GuildMsgItem>>>() { // from class: com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager$msgSelectedCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<GuildMultiMsgManager.d, CopyOnWriteArrayList<GuildMsgItem>> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.msgSelectedCache = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<d, CopyOnWriteArrayList<b.a>>>() { // from class: com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager$msgInitSelectCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<GuildMultiMsgManager.d, CopyOnWriteArrayList<b.a>> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.msgInitSelectCache = lazy2;
    }
}
