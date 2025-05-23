package com.tencent.videocut.render.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/videocut/render/model/StickerConfig;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "actionType", "getActionType", "Lcom/tencent/videocut/render/model/StickerFrameConfig;", AIInput.KEY_FRAME, "Lcom/tencent/videocut/render/model/StickerFrameConfig;", "getFrame", "()Lcom/tencent/videocut/render/model/StickerFrameConfig;", "animationMode", "I", "getAnimationMode", "()I", "", "playEndDuration", "J", "getPlayEndDuration", "()J", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/render/model/StickerFrameConfig;IJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final /* data */ class StickerConfig implements Parcelable {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final Parcelable.Creator<StickerConfig> CREATOR;

    @SerializedName("actionType")
    @NotNull
    private final String actionType;

    @SerializedName("animationMode")
    private final int animationMode;

    @SerializedName(AIInput.KEY_FRAME)
    @NotNull
    private final StickerFrameConfig frame;

    @SerializedName("playEndDuration")
    private final long playEndDuration;

    @SerializedName("type")
    @NotNull
    private final String type;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class a implements Parcelable.Creator<StickerConfig> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StickerConfig createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (StickerConfig) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StickerConfig(parcel.readString(), parcel.readString(), StickerFrameConfig.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StickerConfig[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (StickerConfig[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new StickerConfig[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59844);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            CREATOR = new a();
        }
    }

    public StickerConfig(@NotNull String type, @NotNull String actionType, @NotNull StickerFrameConfig frame, int i3, long j3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(frame, "frame");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, type, actionType, frame, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.type = type;
        this.actionType = actionType;
        this.frame = frame;
        this.animationMode = i3;
        this.playEndDuration = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerConfig)) {
            return false;
        }
        StickerConfig stickerConfig = (StickerConfig) other;
        if (Intrinsics.areEqual(this.type, stickerConfig.type) && Intrinsics.areEqual(this.actionType, stickerConfig.actionType) && Intrinsics.areEqual(this.frame, stickerConfig.frame) && this.animationMode == stickerConfig.animationMode && this.playEndDuration == stickerConfig.playEndDuration) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return (((((((this.type.hashCode() * 31) + this.actionType.hashCode()) * 31) + this.frame.hashCode()) * 31) + this.animationMode) * 31) + androidx.fragment.app.a.a(this.playEndDuration);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "StickerConfig(type=" + this.type + ", actionType=" + this.actionType + ", frame=" + this.frame + ", animationMode=" + this.animationMode + ", playEndDuration=" + this.playEndDuration + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.type);
        parcel.writeString(this.actionType);
        this.frame.writeToParcel(parcel, flags);
        parcel.writeInt(this.animationMode);
        parcel.writeLong(this.playEndDuration);
    }
}
