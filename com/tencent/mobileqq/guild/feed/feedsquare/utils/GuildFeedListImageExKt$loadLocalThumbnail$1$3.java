package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt$loadLocalThumbnail$1$3", f = "GuildFeedListImageEx.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedListImageExKt$loadLocalThumbnail$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $coverHeight;
    final /* synthetic */ int $coverWidth;
    final /* synthetic */ GProStVideo $this_with;
    final /* synthetic */ ImageView $view;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedListImageExKt$loadLocalThumbnail$1$3(GProStVideo gProStVideo, int i3, int i16, ImageView imageView, Continuation<? super GuildFeedListImageExKt$loadLocalThumbnail$1$3> continuation) {
        super(2, continuation);
        this.$this_with = gProStVideo;
        this.$coverWidth = i3;
        this.$coverHeight = i16;
        this.$view = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedListImageExKt$loadLocalThumbnail$1$3(this.$this_with, this.$coverWidth, this.$coverHeight, this.$view, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        Integer num;
        Integer num2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GProStVideo gProStVideo = this.$this_with;
            int i16 = this.$coverWidth;
            int i17 = this.$coverHeight;
            try {
                Result.Companion companion = Result.INSTANCE;
                String playUrl = gProStVideo.playUrl;
                Intrinsics.checkNotNullExpressionValue(playUrl, "playUrl");
                m476constructorimpl = Result.m476constructorimpl(f11.c.n(playUrl, Math.max(i16, i17)));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            GProStVideo gProStVideo2 = this.$this_with;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "failed to get video thumbnail for " + gProStVideo2.playUrl;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedListImageEx", 1, (String) it.next(), m479exceptionOrNullimpl);
                }
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            Bitmap bitmap = (Bitmap) m476constructorimpl;
            Logger logger2 = Logger.f235387a;
            GProStVideo gProStVideo3 = this.$this_with;
            Logger.a d16 = logger2.d();
            if (bitmap != null) {
                num = Boxing.boxInt(bitmap.getWidth());
            } else {
                num = null;
            }
            if (bitmap != null) {
                num2 = Boxing.boxInt(bitmap.getHeight());
            } else {
                num2 = null;
            }
            d16.d("GuildFeedListImageEx", 1, "loadLocalThumbnail: " + num + HippyTKDListViewAdapter.X + num2 + ", url: " + gProStVideo3.playUrl);
            if (bitmap != null) {
                ImageView imageView = this.$view;
                GProStVideo gProStVideo4 = this.$this_with;
                MainCoroutineDispatcher e16 = ae.a().e();
                GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1 guildFeedListImageExKt$loadLocalThumbnail$1$3$2$1 = new GuildFeedListImageExKt$loadLocalThumbnail$1$3$2$1(imageView, bitmap, gProStVideo4, null);
                this.label = 1;
                if (BuildersKt.withContext(e16, guildFeedListImageExKt$loadLocalThumbnail$1$3$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedListImageExKt$loadLocalThumbnail$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
