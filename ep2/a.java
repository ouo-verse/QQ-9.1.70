package ep2;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.model.t;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import sn2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a<M extends t, V extends sn2.a> extends mn2.b<M, V> {
    private int C;
    private List<c> D;
    private List<FTSEntity> E;
    private String F;
    FTSEntitySearchDetailActivity G;

    /* renamed from: i, reason: collision with root package name */
    private int f396931i;

    /* renamed from: m, reason: collision with root package name */
    private int f396932m;

    public a(ListView listView, IFaceDecoder iFaceDecoder, List<FTSEntity> list, String str, FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity) {
        super(listView, iFaceDecoder);
        this.C = 0;
        this.E = list;
        this.F = str;
        this.G = fTSEntitySearchDetailActivity;
        this.D = new ArrayList();
    }

    private void i() {
        if (this.C - this.f396932m == this.f396931i && this.f417043f == 0) {
            h();
        }
    }

    public void h() {
        ArrayList<String> l3 = vy2.b.l(this.F);
        int size = this.D.size();
        int i3 = size + 50;
        if (i3 >= this.E.size()) {
            i3 = this.E.size();
        }
        while (size < i3) {
            FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity = this.G;
            c b16 = e.b(fTSEntitySearchDetailActivity.app, fTSEntitySearchDetailActivity.f283230b0, this.F, l3, this.E.get(size));
            if (b16 != null) {
                this.D.add(b16);
            }
            size++;
        }
        g(this.D);
    }

    @Override // mn2.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        this.f396932m = i3;
        this.f396931i = i16;
        this.C = i17;
    }

    @Override // mn2.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        super.onScrollStateChanged(absListView, i3);
        i();
    }
}
