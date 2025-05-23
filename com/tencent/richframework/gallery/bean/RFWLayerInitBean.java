package com.tencent.richframework.gallery.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\t\b\u0016\u00a2\u0006\u0004\b!\u0010\"B\u0011\b\u0014\u0012\u0006\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "richMediaDataList", "Ljava/util/List;", "getRichMediaDataList", "()Ljava/util/List;", "setRichMediaDataList", "(Ljava/util/List;)V", "enterPos", "I", "getEnterPos", "()I", "setEnterPos", "(I)V", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "transitionBean", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "getTransitionBean", "()Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "setTransitionBean", "(Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;)V", "mTransAnimBeanCreatorId", "getMTransAnimBeanCreatorId", "setMTransAnimBeanCreatorId", "<init>", "()V", "in", "(Landroid/os/Parcel;)V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWLayerInitBean implements Parcelable {
    private int enterPos;
    private int mTransAnimBeanCreatorId;

    @Nullable
    private List<? extends RFWLayerItemMediaInfo> richMediaDataList;

    @Nullable
    private RFWTransAnimBean transitionBean;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<RFWLayerInitBean> CREATOR = new Parcelable.Creator<RFWLayerInitBean>() { // from class: com.tencent.richframework.gallery.bean.RFWLayerInitBean$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RFWLayerInitBean createFromParcel(@NotNull Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new RFWLayerInitBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RFWLayerInitBean[] newArray(int size) {
            return new RFWLayerInitBean[size];
        }
    };

    public RFWLayerInitBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getEnterPos() {
        return this.enterPos;
    }

    public final int getMTransAnimBeanCreatorId() {
        return this.mTransAnimBeanCreatorId;
    }

    @Nullable
    public final List<RFWLayerItemMediaInfo> getRichMediaDataList() {
        return this.richMediaDataList;
    }

    @Nullable
    public final RFWTransAnimBean getTransitionBean() {
        return this.transitionBean;
    }

    public final void setEnterPos(int i3) {
        this.enterPos = i3;
    }

    public final void setMTransAnimBeanCreatorId(int i3) {
        this.mTransAnimBeanCreatorId = i3;
    }

    public final void setRichMediaDataList(@Nullable List<? extends RFWLayerItemMediaInfo> list) {
        this.richMediaDataList = list;
    }

    public final void setTransitionBean(@Nullable RFWTransAnimBean rFWTransAnimBean) {
        this.transitionBean = rFWTransAnimBean;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeTypedList(this.richMediaDataList);
        dest.writeInt(this.enterPos);
        dest.writeSerializable(this.transitionBean);
        dest.writeInt(this.mTransAnimBeanCreatorId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWLayerInitBean(@NotNull Parcel in5) {
        Intrinsics.checkNotNullParameter(in5, "in");
        this.richMediaDataList = in5.createTypedArrayList(RFWLayerItemMediaInfo.CREATOR);
        this.enterPos = in5.readInt();
        this.transitionBean = (RFWTransAnimBean) in5.readSerializable();
        this.mTransAnimBeanCreatorId = in5.readInt();
    }
}
