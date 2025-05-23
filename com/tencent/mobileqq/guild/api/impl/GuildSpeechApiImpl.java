package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.af;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.cg;
import com.tencent.util.QQToastUtil;
import eipc.EIPCResult;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J*\u0010\u0013\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001c\u0010\u0018\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016R*\u0010\u001f\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildSpeechApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildSpeechApi;", "", "guildId", "channelId", "", "isNeedInterceptHongbao", "isNeedInterceptLink", "txtContent", "containLink", "isNeedInterceptQrCode", "", "showInterceptRedEnvelopeSendToast", "showInterceptLinkSendToast", "showInterceptQrCodeSendToast", "", "atAllNum", "atOnlineNum", "atRoleNum", "isNeedInterceptOfAt", "showInterceptAtSendToast", "", "content", "isNeedInterceptKeyword", "isNeedInterceptAds", "Lwh2/f;", "cb", "preloadSpeakRule", "showInterceptKeywordSendToast", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "LINK_PATTERN", "Ljava/util/regex/Pattern;", "getLINK_PATTERN", "()Ljava/util/regex/Pattern;", "setLINK_PATTERN", "(Ljava/util/regex/Pattern;)V", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildSpeechApiImpl implements IGuildSpeechApi {

    @NotNull
    private static final String TAG = "GuildSpeechApiImpl";
    private Pattern LINK_PATTERN = Pattern.compile(cg.f307524c.pattern() + "|" + cg.f307525d.pattern(), 2);

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public boolean containLink(@Nullable String txtContent) {
        return this.LINK_PATTERN.matcher(txtContent).find();
    }

    public final Pattern getLINK_PATTERN() {
        return this.LINK_PATTERN;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public boolean isNeedInterceptAds(@Nullable String guildId, @Nullable String channelId) {
        Bundle bundle;
        if (MobileQQ.sProcessId == 1) {
            return af.d(guildId, channelId, 103, null, 8, null);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IGuildSpeechApi.KEY_GUILD, guildId);
        bundle2.putString(IGuildSpeechApi.KEY_CHANNEL, channelId);
        bundle2.putInt(IGuildSpeechApi.KEY_TYPE, 103);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_check_send_for_speech", bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public boolean isNeedInterceptHongbao(@Nullable String guildId, @Nullable String channelId) {
        Bundle bundle;
        if (MobileQQ.sProcessId == 1) {
            return af.d(guildId, channelId, 100, null, 8, null);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IGuildSpeechApi.KEY_GUILD, guildId);
        bundle2.putString(IGuildSpeechApi.KEY_CHANNEL, channelId);
        bundle2.putInt(IGuildSpeechApi.KEY_TYPE, 100);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_check_send_for_speech", bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public boolean isNeedInterceptKeyword(@NotNull String guildId, @NotNull String channelId, @NotNull CharSequence content) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(content, "content");
        if (MobileQQ.sProcessId == 1) {
            return af.c(guildId, channelId, 104, content);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IGuildSpeechApi.KEY_GUILD, guildId);
        bundle2.putString(IGuildSpeechApi.KEY_CHANNEL, channelId);
        bundle2.putInt(IGuildSpeechApi.KEY_TYPE, 104);
        bundle2.putCharSequence("key_content", content);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_check_send_for_speech", bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public boolean isNeedInterceptLink(@Nullable String guildId, @Nullable String channelId) {
        Bundle bundle;
        if (MobileQQ.sProcessId == 1) {
            return af.d(guildId, channelId, 101, null, 8, null);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IGuildSpeechApi.KEY_GUILD, guildId);
        bundle2.putString(IGuildSpeechApi.KEY_CHANNEL, channelId);
        bundle2.putInt(IGuildSpeechApi.KEY_TYPE, 101);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_check_send_for_speech", bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public boolean isNeedInterceptOfAt(@Nullable String guildId, int atAllNum, int atOnlineNum, int atRoleNum) {
        Bundle bundle;
        if (MobileQQ.sProcessId == 1) {
            return com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.f.b(guildId, atAllNum, atOnlineNum, atRoleNum);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IGuildSpeechApi.KEY_GUILD, guildId);
        bundle2.putInt(IGuildSpeechApi.KEY_AT_ALL_NUM, atAllNum);
        bundle2.putInt(IGuildSpeechApi.KEY_AT_ONLINE_NUM, atOnlineNum);
        bundle2.putInt(IGuildSpeechApi.KEY_AT_ROLE_NUM, atRoleNum);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_check_send_for_at", bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public boolean isNeedInterceptQrCode(@Nullable String guildId, @Nullable String channelId) {
        Bundle bundle;
        if (MobileQQ.sProcessId == 1) {
            return af.d(guildId, channelId, 102, null, 8, null);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IGuildSpeechApi.KEY_GUILD, guildId);
        bundle2.putString(IGuildSpeechApi.KEY_CHANNEL, channelId);
        bundle2.putInt(IGuildSpeechApi.KEY_TYPE, 102);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_check_send_for_speech", bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public void preloadSpeakRule(@Nullable String guildId, @Nullable wh2.f cb5) {
        boolean z16;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            af.f(guildId, cb5);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IGuildSpeechApi.KEY_GUILD, guildId);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "async_preload_speak_rule", bundle, null);
    }

    public final void setLINK_PATTERN(Pattern pattern) {
        this.LINK_PATTERN = pattern;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public void showInterceptAtSendToast() {
        QQToastUtil.showQQToast(0, R.string.f146730uz);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public void showInterceptKeywordSendToast() {
        QQToastUtil.showQQToast(R.string.f157041lu);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public void showInterceptLinkSendToast() {
        QQToastUtil.showQQToast(R.string.f157061lw);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public void showInterceptQrCodeSendToast() {
        QQToastUtil.showQQToast(R.string.f157071lx);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeechApi
    public void showInterceptRedEnvelopeSendToast() {
        QQToastUtil.showQQToast(R.string.f157101m0);
    }
}
