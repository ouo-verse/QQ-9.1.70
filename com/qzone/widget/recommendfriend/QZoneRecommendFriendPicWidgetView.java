package com.qzone.widget.recommendfriend;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.util.m;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.qzone.widget.recommendfriend.QZoneRecommendFriendPicWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef.d;
import fo.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pl.a;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/qzone/widget/recommendfriend/QZoneRecommendFriendPicWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/tencent/mobileqq/data/MediaInfo;", "", "o0", "v0", "", "s0", "u0", "w0", "r0", "q0", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "batchData", "setBatchData", "", "getLayoutId", "objData", c.G, "p0", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivPicImage", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "tvLabelText", "i", "ivVideoPlayIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneRecommendFriendPicWidgetView extends QZoneBaseWidgetView<MediaInfo> {
    private static final int D = ImmersiveUtils.dpToPx(105.0f);
    private static final int E = ImmersiveUtils.dpToPx(2.0f);
    private static final float F = ar.d(2.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RoundCorneredFrameLayout roundLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivPicImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView tvLabelText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivVideoPlayIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MayKnowRecommend batchData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneRecommendFriendPicWidgetView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n_k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026ommend_friend_round_view)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById;
        this.roundLayout = roundCorneredFrameLayout;
        View findViewById2 = findViewById(R.id.n_d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_recommend_friend_image)");
        this.ivPicImage = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.n_l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_recommend_friend_text)");
        this.tvLabelText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.n_i);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026commend_friend_play_icon)");
        this.ivVideoPlayIcon = (ImageView) findViewById4;
        roundCorneredFrameLayout.setRadius(F);
        roundCorneredFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: gp.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneRecommendFriendPicWidgetView.n0(QZoneRecommendFriendPicWidgetView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(QZoneRecommendFriendPicWidgetView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0() {
        int o16 = ((a.f426446a.o(getContext()) - D) - (E * 3)) / 4;
        ViewGroup.LayoutParams layoutParams = this.roundLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = o16;
        }
        ViewGroup.LayoutParams layoutParams2 = this.roundLayout.getLayoutParams();
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.height = o16;
    }

    private final void q0() {
        fo.c.o(this.roundLayout, "em_qz_spatial_dynamic_region", new b().i(String.valueOf(getData().getId())).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL));
    }

    private final void r0() {
        Activity hostActivity = getHostActivity();
        MayKnowRecommend mayKnowRecommend = this.batchData;
        if (mayKnowRecommend == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchData");
            mayKnowRecommend = null;
        }
        ho.h.b(hostActivity, d.k(mayKnowRecommend.uin));
    }

    private final boolean s0() {
        return getData().getMediaType() == 1 || getData().getMediaType() == 2;
    }

    private final void u0() {
        if (s0()) {
            this.tvLabelText.setVisibility(8);
        } else {
            this.tvLabelText.setVisibility(0);
            this.tvLabelText.setText(getData().getText());
        }
    }

    private final void v0() {
        if (!s0()) {
            this.ivPicImage.setVisibility(8);
            return;
        }
        this.ivPicImage.setVisibility(0);
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(getData().getPicUrl());
        e16.setTargetView(this.ivPicImage);
        if (this.roundLayout.getLayoutParams() != null) {
            e16.setRequestWidth(this.roundLayout.getLayoutParams().width);
            e16.setRequestHeight(this.roundLayout.getLayoutParams().height);
        }
        m mVar = m.f59551a;
        e16.setLoadingDrawable(mVar.b(getContext()));
        e16.setFailedDrawable(mVar.a(getContext()));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    private final void w0() {
        this.ivVideoPlayIcon.setVisibility(getData().getMediaType() == 2 ? 0 : 8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cnu;
    }

    public final void setBatchData(MayKnowRecommend batchData) {
        Intrinsics.checkNotNullParameter(batchData, "batchData");
        this.batchData = batchData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(MediaInfo objData, int pos) {
        if (objData != null) {
            o0();
            v0();
            w0();
            u0();
            q0();
        }
    }
}
