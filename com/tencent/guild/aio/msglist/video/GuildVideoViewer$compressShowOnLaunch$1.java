package com.tencent.guild.aio.msglist.video;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.msglist.video.GuildVideoViewer$compressShowOnLaunch$1", f = "GuildVideoViewer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildVideoViewer$compressShowOnLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildVideoViewer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildVideoViewer$compressShowOnLaunch$1(GuildVideoViewer guildVideoViewer, Continuation<? super GuildVideoViewer$compressShowOnLaunch$1> continuation) {
        super(2, continuation);
        this.this$0 = guildVideoViewer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildVideoViewer$compressShowOnLaunch$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MsgElement msgElement;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            msgElement = this.this$0.com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants.TAG.ELEMENT java.lang.String;
            if (msgElement != null) {
                GuildVideoViewer guildVideoViewer = this.this$0;
                viewGroup = guildVideoViewer.binding;
                TextView textView = (TextView) viewGroup.findViewById(R.id.f110116hn);
                textView.setText("\u538b\u7f29\u4e2d");
                textView.setTextSize(7.0f);
                viewGroup2 = guildVideoViewer.binding;
                ((ProgressBar) viewGroup2.findViewById(R.id.fk5)).setProgress(0);
                viewGroup3 = guildVideoViewer.binding;
                ((FrameLayout) viewGroup3.findViewById(R.id.fk6)).setVisibility(0);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildVideoViewer$compressShowOnLaunch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
