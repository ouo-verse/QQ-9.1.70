package com.qzone.reborn.feedx.itemview.qcircleshare;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.itemview.c;
import com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.ao;
import com.qzone.reborn.feedx.presenter.ax;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.bk;
import com.qzone.reborn.feedx.presenter.bu;
import com.qzone.reborn.feedx.presenter.ca;
import com.qzone.reborn.feedx.presenter.i;
import com.qzone.reborn.feedx.presenter.v;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.b;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import eg.f;
import java.util.ArrayList;
import java.util.List;
import xg.g;
import yo.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneQCircleShareFeedItemView extends QZoneBaseFeedItemView {
    private ax E;
    private boolean F;

    public QZoneQCircleShareFeedItemView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams C0(BusinessFeedData businessFeedData, FrameLayout.LayoutParams layoutParams) {
        ArrayList<PictureItem> arrayList;
        PictureUrl pictureUrl;
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        if (videoInfo != null && (pictureUrl = videoInfo.coverUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
            b.b(getContext(), layoutParams, videoInfo);
            return layoutParams;
        }
        if (pictureInfo != null && (arrayList = pictureInfo.pics) != null && arrayList.size() > 0 && pictureInfo.pics.get(0) != null && pictureInfo.pics.get(0).currentUrl != null) {
            b.a(getContext(), this.C, layoutParams, pictureInfo.pics.get(0).currentUrl, pl.a.f426446a.l(getContext()));
            return layoutParams;
        }
        QLog.e("QZoneQCircleShareFeedItemView", 1, "calculateLayoutParams getDefaultParams,feedsKey:", businessFeedData.getFeedCommInfo().feedskey);
        int i3 = c.f54846b;
        layoutParams.width = i3;
        layoutParams.height = (int) (i3 / 0.75f);
        return layoutParams;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfa;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneQCircleShareFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public void initView() {
        super.initView();
        ax axVar = (ax) r0(ax.class);
        this.E = axVar;
        if (axVar != null) {
            axVar.H(new a());
        }
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends vg.a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aj.class);
        arrayList.add(bu.class);
        arrayList.add(ca.class);
        arrayList.add(bk.class);
        arrayList.add(ax.class);
        arrayList.add(i.class);
        arrayList.add(bd.class);
        arrayList.add(QZoneFeedGuideBarContentPresenter.class);
        arrayList.addAll(x.f55790a.a(q0()));
        arrayList.add(ao.class);
        arrayList.add(v.class);
        return arrayList;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements QZoneSinglePicWidgetView.b {
        a() {
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
        public void a(BusinessFeedData businessFeedData, View view) {
            String str;
            VideoInfo videoInfo = businessFeedData.getVideoInfo();
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            if (videoInfo != null && !TextUtils.isEmpty(videoInfo.actionUrl)) {
                str = videoInfo.actionUrl;
            } else {
                str = pictureInfo != null ? pictureInfo.actionurl : null;
            }
            if (businessFeedData.isQCircleShareCardFeed() && businessFeedData.getVideoInfo() != null && !TextUtils.isEmpty(businessFeedData.getVideoInfo().actionUrl)) {
                g.a aVar = new g.a();
                if (view instanceof ImageView) {
                    aVar.f447951a = (ImageView) view;
                }
                f.l(businessFeedData, QZoneQCircleShareFeedItemView.this.getContext(), aVar, 0L);
                return;
            }
            d.d(str, view.getContext(), null);
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
        public boolean c() {
            return QZoneQCircleShareFeedItemView.this.F;
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
        public String b(BusinessFeedData businessFeedData) {
            ArrayList<PictureItem> arrayList;
            PictureUrl pictureUrl;
            if (businessFeedData == null) {
                return null;
            }
            VideoInfo videoInfo = businessFeedData.getVideoInfo();
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            if (videoInfo != null && (pictureUrl = videoInfo.coverUrl) != null) {
                String str = pictureUrl.url;
                QLog.d("QZoneQCircleShareFeedItemView", 2, "getImageUrl from videoUrl:", str);
                QZoneQCircleShareFeedItemView.this.F = true;
                return str;
            }
            if (pictureInfo == null || (arrayList = pictureInfo.pics) == null || arrayList.size() <= 0 || pictureInfo.pics.get(0) == null || pictureInfo.pics.get(0).currentUrl == null) {
                return null;
            }
            String str2 = pictureInfo.pics.get(0).currentUrl.url;
            QLog.d("QZoneQCircleShareFeedItemView", 2, "getImageUrl from pictureUrl:", str2);
            QZoneQCircleShareFeedItemView.this.F = false;
            return str2;
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneSinglePicWidgetView.b
        public FrameLayout.LayoutParams d(Context context, BusinessFeedData businessFeedData, FrameLayout.LayoutParams layoutParams) {
            if (businessFeedData != null && layoutParams != null) {
                return QZoneQCircleShareFeedItemView.this.C0(businessFeedData, layoutParams);
            }
            QLog.e("QZoneQCircleShareFeedItemView", 1, "getLayoutParams error feeddata or param is null");
            return null;
        }
    }
}
