package com.tencent.biz.qqcircle.debug;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.google.gson.Gson;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDeliveryContentRequest;
import com.tencent.biz.qqcircle.requests.QCircleFeedbackHitRequest;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StDeliveryContentResp;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleFeedbackhit$StFeedbackCommonInfo;
import qqcircle.QQCircleFeedbackhit$StSetFeedbackHitRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f84163d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f84164e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QCircleShareInfo f84165f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f84166h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f84167i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f84168m;

        a(ActionSheet actionSheet, Activity activity, QCircleShareInfo qCircleShareInfo, String str, String str2, String str3, String str4) {
            this.f84163d = actionSheet;
            this.f84164e = activity;
            this.f84165f = qCircleShareInfo;
            this.f84166h = str;
            this.f84167i = str2;
            this.f84168m = str3;
            this.C = str4;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!fb0.a.a("showMoreActionSheetClick")) {
                String content = this.f84163d.getContent(i3);
                if (TextUtils.isEmpty(content)) {
                    return;
                }
                if (content.equals("\u672c\u6761\u5185\u5bb9\u589e\u52a01K\u66dd\u5149\u91cf")) {
                    b.l(this.f84164e, this.f84165f.feed, "\u672c\u6761\u5185\u5bb9\u589e\u52a01K\u66dd\u5149\u91cf", 1000);
                } else if (content.equals("\u672c\u6761\u5185\u5bb9\u589e\u52a05K\u66dd\u5149\u91cf")) {
                    b.l(this.f84164e, this.f84165f.feed, "\u672c\u6761\u5185\u5bb9\u589e\u52a05K\u66dd\u5149\u91cf", 5000);
                } else if (content.equals("\u672c\u6761\u5185\u5bb9\u589e\u52a010K\u66dd\u5149\u91cf")) {
                    b.l(this.f84164e, this.f84165f.feed, "\u672c\u6761\u5185\u5bb9\u589e\u52a010K\u66dd\u5149\u91cf", 10000);
                } else if (content.equals(this.f84166h)) {
                    b.k(this.f84164e, this.f84165f.feed, this.f84166h);
                } else if (content.equals(this.f84167i)) {
                    b.j(this.f84164e, this.f84165f.feed, this.f84167i);
                } else if (content.equals(this.f84168m)) {
                    b.i(this.f84164e, this.f84165f.feed, this.f84168m);
                } else if (content.equals(this.C)) {
                    b.h(this.f84164e, this.f84165f.feed, this.C);
                }
                this.f84163d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.debug.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class DialogInterfaceOnClickListenerC0859b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0859b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f84169d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f84170e;

        c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            this.f84169d = feedCloudMeta$StFeed;
            this.f84170e = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            b.n(this.f84169d, this.f84170e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f84171d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f84172e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f84173f;

        e(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
            this.f84171d = feedCloudMeta$StFeed;
            this.f84172e = i3;
            this.f84173f = i16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            b.m(this.f84171d, this.f84172e, this.f84173f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements VSDispatchObserver.OnVSRspCallBack<QQCircleFeedbackhit$StSetFeedbackHitRsp> {
        f() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleFeedbackhit$StSetFeedbackHitRsp qQCircleFeedbackhit$StSetFeedbackHitRsp) {
            if (TextUtils.isEmpty(str) && j3 == 0) {
                str = WinkBaseErrorCodeKt.ERROR_MSG_OK;
            }
            QCircleToast.o(str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements VSDispatchObserver.OnVSRspCallBack<FeedCloudMeta$StDeliveryContentResp> {
        g() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudMeta$StDeliveryContentResp feedCloudMeta$StDeliveryContentResp) {
            if (TextUtils.isEmpty(str) && j3 == 0) {
                str = WinkBaseErrorCodeKt.ERROR_MSG_OK;
            }
            QCircleToast.o(str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        o(activity, feedCloudMeta$StFeed, str, 2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        o(activity, feedCloudMeta$StFeed, str, 4, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        o(activity, feedCloudMeta$StFeed, str, 3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        o(activity, feedCloudMeta$StFeed, str, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3) {
        QCircleCustomDialog.O(activity).c0(str).f0(R.string.f171151ok, new c(feedCloudMeta$StFeed, i3)).d0(R.string.cancel, new DialogInterfaceOnClickListenerC0859b()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        QQCircleFeedbackhit$StFeedbackCommonInfo qQCircleFeedbackhit$StFeedbackCommonInfo = new QQCircleFeedbackhit$StFeedbackCommonInfo();
        qQCircleFeedbackhit$StFeedbackCommonInfo.feedId.set(feedCloudMeta$StFeed.f398449id.get());
        qQCircleFeedbackhit$StFeedbackCommonInfo.sourceUin.set(feedCloudMeta$StFeed.poster.f398463id.get());
        qQCircleFeedbackhit$StFeedbackCommonInfo.operationUin.set(HostDataTransUtils.getAccount());
        qQCircleFeedbackhit$StFeedbackCommonInfo.level.set(i16);
        String str = feedCloudMeta$StFeed.poster.nick.get();
        if (TextUtils.isEmpty(str)) {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        qQCircleFeedbackhit$StFeedbackCommonInfo.sourceUinName.set(str);
        VSNetworkHelper.getInstance().sendRequest(new QCircleFeedbackHitRequest(qQCircleFeedbackhit$StFeedbackCommonInfo, i3, new FeedCloudCommon$StCommonExt()), new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        long j3 = 0;
        for (FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry : feedCloudMeta$StFeed.debugInfo.debugMapBytes.get()) {
            if ("FeedYuHengInfo".equals(feedCloudCommon$BytesEntry.key.get())) {
                try {
                    j3 = ((c30.a) new Gson().fromJson(feedCloudCommon$BytesEntry.value.get().toStringUtf8(), c30.a.class)).contentId.longValue();
                } catch (Exception e16) {
                    QLog.i("QCircleDebugActionSheet", 1, "sendIncreaseExposureRequest exception:", e16);
                }
            }
        }
        if (j3 <= 0) {
            QCircleToast.o("ContentID\u83b7\u53d6\u5931\u8d25", 1);
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QCircleDeliveryContentRequest(29758, i3, j3), new g());
        }
    }

    private static void o(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3, int i16) {
        QCircleCustomDialog.O(activity).c0(str).f0(R.string.f171151ok, new e(feedCloudMeta$StFeed, i3, i16)).d0(R.string.cancel, new d()).show();
    }

    public static void p(Activity activity, QCircleShareInfo qCircleShareInfo) {
        if (qCircleShareInfo != null && qCircleShareInfo.feed != null && activity != null) {
            ActionSheet a16 = ob0.a.a(activity);
            String string = activity.getResources().getString(R.string.f182343g8);
            String string2 = activity.getResources().getString(R.string.f182353g9);
            String string3 = activity.getResources().getString(R.string.f181983f9);
            String string4 = activity.getResources().getString(R.string.f181973f8);
            if (qCircleShareInfo.feed.opMask2.get().contains(28)) {
                a16.addButton("\u672c\u6761\u5185\u5bb9\u589e\u52a01K\u66dd\u5149\u91cf", 0);
                a16.addButton("\u672c\u6761\u5185\u5bb9\u589e\u52a05K\u66dd\u5149\u91cf", 0);
                a16.addButton("\u672c\u6761\u5185\u5bb9\u589e\u52a010K\u66dd\u5149\u91cf", 0);
            }
            a16.addButton(string, 0);
            a16.addButton(string2, 0);
            a16.addButton(string3, 0);
            a16.addButton(string4, 0);
            a16.addCancelButton(R.string.cancel);
            a16.setOnButtonClickListener(new a(a16, activity, qCircleShareInfo, string2, string, string3, string4));
            if (!a16.isShowing()) {
                a16.show();
            }
        }
    }
}
