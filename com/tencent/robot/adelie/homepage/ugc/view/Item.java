package com.tencent.robot.adelie.homepage.ugc.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/x;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "thumbUrl", "b", "text", "styleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.ugc.view.x, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class Item {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String thumbUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String styleId;

    public Item(@NotNull String thumbUrl, @NotNull String text, @NotNull String styleId) {
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        this.thumbUrl = thumbUrl;
        this.text = text;
        this.styleId = styleId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getStyleId() {
        return this.styleId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Item)) {
            return false;
        }
        Item item = (Item) other;
        if (Intrinsics.areEqual(this.thumbUrl, item.thumbUrl) && Intrinsics.areEqual(this.text, item.text) && Intrinsics.areEqual(this.styleId, item.styleId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.thumbUrl.hashCode() * 31) + this.text.hashCode()) * 31) + this.styleId.hashCode();
    }

    @NotNull
    public String toString() {
        return "Item(thumbUrl=" + this.thumbUrl + ", text=" + this.text + ", styleId=" + this.styleId + ")";
    }
}
