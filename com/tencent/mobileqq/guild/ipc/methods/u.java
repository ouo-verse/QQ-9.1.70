package com.tencent.mobileqq.guild.ipc.methods;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.feed.picshare.restorer.FeedDetailJsonParser;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import eipc.EIPCResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bd;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J;\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/u;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "", "feedJson", "", "g", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u extends AbsIpcMethod {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Bitmap bitmap, String jsonStr, String feedId, String guildId, String channelId, AppRuntime appRuntime, int i3, String str, IGProFetchShareUrlRsp iGProFetchShareUrlRsp) {
        Intrinsics.checkNotNullParameter(jsonStr, "$jsonStr");
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        QLog.i("GuildShowPicShareIpcMethod", 1, "fetchShareUrlReq result=" + i3 + " errMsg=" + str + " shareUrl=" + iGProFetchShareUrlRsp);
        if (i3 == 0 && !TextUtils.isEmpty(iGProFetchShareUrlRsp.getShareLink())) {
            Bundle bundle = new Bundle();
            if (bitmap != null) {
                ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).putBgBitmapToCache(bitmap);
            }
            bundle.putString("guild_content_share_url_key", iGProFetchShareUrlRsp.getShareLink());
            bundle.putString("guild_content_share_data_key", jsonStr);
            bundle.putString("sgrp_content_id", feedId);
            bundle.putString("sgrp_channel_id", guildId);
            bundle.putString("sgrp_sub_channel_id", channelId);
            ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).startContentShareFragment(appRuntime.getApplicationContext(), bundle, 1);
            return;
        }
        QQToastUtil.showQQToast(-1, str);
    }

    private final void g(final String feedJson) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.ipc.methods.t
            @Override // java.lang.Runnable
            public final void run() {
                u.h(feedJson);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String feedJson) {
        Intrinsics.checkNotNullParameter(feedJson, "$feedJson");
        QLog.i("GuildShowPicShareIpcMethod", 4, "onPreLoadAsync");
        FeedDetailJsonParser feedDetailJsonParser = new FeedDetailJsonParser();
        feedDetailJsonParser.parser(feedJson);
        ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).doPreload(feedDetailJsonParser, feedDetailJsonParser.getGuildId());
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@Nullable AbsIpcMethod.a context, @Nullable String method, @NotNull Object... arguments) {
        Bitmap bitmap;
        Integer num;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        final String str = (String) obj;
        Object obj2 = arguments[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        final String str2 = (String) obj2;
        Object obj3 = arguments[2];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        String str3 = (String) obj3;
        Object obj4 = arguments[3];
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
        final String str4 = (String) obj4;
        Object obj5 = arguments[4];
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
        final String str5 = (String) obj5;
        Object obj6 = arguments[5];
        Integer num2 = null;
        if (obj6 instanceof Bitmap) {
            bitmap = (Bitmap) obj6;
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            num = Integer.valueOf(bitmap.getHeight());
        } else {
            num = null;
        }
        if (bitmap != null) {
            num2 = Integer.valueOf(bitmap.getWidth());
        }
        QLog.i("GuildShowPicShareIpcMethod", 2, "doInvoke guildId=" + str + " channelId=" + str2 + " feedType=" + str3 + " feedId=" + str4 + " jsonStr=" + str5 + " bitmapHeight=" + num + " bitmapWidth=" + num2);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(R.string.f1511016s);
            Bundle bundle = new Bundle();
            if (context != null) {
                context.b(bundle);
            }
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(bundle);
            Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(bundle)");
            return createSuccessResult;
        }
        g(str5);
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final Bitmap bitmap2 = bitmap;
        ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "all")).fetchShareUrlReq(Long.parseLong(str), Long.parseLong(str2), 0L, str4, new com.tencent.mobileqq.qqguildsdk.data.genc.aw(), new ArrayList<>(), new bd() { // from class: com.tencent.mobileqq.guild.ipc.methods.s
            @Override // wh2.bd
            public final void a(int i3, String str6, IGProFetchShareUrlRsp iGProFetchShareUrlRsp) {
                u.f(bitmap2, str5, str4, str, str2, peekAppRuntime, i3, str6, iGProFetchShareUrlRsp);
            }
        });
        Bundle bundle2 = new Bundle();
        if (context != null) {
            context.b(bundle2);
        }
        EIPCResult createSuccessResult2 = EIPCResult.createSuccessResult(bundle2);
        Intrinsics.checkNotNullExpressionValue(createSuccessResult2, "createSuccessResult(bundle)");
        return createSuccessResult2;
    }
}
