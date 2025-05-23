package com.tencent.mobileqq.guild.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildArgusPreloadConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/e;", "b", "", "content", "d", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildArgusPreloadConfigParser extends BaseConfigParser<GuildArgusPreloadConfig> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildArgusPreloadConfigParser$a;", "", "Lcom/tencent/mobileqq/guild/config/e;", "a", "", "ID", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.GuildArgusPreloadConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildArgusPreloadConfig a() {
            GuildArgusPreloadConfig guildArgusPreloadConfig = (GuildArgusPreloadConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105684");
            if (guildArgusPreloadConfig != null) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().c("GuildArgusPreloadConfigParser", 2, "getConfig Find " + guildArgusPreloadConfig + " 105684");
                }
                return guildArgusPreloadConfig;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getConfig errorFind GuildArgusPreloadConfig 105684");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().b("GuildArgusPreloadConfigParser", 1, (String) it.next(), null);
            }
            return new GuildArgusPreloadConfig(false, false, false, false, 15, null);
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final GuildArgusPreloadConfig c() {
        return INSTANCE.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GuildArgusPreloadConfig defaultConfig() {
        return new GuildArgusPreloadConfig(false, false, false, false, 15, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public GuildArgusPreloadConfig parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return GuildArgusPreloadConfig.INSTANCE.a(new String(content, Charsets.UTF_8));
    }
}
