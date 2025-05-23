package d24;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Ld24/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "d", "(Landroid/graphics/Bitmap;)V", "avatar", "b", "e", "cover", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "extraInfo", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieAvatarResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Bitmap avatar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Bitmap cover;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String extraInfo;

    public AdelieAvatarResult() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bitmap getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Bitmap getCover() {
        return this.cover;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final void d(@Nullable Bitmap bitmap) {
        this.avatar = bitmap;
    }

    public final void e(@Nullable Bitmap bitmap) {
        this.cover = bitmap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieAvatarResult)) {
            return false;
        }
        AdelieAvatarResult adelieAvatarResult = (AdelieAvatarResult) other;
        if (Intrinsics.areEqual(this.avatar, adelieAvatarResult.avatar) && Intrinsics.areEqual(this.cover, adelieAvatarResult.cover) && Intrinsics.areEqual(this.extraInfo, adelieAvatarResult.extraInfo)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable String str) {
        this.extraInfo = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Bitmap bitmap = this.avatar;
        int i3 = 0;
        if (bitmap == null) {
            hashCode = 0;
        } else {
            hashCode = bitmap.hashCode();
        }
        int i16 = hashCode * 31;
        Bitmap bitmap2 = this.cover;
        if (bitmap2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bitmap2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str = this.extraInfo;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "AdelieAvatarResult(avatar=" + this.avatar + ", cover=" + this.cover + ", extraInfo=" + this.extraInfo + ")";
    }

    public AdelieAvatarResult(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2, @Nullable String str) {
        this.avatar = bitmap;
        this.cover = bitmap2;
        this.extraInfo = str;
    }

    public /* synthetic */ AdelieAvatarResult(Bitmap bitmap, Bitmap bitmap2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bitmap, (i3 & 2) != 0 ? null : bitmap2, (i3 & 4) != 0 ? null : str);
    }
}
