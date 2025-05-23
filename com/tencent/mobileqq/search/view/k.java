package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import lo2.w;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends com.tencent.mobileqq.search.business.net.view.c {
    public LinearLayout M;
    public URLImageView N;
    public TextView P;
    public TextView Q;
    public TextView R;
    public URLImageView S;
    public View T;
    public LinearLayout U;
    public ArrayList<a> V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public View f285133a;

        /* renamed from: b, reason: collision with root package name */
        public URLImageView f285134b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f285135c;

        public a(Context context) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.f168538a05, (ViewGroup) k.this.U, false);
            this.f285133a = inflate;
            this.f285134b = (URLImageView) inflate.findViewById(R.id.image);
            this.f285135c = (TextView) this.f285133a.findViewById(R.id.bg6);
        }
    }

    public k(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
        this.V = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        View j3 = j(this.E);
        this.M = (LinearLayout) j3.findViewById(R.id.bxy);
        this.N = (URLImageView) j3.findViewById(R.id.image);
        this.P = (TextView) j3.findViewById(R.id.title);
        this.Q = (TextView) j3.findViewById(R.id.f166931j64);
        this.R = (TextView) j3.findViewById(R.id.bgt);
        this.S = (URLImageView) j3.findViewById(R.id.f166793ia2);
        this.T = j3.findViewById(R.id.f165819dm3);
        this.U = (LinearLayout) j3.findViewById(R.id.f166929j61);
    }

    public void p(w wVar) {
        this.V.clear();
        this.U.removeAllViews();
        List<lo2.i> list = wVar.f415300g0;
        if (list != null && list.size() != 0) {
            this.T.setVisibility(0);
            this.U.setVisibility(0);
            Context context = this.U.getContext();
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            for (int i3 = 0; i3 < wVar.f415300g0.size(); i3++) {
                lo2.i iVar = wVar.f415300g0.get(i3);
                a aVar = new a(context);
                if (!TextUtils.isEmpty(iVar.f415214a)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mFailedDrawable = colorDrawable;
                    obtain.mLoadingDrawable = colorDrawable;
                    obtain.mRequestWidth = x.c(context, 18.0f);
                    obtain.mRequestHeight = x.c(context, 18.0f);
                    obtain.mMemoryCacheKeySuffix = "leftIcon";
                    URLDrawable drawable = URLDrawable.getDrawable(iVar.f415214a, obtain);
                    drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                    aVar.f285134b.setImageDrawable(drawable);
                    if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                        drawable.restartDownload();
                    }
                    aVar.f285134b.setVisibility(0);
                } else {
                    aVar.f285134b.setVisibility(8);
                }
                if (!TextUtils.isEmpty(iVar.f415215b)) {
                    aVar.f285135c.setText(iVar.f415215b);
                    aVar.f285135c.setVisibility(0);
                } else {
                    aVar.f285135c.setVisibility(8);
                }
                if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                    aVar.f285135c.setTextColor(Color.parseColor("#737373"));
                    this.T.setBackgroundColor(Color.parseColor("#112037"));
                } else {
                    aVar.f285135c.setTextColor(Color.parseColor("#262626"));
                    this.T.setBackgroundColor(Color.parseColor("#E6E6E6"));
                }
                this.U.addView(aVar.f285133a);
                this.V.add(aVar);
            }
            return;
        }
        this.T.setVisibility(8);
        this.U.setVisibility(8);
    }
}
