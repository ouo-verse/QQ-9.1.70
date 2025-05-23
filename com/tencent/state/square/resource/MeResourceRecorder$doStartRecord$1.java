package com.tencent.state.square.resource;

import com.tencent.state.square.IZPlanRecorder;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.UserIdentifier;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "canRecord", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MeResourceRecorder$doStartRecord$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ WeakReference $callback;
    final /* synthetic */ List $receivers;
    final /* synthetic */ RecordRequest $request;
    final /* synthetic */ Resource $resource;
    final /* synthetic */ UserIdentifier $sender;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.state.square.resource.MeResourceRecorder$doStartRecord$1$1", f = "MeResourceRecorder.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.state.square.resource.MeResourceRecorder$doStartRecord$1$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $canRecord;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z16, Continuation continuation) {
            super(2, continuation);
            this.$canRecord = z16;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass1(this.$canRecord, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            final boolean z16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                SquareBaseKt.getSquareLog().i("MeResourceRecorder", "checkCanRecord: canRecord=" + this.$canRecord);
                if (this.$canRecord) {
                    IZPlanRecorder recorder = Square.INSTANCE.getConfig().getRecorder();
                    Resource resource = MeResourceRecorder$doStartRecord$1.this.$resource;
                    MeResourceRecorder$doStartRecord$1 meResourceRecorder$doStartRecord$1 = MeResourceRecorder$doStartRecord$1.this;
                    RecordIdentifier recordIdentifier = new RecordIdentifier(meResourceRecorder$doStartRecord$1.$sender, meResourceRecorder$doStartRecord$1.$receivers, meResourceRecorder$doStartRecord$1.$request.getAppId(), null, false, 24, null);
                    this.label = 1;
                    obj = IZPlanRecorder.DefaultImpls.recordAvatarActions$default(recorder, resource, recordIdentifier, true, false, (Continuation) this, 8, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    SquareBaseKt.getSquareLog().w("MeResourceRecorder", "startRecord: isForbidden");
                    z16 = false;
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.MeResourceRecorder.doStartRecord.1.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IResourceCallback iResourceCallback;
                            WeakReference weakReference = MeResourceRecorder$doStartRecord$1.this.$callback;
                            if (weakReference == null || (iResourceCallback = (IResourceCallback) weakReference.get()) == null) {
                                return;
                            }
                            iResourceCallback.onRecordStart(MeResourceRecorder$doStartRecord$1.this.$resource, z16);
                        }
                    });
                    SquareBaseKt.getSquareLog().i("MeResourceRecorder", "isRecordStarted: " + z16);
                    return Unit.INSTANCE;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z16 = ((Boolean) obj).booleanValue();
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.MeResourceRecorder.doStartRecord.1.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IResourceCallback iResourceCallback;
                    WeakReference weakReference = MeResourceRecorder$doStartRecord$1.this.$callback;
                    if (weakReference == null || (iResourceCallback = (IResourceCallback) weakReference.get()) == null) {
                        return;
                    }
                    iResourceCallback.onRecordStart(MeResourceRecorder$doStartRecord$1.this.$resource, z16);
                }
            });
            SquareBaseKt.getSquareLog().i("MeResourceRecorder", "isRecordStarted: " + z16);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeResourceRecorder$doStartRecord$1(Resource resource, UserIdentifier userIdentifier, List list, RecordRequest recordRequest, WeakReference weakReference) {
        super(1);
        this.$resource = resource;
        this.$sender = userIdentifier;
        this.$receivers = list;
        this.$request = recordRequest;
        this.$callback = weakReference;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(z16, null), 3, null);
    }
}
