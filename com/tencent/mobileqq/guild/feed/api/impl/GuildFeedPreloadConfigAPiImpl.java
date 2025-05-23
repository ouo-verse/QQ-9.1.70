package com.tencent.mobileqq.guild.feed.api.impl;

import android.webkit.URLUtil;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.feed.util.ay;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedPreloadConfigAPiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedPreloadConfigAPi;", "Lorg/json/JSONObject;", "jsonObj", "", "parseWebBundleConfig", "parseFeedDetailPreloadConfig", "parseConfig", "", "getFeedPublishMaxLimit", "", "enableWebBundlePreload", "enable", "setWebBundlePreloadEnable", "", "getWebBundlePreloadUrl", "enableFeedDetailPreload", "getFeedDetailBatchPreloadUrl", "getFeedDetailSinglePreloadUrl", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPreloadConfigAPiImpl implements IGuildFeedPreloadConfigAPi {

    @NotNull
    private static final String BATCH_FEED_DETAIL_URL = "https://qun.qq.com/pro/feed/trpc?trpcProxyName=ComReaderProxy&trpcCommandName=BatchGetFeedDetail&preload=true";
    private static final String DEFAULT_PRELOAD_URL = ay.f223860b;

    @NotNull
    private static final String JSON_KEY = "guildFeedDetailPreloadHttp";

    @NotNull
    private static final String JSON_KEY_BATCH_HTTP_URL = "batchUrl";

    @NotNull
    private static final String JSON_KEY_ENABLE_HTTP_TASK = "enableHttp";

    @NotNull
    private static final String JSON_KEY_ENABLE_WEBBUNDLE = "enableWebbundle";

    @NotNull
    private static final String JSON_KEY_SINGLE_HTTP_URL = "singleUrl";

    @NotNull
    private static final String JSON_KEY_WEBBUNDLE_PRELOAD_URL = "preloadUrl";

    @NotNull
    private static final String KEY_ENABLE_DETAIL_PRELOAD = "guild_feed_detail_enable_http_task";

    @NotNull
    private static final String KEY_PUBLISH_TEXT_LIMIT_CONFIG = "key_publish_text_limit_config";

    @NotNull
    public static final String KEY_WEB_BUNDLE_ENABLE = "guild_webbundle_enable";

    @NotNull
    public static final String KEY_WEB_BUNDLE_PRELOAD_URL = "guild_webbundle_preload_url";

    @NotNull
    public static final String MMKV_KEY_BATCH_URL = "guild_feed_detail_batch_url";

    @NotNull
    private static final String MMKV_KEY_SINGLE_URL = "guild_feed_detail_single_url";

    @NotNull
    private static final String SINGLE_FEED_DETAIL_URL = "https://qun.qq.com/pro/feed/trpc/?trpcProxyName=ComReaderProxy&trpcCommandName=GetFeedDetail&preload=true";

    @NotNull
    private static final String TAG = "GuildFeedPreloadConfigAPiImpl";

    private final void parseFeedDetailPreloadConfig(JSONObject jsonObj) {
        JSONObject optJSONObject = jsonObj.optJSONObject(JSON_KEY);
        bw.L().encodeBool(KEY_ENABLE_DETAIL_PRELOAD, optJSONObject.optBoolean(JSON_KEY_ENABLE_HTTP_TASK, false));
        String optString = optJSONObject.optString(JSON_KEY_SINGLE_HTTP_URL, SINGLE_FEED_DETAIL_URL);
        if (URLUtil.isNetworkUrl(optString)) {
            bw.L().encodeString(MMKV_KEY_SINGLE_URL, optString);
        }
        String optString2 = optJSONObject.optString(JSON_KEY_BATCH_HTTP_URL, BATCH_FEED_DETAIL_URL);
        if (URLUtil.isNetworkUrl(optString2)) {
            bw.L().encodeString(MMKV_KEY_BATCH_URL, optString2);
        }
    }

    private final void parseWebBundleConfig(JSONObject jsonObj) {
        JSONObject optJSONObject = jsonObj.optJSONObject(JSON_KEY);
        bw.L().encodeBool(KEY_WEB_BUNDLE_ENABLE, optJSONObject.optBoolean(JSON_KEY_ENABLE_WEBBUNDLE, false));
        String optString = optJSONObject.optString("preloadUrl", DEFAULT_PRELOAD_URL);
        if (URLUtil.isNetworkUrl(optString)) {
            bw.L().encodeString(KEY_WEB_BUNDLE_PRELOAD_URL, optString);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    public boolean enableFeedDetailPreload() {
        return bw.L().decodeBool(KEY_ENABLE_DETAIL_PRELOAD, false);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    public boolean enableWebBundlePreload() {
        return bw.L().decodeBool(KEY_WEB_BUNDLE_ENABLE, false);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    @NotNull
    public String getFeedDetailBatchPreloadUrl() {
        String decodeString = bw.L().decodeString(MMKV_KEY_BATCH_URL, BATCH_FEED_DETAIL_URL);
        Intrinsics.checkNotNullExpressionValue(decodeString, "getMMKVEntity().decodeSt\u2026L, BATCH_FEED_DETAIL_URL)");
        return decodeString;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    @NotNull
    public String getFeedDetailSinglePreloadUrl() {
        String decodeString = bw.L().decodeString(MMKV_KEY_SINGLE_URL, SINGLE_FEED_DETAIL_URL);
        Intrinsics.checkNotNullExpressionValue(decodeString, "getMMKVEntity().decodeSt\u2026, SINGLE_FEED_DETAIL_URL)");
        return decodeString;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    public int getFeedPublishMaxLimit() {
        return 10000;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    @NotNull
    public String getWebBundlePreloadUrl() {
        MMKVOptionEntity L = bw.L();
        String DEFAULT_PRELOAD_URL2 = DEFAULT_PRELOAD_URL;
        String decodeString = L.decodeString(KEY_WEB_BUNDLE_PRELOAD_URL, DEFAULT_PRELOAD_URL2);
        if (decodeString == null) {
            Intrinsics.checkNotNullExpressionValue(DEFAULT_PRELOAD_URL2, "DEFAULT_PRELOAD_URL");
            return DEFAULT_PRELOAD_URL2;
        }
        return decodeString;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    public void parseConfig(@NotNull JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        try {
            if (!jsonObj.has(JSON_KEY)) {
                return;
            }
            QLog.i(TAG, 2, "parseConfig " + jsonObj);
            parseFeedDetailPreloadConfig(jsonObj);
            parseWebBundleConfig(jsonObj);
            int optInt = jsonObj.optInt("guildFeedTextSizeLimit", 10000);
            if (optInt > 0) {
                bw.L().encodeInt(KEY_PUBLISH_TEXT_LIMIT_CONFIG, optInt);
            }
        } catch (Exception unused) {
            QLog.e(TAG, 1, "parseConfig fail");
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi
    public void setWebBundlePreloadEnable(boolean enable) {
        bw.L().encodeBool(KEY_WEB_BUNDLE_ENABLE, enable);
    }
}
