package ls2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.s;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends BaseAdapter implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f415497d = TroopUtils.f();

    /* renamed from: e, reason: collision with root package name */
    private final List<s> f415498e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final int f415499f;

    /* renamed from: h, reason: collision with root package name */
    private final long f415500h;

    /* renamed from: i, reason: collision with root package name */
    private final a f415501i;

    public b(int i3, long j3, a aVar) {
        this.f415499f = i3;
        this.f415500h = j3;
        this.f415501i = aVar;
    }

    public void a(List<s> list) {
        this.f415498e.clear();
        this.f415498e.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f415498e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f415498e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TroopInfo troopInfoFromCache;
        if (view.getId() == R.id.f167025k20 && (troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(this.f415500h))) != null && troopInfoFromCache.hadJoinTroop()) {
            Object tag = view.getTag(R.id.giu);
            if (tag instanceof s) {
                s sVar = (s) tag;
                n nVar = sVar.f294966i;
                QFileUtils.s(this.f415497d, view.getContext(), null, null, sVar.f294958a, TroopFileUtils.k(this.f415497d, this.f415500h, nVar.f294915a.toString(), nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e), String.valueOf(sVar.f294960c), nVar.f294923i, 2, 4, QFileUtils.b0(view.findViewById(R.id.f167030k25), nVar.f294917c), false, false, false, true, this.f415499f);
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ai6, viewGroup, false);
            cVar = new c(view, this);
            view.setTag(cVar);
        } else {
            Object tag = view.getTag();
            if (tag instanceof c) {
                cVar = (c) tag;
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ai6, viewGroup, false);
                cVar = new c(view, this);
                view.setTag(cVar);
            }
        }
        cVar.c(viewGroup.getContext(), this.f415498e.get(i3), this.f415501i);
        return view;
    }
}
