package com.tencent.mobileqq.flock.layer.bean;

import android.widget.ImageView;
import com.tencent.mobileqq.flock.base.FlockInitBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/flock/layer/bean/FlockLayerInitBean;", "Lcom/tencent/mobileqq/flock/base/FlockInitBean;", "curPos", "", "clickView", "Landroid/widget/ImageView;", "mediaInfoList", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "(ILandroid/widget/ImageView;Ljava/util/List;)V", "getClickView", "()Landroid/widget/ImageView;", "getCurPos", "()I", "getMediaInfoList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final /* data */ class FlockLayerInitBean extends FlockInitBean {
    static IPatchRedirector $redirector_;

    @Nullable
    private final ImageView clickView;
    private final int curPos;

    @NotNull
    private final List<RFWLayerItemMediaInfo> mediaInfoList;

    public FlockLayerInitBean() {
        this(0, null, null, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FlockLayerInitBean copy$default(FlockLayerInitBean flockLayerInitBean, int i3, ImageView imageView, List list, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = flockLayerInitBean.curPos;
        }
        if ((i16 & 2) != 0) {
            imageView = flockLayerInitBean.clickView;
        }
        if ((i16 & 4) != 0) {
            list = flockLayerInitBean.mediaInfoList;
        }
        return flockLayerInitBean.copy(i3, imageView, list);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.curPos;
    }

    @Nullable
    public final ImageView component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ImageView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.clickView;
    }

    @NotNull
    public final List<RFWLayerItemMediaInfo> component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mediaInfoList;
    }

    @NotNull
    public final FlockLayerInitBean copy(int curPos, @Nullable ImageView clickView, @NotNull List<? extends RFWLayerItemMediaInfo> mediaInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (FlockLayerInitBean) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(curPos), clickView, mediaInfoList);
        }
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        return new FlockLayerInitBean(curPos, clickView, mediaInfoList);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlockLayerInitBean)) {
            return false;
        }
        FlockLayerInitBean flockLayerInitBean = (FlockLayerInitBean) other;
        if (this.curPos == flockLayerInitBean.curPos && Intrinsics.areEqual(this.clickView, flockLayerInitBean.clickView) && Intrinsics.areEqual(this.mediaInfoList, flockLayerInitBean.mediaInfoList)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final ImageView getClickView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.clickView;
    }

    public final int getCurPos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.curPos;
    }

    @NotNull
    public final List<RFWLayerItemMediaInfo> getMediaInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mediaInfoList;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = this.curPos * 31;
        ImageView imageView = this.clickView;
        if (imageView == null) {
            hashCode = 0;
        } else {
            hashCode = imageView.hashCode();
        }
        return ((i3 + hashCode) * 31) + this.mediaInfoList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "FlockLayerInitBean(curPos=" + this.curPos + ", clickView=" + this.clickView + ", mediaInfoList=" + this.mediaInfoList + ")";
    }

    public /* synthetic */ FlockLayerInitBean(int i3, ImageView imageView, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : imageView, (i16 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), imageView, list, Integer.valueOf(i16), defaultConstructorMarker);
    }

    public FlockLayerInitBean(int i3, @Nullable ImageView imageView, @NotNull List<? extends RFWLayerItemMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), imageView, mediaInfoList);
            return;
        }
        this.curPos = i3;
        this.clickView = imageView;
        this.mediaInfoList = mediaInfoList;
    }
}
