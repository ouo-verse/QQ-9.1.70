package ne;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jo.h;
import vg.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements c {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<a> f420057d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, View> f420058e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private int f420059f;

    private String d(a aVar, String str) {
        return aVar.getTAG() + "#" + str;
    }

    public void a(int i3, View view) {
        this.f420058e.put(Integer.valueOf(i3), view);
    }

    public void b(cf.b bVar) {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, "handleBroadcastMessage");
            next.r(bVar);
            i(next, "handleBroadcastMessage");
        }
    }

    @Override // vg.c
    public void c() {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, "onResumed");
            next.c();
            i(next, "onResumed");
        }
    }

    public int e() {
        return this.f420059f;
    }

    public ArrayList<a> f() {
        return this.f420057d;
    }

    public View g(int i3) {
        return this.f420058e.get(Integer.valueOf(i3));
    }

    public void h(View view, ViewGroup viewGroup) {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, "initView");
            next.D(viewGroup);
            next.s(view);
            i(next, "initView");
        }
    }

    public void k() {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, NodeProps.ON_ATTACHED_TO_WINDOW);
            next.w();
            i(next, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    public void l() {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, NodeProps.ON_DETACHED_FROM_WINDOW);
            next.y();
            i(next, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
    }

    public void n(CommonFeed commonFeed, int i3) {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, "onBindData");
            next.B(commonFeed, i3);
            i(next, "onBindData");
        }
    }

    public void o(int i3) {
        this.f420059f = i3;
    }

    @Override // vg.c
    public void onDestroy() {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            next.onDestroy();
            i(next, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // vg.c
    public void onPaused() {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, "onPaused");
            next.onPaused();
            i(next, "onPaused");
        }
    }

    @Override // vg.c
    public void onStop() {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, DKHippyEvent.EVENT_STOP);
            next.onStop();
            i(next, DKHippyEvent.EVENT_STOP);
        }
    }

    @Override // vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, "onViewHolderAttachedToWindow");
            next.onViewHolderAttachedToWindow(viewHolder);
            i(next, "onViewHolderAttachedToWindow");
        }
    }

    @Override // vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Iterator<a> it = this.f420057d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            j(next, "onViewHolderDetachedFromWindow");
            next.onViewHolderDetachedFromWindow(viewHolder);
            i(next, "onViewHolderDetachedFromWindow");
        }
    }

    public void m(List<Class<? extends a>> list) {
        if (list == null) {
            QLog.e("QZoneFeedPresenterManager", 1, "registerPresenters  presenterClasses == null");
            return;
        }
        Iterator<Class<? extends a>> it = list.iterator();
        while (it.hasNext()) {
            try {
                a newInstance = it.next().newInstance();
                if (newInstance.v()) {
                    this.f420057d.add(newInstance);
                    newInstance.C(this);
                }
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.e("QZoneFeedPresenterManager", 1, "registerPresenters  e = " + e16.getMessage());
            }
        }
    }

    private void i(a aVar, String str) {
        if (aVar != null) {
            h.f410717a.g("section_lifecycle").b(d(aVar, str));
        }
    }

    private void j(a aVar, String str) {
        if (aVar != null) {
            h.f410717a.g("section_lifecycle").h(d(aVar, str));
        }
    }
}
