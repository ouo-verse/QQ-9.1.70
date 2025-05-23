package com.tencent.biz.qqcircle.immersive.views.searchsquare;

import android.text.TextUtils;
import circlesearch.CircleSearchExhibition$SquareBubbleInfo;
import circlesearch.CircleSearchExhibition$StSquareRsp;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.request.QFSSquareGetDataRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f91312a = new LinkedList();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.searchsquare.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0918a implements VSDispatchObserver.OnVSRspCallBack<CircleSearchExhibition$StSquareRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSSquareGetDataRequest f91313a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f91314b;

        C0918a(QFSSquareGetDataRequest qFSSquareGetDataRequest, b bVar) {
            this.f91313a = qFSSquareGetDataRequest;
            this.f91314b = bVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CircleSearchExhibition$StSquareRsp circleSearchExhibition$StSquareRsp) {
            this.f91313a.reportCmdSuccessRate(j3, str);
            if (this.f91314b == null) {
                return;
            }
            if (z16 && j3 == 0) {
                if (circleSearchExhibition$StSquareRsp.bubble_info.has()) {
                    this.f91314b.a(circleSearchExhibition$StSquareRsp.bubble_info.get());
                    return;
                }
                str = "empty data";
            }
            QLog.w("QFSSquareSearchHelper", 1, "#requestData: fail, code=" + j3 + ", errorMessage=" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(CircleSearchExhibition$SquareBubbleInfo circleSearchExhibition$SquareBubbleInfo);
    }

    private String e(String str, String str2) {
        return str + "," + str2;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f91312a.add(0, e(str, str2));
        }
    }

    public void b() {
        this.f91312a.clear();
    }

    public boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return this.f91312a.contains(e(str, str2));
        }
        return true;
    }

    public void d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, b bVar) {
        QFSSquareGetDataRequest b16 = new QFSSquareGetDataRequest.a().g(1).f(feedCloudMeta$StFeed.f398449id.get()).b();
        VSNetworkHelper.getInstance().sendRequest(b16, new C0918a(b16, bVar));
    }
}
