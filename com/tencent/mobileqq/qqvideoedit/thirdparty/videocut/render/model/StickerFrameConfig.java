package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/StickerFrameConfig;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "centerX", UserInfo.SEX_FEMALE, "getCenterX", "()F", "centerY", "getCenterY", "angle", "getAngle", "minScale", "getMinScale", "maxScale", "getMaxScale", "scale", "getScale", "<init>", "(FFFFFF)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class StickerFrameConfig implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<StickerFrameConfig> CREATOR = new a();

    @SerializedName("angle")
    private final float angle;

    @SerializedName("centerX")
    private final float centerX;

    @SerializedName("centerY")
    private final float centerY;

    @SerializedName("maxScale")
    private final float maxScale;

    @SerializedName("minScale")
    private final float minScale;

    @SerializedName("scale")
    private final float scale;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class a implements Parcelable.Creator<StickerFrameConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StickerFrameConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StickerFrameConfig(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StickerFrameConfig[] newArray(int i3) {
            return new StickerFrameConfig[i3];
        }
    }

    public StickerFrameConfig() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerFrameConfig)) {
            return false;
        }
        StickerFrameConfig stickerFrameConfig = (StickerFrameConfig) other;
        if (Float.compare(this.centerX, stickerFrameConfig.centerX) == 0 && Float.compare(this.centerY, stickerFrameConfig.centerY) == 0 && Float.compare(this.angle, stickerFrameConfig.angle) == 0 && Float.compare(this.minScale, stickerFrameConfig.minScale) == 0 && Float.compare(this.maxScale, stickerFrameConfig.maxScale) == 0 && Float.compare(this.scale, stickerFrameConfig.scale) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.centerX) * 31) + Float.floatToIntBits(this.centerY)) * 31) + Float.floatToIntBits(this.angle)) * 31) + Float.floatToIntBits(this.minScale)) * 31) + Float.floatToIntBits(this.maxScale)) * 31) + Float.floatToIntBits(this.scale);
    }

    @NotNull
    public String toString() {
        return "StickerFrameConfig(centerX=" + this.centerX + ", centerY=" + this.centerY + ", angle=" + this.angle + ", minScale=" + this.minScale + ", maxScale=" + this.maxScale + ", scale=" + this.scale + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeFloat(this.centerX);
        parcel.writeFloat(this.centerY);
        parcel.writeFloat(this.angle);
        parcel.writeFloat(this.minScale);
        parcel.writeFloat(this.maxScale);
        parcel.writeFloat(this.scale);
    }

    public StickerFrameConfig(float f16, float f17, float f18, float f19, float f26, float f27) {
        this.centerX = f16;
        this.centerY = f17;
        this.angle = f18;
        this.minScale = f19;
        this.maxScale = f26;
        this.scale = f27;
    }

    public /* synthetic */ StickerFrameConfig(float f16, float f17, float f18, float f19, float f26, float f27, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) == 0 ? f18 : 0.0f, (i3 & 8) != 0 ? 0.2f : f19, (i3 & 16) != 0 ? 10.0f : f26, (i3 & 32) != 0 ? 0.4f : f27);
    }
}
