package com.tencent.biz.qqcircle.scrollers;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import u30.d;

/* loaded from: classes5.dex */
public class QCircleFeedPicPreloadScroller extends a {
    private static String H = "QCircleFeedPicPreloadScroller";
    private ConcurrentHashMap<String, Boolean> G = new ConcurrentHashMap<>();

    private void A(boolean z16, int i3, int i16) {
        List<e30.b> dataList;
        if (l() && i3 >= 0 && i16 >= i3 && (dataList = this.f92284m.getDataList()) != null && dataList.size() > i16) {
            QLog.d(H, 4, "feeds size" + dataList.size());
            B(i3, dataList);
        }
    }

    private void B(int i3, List<e30.b> list) {
        try {
            Iterator<e30.b> it = list.subList(i3, list.size()).iterator();
            while (it.hasNext()) {
                d.d().p(it.next().g());
            }
        } catch (Exception unused) {
            QLog.e(H, 4, "feeds size" + list.size());
        }
    }

    private void z() {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = QCircleFeedPicPreloadScroller.this.G.keySet().iterator();
                while (it.hasNext()) {
                    Boolean bool = (Boolean) QCircleFeedPicPreloadScroller.this.G.get((String) it.next());
                    if (bool != null && !bool.booleanValue()) {
                        it.remove();
                    }
                }
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void n(RecyclerView recyclerView) {
        super.n(recyclerView);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void o() {
        z();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onDestroy() {
        QLog.d(H, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        z();
        this.G.clear();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void q(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        super.q(recyclerView, i3, i16, z16);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void r(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (i3 == 0 && z16) {
            A(z16, i16, i17);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void x(int i3, int i16, int i17, int i18, boolean z16) {
        if (z16) {
            A(z16, i3, i16);
        }
    }
}
