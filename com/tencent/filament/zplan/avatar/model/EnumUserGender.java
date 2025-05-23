package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.ttpic.openapi.filter.LightConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\n\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "GENDER_UNINIT", "GENDER_MALE", "GENDER_FEMALE", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum EnumUserGender implements Parcelable {
    GENDER_UNINIT(0),
    GENDER_MALE(1),
    GENDER_FEMALE(2);

    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<EnumUserGender> CREATOR = new Parcelable.Creator<EnumUserGender>() { // from class: com.tencent.filament.zplan.avatar.model.EnumUserGender.b
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final EnumUserGender createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return (EnumUserGender) Enum.valueOf(EnumUserGender.class, in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final EnumUserGender[] newArray(int i3) {
            return new EnumUserGender[i3];
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/EnumUserGender$a;", "", "", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "a", "", "b", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.avatar.model.EnumUserGender$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final EnumUserGender a(int i3) {
            EnumUserGender enumUserGender = EnumUserGender.GENDER_FEMALE;
            if (i3 != enumUserGender.getValue()) {
                EnumUserGender enumUserGender2 = EnumUserGender.GENDER_MALE;
                if (i3 != enumUserGender2.getValue()) {
                    return EnumUserGender.GENDER_UNINIT;
                }
                return enumUserGender2;
            }
            return enumUserGender;
        }

        @NotNull
        public final String b(int i3) {
            if (i3 == EnumUserGender.GENDER_FEMALE.getValue()) {
                return LightConstants.FEMALE;
            }
            if (i3 == EnumUserGender.GENDER_MALE.getValue()) {
                return LightConstants.MALE;
            }
            return "unknown";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    EnumUserGender(int i3) {
        this.value = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
