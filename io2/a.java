package io2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import sn2.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements sn2.b {

    /* renamed from: d, reason: collision with root package name */
    protected View f408097d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f408098e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f408099f;

    /* renamed from: h, reason: collision with root package name */
    private List<c> f408100h;

    public a(ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        this.f408097d = inflate;
        this.f408098e = (TextView) inflate.findViewById(R.id.ezq);
        this.f408100h = new ArrayList();
        this.f408099f = (LinearLayout) this.f408097d.findViewById(R.id.ecl);
    }

    public LinearLayout a() {
        return this.f408099f;
    }

    @Override // sn2.b
    public TextView b() {
        return b();
    }

    @Override // sn2.b
    public List<c> e() {
        return this.f408100h;
    }

    @Override // sn2.b
    public TextView getMoreView() {
        return this.f408098e;
    }

    @Override // sn2.d
    public View getView() {
        return this.f408097d;
    }
}
