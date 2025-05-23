package com.qzone.reborn.feedpro.layer.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0018\u0010 \u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0018\u0010$\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/g;", "Lcom/qzone/reborn/feedpro/layer/part/c;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G9", "I9", "H9", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Lp9/a;", "i", "Lp9/a;", "getOperateConfig", "()Lp9/a;", "operateConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "footerView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "commentNum", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "commentIcon", "E", "praiseNum", UserInfo.SEX_FEMALE, "praiseIcon", "G", "shareMoreIcon", "H", "commentInputTv", "<init>", "(Lp9/a;)V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends c {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView commentNum;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView commentIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView praiseNum;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView praiseIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView shareMoreIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView commentInputTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final p9.a operateConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View footerView;

    public g(p9.a operateConfig) {
        Intrinsics.checkNotNullParameter(operateConfig, "operateConfig");
        this.operateConfig = operateConfig;
    }

    private final void H9() {
        boolean isSupportComment = this.operateConfig.getIsSupportComment();
        TextView textView = this.commentNum;
        if (textView != null) {
            textView.setVisibility(isSupportComment ? 0 : 4);
        }
        ImageView imageView = this.commentIcon;
        if (imageView != null) {
            imageView.setVisibility(isSupportComment ? 0 : 4);
        }
        TextView textView2 = this.commentInputTv;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(isSupportComment ? 0 : 4);
    }

    private final void I9() {
        boolean isSupportPraise = this.operateConfig.getIsSupportPraise();
        TextView textView = this.praiseNum;
        if (textView != null) {
            textView.setVisibility(isSupportPraise ? 0 : 4);
        }
        ImageView imageView = this.praiseIcon;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(isSupportPraise ? 0 : 4);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        G9(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (x9() == null) {
            View view = this.footerView;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        View view2 = this.footerView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ImageView imageView = this.shareMoreIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        I9();
        H9();
    }

    private final void G9(View rootView) {
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.f130137y, (ViewGroup) null);
        this.footerView = inflate;
        this.commentIcon = inflate != null ? (ImageView) inflate.findViewById(R.id.mwq) : null;
        View view = this.footerView;
        this.commentNum = view != null ? (TextView) view.findViewById(R.id.mws) : null;
        View view2 = this.footerView;
        this.praiseNum = view2 != null ? (TextView) view2.findViewById(R.id.f162839mx0) : null;
        View view3 = this.footerView;
        this.praiseIcon = view3 != null ? (ImageView) view3.findViewById(R.id.mwz) : null;
        View view4 = this.footerView;
        this.shareMoreIcon = view4 != null ? (ImageView) view4.findViewById(R.id.f162840mx1) : null;
        View view5 = this.footerView;
        this.commentInputTv = view5 != null ? (TextView) view5.findViewById(R.id.mwr) : null;
        com.tencent.mobileqq.qzone.picload.c.a().m(this.commentIcon, -1);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.praiseIcon, -1);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.shareMoreIcon, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ar.d(200.0f));
        layoutParams.gravity = 80;
        View view6 = this.footerView;
        if (view6 != null) {
            view6.setClickable(false);
        }
        View view7 = this.footerView;
        if (view7 != null) {
            view7.setEnabled(false);
        }
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.footerView, layoutParams);
    }
}
