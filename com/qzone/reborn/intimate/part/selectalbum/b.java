package com.qzone.reborn.intimate.part.selectalbum;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart;
import com.qzone.reborn.albumx.common.viewmodel.l;
import com.qzone.reborn.feedx.util.k;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.bb;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/intimate/part/selectalbum/b;", "Lcom/qzone/reborn/albumx/common/part/selectalbum/CommonSelectAlbumBlankPart;", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "E9", "", "J9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends CommonSelectAlbumBlankPart {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l G9 = this$0.G9();
        Intrinsics.checkNotNull(G9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateSelectAlbumViewModel");
        this$0.broadcastMessage("ACTION_CREATE_ALBUM", ((bb) G9).Z1().getSpaceId());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart
    public l E9() {
        ViewModel viewModel = getViewModel(bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026bumViewModel::class.java)");
        return (l) viewModel;
    }

    @Override // com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart
    protected void J9() {
        F9().setData(k.j(getContext(), G9().Q1(), new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.selectalbum.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.P9(b.this, view);
            }
        }));
    }
}
