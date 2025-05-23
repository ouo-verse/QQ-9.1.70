package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends com.tencent.mobileqq.teamworkforgroup.b {

    /* renamed from: e, reason: collision with root package name */
    protected int f292624e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        TextView f292625a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f292626b;

        b() {
        }
    }

    public k(AppInterface appInterface, Context context, BaseAdapter baseAdapter, int i3) {
        super(appInterface, context, baseAdapter, i3);
        this.f292624e = 0;
    }

    @Override // com.tencent.mobileqq.teamworkforgroup.b
    public View a(int i3, h hVar, View view, ViewGroup viewGroup, boolean z16, boolean z17, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, boolean z18, int i16) {
        b bVar;
        if (view == null) {
            View inflate = LayoutInflater.from(this.f292579b).inflate(R.layout.f168019p5, (ViewGroup) null);
            bVar = new b();
            bVar.f292625a = (TextView) inflate.findViewById(R.id.cyl);
            bVar.f292626b = (ImageView) inflate.findViewById(R.id.cym);
            inflate.setTag(bVar);
            view = inflate;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f292625a.setText(R.string.bo8);
        bVar.f292626b.setImageResource(R.drawable.coe);
        return view;
    }
}
