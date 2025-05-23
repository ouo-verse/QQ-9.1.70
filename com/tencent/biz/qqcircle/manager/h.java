package com.tencent.biz.qqcircle.manager;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.events.QFSCallFriendFollowBackEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSCallFriendFollowBackRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite$StBatchCallFollowRsp;
import feedcloud.FeedCloudWrite$StCallFollowRsp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f91569b;

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f91570a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StBatchCallFollowRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f91571a;

        a(String str) {
            this.f91571a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StBatchCallFollowRsp feedCloudWrite$StBatchCallFollowRsp) {
            if (z16 && j3 == 0) {
                if (feedCloudWrite$StBatchCallFollowRsp != null && feedCloudWrite$StBatchCallFollowRsp.results.size() >= 1) {
                    for (FeedCloudWrite$StCallFollowRsp feedCloudWrite$StCallFollowRsp : feedCloudWrite$StBatchCallFollowRsp.results.get()) {
                        if (feedCloudWrite$StCallFollowRsp.uid.get().equals(this.f91571a)) {
                            QCircleToast.o(feedCloudWrite$StCallFollowRsp.f398482msg.get(), 0);
                            QLog.d("QFSCallFriendFollowBackManager", 1, "Call friend follow back retCode: " + feedCloudWrite$StCallFollowRsp.code.get());
                            return;
                        }
                    }
                    return;
                }
                QLog.e("QFSCallFriendFollowBackManager", 1, "Call friend follow back fail. result size: 0");
                return;
            }
            QLog.e("QFSCallFriendFollowBackManager", 1, "Call friend follow back fail. retCode: " + j3);
        }
    }

    public static h b() {
        if (f91569b == null) {
            synchronized (h.class) {
                if (f91569b == null) {
                    f91569b = new h();
                }
            }
        }
        return f91569b;
    }

    public void a(String str) {
        this.f91570a.add(str);
    }

    public void c(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2);
        SimpleEventBus.getInstance().dispatchEvent(new QFSCallFriendFollowBackEvent(str, str2, i3));
        VSNetworkHelper.getInstance().sendRequest(new QFSCallFriendFollowBackRequest(str2), new a(str2));
    }
}
