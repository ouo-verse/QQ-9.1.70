package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.module.feedcomponent.ui.DataPreCalculateTool;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import java.util.ArrayList;
import java.util.UUID;
import r6.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aw extends vg.a implements gf.r, RFWTransitionHelper.TransAnimCreator {
    private QZonePicMixVideoView F;
    private QZoneVideoItemWidgetView G;
    private int H;
    private int I;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || motionEvent.getAction() != 1 || com.qzone.reborn.feedx.util.x.f55790a.c(aw.this.o())) {
                return false;
            }
            xg.d.a(((vg.a) aw.this).f441565h, ((vg.a) aw.this).C, aw.this.F);
            return false;
        }
    }

    private RFWTransAnimBean N(UUID uuid, int i3, PictureItem pictureItem) {
        ImageView p06;
        QZonePicMixVideoView qZonePicMixVideoView = this.F;
        if (qZonePicMixVideoView != null && qZonePicMixVideoView.z0() != null && this.F.z0().getChildCount() > i3) {
            View childAt = this.F.z0().getChildAt(i3);
            if (!(childAt instanceof QZoneMixBaseWidgetView) || (p06 = ((QZoneMixBaseWidgetView) childAt).p0()) == null) {
                return null;
            }
            return RFWLayerLaunchUtil.getTransAnimBean(uuid, p06, tk.h.o(pictureItem, this.f441565h), true);
        }
        return null;
    }

    private void O(View view, int i3, com.qzone.proxy.feedcomponent.model.f fVar) {
        ImageView imageView;
        if (view instanceof QZoneMixBaseWidgetView) {
            imageView = ((QZoneMixBaseWidgetView) view).p0();
            imageView.setTag(R.id.f100755tc, Integer.valueOf(this.H));
        } else {
            imageView = null;
        }
        T();
        R(fVar, imageView, i3);
    }

    private void P(View view, int i3, com.qzone.proxy.feedcomponent.model.f fVar) {
        if (this.f441565h.isFakeFeed()) {
            RFWLog.i("QZoneFeedPicMixVideoPresenter", RFWLog.USR, "fake feed do not handle over limit click");
            return;
        }
        com.qzone.reborn.feedx.util.x xVar = com.qzone.reborn.feedx.util.x.f55790a;
        if (xVar.e(o())) {
            BusinessFeedData businessFeedData = this.f441565h;
            if (businessFeedData.cellIntimateSpaceInfo == null || businessFeedData.cellPictureInfo == null) {
                return;
            }
            QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
            qZoneIntimateAlbumDetailInitBean.setSpaceId(this.f441565h.cellIntimateSpaceInfo.spaceId);
            qZoneIntimateAlbumDetailInitBean.setAlbumId(this.f441565h.cellPictureInfo.albumid);
            qZoneIntimateAlbumDetailInitBean.setBatchId(this.f441565h.cellPictureInfo.batchId);
            qZoneIntimateAlbumDetailInitBean.setSearchType(2);
            ho.i.o().q(i(), qZoneIntimateAlbumDetailInitBean);
            return;
        }
        if (!xVar.c(o())) {
            xg.d.a(this.f441565h, this.C, this.F);
        } else if (fVar.d() && M(fVar.c())) {
            U(true, fVar.c());
        } else {
            O(view, i3, fVar);
        }
    }

    private boolean Q() {
        return (v() && PictureViewerFactory.E(this.f441566i.getFeedCommInfoV2()) == 1) ? false : true;
    }

    private void R(com.qzone.proxy.feedcomponent.model.f fVar, ImageView imageView, int i3) {
        gf.i iVar = (gf.i) j(gf.i.class);
        if (iVar == null) {
            RFWLog.e("QZoneFeedPicMixVideoPresenter", RFWLog.USR, "launcher ioc is null");
        } else {
            iVar.N5(this.f441565h, this.f441566i, fVar, imageView, i3, this.C, Q());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(PictureItem pictureItem, int i3, View view) {
        boolean z16 = view instanceof QZoneMixBaseWidgetView;
        if (z16) {
            W((QZoneMixBaseWidgetView) view);
        }
        QLog.i("QZoneFeedPicMixVideoPresenter", 1, "index is " + i3);
        if (z16 && ((QZoneMixBaseWidgetView) view).s0()) {
            P(view, i3, new com.qzone.proxy.feedcomponent.model.f(0, i3, true, false));
        } else {
            O(view, i3, new com.qzone.proxy.feedcomponent.model.f(0, i3, false));
        }
    }

    private void T() {
        if (v()) {
            DataPreCalculateTool.makeUpForwardFeedInfo(this.f441565h, this.f441566i);
        }
    }

    private void U(boolean z16, boolean z17) {
        CellPictureInfo pictureInfo;
        BusinessFeedData businessFeedData = this.f441565h;
        if (z17 && businessFeedData != null) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        if (businessFeedData == null || this.C == null || (pictureInfo = businessFeedData.getPictureInfo()) == null) {
            return;
        }
        if (com.qzone.reborn.albumx.qzonex.utils.d.a()) {
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(String.valueOf(pictureInfo.uin));
            qZAlbumxAlbumDetailInitBean.setAlbumId(pictureInfo.albumid);
            qZAlbumxAlbumDetailInitBean.setAlbumName(pictureInfo.albumname);
            ho.i.x().g(this.C, qZAlbumxAlbumDetailInitBean);
            return;
        }
        int t16 = QZoneAlbumUtil.t(pictureInfo.anonymity);
        a.C11115a c11115a = new a.C11115a();
        c11115a.f430813b = pictureInfo.albumid;
        c11115a.f430812a = pictureInfo.albumname;
        c11115a.f430814c = Long.valueOf(pictureInfo.uin);
        c11115a.f430815d = t16;
        c11115a.f430816e = pictureInfo.individualAlbum;
        r6.a.D(this.C, r6.a.o().f430801d, c11115a, Boolean.valueOf(z16));
    }

    private void V(boolean z16) {
        QZoneVideoItemWidgetView qZoneVideoItemWidgetView = this.G;
        if (qZoneVideoItemWidgetView == null || qZoneVideoItemWidgetView.V0() == null) {
            return;
        }
        this.G.V0().setVisibility(z16 ? 0 : 4);
        this.G.setPlayIconVisible(z16);
    }

    private void W(QZoneMixBaseWidgetView qZoneMixBaseWidgetView) {
        if (qZoneMixBaseWidgetView instanceof QZoneVideoItemWidgetView) {
            this.G = (QZoneVideoItemWidgetView) qZoneMixBaseWidgetView;
        } else {
            this.G = null;
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (com.qzone.reborn.feedx.itemview.d.d(this.f441566i)) {
            this.F.setItemViewMultiBorderWidth((int) (com.qzone.reborn.feedx.itemview.c.f54845a * 2.0f));
        }
        this.F.setData(businessFeedData, this.f441567m);
    }

    public boolean M(boolean z16) {
        CellPictureInfo pictureInfo;
        BusinessFeedData businessFeedData = this.f441565h;
        if (z16 && businessFeedData != null) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        if (businessFeedData == null || (pictureInfo = businessFeedData.getPictureInfo()) == null) {
            return false;
        }
        int t16 = QZoneAlbumUtil.t(pictureInfo.anonymity);
        a.C11115a c11115a = new a.C11115a();
        c11115a.f430813b = pictureInfo.albumid;
        c11115a.f430812a = pictureInfo.albumname;
        c11115a.f430814c = Long.valueOf(pictureInfo.uin);
        c11115a.f430815d = t16;
        return r6.a.d(r6.a.o().f430801d, c11115a);
    }

    @Override // gf.r
    public void a() {
        QZonePicMixVideoView qZonePicMixVideoView = this.F;
        if (qZonePicMixVideoView != null) {
            qZonePicMixVideoView.a();
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        QZonePicMixVideoView qZonePicMixVideoView = this.F;
        if (qZonePicMixVideoView != null) {
            return qZonePicMixVideoView.d();
        }
        return null;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String str) {
        ArrayList<PictureItem> arrayList;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || (arrayList = this.f441565h.getPictureInfo().pics) == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PictureItem pictureItem = arrayList.get(i3);
            if (TextUtils.equals(pictureItem.lloc, str) || pictureItem.getBigUrlUniKey().equals(str)) {
                this.I = i3;
                QLog.i("QZoneFeedPicMixVideoPresenter", 1, " generateTransAnimBean data index:" + i3);
                return N(uuid, i3, pictureItem);
            }
        }
        int size = this.I > 0 ? arrayList.size() - 1 : 0;
        return N(uuid, size, arrayList.get(size));
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedPicMixVideoPresenter";
    }

    @Override // gf.r
    public void pause() {
        QZonePicMixVideoView qZonePicMixVideoView = this.F;
        if (qZonePicMixVideoView != null) {
            qZonePicMixVideoView.pause();
        }
    }

    @Override // gf.r
    public void play() {
        QZonePicMixVideoView qZonePicMixVideoView = this.F;
        if (qZonePicMixVideoView != null) {
            qZonePicMixVideoView.play();
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnv;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String str, boolean z16) {
        ArrayList<PictureItem> arrayList;
        if (TextUtils.isEmpty(str)) {
            V(z16);
            return;
        }
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || (arrayList = this.f441565h.getPictureInfo().pics) == null || arrayList.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PictureItem pictureItem = arrayList.get(i3);
            if (TextUtils.equals(pictureItem.lloc, str) || pictureItem.getBigUrlUniKey().equals(str)) {
                QLog.i("QZoneFeedPicMixVideoPresenter", 1, "data index:" + i3);
                QZonePicMixVideoView qZonePicMixVideoView = this.F;
                if (qZonePicMixVideoView != null && qZonePicMixVideoView.z0() != null && this.F.z0().getChildCount() > i3) {
                    View childAt = this.F.z0().getChildAt(i3);
                    if (childAt instanceof QZoneMixBaseWidgetView) {
                        QZoneMixBaseWidgetView qZoneMixBaseWidgetView = (QZoneMixBaseWidgetView) childAt;
                        if (qZoneMixBaseWidgetView.p0() != null) {
                            V(z16);
                            W(qZoneMixBaseWidgetView);
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    @Override // vg.a
    protected boolean x() {
        return true;
    }

    @Override // vg.a
    protected void C(View view) {
        QZonePicMixVideoView qZonePicMixVideoView = (QZonePicMixVideoView) view.findViewById(R.id.n9_);
        this.F = qZonePicMixVideoView;
        qZonePicMixVideoView.setEnableOverLimit(o() != 10);
        this.H = RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this);
        this.F.setOnItemClickListener(new QZonePicMixVideoView.c() { // from class: com.qzone.reborn.feedx.presenter.av
            @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView.c
            public final void a(PictureItem pictureItem, int i3, View view2) {
                aw.this.S(pictureItem, i3, view2);
            }
        });
        this.F.setOnEmptyTouchListener(new a());
    }
}
