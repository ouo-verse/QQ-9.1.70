package com.qzone.common.activities.base;

import android.content.Intent;
import android.os.Message;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.luan.ioc.annotation.Inject;

/* loaded from: classes39.dex */
public class BaseFeedFragmentFeedPresenterImp implements d5.o<BusinessFeedData> {

    /* renamed from: a, reason: collision with root package name */
    protected d5.u f45044a;

    /* renamed from: b, reason: collision with root package name */
    protected BaseFeedPresenter f45045b = null;

    /* renamed from: c, reason: collision with root package name */
    protected com.qzone.common.logic.presenter.a f45046c;

    @Inject
    public BaseFeedFragmentFeedPresenterImp() {
    }

    @Override // d5.o
    public void a() {
        BaseFeedPresenter baseFeedPresenter = this.f45045b;
        if (baseFeedPresenter != null) {
            baseFeedPresenter.i();
        }
    }

    @Override // d5.o
    public void b(Message message) {
        BaseFeedPresenter baseFeedPresenter = this.f45045b;
        if (baseFeedPresenter != null) {
            baseFeedPresenter.A0(message);
        }
    }

    @Override // d5.o
    public void c(d5.m<BusinessFeedData> mVar, int i3) {
        if (this.f45045b == null) {
            return;
        }
        BusinessFeedData t16 = mVar.t(i3);
        if (t16 == null || !t16.isFriendLikeContainer()) {
            if (t16 == null || (!t16.isFriendVideoFeed() && t16.cellFollowGuide == null)) {
                if (t16 == null || !t16.isFriendFeedReadLineFeed()) {
                    if (t16 == null || !t16.isQQLiveFeed()) {
                        if (t16 == null || !com.qzone.proxy.feedcomponent.model.c.b(t16)) {
                            this.f45045b.o0(t16, i3, true, new Object[0]);
                            if (t16 == null || !t16.getFeedCommInfo().needAdvReport()) {
                                return;
                            }
                            int i16 = t16.getFeedCommInfo().actiontype;
                            if (i16 == 20 && t16.getOperationInfo().actionType != 0) {
                                i16 = t16.getOperationInfo().actionType;
                            }
                            int i17 = i16;
                            if (t16.getFeedCommInfo().isVideoAdv()) {
                                return;
                            }
                            this.f45045b.v0(null, t16, i3, 9, i17, 0);
                        }
                    }
                }
            }
        }
    }

    @Override // d5.o
    public void d(d5.k<BusinessFeedData> kVar, int i3, int i16) {
        BaseFeedPresenter baseFeedPresenter = this.f45045b;
        if (baseFeedPresenter != null) {
            baseFeedPresenter.H0(kVar.b(), i3, i16);
        }
    }

    @Override // d5.o
    public void destroy() {
        BaseFeedPresenter baseFeedPresenter = this.f45045b;
        if (baseFeedPresenter != null) {
            baseFeedPresenter.t0();
        }
        this.f45045b = null;
        com.qzone.common.logic.presenter.a aVar = this.f45046c;
        if (aVar != null) {
            aVar.b();
        }
        this.f45046c = null;
    }

    protected BaseFeedPresenter e() {
        return new BaseFeedPresenter((QZoneBaseFeedFragment) this.f45044a.getFragment());
    }

    public BaseFeedPresenter f() {
        return this.f45045b;
    }

    public b6.a g() {
        return this.f45046c;
    }

    @Override // d5.o
    public void init() {
        if (this.f45045b == null) {
            BaseFeedPresenter e16 = e();
            this.f45045b = e16;
            this.f45046c = new com.qzone.common.logic.presenter.a(e16);
        }
    }

    @Override // d5.o
    public boolean onActivityResult(int i3, int i16, Intent intent) {
        BaseFeedPresenter baseFeedPresenter = this.f45045b;
        if (baseFeedPresenter == null) {
            return false;
        }
        switch (i3) {
            case 1205:
                baseFeedPresenter.F0(intent);
                return true;
            case 1206:
                baseFeedPresenter.z0(intent);
                return true;
            case 1207:
                baseFeedPresenter.u(intent);
                return true;
            case 1208:
                baseFeedPresenter.s(intent);
                return true;
            default:
                return false;
        }
    }

    @Override // d5.o
    public void onPause() {
        BaseFeedPresenter baseFeedPresenter = this.f45045b;
        if (baseFeedPresenter != null) {
            baseFeedPresenter.C0();
        }
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45044a = uVar;
    }
}
