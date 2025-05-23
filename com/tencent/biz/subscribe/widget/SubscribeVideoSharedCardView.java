package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView;
import com.tencent.mobileqq.R;
import ve0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeVideoSharedCardView extends SubscribeMultiPicSharedCardView {
    private ImageView Q;

    public SubscribeVideoSharedCardView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.biz.subscribe.widget.SubscribeMultiPicSharedCardView, com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public void e(b bVar, Bitmap bitmap, AbsSubscribeShareCardView.a aVar) {
        super.e(bVar, bitmap, aVar);
        CertifiedAccountMeta$StFeed a16 = bVar.a();
        c(this.P, a16.cover.width.get(), a16.cover.height.get());
        this.f96364i.add(a16.poster.icon.get());
        this.f96365m.add(this.K);
        this.f96364i.add(a16.cover.url.get());
        this.f96365m.add(this.J);
        f(this.f96364i, this.f96365m, aVar);
    }

    @Override // com.tencent.biz.subscribe.widget.SubscribeMultiPicSharedCardView, com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public void j(View view) {
        super.j(view);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.cj6);
        this.Q = imageView;
        imageView.setVisibility(0);
    }

    public SubscribeVideoSharedCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscribeVideoSharedCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
