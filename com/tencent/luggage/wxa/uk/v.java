package com.tencent.luggage.wxa.uk;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class v {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f142778a;

        /* renamed from: b, reason: collision with root package name */
        public Object f142779b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f142780c;

        /* renamed from: d, reason: collision with root package name */
        public int f142781d;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f142780c = obj;
            this.f142781d |= Integer.MIN_VALUE;
            return v.a(null, null, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f142782a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar) {
            super(1);
            this.f142782a = cVar;
        }

        public final void a(Throwable th5) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.IconAttacher", "onCancel#loadIcon, tr: " + th5);
            AppBrandSimpleImageLoader.instance().cancel(this.f142782a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(2:10|11)(2:19|20))(2:21|(2:23|24)(3:25|26|(1:28)))|12|(1:14)(1:18)|15|16))|31|6|7|(0)(0)|12|(0)(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.IconAttacher", "attachTo, loadIcon fail since " + r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[Catch: IOException -> 0x0073, TryCatch #0 {IOException -> 0x0073, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0068, B:18:0x006c, B:26:0x004f), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c A[Catch: IOException -> 0x0073, TRY_LEAVE, TryCatch #0 {IOException -> 0x0073, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0068, B:18:0x006c, B:26:0x004f), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(String str, ImageView imageView, Continuation continuation) {
        a aVar;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i16 = aVar.f142781d;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aVar.f142781d = i16 - Integer.MIN_VALUE;
                Object obj = aVar.f142780c;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aVar.f142781d;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (imageView == null) {
                        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.IconAttacher", "attachTo, imageView is null");
                        return Unit.INSTANCE;
                    }
                    imageView.setTag(str);
                    aVar.f142778a = str;
                    aVar.f142779b = imageView;
                    aVar.f142781d = 1;
                    obj = a(str, aVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    imageView = (ImageView) aVar.f142779b;
                    str = (String) aVar.f142778a;
                    ResultKt.throwOnFailure(obj);
                }
                Bitmap bitmap = (Bitmap) obj;
                if (!Intrinsics.areEqual(str, imageView.getTag())) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.IconAttacher", "attachTo, imageView already reused");
                }
                return Unit.INSTANCE;
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.f142780c;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aVar.f142781d;
        if (i3 != 0) {
        }
        Bitmap bitmap2 = (Bitmap) obj2;
        if (!Intrinsics.areEqual(str, imageView.getTag())) {
        }
        return Unit.INSTANCE;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements AppBrandSimpleImageLoader.m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142783a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f142784b;

        public c(String str, CancellableContinuation cancellableContinuation) {
            this.f142783a = str;
            this.f142784b = cancellableContinuation;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.IconAttacher", "onBitmapLoaded, iconUrl: " + this.f142783a);
            if (bitmap == null) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.IconAttacher", "onBitmapLoaded, bitmap is null");
                CancellableContinuation cancellableContinuation = this.f142784b;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IOException("Unexpected null bitmap"))));
                return;
            }
            this.f142784b.resumeWith(Result.m476constructorimpl(bitmap));
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return com.tencent.luggage.wxa.tk.m.a(this);
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.IconAttacher", "beforeLoadBitmap, iconUrl: " + this.f142783a);
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.IconAttacher", "onLoadFailed, iconUrl: " + this.f142783a);
            CancellableContinuation cancellableContinuation = this.f142784b;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IOException("Load fail"))));
        }
    }

    public static final Object a(String str, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        c cVar = new c(str, cancellableContinuationImpl);
        AppBrandSimpleImageLoader.instance().load(cVar, str, (AppBrandSimpleImageLoader.j) null);
        cancellableContinuationImpl.invokeOnCancellation(new b(cVar));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
