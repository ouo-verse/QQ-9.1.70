package com.tencent.mobileqq.minigame.minigamecenter.config;

import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.jsonconverter.Alias;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/minigame/minigamecenter/config/OpenHippyParam;", "", "()V", "bundleName", "", "getBundleName", "()Ljava/lang/String;", "setBundleName", "(Ljava/lang/String;)V", "domain", "getDomain", "setDomain", OpenHippyInfo.EXTRA_KEY_ERROR_URL, "getErrorUrl", "setErrorUrl", OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, "", "()Z", "setAnimated", "(Z)V", "isInToolProcess", "setInToolProcess", "isPredraw", "setPredraw", OpenHippyInfo.EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED, "setPredrawWhenClosed", "isPreload", "setPreload", OpenHippyInfo.EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED, "setPreloadWhenClosed", "url", "getUrl", "setUrl", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class OpenHippyParam {

    @Alias("bundleName")
    private String bundleName;

    @Alias("domain")
    private String domain;

    @Alias(OpenHippyInfo.EXTRA_KEY_ERROR_URL)
    private String errorUrl;

    @Alias("isPredraw")
    private boolean isPredraw;

    @Alias(OpenHippyInfo.EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED)
    private boolean isPredrawWhenClosed;

    @Alias("isPreload")
    private boolean isPreload;

    @Alias(OpenHippyInfo.EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED)
    private boolean isPreloadWhenClosed;

    @Alias("url")
    private String url;

    @Alias("isInToolProcess")
    private boolean isInToolProcess = true;

    @Alias(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED)
    private boolean isAnimated = true;

    public final String getBundleName() {
        return this.bundleName;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getErrorUrl() {
        return this.errorUrl;
    }

    public final String getUrl() {
        return this.url;
    }

    /* renamed from: isAnimated, reason: from getter */
    public final boolean getIsAnimated() {
        return this.isAnimated;
    }

    /* renamed from: isInToolProcess, reason: from getter */
    public final boolean getIsInToolProcess() {
        return this.isInToolProcess;
    }

    /* renamed from: isPredraw, reason: from getter */
    public final boolean getIsPredraw() {
        return this.isPredraw;
    }

    /* renamed from: isPredrawWhenClosed, reason: from getter */
    public final boolean getIsPredrawWhenClosed() {
        return this.isPredrawWhenClosed;
    }

    /* renamed from: isPreload, reason: from getter */
    public final boolean getIsPreload() {
        return this.isPreload;
    }

    /* renamed from: isPreloadWhenClosed, reason: from getter */
    public final boolean getIsPreloadWhenClosed() {
        return this.isPreloadWhenClosed;
    }

    public final void setAnimated(boolean z16) {
        this.isAnimated = z16;
    }

    public final void setBundleName(String str) {
        this.bundleName = str;
    }

    public final void setDomain(String str) {
        this.domain = str;
    }

    public final void setErrorUrl(String str) {
        this.errorUrl = str;
    }

    public final void setInToolProcess(boolean z16) {
        this.isInToolProcess = z16;
    }

    public final void setPredraw(boolean z16) {
        this.isPredraw = z16;
    }

    public final void setPredrawWhenClosed(boolean z16) {
        this.isPredrawWhenClosed = z16;
    }

    public final void setPreload(boolean z16) {
        this.isPreload = z16;
    }

    public final void setPreloadWhenClosed(boolean z16) {
        this.isPreloadWhenClosed = z16;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
