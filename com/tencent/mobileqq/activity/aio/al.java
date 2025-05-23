package com.tencent.mobileqq.activity.aio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderView;
import com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.qzone.api.IQZoneIntimateSpaceApi;
import java.util.ArrayList;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;
import qzone.QZIntimateSpaceRedDotReader$GetRedPointsRsp;

/* compiled from: P */
/* loaded from: classes10.dex */
public class al extends MainIntimateView {

    /* renamed from: i0, reason: collision with root package name */
    private String f178196i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f178197j0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f178198k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f178199l0;

    /* renamed from: m0, reason: collision with root package name */
    private com.tencent.aio.frame.api.e f178200m0;

    /* renamed from: n0, reason: collision with root package name */
    private final FragmentManager f178201n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f178202o0;

    /* renamed from: p0, reason: collision with root package name */
    private View f178203p0;

    /* renamed from: q0, reason: collision with root package name */
    private Fragment f178204q0;

    /* renamed from: r0, reason: collision with root package name */
    private ViewGroup f178205r0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceRedDotReader$GetRedPointsRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZIntimateSpaceRedDotReader$GetRedPointsRsp qZIntimateSpaceRedDotReader$GetRedPointsRsp) {
            QLog.d("intimate_relationship", 1, "[requestQZoneIntimateSpaceInfo] onReceive error, isSuccess = " + z16 + ", retCode = " + j3 + ", errMsg = " + str + ", traceId = " + baseRequest.getTraceId() + ", friendUin = " + al.this.f178905h);
            if (z16 && qZIntimateSpaceRedDotReader$GetRedPointsRsp != null) {
                al.this.d0(qZIntimateSpaceRedDotReader$GetRedPointsRsp.entrance_info.get());
                if (((MainIntimateView) al.this).J != null) {
                    ((MainIntimateView) al.this).J.Ta(qZIntimateSpaceRedDotReader$GetRedPointsRsp.entrance_info.get());
                    return;
                }
                return;
            }
            if (((MainIntimateView) al.this).J != null) {
                QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo = new QZIntimateSpaceRedDotReader$EntranceInfo();
                qZIntimateSpaceRedDotReader$EntranceInfo.lst_publish_time.set(Long.MIN_VALUE);
                ((MainIntimateView) al.this).J.Ta(qZIntimateSpaceRedDotReader$EntranceInfo);
            }
        }
    }

    public al(QBaseActivity qBaseActivity, Context context, String str, FragmentManager fragmentManager) {
        super(qBaseActivity, context, str);
        this.f178199l0 = 0;
        this.f178202o0 = false;
        this.f178201n0 = fragmentManager;
        j0(0, 0);
    }

    private void e0(long j3) {
        if (this.f178202o0) {
            QLog.d("IntimateInfoViewV2", 1, "QZoneFeedView has init, return");
            return;
        }
        if (this.f178201n0 != null && j3 > 0) {
            this.f178202o0 = true;
            Fragment qZoneAIOUserHomeFragment = ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZoneAIOUserHomeFragment(j3);
            this.f178204q0 = qZoneAIOUserHomeFragment;
            if (qZoneAIOUserHomeFragment != null) {
                this.f178201n0.beginTransaction().replace(R.id.xpu, this.f178204q0).commitAllowingStateLoss();
                QLog.d("IntimateInfoViewV2", 1, "QZoneFeedView init success");
                return;
            } else {
                QLog.d("IntimateInfoViewV2", 1, "QZoneFeedView init error, fragment is null");
                return;
            }
        }
        QLog.d("IntimateInfoViewV2", 1, "QZoneFeedView init error, mFragmentManager: " + this.f178201n0 + ", friendUin: " + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(final int i3, final int i16) {
        final String d16;
        Context context = this.f178902f;
        if (context != null && com.tencent.biz.qui.quicommon.a.b(context.getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
            d16 = FriendIntimateRelationshipHelper.e(i3, i16);
        } else {
            d16 = FriendIntimateRelationshipHelper.d(i3, i16);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.aj
            @Override // java.lang.Runnable
            public final void run() {
                al.this.f0(d16, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(int i3) {
        ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g> n3 = n();
        if (i3 >= 0 && i3 < n3.size()) {
            int type = n3.get(i3).getType();
            if (this.f178199l0 != type) {
                IntimateHeaderCardUtil.I(type, n3.get(i3).getLevel(), this.H, this.f178197j0, this.f178198k0);
            }
            this.f178199l0 = type;
            com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a.j(this.f178905h, type);
            IntimateHeaderView intimateHeaderView = this.L;
            if (intimateHeaderView != null) {
                intimateHeaderView.setCurrentType(this.f178199l0);
            }
            QLog.i("IntimateInfoViewV2", 1, "currentType_change:" + this.f178199l0);
            MainIntimateTitlePart mainIntimateTitlePart = this.J;
            if (mainIntimateTitlePart != null) {
                mainIntimateTitlePart.Ra(this.f178199l0, n3.get(i3).getLevel(), n3.get(i3).getFlag());
            }
        }
    }

    private void i0() {
        Fragment fragment;
        try {
            if (this.f178201n0 != null && (fragment = this.f178204q0) != null && fragment.isAdded()) {
                this.f178201n0.beginTransaction().remove(this.f178204q0).commitNowAllowingStateLoss();
                this.f178204q0 = null;
                this.f178202o0 = false;
            }
        } catch (Exception e16) {
            QLog.e("IntimateInfoViewV2", 1, e16, new Object[0]);
        }
    }

    private void j0(final int i3, final int i16) {
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Ra(i3, i16, 0L);
        }
        if (com.tencent.mobileqq.activity.aio.intimate.header.n.a()) {
            if (QQTheme.isVasTheme()) {
                this.H.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            } else {
                k0(i3, i16);
            }
            n0();
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ai
            @Override // java.lang.Runnable
            public final void run() {
                al.this.g0(i3, i16);
            }
        }, 16, null, true);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void k0(int i3, int i16) {
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
            this.f178198k0.setVisibility(0);
            String g16 = IntimateHeaderCardUtil.g(i3);
            if (this.f178198k0.getDrawable() == null) {
                drawable2 = new ColorDrawable(0);
            } else {
                drawable2 = this.f178198k0.getDrawable();
            }
            IntimateHeaderCardUtil.X(this.f178198k0, g16, drawable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void f0(String str, int i3, int i16) {
        Context context;
        Drawable drawable;
        if ((!TextUtils.isEmpty(this.f178196i0) && str.equals(this.f178196i0)) || (context = this.f178902f) == null) {
            return;
        }
        if (i3 == 3) {
            drawable = context.getResources().getDrawable(R.drawable.intimate_relationship_jiyou_bg);
        } else if (i3 == 2) {
            drawable = context.getResources().getDrawable(R.drawable.intimate_relationship_guimi_bg);
        } else if (i3 == 1) {
            drawable = context.getResources().getDrawable(R.drawable.intimate_relationship_lover_bg);
        } else if (i3 == 26) {
            drawable = context.getResources().getDrawable(R.drawable.mze);
        } else {
            drawable = context.getResources().getDrawable(R.drawable.intimate_relationship_normal_bg);
        }
        QLog.i("intimate_relationship", 1, String.format("setBackgroundDrawable, intimateType: %s, level: %s, bgUrl: %s", Integer.valueOf(i3), Integer.valueOf(i16), str));
        if (!TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = ViewUtils.getScreenWidth();
            obtain.mRequestHeight = ViewUtils.getScreenHeight();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
            drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306345y);
            this.H.setBackgroundDrawable(drawable2);
            this.f178196i0 = str;
            return;
        }
        this.H.setBackgroundDrawable(drawable);
    }

    private void n0() {
        IntimateHeaderView intimateHeaderView = this.L;
        if (intimateHeaderView == null) {
            return;
        }
        intimateHeaderView.setTabChangeListener(new QUICardStackView.c() { // from class: com.tencent.mobileqq.activity.aio.ak
            @Override // com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView.c
            public final void onChanged(int i3) {
                al.this.h0(i3);
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    protected View A() {
        this.f178906i = 0L;
        try {
            this.f178906i = Long.parseLong(this.f178905h);
        } catch (NumberFormatException unused) {
        }
        View findViewById = LayoutInflater.from(this.f178902f).inflate(R.layout.fcn, (ViewGroup) null).findViewById(R.id.if5);
        View inflate = LayoutInflater.from(this.f178902f).inflate(R.layout.fcs, (ViewGroup) null);
        this.I = inflate;
        View findViewById2 = inflate.findViewById(R.id.alv);
        this.f178203p0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        ((ViewGroup) findViewById.findViewById(R.id.xqv)).addView(this.I);
        this.f178197j0 = findViewById.findViewById(R.id.f783746w);
        this.f178198k0 = (ImageView) findViewById.findViewById(R.id.vio);
        this.f178205r0 = (ViewGroup) findViewById.findViewById(R.id.xpu);
        return findViewById;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void B() {
        super.B();
        this.f178898d = null;
        this.f178200m0 = null;
        i0();
        ViewGroup viewGroup = this.f178205r0;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        View view = this.H;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void C() {
        super.C();
        IntimateHeaderView intimateHeaderView = this.L;
        if (intimateHeaderView != null) {
            intimateHeaderView.setCurrentType(0);
        }
        this.f178199l0 = 0;
        FragmentManager fragmentManager = this.f178201n0;
        if (fragmentManager != null && this.f178204q0 != null) {
            fragmentManager.beginTransaction().setMaxLifecycle(this.f178204q0, Lifecycle.State.STARTED).commitNowAllowingStateLoss();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void D() {
        super.D();
        e0(this.f178906i);
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
        if (this.f178199l0 == 0) {
            this.f178199l0 = com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a.c(this.f178905h);
        }
        if (this.f178199l0 != 0 && com.tencent.mobileqq.activity.aio.intimate.header.n.b()) {
            return;
        }
        if (intimateInfo.beFriendDays >= -1) {
            int i3 = this.D;
            if (i3 != 1 && i3 != 3 && i3 != 2 && i3 != 26) {
                j0(0, intimateInfo.maskLevel);
                return;
            } else {
                j0(i3, intimateInfo.maskLevel);
                return;
            }
        }
        j0(0, intimateInfo.maskLevel);
    }

    public void d0(QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo) {
        IntimateHeaderView intimateHeaderView = this.L;
        if (intimateHeaderView != null) {
            intimateHeaderView.C(qZIntimateSpaceRedDotReader$EntranceInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    protected View l() {
        return this.I;
    }

    public void m0(com.tencent.aio.frame.api.e eVar) {
        this.f178200m0 = eVar;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    protected void s(IntimateInfo intimateInfo) {
        super.s(intimateInfo);
        if (com.tencent.mobileqq.activity.aio.intimate.header.n.b()) {
            return;
        }
        j0(this.D, intimateInfo.maskLevel);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
    public void y() {
        QLog.i("IntimateInfoViewV2", 1, "onBackAction");
        com.tencent.aio.frame.api.e eVar = this.f178200m0;
        if (eVar != null) {
            eVar.e(300);
        }
    }
}
