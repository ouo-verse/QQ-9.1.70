package com.tencent.mobileqq.qqguildsdk.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qqguildsdk.manager.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/config/GuildPicDomainNameConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/qqguildsdk/config/GuildPicDomainNameConfigParser$b;", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "b", "<init>", "()V", "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GuildPicDomainNameConfigParser extends BaseConfigParser<Config> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/config/GuildPicDomainNameConfigParser$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/config/GuildPicDomainNameConfigParser$b;", "a", "", "CONFIG_ID", "Ljava/lang/String;", "DEFAULT_COVER_DOMAIN", "DEFAULT_HEAD_DOMAIN", "KEY_COVER_DOMAIN", "KEY_HEAD_DOMAIN", "TAG", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.config.GuildPicDomainNameConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Config a() {
            Config config = (Config) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100633");
            if (config == null) {
                return new Config();
            }
            return config;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/config/GuildPicDomainNameConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "c", "toString", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setHeadDomain", "(Ljava/lang/String;)V", "headDomain", "e", "a", "setCoverDomain", "coverDomain", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.config.GuildPicDomainNameConfigParser$b, reason: from toString */
    /* loaded from: classes17.dex */
    public static final class Config implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String headDomain = "groupprohead.gtimg.cn";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String coverDomain = "groupprocover.gtimg.cn";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCoverDomain() {
            return this.coverDomain;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getHeadDomain() {
            return this.headDomain;
        }

        public final void c(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            JSONObject jSONObject = new JSONObject(content);
            String optString = jSONObject.optString("head_domain", "groupprohead.gtimg.cn");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(KEY_HE\u2026AIN, DEFAULT_HEAD_DOMAIN)");
            this.headDomain = optString;
            String optString2 = jSONObject.optString("cover_domain", "groupprohead.gtimg.cn");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(KEY_CO\u2026AIN, DEFAULT_HEAD_DOMAIN)");
            this.coverDomain = optString2;
            QLog.d("GuildPicDomainNameConfigParser", 1, "parse config=" + content + " res=" + this);
        }

        @NotNull
        public String toString() {
            return "Config(headDomain='" + this.headDomain + "', coverDomain='" + this.coverDomain + "')";
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Config defaultConfig() {
        QLog.d("GuildPicDomainNameConfigParser", 1, "get defaultConfig");
        return new Config();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable Config config) {
        super.doOnConfigUpdate(config);
        if (config == null) {
            QLog.d("GuildPicDomainNameConfigParser", 1, "doOnConfigUpdate config is null");
        } else {
            QLog.d("GuildPicDomainNameConfigParser", 1, "doOnConfigUpdate");
            c.d().f(config);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Config parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("GuildPicDomainNameConfigParser", 1, "parse config");
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
        } else {
            QLog.d("GuildPicDomainNameConfigParser", 1, "parse empty content");
        }
        return config;
    }
}
