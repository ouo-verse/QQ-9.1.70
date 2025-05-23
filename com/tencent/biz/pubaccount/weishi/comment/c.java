package com.tencent.biz.pubaccount.weishi.comment;

import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tribe.async.dispatch.QQUIEventReceiver;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends QQUIEventReceiver<WsCommentPresenter, wz.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WsCommentPresenter wsCommentPresenter) {
        super(wsCommentPresenter);
    }

    private boolean a(Object[] objArr) {
        return (objArr.length < 3 || this.mRef.get() == null || ((Integer) objArr[2]).intValue() == ((WsCommentPresenter) this.mRef.get()).hashCode()) ? false : true;
    }

    @Override // com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect
    public Class acceptEventClass() {
        return wz.a.class;
    }

    @Override // com.tribe.async.dispatch.QQUIEventReceiver
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onEvent(WsCommentPresenter wsCommentPresenter, wz.a aVar) {
        x.i("comment", "[WSCommentEventReceiver.java][onEvent] commentEvent.mEventAction:" + aVar.f96002d + ", commentPresenter:" + wsCommentPresenter);
        int i3 = aVar.f96002d;
        if (i3 == 1) {
            wsCommentPresenter.w0();
            return;
        }
        if (i3 == 2) {
            wsCommentPresenter.V();
            return;
        }
        if (i3 != 4) {
            if (i3 != 6) {
                x.i("comment", "[WSCommentEventReceiver.java][onEvent] default process,commentEvent.mEventAction:" + aVar.f96002d);
                return;
            }
            wsCommentPresenter.T((Object[]) aVar.f96003e);
            return;
        }
        Object obj = aVar.f96003e;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (a(objArr)) {
                return;
            }
            int intValue = ((Integer) objArr[0]).intValue();
            wsCommentPresenter.v0(intValue);
            stSimpleMetaFeed e16 = ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) objArr[1]).e();
            x.i("comment", "[WSCommentEventReceiver.java][onEvent] , feedId:" + e16.f25129id + ", position:" + intValue + ",feed desc:" + e16.feed_desc);
            wsCommentPresenter.r0(e16);
        }
        x.i("comment", "[WSCommentEventReceiver.java][onEvent] event page change, position:" + wsCommentPresenter.M() + " feedId:" + wsCommentPresenter.I());
        wsCommentPresenter.k0();
        q D = wsCommentPresenter.D();
        if (!wsCommentPresenter.c0() || D == null) {
            return;
        }
        Handler n3 = D.n();
        n3.removeMessages(11);
        n3.sendMessageDelayed(n3.obtainMessage(11), 20L);
    }
}
