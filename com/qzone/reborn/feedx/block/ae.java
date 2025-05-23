package com.qzone.reborn.feedx.block;

import android.os.Bundle;
import com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView;
import com.qzone.reborn.feedx.widget.header.QZoneUserHomeHeaderContainerView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/feedx/block/ae;", "Lcom/qzone/reborn/feedx/block/b;", "Lcom/qzone/reborn/feedx/widget/header/QZoneBaseFeedxHeaderContainerView;", "r0", "Landroid/os/Bundle;", "initParams", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class ae extends b {
    public ae(Bundle bundle) {
        super(bundle);
    }

    @Override // com.qzone.reborn.feedx.block.b
    public QZoneBaseFeedxHeaderContainerView r0() {
        return new QZoneUserHomeHeaderContainerView(getActivity(), getParentFragment(), this);
    }
}
