package com.qzone.reborn.albumx.common.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\b\u0010\u0010\u001a\u00020\u0005H\u0014J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010&\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\"\u0010*\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\"\u00102\u001a\u00020+8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010B\u001a\u00020+8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b?\u0010-\u001a\u0004\b@\u0010/\"\u0004\bA\u00101R\"\u0010F\u001a\u00020+8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bC\u0010-\u001a\u0004\bD\u0010/\"\u0004\bE\u00101R\u0016\u0010H\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010-R\"\u0010P\u001a\u00020I8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010X\u001a\u00020Q8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010RR#\u0010e\u001a\n `*\u0004\u0018\u00010_0_8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\u00a8\u0006h"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/CommonAlbumDetailTitlePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "scrollRate", "", "R9", "", CustomAnimation.KeyPath.COLOR_FILTER, "aa", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "D9", "E9", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "P9", "()Landroid/widget/TextView;", "da", "(Landroid/widget/TextView;)V", "tvCancelText", "e", "O9", "ca", "tvBatchOperateText", "f", "N9", "ba", "tvAllSelectText", tl.h.F, "J9", "X9", "ivOperateTitle", "i", "Q9", "ea", "tvOperateText", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "I9", "()Landroid/widget/ImageView;", "W9", "(Landroid/widget/ImageView;)V", "ivOperateIcon", "Landroidx/appcompat/widget/Toolbar;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/appcompat/widget/Toolbar;", "toolBar", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "G9", "()Landroid/widget/LinearLayout;", "U9", "(Landroid/widget/LinearLayout;)V", "flBatchOperate", "E", "K9", "Y9", "ivTransmitQueenView", UserInfo.SEX_FEMALE, "H9", "V9", "ivEdit", "G", "ivBack", "Lcom/google/android/material/appbar/AppBarLayout;", "H", "Lcom/google/android/material/appbar/AppBarLayout;", "F9", "()Lcom/google/android/material/appbar/AppBarLayout;", "T9", "(Lcom/google/android/material/appbar/AppBarLayout;)V", "appBarLayout", "Landroidx/recyclerview/widget/RecyclerView;", "I", "Landroidx/recyclerview/widget/RecyclerView;", "L9", "()Landroidx/recyclerview/widget/RecyclerView;", "Z9", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Landroidx/appcompat/widget/LinearLayoutCompat;", "J", "Landroidx/appcompat/widget/LinearLayoutCompat;", "linearLayoutCompat", "K", "curVerticalOffset", "Lcom/qzone/reborn/albumx/common/viewmodel/m;", "kotlin.jvm.PlatformType", "L", "Lkotlin/Lazy;", "M9", "()Lcom/qzone/reborn/albumx/common/viewmodel/m;", "transmitVm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class CommonAlbumDetailTitlePart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private Toolbar toolBar;

    /* renamed from: D, reason: from kotlin metadata */
    protected LinearLayout flBatchOperate;

    /* renamed from: E, reason: from kotlin metadata */
    protected ImageView ivTransmitQueenView;

    /* renamed from: F, reason: from kotlin metadata */
    protected ImageView ivEdit;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: H, reason: from kotlin metadata */
    public AppBarLayout appBarLayout;

    /* renamed from: I, reason: from kotlin metadata */
    public RecyclerView recyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayoutCompat linearLayoutCompat;

    /* renamed from: K, reason: from kotlin metadata */
    private int curVerticalOffset = -1;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy transmitVm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected TextView tvCancelText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected TextView tvBatchOperateText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected TextView tvAllSelectText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected TextView ivOperateTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected TextView tvOperateText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected ImageView ivOperateIcon;

    public CommonAlbumDetailTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.albumx.common.viewmodel.m>() { // from class: com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart$transmitVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.albumx.common.viewmodel.m invoke() {
                return (com.qzone.reborn.albumx.common.viewmodel.m) CommonAlbumDetailTitlePart.this.getViewModel(com.qzone.reborn.albumx.common.viewmodel.m.class);
            }
        });
        this.transmitVm = lazy;
    }

    private final com.qzone.reborn.albumx.common.viewmodel.m M9() {
        return (com.qzone.reborn.albumx.common.viewmodel.m) this.transmitVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(CommonAlbumDetailTitlePart this$0, AppBarLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.curVerticalOffset == i3) {
            return;
        }
        this$0.curVerticalOffset = i3;
        this$0.R9(Math.abs(i3) / Math.abs(appBarLayout.p()));
    }

    private final void aa(int colorFilter) {
        com.qzone.reborn.albumx.common.viewmodel.m M9 = M9();
        if (M9 != null) {
            M9.N1(colorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D9() {
        ImageView imageView = this.ivBack;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setBackgroundResource(0);
        G9().setBackgroundResource(0);
        H9().setBackgroundResource(0);
        K9().setBackgroundResource(0);
        aa(R.color.qui_common_icon_primary);
        ImageView imageView3 = this.ivBack;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
        } else {
            imageView2 = imageView3;
        }
        rn.h.a(imageView2, "qui_arrow_left", R.color.qui_common_icon_primary);
        rn.h.a(I9(), "qui_list_select", R.color.qui_common_icon_primary);
        rn.h.a(H9(), "qui_more", R.color.qui_common_icon_primary);
        Q9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        J9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        P9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        O9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        N9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E9() {
        ImageView imageView = this.ivBack;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setBackgroundResource(R.drawable.f169970);
        G9().setBackgroundResource(R.drawable.f16986z);
        H9().setBackgroundResource(R.drawable.f169970);
        K9().setBackgroundResource(R.drawable.f169970);
        aa(R.color.qui_common_text_allwhite_primary);
        ImageView imageView3 = this.ivBack;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
        } else {
            imageView2 = imageView3;
        }
        rn.h.a(imageView2, "qui_arrow_left", R.color.qui_common_text_allwhite_primary);
        rn.h.a(I9(), "qui_list_select", R.color.qui_common_text_allwhite_primary);
        rn.h.a(H9(), "qui_more", R.color.qui_common_text_allwhite_primary);
        Q9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
        P9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
        O9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
        N9().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
    }

    public final AppBarLayout F9() {
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout != null) {
            return appBarLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout G9() {
        LinearLayout linearLayout = this.flBatchOperate;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flBatchOperate");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView H9() {
        ImageView imageView = this.ivEdit;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivEdit");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView I9() {
        ImageView imageView = this.ivOperateIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivOperateIcon");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView J9() {
        TextView textView = this.ivOperateTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivOperateTitle");
        return null;
    }

    protected final ImageView K9() {
        ImageView imageView = this.ivTransmitQueenView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTransmitQueenView");
        return null;
    }

    public final RecyclerView L9() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView N9() {
        TextView textView = this.tvAllSelectText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvAllSelectText");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView O9() {
        TextView textView = this.tvBatchOperateText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvBatchOperateText");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView P9() {
        TextView textView = this.tvCancelText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvCancelText");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView Q9() {
        TextView textView = this.tvOperateText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvOperateText");
        return null;
    }

    public final void T9(AppBarLayout appBarLayout) {
        Intrinsics.checkNotNullParameter(appBarLayout, "<set-?>");
        this.appBarLayout = appBarLayout;
    }

    protected final void U9(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.flBatchOperate = linearLayout;
    }

    protected final void V9(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivEdit = imageView;
    }

    protected final void W9(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivOperateIcon = imageView;
    }

    protected final void X9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.ivOperateTitle = textView;
    }

    protected final void Y9(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivTransmitQueenView = imageView;
    }

    public final void Z9(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ba(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvAllSelectText = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ca(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvBatchOperateText = textView;
    }

    protected final void da(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvCancelText = textView;
    }

    protected final void ea(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvOperateText = textView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "CommonAlbumDetailTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.lvk) {
            getActivity().onBackPressed();
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
        View findViewById2 = rootView.findViewById(R.id.lvo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_title_edit)");
        V9((ImageView) findViewById2);
        View findViewById3 = rootView.findViewById(R.id.fyg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.fl_batch_operate)");
        U9((LinearLayout) findViewById3);
        View findViewById4 = rootView.findViewById(R.id.n69);
        ImageView imageView = (ImageView) findViewById4;
        imageView.setBackgroundResource(R.drawable.f169970);
        aa(R.color.qui_common_text_allwhite_primary);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<Im\u2026lwhite_primary)\n        }");
        Y9(imageView);
        View findViewById5 = rootView.findViewById(R.id.n5k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026ate_space_app_bar_layout)");
        T9((AppBarLayout) findViewById5);
        View findViewById6 = rootView.findViewById(R.id.nf7);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.rv_feed_list)");
        Z9((RecyclerView) findViewById6);
        View findViewById7 = rootView.findViewById(R.id.f162893n63);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026qzone_intimate_title_bar)");
        this.toolBar = (Toolbar) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.ln6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.iv_operate_icon)");
        W9((ImageView) findViewById8);
        View findViewById9 = rootView.findViewById(R.id.lnp);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.iv_operate_text)");
        ea((TextView) findViewById9);
        View findViewById10 = rootView.findViewById(R.id.ktv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.id.iv_album_title_info)");
        X9((TextView) findViewById10);
        View findViewById11 = rootView.findViewById(R.id.nia);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.tv_cancel_text)");
        da((TextView) findViewById11);
        View findViewById12 = rootView.findViewById(R.id.f162954ni4);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.id.tv_batch_operate_text)");
        ca((TextView) findViewById12);
        View findViewById13 = rootView.findViewById(R.id.nhv);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.id.tv_all_select_text)");
        ba((TextView) findViewById13);
        View findViewById14 = rootView.findViewById(R.id.n5v);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.\u2026e_intimate_tab_container)");
        this.linearLayoutCompat = (LinearLayoutCompat) findViewById14;
        ImageView imageView2 = this.ivBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        H9().setOnClickListener(this);
        J9().setOnClickListener(this);
        G9().setOnClickListener(this);
        P9().setOnClickListener(this);
        N9().setOnClickListener(this);
        F9().e(new AppBarLayout.g() { // from class: com.qzone.reborn.albumx.common.part.j
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
                CommonAlbumDetailTitlePart.S9(CommonAlbumDetailTitlePart.this, appBarLayout, i3);
            }
        });
    }

    private final void R9(float scrollRate) {
        int i3 = (int) (scrollRate <= 1.0f ? 255.0f * scrollRate : 255.0f);
        int color = getContext().getResources().getColor(R.color.qui_common_fill_light_primary);
        LinearLayoutCompat linearLayoutCompat = null;
        if (i3 >= 0 && i3 < 256) {
            int alphaComponent = ColorUtils.setAlphaComponent(color, i3);
            Toolbar toolbar = this.toolBar;
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolBar");
                toolbar = null;
            }
            toolbar.setBackgroundColor(alphaComponent);
        }
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
