package on2;

import com.tencent.mobileqq.search.model.v;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface d<M extends v> {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a<M extends v> implements d<M> {
        @Override // on2.d
        public /* synthetic */ void onCancelSearch() {
            c.a(this);
        }

        @Override // on2.d
        public /* synthetic */ void onFinish(List list, int i3) {
            c.b(this, list, i3);
        }

        @Override // on2.d
        public /* synthetic */ void onUpdate(List list) {
            c.d(this, list);
        }

        @Override // on2.d
        public /* synthetic */ void onFinish(List list, pn2.b bVar) {
            c.c(this, list, bVar);
        }

        @Override // on2.d
        public /* synthetic */ void onUpdate(List list, boolean z16) {
            c.e(this, list, z16);
        }
    }

    void onCancelSearch();

    void onFinish(List<M> list, int i3);

    void onFinish(List<M> list, pn2.b bVar);

    void onUpdate(List<M> list);

    void onUpdate(List<M> list, boolean z16);
}
