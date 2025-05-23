package m60;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.IRefreshViewProvider;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name */
    private int f416291d = 0;

    public abstract void d(@NonNull RecyclerView recyclerView, int i3, int i16, int i17);

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
        super.onScrolled(recyclerView, i3, i16);
        this.f416291d += i16;
        View childAt = recyclerView.getChildAt(0);
        if ((childAt instanceof IRefreshViewProvider) && !cx.i(childAt, false, true)) {
            this.f416291d = 0;
        }
        d(recyclerView, i3, i16, this.f416291d);
    }
}
