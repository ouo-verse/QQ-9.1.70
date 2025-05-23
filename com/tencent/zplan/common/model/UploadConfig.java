package com.tencent.zplan.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001'B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u001bH\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bH\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006("}, d2 = {"Lcom/tencent/zplan/common/model/UploadConfig;", "Landroid/os/Parcelable;", "needUpload", "", "target", "Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "checkAppearanceKey", "needCheckUploadConfigRequirement", "(ZLcom/tencent/zplan/common/model/UploadConfig$UploadTarget;ZZ)V", "getCheckAppearanceKey", "()Z", "setCheckAppearanceKey", "(Z)V", "getNeedCheckUploadConfigRequirement", "setNeedCheckUploadConfigRequirement", "getNeedUpload", "setNeedUpload", "getTarget", "()Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "setTarget", "(Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "UploadTarget", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class UploadConfig implements Parcelable {
    public static final Parcelable.Creator<UploadConfig> CREATOR = new a();
    private boolean checkAppearanceKey;
    private boolean needCheckUploadConfigRequirement;
    private boolean needUpload;

    @NotNull
    private UploadTarget target;

    /* compiled from: P */
    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00d6\u0001j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "IDC", "CDN", "CDN_AVATAR", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public enum UploadTarget implements Parcelable {
        IDC,
        CDN,
        CDN_AVATAR;

        public static final Parcelable.Creator<UploadTarget> CREATOR = new a();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<UploadTarget> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final UploadTarget createFromParcel(@NotNull Parcel in5) {
                Intrinsics.checkNotNullParameter(in5, "in");
                return (UploadTarget) Enum.valueOf(UploadTarget.class, in5.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final UploadTarget[] newArray(int i3) {
                return new UploadTarget[i3];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(name());
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class a implements Parcelable.Creator<UploadConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UploadConfig createFromParcel(@NotNull Parcel in5) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(in5, "in");
            boolean z18 = true;
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            UploadTarget uploadTarget = (UploadTarget) Enum.valueOf(UploadTarget.class, in5.readString());
            if (in5.readInt() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (in5.readInt() == 0) {
                z18 = false;
            }
            return new UploadConfig(z16, uploadTarget, z17, z18);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UploadConfig[] newArray(int i3) {
            return new UploadConfig[i3];
        }
    }

    public UploadConfig() {
        this(false, null, false, false, 15, null);
    }

    public static /* synthetic */ UploadConfig copy$default(UploadConfig uploadConfig, boolean z16, UploadTarget uploadTarget, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = uploadConfig.needUpload;
        }
        if ((i3 & 2) != 0) {
            uploadTarget = uploadConfig.target;
        }
        if ((i3 & 4) != 0) {
            z17 = uploadConfig.checkAppearanceKey;
        }
        if ((i3 & 8) != 0) {
            z18 = uploadConfig.needCheckUploadConfigRequirement;
        }
        return uploadConfig.copy(z16, uploadTarget, z17, z18);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getNeedUpload() {
        return this.needUpload;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UploadTarget getTarget() {
        return this.target;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCheckAppearanceKey() {
        return this.checkAppearanceKey;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getNeedCheckUploadConfigRequirement() {
        return this.needCheckUploadConfigRequirement;
    }

    @NotNull
    public final UploadConfig copy(boolean needUpload, @NotNull UploadTarget target, boolean checkAppearanceKey, boolean needCheckUploadConfigRequirement) {
        Intrinsics.checkNotNullParameter(target, "target");
        return new UploadConfig(needUpload, target, checkAppearanceKey, needCheckUploadConfigRequirement);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof UploadConfig) {
                UploadConfig uploadConfig = (UploadConfig) other;
                if (this.needUpload != uploadConfig.needUpload || !Intrinsics.areEqual(this.target, uploadConfig.target) || this.checkAppearanceKey != uploadConfig.checkAppearanceKey || this.needCheckUploadConfigRequirement != uploadConfig.needCheckUploadConfigRequirement) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getCheckAppearanceKey() {
        return this.checkAppearanceKey;
    }

    public final boolean getNeedCheckUploadConfigRequirement() {
        return this.needCheckUploadConfigRequirement;
    }

    public final boolean getNeedUpload() {
        return this.needUpload;
    }

    @NotNull
    public final UploadTarget getTarget() {
        return this.target;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    public int hashCode() {
        int i3;
        boolean z16 = this.needUpload;
        int i16 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i17 = r06 * 31;
        UploadTarget uploadTarget = this.target;
        if (uploadTarget != null) {
            i3 = uploadTarget.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i17 + i3) * 31;
        ?? r26 = this.checkAppearanceKey;
        int i19 = r26;
        if (r26 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z17 = this.needCheckUploadConfigRequirement;
        if (!z17) {
            i16 = z17 ? 1 : 0;
        }
        return i26 + i16;
    }

    public final void setCheckAppearanceKey(boolean z16) {
        this.checkAppearanceKey = z16;
    }

    public final void setNeedCheckUploadConfigRequirement(boolean z16) {
        this.needCheckUploadConfigRequirement = z16;
    }

    public final void setNeedUpload(boolean z16) {
        this.needUpload = z16;
    }

    public final void setTarget(@NotNull UploadTarget uploadTarget) {
        Intrinsics.checkNotNullParameter(uploadTarget, "<set-?>");
        this.target = uploadTarget;
    }

    @NotNull
    public String toString() {
        return "UploadConfig(needUpload=" + this.needUpload + ", target=" + this.target + ", checkAppearanceKey=" + this.checkAppearanceKey + ", needCheckUploadConfigRequirement=" + this.needCheckUploadConfigRequirement + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.needUpload ? 1 : 0);
        parcel.writeString(this.target.name());
        parcel.writeInt(this.checkAppearanceKey ? 1 : 0);
        parcel.writeInt(this.needCheckUploadConfigRequirement ? 1 : 0);
    }

    public UploadConfig(boolean z16, @NotNull UploadTarget target, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.needUpload = z16;
        this.target = target;
        this.checkAppearanceKey = z17;
        this.needCheckUploadConfigRequirement = z18;
    }

    public /* synthetic */ UploadConfig(boolean z16, UploadTarget uploadTarget, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? UploadTarget.IDC : uploadTarget, (i3 & 4) != 0 ? true : z17, (i3 & 8) != 0 ? false : z18);
    }
}
