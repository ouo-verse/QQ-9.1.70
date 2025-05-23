package kotlinx.parcelize;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u00a8\u0006\u0004"}, d2 = {"parcelableCreator", "Landroid/os/Parcelable$Creator;", "T", "Landroid/os/Parcelable;", "parcelize-runtime"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ParcelableCreatorKt {
    public static final /* synthetic */ <T extends Parcelable> Parcelable.Creator<T> parcelableCreator() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Parcelable.Creator<T> creator = null;
        Object obj = Parcelable.class.getDeclaredField("CREATOR").get(null);
        if (obj instanceof Parcelable.Creator) {
            creator = (Parcelable.Creator) obj;
        }
        if (creator != null) {
            return creator;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Could not access CREATOR field in class ");
        Intrinsics.reifiedOperationMarker(4, "T");
        sb5.append(Reflection.getOrCreateKotlinClass(Parcelable.class).getSimpleName());
        throw new IllegalArgumentException(sb5.toString());
    }
}
