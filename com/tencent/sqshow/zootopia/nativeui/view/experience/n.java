package com.tencent.sqshow.zootopia.nativeui.view.experience;

import android.content.res.AssetManager;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/experience/n;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Luv4/az;", "cardItemData", "", "l", "Ln74/k;", "E", "Ln74/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ln74/k;", "setViewBinding", "(Ln74/k;)V", "viewBinding", "<init>", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class n extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private n74.k viewBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(n74.k viewBinding) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.viewBinding = viewBinding;
    }

    public final void l(az cardItemData) {
        Intrinsics.checkNotNullParameter(cardItemData, "cardItemData");
        this.viewBinding.f419360d.setText(cardItemData.f440277d);
        URLImageView uRLImageView = this.viewBinding.f419359c;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "viewBinding.cardIcon");
        String str = cardItemData.f440279f;
        Intrinsics.checkNotNullExpressionValue(str, "cardItemData.icon");
        CommonExKt.w(uRLImageView, str, null, null, 4, null);
        n74.k kVar = this.viewBinding;
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = kVar.f419361e;
        t74.m mVar = t74.m.f435564a;
        AssetManager assets = kVar.getRoot().getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "viewBinding.root.context.assets");
        zplanExcludeFontPaddingTextView.setTypeface(mVar.a(assets));
        this.viewBinding.f419361e.setText(String.valueOf(cardItemData.f440287n.f440313b));
        if (cardItemData.f440295v > 0) {
            this.viewBinding.f419365i.setVisibility(0);
            this.viewBinding.f419366j.setText(String.valueOf(cardItemData.f440295v));
            TextView textView = this.viewBinding.f419366j;
            AssetManager assets2 = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
            textView.setTypeface(mVar.a(assets2));
            return;
        }
        this.viewBinding.f419365i.setVisibility(8);
    }

    /* renamed from: m, reason: from getter */
    public final n74.k getViewBinding() {
        return this.viewBinding;
    }
}
