package com.tencent.mobileqq.wink.publish.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.utils.i;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    private Context f325646e;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f325645d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private int f325647f = -1;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public LbsDataV2.PoiInfo f325648a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f325649b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f325650c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f325651d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.publish.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C9081b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f325652a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f325653b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f325654c = false;

        C9081b() {
        }
    }

    public b(Context context) {
        this.f325646e = context;
    }

    private void a() {
        a aVar = new a();
        aVar.f325651d = true;
        aVar.f325650c = false;
        this.f325645d.add(0, aVar);
    }

    private View b(View view) {
        C9081b c9081b = new C9081b();
        View view2 = new View(this.f325646e);
        view2.setLayoutParams(new FrameLayout.LayoutParams(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(12.0f)));
        view2.setPadding(0, ViewUtils.dip2px(12.0f), 0, 0);
        view2.setTag(c9081b);
        return view2;
    }

    private View c(a aVar, View view) {
        View view2;
        C9081b c9081b;
        if (view != null && !((C9081b) view.getTag()).f325654c) {
            view = null;
        }
        if (view == null) {
            c9081b = new C9081b();
            TextView textView = new TextView(this.f325646e);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setGravity(16);
            textView.setPadding(0, 0, ViewUtils.dip2px(16.0f), 0);
            textView.setTextSize(1, 12.0f);
            textView.setTextColor(this.f325646e.getResources().getColor(R.color.qvideo_skin_color_text_secondary));
            Drawable drawable = this.f325646e.getResources().getDrawable(R.drawable.nd_);
            drawable.setBounds(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setCompoundDrawablePadding(ViewUtils.dip2px(3.0f));
            c9081b.f325652a = textView;
            c9081b.f325653b = false;
            c9081b.f325654c = true;
            textView.setTag(c9081b);
            view2 = textView;
        } else {
            view2 = view;
            c9081b = (C9081b) view.getTag();
        }
        c9081b.f325652a.setTextSize(0, i.a(this.f325646e, 12.0f));
        c9081b.f325652a.requestLayout();
        c9081b.f325652a.setText(R.string.f183683ju);
        view2.setPadding(0, ViewUtils.dip2px(12.0f), ViewUtils.dip2px(16.0f), 0);
        return view2;
    }

    private View d(a aVar, View view, int i3) {
        C9081b c9081b = new C9081b();
        TextView textView = new TextView(this.f325646e);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setGravity(16);
        textView.setPadding(0, ViewUtils.dip2px(12.0f), ViewUtils.dip2px(16.0f), 0);
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(this.f325646e.getResources().getColor(R.color.qvideo_skin_color_text_secondary));
        c9081b.f325652a = textView;
        c9081b.f325653b = false;
        textView.setTag(c9081b);
        c9081b.f325652a.setTextSize(0, i.a(this.f325646e, 12.0f));
        c9081b.f325652a.requestLayout();
        c9081b.f325652a.setText(aVar.f325648a.poiName);
        return textView;
    }

    public void e() {
        List<a> list = this.f325645d;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a getItem(int i3) {
        if (i3 >= this.f325645d.size()) {
            return null;
        }
        return this.f325645d.get(i3);
    }

    public void g(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo != null && !"invalide_poi_id".equals(poiInfo.poiId)) {
            for (int i3 = 1; i3 < this.f325645d.size(); i3++) {
                if (poiInfo.poiName.equals(this.f325645d.get(i3).f325648a.poiName)) {
                    this.f325647f = i3;
                }
            }
            notifyDataSetChanged();
            return;
        }
        this.f325647f = -1;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a> list = this.f325645d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View d16;
        a item = getItem(i3);
        if (item.f325650c) {
            d16 = c(item, view);
        } else if (item.f325651d) {
            d16 = b(view);
        } else {
            d16 = d(item, view, i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return d16;
    }

    public void setData(List<LbsDataV2.PoiInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.f325645d.clear();
            a();
            for (LbsDataV2.PoiInfo poiInfo : list) {
                a aVar = new a();
                aVar.f325648a = poiInfo;
                this.f325645d.add(aVar);
            }
            a aVar2 = new a();
            LbsDataV2.PoiInfo poiInfo2 = new LbsDataV2.PoiInfo();
            poiInfo2.poiId = "";
            poiInfo2.poiName = "";
            aVar2.f325648a = poiInfo2;
            aVar2.f325649b = false;
            aVar2.f325650c = true;
            this.f325645d.add(aVar2);
            notifyDataSetChanged();
        }
    }
}
