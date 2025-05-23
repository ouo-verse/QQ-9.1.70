package mn2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.t;
import com.tencent.mobileqq.search.model.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sn2.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a<M extends v, V extends d> extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    protected List<M> f417041d = new ArrayList();

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public M getItem(int i3) {
        if (i3 >= this.f417041d.size()) {
            return null;
        }
        return this.f417041d.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(int i3, t tVar) {
        if (tVar.k() != i3 && (tVar.k() != 4 || i3 != 113)) {
            return false;
        }
        return true;
    }

    protected abstract qn2.d<M, V> e(int i3);

    protected abstract d f(int i3, ViewGroup viewGroup);

    public void g(List<M> list) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList");
        }
        this.f417041d.clear();
        if (list != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList\uff0c size:" + list.size());
            }
            this.f417041d.addAll(list);
        } else if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList\uff0c null");
        }
        Iterator<M> it = this.f417041d.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f417041d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [qn2.d] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        ?? r46;
        View view2;
        View view3;
        M item = getItem(i3);
        if (item == null) {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + i3 + " list size = " + this.f417041d.size());
            view2 = null;
            view3 = view;
        } else {
            if (view == null) {
                d f16 = f(i3, viewGroup);
                View view4 = f16.getView();
                qn2.d<M, V> e16 = e(i3);
                view4.setTag(R.id.kxd, e16);
                view4.setTag(R.id.kxg, f16);
                dVar = f16;
                view = view4;
                r46 = e16;
            } else {
                dVar = (d) view.getTag(R.id.kxg);
                r46 = (qn2.d<M, V>) ((qn2.d) view.getTag(R.id.kxd));
            }
            view.setTag(R.id.kxb, item);
            if (dVar.getView() != null) {
                dVar.getView().setTag(R.id.kxc, Integer.valueOf(i3));
                dVar.getView().setTag(R.id.kxa, Integer.valueOf(getCount()));
            }
            int a16 = a(i3);
            item.i(a16);
            r46.a(item, dVar);
            if (r46 instanceof qn2.b) {
                ((qn2.b) r46).b(item, dVar.getView(), c(item, i3), a16);
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    protected int a(int i3) {
        return i3;
    }

    protected int c(v vVar, int i3) {
        return i3;
    }
}
