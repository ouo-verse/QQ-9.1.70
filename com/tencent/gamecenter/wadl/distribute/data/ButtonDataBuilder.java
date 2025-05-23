package com.tencent.gamecenter.wadl.distribute.data;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b0\u0018\u0000 B2\u00020\u0001:\u0003ABCB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\rJ\u0010\u0010+\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010-\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010/\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0010\u00100\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\rJ\u0010\u00104\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u00105\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u00106\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u000e\u00107\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u00108\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u00109\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010:\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010;\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0010\u0010<\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010\u0004J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder;", "", "()V", "aggregatedBuffer", "", "apkChannel", "apkUrl", "appId", "appName", "attaReportData", "bufferFromCache", "", "businessChannel", "", QQBrowserActivity.APP_PARAM, "guildID", "iconUrl", "isSupportSpark", PushClientConstants.TAG_PKG_NAME, VirtualAppProxy.KEY_PKG_SIZE, "", "pkgSizeStr", "reportData", "sparkTaskKey", "subScribeSource", "versionCode", "getAggregatedBuffer", "getApkChannel", "getApkUrl", "getAppId", "getAppName", "getAttaReportData", "getBufferFromCache", "getBusinessChannel", "getExtraParams", "getGuildID", "getIconUrl", "getIsSupportSpark", "getPkgName", "getReportData", "getSparkTaskKey", "getSubScribeSource", "getVersionCode", "setAggregatedBuffer", "setApkChannel", "setApkUrl", "setAppId", "setAppName", "setAttaReportData", "setBufferFromCache", "setBusinessChannel", WadlProxyConsts.CHANNEL, "setExtraParams", "setGuildID", "setIconUrl", "setIsSupportSpark", "setPkgName", "setPkgSize", "setPkgSizeStr", "setReportData", "setSparkTaskKey", "taskKey", "setSubscribeSource", "source", "setVersionCode", "BusinessChannel", "Companion", "SubScribeSource", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ButtonDataBuilder {

    @NotNull
    private static final String TAG = "ButtonDataBuilder";

    @Nullable
    private String attaReportData;
    private boolean bufferFromCache;
    private int businessChannel;
    private int isSupportSpark;
    private long pkgSize;
    private int versionCode;

    @NotNull
    private String apkUrl = "";

    @NotNull
    private String appId = "";

    @NotNull
    private String apkChannel = WadlProxyConsts.APP_CHANNEL_GAMECENTER;

    @NotNull
    private String appName = "";

    @NotNull
    private String iconUrl = "";

    @NotNull
    private String pkgName = "";

    @NotNull
    private String pkgSizeStr = "";

    @NotNull
    private String subScribeSource = "1";

    @NotNull
    private String reportData = "";

    @NotNull
    private String sparkTaskKey = "";

    @NotNull
    private String extraParams = "";

    @NotNull
    private String aggregatedBuffer = "";

    @NotNull
    private String guildID = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder$BusinessChannel;", "", "Companion", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes6.dex */
    public @interface BusinessChannel {
        public static final int COMMON = 0;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int KAN_DIAN = 1;
        public static final int QQ_CIRCLE = 2;
        public static final int QQ_GUILD = 6;
        public static final int QQ_LIVE = 4;
        public static final int QQ_NET_SEARCH = 5;
        public static final int QQ_NEWS = 3;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder$BusinessChannel$Companion;", "", "()V", "COMMON", "", "KAN_DIAN", "QQ_CIRCLE", "QQ_GUILD", "QQ_LIVE", "QQ_NET_SEARCH", "QQ_NEWS", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int COMMON = 0;
            public static final int KAN_DIAN = 1;
            public static final int QQ_CIRCLE = 2;
            public static final int QQ_GUILD = 6;
            public static final int QQ_LIVE = 4;
            public static final int QQ_NET_SEARCH = 5;
            public static final int QQ_NEWS = 3;

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder$SubScribeSource;", "", "Companion", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes6.dex */
    public @interface SubScribeSource {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String GAME_CENTER = "1";

        @NotNull
        public static final String GUILD_GAME = "100";

        @NotNull
        public static final String H5_ACTIVITY = "2";

        @NotNull
        public static final String SERVICE = "3";

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder$SubScribeSource$Companion;", "", "()V", "GAME_CENTER", "", "GUILD_GAME", "H5_ACTIVITY", "SERVICE", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String GAME_CENTER = "1";

            @NotNull
            public static final String GUILD_GAME = "100";

            @NotNull
            public static final String H5_ACTIVITY = "2";

            @NotNull
            public static final String SERVICE = "3";

            Companion() {
            }
        }
    }

    @NotNull
    public final String getAggregatedBuffer() {
        return this.aggregatedBuffer;
    }

    @NotNull
    public final String getApkChannel() {
        return this.apkChannel;
    }

    @NotNull
    public final String getApkUrl() {
        return this.apkUrl;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getAttaReportData() {
        return this.attaReportData;
    }

    public final boolean getBufferFromCache() {
        return this.bufferFromCache;
    }

    public final int getBusinessChannel() {
        return this.businessChannel;
    }

    @NotNull
    public final String getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final String getGuildID() {
        return this.guildID;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getIsSupportSpark() {
        return this.isSupportSpark;
    }

    @NotNull
    public final String getPkgName() {
        return this.pkgName;
    }

    @NotNull
    public final String getReportData() {
        return this.reportData;
    }

    @NotNull
    public final String getSparkTaskKey() {
        return this.sparkTaskKey;
    }

    @NotNull
    public final String getSubScribeSource() {
        return this.subScribeSource;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final ButtonDataBuilder setAggregatedBuffer(@Nullable String aggregatedBuffer) {
        if (aggregatedBuffer != null) {
            this.aggregatedBuffer = aggregatedBuffer;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setApkChannel(@NotNull String apkChannel) {
        Intrinsics.checkNotNullParameter(apkChannel, "apkChannel");
        if (!TextUtils.isEmpty(apkChannel)) {
            this.apkChannel = apkChannel;
        } else {
            this.apkChannel = WadlProxyConsts.APP_CHANNEL_GAMECENTER;
            QLog.e(TAG, 1, "[setApkChannel] channel is empty");
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setApkUrl(@Nullable String apkUrl) {
        if (apkUrl != null) {
            this.apkUrl = apkUrl;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setAppId(@Nullable String appId) {
        if (appId != null) {
            this.appId = appId;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setAppName(@Nullable String appName) {
        if (appName != null) {
            this.appName = appName;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setAttaReportData(@Nullable String attaReportData) {
        this.attaReportData = attaReportData;
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setBufferFromCache(boolean bufferFromCache) {
        this.bufferFromCache = bufferFromCache;
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setBusinessChannel(int channel) {
        this.businessChannel = channel;
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setExtraParams(@Nullable String extraParams) {
        boolean z16;
        if (extraParams != null && extraParams.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.extraParams = extraParams;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setGuildID(@Nullable String guildID) {
        boolean z16;
        if (guildID != null && guildID.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.guildID = guildID;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setIconUrl(@Nullable String iconUrl) {
        if (iconUrl != null) {
            this.iconUrl = iconUrl;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setIsSupportSpark(int isSupportSpark) {
        this.isSupportSpark = isSupportSpark;
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setPkgName(@Nullable String pkgName) {
        if (pkgName != null) {
            this.pkgName = pkgName;
        }
        return this;
    }

    @Deprecated(message = "\u5e9f\u5f03")
    @NotNull
    public final ButtonDataBuilder setPkgSize(long pkgSize) {
        this.pkgSize = pkgSize;
        return this;
    }

    @Deprecated(message = "\u5e9f\u5f03")
    @NotNull
    public final ButtonDataBuilder setPkgSizeStr(@Nullable String pkgSizeStr) {
        if (pkgSizeStr != null) {
            this.pkgSizeStr = pkgSizeStr;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setReportData(@Nullable String reportData) {
        if (reportData != null) {
            this.reportData = reportData;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setSparkTaskKey(@Nullable String taskKey) {
        boolean z16;
        if (taskKey != null && taskKey.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.sparkTaskKey = taskKey;
        }
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setSubscribeSource(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.subScribeSource = source;
        return this;
    }

    @NotNull
    public final ButtonDataBuilder setVersionCode(int versionCode) {
        this.versionCode = versionCode;
        return this;
    }
}
