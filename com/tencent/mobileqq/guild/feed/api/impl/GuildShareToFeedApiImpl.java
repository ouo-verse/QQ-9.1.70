package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.guild.feed.api.IGuildShareToFeedApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildShareToFeedApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildShareToFeedApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "shareParam", "", "parseActivityIntentExtraInShareParamExtraOption", "", "guildId", "", "sharePageSource", "Lcom/tencent/mobileqq/guild/feed/api/g;", "shareResultListener", "shareToFeedPostAwareForbidden", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildShareToFeedApiImpl implements IGuildShareToFeedApi {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String TAG = "GuildShareToFeedApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildShareToFeedApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void parseActivityIntentExtraInShareParamExtraOption(Activity activity, SharePublishGuildFeedParam shareParam) {
        boolean z16;
        Intent intent = activity.getIntent();
        boolean z17 = false;
        if (intent != null) {
            Integer valueOf = Integer.valueOf(intent.getIntExtra("key_guild_success_action", -1));
            if (valueOf.intValue() < 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                shareParam.getEditorLaunchOption().setSuccessAction(valueOf.intValue());
            }
        }
        Intent intent2 = activity.getIntent();
        if (intent2 != null && intent2.getBooleanExtra("system_share", false)) {
            z17 = true;
        }
        if (z17) {
            shareParam.getEditorLaunchOption().setSuccessAction(1);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildShareToFeedApi
    public void shareToFeedPostAwareForbidden(@NotNull Activity activity, @NotNull String guildId, @NotNull SharePublishGuildFeedParam shareParam, int sharePageSource, @Nullable com.tencent.mobileqq.guild.feed.api.g shareResultListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        Logger.f235387a.d().i(TAG, 1, "shareToFeedPostAwareForbidden: " + guildId + " - " + shareParam);
        parseActivityIntentExtraInShareParamExtraOption(activity, shareParam);
        GuildFeedLauncherHelper.INSTANCE.a(activity, guildId, shareParam, sharePageSource, shareResultListener);
    }
}
