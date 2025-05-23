package com.tencent.zplan.world.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/zplan/world/model/FirstFrameResult;", "Landroid/os/Parcelable;", "curType", "", "params", "", "(ILjava/lang/String;)V", "getCurType", "()I", "getParams", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class FirstFrameResult implements Parcelable {
    public static final Parcelable.Creator<FirstFrameResult> CREATOR = new a();
    private final int curType;

    @Nullable
    private final String params;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class a implements Parcelable.Creator<FirstFrameResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FirstFrameResult createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new FirstFrameResult(in5.readInt(), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FirstFrameResult[] newArray(int i3) {
            return new FirstFrameResult[i3];
        }
    }

    public FirstFrameResult(int i3, @Nullable String str) {
        this.curType = i3;
        this.params = str;
    }

    public static /* synthetic */ FirstFrameResult copy$default(FirstFrameResult firstFrameResult, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = firstFrameResult.curType;
        }
        if ((i16 & 2) != 0) {
            str = firstFrameResult.params;
        }
        return firstFrameResult.copy(i3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCurType() {
        return this.curType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    @NotNull
    public final FirstFrameResult copy(int curType, @Nullable String params) {
        return new FirstFrameResult(curType, params);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FirstFrameResult) {
                FirstFrameResult firstFrameResult = (FirstFrameResult) other;
                if (this.curType != firstFrameResult.curType || !Intrinsics.areEqual(this.params, firstFrameResult.params)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getCurType() {
        return this.curType;
    }

    @Nullable
    public final String getParams() {
        return this.params;
    }

    public int hashCode() {
        int i3;
        int i16 = this.curType * 31;
        String str = this.params;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "FirstFrameResult(curType=" + this.curType + ", params=" + this.params + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.curType);
        parcel.writeString(this.params);
    }

    public /* synthetic */ FirstFrameResult(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : str);
    }
}
