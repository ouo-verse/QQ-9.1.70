package com.tencent.mobileqq.guild.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \b2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/config/i;", "", "", "toString", "", "<set-?>", "a", "Z", "d", "()Z", "enable", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "picUrl", "c", "e", "jumpWebUrl", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.i, reason: from toString */
/* loaded from: classes13.dex */
public final class GuildDiscoverBannerConfBean {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String picUrl = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpWebUrl = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/config/i$a;", "", "Lcom/tencent/mobileqq/guild/config/i;", "bean", "Lorg/json/JSONObject;", "jsonObj", "", "b", "", "a", "", "ENABLE_JSON_KEY", "Ljava/lang/String;", "JUMP_WEB_URL_JSON_KEY", "PIC_URL_JSON_KEY", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.i$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (jsonObj.has("enableGuildDiscoverBanner") && jsonObj.has("jumpWebUrl")) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void b(@NotNull GuildDiscoverBannerConfBean bean, @NotNull JSONObject jsonObj) {
            CharSequence trim;
            CharSequence trim2;
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            bean.enable = jsonObj.optBoolean("enableGuildDiscoverBanner", false);
            String optString = jsonObj.optString("picUrl", "");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(PIC_URL_JSON_KEY, \"\")");
            trim = StringsKt__StringsKt.trim((CharSequence) optString);
            bean.picUrl = trim.toString();
            String optString2 = jsonObj.optString("jumpWebUrl", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(JUMP_WEB_URL_JSON_KEY, \"\")");
            trim2 = StringsKt__StringsKt.trim((CharSequence) optString2);
            bean.jumpWebUrl = trim2.toString();
            com.tencent.mobileqq.guild.discover.d.f216503a.a().setValue(bean);
            QLog.i("Guild.config.GuildDiscoverBannerConfBean", 1, "parseFromJson complete. bean = " + bean);
        }

        Companion() {
        }
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getJumpWebUrl() {
        return this.jumpWebUrl;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public String toString() {
        return "GuildDiscoverBannerConfBean(enable=" + this.enable + ", picUrl='" + this.picUrl + "', jumpWebUrl='" + this.jumpWebUrl + "')";
    }
}
