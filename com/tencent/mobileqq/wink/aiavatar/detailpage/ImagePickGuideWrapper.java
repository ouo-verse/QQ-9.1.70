package com.tencent.mobileqq.wink.aiavatar.detailpage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/a;", "items", "Ljava/util/List;", "b", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "id", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.aiavatar.detailpage.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ImagePickGuideWrapper {

    @SerializedName("id")
    @NotNull
    private String id;

    @SerializedName("items")
    @NotNull
    private List<AIAvatarImgPickGuideDataItem> items;

    public ImagePickGuideWrapper() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<AIAvatarImgPickGuideDataItem> b() {
        return this.items;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImagePickGuideWrapper)) {
            return false;
        }
        ImagePickGuideWrapper imagePickGuideWrapper = (ImagePickGuideWrapper) other;
        if (Intrinsics.areEqual(this.items, imagePickGuideWrapper.items) && Intrinsics.areEqual(this.id, imagePickGuideWrapper.id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + this.id.hashCode();
    }

    @NotNull
    public String toString() {
        return "ImagePickGuideWrapper(items=" + this.items + ", id=" + this.id + ")";
    }

    public ImagePickGuideWrapper(@NotNull List<AIAvatarImgPickGuideDataItem> items, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(id5, "id");
        this.items = items;
        this.id = id5;
    }

    public /* synthetic */ ImagePickGuideWrapper(List list, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? "ai_avatar_single_upload_img_suggest_info" : str);
    }
}
