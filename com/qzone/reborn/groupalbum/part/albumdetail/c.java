package com.qzone.reborn.groupalbum.part.albumdetail;

import android.app.Activity;
import android.view.View;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailHeadView;
import com.qzone.reborn.albumx.qzonex.bean.QZAlbumxDescDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/albumdetail/c;", "Lcom/qzone/reborn/albumx/common/part/f;", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView;", "headView", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "info", "", "Q9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends com.qzone.reborn.albumx.common.part.f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(c this$0, CommonAlbumInfo info, CommonAlbumDetailHeadView headView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(headView, "$headView");
        vb.b x16 = ho.i.x();
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String owner = info.getOwner();
        String a16 = com.qzone.util.l.a(R.string.f133957i);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_albumx_album_desc_text)");
        x16.a(activity, new QZAlbumxDescDetailInitBean(owner, a16, headView.r0()));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.albumx.common.part.f
    public void Q9(final CommonAlbumDetailHeadView headView, final CommonAlbumInfo info) {
        Intrinsics.checkNotNullParameter(headView, "headView");
        Intrinsics.checkNotNullParameter(info, "info");
        headView.setDescMoreClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.U9(c.this, info, headView, view);
            }
        });
    }
}
