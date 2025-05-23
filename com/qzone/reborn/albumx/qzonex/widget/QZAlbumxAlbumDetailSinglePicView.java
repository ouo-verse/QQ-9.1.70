package com.qzone.reborn.albumx.qzonex.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.viewmodel.b;
import com.qzone.reborn.albumx.common.viewmodel.e;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView;
import com.qzone.reborn.albumx.qzonex.utils.c;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.ap;
import nc.y;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/widget/QZAlbumxAlbumDetailSinglePicView;", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailPicWidgetView;", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "X0", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "E0", "", "Q0", "P0", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailSinglePicView extends CommonAlbumDetailPicWidgetView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxAlbumDetailSinglePicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView
    public e E0() {
        ViewModel p16 = p(ap.class);
        Intrinsics.checkNotNullExpressionValue(p16, "getViewModel(QZAlbumxAlb\u2026ateViewModel::class.java)");
        return (e) p16;
    }

    @Override // com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView
    public boolean P0() {
        return false;
    }

    @Override // com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView
    public boolean Q0() {
        return c.f53402a.e(X0().M1().getValue());
    }

    public b X0() {
        ViewModel p16 = p(y.class);
        Intrinsics.checkNotNullExpressionValue(p16, "getViewModel(QZAlbumxAlb\u2026ailViewModel::class.java)");
        return (b) p16;
    }
}
