package com.tencent.mobileqq.guild.sign.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\n\u0006\u0005\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$b;", "", "content", "c", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSignAndWalletConfig extends BaseConfigParser<b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$a;", "", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$b;", "a", "", "GUILD_WALLET_CONFIG_KEY", "Ljava/lang/String;", "ID", "IS_SHOW_KEY", "JUMP_URL_KEY", "SIGNING_CENTER_CONFIG_KEY", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100600");
            if (bVar == null) {
                return new b();
            }
            return bVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$b;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObject", "", "d", "e", "", "content", "c", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$c;", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$c;", "b", "()Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$c;", "singingCenterConfig", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$d;", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$d;", "a", "()Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$d;", "guildWalletEntranceConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildSigningCenterEntranceConfig singingCenterConfig;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildWalletEntranceConfig guildWalletEntranceConfig;

        public b() {
            boolean z16 = false;
            int i3 = 3;
            this.singingCenterConfig = new GuildSigningCenterEntranceConfig(z16, null, i3, 0 == true ? 1 : 0);
            this.guildWalletEntranceConfig = new GuildWalletEntranceConfig(z16, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        }

        private final void d(JSONObject jsonObject) {
            if (jsonObject == null) {
                return;
            }
            GuildSigningCenterEntranceConfig guildSigningCenterEntranceConfig = this.singingCenterConfig;
            guildSigningCenterEntranceConfig.d(jsonObject.optBoolean("is_show"));
            guildSigningCenterEntranceConfig.c(jsonObject.optString("jump_url"));
        }

        private final void e(JSONObject jsonObject) {
            if (jsonObject == null) {
                return;
            }
            GuildWalletEntranceConfig guildWalletEntranceConfig = this.guildWalletEntranceConfig;
            guildWalletEntranceConfig.d(jsonObject.optBoolean("is_show"));
            guildWalletEntranceConfig.c(jsonObject.optString("jump_url"));
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildWalletEntranceConfig getGuildWalletEntranceConfig() {
            return this.guildWalletEntranceConfig;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final GuildSigningCenterEntranceConfig getSingingCenterConfig() {
            return this.singingCenterConfig;
        }

        public final void c(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            JSONObject jSONObject = new JSONObject(content);
            d(jSONObject.optJSONObject("guild_signing_center_config"));
            e(jSONObject.optJSONObject("guild_wallet_config"));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "d", "(Z)V", ViewStickEventHelper.IS_SHOW, "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildSigningCenterEntranceConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isShow;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String jumpUrl;

        public GuildSigningCenterEntranceConfig() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }

        public final void c(@Nullable String str) {
            this.jumpUrl = str;
        }

        public final void d(boolean z16) {
            this.isShow = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildSigningCenterEntranceConfig)) {
                return false;
            }
            GuildSigningCenterEntranceConfig guildSigningCenterEntranceConfig = (GuildSigningCenterEntranceConfig) other;
            if (this.isShow == guildSigningCenterEntranceConfig.isShow && Intrinsics.areEqual(this.jumpUrl, guildSigningCenterEntranceConfig.jumpUrl)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isShow;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            String str = this.jumpUrl;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "GuildSigningCenterEntranceConfig(isShow=" + this.isShow + ", jumpUrl=" + this.jumpUrl + ")";
        }

        public GuildSigningCenterEntranceConfig(boolean z16, @Nullable String str) {
            this.isShow = z16;
            this.jumpUrl = str;
        }

        public /* synthetic */ GuildSigningCenterEntranceConfig(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "d", "(Z)V", ViewStickEventHelper.IS_SHOW, "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig$d, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildWalletEntranceConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isShow;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String jumpUrl;

        public GuildWalletEntranceConfig() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }

        public final void c(@Nullable String str) {
            this.jumpUrl = str;
        }

        public final void d(boolean z16) {
            this.isShow = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildWalletEntranceConfig)) {
                return false;
            }
            GuildWalletEntranceConfig guildWalletEntranceConfig = (GuildWalletEntranceConfig) other;
            if (this.isShow == guildWalletEntranceConfig.isShow && Intrinsics.areEqual(this.jumpUrl, guildWalletEntranceConfig.jumpUrl)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isShow;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            String str = this.jumpUrl;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "GuildWalletEntranceConfig(isShow=" + this.isShow + ", jumpUrl=" + this.jumpUrl + ")";
        }

        public GuildWalletEntranceConfig(boolean z16, @Nullable String str) {
            this.isShow = z16;
            this.jumpUrl = str;
        }

        public /* synthetic */ GuildWalletEntranceConfig(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : str);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        QLog.d("GuildSignAndWalletConfig", 1, "get defaultConfig");
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("GuildSignAndWalletConfig", 1, "parse config");
        b bVar = new b();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            bVar.c(new String(content, UTF_8));
            QLog.d("GuildSignAndWalletConfig", 1, "test: " + bVar);
        } else {
            QLog.d("GuildSignAndWalletConfig", 1, "parse empty content");
        }
        return bVar;
    }
}
