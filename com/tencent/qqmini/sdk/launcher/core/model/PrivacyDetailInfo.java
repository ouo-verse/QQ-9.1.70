package com.tencent.qqmini.sdk.launcher.core.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/model/PrivacyDetailInfo;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "permissionName", "getPermissionName", "setPermissionName", "privacyTitle", "getPrivacyTitle", "setPrivacyTitle", "serviceTermsName", "getServiceTermsName", "setServiceTermsName", "serviceTermsUrl", "getServiceTermsUrl", "setServiceTermsUrl", "webUrl", "getWebUrl", "setWebUrl", "toString", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class PrivacyDetailInfo {

    @Nullable
    private String webUrl = "";

    @Nullable
    private String privacyTitle = "";

    @Nullable
    private String permissionName = "";

    @Nullable
    private String serviceTermsName = "";

    @Nullable
    private String serviceTermsUrl = "";

    @Nullable
    private String id = "";

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getPermissionName() {
        return this.permissionName;
    }

    @Nullable
    public final String getPrivacyTitle() {
        return this.privacyTitle;
    }

    @Nullable
    public final String getServiceTermsName() {
        return this.serviceTermsName;
    }

    @Nullable
    public final String getServiceTermsUrl() {
        return this.serviceTermsUrl;
    }

    @Nullable
    public final String getWebUrl() {
        return this.webUrl;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public final void setPermissionName(@Nullable String str) {
        this.permissionName = str;
    }

    public final void setPrivacyTitle(@Nullable String str) {
        this.privacyTitle = str;
    }

    public final void setServiceTermsName(@Nullable String str) {
        this.serviceTermsName = str;
    }

    public final void setServiceTermsUrl(@Nullable String str) {
        this.serviceTermsUrl = str;
    }

    public final void setWebUrl(@Nullable String str) {
        this.webUrl = str;
    }

    @NotNull
    public String toString() {
        return "PrivacyDetailInfo(webUrl=" + this.webUrl + ", privacyTitle=" + this.privacyTitle + ", permissionName=" + this.permissionName + ", serviceTermsName=" + this.serviceTermsName + ", serviceTermsUrl=" + this.serviceTermsUrl + ", id=" + this.id + ')';
    }
}
