package com.tencent.localedit.fakenative.meta;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"J\b\u0010#\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/localedit/fakenative/meta/WebResourceResp;", "", "()V", "encoding", "", "getEncoding", "()Ljava/lang/String;", "setEncoding", "(Ljava/lang/String;)V", "inputStream", "Ljava/io/InputStream;", "getInputStream", "()Ljava/io/InputStream;", "setInputStream", "(Ljava/io/InputStream;)V", "mimeType", "getMimeType", "setMimeType", "reasonPhrase", "getReasonPhrase", "setReasonPhrase", "responseHeaders", "", "getResponseHeaders", "()Ljava/util/Map;", "setResponseHeaders", "(Ljava/util/Map;)V", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "getStatusCode", "()I", "setStatusCode", "(I)V", "toMap", "", "toString", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class WebResourceResp {

    @Nullable
    private String encoding;

    @Nullable
    private InputStream inputStream;

    @Nullable
    private String mimeType;

    @Nullable
    private String reasonPhrase;

    @NotNull
    private Map<String, String> responseHeaders = new LinkedHashMap();
    private int statusCode;

    @Nullable
    public final String getEncoding() {
        return this.encoding;
    }

    @Nullable
    public final InputStream getInputStream() {
        return this.inputStream;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    public final String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @NotNull
    public final Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setEncoding(@Nullable String str) {
        this.encoding = str;
    }

    public final void setInputStream(@Nullable InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public final void setMimeType(@Nullable String str) {
        this.mimeType = str;
    }

    public final void setReasonPhrase(@Nullable String str) {
        this.reasonPhrase = str;
    }

    public final void setResponseHeaders(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.responseHeaders = map;
    }

    public final void setStatusCode(int i3) {
        this.statusCode = i3;
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("mimeType", this.mimeType), TuplesKt.to("encoding", this.encoding), TuplesKt.to(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(this.statusCode)), TuplesKt.to("reasonPhrase", this.reasonPhrase), TuplesKt.to("responseHeaders", this.responseHeaders), TuplesKt.to("inputStream", this.inputStream));
        return mapOf;
    }

    @NotNull
    public String toString() {
        List list;
        list = MapsKt___MapsKt.toList(toMap());
        return list.toString();
    }
}
