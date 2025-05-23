package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PathUtils {
    PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f16) {
        float[] approximate;
        approximate = path.approximate(f16);
        int length = approximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 1; i3 < length; i3++) {
            int i16 = i3 * 3;
            int i17 = (i3 - 1) * 3;
            float f17 = approximate[i16];
            float f18 = approximate[i16 + 1];
            float f19 = approximate[i16 + 2];
            float f26 = approximate[i17];
            float f27 = approximate[i17 + 1];
            float f28 = approximate[i17 + 2];
            if (f17 != f26 && (f18 != f27 || f19 != f28)) {
                arrayList.add(new PathSegment(new PointF(f27, f28), f26, new PointF(f18, f19), f17));
            }
        }
        return arrayList;
    }
}
