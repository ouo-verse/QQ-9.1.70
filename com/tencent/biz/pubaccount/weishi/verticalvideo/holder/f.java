package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class f extends au {

    /* renamed from: m, reason: collision with root package name */
    private static final int f82130m = ScreenUtil.dip2px(45.0f);

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    public FrameLayout c() {
        Object obj = this.f82127d;
        if (obj instanceof b) {
            return ((b) obj).h();
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public int k() {
        return f82130m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean o() {
        T t16 = this.f82129f;
        if (t16 != 0 && ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) t16).h()) {
            return true;
        }
        if (this.f82128e.getPresenter().m()) {
            return false;
        }
        boolean H = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().H();
        com.tencent.biz.pubaccount.weishi.util.x.j("WS_VIDEO_PLAY_TIME", "[WSVerticalCommonVideoHolder.java][isPlayLoop] isLoop:" + H);
        return H;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    protected boolean p() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean q() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public void r() {
        Object obj = this.f82127d;
        if (obj instanceof b) {
            ((b) obj).recycle();
        }
    }

    public f(ViewGroup viewGroup, int i3, WSVerticalPageFragment wSVerticalPageFragment) {
        super(viewGroup, R.layout.fwj, i3, wSVerticalPageFragment);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public void s() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public void t() {
    }

    public void w(boolean z16) {
    }

    public void x(boolean z16) {
    }
}
