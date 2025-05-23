package com.tencent.qq.minibox.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.image.URLDrawable;
import com.tencent.minibox.business.api.IMiniBoxCallback;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.minibox.contract.LaunchAppInfo;
import com.tencent.minibox.contract.LaunchExtInfo;
import com.tencent.minibox.contract.LocalInstallInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dq;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qq.minibox.event.CloseLoadingPageEvent;
import com.tencent.qq.minibox.manager.danmaku.MiniBoxDanmakuManager;
import com.tencent.qq.minibox.ui.MiniBoxAppLoadingFragment;
import com.tencent.qq.minibox.ui.view.indicator.CircleIndicator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$AppCommentInfo;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$AppMediaInfo;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$GetVMAppInfoRsq;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MiniBoxAppLoadingFragment extends BaseMiniBoxAppFragment implements View.OnClickListener, SimpleEventReceiver, qs3.a {
    private SquareImageView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private ImageView N;
    private ImageView P;
    private ImageView Q;
    private ImageView R;
    private ViewPager2 S;
    private CircleIndicator T;
    private ss3.c U;
    private MiniBoxDanmakuManager V;
    private VirtualAppInfo W;
    private ss3.f X;
    private ProgressBar Y;
    private Intent Z;

    /* renamed from: a0, reason: collision with root package name */
    private us3.o f344626a0;

    /* renamed from: e0, reason: collision with root package name */
    private int f344630e0;

    /* renamed from: b0, reason: collision with root package name */
    private int f344627b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f344628c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f344629d0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private Handler f344631f0 = new Handler(new Handler.Callback() { // from class: com.tencent.qq.minibox.ui.f
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean Hi;
            Hi = MiniBoxAppLoadingFragment.this.Hi(message);
            return Hi;
        }
    });

    /* renamed from: g0, reason: collision with root package name */
    private Boolean f344632g0 = Boolean.valueOf(!us3.q.f440003a.e());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements rs3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirtualAppInfo f344634a;

        a(VirtualAppInfo virtualAppInfo) {
            this.f344634a = virtualAppInfo;
        }

        @Override // rs3.b
        public void a(@Nullable LocalInstallInfo localInstallInfo) {
            MiniBoxAppLoadingFragment.this.wi(this.f344634a, localInstallInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements IMiniBoxCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirtualAppInfo f344636a;

        b(VirtualAppInfo virtualAppInfo) {
            this.f344636a = virtualAppInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            MiniBoxAppLoadingFragment miniBoxAppLoadingFragment = MiniBoxAppLoadingFragment.this;
            miniBoxAppLoadingFragment.hj(miniBoxAppLoadingFragment.yi().getPackageName());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (MiniBoxAppLoadingFragment.this.uh()) {
                MiniBoxAppLoadingFragment.this.getQBaseActivity().finish();
            }
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxCallback
        public void onFail(int i3, String str) {
            QLog.d("MiniBoxAppLoadingFragment", 4, " MiniBoxSDK launchApp fail ,appid=" + this.f344636a.getAppId() + " err=" + i3);
            us3.p.f440002a.f(this.f344636a, false, i3, str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.p
                @Override // java.lang.Runnable
                public final void run() {
                    MiniBoxAppLoadingFragment.b.this.c();
                }
            });
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxCallback
        public void onSuccess() {
            QLog.d("MiniBoxAppLoadingFragment", 4, " MiniBoxSDK launchApp succ ,appid=" + this.f344636a.getAppId());
            us3.p.f440002a.f(this.f344636a, true, 0, MeasureConst.SLI_TYPE_SUCCESS);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.q
                @Override // java.lang.Runnable
                public final void run() {
                    MiniBoxAppLoadingFragment.b.this.d();
                }
            });
        }
    }

    private void Ai(List<VMBasicInfo$AppCommentInfo> list) {
        if (list != null && list.size() != 0) {
            this.V.k();
            this.V.c(list);
        }
    }

    private void Bi() {
        int i3 = this.f344627b0;
        if (i3 == 300) {
            Zi();
            return;
        }
        if (i3 == 200) {
            Zi();
            gj();
        } else if (i3 == -1) {
            Yi();
        } else if (i3 == 100) {
            bj();
        }
    }

    private void Ci() {
        this.G.setText(xi(this.W.b(), this.W.a()));
        if (this.W.b()) {
            this.H.setText(" ");
        } else {
            this.H.setText(getString(R.string.f166922bj));
        }
    }

    private void Di(VMBasicInfo$GetVMAppInfoRsq vMBasicInfo$GetVMAppInfoRsq) {
        if (!uh()) {
            return;
        }
        final List<VMBasicInfo$AppMediaInfo> list = vMBasicInfo$GetVMAppInfoRsq.info.covers.get();
        final List<VMBasicInfo$AppCommentInfo> list2 = vMBasicInfo$GetVMAppInfoRsq.info.comments.get();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxAppLoadingFragment.this.Gi(list, list2);
            }
        });
    }

    private void Ei(VirtualAppInfo virtualAppInfo) {
        int i3;
        this.F.setText(virtualAppInfo.getAppName());
        if (!TextUtils.isEmpty(virtualAppInfo.getAppIcon())) {
            try {
                this.E.setImageDrawable(URLDrawable.getDrawable(virtualAppInfo.getAppIcon(), us3.r.b(this.F.getContext())));
            } catch (Throwable th5) {
                QLog.e("MiniBoxAppLoadingFragment", 1, "init app info ui set drawable throw:", th5);
            }
        }
        TextView textView = this.L;
        if (virtualAppInfo.a()) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        textView.setVisibility(i3);
        Ci();
        Wi(yi().getCoverUrl());
    }

    private void Fi() {
        VirtualAppInfo yi5 = yi();
        if (!us3.f.f439985a.a(yi5)) {
            QLog.w("MiniBoxAppLoadingFragment", 1, "initMiniBoxLoading checkAppInfo failed:" + yi5);
            Ri("4");
            getQBaseActivity().finish();
        }
        us3.q qVar = us3.q.f440003a;
        qVar.l(this.W.getPackageName(), this.W.getDesc());
        qVar.m(this.W.getPackageName(), this.W.getAppId());
        Ei(yi5);
        th(yi5.getPackageName());
        Yh(yi5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gi(List list, List list2) {
        zi(list);
        Ai(list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Hi(Message message) {
        int i3 = message.what;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            Bi();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ii(WadlResult wadlResult) {
        ej(wadlResult, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ji(WadlResult wadlResult) {
        ej(wadlResult, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Ki(Integer num) {
        Ui(num.intValue());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Li(WadlResult wadlResult, DialogInterface dialogInterface, int i3) {
        if ((dialogInterface instanceof QQCustomDialog) && ((QQCustomDialog) dialogInterface).getCheckBoxState()) {
            QLog.d("MiniBoxAppLoadingFragment", 1, "addDelayDownloadTaslk:" + wadlResult.wadlParams.packageName);
            us3.s.f440005a.a(wadlResult.wadlParams);
        }
        Zh(yi().getPackageName());
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Mi(WadlResult wadlResult, DialogInterface dialogInterface, int i3) {
        if ((dialogInterface instanceof QQCustomDialog) && ((QQCustomDialog) dialogInterface).getCheckBoxState()) {
            QLog.d("MiniBoxAppLoadingFragment", 1, "addDelayDownloadTaslk:" + wadlResult.wadlParams.packageName);
            us3.s.f440005a.a(wadlResult.wadlParams);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ni(String str, DialogInterface dialogInterface, int i3) {
        this.C.doInstallAction(xh(), str);
        getQBaseActivity().finish();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oi(DialogInterface dialogInterface, int i3) {
        getQBaseActivity().finish();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        getQBaseActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Qi() {
        us3.q qVar = us3.q.f440003a;
        if (qVar.f()) {
            int i3 = this.f344627b0;
            if (i3 != 100 && i3 != 300) {
                getQBaseActivity().finish();
                return;
            } else {
                ij();
                qVar.p(false);
                return;
            }
        }
        getQBaseActivity().finish();
    }

    private void Ri(String str) {
        String appId;
        int scene;
        String via;
        VirtualAppInfo yi5 = yi();
        String str2 = "";
        if (yi5 == null) {
            appId = "";
        } else {
            appId = yi5.getAppId();
        }
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(appId).setOperModule("9080").setBussinessId("1").setPageId("969").setModuleType("908001").setOperId("907228").setOperType("20").setExt(5, str).report();
        if (yi() == null) {
            QLog.e("MiniBoxAppLoadingFragment", 1, "reportPageClick getMiniBoxAppInfo null");
            return;
        }
        if (yi5 == null) {
            scene = 0;
        } else {
            scene = yi5.getScene();
        }
        if (yi5 == null) {
            via = "";
        } else {
            via = yi5.getVia();
        }
        if (yi5 != null) {
            str2 = yi5.getReportData();
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameVirtual(appId, "page_view", "virtual_click_module", "", null, str, String.valueOf(scene), via, str2);
    }

    private void Si(int i3) {
        String appId;
        int scene;
        String via;
        if (i3 != -1 && this.f344628c0) {
            return;
        }
        VirtualAppInfo yi5 = yi();
        String str = "";
        if (yi5 == null) {
            appId = "";
        } else {
            appId = yi5.getAppId();
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(appId).setOperModule("9080").setBussinessId("1").setPageId("969").setModuleType("908001").setExt(6, this.f344630e0 + "");
        if (i3 == -1) {
            wadlReportBuilder.setOperId("907227").setOperType("8");
        } else {
            wadlReportBuilder.setOperId("907231").setOperType("8").setExt(5, i3 + "");
            this.f344628c0 = true;
            if (yi5 == null) {
                scene = 0;
            } else {
                scene = yi5.getScene();
            }
            if (yi5 == null) {
                via = "";
            } else {
                via = yi5.getVia();
            }
            if (yi5 != null) {
                str = yi5.getReportData();
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameVirtual(appId, "page_view", "virtual_load", "", null, null, String.valueOf(scene), via, str);
        }
        wadlReportBuilder.report();
    }

    private void Ti(String str, qs3.a aVar) {
        qs3.c.f429464a.d(new rs3.f(str), aVar);
    }

    @SuppressLint({"DefaultLocale"})
    private void Ui(int i3) {
        this.Y.setProgress(i3);
        this.I.setText(String.format("%d%%", Integer.valueOf(i3)));
    }

    private void Vi() {
        this.I.setVisibility(4);
        this.P.setVisibility(4);
        this.Y.setVisibility(4);
        this.M.setVisibility(4);
        this.N.setVisibility(4);
        this.M.setVisibility(0);
        this.M.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.M.getWidth(), this.M.getHeight(), Color.parseColor("#00B3FF"), Color.parseColor("#00DAFF"), Shader.TileMode.MIRROR));
        this.M.invalidate();
    }

    private void Wi(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "https://img.gamecenter.qq.com/xgame/gm/1684467921348_2fd2abeab05d59f03a4d01caaa835059.png";
        }
        this.X.q0(str);
    }

    private void Xi() {
        Vi();
        this.M.setVisibility(0);
        this.M.setText(R.string.f166202_l);
    }

    private void Yi() {
        Vi();
        this.M.setVisibility(0);
        this.M.setText(R.string.f166842bb);
    }

    private void Zi() {
        this.N.setVisibility(8);
        this.Y.setVisibility(0);
        this.I.setVisibility(0);
        this.M.setVisibility(4);
        this.H.setVisibility(0);
        fj();
    }

    private void aj(VirtualAppInfo virtualAppInfo) {
        kj(virtualAppInfo.getVideoUrl());
        this.f344627b0 = -1;
        this.f344631f0.sendEmptyMessageDelayed(1, 500L);
        jj(1);
    }

    private void bj() {
        Vi();
        this.M.setVisibility(0);
        this.M.setText(R.string.f166962bn);
    }

    private void cj() {
        this.N.setVisibility(0);
        this.P.setVisibility(8);
        this.Y.setVisibility(8);
        this.I.setVisibility(8);
    }

    private void dj(VirtualAppInfo virtualAppInfo) {
        jj(2);
        cj();
    }

    private void ej(final WadlResult wadlResult, Boolean bool) {
        if (uh()) {
            QQCustomDialog a16 = dq.a(getActivity(), 0, "\u6682\u505c\u52a0\u8f7d", us3.r.f440004a.a(getActivity(), wadlResult), R.string.f1655228r, R.string.f1653728c, new DialogInterface.OnClickListener() { // from class: com.tencent.qq.minibox.ui.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MiniBoxAppLoadingFragment.this.Li(wadlResult, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.qq.minibox.ui.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MiniBoxAppLoadingFragment.Mi(WadlResult.this, dialogInterface, i3);
                }
            });
            if (bool.booleanValue()) {
                a16.setCheckBox(getString(R.string.f16533289), true, null);
            }
            a16.show();
        }
    }

    private void fj() {
        this.P.setVisibility(0);
        this.P.setImageResource(R.drawable.n0k);
    }

    private void gj() {
        this.P.setVisibility(0);
        this.P.setImageResource(R.drawable.n0l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(final String str) {
        if (uh()) {
            QQCustomDialog a16 = dq.a(getActivity(), 0, "\u6e29\u99a8\u63d0\u9192", "\u5f53\u524d\u6e38\u620f\u542f\u52a8\u8fdb\u7a0b\u51fa\u73b0\u5f02\u5e38\uff0c\u662f\u5426\u5b89\u88c5\u5230\u684c\u9762\uff0c\u4ee5\u4fbf\u6b63\u5e38\u6e38\u73a9~", R.string.f1655228r, R.string.f1653428_, new DialogInterface.OnClickListener() { // from class: com.tencent.qq.minibox.ui.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MiniBoxAppLoadingFragment.this.Ni(str, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.qq.minibox.ui.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MiniBoxAppLoadingFragment.this.Oi(dialogInterface, i3);
                }
            });
            a16.setCancelable(false);
            a16.show();
        }
    }

    private void ij() {
        if (uh()) {
            ts3.b bVar = new ts3.b(getActivity());
            bVar.P(new View.OnClickListener() { // from class: com.tencent.qq.minibox.ui.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniBoxAppLoadingFragment.this.Pi(view);
                }
            });
            bVar.show();
        }
    }

    private void initView(View view) {
        this.U = new ss3.c((FrameLayout) view.findViewById(R.id.f166026yg0));
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f165772xj4);
        this.E = squareImageView;
        squareImageView.setRoundRect(30);
        this.F = (TextView) view.findViewById(R.id.f1060667p);
        this.G = (TextView) view.findViewById(R.id.f109096ew);
        this.H = (TextView) view.findViewById(R.id.f107406ab);
        this.N = (ImageView) view.findViewById(R.id.xk9);
        this.Y = (ProgressBar) view.findViewById(R.id.f27490gd);
        this.I = (TextView) view.findViewById(R.id.f110116hn);
        this.P = (ImageView) view.findViewById(R.id.xjf);
        this.J = (TextView) view.findViewById(R.id.f1062868a);
        this.K = (TextView) view.findViewById(R.id.f108386cz);
        this.Q = (ImageView) view.findViewById(R.id.xj_);
        this.R = (ImageView) view.findViewById(R.id.xjp);
        this.L = (TextView) view.findViewById(R.id.f109106ex);
        this.M = (TextView) view.findViewById(R.id.f112496o3);
        this.S = (ViewPager2) view.findViewById(R.id.f12030797);
        this.T = (CircleIndicator) view.findViewById(R.id.mfd);
        this.P.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.V = new MiniBoxDanmakuManager(this, getActivity(), (FrameLayout) view.findViewById(R.id.ydx));
        this.X = new ss3.f(getActivity(), this.S, this.T);
    }

    private void jj(int i3) {
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 5) {
                    return;
                }
            } else {
                this.G.setText(yi().getDesc());
                this.H.setText(R.string.f166902bh);
                return;
            }
        }
        Ci();
    }

    private void kj(String str) {
        if (uh() && this.f344632g0.booleanValue()) {
            this.U.i(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(VirtualAppInfo virtualAppInfo) {
        cj();
        rs3.c.b(virtualAppInfo.getAppId(), new a(virtualAppInfo));
    }

    private void ri(VirtualAppInfo virtualAppInfo, WadlResult wadlResult) {
        QLog.d("MiniBoxAppLoadingFragment", 4, "doAppApkExitsLogic pckName:" + virtualAppInfo.getPackageName());
        int s16 = virtualAppInfo.s();
        String md5 = virtualAppInfo.getMd5();
        File file = new File(wadlResult.downloadFilePath);
        WadlParams wadlParams = wadlResult.wadlParams;
        if (wadlParams == null) {
            si(virtualAppInfo);
            return;
        }
        if (s16 != wadlParams.versionCode || !file.exists() || !md5.equals(m51.c.f416181a.a(file))) {
            WadlParams wadlParams2 = wadlResult.wadlParams;
            if (s16 >= wadlParams2.versionCode) {
                vh(wadlParams2.packageName);
                si(virtualAppInfo);
                return;
            }
        }
        ti(virtualAppInfo, wadlResult.downloadFilePath);
    }

    private void si(VirtualAppInfo virtualAppInfo) {
        QLog.d("MiniBoxAppLoadingFragment", 4, "doAppDownLoadLogic pckName:" + virtualAppInfo.getPackageName());
        bi(virtualAppInfo);
        aj(virtualAppInfo);
    }

    private void ti(VirtualAppInfo virtualAppInfo, String str) {
        QLog.d("MiniBoxAppLoadingFragment", 2, "doAppInstallLogic apkFilePath:" + str);
        dj(virtualAppInfo);
        Dh(str);
    }

    private void ui(final VirtualAppInfo virtualAppInfo) {
        QLog.d("MiniBoxAppLoadingFragment", 4, "doAppStartLogic pckName:" + virtualAppInfo.getPackageName());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qq.minibox.ui.MiniBoxAppLoadingFragment.1
            @Override // java.lang.Runnable
            public void run() {
                MiniBoxAppLoadingFragment.this.lj(virtualAppInfo);
            }
        }, 500L);
    }

    private void vi(VirtualAppInfo virtualAppInfo, Long l3) {
        String appId = virtualAppInfo.getAppId();
        String versionCode = virtualAppInfo.getVersionCode();
        if (appId != null && versionCode != null) {
            gs3.c.o(appId, versionCode, l3.longValue());
            return;
        }
        QLog.e("MiniBoxAppLoadingFragment", 1, "[doAppStartLogic] appId or appVersion is null. appId=" + appId + "appVersion=" + versionCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(VirtualAppInfo virtualAppInfo, @Nullable LocalInstallInfo localInstallInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        LaunchAppInfo launchAppInfo = new LaunchAppInfo();
        launchAppInfo.setAppId(virtualAppInfo.getAppId());
        launchAppInfo.setAppVersion(virtualAppInfo.getVersionCode());
        launchAppInfo.setLaunchTime(currentTimeMillis);
        launchAppInfo.setPackageName(virtualAppInfo.getPackageName());
        launchAppInfo.setLaunch(new LaunchExtInfo(virtualAppInfo.getScene(), virtualAppInfo.getVia(), virtualAppInfo.getReportData()));
        launchAppInfo.setInstallDialogData(localInstallInfo);
        MiniBoxSDK.launchApp(launchAppInfo, new b(virtualAppInfo));
        vi(virtualAppInfo, Long.valueOf(currentTimeMillis));
    }

    private String xi(boolean z16, boolean z17) {
        if (z17 && z16) {
            return getString(R.string.f166922bj);
        }
        if (z17 && !z16) {
            return getString(R.string.f166932bk);
        }
        if (!z17 && z16) {
            return getString(R.string.f166922bj);
        }
        if (!z17 && !z16) {
            return getString(R.string.f166932bk);
        }
        return getString(R.string.f166922bj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VirtualAppInfo yi() {
        if (this.W == null) {
            Intent intent = this.Z;
            if (intent != null && intent.hasExtra("virtualAppData")) {
                this.W = (VirtualAppInfo) this.Z.getParcelableExtra("virtualAppData");
            }
            Intent intent2 = this.Z;
            if (intent2 != null && intent2.hasExtra("minibox_from")) {
                this.f344630e0 = this.Z.getIntExtra("minibox_from", 0);
            }
        }
        return this.W;
    }

    private void zi(List<VMBasicInfo$AppMediaInfo> list) {
        if (this.f344632g0.booleanValue()) {
            this.X.r0();
            this.X.y0();
            return;
        }
        if (list != null && list.size() > 0) {
            if (!TextUtils.isEmpty(yi().getVideoUrl())) {
                this.X.r0();
                this.X.q0(list.get(0).url.get());
                return;
            }
            this.X.r0();
            ArrayList arrayList = new ArrayList();
            Iterator<VMBasicInfo$AppMediaInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().get().url.get());
            }
            this.X.x0(arrayList);
        }
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Lh(int i3) {
        Xi();
        ai(getString(R.string.f166882bf));
        us3.o oVar = this.f344626a0;
        if (oVar != null) {
            oVar.k();
        }
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Mh(final WadlResult wadlResult) {
        super.Mh(wadlResult);
        gj();
        this.f344627b0 = 200;
        if (!this.f344629d0) {
            boolean z16 = true;
            this.f344629d0 = true;
            long j3 = ((float) (wadlResult.fileSize - wadlResult.downloadFileSize)) / ((float) wadlResult.speed);
            boolean c16 = us3.s.c();
            if (NetworkUtil.getSystemNetwork(getActivity()) != 1) {
                z16 = false;
            }
            if (!c16 && !z16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniBoxAppLoadingFragment.this.Ii(wadlResult);
                    }
                });
            } else if (j3 < 60) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniBoxAppLoadingFragment.this.Ji(wadlResult);
                    }
                });
            }
        }
        us3.o oVar = this.f344626a0;
        if (oVar != null) {
            oVar.e();
        }
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Nh(int i3, String str, String str2, String str3) {
        int i16 = this.f344627b0;
        if (i16 == 100 || i16 == 200) {
            this.f344631f0.sendEmptyMessageDelayed(3, 500L);
            this.f344627b0 = 300;
        }
        String format = String.format(getString(R.string.f166912bi), str, str2, str3);
        if (this.M.getVisibility() != 0) {
            this.H.setText(format);
        }
        us3.o oVar = this.f344626a0;
        if (oVar != null) {
            oVar.g(i3);
        }
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Ph(WadlResult wadlResult) {
        super.Ph(wadlResult);
        this.f344627b0 = 100;
        this.f344631f0.sendEmptyMessageDelayed(2, 500L);
        us3.o oVar = this.f344626a0;
        if (oVar == null) {
            us3.o oVar2 = new us3.o(wadlResult.fileSize);
            this.f344626a0 = oVar2;
            oVar2.i(new Function1() { // from class: com.tencent.qq.minibox.ui.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Ki;
                    Ki = MiniBoxAppLoadingFragment.this.Ki((Integer) obj);
                    return Ki;
                }
            });
            this.f344626a0.j();
            return;
        }
        oVar.f();
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Qh(WadlResult wadlResult) {
        this.f344627b0 = 400;
        ti(yi(), wadlResult.downloadFilePath);
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Rh(int i3, WadlResult wadlResult) {
        QLog.d("MiniBoxAppLoadingFragment", 4, "onGetAppStatus appStatus=" + i3 + " result=" + wadlResult);
        VirtualAppInfo yi5 = yi();
        if (uh() && !getQBaseActivity().isResume()) {
            return;
        }
        Si(i3);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            ri(yi5, wadlResult);
                            return;
                        }
                        return;
                    }
                } else {
                    ui(yi5);
                    return;
                }
            } else {
                ti(yi5, wadlResult.downloadFilePath);
                return;
            }
        }
        si(yi5);
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Sh(int i3, String str) {
        ai(getString(R.string.f166892bg));
        QLog.d("MiniBoxAppLoadingFragment", 1, "install minibox app faile:" + i3 + ", errMsg:" + str);
        us3.p.f440002a.e(yi(), false, i3, str);
        hj(yi().getPackageName());
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment
    public void Th() {
        super.Th();
        QLog.d("MiniBoxAppLoadingFragment", 1, "install minibox app succ");
        VirtualAppInfo yi5 = yi();
        if (!((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMiniBoxSystemInstallSwitchEnable()) {
            vh(yi().getPackageName());
        }
        wh();
        us3.p.f440002a.e(yi(), true, 0, MeasureConst.SLI_TYPE_SUCCESS);
        ui(yi5);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(CloseLoadingPageEvent.class);
        return arrayList;
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Ri("3");
        Qi();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.xjf) {
            int i3 = this.f344627b0;
            if (i3 == 200) {
                Zh(yi().getPackageName());
            } else if (i3 == 300) {
                Wh(yi().getPackageName());
            }
        } else if (view.getId() != R.id.f1062868a && view.getId() != R.id.xj_) {
            if (view.getId() == R.id.f108386cz || view.getId() == R.id.xjp) {
                SimpleEventBus.getInstance().registerReceiver(this);
                Intent intent = new Intent();
                intent.putExtra("loadingPackageName", this.W.getPackageName());
                ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).startMiniBoxManagerPage(getQBaseActivity(), "", intent);
                Ri("2");
                getActivity().finish();
            }
        } else {
            Qi();
            Ri("1");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fi5, (ViewGroup) null);
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.U.g();
        this.X.s0();
        us3.o oVar = this.f344626a0;
        if (oVar != null) {
            oVar.b();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.U.f();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof CloseLoadingPageEvent) && uh()) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            getQBaseActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.U.h();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.U.f();
    }

    @Override // com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.Z = getQBaseActivity().getIntent();
        Fi();
        Si(-1);
        Ti(yi().getAppId(), this);
    }

    @Override // qs3.a
    public void q7(@NonNull qs3.d dVar) {
        if (dVar.c()) {
            try {
                VMBasicInfo$GetVMAppInfoRsq vMBasicInfo$GetVMAppInfoRsq = new VMBasicInfo$GetVMAppInfoRsq();
                vMBasicInfo$GetVMAppInfoRsq.mergeFrom(dVar.getData());
                Di(vMBasicInfo$GetVMAppInfoRsq);
            } catch (Throwable th5) {
                QLog.e("MiniBoxAppLoadingFragment", 1, "virtualappbasicinfo onResponse", th5);
            }
        }
    }
}
