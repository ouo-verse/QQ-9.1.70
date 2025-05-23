package com.tencent.zplan.meme;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/meme/EngineType;", "Landroid/os/Parcelable;", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "d", "Ljava/lang/Class;", "a", "()Ljava/lang/Class;", "recorder", "<init>", "(Ljava/lang/Class;)V", "Filament", "Unreal", "Lcom/tencent/zplan/meme/EngineType$Unreal;", "Lcom/tencent/zplan/meme/EngineType$Filament;", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class EngineType implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Class<com.tencent.zplan.meme.recorder.a> recorder;

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/meme/EngineType$Filament;", "Lcom/tencent/zplan/meme/EngineType;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "e", "Ljava/lang/Class;", "a", "()Ljava/lang/Class;", "recorder", "<init>", "(Ljava/lang/Class;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class Filament extends EngineType {
        public static final Parcelable.Creator<Filament> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Class<com.tencent.zplan.meme.recorder.a> recorder;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<Filament> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Filament createFromParcel(@NotNull Parcel in5) {
                Intrinsics.checkNotNullParameter(in5, "in");
                return new Filament((Class) in5.readSerializable());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Filament[] newArray(int i3) {
                return new Filament[i3];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Filament(@NotNull Class<com.tencent.zplan.meme.recorder.a> recorder) {
            super(recorder, null);
            Intrinsics.checkNotNullParameter(recorder, "recorder");
            this.recorder = recorder;
        }

        @Override // com.tencent.zplan.meme.EngineType
        @NotNull
        public Class<com.tencent.zplan.meme.recorder.a> a() {
            return this.recorder;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeSerializable(this.recorder);
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/meme/EngineType$Unreal;", "Lcom/tencent/zplan/meme/EngineType;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "e", "Ljava/lang/Class;", "a", "()Ljava/lang/Class;", "recorder", "<init>", "(Ljava/lang/Class;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class Unreal extends EngineType {
        public static final Parcelable.Creator<Unreal> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Class<com.tencent.zplan.meme.recorder.a> recorder;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<Unreal> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Unreal createFromParcel(@NotNull Parcel in5) {
                Intrinsics.checkNotNullParameter(in5, "in");
                return new Unreal((Class) in5.readSerializable());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Unreal[] newArray(int i3) {
                return new Unreal[i3];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unreal(@NotNull Class<com.tencent.zplan.meme.recorder.a> recorder) {
            super(recorder, null);
            Intrinsics.checkNotNullParameter(recorder, "recorder");
            this.recorder = recorder;
        }

        @Override // com.tencent.zplan.meme.EngineType
        @NotNull
        public Class<com.tencent.zplan.meme.recorder.a> a() {
            return this.recorder;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeSerializable(this.recorder);
        }
    }

    EngineType(Class<com.tencent.zplan.meme.recorder.a> cls) {
        this.recorder = cls;
    }

    @Nullable
    public Class<com.tencent.zplan.meme.recorder.a> a() {
        return this.recorder;
    }

    public /* synthetic */ EngineType(Class cls, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls);
    }
}
