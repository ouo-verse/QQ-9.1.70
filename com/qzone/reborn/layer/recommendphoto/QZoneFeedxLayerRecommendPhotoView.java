package com.qzone.reborn.layer.recommendphoto;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.common.activities.base.ak;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.utils.d;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.util.h;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import fo.c;
import ho.i;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes37.dex */
public class QZoneFeedxLayerRecommendPhotoView extends QZoneBaseWidgetView<QZoneFeedxLayerRecommendPhotoBean> {

    /* renamed from: d0, reason: collision with root package name */
    private static final int f58077d0 = ar.d(32.0f);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f58078e0 = ar.d(36.0f);

    /* renamed from: f0, reason: collision with root package name */
    private static final int f58079f0 = ar.d(30.0f);
    private TextView C;
    private TextView D;
    private TextView E;
    private RFWSquareImageView F;
    private RFWSquareImageView G;
    private RFWSquareImageView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private FrameLayout L;
    private FrameLayout M;
    private FrameLayout N;
    private LinearLayout P;
    private LinearLayout Q;
    private LinearLayout R;
    private RelativeLayout S;
    private Context T;
    private boolean U;
    private Boolean V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private Long f58080a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f58081b0;

    /* renamed from: c0, reason: collision with root package name */
    private final View.OnClickListener f58082c0;

    /* renamed from: e, reason: collision with root package name */
    private QZoneFeedxLayerRecommendPhotoBean f58083e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneUserAvatarView f58084f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f58085h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f58086i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f58087m;

    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null) {
                if (!QZoneFeedxLayerRecommendPhotoView.this.K0()) {
                    QZoneFeedxLayerRecommendPhotoView.this.N0(view.getContext(), view);
                } else {
                    QZoneFeedxLayerRecommendPhotoView qZoneFeedxLayerRecommendPhotoView = QZoneFeedxLayerRecommendPhotoView.this;
                    qZoneFeedxLayerRecommendPhotoView.P0(qZoneFeedxLayerRecommendPhotoView.getContext(), view);
                }
                QZoneFeedxLayerRecommendPhotoView.this.B0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AlbumCacheData f58089d;

        b(AlbumCacheData albumCacheData) {
            this.f58089d = albumCacheData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneFeedxLayerRecommendPhotoView.this.K0()) {
                QZoneFeedxLayerRecommendPhotoView.this.O0(this.f58089d, view);
            } else {
                QZoneFeedxLayerRecommendPhotoView.this.M0(this.f58089d, view);
            }
            LpReportInfo_pf00064.allReport(301, 22, 1);
            QZoneFeedxLayerRecommendPhotoView qZoneFeedxLayerRecommendPhotoView = QZoneFeedxLayerRecommendPhotoView.this;
            qZoneFeedxLayerRecommendPhotoView.F0(false, qZoneFeedxLayerRecommendPhotoView.f58083e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneFeedxLayerRecommendPhotoView(Context context) {
        super(context);
        this.f58082c0 = new a();
        this.T = context;
        J0(this);
    }

    private void A0() {
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.f58083e;
        if (qZoneFeedxLayerRecommendPhotoBean == null || qZoneFeedxLayerRecommendPhotoBean.isDataIllegal) {
            return;
        }
        if (K0() || L0()) {
            z0(this.P, 0);
            z0(this.Q, 1);
            z0(this.R, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.f58083e;
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return;
        }
        LpReportInfo_pf00064.allReport(301, 23, qZoneFeedxLayerRecommendPhotoBean.refer);
    }

    private void C0() {
        String str;
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.f58083e;
        if (qZoneFeedxLayerRecommendPhotoBean == null || qZoneFeedxLayerRecommendPhotoBean.isDataIllegal || this.S == null) {
            return;
        }
        if (K0() || L0()) {
            if (K0()) {
                str = "pg_qz_group_album_endpage";
            } else {
                str = "pg_qz_dynamic_floating_final";
            }
            c.f("em_qz_view_all_albums", str, this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K0() {
        int i3;
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.f58083e;
        return qZoneFeedxLayerRecommendPhotoBean != null && ((i3 = qZoneFeedxLayerRecommendPhotoBean.refer) == 3 || i3 == 4);
    }

    private boolean L0() {
        int i3;
        return this.f58083e != null && d.a() && ((i3 = this.f58083e.refer) == 1 || i3 == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(Context context, View view) {
        if (this.f58083e == null) {
            RFWLog.e("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "bean is null");
            return;
        }
        if (L0()) {
            c.d("em_qz_view_all_albums", "pg_qz_dynamic_floating_final", view);
        }
        vo.b.f(context, this.f58083e.albumOwnerUin, "qzone_recom_album_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(AlbumCacheData albumCacheData, View view) {
        String str;
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.f58083e;
        if (qZoneFeedxLayerRecommendPhotoBean != null) {
            long j3 = qZoneFeedxLayerRecommendPhotoBean.albumOwnerUin;
            if (j3 == 0 || albumCacheData == null) {
                return;
            }
            GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(String.valueOf(j3));
            String str2 = "";
            if (TextUtils.isEmpty(albumCacheData.albumid)) {
                str = "";
            } else {
                str = albumCacheData.albumid;
            }
            groupAlbumAlbumDetailInitBean.setAlbumId(str);
            if (!TextUtils.isEmpty(albumCacheData.albumname)) {
                str2 = albumCacheData.albumname;
            }
            groupAlbumAlbumDetailInitBean.setAlbumName(str2);
            i.m().h(getContext(), groupAlbumAlbumDetailInitBean);
            v0(albumCacheData, view, "pg_qz_group_album_endpage");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(Context context, View view) {
        if (this.f58083e == null) {
            return;
        }
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(context, "mqzone://arouse/groupalbum/homealbum?groupid=" + this.f58083e.albumOwnerUin + "&tabid=1");
        c.d("em_qz_view_all_albums", "pg_qz_group_album_endpage", view);
    }

    private void c1() {
        W0(this.I);
        W0(this.J);
        W0(this.K);
    }

    private void f1(boolean z16) {
        LinearLayout linearLayout = this.R;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(z16 ? 0 : 8);
    }

    private int y0() {
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.f58083e;
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return 0;
        }
        if (qZoneFeedxLayerRecommendPhotoBean.isDefaultStyle) {
            return ((ar.l() - f58077d0) - f58078e0) / 3;
        }
        return ((ar.l() - f58077d0) - f58079f0) / 2;
    }

    private void z0(View view, int i3) {
        String str;
        List<AlbumCacheData> list = this.f58083e.albumCacheDataList;
        if (list == null || list.size() <= i3) {
            return;
        }
        AlbumCacheData albumCacheData = list.get(i3);
        HashMap hashMap = new HashMap();
        hashMap.put("photo_album_id", albumCacheData.albumid);
        hashMap.put("photo_album_name", albumCacheData.albumname);
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (K0()) {
            str = "pg_qz_group_album_endpage";
        } else {
            str = "pg_qz_dynamic_floating_final";
        }
        c.g("em_qz_individual_album_item", str, view, hashMap);
    }

    public void S0() {
        RFWLog.i("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "recommend resume");
        F0(true, this.f58083e);
        C0();
        A0();
    }

    public void T0() {
        if (this.f58080a0 == null) {
            RFWLog.i("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "no enter action");
            return;
        }
        Boolean bool = this.V;
        if (bool != null && (!bool.booleanValue() || !this.f58081b0)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f58080a0.longValue();
            this.f58080a0 = null;
            G0(currentTimeMillis);
            return;
        }
        RFWLog.i("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "entry bean is not legal or duplicate exposure");
    }

    public void U0() {
        RFWLog.i("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "onExposureResume");
        this.f58080a0 = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfp;
    }

    private void G0(long j3) {
        RFWLog.d("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "total stay time-ms:" + j3 + ", mIsExposure:=" + this.V);
        if (this.V.booleanValue()) {
            this.f58081b0 = true;
            LpReportInfo_pf00064.allReport(301, 21, this.W, "", "", String.valueOf(j3));
        } else {
            LpReportInfo_pf00064.allReport(301, 22, this.W, "", "", String.valueOf(j3));
        }
    }

    private void D0(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null || qZoneFeedxLayerRecommendPhotoBean.isDataIllegal) {
            return;
        }
        this.V = Boolean.TRUE;
        int i3 = qZoneFeedxLayerRecommendPhotoBean.refer;
        this.W = i3;
        if (this.U) {
            return;
        }
        this.U = true;
        LpReportInfo_pf00064.allReport(301, 21, i3, "", "1");
    }

    private void E0(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null || qZoneFeedxLayerRecommendPhotoBean.isDataIllegal) {
            return;
        }
        this.V = Boolean.FALSE;
        int i3 = qZoneFeedxLayerRecommendPhotoBean.refer;
        this.W = i3;
        LpReportInfo_pf00064.allReport(301, 22, i3, "", "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(boolean z16, QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (z16) {
            D0(qZoneFeedxLayerRecommendPhotoBean);
        } else {
            E0(qZoneFeedxLayerRecommendPhotoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean, int i3) {
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            RFWLog.e("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "recommendAlbumList is null");
            return;
        }
        this.f58083e = qZoneFeedxLayerRecommendPhotoBean;
        d1(qZoneFeedxLayerRecommendPhotoBean);
        Z0(qZoneFeedxLayerRecommendPhotoBean);
        e1(qZoneFeedxLayerRecommendPhotoBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(AlbumCacheData albumCacheData, View view) {
        if (albumCacheData == null) {
            return;
        }
        if (d.a()) {
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(String.valueOf(albumCacheData.ownerUin));
            qZAlbumxAlbumDetailInitBean.setAlbumId(albumCacheData.albumid);
            qZAlbumxAlbumDetailInitBean.setAlbumName(albumCacheData.albumname);
            i.x().g(view.getContext(), qZAlbumxAlbumDetailInitBean);
            v0(albumCacheData, view, "pg_qz_dynamic_floating_final");
            return;
        }
        if (com.qzone.album.util.d.f(albumCacheData.albumrights) && !albumCacheData.allowAccess) {
            H0(albumCacheData, view);
        } else {
            I0(albumCacheData, view);
        }
    }

    private void V0(AlbumCacheData albumCacheData) {
        if (albumCacheData == null) {
            return;
        }
        int albumThemeTypeValue = albumCacheData.getAlbumThemeTypeValue();
        if (albumThemeTypeValue == 1) {
            ClickReport.r("", "", "", true, "56", "1");
        } else if (albumThemeTypeValue == 8) {
            ClickReport.r("", "", "", true, "56", "2");
        } else {
            if (albumThemeTypeValue != 9) {
                return;
            }
            ClickReport.r("", "", "", true, "56", "3");
        }
    }

    private void W0(TextView textView) {
        if (textView == null || textView.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = y0();
        textView.setLayoutParams(layoutParams);
    }

    private void X0(FrameLayout frameLayout) {
        if (frameLayout != null && (frameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = y0();
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    private void Y0(RFWSquareImageView rFWSquareImageView) {
        if (rFWSquareImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = rFWSquareImageView.getLayoutParams();
        layoutParams.width = y0();
        layoutParams.height = y0();
        rFWSquareImageView.setLayoutParams(layoutParams);
    }

    private void Z0(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null || this.f58086i == null || this.f58087m == null || this.S == null || this.f58084f == null) {
            return;
        }
        boolean z16 = qZoneFeedxLayerRecommendPhotoBean.isShowHasMoreBtn;
        if (!TextUtils.isEmpty(qZoneFeedxLayerRecommendPhotoBean.moreBtnText)) {
            this.f58086i.setText(qZoneFeedxLayerRecommendPhotoBean.moreBtnText);
        }
        this.f58086i.setVisibility(z16 ? 0 : 8);
        this.f58087m.setVisibility(z16 ? 0 : 8);
        this.S.setOnClickListener(this.f58082c0);
        this.f58084f.setOnClickListener(this.f58082c0);
    }

    private void b1(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "album title is empty");
        } else {
            textView.setText(str);
        }
    }

    private void d1(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView = this.f58084f;
        if (qZoneUserAvatarView != null && this.f58085h != null) {
            QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean2 = this.f58083e;
            if (qZoneFeedxLayerRecommendPhotoBean2 != null && qZoneFeedxLayerRecommendPhotoBean2.isShowUserIcon) {
                qZoneUserAvatarView.setIsShieldJumpToMainPage(true);
                this.f58084f.setUser(qZoneFeedxLayerRecommendPhotoBean.albumOwnerUin);
                this.f58084f.setVisibility(0);
            } else {
                qZoneUserAvatarView.setVisibility(8);
            }
            this.f58085h.setText(qZoneFeedxLayerRecommendPhotoBean.albumOwnerTitle);
            return;
        }
        RFWLog.e("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "avatar or title is null");
    }

    private void e1(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return;
        }
        List<AlbumCacheData> list = qZoneFeedxLayerRecommendPhotoBean.albumCacheDataList;
        f1(qZoneFeedxLayerRecommendPhotoBean.isDefaultStyle);
        Q0(this.P, this.F, this.L, this.C, this.I, list.get(0));
        Q0(this.Q, this.G, this.M, this.D, this.J, list.get(1));
        if (qZoneFeedxLayerRecommendPhotoBean.isDefaultStyle) {
            Q0(this.R, this.H, this.N, this.E, this.K, list.get(2));
        }
        c1();
    }

    private void H0(AlbumCacheData albumCacheData, View view) {
        if (albumCacheData == null || view == null) {
            return;
        }
        Intent H = ak.H(view.getContext(), albumCacheData.albumid, albumCacheData.albumname, Long.valueOf(albumCacheData.ownerUin), albumCacheData.albumquestion, albumCacheData.busi_param, 0, null, albumCacheData.albumtype, false);
        if (view.getContext() == null) {
            RFWLog.e("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "view context is null");
        } else {
            view.getContext().startActivity(H);
        }
    }

    private void a1(TextView textView, int i3) {
        if (textView == null) {
            return;
        }
        if (i3 <= 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(i3));
        }
    }

    private void v0(AlbumCacheData albumCacheData, View view, String str) {
        if (albumCacheData == null || view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("photo_album_id", albumCacheData.albumid);
        hashMap.put("photo_album_name", albumCacheData.albumname);
        c.e("em_qz_individual_album_item", str, view, hashMap);
    }

    private void w0(View view, AlbumCacheData albumCacheData) {
        if (view == null || albumCacheData == null) {
            return;
        }
        view.setOnClickListener(new b(albumCacheData));
    }

    public void J0(View view) {
        if (view == null) {
            return;
        }
        this.f58084f = (QZoneUserAvatarView) view.findViewById(R.id.mhq);
        this.f58085h = (TextView) view.findViewById(R.id.n98);
        this.f58086i = (TextView) view.findViewById(R.id.n97);
        this.f58087m = (ImageView) view.findViewById(R.id.n96);
        this.F = (RFWSquareImageView) view.findViewById(R.id.ndz);
        this.G = (RFWSquareImageView) view.findViewById(R.id.f162930ne0);
        this.H = (RFWSquareImageView) view.findViewById(R.id.f162931ne1);
        this.C = (TextView) view.findViewById(R.id.ndw);
        this.D = (TextView) view.findViewById(R.id.ndx);
        this.E = (TextView) view.findViewById(R.id.ndy);
        this.I = (TextView) view.findViewById(R.id.ndq);
        this.J = (TextView) view.findViewById(R.id.ndr);
        this.K = (TextView) view.findViewById(R.id.nds);
        this.L = (FrameLayout) view.findViewById(R.id.ndj);
        this.M = (FrameLayout) view.findViewById(R.id.ndk);
        this.N = (FrameLayout) view.findViewById(R.id.ndl);
        this.P = (LinearLayout) view.findViewById(R.id.ndn);
        this.Q = (LinearLayout) view.findViewById(R.id.ndo);
        this.R = (LinearLayout) view.findViewById(R.id.ndp);
        this.S = (RelativeLayout) view.findViewById(R.id.f162932ne2);
    }

    private void I0(AlbumCacheData albumCacheData, View view) {
        if (albumCacheData == null || view == null) {
            return;
        }
        BusinessAlbumInfo createFrom = BusinessAlbumInfo.createFrom(albumCacheData.albumid, albumCacheData.albumtype, albumCacheData.albumname, albumCacheData.getLloc(), albumCacheData.albumrights, albumCacheData.albumnum, albumCacheData.anonymity, albumCacheData.individual, albumCacheData.operatemask, albumCacheData.allow_share, albumCacheData.isSharingAlbumOnServer(), com.qzone.album.util.b.a(albumCacheData), albumCacheData.isSharingOwner);
        createFrom.mUin = albumCacheData.ownerUin;
        createFrom.mCover = albumCacheData.getLloc();
        createFrom.isIndividualityAlbum = albumCacheData.individual != 0;
        createFrom.sortType = albumCacheData.sortType;
        Intent I = ak.I(view.getContext(), createFrom, 0);
        if (view.getContext() == null) {
            RFWLog.e("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "view context is null");
        } else {
            view.getContext().startActivity(I);
            V0(albumCacheData);
        }
    }

    private void Q0(LinearLayout linearLayout, RFWSquareImageView rFWSquareImageView, FrameLayout frameLayout, TextView textView, TextView textView2, AlbumCacheData albumCacheData) {
        if (rFWSquareImageView == null || frameLayout == null || textView == null) {
            return;
        }
        if (albumCacheData == null) {
            RFWLog.e("QZoneFeedxLayerPhotoRecommendView", RFWLog.USR, "album cache data is null");
            return;
        }
        w0(linearLayout, albumCacheData);
        Y0(rFWSquareImageView);
        h.i(this.T, rFWSquareImageView, albumCacheData.getLloc(), y0(), y0());
        X0(frameLayout);
        a1(textView, albumCacheData.albumnum);
        b1(textView2, albumCacheData.albumname);
    }
}
