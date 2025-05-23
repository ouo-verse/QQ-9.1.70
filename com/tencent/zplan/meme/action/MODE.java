package com.tencent.zplan.meme.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.tavcut.core.render.exporter.MovieExporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010\u0006\u001a\u00020\u0005J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00d6\u0001j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/meme/action/MODE;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "toFrameCount", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "APNG", "GIF", "FRAME", "SHARPP", MovieExporter.FILE_TYPE, "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public enum MODE implements Parcelable {
    APNG,
    GIF,
    FRAME,
    SHARPP,
    MP4;

    public static final Parcelable.Creator<MODE> CREATOR = new Parcelable.Creator<MODE>() { // from class: com.tencent.zplan.meme.action.MODE.Creator
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MODE createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return (MODE) Enum.valueOf(MODE.class, in5.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MODE[] newArray(int i3) {
            return new MODE[i3];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int toFrameCount() {
        if (this == FRAME) {
            return 1;
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
