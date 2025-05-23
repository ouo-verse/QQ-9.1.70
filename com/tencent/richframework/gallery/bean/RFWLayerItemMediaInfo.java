package com.tencent.richframework.gallery.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0016\u0018\u0000 52\u00020\u0001:\u00015B\t\b\u0016\u00a2\u0006\u0004\b1\u00102B\u0011\b\u0014\u0012\u0006\u00103\u001a\u00020\u0004\u00a2\u0006\u0004\b1\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\u0004\u0018\u00010\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u001bR\u0011\u0010.\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u001bR\u0013\u00100\u001a\u0004\u0018\u00010\u001e8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010*\u00a8\u00066"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoInfo;", "layerVideoInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoInfo;", "getLayerVideoInfo", "()Lcom/tencent/richframework/gallery/bean/RFWLayerVideoInfo;", "setLayerVideoInfo", "(Lcom/tencent/richframework/gallery/bean/RFWLayerVideoInfo;)V", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layerPicInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "getLayerPicInfo", "()Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "setLayerPicInfo", "(Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;)V", "", HippyReporter.RemoveEngineReason.INVALID, "Z", "getInvalid", "()Z", "setInvalid", "(Z)V", "", "_mediaId", "Ljava/lang/String;", "", WadlProxyConsts.EXTRA_DATA, "Ljava/lang/Object;", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "mediaId", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "isShowOriginPic", "getExistSaveOrEditPath", "existSaveOrEditPath", "<init>", "()V", "in", "(Landroid/os/Parcel;)V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWLayerItemMediaInfo implements Parcelable {
    private String _mediaId;

    @Nullable
    private transient Object extraData;
    private boolean invalid;

    @Nullable
    private RFWLayerPicInfo layerPicInfo;

    @Nullable
    private RFWLayerVideoInfo layerVideoInfo;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<RFWLayerItemMediaInfo> CREATOR = new Parcelable.Creator<RFWLayerItemMediaInfo>() { // from class: com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RFWLayerItemMediaInfo createFromParcel(@NotNull Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new RFWLayerItemMediaInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RFWLayerItemMediaInfo[] newArray(int size) {
            return newArray(size);
        }
    };

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getCurrentIndex", "", "currentMediaInfo", "newMediaList", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public final int getCurrentIndex(@Nullable RFWLayerItemMediaInfo currentMediaInfo, @Nullable List<? extends RFWLayerItemMediaInfo> newMediaList) {
            if (currentMediaInfo != null && newMediaList != null) {
                int size = newMediaList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (!TextUtils.isEmpty(currentMediaInfo.getMediaId()) && Intrinsics.areEqual(currentMediaInfo.getMediaId(), newMediaList.get(i3).getMediaId())) {
                        return i3;
                    }
                }
                RFWLog.e("RFWLayerPagePart", RFWLog.USR, " can't find currentIndex from mediaList");
                return -1;
            }
            RFWLog.e("RFWLayerPagePart", RFWLog.USR, " can't find currentIndex from error inputData");
            return -1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFWLayerItemMediaInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getExistSaveOrEditPath() {
        RFWLayerVideoInfo rFWLayerVideoInfo = this.layerVideoInfo;
        if (rFWLayerVideoInfo != null) {
            Intrinsics.checkNotNull(rFWLayerVideoInfo);
            if (RFWFileUtils.fileExists(rFWLayerVideoInfo.getLocalPath())) {
                RFWLayerVideoInfo rFWLayerVideoInfo2 = this.layerVideoInfo;
                Intrinsics.checkNotNull(rFWLayerVideoInfo2);
                return rFWLayerVideoInfo2.getLocalPath();
            }
        }
        RFWLayerPicInfo rFWLayerPicInfo = this.layerPicInfo;
        if (rFWLayerPicInfo != null) {
            Intrinsics.checkNotNull(rFWLayerPicInfo);
            return rFWLayerPicInfo.getMaxsizeFile();
        }
        return null;
    }

    @Nullable
    public final Object getExtraData() {
        return this.extraData;
    }

    public final boolean getInvalid() {
        return this.invalid;
    }

    @Nullable
    public final RFWLayerPicInfo getLayerPicInfo() {
        return this.layerPicInfo;
    }

    @Nullable
    public final RFWLayerVideoInfo getLayerVideoInfo() {
        return this.layerVideoInfo;
    }

    @Nullable
    public final String getMediaId() {
        RFWLayerPicInfo rFWLayerPicInfo;
        RFWLayerVideoInfo rFWLayerVideoInfo;
        String str = this._mediaId;
        if (TextUtils.isEmpty(str) && (rFWLayerVideoInfo = this.layerVideoInfo) != null) {
            Intrinsics.checkNotNull(rFWLayerVideoInfo);
            str = rFWLayerVideoInfo.getPlayId();
        }
        if (TextUtils.isEmpty(str) && (rFWLayerPicInfo = this.layerPicInfo) != null) {
            if (rFWLayerPicInfo != null) {
                return rFWLayerPicInfo.getPicId();
            }
            return null;
        }
        return str;
    }

    public final boolean isShowOriginPic() {
        RFWLayerPicInfo rFWLayerPicInfo;
        if (!isVideo() && (rFWLayerPicInfo = this.layerPicInfo) != null) {
            Intrinsics.checkNotNull(rFWLayerPicInfo);
            RFWLayerPicInfo.RFWPicInfo originPicInfo = rFWLayerPicInfo.getOriginPicInfo();
            RFWLayerPicInfo rFWLayerPicInfo2 = this.layerPicInfo;
            Intrinsics.checkNotNull(rFWLayerPicInfo2);
            if (Intrinsics.areEqual(originPicInfo, rFWLayerPicInfo2.getCurrentPicInfo())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isVideo() {
        if (this.layerVideoInfo != null) {
            return true;
        }
        return false;
    }

    public final void setExtraData(@Nullable Object obj) {
        this.extraData = obj;
    }

    public final void setInvalid(boolean z16) {
        this.invalid = z16;
    }

    public final void setLayerPicInfo(@Nullable RFWLayerPicInfo rFWLayerPicInfo) {
        this.layerPicInfo = rFWLayerPicInfo;
    }

    public final void setLayerVideoInfo(@Nullable RFWLayerVideoInfo rFWLayerVideoInfo) {
        this.layerVideoInfo = rFWLayerVideoInfo;
    }

    public final void setMediaId(@Nullable String str) {
        this._mediaId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        int i3;
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeSerializable(this.layerVideoInfo);
        dest.writeSerializable(this.layerPicInfo);
        if (this.invalid) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        dest.writeByte((byte) i3);
        dest.writeString(getMediaId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWLayerItemMediaInfo(@NotNull Parcel in5) {
        Intrinsics.checkNotNullParameter(in5, "in");
        this.layerVideoInfo = (RFWLayerVideoInfo) in5.readSerializable();
        this.layerPicInfo = (RFWLayerPicInfo) in5.readSerializable();
        this.invalid = in5.readByte() != 0;
        setMediaId(in5.readString());
    }
}
