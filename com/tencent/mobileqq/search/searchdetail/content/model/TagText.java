package com.tencent.mobileqq.search.searchdetail.content.model;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "I", "()I", "c", "(I)V", "bgColor", "<init>", "(Ljava/lang/String;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.model.j, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class TagText {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int bgColor;

    public TagText(@NotNull String text, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.bgColor = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getBgColor() {
        return this.bgColor;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final void c(int i3) {
        this.bgColor = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagText)) {
            return false;
        }
        TagText tagText = (TagText) other;
        if (Intrinsics.areEqual(this.text, tagText.text) && this.bgColor == tagText.bgColor) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.bgColor;
    }

    @NotNull
    public String toString() {
        return "TagText(text=" + this.text + ", bgColor=" + this.bgColor + ")";
    }

    public /* synthetic */ TagText(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? BaseApplication.context.getColor(R.color.qui_common_fill_standard_primary) : i3);
    }
}
