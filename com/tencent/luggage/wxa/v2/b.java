package com.tencent.luggage.wxa.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.mo.p;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.v2.a;
import com.tencent.luggage.wxa.x0.b;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: j, reason: collision with root package name */
    public static final a f142956j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.d f142957a;

    /* renamed from: b, reason: collision with root package name */
    public final int f142958b;

    /* renamed from: c, reason: collision with root package name */
    public final int f142959c;

    /* renamed from: d, reason: collision with root package name */
    public final int f142960d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f142961e;

    /* renamed from: f, reason: collision with root package name */
    public final int f142962f;

    /* renamed from: g, reason: collision with root package name */
    public final int f142963g;

    /* renamed from: h, reason: collision with root package name */
    public final int f142964h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f142965i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.v2.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6813b implements com.tencent.luggage.wxa.uo.b {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v2.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a implements LuggageActivityHelper.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f142967a;

            public a(com.tencent.luggage.wxa.xo.b bVar) {
                this.f142967a = bVar;
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public final void a(int i3, Intent intent) {
                int collectionSizeOrDefault;
                if (intent == null || i3 == 0) {
                    this.f142967a.a(a.C6812a.f142952b);
                }
                List a16 = com.tencent.luggage.wxa.x0.b.a(intent);
                if (a16 == null) {
                    this.f142967a.a(new a.c("no selected image data"));
                    return;
                }
                com.tencent.luggage.wxa.xo.b bVar = this.f142967a;
                Object[] objArr = new Object[1];
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = a16.iterator();
                while (it.hasNext()) {
                    arrayList.add(new v(((com.tencent.luggage.wxa.f1.b) it.next()).b()));
                }
                objArr[0] = new a.d(arrayList, 1);
                bVar.a(objArr);
            }
        }

        public C6813b() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.v2.a call(Void r46) {
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            Activity h16 = com.tencent.luggage.wxa.po.b.h(b.this.f142957a.getContext());
            b.a a16 = com.tencent.luggage.wxa.x0.b.a(h16);
            a16.a(b.this.f142963g);
            a16.b(true);
            a16.a(false);
            a16.c(false);
            LuggageActivityHelper.FOR(h16).startActivityForResult(a16.a((Context) h16), new a(b16));
            return a.C6812a.f142952b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.uo.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h call(Void r75) {
            int i3;
            int i16 = b.this.f142960d;
            if (i16 == com.tencent.luggage.wxa.v2.f.VIDEO.a()) {
                i3 = 1;
            } else if (i16 == com.tencent.luggage.wxa.v2.f.IMAGE.a()) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            b bVar = b.this;
            h a16 = bVar.a(i3, bVar.f142962f, com.tencent.luggage.wxa.v2.d.FRONT.a(b.this.f142959c));
            a16.b(false);
            a16.c(true);
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.uo.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements LuggageActivityHelper.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f142970a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f142971b;

            public a(h hVar, com.tencent.luggage.wxa.xo.b bVar) {
                this.f142970a = hVar;
                this.f142971b = bVar;
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public final void a(int i3, Intent intent) {
                List listOf;
                if ((intent == null && !x.d(this.f142970a.a())) || i3 == 0) {
                    this.f142971b.a(a.C6812a.f142952b);
                    return;
                }
                com.tencent.luggage.wxa.xo.b bVar = this.f142971b;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new v(this.f142970a.a()));
                bVar.a(new a.d(listOf, 2));
            }
        }

        public d() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.v2.a call(h hVar) {
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            Activity h16 = com.tencent.luggage.wxa.po.b.h(b.this.f142957a.getContext());
            LuggageActivityHelper.FOR(h16).startActivityForResult(com.tencent.luggage.wxa.u2.c.a(h16, hVar.a(), b.this.f142962f, 0, 1, com.tencent.luggage.wxa.v2.d.FRONT.a(b.this.f142959c)), new a(hVar, b16));
            return a.C6812a.f142952b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f142972b;

        public e(Function1 function1) {
            this.f142972b = function1;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public final /* synthetic */ Object call(Object obj) {
            return this.f142972b.invoke(obj);
        }
    }

    public b(com.tencent.luggage.wxa.xd.d mComponent, int i3, int i16, int i17, boolean z16, int i18, int i19) {
        Intrinsics.checkNotNullParameter(mComponent, "mComponent");
        this.f142957a = mComponent;
        this.f142958b = i3;
        this.f142959c = i16;
        this.f142960d = i17;
        this.f142961e = z16;
        this.f142962f = Math.min(Math.max(i18, 1), 60);
        this.f142963g = Math.min(Math.max(i19, 1), 9);
        this.f142964h = 200;
    }

    public final com.tencent.luggage.wxa.xo.d b() {
        if (!(w0.a(this.f142957a.getContext()) > ((long) this.f142964h))) {
            Toast.makeText(this.f142957a.getContext(), this.f142957a.getContext().getString(R.string.yxf), 1).show();
        }
        com.tencent.luggage.wxa.xo.d a16 = com.tencent.luggage.wxa.xo.h.c().d(new c()).a(new d());
        Intrinsics.checkNotNullExpressionValue(a16, "private fun goSightCaptu\u2026.CANCELED\n        }\n    }");
        return a16;
    }

    public final com.tencent.luggage.wxa.xo.d c() {
        com.tencent.luggage.wxa.xo.d a16 = com.tencent.luggage.wxa.xo.h.c().a(new f()).a(new g());
        Intrinsics.checkNotNullExpressionValue(a16, "fun startChoose(): Pipea\u2026D\n                }\n    }");
        return a16;
    }

    public final com.tencent.luggage.wxa.xo.d a() {
        com.tencent.luggage.wxa.xo.d a16 = com.tencent.luggage.wxa.xo.h.c().a(new C6813b());
        Intrinsics.checkNotNullExpressionValue(a16, "private fun goAlbumUI():\u2026ANCELED\n\n\n        }\n    }");
        return a16;
    }

    public final h a(int i3, int i16, boolean z16) {
        String str = "microMsg_" + w0.c();
        StringBuilder sb5 = new StringBuilder();
        String DATAROOT_SDCARD_CAMERA_PATH = com.tencent.luggage.wxa.db.a.f124169b;
        sb5.append(DATAROOT_SDCARD_CAMERA_PATH);
        sb5.append("microMsg.");
        sb5.append(str);
        sb5.append(".mp4");
        String sb6 = sb5.toString();
        String str2 = DATAROOT_SDCARD_CAMERA_PATH + "microMsg." + str + ".jpeg";
        if (i3 == 2) {
            h hVar = new h(3, 2);
            Intrinsics.checkNotNullExpressionValue(DATAROOT_SDCARD_CAMERA_PATH, "DATAROOT_SDCARD_CAMERA_PATH");
            hVar.b(DATAROOT_SDCARD_CAMERA_PATH);
            hVar.a("microMsg." + System.currentTimeMillis() + ".jpg");
            return hVar;
        }
        h hVar2 = new h(3, 1);
        hVar2.a(z16 ? 1 : 2);
        hVar2.b(i3);
        if (hVar2.b() == null) {
            hVar2.a(new j());
        }
        j b16 = hVar2.b();
        Intrinsics.checkNotNull(b16);
        b16.f143040e = i16;
        hVar2.a(false);
        hVar2.a(str, sb6, str2, com.tencent.luggage.wxa.bo.b.a() + "capture" + w0.c() + ".jpg");
        return hVar2;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements com.tencent.luggage.wxa.uo.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements MMBottomSheet.CancelBtnCallBack {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f142977a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f142978b;

            public a(b bVar, com.tencent.luggage.wxa.xo.b bVar2) {
                this.f142977a = bVar;
                this.f142978b = bVar2;
            }

            @Override // com.tencent.mm.ui.widget.dialog.MMBottomSheet.CancelBtnCallBack
            public final void onClick() {
                this.f142977a.f142965i = true;
                this.f142978b.a(a.C6812a.f142952b);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v2.b$g$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6814b implements p {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f142979a;

            public C6814b(b bVar) {
                this.f142979a = bVar;
            }

            @Override // com.tencent.luggage.wxa.mo.p
            public final void a(com.tencent.luggage.wxa.mo.h hVar) {
                hVar.add(0, 1, 0, this.f142979a.f142957a.getContext().getString(R.string.f170377z22));
                hVar.add(0, 2, 1, this.f142979a.f142957a.getContext().getString(R.string.f170378z23));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c implements u {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f142980a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f142981b;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function1 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f142982a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(com.tencent.luggage.wxa.xo.b bVar) {
                    super(1);
                    this.f142982a = bVar;
                }

                public final void a(com.tencent.luggage.wxa.v2.a aVar) {
                    this.f142982a.a(aVar);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((com.tencent.luggage.wxa.v2.a) obj);
                    return Unit.INSTANCE;
                }
            }

            public c(b bVar, com.tencent.luggage.wxa.xo.b bVar2) {
                this.f142980a = bVar;
                this.f142981b = bVar2;
            }

            @Override // com.tencent.luggage.wxa.mo.u
            public final void a(MenuItem menuItem, int i3) {
                com.tencent.luggage.wxa.xo.d b16;
                this.f142980a.f142965i = true;
                int itemId = menuItem.getItemId();
                if (itemId == 1) {
                    b16 = this.f142980a.b();
                } else {
                    b16 = itemId != 2 ? com.tencent.luggage.wxa.xo.h.a(a.C6812a.f142952b) : this.f142980a.a();
                }
                b16.a(new e(new a(this.f142981b)));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements MMBottomSheet.IDismissCallBack {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f142983a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f142984b;

            public d(b bVar, com.tencent.luggage.wxa.xo.b bVar2) {
                this.f142983a = bVar;
                this.f142984b = bVar2;
            }

            @Override // com.tencent.mm.ui.widget.dialog.MMBottomSheet.IDismissCallBack
            public final void onDismiss() {
                if (!this.f142983a.f142965i) {
                    this.f142984b.a(a.C6812a.f142952b);
                }
            }
        }

        public g() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.v2.a call(Boolean bool) {
            Activity h16 = com.tencent.luggage.wxa.po.b.h(b.this.f142957a.getContext());
            if (h16 != null) {
                if (com.tencent.luggage.wxa.v2.g.CAMERA.a(b.this.f142958b)) {
                    com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) b.this.b());
                } else if (com.tencent.luggage.wxa.v2.g.ALBUM.a(b.this.f142958b)) {
                    com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) b.this.a());
                } else {
                    com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
                    MMBottomSheet mMBottomSheet = new MMBottomSheet((Context) h16, 1, false);
                    b bVar = b.this;
                    mMBottomSheet.setCancelBtnClickListener(new a(bVar, b16));
                    mMBottomSheet.setOnCreateMenuListener(new C6814b(bVar));
                    mMBottomSheet.setOnMenuSelectedListener(new c(bVar, b16));
                    mMBottomSheet.setOnBottomSheetDismissListener(new d(bVar, b16));
                    mMBottomSheet.tryShow();
                }
                return a.C6812a.f142952b;
            }
            return a();
        }

        public static final a.C6812a a() {
            w.b("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:startActivityForResult, context !is Activity");
            com.tencent.luggage.wxa.xo.h.a().a(new IllegalStateException("fail:internal error invalid android context"));
            return a.C6812a.f142952b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements com.tencent.luggage.wxa.uo.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements LuggageActivityHelper.h {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f142974a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ArrayList f142975b;

            public a(com.tencent.luggage.wxa.xo.b bVar, ArrayList arrayList) {
                this.f142974a = bVar;
                this.f142975b = arrayList;
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.h
            public final void a(String[] strArr, int[] grantResults) {
                Intrinsics.checkNotNullExpressionValue(grantResults, "grantResults");
                com.tencent.luggage.wxa.xo.b bVar = this.f142974a;
                ArrayList arrayList = this.f142975b;
                int length = grantResults.length;
                int i3 = 0;
                int i16 = 0;
                while (i3 < length) {
                    int i17 = i16 + 1;
                    if (grantResults[i3] != 0) {
                        bVar.a(new IllegalAccessException("fail:system permission denied"));
                        w.b("MicroMsg.AppBrand.ChooseMediaWorkFlow", "interrupt pipeline, " + ((String) arrayList.get(i16)) + " denied by user");
                        return;
                    }
                    i3++;
                    i16 = i17;
                }
                this.f142974a.a(Boolean.TRUE);
            }
        }

        public f() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean call(Void r56) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            arrayList.add(QQPermissionConstants.Permission.RECORD_AUDIO);
            arrayList.add(QQPermissionConstants.Permission.CAMERA);
            Iterator it = arrayList.iterator();
            b bVar = b.this;
            while (it.hasNext()) {
                if (k.a(bVar.f142957a.getContext(), (String) it.next())) {
                    it.remove();
                }
            }
            if (!arrayList.isEmpty()) {
                Activity h16 = com.tencent.luggage.wxa.po.b.h(b.this.f142957a.getContext());
                if (h16 == null) {
                    return Boolean.valueOf(a());
                }
                com.tencent.luggage.wxa.xo.b a16 = com.tencent.luggage.wxa.xo.h.a();
                a16.b();
                LuggageActivityHelper FOR = LuggageActivityHelper.FOR(h16);
                Object[] array = arrayList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                FOR.requestPermissions((String[]) array, new a(a16, arrayList));
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }

        public static final boolean a() {
            w.b("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:requestPermission, context !is Activity");
            com.tencent.luggage.wxa.xo.h.a().a(new IllegalStateException("fail:internal error invalid android context"));
            return false;
        }
    }
}
