package com.tencent.mobileqq.guild.share;

import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.av;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.at;
import wh2.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 JP\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J>\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J+\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJR\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001dH\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildShareWrapper;", "", "", "guildId", "channelId", "", "businessType", "", "businessParam", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/ey;", "Lkotlin/collections/ArrayList;", "urlParams", "Lcom/tencent/mobileqq/guild/share/t;", "cb", "", "e", "Lcom/tencent/mobileqq/guild/share/z;", "shortUrlResult", "longUrlResult", "d", "", "isShortUrl", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/av;", tl.h.F, "", "reqInfo", "f", "(JJLcom/tencent/mobileqq/qqguildsdk/data/genc/av;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lvh2/at;", "g", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildShareWrapper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildShareWrapper f234954a = new GuildShareWrapper();

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JX\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/share/GuildShareWrapper$a", "Lwh2/bc;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "secResult", "shareUrl", "shareInfo", "", "shareExpiredTime", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProQRCodeShareInfo;", "qRShareInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProShareExtendInfo;", "shareExtendInfo", "attaContentId", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements bc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<ShareInfoResult> f234955a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super ShareInfoResult> continuation) {
            this.f234955a = continuation;
        }

        @Override // wh2.bc
        public void a(int result, @NotNull String errMsg, @Nullable IGProSecurityResult secResult, @NotNull String shareUrl, @NotNull String shareInfo, long shareExpiredTime, @Nullable IGProQRCodeShareInfo qRShareInfo, @Nullable IGProShareExtendInfo shareExtendInfo, @Nullable String attaContentId) {
            String str;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
            Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
            Continuation<ShareInfoResult> continuation = this.f234955a;
            Result.Companion companion = Result.INSTANCE;
            if (attaContentId == null) {
                str = "";
            } else {
                str = attaContentId;
            }
            continuation.resumeWith(Result.m476constructorimpl(new ShareInfoResult(result, errMsg, secResult, shareUrl, shareInfo, shareExtendInfo, "", str)));
        }
    }

    GuildShareWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(ShareInfoResult shortUrlResult, ShareInfoResult longUrlResult) {
        Uri uri;
        String str;
        String replace$default;
        try {
            uri = Uri.parse(longUrlResult.getShareUrl());
        } catch (Throwable unused) {
            uri = null;
        }
        if (uri == null || (str = uri.getQueryParameter("attaContentID")) == null) {
            str = "";
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(longUrlResult.getShareUrl(), "attaContentID" + ContainerUtils.KEY_VALUE_DELIMITER + str, "attaContentID" + ContainerUtils.KEY_VALUE_DELIMITER + shortUrlResult.getShareContentInfoId(), false, 4, (Object) null);
        return replace$default;
    }

    @JvmStatic
    public static final void e(@NotNull String guildId, @Nullable String channelId, int businessType, @Nullable byte[] businessParam, @Nullable ArrayList<ey> urlParams, @NotNull t cb5) {
        long j3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Logger.f235387a.d().i("Guild.share.GuildShareWrapper", 1, "fetchShareInfo guildId:" + guildId + " channelId:" + channelId + " ");
        long l3 = MiscKt.l(guildId);
        if (channelId != null) {
            j3 = MiscKt.l(channelId);
        } else {
            j3 = 0;
        }
        long j16 = j3;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.share.GuildShareWrapper", null, null, null, new GuildShareWrapper$fetchShareInfo$2(businessType, businessParam, urlParams, l3, j16, cb5, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(long j3, long j16, av avVar, Continuation<? super ShareInfoResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ((IGPSService) ch.R0(IGPSService.class)).fetchShareInfo0x10c3(j3, j16, avVar, new a(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @JvmStatic
    public static final void g(@NotNull String guildId, @Nullable String channelId, int businessType, @Nullable byte[] businessParam, @Nullable ArrayList<ey> urlParams, @Nullable at cb5) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger.f235387a.d().i("Guild.share.GuildShareWrapper", 1, "fetchShareInfoForQrcode guildId:" + guildId + " channelId:" + channelId + " getShortUrl:true");
        com.tencent.mobileqq.qqguildsdk.data.genc.v vVar = new com.tencent.mobileqq.qqguildsdk.data.genc.v();
        vVar.d(true);
        ((IGPSService) ch.S0(IGPSService.class, "")).fetchShareInfo(guildId, channelId, businessType, businessParam, true, urlParams, vVar, cb5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final av h(int businessType, byte[] businessParam, ArrayList<ey> urlParams, boolean isShortUrl) {
        av avVar = new av();
        avVar.h(businessType);
        int i3 = 0;
        if (businessParam == null) {
            businessParam = new byte[]{0};
        }
        avVar.g(businessParam);
        if (urlParams == null) {
            urlParams = new ArrayList<>();
        }
        avVar.l(urlParams);
        avVar.k(isShortUrl);
        avVar.j(true);
        com.tencent.mobileqq.qqguildsdk.data.genc.v vVar = new com.tencent.mobileqq.qqguildsdk.data.genc.v();
        vVar.d(true);
        if (businessType == 9 || businessType == 15) {
            i3 = 1;
        }
        vVar.f(i3);
        avVar.i(vVar);
        return avVar;
    }
}
