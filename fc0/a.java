package fc0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final List<QFSEdgeItem> f398260a = Collections.synchronizedList(new ArrayList());

    public void b(List<QFSEdgeItem> list) {
        if (list != null && list.size() > 0) {
            d().addAll(list);
        }
    }

    public void c(List<QFSEdgeItem> list, int i3) {
        if (list == null) {
            return;
        }
        if (i3 > d().size()) {
            i3 = d().size();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            d().add(i3, list.get(size));
        }
    }

    @NonNull
    public List<QFSEdgeItem> d() {
        return this.f398260a;
    }

    public List<QFSEdgeItem> e(int i3) {
        if (d().size() < i3) {
            return new ArrayList(d());
        }
        return new ArrayList(d().subList(0, i3));
    }

    public void f() {
        RFWLog.d("BaseDataList", RFWLog.USR, "removeAllData");
        this.f398260a.clear();
    }

    public void g(int i3) {
        if (d().size() <= i3) {
            f();
            return;
        }
        List<QFSEdgeItem> d16 = d();
        synchronized (d16) {
            Iterator<QFSEdgeItem> it = d16.iterator();
            while (it.hasNext() && i3 > 0) {
                it.remove();
                i3--;
            }
        }
    }

    public void h(List<QFSEdgeItem> list) {
        if (list == null) {
            return;
        }
        List<QFSEdgeItem> d16 = d();
        synchronized (d16) {
            for (QFSEdgeItem qFSEdgeItem : list) {
                Iterator<QFSEdgeItem> it = d16.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(a(qFSEdgeItem), a(it.next()))) {
                        it.remove();
                    }
                }
            }
        }
    }
}
