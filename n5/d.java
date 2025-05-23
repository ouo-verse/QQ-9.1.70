package n5;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.util.ToastUtil;
import com.qzone.util.al;
import com.qzone.util.image.NetImageInfo;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {

    /* renamed from: r, reason: collision with root package name */
    private static final al<d, Void> f418347r = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f418348a;

    /* renamed from: b, reason: collision with root package name */
    private long f418349b;

    /* renamed from: c, reason: collision with root package name */
    private CellIdInfo f418350c;

    /* renamed from: d, reason: collision with root package name */
    private BusinessAlbumInfo f418351d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<NetImageInfo> f418352e;

    /* renamed from: h, reason: collision with root package name */
    private p5.a f418355h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Context> f418356i;

    /* renamed from: j, reason: collision with root package name */
    private f f418357j;

    /* renamed from: k, reason: collision with root package name */
    private g f418358k;

    /* renamed from: l, reason: collision with root package name */
    private n5.a f418359l;

    /* renamed from: m, reason: collision with root package name */
    private int f418360m;

    /* renamed from: n, reason: collision with root package name */
    private h f418361n;

    /* renamed from: f, reason: collision with root package name */
    private boolean f418353f = false;

    /* renamed from: g, reason: collision with root package name */
    private e f418354g = null;

    /* renamed from: o, reason: collision with root package name */
    private DialogInterface.OnClickListener f418362o = new b();

    /* renamed from: p, reason: collision with root package name */
    private DialogInterface.OnClickListener f418363p = new c();

    /* renamed from: q, reason: collision with root package name */
    private View.OnClickListener f418364q = new ViewOnClickListenerC10824d();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a extends al<d, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Void r16) {
            return new d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            d.this.j();
            o5.a.c(4, d.this.f418360m);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.d("QzoneReshipService", 1, "onClick positiveListener");
            int g16 = d.this.g();
            if (g16 == 0) {
                d.this.j();
                d.this.n();
                o5.a.c(3, d.this.f418360m);
            } else if (g16 == 1) {
                ToastUtil.o(R.string.gcq, 4);
            } else if (g16 != 2) {
                d.this.j();
            } else {
                ToastUtil.o(R.string.gcr, 4);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: n5.d$d, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class ViewOnClickListenerC10824d implements View.OnClickListener {
        ViewOnClickListenerC10824d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (d.this.f418358k != null) {
                d.this.f418358k.a(d.this.f418351d);
                o5.a.c(2, d.this.f418360m);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f418368a = R.string.cancel;

        /* renamed from: b, reason: collision with root package name */
        public int f418369b = R.string.gnd;

        /* renamed from: c, reason: collision with root package name */
        public String f418370c = "";
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<Context> f418371a;

        f(Context context) {
            this.f418371a = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<Context> weakReference;
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 999908) {
                if (i3 != 999969) {
                    return;
                }
                QZoneResult unpack = QZoneResult.unpack(message);
                BusinessAlbumInfo businessAlbumInfo = (unpack != null && unpack.getSucceed() && (unpack.getData() instanceof BusinessAlbumInfo)) ? (BusinessAlbumInfo) unpack.getData() : null;
                if (businessAlbumInfo != null) {
                    d.l().v(businessAlbumInfo);
                    return;
                }
                return;
            }
            QZoneResult unpack2 = QZoneResult.unpack(message);
            if (unpack2 == null || !unpack2.getSucceed()) {
                if (unpack2 != null) {
                    ToastUtil.s(unpack2.getMessage(), 4);
                    return;
                } else {
                    ToastUtil.s(l.a(R.string.s7u), 4);
                    QZLog.e("QzoneReshipService", "result == null or not succeed");
                    return;
                }
            }
            int intValue = ((Integer) unpack2.getData()).intValue();
            if (intValue == 7 && (weakReference = this.f418371a) != null && weakReference.get() != null) {
                ToastUtil.s(this.f418371a.get().getResources().getString(R.string.f170824al0), 5);
                return;
            }
            QZLog.e("QzoneReshipService", "actionTye error = " + intValue);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface g {
        void a(BusinessAlbumInfo businessAlbumInfo);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface h {
        void a(String str, QZoneWriteOperationService.p pVar);
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        if (this.f418351d == null) {
            return 0;
        }
        if (!this.f418353f) {
            return 2;
        }
        int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_ALBUM_MAX_PHOTO_COUNT, 10000);
        return (!this.f418353f || config <= 0 || (this.f418352e.size() + QZonePublishQueue.w().D(this.f418351d.mAlbumId)) + this.f418351d.mTotal <= config) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        p5.a aVar = this.f418355h;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.f418355h.dismiss();
        this.f418355h = null;
    }

    public static d l() {
        return f418347r.get(null);
    }

    private String m() {
        e eVar = this.f418354g;
        if (eVar != null && !TextUtils.isEmpty(eVar.f418370c)) {
            return this.f418354g.f418370c;
        }
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewQuotePictureTo", "\u8f6c\u8f7d\u56fe\u7247\u5230");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String str;
        ArrayList<String> arrayList;
        if (!NetworkState.isNetSupport()) {
            ToastUtil.o(R.string.gdc, 4);
            return;
        }
        if (this.f418352e == null) {
            return;
        }
        BusinessAlbumInfo businessAlbumInfo = this.f418351d;
        String str2 = "";
        if (businessAlbumInfo == null) {
            str = "";
        } else {
            str = businessAlbumInfo.mAlbumId;
        }
        HashMap hashMap = new HashMap();
        int i3 = this.f418348a;
        if (i3 != 4) {
            arrayList = null;
            if (i3 == 311) {
                CellIdInfo cellIdInfo = this.f418350c;
                if (cellIdInfo != null) {
                    str2 = cellIdInfo.cellId;
                }
                Iterator<NetImageInfo> it = this.f418352e.iterator();
                while (it.hasNext()) {
                    NetImageInfo next = it.next();
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.mAlbumId);
                    if (arrayList2 == null) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(next.lloc);
                        hashMap.put(next.mAlbumId, arrayList3);
                    } else {
                        arrayList2.add(next.lloc);
                    }
                }
            }
        } else {
            str2 = this.f418352e.get(0).mAlbumId;
            arrayList = new ArrayList<>();
            Iterator<NetImageInfo> it5 = this.f418352e.iterator();
            while (it5.hasNext()) {
                arrayList.add(it5.next().lloc);
            }
        }
        QZoneWriteOperationService.p pVar = new QZoneWriteOperationService.p();
        pVar.f45771c = this.f418348a;
        pVar.f45773e = this.f418349b;
        pVar.f45774f = str2;
        pVar.f45775g = arrayList;
        pVar.f45790v = hashMap;
        h hVar = this.f418361n;
        if (hVar != null) {
            hVar.a(str, pVar);
        } else {
            n5.a aVar = this.f418359l;
            if (aVar != null) {
                aVar.a(str, pVar, this.f418357j);
            }
        }
        o5.a.d(this.f418351d);
    }

    private void w() {
        int i3;
        int i16;
        p5.a aVar = this.f418355h;
        if (aVar != null) {
            if (aVar.isShowing()) {
                try {
                    this.f418355h.dismiss();
                } catch (Exception e16) {
                    QZLog.e("QzoneReshipService", "error", e16);
                }
            }
            this.f418355h = null;
        }
        if (this.f418356i.get() != null) {
            p5.a aVar2 = new p5.a(this.f418356i.get(), R.style.qZoneInputDialog);
            this.f418355h = aVar2;
            aVar2.setContentView(R.layout.bqy);
            e eVar = this.f418354g;
            if (eVar != null) {
                i3 = eVar.f418368a;
                i16 = eVar.f418369b;
            } else {
                i3 = R.string.cancel;
                i16 = R.string.gnd;
            }
            this.f418355h.U(m()).R(i3, this.f418362o).S(i16, this.f418363p).O(this.f418364q);
            BusinessAlbumInfo businessAlbumInfo = this.f418351d;
            if (businessAlbumInfo == null) {
                this.f418355h.N(o5.a.a()).P(o5.a.a()).Q(null, true);
            } else {
                this.f418355h.N(businessAlbumInfo.getTitle()).P(this.f418351d.getPrivacyDescription()).Q(this.f418351d.mCover, true);
            }
            this.f418355h.show();
            o5.a.c(1, this.f418360m);
        }
    }

    private void x() {
        p5.a aVar;
        if (this.f418351d == null || (aVar = this.f418355h) == null || !aVar.isShowing()) {
            return;
        }
        this.f418355h.U(m()).N(this.f418351d.getTitle()).P(this.f418351d.getPrivacyDescription()).Q(this.f418351d.mCover, true);
    }

    public void h(int i3) {
        if (this.f418360m == i3) {
            r(null);
        }
    }

    public void i(Context context) {
        p5.a aVar = this.f418355h;
        if (aVar == null || context != aVar.getContext()) {
            return;
        }
        j();
    }

    public BusinessAlbumInfo k() {
        return this.f418351d;
    }

    public void q(Context context, ArrayList<NetImageInfo> arrayList, int i3, long j3, CellIdInfo cellIdInfo, e eVar, BusinessAlbumInfo businessAlbumInfo) {
        this.f418352e = arrayList;
        this.f418348a = i3;
        this.f418349b = j3;
        this.f418350c = cellIdInfo;
        this.f418356i = new WeakReference<>(context);
        this.f418357j = new f(context);
        this.f418351d = null;
        this.f418353f = false;
        this.f418354g = eVar;
        ArrayList<NetImageInfo> arrayList2 = this.f418352e;
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.f418351d = o5.a.b();
            w();
            n5.a aVar = this.f418359l;
            if (aVar != null) {
                BusinessAlbumInfo businessAlbumInfo2 = this.f418351d;
                if (businessAlbumInfo2 != null) {
                    this.f418353f = true;
                    aVar.b(businessAlbumInfo2.mAlbumId, businessAlbumInfo2.mTitle, this.f418357j);
                    return;
                } else if (businessAlbumInfo != null) {
                    this.f418353f = true;
                    aVar.b(businessAlbumInfo.mAlbumId, businessAlbumInfo.mTitle, this.f418357j);
                    return;
                } else {
                    aVar.b("", o5.a.a(), this.f418357j);
                    return;
                }
            }
            return;
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastQuoteNullPicture", "\u8f6c\u8f7d\u56fe\u7247\u4e3a\u7a7a"), 4);
    }

    public void r(g gVar) {
        this.f418358k = gVar;
    }

    public void s(int i3) {
        this.f418360m = i3;
    }

    public void t(h hVar) {
        this.f418361n = hVar;
    }

    public void u(n5.a aVar) {
        this.f418359l = aVar;
    }

    public void v(BusinessAlbumInfo businessAlbumInfo) {
        this.f418353f = businessAlbumInfo != null;
        this.f418351d = businessAlbumInfo;
        x();
    }

    public void o(Context context, ArrayList<NetImageInfo> arrayList, int i3, long j3, CellIdInfo cellIdInfo) {
        p(context, arrayList, i3, j3, cellIdInfo, null);
    }

    public void p(Context context, ArrayList<NetImageInfo> arrayList, int i3, long j3, CellIdInfo cellIdInfo, e eVar) {
        q(context, arrayList, i3, j3, cellIdInfo, eVar, null);
    }
}
