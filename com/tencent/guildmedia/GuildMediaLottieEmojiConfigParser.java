package com.tencent.guildmedia;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guildmedia/GuildMediaLottieEmojiConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/guildmedia/GuildMediaLottieEmojiConfigParser$b;", "b", "", "isAccountRelated", "", "version", "", "onSend", "", "content", "c", "<init>", "()V", "d", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaLottieEmojiConfigParser extends BaseConfigParser<Config> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guildmedia/GuildMediaLottieEmojiConfigParser$a;", "", "Lcom/tencent/guildmedia/GuildMediaLottieEmojiConfigParser$b;", "a", "", "DEFAULT_COUNT", "I", "", "DEFAULT_TIME", "J", "", "ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.GuildMediaLottieEmojiConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Config a() {
            Config config = (Config) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100228");
            if (config == null) {
                return new Config();
            }
            return config;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guildmedia/GuildMediaLottieEmojiConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "c", "", "b", "toString", "d", "J", "getTime", "()J", "setTime", "(J)V", "time", "", "e", "I", "a", "()I", "setCount", "(I)V", "count", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.GuildMediaLottieEmojiConfigParser$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final class Config implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private long time = 10;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int count = 5;

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final long b() {
            return this.time * 1000;
        }

        public final void c(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.d("GuildMediaLottieEmojiConfigParser", 1, "parse config: " + content);
            JSONObject jSONObject = new JSONObject(content);
            this.time = jSONObject.optLong("time", 10L);
            this.count = jSONObject.optInt("count", 5);
        }

        @NotNull
        public String toString() {
            return "Config(time=" + this.time + ", count=" + this.count + ")";
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Config defaultConfig() {
        QLog.d("GuildMediaLottieEmojiConfigParser", 1, "get defaultConfig");
        return new Config();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Config parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("GuildMediaLottieEmojiConfigParser", 1, "parse config");
        Config config = new Config();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            config.c(new String(content, UTF_8));
            QLog.d("GuildMediaLottieEmojiConfigParser", 1, "test: " + config);
        } else {
            QLog.d("GuildMediaLottieEmojiConfigParser", 1, "parse empty content");
        }
        return config;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.d("GuildMediaLottieEmojiConfigParser", 1, "onSend version: ", version);
    }
}
