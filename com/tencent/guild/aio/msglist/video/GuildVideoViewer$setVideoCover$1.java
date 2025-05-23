package com.tencent.guild.aio.msglist.video;

import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.qqnt.videoplay.api.view.NTAIOBubbleVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.tencent.guild.aio.msglist.video.GuildVideoViewer$setVideoCover$1", f = "GuildVideoViewer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildVideoViewer$setVideoCover$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ColorDrawable $defaultDrawable;
    final /* synthetic */ GuildMsgItem $msgItem;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildVideoViewer this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/video/GuildVideoViewer$setVideoCover$1$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f111980e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GuildMsgItem guildMsgItem) {
            super(false);
            this.f111980e = guildMsgItem;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            boolean z16 = false;
            if (state != null && state.isFinishError()) {
                z16 = true;
            }
            if (z16) {
                QLog.i("GuildVideoViewer", 1, "[setVideoCover] error: " + state + ", msgSeq: " + this.f111980e.getMsgSeq() + ", msgId: " + this.f111980e.getMsgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildVideoViewer$setVideoCover$1(GuildVideoViewer guildVideoViewer, GuildMsgItem guildMsgItem, ColorDrawable colorDrawable, Continuation<? super GuildVideoViewer$setVideoCover$1> continuation) {
        super(2, continuation);
        this.this$0 = guildVideoViewer;
        this.$msgItem = guildMsgItem;
        this.$defaultDrawable = colorDrawable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildVideoViewer$setVideoCover$1 guildVideoViewer$setVideoCover$1 = new GuildVideoViewer$setVideoCover$1(this.this$0, this.$msgItem, this.$defaultDrawable, continuation);
        guildVideoViewer$setVideoCover$1.L$0 = obj;
        return guildVideoViewer$setVideoCover$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String J;
        boolean z16;
        NTAIOBubbleVideoView nTAIOBubbleVideoView;
        ImageView imageView;
        NTAIOBubbleVideoView nTAIOBubbleVideoView2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            J = this.this$0.J(this.$msgItem);
            boolean exists = new File(J).exists();
            QLog.d("GuildVideoViewer", 1, "setVideoCover, " + coroutineScope.hashCode() + ", msgSeq: " + this.$msgItem.getMsgSeq() + ", thumbPath: " + J + ", FileExists: " + exists);
            if (J.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && exists) {
                nTAIOBubbleVideoView = this.this$0.videoView;
                ImageView imageView2 = null;
                if (nTAIOBubbleVideoView != null) {
                    imageView = nTAIOBubbleVideoView.c();
                } else {
                    imageView = null;
                }
                if (imageView != null) {
                    Pair<Integer, Integer> e16 = com.tencent.guild.aio.msglist.video.a.f111981a.e(this.$msgItem);
                    int intValue = e16.component1().intValue();
                    int intValue2 = e16.component2().intValue();
                    Option option = new Option();
                    nTAIOBubbleVideoView2 = this.this$0.videoView;
                    if (nTAIOBubbleVideoView2 != null) {
                        imageView2 = nTAIOBubbleVideoView2.c();
                    }
                    com.tencent.mobileqq.guild.picload.e.a().f(option.setTargetView(imageView2).setNeedFilterUrl(false).setPredecode(true).setUrl(J).setRequestWidth(intValue).setRequestHeight(intValue2).setLoadingDrawable(this.$defaultDrawable).setFailDrawable(this.$defaultDrawable), new a(this.$msgItem));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildVideoViewer$setVideoCover$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
