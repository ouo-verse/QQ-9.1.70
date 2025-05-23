package com.tencent.now.od.ui.game.odgame.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\b\u0082\b\u0018\u0000 #2\u00020\u0001:\u0001$B!\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"com/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "", "d", "J", "getUid", "()J", "uid", "e", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "avatar", "f", "I", "getSeatNo", "()I", "seatNo", "<init>", "(JLjava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.now.od.ui.game.odgame.fragment.ODMatchResultDialog$ParcelableUser, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ParcelableUser implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long uid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String avatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int seatNo;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser;", "<init>", "()V", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.od.ui.game.odgame.fragment.ODMatchResultDialog$ParcelableUser$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion implements Parcelable.Creator<ParcelableUser> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableUser createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ParcelableUser(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableUser[] newArray(int size) {
            return new ParcelableUser[size];
        }

        Companion() {
        }
    }

    public ParcelableUser(long j3, @Nullable String str, int i3) {
        this.uid = j3;
        this.avatar = str;
        this.seatNo = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParcelableUser)) {
            return false;
        }
        ParcelableUser parcelableUser = (ParcelableUser) other;
        if (this.uid == parcelableUser.uid && Intrinsics.areEqual(this.avatar, parcelableUser.avatar) && this.seatNo == parcelableUser.seatNo) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int a16 = a.a(this.uid) * 31;
        String str = this.avatar;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((a16 + hashCode) * 31) + this.seatNo;
    }

    @NotNull
    public String toString() {
        return "ParcelableUser(uid=" + this.uid + ", avatar=" + this.avatar + ", seatNo=" + this.seatNo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.uid);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.seatNo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParcelableUser(@NotNull Parcel parcel) {
        this(parcel.readLong(), parcel.readString(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
