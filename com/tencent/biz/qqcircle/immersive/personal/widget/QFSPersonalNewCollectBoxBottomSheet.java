package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalCollectBoxEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSMoveCollectBoxRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSNewCollectBoxRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSUpdateCollectBoxRequest;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$CreateFavoritesRsp;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudFavoritessvr$MoveFavoritesFeedsRsp;
import feedcloud.FeedCloudFavoritessvr$UpdateFavoritesRsp;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalNewCollectBoxBottomSheet extends QFSBaseBottomSheetDialog implements View.OnClickListener {
    private static final int M = cx.a(96.0f);
    private View E;
    private final View F;
    private EditText G;
    private TextView H;
    private com.tencent.biz.qqcircle.widgets.comment.f I;
    private int J;
    private final com.tencent.biz.qqcircle.immersive.personal.bean.n K;
    private final QCircleReportBean L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements f.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardClosed() {
            QLog.d("QFSPersonalNewCollectBoxBottomSheet", 1, "onSoftKeyboardClosed");
            QFSPersonalNewCollectBoxBottomSheet.this.dismiss();
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardOpened(int i3) {
            QLog.d("QFSPersonalNewCollectBoxBottomSheet", 1, "onSoftKeyboardOpened");
            if (QFSPersonalNewCollectBoxBottomSheet.this.J != i3) {
                QFSPersonalNewCollectBoxBottomSheet.this.J = i3;
                QFSPersonalNewCollectBoxBottomSheet.this.l0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$MoveFavoritesFeedsRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f89279a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f89280b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f89281c;

        c(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, List list, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo2) {
            this.f89279a = feedCloudFavoritessvr$FavoritesInfo;
            this.f89280b = list;
            this.f89281c = feedCloudFavoritessvr$FavoritesInfo2;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$MoveFavoritesFeedsRsp feedCloudFavoritessvr$MoveFavoritesFeedsRsp) {
            if (z16 && j3 == 0 && feedCloudFavoritessvr$MoveFavoritesFeedsRsp != null) {
                this.f89279a.f398434id.set(feedCloudFavoritessvr$MoveFavoritesFeedsRsp.dst_id.get());
                this.f89279a.feed_num.set(feedCloudFavoritessvr$MoveFavoritesFeedsRsp.dst_delta_num.get());
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(1);
                if (!RFSafeListUtils.isEmpty(this.f89280b)) {
                    this.f89279a.cover_url.set(((FeedCloudMeta$StFeed) this.f89280b.get(0)).cover.picUrl.get());
                }
                qFSPersonalCollectBoxEvent.setFavoritesInfo(this.f89279a);
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent2 = new QFSPersonalCollectBoxEvent(5);
                qFSPersonalCollectBoxEvent2.setFeedList(this.f89280b);
                qFSPersonalCollectBoxEvent2.setFavoritesInfo(this.f89281c);
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent2);
                QFSPersonalNewCollectBoxBottomSheet.this.dismiss();
                QFSPublishTipsUtils qFSPublishTipsUtils = new QFSPublishTipsUtils();
                qFSPublishTipsUtils.t(QFSPersonalNewCollectBoxBottomSheet.this.L);
                qFSPublishTipsUtils.v(QFSPersonalNewCollectBoxBottomSheet.this.F, this.f89279a, this.f89281c);
                return;
            }
            QLog.e("QFSPersonalNewCollectBoxBottomSheet", 1, "moveCollectBox error:" + j3 + "  errorMsg:" + str);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1920646h), 0);
            QFSPersonalNewCollectBoxBottomSheet.this.H.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$UpdateFavoritesRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f89283a;

        d(String str) {
            this.f89283a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$UpdateFavoritesRsp feedCloudFavoritessvr$UpdateFavoritesRsp) {
            if (z16 && j3 == 0 && feedCloudFavoritessvr$UpdateFavoritesRsp != null) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f194814cx), 0);
                QFSPersonalNewCollectBoxBottomSheet.this.K.a().title.set(this.f89283a);
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(2);
                qFSPersonalCollectBoxEvent.setFavoritesInfo(QFSPersonalNewCollectBoxBottomSheet.this.K.a());
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                QFSPersonalNewCollectBoxBottomSheet.this.dismiss();
                return;
            }
            QLog.e("QFSPersonalNewCollectBoxBottomSheet", 1, "updateCollectBox error:" + j3 + "  errorMsg:" + str);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f194804cw), 0);
            QFSPersonalNewCollectBoxBottomSheet.this.H.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$CreateFavoritesRsp> {
        e() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$CreateFavoritesRsp feedCloudFavoritessvr$CreateFavoritesRsp) {
            if (z16 && j3 == 0 && feedCloudFavoritessvr$CreateFavoritesRsp != null) {
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(1);
                FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = feedCloudFavoritessvr$CreateFavoritesRsp.info.get();
                qFSPersonalCollectBoxEvent.setFavoritesInfo(feedCloudFavoritessvr$FavoritesInfo);
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                if (QFSPersonalNewCollectBoxBottomSheet.this.K.c() == 5) {
                    QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent2 = new QFSPersonalCollectBoxEvent(3);
                    qFSPersonalCollectBoxEvent2.setFavoritesInfo(QFSPersonalNewCollectBoxBottomSheet.this.K.a());
                    SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent2);
                }
                QFSPersonalNewCollectBoxBottomSheet.this.dismiss();
                if (QFSPersonalNewCollectBoxBottomSheet.this.K.c() != 3) {
                    QFSPersonalNewCollectBoxBottomSheet.this.j0(feedCloudFavoritessvr$FavoritesInfo);
                    return;
                }
                QFSPublishTipsUtils qFSPublishTipsUtils = new QFSPublishTipsUtils();
                qFSPublishTipsUtils.t(QFSPersonalNewCollectBoxBottomSheet.this.L);
                qFSPublishTipsUtils.v(QFSPersonalNewCollectBoxBottomSheet.this.F, feedCloudFavoritessvr$FavoritesInfo, null);
                return;
            }
            QLog.e("QFSPersonalNewCollectBoxBottomSheet", 1, "createCollectBox error:" + j3 + "  errorMsg:" + str);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1920646h), 0);
            QFSPersonalNewCollectBoxBottomSheet.this.H.setEnabled(true);
        }
    }

    public QFSPersonalNewCollectBoxBottomSheet(@NonNull Context context, @NonNull View view, @NonNull com.tencent.biz.qqcircle.immersive.personal.bean.n nVar, QCircleReportBean qCircleReportBean) {
        super(context);
        this.F = view;
        this.K = nVar;
        this.L = qCircleReportBean;
        getBehavior().setDraggable(false);
        initView();
        i0();
        f0();
        l0();
        e0();
    }

    private void a0(String str, List<FeedCloudMeta$StFeed> list) {
        QFSNewCollectBoxRequest qFSNewCollectBoxRequest;
        if (this.K.c() == 5) {
            qFSNewCollectBoxRequest = new QFSNewCollectBoxRequest(this.K.a().f398434id.get(), str);
        } else {
            qFSNewCollectBoxRequest = new QFSNewCollectBoxRequest(str, list);
        }
        VSNetworkHelper.getInstance().sendRequest(qFSNewCollectBoxRequest, new e());
    }

    private void b0(boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_COLLECT_FOLDER_CONFIRM_BTN);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CREATE_COLLECT_FOLDER_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.c(this.K.c())));
        QCircleReportBean qCircleReportBean = this.L;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (this.K.a() != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.K.a().f398434id.get()));
        }
        if (z16) {
            str = "ev_xsj_abnormal_clck";
        } else {
            str = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str, buildElementParams);
    }

    private void c0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_COLLECT_FOLDER_POPUP);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CREATE_COLLECT_FOLDER_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.c(this.K.c())));
        QCircleReportBean qCircleReportBean = this.L;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void d0(View view) {
        String obj = this.G.getText().toString();
        if (com.tencent.biz.qqcircle.widgets.comment.d.f93569b.matcher(obj).find()) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1920846j), 0);
            return;
        }
        this.H.setEnabled(false);
        if (this.K.c() == 1) {
            a0(obj, null);
        } else if (this.K.c() == 2) {
            n0(obj);
        } else if (this.K.c() == 3) {
            a0(obj, this.K.b());
        } else if (this.K.c() == 4) {
            k0(obj);
        } else if (this.K.c() == 5) {
            a0(obj, null);
        }
        b0(true);
    }

    private void e0() {
        if (this.K.c() == 2) {
            ((TextView) this.E.findViewById(R.id.kbs)).setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194794cv));
            m0(this.K.a().title.get());
            this.H.setEnabled(false);
        } else if (this.K.c() == 5) {
            m0(this.K.a().title.get());
        }
    }

    private void f0() {
        this.J = uq3.k.b().e("sp_key_soft_keyboard_height", cx.a(250.0f));
    }

    private void g0() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(this.F);
        this.I = fVar;
        fVar.a(new a());
    }

    private void i0() {
        this.E.findViewById(R.id.f167033k60).setOnClickListener(this);
        this.H.setOnClickListener(this);
        g0();
        this.G.addTextChangedListener(new b());
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.gmk, (ViewGroup) null);
        this.E = inflate;
        this.G = (EditText) inflate.findViewById(R.id.byx);
        this.H = (TextView) this.E.findViewById(R.id.f107736b8);
        setContentView(this.E);
        c0();
        b0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        int i3;
        if (this.K.c() == 5) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.biz.qqcircle.immersive.personal.bean.f fVar = new com.tencent.biz.qqcircle.immersive.personal.bean.f(i3);
        fVar.c(feedCloudFavoritessvr$FavoritesInfo);
        new QFSPersonalCollectBoxAddFeedBottomSheet(this.C, this.F, fVar, this.L).show();
    }

    private void k0(String str) {
        FeedCloudFavoritessvr$FavoritesInfo a16 = this.K.a();
        FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = new FeedCloudFavoritessvr$FavoritesInfo();
        feedCloudFavoritessvr$FavoritesInfo.title.set(str);
        List<FeedCloudMeta$StFeed> b16 = this.K.b();
        VSNetworkHelper.getInstance().sendRequest(new QFSMoveCollectBoxRequest(a16.f398434id.get(), feedCloudFavoritessvr$FavoritesInfo, b16), new c(feedCloudFavoritessvr$FavoritesInfo, b16, a16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.height = this.J + M;
        this.E.setLayoutParams(layoutParams);
        getBehavior().setPeekHeight(layoutParams.height);
    }

    private void m0(String str) {
        this.G.setText(str);
        this.G.setSelection(str.length());
    }

    private void n0(String str) {
        VSNetworkHelper.getInstance().sendRequest(new QFSUpdateCollectBoxRequest(this.K.a().f398434id.get(), str), new d(str));
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        EditText editText = this.G;
        if (editText != null) {
            InputMethodUtil.hide(editText);
        }
        com.tencent.biz.qqcircle.widgets.comment.f fVar = this.I;
        if (fVar != null) {
            fVar.r();
            this.I = null;
        }
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSPersonalNewCollectBoxBottomSheet")) {
            int id5 = view.getId();
            if (id5 == R.id.f107736b8) {
                d0(view);
            } else if (id5 == R.id.f167033k60) {
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        g0();
        this.G.requestFocus();
        this.G.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalNewCollectBoxBottomSheet.3
            @Override // java.lang.Runnable
            public void run() {
                InputMethodUtil.show(QFSPersonalNewCollectBoxBottomSheet.this.G);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private int f89276d;

        /* renamed from: e, reason: collision with root package name */
        private int f89277e;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (QFSPersonalNewCollectBoxBottomSheet.this.G.getText().length() > 10) {
                int i3 = this.f89276d;
                QFSPersonalNewCollectBoxBottomSheet.this.G.setText(editable.delete(i3, this.f89277e + i3));
                QFSPersonalNewCollectBoxBottomSheet.this.G.setSelection(QFSPersonalNewCollectBoxBottomSheet.this.G.getText().length());
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928148i), 0);
                return;
            }
            this.f89276d = 0;
            this.f89277e = 0;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            this.f89276d = i3;
            this.f89277e = i17;
            QFSPersonalNewCollectBoxBottomSheet.this.H.setEnabled(!TextUtils.isEmpty(QFSPersonalNewCollectBoxBottomSheet.this.G.getText()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
