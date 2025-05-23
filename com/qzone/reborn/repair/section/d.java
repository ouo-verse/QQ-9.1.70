package com.qzone.reborn.repair.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.base.l;
import com.qzone.reborn.util.m;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$SRTask;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/repair/section/d;", "Lcom/qzone/reborn/base/l;", "Lwn/d;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "imageIcon", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends l<wn.d> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout roundLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView imageIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162936nf1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.round_image_layout)");
        this.roundLayout = (RoundCorneredFrameLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.iv_image_icon)");
        this.imageIcon = (ImageView) findViewById2;
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.roundLayout;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roundLayout");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(ImmersiveUtils.dpToPx(4.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nmb};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(wn.d data, int position, List<Object> payload) {
        SuperResolution$SRTask rsTask;
        PBStringField pBStringField;
        SuperResolution$SRTask rsTask2;
        PBStringField pBStringField2;
        ImageView imageView = null;
        String str = (data == null || (rsTask2 = data.getRsTask()) == null || (pBStringField2 = rsTask2.sr_url) == null) ? null : pBStringField2.get();
        if (TextUtils.isEmpty(str)) {
            str = (data == null || (rsTask = data.getRsTask()) == null || (pBStringField = rsTask.src_url) == null) ? null : pBStringField.get();
        }
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(str);
        ImageView imageView2 = this.imageIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView2 = null;
        }
        e16.setTargetView(imageView2);
        ImageView imageView3 = this.imageIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView3 = null;
        }
        if (imageView3.getLayoutParams() != null) {
            ImageView imageView4 = this.imageIcon;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
                imageView4 = null;
            }
            e16.setRequestWidth(imageView4.getLayoutParams().width);
            ImageView imageView5 = this.imageIcon;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
                imageView5 = null;
            }
            e16.setRequestHeight(imageView5.getLayoutParams().height);
        }
        m mVar = m.f59551a;
        ImageView imageView6 = this.imageIcon;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView6 = null;
        }
        e16.setLoadingDrawable(mVar.b(imageView6.getContext()));
        ImageView imageView7 = this.imageIcon;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
        } else {
            imageView = imageView7;
        }
        e16.setFailedDrawable(mVar.a(imageView.getContext()));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }
}
