package h80;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import nb0.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends RecyclerView.OnScrollListener implements b.c {

    /* renamed from: d, reason: collision with root package name */
    private String f404561d;

    /* renamed from: e, reason: collision with root package name */
    private final b.c f404562e;

    /* renamed from: f, reason: collision with root package name */
    private int f404563f = -1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f404564h;

    /* renamed from: i, reason: collision with root package name */
    private int f404565i;

    public a(b.c cVar) {
        this.f404562e = cVar;
    }

    private boolean d(int i3, int i16) {
        if (i16 == 0 || Math.abs(i3 - this.f404565i) / i16 < 0.1f) {
            return false;
        }
        return true;
    }

    @Nullable
    private View e(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        if (this.f404563f < 0 || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        return layoutManager.findViewByPosition(this.f404563f);
    }

    private void f(RecyclerView recyclerView) {
        int i3;
        View e16 = e(recyclerView);
        if (e16 == null) {
            return;
        }
        int left = e16.getLeft();
        int width = e16.getWidth();
        if (!d(left, width)) {
            return;
        }
        if (i(width, left)) {
            i3 = -1;
        } else if (h(width, left)) {
            i3 = 1;
        } else {
            i3 = -100;
        }
        QFSSearchPrerenderManager.E(recyclerView.getContext()).M(this.f404561d, i3);
    }

    private boolean h(int i3, int i16) {
        if (i16 < this.f404565i && this.f404564h) {
            return true;
        }
        return false;
    }

    private boolean i(int i3, int i16) {
        if (i16 >= this.f404565i && !this.f404564h) {
            return true;
        }
        return false;
    }

    @Override // nb0.b.c
    public void b(int i3) {
        b.c cVar = this.f404562e;
        if (cVar != null) {
            cVar.b(i3);
        }
        this.f404563f = i3;
    }

    public void g(String str) {
        this.f404561d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f404564h = z16;
        if (this.f404565i == 0) {
            this.f404565i = Math.max(recyclerView.getPaddingLeft(), recyclerView.getPaddingRight());
        }
        f(recyclerView);
    }
}
