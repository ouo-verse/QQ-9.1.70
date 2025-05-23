package com.qzone.detail.ui.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.detail.ui.adapter.MergeListAdapter;
import com.qzone.detail.ui.comment.CommentListLayout;
import com.qzone.detail.ui.component.FeedElementBaseClickListener;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentEssence;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.comment.bean.CommentReplyParam;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.qzone.util.u;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.qzone.widget.util.b;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.report.lp.LpReportInfo_DC01691;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProcessUtils;
import cooperation.qzone.util.QZLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CommentListBaseController implements IObserver.main, com.qzone.detail.ui.component.b {
    public static Comment A0;
    public static Comment B0;
    private static final String C0 = com.qzone.util.l.a(R.string.kt9);
    protected String C;
    protected Map<Integer, String> D;
    protected Activity E;
    protected MergeListAdapter F;
    protected com.qzone.proxy.feedcomponent.ui.detail.b G;
    protected com.qzone.proxy.feedcomponent.ui.detail.b H;
    protected com.qzone.proxy.feedcomponent.ui.detail.a I;
    private QZoneDetailService J;
    protected Handler K;
    private CommentListLayout L;
    private int M;
    private QZonePullToRefreshListView N;
    private boolean P;
    private boolean Q;
    protected User R;
    public int S;
    protected BusinessFeedData T;
    private boolean U;
    private boolean V;
    private boolean W;
    private o X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f46893a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f46894b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f46895c0;

    /* renamed from: d, reason: collision with root package name */
    protected long f46896d;

    /* renamed from: d0, reason: collision with root package name */
    private QZonePullToRefreshListView f46897d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f46898e;

    /* renamed from: e0, reason: collision with root package name */
    private com.qzone.proxy.feedcomponent.ui.detail.b f46899e0;

    /* renamed from: f, reason: collision with root package name */
    protected String f46900f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f46901f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f46902g0;

    /* renamed from: h, reason: collision with root package name */
    protected String f46903h;

    /* renamed from: h0, reason: collision with root package name */
    private int f46904h0;

    /* renamed from: i, reason: collision with root package name */
    protected String f46905i;

    /* renamed from: i0, reason: collision with root package name */
    private FeedElementBaseClickListener f46906i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f46907j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f46908k0;

    /* renamed from: l0, reason: collision with root package name */
    private com.qzone.proxy.feedcomponent.ui.detail.b f46909l0;

    /* renamed from: m, reason: collision with root package name */
    protected String f46910m;

    /* renamed from: m0, reason: collision with root package name */
    private com.qzone.detail.ui.component.f f46911m0;

    /* renamed from: n0, reason: collision with root package name */
    private com.qzone.detail.ui.comment.b f46912n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f46913o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f46914p0;

    /* renamed from: q0, reason: collision with root package name */
    protected FeedElementBaseClickListener f46915q0;

    /* renamed from: r0, reason: collision with root package name */
    public ActionSheet f46916r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f46917s0;

    /* renamed from: t0, reason: collision with root package name */
    private Comment f46918t0;

    /* renamed from: u0, reason: collision with root package name */
    private Reply f46919u0;

    /* renamed from: v0, reason: collision with root package name */
    private ActionSheet.OnButtonClickListener f46920v0;

    /* renamed from: w0, reason: collision with root package name */
    private ListAdapter f46921w0;

    /* renamed from: x0, reason: collision with root package name */
    private CellCommentInfo f46922x0;

    /* renamed from: y0, reason: collision with root package name */
    private CellCommentEssence f46923y0;

    /* renamed from: z0, reason: collision with root package name */
    n f46924z0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f46930d;

        a(CellTextView.OnTextOperater onTextOperater) {
            this.f46930d = onTextOperater;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView.OnTextOperater onTextOperater = this.f46930d;
            if (onTextOperater != null) {
                onTextOperater.onCancle();
            }
            CommentListBaseController.this.f46908k0 = false;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView.OnTextOperater onTextOperater = this.f46930d;
            if (onTextOperater != null) {
                onTextOperater.onCopy();
            }
            CommentListBaseController.this.f46908k0 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.obj instanceof QZoneTask) {
                QZLog.d("CommentListBaseController", 1, "----picture: msg from qzone process.");
                QZoneTask qZoneTask = (QZoneTask) message.obj;
                qZoneTask.setHandler(CommentListBaseController.this.K);
                CommentListBaseController.this.T0().onTaskResponse(qZoneTask);
                return;
            }
            CommentListBaseController.this.t0(message);
            QZLog.d("CommentListBaseController", 1, "----get msg from QZoneDetailService.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f46935a;

        d(Comment comment) {
            this.f46935a = comment;
        }

        @Override // com.qzone.widget.util.b.e
        public void a() {
            CommentListBaseController.this.O(0, this.f46935a, null).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f46937d;

        e(CellTextView.OnTextOperater onTextOperater) {
            this.f46937d = onTextOperater;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView.OnTextOperater onTextOperater = this.f46937d;
            if (onTextOperater != null) {
                onTextOperater.onCancle();
            }
            CommentListBaseController.this.f46908k0 = false;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView.OnTextOperater onTextOperater = this.f46937d;
            if (onTextOperater != null) {
                onTextOperater.onCopy();
            }
            CommentListBaseController.this.f46908k0 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f46939a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Reply f46940b;

        f(Comment comment, Reply reply) {
            this.f46939a = comment;
            this.f46940b = reply;
        }

        @Override // com.qzone.widget.util.b.e
        public void a() {
            CommentListBaseController.this.O(1, this.f46939a, this.f46940b).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommentListBaseController.this.Pd();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommentListBaseController.this.v();
            CommentListBaseController.this.y0(34, 8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommentListBaseController.this.e0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class m implements ActionSheet.OnButtonClickListener {
        m() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(getClass().getSimpleName(), view);
            if (!CommentListBaseController.this.m0()) {
                int i16 = CommentListBaseController.this.f46917s0;
                if (i16 != 0) {
                    if (i16 == 1) {
                        if (CommentListBaseController.this.f46919u0 != null) {
                            CommentListBaseController commentListBaseController = CommentListBaseController.this;
                            commentListBaseController.z(commentListBaseController.K, commentListBaseController.T0().R(), CommentListBaseController.this.f46919u0, CommentListBaseController.this.f46918t0, 0);
                        } else {
                            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDetailReplyNotExist", "\u8be5\u6761\u56de\u590d\u4e0d\u5b58\u5728\u6216\u5df2\u88ab\u5220\u9664"), 3);
                        }
                    }
                } else if (CommentListBaseController.this.f46918t0 != null) {
                    CommentListBaseController commentListBaseController2 = CommentListBaseController.this;
                    commentListBaseController2.y(commentListBaseController2.K, commentListBaseController2.T0().R(), CommentListBaseController.this.f46918t0);
                } else {
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDetailCommentNotExist", "\u8be5\u6761\u8bc4\u8bba\u4e0d\u5b58\u5728\u6216\u5df2\u88ab\u5220\u9664"), 3);
                }
                CommentListBaseController commentListBaseController3 = CommentListBaseController.this;
                ActionSheet actionSheet = commentListBaseController3.f46916r0;
                if (actionSheet != null) {
                    ActionSheetHelper.dismissActionSheet(commentListBaseController3.E, actionSheet);
                    return;
                }
                return;
            }
            CommentListBaseController commentListBaseController4 = CommentListBaseController.this;
            ActionSheet actionSheet2 = commentListBaseController4.f46916r0;
            if (actionSheet2 != null) {
                ActionSheetHelper.dismissActionSheet(commentListBaseController4.E, actionSheet2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface n {
        void a();

        void b();

        void c();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface o {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CommentListBaseController(Activity activity) {
        this.P = false;
        this.Q = false;
        this.S = 0;
        this.U = false;
        this.V = false;
        this.Y = false;
        this.Z = false;
        this.f46894b0 = false;
        this.f46895c0 = 0;
        this.f46901f0 = false;
        this.f46907j0 = true;
        this.f46908k0 = false;
        this.f46913o0 = false;
        this.f46914p0 = false;
        this.f46917s0 = 0;
        this.f46918t0 = null;
        this.f46919u0 = null;
        this.f46920v0 = new m();
        this.f46924z0 = null;
        this.E = activity;
        this.K = new c(Looper.getMainLooper());
        T0();
    }

    private void F0(int i3, int i16) {
        this.f46902g0 = i3;
        this.f46904h0 = i16;
        if (K0()) {
            U().notifyDataSetChanged();
            this.f46901f0 = true;
            this.L.y();
            L0();
        }
    }

    private void G(int i3, int i16) {
        BusinessFeedData R = T0().R();
        if (l0()) {
            QZoneWriteOperationService.v0().L(R.getOperationInfo().cookie, i3, 0, 0, 0, i16, true, R.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, R);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qzone.proxy.feedcomponent.ui.detail.b I() {
        if (this.f46899e0 == null) {
            com.qzone.proxy.feedcomponent.ui.detail.b createFeedDetailCommentAdapter = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().createFeedDetailCommentAdapter(this.E, null, J());
            this.f46899e0 = createFeedDetailCommentAdapter;
            createFeedDetailCommentAdapter.setNeedBackground(false);
            this.f46899e0.setIsEssenceComment(true);
            this.f46899e0.setIsReplyVisible(true);
            this.f46899e0.setIsAbleToReply(true);
            this.f46899e0.setIsUsePicureViewerLayout(true);
            this.f46899e0.setCommentLikeVisible(true);
            this.f46899e0.setCommentLikeAble(true);
            this.f46899e0.setShowHeader(false);
        }
        return this.f46899e0;
    }

    private com.qzone.proxy.feedcomponent.ui.g J() {
        if (this.f46906i0 == null) {
            this.f46906i0 = new com.qzone.detail.ui.component.e(this.E, this);
        }
        return this.f46906i0;
    }

    private void J0(boolean z16, String str) {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.N;
        if (qZonePullToRefreshListView != null) {
            if (z16) {
                qZonePullToRefreshListView.s0(this.E.getString(R.string.gm6));
            } else {
                qZonePullToRefreshListView.r0(this.E.getString(R.string.gm5), str);
            }
        }
        A0();
    }

    private boolean K0() {
        int i3;
        Object item;
        if (this.f46899e0 != null && (i3 = this.f46902g0) != -1 && this.f46904h0 != -1) {
            Adapter adapter = U().c().get(i3 == 0 ? 1 : i3 == 1 ? 2 : 0);
            if (adapter != null && (item = adapter.getItem(this.f46904h0)) != null && (item instanceof Comment)) {
                Comment comment = (Comment) item;
                ArrayList arrayList = new ArrayList();
                arrayList.add(comment);
                this.f46899e0.setData(arrayList);
                this.f46899e0.notifyDataSetChanged();
                A0 = comment;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        this.W = H().getCount() + K().getCount() == 0;
        P().setWidgetData(Boolean.valueOf(this.W));
    }

    private com.qzone.proxy.feedcomponent.ui.g W() {
        if (this.f46911m0 == null) {
            this.f46911m0 = new com.qzone.detail.ui.component.f(this.E, this);
        }
        return this.f46911m0;
    }

    private com.qzone.proxy.feedcomponent.ui.detail.b Y() {
        if (this.f46909l0 == null) {
            com.qzone.proxy.feedcomponent.ui.detail.b createFeedDetailCommentAdapter = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().createFeedDetailCommentAdapter(this.E, null, W());
            this.f46909l0 = createFeedDetailCommentAdapter;
            createFeedDetailCommentAdapter.setNeedBackground(false);
            this.f46909l0.setShowHeader(true);
            this.f46909l0.setIsEssenceComment(true);
            this.f46909l0.setIsReplyVisible(true);
            this.f46909l0.setIsAbleToReply(true);
            this.f46909l0.setIsUsePicureViewerLayout(true);
            this.f46909l0.setCommentLikeVisible(true);
            this.f46909l0.setCommentLikeAble(true);
            this.f46909l0.setHeaderText(C0);
        }
        return this.f46909l0;
    }

    private void a0(QZoneResult qZoneResult) {
        if (qZoneResult != null && (qZoneResult.getSucceed() || (qZoneResult.getReturnCode() == 0 && ProcessUtils.isPicture(ProcessUtils.getCurProcessName(this.E))))) {
            QZLog.i("CommentListBaseController", 1, "---onServiceResult MSG_GET_MORE_COMMENT_ESSENCE success");
            J0(true, "");
            final Bundle bundle = (Bundle) qZoneResult.getData();
            if (bundle != null) {
                S().post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY);
                        if (businessFeedData != null && businessFeedData.getCommentEssence() != null) {
                            CommentListBaseController.this.K().setData(businessFeedData.getCommentEssence().commments);
                            CommentListBaseController.this.M0();
                        }
                        CommentListBaseController.this.U().notifyDataSetChanged();
                    }
                });
                return;
            }
            return;
        }
        J0(false, "");
        QZLog.i("CommentListBaseController", 1, "---onServiceResult MSG_GET_MORE_COMMENT_ESSENCE failed");
    }

    private void b0(QZoneResult qZoneResult) {
        if (qZoneResult != null && (qZoneResult.getSucceed() || (qZoneResult.getReturnCode() == 0 && ProcessUtils.isPicture(ProcessUtils.getCurProcessName(this.E))))) {
            QZLog.i("CommentListBaseController", 1, "---onServiceResult MSG_GET_MORE_COMMENT_SUCCESS success");
            J0(true, "");
            final Bundle bundle = (Bundle) qZoneResult.getData();
            if (bundle != null) {
                S().post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.12
                    @Override // java.lang.Runnable
                    public void run() {
                        BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY);
                        if (businessFeedData != null) {
                            CommentListBaseController.this.H().setData(businessFeedData.getCommentInfo().commments);
                            CommentListBaseController.this.M0();
                        }
                        CommentListBaseController.this.U().notifyDataSetChanged();
                    }
                });
                return;
            }
            return;
        }
        J0(false, "");
        QZLog.i("CommentListBaseController", 1, "---onServiceResult MSG_GET_MORE_COMMENT_SUCCESS failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        CommentListLayout commentListLayout = this.L;
        if (commentListLayout == null || !this.f46901f0) {
            return;
        }
        this.f46901f0 = false;
        A0 = null;
        commentListLayout.h();
        L0();
    }

    private void f0(Bundle bundle) {
        l();
        i0();
        h0(bundle);
    }

    private void g0() {
        QZonePullToRefreshListView o16 = this.L.o();
        this.f46897d0 = o16;
        o16.setAdapter((ListAdapter) I());
        this.f46897d0.setOnRefreshListener(new g());
    }

    private void i0() {
        int k3;
        if (this.L == null && this.E != null) {
            if (this.Y) {
                k3 = ar.k();
            } else {
                k3 = ar.k() / 2;
            }
            CommentListLayout commentListLayout = new CommentListLayout(this.E, -1, k3);
            this.L = commentListLayout;
            QZonePullToRefreshListView n3 = commentListLayout.n();
            this.N = n3;
            n3.setOnRefreshListener(new h());
            this.N.setOnScrollListener(new i());
            g0();
            this.V = true;
            this.L.setOnClickListenerForCommentContainer(new j());
            this.L.setOnClickListenerForCloseBtn(new k());
            this.L.setOnClickListenerForBackArea(new l());
        }
        this.N.setAdapter((ListAdapter) U());
        CommentListLayout commentListLayout2 = this.L;
        if (commentListLayout2 != null) {
            commentListLayout2.setTitleText(this.f46893a0);
        }
    }

    private void l() {
        EventCenter.getInstance().addUIObserver(this, "Detail", 1, 2, 3);
    }

    private boolean l0() {
        BusinessFeedData R = T0().R();
        return R != null && R.isGDTAdvFeed() && R.getFeedCommInfo() != null && GdtFeedUtilForQZone.p(R.getFeedCommInfo());
    }

    private void m(ListAdapter listAdapter) {
        if (this.N.j0() == null || this.f46921w0 == listAdapter) {
            return;
        }
        this.N.j0().setAdapter(listAdapter);
        this.f46921w0 = listAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0() {
        if (NetworkState.isNetSupport()) {
            return false;
        }
        ToastUtil.n(R.string.ghi);
        return true;
    }

    private boolean p() {
        if (!this.U || this.V) {
            return false;
        }
        i0();
        this.V = true;
        return true;
    }

    private void q() {
        com.qzone.proxy.feedcomponent.ui.detail.b bVar = this.f46899e0;
        if (bVar != null) {
            bVar.setData(null);
            this.f46899e0.notifyDataSetChanged();
            U().notifyDataSetChanged();
            this.f46901f0 = false;
            this.f46902g0 = -1;
            this.f46904h0 = -1;
        }
    }

    private void r() {
        com.qzone.proxy.feedcomponent.ui.detail.b bVar = this.G;
        if (bVar != null) {
            bVar.setData(null);
        }
        com.qzone.proxy.feedcomponent.ui.detail.b bVar2 = this.H;
        if (bVar2 != null) {
            bVar2.setData(null);
        }
        com.qzone.proxy.feedcomponent.ui.detail.a aVar = this.I;
        if (aVar != null) {
            aVar.setWidgetData(Boolean.FALSE);
        }
        com.qzone.proxy.feedcomponent.ui.detail.b bVar3 = this.f46899e0;
        if (bVar3 != null) {
            bVar3.setData(null);
        }
        this.f46896d = 0L;
        this.f46898e = 0;
        this.f46900f = "";
        this.f46903h = "";
        this.f46905i = "";
        this.f46910m = "";
        this.D = null;
        this.U = false;
        this.J = null;
        this.M = 0;
        this.W = false;
    }

    private void u() {
        EventCenter.getInstance().removeObserver(this);
    }

    private void v0(QZoneResult qZoneResult) {
        if (!qZoneResult.getSucceed() && (qZoneResult.getReturnCode() != 0 || !ProcessUtils.isPicture(ProcessUtils.getCurProcessName(this.E)))) {
            J0(false, qZoneResult.getMessage());
        } else {
            J0(true, "");
            x0(T0().R());
            s0();
            if (this.f46898e == 334) {
                if (LoginData.getInstance().getUin() == this.f46896d) {
                    this.P = true;
                }
                if (T0() != null && T0().R() != null && T0().R().getUser().uin == LoginData.getInstance().getUin()) {
                    this.Q = true;
                }
            }
            m(U());
        }
        if ((qZoneResult.getReturnCode() == -4403 || qZoneResult.getReturnCode() == -4404) && QZLog.isColorLevel()) {
            QZLog.d("CommentListBaseController", 2, "visit forbidden result: " + qZoneResult.getSucceed() + " resultCode: " + qZoneResult.getReturnCode() + " result.msg: " + qZoneResult.getMessage());
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("CommentListBaseController", 2, "this log is for qzonetest : comment detail is loading complete, result: " + qZoneResult.getSucceed() + " resultCode: " + qZoneResult.getReturnCode() + " result.msg: " + qZoneResult.getMessage());
        }
    }

    protected void A() {
        if (T0().C > 0 && !T0().f46826d) {
            T0().a0(this.f46896d, this.f46898e, this.f46903h, this.f46900f, T0().f46831m, 29, this.D, 1048578, false, true, this.K);
        } else {
            if (T0().E <= 0 || T0().f46826d) {
                return;
            }
            T0().b0(this.f46896d, this.f46898e, this.f46903h, this.f46900f, T0().D, 29, this.D, 1048579, false, true, this.K);
        }
    }

    protected void A0() {
        u5.b.u0("key_detail_refresh_last_timestamp", System.currentTimeMillis(), LoginData.getInstance().getUin());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(Handler handler, QZoneWriteOperationService.k kVar) {
        QZoneWriteOperationService.v0().t1(handler, kVar);
    }

    public void B0(n nVar) {
        this.f46924z0 = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(QZoneWriteOperationService.l lVar, RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        QZoneWriteOperationService.v0().X1(S(), lVar, rapidCommentExpressionInfo);
    }

    public CommentListBaseController C0(Bundle bundle) {
        r();
        f0(bundle);
        return this;
    }

    protected void D() {
        T0().Y(this.f46896d, this.f46898e, this.f46903h, this.f46900f, this.D, this.K, QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FLOAT_COMMENT_SOFT_ORDER, 1) == 1);
    }

    public void D0(CommentListLayout.c cVar) {
        CommentListLayout commentListLayout = this.L;
        if (commentListLayout != null) {
            commentListLayout.setOnCommentViewAnimListener(cVar);
        }
    }

    public void E0(o oVar) {
        this.X = oVar;
    }

    public void G0() {
        if (!this.V) {
            i0();
        }
        this.L.w();
        w0();
        y0(34, 1);
        q();
    }

    protected com.qzone.proxy.feedcomponent.ui.detail.b H() {
        if (this.G == null) {
            com.qzone.proxy.feedcomponent.ui.detail.b createFeedDetailCommentAdapter = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().createFeedDetailCommentAdapter(this.E, null, R());
            this.G = createFeedDetailCommentAdapter;
            createFeedDetailCommentAdapter.setNeedBackground(false);
            this.G.setShowHeader(true);
            this.G.setIsEssenceComment(false);
            this.G.setIsUsePicureViewerLayout(true);
            this.G.setCommentLikeVisible(true);
            this.G.setCommentLikeAble(true);
            this.G.setEnableShrinkComment(true);
        }
        if (T0().R() != null && T0().R().getPictureInfo() != null && T0().R().getPictureInfo().isSharingAlbumData()) {
            this.G.setIsSharingAlbumData(true);
        }
        return this.G;
    }

    public void H0(QZoneCommentPanelParams qZoneCommentPanelParams, BusinessFeedData businessFeedData) {
        if (!this.Y) {
            M().setVisible(false);
        }
        this.f46914p0 = true;
        n nVar = this.f46924z0;
        if (nVar != null) {
            nVar.a();
        }
        String e16 = cd.c.e(businessFeedData, qZoneCommentPanelParams.getCommentReplyParam(), qZoneCommentPanelParams.getRequestCode());
        if (!TextUtils.isEmpty(e16)) {
            qZoneCommentPanelParams.setCacheUniKey(e16);
        }
        ho.i.c().h(qZoneCommentPanelParams, this.E, businessFeedData);
    }

    protected com.qzone.proxy.feedcomponent.ui.detail.b K() {
        if (this.H == null) {
            com.qzone.proxy.feedcomponent.ui.detail.b createFeedDetailCommentAdapter = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().createFeedDetailCommentAdapter(this.E, null, R());
            this.H = createFeedDetailCommentAdapter;
            createFeedDetailCommentAdapter.setNeedBackground(false);
            this.H.setShowHeader(true);
            this.H.setIsEssenceComment(true);
            this.H.setIsReplyVisible(true);
            this.H.setIsAbleToReply(true);
            this.H.setIsUsePicureViewerLayout(true);
            this.H.setCommentLikeVisible(true);
            this.H.setCommentLikeAble(true);
            this.H.setEnableShrinkComment(true);
        }
        return this.H;
    }

    public int L() {
        BusinessFeedData businessFeedData = this.T;
        if (businessFeedData == null || businessFeedData.getCommentInfo() == null) {
            return 0;
        }
        return this.T.getCommentInfo().realCount;
    }

    public void L0() {
        CommentListLayout commentListLayout = this.L;
        if (commentListLayout == null) {
            return;
        }
        View l3 = commentListLayout.l();
        if (l3 != null) {
            l3.setVisibility(this.f46901f0 ? 0 : 8);
        }
        if (this.f46901f0) {
            this.L.setCommentDetailTitle();
        } else {
            this.L.setCommentNum(L());
        }
    }

    public CommentListLayout M() {
        if (this.L == null) {
            i0();
        }
        return this.L;
    }

    public ActionSheet O(int i3, Comment comment, Reply reply) {
        this.f46917s0 = i3;
        this.f46918t0 = comment;
        this.f46919u0 = reply;
        if (this.f46916r0 == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(this.E, R.string.gda), 0, 0, 2));
            ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(this.E, arrayList, this.f46920v0);
            this.f46916r0 = createActionSheet;
            createActionSheet.addCancelButton(R.string.cancel);
        }
        ActionSheetHelper.showActionSheet(this.E, this.f46916r0);
        return this.f46916r0;
    }

    protected com.qzone.proxy.feedcomponent.ui.detail.a P() {
        if (this.I == null) {
            com.qzone.proxy.feedcomponent.ui.detail.a createDetailWidgetAdapter = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().createDetailWidgetAdapter(this.E, 2);
            this.I = createDetailWidgetAdapter;
            createDetailWidgetAdapter.setWidgetData(Boolean.FALSE);
            this.I.setOnDetailFeedElementClickListener(R());
        }
        return this.I;
    }

    @Override // com.qzone.detail.ui.component.b
    public void Pd() {
        BusinessFeedData S = T0().S();
        H0(cd.c.b(S, null).y(1207).A(-1).getParams(), S);
        y0(34, 2);
    }

    public FeedElementBaseClickListener R() {
        if (this.f46915q0 == null) {
            this.f46915q0 = new FeedElementBaseClickListener(this.E, this);
        }
        return this.f46915q0;
    }

    public Handler S() {
        return this.K;
    }

    public QZonePullToRefreshListView T() {
        return this.N;
    }

    @Override // com.qzone.detail.ui.component.b
    public QZoneDetailService T0() {
        if (this.J == null) {
            this.J = new QZoneDetailService();
        }
        return this.J;
    }

    protected MergeListAdapter U() {
        if (this.F == null) {
            MergeListAdapter mergeListAdapter = new MergeListAdapter();
            this.F = mergeListAdapter;
            mergeListAdapter.b(Y());
            this.F.b(H());
            this.F.b(K());
            this.F.b(P());
        }
        return this.F;
    }

    public void V() {
        Message obtain = Message.obtain();
        obtain.what = 158;
        S().removeMessages(158);
        S().sendMessageDelayed(obtain, 500L);
    }

    @Override // com.qzone.detail.ui.component.b
    public void Ye(View view, Comment comment, CellTextView.OnTextOperater onTextOperater) {
        User user;
        a aVar = new a(onTextOperater);
        BusinessFeedData R = T0().R();
        if (R == null) {
            QZLog.w("CommentListBaseController", "--onCommentLongClick, businessFeedData is null.");
            return;
        }
        b bVar = (comment == null || QZoneFeedUtil.n(comment) == null) ? null : new b(comment);
        this.f46908k0 = true;
        if (R.getLocalInfo() != null && !R.getLocalInfo().canDelComment) {
            com.qzone.widget.util.b.h(this.E, aVar);
            return;
        }
        if (comment == null || (user = comment.user) == null) {
            com.qzone.widget.util.b.h(this.E, aVar);
            return;
        }
        if (user.uin != LoginData.getInstance().getUin() && R.getUser().uin != LoginData.getInstance().getUin()) {
            com.qzone.widget.util.b.h(this.E, aVar);
        } else if (this.f46898e == 334 && comment.user.uin != LoginData.getInstance().getUin() && !this.P) {
            com.qzone.widget.util.b.h(this.E, aVar);
        } else {
            com.qzone.widget.util.b.k(this.E, aVar, new d(comment), null, bVar, null);
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public int cg() {
        return 0;
    }

    @Override // com.qzone.detail.ui.component.b
    public int getAppid() {
        return 0;
    }

    protected void h0(Bundle bundle) {
        int i3;
        this.f46896d = bundle.getLong("uin");
        this.f46898e = bundle.getInt("appid");
        this.f46900f = bundle.getString("sub_id");
        this.f46903h = bundle.getString(PictureConst.CELL_ID);
        this.f46905i = bundle.getString(QZoneResult.UGC_KEY);
        this.f46910m = bundle.getString("feed_id");
        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable("business_params");
        if (mapParcelable != null) {
            this.D = mapParcelable.getSingleMap();
        }
        Map<Integer, String> map = this.D;
        if (map != null) {
            this.C = map.get(2);
        }
        this.M = bundle.getInt(PictureConst.PHOTO_COMMENT_NUM);
        this.U = true;
        if (!TextUtils.isEmpty(this.f46905i) && !TextUtils.isEmpty(this.f46910m) && ((i3 = this.f46898e) == 311 || i3 == 6600)) {
            if (QZLog.isColorLevel()) {
                QZLog.i("CommentListBaseController", 1, "-------ugcKey:" + this.f46905i + ",feedId:" + this.f46910m);
            }
            if (this.f46895c0 == 0) {
                T0().C0(this.f46905i, this.f46910m);
            } else {
                S().postDelayed(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneDetailService T0 = CommentListBaseController.this.T0();
                        CommentListBaseController commentListBaseController = CommentListBaseController.this;
                        T0.C0(commentListBaseController.f46905i, commentListBaseController.f46910m);
                    }
                }, this.f46895c0);
            }
        }
        this.f46912n0 = new com.qzone.detail.ui.comment.b();
    }

    public boolean j0() {
        CommentListLayout commentListLayout = this.L;
        return commentListLayout != null && commentListLayout.r();
    }

    public boolean k0() {
        CommentListLayout commentListLayout = this.L;
        if (commentListLayout == null) {
            return false;
        }
        return commentListLayout.getVisibility() == 0 || this.f46914p0;
    }

    public boolean o0() {
        return w();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Detail".equals(event.source.getName()) && event.what == 1) {
            if (!x0(T0().R())) {
                U().notifyDataSetChanged();
            }
            s0();
        }
    }

    public void p0() {
        r6.a.o().I();
        u();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.15
            @Override // java.lang.Runnable
            public void run() {
                CommentListBaseController.this.T0().close();
            }
        });
        A0 = null;
        B0 = null;
        com.qzone.detail.ui.comment.b bVar = this.f46912n0;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public void p6(View view, Comment comment, Reply reply, int i3, int i16) {
        User user;
        User user2;
        if (this.f46898e != 334 || this.P || this.Q) {
            if (!n(comment, i3)) {
                QZLog.w("CommentListBaseController", "checkIsCommentInvalid:false,return");
                return;
            }
            if (i16 == 101 && comment != null && (user2 = comment.user) != null && user2.uin == LoginData.getInstance().getUin()) {
                O(0, comment, reply).show();
                return;
            }
            if (i16 == 1 && comment != null && reply != null && (user = reply.user) != null && user.uin == LoginData.getInstance().getUin()) {
                O(1, comment, reply).show();
            } else {
                I0(view, comment, reply, i3);
            }
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public void q5(View view, Comment comment, Reply reply, CellTextView.OnTextOperater onTextOperater) {
        BusinessFeedData R = T0().R();
        e eVar = new e(onTextOperater);
        this.f46908k0 = true;
        if (comment == null || reply == null || R == null) {
            com.qzone.widget.util.b.h(this.E, eVar);
        } else if (reply.user.uin != LoginData.getInstance().getUin() && R.getUser().uin != LoginData.getInstance().getUin()) {
            com.qzone.widget.util.b.h(this.E, eVar);
        } else {
            com.qzone.widget.util.b.k(this.E, eVar, new f(comment, reply), null, null, null);
        }
    }

    public void t0(Message message) {
        User user;
        int i3 = message.what;
        if (i3 == 153) {
            int i16 = message.arg1;
            if (T0().R() == null || T0().R().getCommentInfo() == null || T0().R().getLocalInfo() == null || !T0().R().getLocalInfo().canDelComment || T0().R().getCommentInfo().commments == null || i16 >= T0().R().getCommentInfo().commments.size()) {
                return;
            }
            Comment comment = T0().R().getCommentInfo().commments.get(i16);
            if (comment != null && (user = comment.user) != null && user.uin == LoginData.getInstance().getUin()) {
                O(0, comment, null).show();
            }
        } else if (i3 != 8192) {
            switch (i3) {
                case 156:
                    QZLog.i("CommentListBaseController", 1, "---onHandleMessage render");
                    x0(T0().R());
                    break;
                case 157:
                    D();
                    break;
                case 158:
                    A();
                    break;
            }
        } else {
            BusinessFeedData S = T0().S();
            H0(cd.c.b(S, null).y(1207).A(-1).m(false).l(true).getParams(), S);
        }
        u0(QZoneResult.unpack(message));
    }

    public void v() {
        this.L.i();
        o oVar = this.X;
        if (oVar != null) {
            oVar.a();
        }
        z0();
    }

    public boolean w() {
        if (this.L != null && this.f46901f0) {
            e0();
            return true;
        }
        if (!k0()) {
            return false;
        }
        v();
        return true;
    }

    protected void x(QZoneWriteOperationService.l lVar) {
        QZoneWriteOperationService.v0().Q(S(), lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(Handler handler, BusinessFeedData businessFeedData, Comment comment) {
        QZoneWriteOperationService.v0().T(handler, businessFeedData, comment);
    }

    protected void y0(int i3, int i16) {
        int i17 = this.Y ? 2 : 1;
        LpReportInfo_dc00321 lpReportInfo_dc00321 = new LpReportInfo_dc00321(i3, i16, 1, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
        lpReportInfo_dc00321.reserves3 = Integer.toString(i17);
        LpReportManager.getInstance().reportToDC00321(lpReportInfo_dc00321, false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(Handler handler, BusinessFeedData businessFeedData, Reply reply, Comment comment, int i3) {
        QZoneWriteOperationService.v0().d0(handler, businessFeedData, reply, comment, i3);
    }

    @Override // com.qzone.detail.ui.component.b
    public StickerBubbleAnimationView z8() {
        return null;
    }

    public static CommentListBaseController s(Activity activity, int i3) {
        return t(activity, i3, false);
    }

    private void s0() {
        CommentListLayout commentListLayout;
        this.f46894b0 = true;
        if (!this.Z || (commentListLayout = this.L) == null || commentListLayout.s()) {
            return;
        }
        Pd();
        this.Z = false;
    }

    private void z0() {
        A0 = null;
        B0 = null;
        com.qzone.proxy.feedcomponent.ui.detail.b bVar = this.f46909l0;
        if (bVar != null) {
            bVar.setData(null);
        }
    }

    void q0(Intent intent) {
        String str;
        if (intent == null) {
            QLog.e("CommentListBaseController", 1, "[onFinishCommentNew] data is null");
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e("CommentListBaseController", 1, "[onFinishCommentNew] bean isNot QZoneCommentPanelResultBean");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        BusinessFeedData Q = Q(qZoneCommentPanelResultBean);
        if (Q == null) {
            QLog.e("CommentListBaseController", 1, "[onFinishCommentNew] feedData is null");
            return;
        }
        Map<Integer, String> map = Q.getOperationInfo().busiParam;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.f46898e == 4) {
            str = map.get(12);
        } else {
            str = this.f46903h;
        }
        long j3 = Q.getUser().uin;
        if (this.f46898e == 334) {
            j3 = this.f46896d;
        }
        Map<String, String> a16 = qZoneCommentPanelResultBean.a();
        a16.put("is_from_comment_float", "1");
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45712e = Q.getFeedCommInfo().appid;
        lVar.f45718k = map;
        lVar.f45715h = qZoneCommentPanelResultBean.getInputContent();
        lVar.f45716i = qZoneCommentPanelResultBean.getCacheUniKey();
        lVar.f45710c = UUID.randomUUID().toString();
        lVar.f45709b = Q.getFeedCommInfo().feedskey;
        lVar.f45711d = Q.getFeedCommInfo().clientkey;
        lVar.f45725r = qZoneCommentPanelResultBean.getIsCheckedPrivateIcon();
        lVar.f45724q = false;
        lVar.f45720m = null;
        lVar.f45713f = j3;
        lVar.f45722o = this.f46905i;
        lVar.f45714g = str;
        lVar.f45708a = Q.getFeedCommInfo().ugckey;
        lVar.f45726s = qZoneCommentPanelResultBean.g();
        lVar.f45727t = 2;
        lVar.f45723p = qZoneCommentPanelResultBean.getPosition();
        lVar.f45730w = a16;
        lVar.f45728u = 2;
        lVar.f45729v = this.C;
        if (!qZoneCommentPanelResultBean.getIsEmoRapidComment()) {
            x(lVar);
        } else {
            C(lVar, qZoneCommentPanelResultBean.getRapidCommentInfo());
        }
        y0(34, 7);
    }

    public void w0() {
        this.f46894b0 = false;
        if (m0()) {
            QZLog.w("CommentListBaseController", "----network not link.");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 157;
        S().removeMessages(157);
        S().sendMessageDelayed(obtain, 500L);
        if (!this.W && H().getCount() + K().getCount() == 0 && B0 == null) {
            this.L.x(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f46932a;

        b(Comment comment) {
            this.f46932a = comment;
        }

        @Override // com.qzone.widget.util.b.d
        public void a() {
            LpReportInfo_pf00064.report(129, 7);
            Activity activity = CommentListBaseController.this.E;
            Comment comment = this.f46932a;
            vo.c.E(activity, comment.user.uin, QZoneFeedUtil.n(comment));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements AbsListView.OnScrollListener {
        i() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0 && CommentListBaseController.this.N.getLastVisiblePosition() >= (CommentListBaseController.this.N.getCount() - CommentListBaseController.this.N.getHeaderViewsCount()) - 1) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("CommentListBaseController", 4, "---getMoreComment");
                }
                CommentListBaseController.this.V();
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }

    private void I0(View view, Comment comment, Reply reply, int i3) {
        String str;
        if (reply != null) {
            str = X(reply.user);
            this.R = reply.user;
        } else if (comment != null) {
            str = X(comment.user);
            this.R = comment.user;
        } else {
            str = "";
        }
        int i16 = comment != null ? comment.isPrivate : true ? 1 : -1;
        BusinessFeedData R = T0().R();
        CommentReplyParam commentReplyParam = new CommentReplyParam();
        String str2 = comment != null ? comment.commentid : null;
        commentReplyParam.setCommentID(str2);
        commentReplyParam.setReplyID(reply != null ? reply.replyId : null);
        H0(cd.c.b(R, str2).y(1208).q(str).v(i3).A(i16).h(commentReplyParam).getParams(), R);
        this.f46913o0 = o(view);
    }

    private BusinessFeedData Q(QZoneCommentPanelResultBean qZoneCommentPanelResultBean) {
        if (qZoneCommentPanelResultBean == null) {
            QLog.e("CommentListBaseController", 1, "[getDetailFeedData] commentResult is null");
            return null;
        }
        BusinessFeedData W = T0().W(qZoneCommentPanelResultBean.getAutoSaveUgcKey(), qZoneCommentPanelResultBean.getCacheFeedsKey());
        if (W != null) {
            return W;
        }
        if (T0().c0() == null) {
            QLog.e("CommentListBaseController", 1, "[getDetailFeedData] getSourceCurrentDetailData is null");
            return null;
        }
        return T0().c0();
    }

    private static String X(User user) {
        if (user != null) {
            return com.qzone.util.l.a(R.string.kt8) + user.nickName + ":";
        }
        return com.qzone.util.l.a(R.string.kt_) + " :";
    }

    private void Z(QZoneResult qZoneResult) {
        if (qZoneResult != null) {
            if (!qZoneResult.getSucceed()) {
                String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDetailCommentReplyDelFail", "\u5220\u9664\u5931\u8d25");
                if (!TextUtils.isEmpty(qZoneResult.getMessage())) {
                    config = qZoneResult.getMessage();
                }
                ToastUtil.r(config);
                return;
            }
            Bundle bundle = qZoneResult.getBundle();
            if (bundle != null && bundle.getBoolean(QZoneResult.KEY_IS_DEL_COMMENT)) {
                G(7, 1);
            } else {
                G(24, 1);
            }
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public void k3(View view, Object obj) {
        if (obj == null || !(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        Object obj2 = bundle.get("position");
        Object obj3 = bundle.get("commenttype");
        if (obj2 == null || !(obj2 instanceof Integer) || obj3 == null || !(obj3 instanceof Integer)) {
            return;
        }
        F0(((Integer) obj3).intValue(), ((Integer) obj2).intValue());
    }

    @Override // com.qzone.detail.ui.component.b
    public void pc(View view, Comment comment, Reply reply, int i3, int i16) {
        if (comment == null || T0() == null) {
            return;
        }
        this.R = comment.user;
        BusinessFeedData R = T0().R();
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = R.getFeedCommInfo().appid;
        kVar.f45702i = R.getOperationInfo().busiParam;
        kVar.f45697d = R.getFeedCommInfo().feedskey;
        kVar.f45696c = R.getFeedCommInfo().ugckey;
        kVar.f45698e = R.getFeedCommInfo().orglikekey;
        kVar.f45694a = R.getUser().uin;
        kVar.f45699f = comment.commentLikekey;
        kVar.f45703j = comment.commentid;
        kVar.f45700g = !comment.isliked;
        kVar.f45695b = comment.user;
        kVar.f45706m = R.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
        kVar.f45707n = 1;
        B(S(), kVar);
        if (kVar.f45700g) {
            y0(34, 9);
        } else {
            y0(34, 10);
        }
    }

    private void c0(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("CommentListBaseController", 1, "---onServiceResult MSG_WRITE_COMMENT_FINISH");
        }
        if (qZoneResult.getSucceed()) {
            if (this.f46907j0) {
                ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentSuccess", "\u8bc4\u8bba\u6210\u529f"));
            }
            G(7, 0);
            S().post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.10
                @Override // java.lang.Runnable
                public void run() {
                    if (CommentListBaseController.this.T0().R() != null) {
                        if (CommentListBaseController.this.T0().R().getCommentInfo() != null) {
                            CommentListBaseController.this.H().setData(CommentListBaseController.this.T0().R().getCommentInfo().commments);
                        }
                        if (CommentListBaseController.this.T0().R().getCommentEssence() != null) {
                            CommentListBaseController.this.K().setData(CommentListBaseController.this.T0().R().getCommentEssence().commments);
                        }
                    }
                    CommentListBaseController.this.M0();
                    CommentListBaseController.this.U().notifyDataSetChanged();
                    if (CommentListBaseController.this.f46901f0) {
                        CommentListBaseController.this.I().notifyDataSetChanged();
                    }
                }
            });
            try {
                S().postDelayed(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        CommentListBaseController.this.N.j0().setSelection(0);
                    }
                }, 400L);
            } catch (Exception e16) {
                QZLog.w("CommentListBaseController", "catch an exception:" + Log.getStackTraceString(e16));
            }
            n nVar = this.f46924z0;
            if (nVar != null) {
                nVar.c();
                return;
            }
            return;
        }
        QZLog.w("CommentListBaseController", "handleWriteCommentFinish: comment failed,errCode:" + qZoneResult.getReturnCode() + "errMsg:" + qZoneResult.getMessage());
        ToastUtil.r(qZoneResult.getMessage());
    }

    private void d0(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("CommentListBaseController", 1, "---onServiceResult MSG_WRITE_REPLAY_FINISH");
        }
        if (qZoneResult.getSucceed()) {
            if (this.f46907j0) {
                ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastReplySuccess", "\u56de\u590d\u6210\u529f"));
            }
            G(24, 0);
            S().post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.9
                @Override // java.lang.Runnable
                public void run() {
                    if (CommentListBaseController.this.T0().R() != null) {
                        if (CommentListBaseController.this.T0().R().getCommentInfo() != null) {
                            CommentListBaseController.this.H().setData(CommentListBaseController.this.T0().R().getCommentInfo().commments);
                        }
                        if (CommentListBaseController.this.T0().R().getCommentEssence() != null) {
                            CommentListBaseController.this.K().setData(CommentListBaseController.this.T0().R().getCommentEssence().commments);
                        }
                    }
                    CommentListBaseController.this.M0();
                    CommentListBaseController.this.U().notifyDataSetChanged();
                    if (CommentListBaseController.this.f46901f0) {
                        CommentListBaseController.this.I().notifyDataSetChanged();
                    }
                }
            });
            n nVar = this.f46924z0;
            if (nVar != null) {
                nVar.c();
                return;
            }
            return;
        }
        ToastUtil.r(qZoneResult.getMessage());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F(int i3) {
        int i16;
        String valueOf;
        String valueOf2;
        if (this.T == null) {
            return;
        }
        int i17 = 4;
        int i18 = i3 != 999905 ? i3 != 999907 ? 0 : 3 : 4;
        if (i18 <= 0) {
            return;
        }
        LbsDataV2.GpsInfo a16 = com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).a();
        long j3 = this.T.getUser() != null ? this.T.getUser().uin : 0L;
        if (this.T.getCellLive() != null) {
            i17 = 5;
        } else if (this.T.getVideoInfo() == null) {
            i16 = 0;
            if (a16 != null) {
                if (!com.qzone.reborn.configx.g.f53821a.b().q()) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.14
                        @Override // java.lang.Runnable
                        public void run() {
                            com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).f();
                        }
                    });
                } else {
                    QLog.e("QZoneRequest", 2, "disable silent locate in CommentListBaseController");
                }
                valueOf = "";
                valueOf2 = valueOf;
            } else {
                valueOf = String.valueOf((a16.lat * 1.0d) / 1000000.0d);
                valueOf2 = String.valueOf((a16.lon * 1.0d) / 1000000.0d);
            }
            LpReportManager.getInstance().reportToDC01691(new LpReportInfo_DC01691(3, i18, 0, j3, this.T.getFeedCommInfo().ugckey, i16, valueOf, valueOf2), false, false);
        }
        i16 = i17;
        if (a16 != null) {
        }
        LpReportManager.getInstance().reportToDC01691(new LpReportInfo_DC01691(3, i18, 0, j3, this.T.getFeedCommInfo().ugckey, i16, valueOf, valueOf2), false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        F(qZoneResult.what);
        switch (qZoneResult.what) {
            case 999900:
                QZLog.i("CommentListBaseController", 1, "---onServiceResult MSG_DETAIL_GET_DATA_COMPLETE");
                this.L.x(false);
                v0(qZoneResult);
                return;
            case 999905:
                c0(qZoneResult);
                return;
            case 999907:
                d0(qZoneResult);
                return;
            case 999927:
                b0(qZoneResult);
                return;
            case 999978:
                Z(qZoneResult);
                return;
            case 1000144:
                a0(qZoneResult);
                return;
            default:
                return;
        }
    }

    private Comment N(QZoneCommentPanelResultBean qZoneCommentPanelResultBean, BusinessFeedData businessFeedData) {
        if (qZoneCommentPanelResultBean == null) {
            QLog.e("CommentListBaseController", 1, "[onFinishReplyNew] getCurrentDetailComment null");
            return null;
        }
        int position = qZoneCommentPanelResultBean.getPosition();
        Comment comment = A0;
        if (comment != null || (this.f46913o0 && (comment = B0) != null)) {
            return comment;
        }
        if (this.S == 1) {
            if (businessFeedData.getCommentEssence() == null || businessFeedData.getCommentEssence().commments == null || position >= businessFeedData.getCommentEssence().commments.size() || businessFeedData.getCommentEssence().commments.get(position) == null) {
                return null;
            }
            return businessFeedData.getCommentEssence().commments.get(position);
        }
        if (businessFeedData.getCommentInfo() == null || businessFeedData.getCommentInfo().commments == null || position >= businessFeedData.getCommentInfo().commments.size() || businessFeedData.getCommentInfo().commments.get(position) == null) {
            return null;
        }
        return businessFeedData.getCommentInfo().commments.get(position);
    }

    private boolean n(Comment comment, int i3) {
        if (comment != null && comment.commentType == 0) {
            this.S = 0;
            if (T0() == null || T0().R() == null || T0().R().getCommentInfo() == null || T0().R().getCommentInfo().commments == null || i3 > T0().R().getCommentInfo().commments.size() - 1) {
                return false;
            }
        } else if (comment != null && comment.commentType == 1) {
            this.S = 1;
            if (T0() == null || T0().R() == null || T0().R().getCommentEssence() == null || T0().R().getCommentEssence().commments == null || i3 > T0().R().getCommentEssence().commments.size() - 1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qzone.detail.ui.component.b
    public void ih(View view, Comment comment, Reply reply, int i3, int i16, int i17) {
        QZoneDetailService qZoneDetailService;
        if (comment == null || reply == null || (qZoneDetailService = this.J) == null) {
            return;
        }
        this.R = comment.user;
        BusinessFeedData R = qZoneDetailService.R();
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = R.getFeedCommInfo().appid;
        kVar.f45702i = R.getOperationInfo().busiParam;
        kVar.f45697d = R.getFeedCommInfo().feedskey;
        kVar.f45696c = R.getFeedCommInfo().ugckey;
        kVar.f45698e = R.getFeedCommInfo().orglikekey;
        kVar.f45694a = R.getUser().uin;
        kVar.f45704k = reply.replyId;
        kVar.f45699f = reply.replyLikeKey;
        kVar.f45703j = comment.commentid;
        kVar.f45700g = !reply.isliked;
        kVar.f45695b = reply.user;
        kVar.f45705l = 2;
        kVar.f45706m = R.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
        kVar.f45707n = 1;
        QZoneWriteOperationService.v0().v1(S(), kVar);
    }

    private boolean o(View view) {
        Object tag;
        if (view == null || (tag = view.getTag(R.id.jam)) == null || !(tag instanceof Boolean)) {
            return false;
        }
        return ((Boolean) tag).booleanValue();
    }

    void r0(Intent intent) {
        String str;
        String str2;
        CommentListBaseController commentListBaseController;
        User user;
        try {
            if (intent == null) {
                QLog.e("CommentListBaseController", 1, "[onFinishReplyNew] data is null");
                return;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
            if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
                QLog.e("CommentListBaseController", 1, "[onFinishReplyNew] bean isNot QZoneCommentPanelResultBean");
                return;
            }
            QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
            BusinessFeedData Q = Q(qZoneCommentPanelResultBean);
            if (Q == null) {
                QLog.e("CommentListBaseController", 1, "[onFinishReplyNew] feedData is null");
                return;
            }
            Comment N = N(qZoneCommentPanelResultBean, Q);
            long j3 = 0;
            if (N != null && (user = N.user) != null) {
                j3 = user.uin;
            }
            long j16 = j3;
            Map<Integer, String> map = Q.getOperationInfo().busiParam;
            if (map == null) {
                map = new HashMap<>();
            }
            Map<Integer, String> map2 = map;
            if (this.f46898e == 4) {
                str2 = map2.get(12);
            } else {
                str2 = this.f46903h;
            }
            String str3 = str2;
            Map<String, String> a16 = qZoneCommentPanelResultBean.a();
            try {
                if (this.f46898e == 334 || N == null) {
                    str = "CommentListBaseController";
                    QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
                    lVar.f45708a = Q.getFeedCommInfo().ugckey;
                    lVar.f45709b = Q.getFeedCommInfo().feedskey;
                    lVar.f45708a = UUID.randomUUID().toString();
                    lVar.f45712e = Q.getFeedCommInfo().appid;
                    commentListBaseController = this;
                    try {
                        lVar.f45713f = commentListBaseController.f46896d;
                        lVar.f45714g = str3;
                        lVar.f45715h = qZoneCommentPanelResultBean.getInputContent();
                        lVar.f45716i = qZoneCommentPanelResultBean.getCacheUniKey();
                        lVar.f45718k = map2;
                        lVar.f45724q = false;
                        lVar.f45730w = a16;
                        commentListBaseController.x(lVar);
                    } catch (Exception e16) {
                        e = e16;
                        QZLog.e(str, "onFinishReply catch an exception.", e);
                        return;
                    }
                } else {
                    try {
                        Handler S = S();
                        String str4 = Q.getFeedCommInfo().ugckey;
                        String str5 = Q.getFeedCommInfo().feedskey;
                        String uuid = UUID.randomUUID().toString();
                        int i3 = Q.getFeedCommInfo().appid;
                        try {
                            long j17 = Q.getUser().uin;
                            User user2 = this.R;
                            String str6 = this.C;
                            String str7 = N.commentid;
                            StringBuilder sb5 = new StringBuilder();
                            User user3 = this.R;
                            sb5.append(u.a(user3.uin, user3.nickName));
                            sb5.append(qZoneCommentPanelResultBean.getInputContent());
                            str = "CommentListBaseController";
                            E(S, str4, str5, uuid, i3, j17, j16, user2, str3, str6, str7, sb5.toString(), qZoneCommentPanelResultBean.getInputContent(), qZoneCommentPanelResultBean.getCacheUniKey(), 0, map2, "picture_viewer", false, qZoneCommentPanelResultBean.getPosition(), 2, a16);
                            commentListBaseController = this;
                        } catch (Exception e17) {
                            e = e17;
                            str = "CommentListBaseController";
                            QZLog.e(str, "onFinishReply catch an exception.", e);
                            return;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str = "CommentListBaseController";
                    }
                }
                commentListBaseController.y0(34, 7);
            } catch (Exception e19) {
                e = e19;
            }
        } catch (Exception e26) {
            e = e26;
            str = "CommentListBaseController";
        }
    }

    public static CommentListBaseController t(Activity activity, int i3, boolean z16) {
        if (i3 == 1) {
            return new com.qzone.detail.ui.comment.a(activity);
        }
        if (i3 != 2) {
            return new CommentListBaseController(activity, z16);
        }
        return new CommentListBaseController(activity, z16);
    }

    public void n0(final int i3, final int i16, final Intent intent) {
        if ((i3 == 1207 || i3 == 1208) && this.f46914p0) {
            n nVar = this.f46924z0;
            if (nVar != null) {
                nVar.b();
            }
            S().postDelayed(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.16
                @Override // java.lang.Runnable
                public void run() {
                    CommentListBaseController.this.f46914p0 = false;
                    CommentListBaseController.this.M().setVisible(true);
                }
            }, 100L);
        }
        if (i16 == 0) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListBaseController.17
            @Override // java.lang.Runnable
            public void run() {
                Intent intent2;
                if (i16 != -1 || (intent2 = intent) == null) {
                    return;
                }
                int i17 = i3;
                if (i17 == 1207) {
                    CommentListBaseController.this.q0(intent2);
                } else {
                    if (i17 != 1208) {
                        return;
                    }
                    CommentListBaseController.this.r0(intent2);
                }
            }
        });
    }

    public boolean x0(BusinessFeedData businessFeedData) {
        String str;
        boolean z16;
        if (businessFeedData == null) {
            return false;
        }
        if (businessFeedData.getUser() == null || (businessFeedData.getUser().uin == 0 && !businessFeedData.isAdFeeds())) {
            return false;
        }
        p();
        if (!this.V) {
            return false;
        }
        QZLog.i("CommentListBaseController", 1, "--do render");
        this.T = businessFeedData;
        QZLog.i("CommentListBaseController", 1, "carlzhao render detail comment");
        this.f46922x0 = businessFeedData.getCommentInfo();
        this.f46923y0 = businessFeedData.getCommentEssence();
        r6.a.o().r(this.E, S(), this.f46896d, "", false, -1, this.f46903h, this.f46900f, businessFeedData.getUser().uin, businessFeedData);
        R().D0(businessFeedData);
        if (businessFeedData.getCellUserInfo().getUser() != null && !TextUtils.isEmpty(businessFeedData.getCellUserInfo().getUser().qzoneDesc)) {
            try {
                JSONObject jSONObject = new JSONObject(businessFeedData.getCellUserInfo().getUser().qzoneDesc);
                businessFeedData.getCellUserInfo().getUser().qzoneDesc = "{url:" + URLDecoder.decode(jSONObject.optString("url"), "UTF-8") + ",text:" + jSONObject.optString("text") + "}";
            } catch (Exception e16) {
                str = "CommentListBaseController";
                QZLog.e(str, ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, e16);
            }
        }
        str = "CommentListBaseController";
        H().setData(businessFeedData.getCommentInfo().commments);
        if (businessFeedData.getCommentEssence() != null) {
            K().setData(businessFeedData.getCommentEssence().commments);
        }
        if (businessFeedData.getCommentEssence() != null && businessFeedData.getCommentEssence().commentNum != 0) {
            z16 = true;
            H().setShowHeader(true);
            K().setShowHeader(true);
        } else {
            z16 = true;
            H().setShowHeader(false);
            K().setShowHeader(false);
        }
        M0();
        this.L.x(false);
        int i3 = this.f46898e;
        if (i3 == 2) {
            QZLog.w(str, "---render AppidConsts.BLOG");
        } else if (i3 == 334) {
            H().setIsReplyVisible(false);
            K().setIsReplyVisible(false);
            QZLog.w(str, "---render AppidConsts.MESSAGE");
        }
        if (this.f46901f0) {
            this.N.setVisibility(4);
            K0();
        } else {
            this.N.setVisibility(0);
        }
        U().notifyDataSetChanged();
        if (!this.f46901f0) {
            M().setCommentNum(L());
        }
        EventCenter.getInstance().post("Feed", 20);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements QZonePullToRefreshListView.c {
        g() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            CommentListBaseController.this.w0();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements QZonePullToRefreshListView.c {
        h() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            CommentListBaseController.this.w0();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public void Fc() {
    }

    @Override // com.qzone.detail.ui.component.b
    public void If(View view) {
    }

    @Override // com.qzone.detail.ui.component.b
    public void Y3() {
    }

    @Override // com.qzone.detail.ui.component.b
    public void m1() {
    }

    @Override // com.qzone.detail.ui.component.b
    public void zg(View view) {
    }

    CommentListBaseController(Activity activity, boolean z16) {
        this(activity);
        this.Y = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(Handler handler, String str, String str2, String str3, int i3, long j3, long j16, User user, String str4, String str5, String str6, String str7, String str8, String str9, int i16, Map<Integer, String> map, String str10, boolean z16, int i17, int i18, Map<String, String> map2) {
        QZoneWriteOperationService.v0().c2(handler, str, str2, str3, i3, j3, j16, user, str4, str5, str6, str7, str8, str9, i16, map, str10, z16, i17, i18, map2);
    }

    @Override // com.qzone.detail.ui.component.b
    public void q4(View view, Object obj) {
    }

    @Override // com.qzone.detail.ui.component.b
    public void V7(View view, BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.detail.ui.component.b
    public void Ee(View view, BusinessFeedData businessFeedData, int i3, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData, int i16) {
    }

    @Override // com.qzone.detail.ui.component.b
    public void m2(View view, BusinessFeedData businessFeedData, FeedElement feedElement, int i3, Object obj) {
    }
}
