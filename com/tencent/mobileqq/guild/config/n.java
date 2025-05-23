package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \f2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/config/n;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "iconUrl", "<init>", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n implements IConfigData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String iconUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/n$a;", "", "", "conf", "Lcom/tencent/mobileqq/guild/config/n;", "a", "CONFIG_ID", "Ljava/lang/String;", "DEFAULT_ICON_URL", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.n$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final n a(@NotNull String conf) {
            Intrinsics.checkNotNullParameter(conf, "conf");
            n nVar = new n("https://downv6.qq.com/innovate/guild/common/guild_official_medal_v2.png");
            if (TextUtils.isEmpty(conf)) {
                QLog.d("GuildOfficialIconConfigBean", 1, "parse null, return default bean");
                return nVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(conf);
                String optString = jSONObject.optString("QQGProOfficialMedalIconUrl", "https://downv6.qq.com/innovate/guild/common/guild_official_medal_v2.png");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"QQ\u2026onUrl\", DEFAULT_ICON_URL)");
                nVar.b(optString);
                if (QLog.isColorLevel()) {
                    QLog.i("GuildOfficialIconConfigBean", 2, "parse GuildOfficialIconConfigBean =  " + jSONObject);
                }
            } catch (Exception e16) {
                QLog.e("GuildOfficialIconConfigBean", 1, "parse GuildOfficialIconConfigBean:" + conf + " exception: " + e16);
            }
            return nVar;
        }

        Companion() {
        }
    }

    public n(@NotNull String iconUrl) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.iconUrl = iconUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrl = str;
    }

    @NotNull
    public String toString() {
        return "GuildOfficialIconConfigBean{iconUrl=" + this.iconUrl;
    }
}
