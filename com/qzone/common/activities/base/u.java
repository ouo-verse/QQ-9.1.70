package com.qzone.common.activities.base;

import android.view.View;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;

/* compiled from: P */
@Named("BaseFeedFragmentRecommendFriendImp")
/* loaded from: classes39.dex */
public class u implements d5.aa {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements d5.d<View> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f45546a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f45547b;

        a(long j3, boolean z16) {
            this.f45546a = j3;
            this.f45547b = z16;
        }

        @Override // d5.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean accept(View view) {
            BusinessFeedData businessFeedData;
            if (view instanceof AbsFeedView) {
                AbsFeedView absFeedView = (AbsFeedView) view;
                if ((absFeedView instanceof NormalAbsFeedView) && (businessFeedData = absFeedView.mFeedData) != null && businessFeedData.getFeedCommInfo().isMayKnowFriendFeed() && businessFeedData.getUser().uin == this.f45546a) {
                    businessFeedData.getFeedCommInfo().isFriendAdded = this.f45547b;
                    absFeedView.requestLayout();
                }
            }
            return false;
        }
    }

    @Inject
    public u() {
    }

    private void b(d5.m mVar, long j3, boolean z16) {
        if (mVar == null) {
            return;
        }
        mVar.s(new a(j3, z16));
    }

    @Override // d5.aa
    public void a(d5.m mVar, int i3, int i16) {
        if (i16 == 0) {
            com.qzone.feed.business.model.c.d().g(false, null, null, i3);
            return;
        }
        if (i16 == -1) {
            int c16 = com.qzone.feed.business.model.c.d().c();
            b(mVar, com.qzone.feed.business.model.c.d().b(), true);
            View b16 = (mVar == null || !mVar.u()) ? null : mVar.b(c16);
            String valueOf = com.qzone.feed.business.model.c.d().b() > 0 ? String.valueOf(com.qzone.feed.business.model.c.d().b()) : null;
            if (b16 instanceof AbsFeedView) {
                com.qzone.feed.business.model.c.d().g(true, (AbsFeedView) b16, valueOf, i3);
            } else {
                com.qzone.feed.business.model.c.d().g(true, null, valueOf, i3);
            }
        }
    }
}
