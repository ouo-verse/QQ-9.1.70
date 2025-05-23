package com.tencent.mobileqq.guild.feed.webbundle;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleInterface;", "", "", "getJson", "data", "", "setJson", "getData", "preloadViewSuccess", "preload", "", "useWebBundle", "setWebBundleOption", "dataStr", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/feed/webbundle/r;", "holderRef", "Ljava/lang/ref/WeakReference;", "stateHolder", "<init>", "(Lcom/tencent/mobileqq/guild/feed/webbundle/r;)V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildWebBundleInterface {

    @NotNull
    private static final String TAG = "GuildWebBundleInterface";

    @NotNull
    private String dataStr;

    @NotNull
    private WeakReference<r> holderRef;

    public GuildWebBundleInterface(@NotNull r stateHolder) {
        Intrinsics.checkNotNullParameter(stateHolder, "stateHolder");
        this.dataStr = "";
        this.holderRef = new WeakReference<>(stateHolder);
    }

    @JavascriptInterface
    @Keep
    @NotNull
    public final String getData() {
        GuildWebBundlePreloadState guildWebBundlePreloadState;
        int i3;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            Object obj = this.holderRef.get();
            if (obj != null) {
                i3 = obj.hashCode();
            } else {
                i3 = 0;
            }
            d16.d(TAG, 2, "[use][step 3][#" + i3 + "] FeedWebBundle==  h5 get real data: " + this.dataStr);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.dataStr);
        r rVar = this.holderRef.get();
        if (rVar == null || (guildWebBundlePreloadState = rVar.getPreloadState()) == null) {
            guildWebBundlePreloadState = GuildWebBundlePreloadState.INIT;
        }
        jSONObject.put("state", guildWebBundlePreloadState);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObj.toString()");
        return jSONObject2;
    }

    @NotNull
    /* renamed from: getJson, reason: from getter */
    public final String getDataStr() {
        return this.dataStr;
    }

    @JavascriptInterface
    @Keep
    public final void preload() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d(TAG, 2, "preload preloadWebBundleWhileOnIdle== delay=100");
        }
        GuildWebBundleManager.E(GuildWebBundleManager.INSTANCE.a(), 100L, null, 2, null);
    }

    @JavascriptInterface
    @Keep
    public final void preloadViewSuccess() {
        int i3;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            Object obj = this.holderRef.get();
            if (obj != null) {
                i3 = obj.hashCode();
            } else {
                i3 = 0;
            }
            d16.d(TAG, 2, "[preload][step 2][#" + i3 + "] FeedWebBundle== receive preload success callback from h5.");
        }
        r rVar = this.holderRef.get();
        if (rVar != null) {
            rVar.a(GuildWebBundlePreloadState.SUCCESS);
        }
    }

    public final void setJson(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataStr = data;
    }

    @JavascriptInterface
    @Keep
    public final void setWebBundleOption(int useWebBundle) {
        boolean z16;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d(TAG, 2, "[#" + this.holderRef.get() + "] setWebBundleOption] useWebBundle = " + useWebBundle);
        }
        l optionListener = GuildWebBundleManager.INSTANCE.a().p().getOptionListener();
        if (optionListener != null) {
            if (useWebBundle != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            optionListener.enableWebBundle(z16);
        }
    }
}
