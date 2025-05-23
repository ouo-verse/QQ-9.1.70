package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseMiniAppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.music.SyncMusicInfoHandler;
import com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;

@SuppressLint({"UseCompatLoadingForDrawables"})
/* loaded from: classes16.dex */
public class SyncStatusExtInfoPopWindow extends BottomSheetDialogFragment {
    protected int C;
    protected int E;
    protected View F;
    protected d G;
    protected IOnlineStatusMiniService.c H;
    protected IOnlineStatusMiniService.a I;
    protected Button J;
    protected TextView K;
    protected TextView L;
    protected ImageView M;
    protected TextView N;
    protected TextView P;
    protected TextView Q;
    protected String R;
    protected String S;
    protected String T;
    private com.tencent.mobileqq.armap.f U;
    private CustomShareInfo V;
    protected com.tencent.mobileqq.onlinestatus.an W;
    protected AppInterface X;
    protected BottomSheetBehavior<FrameLayout> Y;
    protected c Z;

    /* renamed from: a0, reason: collision with root package name */
    protected v.a f256457a0;
    protected boolean D = false;

    /* renamed from: b0, reason: collision with root package name */
    protected com.tencent.mobileqq.onlinestatus.av f256458b0 = new a();

    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.onlinestatus.av {
        a() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean z16, Bundle bundle) {
            if (bundle == null) {
                return;
            }
            long j3 = bundle.getLong("extStatus");
            if (z16 && j3 == 1021) {
                SyncStatusExtInfoPopWindow.this.yh();
                TencentVideoNameHandler tencentVideoNameHandler = (TencentVideoNameHandler) SyncStatusExtInfoPopWindow.this.X.getBusinessHandler(TencentVideoNameHandler.class.getName());
                SyncStatusExtInfoPopWindow syncStatusExtInfoPopWindow = SyncStatusExtInfoPopWindow.this;
                tencentVideoNameHandler.D2(1, syncStatusExtInfoPopWindow.T, syncStatusExtInfoPopWindow.X.getCurrentAccountUin());
                return;
            }
            if (z16 && j3 == 1028) {
                SyncMusicInfoHandler syncMusicInfoHandler = (SyncMusicInfoHandler) SyncStatusExtInfoPopWindow.this.X.getBusinessHandler(SyncMusicInfoHandler.class.getName());
                SyncStatusExtInfoPopWindow syncStatusExtInfoPopWindow2 = SyncStatusExtInfoPopWindow.this;
                syncMusicInfoHandler.F2(syncStatusExtInfoPopWindow2.W, syncStatusExtInfoPopWindow2.V);
            }
        }
    }

    /* loaded from: classes16.dex */
    class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            if (QLog.isColorLevel()) {
                QLog.i("SyncStatusExtInfoStatusPopWindow", 2, "onSlide\uff1aslideOffset = " + f16);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("SyncStatusExtInfoStatusPopWindow", 2, "onStateChanged\uff1anewState = " + i3);
            }
            if (i3 == 4) {
                v.a aVar = SyncStatusExtInfoPopWindow.this.f256457a0;
                if (aVar != null) {
                    aVar.L0(AppRuntime.Status.online, 1021);
                }
                IOnlineStatusMiniService.a aVar2 = SyncStatusExtInfoPopWindow.this.I;
                if (aVar2 != null) {
                    aVar2.a(true);
                }
                SyncStatusExtInfoPopWindow.this.dismiss();
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface c {
        void z3();
    }

    /* loaded from: classes16.dex */
    public interface d {
    }

    /* loaded from: classes16.dex */
    public interface e {
        void a(boolean z16);
    }

    public SyncStatusExtInfoPopWindow(String str, String str2, String str3, CustomShareInfo customShareInfo, c cVar, v.a aVar, AppInterface appInterface) {
        this.E = 0;
        this.R = str;
        this.T = str2;
        this.S = str3;
        this.V = customShareInfo;
        this.Z = cVar;
        this.f256457a0 = aVar;
        this.X = appInterface;
        this.E = 1;
    }

    private Drawable Ah() {
        int i3 = this.E;
        if (i3 == 1) {
            return getResources().getDrawable(R.drawable.o4l);
        }
        if (i3 == 2) {
            return getResources().getDrawable(R.drawable.nfe);
        }
        return null;
    }

    private void Ch() {
        LinearLayout linearLayout = (LinearLayout) this.F.findViewById(R.id.f627131k);
        if (this.E == 2) {
            linearLayout.setBackground(getContext().getResources().getDrawable(R.drawable.nfd));
        }
    }

    private void Eh() {
        this.P = (TextView) this.F.findViewById(R.id.f627331m);
        this.Q = (TextView) this.F.findViewById(R.id.f627231l);
    }

    private void Hh() {
        if (this.E == 2) {
            this.P.setText(R.string.f201204u7);
            this.Q.setText(R.string.f201194u6);
        }
    }

    private boolean Lh() {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H;
        com.tencent.mobileqq.onlinestatus.an anVar = this.W;
        if (anVar == null || "".equals(anVar.f255411b) || (H = com.tencent.mobileqq.onlinestatus.bs.H("SyncStatusExtInfoStatusPopWindow")) == null || !this.W.f255411b.equals(H.V()) || H.e0() != 1028) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh() {
        dismissAllowingStateLoss();
        c cVar = this.Z;
        if (cVar != null) {
            cVar.z3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.onlinestatus.utils.z.C(this.C);
        if (this.X.getAccount() != null && this.X.isLogin()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(this.X.getApplicationContext(), 1, R.string.hpk, 1).show();
                dismiss();
            } else {
                int i3 = this.E;
                if (i3 == 1) {
                    Wh();
                } else if (i3 == 2) {
                    Uh();
                }
            }
        } else {
            QQToast.makeText(this.X.getApplicationContext(), R.string.f225356le, 1).show();
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(String str, String str2, Bitmap bitmap) {
        if (QLog.isColorLevel()) {
            QLog.i("SyncStatusExtInfoStatusPopWindow", 2, "onFaceUpdate uin: " + str + " -- " + str2 + " head:" + bitmap);
        }
        if (bitmap != null) {
            this.M.setImageDrawable(new BitmapDrawable(bitmap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ph(boolean z16) {
        if (!z16) {
            this.X.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.bm
                @Override // java.lang.Runnable
                public final void run() {
                    SyncStatusExtInfoPopWindow.this.lambda$onCreate$0();
                }
            });
        } else {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = com.tencent.mobileqq.onlinestatus.bs.H("SyncStatusExtInfoStatusPopWindow");
            if (H != null) {
                H.U0(this.W.f255411b);
                H.V0(this.W.f255412c);
                H.R0(this.W.f255414e);
                H.S0(this.W.f255418i);
                H.T0(this.W.f255415f);
                H.X0(this.W.f255416g);
                H.W0(this.W.f255415f);
                ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).updateOnlineStatusSimpleInfo(H, "SyncStatusExtInfoStatusPopWindow", (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
            }
        }
        yh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(DialogInterface dialogInterface) {
        IOnlineStatusMiniService.a aVar = this.I;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    private void Uh() {
        com.tencent.mobileqq.onlinestatus.af C = com.tencent.mobileqq.onlinestatus.af.C();
        AppRuntime.Status status = AppRuntime.Status.online;
        if (C.I(status, 1028L).f255489b != 1028) {
            QQToast.makeText(getContext(), R.string.f225356le, 0).show();
            yh();
        } else {
            ((IOnlineStatusService) this.X.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(status, 1028L);
        }
    }

    private void Wh() {
        if (com.tencent.mobileqq.onlinestatus.af.C().I(AppRuntime.Status.online, 1021L).f255489b != 1021) {
            QQToast.makeText(getContext(), R.string.f225356le, 0).show();
            yh();
            return;
        }
        AppInterface appInterface = this.X;
        if (appInterface instanceof BaseQQAppInterface) {
            com.tencent.mobileqq.onlinestatus.utils.ad.c(this.T, this.S, this.V, appInterface, null);
        } else if (appInterface instanceof BaseMiniAppInterface) {
            com.tencent.mobileqq.onlinestatus.utils.ad.d(this.T, this.S, this.V, this.H);
            dismiss();
        }
    }

    private String getStatusDesc() {
        int i3 = this.E;
        if (i3 == 1) {
            return getResources().getString(R.string.f23078703) + " " + this.R;
        }
        if (i3 == 2) {
            return getResources().getString(R.string.f201184u5) + " " + this.W.f255412c + "-" + this.W.f255414e;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        QQToast.makeText(getContext(), R.string.f225356le, 0).show();
    }

    private void xh() {
        Window window;
        if (!AppSetting.t(getContext())) {
            return;
        }
        if (getDialog() != null) {
            window = getDialog().getWindow();
        } else {
            window = null;
        }
        if (window == null) {
            return;
        }
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        int dpToPx = ViewUtils.dpToPx(400.0f);
        if (i3 > dpToPx) {
            window.setLayout(dpToPx, -1);
            window.setGravity(81);
        } else {
            window.setLayout(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(EIPCResult eIPCResult) {
        if (eIPCResult == null) {
            QLog.e("SyncStatusExtInfoStatusPopWindow", 1, "ACTION_GET_ONLINE_STATUS_MAIN error, result is null");
            return;
        }
        if (eIPCResult.code != 0) {
            QLog.e("SyncStatusExtInfoStatusPopWindow", 1, "ACTION_GET_ONLINE_STATUS_MAIN: result.code: " + eIPCResult.code);
            return;
        }
        long j3 = eIPCResult.data.getLong(IOnlineStatusMiniService.ONLINE_STATE);
        String string = eIPCResult.data.getString("cid");
        String str = this.T;
        if (str != null && str.equals(string) && j3 == 1021) {
            this.D = true;
        }
    }

    String Bh() {
        String str;
        Time time = new Time();
        time.setToNow();
        int i3 = time.hour;
        int i16 = time.minute;
        StringBuilder sb5 = new StringBuilder();
        String str2 = "0";
        if (i3 < 10) {
            str = "0";
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(i3);
        sb5.append(":");
        if (i16 >= 10) {
            str2 = "";
        }
        sb5.append(str2);
        sb5.append(i16);
        return sb5.toString();
    }

    void Dh() {
        int i3 = this.E;
        if (i3 == 1) {
            AppInterface appInterface = this.X;
            if (appInterface instanceof BaseQQAppInterface) {
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = com.tencent.mobileqq.onlinestatus.bs.H("SyncStatusExtInfoStatusPopWindow");
                String str = this.T;
                if (str != null && H != null && str.equals(H.g0()) && H.e0() == 1021) {
                    this.D = true;
                    return;
                }
                return;
            }
            if (appInterface instanceof BaseMiniAppInterface) {
                QIPCClientHelper.getInstance().callServer("TencentVideoStatusQIPCModule", "ACTION_GET_ONLINE_STATUS_MAIN", null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.onlinestatus.view.bn
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        SyncStatusExtInfoPopWindow.this.zh(eIPCResult);
                    }
                });
                return;
            }
            return;
        }
        if (i3 == 2) {
            this.D = Lh();
        }
    }

    void Fh() {
        Button button = (Button) this.F.findViewById(R.id.f83644k4);
        this.J = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncStatusExtInfoPopWindow.this.Nh(view);
            }
        });
    }

    void Gh() {
        String Bh = Bh();
        TextView textView = (TextView) this.F.findViewById(R.id.f94085bb);
        this.N = textView;
        textView.setText(Bh);
    }

    void Ih(String str) {
        this.M = (ImageView) this.F.findViewById(R.id.f94115be);
        com.tencent.mobileqq.armap.f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(getContext(), 3);
        this.U = nonMainAppHeadLoader;
        if (nonMainAppHeadLoader != null) {
            nonMainAppHeadLoader.init();
            this.U.a(new com.tencent.mobileqq.armap.e() { // from class: com.tencent.mobileqq.onlinestatus.view.bo
                @Override // com.tencent.mobileqq.armap.e
                public final void h(String str2, String str3, Bitmap bitmap) {
                    SyncStatusExtInfoPopWindow.this.Oh(str2, str3, bitmap);
                }
            });
            this.U.b(str, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void Jh(String str) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar;
        if (!TextUtils.isEmpty(str)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (!TextUtils.isEmpty(uidFromUin)) {
                dVar = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "SyncStatusExtInfoStatusPopWindow");
                if (dVar != null) {
                    str = dVar.m();
                }
                TextView textView = (TextView) this.F.findViewById(R.id.f94125bf);
                this.K = textView;
                textView.setText(str);
            }
        }
        dVar = null;
        if (dVar != null) {
        }
        TextView textView2 = (TextView) this.F.findViewById(R.id.f94125bf);
        this.K = textView2;
        textView2.setText(str);
    }

    void Kh() {
        this.L = (TextView) this.F.findViewById(R.id.f94135bg);
        String statusDesc = getStatusDesc();
        Drawable Ah = Ah();
        if (statusDesc != null && Ah != null) {
            Ah.setBounds(0, 0, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
            Drawable drawable = getResources().getDrawable(R.drawable.o3t);
            drawable.setBounds(0, 0, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
            this.L.setCompoundDrawables(Ah, null, drawable, null);
            this.L.setText(statusDesc);
            return;
        }
        yh();
    }

    public void Rh(IOnlineStatusMiniService.a aVar) {
        this.I = aVar;
    }

    public void Sh(d dVar) {
        this.G = dVar;
    }

    public void Th(int i3) {
        this.C = i3;
    }

    public void Vh(IOnlineStatusMiniService.c cVar) {
        this.H = cVar;
    }

    void initView() {
        String currentUin = this.X.getCurrentUin();
        Ch();
        Eh();
        Hh();
        Fh();
        Jh(currentUin);
        Ih(currentUin);
        Gh();
        Kh();
        if (this.D) {
            ((TextView) this.F.findViewById(R.id.f627331m)).setText(getString(R.string.f23082707));
            this.J.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppInterface appInterface = this.X;
        if (appInterface instanceof BaseQQAppInterface) {
            appInterface.addObserver(this.f256458b0);
        }
        Dh();
        ((SyncMusicInfoHandler) this.X.getBusinessHandler(SyncMusicInfoHandler.class.getName())).I2(new e() { // from class: com.tencent.mobileqq.onlinestatus.view.bk
            @Override // com.tencent.mobileqq.onlinestatus.view.SyncStatusExtInfoPopWindow.e
            public final void a(boolean z16) {
                SyncStatusExtInfoPopWindow.this.Ph(z16);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        if (getContext() == null) {
            view = null;
        } else {
            this.F = layoutInflater.inflate(R.layout.hrx, viewGroup);
            initView();
            com.tencent.mobileqq.onlinestatus.utils.z.B(this.C);
            view = this.F;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppInterface appInterface = this.X;
        if (appInterface instanceof BaseQQAppInterface) {
            appInterface.removeObserver(this.f256458b0);
        }
        com.tencent.mobileqq.armap.f fVar = this.U;
        if (fVar != null) {
            fVar.destroy();
        }
        ((SyncMusicInfoHandler) this.X.getBusinessHandler(SyncMusicInfoHandler.class.getName())).I2(null);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.F.getParent()).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        xh();
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        this.Y = behavior;
        behavior.setState(3);
        this.Y.setPeekHeight(0);
        this.Y.addBottomSheetCallback(new b());
        getDialog().setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bj
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SyncStatusExtInfoPopWindow.this.Qh(dialogInterface);
            }
        });
    }

    void yh() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.bl
            @Override // java.lang.Runnable
            public final void run() {
                SyncStatusExtInfoPopWindow.this.Mh();
            }
        }, 2000L);
    }

    public SyncStatusExtInfoPopWindow(com.tencent.mobileqq.onlinestatus.an anVar, CustomShareInfo customShareInfo, AppInterface appInterface, c cVar, v.a aVar) {
        this.E = 0;
        this.W = anVar;
        this.V = customShareInfo;
        this.X = appInterface;
        this.Z = cVar;
        this.f256457a0 = aVar;
        this.E = 2;
    }
}
