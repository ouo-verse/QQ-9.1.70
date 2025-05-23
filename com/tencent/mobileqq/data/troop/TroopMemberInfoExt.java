package com.tencent.mobileqq.data.troop;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "troopUin,memberUin")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u0012\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "Lcom/tencent/mobileqq/persistence/Entity;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "uiInfo", "", "updatePinyin", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "troopUin", "Ljava/lang/String;", "memberUin", "showNameForPinyin", "showNamePinyinFirst", "showNamePinyinAll", "commonFrdCnt", "I", "hwIdentity", "recommendRemark", "getRecommendRemark$annotations", "()V", "", "lastMsgUpdateHonorRichTime", "J", "flagEx3", "", "nickIconRepeatMsgBuffer", "[B", "<init>", "(Landroid/os/Parcel;)V", "CREATOR", "a", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TroopMemberInfoExt extends Entity implements Serializable, Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long VALUE_DISTANCE_TO_SELF_UNKOWN = -100;
    private static final int VALUE_INVALID = -100;

    @JvmField
    public int commonFrdCnt;

    @JvmField
    public long flagEx3;

    @JvmField
    public int hwIdentity;

    @JvmField
    public long lastMsgUpdateHonorRichTime;

    @JvmField
    @Nullable
    public String memberUin;

    @JvmField
    @Nullable
    public byte[] nickIconRepeatMsgBuffer;

    @JvmField
    @Nullable
    public String recommendRemark;

    @JvmField
    @Nullable
    public String showNameForPinyin;

    @JvmField
    @Nullable
    public String showNamePinyinAll;

    @JvmField
    @Nullable
    public String showNamePinyinFirst;

    @JvmField
    @Nullable
    public String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "", "VALUE_DISTANCE_TO_SELF_UNKOWN", "J", "VALUE_INVALID", "I", "<init>", "()V", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.data.troop.TroopMemberInfoExt$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion implements Parcelable.Creator<TroopMemberInfoExt> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopMemberInfoExt createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopMemberInfoExt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopMemberInfoExt[] newArray(int size) {
            return new TroopMemberInfoExt[size];
        }

        Companion() {
        }
    }

    public TroopMemberInfoExt() {
        this.commonFrdCnt = Integer.MIN_VALUE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public String toString() {
        Integer num;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TroopMemberInfoExt{troopUin=");
        sb5.append(this.troopUin);
        sb5.append(", memberUin=");
        sb5.append(this.memberUin);
        sb5.append(", commonFrdCnt:");
        sb5.append(this.commonFrdCnt);
        sb5.append(", hwIdentity=");
        sb5.append(this.hwIdentity);
        sb5.append(", recommendRemark=");
        sb5.append(this.recommendRemark);
        sb5.append(", lastMsgUpdateHonorRichTime:");
        sb5.append(this.lastMsgUpdateHonorRichTime);
        sb5.append(", flagEx3=");
        sb5.append(this.flagEx3);
        sb5.append("}, nickIconRepeatMsgBuffer.size=");
        byte[] bArr = this.nickIconRepeatMsgBuffer;
        if (bArr != null) {
            num = Integer.valueOf(bArr.length);
        } else {
            num = null;
        }
        sb5.append(num);
        return sb5.toString();
    }

    public final void updatePinyin(@NotNull TroopMemberNickUIInfo uiInfo) {
        Intrinsics.checkNotNullParameter(uiInfo, "uiInfo");
        this.showNameForPinyin = uiInfo.getShowName();
        this.showNamePinyinFirst = uiInfo.getShowNamePyFirst();
        this.showNamePinyinAll = uiInfo.getShowNamePyAll();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.troopUin);
        parcel.writeString(this.memberUin);
        parcel.writeString(this.showNameForPinyin);
        parcel.writeString(this.showNamePinyinFirst);
        parcel.writeString(this.showNamePinyinAll);
        parcel.writeInt(this.commonFrdCnt);
        parcel.writeInt(this.hwIdentity);
        parcel.writeString(this.recommendRemark);
        parcel.writeLong(this.lastMsgUpdateHonorRichTime);
        parcel.writeLong(this.flagEx3);
        parcel.writeByteArray(this.nickIconRepeatMsgBuffer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TroopMemberInfoExt(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.troopUin = parcel.readString();
        this.memberUin = parcel.readString();
        this.showNameForPinyin = parcel.readString();
        this.showNamePinyinFirst = parcel.readString();
        this.showNamePinyinAll = parcel.readString();
        this.commonFrdCnt = parcel.readInt();
        this.hwIdentity = parcel.readInt();
        this.recommendRemark = parcel.readString();
        this.lastMsgUpdateHonorRichTime = parcel.readLong();
        this.flagEx3 = parcel.readLong();
        this.nickIconRepeatMsgBuffer = parcel.createByteArray();
    }

    @Deprecated(message = "\u667a\u80fd\u5907\u6ce8\u903b\u8f91\u5df2\u7ecf\u4e0b\u67b6")
    public static /* synthetic */ void getRecommendRemark$annotations() {
    }
}
