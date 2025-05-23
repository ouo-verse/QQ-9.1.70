package com.qzone.album.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumExData;
import com.qzone.album.ui.widget.a;
import com.qzone.util.ar;
import com.qzone.widget.AvatarImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes39.dex */
public class AlbumRecomGalleryPage extends LinearLayout {
    private int C;
    private int D;
    private int E;
    private RelativeLayout F;
    private RelativeLayout G;
    IAlbumRecommendAdvController H;
    public b I;
    public IAdVideoViewController J;
    public AlumBasicData K;

    /* renamed from: d, reason: collision with root package name */
    private a.c f44133d;

    /* renamed from: e, reason: collision with root package name */
    private List<com.qzone.album.ui.widget.a> f44134e;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f44135f;

    /* renamed from: h, reason: collision with root package name */
    protected AvatarImageView f44136h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f44137i;

    /* renamed from: m, reason: collision with root package name */
    private int f44138m;

    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b bVar = AlbumRecomGalleryPage.this.I;
            if (bVar != null) {
                bVar.onClicked(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public interface b {
        void onClicked(View view);
    }

    public AlbumRecomGalleryPage(Context context) {
        super(context);
        this.f44135f = new Rect();
        this.f44138m = -1;
        this.C = 1;
        this.D = 1;
        this.E = 1;
        this.K = null;
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.biq, (ViewGroup) null);
        this.f44136h = (AvatarImageView) inflate.findViewById(R.id.hqg);
        this.f44137i = (TextView) inflate.findViewById(R.id.hqf);
        this.f44136h.setSelector(R.drawable.ara);
        this.F = (RelativeLayout) inflate.findViewById(R.id.hnm);
        this.G = (RelativeLayout) inflate.findViewById(R.id.hnl);
        this.f44137i.setTextColor(-1);
        this.F.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, ar.e(15.0f) + (context instanceof Activity ? SystemUtil.getNotchHeight(context, (Activity) context) : 0), 0, ar.e(15.0f));
        inflate.setLayoutParams(layoutParams);
        addView(inflate);
    }

    public void d() {
        IAlbumRecommendAdvController iAlbumRecommendAdvController;
        IAdVideoViewController iAdVideoViewController;
        AlumBasicData alumBasicData = this.K;
        if (alumBasicData != null && alumBasicData.isVideoAdvType() && (iAdVideoViewController = this.J) != null) {
            iAdVideoViewController.onPause();
        }
        AlumBasicData alumBasicData2 = this.K;
        if (alumBasicData2 == null || !alumBasicData2.isPicAdvType() || (iAlbumRecommendAdvController = this.H) == null) {
            return;
        }
        iAlbumRecommendAdvController.onPause();
    }

    public void e() {
        IAlbumRecommendAdvController iAlbumRecommendAdvController;
        IAdVideoViewController iAdVideoViewController;
        AlumBasicData alumBasicData = this.K;
        if (alumBasicData != null && alumBasicData.isVideoAdvType() && (iAdVideoViewController = this.J) != null) {
            iAdVideoViewController.onResume();
        }
        AlumBasicData alumBasicData2 = this.K;
        if (alumBasicData2 == null || !alumBasicData2.isPicAdvType() || (iAlbumRecommendAdvController = this.H) == null) {
            return;
        }
        iAlbumRecommendAdvController.onResume();
    }

    public void f(float f16, float f17) {
        List<com.qzone.album.ui.widget.a> list = this.f44134e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (com.qzone.album.ui.widget.a aVar : this.f44134e) {
            ArrayList<View> f18 = aVar.f();
            if (f18 != null && f18.size() != 0) {
                Iterator<View> it = f18.iterator();
                while (it.hasNext()) {
                    View next = it.next();
                    if (c(next, f16, f17)) {
                        aVar.i(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IAlbumRecommendAdvController iAlbumRecommendAdvController = this.H;
        if (iAlbumRecommendAdvController != null) {
            iAlbumRecommendAdvController.onDestroy();
        }
        IAdVideoViewController iAdVideoViewController = this.J;
        if (iAdVideoViewController != null) {
            iAdVideoViewController.onDestroy();
        }
        super.onDetachedFromWindow();
    }

    public void setAdvData(AlumBasicData alumBasicData) {
        this.K = alumBasicData;
        if (alumBasicData.isPicAdvType()) {
            IAlbumRecommendAdvController iAlbumRecommendAdvController = this.H;
            if (iAlbumRecommendAdvController != null) {
                iAlbumRecommendAdvController.initAndRenderData(alumBasicData);
            }
            IAdVideoViewController iAdVideoViewController = this.J;
            if (iAdVideoViewController != null) {
                iAdVideoViewController.setVideoDataChanged(null, -1);
                return;
            }
            return;
        }
        if (alumBasicData.isVideoAdvType()) {
            IAlbumRecommendAdvController iAlbumRecommendAdvController2 = this.H;
            if (iAlbumRecommendAdvController2 != null) {
                iAlbumRecommendAdvController2.hideAdView();
            }
            IAdVideoViewController iAdVideoViewController2 = this.J;
            if (iAdVideoViewController2 != null) {
                iAdVideoViewController2.setVideoDataChanged(alumBasicData, 103);
            }
        }
    }

    public void setRecomAlbumClickListener(a.c cVar) {
        this.f44133d = cVar;
    }

    public void setRecomHasMoreClickListener(b bVar) {
        this.I = bVar;
    }

    public void setUpView(Context context, int i3) {
        b();
        if (this.f44134e == null) {
            this.f44134e = new ArrayList();
        }
        this.f44134e.clear();
        a(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ScrollView scrollView = new ScrollView(context);
        for (int i16 = 0; i16 < i3; i16++) {
            com.qzone.album.ui.widget.a aVar = new com.qzone.album.ui.widget.a(this.f44138m, context, R.layout.bip, this.C, this.D, this.E, this.f44133d);
            linearLayout.addView(aVar.h());
            this.f44134e.add(aVar);
        }
        QZLog.i("AlbumRecomGalleryPage", " @getGdtInfo setUpView");
        IVasQZoneApi iVasQZoneApi = (IVasQZoneApi) QRoute.api(IVasQZoneApi.class);
        IAlbumRecommendAdvController createAlbumAdvViewController = iVasQZoneApi.createAlbumAdvViewController(context, linearLayout);
        this.H = createAlbumAdvViewController;
        linearLayout.addView(createAlbumAdvViewController.getView());
        IAdVideoViewController createAdVideoViewController = iVasQZoneApi.createAdVideoViewController(context);
        this.J = createAdVideoViewController;
        createAdVideoViewController.initStubView(linearLayout);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.H.setOutActivity(activity);
            this.J.setOutActivity(activity);
        }
        linearLayout.addView(this.J.getView());
        scrollView.addView(linearLayout);
        scrollView.requestDisallowInterceptTouchEvent(true);
        addView(scrollView);
    }

    private void b() {
        this.f44138m = 1;
        this.C = ar.l();
        this.D = ar.e(2.0f);
        this.E = ar.e(2.0f);
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.C, ar.k() - ar.e(10.0f));
        layoutParams.topMargin = ar.d(42.0f);
        setLayoutParams(layoutParams);
    }

    public void setData(List<AlbumCacheData[]> list, List<RecomAlbumExData> list2, boolean z16) {
        RelativeLayout relativeLayout;
        if (list == null || list.size() != this.f44134e.size() || list2 == null || list.size() == 0) {
            return;
        }
        for (int i3 = 0; i3 < this.f44134e.size(); i3++) {
            this.f44134e.get(i3).e(list.get(i3), list2.get(i3));
        }
        if (list.get(0)[0].ownerUin != 0 && list.get(0)[0].albumOwner != null && !TextUtils.isEmpty(list.get(0)[0].albumOwner)) {
            this.f44136h.j(list.get(0)[0].ownerUin);
            this.f44137i.setText(list.get(0)[0].albumOwner);
        }
        if (!z16 || (relativeLayout = this.F) == null || this.G == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        this.G.setOnClickListener(new a());
    }

    private boolean c(View view, float f16, float f17) {
        if (view == null) {
            return false;
        }
        view.getGlobalVisibleRect(this.f44135f);
        return this.f44135f.contains((int) f16, (int) f17);
    }

    public AlbumRecomGalleryPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44135f = new Rect();
        this.f44138m = -1;
        this.C = 1;
        this.D = 1;
        this.E = 1;
        this.K = null;
    }
}
