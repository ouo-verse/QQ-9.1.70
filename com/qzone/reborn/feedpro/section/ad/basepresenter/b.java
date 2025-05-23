package com.qzone.reborn.feedpro.section.ad.basepresenter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.utils.aq;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010 \u001a\u00060\u001aR\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\"\u001a\u0004\b\u0013\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b;", "Lne/a;", "Landroid/view/View$OnClickListener;", "", h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "G", "H", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "getMAdPicView", "()Landroid/widget/ImageView;", "setMAdPicView", "(Landroid/widget/ImageView;)V", "mAdPicView", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b$a;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b$a;", "()Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b$a;", "setMAdFeedPicData", "(Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b$a;)V", "mAdFeedPicData", "Lyd/a;", "Lyd/a;", "()Lyd/a;", "setMAdFeedData", "(Lyd/a;)V", "mAdFeedData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class b extends ne.a implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mAdPicView;

    /* renamed from: F, reason: from kotlin metadata */
    private a mAdFeedPicData = new a();

    /* renamed from: G, reason: from kotlin metadata */
    private yd.a mAdFeedData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b$a;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "b", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;)V", "pictureUrl", "<init>", "(Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private CommonPicUrl pictureUrl = new CommonPicUrl();

        public a() {
        }

        /* renamed from: a, reason: from getter */
        public final CommonPicUrl getPictureUrl() {
            return this.pictureUrl;
        }

        public final void b(CommonPicUrl commonPicUrl) {
            Intrinsics.checkNotNullParameter(commonPicUrl, "<set-?>");
            this.pictureUrl = commonPicUrl;
        }
    }

    /* renamed from: E, reason: from getter */
    public final yd.a getMAdFeedData() {
        return this.mAdFeedData;
    }

    /* renamed from: F, reason: from getter */
    public final a getMAdFeedPicData() {
        return this.mAdFeedPicData;
    }

    public abstract void G();

    public void H() {
        CommonPicUrl pictureUrl = this.mAdFeedPicData.getPictureUrl();
        Activity activity = getActivity();
        if (activity != null) {
            aq aqVar = aq.f54314a;
            String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
            ImageView imageView = this.mAdPicView;
            aqVar.a(activity, feedUniqueKey, imageView != null ? imageView.getLayoutParams() : null, pictureUrl, pl.a.f426446a.k(activity));
        }
        String url = pictureUrl.getUrl();
        if (url == null) {
            url = "";
        }
        c.a().h(Option.obtain().setTargetView(this.mAdPicView).setNeedShowLoadingDrawable(true).setNeedShowFailedDrawable(true).setUrl(GdtUIUtils.getVaildImageUrl(url)));
        ImageView imageView2 = this.mAdPicView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        ImageView imageView3 = this.mAdPicView;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public abstract String getTAG();

    @Override // ne.a
    protected int q() {
        return R.id.f162976nn1;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        ImageView imageView = this.mAdPicView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.mAdFeedData = feedData != null ? xd.c.h(feedData) : null;
        G();
        String url = this.mAdFeedPicData.getPictureUrl().getUrl();
        if (url == null || url.length() == 0) {
            QLog.e(getTAG(), 1, "[onBindData] error,picture url is null");
        } else {
            H();
        }
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View mContainerView = getMContainerView();
        ImageView imageView = mContainerView != null ? (ImageView) mContainerView.findViewById(R.id.mvo) : null;
        this.mAdPicView = imageView;
        GdtUIUtils.setViewRadius(imageView, 2.0f);
    }
}
