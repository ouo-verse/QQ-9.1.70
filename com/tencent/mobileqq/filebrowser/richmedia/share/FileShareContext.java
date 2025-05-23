package com.tencent.mobileqq.filebrowser.richmedia.share;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u000f\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragment", "Landroid/view/View;", "c", "Landroid/view/View;", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRootView", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "d", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "layerItemInfo", "<init>", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;Landroid/view/View;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;)V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.filebrowser.richmedia.share.m, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class FileShareContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Fragment fragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private View mRootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RFWLayerItemMediaInfo layerItemInfo;

    public FileShareContext(@NotNull Activity activity, @NotNull Fragment fragment, @NotNull View mRootView, @NotNull RFWLayerItemMediaInfo layerItemInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(layerItemInfo, "layerItemInfo");
        this.activity = activity;
        this.fragment = fragment;
        this.mRootView = mRootView;
        this.layerItemInfo = layerItemInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final RFWLayerItemMediaInfo getLayerItemInfo() {
        return this.layerItemInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final View getMRootView() {
        return this.mRootView;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileShareContext)) {
            return false;
        }
        FileShareContext fileShareContext = (FileShareContext) other;
        if (Intrinsics.areEqual(this.activity, fileShareContext.activity) && Intrinsics.areEqual(this.fragment, fileShareContext.fragment) && Intrinsics.areEqual(this.mRootView, fileShareContext.mRootView) && Intrinsics.areEqual(this.layerItemInfo, fileShareContext.layerItemInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.activity.hashCode() * 31) + this.fragment.hashCode()) * 31) + this.mRootView.hashCode()) * 31) + this.layerItemInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "FileShareContext(activity=" + this.activity + ", fragment=" + this.fragment + ", mRootView=" + this.mRootView + ", layerItemInfo=" + this.layerItemInfo + ")";
    }
}
