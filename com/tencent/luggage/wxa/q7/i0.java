package com.tencent.luggage.wxa.q7;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.luggage.wxa.s3.h;
import com.tencent.mars.ilink.comm.NetStatusUtil;
import cooperation.qzone.util.WnsError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f138000a = new i0();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f138001b;

    /* renamed from: c, reason: collision with root package name */
    public static Function1 f138002c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.cp.a0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f138003a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f138004b;

        public a(String str, List list) {
            this.f138003a = str;
            this.f138004b = list;
        }

        @Override // com.tencent.luggage.wxa.cp.a0
        public final boolean a(com.tencent.luggage.wxa.cp.v vVar, String filename) {
            boolean contains$default;
            int lastIndexOf$default;
            String replace$default;
            String replace$default2;
            boolean endsWith$default;
            Intrinsics.checkNotNullParameter(filename, "filename");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) filename, (CharSequence) "_", false, 2, (Object) null);
            if (contains$default) {
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filename, "_", 0, false, 6, (Object) null);
                String substring = filename.substring(lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                replace$default = StringsKt__StringsJVMKt.replace$default(substring, "_", "", false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, this.f138003a, "", false, 4, (Object) null);
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(filename, this.f138003a, false, 2, null);
                if (!endsWith$default || !this.f138004b.contains(replace$default2)) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f138005a = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements h.a {
            @Override // com.tencent.luggage.wxa.s3.h.a
            public /* synthetic */ void onAllResourceNeedRecreate() {
                b41.a.a(this);
            }

            @Override // com.tencent.luggage.wxa.s3.h.a
            public void onUploadLogComplete(int i3) {
                com.tencent.luggage.wxa.tn.w.d("XLogUploadLogic", "onUploadLogComplete, code: " + i3);
                Function1 b16 = i0.f138000a.b();
                if (b16 != null) {
                    b16.invoke(Integer.valueOf(i3));
                }
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.s3.h invoke() {
            com.tencent.luggage.wxa.s3.h i3 = com.tencent.luggage.wxa.s3.h.i();
            i3.a(new a());
            return i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "it", "a", "(Lcom/tencent/luggage/wxa/va/e;)Lcom/tencent/luggage/wxa/va/e;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class c<InputType, ResultType> implements com.tencent.luggage.wxa.ka.r {

        /* renamed from: a, reason: collision with root package name */
        public static final c f138006a = new c();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.e invoke(com.tencent.luggage.wxa.va.e eVar) {
            com.tencent.luggage.wxa.tn.w.c();
            return com.tencent.luggage.wxa.va.e.f143316a;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(b.f138005a);
        f138001b = lazy;
    }

    public final com.tencent.luggage.wxa.s3.h a() {
        Object value = f138001b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDevice>(...)");
        return (com.tencent.luggage.wxa.s3.h) value;
    }

    public final Function1 b() {
        return f138002c;
    }

    public final void a(Function1 function1) {
        f138002c = function1;
    }

    public final List b(int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        com.tencent.luggage.wxa.cp.v[] a16 = new com.tencent.luggage.wxa.cp.v(h0.f137982b).a(new a(".xlog", a(i3, i16)));
        if (a16 == null) {
            a16 = new com.tencent.luggage.wxa.cp.v[0];
        }
        for (com.tencent.luggage.wxa.cp.v vVar : a16) {
            if (vVar != null && vVar.e()) {
                arrayList.add(vVar.g());
            }
        }
        return arrayList;
    }

    public final void a(com.tencent.luggage.wxa.n3.y yVar) {
        com.tencent.luggage.wxa.n3.t tVar;
        String str;
        com.tencent.luggage.wxa.tn.w.d("XLogUploadLogic", "pre uploadXLogFile");
        if (yVar == null) {
            return;
        }
        int netWorkType = NetStatusUtil.getNetWorkType(com.tencent.luggage.wxa.tn.z.c());
        if (yVar.g() == 0 && netWorkType != -1 && netWorkType != 1 && netWorkType != 9) {
            com.tencent.luggage.wxa.tn.w.a("XLogUploadLogic", "OnLocalRequestUploadLogfiles nettype not match:" + netWorkType);
            Function1 function1 = f138002c;
            if (function1 != null) {
                function1.invoke(-101);
                return;
            }
            return;
        }
        for (String str2 : com.tencent.luggage.wxa.v7.h.f143309k.a().j()) {
            if (com.tencent.luggage.wxa.tn.z.d(str2)) {
                com.tencent.luggage.wxa.ka.o.a(str2, com.tencent.luggage.wxa.va.e.f143316a, c.f138006a.getClass());
            }
        }
        try {
            tVar = com.tencent.luggage.wxa.x7.a.f144602d.k();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("XLogUploadLogic", "uploadXLogFile, get tdiSession, exception=" + e16);
            tVar = null;
        }
        String f16 = yVar.f();
        List b16 = b(yVar.e(), yVar.a());
        boolean d16 = yVar.d();
        String b17 = yVar.b();
        String c16 = yVar.c();
        long uin = tVar != null ? tVar.getUin() : 0L;
        if (tVar == null || (str = tVar.getUsername()) == null) {
            str = "";
        }
        a().a(new com.tencent.luggage.wxa.s3.d(f16, "Android", WnsError.WNS_CODE_LOGIN_PTLOGIN_BUSY, uin, str, b16, c16, d16, b17));
    }

    public final List a(int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        long j3 = i16 * 1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.ENGLISH);
        for (long j16 = i3 * 1000; j16 < j3 + 86400000; j16 += 86400000) {
            arrayList.add(simpleDateFormat.format(Long.valueOf(j16)));
        }
        return arrayList;
    }
}
