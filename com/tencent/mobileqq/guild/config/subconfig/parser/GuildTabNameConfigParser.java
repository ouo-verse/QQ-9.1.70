package com.tencent.mobileqq.guild.config.subconfig.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.guild.config.subconfig.parser.GuildTabNameConfigParser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u000bB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser$Config;", "", "content", "e", "b", "<init>", "()V", "d", "a", "Config", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildTabNameConfigParser extends BaseConfigParser<Config> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser$Config;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tabName", "<init>", "(Ljava/lang/String;)V", "e", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Config implements IConfigData {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private static final CopyOnWriteArrayList<WeakReference<IGuildConfigApi.a>> f216207f = new CopyOnWriteArrayList<>();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tabName;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser$Config$Companion;", "", "", "b", "", "content", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser$Config;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/api/IGuildConfigApi$a;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final void b() {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.config.subconfig.parser.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildTabNameConfigParser.Config.Companion.c();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c() {
                Logger.a d16 = Logger.f235387a.d();
                Companion companion = Config.INSTANCE;
                d16.i("GuildTabNameConfigParser.Config", 1, "dispatchListeners, " + companion.d().size());
                String b16 = GuildTabNameConfigParser.INSTANCE.b();
                CollectionsKt__MutableCollectionsKt.retainAll((List) companion.d(), (Function1) new Function1<WeakReference<IGuildConfigApi.a>, Boolean>() { // from class: com.tencent.mobileqq.guild.config.subconfig.parser.GuildTabNameConfigParser$Config$Companion$dispatchListeners$1$2
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(WeakReference<IGuildConfigApi.a> weakReference) {
                        return Boolean.valueOf(weakReference.get() != null);
                    }
                });
                Iterator<T> it = companion.d().iterator();
                while (it.hasNext()) {
                    IGuildConfigApi.a aVar = (IGuildConfigApi.a) ((WeakReference) it.next()).get();
                    if (aVar != null) {
                        aVar.g(b16);
                    }
                }
            }

            @NotNull
            public final CopyOnWriteArrayList<WeakReference<IGuildConfigApi.a>> d() {
                return Config.f216207f;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @NotNull
            public final Config e(@Nullable String content) {
                byte b16;
                Config config;
                int i3 = 1;
                QLog.i("GuildTabNameConfigParser.Config", 1, "parse " + content);
                boolean z16 = false;
                if (content != null && content.length() != 0) {
                    b16 = false;
                } else {
                    b16 = true;
                }
                String str = null;
                byte b17 = 0;
                byte b18 = 0;
                byte b19 = 0;
                byte b26 = 0;
                byte b27 = 0;
                if (b16 != false) {
                    return new Config(str, i3, b27 == true ? 1 : 0);
                }
                try {
                    String guildTabName = new JSONObject(content).optString("guildTabName");
                    if (guildTabName == null || guildTabName.length() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        config = new Config(b26 == true ? 1 : 0, i3, b19 == true ? 1 : 0);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(guildTabName, "guildTabName");
                        config = new Config(guildTabName);
                    }
                    b();
                    return config;
                } catch (JSONException e16) {
                    QLog.e("GuildTabNameConfigParser.Config", 1, "error parse GuildMemoryReleaseParser content:" + content, e16);
                    return new Config(b18 == true ? 1 : 0, i3, b17 == true ? 1 : 0);
                }
            }

            Companion() {
            }
        }

        public Config() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTabName() {
            return this.tabName;
        }

        public Config(@NotNull String tabName) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            this.tabName = tabName;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Config(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
            if ((i3 & 1) != 0) {
                str = HardCodeUtil.qqStr(R.string.f139690by);
                Intrinsics.checkNotNullExpressionValue(str, "qqStr(com.tencent.mobile\u2026.R.string.guild_app_name)");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser$a;", "", "", "b", "Lcom/tencent/mobileqq/guild/api/IGuildConfigApi$a;", "listener", "", "a", "CONFIG_ID", "Ljava/lang/String;", "GUILD_TAB_NAME", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.GuildTabNameConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser$a$a", "Lpy2/a;", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildTabNameConfigParser$Config;", DownloadInfo.spKey_Config, "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.GuildTabNameConfigParser$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7711a implements py2.a<Config> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IGuildConfigApi.a f216209a;

            C7711a(IGuildConfigApi.a aVar) {
                this.f216209a = aVar;
            }

            @Override // py2.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@Nullable Config config) {
                String qqStr;
                Logger.f235387a.d().i("GuildTabNameConfigParser.Config", 1, "config:onLoad, " + config);
                IGuildConfigApi.a aVar = this.f216209a;
                if (config == null || (qqStr = config.getTabName()) == null) {
                    qqStr = HardCodeUtil.qqStr(R.string.f139690by);
                }
                aVar.g(qqStr);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull IGuildConfigApi.a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Config.INSTANCE.d().addIfAbsent(new WeakReference<>(listener));
            ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("102227", new C7711a(listener));
        }

        @JvmStatic
        @NotNull
        public final String b() {
            Config config = (Config) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102227");
            if (config == null) {
                config = new Config(null, 1, 0 == true ? 1 : 0);
            }
            return config.getTabName();
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void c(@NotNull IGuildConfigApi.a aVar) {
        INSTANCE.a(aVar);
    }

    @JvmStatic
    @NotNull
    public static final String d() {
        return INSTANCE.b();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Config defaultConfig() {
        return new Config(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Config parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Config.Companion companion = Config.INSTANCE;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return companion.e(new String(content, UTF_8));
    }
}
