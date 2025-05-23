package com.tencent.mobileqq.guild.channellist;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/f;", "Lcom/tencent/mobileqq/guild/channellist/c;", "", "f", "", "d", "", "toString", "hashCode", "", "other", "", "equals", "b", "I", "e", "()I", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "c", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "title", "getDesc", "desc", "Z", "g", "()Z", "showAddButton", "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.channellist.f, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class EmptyPageData extends c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imageType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showAddButton;

    public EmptyPageData(int i3, @NotNull String title, @NotNull String desc, boolean z16) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.imageType = i3;
        this.title = title;
        this.desc = desc;
        this.showAddButton = z16;
    }

    @Override // com.tencent.mobileqq.guild.channellist.c
    public long d() {
        return Objects.hash(Integer.valueOf(f()), this.title, this.desc, Boolean.valueOf(this.showAddButton));
    }

    /* renamed from: e, reason: from getter */
    public final int getImageType() {
        return this.imageType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmptyPageData)) {
            return false;
        }
        EmptyPageData emptyPageData = (EmptyPageData) other;
        if (this.imageType == emptyPageData.imageType && Intrinsics.areEqual(this.title, emptyPageData.title) && Intrinsics.areEqual(this.desc, emptyPageData.desc) && this.showAddButton == emptyPageData.showAddButton) {
            return true;
        }
        return false;
    }

    public int f() {
        return 2;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getShowAddButton() {
        return this.showAddButton;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.imageType * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31;
        boolean z16 = this.showAddButton;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "EmptyPageData(imageType=" + this.imageType + ", title=" + this.title + ", desc=" + this.desc + ", showAddButton=" + this.showAddButton + ")";
    }
}
