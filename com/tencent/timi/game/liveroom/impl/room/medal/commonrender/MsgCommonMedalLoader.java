package com.tencent.timi.game.liveroom.impl.room.medal.commonrender;

import android.graphics.Bitmap;
import android.text.SpannableString;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.medal.commonrender.MedalLayoutStyleConfig;
import com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr4.g;
import tl.h;
import uq4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u0019\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001d\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0015R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/MsgCommonMedalLoader;", "", "", "roomId", "Lsr4/g;", "medalInfo", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/b;", "g", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "drawConfig", "Landroid/text/SpannableString;", "d", "Lcom/tencent/libra/request/Option;", "option", "f", "(Lcom/tencent/libra/request/Option;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "userMedalInfo", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c$b;", "callback", "", h.F, "e", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "downloadScope", "<init>", "()V", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MsgCommonMedalLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CoroutineScope downloadScope;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/MsgCommonMedalLoader$b;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "", "execute", "", "d", "I", "getType", "()I", "type", "<init>", "(I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements Executor {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        public b(int i3) {
            this.type = i3;
        }

        @Override // java.util.concurrent.Executor
        public void execute(@Nullable Runnable command) {
            ThreadManagerV2.excute(command, this.type, null, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/medal/commonrender/MsgCommonMedalLoader$c", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Bitmap> f377961d;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Bitmap> cancellableContinuation) {
            this.f377961d = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            boolean z16;
            if (this.f377961d.isActive()) {
                boolean z17 = true;
                if (state != null && state.isFinishSuccess()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Bitmap bitmap = null;
                if (z16) {
                    CancellableContinuation<Bitmap> cancellableContinuation = this.f377961d;
                    Result.Companion companion = Result.INSTANCE;
                    if (option != null) {
                        bitmap = option.getResultBitMap();
                    }
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(bitmap));
                    return;
                }
                if (state == null || !state.isFinishError()) {
                    z17 = false;
                }
                if (z17) {
                    this.f377961d.resumeWith(Result.m476constructorimpl(null));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpannableString d(Bitmap bitmap, g medalInfo, MedalLayoutStyleConfig drawConfig) {
        a aVar = new a(bitmap, medalInfo, drawConfig);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(aVar, 0, 1, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(Option option, Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QCircleFeedPicLoader.g().loadImage(option, new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MedalLayoutStyleConfig g(long roomId, g medalInfo) {
        MedalLayoutStyleConfig medalLayoutStyleConfig;
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        String str = medalInfo.B.f434409a;
        Intrinsics.checkNotNullExpressionValue(str, "medalInfo.layoutStyle.id");
        g.a m3 = busConfigHelper.m(roomId, str);
        if (m3 != null) {
            MedalLayoutStyleConfig.Companion companion = MedalLayoutStyleConfig.INSTANCE;
            String str2 = m3.f439853b;
            Intrinsics.checkNotNullExpressionValue(str2, "styleConfig.format");
            medalLayoutStyleConfig = companion.a(str2);
        } else {
            medalLayoutStyleConfig = null;
        }
        if (medalLayoutStyleConfig == null) {
            AegisLogger.INSTANCE.e("Chat_Message|MsgCommonMedalRender", "getDrawConfig fail", "styleConfig=" + m3 + ", medalInfo=" + medalInfo);
        }
        return medalLayoutStyleConfig;
    }

    public final void e() {
        CoroutineScope coroutineScope = this.downloadScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel(coroutineScope, null);
        }
    }

    public final void h(long roomId, @NotNull com.tencent.mobileqq.qqlive.widget.chat.data.b userMedalInfo, @NotNull c.b callback) {
        Intrinsics.checkNotNullParameter(userMedalInfo, "userMedalInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CoroutineScope coroutineScope = this.downloadScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel(coroutineScope, null);
        }
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(new b(16)));
        this.downloadScope = CoroutineScope;
        if (CoroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new MsgCommonMedalLoader$load$1(userMedalInfo, this, roomId, callback, null), 3, null);
        }
    }
}
