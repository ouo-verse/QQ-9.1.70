package com.tencent.mobileqq.nearbypro.map.poi;

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
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import cooperation.qzone.LbsDataV2;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends BaseAdapter {
    private d C;

    /* renamed from: d, reason: collision with root package name */
    private Context f253568d;

    /* renamed from: e, reason: collision with root package name */
    private List<LbsDataV2.PoiInfo> f253569e;

    /* renamed from: f, reason: collision with root package name */
    private int f253570f = -1;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC8152b f253571h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f253572i;

    /* renamed from: m, reason: collision with root package name */
    public String f253573m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public View f253574a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f253575b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f253576c;

        /* renamed from: d, reason: collision with root package name */
        public View f253577d;

        /* renamed from: e, reason: collision with root package name */
        public View f253578e;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.nearbypro.map.poi.b$b, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public interface InterfaceC8152b {
        void a();

        int b(LatLng latLng, int i3);

        void c(LatLng latLng, boolean z16);
    }

    public b(Context context, d dVar) {
        this.f253568d = context;
        this.C = dVar;
    }

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
        List<LbsDataV2.PoiInfo> list;
        if (i3 != this.f253570f && (list = this.f253569e) != null && i3 < list.size()) {
            this.f253570f = i3;
            d dVar = this.C;
            if (dVar != null) {
                dVar.M1(b());
            }
            notifyDataSetChanged();
            this.f253571h.c(c.f253579a.c(this.f253569e.get(i3)), true);
        }
        if (i3 >= 0) {
            this.f253571h.a();
        }
    }

    public LbsDataV2.PoiInfo b() {
        List<LbsDataV2.PoiInfo> list;
        int i3 = this.f253570f;
        if (i3 <= -1 || (list = this.f253569e) == null || i3 >= list.size()) {
            return null;
        }
        return this.f253569e.get(this.f253570f);
    }

    public int c() {
        return this.f253570f;
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public LbsDataV2.PoiInfo getItem(int i3) {
        List<LbsDataV2.PoiInfo> list = this.f253569e;
        if (list == null || i3 >= list.size()) {
            return null;
        }
        return this.f253569e.get(i3);
    }

    public void e(List<LbsDataV2.PoiInfo> list, boolean z16) {
        this.f253569e = list;
        this.f253572i = z16;
        notifyDataSetChanged();
        int i3 = this.f253570f;
        if (i3 >= 0) {
            f(i3);
            this.f253571h.a();
        }
    }

    public void f(int i3) {
        this.f253570f = i3;
        d dVar = this.C;
        if (dVar != null) {
            dVar.M1(b());
        }
        if (i3 >= 0) {
            this.f253571h.a();
        }
    }

    public void g(InterfaceC8152b interfaceC8152b) {
        this.f253571h = interfaceC8152b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<LbsDataV2.PoiInfo> list = this.f253569e;
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
            view2 = LayoutInflater.from(this.f253568d).inflate(R.layout.f168923hc1, (ViewGroup) null);
            aVar.f253574a = view2.findViewById(R.id.bhd);
            aVar.f253575b = (TextView) view2.findViewById(R.id.f5p);
            aVar.f253576c = (TextView) view2.findViewById(R.id.f164040i7);
            View findViewById = view2.findViewById(R.id.f166843im3);
            aVar.f253577d = findViewById;
            findViewById.setVisibility(4);
            aVar.f253578e = view2.findViewById(R.id.f0b);
            view2.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        List<LbsDataV2.PoiInfo> list = this.f253569e;
        if (list != null && i3 >= list.size() && i3 > 0 && this.f253572i) {
            aVar.f253578e.setVisibility(0);
            aVar.f253574a.setVisibility(8);
        } else {
            aVar.f253578e.setVisibility(8);
            aVar.f253574a.setVisibility(0);
        }
        LbsDataV2.PoiInfo item = getItem(i3);
        if (item != null) {
            try {
                aVar.f253578e.setVisibility(8);
                aVar.f253574a.setVisibility(0);
                int b16 = this.f253571h.b(c.f253579a.c(item), item.distance);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
                if (b16 < 100) {
                    spannableStringBuilder.append((CharSequence) "100m\u5185\uff5c");
                } else if (b16 < 1000) {
                    spannableStringBuilder.append((CharSequence) (b16 + "m\uff5c"));
                } else {
                    spannableStringBuilder.append((CharSequence) (String.format("%.1f", Double.valueOf(b16 / 1000.0d)) + "km\uff5c"));
                }
                if ("".equals(this.f253573m)) {
                    spannableStringBuilder.append((CharSequence) item.address);
                } else {
                    spannableStringBuilder.append((CharSequence) h(item.address, this.f253573m));
                }
                aVar.f253576c.setText(spannableStringBuilder);
                String str = item.poiName + ((Object) spannableStringBuilder);
                if ("".equals(this.f253573m)) {
                    aVar.f253575b.setText(String.format(item.poiName, new Object[0]));
                } else {
                    aVar.f253575b.setText(h(item.poiName, this.f253573m));
                }
                if (i3 == this.f253570f) {
                    aVar.f253577d.setVisibility(0);
                    str = aVar.f253575b.getText().toString() + ((Object) spannableStringBuilder);
                } else {
                    aVar.f253577d.setVisibility(4);
                }
                if (AppSetting.f99565y) {
                    AccessibilityUtil.y(view2, str, i3 == this.f253570f);
                }
            } catch (Exception e16) {
                QLog.i("PoiListAdapter", 2, "getView Exception = ", e16);
            }
        }
        return view2;
    }
}
