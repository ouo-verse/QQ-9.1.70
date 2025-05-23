package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.fu;
import com.tencent.mapsdk.internal.gn;
import com.tencent.mapsdk.internal.gp;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TencentMapProtocol;
import com.tencent.tencentmap.mapsdk.maps.TencentMapResource;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class bp implements TencentMapContext {

    /* renamed from: i, reason: collision with root package name */
    private static final Map<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component> f147909i = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    private static final Set<a> f147910j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f147911k = "map-context.cache";

    /* renamed from: l, reason: collision with root package name */
    private static final String f147912l = "navi_marker_location.png";

    /* renamed from: m, reason: collision with root package name */
    private static final String f147913m = "color_texture_flat_style.png";

    /* renamed from: a, reason: collision with root package name */
    final Context f147914a;

    /* renamed from: b, reason: collision with root package name */
    public final TencentMapOptions f147915b;

    /* renamed from: c, reason: collision with root package name */
    public final bq f147916c;

    /* renamed from: d, reason: collision with root package name */
    gp f147917d;

    /* renamed from: e, reason: collision with root package name */
    public hi f147918e;

    /* renamed from: f, reason: collision with root package name */
    public go f147919f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f147920g = false;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f147921h = true;

    /* renamed from: n, reason: collision with root package name */
    private mz f147922n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Class<? extends TencentMapComponent.Component> f147923a;

        /* renamed from: b, reason: collision with root package name */
        Class<? extends TencentMapComponent.Component> f147924b;

        public a(Class<? extends TencentMapComponent.Component> cls, Class<? extends TencentMapComponent.Component> cls2) {
            this.f147923a = cls;
            this.f147924b = cls2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                Class<? extends TencentMapComponent.Component> cls = this.f147923a;
                if (cls == null ? aVar.f147923a != null : !cls.equals(aVar.f147923a)) {
                    return false;
                }
                Class<? extends TencentMapComponent.Component> cls2 = this.f147924b;
                Class<? extends TencentMapComponent.Component> cls3 = aVar.f147924b;
                if (cls2 != null) {
                    return cls2.equals(cls3);
                }
                if (cls3 == null) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i3;
            Class<? extends TencentMapComponent.Component> cls = this.f147923a;
            int i16 = 0;
            if (cls != null) {
                i3 = cls.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            Class<? extends TencentMapComponent.Component> cls2 = this.f147924b;
            if (cls2 != null) {
                i16 = cls2.hashCode();
            }
            return i17 + i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f147925a;

        /* renamed from: c, reason: collision with root package name */
        public String f147927c;

        /* renamed from: d, reason: collision with root package name */
        public String f147928d;

        /* renamed from: f, reason: collision with root package name */
        String f147930f;

        /* renamed from: b, reason: collision with root package name */
        public String f147926b = ho.m();

        /* renamed from: e, reason: collision with root package name */
        String f147929e = ho.n();

        b(TencentMapOptions tencentMapOptions) {
            this.f147930f = "undefined";
            this.f147925a = ho.a();
            if (tencentMapOptions != null) {
                if (!TextUtils.isEmpty(tencentMapOptions.getMapKey())) {
                    this.f147925a = tencentMapOptions.getMapKey();
                }
                if (!TextUtils.isEmpty(tencentMapOptions.getSubKey())) {
                    this.f147927c = tencentMapOptions.getSubKey();
                }
                if (!TextUtils.isEmpty(tencentMapOptions.getSubId())) {
                    this.f147928d = tencentMapOptions.getSubId();
                }
                this.f147930f = tencentMapOptions.getCustomUserId();
            }
        }

        private String d() {
            return this.f147925a;
        }

        private String e() {
            return this.f147926b;
        }

        private String f() {
            return this.f147927c;
        }

        private String g() {
            return this.f147928d;
        }

        private String h() {
            return this.f147929e;
        }

        private String i() {
            return this.f147930f;
        }

        private String j() {
            return this.f147925a + "-" + this.f147926b + "-" + this.f147927c + "-" + this.f147928d;
        }

        private String k() {
            return lj.a(a());
        }

        public final String a() {
            return this.f147929e + "-" + this.f147925a + "-" + this.f147926b + "-" + this.f147927c + "-" + this.f147928d;
        }

        public final String b() {
            if (TextUtils.isEmpty(this.f147927c)) {
                return this.f147925a;
            }
            return this.f147927c;
        }

        public final String c() {
            return lj.a(this.f147925a + "-" + this.f147926b + "-" + this.f147927c + "-" + this.f147928d);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f147910j = hashSet;
        hashSet.add(new a(TencentMapProtocol.class, cr.class));
        hashSet.add(new a(OfflineMapComponent.class, cc.class));
    }

    public bp(Context context, TencentMapOptions tencentMapOptions, bq bqVar) {
        this.f147914a = context.getApplicationContext();
        this.f147915b = tencentMapOptions;
        this.f147916c = bqVar;
        BitmapDescriptorFactory.attachMapContext(this);
        mw.a(tencentMapOptions);
    }

    private void a() {
        b D = D();
        ho.a(this.f147914a, D.f147925a, D.f147926b, D.f147930f);
        gp gpVar = new gp(this);
        this.f147917d = gpVar;
        if (gpVar.f148531a == 0) {
            gpVar.a(new gp.AnonymousClass1(new gp.AnonymousClass2()));
        }
        gpVar.f148531a++;
        long currentTimeMillis = System.currentTimeMillis();
        gp.e.a(gp.c.CREATE).f148566e = Long.valueOf(currentTimeMillis);
        this.f147918e = new hi(currentTimeMillis);
        gp gpVar2 = this.f147917d;
        String str = gpVar2.f148533c;
        String str2 = gpVar2.f148534d;
        String m3 = ho.m();
        String str3 = gpVar2.f148535e;
        String h16 = ho.h();
        String d16 = ho.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ho.j());
        this.f147919f = new go(new gn.b(str, str2, m3, str3, h16, d16, sb5.toString(), ho.k(), ho.n(), ho.c(), ho.g()));
        A();
    }

    private void b(boolean z16) {
        this.f147921h = z16;
    }

    private void c() {
        gp gpVar = new gp(this);
        this.f147917d = gpVar;
        if (gpVar.f148531a == 0) {
            gpVar.a(new gp.AnonymousClass1(new gp.AnonymousClass2()));
        }
        gpVar.f148531a++;
        this.f147918e = gp.a(System.currentTimeMillis());
        gp gpVar2 = this.f147917d;
        String str = gpVar2.f148533c;
        String str2 = gpVar2.f148534d;
        String m3 = ho.m();
        String str3 = gpVar2.f148535e;
        String h16 = ho.h();
        String d16 = ho.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ho.j());
        this.f147919f = new go(new gn.b(str, str2, m3, str3, h16, d16, sb5.toString(), ho.k(), ho.n(), ho.c(), ho.g()));
    }

    private hi d() {
        return this.f147918e;
    }

    private go e() {
        return this.f147919f;
    }

    private void f() {
        gp gpVar = this.f147917d;
        hi hiVar = this.f147918e;
        hiVar.f148660b = System.currentTimeMillis() - hiVar.f148659a;
        gpVar.a(hiVar, this.f147919f);
        Bundle bundle = new Bundle();
        if (bundle.size() > 0) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            kt.a(kt.b(kt.f149081d, f147911k), obtain.marshall());
            OaidMonitor.parcelRecycle(obtain);
        }
        B();
        BitmapDescriptorFactory.detachMapContext(this);
        ho.r();
    }

    private boolean g() {
        return this.f147920g;
    }

    private boolean h() {
        return this.f147921h;
    }

    private void i() {
        gp gpVar = this.f147917d;
        hi hiVar = this.f147918e;
        hiVar.f148660b = System.currentTimeMillis() - hiVar.f148659a;
        gpVar.a(hiVar, this.f147919f);
        Bundle bundle = new Bundle();
        if (bundle.size() > 0) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            kt.a(kt.b(kt.f149081d, f147911k), obtain.marshall());
            OaidMonitor.parcelRecycle(obtain);
        }
        B();
        BitmapDescriptorFactory.detachMapContext(this);
        ho.r();
    }

    private void j() {
        Iterator<Map.Entry<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component>> it = f147909i.entrySet().iterator();
        while (it.hasNext()) {
            TencentMapComponent.Component value = it.next().getValue();
            if (value instanceof bo) {
                ((bo) value).b(this);
            }
        }
    }

    private void k() {
        Iterator<Map.Entry<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component>> it = f147909i.entrySet().iterator();
        while (it.hasNext()) {
            TencentMapComponent.Component value = it.next().getValue();
            if (value instanceof bo) {
                ((bo) value).c(this);
            }
        }
    }

    private TencentMapProtocol l() {
        return (TencentMapProtocol) getMapComponent(TencentMapProtocol.class);
    }

    private TencentMapOptions n() {
        return this.f147915b;
    }

    private File o() {
        return C().c();
    }

    private OverSeaSource p() {
        return this.f147915b.getOverSeaSource();
    }

    private MapViewType q() {
        return this.f147915b.getMapViewType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle z() {
        byte[] c16;
        File file = new File(kt.f149081d, f147911k);
        if (file.exists() && (c16 = kt.c(file)) != null && c16.length > 0) {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(c16, 0, c16.length);
            Bundle bundle = new Bundle();
            bundle.readFromParcel(obtain);
            kt.b(file);
            OaidMonitor.parcelRecycle(obtain);
            return bundle;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void A() {
        Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> y16 = y();
        if (y16 != null) {
            for (Map.Entry<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> entry : y16.entrySet()) {
                f147910j.add(new a(entry.getKey(), entry.getValue()));
            }
        }
        for (a aVar : f147910j) {
            Class<? extends TencentMapComponent.Component> cls = aVar.f147923a;
            Map<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component> map = f147909i;
            TencentMapComponent.Component component = map.get(cls);
            Class<? extends TencentMapComponent.Component> cls2 = aVar.f147924b;
            if (component == null && cls2 != null && cls.isAssignableFrom(cls2)) {
                component = (TencentMapComponent.Component) hq.a(cls2, new Object[0]);
                if (component instanceof bo) {
                    ((bo) component).a(getContext());
                }
                map.put(cls, component);
            }
            if (component instanceof bo) {
                ((bo) component).a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B() {
        for (Map.Entry<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component> entry : f147909i.entrySet()) {
            TencentMapComponent.Component value = entry.getValue();
            if (value instanceof bo) {
                bo boVar = (bo) value;
                boVar.d(this);
                if (boVar.f147907a.size() == 0) {
                    f147909i.remove(entry.getKey());
                    boVar.b_();
                }
            }
        }
    }

    public final mz C() {
        if (this.f147922n == null) {
            this.f147922n = mz.a(this.f147914a, this.f147915b);
        }
        return this.f147922n;
    }

    public final b D() {
        return new b(this.f147915b);
    }

    public abstract String E();

    public abstract String F();

    public abstract String G();

    public abstract bu H();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(int i3, int i16) {
        fu fuVar = new fu(getContext(), i16);
        fuVar.f148352a = i3;
        return new BitmapDescriptor(fuVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapContext
    public final Context getContext() {
        return this.f147914a;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public MyLocationStyle getDefaultMyLocationStyle() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.icon(createBitmapDescriptor(f147912l, 2));
        return myLocationStyle;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapContext
    public TencentMapComponent getMapComponent() {
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public TencentMapServiceProtocol getMapServiceProtocol() {
        return (TencentMapServiceProtocol) getMapComponent(TencentMapProtocol.class);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public int getScreenPixels() {
        return ho.f();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public Typeface getTypeface() {
        return this.f147915b.getTypeface();
    }

    public abstract boolean m();

    public final ct u() {
        TencentMapProtocol l3 = l();
        if (l3 instanceof cr) {
            return ((cr) l3).e().f148048b;
        }
        return cr.f();
    }

    protected abstract void v();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w() {
        Iterator<Map.Entry<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component>> it = f147909i.entrySet().iterator();
        while (it.hasNext()) {
            TencentMapComponent.Component value = it.next().getValue();
            if (value instanceof bo) {
                ((bo) value).b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x() {
        Iterator<Map.Entry<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component>> it = f147909i.entrySet().iterator();
        while (it.hasNext()) {
            TencentMapComponent.Component value = it.next().getValue();
            if (value instanceof bo) {
                ((bo) value).c(this);
            }
        }
    }

    protected Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> y() {
        return null;
    }

    public final MapDelegate b() {
        return this.f147916c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public <T extends TencentMapComponent.Component> T getMapComponent(Class<T> cls) {
        T t16 = (T) f147909i.get(cls);
        if (t16 instanceof bo) {
            ((bo) t16).a(this, null);
        }
        return t16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(String str, int i3) {
        fu fuVar = new fu(getContext(), i3);
        if (i3 == 2) {
            fuVar.f148353b = str;
            return new BitmapDescriptor(fuVar);
        }
        if (i3 == 3) {
            fuVar.f148354c = str;
            return new BitmapDescriptor(fuVar);
        }
        if (i3 == 4) {
            fuVar.f148355d = str;
            return new BitmapDescriptor(fuVar);
        }
        if (i3 != 8) {
            return null;
        }
        fuVar.f148357f = str;
        return new BitmapDescriptor(fuVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(float f16, int i3) {
        fu fuVar = new fu(getContext(), i3);
        fuVar.f148356e = f16;
        return new BitmapDescriptor(fuVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(Parcelable parcelable, int i3) {
        fu fuVar = new fu(getContext(), i3);
        if (i3 == 9) {
            if (!(parcelable instanceof fu.a)) {
                return null;
            }
            fuVar.f148358g = (fu.a) parcelable;
            return new BitmapDescriptor(fuVar);
        }
        if (i3 == 7 && (parcelable instanceof Bitmap)) {
            return new BitmapDescriptor(fuVar.a((Bitmap) parcelable));
        }
        return null;
    }

    private void a(boolean z16) {
        this.f147920g = z16;
    }

    private static void a(Bundle bundle) {
        if (bundle.size() > 0) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            kt.a(kt.b(kt.f149081d, f147911k), obtain.marshall());
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapContext
    public TencentMapResource getMapResource() {
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(Bitmap bitmap, int i3) {
        return new BitmapDescriptor(new fu(getContext(), i3).a(bitmap));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(Bitmap[] bitmapArr, int i3) {
        fu fuVar = new fu(getContext(), i3);
        fuVar.f148359h = bitmapArr;
        fuVar.getBitmap(fuVar.f148360i);
        return new BitmapDescriptor(fuVar);
    }

    private <T extends TencentMapComponent.Component> T a(Class<T> cls) {
        T t16 = (T) f147909i.get(cls);
        if (t16 instanceof bo) {
            ((bo) t16).a(this, null);
        }
        return t16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(int i3) {
        fu fuVar = new fu(getContext(), i3);
        if (i3 == 5) {
            return new BitmapDescriptor(fuVar);
        }
        return null;
    }
}
