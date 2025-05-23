package mn2;

import android.graphics.Bitmap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.model.t;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import qn2.c;
import sn2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b<M extends t, V extends sn2.a> extends a<M, V> implements DecodeTaskCompletionListener, AbsListView.OnScrollListener {

    /* renamed from: e, reason: collision with root package name */
    protected IFaceDecoder f417042e;

    /* renamed from: f, reason: collision with root package name */
    protected int f417043f = 0;

    /* renamed from: h, reason: collision with root package name */
    private ListView f417044h;

    public b(ListView listView, IFaceDecoder iFaceDecoder) {
        this.f417044h = listView;
        this.f417042e = iFaceDecoder;
        iFaceDecoder.setDecodeTaskCompletionListener(this);
        listView.setOnScrollListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        if (!this.f417042e.isPausing()) {
            int i17 = this.f417043f;
            if (i17 == 0 || i17 == 1) {
                int childCount = this.f417044h.getChildCount();
                for (int i18 = 0; i18 < childCount; i18++) {
                    t tVar = (t) this.f417044h.getChildAt(i18).getTag(R.id.kxb);
                    if (tVar != null && d(i16, tVar) && str.equals(tVar.l())) {
                        c cVar = (c) this.f417044h.getChildAt(i18).getTag(R.id.kxd);
                        sn2.a aVar = (sn2.a) this.f417044h.getChildAt(i18).getTag(R.id.kxg);
                        if (cVar != 0 && aVar != null) {
                            cVar.f(tVar, aVar, bitmap);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (this.f417044h == null) {
            return;
        }
        this.f417043f = i3;
        if (i3 != 0 && i3 != 1) {
            this.f417042e.cancelPendingRequests();
            this.f417042e.pause();
            return;
        }
        if (this.f417042e.isPausing()) {
            this.f417042e.resume();
        }
        int childCount = this.f417044h.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            t tVar = (t) this.f417044h.getChildAt(i16).getTag(R.id.kxb);
            c cVar = (c) this.f417044h.getChildAt(i16).getTag(R.id.kxd);
            sn2.a aVar = (sn2.a) this.f417044h.getChildAt(i16).getTag(R.id.kxg);
            if (cVar != 0 && tVar != null && absListView != null) {
                cVar.c(tVar, aVar);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
    }
}
