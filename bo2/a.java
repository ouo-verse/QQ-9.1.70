package bo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import sn2.b;
import sn2.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements b {

    /* renamed from: d, reason: collision with root package name */
    protected View f28723d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f28724e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f28725f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f28726h;

    /* renamed from: i, reason: collision with root package name */
    private List<c> f28727i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f28728m;

    public a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bxg, viewGroup, false);
        this.f28723d = inflate;
        this.f28725f = (TextView) inflate.findViewById(R.id.ezq);
        this.f28727i = new ArrayList();
        this.f28726h = (LinearLayout) this.f28723d.findViewById(R.id.ecl);
        this.f28728m = viewGroup;
    }

    public LinearLayout a() {
        return this.f28726h;
    }

    @Override // sn2.b
    public TextView b() {
        return this.f28724e;
    }

    @Override // sn2.b
    public List<c> e() {
        return this.f28727i;
    }

    @Override // sn2.b
    public TextView getMoreView() {
        return this.f28725f;
    }

    @Override // sn2.d
    public View getView() {
        return this.f28723d;
    }

    public ViewGroup j() {
        return this.f28728m;
    }
}
