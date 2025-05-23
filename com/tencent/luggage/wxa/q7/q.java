package com.tencent.luggage.wxa.q7;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.luggage.opensdk.OpenSDKApiContentProvider;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.o1;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f138021a = new q();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f138022b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f138023a;

        static {
            int[] iArr = new int[WxaAppCustomActionSheetDelegate.ActionType.values().length];
            iArr[WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage.ordinal()] = 1;
            iArr[WxaAppCustomActionSheetDelegate.ActionType.onAddToFavorites.ordinal()] = 2;
            iArr[WxaAppCustomActionSheetDelegate.ActionType.onAddToMine.ordinal()] = 3;
            f138023a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements WxaAppCustomActionSheetDelegate.a {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.f7.e f138024a;

        public b(com.tencent.luggage.wxa.s6.h hVar, com.tencent.luggage.wxa.l7.c cVar) {
            int i3;
            String b16 = s.d.f138074a.b();
            String appId = hVar.getAppId();
            String B0 = hVar.B0();
            String j3 = hVar.getRuntime().S().j();
            String name = WxaAppCustomActionSheetDelegate.ActionType.onAddToMine.name();
            int i16 = cVar.i();
            if (cVar.h().C) {
                i3 = 5;
            } else {
                i3 = 4;
            }
            this.f138024a = new com.tencent.luggage.wxa.f7.e(b16, appId, B0, j3, name, i16, i3);
        }

        @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
        public void onCancel() {
            this.f138024a.a(2);
            this.f138024a.c();
        }

        @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
        public void onFail(String str) {
            this.f138024a.a(3);
            this.f138024a.c();
        }

        @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
        public void onSuccess() {
            this.f138024a.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f138025a;

        /* renamed from: b, reason: collision with root package name */
        public Object f138026b;

        /* renamed from: c, reason: collision with root package name */
        public Object f138027c;

        /* renamed from: d, reason: collision with root package name */
        public Object f138028d;

        /* renamed from: e, reason: collision with root package name */
        public int f138029e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f138030f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ WxaAppCustomActionSheetDelegate.ActionType f138031g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f138032h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ JSONObject f138033i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Map f138034j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.a f138035k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f138036l;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f138037a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bitmap f138038b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.cp.v f138039c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.rc.r f138040d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ JSONObject f138041e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Bitmap bitmap, com.tencent.luggage.wxa.cp.v vVar, com.tencent.luggage.wxa.rc.r rVar, JSONObject jSONObject, Continuation continuation) {
                super(2, continuation);
                this.f138038b = bitmap;
                this.f138039c = vVar;
                this.f138040d = rVar;
                this.f138041e = jSONObject;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f138038b, this.f138039c, this.f138040d, this.f138041e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f138037a == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.luggage.wxa.tn.d.a(this.f138038b, 100, Bitmap.CompressFormat.JPEG, this.f138039c.g(), true);
                    com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                    this.f138040d.createTempFileFrom(this.f138039c, "jpg", true, iVar);
                    return this.f138041e.put("imageUrl", iVar.f141499a);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements WxaAppCustomActionSheetDelegate.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f138042a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f138043b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.a f138044c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.f7.e f138045d;

            public b(com.tencent.luggage.wxa.ic.d dVar, int i3, com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.f7.e eVar) {
                this.f138042a = dVar;
                this.f138043b = i3;
                this.f138044c = aVar;
                this.f138045d = eVar;
            }

            @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
            public void onCancel() {
                this.f138042a.a(this.f138043b, this.f138044c.makeReturnJson("fail cancel"));
                this.f138045d.a(2);
                this.f138045d.c();
            }

            @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
            public void onFail(String str) {
                com.tencent.luggage.wxa.ic.d dVar = this.f138042a;
                int i3 = this.f138043b;
                com.tencent.luggage.wxa.xd.a aVar = this.f138044c;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fail ");
                if (str == null) {
                    str = "";
                }
                sb5.append(str);
                dVar.a(i3, aVar.makeReturnJson(sb5.toString()));
                this.f138045d.a(3);
                this.f138045d.c();
            }

            @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
            public void onSuccess() {
                this.f138042a.a(this.f138043b, this.f138044c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                this.f138045d.a(1);
                this.f138045d.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.ic.d dVar, WxaAppCustomActionSheetDelegate.ActionType actionType, int i3, JSONObject jSONObject, Map map, com.tencent.luggage.wxa.xd.a aVar, int i16, Continuation continuation) {
            super(2, continuation);
            this.f138030f = dVar;
            this.f138031g = actionType;
            this.f138032h = i3;
            this.f138033i = jSONObject;
            this.f138034j = map;
            this.f138035k = aVar;
            this.f138036l = i16;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f138030f, this.f138031g, this.f138032h, this.f138033i, this.f138034j, this.f138035k, this.f138036l, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            com.tencent.luggage.wxa.f7.e eVar;
            com.tencent.luggage.wxa.j4.d dVar;
            String str;
            boolean z16;
            com.tencent.luggage.wxa.rc.r fileSystem;
            Object a16;
            JSONObject jSONObject;
            com.tencent.luggage.wxa.rc.r rVar;
            Object m476constructorimpl;
            Object withContext;
            com.tencent.luggage.wxa.f7.e eVar2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f138029e;
            Unit unit = null;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        eVar2 = (com.tencent.luggage.wxa.f7.e) this.f138025a;
                        ResultKt.throwOnFailure(obj);
                        withContext = obj;
                        eVar = eVar2;
                        OpenSDKApiContentProvider.a(this.f138030f, this.f138033i, OpenSDKApiContentProvider.a.ToFileProtocol);
                        v vVar = v.f138193a;
                        String appId = this.f138030f.getAppId();
                        Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
                        vVar.handleCustomAction(appId, this.f138030f.getRuntime().l0(), this.f138032h, q.f138021a.a(this.f138033i, this.f138031g), new b(this.f138030f, this.f138036l, this.f138035k, eVar), this.f138031g, this.f138034j);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                JSONObject jSONObject2 = (JSONObject) this.f138027c;
                com.tencent.luggage.wxa.rc.r rVar2 = (com.tencent.luggage.wxa.rc.r) this.f138026b;
                com.tencent.luggage.wxa.f7.e eVar3 = (com.tencent.luggage.wxa.f7.e) this.f138025a;
                ResultKt.throwOnFailure(obj);
                jSONObject = jSONObject2;
                rVar = rVar2;
                eVar = eVar3;
                a16 = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                String b16 = s.d.f138074a.b();
                String appId2 = this.f138030f.getAppId();
                String currentUrl = this.f138030f.getRuntime().Y().getCurrentUrl();
                com.tencent.luggage.wxa.fd.i S = this.f138030f.getRuntime().S();
                if (S instanceof com.tencent.luggage.wxa.j4.d) {
                    dVar = (com.tencent.luggage.wxa.j4.d) S;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    str = dVar.j();
                } else {
                    str = null;
                }
                eVar = new com.tencent.luggage.wxa.f7.e(b16, appId2, currentUrl, str, this.f138031g.name(), this.f138032h, 0, 64, null);
                String optString = this.f138033i.optString("imageUrl");
                if (optString != null && optString.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && (fileSystem = this.f138030f.getFileSystem()) != null) {
                    com.tencent.luggage.wxa.xd.a aVar = this.f138035k;
                    com.tencent.luggage.wxa.ic.d dVar2 = this.f138030f;
                    JSONObject jSONObject3 = this.f138033i;
                    q qVar = q.f138021a;
                    this.f138025a = eVar;
                    this.f138026b = fileSystem;
                    this.f138027c = jSONObject3;
                    this.f138028d = fileSystem;
                    this.f138029e = 1;
                    a16 = qVar.a(aVar, dVar2, this);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jSONObject = jSONObject3;
                    rVar = fileSystem;
                }
                OpenSDKApiContentProvider.a(this.f138030f, this.f138033i, OpenSDKApiContentProvider.a.ToFileProtocol);
                v vVar2 = v.f138193a;
                String appId3 = this.f138030f.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId3, "env.appId");
                vVar2.handleCustomAction(appId3, this.f138030f.getRuntime().l0(), this.f138032h, q.f138021a.a(this.f138033i, this.f138031g), new b(this.f138030f, this.f138036l, this.f138035k, eVar), this.f138031g, this.f138034j);
                return Unit.INSTANCE;
            }
            Bitmap bitmap = (Bitmap) a16;
            com.tencent.luggage.wxa.cp.v allocTempFile = rVar.allocTempFile("temp_snapshot_" + w0.c() + ".jpg");
            if (allocTempFile == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (bitmap != null) {
                        bitmap.recycle();
                        unit = Unit.INSTANCE;
                    }
                    m476constructorimpl = Result.m476constructorimpl(unit);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Result.m475boximpl(m476constructorimpl);
            } else if (bitmap != null) {
                CoroutineDispatcher io5 = Dispatchers.getIO();
                a aVar2 = new a(bitmap, allocTempFile, rVar, jSONObject, null);
                this.f138025a = eVar;
                this.f138026b = null;
                this.f138027c = null;
                this.f138028d = null;
                this.f138029e = 2;
                withContext = BuildersKt.withContext(io5, aVar2, this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eVar2 = eVar;
                eVar = eVar2;
            }
            OpenSDKApiContentProvider.a(this.f138030f, this.f138033i, OpenSDKApiContentProvider.a.ToFileProtocol);
            v vVar22 = v.f138193a;
            String appId32 = this.f138030f.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId32, "env.appId");
            vVar22.handleCustomAction(appId32, this.f138030f.getRuntime().l0(), this.f138032h, q.f138021a.a(this.f138033i, this.f138031g), new b(this.f138030f, this.f138036l, this.f138035k, eVar), this.f138031g, this.f138034j);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f138046a;

        public d(CancellableContinuation cancellableContinuation) {
            this.f138046a = cancellableContinuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(Bitmap bitmap) {
            q.b(this.f138046a, bitmap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f138047a;

        public e(CancellableContinuation cancellableContinuation) {
            this.f138047a = cancellableContinuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            q.b(this.f138047a, null);
        }
    }

    static {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage, new String[]{"itemID", "path", "title", "desc", "imageUrl"}), TuplesKt.to(WxaAppCustomActionSheetDelegate.ActionType.onAddToFavorites, new String[]{"itemID", "path", "title", "imageUrl"}));
        f138022b = mapOf;
    }

    public static final void b(CancellableContinuation cancellableContinuation, Bitmap bitmap) {
        if (!cancellableContinuation.isCompleted()) {
            cancellableContinuation.resumeWith(Result.m476constructorimpl(bitmap));
        }
    }

    public final boolean a(com.tencent.luggage.wxa.xd.a aVar, JSONObject jSONObject) {
        if (jSONObject == null || !o.b()) {
            return false;
        }
        if (!(Intrinsics.areEqual(aVar.getName(), com.tencent.luggage.wxa.c3.d.NAME) || Intrinsics.areEqual(aVar.getName(), com.tencent.luggage.wxa.c3.e.NAME)) || Intrinsics.areEqual(jSONObject.optString(TtmlNode.ATTR_TTS_ORIGIN), "weixin")) {
            return false;
        }
        String optString = jSONObject.optString("mode");
        if ((optString == null || optString.length() == 0) || Intrinsics.areEqual(optString, "common")) {
            return true;
        }
        jSONObject.optBoolean("disableForward", false);
        return false;
    }

    public final boolean a(WxaAppCustomActionSheetDelegate.ActionType type, com.tencent.luggage.wxa.xd.a api, com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(api, "api");
        if (dVar == null) {
            return false;
        }
        if (!(jSONObject != null && jSONObject.has("itemID")) && !a(api, jSONObject)) {
            return false;
        }
        Intrinsics.checkNotNull(jSONObject);
        int optInt = jSONObject.optInt("itemID", 0);
        com.tencent.luggage.wxa.fd.i a16 = com.tencent.luggage.wxa.e5.b.a(dVar);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
        com.tencent.luggage.wxa.i3.n a17 = com.tencent.luggage.wxa.i3.n.f129339b.a(((com.tencent.luggage.wxa.j4.d) a16).f130793e0);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new c(dVar, type, optInt, jSONObject, a17 != null ? a17.d() : null, api, i3, null), 3, null);
        return true;
    }

    public final void a(Context context, String appId, com.tencent.luggage.wxa.s6.h page, com.tencent.luggage.wxa.l7.c item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.luggage.wxa.fd.i a16 = com.tencent.luggage.wxa.e5.b.a(page);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
        com.tencent.luggage.wxa.i3.n a17 = com.tencent.luggage.wxa.i3.n.f129339b.a(((com.tencent.luggage.wxa.j4.d) a16).f130793e0);
        Map d16 = a17 != null ? a17.d() : null;
        int i3 = a.f138023a[item.l().ordinal()];
        if (i3 == 1) {
            com.tencent.luggage.wxa.c3.a aVar = new com.tencent.luggage.wxa.c3.a();
            aVar.g(page.getRuntime().S().f125809b);
            aVar.b("");
            aVar.f(page.B0());
            com.tencent.luggage.wxa.f3.a q16 = page.q1();
            aVar.h(q16 != null ? q16.getCurrentURL() : null);
            aVar.c(page.getRuntime().S().f125810c);
            aVar.d("common");
            aVar.a(false);
            aVar.a(item.i());
            aVar.setContext(page.y0(), page.getComponentId()).dispatch();
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            v vVar = v.f138193a;
            String appId2 = page.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId2, "page.appId");
            vVar.handleCustomAction(appId2, page.getRuntime().l0(), item.i(), null, new b(page, item), item.l(), d16);
            return;
        }
        com.tencent.luggage.wxa.b7.a aVar2 = new com.tencent.luggage.wxa.b7.a();
        String n06 = page.n0();
        Intrinsics.checkNotNullExpressionValue(n06, "page.navigationBarTitle");
        aVar2.d(n06);
        String B0 = page.B0();
        Intrinsics.checkNotNullExpressionValue(B0, "page.urlWithQuery");
        aVar2.c(B0);
        com.tencent.luggage.wxa.f3.a q17 = page.q1();
        aVar2.e(q17 != null ? q17.getCurrentURL() : null);
        aVar2.a(item.i());
        aVar2.setContext(page.y0(), page.getComponentId()).dispatch();
    }

    public final JSONObject a(JSONObject jSONObject, WxaAppCustomActionSheetDelegate.ActionType actionType) {
        boolean contains;
        if (jSONObject == null) {
            return null;
        }
        String[] strArr = (String[]) f138022b.get(actionType);
        if (strArr == null) {
            return jSONObject;
        }
        HashMap hashMap = new HashMap(strArr.length);
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String key = (String) keys.next();
            contains = ArraysKt___ArraysKt.contains(strArr, key);
            if (contains) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                hashMap.put(key, jSONObject.get(key));
            }
        }
        return new JSONObject(hashMap);
    }

    public final Object a(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.ic.d dVar, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (aVar instanceof com.tencent.luggage.wxa.b7.b) {
            com.tencent.luggage.wxa.kj.v a16 = o1.a(dVar);
            b(cancellableContinuationImpl, a16 != null ? a16.w0() : null);
        } else {
            com.tencent.luggage.wxa.kj.v a17 = o1.a(dVar);
            com.tencent.luggage.wxa.m4.b bVar = a17 instanceof com.tencent.luggage.wxa.m4.b ? (com.tencent.luggage.wxa.m4.b) a17 : null;
            if (bVar == null) {
                b(cancellableContinuationImpl, null);
            } else if (bVar.f(com.tencent.luggage.wxa.z1.d.class) != null) {
                b(cancellableContinuationImpl, bVar.w0());
            } else {
                bVar.a((Bundle) null);
                bVar.s1().a(new d(cancellableContinuationImpl)).a(new e(cancellableContinuationImpl));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
