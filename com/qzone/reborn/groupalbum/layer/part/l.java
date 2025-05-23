package com.qzone.reborn.groupalbum.layer.part;

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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010!\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0018\u0010%\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001c\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/l;", "Lcom/qzone/reborn/groupalbum/layer/part/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "D9", "G9", "F9", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Lp9/a;", tl.h.F, "Lp9/a;", "getOperateConfig", "()Lp9/a;", "operateConfig", "i", "Landroid/view/View;", "footerView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "commentNum", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "commentIcon", "D", "praiseNum", "E", "praiseIcon", UserInfo.SEX_FEMALE, "commentInputTv", "G", "shareMoreIcon", "<init>", "(Lp9/a;)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends b {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView commentIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView praiseNum;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView praiseIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView commentInputTv;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView shareMoreIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final p9.a operateConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View footerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView commentNum;

    public l(p9.a operateConfig) {
        Intrinsics.checkNotNullParameter(operateConfig, "operateConfig");
        this.operateConfig = operateConfig;
    }

    private final void D9() {
        fo.c.n(this.commentInputTv, "em_qz_comment_box");
        fo.c.n(this.praiseIcon, "em_qz_like");
        fo.c.n(this.commentIcon, "em_qz_comment");
    }

    private final void F9() {
        boolean isSupportComment = this.operateConfig.getIsSupportComment();
        TextView textView = this.commentNum;
        if (textView == null || this.commentIcon == null || this.commentInputTv == null) {
            return;
        }
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(isSupportComment ? 0 : 4);
        ImageView imageView = this.commentIcon;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(isSupportComment ? 0 : 4);
        TextView textView2 = this.commentInputTv;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(isSupportComment ? 0 : 4);
    }

    private final void G9() {
        boolean isSupportPraise = this.operateConfig.getIsSupportPraise();
        if (this.commentNum == null || this.commentIcon == null) {
            return;
        }
        TextView textView = this.praiseNum;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(isSupportPraise ? 0 : 4);
        ImageView imageView = this.praiseIcon;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(isSupportPraise ? 0 : 4);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        E9(rootView);
        D9();
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
        G9();
        F9();
    }

    private final void E9(View rootView) {
        if (rootView == null) {
            return;
        }
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f1275812, (ViewGroup) null);
        this.footerView = inflate;
        this.commentIcon = inflate != null ? (ImageView) inflate.findViewById(R.id.f199876) : null;
        View view = this.footerView;
        this.commentNum = view != null ? (TextView) view.findViewById(R.id.f200078) : null;
        View view2 = this.footerView;
        this.praiseNum = view2 != null ? (TextView) view2.findViewById(R.id.f20047b) : null;
        View view3 = this.footerView;
        this.praiseIcon = view3 != null ? (ImageView) view3.findViewById(R.id.f20037a) : null;
        View view4 = this.footerView;
        this.commentInputTv = view4 != null ? (TextView) view4.findViewById(R.id.f199977) : null;
        View view5 = this.footerView;
        this.shareMoreIcon = view5 != null ? (ImageView) view5.findViewById(R.id.f20057c) : null;
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
        ((ViewGroup) rootView).addView(this.footerView, layoutParams);
    }
}
