package com.qzone.reborn.feedx.widget.eventtag;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.util.d;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import tl.h;
import xg.e;
import ze.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002=>B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108B\u001b\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b7\u0010;J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0014J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0014J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroidx/lifecycle/Observer;", "Laf/c;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "s0", "q0", "p0", "m0", "n0", "u0", "", "getLayoutId", NodeProps.ON_ATTACHED_TO_WINDOW, "feedData", c.G, "o0", "likeInfoBean", "v0", "r0", NodeProps.ON_CLICK, "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mContentView", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mCommentLikeArea", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mUserAvatarView", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mNickNameView", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mPraiseView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mBottomLikeNumView", "Lxg/e;", "D", "Lxg/e;", "mLikeClickProcess", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneEventTagItemBottomView extends QZoneBaseWidgetView<BusinessFeedData> implements Observer<af.c>, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mBottomLikeNumView;

    /* renamed from: D, reason: from kotlin metadata */
    private e mLikeClickProcess;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mCommentLikeArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mUserAvatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView mNickNameView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mPraiseView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Lmqq/util/WeakReference;", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "a", "Lmqq/util/WeakReference;", "mWeakReference", "view", "<init>", "(Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZoneEventTagItemBottomView> mWeakReference;

        public b(QZoneEventTagItemBottomView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mWeakReference = new WeakReference<>(view);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            CellLikeInfo likeInfo;
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap hashMap = new HashMap();
            QZoneEventTagItemBottomView qZoneEventTagItemBottomView = this.mWeakReference.get();
            if (qZoneEventTagItemBottomView != null) {
                BusinessFeedData data = qZoneEventTagItemBottomView.getData();
                boolean z16 = false;
                if (data != null && (likeInfo = data.getLikeInfo()) != null && likeInfo.isLiked) {
                    z16 = true;
                }
                hashMap.put("after_click_state", Integer.valueOf(z16 ? 1 : 2));
            }
            return hashMap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagItemBottomView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mub);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_bottom_content)");
        this.mContentView = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.muu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_like_area)");
        this.mCommentLikeArea = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.mua);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_bottom_avatar)");
        this.mUserAvatarView = (QZoneUserAvatarView) findViewById3;
        View findViewById4 = findViewById(R.id.mue);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026ent_tag_bottom_nike_name)");
        this.mNickNameView = (QZoneNickNameView) findViewById4;
        View findViewById5 = findViewById(R.id.muc);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_event_tag_bottom_like)");
        this.mPraiseView = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.mud);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_event_tag_bottom_like_num)");
        this.mBottomLikeNumView = (TextView) findViewById6;
        this.mCommentLikeArea.setOnClickListener(this);
    }

    private final void m0() {
        String a16;
        if (getData().getLikeInfo() == null) {
            RFWLog.e("QZoneEventTagItemBottomView", RFWLog.USR, "[bindBottomLikeNum] likeInfo = null");
            return;
        }
        if (getData().isFakeFeed()) {
            this.mPraiseView.setAlpha(0.3f);
            this.mPraiseView.setEnabled(false);
            this.mPraiseView.setSelected(false);
            return;
        }
        this.mPraiseView.setEnabled(true);
        this.mPraiseView.setAlpha(1.0f);
        this.mPraiseView.setVisibility(0);
        this.mPraiseView.setSelected(getData().getLikeInfo().isLiked);
        ImageView imageView = this.mPraiseView;
        if (imageView.isSelected()) {
            a16 = l.a(R.string.f2202468l);
        } else {
            a16 = l.a(R.string.f2202368k);
        }
        AccessibilityUtil.s(imageView, a16);
        r0();
    }

    private final void n0() {
        if (getData().getLikeInfo() == null) {
            this.mBottomLikeNumView.setVisibility(8);
            RFWLog.e("QZoneEventTagItemBottomView", RFWLog.USR, "[bindBottomLikeNum] likeInfo = null");
            return;
        }
        CellLikeInfo likeInfo = getData().getLikeInfo();
        Intrinsics.checkNotNull(likeInfo);
        if (likeInfo.likeNum > 0) {
            this.mBottomLikeNumView.setVisibility(0);
            TextView textView = this.mBottomLikeNumView;
            CellLikeInfo likeInfo2 = getData().getLikeInfo();
            Intrinsics.checkNotNull(likeInfo2);
            textView.setText(String.valueOf(d.l(likeInfo2.likeNum)));
            return;
        }
        this.mBottomLikeNumView.setVisibility(8);
    }

    private final void p0() {
        this.mNickNameView.setClickEnable(false);
        this.mNickNameView.setRichText(getData().getUser().nickName);
    }

    private final void q0() {
        this.mUserAvatarView.setIsShieldJumpToMainPage(true);
        this.mUserAvatarView.setUser(getData().getUser().uin);
    }

    private final void u0() {
        String a16;
        if (getData() != null && getData().getLikeInfo() != null) {
            if (this.mLikeClickProcess == null) {
                this.mLikeClickProcess = new e();
            }
            if (com.qzone.reborn.feedx.util.l.a("QZoneEventTagItemBottomViewhandleClickPraiseView")) {
                return;
            }
            if (!(getContext() instanceof Activity)) {
                RFWLog.e("QZoneEventTagItemBottomView", RFWLog.USR, "[handleClickPraiseView] context is not activity");
                return;
            }
            e eVar = this.mLikeClickProcess;
            if (eVar != null) {
                BusinessFeedData data = getData();
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                eVar.a(data, (Activity) context);
            }
            ImageView imageView = this.mPraiseView;
            if (imageView.isSelected()) {
                a16 = l.a(R.string.f2202468l);
            } else {
                a16 = l.a(R.string.f2202368k);
            }
            AccessibilityUtil.s(imageView, a16);
            return;
        }
        RFWLog.e("QZoneEventTagItemBottomView", RFWLog.USR, "[handleClickPraiseView] likeInfo = null");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.a_3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData feedData, int pos) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        q0();
        p0();
        m0();
        n0();
        if (TextUtils.isEmpty(ef.b.a(feedData))) {
            return;
        }
        a.a().observerGlobalState(new af.c(ef.b.a(feedData), feedData.cellLikeInfo), this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0(this.mCommentLikeArea);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.muu) {
            u0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void r0() {
        fo.c.o(this.mCommentLikeArea, "em_qz_like", new fo.b().h(new b(this)).i(getData().getFeedCommInfo().feedsid).j(EndExposurePolicy.REPORT_NONE));
    }

    private final void s0(View view) {
        int dpToPx = ImmersiveUtils.dpToPx(10.0f);
        QZoneFeedxViewUtils.a(view, dpToPx, dpToPx, dpToPx, dpToPx);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.c likeInfoBean) {
        if (likeInfoBean == null || !TextUtils.equals(likeInfoBean.a(), ef.b.a(getData()))) {
            return;
        }
        getData().cellLikeInfo = likeInfoBean.b();
        m0();
        n0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagItemBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mub);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_bottom_content)");
        this.mContentView = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.muu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_like_area)");
        this.mCommentLikeArea = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.mua);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_bottom_avatar)");
        this.mUserAvatarView = (QZoneUserAvatarView) findViewById3;
        View findViewById4 = findViewById(R.id.mue);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026ent_tag_bottom_nike_name)");
        this.mNickNameView = (QZoneNickNameView) findViewById4;
        View findViewById5 = findViewById(R.id.muc);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_event_tag_bottom_like)");
        this.mPraiseView = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.mud);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_event_tag_bottom_like_num)");
        this.mBottomLikeNumView = (TextView) findViewById6;
        this.mCommentLikeArea.setOnClickListener(this);
    }
}
