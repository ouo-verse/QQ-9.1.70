package hh;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.j;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class b {

    /* renamed from: d, reason: collision with root package name */
    protected c f404910d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f404911e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f404912f;

    /* renamed from: h, reason: collision with root package name */
    protected BaseListViewAdapter f404913h;

    /* renamed from: i, reason: collision with root package name */
    private int f404914i = 1;

    private boolean e(View view, float f16) {
        int i3;
        Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        view.getGlobalVisibleRect(rect);
        int width = view.getWidth();
        int i16 = rect.right;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenWidth()) {
                rect.right = DisplayUtil.getScreenWidth();
            }
            i3 = rect.right - rect.left;
        } else {
            i3 = 0;
        }
        float f17 = i3 / width;
        QLog.d(getTAG(), 1, "inPlayAreaHorizontal  | rate = " + f17 + " | showRate = " + f16 + " | isCurrentPage = " + g());
        return f17 >= f16 && g();
    }

    private boolean f(View view, float f16) {
        int i3;
        Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        view.getGlobalVisibleRect(rect);
        int height = view.getHeight();
        int i16 = rect.bottom;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenHeight()) {
                rect.bottom = DisplayUtil.getScreenHeight();
            }
            i3 = rect.bottom - rect.top;
        } else {
            i3 = 0;
        }
        float f17 = i3 / height;
        QLog.d(getTAG(), 1, "inPlayAreaVertical  | rate = " + f17 + " | showRate = " + f16 + " | isCurrentPage = " + g());
        return f17 >= f16 && g();
    }

    public void a(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter, c cVar) {
        this.f404912f = context;
        this.f404911e = recyclerView;
        this.f404913h = baseListViewAdapter;
        this.f404910d = cVar;
    }

    /* renamed from: c */
    protected abstract String getTAG();

    public boolean g() {
        return true;
    }

    protected boolean h() {
        return this.f404914i == 1;
    }

    public void i(RecyclerView recyclerView) {
        if (recyclerView.getAdapter() instanceof BlockMerger) {
            for (MultiViewBlock multiViewBlock : ((BlockMerger) recyclerView.getAdapter()).getDataList()) {
                if (multiViewBlock instanceof j) {
                    this.f404913h = multiViewBlock;
                    return;
                }
            }
        }
    }

    public void p(int i3) {
        this.f404914i = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] b() {
        int[] iArr = new int[4];
        c cVar = this.f404910d;
        return cVar == null ? iArr : cVar.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(View view, float f16) {
        if (view == null) {
            return false;
        }
        if (h()) {
            return f(view, f16);
        }
        return e(view, f16);
    }

    public void j() {
    }

    public void k() {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onStop() {
    }

    public void n(RecyclerView.ViewHolder viewHolder) {
    }

    public void o(RecyclerView.ViewHolder viewHolder) {
    }

    public void l(RecyclerView recyclerView, int i3, int i16, boolean z16, int i17, int i18, int i19, int i26) {
    }

    public void m(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
    }

    public void q(int i3, int i16, int i17, int i18, boolean z16) {
    }
}
