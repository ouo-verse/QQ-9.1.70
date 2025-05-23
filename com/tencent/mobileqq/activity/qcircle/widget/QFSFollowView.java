package com.tencent.mobileqq.activity.qcircle.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoFollowRsp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QFSFollowView extends TextView implements View.OnClickListener, SimpleEventReceiver {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;

    /* renamed from: d, reason: collision with root package name */
    protected FeedCloudMeta$StUser f184630d;

    /* renamed from: e, reason: collision with root package name */
    private String f184631e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f184632f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f184633h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f184634i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f184635m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoFollowRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f184637a;

        b(int i3) {
            this.f184637a = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoFollowRsp feedCloudWrite$StDoFollowRsp) {
            QLog.d("QFSFollowView", 1, "doFollow: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            if (z16 && j3 == 0) {
                QFSFollowView.this.o(this.f184637a, true);
                QFSFollowView.this.i(feedCloudWrite$StDoFollowRsp, this.f184637a);
            } else {
                QQToast.makeText(QFSFollowView.this.getContext(), 1, str, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoFollowRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f184639a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f184640b;

        c(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
            this.f184639a = feedCloudMeta$StUser;
            this.f184640b = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoFollowRsp feedCloudWrite$StDoFollowRsp) {
            boolean z17 = true;
            QLog.d("QFSFollowView", 1, "doFollow: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            if (z16 && j3 == 0) {
                if (this.f184639a != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(this.f184640b, this.f184639a.f398463id.get()));
                    QFSFollowView.c(BaseApplication.getContext(), this.f184639a.f398463id.get(), this.f184640b);
                    ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).setUinFollowed(this.f184639a.f398463id.get(), this.f184640b);
                    if (feedCloudWrite$StDoFollowRsp != null) {
                        if (this.f184640b != 1) {
                            z17 = false;
                        }
                        ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).updateFollowUser(this.f184639a.f398463id.get(), this.f184639a.nick.get(), z17);
                        return;
                    }
                    return;
                }
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f184641d;

        d(ActionSheet actionSheet) {
            this.f184641d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!hf0.a.a("showUnFollowUserActionSheetClick")) {
                if (i3 == 0) {
                    QFSFollowView.a(QFSFollowView.this);
                    QFSFollowView.this.e(false);
                }
                this.f184641d.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface f {
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface g {
    }

    public QFSFollowView(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ f a(QFSFollowView qFSFollowView) {
        qFSFollowView.getClass();
        return null;
    }

    public static void c(Context context, String str, int i3) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("action_update_web_user_follow_state");
        intent.putExtra("uin", str);
        intent.putExtra("followstate", i3);
        context.sendBroadcast(intent);
    }

    public static void d(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFollowView", 2, "follow");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(str);
        VSNetworkHelper.getInstance().sendRequest(((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getQCircleFollowRequest(feedCloudMeta$StUser, z16 ? 1 : 0, null), new c(feedCloudMeta$StUser, z16 ? 1 : 0));
    }

    private boolean h() {
        if (this.f184630d.followState.get() == 1 && this.f184630d.blackState.get() == 2) {
            return false;
        }
        if (this.f184630d.blackState.get() != 1 && this.f184630d.blackState.get() != 3) {
            if (this.f184630d.blackState.get() != 2) {
                return false;
            }
            DialogUtil.createCustomDialog(getContext(), 230).setMessage(R.string.f183343ix).setPositiveButton(R.string.f183573jj, new a()).show();
            return true;
        }
        QQToast.makeText(getContext(), 0, R.string.f183333iw, 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(FeedCloudWrite$StDoFollowRsp feedCloudWrite$StDoFollowRsp, int i3) {
        boolean z16 = true;
        if (this.f184630d == null) {
            QLog.w("QFSFollowView", 1, "[onReceive] user info not is null.");
            return;
        }
        if (i3 != 1) {
            z16 = false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(i3, this.f184630d.f398463id.get()));
        c(getContext(), this.f184630d.f398463id.get(), i3);
        ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).setUinFollowed(this.f184630d.f398463id.get(), i3);
        if (feedCloudWrite$StDoFollowRsp != null) {
            ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).updateFollowUser(this.f184630d.f398463id.get(), this.f184630d.nick.get(), z16);
        }
    }

    private void l() {
        ActionSheet create = ActionSheet.create(getContext());
        create.setMainTitle(getContext().getResources().getString(R.string.f185453om));
        create.addButton(R.string.f185463on, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new d(create));
        if (!create.isShowing()) {
            create.show();
        }
    }

    protected void e(boolean z16) {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt;
        if (QLog.isColorLevel()) {
            QLog.d("QFSFollowView", 2, "follow");
        }
        if (this.f184630d == null) {
            QLog.e("QFSFollowView", 2, "follow user failed! user is null");
            return;
        }
        if (!TextUtils.isEmpty(this.f184631e)) {
            feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("feedid");
            feedCloudCommon$Entry.value.set(this.f184631e);
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry);
        } else {
            feedCloudCommon$StCommonExt = null;
        }
        VSNetworkHelper.getInstance().sendRequest(((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getQCircleFollowRequest(this.f184630d, z16 ? 1 : 0, feedCloudCommon$StCommonExt), new b(z16 ? 1 : 0));
    }

    protected URLDrawable f(int i3, String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(i3);
        return URLDrawable.getDrawable(str, obtain);
    }

    protected void g() {
        setOnClickListener(this);
        k();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFollowUpdateEvent.class);
        return arrayList;
    }

    protected void j(boolean z16) {
        setVisibility(0);
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f184630d;
        if (feedCloudMeta$StUser != null && (feedCloudMeta$StUser.blackState.get() == 1 || this.f184630d.blackState.get() == 3)) {
            setBackgroundResource(this.F);
        } else if (!TextUtils.isEmpty(this.J)) {
            setBackgroundDrawable(f(this.D, this.J));
        } else {
            setBackgroundResource(this.D);
        }
        setTextColor(this.G);
        setText(R.string.f183383j1);
        if (this.f184633h) {
            if (z16) {
                m();
            } else {
                setVisibility(8);
            }
        }
    }

    protected void k() {
        setVisibility(0);
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f184630d;
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.blackState.get() != 0) {
            setBackgroundResource(this.E);
        } else if (!TextUtils.isEmpty(this.I)) {
            setBackgroundDrawable(f(this.C, this.I));
        } else {
            setBackgroundResource(this.C);
        }
        setTextColor(this.H);
        setText(R.string.f183323iv);
    }

    protected void m() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillEnabled(false);
        startAnimation(alphaAnimation);
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.widget.QFSFollowView.2
            @Override // java.lang.Runnable
            public void run() {
                QFSFollowView.this.setVisibility(8);
            }
        }, 500L);
    }

    public void n(int i3) {
        o(i3, false);
    }

    public void o(int i3, boolean z16) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f184630d;
        if (feedCloudMeta$StUser != null) {
            feedCloudMeta$StUser.followState.set(i3);
            QLog.d("QFSFollowView", 1, "uin:" + this.f184630d.f398463id.get() + " state:" + i3);
        }
        if (i3 == 1) {
            j(z16);
        } else {
            k();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f184630d;
        if (feedCloudMeta$StUser != null) {
            p(feedCloudMeta$StUser);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!hf0.a.a("QFSFollowViewClick") && this.f184630d != null && !h()) {
            if (!QCircleHostUtil.isFollow(this.f184630d)) {
                e(true);
            } else {
                l();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f184630d;
        if (feedCloudMeta$StUser != null && (simpleBaseEvent instanceof QCircleFollowUpdateEvent)) {
            QCircleFollowUpdateEvent qCircleFollowUpdateEvent = (QCircleFollowUpdateEvent) simpleBaseEvent;
            if (feedCloudMeta$StUser.f398463id.get().equals(qCircleFollowUpdateEvent.mUserId)) {
                int i3 = this.f184630d.followState.get();
                int i16 = qCircleFollowUpdateEvent.mFollowStatus;
                if (i3 != i16) {
                    n(i16);
                }
            }
        }
    }

    public void p(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSFollowView", 1, "updateUiIfNeed failed! user is null");
            return;
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get()) && !QCircleHostUtil.isOwner(feedCloudMeta$StUser)) {
            if (((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).hasUin(feedCloudMeta$StUser.f398463id.get())) {
                this.f184630d.followState.set(((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getUinFollowed(feedCloudMeta$StUser.f398463id.get()));
                n(((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getUinFollowed(feedCloudMeta$StUser.f398463id.get()));
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public void setFollowedDismiss(boolean z16) {
        this.f184633h = z16;
    }

    public void setFollowedDrawable(int i3) {
        this.D = i3;
    }

    public void setFollowedRemoteUrl(String str) {
        this.J = str;
    }

    public void setFollowedShowToast(boolean z16) {
        this.f184634i = z16;
    }

    public void setFollowedTextColor(int i3) {
        this.G = i3;
    }

    public void setIsInNightMode(boolean z16) {
        this.f184635m = z16;
    }

    public void setOnlyFollowMode(boolean z16) {
        this.f184632f = z16;
    }

    public void setUnFollowDrawable(int i3) {
        this.C = i3;
    }

    public void setUnFollowRemoteUrl(String str) {
        this.I = str;
    }

    public void setUnFollowTextColor(int i3) {
        this.H = i3;
    }

    public void setUserData(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        setUserData(feedCloudMeta$StUser, "");
    }

    public QFSFollowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUserData(FeedCloudMeta$StUser feedCloudMeta$StUser, String str) {
        if (feedCloudMeta$StUser != null) {
            this.f184630d.f398463id.set(feedCloudMeta$StUser.f398463id.get());
            this.f184630d.nick.set(feedCloudMeta$StUser.nick.get());
            this.f184630d.blackState.set(feedCloudMeta$StUser.blackState.get());
            if (!TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get()) && !QCircleHostUtil.isOwner(feedCloudMeta$StUser)) {
                if (((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).hasUin(feedCloudMeta$StUser.f398463id.get())) {
                    this.f184630d.followState.set(((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getUinFollowed(feedCloudMeta$StUser.f398463id.get()));
                    n(((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getUinFollowed(feedCloudMeta$StUser.f398463id.get()));
                } else {
                    this.f184630d.followState.set(feedCloudMeta$StUser.followState.get());
                    n(this.f184630d.followState.get());
                }
            } else {
                setVisibility(8);
            }
        }
        this.f184631e = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (r4 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QFSFollowView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f184630d = new FeedCloudMeta$StUser();
        this.f184635m = false;
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.QFSFollowView);
                this.D = typedArray.getResourceId(R.styleable.QFSFollowView_qfs_follow_res, R.drawable.qvideo_skin_bg_btn_primary_pressed);
                this.C = typedArray.getResourceId(R.styleable.QFSFollowView_qfs_un_follow_res, R.drawable.qvideo_skin_bg_btn_primary_normal);
                this.F = typedArray.getResourceId(R.styleable.QFSFollowView_qfs_disable_follow_res, R.drawable.qvideo_skin_bg_btn_primary_pressed);
                this.E = typedArray.getResourceId(R.styleable.QFSFollowView_qfs_disable_un_follow_res, R.drawable.qvideo_skin_bg_btn_primary_disable);
                this.G = typedArray.getColor(R.styleable.QFSFollowView_qfs_follow_text_color, getResources().getColor(R.color.by));
                this.H = typedArray.getColor(R.styleable.QFSFollowView_qfs_un_follow_text_color, getResources().getColor(R.color.cav));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            typedArray.recycle();
            g();
        } catch (Throwable th5) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th5;
        }
    }

    public void setFollowStateChangeListener(e eVar) {
    }

    public void setItemPreClickListener(g gVar) {
    }

    public void setItemReportListener(f fVar) {
    }
}
