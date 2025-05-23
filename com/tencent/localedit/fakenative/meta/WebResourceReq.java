package com.tencent.localedit.fakenative.meta;

import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bJ\b\u0010\u0017\u001a\u00020\tH\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/localedit/fakenative/meta/WebResourceReq;", "", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "isForMainFrame", "", "isRedirect", "hasGesture", "method", "", "requestHeaders", "", "(Landroid/net/Uri;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)V", "getHasGesture", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMethod", "()Ljava/lang/String;", "getRequestHeaders", "()Ljava/util/Map;", "getUri", "()Landroid/net/Uri;", "toMap", "toString", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class WebResourceReq {

    @Nullable
    private final Boolean hasGesture;

    @Nullable
    private final Boolean isForMainFrame;

    @Nullable
    private final Boolean isRedirect;

    @Nullable
    private final String method;

    @Nullable
    private final Map<String, String> requestHeaders;

    @Nullable
    private final Uri uri;

    public WebResourceReq(@Nullable Uri uri, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str, @Nullable Map<String, String> map) {
        this.uri = uri;
        this.isForMainFrame = bool;
        this.isRedirect = bool2;
        this.hasGesture = bool3;
        this.method = str;
        this.requestHeaders = map;
    }

    @Nullable
    public final Boolean getHasGesture() {
        return this.hasGesture;
    }

    @Nullable
    public final String getMethod() {
        return this.method;
    }

    @Nullable
    public final Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    @Nullable
    public final Uri getUri() {
        return this.uri;
    }

    @Nullable
    /* renamed from: isForMainFrame, reason: from getter */
    public final Boolean getIsForMainFrame() {
        return this.isForMainFrame;
    }

    @Nullable
    /* renamed from: isRedirect, reason: from getter */
    public final Boolean getIsRedirect() {
        return this.isRedirect;
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(LayoutAttrDefine.CLICK_URI, this.uri), TuplesKt.to("isForMainFrame", this.isForMainFrame), TuplesKt.to("isRedirect", this.isRedirect), TuplesKt.to("hasGesture", this.hasGesture), TuplesKt.to("getMethod", this.method), TuplesKt.to("getRequestHeaders", this.requestHeaders));
        return mapOf;
    }

    @NotNull
    public String toString() {
        List list;
        list = MapsKt___MapsKt.toList(toMap());
        return list.toString();
    }
}
