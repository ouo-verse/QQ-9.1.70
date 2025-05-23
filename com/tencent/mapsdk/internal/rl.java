package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ce;
import com.tencent.mapsdk.internal.ci;
import com.tencent.mapsdk.internal.hr;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.rk;
import com.tencent.mapsdk.internal.v;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rl implements ci {

    /* renamed from: k, reason: collision with root package name */
    private static final String f150077k = "PromoteImageCache";

    /* renamed from: a, reason: collision with root package name */
    boolean f150078a;

    /* renamed from: b, reason: collision with root package name */
    ci.a f150079b;

    /* renamed from: c, reason: collision with root package name */
    final cf f150080c;

    /* renamed from: d, reason: collision with root package name */
    final b f150081d;

    /* renamed from: e, reason: collision with root package name */
    final Map<ce, Boolean> f150082e;

    /* renamed from: f, reason: collision with root package name */
    final Map<ce, Boolean> f150083f;

    /* renamed from: g, reason: collision with root package name */
    final Map<ce, Boolean> f150084g;

    /* renamed from: h, reason: collision with root package name */
    final Map<ce, Boolean> f150085h;

    /* renamed from: i, reason: collision with root package name */
    final Map<String, Set<ce>> f150086i;

    /* renamed from: j, reason: collision with root package name */
    final a f150087j;

    /* renamed from: l, reason: collision with root package name */
    private int f150088l;

    /* renamed from: m, reason: collision with root package name */
    private int f150089m;

    /* renamed from: n, reason: collision with root package name */
    private final lw f150090n;

    /* renamed from: o, reason: collision with root package name */
    private final lu f150091o;

    /* renamed from: p, reason: collision with root package name */
    private final kp.a<Boolean> f150092p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rl(cf cfVar) {
        lw lwVar = new lw();
        this.f150090n = lwVar;
        this.f150091o = new ma();
        this.f150081d = new b();
        this.f150082e = new ConcurrentHashMap();
        this.f150083f = new ConcurrentHashMap();
        this.f150084g = new ConcurrentHashMap();
        this.f150085h = new ConcurrentHashMap();
        this.f150086i = new ConcurrentHashMap();
        this.f150087j = new a();
        this.f150092p = new kp.a<Boolean>() { // from class: com.tencent.mapsdk.internal.rl.1
            private void a(Boolean bool) {
                if (bool.booleanValue() && rl.this.f150079b != null) {
                    LogUtil.b(rl.f150077k, "notify layer handle result before :" + rl.this.f150085h.size() + "|" + rl.this.f150084g.size() + "|" + rl.this.f150083f.size());
                    rl rlVar = rl.this;
                    rlVar.f150079b.a(rlVar.f150085h.keySet(), rl.this.f150084g.keySet(), rl.this.f150083f.keySet());
                    for (ce ceVar : rl.this.f150083f.keySet()) {
                        if (ceVar.g() == ce.a.REMOVE) {
                            rl.this.f150083f.remove(ceVar);
                            rl.this.f150082e.remove(ceVar);
                        }
                    }
                    for (ce ceVar2 : rl.this.f150085h.keySet()) {
                        if (ceVar2.g() == ce.a.ADD) {
                            rl.this.f150085h.remove(ceVar2);
                        }
                    }
                    for (ce ceVar3 : rl.this.f150084g.keySet()) {
                        if (ceVar3.g() == ce.a.ADD || ceVar3.g() == ce.a.SHOWING) {
                            rl.this.f150084g.remove(ceVar3);
                        }
                    }
                    LogUtil.b(rl.f150077k, "notify layer handle result after:" + rl.this.f150085h.size() + "|" + rl.this.f150084g.size() + "|" + rl.this.f150083f.size());
                    return;
                }
                LogUtil.b(rl.f150077k, "thisCallbackRunnable do nothing !");
            }

            @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(Object obj) {
                if (((Boolean) obj).booleanValue() && rl.this.f150079b != null) {
                    LogUtil.b(rl.f150077k, "notify layer handle result before :" + rl.this.f150085h.size() + "|" + rl.this.f150084g.size() + "|" + rl.this.f150083f.size());
                    rl rlVar = rl.this;
                    rlVar.f150079b.a(rlVar.f150085h.keySet(), rl.this.f150084g.keySet(), rl.this.f150083f.keySet());
                    for (ce ceVar : rl.this.f150083f.keySet()) {
                        if (ceVar.g() == ce.a.REMOVE) {
                            rl.this.f150083f.remove(ceVar);
                            rl.this.f150082e.remove(ceVar);
                        }
                    }
                    for (ce ceVar2 : rl.this.f150085h.keySet()) {
                        if (ceVar2.g() == ce.a.ADD) {
                            rl.this.f150085h.remove(ceVar2);
                        }
                    }
                    for (ce ceVar3 : rl.this.f150084g.keySet()) {
                        if (ceVar3.g() == ce.a.ADD || ceVar3.g() == ce.a.SHOWING) {
                            rl.this.f150084g.remove(ceVar3);
                        }
                    }
                    LogUtil.b(rl.f150077k, "notify layer handle result after:" + rl.this.f150085h.size() + "|" + rl.this.f150084g.size() + "|" + rl.this.f150083f.size());
                    return;
                }
                LogUtil.b(rl.f150077k, "thisCallbackRunnable do nothing !");
            }
        };
        this.f150080c = cfVar;
        lwVar.a(new mb() { // from class: com.tencent.mapsdk.internal.rl.2
            @Override // com.tencent.mapsdk.internal.mb, com.tencent.mapsdk.internal.lv
            public final void a(String str, byte[] bArr) {
                super.a(str, bArr);
                Set<ce> set = rl.this.f150086i.get(str);
                if (set != null) {
                    Iterator<ce> it = set.iterator();
                    while (it.hasNext()) {
                        rl.this.a(str, bArr, it.next());
                    }
                }
            }

            @Override // com.tencent.mapsdk.internal.mb, com.tencent.mapsdk.internal.lv
            public final void c(String str) {
                super.c(str);
                Set<ce> remove = rl.this.f150086i.remove(str);
                if (remove != null) {
                    for (ce ceVar : remove) {
                        if (ceVar != null && ceVar.b(rl.this.f150078a) != null) {
                            ceVar.a(ce.a.WILL_ADD);
                            rl.this.f150085h.put(ceVar, Boolean.TRUE);
                        }
                    }
                }
                if (rl.this.f150086i.isEmpty() && !rl.this.f150085h.isEmpty()) {
                    LogUtil.b(rl.f150077k, "onCompleted all icons to add on layer");
                    rl.this.b();
                }
            }

            @Override // com.tencent.mapsdk.internal.mb, com.tencent.mapsdk.internal.lv
            public final void a(String str, lx lxVar) {
                LogUtil.b(rl.f150077k, "download icon " + lxVar + " url : " + str);
                if (lxVar == lx.CANCEL || lxVar == lx.ERROR) {
                    rl.this.f150087j.c(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends lh<String, byte[]> {
        public a() {
            super(10240);
        }

        @Override // com.tencent.mapsdk.internal.lh
        public final /* bridge */ /* synthetic */ int a(@NonNull byte[] bArr) {
            return bArr.length;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static int a2(@NonNull byte[] bArr) {
            return bArr.length;
        }
    }

    private boolean b(List<ce> list) {
        LogUtil.b(f150077k, "mergeNewImages ... :".concat(String.valueOf(list)));
        List[] a16 = hr.a((List) new ArrayList(this.f150082e.keySet()), (List) list);
        LogUtil.b(f150077k, "diff :" + a16[0]);
        LogUtil.b(f150077k, "same :" + a16[1]);
        LogUtil.b(f150077k, "insert :" + a16[2]);
        LogUtil.b(f150077k, "merge :" + a16[3]);
        Iterator it = a16[3].iterator();
        while (it.hasNext()) {
            this.f150082e.put((ce) it.next(), Boolean.TRUE);
        }
        if (a16[1].size() > 0) {
            a(this.f150084g, (List<ce>) a16[1], ce.a.WILL_UPDATE);
        }
        if (a16[2].size() > 0) {
            a(this.f150085h, (List<ce>) a16[2], ce.a.WILL_ADD);
        }
        return a16[1].size() > 0 || a16[2].size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, byte[] bArr, ce ceVar) {
        BitmapDescriptor a16;
        if (ceVar != null) {
            String a17 = ceVar.a(false);
            String a18 = ceVar.a(true);
            if (str.equals(a17)) {
                BitmapDescriptor a19 = this.f150080c.a(ceVar, bArr, false, false);
                if (a19 != null) {
                    ceVar.a(a19, false);
                }
                if (hs.a(a18)) {
                    ceVar.a(this.f150080c.a(ceVar, bArr, true, true), true);
                    return;
                }
                return;
            }
            if (!str.equals(a18) || (a16 = this.f150080c.a(ceVar, bArr, true, false)) == null) {
                return;
            }
            ceVar.a(a16, true);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.rl$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass3 extends kp.g<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f150095a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f150096b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ v.b f150097c;

        AnonymousClass3(String str, String str2, v.b bVar) {
            this.f150095a = str;
            this.f150096b = str2;
            this.f150097c = bVar;
        }

        private Boolean a() throws Exception {
            boolean z16;
            LogUtil.b(rl.f150077k, "load from network ... range:" + this.f150095a + " level:" + this.f150096b);
            NetResponse fetchData = ch.b().fetchData(this.f150095a, this.f150096b);
            if (fetchData.available()) {
                String data = fetchData.getData();
                LogUtil.b(rl.f150077k, "fetch json:".concat(String.valueOf(data)));
                if (!TextUtils.isEmpty(data)) {
                    List<ce> a16 = rl.this.f150080c.a(data);
                    LogUtil.b(rl.f150077k, "mergeNewImages :" + a16.size());
                    rl.this.f150081d.a(this.f150097c, a16);
                    if (rl.a(rl.this, a16)) {
                        List[] a17 = hr.a((List) new ArrayList(rl.this.f150085h.keySet()), (List) new ArrayList(rl.this.f150084g.keySet()));
                        LogUtil.b(rl.f150077k, "notify new or update Images :" + a17[3].size());
                        LogUtil.b(rl.f150077k, "notify downloadIcons :".concat(String.valueOf(rl.b(rl.this, a17[3]))));
                        boolean z17 = false;
                        int intValue = ((Integer) hr.a((Iterable) a17[3], (hr.e) new AnonymousClass1(0))).intValue();
                        StringBuilder sb5 = new StringBuilder("notify update ? ");
                        if (intValue > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sb5.append(z16);
                        LogUtil.b(rl.f150077k, sb5.toString());
                        if (intValue > 0) {
                            z17 = true;
                        }
                        return Boolean.valueOf(z17);
                    }
                }
            }
            return Boolean.FALSE;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            boolean z16;
            LogUtil.b(rl.f150077k, "load from network ... range:" + this.f150095a + " level:" + this.f150096b);
            NetResponse fetchData = ch.b().fetchData(this.f150095a, this.f150096b);
            if (fetchData.available()) {
                String data = fetchData.getData();
                LogUtil.b(rl.f150077k, "fetch json:".concat(String.valueOf(data)));
                if (!TextUtils.isEmpty(data)) {
                    List<ce> a16 = rl.this.f150080c.a(data);
                    LogUtil.b(rl.f150077k, "mergeNewImages :" + a16.size());
                    rl.this.f150081d.a(this.f150097c, a16);
                    if (rl.a(rl.this, a16)) {
                        List[] a17 = hr.a((List) new ArrayList(rl.this.f150085h.keySet()), (List) new ArrayList(rl.this.f150084g.keySet()));
                        LogUtil.b(rl.f150077k, "notify new or update Images :" + a17[3].size());
                        LogUtil.b(rl.f150077k, "notify downloadIcons :".concat(String.valueOf(rl.b(rl.this, a17[3]))));
                        boolean z17 = false;
                        int intValue = ((Integer) hr.a((Iterable) a17[3], (hr.e) new AnonymousClass1(0))).intValue();
                        StringBuilder sb5 = new StringBuilder("notify update ? ");
                        if (intValue > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sb5.append(z16);
                        LogUtil.b(rl.f150077k, sb5.toString());
                        if (intValue > 0) {
                            z17 = true;
                        }
                        return Boolean.valueOf(z17);
                    }
                }
            }
            return Boolean.FALSE;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.rl$3$1, reason: invalid class name */
        /* loaded from: classes9.dex */
        final class AnonymousClass1 extends hr.e<ce, Integer> {
            AnonymousClass1(Integer num) {
                super(num);
            }

            @Override // com.tencent.mapsdk.internal.hr.e
            public final /* synthetic */ Integer a(Integer num, ce ceVar) {
                Integer num2 = num;
                ce ceVar2 = ceVar;
                if (ceVar2.g() != ce.a.WILL_ADD && ceVar2.g() != ce.a.WILL_UPDATE && ceVar2.g() != ce.a.WILL_REMOVE) {
                    return 0;
                }
                return Integer.valueOf(num2.intValue() + 1);
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            private static Integer a2(Integer num, ce ceVar) {
                if (ceVar.g() != ce.a.WILL_ADD && ceVar.g() != ce.a.WILL_UPDATE && ceVar.g() != ce.a.WILL_REMOVE) {
                    return 0;
                }
                return Integer.valueOf(num.intValue() + 1);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ci
    public final void a(ci.a aVar) {
        this.f150079b = aVar;
    }

    @Override // com.tencent.mapsdk.internal.ci
    public final void a() {
        LogUtil.b(f150077k, "destroyCache ... ");
        this.f150087j.a();
        this.f150081d.a();
        this.f150082e.clear();
        this.f150085h.clear();
        this.f150083f.clear();
        this.f150084g.clear();
        this.f150086i.clear();
        this.f150079b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f150092p.callback(Boolean.TRUE);
    }

    static /* synthetic */ int b(rl rlVar, List list) {
        LogUtil.b(f150077k, "downloadIcons ... ");
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ce ceVar = (ce) it.next();
            ce.a g16 = ceVar.g();
            ce.a aVar = ce.a.PREPARING;
            if (g16 != aVar) {
                String a16 = ceVar.a(rlVar.f150078a);
                LogUtil.b(f150077k, "id[" + ceVar.a() + "]icon url : " + a16);
                BitmapDescriptor b16 = ceVar.b(rlVar.f150078a);
                if (b16 == null) {
                    if (hs.a(a16)) {
                        a16 = ceVar.a(false);
                    }
                    byte[] b17 = rlVar.f150087j.b((a) a16);
                    if (b17 != null && b17.length > 0) {
                        rlVar.a(a16, b17, ceVar);
                    } else {
                        Set<ce> set = rlVar.f150086i.get(a16);
                        if (set == null) {
                            set = new ConcurrentSkipListSet<>();
                            rlVar.f150086i.put(a16, set);
                        }
                        set.add(ceVar);
                        if (set.size() == 1) {
                            i3++;
                            rlVar.f150090n.a(a16, rlVar.f150091o);
                        }
                        ceVar.a(aVar);
                    }
                } else {
                    Bitmap bitmap = b16.getBitmap(rlVar.f150080c.getMapContext().getContext());
                    if (bitmap == null || bitmap.isRecycled()) {
                        ceVar.a(aVar);
                    }
                }
            }
        }
        LogUtil.b(f150077k, "<= downloadIcons");
        return i3;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends lh<v.b, List<ce>> {
        public b() {
            super(9);
        }

        @Override // com.tencent.mapsdk.internal.lh
        public final /* synthetic */ void a(boolean z16, @NonNull v.b bVar, @NonNull List<ce> list, @Nullable List<ce> list2) {
            v.b bVar2 = bVar;
            List<ce> list3 = list;
            List<ce> list4 = list2;
            super.a(z16, (boolean) bVar2, list3, list4);
            LogUtil.b(rl.f150077k, "LRU entryRemoved key:".concat(String.valueOf(bVar2)));
            if (((rk) rl.this.f150080c).f150058b == rk.a.f150073c) {
                List[] a16 = hr.a((List) list3, (List) list4);
                if (a16[3].size() > 0) {
                    rl.a(rl.this.f150083f, (List<ce>) a16[3], ce.a.WILL_REMOVE);
                    if (rl.this.f150083f.isEmpty()) {
                        return;
                    }
                    LogUtil.b(rl.f150077k, "LRU entryRemoved notify callback to remove");
                    rl.this.b();
                }
            }
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(boolean z16, @NonNull v.b bVar, @NonNull List<ce> list, @Nullable List<ce> list2) {
            super.a(z16, (boolean) bVar, list, list2);
            LogUtil.b(rl.f150077k, "LRU entryRemoved key:".concat(String.valueOf(bVar)));
            if (((rk) rl.this.f150080c).f150058b == rk.a.f150073c) {
                List[] a16 = hr.a((List) list, (List) list2);
                if (a16[3].size() > 0) {
                    rl.a(rl.this.f150083f, (List<ce>) a16[3], ce.a.WILL_REMOVE);
                    if (rl.this.f150083f.isEmpty()) {
                        return;
                    }
                    LogUtil.b(rl.f150077k, "LRU entryRemoved notify callback to remove");
                    rl.this.b();
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ci
    public final void a(CameraPosition cameraPosition, boolean z16, int i3, int i16) {
        LogUtil.b(f150077k, "loadCurrent... pos:" + cameraPosition + " isNight:" + z16 + " minLevel:" + i3 + " maxLevel:" + i16);
        boolean z17 = (this.f150078a == z16 && this.f150088l == i3 && this.f150089m == i16) ? false : true;
        this.f150078a = z16;
        this.f150088l = i3;
        this.f150089m = i16;
        VisibleRegion visibleRegion = ((bf) this.f150080c.getMapContext()).b().getMap().getProjection().getVisibleRegion();
        HashSet hashSet = new HashSet();
        hashSet.add(y.c(visibleRegion.farLeft));
        hashSet.add(y.c(visibleRegion.farRight));
        hashSet.add(y.c(visibleRegion.nearRight));
        hashSet.add(y.c(visibleRegion.nearLeft));
        ArrayList arrayList = new ArrayList(hashSet);
        ArrayList arrayList2 = new ArrayList(this.f150081d.d().keySet());
        List[] a16 = hr.a((List) arrayList2, (List) arrayList);
        LogUtil.b(f150077k, "\u5f53\u524d\u74e6\u7247\u6570\u636e\uff1a".concat(String.valueOf(arrayList2)));
        if (a16[2].size() > 0) {
            for (v.b bVar : a16[2]) {
                LogUtil.b(f150077k, "\u65b0\u589e\u74e6\u7247[" + bVar + "]");
                if (bVar != null) {
                    LatLngBounds build = LatLngBounds.builder().include(Arrays.asList(y.a(bVar))).build();
                    if (!build.isEmptySpan()) {
                        kp.a((kp.g) new AnonymousClass3(build.northeast.latitude + "," + build.northeast.longitude + ";" + build.southwest.latitude + "," + build.southwest.longitude, this.f150088l + "," + this.f150089m, bVar)).a((kp.b.a) Boolean.FALSE, (kp.a<kp.b.a>) this.f150092p);
                    }
                }
            }
        } else {
            LogUtil.b(f150077k, "\u65e0\u65b0\u589e\u74e6\u7247\u6570\u636e:" + this.f150081d.b());
        }
        if (z17) {
            for (Map.Entry<v.b, List<ce>> entry : this.f150081d.d().entrySet()) {
                if (entry != null && entry.getValue() != null && !entry.getValue().isEmpty()) {
                    a(this.f150084g, entry.getValue(), ce.a.WILL_UPDATE);
                    LogUtil.b(f150077k, "\u66f4\u65b0\u74e6\u7247[" + entry.getKey() + "]\u7684\u6570\u636e\uff0c\u603b\u6570=" + entry.getValue().size() + " \u53ef\u66f4\u65b0\uff1a" + this.f150084g.size());
                }
            }
            b();
            return;
        }
        LogUtil.b(f150077k, "\u65e0\u66f4\u65b0\u74e6\u7247\u6570\u636e");
    }

    @Override // com.tencent.mapsdk.internal.ci
    public final List<ce> a(long j3, long j16, long j17) {
        return this.f150081d.b((b) new v.b(j3, j16, j17));
    }

    private void a(v.b bVar) {
        if (bVar == null) {
            return;
        }
        LatLngBounds build = LatLngBounds.builder().include(Arrays.asList(y.a(bVar))).build();
        if (build.isEmptySpan()) {
            return;
        }
        kp.a((kp.g) new AnonymousClass3(build.northeast.latitude + "," + build.northeast.longitude + ";" + build.southwest.latitude + "," + build.southwest.longitude, this.f150088l + "," + this.f150089m, bVar)).a((kp.b.a) Boolean.FALSE, (kp.a<kp.b.a>) this.f150092p);
    }

    private int a(List<ce> list) {
        LogUtil.b(f150077k, "downloadIcons ... ");
        int i3 = 0;
        for (ce ceVar : list) {
            ce.a g16 = ceVar.g();
            ce.a aVar = ce.a.PREPARING;
            if (g16 != aVar) {
                String a16 = ceVar.a(this.f150078a);
                LogUtil.b(f150077k, "id[" + ceVar.a() + "]icon url : " + a16);
                BitmapDescriptor b16 = ceVar.b(this.f150078a);
                if (b16 == null) {
                    if (hs.a(a16)) {
                        a16 = ceVar.a(false);
                    }
                    byte[] b17 = this.f150087j.b((a) a16);
                    if (b17 != null && b17.length > 0) {
                        a(a16, b17, ceVar);
                    } else {
                        Set<ce> set = this.f150086i.get(a16);
                        if (set == null) {
                            set = new ConcurrentSkipListSet<>();
                            this.f150086i.put(a16, set);
                        }
                        set.add(ceVar);
                        if (set.size() == 1) {
                            i3++;
                            this.f150090n.a(a16, this.f150091o);
                        }
                        ceVar.a(aVar);
                    }
                } else {
                    Bitmap bitmap = b16.getBitmap(this.f150080c.getMapContext().getContext());
                    if (bitmap == null || bitmap.isRecycled()) {
                        ceVar.a(aVar);
                    }
                }
            }
        }
        LogUtil.b(f150077k, "<= downloadIcons");
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Map<ce, Boolean> map, List<ce> list, ce.a aVar) {
        for (ce ceVar : hr.a((List) new ArrayList(map.keySet()), (List) list)[3]) {
            if (ceVar.a(aVar)) {
                map.put(ceVar, Boolean.TRUE);
            }
        }
    }

    static /* synthetic */ boolean a(rl rlVar, List list) {
        LogUtil.b(f150077k, "mergeNewImages ... :".concat(String.valueOf(list)));
        List[] a16 = hr.a((List) new ArrayList(rlVar.f150082e.keySet()), list);
        LogUtil.b(f150077k, "diff :" + a16[0]);
        LogUtil.b(f150077k, "same :" + a16[1]);
        LogUtil.b(f150077k, "insert :" + a16[2]);
        LogUtil.b(f150077k, "merge :" + a16[3]);
        Iterator it = a16[3].iterator();
        while (it.hasNext()) {
            rlVar.f150082e.put((ce) it.next(), Boolean.TRUE);
        }
        if (a16[1].size() > 0) {
            a(rlVar.f150084g, (List<ce>) a16[1], ce.a.WILL_UPDATE);
        }
        if (a16[2].size() > 0) {
            a(rlVar.f150085h, (List<ce>) a16[2], ce.a.WILL_ADD);
        }
        return a16[1].size() > 0 || a16[2].size() > 0;
    }
}
