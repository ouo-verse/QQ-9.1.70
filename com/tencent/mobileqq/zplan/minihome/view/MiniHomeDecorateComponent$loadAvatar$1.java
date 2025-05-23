package com.tencent.mobileqq.zplan.minihome.view;

import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.view.MiniHomeDecorateComponent$loadAvatar$1", f = "MiniHomeDecorateComponent.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class MiniHomeDecorateComponent$loadAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WeakReference<IMiniHomeLoadCallback> $callbackRef;
    int label;
    final /* synthetic */ MiniHomeDecorateComponent this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minihome/view/MiniHomeDecorateComponent$loadAvatar$1$a", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements sk0.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniHomeDecorateComponent f334395d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f334396e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference<IMiniHomeLoadCallback> f334397f;

        a(MiniHomeDecorateComponent miniHomeDecorateComponent, int i3, WeakReference<IMiniHomeLoadCallback> weakReference) {
            this.f334395d = miniHomeDecorateComponent;
            this.f334396e = i3;
            this.f334397f = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:3:0x0008, B:7:0x0015, B:9:0x001d, B:11:0x0026, B:17:0x0033, B:20:0x0048, B:22:0x0052), top: B:2:0x0008 }] */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
            boolean z16;
            IMiniHomeLoadCallback iMiniHomeLoadCallback;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                MiniHomeScene.Companion.EVENT event = MiniHomeScene.Companion.EVENT.LOAD_AVATAR_CALLBACK;
                if (!Intrinsics.areEqual(event.name(), type)) {
                    return;
                }
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.f334395d.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.removeEventListener(event.name(), this);
                }
                if (data != null && data.length() != 0) {
                    z16 = false;
                    if (z16) {
                        JSONObject jSONObject = new JSONObject(data);
                        if (this.f334396e == jSONObject.optInt(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), -1) && (iMiniHomeLoadCallback = this.f334397f.get()) != null) {
                            iMiniHomeLoadCallback.onMiniHomeLoadResult(jSONObject.optBoolean(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_RESULT.name(), false), jSONObject.optString(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_DATA.name(), "{}"));
                            return;
                        }
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateComponent", 1, "loadAvatar handleEvent error, " + th5);
                IMiniHomeLoadCallback iMiniHomeLoadCallback2 = this.f334397f.get();
                if (iMiniHomeLoadCallback2 != null) {
                    iMiniHomeLoadCallback2.onMiniHomeLoadResult(false, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeDecorateComponent$loadAvatar$1(MiniHomeDecorateComponent miniHomeDecorateComponent, WeakReference<IMiniHomeLoadCallback> weakReference, Continuation<? super MiniHomeDecorateComponent$loadAvatar$1> continuation) {
        super(2, continuation);
        this.this$0 = miniHomeDecorateComponent;
        this.$callbackRef = weakReference;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeDecorateComponent$loadAvatar$1(this.this$0, this.$callbackRef, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.zplan.zplantracing.b bVar;
        AtomicInteger atomicInteger;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.i("MiniHomeDecorateComponent", 1, "loadAvatar " + this.this$0.nativeApp);
                MiniHomeDecorateComponent miniHomeDecorateComponent = this.this$0;
                this.label = 1;
                obj = miniHomeDecorateComponent.H(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniHomeScene.Companion.DATA.AVATAR_INFO.name(), (String) obj);
            if (this.$callbackRef != null) {
                atomicInteger = this.this$0.loadIndex;
                int incrementAndGet = atomicInteger.incrementAndGet();
                jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), incrementAndGet);
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.this$0.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    iFilamentNativeAppV2305.addEventListener(MiniHomeScene.Companion.EVENT.LOAD_AVATAR_CALLBACK.name(), new a(this.this$0, incrementAndGet, this.$callbackRef));
                }
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.this$0.nativeApp;
            if (iFilamentNativeAppV23052 != null) {
                bVar = this.this$0.rootSpan;
                iFilamentNativeAppV23052.dispatchEvent(bVar != null ? bVar.c() : null, MiniHomeScene.Companion.EVENT.LOAD_AVATAR.name(), jSONObject.toString());
            }
        } catch (Throwable unused) {
            QLog.e("MiniHomeDecorateComponent", 1, "loadAvatar error, t");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeDecorateComponent$loadAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
