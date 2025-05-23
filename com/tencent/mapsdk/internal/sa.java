package com.tencent.mapsdk.internal;

import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Response;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.rz;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sa implements oz {

    /* renamed from: a, reason: collision with root package name */
    public static final String f150166a = "d8ab2f7b7a7536a71894084e1c812fd0";

    /* renamed from: b, reason: collision with root package name */
    public static final IvParameterSpec f150167b = new IvParameterSpec("c0ab1f54he78k36d".getBytes());

    /* renamed from: c, reason: collision with root package name */
    public static int f150168c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static int f150169d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static int f150170e = 2;

    /* renamed from: m, reason: collision with root package name */
    private static final int f150171m = 130817;

    /* renamed from: n, reason: collision with root package name */
    private static final int f150172n = 130818;

    /* renamed from: o, reason: collision with root package name */
    private static final int f150173o = 130819;

    /* renamed from: q, reason: collision with root package name */
    private static final int f150174q = 5000;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f150175f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f150176g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f150177h;

    /* renamed from: j, reason: collision with root package name */
    private final ne f150179j;

    /* renamed from: k, reason: collision with root package name */
    private final rz f150180k;

    /* renamed from: l, reason: collision with root package name */
    private final String f150181l;

    /* renamed from: p, reason: collision with root package name */
    private final SparseArray<rx> f150182p = new SparseArray<>(32);

    /* renamed from: i, reason: collision with root package name */
    public final Handler f150178i = new Handler(kp.a("gesture")) { // from class: com.tencent.mapsdk.internal.sa.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case sa.f150171m /* 130817 */:
                    sa.a(sa.this);
                    return;
                case sa.f150172n /* 130818 */:
                    sa.this.a();
                    return;
                case sa.f150173o /* 130819 */:
                    sa.b(sa.this);
                    return;
                default:
                    return;
            }
        }
    };

    public sa(ne neVar) {
        this.f150179j = neVar;
        neVar.a(this);
        this.f150180k = new rz(neVar.f149400m);
        mz a16 = mz.a(neVar.getContext(), (TencentMapOptions) null);
        ku.a(a16.f149361d);
        this.f150181l = a16.f149361d;
    }

    private void a(boolean z16) {
        this.f150175f = z16;
        if (z16) {
            this.f150178i.sendEmptyMessage(f150171m);
        } else {
            this.f150178i.sendEmptyMessage(f150173o);
        }
    }

    private void b() {
        LogUtil.c(ky.f149108n, "performInit");
        this.f150177h = false;
        this.f150176g = false;
        a();
    }

    private boolean c() {
        return this.f150176g;
    }

    private boolean d() {
        if (!this.f150177h && this.f150175f) {
            return true;
        }
        return false;
    }

    private void e() {
        this.f150176g = false;
        this.f150178i.sendEmptyMessage(f150172n);
    }

    private void f() {
        this.f150176g = true;
    }

    private void g() {
        this.f150177h = true;
        this.f150175f = false;
        this.f150178i.sendEmptyMessage(f150173o);
    }

    private void h() {
        LogUtil.c(ky.f149108n, "performDestroy");
        this.f150180k.a();
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void k() {
        this.f150178i.sendEmptyMessage(f150172n);
    }

    private static rx a(int i3, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        byte[] bArr;
        String encode = URLEncoder.encode(EncryptAesUtils.encryptAes256Base64("lblat=" + latLng.latitude + "&lblon=" + latLng.longitude + "&rtlat=" + latLng2.latitude + "&rtlon=" + latLng2.longitude + "&zoom=" + i3 + "&suid=" + ho.d() + "&version=" + ho.n() + "&nt=" + ho.g() + "&location=" + latLng3.latitude + "," + latLng3.longitude, f150166a, f150167b));
        ea eaVar = (ea) cr.a(ea.class);
        NetResponse mapTrafficEvent = eaVar != null ? ((dl) eaVar.i()).mapTrafficEvent(encode) : null;
        if (mapTrafficEvent != null && (bArr = mapTrafficEvent.data) != null) {
            m mVar = new m(bArr);
            mVar.a("UTF-8");
            Response response = new Response();
            try {
                response.readFrom(mVar);
            } catch (Exception e16) {
                LogUtil.e(ky.f149108n, "traffic event read field exception:" + e16.fillInStackTrace());
            }
            if (response.error != 0 || response.detail == null) {
                return null;
            }
            rx rxVar = new rx(new LatLngBounds.Builder().include(latLng).include(latLng2).build(), response.detail);
            LogUtil.b(ky.f149108n, "traffic event data detail:".concat(String.valueOf(rxVar)));
            return rxVar;
        }
        StringBuilder sb5 = new StringBuilder("rsp = ");
        sb5.append(mapTrafficEvent != null ? Integer.valueOf(mapTrafficEvent.statusCode) : "null");
        LogUtil.c(ky.f149108n, sb5.toString());
        return null;
    }

    private rx b(int i3) {
        ne neVar = this.f150179j;
        if (neVar == null) {
            return null;
        }
        if (neVar.L() != null && this.f150179j.L().f147920g) {
            return null;
        }
        LogUtil.c(ky.f149108n, "traffic event tobe fetch data from net!");
        ne neVar2 = this.f150179j;
        Rect rect = neVar2.f149405r;
        return a(i3, neVar2.f149403p.a(new PointF(rect.width() * (-2), rect.height() * 3)), this.f150179j.f149403p.a(new PointF(rect.width() * 3, rect.height() * (-2))), ks.a(this.f150179j.f149410w.f151264m));
    }

    private void a(rx rxVar, rx rxVar2) {
        List<Detail> list;
        List<Detail> list2;
        boolean z16;
        if (rxVar2 == null || (list = rxVar2.f150157c) == null) {
            return;
        }
        if (list.isEmpty()) {
            this.f150180k.a();
            return;
        }
        LinkedList linkedList = new LinkedList();
        if (rxVar == null || (list2 = rxVar.f150157c) == null || list2.isEmpty()) {
            return;
        }
        List<Detail> list3 = rxVar.f150157c;
        List<Detail> list4 = rxVar2.f150157c;
        for (Detail detail : list3) {
            Iterator<Detail> it = list4.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().basic.eventid.equals(detail.basic.eventid)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                linkedList.add(detail);
            }
        }
        this.f150180k.b(linkedList);
    }

    @Override // com.tencent.mapsdk.internal.oz
    public final void j() {
    }

    static /* synthetic */ void b(sa saVar) {
        LogUtil.c(ky.f149108n, "performDestroy");
        saVar.f150180k.a();
    }

    private void a(rx rxVar) {
        List<Detail> list;
        int i3;
        byte[] c16;
        byte[] bArr;
        hi hiVar;
        if (rxVar == null || (list = rxVar.f150157c) == null || list.isEmpty()) {
            return;
        }
        ne neVar = this.f150179j;
        if (neVar != null && (hiVar = neVar.f147918e) != null) {
            hiVar.f().f148654a++;
        }
        Iterator<Detail> it = rxVar.f150157c.iterator();
        while (it.hasNext()) {
            String str = it.next().basic.icon_normal;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1 && (i3 = lastIndexOf + 1) <= str.length()) {
                String substring = str.substring(i3);
                if (hn.f148686b.a(substring) == null) {
                    File file = new File(this.f150181l, substring);
                    if (!file.exists()) {
                        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
                        if (doGet != null && (bArr = doGet.data) != null) {
                            kt.a(file, bArr);
                            c16 = doGet.data;
                        }
                    } else {
                        c16 = kt.c(file);
                    }
                    if (c16 != null && c16.length > 0) {
                        hn.f148686b.a(substring, BitmapFactory.decodeByteArray(c16, 0, c16.length));
                    }
                }
            }
        }
        this.f150180k.a(rxVar.f150157c);
    }

    private void a(List<Detail> list) {
        int i3;
        byte[] c16;
        byte[] bArr;
        Iterator<Detail> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next().basic.icon_normal;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1 && (i3 = lastIndexOf + 1) <= str.length()) {
                String substring = str.substring(i3);
                if (hn.f148686b.a(substring) == null) {
                    File file = new File(this.f150181l, substring);
                    if (!file.exists()) {
                        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
                        if (doGet != null && (bArr = doGet.data) != null) {
                            kt.a(file, bArr);
                            c16 = doGet.data;
                        }
                    } else {
                        c16 = kt.c(file);
                    }
                    if (c16 != null && c16.length > 0) {
                        hn.f148686b.a(substring, BitmapFactory.decodeByteArray(c16, 0, c16.length));
                    }
                }
            }
        }
    }

    public final TrafficEvent a(int i3) {
        rz rzVar = this.f150180k;
        if (rzVar == null) {
            return null;
        }
        Iterator<String> it = rzVar.f150162a.keySet().iterator();
        while (it.hasNext()) {
            rz.a aVar = this.f150180k.f150162a.get(it.next());
            if (aVar != null && aVar.f150164a.a() == i3) {
                return new ry(aVar.f150165b);
            }
        }
        return null;
    }

    public final void a() {
        LogUtil.c(ky.f149108n, "performRefresh");
        if (d()) {
            if (!this.f150176g) {
                ne neVar = this.f150179j;
                int a16 = (int) neVar.f149410w.a();
                LatLng[] a17 = neVar.f149403p.a();
                rx rxVar = this.f150182p.get(a16);
                rx b16 = (rxVar != null && rxVar.f150157c != null && SystemClock.elapsedRealtime() - rxVar.f150155a <= 5000 && rxVar.f150156b.contains(a17[0]) && rxVar.f150156b.contains(a17[1]) && rxVar.f150156b.contains(a17[2]) && rxVar.f150156b.contains(a17[3])) ? null : b(a16);
                if (b16 == null || b16.f150157c == null) {
                    b16 = rxVar;
                }
                this.f150182p.put(a16, b16);
                a(rxVar, b16);
                a(b16);
                this.f150178i.removeMessages(f150172n);
                this.f150178i.sendEmptyMessageDelayed(f150172n, 5000L);
                return;
            }
            LogUtil.c(ky.f149108n, "traffic event tobe paused!");
            return;
        }
        LogUtil.c(ky.f149108n, "traffic event tobe destroyed!");
        this.f150182p.clear();
    }

    static /* synthetic */ void a(sa saVar) {
        LogUtil.c(ky.f149108n, "performInit");
        saVar.f150177h = false;
        saVar.f150176g = false;
        saVar.a();
    }
}
