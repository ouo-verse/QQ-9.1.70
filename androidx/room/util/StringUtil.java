package androidx.room.util;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    StringUtil() {
    }

    public static void appendPlaceholders(StringBuilder sb5, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (i16 < i3 - 1) {
                sb5.append(",");
            }
        }
    }

    @Nullable
    public static String joinIntoString(@Nullable List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(Integer.toString(list.get(i3).intValue()));
            if (i3 < size - 1) {
                sb5.append(",");
            }
        }
        return sb5.toString();
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @Nullable
    public static List<Integer> splitToIntList(@Nullable String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
            } catch (NumberFormatException e16) {
                Log.e("ROOM", "Malformed integer list", e16);
            }
        }
        return arrayList;
    }
}
