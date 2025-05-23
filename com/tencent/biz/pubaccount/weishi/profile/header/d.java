package com.tencent.biz.pubaccount.weishi.profile.header;

import UserGrowth.stPersonExt;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.util.ag;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/d;", "Lcom/tencent/biz/pubaccount/weishi/profile/header/AbsWSHeaderPresenter;", "", "H", "", HippyTKDListViewAdapter.X, "", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "", "f", "g", "o", "Lcom/tencent/biz/pubaccount/weishi/profile/d;", "profileViewImpl", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/profile/d;)V", tl.h.F, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d extends AbsWSHeaderPresenter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.tencent.biz.pubaccount.weishi.profile.d profileViewImpl) {
        super(profileViewImpl);
        Intrinsics.checkNotNullParameter(profileViewImpl, "profileViewImpl");
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public boolean H() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        x.b("WSHostPresenter", "onRightSmallBtnClick() setting");
        bb.N(context, "2");
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void g(Context context) {
        stPersonExt stpersonext;
        Intrinsics.checkNotNullParameter(context, "context");
        x.b("WSHostPresenter", "onRightBigBtnClick() edit profile");
        stSimpleMetaPerson mPerson = getMPerson();
        l(context, (mPerson == null || (stpersonext = mPerson.extInfo) == null) ? null : stpersonext.editSchema, 3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public float y() {
        return 12.0f;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public int z() {
        return R.drawable.f159776go4;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public String o() {
        return ag.c(R.string.x8a);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public String x() {
        return ag.c(R.string.x8_);
    }
}
