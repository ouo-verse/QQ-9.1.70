package com.tencent.mobileqq.guild.config;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007J\u0006\u0010\b\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/config/z;", "", "", "d", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "e", "configID", "key", "value", "b", "c", "Ljava/util/ArrayList;", "getMDiscoverGuideTexts", "()Ljava/util/ArrayList;", "setMDiscoverGuideTexts", "(Ljava/util/ArrayList;)V", "mDiscoverGuideTexts", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z f216289a = new z();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<String> mDiscoverGuideTexts = new ArrayList<>();

    z() {
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> a() {
        return QQGuildMCParser.INSTANCE.a("101719", "guild_id_list");
    }

    @JvmStatic
    public static final boolean d() {
        return QQGuildMCParser.INSTANCE.c("101188", "show_risk_member", false);
    }

    public final boolean b(@NotNull String configID, @NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(configID, "configID");
        Intrinsics.checkNotNullParameter(key, "key");
        if (QQGuildMCParser.INSTANCE.d(configID, key, value ? 1 : 0) == 1) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        return QQGuildMCParser.INSTANCE.c("102429", "showMyManageAndJoinGroup", false);
    }

    public final boolean e() {
        return QQGuildMCParser.INSTANCE.c("100551", "enableLiveSupportQuicFlv", false);
    }
}
