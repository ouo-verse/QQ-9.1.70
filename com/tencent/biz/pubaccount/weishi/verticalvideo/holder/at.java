package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewStub;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class at extends WSVerticalVideoOperationRightItemView {
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> V;

    public at(Context context, au auVar) {
        super(context, auVar);
    }

    private void f0() {
        stSimpleMetaPerson stsimplemetaperson;
        stSimpleMetaFeed C = C();
        if (C == null || (stsimplemetaperson = C.poster) == null) {
            return;
        }
        ((k) this.V).D(stsimplemetaperson);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSVerticalVideoAvatarBottomItemViewLog", "[WSVerticalVideoAvatarBottomItemView.java][updateFollowBtnUI] title:" + C.feed_desc);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView
    public void P() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11808737);
        k kVar = new k(this.C, this.f82126m);
        this.V = kVar;
        kVar.r(viewStub);
        b(this.V);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView
    public boolean Y() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView
    public void b0(boolean z16) {
        super.b0(z16);
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.V;
        if (bVar != null) {
            bVar.l(z16 ? 0 : 8);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView
    public void e0(boolean z16) {
        super.e0(z16);
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.V;
        if (bVar != null) {
            bVar.l(z16 ? 8 : 0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int i3) {
        stSimpleMetaPerson stsimplemetaperson;
        super.onPageSelected(i3);
        stSimpleMetaFeed C = C();
        if (C == null || (stsimplemetaperson = C.poster) == null) {
            return;
        }
        ((k) this.V).x(stsimplemetaperson);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView, com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
        if (i3 == 1 && (this.V instanceof k)) {
            f0();
        } else {
            super.e(i3);
        }
    }
}
