package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    private static class Api29Impl {
        Api29Impl() {
        }

        @NonNull
        static LocusId create(@NonNull String str) {
            return new LocusId(str);
        }

        @NonNull
        static String getId(@NonNull LocusId locusId) {
            String id5;
            id5 = locusId.getId();
            return id5;
        }
    }

    public LocusIdCompat(@NonNull String str) {
        this.mId = (String) Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped = Api29Impl.create(str);
        } else {
            this.mWrapped = null;
        }
    }

    @NonNull
    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    @NonNull
    @RequiresApi(29)
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(locusId), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.mId;
        if (str == null) {
            if (locusIdCompat.mId == null) {
                return true;
            }
            return false;
        }
        return str.equals(locusIdCompat.mId);
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        int hashCode;
        String str = this.mId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    @NonNull
    @RequiresApi(29)
    public LocusId toLocusId() {
        return this.mWrapped;
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }
}
