package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSInteractActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSSendFollowedReqEvent;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.fake.a;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleMultiFollowUpdateEvent;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoFollowReq;
import feedcloud.FeedCloudWrite$StDoFollowRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSFollowView extends TextView implements View.OnClickListener, SimpleEventReceiver {
    private c C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private String M;
    private Map<String, Object> N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private String T;
    private boolean U;
    private String V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    protected int f93227a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f93228b0;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f93229d;

    /* renamed from: e, reason: collision with root package name */
    protected FeedCloudMeta$StUser f93230e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StFeed f93231f;

    /* renamed from: h, reason: collision with root package name */
    private final Call.OnRspCallBack f93232h;

    /* renamed from: i, reason: collision with root package name */
    private List<e> f93233i;

    /* renamed from: m, reason: collision with root package name */
    private d f93234m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b();

        void c(int i3);

        void onClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void beforeClick();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class f implements Call.OnRspCallBack {
        f() {
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
            String str2;
            FeedCloudMeta$StUser feedCloudMeta$StUser;
            FeedCloudMeta$StUser feedCloudMeta$StUser2 = QFSFollowView.this.f93230e;
            String str3 = null;
            if (feedCloudMeta$StUser2 == null) {
                str2 = null;
            } else {
                str2 = feedCloudMeta$StUser2.f398463id.get();
            }
            QLog.d("QFSFollowView", 1, "doFollow: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str + ", curUin = " + str2);
            if (obj2 instanceof a.C0926a) {
                a.C0926a c0926a = (a.C0926a) obj2;
                if (!TextUtils.equals(c0926a.f92010a, str2)) {
                    QLog.e("QFSFollowView", 1, "[doFollow] receive fake rsp, but uin not equals, curUin = " + str2 + ", fakeRspUin = " + c0926a.f92010a);
                    return;
                }
                if (z16) {
                    QFSFollowView.this.I(c0926a.f92012c, true);
                } else {
                    QFSFollowView.this.I(c0926a.f92011b, true);
                }
            }
            if ((obj2 instanceof FeedCloudWrite$StDoFollowRsp) && (obj instanceof QCircleDoFollowRequest) && bundle != null) {
                FeedCloudWrite$StDoFollowReq req = ((QCircleDoFollowRequest) obj).getReq();
                if (req != null && (feedCloudMeta$StUser = req.user) != null) {
                    str3 = feedCloudMeta$StUser.f398463id.get();
                }
                if (!TextUtils.equals(str3, str2)) {
                    QLog.e("QFSFollowView", 1, "[doFollow] real rsp, but uin not equals, curUin = " + str2 + ", reqUin = " + str3);
                    return;
                }
                int i3 = bundle.getInt(eb0.a.f396059a);
                if (z16 && j3 == 0) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSInteractActionEvent(str3, 6));
                    QFSFollowView.this.s(i3);
                    QFSFollowView qFSFollowView = QFSFollowView.this;
                    if (qFSFollowView.f93230e != null && qFSFollowView.C != null) {
                        QFSFollowView.this.C.O(QCirclePluginUtil.isFollow(i3), QFSFollowView.this.f93230e);
                        return;
                    }
                    return;
                }
                if (QFSFollowView.this.f93234m != null) {
                    QFSFollowView.this.f93234m.b();
                }
            }
        }
    }

    public QFSFollowView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(ActionSheet actionSheet, View view, int i3, String str) {
        B(str, actionSheet);
    }

    private void B(String str, ActionSheet actionSheet) {
        if (fb0.a.a("showUnFollowUserActionSheetClick") || this.f93230e == null) {
            return;
        }
        if (com.tencent.biz.qqcircle.utils.h.a(R.string.f188023vk).equals(str)) {
            p();
        } else if (com.tencent.biz.qqcircle.utils.h.a(R.string.f184853n0).equals(str)) {
            v();
        } else if (com.tencent.biz.qqcircle.utils.h.a(R.string.f181743el).equals(str)) {
            r();
        } else if (com.tencent.biz.qqcircle.utils.h.a(R.string.f196244gs).equals(str)) {
            w();
        } else if (!TextUtils.isEmpty(this.V) && this.V.equals(str)) {
            q();
        }
        actionSheet.dismiss();
        k(str);
    }

    private void M(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        int i3;
        this.f93230e.f398463id.set(feedCloudMeta$StUser.f398463id.get());
        this.f93230e.nick.set(feedCloudMeta$StUser.nick.get());
        this.f93230e.blackState.set(feedCloudMeta$StUser.blackState.get());
        this.f93230e.relationState.set(feedCloudMeta$StUser.relationState.get());
        this.f93230e.frdState.set(feedCloudMeta$StUser.frdState.get());
        if (!TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get()) && !QCirclePluginUtil.isOwner(feedCloudMeta$StUser)) {
            this.f93227a0 = Integer.MIN_VALUE;
            if (QCircleFollowManager.getInstance().hasUin(feedCloudMeta$StUser.f398463id.get())) {
                i3 = QCircleFollowManager.getInstance().getUinFollowed(feedCloudMeta$StUser.f398463id.get()).intValue();
            } else {
                i3 = feedCloudMeta$StUser.followState.get();
            }
            H(i3);
            J();
            return;
        }
        setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N() {
        MutableLiveData globalData = w20.a.j().getGlobalData(com.tencent.biz.qqcircle.immersive.personal.data.w.class, this.f93230e.f398463id.get());
        if (globalData != null && globalData.getValue() != 0) {
            M(((com.tencent.biz.qqcircle.immersive.personal.data.w) globalData.getValue()).c());
        }
    }

    private SpannableStringBuilder g(@NonNull SpannableStringBuilder spannableStringBuilder) {
        setMovementMethod(LinkMovementMethod.getInstance());
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(R.drawable.l8y);
        drawable.setBounds(0, 0, cx.a(9.0f), cx.a(9.0f));
        nb0.d dVar = new nb0.d(drawable, 0);
        dVar.a(ImmersiveUtils.dpToPx(4.0f), 0);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.setSpan(dVar, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    private boolean h() {
        if (((getContext() instanceof Activity) && ((Activity) getContext()).isFinishing()) || ((getContext() instanceof Activity) && ((Activity) getContext()).isDestroyed())) {
            return true;
        }
        return false;
    }

    private void k(String str) {
        if (this.f93230e == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_POPUP_CONTENT);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_item_name", str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void l(String str) {
        if (this.f93230e == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_POPUP_CONTENT);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_item_name", str);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void n(View view) {
        if (!fb0.a.a("QFSFollowViewClick" + this.f93230e.f398463id.get())) {
            N();
            if (y()) {
                return;
            }
            if (!QCirclePluginUtil.isFollow(this.f93230e) && com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
                QLog.d("QFSFollowView", 1, "forbid follow because of sencebeat");
                return;
            }
            d dVar = this.f93234m;
            if (dVar != null) {
                dVar.onClick(this.f93230e.followState.get());
            }
            Iterator<e> it = this.f93233i.iterator();
            while (it.hasNext()) {
                it.next().beforeClick();
            }
            if (!QCirclePluginUtil.isFollow(this.f93230e)) {
                m(true);
                SimpleEventBus.getInstance().dispatchEvent(new QFSSendFollowedReqEvent(com.tencent.biz.qqcircle.utils.bj.g(this.f93231f)));
            } else if (QCirclePluginUtil.isFollow(this.f93230e) && this.L) {
                F(false);
            }
        }
    }

    private void p() {
        if (!this.P) {
            com.tencent.biz.qqcircle.utils.ba.f92679a.b(getContext());
        } else {
            QCircleHostLauncher.startAddFriend(getContext(), this.f93230e.f398463id.get(), this.f93230e.nick.get(), false, false);
        }
    }

    private void q() {
        if (this.f93230e == null) {
            return;
        }
        com.tencent.biz.qqcircle.manager.h.b().c("", this.f93230e.f398463id.get(), 2);
    }

    private void r() {
        QCircleSpecialFollowManager.g().f(this.f93230e, false, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3) {
        I(i3, true);
        if (this.f93230e != null) {
            QCircleFollowManager.getInstance().setUinFollowed(this.f93230e.f398463id.get(), i3);
        }
    }

    private void t(QCircleMultiFollowUpdateEvent qCircleMultiFollowUpdateEvent) {
        if (!this.f93228b0 || !qCircleMultiFollowUpdateEvent.mUserFollowStatusMap.containsKey(this.f93230e.f398463id.get())) {
            return;
        }
        callOnClick();
        I(qCircleMultiFollowUpdateEvent.mUserFollowStatusMap.get(this.f93230e.f398463id.get()).intValue(), true);
        if (this.C != null) {
            this.C.O(QCirclePluginUtil.isFollow(qCircleMultiFollowUpdateEvent.mUserFollowStatusMap.get(this.f93230e.f398463id.get()).intValue()), this.f93230e);
        }
    }

    private void u(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        if (!this.f93228b0 || !this.f93230e.f398463id.get().equals(qCircleFollowUpdateEvent.mUserId)) {
            return;
        }
        int i3 = this.f93230e.followState.get();
        int i16 = qCircleFollowUpdateEvent.mFollowStatus;
        if (i3 == i16) {
            return;
        }
        I(i16, false);
        if (this.C != null) {
            this.C.O(QCirclePluginUtil.isFollow(qCircleFollowUpdateEvent.mFollowStatus), this.f93230e);
        }
    }

    private void v() {
        QCircleSpecialFollowManager.g().f(this.f93230e, true, getContext());
    }

    private void w() {
        d dVar = this.f93234m;
        if (dVar != null) {
            dVar.a();
        }
        m(false);
    }

    private boolean y() {
        if (QCirclePluginUtil.isFollow(this.f93230e) && this.f93230e.blackState.get() == 2) {
            return false;
        }
        if (this.f93230e.blackState.get() != 1 && this.f93230e.blackState.get() != 3) {
            if (this.f93230e.blackState.get() != 2) {
                return false;
            }
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f1905142a), (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f1910643s), new b(), (DialogInterface.OnClickListener) null).show();
            return true;
        }
        if (this.R) {
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f1905042_), (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f1910643s), new a(), (DialogInterface.OnClickListener) null).show();
        } else {
            QCircleToast.i(QCircleToast.f91644d, R.string.f1905042_, 0);
        }
        return true;
    }

    private boolean z() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.followState.get() == 3 && this.f93230e.frdState.get() == 0 && this.Q && uq3.c.b5()) {
            return true;
        }
        return false;
    }

    public void C(e eVar) {
        this.f93233i.remove(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(boolean z16) {
        setVisibility(8);
        K();
        if (this.D) {
            if (z16) {
                G();
            } else {
                setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        setVisibility(8);
        setTextColor(QCircleSkinHelper.getInstance().getColor(this.J));
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.blackState.get() != 0) {
            setBackground(QCircleSkinHelper.getInstance().getDrawable(getContext(), this.G));
            setTextColor(getResources().getColor(this.J));
        } else {
            setBackground(QCircleSkinHelper.getInstance().getDrawable(getContext(), this.E));
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.f93230e;
        if (feedCloudMeta$StUser2 != null && feedCloudMeta$StUser2.followState.get() == 2 && this.W == 1) {
            setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f184753mq));
        } else {
            setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f19049429));
        }
    }

    public void F(boolean z16) {
        boolean z17;
        String str;
        String str2;
        String str3;
        String str4;
        if (z16) {
            if (fb0.a.a("QFSFollowViewClick" + this.f93230e.f398463id.get())) {
                return;
            }
        }
        if (h()) {
            return;
        }
        N();
        StringBuilder sb5 = new StringBuilder();
        final ActionSheet a16 = ob0.a.a(getContext());
        boolean z18 = false;
        if (z()) {
            a16.addButton(R.string.f188023vk, 0);
            sb5.append(com.tencent.biz.qqcircle.utils.h.a(R.string.f188023vk));
            z17 = false;
        } else {
            z17 = true;
        }
        String str5 = "";
        if (this.K && QCirclePluginUtil.isFollow(this.f93230e)) {
            if (this.f93230e.relationState.get() == 0 && this.f93230e.blackState.get() == 0) {
                a16.addButton(R.string.f184853n0, 0);
                if (z17) {
                    str4 = "";
                } else {
                    str4 = "|";
                }
                sb5.append(str4);
                sb5.append(com.tencent.biz.qqcircle.utils.h.a(R.string.f184853n0));
            } else if (this.f93230e.relationState.get() == 1) {
                a16.addButton(R.string.f181743el, 0);
                if (z17) {
                    str3 = "";
                } else {
                    str3 = "|";
                }
                sb5.append(str3);
                sb5.append(com.tencent.biz.qqcircle.utils.h.a(R.string.f181743el));
            } else {
                z18 = z17;
            }
        } else {
            a16.setMainTitle(getContext().getResources().getString(R.string.f196234gr));
            if (z17) {
                str = "";
            } else {
                str = "|";
            }
            sb5.append(str);
            sb5.append(com.tencent.biz.qqcircle.utils.h.a(R.string.f196234gr));
        }
        a16.addButton(R.string.f196244gs, 3);
        if (z18) {
            str2 = "";
        } else {
            str2 = "|";
        }
        sb5.append(str2);
        sb5.append(com.tencent.biz.qqcircle.utils.h.a(R.string.f196244gs));
        if (!TextUtils.isEmpty(this.V)) {
            a16.addButton(this.V);
            if (!z18) {
                str5 = "|";
            }
            sb5.append(str5);
            sb5.append(this.V);
        }
        a16.addCancelButton(R.string.cancel);
        a16.setOnButtonClickListenerV2(new ActionSheet.OnButtonClickListenerV2() { // from class: com.tencent.biz.qqcircle.widgets.z
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
            public final void OnClick(View view, int i3, String str6) {
                QFSFollowView.this.A(a16, view, i3, str6);
            }
        });
        if (!a16.isShowing()) {
            a16.show();
            l(sb5.toString());
        }
    }

    protected void G() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillEnabled(false);
        startAnimation(alphaAnimation);
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSFollowView.3
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StUser feedCloudMeta$StUser = QFSFollowView.this.f93230e;
                if (feedCloudMeta$StUser != null && QCirclePluginUtil.isFollow(feedCloudMeta$StUser.followState.get())) {
                    QFSFollowView.this.setVisibility(8);
                }
            }
        }, 500L, true);
    }

    public void H(int i3) {
        I(i3, false);
    }

    public void I(int i3, boolean z16) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
        if (feedCloudMeta$StUser != null) {
            feedCloudMeta$StUser.followState.set(i3);
        }
        if (this.f93227a0 == i3) {
            return;
        }
        this.f93227a0 = i3;
        j(i3);
        if (QCirclePluginUtil.isFollow(i3)) {
            D(z16);
        } else {
            E();
        }
    }

    protected void J() {
        if (this.K && QCirclePluginUtil.isFollow(this.f93230e) && this.f93230e.blackState.get() == 0) {
            if (this.f93230e.relationState.get() == 1) {
                setMovementMethod(LinkMovementMethod.getInstance());
                if (this.f93229d == null) {
                    this.f93229d = QCircleApplication.APP.getResources().getDrawable(R.drawable.myz);
                }
                this.f93229d.setBounds(new Rect(0, 0, ImmersiveUtils.dpToPx(14.0f), ImmersiveUtils.dpToPx(14.0f)));
                nb0.d dVar = new nb0.d(this.f93229d, 0);
                dVar.a(0, ImmersiveUtils.dpToPx(2.0f));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
                spannableStringBuilder.setSpan(dVar, 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) getResources().getString(R.string.f185123nq));
                setText(spannableStringBuilder);
                return;
            }
            D(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K() {
        CharSequence a16;
        setTextColor(QCircleSkinHelper.getInstance().getColor(this.I));
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
        if (feedCloudMeta$StUser != null && (feedCloudMeta$StUser.blackState.get() == 1 || this.f93230e.blackState.get() == 3)) {
            setBackground(QCircleSkinHelper.getInstance().getDrawable(this.H));
            setTextColor(getResources().getColor(R.color.al7));
        } else {
            setBackground(QCircleSkinHelper.getInstance().getDrawable(this.F));
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.f93230e;
        if (feedCloudMeta$StUser2 != null && feedCloudMeta$StUser2.followState.get() == 3 && this.W == 1) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f183393j2);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1905342c);
        }
        if (this.S) {
            a16 = g(new SpannableStringBuilder(a16));
        }
        setText(a16);
    }

    public void L(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        int i3;
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSFollowView", 1, "updateUiIfNeed failed! user is null");
            return;
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get()) && !QCirclePluginUtil.isOwner(feedCloudMeta$StUser)) {
            if (QCircleFollowManager.getInstance().hasUin(feedCloudMeta$StUser.f398463id.get())) {
                i3 = QCircleFollowManager.getInstance().getUinFollowed(feedCloudMeta$StUser.f398463id.get()).intValue();
            } else {
                i3 = feedCloudMeta$StUser.followState.get();
            }
            boolean isFollow = QCirclePluginUtil.isFollow(i3);
            H(i3);
            c cVar = this.C;
            if (cVar != null) {
                cVar.O(isFollow, this.f93230e);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public void f(e eVar) {
        this.f93233i.add(eVar);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFollowUpdateEvent.class);
        arrayList.add(QCircleMultiFollowUpdateEvent.class);
        arrayList.add(QCircleSpecialFollowUpdateEvent.class);
        return arrayList;
    }

    public boolean i() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
        if (feedCloudMeta$StUser == null || TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get()) || QCirclePluginUtil.isOwner(feedCloudMeta$StUser)) {
            return false;
        }
        return true;
    }

    protected void j(int i3) {
        String str;
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, com.tencent.biz.qqcircle.immersive.utils.r.F(i3));
        if (this.U) {
            str = "1";
        } else {
            str = "0";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOWBACK_SOURCE, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, this.T);
        if (!TextUtils.isEmpty(this.M)) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, this.M);
        }
        if (!TextUtils.isEmpty(this.M)) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EID, this.M);
        }
        Map<String, Object> map = this.N;
        if (map != null && map.size() > 0) {
            buildElementParams.putAll(this.N);
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
        if (feedCloudMeta$StUser != null) {
            str2 = feedCloudMeta$StUser.f398463id.get();
        } else {
            str2 = "";
        }
        buildElementParams.put("xsj_target_qq", str2);
        VideoReport.setElementParams(this, buildElementParams);
        VideoReport.setElementReuseIdentifier(this, str2);
    }

    protected void m(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFollowView", 2, "follow");
        }
        if (this.f93230e == null) {
            QLog.e("QFSFollowView", 2, "follow user failed! user is null");
        } else {
            setTag(R.id.f88074w3, Boolean.TRUE);
            com.tencent.biz.qqcircle.immersive.utils.z.b(this.f93232h, this.f93230e, this.f93231f, QCirclePluginUtil.getQCircleInitBean(getContext()));
        }
    }

    public FeedCloudMeta$StUser o() {
        return this.f93230e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        d dVar;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
        if (feedCloudMeta$StUser != null && (dVar = this.f93234m) != null) {
            dVar.c(feedCloudMeta$StUser.followState.get());
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.f93230e;
        if (feedCloudMeta$StUser2 != null) {
            L(feedCloudMeta$StUser2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f93230e != null) {
            n(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (hashCode() != simpleBaseEvent.mHashCode && this.f93232h.hashCode() != simpleBaseEvent.mHashCode) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93230e;
            if (feedCloudMeta$StUser != null && (simpleBaseEvent instanceof QCircleFollowUpdateEvent)) {
                u((QCircleFollowUpdateEvent) simpleBaseEvent);
                return;
            }
            if (feedCloudMeta$StUser != null && (simpleBaseEvent instanceof QCircleMultiFollowUpdateEvent)) {
                t((QCircleMultiFollowUpdateEvent) simpleBaseEvent);
                return;
            }
            if (feedCloudMeta$StUser != null && (simpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent)) {
                QCircleSpecialFollowUpdateEvent qCircleSpecialFollowUpdateEvent = (QCircleSpecialFollowUpdateEvent) simpleBaseEvent;
                QLog.d("QFSFollowView", 4, "onReceiveEvent: " + this.f93230e.f398463id.get() + " " + qCircleSpecialFollowUpdateEvent);
                if (this.f93230e.f398463id.get().equals(qCircleSpecialFollowUpdateEvent.uin)) {
                    this.f93230e.relationState.set(qCircleSpecialFollowUpdateEvent.isFollow ? 1 : 0);
                    J();
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setAlpha(1.0f);
                }
                return super.onTouchEvent(motionEvent);
            }
            setAlpha(0.5f);
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setArrowEnable(boolean z16) {
        this.S = z16;
    }

    public void setCallFriendFollowBackHint(String str) {
        this.V = str;
    }

    public void setDtParentEmId(String str) {
        this.M = str;
    }

    public void setDtReportExtraParams(Map<String, Object> map) {
        this.N = map;
    }

    public void setFollowStateChangeListener(c cVar) {
        this.C = cVar;
    }

    public void setFollowedDismiss(boolean z16) {
        this.D = z16;
    }

    public void setFollowedDrawable(int i3) {
        this.F = i3;
    }

    public void setFollowedTextColor(int i3) {
        this.I = i3;
    }

    public void setIsCallFollowBackType(boolean z16) {
        this.U = z16;
    }

    public void setItemReportListener(d dVar) {
        this.f93234m = dVar;
    }

    public void setNeedHandleFollowUpdateEvent(boolean z16) {
        this.f93228b0 = z16;
    }

    public void setProfilePage(boolean z16) {
        this.R = z16;
    }

    public void setShowAddFriendBtn(boolean z16) {
        this.Q = z16;
    }

    public void setShowQQProfile(boolean z16) {
        this.P = z16;
    }

    public void setUnFollowDrawable(int i3) {
        this.E = i3;
    }

    public void setUnFollowTextColor(int i3) {
        this.J = i3;
    }

    public void setUserData(FeedCloudMeta$StUser feedCloudMeta$StUser, String str) {
        this.T = str;
        setUserData(feedCloudMeta$StUser);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        setVisibility(8);
    }

    public QFSFollowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:
    
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QFSFollowView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93230e = new FeedCloudMeta$StUser();
        this.f93232h = new f();
        this.f93233i = new ArrayList();
        this.Q = true;
        this.U = false;
        this.V = "";
        this.W = uq3.c.X0("qqcircle", "qqcircle_back_follow_enable", 1).intValue();
        this.f93227a0 = Integer.MIN_VALUE;
        this.f93228b0 = true;
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, y91.a.f449889y6);
                this.F = typedArray.getResourceId(y91.a.B6, R.drawable.qvideo_skin_bg_btn_primary_pressed);
                this.E = typedArray.getResourceId(y91.a.F6, R.drawable.qvideo_skin_bg_btn_primary_normal);
                this.H = typedArray.getResourceId(y91.a.f449902z6, R.drawable.qvideo_skin_bg_btn_primary_pressed);
                this.G = typedArray.getResourceId(y91.a.A6, R.drawable.qvideo_skin_bg_btn_primary_disable);
                this.I = typedArray.getResourceId(y91.a.C6, R.color.qvideo_skin_color_text_primary);
                this.J = typedArray.getResourceId(y91.a.G6, R.color.cla);
                this.K = typedArray.getBoolean(y91.a.E6, false);
                this.L = typedArray.getBoolean(y91.a.D6, true);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            typedArray.recycle();
            x();
        } catch (Throwable th5) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th5;
        }
    }

    public void setUserData(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        setUserData(feedCloudMeta$StUser, (FeedCloudMeta$StFeed) null);
    }

    public void setUserData(FeedCloudMeta$StUser feedCloudMeta$StUser, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StUser != null) {
            M(feedCloudMeta$StUser);
        }
        this.f93231f = feedCloudMeta$StFeed;
    }
}
