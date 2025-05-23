package k94;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lk94/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "conflictTips", "b", "I", "d", "()I", "outfitCfgId", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "()Landroid/view/View$OnClickListener;", "confirmClickListener", "cancelClickListener", "<init>", "(Ljava/util/List;ILandroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: k94.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class AvatarTemplateNeedUpdateData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> conflictTips;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int outfitCfgId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final View.OnClickListener confirmClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final View.OnClickListener cancelClickListener;

    public AvatarTemplateNeedUpdateData(List<String> conflictTips, int i3, View.OnClickListener confirmClickListener, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(conflictTips, "conflictTips");
        Intrinsics.checkNotNullParameter(confirmClickListener, "confirmClickListener");
        this.conflictTips = conflictTips;
        this.outfitCfgId = i3;
        this.confirmClickListener = confirmClickListener;
        this.cancelClickListener = onClickListener;
    }

    /* renamed from: a, reason: from getter */
    public final View.OnClickListener getCancelClickListener() {
        return this.cancelClickListener;
    }

    /* renamed from: b, reason: from getter */
    public final View.OnClickListener getConfirmClickListener() {
        return this.confirmClickListener;
    }

    public final List<String> c() {
        return this.conflictTips;
    }

    /* renamed from: d, reason: from getter */
    public final int getOutfitCfgId() {
        return this.outfitCfgId;
    }

    public int hashCode() {
        int hashCode = ((((this.conflictTips.hashCode() * 31) + this.outfitCfgId) * 31) + this.confirmClickListener.hashCode()) * 31;
        View.OnClickListener onClickListener = this.cancelClickListener;
        return hashCode + (onClickListener == null ? 0 : onClickListener.hashCode());
    }

    public String toString() {
        return "AvatarTemplateNeedUpdateData(conflictTips=" + this.conflictTips + ", outfitCfgId=" + this.outfitCfgId + ", confirmClickListener=" + this.confirmClickListener + ", cancelClickListener=" + this.cancelClickListener + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarTemplateNeedUpdateData)) {
            return false;
        }
        AvatarTemplateNeedUpdateData avatarTemplateNeedUpdateData = (AvatarTemplateNeedUpdateData) other;
        return Intrinsics.areEqual(this.conflictTips, avatarTemplateNeedUpdateData.conflictTips) && this.outfitCfgId == avatarTemplateNeedUpdateData.outfitCfgId && Intrinsics.areEqual(this.confirmClickListener, avatarTemplateNeedUpdateData.confirmClickListener) && Intrinsics.areEqual(this.cancelClickListener, avatarTemplateNeedUpdateData.cancelClickListener);
    }

    public /* synthetic */ AvatarTemplateNeedUpdateData(List list, int i3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i3, onClickListener, (i16 & 8) != 0 ? null : onClickListener2);
    }
}
