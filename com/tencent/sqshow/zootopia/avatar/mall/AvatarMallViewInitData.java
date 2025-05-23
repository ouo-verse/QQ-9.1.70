package com.tencent.sqshow.zootopia.avatar.mall;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/mall/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "()Landroidx/fragment/app/FragmentActivity;", "context", "b", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "pageId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "c", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "currentSource", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.avatar.mall.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class AvatarMallViewInitData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final FragmentActivity context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pageId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaSource currentSource;

    public AvatarMallViewInitData(FragmentActivity context, String pageId, ZootopiaSource currentSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(currentSource, "currentSource");
        this.context = context;
        this.pageId = pageId;
        this.currentSource = currentSource;
    }

    /* renamed from: a, reason: from getter */
    public final FragmentActivity getContext() {
        return this.context;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaSource getCurrentSource() {
        return this.currentSource;
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + this.pageId.hashCode()) * 31) + this.currentSource.hashCode();
    }

    public String toString() {
        return "AvatarMallViewInitData(context=" + this.context + ", pageId=" + this.pageId + ", currentSource=" + this.currentSource + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarMallViewInitData)) {
            return false;
        }
        AvatarMallViewInitData avatarMallViewInitData = (AvatarMallViewInitData) other;
        return Intrinsics.areEqual(this.context, avatarMallViewInitData.context) && Intrinsics.areEqual(this.pageId, avatarMallViewInitData.pageId) && Intrinsics.areEqual(this.currentSource, avatarMallViewInitData.currentSource);
    }
}
