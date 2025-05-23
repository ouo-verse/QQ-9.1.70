package com.tencent.mobileqq.guild.feed.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B/\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0004\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0011H\u00d6\u0001J\u0019\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\t\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u000b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0017\u0010\r\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b#\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "component5", "screenX", "screenY", "widthSource", "heightSource", "limitHeight", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", UserInfo.SEX_FEMALE, "getScreenX", "()F", "getScreenY", "getWidthSource", "getHeightSource", "getLimitHeight", "<init>", "(FFFFF)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class AnimationParams implements Parcelable, Serializable {
    private final float heightSource;
    private final float limitHeight;
    private final float screenX;
    private final float screenY;
    private final float widthSource;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<AnimationParams> CREATOR = new b();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/AnimationParams$a;", "", "Landroid/view/View;", "animaView", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.api.AnimationParams$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AnimationParams a(@NotNull View animaView) {
            Intrinsics.checkNotNullParameter(animaView, "animaView");
            animaView.getLocationInWindow(new int[2]);
            return new AnimationParams(r0[0], r0[1], animaView.getWidth(), animaView.getHeight(), animaView.getHeight());
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<AnimationParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AnimationParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AnimationParams(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AnimationParams[] newArray(int i3) {
            return new AnimationParams[i3];
        }
    }

    public AnimationParams(float f16, float f17, float f18, float f19, float f26) {
        this.screenX = f16;
        this.screenY = f17;
        this.widthSource = f18;
        this.heightSource = f19;
        this.limitHeight = f26;
    }

    public static /* synthetic */ AnimationParams copy$default(AnimationParams animationParams, float f16, float f17, float f18, float f19, float f26, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = animationParams.screenX;
        }
        if ((i3 & 2) != 0) {
            f17 = animationParams.screenY;
        }
        float f27 = f17;
        if ((i3 & 4) != 0) {
            f18 = animationParams.widthSource;
        }
        float f28 = f18;
        if ((i3 & 8) != 0) {
            f19 = animationParams.heightSource;
        }
        float f29 = f19;
        if ((i3 & 16) != 0) {
            f26 = animationParams.limitHeight;
        }
        return animationParams.copy(f16, f27, f28, f29, f26);
    }

    /* renamed from: component1, reason: from getter */
    public final float getScreenX() {
        return this.screenX;
    }

    /* renamed from: component2, reason: from getter */
    public final float getScreenY() {
        return this.screenY;
    }

    /* renamed from: component3, reason: from getter */
    public final float getWidthSource() {
        return this.widthSource;
    }

    /* renamed from: component4, reason: from getter */
    public final float getHeightSource() {
        return this.heightSource;
    }

    /* renamed from: component5, reason: from getter */
    public final float getLimitHeight() {
        return this.limitHeight;
    }

    @NotNull
    public final AnimationParams copy(float screenX, float screenY, float widthSource, float heightSource, float limitHeight) {
        return new AnimationParams(screenX, screenY, widthSource, heightSource, limitHeight);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationParams)) {
            return false;
        }
        AnimationParams animationParams = (AnimationParams) other;
        if (Float.compare(this.screenX, animationParams.screenX) == 0 && Float.compare(this.screenY, animationParams.screenY) == 0 && Float.compare(this.widthSource, animationParams.widthSource) == 0 && Float.compare(this.heightSource, animationParams.heightSource) == 0 && Float.compare(this.limitHeight, animationParams.limitHeight) == 0) {
            return true;
        }
        return false;
    }

    public final float getHeightSource() {
        return this.heightSource;
    }

    public final float getLimitHeight() {
        return this.limitHeight;
    }

    public final float getScreenX() {
        return this.screenX;
    }

    public final float getScreenY() {
        return this.screenY;
    }

    public final float getWidthSource() {
        return this.widthSource;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.screenX) * 31) + Float.floatToIntBits(this.screenY)) * 31) + Float.floatToIntBits(this.widthSource)) * 31) + Float.floatToIntBits(this.heightSource)) * 31) + Float.floatToIntBits(this.limitHeight);
    }

    @NotNull
    public String toString() {
        return "AnimationParams(screenX=" + this.screenX + ", screenY=" + this.screenY + ", widthSource=" + this.widthSource + ", heightSource=" + this.heightSource + ", limitHeight=" + this.limitHeight + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeFloat(this.screenX);
        parcel.writeFloat(this.screenY);
        parcel.writeFloat(this.widthSource);
        parcel.writeFloat(this.heightSource);
        parcel.writeFloat(this.limitHeight);
    }
}
