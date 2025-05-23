package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.config.GuildShare2WechatParser;
import com.tencent.mobileqq.guild.share.util.GuildWXShareUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.util.QQToastUtil;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedShareToWXHelper$startShare$3", f = "GuildFeedShareToWXHelper.kt", i = {1, 1, 1}, l = {101, 112}, m = "invokeSuspend", n = {"shareUrl", "shareConfig", "sharePath"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes13.dex */
public final class GuildFeedShareToWXHelper$startShare$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GuildFeedShareToWXInfo $info;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareToWXHelper$startShare$3(GuildFeedShareToWXInfo guildFeedShareToWXInfo, Context context, Continuation<? super GuildFeedShareToWXHelper$startShare$3> continuation) {
        super(2, continuation);
        this.$info = guildFeedShareToWXInfo;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedShareToWXHelper$startShare$3(this.$info, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String m3;
        Object n3;
        String str;
        com.tencent.mobileqq.guild.config.q qVar;
        int intValue;
        String title;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    String str2 = (String) this.L$2;
                    qVar = (com.tencent.mobileqq.guild.config.q) this.L$1;
                    String str3 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    m3 = str2;
                    str = str3;
                    Pair pair = (Pair) obj;
                    intValue = ((Number) pair.component1()).intValue();
                    Bitmap bitmap = (Bitmap) pair.component2();
                    if (intValue != 5 && this.$info.getFeedInfo().contents.contents.size() == 1) {
                        title = "\u5206\u4eab\u9644\u4ef6\uff1a" + this.$info.getTitle();
                    } else {
                        title = this.$info.getTitle();
                    }
                    ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).shareTargetMiniProgramToWX(qVar.getWxAppId(), m3, qVar.getProgramOriginAppId(), bitmap, title, this.$info.getDesc(), str);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            GuildFeedShareToWXHelper guildFeedShareToWXHelper = GuildFeedShareToWXHelper.f220290a;
            GuildFeedShareToWXInfo guildFeedShareToWXInfo = this.$info;
            this.label = 1;
            obj = guildFeedShareToWXHelper.i(guildFeedShareToWXInfo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        String str4 = (String) obj;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "shareUrl:" + str4);
        }
        com.tencent.mobileqq.guild.config.q a16 = GuildShare2WechatParser.INSTANCE.a();
        m3 = GuildWXShareUtils.m(str4, 2, a16);
        if (MiscKt.f(m3)) {
            GuildFeedShareToWXInfo guildFeedShareToWXInfo2 = this.$info;
            logger.d().w("Guild.share.GuildFeedShareToWXHelper", 1, "startShare title:" + guildFeedShareToWXInfo2.getTitle() + " sharePath:" + m3);
            QQToastUtil.showQQToastInUiThread(1, ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
            return Unit.INSTANCE;
        }
        GuildFeedShareToWXInfo guildFeedShareToWXInfo3 = this.$info;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "startShare title:" + guildFeedShareToWXInfo3.getTitle() + " sharePath:" + m3);
        }
        GuildFeedShareToWXHelper guildFeedShareToWXHelper2 = GuildFeedShareToWXHelper.f220290a;
        Context context = this.$context;
        GuildFeedShareToWXInfo guildFeedShareToWXInfo4 = this.$info;
        this.L$0 = str4;
        this.L$1 = a16;
        this.L$2 = m3;
        this.label = 2;
        n3 = guildFeedShareToWXHelper2.n(context, guildFeedShareToWXInfo4, this);
        if (n3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        str = str4;
        obj = n3;
        qVar = a16;
        Pair pair2 = (Pair) obj;
        intValue = ((Number) pair2.component1()).intValue();
        Bitmap bitmap2 = (Bitmap) pair2.component2();
        if (intValue != 5) {
        }
        title = this.$info.getTitle();
        ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).shareTargetMiniProgramToWX(qVar.getWxAppId(), m3, qVar.getProgramOriginAppId(), bitmap2, title, this.$info.getDesc(), str);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedShareToWXHelper$startShare$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
