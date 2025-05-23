package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ark.ark;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedPermissionChangeEvent;
import com.tencent.biz.qqcircle.immersive.request.QFSChangeFeedPermissionRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bm;
import com.tencent.biz.qqcircle.utils.bu;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bm {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements bu.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f92703a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f92704b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f92705c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f92706d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f92707e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f92708f;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3, long j3, String str2, int i16) {
            this.f92703a = feedCloudMeta$StFeed;
            this.f92704b = str;
            this.f92705c = i3;
            this.f92706d = j3;
            this.f92707e = str2;
            this.f92708f = i16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, int i3) {
            if (!TextUtils.isEmpty(str)) {
                cj.b(false, i3, str);
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.bu.a
        public void a(String str, String str2, boolean z16, final int i3, final String str3) {
            QLog.d("QFSFeedDeleteDialogUtil", 1, "requestGetQZoneFeedDetailData httpsUrl : " + str + "isSuccess : " + z16 + " retCode : " + i3 + " rspMsg : " + str3);
            if (z16 && i3 == 0) {
                bm.l(this.f92703a, this.f92704b, "https://h5.qzone.qq.com/mood/editor?action=update&g_tk=" + this.f92705c, this.f92706d, this.f92707e, this.f92708f, str3);
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.bl
                @Override // java.lang.Runnable
                public final void run() {
                    bm.a.c(str3, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements bu.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f92709a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f92710b;

        b(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f92709a = i3;
            this.f92710b = feedCloudMeta$StFeed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(boolean z16, int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
            if (z16 && i3 == 0) {
                QCircleToast.l(QCircleToast.f91644d, bm.g(i16), 0, true, true);
                SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedJSPermissionChangeEvent(bm.c(i16), feedCloudMeta$StFeed.f398449id.get(), cq.f92752a.q(feedCloudMeta$StFeed), -1, -1), true);
            } else if (!TextUtils.isEmpty(str)) {
                cj.b(false, i3, str);
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.bu.a
        public void a(String str, String str2, final boolean z16, final int i3, final String str3) {
            QLog.d("QFSFeedDeleteDialogUtil", 1, "requestSetQZoneFeedRight httpsUrl : " + str + "\nbody : " + str2 + "\nisSuccess : " + z16 + " retCode : " + i3 + " rspMsg : " + str3);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final int i16 = this.f92709a;
            final FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f92710b;
            uIHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.bn
                @Override // java.lang.Runnable
                public final void run() {
                    bm.b.c(z16, i3, i16, feedCloudMeta$StFeed, str3);
                }
            });
        }
    }

    public static int c(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 4) {
            return 2;
        }
        if (i3 == 16) {
            return 3;
        }
        if (i3 == 64) {
            return 5;
        }
        if (i3 == 128) {
            return 6;
        }
        return 0;
    }

    public static String d(boolean z16) {
        if (z16) {
            return uq3.o.z0("101729", "qzone_feed_action_sheet_title", "\u4f5c\u54c1\u5c06\u88ab\u6c38\u4e45\u5220\u9664\uff0c\u8be5\u89c6\u9891\u7684\u7a7a\u95f4\u52a8\u6001\u4f1a\u540c\u65f6\u5220\u9664\u3002\u4f5c\u54c1\u83b7\u5f97\u7684\u4e92\u52a8\u6570\u636e\uff08\u70b9\u8d5e\u3001\u8bc4\u8bba\u7b49\uff09\u4e5f\u5c06\u6e05\u7a7a\u3002");
        }
        return uq3.o.z0("101729", "qfs_feed_action_sheet_title", "\u4f5c\u54c1\u5c06\u88ab\u6c38\u4e45\u5220\u9664\uff0c\u4e14\u4f5c\u54c1\u6240\u83b7\u5f97\u7684\u4e92\u52a8\u6570\u636e\uff08\u70b9\u8d5e\u3001\u8bc4\u8bba\u7b49\uff09\u4e5f\u5c06\u6e05\u7a7a\u3002");
    }

    private static String e(int i3, long j3, String str) {
        return "https://h5.qzone.qq.com/proxy/domain/taotao.qq.com/cgi-bin/emotion_cgi_msgdetail_v6?t1_source=1&not_trunc_con=1&need_right=1&not_adapt_outpic=1&g_tk=" + i3 + "&uin=" + j3 + "&tid=" + str + "&qua=" + HostDataTransUtils.getQUA3();
    }

    private static String f(long j3, String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", j3);
            jSONObject.put("content", str);
            jSONObject.put("tid", str2);
            jSONObject.put("ugc_right", str3);
            jSONObject.put("allow_uins", str4);
            jSONObject.put("hostUin", j3);
            jSONObject.put("font_size", 0);
            jSONObject.put("hideFlag", 0);
            jSONObject.put("is_feeds_long_pics_browsing_mode", 0);
            jSONObject.put("format", ark.ARKMETADATA_JSON);
            jSONObject.put("inCharset", "utf-8");
            jSONObject.put("outCharset", "utf-8");
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("QFSFeedDeleteDialogUtil", 1, "getRequestBody error : " + e16);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(int i3) {
        int i16;
        if (i3 == 64) {
            i16 = R.string.f188623x7;
        } else if (i3 == 4) {
            i16 = R.string.f188613x6;
        } else {
            i16 = 0;
        }
        if (i16 != 0) {
            return h.a(i16);
        }
        return "";
    }

    public static boolean h() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101728", false);
        boolean equals = TextUtils.equals(l.b("exp_sxj_feed_delete_exp"), "exp_sxj_feed_delete_exp_B");
        QLog.d("QFSFeedDeleteDialogUtil", 1, "hitDeleteDialogOptimizeExp unitedClose : " + isSwitchOn + " isHitExp : " + equals);
        if (isSwitchOn || !equals) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(QFSChangeFeedPermissionRequest qFSChangeFeedPermissionRequest, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
        int i3;
        int i16 = 1;
        QLog.i("QFSFeedDeleteDialogUtil", 1, "requestSetQFSFeedRight traceId:" + qFSChangeFeedPermissionRequest.getTraceId() + " isSuccess:" + z17 + " errorCode" + j3 + " msg:" + str + " isPublic: " + z16);
        if (z17 && j3 == 0) {
            if (z16) {
                i3 = R.string.f188603x5;
            } else {
                i3 = R.string.f188593x4;
            }
            QCircleToast.l(QCircleToast.f91644d, h.a(i3), 0, true, false);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (!z16) {
                i16 = 2;
            }
            simpleEventBus.dispatchEvent(new QFSFeedPermissionChangeEvent(i16, feedCloudMeta$StFeed.f398449id.get()));
            return;
        }
        QCircleToast.l(QCircleToast.f91645e, h.a(R.string.f19228473), 0, true, false);
    }

    public static void j(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String d16 = bu.d("https://h5.qzone.qq.com/mood/editor?action=update");
        int e16 = bu.e(d16);
        long currentAccountLongUin = QCircleCommonUtil.getCurrentAccountLongUin();
        String o16 = cq.f92752a.o(feedCloudMeta$StFeed);
        String e17 = e(e16, currentAccountLongUin, o16);
        QLog.d("QFSFeedDeleteDialogUtil", 1, "requestGetQZoneFeedDetailData");
        bu.j(e17, d16, new a(feedCloudMeta$StFeed, d16, e16, currentAccountLongUin, o16, i3));
    }

    public static void k(@NonNull final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final boolean z16) {
        QLog.d("QFSFeedDeleteDialogUtil", 1, "requestSetQFSFeedRight feedid : " + feedCloudMeta$StFeed.f398449id.get() + " isSetToPublic : " + z16);
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, h.a(R.string.f19228473), 0, true, false);
            QLog.d("QFSFeedDeleteDialogUtil", 1, "requestSetQFSFeedRight fail");
        } else {
            final QFSChangeFeedPermissionRequest qFSChangeFeedPermissionRequest = new QFSChangeFeedPermissionRequest(feedCloudMeta$StFeed, z16);
            VSNetworkHelper.getInstance().sendRequest(qFSChangeFeedPermissionRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.utils.bk
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                    bm.i(QFSChangeFeedPermissionRequest.this, z16, feedCloudMeta$StFeed, baseRequest, z17, j3, str, obj);
                }
            });
        }
    }

    public static void l(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, String str2, long j3, String str3, int i3, String str4) {
        String f16 = f(j3, str4, str3, i3 + "", "");
        QLog.d("QFSFeedDeleteDialogUtil", 1, "requestSetQZoneFeedRight");
        bu.k(str2, str, "application/json", f16, 15000, 15000, new b(i3, feedCloudMeta$StFeed));
    }
}
