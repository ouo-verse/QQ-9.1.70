package com.tencent.biz.qqcircle.immersive.views.search.util;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import circlesearch.CircleSearchExhibition$StliveReserveRsp;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchLiveReserveRequest;
import com.tencent.biz.qqcircle.immersive.views.search.util.d;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import feedcloud.FeedCloudMeta$StFeed;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f91244a;

    /* renamed from: b, reason: collision with root package name */
    private String f91245b;

    /* renamed from: c, reason: collision with root package name */
    private int f91246c;

    /* renamed from: d, reason: collision with root package name */
    private long f91247d;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(long j3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        private final a f91248d;

        b(a aVar) {
            this.f91248d = aVar;
        }

        private void a(AcsSubNoticeRsp acsSubNoticeRsp) {
            int i3 = acsSubNoticeRsp.ret_code;
            if (i3 != 0 && i3 != 5) {
                String str = acsSubNoticeRsp.err_str;
                QLog.i("QFSSearchLiveSubscribeHelper", 1, "SubscribeObserver#processRsp: retCode=" + i3 + ", msg=" + str);
                d.this.m(this.f91248d, (long) i3, str);
                return;
            }
            AcsMsg acsMsg = acsSubNoticeRsp.f25141msg;
            if (acsMsg != null && uq3.n.e(acsMsg.notice_time * 1000)) {
                d.f().saveReminderMsg(acsMsg);
            }
            d.this.o(this.f91248d, true);
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (i3 != 2002) {
                return;
            }
            if (!z16) {
                QLog.i("QFSSearchLiveSubscribeHelper", 1, "SubscribeObserver#onReceive: isSuccess=false");
                d.this.m(this.f91248d, 3L, "system error");
                return;
            }
            AcsSubNoticeRsp acsSubNoticeRsp = (AcsSubNoticeRsp) bundle.getSerializable("rsp");
            if (acsSubNoticeRsp == null) {
                QLog.i("QFSSearchLiveSubscribeHelper", 1, "SubscribeObserver#onReceive: acsSubNoticeRsp=null");
                d.this.m(this.f91248d, 3L, "system error");
            } else {
                a(acsSubNoticeRsp);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private final class c implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        private final a f91250d;

        c(a aVar) {
            this.f91250d = aVar;
        }

        private void c(AcsDelMsgRsp acsDelMsgRsp) {
            int i3 = acsDelMsgRsp.ret_code;
            if (i3 != 0 && i3 != 6) {
                String str = acsDelMsgRsp.err_str;
                QLog.i("QFSSearchLiveSubscribeHelper", 1, "UnsubscribeObserver#processRsp: retCode=" + i3 + ", msg=" + str);
                d.this.m(this.f91250d, (long) i3, str);
                return;
            }
            d.f().deleteReminderByMsgId(d.this.f91244a, new OnDeleteReminderFailListener() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.e
                @Override // com.tencent.mobileqq.reminder.OnDeleteReminderFailListener
                public final void onReminderDeleteFail() {
                    QLog.w("QFSSearchLiveSubscribeHelper", 1, "UnsubscribeObserver#processRsp: fail to delete");
                }
            });
            d.this.o(this.f91250d, false);
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (i3 != 2001) {
                return;
            }
            if (!z16) {
                QLog.i("QFSSearchLiveSubscribeHelper", 1, "UnsubscribeObserver#onReceive: isSuccess=false");
                d.this.m(this.f91250d, 3L, "system error");
                return;
            }
            AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) bundle.getSerializable("rsp");
            if (acsDelMsgRsp == null) {
                QLog.i("QFSSearchLiveSubscribeHelper", 1, "UnsubscribeObserver#onReceive: acsSubNoticeRsp=null");
                d.this.m(this.f91250d, 3L, "system error");
            } else {
                c(acsDelMsgRsp);
            }
        }
    }

    static /* bridge */ /* synthetic */ IQQReminderDataService f() {
        return h();
    }

    private boolean g() {
        boolean z16;
        if (!TextUtils.isEmpty(this.f91244a) && !TextUtils.isEmpty(this.f91245b)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.w("QFSSearchLiveSubscribeHelper", 1, "#checkParams: msgId=" + this.f91244a + ", roomId=" + this.f91245b);
        }
        return z16;
    }

    private static IQQReminderDataService h() {
        return (IQQReminderDataService) QCircleHostStubUtil.getAppRunTime().getRuntimeService(IQQReminderDataService.class, "");
    }

    @NonNull
    private static IQQReminderService i() {
        return (IQQReminderService) QCircleHostStubUtil.getAppRunTime().getRuntimeService(IQQReminderService.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(a aVar, BaseRequest baseRequest, boolean z16, long j3, String str, CircleSearchExhibition$StliveReserveRsp circleSearchExhibition$StliveReserveRsp) {
        if (!z16) {
            QLog.i("QFSSearchLiveSubscribeHelper", 1, "#syncSubscribeStatusToServer: isSuccess=false");
            m(aVar, 3L, "system error");
            return;
        }
        if (j3 != 0) {
            QLog.i("QFSSearchLiveSubscribeHelper", 1, "#syncSubscribeStatusToServer: retCode=" + j3 + ", msg=" + str);
            m(aVar, j3, str);
            return;
        }
        QLog.d("QFSSearchLiveSubscribeHelper", 2, "#syncSubscribeStatusToServer: total cost time=" + (System.currentTimeMillis() - this.f91247d));
        m(aVar, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final a aVar, final long j3, final String str) {
        if (aVar != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.this.a(j3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final a aVar, boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(this.f91246c, new QFSSearchLiveReserveRequest.a().f(this.f91245b).g(z16 ? 1 : 0).b(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                d.this.l(aVar, baseRequest, z17, j3, str, (CircleSearchExhibition$StliveReserveRsp) obj);
            }
        });
    }

    public void j(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String i16 = p.i(feedCloudMeta$StFeed, "live_qq_message_id");
        String i17 = p.i(feedCloudMeta$StFeed, "live_roomid");
        this.f91244a = i16;
        this.f91245b = i17;
        this.f91246c = i3;
    }

    public void n(a aVar) {
        if (!g()) {
            QLog.i("QFSSearchLiveSubscribeHelper", 1, "#subscribe: param invalid");
            m(aVar, 3L, "param error");
        } else {
            this.f91247d = System.currentTimeMillis();
            i().sendSubscribeReminder(this.f91244a, "ti.qq.com", new b(aVar));
        }
    }

    public void p(a aVar) {
        if (!g()) {
            QLog.i("QFSSearchLiveSubscribeHelper", 1, "#unsubscribe: param invalid");
            m(aVar, 3L, "param error");
        } else {
            this.f91247d = System.currentTimeMillis();
            i().sendDelReminderListById(this.f91244a, 0L, 1, new c(aVar));
        }
    }
}
