package com.tencent.mobileqq.wink.h5native;

import com.tencent.ams.adcore.mma.api.Global;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$Image", "", "", "isURL", "isBase64", "", "component1", "component2", "type", "content", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$Image;", "copy", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "getContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$Image, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class Image {

    @NotNull
    private final String content;

    @NotNull
    private final String type;

    public Image(@NotNull String type, @NotNull String content) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        this.type = type;
        this.content = content;
    }

    public static /* synthetic */ Image copy$default(Image image, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = image.type;
        }
        if ((i3 & 2) != 0) {
            str2 = image.content;
        }
        return image.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final Image copy(@NotNull String type, @NotNull String content) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        return new Image(type, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Image)) {
            return false;
        }
        Image image = (Image) other;
        if (Intrinsics.areEqual(this.type, image.type) && Intrinsics.areEqual(this.content, image.content)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.content.hashCode();
    }

    public final boolean isBase64() {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(this.type, "Base64", true);
        return equals;
    }

    public final boolean isURL() {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(this.type, Global.TRACKING_URL, true);
        return equals;
    }

    @NotNull
    public String toString() {
        return "Image(type=" + this.type + ", content=" + this.content + ")";
    }
}
