package com.tencent.mobileqq.activity.aio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.annotation.RequiresApi;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderView;
import com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.IActivityLauncherProxy;
import cooperation.qzone.api.IQZoneIntimateSpaceApi;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;
import qzone.QZIntimateSpaceRedDotReader$GetRedPointsRsp;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateInfoView extends MainIntimateView implements FeedListView.LoadFeedCallback {

    /* renamed from: i0, reason: collision with root package name */
    @Nullable
    private FeedListView f178138i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f178139j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f178140k0;

    /* renamed from: l0, reason: collision with root package name */
    @Nullable
    private BounceScrollView f178141l0;

    /* renamed from: m0, reason: collision with root package name */
    private WeakReference<View> f178142m0;

    /* renamed from: n0, reason: collision with root package name */
    private ImageView f178143n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f178144o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f178145p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f178146q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f178147r0;

    /* renamed from: s0, reason: collision with root package name */
    private com.tencent.aio.frame.api.e f178148s0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceRedDotReader$GetRedPointsRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZIntimateSpaceRedDotReader$GetRedPointsRsp qZIntimateSpaceRedDotReader$GetRedPointsRsp) {
            QLog.d("intimate_relationship", 1, "[requestQZoneIntimateSpaceInfo] onReceive error, isSuccess = " + z16 + ", retCode = " + j3 + ", errMsg = " + str + ", traceId = " + baseRequest.getTraceId() + ", friendUin = " + IntimateInfoView.this.f178905h);
            if (z16 && qZIntimateSpaceRedDotReader$GetRedPointsRsp != null) {
                IntimateInfoView.this.e0(qZIntimateSpaceRedDotReader$GetRedPointsRsp.entrance_info.get());
                if (((MainIntimateView) IntimateInfoView.this).J != null) {
                    ((MainIntimateView) IntimateInfoView.this).J.Ta(qZIntimateSpaceRedDotReader$GetRedPointsRsp.entrance_info.get());
                    return;
                }
                return;
            }
            if (((MainIntimateView) IntimateInfoView.this).J != null) {
                QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo = new QZIntimateSpaceRedDotReader$EntranceInfo();
                qZIntimateSpaceRedDotReader$EntranceInfo.lst_publish_time.set(Long.MIN_VALUE);
                ((MainIntimateView) IntimateInfoView.this).J.Ta(qZIntimateSpaceRedDotReader$EntranceInfo);
            }
        }
    }

    public IntimateInfoView(QBaseActivity qBaseActivity, Context context, String str) {
        super(qBaseActivity, context, str);
        this.f178145p0 = false;
        this.f178146q0 = false;
        this.f178147r0 = 0;
        this.f178139j0 = this.I.findViewById(R.id.alv);
        if (this.f178144o0) {
            this.f178138i0.setOverScrollMode(0);
            this.f178138i0.setEdgeEffectEnabled(false);
            this.f178138i0.setVerticalScrollBarEnabled(false);
            this.f178138i0.addHeaderView(this.I);
            this.f178138i0.attach(this.f178898d, qBaseActivity, this.f178906i);
            this.f178140k0 = false;
        } else {
            BounceScrollView bounceScrollView = (BounceScrollView) this.H.findViewById(R.id.iig);
            this.f178141l0 = bounceScrollView;
            bounceScrollView.setOverScrollMode(0);
            this.f178141l0.setEdgeEffectEnabled(false);
            this.f178141l0.setVerticalScrollBarEnabled(false);
        }
        k0(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(int i3, ActivityResult activityResult) {
        FeedListView feedListView = this.f178138i0;
        if (feedListView != null) {
            feedListView.doActivityResult(i3, activityResult.getResultCode(), activityResult.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(ts.a aVar, Intent intent, final int i3) {
        aVar.c(intent, i3, new ActivityResultCallback() { // from class: com.tencent.mobileqq.activity.aio.ag
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                IntimateInfoView.this.h0(i3, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i3) {
        WeakReference<View> weakReference;
        ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g> n3 = n();
        if (i3 >= 0 && i3 < n3.size()) {
            int type = n3.get(i3).getType();
            if (this.f178147r0 != type && (weakReference = this.f178142m0) != null && weakReference.get() != null) {
                IntimateHeaderCardUtil.I(type, n3.get(i3).getLevel(), this.H, this.f178142m0.get(), this.f178143n0);
            }
            this.f178147r0 = type;
            com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a.j(this.f178905h, type);
            IntimateHeaderView intimateHeaderView = this.L;
            if (intimateHeaderView != null) {
                intimateHeaderView.setCurrentType(this.f178147r0);
            }
            QLog.i("IntimateInfoView", 1, "currentType_change:" + this.f178147r0);
            MainIntimateTitlePart mainIntimateTitlePart = this.J;
            if (mainIntimateTitlePart != null) {
                mainIntimateTitlePart.Ra(this.f178147r0, n3.get(i3).getLevel(), n3.get(i3).getFlag());
            }
        }
    }

    private void k0(int i3, int i16) {
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Ra(i3, i16, 0L);
        }
        if (QQTheme.isVasTheme()) {
            this.H.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        } else {
            l0(i3, i16);
        }
        n0();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void l0(int i3, int i16) {
        Drawable drawable;
        Drawable drawable2;
        Context context = this.f178902f;
        if (context == null) {
            drawable = new ColorDrawable(0);
        } else {
            drawable = context.getDrawable(R.drawable.qui_common_bg_bottom_standard_bg);
        }
        IntimateHeaderCardUtil.X(this.H, IntimateHeaderCardUtil.d(i3, i16), drawable);
        if (IntimateHeaderCardUtil.M(i3)) {
            this.f178143n0.setVisibility(0);
            String g16 = IntimateHeaderCardUtil.g(i3);
            if (this.f178143n0.getDrawable() == null) {
                drawable2 = new ColorDrawable(0);
            } else {
                drawable2 = this.f178143n0.getDrawable();
            }
            IntimateHeaderCardUtil.X(this.f178143n0, g16, drawable2);
        }
    }

    private void n0() {
        IntimateHeaderView intimateHeaderView = this.L;
        if (intimateHeaderView == null) {
            return;
        }
        intimateHeaderView.setTabChangeListener(new QUICardStackView.c() { // from class: com.tencent.mobileqq.activity.aio.ah
            @Override // com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView.c
            public final void onChanged(int i3) {
                IntimateInfoView.this.j0(i3);
            }
        });
    }

    private void o0() {
        FeedListView feedListView;
        if (this.f178144o0 && (feedListView = this.f178138i0) != null) {
            feedListView.loadMore(this);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    protected View A() {
        this.f178906i = 0L;
        try {
            this.f178906i = Long.parseLong(this.f178905h);
        } catch (NumberFormatException unused) {
        }
        if (this.f178906i > 0) {
            boolean isQZonePluginInit = QZoneApiProxy.isQZonePluginInit();
            QLog.i("IntimateInfoView", 1, "IntimateInfoView: start to load qzone plugin  | isQZonePluginInit: " + isQZonePluginInit);
            if (!isQZonePluginInit) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.IntimateInfoView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            IntimateInfoView intimateInfoView = IntimateInfoView.this;
                            QZoneApiProxy.initServlet(intimateInfoView.f178900e, intimateInfoView.f178898d);
                            IntimateInfoView intimateInfoView2 = IntimateInfoView.this;
                            QZoneApiProxy.initEnv(intimateInfoView2.f178900e, intimateInfoView2.f178898d);
                        } catch (Throwable th5) {
                            QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone plugin", th5);
                        }
                    }
                });
            } else {
                QZoneApiProxy.needShowAioFeedList(this.f178900e, this.f178898d);
            }
        }
        View inflate = LayoutInflater.from(this.f178902f).inflate(R.layout.f168209pi, (ViewGroup) null);
        this.f178144o0 = false;
        View findViewById = inflate.findViewById(R.id.if5);
        if (this.f178144o0) {
            this.I = LayoutInflater.from(this.f178902f).inflate(R.layout.fcs, (ViewGroup) null);
        } else {
            this.I = inflate;
        }
        this.f178142m0 = new WeakReference<>(findViewById.findViewById(R.id.f783746w));
        this.f178143n0 = (ImageView) findViewById.findViewById(R.id.vio);
        return findViewById;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void B() {
        super.B();
        this.f178898d = null;
        FeedListView feedListView = this.f178138i0;
        if (feedListView != null) {
            feedListView.onDestroy();
            this.f178140k0 = true;
        }
        this.f178138i0 = null;
        View view = this.f178139j0;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f178148s0 = null;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void C() {
        super.C();
        FeedListView feedListView = this.f178138i0;
        if (feedListView != null) {
            feedListView.onPause();
        }
        IntimateHeaderView intimateHeaderView = this.L;
        if (intimateHeaderView != null) {
            intimateHeaderView.setCurrentType(0);
        }
        this.f178147r0 = 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void D() {
        super.D();
        FeedListView feedListView = this.f178138i0;
        if (feedListView != null) {
            feedListView.onStart();
            this.f178138i0.onResume();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void F() {
        super.F();
        FeedListView feedListView = this.f178138i0;
        if (feedListView != null) {
            feedListView.onStop();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void G() {
        super.G();
        FeedListView feedListView = this.f178138i0;
        if (feedListView != null) {
            feedListView.onStart();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void N() {
        VSNetworkHelper.getInstance().sendRequest(((IQZoneIntimateSpaceApi) QRoute.api(IQZoneIntimateSpaceApi.class)).getRedDotReaderRequest(System.currentTimeMillis(), true, 3, this.f178905h), new a());
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    @RequiresApi(api = 17)
    protected void V(IntimateInfo intimateInfo) {
        super.V(intimateInfo);
        if (intimateInfo == null) {
            return;
        }
        this.f178907m = intimateInfo;
        this.D = intimateInfo.maskType;
        if (this.f178147r0 == 0) {
            this.f178147r0 = com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a.c(this.f178905h);
        }
        if (this.f178147r0 != 0 && com.tencent.mobileqq.activity.aio.intimate.header.n.b()) {
            return;
        }
        if (intimateInfo.beFriendDays >= -1) {
            int i3 = this.D;
            if (i3 != 1 && i3 != 3 && i3 != 2 && i3 != 26) {
                k0(0, intimateInfo.maskLevel);
                return;
            } else {
                k0(i3, intimateInfo.maskLevel);
                return;
            }
        }
        k0(0, intimateInfo.maskLevel);
    }

    public void d0(int i3, int i16, Intent intent) {
        FeedListView feedListView;
        if (this.f178144o0 && (feedListView = this.f178138i0) != null) {
            feedListView.doActivityResult(i3, i16, intent);
        }
    }

    public void e0(QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo) {
        IntimateHeaderView intimateHeaderView = this.L;
        if (intimateHeaderView != null) {
            intimateHeaderView.C(qZIntimateSpaceRedDotReader$EntranceInfo);
        }
    }

    public void f0() {
        if (!this.f178145p0) {
            o0();
            this.f178145p0 = true;
        }
        FeedListView feedListView = this.f178138i0;
        if (feedListView != null) {
            feedListView.setLongClickValid(true);
        }
    }

    public void g0(@NotNull final ts.a aVar) {
        FeedListView feedListView;
        if (this.f178144o0 && (feedListView = this.f178138i0) != null) {
            feedListView.injectLauncherProxy(new IActivityLauncherProxy() { // from class: com.tencent.mobileqq.activity.aio.af
                @Override // cooperation.qzone.api.IActivityLauncherProxy
                public final void startActivityForResult(Intent intent, int i3) {
                    IntimateInfoView.this.i0(aVar, intent, i3);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    protected View l() {
        return this.I;
    }

    public void m0(com.tencent.aio.frame.api.e eVar) {
        this.f178148s0 = eVar;
    }

    @Override // cooperation.qzone.api.FeedListView.LoadFeedCallback
    public void onLoadOver(boolean z16) {
        FeedListView feedListView;
        QLog.i("IntimateInfoView", 4, "onLoadOver: " + z16);
        if (this.f178139j0 != null && (feedListView = this.f178138i0) != null) {
            if (feedListView.getFeedCnt() > 0) {
                this.f178139j0.setVisibility(0);
            } else {
                this.f178139j0.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    protected void s(IntimateInfo intimateInfo) {
        super.s(intimateInfo);
        if (com.tencent.mobileqq.activity.aio.intimate.header.n.b()) {
            return;
        }
        k0(this.D, intimateInfo.maskLevel);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void y() {
        QLog.i("IntimateInfoView", 1, "onBackAction");
        com.tencent.aio.frame.api.e eVar = this.f178148s0;
        if (eVar != null) {
            eVar.e(300);
        }
    }
}
