package com.tencent.biz.qqcircle.immersive.part.teenmode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.utils.ax;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter;
import cooperation.qzone.util.QZoneTeenOnlineTimeHelper;

/* loaded from: classes4.dex */
public class QFSTeenModeAntiAddictionTipsPart extends u implements View.OnClickListener, QFSTeenModeLoginTimeReporter.QFSTeenModeTimeoutListener {
    private ImageView C;
    private LinearLayout D;
    private Button E;
    private String G;
    private boolean I;

    /* renamed from: d, reason: collision with root package name */
    private Activity f88321d;

    /* renamed from: e, reason: collision with root package name */
    private View f88322e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f88323f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f88324h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f88325i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f88326m;
    private boolean F = false;
    private String H = "";
    private BroadcastReceiver J = null;
    private boolean K = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "receive Broadcast action=" + action);
                if (QZoneTeenOnlineTimeHelper.TEEN_PSW_VERIFY_RESULT_ACTION.equals(action)) {
                    QFSTeenModeAntiAddictionTipsPart.this.D9(intent);
                    return;
                }
                return;
            }
            QLog.e("QFSTeenModeAntiAddictionTipsPart", 1, "receive psw broadcast intent is null or action is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(Intent intent) {
        if (intent == null) {
            QLog.e("QFSTeenModeAntiAddictionTipsPart", 1, "handleQFSTeenPswVerifyResult data is null");
            return;
        }
        String stringExtra = intent.getStringExtra("result");
        QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "handleQFSTeenPswVerifyResult result=" + stringExtra);
        if (!"success".equals(stringExtra)) {
            return;
        }
        I9(false, null);
        QCircleToast.o(this.H, 0);
        J9();
        QFSTeenModeLoginTimeReporter.getInstance().resetLoginTimeDuration();
    }

    private void E9() {
        if (this.I) {
            G9();
        } else {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        ViewStub viewStub;
        if (this.F || (viewStub = (ViewStub) this.f88322e.findViewById(R.id.f55512i4)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.f88323f = (FrameLayout) inflate.findViewById(R.id.f55452hy);
        this.C = (ImageView) inflate.findViewById(R.id.f55432hw);
        this.f88324h = (TextView) inflate.findViewById(R.id.f55502i3);
        this.f88325i = (TextView) inflate.findViewById(R.id.f55442hx);
        this.f88326m = (TextView) inflate.findViewById(R.id.f55462hz);
        this.D = (LinearLayout) inflate.findViewById(R.id.f55492i2);
        Button button = (Button) inflate.findViewById(R.id.f55482i1);
        this.E = button;
        button.setOnClickListener(this);
        this.D.setOnClickListener(this);
        boolean isTabMode = QCirclePluginUtil.isTabMode();
        this.I = isTabMode;
        if (isTabMode) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("pymk_feed_bg")).setRequestWidth(cx.g()).setRequestHeight(cx.f()).setTargetView(this.C).setEnableAutoDeleteLocalCache(false).setSupportRecycler(false));
        this.F = true;
        QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "Teen Mode Anti Addiction Window Has init.");
    }

    private void G9() {
        if (TextUtils.isEmpty(this.G)) {
            return;
        }
        c.j(getContext(), this.G, true);
        QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "Jump To Teen Mode Psw verify Page.");
    }

    private void H9() {
        if (this.f88321d == null) {
            return;
        }
        if (this.J == null) {
            this.J = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(QZoneTeenOnlineTimeHelper.TEEN_PSW_VERIFY_RESULT_ACTION);
        try {
            this.f88321d.registerReceiver(this.J, intentFilter);
            QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "[registerReceiver]");
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("QFSTeenModeAntiAddictionTipsPart", 1, "registerReceiver fail");
        }
    }

    private void I9(final boolean z16, final QFSTeenModeLoginTimeReporter.QFSTeenModeDialogBean qFSTeenModeDialogBean) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.teenmode.QFSTeenModeAntiAddictionTipsPart.1
            @Override // java.lang.Runnable
            public void run() {
                QFSTeenModeAntiAddictionTipsPart.this.K = z16;
                QFSTeenModeAntiAddictionTipsPart.this.F9();
                if (QFSTeenModeAntiAddictionTipsPart.this.f88323f == null) {
                    return;
                }
                if (z16) {
                    QFSTeenModeAntiAddictionTipsPart.this.K9(qFSTeenModeDialogBean);
                    QFSTeenModeAntiAddictionTipsPart.this.f88323f.setVisibility(0);
                    ax.k(QFSTeenModeAntiAddictionTipsPart.this.getContext(), false);
                    SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSTeenModeAntiAddictionTipsPart.this.getContext()));
                } else {
                    QFSTeenModeAntiAddictionTipsPart.this.f88323f.setVisibility(8);
                    ax.k(QFSTeenModeAntiAddictionTipsPart.this.getContext(), true);
                    SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, QFSTeenModeAntiAddictionTipsPart.this.getContext()));
                }
                QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "Tips view is visible: " + z16);
            }
        });
    }

    private void J9() {
        Activity activity = this.f88321d;
        if (activity == null) {
            return;
        }
        try {
            activity.unregisterReceiver(this.J);
            QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "[unRegisterReceiver]");
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("QFSTeenModeAntiAddictionTipsPart", 1, "unRegisterReceiver fail");
        }
        this.J = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9(QFSTeenModeLoginTimeReporter.QFSTeenModeDialogBean qFSTeenModeDialogBean) {
        String a16;
        if (qFSTeenModeDialogBean == null) {
            return;
        }
        if (!TextUtils.isEmpty(qFSTeenModeDialogBean.mTitle)) {
            this.f88324h.setText(qFSTeenModeDialogBean.mTitle);
        }
        if (!TextUtils.isEmpty(qFSTeenModeDialogBean.mContent)) {
            this.f88325i.setText(qFSTeenModeDialogBean.mContent);
        }
        if (!TextUtils.isEmpty(qFSTeenModeDialogBean.mJumpText)) {
            this.f88326m.setText(qFSTeenModeDialogBean.mJumpText);
            Button button = this.E;
            if (this.I) {
                a16 = qFSTeenModeDialogBean.mJumpText;
            } else {
                a16 = h.a(R.string.f194474c0);
            }
            button.setText(a16);
        }
        this.G = qFSTeenModeDialogBean.mJumpUrl;
        this.H = qFSTeenModeDialogBean.mToastText;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTeenModeAntiAddictionTipsPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && uq3.c.x5()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f55492i2) {
            G9();
        } else if (id5 == R.id.f55482i1) {
            E9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88322e = view;
        this.f88321d = getActivity();
        QFSTeenModeLoginTimeReporter.getInstance().setReportListener(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        J9();
        QFSTeenModeLoginTimeReporter.getInstance().releaseReportListener();
    }

    @Override // cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter.QFSTeenModeTimeoutListener
    public void showAntiAddictionWindow(QFSTeenModeLoginTimeReporter.QFSTeenModeDialogBean qFSTeenModeDialogBean) {
        if (this.K) {
            QLog.d("QFSTeenModeAntiAddictionTipsPart", 1, "[showAntiAddictionWindow] is visible");
            return;
        }
        I9(true, qFSTeenModeDialogBean);
        H9();
        QCircleSchemeLauncher.d(RFWApplication.getApplication(), "mqqapi://qcircle/openfolder?tabtype=6&childmode=1&is_teen_mode_limit=1");
    }
}
