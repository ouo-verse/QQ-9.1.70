package com.tencent.guild.aio.help;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.msglist.ark.GuildArkAppContainerEvent;
import com.tencent.guild.aio.msglist.ark.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\n*\u0001(\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u001c\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\u0006J\u0014\u0010\u001e\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010!R\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010,R&\u00101\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/guild/aio/help/GuildArkContainerHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", DomainData.DOMAIN_NAME, "", tl.h.F, "k", "j", "", "messageId", "g", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Ljava/lang/ref/WeakReference;", "Ltp0/a;", "arkAppContainerWeakReference", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "e", "d", "Lcom/tencent/aio/main/businesshelper/b;", "Ljava/lang/String;", "guildId", "f", "channelId", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "containerEvents", "com/tencent/guild/aio/help/GuildArkContainerHelper$b", "Lcom/tencent/guild/aio/help/GuildArkContainerHelper$b;", "mActionR", "Lcom/tencent/guild/aio/msglist/ark/d;", "Lcom/tencent/guild/aio/msglist/ark/d;", "arkAppContainerMRUUpdater", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "arkAppContainerMap", "D", "preloadArkAppContainerMap", "<init>", "()V", "E", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArkContainerHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String channelId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> containerEvents = new ArrayList<String>() { // from class: com.tencent.guild.aio.help.GuildArkContainerHelper$containerEvents$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            add(Reflection.getOrCreateKotlinClass(GuildArkAppContainerEvent.GetArkContainerHelper.class).getQualifiedName());
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return indexOf((String) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return lastIndexOf((String) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ String remove(int i3) {
            return removeAt(i3);
        }

        public /* bridge */ String removeAt(int i3) {
            return (String) super.remove(i3);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((Object) str);
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf((Object) str);
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf((Object) str);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return remove((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str) {
            return super.remove((Object) str);
        }
    };

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR = new b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.ark.d arkAppContainerMRUUpdater = new com.tencent.guild.aio.msglist.ark.d();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, WeakReference<tp0.a>> arkAppContainerMap = new HashMap();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, tp0.a> preloadArkAppContainerMap = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001e\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001e\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001e\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/help/GuildArkContainerHelper$a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Ljava/lang/ref/WeakReference;", "Ltp0/a;", "weakRef", "", "d", "c", "e", "a", "Lcom/tencent/guild/aio/help/GuildArkContainerHelper;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.help.GuildArkContainerHelper$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<tp0.a> weakRef) {
            GuildArkContainerHelper b16;
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null) {
                b16.e(weakRef);
            }
        }

        @Nullable
        public final GuildArkContainerHelper b(@Nullable com.tencent.aio.api.runtime.a aioContext) {
            if (aioContext != null && aioContext.e() != null) {
                com.tencent.mvi.base.route.k k3 = aioContext.e().k(GuildArkAppContainerEvent.GetArkContainerHelper.f111188d);
                if (k3 != null) {
                    return ((c.a) k3).getArkContainerHelper();
                }
            }
            return null;
        }

        public final void c(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<tp0.a> weakRef) {
            GuildArkContainerHelper b16;
            com.tencent.guild.aio.msglist.ark.d dVar;
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null && (dVar = b16.arkAppContainerMRUUpdater) != null) {
                dVar.o(weakRef);
            }
        }

        public final void d(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<tp0.a> weakRef) {
            GuildArkContainerHelper b16;
            com.tencent.guild.aio.msglist.ark.d dVar;
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null && (dVar = b16.arkAppContainerMRUUpdater) != null) {
                dVar.n(weakRef);
            }
        }

        public final void e(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<tp0.a> weakRef) {
            GuildArkContainerHelper b16;
            com.tencent.guild.aio.msglist.ark.d dVar;
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null && (dVar = b16.arkAppContainerMRUUpdater) != null) {
                dVar.p(weakRef);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/GuildArkContainerHelper$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        b() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildArkContainerHelper.this.n(i3);
        }
    }

    private final void g(long messageId) {
        tp0.a aVar;
        tp0.a aVar2;
        WeakReference<tp0.a> weakReference = this.arkAppContainerMap.get(Long.valueOf(messageId));
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null && (aVar2 = weakReference.get()) != null) {
            aVar2.doOnEvent(2);
        }
    }

    private final void i() {
        com.tencent.guild.aio.msglist.ark.g d16 = com.tencent.guild.aio.msglist.ark.g.INSTANCE.d();
        if (d16 != null) {
            String str = this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            String str2 = this.channelId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                str2 = null;
            }
            d16.g(str, str2);
        }
        c();
        Iterator<String> it = this.containerEvents.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.tencent.aio.main.businesshelper.b bVar = this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            bVar.a().e().a(next);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k n(MsgIntent i3) {
        if (i3 instanceof GuildArkAppContainerEvent.GetArkContainerHelper) {
            return new c.a(this);
        }
        return pn0.b.f426490a;
    }

    public final void c() {
        Iterator<Map.Entry<Long, WeakReference<tp0.a>>> it = this.arkAppContainerMap.entrySet().iterator();
        while (it.hasNext()) {
            g(it.next().getKey().longValue());
        }
        this.arkAppContainerMap.clear();
        Iterator<Map.Entry<Long, tp0.a>> it5 = this.preloadArkAppContainerMap.entrySet().iterator();
        while (it5.hasNext()) {
            g(it5.next().getKey().longValue());
        }
        this.preloadArkAppContainerMap.clear();
        this.arkAppContainerMRUUpdater.f();
    }

    public final void e(@NotNull WeakReference<tp0.a> arkAppContainerWeakReference) {
        Intrinsics.checkNotNullParameter(arkAppContainerWeakReference, "arkAppContainerWeakReference");
        Iterator<Map.Entry<Long, WeakReference<tp0.a>>> it = this.arkAppContainerMap.entrySet().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getValue(), arkAppContainerWeakReference)) {
                it.remove();
                return;
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 14;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildArkContainerHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 8, 12};
    }

    @Nullable
    public final tp0.a m(long messageId) {
        WeakReference<tp0.a> weakReference = this.arkAppContainerMap.get(Long.valueOf(messageId));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void o(long messageId, @NotNull WeakReference<tp0.a> arkAppContainerWeakReference) {
        Intrinsics.checkNotNullParameter(arkAppContainerWeakReference, "arkAppContainerWeakReference");
        this.arkAppContainerMap.put(Long.valueOf(messageId), arkAppContainerWeakReference);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        AIOContact c16 = param.a().g().r().c();
        this.guildId = c16.f();
        this.channelId = c16.j();
        com.tencent.guild.aio.msglist.ark.g d16 = com.tencent.guild.aio.msglist.ark.g.INSTANCE.d();
        if (d16 != null) {
            String str = this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            String str2 = this.channelId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                str2 = null;
            }
            d16.e(str, str2);
        }
        Iterator<String> it = this.containerEvents.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.tencent.aio.main.businesshelper.b bVar = this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            bVar.a().e().j(next, this.mActionR);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state != 8) {
                    if (state == 12) {
                        i();
                        return;
                    }
                    return;
                }
                j();
                return;
            }
            k();
            return;
        }
        h();
    }

    private final void h() {
    }

    private final void j() {
    }

    private final void k() {
    }
}
