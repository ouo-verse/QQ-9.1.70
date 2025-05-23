package com.tencent.robot.adelie.homepage.ugc.view;

import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText;
import com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$initView$3$1", f = "AdelieAvatarEditTextView.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieAvatarEditTextView$initView$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $btn;
    final /* synthetic */ Ref.ObjectRef<String> $reportInput;
    final /* synthetic */ ShadowAIGCGenerate$GenerateRequest $request;
    final /* synthetic */ long $timeStamp;
    int label;
    final /* synthetic */ AdelieAvatarEditTextView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieAvatarEditTextView$initView$3$1(AdelieAvatarEditTextView adelieAvatarEditTextView, ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest, View view, Ref.ObjectRef<String> objectRef, long j3, Continuation<? super AdelieAvatarEditTextView$initView$3$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieAvatarEditTextView;
        this.$request = shadowAIGCGenerate$GenerateRequest;
        this.$btn = view;
        this.$reportInput = objectRef;
        this.$timeStamp = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieAvatarEditTextView$initView$3$1(this.this$0, this.$request, this.$btn, this.$reportInput, this.$timeStamp, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ShadowAIGCGenerate$GenerateReply date;
        PBStringField pBStringField;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        String str = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdelieAvatarEditTextView$initView$3$1$fullReply$1 adelieAvatarEditTextView$initView$3$1$fullReply$1 = new AdelieAvatarEditTextView$initView$3$1$fullReply$1(this.$request, null);
            this.label = 1;
            obj = TimeoutKt.withTimeout(30000L, adelieAvatarEditTextView$initView$3$1$fullReply$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AdelieGenerateImageRequest.FullReply fullReply = (AdelieGenerateImageRequest.FullReply) obj;
        final AdelieAvatarEditTextView adelieAvatarEditTextView = this.this$0;
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$initView$3$1.1
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
                AdelieAvatarEditTextView.this.q();
            }
        });
        boolean z16 = false;
        if (fullReply != null && fullReply.getErrorCode() == 0) {
            z16 = true;
        }
        long j3 = -1;
        if (!z16) {
            AdelieAvatarEditTextView adelieAvatarEditTextView2 = this.this$0;
            if (fullReply != null) {
                j3 = fullReply.getErrorCode();
            }
            adelieAvatarEditTextView2.y(j3);
            final View view = this.$btn;
            final Ref.ObjectRef<String> objectRef = this.$reportInput;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$initView$3$1.2
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
                    Map mapOf;
                    View view2 = view;
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("input_text", objectRef.element), TuplesKt.to("output_text", ""));
                    VideoReport.reportEvent("clck", view2, mapOf);
                }
            });
            return Unit.INSTANCE;
        }
        if (fullReply != null && (date = fullReply.getDate()) != null && (pBStringField = date.extra) != null) {
            long j16 = this.$timeStamp;
            final View view2 = this.$btn;
            final Ref.ObjectRef<String> objectRef2 = this.$reportInput;
            final AdelieAvatarEditTextView adelieAvatarEditTextView3 = this.this$0;
            final GenerateResultExtra generateResultExtra = (GenerateResultExtra) new Gson().fromJson(pBStringField.get(), GenerateResultExtra.class);
            QLog.i("AdelieAvatarEditTextView", 1, "[UGC-QQ-Agent][Performance] AI generate description time: " + (System.currentTimeMillis() - j16));
            if (generateResultExtra != null) {
                str = generateResultExtra.getResultDesc();
            }
            if (str == null) {
                QLog.e("AdelieAvatarEditTextView", 1, "AI generate description result is null");
            } else {
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$initView$3$1$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        Map mapOf;
                        InterceptTouchEditText interceptTouchEditText;
                        View view3 = view2;
                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("input_text", objectRef2.element), TuplesKt.to("output_text", generateResultExtra.getResultDesc()));
                        VideoReport.reportEvent("clck", view3, mapOf);
                        interceptTouchEditText = adelieAvatarEditTextView3.editTextView;
                        if (interceptTouchEditText != null) {
                            interceptTouchEditText.setText(generateResultExtra.getResultDesc(), TextView.BufferType.NORMAL);
                        }
                    }
                });
                return Unit.INSTANCE;
            }
        }
        this.this$0.y(-1L);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieAvatarEditTextView$initView$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
