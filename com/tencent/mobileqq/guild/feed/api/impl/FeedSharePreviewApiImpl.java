package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi;
import com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer;
import com.tencent.mobileqq.guild.feed.share.preview.PreviewFragment;
import com.tencent.mobileqq.guild.quiprofile.GuildContextWrapper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedSharePreviewApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$b;", "reqParams", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$a;", "Landroid/graphics/Bitmap;", "callback", "", "requestBitmap", "Landroid/view/View;", "requestView", "Landroid/os/Bundle;", "arguments", "showDemoFragment", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSharePreviewApiImpl implements IFeedSharePreviewApi {

    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestView$lambda$2(FeedSharePreviewApiImpl this$0, IFeedSharePreviewApi.a callback, Context context, IFeedSharePreviewApi.ReqParams reqParams) {
        Object m476constructorimpl;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(reqParams, "$reqParams");
        try {
            Result.Companion companion = Result.INSTANCE;
            GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer = new GuildFeedShareNormalPreviewContainer(new GuildContextWrapper(context, 1001), null, 0, 6, null);
            guildFeedShareNormalPreviewContainer.setParams(reqParams);
            mw1.a.f417705a.f(guildFeedShareNormalPreviewContainer);
            m476constructorimpl = Result.m476constructorimpl(guildFeedShareNormalPreviewContainer);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            obj = null;
        } else {
            obj = m476constructorimpl;
        }
        GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer2 = (GuildFeedShareNormalPreviewContainer) obj;
        if (guildFeedShareNormalPreviewContainer2 != null) {
            BuildersKt__Builders_commonKt.launch$default(this$0.coroutineScope, null, null, new FeedSharePreviewApiImpl$requestView$1$1(callback, guildFeedShareNormalPreviewContainer2, null), 3, null);
        } else {
            callback.onResult(m476constructorimpl);
        }
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi
    public void requestBitmap(@NotNull Context context, @NotNull IFeedSharePreviewApi.ReqParams reqParams, @NotNull final IFeedSharePreviewApi.a<Bitmap> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reqParams, "reqParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        requestView(context, reqParams, new IFeedSharePreviewApi.a<View>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedSharePreviewApiImpl$requestBitmap$1
            @Override // com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi.a
            public void onResult(@NotNull Object result) {
                Object obj;
                if (Result.m482isFailureimpl(result)) {
                    obj = null;
                } else {
                    obj = result;
                }
                View view = (View) obj;
                if (Result.m483isSuccessimpl(result) && view != null) {
                    BuildersKt__Builders_commonKt.launch$default(FeedSharePreviewApiImpl.this.getCoroutineScope(), null, null, new FeedSharePreviewApiImpl$requestBitmap$1$onResult$1(callback, view, null), 3, null);
                    return;
                }
                IFeedSharePreviewApi.a<Bitmap> aVar = callback;
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(result);
                if (m479exceptionOrNullimpl == null) {
                    m479exceptionOrNullimpl = new IFeedSharePreviewApi.FeedShareException("Failed to get view", null, 2, null);
                }
                aVar.onResult(Result.m476constructorimpl(ResultKt.createFailure(m479exceptionOrNullimpl)));
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi
    public void requestView(@NotNull final Context context, @NotNull final IFeedSharePreviewApi.ReqParams reqParams, @NotNull final IFeedSharePreviewApi.a<View> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reqParams, "reqParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                FeedSharePreviewApiImpl.requestView$lambda$2(FeedSharePreviewApiImpl.this, callback, context, reqParams);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi
    public void showDemoFragment(@NotNull Context context, @NotNull Bundle arguments) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        PreviewFragment.INSTANCE.a(context, arguments);
    }
}
