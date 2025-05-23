package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StUser;
import qqcircle.QQCircleRight$SetCircleUnCareRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleAddBlackListView extends TextView implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private int f92884d;

    /* renamed from: e, reason: collision with root package name */
    private int f92885e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StUser f92886f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f92887d;

        a(ActionSheet actionSheet) {
            this.f92887d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!fb0.a.a("showUnblackUserActionSheetClick")) {
                if (i3 == 0) {
                    QCircleAddBlackListView.this.d(true);
                }
                this.f92887d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleRight$SetCircleUnCareRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f92889a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f92890b;

        b(int i3, int i16) {
            this.f92889a = i3;
            this.f92890b = i16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleRight$SetCircleUnCareRsp qQCircleRight$SetCircleUnCareRsp) {
            if (z16 && j3 == 0) {
                QCircleAddBlackListView.this.k(this.f92889a);
                QCircleAddBlackListView qCircleAddBlackListView = QCircleAddBlackListView.this;
                qCircleAddBlackListView.g(qCircleAddBlackListView.f92886f.f398463id.get());
                QCircleToast.l(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f181343di), 0, true, false);
                SimpleEventBus.getInstance().dispatchEvent(new QCircleAddblackUpdateEvent(this.f92889a, QCircleAddBlackListView.this.f92886f.f398463id.get()));
                QCircleAddBlackListView.e(QCircleAddBlackListView.this.getContext(), QCircleAddBlackListView.this.f92886f.f398463id.get(), 0, this.f92889a);
                return;
            }
            QLog.e("QCircleAddBlackListView", 1, "revertBlackUI:" + this.f92890b + " retCode =" + j3);
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0, true, false);
            QCircleAddBlackListView.this.k(this.f92890b);
        }
    }

    public QCircleAddBlackListView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z16) {
        int i3;
        int i16 = !z16 ? 1 : 0;
        VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
        String str = this.f92886f.f398463id.get();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        vSNetworkHelper.sendRequest(new QCircleSetUnCareRequest(str, i3, 1, null), new b(z16 ? 1 : 0, i16));
    }

    public static void e(Context context, String str, int i3, int i16) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("action_update_web_user_follow_state");
        intent.putExtra("uin", str);
        intent.putExtra("followstate", i3);
        intent.putExtra("blackstate", i16);
        context.sendBroadcast(intent);
    }

    private void h() {
        ActionSheet a16 = ob0.a.a(getContext());
        a16.setMainTitle(getContext().getResources().getString(R.string.f181323dg));
        a16.addButton(R.string.f171151ok, 3);
        a16.addCancelButton(R.string.cancel);
        a16.setOnButtonClickListener(new a(a16));
        if (!a16.isShowing()) {
            a16.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f92886f;
        if (feedCloudMeta$StUser != null) {
            feedCloudMeta$StUser.blackState.set(i3);
        }
        if (getVisibility() == 8) {
            return;
        }
        if (i3 == 0) {
            i();
        } else {
            j();
        }
    }

    protected void f() {
        setOnClickListener(this);
    }

    public void g(String str) {
        Intent intent = new Intent();
        intent.setAction("action_reload_get_main_page");
        intent.putExtra("uin", str);
        if (getContext() != null) {
            getContext().sendBroadcast(intent);
        }
    }

    protected void i() {
        setVisibility(0);
        setTextColor(QCircleSkinHelper.getInstance().getColor(this.f92884d));
        setText(R.string.f181513dz);
    }

    protected void j() {
        setVisibility(0);
        setTextColor(QCircleSkinHelper.getInstance().getColor(this.f92885e));
        setText(R.string.f184693mk);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QCircleblackViewClick") && (feedCloudMeta$StUser = this.f92886f) != null) {
            if (feedCloudMeta$StUser.blackState.get() == 1) {
                d(false);
            } else if (this.f92886f.blackState.get() == 0) {
                h();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setUserData(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f92886f = feedCloudMeta$StUser;
        k(feedCloudMeta$StUser.blackState.get());
    }

    public QCircleAddBlackListView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleAddBlackListView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449889y6);
        this.f92884d = obtainStyledAttributes.getResourceId(y91.a.C6, R.color.qui_common_text_secondary);
        this.f92885e = obtainStyledAttributes.getResourceId(y91.a.G6, R.color.qui_common_text_primary);
        obtainStyledAttributes.recycle();
        f();
    }
}
