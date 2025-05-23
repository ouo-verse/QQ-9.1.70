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
import tl.h;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\u0006B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/config/GProSdkTjgConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/qqguildsdk/config/GProSdkTjgConfigParser$b;", "", "content", "d", "b", DownloadInfo.spKey_Config, "", "c", "<init>", "()V", "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GProSdkTjgConfigParser extends BaseConfigParser<Config> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/config/GProSdkTjgConfigParser$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/config/GProSdkTjgConfigParser$b;", "a", "", "CONFIG_ID", "Ljava/lang/String;", "", "DEFAULT_SAMPLE", "D", "", "DEFAULT_SWITCH_VAL", "Z", "TAG", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.config.GProSdkTjgConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Config a() {
            Config config = (Config) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100611");
            if (config == null) {
                return new Config();
            }
            return config;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/config/GProSdkTjgConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "e", "toString", "", "d", "Z", "()Z", "setTraceSdkEnable", "(Z)V", "isTraceSdkEnable", "isMetricSdkEnable", "setMetricSdkEnable", "f", "c", "setColorUser", "isColorUser", "", h.F, "D", "a", "()D", "setTraceSample", "(D)V", "traceSample", "i", "b", "setTraceSampleEvent", "traceSampleEvent", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.config.GProSdkTjgConfigParser$b, reason: from toString */
    /* loaded from: classes17.dex */
    public static final class Config implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isTraceSdkEnable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isMetricSdkEnable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isColorUser;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private double traceSample;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private double traceSampleEvent;

        /* renamed from: a, reason: from getter */
        public final double getTraceSample() {
            return this.traceSample;
        }

        /* renamed from: b, reason: from getter */
        public final double getTraceSampleEvent() {
            return this.traceSampleEvent;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsColorUser() {
            return this.isColorUser;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsTraceSdkEnable() {
            return this.isTraceSdkEnable;
        }

        public final void e(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            JSONObject jSONObject = new JSONObject(content);
            this.isTraceSdkEnable = jSONObject.optBoolean("trace_sdk_enable", false);
            this.isMetricSdkEnable = jSONObject.optBoolean("metric_sdk_enable", false);
            this.isColorUser = jSONObject.optBoolean("trace_color_user", false);
            this.traceSample = jSONObject.optDouble("trace_sample", 0.0d);
            this.traceSampleEvent = jSONObject.optDouble("trace_sample_event", 0.0d);
            QLog.d("GProSdkTjgConfigParser", 1, "parse config=" + content + " res=" + this);
        }

        @NotNull
        public String toString() {
            return "Config(isTraceSdkEnable=" + this.isTraceSdkEnable + ", isMetricSdkEnable=" + this.isMetricSdkEnable + ", isColorUser=" + this.isColorUser + ", traceSample=" + this.traceSample + ", traceSampleEvent=" + this.traceSampleEvent + ")";
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Config defaultConfig() {
        QLog.d("GProSdkTjgConfigParser", 1, "get defaultConfig");
        return new Config();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable Config config) {
        super.doOnConfigUpdate(config);
        if (config == null) {
            QLog.d("GProSdkTjgConfigParser", 1, "doOnConfigUpdate config is null");
        } else {
            QLog.d("GProSdkTjgConfigParser", 1, "doOnConfigUpdate");
            c.d().g(config);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Config parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("GProSdkTjgConfigParser", 1, "parse config");
        Config config = new Config();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            config.e(new String(content, UTF_8));
        } else {
            QLog.d("GProSdkTjgConfigParser", 1, "parse empty content");
        }
        return config;
    }
}
