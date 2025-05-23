package com.tencent.biz.qqcircle.immersive.personal.part;

import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTemplateCarouselInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/az;", "", "", "c", "", "toString", "", "hashCode", "other", "equals", "", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/t;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "g", "(Ljava/util/List;)V", "infoList", "Z", "()Z", "d", "(Z)V", "hasDraft", "getHasSetInfoList", "f", "hasSetInfoList", "getHasSetHasDraft", "e", "hasSetHasDraft", "<init>", "(Ljava/util/List;ZZZ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.personal.part.az, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class TemplateCarouselZip {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<QFSPersonalTemplateCarouselInfo> infoList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasDraft;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasSetInfoList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasSetHasDraft;

    public TemplateCarouselZip() {
        this(null, false, false, false, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasDraft() {
        return this.hasDraft;
    }

    @NotNull
    public final List<QFSPersonalTemplateCarouselInfo> b() {
        return this.infoList;
    }

    public final boolean c() {
        if (this.hasSetInfoList && this.hasSetHasDraft) {
            return true;
        }
        return false;
    }

    public final void d(boolean z16) {
        this.hasDraft = z16;
    }

    public final void e(boolean z16) {
        this.hasSetHasDraft = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateCarouselZip)) {
            return false;
        }
        TemplateCarouselZip templateCarouselZip = (TemplateCarouselZip) other;
        if (Intrinsics.areEqual(this.infoList, templateCarouselZip.infoList) && this.hasDraft == templateCarouselZip.hasDraft && this.hasSetInfoList == templateCarouselZip.hasSetInfoList && this.hasSetHasDraft == templateCarouselZip.hasSetHasDraft) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.hasSetInfoList = z16;
    }

    public final void g(@NotNull List<QFSPersonalTemplateCarouselInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.infoList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.infoList.hashCode() * 31;
        boolean z16 = this.hasDraft;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.hasSetInfoList;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.hasSetHasDraft;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "TemplateCarouselZip(infoList=" + this.infoList + ", hasDraft=" + this.hasDraft + ", hasSetInfoList=" + this.hasSetInfoList + ", hasSetHasDraft=" + this.hasSetHasDraft + ")";
    }

    public TemplateCarouselZip(@NotNull List<QFSPersonalTemplateCarouselInfo> infoList, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.infoList = infoList;
        this.hasDraft = z16;
        this.hasSetInfoList = z17;
        this.hasSetHasDraft = z18;
    }

    public /* synthetic */ TemplateCarouselZip(List list, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17, (i3 & 8) != 0 ? false : z18);
    }
}
