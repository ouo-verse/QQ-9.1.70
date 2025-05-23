package com.tencent.qqnt.troopmemberlist.cache;

import androidx.collection.LruCache;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import com.tencent.qqnt.troopmemberlist.cache.impl.TroopMemberCacheServiceImpl;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u001e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016J\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR&\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010(R\u0014\u0010+\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/AllInOneWithAIOCache;", "Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$c;", "", "troopUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "memberInfo", "", h.F, "g", "", "memberList", "k", "j", "memberUin", "i", "get", "memberInfos", "put", "remove", "", "a", "b", "I", QzoneConfig.SECONDARY_VIDEO_MAX_CACHE_SIZE, "cacheAIOCount", "c", "aioCachePerSize", "Lcom/tencent/cache/api/collection/a;", "d", "Lcom/tencent/cache/api/collection/a;", "memberCache", "", "", "e", "Ljava/util/Map;", "aioSortedCache", "f", "aioCache", "Landroidx/collection/LruCache;", "", "Landroidx/collection/LruCache;", "aioUinCache", "Ljava/lang/Object;", "aioUinCacheLock", "Lcom/tencent/qqnt/inner/b;", "Lcom/tencent/qqnt/inner/b;", "frequencyControl", "<init>", "(I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AllInOneWithAIOCache implements ITroopMemberCacheService.c {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxCacheSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int cacheAIOCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int aioCachePerSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cache.api.collection.a<String, TroopMemberInfo> memberCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, List<TroopMemberInfo>> aioSortedCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, TroopMemberInfo> aioCache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, Object> aioUinCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object aioUinCacheLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.inner.b frequencyControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/troopmemberlist/cache/AllInOneWithAIOCache$a", "Landroidx/collection/LruCache;", "", "", "", "evicted", "key", "oldValue", "newValue", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends LruCache<String, Object> {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AllInOneWithAIOCache.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean evicted, @NotNull String key, @NotNull Object oldValue, @Nullable Object newValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(evicted), key, oldValue, newValue);
                return;
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(oldValue, "oldValue");
            super.entryRemoved(evicted, key, oldValue, newValue);
            Object obj = AllInOneWithAIOCache.this.aioUinCacheLock;
            AllInOneWithAIOCache allInOneWithAIOCache = AllInOneWithAIOCache.this;
            synchronized (obj) {
                allInOneWithAIOCache.j(key);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/AllInOneWithAIOCache$b;", "", "", "DEFAULT_INIT_DELAY_TIME", "J", "", "DEFAULT_MAX_REQUESTING_SIZE", "I", "DEFAULT_REQUEST_DELAY_TIME", "", "FROM", "Ljava/lang/String;", "KEY_AIO_CACHE_MEMBER", "KEY_CACHE_AIO_UIN", "PLACE_HOLDER", "SPLIT", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.cache.AllInOneWithAIOCache$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AllInOneWithAIOCache(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.maxCacheSize = i3;
        ITroopMemberCacheService.Companion companion = ITroopMemberCacheService.INSTANCE;
        int b16 = companion.b();
        this.cacheAIOCount = b16;
        this.aioCachePerSize = companion.a();
        this.memberCache = new com.tencent.cache.api.collection.a<>(Business.AIO, "TroopMembers", i3);
        this.aioSortedCache = new LinkedHashMap();
        this.aioCache = new LinkedHashMap();
        this.aioUinCacheLock = new Object();
        this.frequencyControl = new com.tencent.qqnt.inner.b("AllInOneWithAIOCache", ITroopMemberCacheService.CONFIG_ID, 3, 200L);
        this.aioUinCache = new a(b16);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.cache.b
            @Override // java.lang.Runnable
            public final void run() {
                AllInOneWithAIOCache.d(AllInOneWithAIOCache.this);
            }
        }, 16, null, false, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AllInOneWithAIOCache this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    private final void g() {
        List<String> split$default;
        boolean z16;
        final List split$default2;
        split$default = StringsKt__StringsKt.split$default((CharSequence) com.tencent.mobileqq.troop.config.a.n(com.tencent.mobileqq.troop.config.a.f294689a, "KEY_CACHE_AIO_UIN", "", false, 4, null), new String[]{"-"}, false, 0, 6, (Object) null);
        for (final String str : split$default) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String n3 = com.tencent.mobileqq.troop.config.a.n(com.tencent.mobileqq.troop.config.a.f294689a, "KEY_AIO_CACHE_MEMBER-" + str, "", false, 4, null);
                if (QLog.isColorLevel()) {
                    QLog.d(TroopMemberCacheServiceImpl.TAG, 2, "initAIOCache: troopUin=" + str + ", cacheMember=" + n3);
                }
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) n3, new String[]{"-"}, false, 0, 6, (Object) null);
                this.frequencyControl.d(str, new Function0<Unit>(str, split$default2) { // from class: com.tencent.qqnt.troopmemberlist.cache.AllInOneWithAIOCache$initAIOCache$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ List<String> $memberUinList;
                    final /* synthetic */ String $troopUin;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$troopUin = str;
                        this.$memberUinList = split$default2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) split$default2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            TroopMemberListRepo.INSTANCE.fetchTroopMemberUinListInfo(this.$troopUin, this.$memberUinList, false, null, "AllInOneWithAIOCache", null);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }

    private final void h(String troopUin, TroopMemberInfo memberInfo) {
        Object removeFirst;
        List<TroopMemberInfo> list;
        TroopMemberInfo troopMemberInfo = this.aioCache.get(TroopMemberCacheServiceImpl.INSTANCE.a(memberInfo));
        if (troopMemberInfo != null && (list = this.aioSortedCache.get(troopUin)) != null) {
            list.remove(troopMemberInfo);
        }
        List<TroopMemberInfo> list2 = this.aioSortedCache.get(troopUin);
        if (list2 == null) {
            list2 = new ArrayList<>();
            this.aioSortedCache.put(troopUin, list2);
        }
        List<TroopMemberInfo> list3 = list2;
        Iterator<TroopMemberInfo> it = list3.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (memberInfo.last_active_time <= it.next().last_active_time) {
                break;
            } else {
                i3++;
            }
        }
        list3.add(i3, memberInfo);
        Map<String, TroopMemberInfo> map = this.aioCache;
        TroopMemberCacheServiceImpl.Companion companion = TroopMemberCacheServiceImpl.INSTANCE;
        map.put(companion.a(memberInfo), memberInfo);
        if (list3.size() > this.aioCachePerSize) {
            removeFirst = CollectionsKt__MutableCollectionsKt.removeFirst(list3);
            this.aioCache.remove(companion.a((TroopMemberInfo) removeFirst));
        }
        synchronized (this.aioUinCacheLock) {
            k(troopUin, list2);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void i(String troopUin, String memberUin) {
        TroopMemberInfo remove = this.aioCache.remove(TroopMemberCacheServiceImpl.INSTANCE.b(troopUin, memberUin));
        if (remove != null) {
            List<TroopMemberInfo> list = this.aioSortedCache.get(troopUin);
            if (list != null) {
                list.remove(remove);
            }
            List<TroopMemberInfo> list2 = this.aioSortedCache.get(troopUin);
            boolean z16 = false;
            if (list2 != null && list2.size() == 0) {
                z16 = true;
            }
            if (z16) {
                j(troopUin);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String troopUin) {
        com.tencent.mobileqq.troop.config.a.p(com.tencent.mobileqq.troop.config.a.f294689a, "KEY_AIO_CACHE_MEMBER-" + troopUin, false, 2, null);
    }

    private final void k(String troopUin, List<? extends TroopMemberInfo> memberList) {
        this.aioUinCache.put(troopUin, 0);
        Map<String, Object> allTroopUin = this.aioUinCache.snapshot();
        StringBuilder sb5 = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(allTroopUin, "allTroopUin");
        Iterator<Map.Entry<String, Object>> it = allTroopUin.entrySet().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().getKey());
            sb5.append("-");
        }
        StringBuilder sb6 = new StringBuilder();
        Iterator<? extends TroopMemberInfo> it5 = memberList.iterator();
        while (it5.hasNext()) {
            sb6.append(it5.next().memberuin);
            sb6.append("-");
        }
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String sb7 = sb6.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "memberUinBuilder.toString()");
        com.tencent.mobileqq.troop.config.a.z(aVar, "KEY_AIO_CACHE_MEMBER-" + troopUin, sb7, false, 4, null);
        String sb8 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "troopUinBuilder.toString()");
        com.tencent.mobileqq.troop.config.a.z(aVar, "KEY_CACHE_AIO_UIN", sb8, false, 4, null);
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public int a(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin)).intValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return this.maxCacheSize - this.memberCache.h();
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.maxCacheSize;
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    @Nullable
    public TroopMemberInfo get(@NotNull String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        String b16 = TroopMemberCacheServiceImpl.INSTANCE.b(troopUin, memberUin);
        TroopMemberInfo e16 = this.memberCache.e(b16);
        if (e16 == null) {
            return this.aioCache.get(b16);
        }
        return e16;
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public void put(@NotNull String troopUin, @NotNull List<? extends TroopMemberInfo> memberInfos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memberInfos);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberInfos, "memberInfos");
        for (TroopMemberInfo troopMemberInfo : memberInfos) {
            this.memberCache.f(TroopMemberCacheServiceImpl.INSTANCE.a(troopMemberInfo), troopMemberInfo);
            synchronized (this.aioSortedCache) {
                h(troopUin, troopMemberInfo);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public void remove(@NotNull String troopUin, @NotNull List<String> memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) memberUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        for (String str : memberUin) {
            this.memberCache.g(TroopMemberCacheServiceImpl.INSTANCE.b(troopUin, str));
            synchronized (this.aioSortedCache) {
                i(troopUin, str);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
