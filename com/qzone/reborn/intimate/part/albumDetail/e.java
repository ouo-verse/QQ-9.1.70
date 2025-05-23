package com.qzone.reborn.intimate.part.albumDetail;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.ViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.aa;
import nk.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/e;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "initData", "", "scrollRate", "G9", "D9", "E9", "F9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "rlOperateLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvBatchOperateText", "f", "tvAllSelectText", "Landroidx/appcompat/widget/Toolbar;", tl.h.F, "Landroidx/appcompat/widget/Toolbar;", "toolBar", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "flTitleBar", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "ivBack", "Lcom/google/android/material/appbar/AppBarLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Landroidx/appcompat/widget/LinearLayoutCompat;", "D", "Landroidx/appcompat/widget/LinearLayoutCompat;", "linearLayoutCompat", "Lnk/w;", "E", "Lnk/w;", "albumViewModel", "", UserInfo.SEX_FEMALE, "I", "curVerticalOffset", "", "G", "Z", "isAllSelectMode", "Lnk/aa;", "H", "Lnk/aa;", "operateViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private AppBarLayout appBarLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayoutCompat linearLayoutCompat;

    /* renamed from: E, reason: from kotlin metadata */
    private w albumViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private int curVerticalOffset = -1;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isAllSelectMode;

    /* renamed from: H, reason: from kotlin metadata */
    private aa operateViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout rlOperateLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvBatchOperateText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvAllSelectText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Toolbar toolBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout flTitleBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    private final void D9() {
        ImageView imageView = this.ivBack;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setBackgroundResource(0);
        ImageView imageView2 = this.ivBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView2 = null;
        }
        rn.h.a(imageView2, "qui_arrow_left", R.color.qui_common_icon_primary);
        TextView textView2 = this.tvBatchOperateText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBatchOperateText");
            textView2 = null;
        }
        textView2.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        TextView textView3 = this.tvAllSelectText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAllSelectText");
        } else {
            textView = textView3;
        }
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
    }

    private final void E9() {
        ImageView imageView = this.ivBack;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setBackgroundResource(R.drawable.f169970);
        ImageView imageView2 = this.ivBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView2 = null;
        }
        rn.h.a(imageView2, "qui_arrow_left", R.color.qui_common_icon_nav_primary);
        TextView textView2 = this.tvBatchOperateText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBatchOperateText");
            textView2 = null;
        }
        textView2.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
        TextView textView3 = this.tvAllSelectText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAllSelectText");
        } else {
            textView = textView3;
        }
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
    }

    private final void F9() {
        boolean z16 = !this.isAllSelectMode;
        this.isAllSelectMode = z16;
        aa aaVar = null;
        if (z16) {
            TextView textView = this.tvAllSelectText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAllSelectText");
                textView = null;
            }
            textView.setText(com.qzone.util.l.a(R.string.snr));
            aa aaVar2 = this.operateViewModel;
            if (aaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                aaVar = aaVar2;
            }
            aaVar.M1();
        } else {
            TextView textView2 = this.tvAllSelectText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAllSelectText");
                textView2 = null;
            }
            textView2.setText(com.qzone.util.l.a(R.string.sni));
            aa aaVar3 = this.operateViewModel;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                aaVar = aaVar3;
            }
            aaVar.h2();
        }
        QLog.i(getTAG(), 1, "handleClickAllSelectOperate  isAllSelectMode = " + this.isAllSelectMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(e this$0, AppBarLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.curVerticalOffset == i3) {
            return;
        }
        this$0.curVerticalOffset = i3;
        this$0.G9(Math.abs(i3) / Math.abs(appBarLayout.p()));
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026ailViewModel::class.java)");
        this.albumViewModel = (w) viewModel;
        ViewModel viewModel2 = getViewModel(aa.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026ateViewModel::class.java)");
        aa aaVar = (aa) viewModel2;
        this.operateViewModel = aaVar;
        w wVar = null;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            aaVar = null;
        }
        aaVar.d2().setValue(Boolean.TRUE);
        aa aaVar2 = this.operateViewModel;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            aaVar2 = null;
        }
        w wVar2 = this.albumViewModel;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        } else {
            wVar = wVar2;
        }
        aaVar2.l2(wVar.N1());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateAlbumBatchDownloadTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.lvk) {
            getActivity().onBackPressed();
        } else if (valueOf != null && valueOf.intValue() == R.id.nhv) {
            F9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.lvk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_title_back)");
        this.ivBack = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.n5k);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ate_space_app_bar_layout)");
        this.appBarLayout = (AppBarLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.jor);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.fl_title_bar)");
        this.flTitleBar = (FrameLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f162893n63);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026qzone_intimate_title_bar)");
        this.toolBar = (Toolbar) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.net);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.rl_operate_layout)");
        this.rlOperateLayout = (RelativeLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f162954ni4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.tv_batch_operate_text)");
        this.tvBatchOperateText = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.nhv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.tv_all_select_text)");
        this.tvAllSelectText = (TextView) findViewById7;
        ImageView imageView = this.ivBack;
        AppBarLayout appBarLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        TextView textView = this.tvAllSelectText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAllSelectText");
            textView = null;
        }
        textView.setOnClickListener(this);
        View findViewById8 = rootView.findViewById(R.id.n5v);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026e_intimate_tab_container)");
        this.linearLayoutCompat = (LinearLayoutCompat) findViewById8;
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        } else {
            appBarLayout = appBarLayout2;
        }
        appBarLayout.e(new AppBarLayout.g() { // from class: com.qzone.reborn.intimate.part.albumDetail.d
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout3, int i3) {
                e.H9(e.this, appBarLayout3, i3);
            }
        });
        initData();
    }

    private final void G9(float scrollRate) {
        int alphaComponent = ColorUtils.setAlphaComponent(getContext().getResources().getColor(R.color.qui_common_fill_light_primary), (int) (255.0f * scrollRate));
        Toolbar toolbar = this.toolBar;
        LinearLayoutCompat linearLayoutCompat = null;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolBar");
            toolbar = null;
        }
        toolbar.setBackgroundColor(alphaComponent);
        if (scrollRate == 0.0f) {
            E9();
            LinearLayoutCompat linearLayoutCompat2 = this.linearLayoutCompat;
            if (linearLayoutCompat2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutCompat");
            } else {
                linearLayoutCompat = linearLayoutCompat2;
            }
            linearLayoutCompat.setBackgroundResource(R.drawable.f170273);
            return;
        }
        if (scrollRate == 1.0f) {
            D9();
            LinearLayoutCompat linearLayoutCompat3 = this.linearLayoutCompat;
            if (linearLayoutCompat3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutCompat");
            } else {
                linearLayoutCompat = linearLayoutCompat3;
            }
            linearLayoutCompat.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            return;
        }
        LinearLayoutCompat linearLayoutCompat4 = this.linearLayoutCompat;
        if (linearLayoutCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutCompat");
        } else {
            linearLayoutCompat = linearLayoutCompat4;
        }
        linearLayoutCompat.setBackgroundResource(R.drawable.f170273);
    }
}
