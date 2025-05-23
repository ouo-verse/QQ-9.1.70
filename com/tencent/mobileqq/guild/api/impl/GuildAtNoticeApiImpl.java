package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildAtNoticeApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.notice.panel.GuildAtNoticeDialogFragment;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedConfigReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedConfigRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedConfigCallback;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019Jf\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062B\u0010\u0010\u001a>\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\bH\u0016J=\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rH\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildAtNoticeApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildAtNoticeApi;", "Landroid/content/Context;", "context", "", "guildId", "", "scene", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "canOpenDialog", "Lkotlin/Pair;", "atCount", "", "openDialogCallback", "getNoticeConfig", "channelId", "", "liveRoomId", "Landroidx/fragment/app/DialogFragment;", "getAtNoticeFragment", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/Pair;)Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildAtNoticeApiImpl implements IGuildAtNoticeApi {

    @NotNull
    private static final String TAG = "GuildAtNoticeApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNoticeConfig$lambda$6(String guildId, Context context, Function2 openDialogCallback, int i3, String str, GProGetTopFeedConfigRsp gProGetTopFeedConfigRsp) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(openDialogCallback, "$openDialogCallback");
        boolean z16 = true;
        if (i3 == 0 && gProGetTopFeedConfigRsp != null) {
            QLog.i(TAG, 1, "[getNoticeConfig] allowNotifyAction=" + gProGetTopFeedConfigRsp.allowNotifyAction + ", , notAllowReason = " + gProGetTopFeedConfigRsp.notAllowNotifyReason + ", remainder count: " + gProGetTopFeedConfigRsp.remainderNotifyCount + ", guildId=" + guildId);
            if (!gProGetTopFeedConfigRsp.allowNotifyAction) {
                if (!TextUtils.isEmpty(gProGetTopFeedConfigRsp.notAllowNotifyReason)) {
                    if (context != null) {
                        QQToast.makeText(context, gProGetTopFeedConfigRsp.notAllowNotifyReason, 0).show();
                    }
                } else if (context != null) {
                    QQToast.makeText(context, R.string.f1498013_, 0).show();
                }
            } else {
                if (gProGetTopFeedConfigRsp.remainderNotifyCount <= 0) {
                    if (context != null) {
                        QQToast.makeText(context, R.string.f139810c_, 0).show();
                    }
                }
                openDialogCallback.invoke(Boolean.valueOf(z16), new Pair(Integer.valueOf(gProGetTopFeedConfigRsp.remainderNotifyCount), Integer.valueOf(gProGetTopFeedConfigRsp.maxNotifyCount)));
                return;
            }
            z16 = false;
            openDialogCallback.invoke(Boolean.valueOf(z16), new Pair(Integer.valueOf(gProGetTopFeedConfigRsp.remainderNotifyCount), Integer.valueOf(gProGetTopFeedConfigRsp.maxNotifyCount)));
            return;
        }
        QLog.e(TAG, 1, "[getNoticeConfig] result=" + i3 + ", msg=" + str + ", guildId=" + guildId);
        if (context != null) {
            QQToast.makeText(context, R.string.f1498013_, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAtNoticeApi
    @NotNull
    public DialogFragment getAtNoticeFragment(@NotNull String guildId, @NotNull String channelId, @Nullable Long liveRoomId, @NotNull Pair<Integer, Integer> atCount) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(atCount, "atCount");
        GuildAtNoticeDialogFragment guildAtNoticeDialogFragment = new GuildAtNoticeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IGuildFeedConfigAPi.PARAM_GUILD_ID, guildId);
        bundle.putString(IGuildFeedConfigAPi.PARAM_CHANNEL_ID, channelId);
        if (liveRoomId != null) {
            liveRoomId.longValue();
            bundle.putLong("PARAM_LIVE_ROOM_ID", liveRoomId.longValue());
        }
        bundle.putInt("PARAM_AT_REMAIN_COUNT", atCount.getFirst().intValue());
        bundle.putInt("PARAM_AT_MAX_COUNT", atCount.getSecond().intValue());
        guildAtNoticeDialogFragment.setArguments(bundle);
        return guildAtNoticeDialogFragment;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAtNoticeApi
    public void getNoticeConfig(@Nullable final Context context, @NotNull final String guildId, int scene, @NotNull final Function2<? super Boolean, ? super Pair<Integer, Integer>, Unit> openDialogCallback) {
        Long longOrNull;
        long j3;
        IGProSession iGProSession;
        com.tencent.qqnt.kernel.api.o feedService;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(openDialogCallback, "openDialogCallback");
        if (!NetworkUtil.isNetworkAvailable()) {
            if (context != null) {
                QQToast.makeText(context, R.string.f1498013_, 0).show();
                return;
            }
            return;
        }
        GProGetTopFeedConfigReq gProGetTopFeedConfigReq = new GProGetTopFeedConfigReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        gProGetTopFeedConfigReq.guildId = j3;
        gProGetTopFeedConfigReq.sceneType = scene;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iGProSession = (IGProSession) peekAppRuntime.getRuntimeService(IGProSession.class, "")) != null && (feedService = iGProSession.getFeedService()) != null) {
            feedService.getTopFeedConfig(gProGetTopFeedConfigReq, new IGProGetTopFeedConfigCallback() { // from class: com.tencent.mobileqq.guild.api.impl.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedConfigCallback
                public final void onResult(int i3, String str, GProGetTopFeedConfigRsp gProGetTopFeedConfigRsp) {
                    GuildAtNoticeApiImpl.getNoticeConfig$lambda$6(guildId, context, openDialogCallback, i3, str, gProGetTopFeedConfigRsp);
                }
            });
        }
    }
}
