package com.qzone.reborn.feedpro.widget.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/p;", "Lcom/qzone/reborn/feedpro/widget/header/f;", "", "v", "Landroid/view/View;", "view", "u", "onInit", "", "k", "containerView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
    }

    private final void u(View view) {
        fo.c.q(view, "em_qz_cover", null);
    }

    private final void v() {
        ImageView imageView = new ImageView(h().getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        getMCoverLayout().addView(imageView, layoutParams);
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(com.qzone.reborn.feedpro.utils.l.f54345a.a());
        e16.setTargetView(imageView);
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedpro.widget.header.o
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                p.w(p.this, loadState, option);
            }
        });
        u(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(p this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e(this$0.k(), RFWLog.USR, "load cover | state = " + loadState + " | url = " + option.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.header.d
    public String k() {
        return "QzoneFeedProUserHomeCoverElement";
    }

    @Override // com.qzone.reborn.feedpro.widget.header.f, com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        super.onInit();
        v();
    }
}
