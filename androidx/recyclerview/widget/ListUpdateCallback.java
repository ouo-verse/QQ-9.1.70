package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i3, int i16, @Nullable Object obj);

    void onInserted(int i3, int i16);

    void onMoved(int i3, int i16);

    void onRemoved(int i3, int i16);
}
