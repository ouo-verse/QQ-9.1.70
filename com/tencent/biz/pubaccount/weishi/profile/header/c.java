package com.tencent.biz.pubaccount.weishi.profile.header;

import UserGrowth.stPersonExt;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.util.ag;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/c;", "Lcom/tencent/biz/pubaccount/weishi/profile/header/AbsWSHeaderPresenter;", "", "H", "", HippyTKDListViewAdapter.X, "", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "", "f", "g", "o", "c", "Lcom/tencent/biz/pubaccount/weishi/profile/d;", "profileViewImpl", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/profile/d;)V", tl.h.F, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c extends AbsWSHeaderPresenter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.tencent.biz.pubaccount.weishi.profile.d profileViewImpl) {
        super(profileViewImpl);
        Intrinsics.checkNotNullParameter(profileViewImpl, "profileViewImpl");
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public boolean H() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter, com.tencent.biz.pubaccount.weishi.profile.header.f
    public void c() {
        stSimpleMetaPerson mPerson = getMPerson();
        if (mPerson == null) {
            x.j("WSGuestPresenter", "onConfirmCancelFollow() mPerson is null");
            return;
        }
        com.tencent.biz.pubaccount.weishi.profile.d F = F();
        com.tencent.biz.pubaccount.weishi.profile.b.o(F != null ? F.getFrom() : null, mPerson.f25130id, mPerson.followStatus);
        jz.g.e().c(mPerson.f25130id, 2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void f(Context context) {
        stPersonExt stpersonext;
        Intrinsics.checkNotNullParameter(context, "context");
        x.b("WSGuestPresenter", "onRightSmallBtnClick() conversation");
        stSimpleMetaPerson mPerson = getMPerson();
        l(context, (mPerson == null || (stpersonext = mPerson.extInfo) == null) ? null : stpersonext.msgSchema, 4);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        x.b("WSGuestPresenter", "onRightBigBtnClick() follow");
        stSimpleMetaPerson mPerson = getMPerson();
        if (mPerson == null) {
            x.j("WSGuestPresenter", "onFollowBtnClick() mPerson is null");
            return;
        }
        if (G()) {
            com.tencent.biz.pubaccount.weishi.profile.d F = F();
            if (F != null) {
                F.g5();
                return;
            }
            return;
        }
        if (!com.tencent.biz.common.util.g.b(BaseApplication.getContext())) {
            ToastUtil.a().b(R.string.f242037th);
            return;
        }
        com.tencent.biz.pubaccount.weishi.profile.d F2 = F();
        com.tencent.biz.pubaccount.weishi.profile.b.o(F2 != null ? F2.getFrom() : null, mPerson.f25130id, mPerson.followStatus);
        jz.g.e().c(mPerson.f25130id, 1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public String x() {
        int i3;
        stSimpleMetaPerson mPerson = getMPerson();
        Integer valueOf = mPerson != null ? Integer.valueOf(mPerson.followStatus) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            i3 = R.string.x8k;
        } else if (valueOf != null && valueOf.intValue() == 3) {
            i3 = R.string.x7e;
        } else {
            i3 = (valueOf != null && valueOf.intValue() == 4) ? R.string.x7c : R.string.x8h;
        }
        return ag.c(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public float y() {
        return 14.0f;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public int z() {
        return R.drawable.gk8;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter
    public String o() {
        return ag.c(R.string.x_a);
    }
}
