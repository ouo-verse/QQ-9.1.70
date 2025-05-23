package com.tencent.mobileqq.guild.jump;

import android.content.Intent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpArkCheck;", "", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/guild/jump/GuildJumpArkCheck$ArkShareScene;", "a", "<init>", "()V", "ArkShareScene", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildJumpArkCheck {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildJumpArkCheck f226370a = new GuildJumpArkCheck();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpArkCheck$ArkShareScene;", "", "(Ljava/lang/String;I)V", "UNKNOWN", ProtocolDownloaderConstants.HOST_C2C, "TROOP", "QZONE", "GUILD", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum ArkShareScene {
        UNKNOWN,
        C2C,
        TROOP,
        QZONE,
        GUILD
    }

    GuildJumpArkCheck() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ArkShareScene a(@Nullable Intent intent) {
        int intExtra;
        boolean startsWith$default;
        if (intent == null) {
            return ArkShareScene.UNKNOWN;
        }
        String stringExtra = intent.getStringExtra("big_brother_source_key");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (Intrinsics.areEqual("biz_src_jc_qzone", stringExtra)) {
            return ArkShareScene.QZONE;
        }
        ArkShareScene arkShareScene = ArkShareScene.UNKNOWN;
        if (!Intrinsics.areEqual(stringExtra, "biz_src_jc_ark")) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(stringExtra, "pindao.", false, 2, null);
            if (!startsWith$default) {
                intExtra = Integer.MIN_VALUE;
                if (intExtra == Integer.MIN_VALUE) {
                    intExtra = intent.getIntExtra("curtype", Integer.MIN_VALUE);
                }
                if (!QQGuildJumpSource.f226421b.contains(Integer.valueOf(intExtra))) {
                    return ArkShareScene.C2C;
                }
                if (intExtra == 1) {
                    return ArkShareScene.TROOP;
                }
                if (intExtra == 10014 || Intrinsics.areEqual(stringExtra, ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getBizSrcJcFeed())) {
                    return ArkShareScene.GUILD;
                }
                return arkShareScene;
            }
        }
        intExtra = intent.getIntExtra("uinType", Integer.MIN_VALUE);
        if (intExtra == Integer.MIN_VALUE) {
        }
        if (!QQGuildJumpSource.f226421b.contains(Integer.valueOf(intExtra))) {
        }
    }
}
