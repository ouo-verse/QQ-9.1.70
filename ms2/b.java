package ms2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.q;
import com.tencent.mobileqq.troop.file.data.j;
import com.tencent.mobileqq.troop.file.data.k;
import com.tencent.mobileqq.troop.file.data.l;
import com.tencent.mobileqq.troop.file.widget.TroopFileListView;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.widget.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends BaseAdapter implements q, m.a {
    public ms2.a C;
    public l D = new l();
    public Map<UUID, j> E = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public long f417493d;

    /* renamed from: e, reason: collision with root package name */
    public QQAppInterface f417494e;

    /* renamed from: f, reason: collision with root package name */
    public Context f417495f;

    /* renamed from: h, reason: collision with root package name */
    public LayoutInflater f417496h;

    /* renamed from: i, reason: collision with root package name */
    public TroopFileListView f417497i;

    /* renamed from: m, reason: collision with root package name */
    public TroopFileManager f417498m;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends j {
        public int K;

        public a(Activity activity, int i3, int i16) {
            super(new k(activity, i3, b.this.f417494e, b.this.f417493d, 0, 0L), null);
            this.K = i16;
        }

        @Override // com.tencent.mobileqq.troop.file.data.j
        protected String n() {
            return "";
        }
    }

    public b(long j3, QQAppInterface qQAppInterface, Activity activity, TroopFileListView troopFileListView, ms2.a aVar) {
        this.f417493d = j3;
        this.f417495f = activity;
        this.f417497i = troopFileListView;
        this.C = aVar;
        this.f417496h = LayoutInflater.from(activity);
        this.f417494e = qQAppInterface;
        TroopFileManager F = TroopFileManager.F(qQAppInterface, this.f417493d);
        this.f417498m = F;
        Iterator<n> it = F.G().iterator();
        while (it.hasNext()) {
            this.D.b(it.next(), this.f417498m);
        }
        this.D.f(new n.a());
        this.f417497i.setSlidingListener(this);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.D.e();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.D.c(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        n c16 = this.D.c(i3);
        if (c16 == null) {
            return null;
        }
        if (view == null) {
            a aVar2 = new a((Activity) this.f417495f, R.layout.a1p, i3);
            View view2 = aVar2.f295471k;
            if (view2 == null) {
                return null;
            }
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            Object tag = view.getTag();
            if (!(tag instanceof a)) {
                return null;
            }
            a aVar3 = (a) tag;
            aVar3.K = i3;
            aVar = aVar3;
        }
        this.E.put(c16.f294915a, aVar);
        aVar.f295472l = c16;
        aVar.N(this.f417493d, this.f417494e);
        aVar.O(this.f417493d, this.f417495f, this.f417494e, false);
        return view;
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void p1(n nVar) {
        if (this.D.d(nVar.f294915a) != null) {
            notifyDataSetChanged();
        }
        this.C.a();
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void I0(n nVar) {
        if (nVar == null || nVar.f294918d > TroopFileManager.f301886r.longValue()) {
            return;
        }
        if (nVar.A) {
            this.C.a();
        }
        int i3 = nVar.f294930p;
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
            if (this.D.b(nVar, this.f417498m)) {
                this.D.f(new n.a());
                notifyDataSetChanged();
                return;
            }
            j jVar = this.E.get(nVar.f294915a);
            if (jVar != null) {
                jVar.N(this.f417493d, this.f417494e);
                jVar.O(this.f417493d, this.f417495f, this.f417494e, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void D1(n nVar) {
        if (nVar == null || nVar.f294930p != 6 || this.D.d(nVar.f294915a) == null) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void B1(n nVar) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void X0(n nVar) {
    }

    @Override // com.tencent.mobileqq.troop.widget.m.a
    public void a(View view) {
    }

    @Override // com.tencent.mobileqq.troop.widget.m.a
    public void interceptTouchEvent(boolean z16) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void m0(int i3) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void x0(n nVar, String str) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void N0(List<n> list, boolean z16, String str, long j3, ArrayList<Long> arrayList) {
    }
}
