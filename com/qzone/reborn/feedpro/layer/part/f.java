package com.qzone.reborn.feedpro.layer.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/f;", "Lcom/qzone/reborn/albumx/common/layer/part/c;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "action", "", "args", "handleBroadcastMessage", "", "F9", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "titleContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "headerView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "pageTitlePageIndicator", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class f extends com.qzone.reborn.albumx.common.layer.part.c<QzoneFeedProLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView pageTitlePageIndicator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout titleContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            this$0.getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected boolean F9() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        LinearLayout linearLayout;
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "LAYER_TITLE_CONTAINER_SHOW")) {
            LinearLayout linearLayout2 = this.titleContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
                return;
            }
            return;
        }
        if (!TextUtils.equals(action, "LAYER_TITLE_CONTAINER_HIDE") || (linearLayout = this.titleContainer) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.cfm, (ViewGroup) null);
        this.headerView = inflate;
        this.titleContainer = inflate != null ? (LinearLayout) inflate.findViewById(R.id.n0p) : null;
        View view = this.headerView;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.nm5) : null;
        this.pageTitlePageIndicator = textView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        View view2 = this.headerView;
        ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.n0j) : null;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    f.G9(f.this, view3);
                }
            });
        }
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.headerView, layoutParams);
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (x9() == null) {
            TextView textView = this.pageTitlePageIndicator;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        View view = this.headerView;
        if (view != null) {
            view.setVisibility(0);
        }
        if (F9()) {
            if (C9(layerState) == 1) {
                TextView textView2 = this.pageTitlePageIndicator;
                if (textView2 == null) {
                    return;
                }
                textView2.setVisibility(8);
                return;
            }
            String str = B9(layerState) + "/" + C9(layerState);
            TextView textView3 = this.pageTitlePageIndicator;
            if (textView3 != null) {
                textView3.setText(str);
            }
            TextView textView4 = this.pageTitlePageIndicator;
            if (textView4 == null) {
                return;
            }
            textView4.setVisibility(0);
        }
    }
}
