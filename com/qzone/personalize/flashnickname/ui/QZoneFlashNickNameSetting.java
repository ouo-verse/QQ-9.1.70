package com.qzone.personalize.flashnickname.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.flashnickname.handler.pb.SsoGetActDynamicNickRsp;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.reborn.feedx.widget.QZoneFlashNickNameHelper;
import com.qzone.util.ToastUtil;
import com.qzone.widget.AvatarImageView;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.trpcprotocol.sweet.verification.judge.GetQzoneDynamicNickRsp;
import com.tencent.trpcprotocol.sweet.verification.judge.SetQzoneDynamicNickRsp;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.RoundRectImageView;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFlashNickNameSetting extends QZoneTitleBarFragmentV2 {

    /* renamed from: p1, reason: collision with root package name */
    private static final boolean f49216p1 = VasToggle.VAS_QZONE_LV_10_COLOR_NAME.isEnable(true);
    private RelativeLayout A0;
    private RelativeLayout B0;
    private RelativeLayout C0;
    private ImageView D0;
    private ImageView E0;
    private ImageView F0;
    private ImageView G0;
    private n K0;
    private String L0;
    private FlashCellTextView M0;
    private RoundRectImageView N0;
    private RelativeLayout O0;
    private ImageView P0;
    private TextView Q0;
    private ViewTreeObserver.OnGlobalLayoutListener S0;
    private String T0;
    private String U0;
    private String V0;

    /* renamed from: b1, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f49218b1;

    /* renamed from: c1, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f49219c1;

    /* renamed from: d1, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f49220d1;

    /* renamed from: e1, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f49221e1;

    /* renamed from: i0, reason: collision with root package name */
    private long f49226i0;

    /* renamed from: j0, reason: collision with root package name */
    private AvatarImageView f49228j0;

    /* renamed from: k0, reason: collision with root package name */
    private FlashCellTextView f49230k0;

    /* renamed from: l0, reason: collision with root package name */
    private FlashCellTextView f49232l0;

    /* renamed from: m0, reason: collision with root package name */
    private FlashCellTextView f49234m0;

    /* renamed from: n0, reason: collision with root package name */
    private FlashCellTextView f49236n0;

    /* renamed from: o0, reason: collision with root package name */
    private FlashCellTextView f49238o0;

    /* renamed from: p0, reason: collision with root package name */
    private FlashCellTextView f49240p0;

    /* renamed from: q0, reason: collision with root package name */
    private ImageView f49241q0;

    /* renamed from: r0, reason: collision with root package name */
    private TextView f49242r0;

    /* renamed from: s0, reason: collision with root package name */
    private TextView f49243s0;

    /* renamed from: t0, reason: collision with root package name */
    private View f49244t0;

    /* renamed from: u0, reason: collision with root package name */
    private TextView f49245u0;

    /* renamed from: v0, reason: collision with root package name */
    private ImageView f49246v0;

    /* renamed from: w0, reason: collision with root package name */
    private RoundRectImageView f49247w0;

    /* renamed from: x0, reason: collision with root package name */
    private RoundRectImageView f49248x0;

    /* renamed from: y0, reason: collision with root package name */
    private RoundRectImageView f49249y0;

    /* renamed from: z0, reason: collision with root package name */
    private RelativeLayout f49250z0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f49224h0 = true;
    private int H0 = 0;
    private int I0 = -1;
    private int J0 = -1;
    private QZoneFlashNickNameHelper R0 = new QZoneFlashNickNameHelper();
    private boolean W0 = false;
    private boolean X0 = false;
    private String Y0 = "";
    private long Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    private String f49217a1 = "";

    /* renamed from: f1, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f49222f1 = new m();

    /* renamed from: g1, reason: collision with root package name */
    private VipResourcesListener f49223g1 = new VipResourcesListener() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.7
        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onLoaded(final Drawable drawable) {
            if (QZoneFlashNickNameSetting.this.f49241q0 != null) {
                QZoneFlashNickNameSetting.this.runOnUiThread(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneFlashNickNameSetting.this.Fj(drawable);
                        QZoneFlashNickNameSetting.this.f49241q0.setImageDrawable(drawable);
                        QZoneFlashNickNameSetting.this.f49241q0.invalidate();
                    }
                });
            }
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onFailed() {
        }
    };

    /* renamed from: h1, reason: collision with root package name */
    private View.OnClickListener f49225h1 = new a();

    /* renamed from: i1, reason: collision with root package name */
    private View.OnClickListener f49227i1 = new b();

    /* renamed from: j1, reason: collision with root package name */
    private View.OnClickListener f49229j1 = new c();

    /* renamed from: k1, reason: collision with root package name */
    private View.OnClickListener f49231k1 = new d();

    /* renamed from: l1, reason: collision with root package name */
    private View.OnClickListener f49233l1 = new e();

    /* renamed from: m1, reason: collision with root package name */
    final ChannelCallback f49235m1 = new f();

    /* renamed from: n1, reason: collision with root package name */
    final ChannelCallback f49237n1 = new g();

    /* renamed from: o1, reason: collision with root package name */
    final ChannelCallback f49239o1 = new h();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFlashNickNameSetting.this.showLoading();
            QZoneFlashNickNameSetting.this.R0.b(QZoneFlashNickNameSetting.this.f49232l0);
            QZoneFlashNickNameSetting.this.I0 = 0;
            m23.d.b(QZoneFlashNickNameSetting.this.getActivity(), QZoneFlashNickNameSetting.this.I0, QZoneFlashNickNameSetting.this.f49239o1);
            MobileReportManager.getInstance().reportAction("1", "yangshi", "QzonePersonalized", "gxh_dtnc", "", 102, 0, System.currentTimeMillis());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFlashNickNameSetting.this.showLoading();
            QZoneFlashNickNameSetting.this.R0.b(QZoneFlashNickNameSetting.this.f49232l0);
            QZoneFlashNickNameSetting.this.I0 = 1;
            if (QZoneFlashNickNameSetting.this.tj()) {
                m23.d.b(QZoneFlashNickNameSetting.this.getActivity(), QZoneFlashNickNameSetting.this.I0, QZoneFlashNickNameSetting.this.f49239o1);
            } else {
                m23.a.b(QZoneFlashNickNameSetting.this.f49235m1);
                c8.a.INSTANCE.a(QZoneFlashNickNameSetting.this.f49237n1);
                MobileReportManager.getInstance().reportAction("2", "yangshi", "QzonePersonalized", "gxh_dtnc", "", 102, 0, System.currentTimeMillis());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFlashNickNameSetting.this.showLoading();
            QZoneFlashNickNameSetting.this.R0.b(QZoneFlashNickNameSetting.this.f49232l0);
            QZoneFlashNickNameSetting.this.I0 = 3;
            if (QZoneFlashNickNameSetting.this.sj()) {
                m23.d.b(QZoneFlashNickNameSetting.this.getActivity(), QZoneFlashNickNameSetting.this.I0, QZoneFlashNickNameSetting.this.f49239o1);
            } else {
                m23.a.b(QZoneFlashNickNameSetting.this.f49235m1);
                c8.a.INSTANCE.a(QZoneFlashNickNameSetting.this.f49237n1);
                MobileReportManager.getInstance().reportAction("4", "yangshi", "QzonePersonalized", "gxh_dtnc", "", 102, 0, System.currentTimeMillis());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFlashNickNameSetting.this.showLoading();
            QZoneFlashNickNameSetting.this.R0.b(QZoneFlashNickNameSetting.this.f49232l0);
            QZoneFlashNickNameSetting.this.I0 = 2;
            if (QZoneFlashNickNameSetting.this.qj() && QZoneFlashNickNameSetting.this.tj()) {
                m23.d.b(QZoneFlashNickNameSetting.this.getActivity(), QZoneFlashNickNameSetting.this.I0, QZoneFlashNickNameSetting.this.f49239o1);
            } else {
                m23.a.b(QZoneFlashNickNameSetting.this.f49235m1);
                c8.a.INSTANCE.a(QZoneFlashNickNameSetting.this.f49237n1);
                MobileReportManager.getInstance().reportAction("3", "yangshi", "QzonePersonalized", "gxh_dtnc", "", 102, 0, System.currentTimeMillis());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (new Date().getTime() <= QZoneFlashNickNameSetting.this.Z0 * 1000) {
                QZoneFlashNickNameSetting.this.showLoading();
                QZoneFlashNickNameSetting.this.I0 = 4;
                m23.d.b(QZoneFlashNickNameSetting.this.getActivity(), QZoneFlashNickNameSetting.this.I0, QZoneFlashNickNameSetting.this.f49239o1);
            } else {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(QZoneFlashNickNameSetting.this.O0.getContext(), QZoneFlashNickNameSetting.this.Y0);
            }
            MobileReportManager.getInstance().reportAction("5", "yangshi", "QzonePersonalized", "gxh_dtnc", "", 102, 0, System.currentTimeMillis());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements ViewTreeObserver.OnGlobalLayoutListener {
        i() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QZoneFlashNickNameSetting.this.f49236n0.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements ViewTreeObserver.OnGlobalLayoutListener {
        j() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (QZoneFlashNickNameSetting.this.f49238o0.getPaint() != null) {
                QZoneFlashNickNameSetting.this.f49238o0.getPaint().setShader(IVipColorName.INSTANCE.getShader(QZoneFlashNickNameSetting.this.f49238o0.getWidth(), QZoneFlashNickNameSetting.this.f49238o0.getHeight()));
                QZoneFlashNickNameSetting.this.f49238o0.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QZoneFlashNickNameSetting.this.f49240p0.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements ViewTreeObserver.OnGlobalLayoutListener {
        l() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (QZoneFlashNickNameSetting.this.J0 == 4 && !TextUtils.isEmpty(QZoneFlashNickNameSetting.this.f49217a1)) {
                QZoneFlashNickNameSetting.this.R0.a(QZoneFlashNickNameSetting.this.f49232l0, "qzone_setting", false, QZoneFlashNickNameSetting.this.f49217a1, Integer.MAX_VALUE, null);
            } else {
                QZoneFlashNickNameSetting.this.R0.b(QZoneFlashNickNameSetting.this.f49232l0);
            }
            QZoneFlashNickNameSetting.this.f49232l0.i();
            QZoneFlashNickNameSetting.this.f49232l0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class m implements ViewTreeObserver.OnGlobalLayoutListener {
        m() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QZoneFlashNickNameSetting.this.M0.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class n extends ReportDialog {
        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }

        public void setTitle(String str) {
            ((TextView) findViewById(R.id.title)).setText(str);
        }

        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
        public void show() {
            try {
                super.show();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }

        @Override // android.app.Dialog
        public void setTitle(int i3) {
            setTitle(i3 == 0 ? null : getContext().getResources().getString(i3));
        }

        n(Context context) {
            super(context, R.style.f174063on);
            setContentView(R.layout.f169003bk1);
            getWindow().setFlags(1024, 2048);
        }
    }

    private void Aj() {
        runOnUiThread(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.12

            /* compiled from: P */
            /* renamed from: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting$12$a */
            /* loaded from: classes39.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    QZoneFlashNickNameSetting.this.hj();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                String str2;
                QZoneFlashNickNameSetting.this.fj();
                com.qzone.component.e eVar = new com.qzone.component.e();
                if (!TextUtils.isEmpty(QZoneFlashNickNameSetting.this.U0)) {
                    str = QZoneFlashNickNameSetting.this.U0;
                } else {
                    str = "\u8be5\u529f\u80fd\u4ec5\u9650\u8c6a\u534e\u9ec4\u94bbLV10\u7528\u6237\u4f7f\u7528\uff0c\u5feb\u53bb\u5347\u7ea7\u65b0\u8eab\u4efd\u5427\uff01";
                }
                String str3 = str;
                if (!TextUtils.isEmpty(QZoneFlashNickNameSetting.this.V0)) {
                    str2 = QZoneFlashNickNameSetting.this.V0;
                } else {
                    str2 = "\u524d\u5f80\u5347\u7ea7";
                }
                eVar.f(QZoneFlashNickNameSetting.this.getActivity(), 230, null, str3, str2, "\u53d6\u6d88", new a(), null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(int i3) {
        this.D0.setVisibility(i3 == 0 ? 0 : 4);
        this.f49230k0.setVisibility(i3 == 0 ? 0 : 4);
        this.f49232l0.setVisibility(i3 == 0 ? 4 : 0);
        this.E0.setVisibility(i3 == 1 ? 0 : 4);
        this.G0.setVisibility(i3 == 2 ? 0 : 4);
        this.F0.setVisibility(i3 == 3 ? 0 : 4);
        this.P0.setVisibility(i3 != 4 ? 4 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj(final int i3) {
        this.f49232l0.post(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.15

            /* compiled from: P */
            /* renamed from: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting$15$a */
            /* loaded from: classes39.dex */
            class a implements ViewTreeObserver.OnGlobalLayoutListener {
                a() {
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    QZoneFlashNickNameSetting.this.f49232l0.i();
                }
            }

            /* compiled from: P */
            /* renamed from: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting$15$b */
            /* loaded from: classes39.dex */
            class b implements ViewTreeObserver.OnGlobalLayoutListener {
                b() {
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    QZoneFlashNickNameSetting.this.f49232l0.i();
                }
            }

            /* compiled from: P */
            /* renamed from: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting$15$c */
            /* loaded from: classes39.dex */
            class c implements ViewTreeObserver.OnGlobalLayoutListener {
                c() {
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (QZoneFlashNickNameSetting.this.I0 != 3 || QZoneFlashNickNameSetting.this.f49232l0.getPaint() == null) {
                        return;
                    }
                    QZoneFlashNickNameSetting.this.f49232l0.getPaint().setShader(IVipColorName.INSTANCE.getShader(QZoneFlashNickNameSetting.this.f49232l0.getWidth(), QZoneFlashNickNameSetting.this.f49232l0.getHeight()));
                    QZoneFlashNickNameSetting.this.f49232l0.i();
                }
            }

            /* compiled from: P */
            /* renamed from: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting$15$d */
            /* loaded from: classes39.dex */
            class d implements ViewTreeObserver.OnGlobalLayoutListener {
                d() {
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                    if (i3 == 4) {
                        QZoneFlashNickNameSetting.this.f49232l0.setTextColor(Color.parseColor("#deb756"));
                        if (QZoneFlashNickNameSetting.this.f49232l0.getPaint() != null) {
                            QZoneFlashNickNameSetting.this.f49232l0.getPaint().setShader(IVipColorName.INSTANCE.getShaderAct(QZoneFlashNickNameSetting.this.f49232l0.getWidth()));
                            QZoneFlashNickNameSetting.this.f49232l0.i();
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QZoneFlashNickNameSetting.this.fj();
                QZoneFlashNickNameSetting.this.xj();
                int i16 = i3;
                if (i16 == 0) {
                    QZoneFlashNickNameSetting.this.Bj(0);
                    QZoneFlashNickNameSetting.this.f49232l0.getPaint().setShader(null);
                    QZoneFlashNickNameSetting.this.f49232l0.setTextColor(-16777216);
                    return;
                }
                if (i16 == 1) {
                    QZoneFlashNickNameSetting.this.Bj(1);
                    QZoneFlashNickNameSetting.this.f49232l0.getPaint().setShader(null);
                    QZoneFlashNickNameSetting.this.f49232l0.setTextColor(QZoneFlashNickNameSetting.this.getResources().getColor(R.color.a6v));
                    QZoneFlashNickNameSetting.this.f49232l0.f49210d = 1;
                    QZoneFlashNickNameSetting.this.S0 = new a();
                    QZoneFlashNickNameSetting.this.f49232l0.getViewTreeObserver().addOnGlobalLayoutListener(QZoneFlashNickNameSetting.this.S0);
                    return;
                }
                if (i16 != 2) {
                    if (i16 == 3) {
                        QZoneFlashNickNameSetting.this.Bj(3);
                        QZoneFlashNickNameSetting.this.f49232l0.f49210d = 3;
                        QZoneFlashNickNameSetting.this.S0 = new c();
                        QZoneFlashNickNameSetting.this.f49232l0.getViewTreeObserver().addOnGlobalLayoutListener(QZoneFlashNickNameSetting.this.S0);
                    } else if (i16 != 4) {
                        return;
                    }
                    QZoneFlashNickNameSetting.this.Bj(4);
                    QZoneFlashNickNameSetting.this.f49232l0.setTextColor(QZoneFlashNickNameSetting.this.getResources().getColor(R.color.cn_));
                    QZoneFlashNickNameSetting.this.f49232l0.f49210d = 4;
                    QZoneFlashNickNameSetting.this.S0 = new d();
                    QZoneFlashNickNameSetting.this.f49232l0.getViewTreeObserver().addOnGlobalLayoutListener(QZoneFlashNickNameSetting.this.S0);
                    return;
                }
                QZoneFlashNickNameSetting.this.Bj(2);
                QZoneFlashNickNameSetting.this.f49232l0.getPaint().setShader(null);
                QZoneFlashNickNameSetting.this.f49232l0.setTextColor(QZoneFlashNickNameSetting.this.getResources().getColor(R.color.cna));
                QZoneFlashNickNameSetting.this.f49232l0.f49210d = 2;
                QZoneFlashNickNameSetting.this.S0 = new b();
                QZoneFlashNickNameSetting.this.f49232l0.getViewTreeObserver().addOnGlobalLayoutListener(QZoneFlashNickNameSetting.this.S0);
            }
        });
    }

    private void Dj(String str) {
        this.f49243s0.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj() {
        runOnUiThread(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneFlashNickNameSetting.this.gj(true);
                if (QZoneFlashNickNameSetting.this.K0.isShowing()) {
                    QZoneFlashNickNameSetting.this.K0.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(boolean z16) {
        this.f49234m0.setClickable(z16);
        this.f49250z0.setClickable(z16);
        this.A0.setClickable(z16);
        this.f49236n0.setClickable(z16);
        this.C0.setClickable(z16);
        this.f49238o0.setClickable(z16);
        this.f49240p0.setClickable(z16);
        this.B0.setClickable(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj() {
        Context context;
        if (!f49216p1 || (context = getContext()) == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.L0);
        intent.putExtra("fromQZone", true);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(final int i3) {
        this.f49232l0.post(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.9
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneFlashNickNameSetting.this.X0) {
                    QZoneFlashNickNameSetting.this.O0.setVisibility(0);
                    if (QZoneFlashNickNameSetting.this.Z0 > 0) {
                        QZoneFlashNickNameSetting.this.Q0.setText("\u6709\u6548\u671f\u81f3\uff1a" + new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(QZoneFlashNickNameSetting.this.Z0 * 1000)));
                        QZoneFlashNickNameSetting.this.Q0.setVisibility(0);
                    } else {
                        QZoneFlashNickNameSetting.this.Q0.setVisibility(8);
                    }
                    QZoneFlashNickNameSetting.this.M0.setOnClickListener(QZoneFlashNickNameSetting.this.f49233l1);
                    QZoneFlashNickNameSetting.this.O0.setOnClickListener(QZoneFlashNickNameSetting.this.f49233l1);
                    QZoneFlashNickNameSetting.this.M0.i();
                    if (!TextUtils.isEmpty(QZoneFlashNickNameSetting.this.f49217a1)) {
                        QZoneFlashNickNameSetting.this.R0.a(QZoneFlashNickNameSetting.this.M0, "qzone_setting", false, QZoneFlashNickNameSetting.this.f49217a1, Integer.MAX_VALUE, null);
                    }
                    if ((QZoneFlashNickNameSetting.this.I0 == -1 && i3 == 4) || QZoneFlashNickNameSetting.this.I0 == 4) {
                        QZoneFlashNickNameSetting.this.f49232l0.i();
                        if (!TextUtils.isEmpty(QZoneFlashNickNameSetting.this.f49217a1)) {
                            QZoneFlashNickNameSetting.this.R0.a(QZoneFlashNickNameSetting.this.f49232l0, "qzone_setting", false, QZoneFlashNickNameSetting.this.f49217a1, Integer.MAX_VALUE, null);
                            return;
                        } else {
                            QZoneFlashNickNameSetting.this.R0.b(QZoneFlashNickNameSetting.this.f49232l0);
                            return;
                        }
                    }
                    return;
                }
                QZoneFlashNickNameSetting.this.O0.setVisibility(8);
            }
        });
    }

    private void initNickName() {
        this.f49232l0.setTextColor(getResources().getColor(R.color.a6v));
        this.f49234m0.setTextColor(-16777216);
        this.f49234m0.f49210d = 0;
        this.f49236n0.setTextColor(getResources().getColor(R.color.a6v));
        this.f49236n0.f49210d = 1;
        this.f49238o0.f49210d = 3;
        this.f49240p0.setTextColor(getResources().getColor(R.color.cna));
        this.f49240p0.f49210d = 2;
        this.f49219c1 = new i();
        this.f49236n0.getViewTreeObserver().addOnGlobalLayoutListener(this.f49219c1);
        this.f49218b1 = new j();
        this.f49238o0.getViewTreeObserver().addOnGlobalLayoutListener(this.f49218b1);
        this.f49220d1 = new k();
        this.f49240p0.getViewTreeObserver().addOnGlobalLayoutListener(this.f49220d1);
        this.f49232l0.setText(LoginData.getInstance().getNickName(""));
        this.f49230k0.setText(LoginData.getInstance().getNickName(""));
        this.f49230k0.setTextColor(-16777216);
        this.f49230k0.f49210d = 0;
        this.f49221e1 = new l();
        this.f49232l0.getViewTreeObserver().addOnGlobalLayoutListener(this.f49221e1);
        this.M0.setTextColor(getResources().getColor(R.color.cn_));
        FlashCellTextView flashCellTextView = this.M0;
        flashCellTextView.f49210d = 4;
        flashCellTextView.getViewTreeObserver().addOnGlobalLayoutListener(this.f49222f1);
    }

    private void initTitleBar() {
        setTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DynamicNickName", "\u52a8\u6001\u6635\u79f0"));
    }

    private void jj() {
        this.f49228j0.j(this.f49226i0);
    }

    private void kj() {
        this.f49243s0.setText("");
    }

    private void lj() {
        new DisplayMetrics();
        int i3 = super.getResources().getDisplayMetrics().widthPixels;
        this.f49250z0.getLayoutParams().width = (i3 - BaseAIOUtils.f(41.0f, getResources())) / 2;
        this.A0.getLayoutParams().width = (i3 - BaseAIOUtils.f(41.0f, getResources())) / 2;
        this.B0.getLayoutParams().width = (i3 - BaseAIOUtils.f(41.0f, getResources())) / 2;
        this.C0.getLayoutParams().width = (i3 - BaseAIOUtils.f(41.0f, getResources())) / 2;
        this.O0.getLayoutParams().width = (i3 - BaseAIOUtils.f(41.0f, getResources())) / 2;
        this.f49234m0.setOnClickListener(this.f49225h1);
        this.f49250z0.setOnClickListener(this.f49225h1);
        this.A0.setOnClickListener(this.f49227i1);
        this.f49236n0.setOnClickListener(this.f49227i1);
        this.C0.setOnClickListener(this.f49229j1);
        this.f49238o0.setOnClickListener(this.f49229j1);
        this.f49240p0.setOnClickListener(this.f49231k1);
        this.B0.setOnClickListener(this.f49231k1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(final int i3) {
        this.f49232l0.post(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.8
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneFlashNickNameSetting.this.W0) {
                    if (QZoneFlashNickNameSetting.this.qj()) {
                        QZoneFlashNickNameSetting.this.B0.setVisibility(0);
                    }
                } else {
                    QZoneFlashNickNameSetting.this.B0.setVisibility(0);
                }
                QZoneFlashNickNameSetting.this.Ej(i3);
                QZoneFlashNickNameSetting.this.f49244t0.setOnClickListener(new a());
            }

            /* compiled from: P */
            /* renamed from: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting$8$a */
            /* loaded from: classes39.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    EventCollector.getInstance().onViewClickedBefore(view);
                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                    int i3 = i3;
                    if (i3 == 3) {
                        if (QZoneFlashNickNameSetting.this.sj()) {
                            QZoneFlashNickNameSetting.this.vj(true, 2);
                        } else {
                            QZoneFlashNickNameSetting.this.hj();
                        }
                        str = "4";
                    } else {
                        if (i3 == 2) {
                            QZoneFlashNickNameSetting.this.uj();
                        } else {
                            if (i3 == 1) {
                                QZoneFlashNickNameSetting.this.vj(true, 2);
                            } else if (QZoneFlashNickNameSetting.this.pj()) {
                                QZoneFlashNickNameSetting.this.uj();
                            } else {
                                QZoneFlashNickNameSetting.this.vj(true, 2);
                            }
                            str = "2";
                        }
                        str = "3";
                    }
                    MobileReportManager.getInstance().reportAction(str, "kaitong", "QzonePersonalized", "gxh_dtnc", "", 102, 0, System.currentTimeMillis());
                    EventCollector.getInstance().onViewClicked(view);
                }
            }
        });
    }

    private void nj() {
        this.f49242r0.setText(com.qzone.util.l.a(R.string.rwa) + com.qzone.album.util.g.f(System.currentTimeMillis()));
    }

    private void oj() {
        QzoneVipInfo userVipInfo;
        if (this.f49241q0 == null || (userVipInfo = LoginData.getInstance().getUserVipInfo()) == null) {
            return;
        }
        Drawable yellowVipIcon = VipComponentProxy.f50997g.getUiInterface().getYellowVipIcon(userVipInfo.getVipLevel(), userVipInfo.getVipLevel(), userVipInfo.isAnnualVip(), userVipInfo.isCustomDiamond(), userVipInfo.getCustomDiamondUrl(), 6, this.f49223g1);
        Fj(yellowVipIcon);
        this.f49241q0.setImageDrawable(yellowVipIcon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pj() {
        return (this.H0 & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qj() {
        return ((this.H0 >> 2) & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rj(int i3) {
        if (i3 != this.I0) {
            return false;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 == 3 && sj()) {
            return true;
        }
        if (i3 == 2 && pj()) {
            return true;
        }
        return i3 == 1 && tj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sj() {
        return ((this.H0 >> 3) & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tj() {
        return ((this.H0 >> 1) & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        runOnUiThread(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.14
            @Override // java.lang.Runnable
            public void run() {
                yo.d.p(QZoneFlashNickNameSetting.this.getActivity(), yo.f.j(QzoneConfig.DEFAULT_FEED_LOVE_DIAMOND_URL, "{entranceId}", "4"), -1, null, null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj(final boolean z16, final int i3) {
        runOnUiThread(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.13
            @Override // java.lang.Runnable
            public void run() {
                ak.Q(QZoneFlashNickNameSetting.this.getActivity(), ak.r(QZoneFlashNickNameSetting.this.getActivity(), "jhan_nicheng", QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanUseDynamicNickName", "\u652f\u4ed8\u6210\u529f\uff0c\u53ef\u4ee5\u4f7f\u7528\u52a8\u6001\u6635\u79f0"), !z16, LoginData.getInstance().getUin(), QZoneFlashNickNameSetting.this.tj()), i3);
                ClickReport.q("308", "14", WadlProxyConsts.OPER_TYPE_APK_SIGN, true);
            }
        });
    }

    private void wj() {
        JSONObject onGetJson;
        if (!f49216p1 || (onGetJson = VasToggle.VAS_QZONE_LV_10_COLOR_NAME.onGetJson()) == null) {
            return;
        }
        try {
            this.T0 = onGetJson.getString("nick_item_text");
            this.U0 = onGetJson.getString("nick_window_text");
            this.V0 = onGetJson.getString("nick_button_text");
            this.L0 = onGetJson.getString("nick_activity_url");
        } catch (JSONException unused) {
            QLog.e("QZoneFlashNickNameSetting", 1, "parse error :" + onGetJson.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        if (this.S0 != null) {
            this.f49232l0.getViewTreeObserver().removeOnGlobalLayoutListener(this.S0);
        }
    }

    private void zj() {
        runOnUiThread(new Runnable() { // from class: com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting.11
            @Override // java.lang.Runnable
            public void run() {
                QZoneFlashNickNameSetting.this.fj();
                new com.qzone.component.e().f(QZoneFlashNickNameSetting.this.getActivity(), 232, null, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogBuyHuangzuanForNickName", "\u60c5\u4fa3\u9ec4\u94bb\u4e13\u5c5e\u52a8\u6001\u6635\u79f0\u5c55\u793a\u6837\u5f0f\u53ea\u6709QQ\u60c5\u4fa3\u7528\u6237\u624d\u53ef\u4ee5\u8bbe\u7f6e\uff0c\u5feb\u53bb\u9080\u8bf7\u4f60\u7684QQ\u60c5\u4fa3\u5427\uff01"), "\u6211\u77e5\u9053\u4e86", null, null, null);
            }
        });
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f49222f1 != null) {
            this.M0.getViewTreeObserver().removeOnGlobalLayoutListener(this.f49222f1);
        }
        xj();
        this.f49232l0.getViewTreeObserver().removeOnGlobalLayoutListener(this.f49221e1);
        this.f49236n0.getViewTreeObserver().removeOnGlobalLayoutListener(this.f49219c1);
        this.f49238o0.getViewTreeObserver().removeOnGlobalLayoutListener(this.f49218b1);
        this.f49240p0.getViewTreeObserver().removeOnGlobalLayoutListener(this.f49220d1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        switch (unpack.what) {
            case IChannelType.APP_SUB_CHANNEL_TYPE_SCHEDULE /* 1000050 */:
                if (unpack.getSucceed()) {
                    b8.a aVar = (b8.a) unpack.getData();
                    if (aVar != null) {
                        Dj(aVar.qzonedesc);
                        d8.a.a().e(aVar.qzonedesc);
                        return;
                    }
                    return;
                }
                toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetUserHomeDescriptionFail", "\u83b7\u53d6\u7528\u6237\u7a7a\u95f4\u63cf\u8ff0\u5931\u8d25"), 4);
                QZLog.w("QZoneFlashNickNameSetting", "get describe label fail");
                return;
            case IChannelType.APP_SUB_CHANNEL_TYPE_CODM /* 1000070 */:
                if (unpack.getSucceed()) {
                    ((Bundle) unpack.getData()).getBoolean("state");
                    return;
                } else {
                    toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetUserDynamicNickNameFail", "\u83b7\u53d6\u7528\u6237\u52a8\u6001\u6635\u79f0\u72b6\u6001\u5931\u8d25"), 4);
                    QZLog.w("QZoneFlashNickNameSetting", "get flash nickname fail");
                    return;
                }
            case 1000071:
                if (unpack.getSucceed()) {
                    return;
                }
                d8.a.a().f(!d8.a.a().b());
                toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSettingUserDynamicNickNameFail", "\u8bbe\u7f6e\u7528\u6237\u52a8\u6001\u6635\u79f0\u72b6\u6001\u5931\u8d25"), 4);
                QZLog.w("QZoneFlashNickNameSetting", "set flash nickname fail");
                return;
            default:
                return;
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f49232l0.j();
        this.f49234m0.j();
        this.f49236n0.j();
        this.f49240p0.j();
        this.f49238o0.j();
        this.M0.j();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        fj();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f49226i0 = LoginData.getInstance().getUin();
        this.f49228j0 = (AvatarImageView) findViewById(R.id.hpe);
        this.f49230k0 = (FlashCellTextView) findViewById(R.id.f69183i2);
        this.f49232l0 = (FlashCellTextView) findViewById(R.id.hpj);
        this.f49234m0 = (FlashCellTextView) findViewById(R.id.ufg);
        this.f49236n0 = (FlashCellTextView) findViewById(R.id.f125847n6);
        this.f49238o0 = (FlashCellTextView) findViewById(R.id.f94045b8);
        this.f49240p0 = (FlashCellTextView) findViewById(R.id.f166154yv4);
        RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById(R.id.f125837n5);
        this.f49247w0 = roundRectImageView;
        roundRectImageView.setCornerRadiusAndMode(12, 1);
        RoundRectImageView roundRectImageView2 = (RoundRectImageView) findViewById(R.id.f94035b7);
        this.f49249y0 = roundRectImageView2;
        roundRectImageView2.setCornerRadiusAndMode(12, 1);
        RoundRectImageView roundRectImageView3 = (RoundRectImageView) findViewById(R.id.yv5);
        this.f49248x0 = roundRectImageView3;
        roundRectImageView3.setCornerRadiusAndMode(12, 1);
        this.f49250z0 = (RelativeLayout) findViewById(R.id.ydy);
        this.A0 = (RelativeLayout) findViewById(R.id.yg5);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.yeq);
        this.B0 = relativeLayout;
        relativeLayout.setVisibility(8);
        this.C0 = (RelativeLayout) findViewById(R.id.yfp);
        this.D0 = (ImageView) findViewById(R.id.xkh);
        this.E0 = (ImageView) findViewById(R.id.xkm);
        this.G0 = (ImageView) findViewById(R.id.xki);
        this.F0 = (ImageView) findViewById(R.id.xkl);
        this.M0 = (FlashCellTextView) findViewById(R.id.s8x);
        RoundRectImageView roundRectImageView4 = (RoundRectImageView) findViewById(R.id.s8v);
        this.N0 = roundRectImageView4;
        roundRectImageView4.setCornerRadiusAndMode(12, 1);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.ydk);
        this.O0 = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.P0 = (ImageView) findViewById(R.id.xkg);
        this.Q0 = (TextView) findViewById(R.id.s8w);
        this.f49241q0 = (ImageView) findViewById(R.id.hpg);
        this.f49242r0 = (TextView) findViewById(R.id.hpk);
        this.f49243s0 = (TextView) findViewById(R.id.hpf);
        this.f49244t0 = findViewById(R.id.hlf);
        this.f49245u0 = (TextView) findViewById(R.id.hlh);
        this.f49246v0 = (ImageView) findViewById(R.id.hle);
        lj();
        initTitleBar();
        jj();
        initNickName();
        oj();
        nj();
        kj();
        m23.a.b(this.f49235m1);
        c8.a.INSTANCE.a(this.f49237n1);
        this.K0 = new n(getActivity());
        ClickReport.m("308", "14", "32");
        MobileReportManager.getInstance().reportAction("", "", "QzonePersonalized", "gxh_dtnc", "", 100, 0, System.currentTimeMillis());
        for (int i3 = 1; i3 < 5; i3++) {
            if (i3 != 4 || f49216p1) {
                MobileReportManager.getInstance().reportAction(String.valueOf(i3), "yangshi", "QzonePersonalized", "gxh_dtnc", "", 101, 0, System.currentTimeMillis());
            }
        }
        wj();
        this.C0.setVisibility(f49216p1 ? 0 : 8);
        if (TextUtils.isEmpty(this.T0)) {
            return;
        }
        this.f49238o0.setText(this.T0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        gj(false);
        this.K0.setTitle("\u6b63\u5728\u8bbe\u7f6e,\u8bf7\u7a0d\u5019");
        if (this.K0.isShowing()) {
            return;
        }
        this.K0.show();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements ChannelCallback {
        g() {
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onRecv(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            SsoGetActDynamicNickRsp ssoGetActDynamicNickRsp = new SsoGetActDynamicNickRsp();
            try {
                ssoGetActDynamicNickRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException unused) {
                ssoGetActDynamicNickRsp = null;
            }
            if (ssoGetActDynamicNickRsp != null && ssoGetActDynamicNickRsp.is_show.get()) {
                QZoneFlashNickNameSetting.this.X0 = true;
                QZoneFlashNickNameSetting.this.Y0 = ssoGetActDynamicNickRsp.url.get();
                QZoneFlashNickNameSetting.this.Z0 = ssoGetActDynamicNickRsp.last_time.get();
                QZoneFlashNickNameSetting.this.f49217a1 = ssoGetActDynamicNickRsp.module.style_url.get();
                QZoneFlashNickNameSetting qZoneFlashNickNameSetting = QZoneFlashNickNameSetting.this;
                qZoneFlashNickNameSetting.ij(qZoneFlashNickNameSetting.J0);
            }
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onError(boolean z16, int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj(int i3) {
        if (i3 == 3 && !sj()) {
            Aj();
            return;
        }
        if (i3 == 1 && !tj()) {
            vj(true, 1);
            return;
        }
        if (i3 == 2) {
            if (pj() && tj() && qj()) {
                return;
            }
            if (pj()) {
                uj();
                return;
            } else {
                zj();
                return;
            }
        }
        m23.d.b(getActivity(), i3, this.f49239o1);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.bh_, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej(int i3) {
        int i16;
        String config;
        boolean z16;
        String config2;
        boolean z17;
        String str;
        int i17;
        boolean z18 = i3 == 0 || i3 == 2;
        int parseColor = Color.parseColor("#99480E");
        int i18 = -1;
        if (i3 == 3) {
            if (sj()) {
                config = "\u7acb\u5373\u7eed\u8d39\u8c6a\u534e\u9ec4\u94bb";
            } else if (TextUtils.isEmpty(this.V0)) {
                config = "\u7acb\u5373\u5347\u7ea7\u8c6a\u534e\u9ec4\u94bbLV10\u8eab\u4efd";
            } else {
                config = this.V0;
            }
            i17 = R.drawable.oc_;
            i16 = R.drawable.m1f;
            str = "4";
            z17 = false;
        } else {
            boolean tj5 = tj();
            i16 = R.drawable.f162343nz3;
            if (tj5) {
                if (z18) {
                    z16 = this.W0;
                    config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "LoveHuangzuanRenewNow", "\u7acb\u5373\u7eed\u8d39\u60c5\u4fa3\u9ec4\u94bb");
                    str = "3";
                    i17 = R.drawable.nx5;
                    String str2 = config2;
                    z17 = z16;
                    config = str2;
                } else {
                    config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanRenewNow", "\u7acb\u5373\u7eed\u8d39\u9ec4\u94bb");
                    z17 = false;
                    i18 = parseColor;
                    str = "2";
                    i16 = R.drawable.geb;
                    i17 = R.drawable.f162369gk0;
                }
            } else if (z18) {
                z16 = this.W0;
                config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "LoveHuangzuanBuyNow", "\u7acb\u5373\u5f00\u901a\u60c5\u4fa3\u9ec4\u94bb");
                str = "3";
                i17 = R.drawable.nx5;
                String str22 = config2;
                z17 = z16;
                config = str22;
            } else {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanBuyNow", "\u7acb\u5373\u5f00\u901a\u9ec4\u94bb");
                z17 = false;
                i18 = parseColor;
                str = "2";
                i16 = R.drawable.geb;
                i17 = R.drawable.f162369gk0;
            }
        }
        this.f49246v0.setImageResource(i17);
        this.f49245u0.setTextColor(i18);
        this.f49245u0.setText(config);
        this.f49244t0.setBackgroundResource(i16);
        if (!z17) {
            this.f49244t0.setVisibility(0);
        } else {
            this.f49244t0.setVisibility(4);
        }
        if (this.f49224h0) {
            this.f49224h0 = false;
            MobileReportManager.getInstance().reportAction(str, "kaitong", "QzonePersonalized", "gxh_dtnc", "", 101, 0, System.currentTimeMillis());
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements ChannelCallback {
        f() {
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onRecv(byte[] bArr) {
            GetQzoneDynamicNickRsp getQzoneDynamicNickRsp = new GetQzoneDynamicNickRsp();
            if (bArr == null) {
                return;
            }
            try {
                getQzoneDynamicNickRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException unused) {
                getQzoneDynamicNickRsp = null;
            }
            if (getQzoneDynamicNickRsp != null) {
                int i3 = (int) getQzoneDynamicNickRsp.module.style_type.get();
                QZoneFlashNickNameSetting.this.H0 = getQzoneDynamicNickRsp.module.style_id.get();
                QZoneFlashNickNameSetting.this.W0 = getQzoneDynamicNickRsp.is_gray.get();
                if (!QZoneFlashNickNameSetting.f49216p1) {
                    i3 = 0;
                }
                QZoneFlashNickNameSetting qZoneFlashNickNameSetting = QZoneFlashNickNameSetting.this;
                qZoneFlashNickNameSetting.mj(qZoneFlashNickNameSetting.I0 != -1 ? QZoneFlashNickNameSetting.this.I0 : i3);
                QZoneFlashNickNameSetting qZoneFlashNickNameSetting2 = QZoneFlashNickNameSetting.this;
                qZoneFlashNickNameSetting2.Cj(qZoneFlashNickNameSetting2.I0 != -1 ? QZoneFlashNickNameSetting.this.I0 : i3);
                QZoneFlashNickNameSetting.this.J0 = i3;
                if (QZoneFlashNickNameSetting.this.I0 == -1 || i3 == QZoneFlashNickNameSetting.this.I0) {
                    if (QZoneFlashNickNameSetting.this.rj(i3)) {
                        ToastUtil.s("\u8bbe\u7f6e\u6210\u529f", 2);
                    }
                } else {
                    QZoneFlashNickNameSetting qZoneFlashNickNameSetting3 = QZoneFlashNickNameSetting.this;
                    qZoneFlashNickNameSetting3.yj(qZoneFlashNickNameSetting3.I0);
                }
                if (i3 == 4) {
                    QZoneFlashNickNameSetting qZoneFlashNickNameSetting4 = QZoneFlashNickNameSetting.this;
                    qZoneFlashNickNameSetting4.ij(qZoneFlashNickNameSetting4.J0);
                }
            }
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onError(boolean z16, int i3, String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements ChannelCallback {
        h() {
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onRecv(byte[] bArr) {
            SetQzoneDynamicNickRsp setQzoneDynamicNickRsp = new SetQzoneDynamicNickRsp();
            if (bArr == null) {
                QQToast.makeText(QZoneFlashNickNameSetting.this.getContext(), "\u8bbe\u7f6e\u5931\u8d25", 1).show();
                QZoneFlashNickNameSetting.this.fj();
                return;
            }
            try {
                setQzoneDynamicNickRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException unused) {
                setQzoneDynamicNickRsp = null;
            }
            if (setQzoneDynamicNickRsp == null || setQzoneDynamicNickRsp.result.get() != 0) {
                return;
            }
            m23.a.b(QZoneFlashNickNameSetting.this.f49235m1);
            c8.a.INSTANCE.a(QZoneFlashNickNameSetting.this.f49237n1);
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onError(boolean z16, int i3, String str) {
        }
    }
}
