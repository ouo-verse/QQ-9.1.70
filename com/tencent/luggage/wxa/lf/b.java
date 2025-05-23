package com.tencent.luggage.wxa.lf;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.ml.o;
import com.tencent.luggage.wxa.tb.a;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.ub.c;
import com.tencent.luggage.wxa.ub.d;
import com.tencent.luggage.wxa.wb.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements a.c, Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f133347a;

    /* renamed from: b, reason: collision with root package name */
    public final List f133348b;

    /* renamed from: c, reason: collision with root package name */
    public final String f133349c;

    /* renamed from: d, reason: collision with root package name */
    public final int f133350d;

    /* renamed from: e, reason: collision with root package name */
    public a.InterfaceC6874a f133351e;

    /* renamed from: f, reason: collision with root package name */
    public c f133352f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.ub.d f133353g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.am.b f133354h;

    /* renamed from: i, reason: collision with root package name */
    public static final C6435b f133346i = new C6435b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lf.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6435b {
        public C6435b() {
        }

        public /* synthetic */ C6435b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(int i3, int i16, String str, com.tencent.luggage.wxa.sb.c cVar);

        void a(m mVar);

        void a(m mVar, o oVar);

        void a(String str, List list, com.tencent.luggage.wxa.sb.b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements d.o {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.ub.d.o
        public void a(Context context, boolean z16) {
            String string;
            Intrinsics.checkNotNullParameter(context, "context");
            if (z16) {
                string = z.j().getString(R.string.f229736x9);
            } else {
                string = z.j().getString(R.string.f229766xb);
            }
            Intrinsics.checkNotNullExpressionValue(string, "if(isCheck) MMApplicatio\u2026orce_notify_cancel_toast)");
            com.tencent.luggage.wxa.am.b f16 = b.this.f();
            if (f16 != null) {
                f16.dismiss();
            }
            b bVar = b.this;
            com.tencent.luggage.wxa.am.b bVar2 = new com.tencent.luggage.wxa.am.b(context, false);
            bVar2.a(string);
            bVar2.setFocusable(false);
            com.tencent.luggage.wxa.am.b.a(bVar2, 0L, 1, null);
            bVar.a(bVar2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f133375a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(List list) {
            super(1);
            this.f133375a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(com.tencent.luggage.wxa.sb.d item) {
            Object obj;
            boolean z16;
            Intrinsics.checkNotNullParameter(item, "item");
            Iterator it = this.f133375a.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (TextUtils.equals(item.f(), ((d.j) obj).c())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            d.j jVar = (d.j) obj;
            if (jVar != null) {
                z16 = jVar.a();
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements o {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ub.c f133377b;

        public g(com.tencent.luggage.wxa.ub.c cVar) {
            this.f133377b = cVar;
        }

        @Override // com.tencent.luggage.wxa.ml.o
        public void a(m mVar) {
            c b16 = b.this.b();
            if (b16 != null) {
                b16.a(this.f133377b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements c.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ub.d f133379b;

        public h(com.tencent.luggage.wxa.ub.d dVar) {
            this.f133379b = dVar;
        }

        @Override // com.tencent.luggage.wxa.ub.c.b
        public void onDismiss() {
            c b16 = b.this.b();
            if (b16 != null) {
                b16.a(this.f133379b);
            }
        }
    }

    public b(String str, List list, String str2, int i3) {
        this.f133347a = str;
        this.f133348b = list;
        this.f133349c = str2;
        this.f133350d = i3;
        this.f133351e = com.tencent.luggage.wxa.lf.a.f133339a;
    }

    public final d.o c() {
        return new e();
    }

    public final com.tencent.luggage.wxa.ub.d d() {
        com.tencent.luggage.wxa.ub.d dVar = this.f133353g;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscribeMsgRequestDialog");
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List e() {
        return this.f133348b;
    }

    public final com.tencent.luggage.wxa.am.b f() {
        return this.f133354h;
    }

    public void g() {
        a.C6747a.f141209a.a(this.f133347a, this.f133348b, this).a(a());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f133347a);
        dest.writeStringList(this.f133348b);
        dest.writeString(this.f133349c);
        dest.writeInt(this.f133350d);
    }

    public final c b() {
        return this.f133352f;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Parcel parcel) {
        this(r0, r2, r3 != null ? r3 : "", parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        List createStringArrayList = parcel.createStringArrayList();
        createStringArrayList = createStringArrayList == null ? CollectionsKt__CollectionsKt.emptyList() : createStringArrayList;
        String readString2 = parcel.readString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String username, List tmplIds, c eventListener, String appid, int i3) {
        this(username, tmplIds, appid, i3);
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(tmplIds, "tmplIds");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(appid, "appid");
        this.f133352f = eventListener;
    }

    public a.InterfaceC6874a a() {
        return this.f133351e;
    }

    public void a(a.InterfaceC6874a interfaceC6874a) {
        Intrinsics.checkNotNullParameter(interfaceC6874a, "<set-?>");
        this.f133351e = interfaceC6874a;
    }

    public final void a(c cVar) {
        this.f133352f = cVar;
    }

    public final void a(com.tencent.luggage.wxa.ub.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.f133353g = dVar;
    }

    public final void a(com.tencent.luggage.wxa.am.b bVar) {
        this.f133354h = bVar;
    }

    public void a(Context context, com.tencent.luggage.wxa.sb.c result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.i().size() == 0) {
            c cVar = this.f133352f;
            if (cVar != null) {
                e31.a.a(cVar, this.f133347a, result.i(), null, 4, null);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = result.i().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.luggage.wxa.sb.d dVar = (com.tencent.luggage.wxa.sb.d) it.next();
            if (dVar.m()) {
                arrayList.add(new d.m(dVar.c() == 1, dVar.i(), dVar.d(), dVar.f(), dVar.a(), dVar.g()));
            } else if (dVar.o()) {
                arrayList.add(new d.l(dVar.c() == 1, dVar.i(), dVar.d(), dVar.f(), dVar.l(), dVar.g()));
            } else {
                arrayList.add(new d.j(dVar.c() == 1, dVar.i(), dVar.d(), dVar.f(), dVar.g()));
            }
        }
        boolean z16 = result.g() == 1;
        if (z16) {
            ((d.j) arrayList.get(0)).b(true);
        }
        c0.a(new d(context, arrayList, this, z16, arrayList.size() == 1 && (arrayList.get(0) instanceof d.m), result, ((com.tencent.luggage.wxa.sb.d) result.i().get(0)).g(), new LinkedHashMap()));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f133355a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f133356b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f133357c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f133358d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f133359e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.sb.c f133360f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f133361g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Map f133362h;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lf.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6436b implements d.h.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.sb.c f133370a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map f133371b;

            public C6436b(com.tencent.luggage.wxa.sb.c cVar, Map map) {
                this.f133370a = cVar;
                this.f133371b = map;
            }

            @Override // com.tencent.luggage.wxa.ub.d.h.a
            public void a(String templateId, boolean z16, int i3) {
                Object obj;
                int i16;
                Intrinsics.checkNotNullParameter(templateId, "templateId");
                Iterator it = this.f133370a.i().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (TextUtils.equals(((com.tencent.luggage.wxa.sb.d) obj).f(), templateId)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (((com.tencent.luggage.wxa.sb.d) obj) != null) {
                    Map map = this.f133371b;
                    Integer valueOf = Integer.valueOf(i3);
                    Integer num = (Integer) map.get(Integer.valueOf(i3));
                    if (num != null) {
                        i16 = num.intValue();
                    } else {
                        i16 = 0;
                    }
                    map.put(valueOf, Integer.valueOf(i16 + 1));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function3 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f133372a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.sb.c f133373b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, com.tencent.luggage.wxa.sb.c cVar) {
                super(3);
                this.f133372a = bVar;
                this.f133373b = cVar;
            }

            public final void a(int i3, List items, boolean z16) {
                Intrinsics.checkNotNullParameter(items, "items");
                com.tencent.luggage.wxa.sb.b a16 = com.tencent.luggage.wxa.sb.b.f140224d.a(i3, items, z16);
                c b16 = this.f133372a.b();
                if (b16 != null) {
                    b16.a(this.f133372a.f133347a, this.f133373b.i(), a16);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                a(((Number) obj).intValue(), (List) obj2, ((Boolean) obj3).booleanValue());
                return Unit.INSTANCE;
            }
        }

        public d(Context context, List list, b bVar, boolean z16, boolean z17, com.tencent.luggage.wxa.sb.c cVar, int i3, Map map) {
            this.f133355a = context;
            this.f133356b = list;
            this.f133357c = bVar;
            this.f133358d = z16;
            this.f133359e = z17;
            this.f133360f = cVar;
            this.f133361g = i3;
            this.f133362h = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String a16;
            c cVar = new c(this.f133357c, this.f133360f);
            if (this.f133355a instanceof Application) {
                cVar.invoke(2, this.f133356b, Boolean.FALSE);
                w.f("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
                return;
            }
            b bVar = this.f133357c;
            Context context = this.f133355a;
            List list = this.f133356b;
            bVar.a(new com.tencent.luggage.wxa.ub.d(context, list, new a(this.f133359e, cVar, this.f133357c, this.f133362h, list, this.f133360f, context), this.f133358d, this.f133359e, this.f133357c.c()));
            com.tencent.luggage.wxa.ub.d d16 = this.f133357c.d();
            String e16 = this.f133360f.e();
            String str = "";
            if (e16 == null) {
                e16 = "";
            }
            d16.e(e16);
            com.tencent.luggage.wxa.ub.d d17 = this.f133357c.d();
            String h16 = this.f133360f.h();
            if (h16 == null) {
                h16 = "";
            }
            d17.i(h16);
            this.f133357c.d().c(this.f133360f.c());
            com.tencent.luggage.wxa.ub.d d18 = this.f133357c.d();
            com.tencent.luggage.wxa.sb.e j3 = this.f133360f.j();
            if (j3 != null && (a16 = j3.a()) != null) {
                str = a16;
            }
            d18.h(str);
            this.f133357c.d().f(this.f133360f.b());
            com.tencent.luggage.wxa.ub.d d19 = this.f133357c.d();
            com.tencent.luggage.wxa.sb.e j16 = this.f133360f.j();
            Intrinsics.checkNotNull(j16);
            d19.a(j16.e());
            com.tencent.luggage.wxa.ub.d d26 = this.f133357c.d();
            com.tencent.luggage.wxa.sb.e j17 = this.f133360f.j();
            Intrinsics.checkNotNull(j17);
            d26.g(j17.b());
            com.tencent.luggage.wxa.ub.d d27 = this.f133357c.d();
            com.tencent.luggage.wxa.sb.e j18 = this.f133360f.j();
            Intrinsics.checkNotNull(j18);
            d27.d(j18.d());
            this.f133357c.d().e(R.drawable.ojy);
            if (this.f133361g == 2) {
                com.tencent.luggage.wxa.ub.d d28 = this.f133357c.d();
                com.tencent.luggage.wxa.sb.e j19 = this.f133360f.j();
                Intrinsics.checkNotNull(j19);
                d28.b(j19.c());
                this.f133357c.d().a(this.f133360f.a());
            }
            this.f133357c.d().b(false);
            this.f133357c.d().a(new C6436b(this.f133360f, this.f133362h));
            c b16 = this.f133357c.b();
            if (b16 != null) {
                b16.a(this.f133357c.d());
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements d.n {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f133363a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function3 f133364b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f133365c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map f133366d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ List f133367e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.sb.c f133368f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Context f133369g;

            public a(boolean z16, Function3 function3, b bVar, Map map, List list, com.tencent.luggage.wxa.sb.c cVar, Context context) {
                this.f133363a = z16;
                this.f133364b = function3;
                this.f133365c = bVar;
                this.f133366d = map;
                this.f133367e = list;
                this.f133368f = cVar;
                this.f133369g = context;
            }

            @Override // com.tencent.luggage.wxa.ub.d.n
            public void a(int i3, List resultData) {
                List list;
                String joinToString$default;
                String joinToString$default2;
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(resultData);
                int i16 = 3;
                if (i3 == 1 || i3 == 2 || i3 == 3) {
                    if (this.f133363a) {
                        this.f133364b.invoke(Integer.valueOf(i3 == 2 ? 3 : i3), arrayList, Boolean.valueOf(this.f133365c.d().d()));
                    } else {
                        this.f133364b.invoke(Integer.valueOf(i3), arrayList, Boolean.valueOf(this.f133365c.d().d()));
                    }
                }
                list = CollectionsKt___CollectionsKt.toList(this.f133366d.keySet());
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) this.f133366d.get(Integer.valueOf(((Number) it.next()).intValue()));
                    if (num != null) {
                        arrayList2.add(Integer.valueOf(num.intValue()));
                    }
                }
                b bVar = this.f133365c;
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f133368f.i());
                Unit unit = Unit.INSTANCE;
                List a16 = bVar.a(arrayList3, this.f133367e);
                boolean d16 = this.f133365c.d().d();
                if (i3 == 1) {
                    i16 = 1;
                } else if (i3 == 2) {
                    i16 = 2;
                } else if (i3 != 3) {
                    i16 = 0;
                }
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, "#", null, null, 0, null, null, 62, null);
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, "#", null, null, 0, null, null, 62, null);
                bVar.a(a16, d16, i16, joinToString$default, joinToString$default2);
            }

            @Override // com.tencent.luggage.wxa.ub.d.n
            public void a(com.tencent.luggage.wxa.ub.e eVar, boolean z16, d.j item, boolean z17) {
                Intrinsics.checkNotNullParameter(eVar, "switch");
                Intrinsics.checkNotNullParameter(item, "item");
                if (eVar == com.tencent.luggage.wxa.ub.e.SWITCH_FORCE_NOTIFY && z16 && z17) {
                    b bVar = this.f133365c;
                    bVar.a(this.f133369g, bVar.d());
                }
            }
        }
    }

    public final List a(List list, List list2) {
        return a(list, new f(list2));
    }

    public final List a(List list, Function1 function1) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.sb.d dVar = (com.tencent.luggage.wxa.sb.d) it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, String.valueOf(dVar.g()));
            linkedHashMap.put("selected", String.valueOf(((Boolean) function1.invoke(dVar)).booleanValue()));
            linkedHashMap.put("templateID", dVar.f());
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    public final void a(List list, boolean z16, int i3, String str, String str2) {
        com.tencent.luggage.wxa.zj.d dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
        if (dVar != null) {
            dVar.a(17524, -1, Uri.encode(new JSONArray((Collection) list).toString()), Integer.valueOf(i3), Integer.valueOf(z16 ? 1 : 0), -1, -1, this.f133347a, "", str, str2, 1, "", this.f133349c, Integer.valueOf(this.f133350d + 1000));
        }
    }

    @Override // com.tencent.luggage.wxa.tb.a.c
    public void a(int i3, int i16, String errMsg, com.tencent.luggage.wxa.sb.c cVar) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        c cVar2 = this.f133352f;
        if (cVar2 != null) {
            cVar2.a(i3, i16, errMsg, cVar);
        }
    }

    public final void a(Context context, com.tencent.luggage.wxa.ub.d dVar) {
        if (context == null) {
            return;
        }
        com.tencent.luggage.wxa.ub.c cVar = new com.tencent.luggage.wxa.ub.c(context);
        if (f0.e().getBoolean("appbrand_subscribe_msg_force_notify_template_show_guide", false)) {
            return;
        }
        c cVar2 = this.f133352f;
        if (cVar2 != null) {
            cVar2.a(dVar, new g(cVar));
        }
        cVar.a(new h(dVar));
        f0.e().putBoolean("appbrand_subscribe_msg_force_notify_template_show_guide", true);
    }
}
