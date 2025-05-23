package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6\u00a8\u00067"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/AvatarSlot;", "", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;IJ)V", HippyTextInputController.COMMAND_getValue, "()J", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "cfgpb_AvatarSlot_EN_SLOT_SUIT", "cfgpb_AvatarSlot_EN_SLOT_HAT", "cfgpb_AvatarSlot_EN_SLOT_HEADDRESS", "cfgpb_AvatarSlot_EN_SLOT_GLASSES", "cfgpb_AvatarSlot_EN_SLOT_HAIR", "cfgpb_AvatarSlot_EN_SLOT_NECKLACE", "cfgpb_AvatarSlot_EN_SLOT_COAT", "cfgpb_AvatarSlot_EN_SLOT_BOTTOM", "cfgpb_AvatarSlot_EN_SLOT_SOCKS", "cfgpb_AvatarSlot_EN_SLOT_SHOES", "cfgpb_AvatarSlot_EN_SLOT_KNAPSACK", "cfgpb_AvatarSlot_EN_SLOT_GLOVE", "cfgpb_AvatarSlot_EN_SLOT_MASK", "cfgpb_AvatarSlot_EN_SLOT_EARRINGS", "cfgpb_AvatarSlot_EN_SLOT_WATCHES", "cfgpb_AvatarSlot_EN_SLOT_BADGE", "cfgpb_AvatarSlot_EN_SLOT_TAIL", "cfgpb_AvatarSlot_EN_SLOT_RING", "cfgpb_AvatarSlot_EN_SLOT_OUTLINE", "cfgpb_AvatarSlot_EN_SLOT_BLUSH", "cfgpb_AvatarSlot_EN_SLOT_EYEBROW", "cfgpb_AvatarSlot_EN_SLOT_EYE", "cfgpb_AvatarSlot_EN_SLOT_PUPIL", "cfgpb_AvatarSlot_EN_SLOT_EYESHADOW", "cfgpb_AvatarSlot_EN_SLOT_EYELASH", "cfgpb_AvatarSlot_EN_SLOT_NOSE", "cfgpb_AvatarSlot_EN_SLOT_LIPS", "cfgpb_AvatarSlot_EN_SLOT_MAKEUP", "cfgpb_AvatarSlot_EN_SLOT_FACIALFEATURES", "cfgpb_AvatarSlot_EN_SLOT_MOTTLING", "cfgpb_AvatarSlot_EN_SLOT_COLORPAINTING", "cfgpb_AvatarSlot_EN_SLOT_EYELINE", "cfgpb_AvatarSlot_EN_SLOT_EYESOCKET", "cfgpb_AvatarSlot_EN_SLOT_BODY", "cfgpb_AvatarSlot_EN_SLOT_LIPSTICK", "cfgpb_AvatarSlot_EN_SLOT_AEGYOSAL", "cfgpb_AvatarSlot_EN_SLOT_BEARD", "cfgpb_AvatarSlot_EN_SLOT_HANDHELD", "cfgpb_AvatarSlot_EN_SLOT_WING", "cfgpb_AvatarSlot_EN_SLOT_EPAULET", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum AvatarSlot implements Parcelable {
    cfgpb_AvatarSlot_EN_SLOT_SUIT(0),
    cfgpb_AvatarSlot_EN_SLOT_HAT(1),
    cfgpb_AvatarSlot_EN_SLOT_HEADDRESS(2),
    cfgpb_AvatarSlot_EN_SLOT_GLASSES(3),
    cfgpb_AvatarSlot_EN_SLOT_HAIR(4),
    cfgpb_AvatarSlot_EN_SLOT_NECKLACE(5),
    cfgpb_AvatarSlot_EN_SLOT_COAT(6),
    cfgpb_AvatarSlot_EN_SLOT_BOTTOM(7),
    cfgpb_AvatarSlot_EN_SLOT_SOCKS(8),
    cfgpb_AvatarSlot_EN_SLOT_SHOES(9),
    cfgpb_AvatarSlot_EN_SLOT_KNAPSACK(10),
    cfgpb_AvatarSlot_EN_SLOT_GLOVE(11),
    cfgpb_AvatarSlot_EN_SLOT_MASK(12),
    cfgpb_AvatarSlot_EN_SLOT_EARRINGS(13),
    cfgpb_AvatarSlot_EN_SLOT_WATCHES(14),
    cfgpb_AvatarSlot_EN_SLOT_BADGE(15),
    cfgpb_AvatarSlot_EN_SLOT_TAIL(16),
    cfgpb_AvatarSlot_EN_SLOT_RING(17),
    cfgpb_AvatarSlot_EN_SLOT_OUTLINE(101),
    cfgpb_AvatarSlot_EN_SLOT_BLUSH(102),
    cfgpb_AvatarSlot_EN_SLOT_EYEBROW(103),
    cfgpb_AvatarSlot_EN_SLOT_EYE(104),
    cfgpb_AvatarSlot_EN_SLOT_PUPIL(105),
    cfgpb_AvatarSlot_EN_SLOT_EYESHADOW(106),
    cfgpb_AvatarSlot_EN_SLOT_EYELASH(107),
    cfgpb_AvatarSlot_EN_SLOT_NOSE(108),
    cfgpb_AvatarSlot_EN_SLOT_LIPS(109),
    cfgpb_AvatarSlot_EN_SLOT_MAKEUP(110),
    cfgpb_AvatarSlot_EN_SLOT_FACIALFEATURES(111),
    cfgpb_AvatarSlot_EN_SLOT_MOTTLING(112),
    cfgpb_AvatarSlot_EN_SLOT_COLORPAINTING(113),
    cfgpb_AvatarSlot_EN_SLOT_EYELINE(114),
    cfgpb_AvatarSlot_EN_SLOT_EYESOCKET(115),
    cfgpb_AvatarSlot_EN_SLOT_BODY(116),
    cfgpb_AvatarSlot_EN_SLOT_LIPSTICK(117),
    cfgpb_AvatarSlot_EN_SLOT_AEGYOSAL(119),
    cfgpb_AvatarSlot_EN_SLOT_BEARD(120),
    cfgpb_AvatarSlot_EN_SLOT_HANDHELD(201),
    cfgpb_AvatarSlot_EN_SLOT_WING(202),
    cfgpb_AvatarSlot_EN_SLOT_EPAULET(203);

    public static final Parcelable.Creator<AvatarSlot> CREATOR = new Parcelable.Creator<AvatarSlot>() { // from class: com.tencent.filament.zplan.avatar.model.AvatarSlot.a
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AvatarSlot createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return (AvatarSlot) Enum.valueOf(AvatarSlot.class, in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AvatarSlot[] newArray(int i3) {
            return new AvatarSlot[i3];
        }
    };
    private final long value;

    AvatarSlot(long j3) {
        this.value = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
