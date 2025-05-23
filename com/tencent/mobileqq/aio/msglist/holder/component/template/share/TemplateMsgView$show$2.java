package com.tencent.mobileqq.aio.msglist.holder.component.template.share;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.h;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.m;
import com.tencent.mobileqq.aio.msglist.holder.component.template.report.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.rich.c;
import com.tencent.qqnt.rich.j;
import com.tencent.qqnt.rich.p;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.template.share.TemplateMsgView$show$2", f = "TemplateMsgView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class TemplateMsgView$show$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ h $buildResult;
    final /* synthetic */ c $dataInfo;
    final /* synthetic */ b $performanceReporter;
    final /* synthetic */ int $targetWidth;
    final /* synthetic */ d $templateMsgInfo;
    int label;
    final /* synthetic */ TemplateMsgView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateMsgView$show$2(TemplateMsgView templateMsgView, c cVar, int i3, b bVar, h hVar, d dVar, Continuation<? super TemplateMsgView$show$2> continuation) {
        super(2, continuation);
        this.this$0 = templateMsgView;
        this.$dataInfo = cVar;
        this.$targetWidth = i3;
        this.$performanceReporter = bVar;
        this.$buildResult = hVar;
        this.$templateMsgInfo = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, templateMsgView, cVar, Integer.valueOf(i3), bVar, hVar, dVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TemplateMsgView$show$2(this.this$0, this.$dataInfo, this.$targetWidth, this.$performanceReporter, this.$buildResult, this.$templateMsgInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.removeAllViews();
                c cVar = this.$dataInfo;
                if (cVar != null) {
                    j jVar = new j(cVar, null, this.$targetWidth, new p(null, null, 0, 0.0f, 0, 0.0f, 0.0f, 0, 255, null), null, 18, null);
                    m mVar = m.f191935a;
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    m.b(mVar, context, this.this$0, jVar, null, 8, null);
                    if (this.this$0.getChildCount() == 0) {
                        b bVar = this.$performanceReporter;
                        String b16 = this.$buildResult.b();
                        if (b16 == null) {
                            b16 = "child_count_zero";
                        }
                        bVar.h("preview_ark2md_render_fail", -3, b16);
                    } else {
                        this.$performanceReporter.i("preview_ark2md_render_success", null);
                    }
                } else {
                    b bVar2 = this.$performanceReporter;
                    String b17 = this.$buildResult.b();
                    if (b17 == null) {
                        b17 = "dataInfo_got_null";
                    }
                    bVar2.h("preview_ark2md_render_fail", -2, b17);
                }
                this.this$0.A0(this.$templateMsgInfo);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TemplateMsgView$show$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
