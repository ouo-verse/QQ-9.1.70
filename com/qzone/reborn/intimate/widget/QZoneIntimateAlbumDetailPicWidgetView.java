package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.aa;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumDetailPicWidgetView;", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailPicWidgetView;", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "X0", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "E0", "", "L0", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumDetailPicWidgetView extends CommonAlbumDetailPicWidgetView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateAlbumDetailPicWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView
    public com.qzone.reborn.albumx.common.viewmodel.e E0() {
        ViewModel p16 = p(aa.class);
        Intrinsics.checkNotNullExpressionValue(p16, "getViewModel(QZoneIntima\u2026ateViewModel::class.java)");
        return (com.qzone.reborn.albumx.common.viewmodel.e) p16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView
    public void L0() {
        MutableLiveData<Boolean> X1;
        com.qzone.reborn.albumx.common.viewmodel.b X0 = X0();
        if ((X0 == null || (X1 = X0.X1()) == null) ? false : Intrinsics.areEqual(X1.getValue(), Boolean.FALSE)) {
            return;
        }
        super.L0();
    }

    public com.qzone.reborn.albumx.common.viewmodel.b X0() {
        ViewModel p16 = p(nk.w.class);
        Intrinsics.checkNotNullExpressionValue(p16, "getViewModel(QZoneIntima\u2026ailViewModel::class.java)");
        return (com.qzone.reborn.albumx.common.viewmodel.b) p16;
    }
}
