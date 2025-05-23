package com.tencent.biz.qqcircle.scrollers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a implements SimpleEventReceiver {
    private boolean C = false;
    private int D = -1;
    private int E = 1;
    private final Rect F = new Rect();

    /* renamed from: d, reason: collision with root package name */
    protected b f92279d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f92280e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f92281f;

    /* renamed from: h, reason: collision with root package name */
    protected QCircleExtraTypeInfo f92282h;

    /* renamed from: i, reason: collision with root package name */
    protected int f92283i;

    /* renamed from: m, reason: collision with root package name */
    protected BaseListViewAdapter f92284m;

    private boolean j(View view) {
        if (g(view) >= 0.5f && l()) {
            return true;
        }
        return false;
    }

    private boolean k(View view) {
        if (h(view) >= 0.5f && l()) {
            return true;
        }
        return false;
    }

    public void e(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter, b bVar) {
        this.f92281f = context;
        this.f92280e = recyclerView;
        this.f92284m = baseListViewAdapter;
        this.f92279d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] f() {
        int[] iArr = new int[4];
        b bVar = this.f92279d;
        if (bVar == null) {
            return iArr;
        }
        return bVar.e();
    }

    protected float g(View view) {
        int i3 = 0;
        this.F.set(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        view.getGlobalVisibleRect(this.F);
        int width = view.getWidth();
        int i16 = this.F.right;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenWidth()) {
                this.F.right = DisplayUtil.getScreenWidth();
            }
            Rect rect = this.F;
            i3 = rect.right - rect.left;
        }
        return i3 / width;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float h(View view) {
        int i3 = 0;
        this.F.set(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        view.getGlobalVisibleRect(this.F);
        int height = view.getHeight();
        int i16 = this.F.bottom;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenHeight()) {
                this.F.bottom = DisplayUtil.getScreenHeight();
            }
            Rect rect = this.F;
            i3 = rect.bottom - rect.top;
        }
        return i3 / height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(View view) {
        if (view == null) {
            return false;
        }
        if (m()) {
            return k(view);
        }
        return j(view);
    }

    public boolean l() {
        BaseListViewAdapter baseListViewAdapter = this.f92284m;
        boolean z16 = true;
        if (!(baseListViewAdapter instanceof com.tencent.biz.qqcircle.bizparts.a)) {
            return true;
        }
        if (!(((com.tencent.biz.qqcircle.bizparts.a) baseListViewAdapter).getInteractor() instanceof j20.a) || !((j20.a) ((com.tencent.biz.qqcircle.bizparts.a) this.f92284m).getInteractor()).isContainerOnScreen()) {
            z16 = false;
        }
        int hashCode = hashCode();
        if (z16 != this.C || hashCode != this.D) {
            QLog.d(b.E, 4, hashCode + ":isCurrentPage :" + z16);
            this.C = z16;
            this.D = hashCode;
        }
        return z16;
    }

    protected boolean m() {
        if (this.E == 1) {
            return true;
        }
        return false;
    }

    public void n(RecyclerView recyclerView) {
        if (recyclerView.getAdapter() instanceof BlockMerger) {
            for (MultiViewBlock multiViewBlock : ((BlockMerger) recyclerView.getAdapter()).getDataList()) {
                if (multiViewBlock instanceof com.tencent.biz.qqcircle.bizparts.a) {
                    this.f92284m = (com.tencent.biz.qqcircle.bizparts.a) multiViewBlock;
                    return;
                }
            }
        }
    }

    public void u(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.f92282h = qCircleExtraTypeInfo;
    }

    public void v(int i3) {
        this.E = i3;
    }

    public void w(int i3) {
        this.f92283i = i3;
    }

    public void o() {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onStop() {
    }

    public void p() {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    public void s(RecyclerView.ViewHolder viewHolder) {
    }

    public void t(RecyclerView.ViewHolder viewHolder) {
    }

    public void q(RecyclerView recyclerView, int i3, int i16, boolean z16) {
    }

    public void x(int i3, int i16, int i17, int i18, boolean z16) {
    }

    public void r(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
    }
}
