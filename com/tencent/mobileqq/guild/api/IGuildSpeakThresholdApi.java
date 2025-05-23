package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H&J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "guildId", "", "isLimitingInChannel", "channelId", "isLimitingInC2C", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "getGuildSpeakableThresholdPermission", "Landroid/content/Context;", "context", "prefix", "Landroid/text/SpannableStringBuilder;", "getFaceAuthTextSpan", "", "type", "getDesByType", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "listener", "", "addListener", "removeListener", "notifyListeners", "canEnableKeyboard", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildSpeakThresholdApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void E(@NotNull String guildId, @NotNull HashSet<String> channelIds);

        void G(@NotNull List<String> guildIds);

        void M(@NotNull String guildId);
    }

    void addListener(@NotNull a listener);

    boolean canEnableKeyboard(@NotNull String guildId, @NotNull String channelId);

    @NotNull
    String getDesByType(long type);

    @NotNull
    SpannableStringBuilder getFaceAuthTextSpan(@NotNull Context context, @NotNull String prefix);

    @NotNull
    IGuildSpeakableThresholdPermission getGuildSpeakableThresholdPermission(@NotNull String guildId);

    boolean isLimitingInC2C(@NotNull String guildId);

    boolean isLimitingInChannel(@NotNull String guildId);

    boolean isLimitingInChannel(@NotNull String guildId, @NotNull String channelId);

    void notifyListeners(@NotNull String guildId);

    void removeListener(@NotNull a listener);
}
