package ha3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Entity(tableName = "photo_face")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lha3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "id", "I", "()I", "faceCount", "<init>", "(JI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ha3.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PhotoFace {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @PrimaryKey
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int faceCount;

    public PhotoFace(long j3, int i3) {
        this.id = j3;
        this.faceCount = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getFaceCount() {
        return this.faceCount;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhotoFace)) {
            return false;
        }
        PhotoFace photoFace = (PhotoFace) other;
        if (this.id == photoFace.id && this.faceCount == photoFace.faceCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.id) * 31) + this.faceCount;
    }

    @NotNull
    public String toString() {
        return "PhotoFace(id=" + this.id + ", faceCount=" + this.faceCount + ")";
    }
}
