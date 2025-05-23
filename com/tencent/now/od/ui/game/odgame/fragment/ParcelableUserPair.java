package com.tencent.now.od.ui.game.odgame.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.api.MiniConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"com/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUserPair", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser;", "d", "Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser;", "getFirst", "()Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "e", "getSecond", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "<init>", "(Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser;Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUser;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.now.od.ui.game.odgame.fragment.ODMatchResultDialog$ParcelableUserPair, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ParcelableUserPair implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ParcelableUser first;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ParcelableUser second;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUserPair$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUserPair;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/now/od/ui/game/odgame/fragment/ODMatchResultDialog$ParcelableUserPair;", "<init>", "()V", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.od.ui.game.odgame.fragment.ODMatchResultDialog$ParcelableUserPair$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion implements Parcelable.Creator<ParcelableUserPair> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableUserPair createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ParcelableUserPair(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableUserPair[] newArray(int size) {
            return new ParcelableUserPair[size];
        }

        Companion() {
        }
    }

    public ParcelableUserPair(@Nullable ParcelableUser parcelableUser, @Nullable ParcelableUser parcelableUser2) {
        this.first = parcelableUser;
        this.second = parcelableUser2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParcelableUserPair)) {
            return false;
        }
        ParcelableUserPair parcelableUserPair = (ParcelableUserPair) other;
        if (Intrinsics.areEqual(this.first, parcelableUserPair.first) && Intrinsics.areEqual(this.second, parcelableUserPair.second)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        ParcelableUser parcelableUser = this.first;
        int i3 = 0;
        if (parcelableUser == null) {
            hashCode = 0;
        } else {
            hashCode = parcelableUser.hashCode();
        }
        int i16 = hashCode * 31;
        ParcelableUser parcelableUser2 = this.second;
        if (parcelableUser2 != null) {
            i3 = parcelableUser2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "ParcelableUserPair(first=" + this.first + ", second=" + this.second + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.first, flags);
        parcel.writeParcelable(this.second, flags);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParcelableUserPair(@NotNull Parcel parcel) {
        this((ParcelableUser) parcel.readParcelable(ParcelableUser.class.getClassLoader()), (ParcelableUser) parcel.readParcelable(ParcelableUser.class.getClassLoader()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
