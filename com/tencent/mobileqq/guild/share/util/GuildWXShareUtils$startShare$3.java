package com.tencent.mobileqq.guild.share.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.config.GuildShare2WechatParser;
import com.tencent.mobileqq.guild.config.q;
import com.tencent.mobileqq.guild.share.util.GuildWXShareUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.util.QQToastUtil;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.util.GuildWXShareUtils$startShare$3", f = "GuildWXShareUtils.kt", i = {1, 1, 1}, l = {97, 108}, m = "invokeSuspend", n = {"urlAndCountInfo", "shareConfig", "sharePath"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes14.dex */
public final class GuildWXShareUtils$startShare$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GuildShareToWXInfo $info;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildWXShareUtils$startShare$3(GuildShareToWXInfo guildShareToWXInfo, Context context, Continuation<? super GuildWXShareUtils$startShare$3> continuation) {
        super(2, continuation);
        this.$info = guildShareToWXInfo;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildWXShareUtils$startShare$3(this.$info, this.$context, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0112  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object h16;
        Object k3;
        GuildWXShareUtils.GuildShareUrlAndCountInfo guildShareUrlAndCountInfo;
        q qVar;
        String str;
        String n3;
        String substring;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    String str2 = (String) this.L$2;
                    qVar = (q) this.L$1;
                    guildShareUrlAndCountInfo = (GuildWXShareUtils.GuildShareUrlAndCountInfo) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = str2;
                    k3 = obj;
                    Bitmap bitmap = (Bitmap) k3;
                    IShareActionHelper iShareActionHelper = (IShareActionHelper) QRoute.api(IShareActionHelper.class);
                    String wxAppId = qVar.getWxAppId();
                    String programOriginAppId = qVar.getProgramOriginAppId();
                    n3 = GuildWXShareUtils.f235114a.n(this.$info);
                    if (this.$info.getDesc().length() >= 100) {
                        substring = this.$info.getDesc();
                    } else {
                        substring = this.$info.getDesc().substring(0, 95);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    }
                    iShareActionHelper.shareTargetMiniProgramToWX(wxAppId, str, programOriginAppId, bitmap, n3, substring, guildShareUrlAndCountInfo.getShareUrl());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            h16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            GuildWXShareUtils guildWXShareUtils = GuildWXShareUtils.f235114a;
            GuildShareToWXInfo guildShareToWXInfo = this.$info;
            this.label = 1;
            h16 = guildWXShareUtils.h(guildShareToWXInfo, this);
            if (h16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildWXShareUtils.GuildShareUrlAndCountInfo guildShareUrlAndCountInfo2 = (GuildWXShareUtils.GuildShareUrlAndCountInfo) h16;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildWXShareUtils", 1, "startShare urlAndCountInfo:" + guildShareUrlAndCountInfo2);
        }
        q a16 = GuildShare2WechatParser.INSTANCE.a();
        String m3 = GuildWXShareUtils.m(guildShareUrlAndCountInfo2.getShareUrl(), this.$info.getBusinessType(), a16);
        if (MiscKt.f(m3)) {
            logger.d().w("Guild.share.GuildWXShareUtils", 1, "startShare sharePath:" + m3);
            QQToastUtil.showQQToastInUiThread(1, ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
            return Unit.INSTANCE;
        }
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildWXShareUtils", 1, "startShare sharePath:" + m3);
        }
        GuildWXShareUtils guildWXShareUtils2 = GuildWXShareUtils.f235114a;
        Context context = this.$context;
        GuildShareToWXInfo guildShareToWXInfo2 = this.$info;
        long memberCount = guildShareUrlAndCountInfo2.getMemberCount();
        long feedCount = guildShareUrlAndCountInfo2.getFeedCount();
        this.L$0 = guildShareUrlAndCountInfo2;
        this.L$1 = a16;
        this.L$2 = m3;
        this.label = 2;
        k3 = guildWXShareUtils2.k(context, guildShareToWXInfo2, memberCount, feedCount, this);
        if (k3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        guildShareUrlAndCountInfo = guildShareUrlAndCountInfo2;
        qVar = a16;
        str = m3;
        Bitmap bitmap2 = (Bitmap) k3;
        IShareActionHelper iShareActionHelper2 = (IShareActionHelper) QRoute.api(IShareActionHelper.class);
        String wxAppId2 = qVar.getWxAppId();
        String programOriginAppId2 = qVar.getProgramOriginAppId();
        n3 = GuildWXShareUtils.f235114a.n(this.$info);
        if (this.$info.getDesc().length() >= 100) {
        }
        iShareActionHelper2.shareTargetMiniProgramToWX(wxAppId2, str, programOriginAppId2, bitmap2, n3, substring, guildShareUrlAndCountInfo.getShareUrl());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildWXShareUtils$startShare$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
