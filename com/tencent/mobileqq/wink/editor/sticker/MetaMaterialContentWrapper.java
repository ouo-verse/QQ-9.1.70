package com.tencent.mobileqq.wink.editor.sticker;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContentWrapper;", "Ljava/io/Serializable;", "metaMaterialContent", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContent;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getMetaMaterialContent", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class MetaMaterialContentWrapper implements Serializable {

    @SerializedName("metaMaterialContent")
    @NotNull
    private final ArrayList<MetaMaterialContent> metaMaterialContent;

    public MetaMaterialContentWrapper() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetaMaterialContentWrapper copy$default(MetaMaterialContentWrapper metaMaterialContentWrapper, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = metaMaterialContentWrapper.metaMaterialContent;
        }
        return metaMaterialContentWrapper.copy(arrayList);
    }

    @NotNull
    public final ArrayList<MetaMaterialContent> component1() {
        return this.metaMaterialContent;
    }

    @NotNull
    public final MetaMaterialContentWrapper copy(@NotNull ArrayList<MetaMaterialContent> metaMaterialContent) {
        Intrinsics.checkNotNullParameter(metaMaterialContent, "metaMaterialContent");
        return new MetaMaterialContentWrapper(metaMaterialContent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof MetaMaterialContentWrapper) && Intrinsics.areEqual(this.metaMaterialContent, ((MetaMaterialContentWrapper) other).metaMaterialContent)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<MetaMaterialContent> getMetaMaterialContent() {
        return this.metaMaterialContent;
    }

    public int hashCode() {
        return this.metaMaterialContent.hashCode();
    }

    @NotNull
    public String toString() {
        return "MetaMaterialContentWrapper(metaMaterialContent=" + this.metaMaterialContent + ")";
    }

    public MetaMaterialContentWrapper(@NotNull ArrayList<MetaMaterialContent> metaMaterialContent) {
        Intrinsics.checkNotNullParameter(metaMaterialContent, "metaMaterialContent");
        this.metaMaterialContent = metaMaterialContent;
    }

    public /* synthetic */ MetaMaterialContentWrapper(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList);
    }
}
