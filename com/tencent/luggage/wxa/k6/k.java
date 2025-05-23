package com.tencent.luggage.wxa.k6;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.webkit.PermissionRequest;
import android.widget.Toast;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final a f131679d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f131680a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f131681b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f131682c;

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
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f131683a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return f0.e("WebPermissionStorage");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f131684a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f131685b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, String str) {
            super(0);
            this.f131684a = context;
            this.f131685b = str;
        }

        public final void a() {
            Toast.makeText(this.f131684a, this.f131685b, 1).show();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f131686a;

        /* renamed from: b, reason: collision with root package name */
        public Object f131687b;

        /* renamed from: c, reason: collision with root package name */
        public Object f131688c;

        /* renamed from: d, reason: collision with root package name */
        public int f131689d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f131690e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f131691f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Context f131692g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ k f131693h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f131694i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ PermissionRequest f131695j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f131696k;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f131697a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f131698b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f131699c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f131700d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k kVar, Context context, Ref.ObjectRef objectRef, Continuation continuation) {
                super(2, continuation);
                this.f131698b = kVar;
                this.f131699c = context;
                this.f131700d = objectRef;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f131698b, this.f131699c, this.f131700d, continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f131697a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    k kVar = this.f131698b;
                    Context context = this.f131699c;
                    String str = (String) this.f131700d.element;
                    this.f131697a = 1;
                    obj = kVar.a(context, str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Ref.ObjectRef objectRef, String[] strArr, Context context, k kVar, Ref.ObjectRef objectRef2, PermissionRequest permissionRequest, String str, Continuation continuation) {
            super(2, continuation);
            this.f131690e = objectRef;
            this.f131691f = strArr;
            this.f131692g = context;
            this.f131693h = kVar;
            this.f131694i = objectRef2;
            this.f131695j = permissionRequest;
            this.f131696k = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.f131690e, this.f131691f, this.f131692g, this.f131693h, this.f131694i, this.f131695j, this.f131696k, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x00f2  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x00e3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            k kVar;
            PermissionRequest permissionRequest;
            String str;
            ArrayList arrayList;
            boolean contains;
            boolean contains2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f131689d;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            k.a(this.f131693h, this.f131695j, this.f131696k, true, false, 8, null);
                        } else {
                            k.a(this.f131693h, this.f131695j, this.f131696k, false, false, 8, null);
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str2 = (String) this.f131688c;
                PermissionRequest permissionRequest2 = (PermissionRequest) this.f131687b;
                kVar = (k) this.f131686a;
                ResultKt.throwOnFailure(obj);
                str = str2;
                permissionRequest = permissionRequest2;
            } else {
                ResultKt.throwOnFailure(obj);
                String[] strArr = (String[]) this.f131690e.element;
                if (strArr != null) {
                    Context context = this.f131692g;
                    kVar = this.f131693h;
                    permissionRequest = this.f131695j;
                    str = this.f131696k;
                    Ref.ObjectRef objectRef = this.f131694i;
                    if (com.tencent.luggage.wxa.h6.k.a(context, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        a aVar = new a(kVar, context, objectRef, null);
                        this.f131686a = kVar;
                        this.f131687b = permissionRequest;
                        this.f131688c = str;
                        this.f131689d = 1;
                        obj = BuildersKt.withContext(main, aVar, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                arrayList = new ArrayList();
                contains = ArraysKt___ArraysKt.contains(this.f131691f, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                if (contains && com.tencent.luggage.wxa.h6.k.a(this.f131692g, QQPermissionConstants.Permission.RECORD_AUDIO)) {
                    arrayList.add(QQPermissionConstants.Permission.RECORD_AUDIO);
                }
                contains2 = ArraysKt___ArraysKt.contains(this.f131691f, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                if (contains2 && com.tencent.luggage.wxa.h6.k.a(this.f131692g, QQPermissionConstants.Permission.CAMERA)) {
                    arrayList.add(QQPermissionConstants.Permission.CAMERA);
                }
                if (arrayList.isEmpty()) {
                    k kVar2 = this.f131693h;
                    Context context2 = this.f131692g;
                    String str3 = (String) this.f131694i.element;
                    this.f131686a = null;
                    this.f131687b = null;
                    this.f131688c = null;
                    this.f131689d = 2;
                    obj = kVar2.a(context2, arrayList, str3, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                k.a(this.f131693h, this.f131695j, this.f131696k, true, false, 8, null);
                return Unit.INSTANCE;
            }
            if (!((Boolean) obj).booleanValue()) {
                w.d("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest cancel");
                k.a(kVar, permissionRequest, str, false, false, 8, null);
                return Unit.INSTANCE;
            }
            arrayList = new ArrayList();
            contains = ArraysKt___ArraysKt.contains(this.f131691f, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (contains) {
                arrayList.add(QQPermissionConstants.Permission.RECORD_AUDIO);
            }
            contains2 = ArraysKt___ArraysKt.contains(this.f131691f, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            if (contains2) {
                arrayList.add(QQPermissionConstants.Permission.CAMERA);
            }
            if (arrayList.isEmpty()) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements LuggageActivityHelper.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f131701a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f131702b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f131703c;

        public e(Continuation continuation, k kVar, Context context) {
            this.f131701a = continuation;
            this.f131702b = kVar;
            this.f131703c = context;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.h
        public final void a(String[] strArr, int[] iArr) {
            boolean z16;
            if (iArr != null) {
                if (iArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    LinkedList linkedList = new LinkedList();
                    int length = strArr.length;
                    boolean z17 = true;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (iArr[i3] != 0) {
                            w.d("MicroMsg.WebViewPermissionRequestHelper", "showSysPermissionAlert PERMISSION_GRANTED, %s", strArr[i3]);
                            linkedList.add(strArr[i3]);
                            z17 = false;
                        }
                    }
                    this.f131702b.a(this.f131703c, linkedList);
                    w.d("MicroMsg.WebViewPermissionRequestHelper", "showSysPermissionAlert isGrant=" + z17);
                    this.f131701a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z17)));
                    return;
                }
            }
            w.d("MicroMsg.WebViewPermissionRequestHelper", "grantResults empty");
            Continuation continuation = this.f131701a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f131704a;

        public f(Continuation continuation) {
            this.f131704a = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            w.d("MicroMsg.WebViewPermissionRequestHelper", "showWebPermissionAlert ok");
            Continuation continuation = this.f131704a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f131705a;

        public g(Continuation continuation) {
            this.f131705a = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            w.d("MicroMsg.WebViewPermissionRequestHelper", "showWebPermissionAlert cancel");
            Continuation continuation = this.f131705a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    public k() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(b.f131683a);
        this.f131682c = lazy;
    }

    public final Object a(Context context, ArrayList arrayList, String str, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        LuggageActivityHelper FOR = LuggageActivityHelper.FOR(context);
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        FOR.requestPermissions((String[]) array, new e(safeContinuation, this, context));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void a(Context context, LinkedList linkedList) {
        String string;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        if (!linkedList.contains(QQPermissionConstants.Permission.CAMERA) && !linkedList.contains(QQPermissionConstants.Permission.RECORD_AUDIO)) {
            if (!linkedList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                return;
            } else {
                string = context.getString(R.string.f242167tu);
            }
        } else if (linkedList.contains(QQPermissionConstants.Permission.CAMERA) && linkedList.contains(QQPermissionConstants.Permission.RECORD_AUDIO)) {
            string = context.getString(R.string.f242117tp);
        } else if (linkedList.contains(QQPermissionConstants.Permission.CAMERA)) {
            string = context.getString(R.string.f242137tr);
        } else {
            string = context.getString(R.string.f242157tt);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (notGrandArray.contai\u2026     return\n            }");
        com.tencent.luggage.wxa.h6.d.a((Function0) new c(context, string));
    }

    public final Object a(Context context, String str, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
        if (a16 == null) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
        } else {
            Intrinsics.checkNotNullExpressionValue(a16, "AndroidContextUtil.castA\u2026t.resume(false)\n        }");
            if (!a16.isDestroyed() && !a16.isFinishing()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str).setCancelable(false).setPositiveButton(context.getString(R.string.z4v), new f(safeContinuation)).setNegativeButton(context.getString(R.string.z4z), new g(safeContinuation));
                builder.show();
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            String host = Uri.parse(str).getHost();
            return host == null ? QzoneWebMusicJsPlugin.EVENT_UNKOWN : host;
        } catch (Exception unused) {
            return QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(PermissionRequest permissionRequest, String str) {
        boolean z16;
        boolean isBlank;
        String[] resources = permissionRequest.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "request.resources");
        String str2 = "";
        for (String str3 : resources) {
            if (str2 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        str2 = str2 + '-';
                    }
                    str2 = str2 + str3;
                }
            }
            z16 = true;
            if (z16) {
            }
            str2 = str2 + str3;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str != null ? a(str) : null);
        sb5.append('-');
        sb5.append(str2);
        return sb5.toString();
    }

    public static /* synthetic */ void a(k kVar, PermissionRequest permissionRequest, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        kVar.a(permissionRequest, str, z16, z17);
    }

    public final void a(PermissionRequest permissionRequest, String str, boolean z16, boolean z17) {
        if (z16) {
            permissionRequest.grant(permissionRequest.getResources());
        } else {
            permissionRequest.deny();
        }
        if (z17) {
            this.f131681b.put(a(permissionRequest, str), Boolean.valueOf(z16));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.String[]] */
    public final void a(Context context, PermissionRequest permissionRequest, String[] strArr, String str) {
        boolean contains;
        boolean contains2;
        boolean contains3;
        T t16;
        boolean contains4;
        boolean contains5;
        boolean contains6;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        contains = ArraysKt___ArraysKt.contains(strArr, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        if (!contains) {
            contains5 = ArraysKt___ArraysKt.contains(strArr, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (!contains5) {
                contains6 = ArraysKt___ArraysKt.contains(strArr, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID);
                if (contains6) {
                    a(this, permissionRequest, str, true, false, 8, null);
                    w.d("MicroMsg.WebViewPermissionRequestHelper", "showPermissionAlert grant PROTECTED_MEDIA_ID");
                    return;
                } else {
                    permissionRequest.deny();
                    w.f("MicroMsg.WebViewPermissionRequestHelper", "showPermissionAlert not support permission");
                    return;
                }
            }
        }
        contains2 = ArraysKt___ArraysKt.contains(strArr, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        if (contains2) {
            contains4 = ArraysKt___ArraysKt.contains(strArr, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (contains4) {
                objectRef2.element = new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO};
                String string = context.getString(R.string.f242107to, permissionRequest.getOrigin().toString());
                Intrinsics.checkNotNullExpressionValue(string, "{\n                permis\u2026toString())\n            }");
                t16 = string;
                objectRef.element = t16;
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new d(objectRef2, strArr, context, this, objectRef, permissionRequest, str, null), 3, null);
            }
        }
        contains3 = ArraysKt___ArraysKt.contains(strArr, com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        if (contains3) {
            objectRef2.element = new String[]{QQPermissionConstants.Permission.CAMERA};
            String string2 = context.getString(R.string.f242127tq, permissionRequest.getOrigin().toString());
            Intrinsics.checkNotNullExpressionValue(string2, "{\n                permis\u2026toString())\n            }");
            t16 = string2;
        } else {
            objectRef2.element = new String[]{QQPermissionConstants.Permission.RECORD_AUDIO};
            String string3 = context.getString(R.string.f242147ts, permissionRequest.getOrigin().toString());
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                permis\u2026toString())\n            }");
            t16 = string3;
        }
        objectRef.element = t16;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new d(objectRef2, strArr, context, this, objectRef, permissionRequest, str, null), 3, null);
    }

    public final void a(PermissionRequest permissionRequest, Context context, String str) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(context, "context");
        w.d("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest");
        if (permissionRequest == null) {
            return;
        }
        String[] resources = permissionRequest.getResources();
        boolean z16 = true;
        if (resources != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : resources) {
                if (str2.equals(com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_AUDIO_CAPTURE) || str2.equals(com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_VIDEO_CAPTURE) || str2.equals(com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID)) {
                    arrayList.add(str2);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            strArr = (String[]) array;
        } else {
            strArr = null;
        }
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                z16 = false;
            }
        }
        if (z16) {
            permissionRequest.deny();
            return;
        }
        String a16 = a(permissionRequest, str);
        if (this.f131681b.containsKey(a16)) {
            Boolean bool = (Boolean) this.f131681b.get(a16);
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            boolean booleanValue = bool.booleanValue();
            a(permissionRequest, str, booleanValue, false);
            w.a("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest use cache " + booleanValue);
            return;
        }
        a(context, permissionRequest, strArr, str);
    }
}
