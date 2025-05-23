package com.tencent.mobileqq.wink.editor.clipping.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\f\u00a2\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\tH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010 \u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/model/WinkClippingTemplateMusicInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "a", "b", "", "c", "e", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "getPath", "path", "f", "J", "getStartTime", "()J", "startTime", h.F, "getDuration", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkClippingTemplateMusicInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final long duration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/model/WinkClippingTemplateMusicInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/editor/clipping/model/WinkClippingTemplateMusicInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/editor/clipping/model/WinkClippingTemplateMusicInfo;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.clipping.model.WinkClippingTemplateMusicInfo$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkClippingTemplateMusicInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkClippingTemplateMusicInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkClippingTemplateMusicInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkClippingTemplateMusicInfo[] newArray(int size) {
            return new WinkClippingTemplateMusicInfo[size];
        }

        Companion() {
        }
    }

    public WinkClippingTemplateMusicInfo(@NotNull String name, @NotNull String path, long j3, long j16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        this.name = name;
        this.path = path;
        this.startTime = j3;
        this.duration = j16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: c, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkClippingTemplateMusicInfo)) {
            return false;
        }
        WinkClippingTemplateMusicInfo winkClippingTemplateMusicInfo = (WinkClippingTemplateMusicInfo) other;
        if (Intrinsics.areEqual(this.name, winkClippingTemplateMusicInfo.name) && Intrinsics.areEqual(this.path, winkClippingTemplateMusicInfo.path) && this.startTime == winkClippingTemplateMusicInfo.startTime && this.duration == winkClippingTemplateMusicInfo.duration) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + a.a(this.startTime)) * 31) + a.a(this.duration);
    }

    @NotNull
    public String toString() {
        return "WinkClippingTemplateMusicInfo(name=" + this.name + ", path=" + this.path + ", startTime=" + this.startTime + ", duration=" + this.duration + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.path);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.duration);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkClippingTemplateMusicInfo(@NotNull Parcel parcel) {
        this(r3, r0 == null ? "" : r0, parcel.readLong(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
    }
}
