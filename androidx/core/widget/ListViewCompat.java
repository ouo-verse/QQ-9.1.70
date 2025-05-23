package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ListViewCompat {
    ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView listView, int i3) {
        return listView.canScrollList(i3);
    }

    public static void scrollListBy(@NonNull ListView listView, int i3) {
        listView.scrollListBy(i3);
    }
}
