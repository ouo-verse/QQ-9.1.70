package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeHeaderContainerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/feedpro/block/r;", "Lcom/qzone/reborn/feedpro/block/e;", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderContainerView;", "p0", "Landroid/os/Bundle;", "initParams", "<init>", "(Landroid/os/Bundle;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r extends e {
    public r(Bundle bundle) {
        super(bundle);
    }

    @Override // com.qzone.reborn.feedpro.block.e
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public QzoneFeedProUserHomeHeaderContainerView o0() {
        QzoneFeedProUserHomeHeaderContainerView qzoneFeedProUserHomeHeaderContainerView = new QzoneFeedProUserHomeHeaderContainerView(getActivity(), getParentFragment(), this);
        qzoneFeedProUserHomeHeaderContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return qzoneFeedProUserHomeHeaderContainerView;
    }
}
