package com.qzone.album.business.albumlist.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.business.albumlist.adapter.VideoRecentAdapter;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.app.ImageEnvImpl;
import com.qzone.common.event.Event;
import com.qzone.common.event.IObserver;
import com.qzone.preview.event.QZoneAlbumCategoryDeletePhotoEvent;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import yo.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumVideoTabFragment extends AlbumBaseTabFragment implements IObserver.main, SimpleEventReceiver {
    public static HashMap<Long, String> C0 = new HashMap<>(1);
    private String A0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f42340s0;

    /* renamed from: w0, reason: collision with root package name */
    private Button f42344w0;

    /* renamed from: x0, reason: collision with root package name */
    private AsyncImageView f42345x0;

    /* renamed from: y0, reason: collision with root package name */
    private ImageView f42346y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f42347z0;

    /* renamed from: r0, reason: collision with root package name */
    private final String f42339r0 = "[PhotoAlbum]AlbumVideoTabFragment";

    /* renamed from: t0, reason: collision with root package name */
    private boolean f42341t0 = true;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f42342u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f42343v0 = true;
    private boolean B0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(AlbumVideoTabFragment.this.A0)) {
                yo.d.b(AlbumVideoTabFragment.this.C.getHostActivity(), new g(AlbumVideoTabFragment.this.A0));
            }
            AlbumVideoTabFragment.this.aj(2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f42361d;

        b(View view) {
            this.f42361d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AlbumVideoTabFragment.this.J.removeHeaderView(this.f42361d);
            u4.a.z().f0("video_tab_banner_visible_" + AlbumVideoTabFragment.this.P, false);
            u4.a.z().h0("video_tab_banner_close_time_" + AlbumVideoTabFragment.this.P, String.valueOf(System.currentTimeMillis()));
            AlbumVideoTabFragment.this.aj(3);
            AlbumVideoTabFragment.this.B0 = false;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Oi() {
        t4.a.N().z(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi(final ArrayList<AlbumCacheData> arrayList, final ArrayList<PhotoCacheData> arrayList2, final int i3, final View view) {
        final boolean a16 = com.qzone.album.base.b.a(Fh());
        this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment.4
            @Override // java.lang.Runnable
            public void run() {
                t4.a.N().B(AlbumVideoTabFragment.this.C.getHostActivity(), AlbumVideoTabFragment.this.P.longValue(), arrayList, arrayList2, i3, a16, false, 2, view);
            }
        });
    }

    private void Qi(s8.b bVar) {
        if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) bVar.b();
        if (objArr.length >= 2) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                Object obj2 = objArr[1];
                if (obj2 instanceof ArrayList) {
                    this.S.r0(this.P.longValue(), (String) obj, (ArrayList) obj2, 2);
                    di();
                }
            }
        }
        if (objArr.length >= 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof ArrayList) {
                this.S.s0(this.P.longValue(), (ArrayList) obj3, 2);
            }
        }
        di();
    }

    private void Si(s8.b bVar) {
        if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) bVar.b();
        if (objArr.length >= 4) {
            Object obj = objArr[0];
            if ((obj instanceof Boolean) && (objArr[1] instanceof String) && (objArr[2] instanceof ArrayList) && (objArr[3] instanceof String)) {
                Wi(((Boolean) obj).booleanValue(), (String) objArr[1], (ArrayList) objArr[2], (String) objArr[3]);
            }
        }
    }

    private void Ti(s8.b bVar) {
        int c16 = bVar.c();
        if (c16 == 4) {
            Qi(bVar);
            return;
        }
        if (c16 == 1001) {
            di();
        } else if (c16 == 8) {
            di();
        } else {
            if (c16 != 9) {
                return;
            }
            Si(bVar);
        }
    }

    private void Ui(s8.b bVar) {
        int c16 = bVar.c();
        if (c16 == 7) {
            if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
                return;
            }
            Object[] objArr = (Object[]) bVar.b();
            if (objArr.length >= 5) {
                Object obj = objArr[0];
                if ((obj instanceof String) || obj == null) {
                    Object obj2 = objArr[1];
                    if ((obj2 instanceof Boolean) && (objArr[2] instanceof String) && (objArr[3] instanceof Integer) && (objArr[4] instanceof Integer)) {
                        Xi((String) obj, ((Boolean) obj2).booleanValue(), (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
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
                    if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
                        return;
                    }
                    Object[] objArr2 = (Object[]) bVar.b();
                    if (objArr2.length >= 4) {
                        Object obj3 = objArr2[0];
                        if ((obj3 instanceof Boolean) && (objArr2[2] instanceof String) && (objArr2[3] instanceof String) && (objArr2[4] instanceof String)) {
                            Ri(((Boolean) obj3).booleanValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (c16 != 47) {
                    if (c16 == 48 && bVar.b() != null && (bVar.b() instanceof Object[])) {
                        Object[] objArr3 = (Object[]) bVar.b();
                        if (objArr3.length >= 4) {
                            Object obj4 = objArr3[0];
                            if ((obj4 instanceof Boolean) && (objArr3[2] instanceof String) && (objArr3[3] instanceof String) && (objArr3[4] instanceof String)) {
                                Yi(((Boolean) obj4).booleanValue(), (String) objArr3[2], (String) objArr3[3], (String) objArr3[4]);
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
            Object[] objArr4 = (Object[]) bVar.b();
            if (objArr4.length >= 2) {
                Object obj5 = objArr4[0];
                if (obj5 instanceof String) {
                    Object obj6 = objArr4[1];
                    if (obj6 instanceof String) {
                        this.S.q0(this.P.longValue(), (String) obj5, (String) obj6, this.f42342u0 ? 3 : 2);
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
        Object[] objArr5 = (Object[]) bVar.b();
        if (objArr5.length >= 1) {
            Object obj7 = objArr5[0];
            if (obj7 instanceof String) {
                this.S.p0(this.P.longValue(), (String) obj7, this.f42342u0 ? 3 : 2);
            }
        }
    }

    private View Vi() {
        boolean A = u4.a.z().A("video_tab_banner_visible_" + this.P, false);
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_VIDEO_LIST_BANNER_VISIBLE, 1);
        if (!this.f42343v0 || !A || config <= 0) {
            return null;
        }
        this.f42347z0 = u4.a.z().L("video_tab_banner_img_url_" + this.P, null);
        this.A0 = u4.a.z().L("video_tab_banner_jump_url_" + this.P, null);
        View inflate = LayoutInflater.from(this.C.getHostActivity()).inflate(R.layout.bog, (ViewGroup) null);
        if (inflate == null) {
            return inflate;
        }
        this.f42345x0 = (AsyncImageView) inflate.findViewById(R.id.f167095ks3);
        this.f42346y0 = (ImageView) inflate.findViewById(R.id.f167094ks2);
        if (this.f42345x0 != null) {
            if (!TextUtils.isEmpty(this.f42347z0)) {
                ViewGroup.LayoutParams layoutParams = this.f42345x0.getLayoutParams();
                int v3 = com.qzone.album.env.common.a.m().v();
                layoutParams.width = v3;
                layoutParams.height = (v3 * 4) / 25;
                this.f42345x0.setAsyncImage(this.f42347z0);
            }
            this.f42345x0.setOnClickListener(new a());
        }
        ImageView imageView = this.f42346y0;
        if (imageView != null) {
            imageView.setOnClickListener(new b(inflate));
        }
        this.B0 = true;
        return inflate;
    }

    private void Xi(String str, boolean z16, String str2, int i3, int i16) {
        QZLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "onEventLikeResult ugcKey:" + str + " hasPraise:" + z16 + " uniKey:" + str2 + " returnCode:" + i16);
        if (i16 != 0) {
            return;
        }
        PhotoCacheData l3 = ((VideoRecentAdapter) this.K).l(str2);
        if (l3 != null && l3.appid != 311) {
            QZLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "onEventLikeResult update for uniKey !!!");
            l3.updatePhotoPraiseAndCount(z16);
            return;
        }
        PhotoCacheData k3 = ((VideoRecentAdapter) this.K).k(i3);
        if (k3 != null) {
            QZLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "onEventLikeResult update for ugcKey !!!");
            k3.updatePhotoPraise(z16);
            if (k3.isIndependentUgc != 0 && (k3.mylike != 1 || k3.pssHasFeedPraise)) {
                return;
            }
        }
        ArrayList<PhotoCacheData> n3 = ((VideoRecentAdapter) this.K).n(str);
        if (n3 == null || n3.isEmpty()) {
            return;
        }
        Iterator<PhotoCacheData> it = n3.iterator();
        while (it.hasNext()) {
            PhotoCacheData next = it.next();
            if (next != null) {
                QZLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "onEventLikeResult update for ugcKey !!!");
                next.updateFeedPraiseAndCount(z16);
            }
        }
    }

    private void Zi() {
        t4.a.N().A(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 == 1) {
            hashMap.put(QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, "1");
            QLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE);
        } else if (i3 == 2) {
            hashMap.put("click_banner", "1");
            QLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "click_banner");
        } else if (i3 == 3) {
            hashMap.put("click_close", "1");
            QLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "click_close");
        }
        if (hashMap.size() > 0) {
            QLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "videoListBannerReport begin report");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.QZONE_VIDEO_TAB_BANNER_TAG, true, 0L, 0L, hashMap, (String) null, true);
        } else {
            QLog.d("[PhotoAlbum]AlbumVideoTabFragment", 2, "videoListBannerReport no param");
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Ah() {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum]emptyViewController", "[PhotoAlbum]AlbumVideoTabFragment", " opClick");
        u4.a.z().o0(this.C.getHostActivity(), null, null, null, 10, 10, "common");
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Bh() {
        super.Bh();
        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "[PhotoAlbum]AlbumVideoTabFragment", " doGetMore start");
        if (com.qzone.album.base.b.a(Fh())) {
            if (this.f42342u0) {
                this.R.d0(this.P.longValue(), AlbumBaseTabFragment.Eh(this.f42251j0, 2), this.f42256o0);
            } else {
                this.R.o0(this.P.longValue(), AlbumBaseTabFragment.Eh(this.f42251j0, 2), this.f42256o0);
            }
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Bi() {
        super.Bi();
        if (this.C != null && !P2()) {
            this.J.addHeaderView(Vi(), null, false);
        }
        this.f42243b0 = (ImageView) this.D.findViewById(R.id.f164282qn);
        vi("qzone_album_recent_loading_img");
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public int Ch() {
        return R.layout.bo9;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Di(AbsListView absListView, int i3) {
        super.Di(absListView, i3);
        if (getCurrentActivity() != null) {
            mc.c.f416541a.b(i3, new com.tencent.qqnt.avatar.meta.refresh.c<>(getCurrentActivity().getWindow()), "[PhotoAlbum]AlbumVideoTabFragment", "qzone_album_monitor_key_detail_tab_video");
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public String Fh() {
        return "KEY_ALBUM_VIDEOLIST_HASMORE_PRE_ALL_" + this.P + "_" + com.qzone.album.env.common.a.m().s();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Fi() {
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar == null) {
            return;
        }
        int count = cVar.getCount();
        if (count > 0) {
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
        return "qzone_album_old_photo_list";
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void Vh() {
        if (this.C == null) {
            return;
        }
        VideoRecentAdapter videoRecentAdapter = new VideoRecentAdapter(this.C.getHostActivity(), null);
        this.K = videoRecentAdapter;
        videoRecentAdapter.c();
        ((VideoRecentAdapter) this.K).u(this.f42342u0);
        ((VideoRecentAdapter) this.K).w(new VideoRecentAdapter.b() { // from class: com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment.3
            @Override // com.qzone.album.business.albumlist.adapter.VideoRecentAdapter.b
            public void a(final View view, final ArrayList<PhotoCacheData> arrayList, final int i3) {
                if (AlbumVideoTabFragment.this.f42341t0) {
                    AlbumVideoTabFragment.this.f42341t0 = false;
                    if (view == null || arrayList == null || arrayList.isEmpty() || i3 < 0 || i3 >= arrayList.size()) {
                        return;
                    }
                    if (BasePhotoModelController.j3(arrayList.get(i3))) {
                        com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotSelectVideo", "\u89c6\u9891\u6b63\u5728\u8f6c\u7801,\u8bf7\u5237\u65b0\u540e\u91cd\u8bd5"));
                        AlbumVideoTabFragment.this.f42341t0 = true;
                    } else {
                        if (AlbumVideoTabFragment.this.f42251j0 == 1) {
                            com.qzone.album.env.common.a.m().P(120, AlbumVideoTabFragment.this.f42342u0 ? 2 : 1, "2", true, "");
                        } else {
                            com.qzone.album.env.common.a.m().R("326", "1", "24");
                        }
                        com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlbumVideoTabFragment albumVideoTabFragment = AlbumVideoTabFragment.this;
                                ArrayList<AlbumCacheData> T = albumVideoTabFragment.S.T(albumVideoTabFragment.P.longValue());
                                if (T == null) {
                                    T = new ArrayList<>();
                                }
                                AlbumVideoTabFragment.this.Pi(T, arrayList, i3, view);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.album.business.albumlist.fragment.d
    public void Y4(Fragment fragment, boolean z16, e eVar) {
        super.Y4(fragment, z16, eVar);
        if (z16 && (fragment instanceof AlbumVideoTabFragment) && this.B0) {
            aj(1);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void c0() {
        if (this.C == null || this.P == null) {
            return;
        }
        if (this.f42340s0) {
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
            this.R.I1(this.P.longValue(), t4.a.N().Q(this.N), AlbumBaseTabFragment.Eh(this.f42251j0, 1), this.f42255n0);
        } else if (this.f42342u0) {
            this.R.m1(this.P.longValue(), AlbumBaseTabFragment.Eh(this.f42251j0, 1), this.f42255n0);
        } else {
            this.R.H1(this.P.longValue(), AlbumBaseTabFragment.Eh(this.f42251j0, 1), this.f42255n0);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void di() {
        if (this.C == null) {
            return;
        }
        com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment.5
            @Override // java.lang.Runnable
            public void run() {
                int i3 = AlbumVideoTabFragment.this.f42342u0 ? 3 : 2;
                AlbumVideoTabFragment albumVideoTabFragment = AlbumVideoTabFragment.this;
                final ArrayList<PhotoCacheData> V = albumVideoTabFragment.S.V(albumVideoTabFragment.P.longValue(), i3);
                if (V != null) {
                    AlbumVideoTabFragment.this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((VideoRecentAdapter) AlbumVideoTabFragment.this.K).x(V);
                            QZLog.i("[PhotoAlbum]AlbumVideoTabFragment", 2, "loadDataFromCache setAdapter count=" + ((VideoRecentAdapter) AlbumVideoTabFragment.this.K).getCount());
                            AlbumVideoTabFragment.this.K.notifyDataSetChanged();
                            AlbumVideoTabFragment.this.Fi();
                            if (V.size() > 0) {
                                AlbumVideoTabFragment.this.Rh();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneAlbumCategoryDeletePhotoEvent.class);
        return arrayList;
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected String getTagName() {
        return "[PhotoAlbum]AlbumVideoTabFragment";
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    public void gi() {
        Button button;
        super.gi();
        if (AlbumPersonalizeManager.L().J() == null || AlbumPersonalizeManager.L().J().lVideoButonColor == 0 || (button = this.f42344w0) == null) {
            return;
        }
        button.setBackgroundColor((int) AlbumPersonalizeManager.L().J().lVideoButtonBgColor);
        this.f42344w0.setTextColor((int) AlbumPersonalizeManager.L().J().lVideoButonColor);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Hh();
        this.E = 5;
        Oi();
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
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Zi();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        s8.b d16 = s8.b.d(event);
        QZLog.d("[PhotoAlbum]AlbumVideoTabFragment", 1, d16.a(), ":", Integer.valueOf(d16.c()));
        if ("WriteOperation".equals(d16.a())) {
            Ui(d16);
        } else if ("QzoneAlbum".equals(d16.a())) {
            Ti(d16);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f42340s0 = true;
        ImageEnvImpl.setShouldPlayAnimWebp(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneAlbumCategoryDeletePhotoEvent) {
            Kh(((QZoneAlbumCategoryDeletePhotoEvent) simpleBaseEvent).deletePhotoBean, 2);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Button button;
        super.onResume();
        if (this.C == null) {
            return;
        }
        this.f42340s0 = false;
        this.f42341t0 = true;
        this.K.notifyDataSetChanged();
        if (AlbumPersonalizeManager.L().J() != null && AlbumPersonalizeManager.L().J().lVideoButonColor != 0 && (button = this.f42344w0) != null) {
            button.setBackgroundColor((int) AlbumPersonalizeManager.L().J().lVideoButtonBgColor);
            this.f42344w0.setTextColor((int) AlbumPersonalizeManager.L().J().lVideoButonColor);
        }
        ImageEnvImpl.setShouldPlayAnimWebp(true);
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void pi() {
        com.qzone.album.ui.widget.c cVar = this.f42244c0;
        if (cVar != null) {
            if (this.f42342u0) {
                cVar.l(25);
            } else {
                cVar.l(12);
            }
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void qi(String str, String str2) {
        com.qzone.album.ui.widget.c cVar = this.f42244c0;
        if (cVar != null) {
            cVar.l(18);
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
    protected void yi() {
        vi("qzone_album_recent_loading_img");
    }

    private void Ri(boolean z16, String str, String str2, String str3) {
        if (z16) {
            PhotoCacheData m3 = ((VideoRecentAdapter) this.K).m(str, str2);
            if (m3 != null && m3.appid != 311) {
                m3.cmtnum--;
                this.K.notifyDataSetChanged();
                return;
            }
            ArrayList<PhotoCacheData> n3 = ((VideoRecentAdapter) this.K).n(str3);
            if (n3 == null || n3.isEmpty()) {
                return;
            }
            Iterator<PhotoCacheData> it = n3.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    r2.cmtnum--;
                }
            }
            this.K.notifyDataSetChanged();
        }
    }

    private void Yi(boolean z16, String str, String str2, String str3) {
        if (z16) {
            PhotoCacheData m3 = ((VideoRecentAdapter) this.K).m(str, str2);
            if (m3 != null && m3.appid != 311) {
                m3.cmtnum++;
                this.K.notifyDataSetChanged();
                return;
            }
            ArrayList<PhotoCacheData> n3 = ((VideoRecentAdapter) this.K).n(str3);
            if (n3 == null || n3.isEmpty()) {
                return;
            }
            Iterator<PhotoCacheData> it = n3.iterator();
            while (it.hasNext()) {
                PhotoCacheData next = it.next();
                if (next != null) {
                    next.cmtnum++;
                }
            }
            this.K.notifyDataSetChanged();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 != 5) {
            QZLog.w("[PhotoAlbum]AlbumVideoTabFragment", "onShellActivityResult switch to default");
        }
        super.onActivityResult(i3, i16, intent);
    }

    private void Wi(boolean z16, String str, ArrayList<String> arrayList, String str2) {
        if (!z16 || arrayList == null) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            PhotoCacheData m3 = ((VideoRecentAdapter) this.K).m(str, it.next());
            if (m3 != null) {
                m3.desc = str2;
            }
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment
    protected void ji(AdapterView<?> adapterView, View view, int i3, long j3) {
    }
}
