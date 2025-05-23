package com.tencent.mobileqq.guild.share.llmchat;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet;
import com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.f;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareHelper$startShareMultiPlatform$3", f = "GuildLLMChatShareHelper.kt", i = {0}, l = {59}, m = "invokeSuspend", n = {"$this$qLaunch"}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class GuildLLMChatShareHelper$startShareMultiPlatform$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> $adapter;
    final /* synthetic */ List<f> $msgs;
    final /* synthetic */ String $sid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildLLMChatShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildLLMChatShareHelper$startShareMultiPlatform$3(GuildLLMChatShareHelper guildLLMChatShareHelper, GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> bVar, String str, List<? extends f> list, Continuation<? super GuildLLMChatShareHelper$startShareMultiPlatform$3> continuation) {
        super(2, continuation);
        this.this$0 = guildLLMChatShareHelper;
        this.$adapter = bVar;
        this.$sid = str;
        this.$msgs = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildLLMChatShareHelper$startShareMultiPlatform$3 guildLLMChatShareHelper$startShareMultiPlatform$3 = new GuildLLMChatShareHelper$startShareMultiPlatform$3(this.this$0, this.$adapter, this.$sid, this.$msgs, continuation);
        guildLLMChatShareHelper$startShareMultiPlatform$3.L$0 = obj;
        return guildLLMChatShareHelper$startShareMultiPlatform$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        GuildLLMChatShareActionSheet guildLLMChatShareActionSheet;
        GuildLLMChatShareActionSheet guildLLMChatShareActionSheet2;
        boolean isBlank;
        GuildLLMChatShareActionSheet guildLLMChatShareActionSheet3;
        Object c16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    c16 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                GuildLLMChatShareHelper guildLLMChatShareHelper = this.this$0;
                String str = this.$sid;
                List<f> list = this.$msgs;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = coroutineScope;
                this.label = 1;
                c16 = guildLLMChatShareHelper.c(str, list, this);
                if (c16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m476constructorimpl = Result.m476constructorimpl((GuildLLMChatShareHelper.UrlResp) c16);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        GuildLLMChatShareHelper guildLLMChatShareHelper2 = this.this$0;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            if (m479exceptionOrNullimpl instanceof GuildLLMChatShareHelper.BeBannedError) {
                GuildLLMChatShareHelper.BeBannedError beBannedError = (GuildLLMChatShareHelper.BeBannedError) m479exceptionOrNullimpl;
                isBlank = StringsKt__StringsJVMKt.isBlank(beBannedError.getMsg());
                if (true ^ isBlank) {
                    guildLLMChatShareActionSheet3 = guildLLMChatShareHelper2.mainShareSheet;
                    guildLLMChatShareActionSheet3.L(beBannedError.getMsg());
                }
            }
            guildLLMChatShareActionSheet2 = guildLLMChatShareHelper2.mainShareSheet;
            guildLLMChatShareActionSheet2.L("\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        GuildLLMChatShareHelper.UrlResp urlResp = (GuildLLMChatShareHelper.UrlResp) m476constructorimpl;
        if (urlResp == null) {
            return Unit.INSTANCE;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildLLMChatShareHelper", "fetched url " + urlResp);
        }
        guildLLMChatShareActionSheet = this.this$0.mainShareSheet;
        String shareUrl = urlResp.getShareUrl();
        Intrinsics.checkNotNullExpressionValue(shareUrl, "urlInfo.shareUrl");
        String shareTitle = urlResp.getShareTitle();
        Intrinsics.checkNotNullExpressionValue(shareTitle, "urlInfo.shareTitle");
        String anwserDescription = urlResp.getAnwserDescription();
        Intrinsics.checkNotNullExpressionValue(anwserDescription, "urlInfo.anwserDescription");
        String shareIcon = urlResp.getShareIcon();
        Intrinsics.checkNotNullExpressionValue(shareIcon, "urlInfo.shareIcon");
        String tailIcon = urlResp.getTailIcon();
        Intrinsics.checkNotNullExpressionValue(tailIcon, "urlInfo.tailIcon");
        String tailDescription = urlResp.getTailDescription();
        Intrinsics.checkNotNullExpressionValue(tailDescription, "urlInfo.tailDescription");
        String brandDescription = urlResp.getBrandDescription();
        Intrinsics.checkNotNullExpressionValue(brandDescription, "urlInfo.brandDescription");
        String shareModelDescription = urlResp.getShareModelDescription();
        Intrinsics.checkNotNullExpressionValue(shareModelDescription, "urlInfo.shareModelDescription");
        GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> bVar = this.$adapter;
        GuildAISearchConfBean.Companion companion3 = GuildAISearchConfBean.INSTANCE;
        guildLLMChatShareActionSheet.M(new GuildLLMChatShareActionSheet.ShareParam(shareUrl, shareTitle, anwserDescription, shareIcon, tailIcon, tailDescription, brandDescription, shareModelDescription, bVar, companion3.a().getIconUrl(), companion3.a().getCom.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants.KEY_PAGE_TITLE java.lang.String(), 5000L));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildLLMChatShareHelper$startShareMultiPlatform$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
