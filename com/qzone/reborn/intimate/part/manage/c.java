package com.qzone.reborn.intimate.part.manage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.util.e;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mk.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/intimate/part/manage/c;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivAddIcon", "e", "Landroid/view/View;", "titleLayout", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivAddIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View titleLayout;

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateManageTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.kua) {
            getActivity().onBackPressed();
        } else if (valueOf != null && valueOf.intValue() == R.id.ktt && !e.b("QZoneIntimateManageTitlePartHalfScreen", 500L)) {
            i.q(getActivity(), g.f53821a.h().D());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f162886n52);
        this.titleLayout = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = ImmersiveUtils.getStatusBarHeight(getContext()) + d.f416875a.s();
        }
        View view = this.titleLayout;
        if (view != null) {
            view.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
        ImageView imageView = (ImageView) rootView.findViewById(R.id.kua);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        View findViewById2 = rootView.findViewById(R.id.ktt);
        ImageView imageView2 = (ImageView) findViewById2;
        imageView2.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Im\u2026anageTitlePart)\n        }");
        this.ivAddIcon = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAddIcon");
            imageView2 = null;
        }
        fo.c.o(imageView2, "em_qz_create_relationship_button", null);
    }
}
