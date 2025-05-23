package com.qzone.album.business.albumlist.fragment;

import NS_MOBILE_PHOTO.TabTimeLine;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.business.albumlist.activity.QzonePhotoCategoryActivity;
import com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment;
import com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategoryControlInfo;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QzoneAlbumRecentAllPhotoRequest;
import com.qzone.album.ui.widget.AlbumTimeLineView;
import com.qzone.album.ui.widget.ConcreteCombinePictureLayout;
import com.qzone.album.ui.widget.NumberShiftingView;
import com.qzone.common.event.Event;
import com.qzone.common.event.IObserver;
import com.qzone.preview.event.QZoneAlbumCategoryDeletePhotoEvent;
import com.qzone.report.QZonePerfReporter;
import com.qzone.util.ar;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumRecentTabFragment extends AlbumBaseTabFragment implements IObserver.main, c5.a, SimpleEventReceiver {

    /* renamed from: f1, reason: collision with root package name */
    private static final int f42303f1 = ar.e(83.0f);

    /* renamed from: g1, reason: collision with root package name */
    private static final int f42304g1 = ar.e(68.0f);

    /* renamed from: h1, reason: collision with root package name */
    private static final int f42305h1;

    /* renamed from: i1, reason: collision with root package name */
    private static final int f42306i1;

    /* renamed from: j1, reason: collision with root package name */
    private static final int f42307j1;

    /* renamed from: k1, reason: collision with root package name */
    private static final int f42308k1;
    private ConcreteCombinePictureLayout A0;
    private NumberShiftingView B0;
    private NumberShiftingView C0;
    private NumberShiftingView D0;
    private ArrayList<NumberShiftingView> E0;
    private TextView I0;
    private TextView J0;
    private TextView K0;
    private boolean O0;
    private int[] R0;
    private long S0;
    View.OnClickListener T0;
    public boolean U0;
    public boolean V0;
    private int W0;
    private int X0;
    public AbsCompatRequest.a Y0;
    public ArrayList<TabTimeLine> Z0;

    /* renamed from: a1, reason: collision with root package name */
    private int f42309a1;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f42310b1;

    /* renamed from: c1, reason: collision with root package name */
    private int f42311c1;

    /* renamed from: d1, reason: collision with root package name */
    private int f42312d1;

    /* renamed from: e1, reason: collision with root package name */
    private int f42313e1;

    /* renamed from: u0, reason: collision with root package name */
    private View f42317u0;

    /* renamed from: v0, reason: collision with root package name */
    private RelativeLayout f42318v0;

    /* renamed from: w0, reason: collision with root package name */
    private RelativeLayout f42319w0;

    /* renamed from: x0, reason: collision with root package name */
    private RelativeLayout f42320x0;

    /* renamed from: y0, reason: collision with root package name */
    private ConcreteCombinePictureLayout f42321y0;

    /* renamed from: z0, reason: collision with root package name */
    private ConcreteCombinePictureLayout f42322z0;

    /* renamed from: r0, reason: collision with root package name */
    private final String f42314r0 = "AlbumRecentTabFragment";

    /* renamed from: s0, reason: collision with root package name */
    private TextView[] f42315s0 = new TextView[3];

    /* renamed from: t0, reason: collision with root package name */
    private NumberShiftingView[] f42316t0 = new NumberShiftingView[3];
    private int F0 = -1;
    private int G0 = -1;
    private int H0 = -1;
    private String L0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_PORTRAIT_TEXT, QzoneConfig.DefaultValue.DEFAULT_PORTRAIT_TEXT);
    private String M0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_LOCATION_TEXT, QzoneConfig.DefaultValue.DEFAULT_LOCATION_TEXT);
    private String N0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_LABEL_TEXT, QzoneConfig.DefaultValue.DEFAULT_LABEL_TEXT);
    private boolean P0 = true;
    private int Q0 = ar.e(110.0f);

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass2 implements QZonePersonalAlbumRecentAdapter.f {
        AnonymousClass2() {
        }

        @Override // com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter.f
        public void a(final View view, final ArrayList<PhotoCacheData> arrayList, final int i3) {
            if (AlbumRecentTabFragment.this.P0) {
                AlbumRecentTabFragment.this.P0 = false;
                if (view == null || arrayList == null || arrayList.isEmpty() || i3 < 0 || i3 >= arrayList.size()) {
                    return;
                }
                com.qzone.album.env.common.a.m().R("326", "1", "24");
                com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumRecentTabFragment albumRecentTabFragment = AlbumRecentTabFragment.this;
                        final ArrayList<AlbumCacheData> T = albumRecentTabFragment.S.T(albumRecentTabFragment.P.longValue());
                        if (T == null) {
                            T = new ArrayList<>();
                        }
                        final boolean a16 = com.qzone.album.base.b.a(AlbumRecentTabFragment.this.Fh());
                        AlbumRecentTabFragment.this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                t4.a N = t4.a.N();
                                Activity hostActivity = AlbumRecentTabFragment.this.C.getHostActivity();
                                long longValue = AlbumRecentTabFragment.this.P.longValue();
                                ArrayList<AlbumCacheData> arrayList2 = T;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                N.B(hostActivity, longValue, arrayList2, arrayList, i3, a16, AlbumRecentTabFragment.this.U0, 1, view);
                            }
                        });
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (System.currentTimeMillis() - AlbumRecentTabFragment.this.S0 < 1000) {
                QZLog.w("AlbumRecentTabFragment", "click too fast");
            } else {
                AlbumRecentTabFragment.this.S0 = System.currentTimeMillis();
                Intent intent = new Intent();
                intent.setClass(AlbumRecentTabFragment.this.C.getHostActivity(), QzonePhotoCategoryActivity.class);
                int id5 = view.getId();
                if (id5 == R.id.f166503fo3) {
                    intent.putExtra("categorybusitype", 1);
                    u4.c.a().r("326", "2", "13");
                } else if (id5 == R.id.f166504fo4) {
                    intent.putExtra("categorybusitype", 2);
                    u4.c.a().r("326", "2", "14");
                } else if (id5 == R.id.fo5) {
                    intent.putExtra("categorybusitype", 4);
                    u4.c.a().r("326", "2", "15");
                }
                AlbumRecentTabFragment.this.startActivityForResult(intent, 16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements QZonePullToRefreshListView.c {
        b() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
            AlbumRecentTabFragment.this.Sh();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            AlbumBaseTabFragment.j jVar;
            if (AlbumRecentTabFragment.this.Ph() && (jVar = AlbumRecentTabFragment.this.C) != null && !jVar.checkNetworkConnect()) {
                com.qzone.album.env.common.a.m().U(R.string.ghi);
            }
            AlbumRecentTabFragment.this.ki();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
            QZLog.d("recentPhotoTimeLine", 1, "onPullEnd");
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
            QZLog.d("recentPhotoTimeLine", 1, "onPullStart");
            AlbumRecentTabFragment.this.Ui();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements AbsCompatRequest.a {
        c() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "mRefreshRecentListTimeLineCallback refresh complete");
            AlbumRecentTabFragment albumRecentTabFragment = AlbumRecentTabFragment.this;
            albumRecentTabFragment.V0 = false;
            if (!albumRecentTabFragment.isAdded() || sVar == null) {
                return;
            }
            AlbumRecentTabFragment.this.Qh();
            AlbumRecentTabFragment.this.wi(true);
            AlbumRecentTabFragment.this.aj(sVar);
        }
    }

    public AlbumRecentTabFragment() {
        int i3 = f42307j1;
        this.R0 = new int[]{i3, i3, i3, i3};
        this.S0 = 0L;
        this.T0 = new a();
        this.U0 = false;
        this.V0 = false;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = new c();
        this.f42309a1 = 0;
        this.f42310b1 = true;
        this.f42311c1 = 0;
        this.f42312d1 = 0;
        this.f42313e1 = 0;
    }

    private void Ti() {
        t4.a.N().z(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi(ArrayList<PhotoCategoryControlInfo> arrayList) {
        boolean A = u4.a.z().A("photocategory_" + this.P, false);
        boolean A2 = u4.a.z().A("photocategory_data_error_" + this.P, false);
        if (QZLog.isColorLevel()) {
            QZLog.d("AlbumRecentTabFragment", 2, "Visible " + A + "; DataError " + A2);
        }
        if (A && !A2) {
            QZonePerfReporter.f59697a.j("custom", "photo_category_header");
            this.f42318v0.setVisibility(0);
            this.f42319w0.setVisibility(0);
            this.f42320x0.setVisibility(0);
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Iterator<PhotoCategoryControlInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoCategoryControlInfo next = it.next();
                if (next != null) {
                    int i3 = next.categoryType;
                    if (i3 == 1) {
                        rj(next, this.f42321y0, this.B0, this.I0, this.L0, this.F0, "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_catergory_empty_face.png");
                        this.F0 = next.categoryCounter;
                    } else if (i3 == 4) {
                        rj(next, this.A0, this.D0, this.K0, this.N0, this.H0, "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_catergory_empty_label.png");
                        this.H0 = next.categoryCounter;
                    } else if (i3 == 2) {
                        rj(next, this.f42322z0, this.C0, this.J0, this.M0, this.G0, "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_catergory_empty_poi.png");
                        this.G0 = next.categoryCounter;
                    }
                }
            }
            return;
        }
        this.f42318v0.setVisibility(8);
        this.f42319w0.setVisibility(8);
        this.f42320x0.setVisibility(8);
    }

    private void Xi(s8.b bVar) {
        if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) bVar.b();
        if (objArr.length >= 2) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                Object obj2 = objArr[1];
                if (obj2 instanceof ArrayList) {
                    this.S.r0(this.P.longValue(), (String) obj, (ArrayList) obj2, 1);
                    return;
                }
            }
        }
        if (objArr.length >= 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof ArrayList) {
                this.S.s0(this.P.longValue(), (ArrayList) obj3, 1);
            }
        }
    }

    private void Yi(s8.b bVar) {
        if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) bVar.b();
        if (objArr.length >= 3) {
            Object obj = objArr[0];
            if ((obj instanceof String) && (objArr[2] instanceof Integer)) {
                ArrayList<PhotoCacheData> x16 = ((QZonePersonalAlbumRecentAdapter) this.K).x((String) obj);
                if (x16 == null || x16.isEmpty()) {
                    return;
                }
                Iterator<PhotoCacheData> it = x16.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        r0.cmtnum--;
                    }
                }
                this.K.notifyDataSetChanged();
            }
        }
    }

    private void Zi(s8.b bVar) {
        int c16 = bVar.c();
        if (c16 == 4) {
            Xi(bVar);
            return;
        }
        if (c16 == 24) {
            if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
                return;
            }
            Object[] objArr = (Object[]) bVar.b();
            if (objArr.length >= 4) {
                Object obj = objArr[0];
                if (obj instanceof String) {
                    Object obj2 = objArr[1];
                    if ((obj2 instanceof Integer) && (objArr[2] instanceof FaceData) && (objArr[3] instanceof Integer)) {
                        gj((String) obj, ((Integer) obj2).intValue(), (FaceData) objArr[2], ((Integer) objArr[3]).intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (c16 == 31) {
            QZLog.d("recentPhotoTimeLine", 1, "EVENT_RECENT_PHOTO_AUTO_GET_MORE getMore");
            if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
                return;
            }
            Object[] objArr2 = (Object[]) bVar.b();
            if (objArr2.length >= 2) {
                Object obj3 = objArr2[0];
                if ((obj3 instanceof Integer) && (objArr2[1] instanceof s)) {
                    this.f42309a1 = ((Integer) obj3).intValue();
                    ej((s) objArr2[1]);
                    return;
                }
                return;
            }
            return;
        }
        if (c16 != 8) {
            if (c16 == 9 && bVar.b() != null && (bVar.b() instanceof Object[])) {
                Object[] objArr3 = (Object[]) bVar.b();
                if (objArr3.length >= 4) {
                    Object obj4 = objArr3[0];
                    if ((obj4 instanceof Boolean) && (objArr3[1] instanceof String) && (objArr3[2] instanceof ArrayList) && (objArr3[3] instanceof String)) {
                        fj(((Boolean) obj4).booleanValue(), (String) objArr3[1], (ArrayList) objArr3[2], (String) objArr3[3]);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (bVar.b() != null && (bVar.b() instanceof Object[])) {
            Object[] objArr4 = (Object[]) bVar.b();
            if (objArr4.length >= 1) {
                Object obj5 = objArr4[0];
                if (obj5 instanceof Integer) {
                    com.qzone.album.base.b.b(Fh(), ((Integer) obj5).intValue() != 0);
                }
            }
        }
        di();
    }

    private void bj(s8.b bVar) {
        int c16 = bVar.c();
        if (c16 == 7) {
            if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
                return;
            }
            Object[] objArr = (Object[]) bVar.b();
            if (objArr.length >= 5) {
                Object obj = objArr[0];
                if (obj instanceof String) {
                    Object obj2 = objArr[1];
                    if ((obj2 instanceof Boolean) && (objArr[2] instanceof String) && (objArr[3] instanceof Integer) && (objArr[4] instanceof Integer)) {
                        hj((String) obj, ((Boolean) obj2).booleanValue(), (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (c16 != 8) {
            if (c16 != 18) {
                if (c16 == 40) {
                    Yi(bVar);
                    return;
                }
                if (c16 != 47) {
                    if (c16 == 48 && bVar.b() != null && (bVar.b() instanceof Object[])) {
                        Object[] objArr2 = (Object[]) bVar.b();
                        if (objArr2.length >= 4) {
                            Object obj3 = objArr2[0];
                            if ((obj3 instanceof Boolean) && (objArr2[2] instanceof String) && (objArr2[3] instanceof String) && (objArr2[4] instanceof String)) {
                                jj(((Boolean) obj3).booleanValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
                return;
            }
            Object[] objArr3 = (Object[]) bVar.b();
            if (objArr3.length >= 2) {
                Object obj4 = objArr3[0];
                if (obj4 instanceof String) {
                    Object obj5 = objArr3[1];
                    if (obj5 instanceof String) {
                        AlbumCacheDataManager albumCacheDataManager = this.S;
                        long longValue = this.P.longValue();
                        albumCacheDataManager.q0(longValue, (String) obj4, (String) obj5, 1);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
            return;
        }
        Object[] objArr4 = (Object[]) bVar.b();
        if (objArr4.length >= 1) {
            Object obj6 = objArr4[0];
            if (obj6 instanceof String) {
                this.S.o0(this.P.longValue(), (String) obj6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj() {
        this.f42318v0.setVisibility(8);
        this.f42319w0.setVisibility(8);
        this.f42320x0.setVisibility(8);
    }

    private View dj() {
        int i3 = 0;
        if (this.C == null) {
            QZLog.e("AlbumRecentTabFragment", 1, "[initHeaderView] should not be null.");
            return null;
        }
        int l3 = ar.l();
        int i16 = this.Q0;
        int i17 = (l3 - (i16 * 3)) / 4;
        if (i16 * 3 > l3) {
            this.Q0 = l3 / 3;
        } else {
            i3 = i17;
        }
        View inflate = LayoutInflater.from(this.C.getHostActivity()).inflate(R.layout.bik, (ViewGroup) null);
        this.f42317u0 = inflate;
        this.f42318v0 = (RelativeLayout) inflate.findViewById(R.id.f166503fo3);
        this.f42319w0 = (RelativeLayout) inflate.findViewById(R.id.f166504fo4);
        this.f42320x0 = (RelativeLayout) inflate.findViewById(R.id.fo5);
        this.E0 = new ArrayList<>();
        NumberShiftingView numberShiftingView = (NumberShiftingView) inflate.findViewById(R.id.fnx);
        this.B0 = numberShiftingView;
        this.E0.add(numberShiftingView);
        NumberShiftingView numberShiftingView2 = (NumberShiftingView) inflate.findViewById(R.id.fny);
        this.C0 = numberShiftingView2;
        this.E0.add(numberShiftingView2);
        NumberShiftingView numberShiftingView3 = (NumberShiftingView) inflate.findViewById(R.id.fnz);
        this.D0 = numberShiftingView3;
        this.E0.add(numberShiftingView3);
        Iterator<NumberShiftingView> it = this.E0.iterator();
        while (it.hasNext()) {
            NumberShiftingView next = it.next();
            next.setmTextSize(ar.v(15.0f));
            next.setmTypeface(Typeface.DEFAULT_BOLD);
            next.B();
        }
        this.I0 = (TextView) inflate.findViewById(R.id.fo6);
        this.J0 = (TextView) inflate.findViewById(R.id.fo7);
        this.K0 = (TextView) inflate.findViewById(R.id.fo8);
        this.f42318v0.setOnClickListener(this.T0);
        this.f42319w0.setOnClickListener(this.T0);
        this.f42320x0.setOnClickListener(this.T0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f42318v0.getLayoutParams();
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = ar.e(12.0f);
        layoutParams.width = this.Q0;
        this.f42318v0.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f42318v0.getLayoutParams();
        layoutParams2.leftMargin = i3;
        layoutParams2.topMargin = ar.e(12.0f);
        layoutParams2.width = this.Q0;
        this.f42319w0.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f42318v0.getLayoutParams();
        layoutParams3.leftMargin = i3;
        layoutParams3.topMargin = ar.e(12.0f);
        layoutParams3.width = this.Q0;
        this.f42320x0.setLayoutParams(layoutParams3);
        ConcreteCombinePictureLayout concreteCombinePictureLayout = new ConcreteCombinePictureLayout(this.C.getHostActivity());
        this.f42321y0 = concreteCombinePictureLayout;
        this.f42318v0.addView(concreteCombinePictureLayout);
        ConcreteCombinePictureLayout concreteCombinePictureLayout2 = new ConcreteCombinePictureLayout(this.C.getHostActivity());
        this.f42322z0 = concreteCombinePictureLayout2;
        this.f42319w0.addView(concreteCombinePictureLayout2);
        ConcreteCombinePictureLayout concreteCombinePictureLayout3 = new ConcreteCombinePictureLayout(this.C.getHostActivity());
        this.A0 = concreteCombinePictureLayout3;
        this.f42320x0.addView(concreteCombinePictureLayout3);
        if (AlbumPersonalizeManager.L().Q()) {
            oj();
            mj();
        }
        return inflate;
    }

    private void ej(s sVar) {
        if (!this.U0 || sVar == null) {
            return;
        }
        aj(sVar);
    }

    private void gj(String str, int i3, FaceData faceData, int i16) {
        ArrayList<FaceData> arrayList;
        PhotoCacheData v3 = ((QZonePersonalAlbumRecentAdapter) this.K).v(str);
        if (v3 == null || (arrayList = v3.faceList) == null || i3 >= arrayList.size()) {
            return;
        }
        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "onEventFaceChangeResult index:", Integer.valueOf(i3), " unikey:", str, " op:", Integer.valueOf(i16));
        v3.faceList.set(i3, faceData);
    }

    private void lj() {
        t4.a.N().A(this);
    }

    private void nj() {
        NumberShiftingView numberShiftingView = this.B0;
        if (numberShiftingView != null && numberShiftingView.m() != null) {
            NumberShiftingView numberShiftingView2 = this.B0;
            AccessibilityUtil.p(numberShiftingView2, numberShiftingView2.m());
        }
        NumberShiftingView numberShiftingView3 = this.C0;
        if (numberShiftingView3 != null && numberShiftingView3.m() != null) {
            NumberShiftingView numberShiftingView4 = this.C0;
            AccessibilityUtil.p(numberShiftingView4, numberShiftingView4.m());
        }
        NumberShiftingView numberShiftingView5 = this.D0;
        if (numberShiftingView5 == null || numberShiftingView5.m() == null) {
            return;
        }
        NumberShiftingView numberShiftingView6 = this.D0;
        AccessibilityUtil.p(numberShiftingView6, numberShiftingView6.m());
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Ah() {
        t4.a.N().e(this.C.getHostActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Bh() {
        AlbumBaseTabFragment.j jVar;
        super.Bh();
        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "AlbumRecentTabFragment", " doGetMore start");
        QZLog.d("recentPhotoTimeLine", 1, "[doGetMore] mIsGetPhotoByTimeLine:", Boolean.valueOf(this.U0), " mIsInGetPhotoByTimeLine:", Boolean.valueOf(this.V0));
        if (this.U0 && !this.V0 && (jVar = this.C) != null && jVar.v1() != null) {
            if (Wi(1)) {
                f2(1, 0L, 0L);
            }
        } else if (com.qzone.album.base.b.a(Fh())) {
            this.R.j0(this.P.longValue(), AlbumBaseTabFragment.Eh(this.f42251j0, 2), this.f42256o0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Bi() {
        super.Bi();
        this.f42311c1 = this.J.getPaddingTop();
        this.f42313e1 = ar.e(50.0f);
        if (this.C != null) {
            this.J.addHeaderView(dj(), null, false);
        }
        Yh(true);
        this.f42243b0 = (ImageView) this.D.findViewById(R.id.f164282qn);
        vi("qzone_album_recent_loading_img");
        if (!AlbumPersonalizeManager.L().Q() || getActivity() == null) {
            return;
        }
        s5.a.d(this.f42243b0, getActivity(), R.drawable.nwn, ImageView.ScaleType.FIT_XY);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public int Ch() {
        return R.layout.bo9;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Ci(AbsListView absListView, int i3, int i16, int i17) {
        AlbumBaseTabFragment.j jVar = this.C;
        if (jVar == null) {
            QZLog.e("AlbumRecentTabFragment", 2, "[subOnScroll] tab operator should not be null.");
        } else {
            jVar.x0(absListView, i3, i16, i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Di(AbsListView absListView, int i3) {
        View childAt;
        super.Di(absListView, i3);
        if (getCurrentActivity() != null) {
            mc.c.f416541a.b(i3, new com.tencent.qqnt.avatar.meta.refresh.c<>(getCurrentActivity().getWindow()), "AlbumRecentTabFragment", "qzone_album_monitor_key_detail_tab_recent");
        }
        if (this.U0 && AlbumTimeLineView.g(2, this.P.longValue()) && this.J.getFirstVisiblePosition() == 0 && (childAt = this.J.getChildAt(1)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationOnScreen(iArr);
            if (iArr[1] + childAt.getHeight() >= ar.e(75.0f) + ar.e(30.0f)) {
                Ui();
            }
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public String Fh() {
        return "KEY_ALBUM_RECENTLIST_HASMORE_PRE_ALL_" + this.P + "_" + com.qzone.album.env.common.a.m().s();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Fi() {
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar == null) {
            return;
        }
        int count = cVar.getCount();
        if (count > 0) {
            if (this.U0) {
                QZLog.d("recentPhotoTimeLine", 1, "updateFooterTips | down has more:", Boolean.valueOf(AlbumTimeLineView.g(1, this.P.longValue())), " up has more:", Boolean.valueOf(AlbumTimeLineView.g(2, this.P.longValue())));
                if (AlbumTimeLineView.g(1, this.P.longValue())) {
                    ri(5);
                } else {
                    xi(count);
                }
                if (AlbumTimeLineView.g(2, this.P.longValue())) {
                    pj();
                    return;
                } else {
                    qj();
                    return;
                }
            }
            if (com.qzone.album.base.b.a(Fh())) {
                ri(5);
                return;
            } else {
                xi(count);
                return;
            }
        }
        xh();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected String Gh() {
        return "qzone_album_old_video_list";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Nh(s sVar) {
        super.Nh(sVar);
        if (sVar == null || !(sVar.getData() instanceof QzoneAlbumRecentAllPhotoRequest.a)) {
            return;
        }
        ArrayList<PhotoCategoryControlInfo> arrayList = ((QzoneAlbumRecentAllPhotoRequest.a) sVar.getData()).f43979b;
        if (arrayList != null && arrayList.size() > 0) {
            Vi(arrayList);
        }
        this.Z0 = ((QzoneAlbumRecentAllPhotoRequest.a) sVar.getData()).f43982e;
        AlbumBaseTabFragment.j jVar = this.C;
        if (jVar == null || jVar.v1() == null) {
            return;
        }
        this.C.v1().u(this.Z0);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Vh() {
        if (this.C == null) {
            return;
        }
        QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter = new QZonePersonalAlbumRecentAdapter(this.C.getHostActivity(), null, 1, null);
        this.K = qZonePersonalAlbumRecentAdapter;
        qZonePersonalAlbumRecentAdapter.c();
        ((QZonePersonalAlbumRecentAdapter) this.K).O(new AnonymousClass2());
    }

    public boolean Wi(int i3) {
        AlbumBaseTabFragment.j jVar = this.C;
        if (jVar == null || jVar.v1() == null) {
            return false;
        }
        this.C.v1();
        return AlbumTimeLineView.g(i3, this.P.longValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void Xh() {
        super.Xh();
        this.J.setOnRefreshListener(new b());
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.album.business.albumlist.fragment.d
    public void Y4(Fragment fragment, boolean z16, e eVar) {
        super.Y4(fragment, z16, eVar);
    }

    protected void aj(s sVar) {
        com.qzone.album.ui.widget.c cVar;
        Sh();
        if (sVar == null) {
            com.qzone.album.ui.widget.c cVar2 = this.f42244c0;
            if (cVar2 != null) {
                cVar2.l(5);
            }
            QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
            if (qZonePullToRefreshListView != null) {
                qZonePullToRefreshListView.l0();
            }
            ri(this.f42246e0);
            com.qzone.proxy.feedcomponent.b.c("AlbumRecentTabFragment", "resultObject is null");
            return;
        }
        di();
        if (sVar.getSucceed()) {
            if (sVar.getNewCnt() == 0) {
                pi();
            }
            QZonePullToRefreshListView qZonePullToRefreshListView2 = this.J;
            if (qZonePullToRefreshListView2 != null) {
                qZonePullToRefreshListView2.s0(getString(R.string.gm6));
            }
        } else {
            com.qzone.album.ui.widget.c cVar3 = this.f42244c0;
            if (cVar3 != null) {
                cVar3.l(5);
            }
            if (sVar.getReturnCode() == -10650 && (cVar = this.f42244c0) != null) {
                cVar.i(R.string.f171144cj1);
            }
            this.J.r0(getString(R.string.gm5), sVar.getMessage());
            ri(this.f42246e0);
        }
        xh();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, c5.a
    public boolean checkNetworkConnect() {
        return Ta();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void di() {
        if (this.C == null) {
            return;
        }
        com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment.4
            @Override // java.lang.Runnable
            public void run() {
                AlbumRecentTabFragment albumRecentTabFragment = AlbumRecentTabFragment.this;
                final ArrayList<PhotoCacheData> U = albumRecentTabFragment.S.U(albumRecentTabFragment.P.longValue());
                if (U != null) {
                    AlbumRecentTabFragment.this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumRecentTabFragment albumRecentTabFragment2 = AlbumRecentTabFragment.this;
                            albumRecentTabFragment2.W0 = ((QZonePersonalAlbumRecentAdapter) albumRecentTabFragment2.K).getCount();
                            ((QZonePersonalAlbumRecentAdapter) AlbumRecentTabFragment.this.K).Q(U, 0);
                            QZLog.i("AlbumRecentTabFragment", 2, "loadDataFromCache setAdapter count=" + ((QZonePersonalAlbumRecentAdapter) AlbumRecentTabFragment.this.K).getCount());
                            AlbumRecentTabFragment albumRecentTabFragment3 = AlbumRecentTabFragment.this;
                            albumRecentTabFragment3.X0 = ((QZonePersonalAlbumRecentAdapter) albumRecentTabFragment3.K).getCount();
                            AlbumRecentTabFragment.this.K.notifyDataSetChanged();
                            AlbumRecentTabFragment.this.Fi();
                            if (U.size() > 0) {
                                AlbumRecentTabFragment.this.Rh();
                            }
                        }
                    });
                }
                AlbumRecentTabFragment albumRecentTabFragment2 = AlbumRecentTabFragment.this;
                if (!albumRecentTabFragment2.U0) {
                    final ArrayList<PhotoCategoryControlInfo> L = albumRecentTabFragment2.S.L(albumRecentTabFragment2.P.longValue());
                    if (L != null) {
                        AlbumRecentTabFragment.this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AlbumRecentTabFragment.this.Vi(L);
                            }
                        });
                        return;
                    }
                    return;
                }
                albumRecentTabFragment2.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment.4.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumRecentTabFragment.this.kj();
                        AlbumRecentTabFragment.this.cj();
                    }
                });
            }
        });
    }

    @Override // c5.a
    public void f2(int i3, long j3, long j16) {
        if (this.C.v1() == null || this.V0) {
            return;
        }
        this.f42309a1 = i3;
        if (i3 == 0) {
            this.J.setSupportPullDown(false);
        }
        this.V0 = true;
        this.U0 = true;
        this.f42309a1 = i3;
        this.R.w0(this.P.longValue(), j3, j16, i3, this.Y0);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneAlbumCategoryDeletePhotoEvent.class);
        return arrayList;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected String getTagName() {
        return "AlbumRecentTabFragment";
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void gi() {
        super.gi();
        mj();
    }

    public void kj() {
        if (!AlbumTimeLineView.g(2, this.P.longValue())) {
            this.J.setSupportPullDown(true);
        } else {
            this.J.setSupportPullDown(false);
        }
    }

    public void oj() {
        TextView[] textViewArr = this.f42315s0;
        textViewArr[0] = this.I0;
        textViewArr[1] = this.K0;
        textViewArr[2] = this.J0;
        NumberShiftingView[] numberShiftingViewArr = this.f42316t0;
        numberShiftingViewArr[0] = this.B0;
        numberShiftingViewArr[1] = this.C0;
        numberShiftingViewArr[2] = this.D0;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.C != null) {
            this.J.removeHeaderView(this.f42317u0);
            this.J.addHeaderView(dj(), null, false);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Hh();
        this.E = 5;
        Ti();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        update();
        return onCreateView;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar != null) {
            cVar.onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        lj();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        s8.b d16 = s8.b.d(event);
        if ("WriteOperation".equals(d16.a())) {
            bj(d16);
        } else if ("QzoneAlbum".equals(d16.a())) {
            Zi(d16);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.O0 = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneAlbumCategoryDeletePhotoEvent) {
            Kh(((QZoneAlbumCategoryDeletePhotoEvent) simpleBaseEvent).deletePhotoBean, 1);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.C == null) {
            return;
        }
        this.O0 = false;
        this.P0 = true;
        this.K.notifyDataSetChanged();
        gi();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void pi() {
        com.qzone.album.ui.widget.c cVar = this.f42244c0;
        if (cVar != null) {
            cVar.l(11);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void qi(String str, String str2) {
        com.qzone.album.ui.widget.c cVar = this.f42244c0;
        if (cVar != null) {
            cVar.l(17);
            if (!TextUtils.isEmpty(str)) {
                this.f42244c0.k(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f42244c0.j(str2);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void wh() {
        if (this.J.isOverscrollHeadVisiable() || this.J.j0().getLastVisiblePosition() < this.J.j0().getCount() - 1) {
            return;
        }
        hi();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void yi() {
        vi("qzone_album_recent_loading_img");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui() {
        AlbumBaseTabFragment.j jVar;
        QZLog.d("recentPhotoTimeLine", 1, "[doOnPullUp] mIsGetPhotoByTimeLine:", Boolean.valueOf(this.U0), " mIsInGetPhotoByTimeLine:", Boolean.valueOf(this.V0));
        if (!this.U0 || this.V0 || (jVar = this.C) == null || jVar.v1() == null || !Wi(2)) {
            return;
        }
        f2(2, 0L, 0L);
        zi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void c0() {
        this.U0 = false;
        this.V0 = false;
        if (this.C == null || this.P == null) {
            return;
        }
        if (this.O0) {
            Sh();
            ri(this.f42246e0);
            QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
            if (qZonePullToRefreshListView != null) {
                qZonePullToRefreshListView.l0();
                return;
            }
            return;
        }
        super.c0();
        if (this.N != null && !TextUtils.isEmpty(t4.a.N().R(this.N))) {
            this.R.B1(this.P.longValue(), t4.a.N().Q(this.N), AlbumBaseTabFragment.Eh(this.f42251j0, 1), this.f42255n0);
        } else {
            this.R.A1(this.P.longValue(), AlbumBaseTabFragment.Eh(this.f42251j0, 1), this.f42255n0);
        }
    }

    protected void pj() {
        ti(5);
        this.f42310b1 = false;
        this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment.6
            @Override // java.lang.Runnable
            public void run() {
                QZLog.d("recentPhotoTimeLine", 1, "mDirection:", Integer.valueOf(AlbumRecentTabFragment.this.f42309a1), " mNewCount:", Integer.valueOf(AlbumRecentTabFragment.this.X0), " mOldCount:", Integer.valueOf(AlbumRecentTabFragment.this.W0), " header count:", Integer.valueOf(AlbumRecentTabFragment.this.J.getHeaderViewsCount()), " scrollBy y:", Integer.valueOf(AlbumRecentTabFragment.this.f42250i0.getHeight()));
                if (AlbumRecentTabFragment.this.f42309a1 == 2) {
                    if (AlbumRecentTabFragment.this.X0 < AlbumRecentTabFragment.this.W0) {
                        AlbumRecentTabFragment albumRecentTabFragment = AlbumRecentTabFragment.this;
                        albumRecentTabFragment.J.setSelectionFromTop(1, albumRecentTabFragment.f42250i0.getHeight());
                        return;
                    } else {
                        AlbumRecentTabFragment albumRecentTabFragment2 = AlbumRecentTabFragment.this;
                        albumRecentTabFragment2.J.setSelectionFromTop((albumRecentTabFragment2.X0 - AlbumRecentTabFragment.this.W0) + AlbumRecentTabFragment.this.J.getHeaderViewsCount(), AlbumRecentTabFragment.this.f42250i0.getHeight());
                        return;
                    }
                }
                if (AlbumRecentTabFragment.this.f42309a1 == 0) {
                    QZonePullToRefreshListView qZonePullToRefreshListView = AlbumRecentTabFragment.this.J;
                    qZonePullToRefreshListView.setSelectionFromTop(qZonePullToRefreshListView.getHeaderViewsCount(), 0);
                }
            }
        });
    }

    protected void qj() {
        ti(3);
        this.f42310b1 = true;
    }

    static {
        int e16 = ar.e(41.0f);
        f42305h1 = e16;
        f42306i1 = e16;
        f42307j1 = ar.e(5.0f);
        f42308k1 = ar.e(1.0f);
    }

    public void mj() {
        int i3 = 0;
        int i16 = 0;
        while (true) {
            TextView[] textViewArr = this.f42315s0;
            if (i16 >= textViewArr.length) {
                break;
            }
            s5.a.m(textViewArr[i16]);
            i16++;
        }
        while (true) {
            NumberShiftingView[] numberShiftingViewArr = this.f42316t0;
            if (i3 >= numberShiftingViewArr.length) {
                return;
            }
            s5.a.l(numberShiftingViewArr[i3]);
            i3++;
        }
    }

    private void hj(String str, boolean z16, String str2, int i3, int i16) {
        if (i16 != 0) {
            return;
        }
        PhotoCacheData v3 = ((QZonePersonalAlbumRecentAdapter) this.K).v(str2);
        if (v3 != null && v3.appid != 311) {
            v3.updatePhotoPraiseAndCount(z16);
            return;
        }
        PhotoCacheData u16 = ((QZonePersonalAlbumRecentAdapter) this.K).u(i3);
        if (u16 != null) {
            u16.updatePhotoPraise(z16);
            if (u16.isIndependentUgc != 0 && (u16.mylike != 1 || u16.pssHasFeedPraise)) {
                return;
            }
        }
        ArrayList<PhotoCacheData> x16 = ((QZonePersonalAlbumRecentAdapter) this.K).x(str);
        if (x16 == null || x16.isEmpty()) {
            return;
        }
        Iterator<PhotoCacheData> it = x16.iterator();
        while (it.hasNext()) {
            PhotoCacheData next = it.next();
            if (next != null) {
                next.updateFeedPraiseAndCount(z16);
            }
        }
    }

    private void ij(int i3, Intent intent) {
        if (i3 == -1 && intent.getBooleanExtra("key_photo_category_modify", false)) {
            this.O0 = false;
            c0();
        }
    }

    private void jj(boolean z16, String str, String str2, String str3) {
        if (z16) {
            PhotoCacheData w3 = ((QZonePersonalAlbumRecentAdapter) this.K).w(str, str2);
            if (w3 != null && w3.appid != 311) {
                w3.cmtnum++;
                this.K.notifyDataSetChanged();
                return;
            }
            ArrayList<PhotoCacheData> x16 = ((QZonePersonalAlbumRecentAdapter) this.K).x(str3);
            if (x16 == null || x16.isEmpty()) {
                return;
            }
            Iterator<PhotoCacheData> it = x16.iterator();
            while (it.hasNext()) {
                PhotoCacheData next = it.next();
                if (next != null) {
                    next.cmtnum++;
                }
            }
            this.K.notifyDataSetChanged();
        }
    }

    private void rj(PhotoCategoryControlInfo photoCategoryControlInfo, ConcreteCombinePictureLayout concreteCombinePictureLayout, NumberShiftingView numberShiftingView, TextView textView, String str, int i3, String str2) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = photoCategoryControlInfo.categoryCoverUrl;
        if (arrayList3 != null && arrayList3.size() > 0) {
            if (photoCategoryControlInfo.categoryCoverUrl.size() >= 3) {
                arrayList.clear();
                arrayList2.clear();
                int i16 = f42303f1;
                arrayList.add(new int[]{f42304g1, i16});
                int i17 = f42305h1;
                int i18 = f42306i1;
                arrayList.add(new int[]{i17, i18});
                arrayList.add(new int[]{i17, i18});
                arrayList2.add(photoCategoryControlInfo.categoryCoverUrl.get(0));
                arrayList2.add(photoCategoryControlInfo.categoryCoverUrl.get(1));
                arrayList2.add(photoCategoryControlInfo.categoryCoverUrl.get(2));
                concreteCombinePictureLayout.n(3, this.Q0, i16, f42308k1, this.R0, arrayList, arrayList2);
            } else if (photoCategoryControlInfo.categoryCoverUrl.size() == 2) {
                arrayList.clear();
                arrayList2.clear();
                int i19 = f42303f1;
                arrayList.add(new int[]{f42304g1, i19});
                arrayList.add(new int[]{f42305h1, i19});
                arrayList2.add(photoCategoryControlInfo.categoryCoverUrl.get(0));
                arrayList2.add(photoCategoryControlInfo.categoryCoverUrl.get(1));
                concreteCombinePictureLayout.n(2, this.Q0, i19, f42308k1, this.R0, arrayList, arrayList2);
            } else if (photoCategoryControlInfo.categoryCoverUrl.size() == 1) {
                arrayList.clear();
                arrayList2.clear();
                int i26 = f42303f1;
                arrayList.add(new int[]{this.Q0, i26});
                arrayList2.add(photoCategoryControlInfo.categoryCoverUrl.get(0));
                concreteCombinePictureLayout.n(1, this.Q0, i26, f42308k1, this.R0, arrayList, arrayList2);
            }
        } else {
            arrayList.clear();
            arrayList2.clear();
            int i27 = f42303f1;
            arrayList.add(new int[]{this.Q0, i27});
            arrayList2.add(str2);
            concreteCombinePictureLayout.n(1, this.Q0, i27, f42308k1, this.R0, arrayList, arrayList2);
        }
        if (photoCategoryControlInfo.categoryCounter > 0) {
            numberShiftingView.setVisibility(0);
            if (i3 == -1) {
                numberShiftingView.A(photoCategoryControlInfo.categoryCounter);
            } else {
                numberShiftingView.y(photoCategoryControlInfo.categoryCounter);
            }
        } else {
            numberShiftingView.setVisibility(8);
        }
        nj();
        textView.setText(str);
    }

    private void fj(boolean z16, String str, ArrayList<String> arrayList, String str2) {
        if (!z16 || arrayList == null) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            PhotoCacheData w3 = ((QZonePersonalAlbumRecentAdapter) this.K).w(str, it.next());
            if (w3 != null) {
                w3.desc = str2;
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 != 5) {
            if (i3 != 16) {
                com.qzone.proxy.feedcomponent.b.i("AlbumRecentTabFragment", "onShellActivityResult switch to default");
            } else {
                ij(i16, intent);
            }
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void ji(AdapterView<?> adapterView, View view, int i3, long j3) {
    }
}
