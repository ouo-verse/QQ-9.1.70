package com.qzone.reborn.feedpro.block;

import android.app.Activity;
import android.view.ViewGroup;
import com.qzone.reborn.feedpro.widget.header.QzoneFriendFeedProPublishEntranceView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/block/QzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFriendFeedProPublishEntranceView;", "Lcom/qzone/reborn/feedpro/widget/header/a;", "", "O", "J", "", "getRealHeight", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1 extends QzoneFriendFeedProPublishEntranceView implements com.qzone.reborn.feedpro.widget.header.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.a
    public int getRealHeight() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i3 = marginLayoutParams != null ? marginLayoutParams.topMargin : 0;
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        return i3 + (marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0) + getMeasuredHeight();
    }

    @Override // com.qzone.reborn.feedpro.widget.header.a
    public void J() {
        setVisibility(4);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.a
    public void O() {
        setVisibility(0);
    }
}
