package com.qzone.reborn.feedx.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes37.dex */
public class QZoneFeedGuideBarContentPresenter extends vg.a {
    private LinearLayout F;
    private ImageView G;
    private TextView H;
    private Dialog I;
    private boolean J;

    private void K(BusinessFeedData businessFeedData, View view) {
        if (this.J) {
            return;
        }
        com.qzone.feed.utils.c.e();
        final Activity c16 = com.qzone.reborn.feedx.widget.i.c(view);
        if (c16 != null) {
            P(c16);
            this.J = true;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<PictureItem> it = businessFeedData.getPictureInfo().pics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().bigUrl.url);
        }
        com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter.1

            /* renamed from: com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter$1$a */
            /* loaded from: classes37.dex */
            class a implements u4.f {
                a() {
                }

                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void a(String str, ArrayList<String> arrayList) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (c16 == null) {
                        return;
                    }
                    QZoneFeedGuideBarContentPresenter.this.M();
                    QZoneFeedGuideBarContentPresenter.this.J = false;
                    com.qzone.util.image.c.j(arrayList);
                    qo.c.e(c16, com.qzone.util.image.c.p(c16, arrayList));
                }

                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void onDownloadFailed(String str) {
                    QZoneFeedGuideBarContentPresenter.this.M();
                    QZoneFeedGuideBarContentPresenter.this.J = false;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                u4.a.z().t(c16, System.currentTimeMillis() + "", arrayList, new a());
            }
        });
    }

    private void L(BusinessFeedData businessFeedData, View view) {
        try {
            String str = businessFeedData.getFeedCommInfoV2().clientkey;
            FakeShuoShuoDataCacheHelper.a b16 = FakeShuoShuoDataCacheHelper.b(str);
            com.qzone.proxy.feedcomponent.b.a("QZoneFeedGuideBarContentPresenter", "handlePublishQCircle, clientKey: " + str + ", shuoShuoData: " + b16);
            O(businessFeedData, view, b16);
            com.qzone.feed.utils.c.f(this.f441565h);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.j("QZoneFeedGuideBarContentPresenter", "handlePublishQCircle, error ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        Dialog dialog = this.I;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.I.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(BusinessFeedData businessFeedData, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int i3 = businessFeedData.cellAlbumEntrance.iAttr;
        if (i3 == 0) {
            K(businessFeedData, view);
        } else if (i3 == 2) {
            L(businessFeedData, view);
        } else if (!TextUtils.isEmpty(str)) {
            yo.d.e(str, view.getContext(), null, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void P(Activity activity) {
        if (this.I == null) {
            this.I = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        if (activity.isFinishing()) {
            return;
        }
        this.I.show();
    }

    @Override // vg.a
    protected void A(final BusinessFeedData businessFeedData) {
        CellAlbumEntrance cellAlbumEntrance;
        LinearLayout linearLayout = this.F;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
        if (businessFeedData == null || (cellAlbumEntrance = businessFeedData.cellAlbumEntrance) == null) {
            return;
        }
        String str = cellAlbumEntrance.guideIcon;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setTargetView(this.G), null);
        String str2 = cellAlbumEntrance.guideTitle;
        if (TextUtils.isEmpty(str2) || businessFeedData.cellAlbumEntrance.iAttr == 2) {
            return;
        }
        this.H.setText(str2);
        this.F.setVisibility(0);
        final String str3 = cellAlbumEntrance.guideUrl;
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedGuideBarContentPresenter.this.N(businessFeedData, str3, view);
            }
        });
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedGuideBarContentPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnl;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void O(BusinessFeedData businessFeedData, View view, FakeShuoShuoDataCacheHelper.a aVar) {
        String str;
        if (businessFeedData == null) {
            QZLog.i("QZoneFeedGuideBarContentPresenter", 1, "onPublishQCircleClick, businessData is null");
            return;
        }
        CellAlbumEntrance cellAlbumEntrance = businessFeedData.cellAlbumEntrance;
        String str2 = "";
        if (cellAlbumEntrance == null) {
            str = "";
        } else {
            str = cellAlbumEntrance.guideUrl;
        }
        QZLog.d("QZoneFeedGuideBarContentPresenter", 1, "onPublishQCircleClick, args: " + aVar + ", schema: " + str);
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        List<String> a16 = aVar.a();
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 311 && businessFeedData.getCellSummaryV2() != null) {
            str2 = businessFeedData.getCellSummaryV2().summary;
        }
        qo.c.d(view.getContext(), str, new ArrayList(a16), str2);
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (LinearLayout) view.findViewById(R.id.f162737k94);
        this.G = (ImageView) view.findViewById(R.id.l7a);
        this.H = (TextView) view.findViewById(R.id.nix);
    }
}
