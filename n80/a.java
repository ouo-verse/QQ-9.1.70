package n80;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import nb0.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends b {
    public a(int i3, @NonNull b.c cVar) {
        super(i3, cVar);
    }

    @Override // nb0.b
    @Nullable
    public View d(@NonNull RecyclerView.LayoutManager layoutManager, boolean z16) {
        View e16 = e(layoutManager, getHorizontalHelper(layoutManager), 17, z16);
        if (e16 != null) {
            this.f419595d = this.f419604m.getChildAdapterPosition(e16);
        } else {
            this.f419595d = -1;
        }
        return e16;
    }
}
