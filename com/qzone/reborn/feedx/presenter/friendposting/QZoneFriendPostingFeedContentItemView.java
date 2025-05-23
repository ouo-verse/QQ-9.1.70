package com.qzone.reborn.feedx.presenter.friendposting;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.extend.AlphaGradientProcessor;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.j;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ak;
import com.qzone.widget.AsyncImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import fo.b;
import ho.i;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001CB\u000f\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0010H\u0014J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0018\u00103\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006D"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/friendposting/QZoneFriendPostingFeedContentItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/proxy/feedcomponent/model/j$a;", "Landroid/view/View$OnClickListener;", "", "o0", "r0", "s0", "u0", "v0", "w0", "Landroid/view/View;", "view", "", "onlyReportClick", "p0", "", "actionId", "q0", "", WadlProxyConsts.KEY_JUMP_URL, "n0", "getLayoutId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "setFeedData", "objData", c.G, "m0", "v", NodeProps.ON_CLICK, "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mContainerView", "Lcom/qzone/widget/AsyncImageView;", "f", "Lcom/qzone/widget/AsyncImageView;", "mIvContentBackground", h.F, "mIvLogo", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mTvName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTvSubTitle", BdhLogUtil.LogTag.Tag_Conn, "mBtnPlayTogether", "D", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "E", "Lcom/qzone/proxy/feedcomponent/model/j$a;", "mCardData", "Landroid/app/Activity;", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", "mActivity", "G", "I", "mFeedPos", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFriendPostingFeedContentItemView extends QZoneBaseWidgetView<j.a> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mBtnPlayTogether;

    /* renamed from: D, reason: from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: E, reason: from kotlin metadata */
    private j.a mCardData;

    /* renamed from: F, reason: from kotlin metadata */
    private Activity mActivity;

    /* renamed from: G, reason: from kotlin metadata */
    private int mFeedPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mContainerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AsyncImageView mIvContentBackground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AsyncImageView mIvLogo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTvName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTvSubTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFriendPostingFeedContentItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        o0();
    }

    private final void n0(String jumpUrl) {
        if (this.mActivity == null) {
            QLog.e("QZoneFriendPostingFeedContentItemView", 1, "mActivity is null");
        } else if (TextUtils.isEmpty(jumpUrl)) {
            QLog.e("QZoneFriendPostingFeedContentItemView", 1, "jumpUrl is null");
        } else {
            i.q(this.mActivity, jumpUrl);
            q0(102);
        }
    }

    private final void p0(View view, boolean onlyReportClick) {
        ExposurePolicy exposurePolicy;
        if (this.mCardData == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        j.a aVar = this.mCardData;
        Intrinsics.checkNotNull(aVar);
        String title = aVar.getTitle();
        if (title == null) {
            title = "";
        }
        linkedHashMap.put("play_card_name", title);
        b bVar = new b();
        bVar.l(linkedHashMap);
        j.a aVar2 = this.mCardData;
        Intrinsics.checkNotNull(aVar2);
        String adId = aVar2.getAdId();
        bVar.i(adId != null ? adId : "");
        if (onlyReportClick) {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        } else {
            exposurePolicy = ExposurePolicy.REPORT_ALL;
        }
        bVar.k(exposurePolicy);
        bVar.j(EndExposurePolicy.REPORT_NONE);
        bVar.g(ClickPolicy.REPORT_ALL);
        fo.c.o(view, "em_qz_friend_publish_card", bVar);
    }

    private final void q0(int actionId) {
        j.a aVar = this.mCardData;
        String adId = aVar != null ? aVar.getAdId() : null;
        j.a aVar2 = this.mCardData;
        String str = aVar2 != null ? aVar2.getCom.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO java.lang.String() : null;
        if (!TextUtils.isEmpty(adId) && !TextUtils.isEmpty(str)) {
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.b(actionId, adId, str));
            return;
        }
        QLog.e("QZoneFriendPostingFeedContentItemView", 1, "[reportItemTianShu] adId:" + adId + " | traceInfo" + str);
    }

    private final void r0() {
        PictureItem pictureItem;
        j.a aVar = this.mCardData;
        AsyncImageView asyncImageView = null;
        PictureUrl pictureUrl = (aVar == null || (pictureItem = aVar.getPictureItem()) == null) ? null : pictureItem.currentUrl;
        if (pictureUrl == null) {
            QLog.e("QZoneFriendPostingFeedContentItemView", 1, "[updateBackground] currentUrl is null");
            return;
        }
        if (TextUtils.isEmpty(pictureUrl.url)) {
            QLog.e("QZoneFriendPostingFeedContentItemView", 1, "[updateBackground] background url is null");
            return;
        }
        AsyncImageView asyncImageView2 = this.mIvContentBackground;
        if (asyncImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvContentBackground");
            asyncImageView2 = null;
        }
        asyncImageView2.setAsyncImageProcessor(new AlphaGradientProcessor());
        AsyncImageView asyncImageView3 = this.mIvContentBackground;
        if (asyncImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvContentBackground");
        } else {
            asyncImageView = asyncImageView3;
        }
        asyncImageView.setAsyncImage(pictureUrl.imageUrl, pictureUrl.url);
    }

    private final void s0() {
        PictureItem pictureItem;
        j.a aVar = this.mCardData;
        AsyncImageView asyncImageView = null;
        PictureUrl pictureUrl = (aVar == null || (pictureItem = aVar.getPictureItem()) == null) ? null : pictureItem.currentUrl;
        if (pictureUrl == null) {
            QLog.e("QZoneFriendPostingFeedContentItemView", 1, "[updateLogo] currentUrl is null");
            return;
        }
        if (TextUtils.isEmpty(pictureUrl.url)) {
            QLog.e("QZoneFriendPostingFeedContentItemView", 1, "[updateLogo] logo url is null");
            return;
        }
        AsyncImageView asyncImageView2 = this.mIvLogo;
        if (asyncImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvLogo");
        } else {
            asyncImageView = asyncImageView2;
        }
        asyncImageView.setAsyncImage(pictureUrl.imageUrl, pictureUrl.url);
    }

    private final void u0() {
        TextView textView = this.mTvName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView = null;
        }
        j.a aVar = this.mCardData;
        textView.setText(aVar != null ? aVar.getTitle() : null);
    }

    private final void v0() {
        TextView textView = this.mTvSubTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSubTitle");
            textView = null;
        }
        j.a aVar = this.mCardData;
        textView.setText(aVar != null ? aVar.getSummary() : null);
    }

    private final void w0() {
        TextView textView = this.mBtnPlayTogether;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPlayTogether");
            textView = null;
        }
        j.a aVar = this.mCardData;
        textView.setText(aVar != null ? aVar.getButtonText() : null);
        TextView textView3 = this.mBtnPlayTogether;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPlayTogether");
        } else {
            textView2 = textView3;
        }
        p0(textView2, true);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.c38;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.n9f) {
            j.a aVar = this.mCardData;
            n0(aVar != null ? aVar.getButtonJump() : null);
        } else if (id5 == R.id.n9h) {
            j.a aVar2 = this.mCardData;
            n0(aVar2 != null ? aVar2.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String() : null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setFeedData(BusinessFeedData feedData) {
        this.mFeedData = feedData;
    }

    private final void o0() {
        View findViewById = findViewById(R.id.n9h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_post_content_container)");
        this.mContainerView = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.n9g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_post_content_background)");
        this.mIvContentBackground = (AsyncImageView) findViewById2;
        View findViewById3 = findViewById(R.id.n9i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_post_content_logo)");
        this.mIvLogo = (AsyncImageView) findViewById3;
        View findViewById4 = findViewById(R.id.n9j);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_post_content_name)");
        this.mTvName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.n9k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_post_content_subtitle)");
        this.mTvSubTitle = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.n9f);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_play_together_btn)");
        this.mBtnPlayTogether = (TextView) findViewById6;
        FrameLayout frameLayout = this.mContainerView;
        AsyncImageView asyncImageView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainerView");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(this);
        TextView textView = this.mBtnPlayTogether;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPlayTogether");
            textView = null;
        }
        textView.setOnClickListener(this);
        AsyncImageView asyncImageView2 = this.mIvContentBackground;
        if (asyncImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvContentBackground");
            asyncImageView2 = null;
        }
        asyncImageView2.setCornerRadius(8.0f);
        AsyncImageView asyncImageView3 = this.mIvLogo;
        if (asyncImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvLogo");
        } else {
            asyncImageView = asyncImageView3;
        }
        asyncImageView.setCornerRadius(8.0f);
        this.mActivity = com.qzone.reborn.feedx.widget.i.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(j.a objData, int pos) {
        if (objData == null) {
            return;
        }
        if (objData == this.mCardData && pos == this.mFeedPos) {
            return;
        }
        this.mFeedPos = pos;
        this.mCardData = objData;
        r0();
        s0();
        u0();
        v0();
        w0();
        FrameLayout frameLayout = this.mContainerView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainerView");
            frameLayout = null;
        }
        p0(frameLayout, false);
        q0(101);
    }
}
