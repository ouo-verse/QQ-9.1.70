package eb0;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoFollowRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements RspInterceptor<QCircleBaseRequest, BaseSenderChain> {

    /* renamed from: a, reason: collision with root package name */
    public static String f396059a = "req_extra_key_new_follow_state";

    private void a(Context context, String str, int i3) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("action_update_web_user_follow_state");
        intent.putExtra("uin", str);
        intent.putExtra("followstate", i3);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.richframework.sender.interceptor.RspInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void interceptReturnRsp(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain) {
        boolean z17;
        String a16;
        if ((obj instanceof FeedCloudWrite$StDoFollowRsp) && (qCircleBaseRequest instanceof QCircleDoFollowRequest)) {
            QCircleDoFollowRequest qCircleDoFollowRequest = (QCircleDoFollowRequest) qCircleBaseRequest;
            int i3 = baseSenderChain.getExtraData().getInt(f396059a);
            if (z16 && j3 == 0) {
                FeedCloudMeta$StUser feedCloudMeta$StUser = qCircleDoFollowRequest.getReq().user;
                if (i3 == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                QCircleRelationGroupManager.instance().updateFollowFriendListToDB(feedCloudMeta$StUser.f398463id.get(), feedCloudMeta$StUser.nick.get(), z17);
                x20.c.e(new y20.a(feedCloudMeta$StUser.f398463id.get(), i3));
                QCircleFollowUpdateEvent qCircleFollowUpdateEvent = new QCircleFollowUpdateEvent(i3, feedCloudMeta$StUser.f398463id.get(), true);
                if (baseSenderChain.getListener() != null) {
                    qCircleFollowUpdateEvent.mHashCode = baseSenderChain.getListener().hashCode();
                }
                SimpleEventBus.getInstance().dispatchEvent(qCircleFollowUpdateEvent);
                QCircleFollowManager.getInstance().setUinFollowed(feedCloudMeta$StUser.f398463id.get(), i3);
                a(QCircleApplication.APP, feedCloudMeta$StUser.f398463id.get(), i3);
                int i16 = QCircleToast.f91646f;
                if (QCirclePluginUtil.isFollow(i3)) {
                    a16 = h.a(R.string.f183353iy);
                } else {
                    a16 = h.a(R.string.f185443ol);
                }
                QCircleToast.l(i16, a16, 0, true, r.E0());
            } else {
                QCircleToast.l(QCircleToast.f91645e, str, 0, true, r.E0());
            }
        }
        baseSenderChain.handleRsp(z16, j3, str, qCircleBaseRequest, obj);
    }
}
