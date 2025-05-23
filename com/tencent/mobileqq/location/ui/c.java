package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private InterfaceC7979c C;

    /* renamed from: d, reason: collision with root package name */
    private Context f241556d;

    /* renamed from: e, reason: collision with root package name */
    private int f241557e;

    /* renamed from: f, reason: collision with root package name */
    private int f241558f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f241559h;

    /* renamed from: i, reason: collision with root package name */
    private LocationPoiDataFromMapHelper f241560i;

    /* renamed from: m, reason: collision with root package name */
    private List<LocationRoom.Venue> f241561m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements LocationPoiDataFromMapHelper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f241562a;

        a(String str) {
            this.f241562a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) str);
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
            if (c.this.f241561m != null && c.this.f241561m.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            c.this.f241561m = list;
            c.this.notifyDataSetChanged();
            c.this.f241559h = TextUtils.isEmpty(this.f241562a);
            if (c.this.f241561m.size() > 0 && TextUtils.isEmpty(this.f241562a)) {
                if (!z16) {
                    c.this.e(0);
                    return;
                } else {
                    if (c.this.C != null) {
                        InterfaceC7979c interfaceC7979c = c.this.C;
                        if (c.this.f241561m.size() > 0) {
                            i3 = 3;
                        }
                        interfaceC7979c.a(i3);
                        return;
                    }
                    return;
                }
            }
            if (c.this.C != null) {
                InterfaceC7979c interfaceC7979c2 = c.this.C;
                if (c.this.f241561m.size() > 0) {
                    i3 = 3;
                }
                interfaceC7979c2.a(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        View f241564a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f241565b;

        /* renamed from: c, reason: collision with root package name */
        TextView f241566c;

        /* renamed from: d, reason: collision with root package name */
        View f241567d;

        /* renamed from: e, reason: collision with root package name */
        public View f241568e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.ui.c$c, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7979c {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f241557e = -1;
        this.f241558f = -1;
        this.f241559h = true;
        this.f241556d = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i3) {
        LocationRoom.Venue venue = this.f241561m.get(i3);
        if (this.f241558f > 0) {
            this.f241561m.add(this.f241558f, this.f241561m.remove(0));
        }
        this.f241561m.remove(venue);
        this.f241561m.add(0, venue);
        this.f241558f = i3;
        this.f241557e = 0;
        notifyDataSetChanged();
        InterfaceC7979c interfaceC7979c = this.C;
        if (interfaceC7979c != null) {
            interfaceC7979c.a(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        InterfaceC7979c interfaceC7979c;
        if (this.f241560i.k() && (interfaceC7979c = this.C) != null) {
            interfaceC7979c.a(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRoom.Venue g() {
        int i3 = this.f241557e;
        if (i3 < 0) {
            return null;
        }
        return getItem(i3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f241561m != null) {
            if (this.f241560i.l()) {
                return this.f241561m.size() + 1;
            }
            return this.f241561m.size();
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
        View view2;
        b bVar;
        String str;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                bVar = new b();
                view2 = LayoutInflater.from(this.f241556d).inflate(R.layout.f168222ml, (ViewGroup) null);
                bVar.f241564a = view2.findViewById(R.id.bhd);
                bVar.f241565b = (TextView) view2.findViewById(R.id.f5p);
                bVar.f241566c = (TextView) view2.findViewById(R.id.f164040i7);
                View findViewById = view2.findViewById(R.id.f166843im3);
                bVar.f241567d = findViewById;
                findViewById.setVisibility(4);
                bVar.f241568e = view2.findViewById(R.id.f0b);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            if (this.f241560i.l() && i3 == this.f241561m.size()) {
                bVar.f241568e.setVisibility(0);
                bVar.f241564a.setVisibility(8);
            } else {
                bVar.f241568e.setVisibility(8);
                bVar.f241564a.setVisibility(0);
                LocationRoom.Venue item = getItem(i3);
                if (item != null) {
                    bVar.f241568e.setVisibility(8);
                    bVar.f241564a.setVisibility(0);
                    bVar.f241566c.setText(item.f241272h);
                    String str2 = item.f241271f + item.f241272h;
                    if (i3 == this.f241557e) {
                        bVar.f241565b.setText(String.format(this.f241556d.getString(R.string.hgv), item.f241271f));
                        bVar.f241567d.setVisibility(0);
                        str = (bVar.f241565b.getText().toString() + item.f241272h) + this.f241556d.getString(R.string.cxe);
                    } else {
                        bVar.f241565b.setText(item.f241271f);
                        bVar.f241567d.setVisibility(4);
                        str = str2 + this.f241556d.getString(R.string.cxf);
                    }
                    view2.setContentDescription(str);
                }
            }
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f241557e;
    }

    @Override // android.widget.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public LocationRoom.Venue getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocationRoom.Venue) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (this.f241561m != null && i3 < getCount()) {
            return this.f241561m.get(i3);
        }
        return null;
    }

    public void j(TencentMap tencentMap, LatLng latLng, String str) {
        InterfaceC7979c interfaceC7979c;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tencentMap, latLng, str);
            return;
        }
        LocationPoiDataFromMapHelper locationPoiDataFromMapHelper = new LocationPoiDataFromMapHelper(tencentMap, latLng, str);
        this.f241560i = locationPoiDataFromMapHelper;
        locationPoiDataFromMapHelper.o(new a(str));
        if (this.f241560i.k() && (interfaceC7979c = this.C) != null) {
            interfaceC7979c.a(0);
        }
        this.f241558f = -1;
        this.f241557e = -1;
        List<LocationRoom.Venue> list = this.f241561m;
        if (list != null) {
            list.clear();
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f241559h;
    }

    public void l(InterfaceC7979c interfaceC7979c) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) interfaceC7979c);
        } else {
            this.C = interfaceC7979c;
        }
    }
}
