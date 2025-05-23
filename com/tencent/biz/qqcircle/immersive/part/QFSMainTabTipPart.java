package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleTabPopWindowGetRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabPopWindowSetRequest;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleSwitch$GetCirclePopupRsp;
import qqcircle.QQCircleSwitch$SetCirclePopupRsp;
import qqcircle.QQCircleSwitch$StCirclePopup;

/* loaded from: classes4.dex */
public class QFSMainTabTipPart extends u implements View.OnClickListener, SimpleEventReceiver {
    private Dialog C;
    private boolean D;
    private boolean E;
    private boolean G;
    private boolean H;
    private long L;
    private int M;
    private String P;
    private String Q;
    private BaseRequest R;
    private QQCircleSwitch$GetCirclePopupRsp S;
    protected com.tencent.biz.qqcircle.widgets.comment.f T;
    List<QQCircleSwitch$StCirclePopup> U;

    /* renamed from: d, reason: collision with root package name */
    private QCircleInitBean f87448d;

    /* renamed from: e, reason: collision with root package name */
    private View f87449e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f87450f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f87451h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f87452i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f87453m;
    private boolean F = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private String N = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if ((QFSMainTabTipPart.this.M == 2 || QFSMainTabTipPart.this.M == 3) && QFSMainTabTipPart.this.getActivity() != null) {
                QFSMainTabTipPart.this.getActivity().onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetCirclePopupRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f87463a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f87464b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f87465c;

        b(String str, int i3, int i16) {
            this.f87463a = str;
            this.f87464b = i3;
            this.f87465c = i16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetCirclePopupRsp qQCircleSwitch$SetCirclePopupRsp) {
            if (z16 && j3 == 0) {
                QLog.i("QFSMainTabTipPart", 1, "update dialog state success enable:" + this.f87463a + " traceId:" + baseRequest.getTraceId());
                if (QFSMainTabTipPart.this.Z9(this.f87464b, this.f87465c) || QFSMainTabTipPart.this.Y9(this.f87464b, this.f87465c) || QFSMainTabTipPart.this.aa(this.f87464b, this.f87465c)) {
                    QCircleHostUtil.setQCircleToBottomTab();
                    if (QFSMainTabTipPart.this.getContext() != null) {
                        QCircleToast.k(QCircleToast.f91646f, QFSMainTabTipPart.this.getContext().getString(R.string.f184813mw), 0, true);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.i("QFSMainTabTipPart", 1, "update dialog state error retcode= " + j3);
            if (QFSMainTabTipPart.this.getActivity() != null && !QFSMainTabTipPart.this.getActivity().isFinishing()) {
                QCircleToast.h(R.string.f195404ei, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements f.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardClosed() {
            QFSMainTabTipPart.this.K = false;
            QFSMainTabTipPart.this.clearKeyBoardListener();
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardOpened(int i3) {
            QFSMainTabTipPart.this.K = true;
        }
    }

    public QFSMainTabTipPart(boolean z16) {
        this.E = z16;
    }

    private void R9() {
        String str;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(1);
        if (this.E) {
            str = "3";
        } else {
            str = "2";
        }
        QCircleLpReportDc05504.report(subActionType.setExt7(str));
    }

    private void S9() {
        TextView textView = this.f87452i;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ImageView imageView = this.f87453m;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    private void T9() {
        String str;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(3);
        if (this.E) {
            str = "3";
        } else {
            str = "2";
        }
        QCircleLpReportDc05504.report(subActionType.setExt7(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(1).setExt7("1"));
    }

    private void V9(QCircleFeedVideoControlEvent qCircleFeedVideoControlEvent) {
        if (qCircleFeedVideoControlEvent.isPlay() && !this.E) {
            ba(true);
            QLog.d("QFSMainTabTipPart", 1, "QCircleFeedVideoControlEvent received");
        }
    }

    private void W9() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(this.f87449e);
        this.T = fVar;
        fVar.a(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(4).setExt7("1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y9(int i3, int i16) {
        if (2 == i3 && 2 == i16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z9(int i3, int i16) {
        if (1 == i3 && 2 == i16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa(int i3, int i16) {
        if (3 == i3 && 2 == i16) {
            return true;
        }
        return false;
    }

    private void ba(final boolean z16) {
        this.I = true;
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z16 || QFSMainTabTipPart.this.J) {
                    return;
                }
                QFSMainTabTipPart qFSMainTabTipPart = QFSMainTabTipPart.this;
                qFSMainTabTipPart.ca(qFSMainTabTipPart.S, QFSMainTabTipPart.this.R, QFSMainTabTipPart.this.H, QFSMainTabTipPart.this.L);
                QFSMainTabTipPart.this.U9();
            }
        }, uq3.c.d4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(QQCircleSwitch$GetCirclePopupRsp qQCircleSwitch$GetCirclePopupRsp, BaseRequest baseRequest, boolean z16, long j3) {
        if (qQCircleSwitch$GetCirclePopupRsp == null) {
            QLog.e("QFSMainTabTipPart", 1, "[isShowPopWindow] rsp is null");
            return;
        }
        QLog.d("QFSMainTabTipPart", 1, "[isShowPopWindow] QCircleTabPopUpGetRequest traceId: " + baseRequest.getTraceId() + " isSuccess:" + z16 + " retCode: " + j3 + " rspEnable:" + qQCircleSwitch$GetCirclePopupRsp.popupList.get());
        if (z16 && j3 == 0) {
            if (!Cdo.B9() && !QFSTeenModePopWindowPart.T9() && ((getHostFragment() == null || getHostFragment().getPageId() != 504) && !QFSPersonalRecommendSwitchPanelPart.N9())) {
                List<QQCircleSwitch$StCirclePopup> list = this.U;
                if (list != null) {
                    for (QQCircleSwitch$StCirclePopup qQCircleSwitch$StCirclePopup : list) {
                        if ((this.E && qQCircleSwitch$StCirclePopup.get().type.get() == 3) || ((!this.E && qQCircleSwitch$StCirclePopup.get().type.get() == 1) || (!this.E && qQCircleSwitch$StCirclePopup.get().type.get() == 2))) {
                            if (this.G && qQCircleSwitch$StCirclePopup.get() != null && qQCircleSwitch$StCirclePopup.get().key != null) {
                                if (this.N == null) {
                                    this.N = qQCircleSwitch$StCirclePopup.get().key.get();
                                    this.P = qQCircleSwitch$StCirclePopup.get().title.get();
                                    this.Q = qQCircleSwitch$StCirclePopup.get().subtitle.get();
                                    QLog.d("QFSMainTabTipPart", 1, "get pop window request key is " + this.N);
                                }
                                na();
                                this.D = false;
                                return;
                            }
                            this.F = true;
                        }
                    }
                    return;
                }
                return;
            }
            QLog.d("QFSMainTabTipPart", 1, "[isShowPopWindow] QFSPersonalRecommendSwitchPanelPart.isPersonalRecommendSwitchPanelCanShow() = " + QFSPersonalRecommendSwitchPanelPart.N9() + ", QFSNewUserPYMKGuidePart.isShowNewUserPYMKGuide() = " + Cdo.B9() + ", QFSTeenModePopWindowPart.isTeenModePopWindowShow() = " + QFSTeenModePopWindowPart.T9());
            if (getHostFragment() != null) {
                QLog.d("QFSMainTabTipPart", 1, "[isShowPopWindow] getHostFragment().getPageId() = " + getHostFragment().getPageId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyBoardListener() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = this.T;
        if (fVar != null) {
            fVar.r();
            this.T = null;
        }
    }

    private boolean da() {
        if (!this.E) {
            return false;
        }
        return com.tencent.biz.qqcircle.utils.t.a(this.f87448d);
    }

    private void ea(View view) {
        ImageView imageView;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view.findViewById(R.id.f34080y7);
        }
        QFSDynamicResourceManager.g().updateNetworkResource(imageView, "qvideo_skin_dialog_top_tab_v2", R.drawable.nq6);
    }

    private void ga(final boolean z16) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    QFSMainTabTipPart qFSMainTabTipPart = QFSMainTabTipPart.this;
                    qFSMainTabTipPart.ca(qFSMainTabTipPart.S, QFSMainTabTipPart.this.R, QFSMainTabTipPart.this.H, QFSMainTabTipPart.this.L);
                }
            }
        });
    }

    private void ia() {
        String str;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(2);
        if (this.E) {
            str = "3";
        } else {
            str = "2";
        }
        QCircleLpReportDc05504.report(subActionType.setExt7(str));
    }

    private void ja() {
        Window window = this.C.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = com.tencent.biz.qqcircle.utils.cx.a(280.0f);
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    private void la() {
        this.C.setCanceledOnTouchOutside(false);
        this.C.getWindow().requestFeature(1);
        this.C.getWindow().setFlags(1024, 1024);
        this.C.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    private void ma() {
        String a16;
        String string;
        if (getPartRootView() != null && getActivity() != null && !getActivity().isFinishing()) {
            if (this.R != null && this.N != null && this.S != null) {
                this.C = new com.tencent.biz.qqcircle.widgets.comment.a(getContext());
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ghr, (ViewGroup) null);
                ea(inflate);
                la();
                TextView textView = (TextView) inflate.findViewById(R.id.f44081o8);
                this.f87450f = textView;
                if (!TextUtils.isEmpty(this.P)) {
                    a16 = this.P;
                } else {
                    a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f195464eo);
                }
                textView.setText(a16);
                TextView textView2 = (TextView) inflate.findViewById(R.id.f44091o9);
                this.f87451h = textView2;
                if (!TextUtils.isEmpty(this.Q)) {
                    string = this.Q;
                } else {
                    string = getContext().getString(R.string.f195494er);
                }
                textView2.setText(string);
                this.f87452i = (TextView) inflate.findViewById(R.id.vvn);
                this.f87453m = (ImageView) inflate.findViewById(R.id.f34060y5);
                S9();
                this.C.setContentView(inflate);
                int i3 = this.M;
                if (i3 == 0) {
                    i3 = 1;
                }
                this.M = i3;
                if (this.I && this.J && i3 == 1) {
                    return;
                }
                this.C.setOnDismissListener(new a());
                if (!this.K && getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    this.C.show();
                    ja();
                }
                oa(this.N, this.M, 1);
                QLog.d("QFSMainTabTipPart", 1, "pop window request key3 = " + this.N);
                return;
            }
            return;
        }
        QLog.e("QFSMainTabTipPart", 1, "[showPopupWindow] view == null || getActivity is finish");
    }

    private void na() {
        try {
            ma();
        } catch (Exception e16) {
            QLog.e("QFSMainTabTipPart", 1, "[showPopupWindowSafe] error:" + e16);
        }
    }

    private void oa(String str, int i3, int i16) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleTabPopWindowSetRequest(str, i3, i16), new b(str, i3, i16));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFeedVideoControlEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainTabTipPart";
    }

    public void ha() {
        VSNetworkHelper.getInstance().sendRequest(new QCircleTabPopWindowGetRequest(), new VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$GetCirclePopupRsp>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(final BaseRequest baseRequest, final boolean z16, final long j3, String str, final QQCircleSwitch$GetCirclePopupRsp qQCircleSwitch$GetCirclePopupRsp) {
                QFSMainTabTipPart.this.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PBRepeatMessageField<QQCircleSwitch$StCirclePopup> pBRepeatMessageField;
                        QQCircleSwitch$GetCirclePopupRsp qQCircleSwitch$GetCirclePopupRsp2 = qQCircleSwitch$GetCirclePopupRsp;
                        if (qQCircleSwitch$GetCirclePopupRsp2 != null && (pBRepeatMessageField = qQCircleSwitch$GetCirclePopupRsp2.popupList) != null) {
                            if (pBRepeatMessageField.size() == 0) {
                                QLog.d("QFSMainTabTipPart", 1, "window cannot be shown more");
                                QFSMainTabTipPart.this.X9();
                                QFSMainTabTipPart.this.D = false;
                            } else {
                                QFSMainTabTipPart.this.U = qQCircleSwitch$GetCirclePopupRsp.popupList.get();
                                QFSMainTabTipPart.this.S = qQCircleSwitch$GetCirclePopupRsp;
                                QFSMainTabTipPart.this.R = baseRequest;
                                QFSMainTabTipPart.this.H = z16;
                                QFSMainTabTipPart.this.L = j3;
                                QFSMainTabTipPart.this.D = true;
                            }
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        int i3;
        na();
        if (this.D) {
            this.D = false;
            this.J = true;
            R9();
            if (this.E) {
                i3 = 3;
            } else {
                i3 = 2;
            }
            this.M = i3;
            int i16 = i3 - 1;
            List<QQCircleSwitch$StCirclePopup> list = this.U;
            if (list != null && i16 < list.size() && this.U.get(i16) != null && this.U.get(i16).get() != null && this.U.get(i16).get().key != null) {
                this.N = this.U.get(i16).get().key.get();
                QLog.d("QFSMainTabTipPart", 1, "back window request key = " + this.N);
            }
            ga(true);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.f34060y5) {
                QLog.d("QFSMainTabTipPart", 1, "pop window request key1 = " + this.N);
                String str = this.N;
                if (this.E) {
                    i16 = 3;
                } else {
                    i16 = 2;
                }
                oa(str, i16, 3);
                if (this.C != null && getActivity() != null) {
                    int i17 = this.M;
                    if (i17 == 1) {
                        this.C.dismiss();
                    } else if (i17 == 2 || i17 == 3) {
                        this.C.dismiss();
                        getActivity().onBackPressed();
                    }
                }
                T9();
            } else if (id5 == R.id.vvn) {
                QLog.d("QFSMainTabTipPart", 1, "pop window request key2 = " + this.N);
                if (uq3.c.F()) {
                    QCircleHostUtil.jumpQQBottomSettingPage();
                    this.C.dismiss();
                } else {
                    String str2 = this.N;
                    if (this.E) {
                        i3 = 3;
                    } else {
                        i3 = 2;
                    }
                    oa(str2, i3, 2);
                    if (this.C != null && getActivity() != null) {
                        int i18 = this.M;
                        if (i18 == 1) {
                            this.C.dismiss();
                        } else if (i18 == 2 || i18 == 3) {
                            this.C.dismiss();
                            getActivity().onBackPressed();
                        }
                    }
                }
                ia();
            }
            QLog.d("QFSMainTabTipPart", 1, "mPopWindow is closed!");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87449e = view;
        W9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        if (uq3.c.M6() || !(getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleInitBean)) {
            return;
        }
        QCircleInitBean qCircleInitBean = (QCircleInitBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        this.f87448d = qCircleInitBean;
        if (!com.tencent.biz.qqcircle.utils.ae.a(qCircleInitBean) && QCirclePluginGlobalInfo.I()) {
            if (!da()) {
                ha();
                QCirclePluginGlobalInfo.a0(false);
            }
            if (!this.E) {
                ba(true);
            }
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        clearKeyBoardListener();
        getMainHandler().removeCallbacksAndMessages(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.G = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.G = true;
        if (this.F) {
            na();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        getMainHandler().removeCallbacksAndMessages(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFeedVideoControlEvent) {
            V9((QCircleFeedVideoControlEvent) simpleBaseEvent);
        }
    }
}
