package nz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends lz.d<f, e> {

    /* renamed from: i, reason: collision with root package name */
    private long f421605i;

    /* renamed from: m, reason: collision with root package name */
    private int f421606m;

    public d(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    public int w() {
        return this.f421606m;
    }

    public long x() {
        return this.f421605i;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(e eVar, int i3) {
        f fVar = (f) getDataList().get(i3);
        if (fVar.isChecked()) {
            this.f415798d = i3;
        }
        fVar.f(i3 + 1);
        eVar.bindData(fVar);
        if (i3 >= this.f421606m) {
            this.f421606m = i3;
            this.f421605i = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public e onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return new e(viewGroup, this);
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public boolean fillList(List<f> list) {
        this.f421605i = 0L;
        this.f421606m = 0;
        return super.fillList(list);
    }
}
