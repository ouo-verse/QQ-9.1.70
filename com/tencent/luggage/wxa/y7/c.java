package com.tencent.luggage.wxa.y7;

import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.h6.e;
import com.tencent.luggage.wxa.mc.i0;
import com.tencent.luggage.wxa.mc.o;
import com.tencent.luggage.wxa.mc.r;
import com.tencent.luggage.wxa.n3.m0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.h;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeoutException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f145448a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final String f145449b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f145450a = new a();

        public final Object a(String str, String str2, Function1 function1, Continuation continuation) {
            return e.f126875a.a(str, str2, function1, continuation);
        }

        public final String a(r key, com.tencent.luggage.wxa.mc.d record) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(record, "record");
            String a16 = m0.a(key.b(), key.c(), record instanceof i0 ? ((i0) record).Z.hashCode() : record.f138307d, record.f138309f, record.f138319p);
            Intrinsics.checkNotNullExpressionValue(a16, "getPath(appId, moduleNam\u2026ersion, md5, versionType)");
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends IOException {
        public b() {
            super("file corrupt");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.y7.c$c, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6944c extends RuntimeException {

        /* renamed from: a, reason: collision with root package name */
        public final String f145451a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6944c(String downloadUrl) {
            super("server file not found " + downloadUrl);
            Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
            this.f145451a = downloadUrl;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f145452a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f145453b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f145454c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.mc.d f145455d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.y7.b f145456e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f145457f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ o f145458g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Function1 f145459h;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f145460a;

            /* renamed from: b, reason: collision with root package name */
            public Object f145461b;

            /* renamed from: c, reason: collision with root package name */
            public int f145462c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f145463d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f145464e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ r f145465f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.mc.d f145466g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.y7.b f145467h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ String f145468i;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ o f145469j;

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ Function1 f145470k;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.y7.c$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public static final class C6945a extends SuspendLambda implements Function2 {

                /* renamed from: a, reason: collision with root package name */
                public int f145471a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f145472b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f145473c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ Function1 f145474d;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.y7.c$d$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public static final class C6946a extends SuspendLambda implements Function2 {

                    /* renamed from: a, reason: collision with root package name */
                    public int f145475a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ String f145476b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ String f145477c;

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ Function1 f145478d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C6946a(String str, String str2, Function1 function1, Continuation continuation) {
                        super(2, continuation);
                        this.f145476b = str;
                        this.f145477c = str2;
                        this.f145478d = function1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((C6946a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new C6946a(this.f145476b, this.f145477c, this.f145478d, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.f145475a;
                        try {
                            if (i3 != 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                x.c(this.f145476b);
                                a aVar = a.f145450a;
                                String str = this.f145477c;
                                String str2 = this.f145476b;
                                Function1 function1 = this.f145478d;
                                this.f145475a = 1;
                                obj = aVar.a(str, str2, function1, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return (e.a) obj;
                        } catch (Exception e16) {
                            w.a("Luggage.WxaRuntimePkgDownloader|runProfiled", e16, "downloadImpl fail", new Object[0]);
                            return null;
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6945a(String str, String str2, Function1 function1, Continuation continuation) {
                    super(2, continuation);
                    this.f145472b = str;
                    this.f145473c = str2;
                    this.f145474d = function1;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((C6945a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C6945a(this.f145472b, this.f145473c, this.f145474d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.f145471a;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CoroutineDispatcher io5 = Dispatchers.getIO();
                        C6946a c6946a = new C6946a(this.f145472b, this.f145473c, this.f145474d, null);
                        this.f145471a = 1;
                        obj = BuildersKt.withContext(io5, c6946a, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z16, r rVar, com.tencent.luggage.wxa.mc.d dVar, com.tencent.luggage.wxa.y7.b bVar, String str2, o oVar, Function1 function1, Continuation continuation) {
                super(2, continuation);
                this.f145463d = str;
                this.f145464e = z16;
                this.f145465f = rVar;
                this.f145466g = dVar;
                this.f145467h = bVar;
                this.f145468i = str2;
                this.f145469j = oVar;
                this.f145470k = function1;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f145463d, this.f145464e, this.f145465f, this.f145466g, this.f145467h, this.f145468i, this.f145469j, this.f145470k, continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:11:0x00a3  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00e4  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x011b A[Catch: all -> 0x0111, IOException -> 0x0114, TryCatch #1 {IOException -> 0x0114, blocks: (B:81:0x0107, B:33:0x011b, B:35:0x012c, B:37:0x0130, B:42:0x013e, B:71:0x0146, B:47:0x014c, B:49:0x0159, B:50:0x0165, B:53:0x01a3, B:68:0x01e3, B:69:0x01e8, B:75:0x01e9, B:78:0x0242, B:79:0x0247), top: B:80:0x0107, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x022c  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x023d  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0072 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:75:0x01e9 A[Catch: all -> 0x0111, IOException -> 0x0114, TRY_LEAVE, TryCatch #1 {IOException -> 0x0114, blocks: (B:81:0x0107, B:33:0x011b, B:35:0x012c, B:37:0x0130, B:42:0x013e, B:71:0x0146, B:47:0x014c, B:49:0x0159, B:50:0x0165, B:53:0x01a3, B:68:0x01e3, B:69:0x01e8, B:75:0x01e9, B:78:0x0242, B:79:0x0247), top: B:80:0x0107, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0098  */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v24 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            /* JADX WARN: Type inference failed for: r3v39 */
            /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Integer] */
            /* JADX WARN: Type inference failed for: r3v44 */
            /* JADX WARN: Type inference failed for: r3v45 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0070 -> B:5:0x0073). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                a aVar;
                ?? r26;
                String a16;
                Object withTimeoutOrNull;
                int i3;
                e.a aVar2;
                int i16;
                String str;
                int i17;
                com.tencent.luggage.wxa.y7.b bVar;
                boolean z16;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i18 = this.f145462c;
                Continuation continuation = null;
                ?? r36 = 0;
                int i19 = 1;
                if (i18 != 0) {
                    if (i18 == 1) {
                        int i26 = this.f145460a;
                        String str2 = (String) this.f145461b;
                        ResultKt.throwOnFailure(obj);
                        withTimeoutOrNull = obj;
                        a16 = str2;
                        aVar = this;
                        i3 = i26;
                        aVar2 = (e.a) withTimeoutOrNull;
                        w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), ret:" + aVar2);
                        boolean z17 = false;
                        if (aVar2 == null && aVar2.a() == 0) {
                            i16 = i19;
                        } else {
                            i16 = 0;
                        }
                        if (i16 == 0) {
                            if (aVar2.b() != 404 && aVar2.b() != 403) {
                                try {
                                } catch (IOException unused) {
                                    str = r36;
                                }
                                str = com.tencent.mm.plugin.appbrand.appcache.a.b(a16);
                                if (str != null) {
                                    try {
                                        try {
                                            if (str.length() != 0) {
                                                i17 = 0;
                                                if (i17 == 0) {
                                                    String[] strArr = new String[2];
                                                    com.tencent.luggage.wxa.mc.d dVar = aVar.f145466g;
                                                    strArr[0] = dVar.f138309f;
                                                    strArr[i19] = dVar.f138311h;
                                                    int i27 = 0;
                                                    while (true) {
                                                        if (i27 >= 2) {
                                                            break;
                                                        }
                                                        String str3 = strArr[i27];
                                                        if (str3 != null && str3.length() != 0) {
                                                            z16 = false;
                                                            if (z16 && Intrinsics.areEqual(str, str3)) {
                                                                z17 = true;
                                                                break;
                                                            }
                                                            i27++;
                                                        }
                                                        z16 = true;
                                                        if (z16) {
                                                        }
                                                        i27++;
                                                    }
                                                    if (z17) {
                                                        com.tencent.luggage.wxa.mc.d dVar2 = aVar.f145466g;
                                                        dVar2.f138315l = a16;
                                                        com.tencent.luggage.wxa.mc.m0.b(aVar.f145469j, dVar2);
                                                        com.tencent.luggage.wxa.y7.b bVar2 = aVar.f145467h;
                                                        if (bVar2 != null) {
                                                            com.tencent.mm.plugin.appbrand.appcache.a aVar3 = new com.tencent.mm.plugin.appbrand.appcache.a();
                                                            aVar3.md5 = str;
                                                            aVar3.pkgPath = a16;
                                                            bVar2.a(aVar3);
                                                        }
                                                        Unit unit = Unit.INSTANCE;
                                                        w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), checksumOk:" + z17 + ", fileMd5:" + str + ", record_md5:(" + aVar.f145466g.f138309f + QbAddrData.DATA_SPLITER + aVar.f145466g.f138311h + ')');
                                                        return unit;
                                                    }
                                                    if (aVar.f145464e) {
                                                        w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), checksumOk:" + z17 + ", fileMd5:" + str + ", record_md5:(" + aVar.f145466g.f138309f + QbAddrData.DATA_SPLITER + aVar.f145466g.f138311h + ')');
                                                    } else {
                                                        throw new b();
                                                    }
                                                } else if (aVar.f145464e) {
                                                    w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), checksumOk:false, fileMd5:" + str + ", record_md5:(" + aVar.f145466g.f138309f + QbAddrData.DATA_SPLITER + aVar.f145466g.f138311h + ')');
                                                } else {
                                                    throw new FileNotFoundException();
                                                }
                                                int i28 = i3 - 1;
                                                if (i3 > 0) {
                                                    if (i28 <= 0 && (bVar = aVar.f145467h) != null) {
                                                        bVar.onError(new FileNotFoundException());
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                                r26 = i28;
                                                continuation = null;
                                                i19 = 1;
                                                a16 = a.f145450a.a(aVar.f145465f, aVar.f145466g);
                                                C6945a c6945a = new C6945a(a16, aVar.f145468i, aVar.f145470k, continuation);
                                                aVar.f145461b = a16;
                                                aVar.f145460a = r26;
                                                aVar.f145462c = i19;
                                                withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(1001000L, c6945a, aVar);
                                                i3 = r26;
                                                r36 = continuation;
                                                if (withTimeoutOrNull == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                aVar2 = (e.a) withTimeoutOrNull;
                                                w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), ret:" + aVar2);
                                                boolean z172 = false;
                                                if (aVar2 == null) {
                                                }
                                                i16 = 0;
                                                if (i16 == 0) {
                                                    if (aVar2 != null) {
                                                        r36 = Boxing.boxInt(aVar2.a());
                                                    }
                                                    if (r36 == 0) {
                                                        com.tencent.luggage.wxa.y7.b bVar3 = aVar.f145467h;
                                                        if (bVar3 != null) {
                                                            bVar3.onError(new TimeoutException("download timeout"));
                                                        }
                                                    } else {
                                                        com.tencent.luggage.wxa.y7.b bVar4 = aVar.f145467h;
                                                        if (bVar4 != null) {
                                                            bVar4.onError(new TimeoutException("fail " + aVar2.a()));
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                        } catch (IOException e16) {
                                            com.tencent.luggage.wxa.y7.b bVar5 = aVar.f145467h;
                                            if (bVar5 != null) {
                                                bVar5.onError(e16);
                                            }
                                            Unit unit2 = Unit.INSTANCE;
                                            w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), checksumOk:false, fileMd5:" + str + ", record_md5:(" + aVar.f145466g.f138309f + QbAddrData.DATA_SPLITER + aVar.f145466g.f138311h + ')');
                                            return unit2;
                                        }
                                    } catch (Throwable th5) {
                                        w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), checksumOk:false, fileMd5:" + str + ", record_md5:(" + aVar.f145466g.f138309f + QbAddrData.DATA_SPLITER + aVar.f145466g.f138311h + ')');
                                        throw th5;
                                    }
                                }
                                i17 = i19;
                                if (i17 == 0) {
                                }
                                int i282 = i3 - 1;
                                if (i3 > 0) {
                                }
                            } else {
                                com.tencent.luggage.wxa.y7.b bVar6 = aVar.f145467h;
                                if (bVar6 != null) {
                                    bVar6.onError(new C6944c(aVar.f145468i));
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "start downloadForPkgFetcher(" + this.f145463d + "), retryOnceIfFileCorrupt:" + this.f145464e);
                    aVar = this;
                    r26 = this.f145464e;
                    a16 = a.f145450a.a(aVar.f145465f, aVar.f145466g);
                    C6945a c6945a2 = new C6945a(a16, aVar.f145468i, aVar.f145470k, continuation);
                    aVar.f145461b = a16;
                    aVar.f145460a = r26;
                    aVar.f145462c = i19;
                    withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(1001000L, c6945a2, aVar);
                    i3 = r26;
                    r36 = continuation;
                    if (withTimeoutOrNull == coroutine_suspended) {
                    }
                    aVar2 = (e.a) withTimeoutOrNull;
                    w.d("Luggage.WxaRuntimePkgDownloader|runProfiled", "downloadForPkgFetcher(" + aVar.f145463d + "), ret:" + aVar2);
                    boolean z1722 = false;
                    if (aVar2 == null) {
                    }
                    i16 = 0;
                    if (i16 == 0) {
                    }
                }
            }
        }

        public d(String str, boolean z16, r rVar, com.tencent.luggage.wxa.mc.d dVar, com.tencent.luggage.wxa.y7.b bVar, String str2, o oVar, Function1 function1) {
            this.f145452a = str;
            this.f145453b = z16;
            this.f145454c = rVar;
            this.f145455d = dVar;
            this.f145456e = bVar;
            this.f145457f = str2;
            this.f145458g = oVar;
            this.f145459h = function1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.f145448a;
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new a(this.f145452a, this.f145453b, this.f145454c, this.f145455d, this.f145456e, this.f145457f, this.f145458g, this.f145459h, null), 2, null);
        }
    }

    static {
        String str = m0.f135220a;
        Intrinsics.checkNotNull(str);
        f145449b = str;
        com.tencent.luggage.wxa.y7.a.f145440d.a();
    }

    public final void a(r pkgQueryKey, com.tencent.luggage.wxa.mc.d manifestRecord, o storage, String downloadUrl, com.tencent.luggage.wxa.y7.b bVar, Function1 function1, boolean z16) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(pkgQueryKey, "pkgQueryKey");
        Intrinsics.checkNotNullParameter(manifestRecord, "manifestRecord");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        LinkedList linkedList = new LinkedList();
        linkedList.add("key:" + manifestRecord.f138305b);
        linkedList.add("versionType:" + manifestRecord.f138319p);
        if (manifestRecord instanceof i0) {
            linkedList.add("version:" + ((i0) manifestRecord).Z);
        } else {
            linkedList.add("version:" + manifestRecord.f138307d);
        }
        linkedList.add("url:" + downloadUrl);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedList, ", ", null, null, 0, null, null, 62, null);
        h.f146825d.d(new d(joinToString$default, z16, pkgQueryKey, manifestRecord, bVar, downloadUrl, storage, function1));
    }
}
