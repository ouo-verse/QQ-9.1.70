package com.tencent.mobileqq.wink.share;

import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 E2\u00020\u0001:\u0001FB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010DR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\nR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\nR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\nR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\nR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\nR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\"\u00100\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\"\u00103\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\"\u00106\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "Ljava/io/Serializable;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "preview", "getPreview", "setPreview", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "shareUrl", "getShareUrl", "setShareUrl", "descForQq", "getDescForQq", "setDescForQq", "shareExternalUrl", "getShareExternalUrl", "setShareExternalUrl", "shareQZoneUrl", "getShareQZoneUrl", "setShareQZoneUrl", "requestArkBusId", "getRequestArkBusId", "setRequestArkBusId", "sharePathForOutChannel", "getSharePathForOutChannel", "setSharePathForOutChannel", "", "serviceId", "I", "getServiceId", "()I", "setServiceId", "(I)V", "", "isNewArkRequest", "Z", "()Z", "setNewArkRequest", "(Z)V", "requestQQId", "getRequestQQId", "setRequestQQId", "requestQZoneId", "getRequestQZoneId", "setRequestQZoneId", "requestGuildId", "getRequestGuildId", "setRequestGuildId", "requestQZoneAlbumId", "getRequestQZoneAlbumId", "setRequestQZoneAlbumId", "Landroid/os/Bundle;", "qzonePublishParams", "Landroid/os/Bundle;", "getQzonePublishParams", "()Landroid/os/Bundle;", "setQzonePublishParams", "(Landroid/os/Bundle;)V", QQBrowserActivity.APP_PARAM, "getExtraParams", "setExtraParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkShareCommonModel implements Serializable {

    @NotNull
    public static final String EXTRA_PARAMS_MATERIAL_ID = "material_id";

    @NotNull
    public static final String EXTRA_PARAMS_QZONE_ALBUM_COME_FROM = "EXTRA_PARAMS_QZONE_ALBUM_COME_FROM";

    @NotNull
    private String desc;

    @Nullable
    private String descForQq;

    @Nullable
    private Bundle extraParams;
    private boolean isNewArkRequest;

    @NotNull
    private String preview;

    @Nullable
    private Bundle qzonePublishParams;

    @Nullable
    private String requestArkBusId;
    private int requestGuildId;
    private int requestQQId;
    private int requestQZoneAlbumId;
    private int requestQZoneId;
    private int serviceId;

    @Nullable
    private String shareExternalUrl;

    @Nullable
    private String sharePathForOutChannel;

    @Nullable
    private String shareQZoneUrl;

    @NotNull
    private String shareUrl;

    @NotNull
    private final String title;

    public WinkShareCommonModel(@NotNull String title, @NotNull String preview, @NotNull String desc, @NotNull String shareUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        this.title = title;
        this.preview = preview;
        this.desc = desc;
        this.shareUrl = shareUrl;
        this.serviceId = 9;
        this.isNewArkRequest = true;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getDescForQq() {
        return this.descForQq;
    }

    @Nullable
    public final Bundle getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final String getPreview() {
        return this.preview;
    }

    @Nullable
    public final Bundle getQzonePublishParams() {
        return this.qzonePublishParams;
    }

    @Nullable
    public final String getRequestArkBusId() {
        return this.requestArkBusId;
    }

    public final int getRequestGuildId() {
        return this.requestGuildId;
    }

    public final int getRequestQQId() {
        return this.requestQQId;
    }

    public final int getRequestQZoneAlbumId() {
        return this.requestQZoneAlbumId;
    }

    public final int getRequestQZoneId() {
        return this.requestQZoneId;
    }

    public final int getServiceId() {
        return this.serviceId;
    }

    @Nullable
    public final String getShareExternalUrl() {
        return this.shareExternalUrl;
    }

    @Nullable
    public final String getSharePathForOutChannel() {
        return this.sharePathForOutChannel;
    }

    @Nullable
    public final String getShareQZoneUrl() {
        return this.shareQZoneUrl;
    }

    @NotNull
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: isNewArkRequest, reason: from getter */
    public final boolean getIsNewArkRequest() {
        return this.isNewArkRequest;
    }

    public final void setDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setDescForQq(@Nullable String str) {
        this.descForQq = str;
    }

    public final void setExtraParams(@Nullable Bundle bundle) {
        this.extraParams = bundle;
    }

    public final void setNewArkRequest(boolean z16) {
        this.isNewArkRequest = z16;
    }

    public final void setPreview(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.preview = str;
    }

    public final void setQzonePublishParams(@Nullable Bundle bundle) {
        this.qzonePublishParams = bundle;
    }

    public final void setRequestArkBusId(@Nullable String str) {
        this.requestArkBusId = str;
    }

    public final void setRequestGuildId(int i3) {
        this.requestGuildId = i3;
    }

    public final void setRequestQQId(int i3) {
        this.requestQQId = i3;
    }

    public final void setRequestQZoneAlbumId(int i3) {
        this.requestQZoneAlbumId = i3;
    }

    public final void setRequestQZoneId(int i3) {
        this.requestQZoneId = i3;
    }

    public final void setServiceId(int i3) {
        this.serviceId = i3;
    }

    public final void setShareExternalUrl(@Nullable String str) {
        this.shareExternalUrl = str;
    }

    public final void setSharePathForOutChannel(@Nullable String str) {
        this.sharePathForOutChannel = str;
    }

    public final void setShareQZoneUrl(@Nullable String str) {
        this.shareQZoneUrl = str;
    }

    public final void setShareUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareUrl = str;
    }
}
