package com.tencent.biz.map.poi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private d C;

    /* renamed from: d, reason: collision with root package name */
    private Context f78750d;

    /* renamed from: e, reason: collision with root package name */
    private List<LocationRoom.Venue> f78751e;

    /* renamed from: f, reason: collision with root package name */
    private int f78752f = -1;

    /* renamed from: h, reason: collision with root package name */
    private b f78753h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f78754i;

    /* renamed from: m, reason: collision with root package name */
    public String f78755m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public View f78756a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f78757b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f78758c;

        /* renamed from: d, reason: collision with root package name */
        public View f78759d;

        /* renamed from: e, reason: collision with root package name */
        public View f78760e;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        int b(LatLng latLng, int i3);

        void c(LatLng latLng, boolean z16);
    }

    public c(Context context, d dVar) {
        this.f78750d = context;
        this.C = dVar;
    }

    @SuppressLint({"ResourceAsColor"})
    private SpannableString h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        if (TextUtils.isEmpty(str2)) {
            return spannableString;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            for (int i16 = 0; i16 < str2.length(); i16++) {
                if (str.charAt(i3) == str2.charAt(i16) || Character.toUpperCase(str.charAt(i3)) == Character.toUpperCase(str2.charAt(i16))) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0099FF")), i3, i3 + 1, 18);
                }
            }
        }
        return spannableString;
    }

    public void a(int i3) {
        List<LocationRoom.Venue> list;
        if (i3 != this.f78752f && (list = this.f78751e) != null && i3 < list.size()) {
            this.f78752f = i3;
            d dVar = this.C;
            if (dVar != null) {
                dVar.M1(b());
            }
            notifyDataSetChanged();
            this.f78753h.c(this.f78751e.get(i3).f241273i, true);
        }
        if (i3 >= 0) {
            this.f78753h.a();
        }
    }

    public LocationRoom.Venue b() {
        List<LocationRoom.Venue> list;
        int i3 = this.f78752f;
        if (i3 > -1 && (list = this.f78751e) != null && i3 < list.size()) {
            return this.f78751e.get(this.f78752f);
        }
        return null;
    }

    public int c() {
        return this.f78752f;
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public LocationRoom.Venue getItem(int i3) {
        List<LocationRoom.Venue> list = this.f78751e;
        if (list != null && i3 < list.size()) {
            return this.f78751e.get(i3);
        }
        return null;
    }

    public void e(List<LocationRoom.Venue> list, boolean z16) {
        this.f78751e = list;
        this.f78754i = z16;
        notifyDataSetChanged();
        int i3 = this.f78752f;
        if (i3 >= 0) {
            f(i3);
            this.f78753h.a();
        }
    }

    public void f(int i3) {
        this.f78752f = i3;
        d dVar = this.C;
        if (dVar != null) {
            dVar.M1(b());
        }
        if (i3 >= 0) {
            this.f78753h.a();
        }
    }

    public void g(b bVar) {
        this.f78753h = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<LocationRoom.Venue> list = this.f78751e;
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
        a aVar;
        View view2;
        if (view == null) {
            aVar = new a();
            View inflate = LayoutInflater.from(this.f78750d).inflate(R.layout.f168923hc1, (ViewGroup) null);
            aVar.f78756a = inflate.findViewById(R.id.bhd);
            aVar.f78757b = (TextView) inflate.findViewById(R.id.f5p);
            aVar.f78758c = (TextView) inflate.findViewById(R.id.f164040i7);
            View findViewById = inflate.findViewById(R.id.f166843im3);
            aVar.f78759d = findViewById;
            findViewById.setVisibility(4);
            aVar.f78760e = inflate.findViewById(R.id.f0b);
            inflate.setTag(aVar);
            view2 = inflate;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        List<LocationRoom.Venue> list = this.f78751e;
        boolean z16 = false;
        if (list != null && i3 >= list.size() && i3 > 0 && this.f78754i) {
            aVar.f78760e.setVisibility(0);
            aVar.f78756a.setVisibility(8);
        } else {
            aVar.f78760e.setVisibility(8);
            aVar.f78756a.setVisibility(0);
        }
        LocationRoom.Venue item = getItem(i3);
        if (item != null) {
            try {
                aVar.f78760e.setVisibility(8);
                aVar.f78756a.setVisibility(0);
                int b16 = this.f78753h.b(item.f241273i, (int) item.f241274m);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
                if (b16 < 100) {
                    spannableStringBuilder.append((CharSequence) "100m\u5185\uff5c");
                } else if (b16 < 1000) {
                    spannableStringBuilder.append((CharSequence) (b16 + "m\uff5c"));
                } else {
                    spannableStringBuilder.append((CharSequence) (String.format("%.1f", Double.valueOf(b16 / 1000.0d)) + "km\uff5c"));
                }
                if ("".equals(this.f78755m)) {
                    spannableStringBuilder.append((CharSequence) item.f241272h);
                } else {
                    spannableStringBuilder.append((CharSequence) h(item.f241272h, this.f78755m));
                }
                aVar.f78758c.setText(spannableStringBuilder);
                String str = item.f241271f + ((Object) spannableStringBuilder);
                if ("".equals(this.f78755m)) {
                    aVar.f78757b.setText(String.format(item.f241271f, new Object[0]));
                } else {
                    aVar.f78757b.setText(h(item.f241271f, this.f78755m));
                }
                if (i3 == this.f78752f) {
                    aVar.f78759d.setVisibility(0);
                    str = aVar.f78757b.getText().toString() + ((Object) spannableStringBuilder);
                } else {
                    aVar.f78759d.setVisibility(4);
                }
                if (AppSetting.f99565y) {
                    if (i3 == this.f78752f) {
                        z16 = true;
                    }
                    AccessibilityUtil.y(view2, str, z16);
                }
            } catch (Exception e16) {
                QLog.i("PoiListAdapter", 2, "getView Exception = ", e16);
            }
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }
}
