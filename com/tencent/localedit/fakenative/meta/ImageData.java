package com.tencent.localedit.fakenative.meta;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010 J\b\u0010!\u001a\u00020\u0003H\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000b\u00a8\u0006\""}, d2 = {"Lcom/tencent/localedit/fakenative/meta/ImageData;", "", "url", "", "height", "", "width", "size", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/tencent/localedit/fakenative/meta/ImageData;", "equals", "", "other", "hashCode", "toJson", "Lorg/json/JSONObject;", "toMap", "", "toString", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class ImageData {

    @Nullable
    private final Integer height;

    @Nullable
    private final Long size;

    @NotNull
    private final String url;

    @Nullable
    private final Integer width;

    public ImageData(@NotNull String url, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.height = num;
        this.width = num2;
        this.size = l3;
    }

    public static /* synthetic */ ImageData copy$default(ImageData imageData, String str, Integer num, Integer num2, Long l3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageData.url;
        }
        if ((i3 & 2) != 0) {
            num = imageData.height;
        }
        if ((i3 & 4) != 0) {
            num2 = imageData.width;
        }
        if ((i3 & 8) != 0) {
            l3 = imageData.size;
        }
        return imageData.copy(str, num, num2, l3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    @NotNull
    public final ImageData copy(@NotNull String url, @Nullable Integer height, @Nullable Integer width, @Nullable Long size) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new ImageData(url, height, width, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageData)) {
            return false;
        }
        ImageData imageData = (ImageData) other;
        if (Intrinsics.areEqual(this.url, imageData.url) && Intrinsics.areEqual(this.height, imageData.height) && Intrinsics.areEqual(this.width, imageData.width) && Intrinsics.areEqual(this.size, imageData.size)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.url.hashCode() * 31;
        Integer num = this.height;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        Integer num2 = this.width;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Long l3 = this.size;
        if (l3 != null) {
            i3 = l3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public final JSONObject toJson() {
        return new JSONObject(toMap());
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("url", this.url), TuplesKt.to("height", this.height), TuplesKt.to("width", this.width), TuplesKt.to("size", this.size));
        return mapOf;
    }

    @NotNull
    public String toString() {
        String jSONObject = toJson().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJson().toString()");
        return jSONObject;
    }
}
