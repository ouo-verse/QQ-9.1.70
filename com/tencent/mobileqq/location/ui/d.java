package com.tencent.mobileqq.location.ui;

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
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private c C;
    private LatLng D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Context> f241569d;

    /* renamed from: e, reason: collision with root package name */
    private int f241570e;

    /* renamed from: f, reason: collision with root package name */
    private int f241571f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f241572h;

    /* renamed from: i, reason: collision with root package name */
    private LocationPoiDataFromMapHelper f241573i;

    /* renamed from: m, reason: collision with root package name */
    private List<LocationRoom.Venue> f241574m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements LocationPoiDataFromMapHelper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f241575a;

        a(String str) {
            this.f241575a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.a
        public void onUpdate(List<LocationRoom.Venue> list) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            if (d.this.f241574m != null && d.this.f241574m.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            d.this.f241574m = list;
            d.this.notifyDataSetChanged();
            d.this.f241572h = TextUtils.isEmpty(this.f241575a);
            if (d.this.f241574m.size() > 0 && d.this.f241572h) {
                if (!z16) {
                    d.this.f(0);
                    return;
                } else {
                    if (d.this.C != null) {
                        c cVar = d.this.C;
                        if (d.this.f241574m.size() > 0) {
                            i3 = 3;
                        }
                        cVar.a(i3);
                        return;
                    }
                    return;
                }
            }
            if (d.this.C != null) {
                c cVar2 = d.this.C;
                if (d.this.f241574m.size() > 0) {
                    i3 = 3;
                }
                cVar2.a(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        View f241577a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f241578b;

        /* renamed from: c, reason: collision with root package name */
        TextView f241579c;

        /* renamed from: d, reason: collision with root package name */
        View f241580d;

        /* renamed from: e, reason: collision with root package name */
        public View f241581e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f241570e = -1;
        this.f241571f = -1;
        this.f241572h = true;
        this.f241569d = new WeakReference<>(context);
    }

    private Context j() {
        WeakReference<Context> weakReference = this.f241569d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return BaseApplication.getContext();
    }

    private int k(LatLng latLng, int i3) {
        LatLng latLng2 = this.D;
        if (latLng2 != null) {
            return (int) TencentLocationUtils.distanceBetween(latLng2.latitude, latLng2.longitude, latLng.latitude, latLng.longitude);
        }
        return i3;
    }

    @SuppressLint({"ResourceAsColor"})
    private SpannableString p(String str, String str2) {
        if (!"".equals(str2) && !"".equals(str)) {
            SpannableString spannableString = new SpannableString(str);
            for (int i3 = 0; i3 < str.length(); i3++) {
                for (int i16 = 0; i16 < str2.length(); i16++) {
                    if (str.charAt(i3) == str2.charAt(i16) || Character.toUpperCase(str.charAt(i3)) == Character.toUpperCase(str2.charAt(i16))) {
                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0099FF")), i3, i3 + 1, 18);
                    }
                }
            }
            return spannableString;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i3) {
        this.f241570e = i3;
        notifyDataSetChanged();
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        c cVar;
        if (this.f241573i.k() && (cVar = this.C) != null) {
            cVar.a(1);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f241574m != null) {
            if (this.f241573i.l()) {
                return this.f241574m.size() + 1;
            }
            return this.f241574m.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        String str;
        View view3;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view3 = view;
            view4 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                bVar = new b();
                view2 = LayoutInflater.from(j()).inflate(R.layout.f168222ml, (ViewGroup) null);
                bVar.f241577a = view2.findViewById(R.id.bhd);
                bVar.f241578b = (TextView) view2.findViewById(R.id.f5p);
                bVar.f241579c = (TextView) view2.findViewById(R.id.f164040i7);
                View findViewById = view2.findViewById(R.id.f166843im3);
                bVar.f241580d = findViewById;
                findViewById.setVisibility(4);
                bVar.f241581e = view2.findViewById(R.id.f0b);
                view2.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (this.f241573i.l() && i3 == this.f241574m.size()) {
                bVar.f241581e.setVisibility(0);
                bVar.f241577a.setVisibility(8);
            } else {
                bVar.f241581e.setVisibility(8);
                bVar.f241577a.setVisibility(0);
                LocationRoom.Venue item = getItem(i3);
                if (item != null) {
                    bVar.f241581e.setVisibility(8);
                    bVar.f241577a.setVisibility(0);
                    bVar.f241579c.setText(item.f241272h);
                    int k3 = k(item.f241273i, (int) item.f241274m);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
                    if (k3 < 100) {
                        spannableStringBuilder.append((CharSequence) "100m\u5185\uff5c");
                    } else if (k3 < 1000) {
                        spannableStringBuilder.append((CharSequence) (k3 + "m\uff5c"));
                    } else {
                        spannableStringBuilder.append((CharSequence) (String.format("%.1f", Double.valueOf(k3 / 1000.0d)) + "km\uff5c"));
                    }
                    if ("".equals(this.E)) {
                        spannableStringBuilder.append((CharSequence) item.f241272h);
                    } else {
                        spannableStringBuilder.append((CharSequence) p(item.f241272h, this.E));
                    }
                    bVar.f241579c.setText(spannableStringBuilder);
                    String str2 = item.f241271f + item.f241272h;
                    if ("".equals(this.E)) {
                        bVar.f241578b.setText(String.format(item.f241271f, new Object[0]));
                    } else {
                        bVar.f241578b.setText(p(item.f241271f, this.E));
                    }
                    if (i3 == this.f241570e) {
                        bVar.f241580d.setVisibility(0);
                        str = (bVar.f241578b.getText().toString() + item.f241272h) + HardCodeUtil.qqStr(R.string.cxe);
                    } else {
                        bVar.f241580d.setVisibility(4);
                        str = str2 + HardCodeUtil.qqStr(R.string.cxf);
                    }
                    view2.setContentDescription(str);
                }
            }
            view3 = view2;
            view4 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRoom.Venue h() {
        int i3 = this.f241570e;
        if (i3 < 0) {
            return null;
        }
        return getItem(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f241570e;
    }

    @Override // android.widget.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public LocationRoom.Venue getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocationRoom.Venue) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        List<LocationRoom.Venue> list = this.f241574m;
        if (list != null && i3 < list.size()) {
            return this.f241574m.get(i3);
        }
        return null;
    }

    public void m(TencentMap tencentMap, LatLng latLng, LatLng latLng2, String str) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tencentMap, latLng, latLng2, str);
            return;
        }
        this.D = latLng2;
        this.E = str;
        LocationPoiDataFromMapHelper locationPoiDataFromMapHelper = new LocationPoiDataFromMapHelper(tencentMap, latLng, str);
        this.f241573i = locationPoiDataFromMapHelper;
        locationPoiDataFromMapHelper.o(new a(str));
        if (this.f241573i.k() && (cVar = this.C) != null) {
            cVar.a(0);
        }
        this.f241571f = -1;
        this.f241570e = -1;
        List<LocationRoom.Venue> list = this.f241574m;
        if (list != null) {
            list.clear();
        }
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f241572h;
    }

    public void o(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar);
        } else {
            this.C = cVar;
        }
    }
}
