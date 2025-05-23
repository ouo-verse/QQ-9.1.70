package com.qzone.reborn.groupalbum.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.viewmodel.e;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView;
import com.qzone.reborn.groupalbum.viewmodel.h;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/groupalbum/widget/GroupAlbumAlbumDetailSinglePicView;", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailPicWidgetView;", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "E0", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumDetailSinglePicView extends CommonAlbumDetailPicWidgetView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumAlbumDetailSinglePicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView
    public e E0() {
        ViewModel p16 = p(h.class);
        Intrinsics.checkNotNullExpressionValue(p16, "getViewModel(GroupAlbumA\u2026ateViewModel::class.java)");
        return (e) p16;
    }
}
