package com.tencent.qqnt.troopmemberlist.cache;

import com.gcore.abase.utils.PatternUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import com.tencent.qqnt.troopmemberlist.cache.impl.TroopMemberCacheServiceImpl;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0016J\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018RX\u0010\u001e\u001aF\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u001a0\u001aj*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u001aj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b`\u001c`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/d;", "Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$c;", "", "troopUin", "", "newValueSize", "", "e", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "info", "d", "memberUin", "get", "", "memberInfos", "put", "remove", "a", "b", "I", QzoneConfig.SECONDARY_VIDEO_MAX_CACHE_SIZE, "eachTroopMaxMemberSize", "Lcom/tencent/cache/api/collection/a;", "c", "Lcom/tencent/cache/api/collection/a;", "memberCache", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "eachTroopMemberCache", "<init>", "(I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements ITroopMemberCacheService.c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Object f362864f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxCacheSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int eachTroopMaxMemberSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cache.api.collection.a<String, TroopMemberInfo> memberCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, LinkedHashMap<String, Object>> eachTroopMemberCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/troopmemberlist/cache/d$a", "Lcom/tencent/cache/api/collection/a;", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "", "evicted", "key", "oldValue", "newValue", "", "j", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends com.tencent.cache.api.collection.a<String, TroopMemberInfo> {
        static IPatchRedirector $redirector_;

        a(Business business, int i3) {
            super(business, "TroopMembers", i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, business, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.cache.api.collection.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void c(boolean evicted, @Nullable String key, @Nullable TroopMemberInfo oldValue, @Nullable TroopMemberInfo newValue) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(evicted), key, oldValue, newValue);
                return;
            }
            super.c(evicted, key, oldValue, newValue);
            String str2 = null;
            if (oldValue != null) {
                str = oldValue.memberUid;
            } else {
                str = null;
            }
            if (newValue != null) {
                str2 = newValue.memberUid;
            }
            if (!Intrinsics.areEqual(str, str2) && oldValue != null) {
                d dVar = d.this;
                String curTroopUin = oldValue.troopuin;
                if (curTroopUin != null) {
                    Intrinsics.checkNotNullExpressionValue(curTroopUin, "curTroopUin");
                    synchronized (dVar.eachTroopMemberCache) {
                        LinkedHashMap linkedHashMap = (LinkedHashMap) dVar.eachTroopMemberCache.get(curTroopUin);
                        if (linkedHashMap != null) {
                            linkedHashMap.remove(oldValue.memberuin);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/d$b;", "", "", "DEFAULT_LINKED_HASH_MAP_FACTOR", UserInfo.SEX_FEMALE, "", "DEFAULT_LINKED_HASH_MAP_SIZE", "I", PatternUtils.NO_MATCH, "Ljava/lang/Object;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.cache.d$b, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63545);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            f362864f = new Object();
        }
    }

    public d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.maxCacheSize = i3;
        this.eachTroopMaxMemberSize = ITroopMemberCacheService.INSTANCE.d();
        this.eachTroopMemberCache = new LinkedHashMap<>(16, 0.75f, true);
        this.memberCache = new a(Business.AIO, i3);
    }

    private final void d(String troopUin, TroopMemberInfo info) {
        this.memberCache.f(TroopMemberCacheServiceImpl.INSTANCE.a(info), info);
        synchronized (this.eachTroopMemberCache) {
            LinkedHashMap<String, Object> linkedHashMap = this.eachTroopMemberCache.get(troopUin);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
            }
            String str = info.memberuin;
            Intrinsics.checkNotNullExpressionValue(str, "info.memberuin");
            linkedHashMap.put(str, f362864f);
            this.eachTroopMemberCache.put(troopUin, linkedHashMap);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void e(String troopUin, int newValueSize) {
        int a16 = newValueSize - a(troopUin);
        if (a16 > 0) {
            synchronized (this.eachTroopMemberCache) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, LinkedHashMap<String, Object>> entry : this.eachTroopMemberCache.entrySet()) {
                    LinkedHashMap<String, Object> value = entry.getValue();
                    int min = Math.min(value.size() - this.eachTroopMaxMemberSize, a16);
                    if (min > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<Map.Entry<String, Object>> it = value.entrySet().iterator();
                        while (it.hasNext()) {
                            arrayList2.add(it.next().getKey());
                            if (arrayList2.size() == min) {
                                break;
                            }
                        }
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            arrayList.add(TroopMemberCacheServiceImpl.INSTANCE.b(entry.getKey(), (String) it5.next()));
                        }
                        a16 -= min;
                        if (a16 <= 0) {
                            break;
                        }
                    }
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    this.memberCache.g((String) it6.next());
                }
                Unit unit = Unit.INSTANCE;
            }
            if (a16 > 0) {
                Set<Map.Entry<String, TroopMemberInfo>> entrySet = this.memberCache.i().entrySet();
                ArrayList arrayList3 = new ArrayList();
                Iterator<Map.Entry<String, TroopMemberInfo>> it7 = entrySet.iterator();
                while (it7.hasNext()) {
                    String key = it7.next().getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "entrySet.key");
                    arrayList3.add(key);
                    a16--;
                    if (a16 <= 0) {
                        break;
                    }
                }
                Iterator it8 = arrayList3.iterator();
                while (it8.hasNext()) {
                    this.memberCache.g((String) it8.next());
                }
            }
        }
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
        return this.memberCache.e(TroopMemberCacheServiceImpl.INSTANCE.b(troopUin, memberUin));
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
        e(troopUin, memberInfos.size());
        Iterator<? extends TroopMemberInfo> it = memberInfos.iterator();
        while (it.hasNext()) {
            d(troopUin, it.next());
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
        Iterator<String> it = memberUin.iterator();
        while (it.hasNext()) {
            this.memberCache.g(TroopMemberCacheServiceImpl.INSTANCE.b(troopUin, it.next()));
        }
    }
}
