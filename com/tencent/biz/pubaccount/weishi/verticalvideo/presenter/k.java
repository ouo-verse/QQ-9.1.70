package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModePart;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0018\u00010\u0002j\b\u0012\u0002\b\u0003\u0018\u0001`\u0003H\u0016J\"\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0014J$\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/k;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/AbsWSVerticalPagePresenter;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "intentList", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "N", "", "isRefresh", "isFirst", "", "from", "y0", "", "position", "p", "L", "", "l", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "w", "v1", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/HashSet;", "Lrz/a;", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;", "view", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class k extends AbsWSVerticalPagePresenter {
    public k(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public HashSet<rz.a> C(QBaseActivity activity) {
        HashSet<rz.a> hashSetOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (v1()) {
            rz.a[] aVarArr = new rz.a[1];
            com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
            aVarArr[0] = new WSTeenModePart(activity, com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(O0 != null ? O0.getFrom() : null));
            hashSetOf = SetsKt__SetsKt.hashSetOf(aVarArr);
            return hashSetOf;
        }
        return super.C(activity);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean L() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList<?> intentList) {
        yz.i iVar = yz.i.f451583a;
        return iVar.d(iVar.g());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void l() {
        super.l();
        yz.i.f451583a.m(null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int p(int position) {
        x.j("nel-log", "position:" + position + " in WSVerticalForFloatingWindowPresenter");
        return super.p(position + 1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean v1() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        return Intrinsics.areEqual(O0 != null ? O0.getFrom() : null, "float_window_out_ws");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public com.tencent.biz.pubaccount.weishi.player.e w() {
        return yz.i.f451583a.h();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean isRefresh, boolean isFirst, String from) {
        yz.i iVar = yz.i.f451583a;
        iVar.e(iVar.g(), this);
        return true;
    }
}
