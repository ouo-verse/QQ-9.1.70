package ha0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QFSInteractActionEvent;
import com.tencent.biz.qqcircle.helpers.d;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCirclePraiseFakeInterceptor;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import java.util.List;
import qqcircle.QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase$StLikeBusiData;
import qqcircle.QQCircleFeedBase$StPolyLike;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile QCirclePraiseFakeInterceptor f404609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Call.OnRspCallBack {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f404610d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f404611e;

        a(boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f404610d = z16;
            this.f404611e = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
            if (obj2 == null) {
                QLog.d("PL-QCirclePolyLikeManager", 1, "rspObj is null");
                return;
            }
            if (z16 && j3 == 0) {
                if (this.f404610d) {
                    QLog.d("PL-QCirclePolyLikeManager", 1, "doLike success");
                } else {
                    QLog.d("PL-QCirclePolyLikeManager", 1, "doUnLike success");
                }
                if (this.f404611e != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSInteractActionEvent(this.f404611e.f398449id.get(), 5));
                    return;
                }
                return;
            }
            cj.b(true, j3, str);
            if (this.f404610d) {
                QLog.d("PL-QCirclePolyLikeManager", 1, "doLike failed, retCode:" + j3 + ", msg:" + str);
                return;
            }
            QLog.d("PL-QCirclePolyLikeManager", 1, "doUnLike failed, retCode:" + j3 + ", msg:" + str);
        }
    }

    private static QCircleDoLikeRequest a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, Context context) throws InvalidProtocolBufferMicroException {
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        FeedCloudMeta$StLike deepCopyLike = QCirclePluginUtil.deepCopyLike(feedCloudMeta$StFeed.likeInfo);
        QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData = new QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData();
        QQCircleFeedBase$StPolyLike f16 = f("6");
        QQCircleFeedBase$StPolyLike b16 = b(feedCloudMeta$StFeed);
        if (!z16 && b16 == null) {
            return null;
        }
        if (!g(feedCloudMeta$StFeed) && z16 && b16 != null && TextUtils.equals(b16.polyLikeID.get(), "6")) {
            return null;
        }
        if (z16) {
            qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(f16);
        } else {
            qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData.curPolyLikeInfo.set(b16);
        }
        return new QCircleDoLikeRequest(feedCloudMeta$StFeed, z16 ? 1 : 0, deepCopyLike, qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData, false, false, z16, QCirclePluginUtil.getQCircleInitBean(context));
    }

    public static QQCircleFeedBase$StPolyLike b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase$StLikeBusiData();
        try {
            qQCircleFeedBase$StLikeBusiData.mergeFrom(feedCloudMeta$StFeed.likeInfo.get().busiData.get().toByteArray());
            return c(qQCircleFeedBase$StLikeBusiData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("PL-QCirclePolyLikeManager", 1, "getCurPolyLike error:" + e16);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r0.contains("205993") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static QQCircleFeedBase$StPolyLike c(QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData) {
        List<String> list;
        if (qQCircleFeedBase$StLikeBusiData == null || (list = qQCircleFeedBase$StLikeBusiData.likeIDs.get()) == null || list.size() == 0) {
            return null;
        }
        String str = list.get(0);
        String str2 = "6";
        if (!list.contains("6")) {
            str2 = "1";
            if (!list.contains("1")) {
                str2 = "10";
                if (!list.contains("10")) {
                    String str3 = "206008";
                    if (!str.contains("206008")) {
                        str3 = "205993";
                    }
                    str = str3;
                    return f(str);
                }
            }
        }
        str = str2;
        return f(str);
    }

    public static int d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return 0;
        }
        QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase$StLikeBusiData();
        try {
            qQCircleFeedBase$StLikeBusiData.mergeFrom(feedCloudMeta$StFeed.likeInfo.get().busiData.get().toByteArray());
            return e(qQCircleFeedBase$StLikeBusiData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("PL-QCirclePolyLikeManager", 1, "getFreePolyLikeCount error:" + e16);
            return 0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [int, boolean] */
    public static int e(QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData) {
        List<String> list;
        if (qQCircleFeedBase$StLikeBusiData != null && (list = qQCircleFeedBase$StLikeBusiData.likeIDs.get()) != null) {
            ?? contains = list.contains("10");
            int i3 = contains;
            if (list.contains("1")) {
                i3 = contains + 1;
            }
            if (list.contains("6")) {
                return i3 + 1;
            }
            return i3;
        }
        return 0;
    }

    public static QQCircleFeedBase$StPolyLike f(String str) {
        QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike = new QQCircleFeedBase$StPolyLike();
        qQCircleFeedBase$StPolyLike.polyLikeID.set(str);
        return qQCircleFeedBase$StPolyLike;
    }

    public static boolean g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        PBRepeatField<Integer> pBRepeatField;
        if (feedCloudMeta$StFeed != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && pBRepeatField.get().contains(15)) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("PL-QCirclePolyLikeManager", 1, "openCancelLike:" + z16);
        return z16;
    }

    public static void h(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, Context context) {
        QCircleDoLikeRequest qCircleDoLikeRequest;
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.o(h.a(R.string.ci8), 0);
            return;
        }
        if (d.a(1, true)) {
            QLog.d("PL-QCirclePolyLikeManager", 1, "forbid like and unlike because of sencebeat");
            return;
        }
        try {
            qCircleDoLikeRequest = a(feedCloudMeta$StFeed, z16, context);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("PL-QCirclePolyLikeManager", 1, "[requestDoLike]InvalidProtocolBufferMicroException error:" + e16);
            qCircleDoLikeRequest = null;
        }
        if (qCircleDoLikeRequest == null) {
            QLog.d("PL-QCirclePolyLikeManager", 1, "request is null");
        } else {
            f404609a = new QCirclePraiseFakeInterceptor(true, null);
            com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addInterceptor(f404609a).addReqInterceptor(new db0.b()).addRequest(qCircleDoLikeRequest).m250setRspOnCallBack((Call.OnRspCallBack) new a(z16, feedCloudMeta$StFeed)).execute();
        }
    }
}
