package com.qzone.detail.ui.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.CustomListViewActivity;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.module.feedcomponent.ui.AudioFeedBubble;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentEssence;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.w;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.util.u;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.util.b;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneCommentDetailActivity extends CustomListViewActivity implements IObserver.main, com.qzone.detail.ui.component.b {

    /* renamed from: t1, reason: collision with root package name */
    private static String f46845t1 = "getdetail";

    /* renamed from: u1, reason: collision with root package name */
    private static String f46846u1 = l.a(R.string.rpc);

    /* renamed from: v1, reason: collision with root package name */
    public static Comment f46847v1;

    /* renamed from: w1, reason: collision with root package name */
    public static QZoneDetailService f46848w1;
    private QZonePullToRefreshListView Y0;
    public com.qzone.detail.ui.component.d Z0;

    /* renamed from: a1, reason: collision with root package name */
    private com.qzone.proxy.feedcomponent.ui.detail.b f46849a1;

    /* renamed from: b1, reason: collision with root package name */
    private QZoneDetailService f46850b1;

    /* renamed from: c1, reason: collision with root package name */
    private ArrayList<Comment> f46851c1;

    /* renamed from: d1, reason: collision with root package name */
    public long f46852d1;

    /* renamed from: e1, reason: collision with root package name */
    public int f46853e1;

    /* renamed from: f1, reason: collision with root package name */
    public String f46854f1;

    /* renamed from: g1, reason: collision with root package name */
    public int f46855g1;

    /* renamed from: h1, reason: collision with root package name */
    public int f46856h1;

    /* renamed from: i1, reason: collision with root package name */
    private boolean f46857i1;

    /* renamed from: l1, reason: collision with root package name */
    public ActionSheet f46860l1;

    /* renamed from: q1, reason: collision with root package name */
    private String f46865q1;

    /* renamed from: r1, reason: collision with root package name */
    public User f46866r1;

    /* renamed from: j1, reason: collision with root package name */
    private boolean f46858j1 = false;

    /* renamed from: k1, reason: collision with root package name */
    private boolean f46859k1 = false;

    /* renamed from: m1, reason: collision with root package name */
    private int f46861m1 = 0;

    /* renamed from: n1, reason: collision with root package name */
    private Comment f46862n1 = null;

    /* renamed from: o1, reason: collision with root package name */
    private Reply f46863o1 = null;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f46864p1 = false;

    /* renamed from: s1, reason: collision with root package name */
    private ActionSheet.OnButtonClickListener f46867s1 = new c();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QzoneCommentDetailActivity.this.Z0 != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", 0);
                bundle.putInt("commenttype", QzoneCommentDetailActivity.this.f46856h1);
                QzoneCommentDetailActivity.this.Z0.onClick(view, FeedElement.REPLY_BUTTON, 0, bundle);
                LpReportInfo_pf00064.allReport(209, 3, 12);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f46874d;

        d(CellTextView.OnTextOperater onTextOperater) {
            this.f46874d = onTextOperater;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView.OnTextOperater onTextOperater = this.f46874d;
            if (onTextOperater != null) {
                onTextOperater.onCancle();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView.OnTextOperater onTextOperater = this.f46874d;
            if (onTextOperater != null) {
                onTextOperater.onCopy();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f46876a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Reply f46877b;

        e(Comment comment, Reply reply) {
            this.f46876a = comment;
            this.f46877b = reply;
        }

        @Override // com.qzone.widget.util.b.e
        public void a() {
            QzoneCommentDetailActivity.this.D4(1, this.f46876a, this.f46877b).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f46879d;

        f(CellTextView.OnTextOperater onTextOperater) {
            this.f46879d = onTextOperater;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView.OnTextOperater onTextOperater = this.f46879d;
            if (onTextOperater != null) {
                onTextOperater.onCancle();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView.OnTextOperater onTextOperater = this.f46879d;
            if (onTextOperater != null) {
                onTextOperater.onCopy();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f46883a;

        h(Comment comment) {
            this.f46883a = comment;
        }

        @Override // com.qzone.widget.util.b.e
        public void a() {
            QzoneCommentDetailActivity.this.D4(0, this.f46883a, null).show();
        }
    }

    private Comment B4() {
        CellCommentEssence commentEssence;
        ArrayList<Comment> arrayList;
        ArrayList<Comment> arrayList2;
        if (this.f46850b1.R() == null) {
            return null;
        }
        int i3 = this.f46856h1;
        if (i3 == 0) {
            CellCommentInfo commentInfo = this.f46850b1.R().getCommentInfo();
            if (commentInfo == null || (arrayList2 = commentInfo.commments) == null || this.f46855g1 > arrayList2.size() - 1) {
                return null;
            }
            return commentInfo.commments.get(this.f46855g1);
        }
        if (i3 != 1 || (commentEssence = this.f46850b1.R().getCommentEssence()) == null || (arrayList = commentEssence.commments) == null || this.f46855g1 > arrayList.size() - 1) {
            return null;
        }
        return commentEssence.commments.get(this.f46855g1);
    }

    private void C4() {
        this.f46851c1 = new ArrayList<>();
        this.f46850b1 = f46848w1;
        this.f46852d1 = getIntent().getLongExtra("uin", 0L);
        this.f46853e1 = getIntent().getIntExtra("appid", 0);
        this.f46854f1 = getIntent().getStringExtra(s4.c.CELLID);
        this.f46855g1 = getIntent().getIntExtra("position", 0);
        this.f46856h1 = getIntent().getIntExtra("commentType", 0);
        this.f46857i1 = getIntent().getBooleanExtra("fromThoseYear", false);
        Comment comment = f46847v1;
        if (comment != null) {
            this.f46851c1.add(comment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H4(Reply reply, Comment comment, View view) {
        if (view.getId() == R.id.n0y) {
            String str = reply != null ? reply.content : null;
            if (TextUtils.isEmpty(str)) {
                str = comment != null ? comment.comment : null;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i.H().s(TextCellParser.toPlainText(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I4() {
        if (NetworkState.isNetSupport()) {
            return false;
        }
        BaseActivity.toast(R.string.ghi);
        return true;
    }

    private void L4(BaseAdapter baseAdapter) {
        if (this.Y0.j0() == null) {
            return;
        }
        this.Y0.j0().setAdapter((ListAdapter) baseAdapter);
    }

    private void w4() {
        EventCenter.getInstance().addUIObserver(this, "Detail", 1);
    }

    private void x4() {
        EventCenter.getInstance().removeObserver(this);
    }

    private BaseAdapter y4() {
        if (this.L0 == null) {
            this.L0 = z4();
        }
        return this.L0;
    }

    public ActionSheet D4(int i3, Comment comment, Reply reply) {
        this.f46861m1 = i3;
        this.f46862n1 = comment;
        this.f46863o1 = reply;
        if (this.f46860l1 == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(this, R.string.gda), 0, 0, 2));
            ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(this, arrayList, this.f46867s1);
            this.f46860l1 = createActionSheet;
            createActionSheet.addCancelButton(R.string.cancel);
        }
        ActionSheetHelper.showActionSheet(this, this.f46860l1);
        return this.f46860l1;
    }

    public com.qzone.detail.ui.component.d E4() {
        if (this.Z0 == null) {
            F4();
        }
        return this.Z0;
    }

    protected void F4() {
        this.Z0 = new com.qzone.detail.ui.component.d(this, this);
    }

    public void N4(e.a aVar, Serializable serializable, Parcelable parcelable) {
        int i3;
        aVar.f47477j = this.f46850b1.R().getFeedCommInfo().ugckey;
        BusinessFeedData S = this.f46850b1.S();
        boolean z16 = false;
        boolean isFeedCommentInsertImage = S != null ? S.isFeedCommentInsertImage() : false;
        aVar.f47481n = QZoneFeedUtil.l(S, 17);
        Intent F = QZoneFeedUtil.F(this, aVar, serializable, parcelable, null, true, 3);
        if (TextUtils.isEmpty(aVar.f47470c) && FeedActionPanelActivity.v4(S)) {
            z16 = true;
        }
        F.putExtra("show_barrage_effect_icon", z16);
        if (isFeedCommentInsertImage) {
            i3 = FeedActionPanelActivity.M1;
        } else {
            i3 = FeedActionPanelActivity.L1;
        }
        F.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SHOW_PICCOMMENT, i3);
        com.qzone.feed.utils.b.f(this, F, aVar.f47476i);
    }

    @Override // com.qzone.detail.ui.component.b
    public void Pd() {
        int i3;
        int i16 = FeedActionPanelActivity.I1;
        BusinessFeedData S = this.f46850b1.S();
        if (S.isHideSecretComment()) {
            i3 = FeedActionPanelActivity.I1;
        } else {
            i3 = FeedActionPanelActivity.J1;
        }
        if (S.getFeedCommInfo() != null) {
            int x46 = FeedActionPanelActivity.x4(S);
            QZoneDetailService.DetailFeedDataKeys detailFeedDataKeys = new QZoneDetailService.DetailFeedDataKeys(S.getFeedCommInfo().ugckey, S.getFeedCommInfo().feedskey);
            e.a aVar = new e.a();
            aVar.f47468a = "";
            aVar.f47469b = "";
            aVar.f47470c = null;
            aVar.f47471d = null;
            aVar.f47472e = x46;
            aVar.f47475h = i3;
            aVar.f47476i = 1207;
            aVar.f47477j = "";
            aVar.f47478k = false;
            N4(aVar, 0, ParcelableWrapper.obtain(detailFeedDataKeys));
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public QZoneDetailService T0() {
        if (this.f46850b1 == null) {
            synchronized (this) {
                if (this.f46850b1 == null) {
                    this.f46850b1 = new QZoneDetailService();
                }
            }
        }
        return this.f46850b1;
    }

    @Override // com.qzone.detail.ui.component.b
    public void Ye(View view, Comment comment, CellTextView.OnTextOperater onTextOperater) {
        User user;
        f fVar = new f(onTextOperater);
        g gVar = (comment == null || QZoneFeedUtil.n(comment) == null) ? null : new g(comment);
        if (!this.f46850b1.R().getLocalInfo().canDelComment) {
            M4(view, comment, null);
            return;
        }
        BusinessFeedData R = this.f46850b1.R();
        if (comment == null || (user = comment.user) == null) {
            M4(view, comment, null);
            return;
        }
        if (user.uin != LoginData.getInstance().getUin() && R.getUser().uin != LoginData.getInstance().getUin()) {
            M4(view, comment, null);
        } else if (this.f46853e1 == 334 && comment.user.uin != LoginData.getInstance().getUin() && !this.f46858j1) {
            M4(view, comment, null);
        } else {
            com.qzone.widget.util.b.k(this, fVar, new h(comment), null, gVar, null);
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public int cg() {
        return -1;
    }

    @Override // com.qzone.detail.ui.component.b
    public int getAppid() {
        return this.f46853e1;
    }

    public String getBusinessId() {
        int i3 = this.f46853e1;
        int i16 = 2;
        if (i3 == 2) {
            i16 = 3;
        } else if (i3 != 4) {
            i16 = i3 != 202 ? i3 != 311 ? 0 : 1 : 4;
        }
        return i16 + "";
    }

    @Override // com.qzone.detail.ui.component.b
    public void ih(View view, Comment comment, Reply reply, int i3, int i16, int i17) {
        List<Reply> list;
        Comment B4 = B4();
        if (B4 == null || (list = B4.replies) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() <= i16) {
            return;
        }
        Reply reply2 = (Reply) arrayList.get(i16);
        this.f46866r1 = B4.user;
        BusinessFeedData R = this.f46850b1.R();
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = R.getFeedCommInfo().appid;
        kVar.f45702i = R.getOperationInfo().busiParam;
        kVar.f45697d = R.getFeedCommInfo().feedskey;
        kVar.f45696c = R.getFeedCommInfo().ugckey;
        kVar.f45698e = R.getFeedCommInfo().orglikekey;
        kVar.f45694a = R.getUser().uin;
        kVar.f45704k = reply2.replyId;
        kVar.f45699f = reply2.replyLikeKey;
        kVar.f45703j = B4.commentid;
        kVar.f45700g = !reply2.isliked;
        kVar.f45695b = reply2.user;
        kVar.f45705l = 2;
        kVar.f45706m = R.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
        kVar.f45707n = 1;
        QZoneWriteOperationService.v0().v1(getHandler(), kVar);
        LpReportInfo_pf00064.allReport(209, 3, kVar.f45700g ? 6 : 7);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    protected boolean n3() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(final int i3, final int i16, final Intent intent) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.ui.activity.QzoneCommentDetailActivity.9
            @Override // java.lang.Runnable
            public void run() {
                Intent intent2;
                if (i16 == -1 && (intent2 = intent) != null && i3 == 1208) {
                    QzoneCommentDetailActivity.this.J4(intent2);
                }
            }
        });
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Comment comment;
        List<Reply> list;
        super.onCreate(bundle);
        setContentView(R.layout.bjg);
        setTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleCommentDetailActivity", "\u8bc4\u8bba\u8be6\u60c5"));
        C4();
        w4();
        QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) findViewById(R.id.elh);
        this.Y0 = qZonePullToRefreshListView;
        qZonePullToRefreshListView.setContentBackground(new ColorDrawable(getResources().getColor(R.color.qzone_skin_feed_background_color)));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, ar.e(42.0f)));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        this.Y0.addFooterView(linearLayout);
        BaseAdapter y46 = y4();
        this.L0 = y46;
        L4(y46);
        this.Y0.setSupportPullDown(false);
        this.Y0.setOnRefreshListener(new a());
        if (this.f46851c1 != null) {
            z4().setData(this.f46851c1);
            y4().notifyDataSetChanged();
            if (this.f46851c1.size() > 0 && this.f46851c1.get(0) != null && (list = (comment = this.f46851c1.get(0)).replies) != null && list.size() > 0) {
                setTitle(comment.replies.size() + f46846u1);
            }
        }
        ((TextView) findViewById(R.id.het)).setOnClickListener(new b());
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(659, 1, 0);
        lpReportInfo_pf00064.reserves2 = getBusinessId();
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f46847v1 = null;
        f46848w1 = null;
        x4();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Detail".equals(event.source.getName()) && event.what == 1) {
            Comment B4 = B4();
            if (B4 != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(B4);
                z4().setData(arrayList);
            }
            y4().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewActivity, com.qzone.common.activities.base.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (isFinishing()) {
            return;
        }
        onServiceResult(QZoneResult.unpack(message));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LpReportInfo_pf00064.allReport(209, 3, 1);
    }

    @Override // com.qzone.detail.ui.component.b
    public void p6(View view, Comment comment, Reply reply, int i3, int i16) {
        String str;
        User user;
        User user2;
        if (this.f46853e1 != 334 || this.f46858j1 || this.f46859k1) {
            if (i16 == 101 && comment != null && (user2 = comment.user) != null && user2.uin == LoginData.getInstance().getUin()) {
                D4(0, comment, reply).show();
                return;
            }
            if (i16 == 1 && comment != null && reply != null && (user = reply.user) != null && user.uin == LoginData.getInstance().getUin()) {
                D4(1, comment, reply).show();
                return;
            }
            if (reply != null) {
                if (reply.user != null) {
                    str = l.a(R.string.rp_) + reply.user.nickName + ":";
                } else {
                    str = l.a(R.string.rp7) + " :";
                }
                this.f46866r1 = reply.user;
            } else if (comment == null) {
                str = "";
            } else {
                if (comment.user != null) {
                    str = l.a(R.string.rpa) + comment.user.nickName + ":";
                } else {
                    str = l.a(R.string.rpd) + " :";
                }
                this.f46866r1 = comment.user;
            }
            boolean z16 = comment != null ? comment.isPrivate : true;
            int i17 = FeedActionPanelActivity.I1;
            if (z16) {
                i17 = FeedActionPanelActivity.K1;
            }
            BusinessFeedData R = this.f46850b1.R();
            if (R == null || R.getFeedCommInfo() == null) {
                return;
            }
            int x46 = FeedActionPanelActivity.x4(R);
            QZoneDetailService.DetailFeedDataKeys detailFeedDataKeys = new QZoneDetailService.DetailFeedDataKeys(R.getFeedCommInfo().ugckey, R.getFeedCommInfo().feedskey);
            e.a aVar = new e.a();
            aVar.f47468a = str;
            aVar.f47469b = "";
            aVar.f47470c = comment != null ? comment.commentid : null;
            aVar.f47471d = reply != null ? reply.replyId : null;
            aVar.f47472e = x46;
            aVar.f47475h = i17;
            aVar.f47476i = 1208;
            aVar.f47477j = "";
            aVar.f47478k = false;
            N4(aVar, Integer.valueOf(this.f46855g1), ParcelableWrapper.obtain(detailFeedDataKeys));
        }
    }

    @Override // com.qzone.detail.ui.component.b
    public void pc(View view, Comment comment, Reply reply, int i3, int i16) {
        Comment B4 = B4();
        if (B4 == null) {
            return;
        }
        this.f46866r1 = B4.user;
        BusinessFeedData R = this.f46850b1.R();
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = R.getFeedCommInfo().appid;
        kVar.f45702i = R.getOperationInfo().busiParam;
        kVar.f45697d = R.getFeedCommInfo().feedskey;
        kVar.f45696c = R.getFeedCommInfo().ugckey;
        kVar.f45698e = R.getFeedCommInfo().orglikekey;
        kVar.f45694a = R.getUser().uin;
        kVar.f45699f = B4.commentLikekey;
        kVar.f45703j = B4.commentid;
        kVar.f45700g = !B4.isliked;
        kVar.f45695b = B4.user;
        kVar.f45705l = 2;
        kVar.f45706m = R.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
        kVar.f45707n = 1;
        QZoneWriteOperationService.v0().t1(getHandler(), kVar);
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(659, 2, kVar.f45700g ? 1 : 2), false, false);
        LpReportInfo_pf00064.allReport(209, 3, kVar.f45700g ? 4 : 5);
    }

    @Override // com.qzone.detail.ui.component.b
    public void q5(View view, Comment comment, Reply reply, CellTextView.OnTextOperater onTextOperater) {
        BusinessFeedData R = this.f46850b1.R();
        d dVar = new d(onTextOperater);
        if (comment == null || reply == null) {
            M4(view, comment, reply);
        } else if (reply.user.uin != LoginData.getInstance().getUin() && R.getUser().uin != LoginData.getInstance().getUin()) {
            M4(view, comment, reply);
        } else {
            com.qzone.widget.util.b.k(this, dVar, new e(comment, reply), null, null, null);
        }
    }

    public com.qzone.proxy.feedcomponent.ui.detail.b z4() {
        if (this.f46849a1 == null) {
            com.qzone.proxy.feedcomponent.ui.detail.b createFeedCommentDetailAdapter = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().createFeedCommentDetailAdapter(this, null, E4());
            this.f46849a1 = createFeedCommentDetailAdapter;
            createFeedCommentDetailAdapter.setNeedBackground(true);
            this.f46849a1.setShowHeader(false);
            this.f46849a1.setIsEssenceComment(false);
            this.f46849a1.setIsReplyVisible(true);
            this.f46849a1.setIsAbleToReply(true);
            this.f46849a1.setCommentLikeAble(true);
            this.f46849a1.setCommentLikeVisible(true);
            this.f46849a1.setEnableShrinkComment(false);
        }
        return this.f46849a1;
    }

    @Override // com.qzone.detail.ui.component.b
    public StickerBubbleAnimationView z8() {
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements ActionSheet.OnButtonClickListener {
        c() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QzoneCommentDetailActivity.this.simpleClassname, view);
            if (!QzoneCommentDetailActivity.this.I4()) {
                int i16 = QzoneCommentDetailActivity.this.f46861m1;
                if (i16 != 0) {
                    if (i16 == 1) {
                        if (QzoneCommentDetailActivity.this.f46863o1 != null) {
                            if (QzoneCommentDetailActivity.this.f46864p1) {
                                BusinessFeedData R = QzoneCommentDetailActivity.this.f46850b1.R();
                                QZoneWriteOperationService.v0().b0(((BaseActivity) QzoneCommentDetailActivity.this).handler, R.getUser().uin, R.getFeedCommInfo().ugckey, QzoneCommentDetailActivity.this.f46865q1, R.getPictureInfo().albumid, R.getOperationInfo().busiParam, QzoneCommentDetailActivity.this.f46863o1.replyId, QzoneCommentDetailActivity.this.f46862n1.commentid, QzoneCommentDetailActivity.this.f46862n1.isFake);
                            } else {
                                QZoneWriteOperationService.v0().d0(((BaseActivity) QzoneCommentDetailActivity.this).handler, QzoneCommentDetailActivity.this.f46850b1.R(), QzoneCommentDetailActivity.this.f46863o1, QzoneCommentDetailActivity.this.f46862n1, 0);
                            }
                        } else {
                            BaseActivity.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDetailReplyNotExist", "\u8be5\u6761\u56de\u590d\u4e0d\u5b58\u5728\u6216\u5df2\u88ab\u5220\u9664"), 3);
                        }
                    }
                } else if (QzoneCommentDetailActivity.this.f46862n1 != null) {
                    if (QzoneCommentDetailActivity.this.f46864p1) {
                        BusinessFeedData R2 = QzoneCommentDetailActivity.this.f46850b1.R();
                        QZoneWriteOperationService.v0().a0(((BaseActivity) QzoneCommentDetailActivity.this).handler, R2.getUser().uin, R2.getFeedCommInfo().ugckey, QzoneCommentDetailActivity.this.f46865q1, R2.getPictureInfo().albumid, R2.getOperationInfo().busiParam, QzoneCommentDetailActivity.this.f46862n1.commentid, QzoneCommentDetailActivity.this.f46862n1.isFake, 0);
                    } else {
                        QZoneWriteOperationService.v0().T(((BaseActivity) QzoneCommentDetailActivity.this).handler, QzoneCommentDetailActivity.this.f46850b1.R(), QzoneCommentDetailActivity.this.f46862n1);
                    }
                    QzoneCommentDetailActivity.this.finish();
                } else {
                    BaseActivity.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDetailCommentNotExist", "\u8be5\u6761\u8bc4\u8bba\u4e0d\u5b58\u5728\u6216\u5df2\u88ab\u5220\u9664"), 3);
                }
                QzoneCommentDetailActivity qzoneCommentDetailActivity = QzoneCommentDetailActivity.this;
                if (qzoneCommentDetailActivity.f46860l1 != null) {
                    ActionSheetHelper.dismissActionSheet(qzoneCommentDetailActivity.getActivity(), QzoneCommentDetailActivity.this.f46860l1);
                    return;
                }
                return;
            }
            QzoneCommentDetailActivity qzoneCommentDetailActivity2 = QzoneCommentDetailActivity.this;
            if (qzoneCommentDetailActivity2.f46860l1 != null) {
                ActionSheetHelper.dismissActionSheet(qzoneCommentDetailActivity2.getActivity(), QzoneCommentDetailActivity.this.f46860l1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f46881a;

        g(Comment comment) {
            this.f46881a = comment;
        }

        @Override // com.qzone.widget.util.b.d
        public void a() {
            LpReportInfo_pf00064.report(129, 7);
            BaseApplication context = BaseApplication.getContext();
            Comment comment = this.f46881a;
            vo.c.E(context, comment.user.uin, QZoneFeedUtil.n(comment));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G4(Comment comment) {
        if (comment != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(comment);
            z4().setData(arrayList);
            y4().notifyDataSetChanged();
        }
    }

    private void M4(View view, final Comment comment, final Reply reply) {
        if (view == null) {
            QLog.e("QzoneCommentDetailActivity", 1, "onCommentLongClick  params error");
            return;
        }
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
        w.a().b(view, cVar, new w.c() { // from class: com.qzone.detail.ui.activity.b
            @Override // com.qzone.reborn.feedx.util.w.c
            public final void onClick(View view2) {
                QzoneCommentDetailActivity.H4(Reply.this, comment, view2);
            }
        });
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected void onServiceResult(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        int i3 = qZoneResult.what;
        if (i3 == 999907) {
            if (!qZoneResult.getSucceed()) {
                BaseActivity.toast(qZoneResult.getMessage());
            }
            final Comment B4 = B4();
            if (!isUIThread()) {
                runOnUiThread(new Runnable() { // from class: com.qzone.detail.ui.activity.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QzoneCommentDetailActivity.this.G4(B4);
                    }
                });
                return;
            }
            if (B4 != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(B4);
                z4().setData(arrayList);
            }
            y4().notifyDataSetChanged();
            return;
        }
        if (i3 != 999978) {
            if (i3 == 1000185 && !qZoneResult.getSucceed()) {
                BaseActivity.toast(qZoneResult.getMessage());
                return;
            }
            return;
        }
        if (qZoneResult.getSucceed()) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDetailCommentReplyDelFail", "\u5220\u9664\u5931\u8d25");
        if (!TextUtils.isEmpty(qZoneResult.getMessage())) {
            config = qZoneResult.getMessage();
        }
        BaseActivity.toast(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2 A[Catch: Exception -> 0x0225, TryCatch #0 {Exception -> 0x0225, blocks: (B:3:0x000d, B:6:0x0031, B:8:0x0037, B:10:0x003d, B:12:0x0045, B:14:0x0051, B:16:0x005d, B:19:0x00a2, B:21:0x00a6, B:22:0x00af, B:27:0x00be, B:28:0x00c3, B:30:0x00ce, B:31:0x0118, B:33:0x011d, B:34:0x012c, B:37:0x0134, B:45:0x012a, B:47:0x00a9, B:49:0x006a, B:51:0x0070, B:53:0x0078, B:55:0x0084, B:57:0x0090), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a9 A[Catch: Exception -> 0x0225, TryCatch #0 {Exception -> 0x0225, blocks: (B:3:0x000d, B:6:0x0031, B:8:0x0037, B:10:0x003d, B:12:0x0045, B:14:0x0051, B:16:0x005d, B:19:0x00a2, B:21:0x00a6, B:22:0x00af, B:27:0x00be, B:28:0x00c3, B:30:0x00ce, B:31:0x0118, B:33:0x011d, B:34:0x012c, B:37:0x0134, B:45:0x012a, B:47:0x00a9, B:49:0x006a, B:51:0x0070, B:53:0x0078, B:55:0x0084, B:57:0x0090), top: B:2:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void J4(Intent intent) {
        String str;
        String stringExtra;
        String stringExtra2;
        int intValue;
        BusinessFeedData R;
        Comment comment;
        HashMap hashMap;
        String str2;
        try {
            stringExtra = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
            stringExtra2 = intent.getStringExtra("contentIntentKey");
            intValue = ((Integer) intent.getSerializableExtra("extraIntentKey")).intValue();
            R = this.f46850b1.R();
            try {
            } catch (Exception e16) {
                e = e16;
            }
        } catch (Exception e17) {
            e = e17;
            str = "QzoneCommentDetailActivity";
        }
        if (R == null) {
            str = "QzoneCommentDetailActivity";
        } else {
            if (this.f46856h1 == 1) {
                if (R.getCommentEssence() != null && R.getCommentEssence().commments != null && intValue < R.getCommentEssence().commments.size() && R.getCommentEssence().commments.get(intValue) != null) {
                    comment = R.getCommentEssence().commments.get(intValue);
                    long j3 = 0;
                    if (comment == null) {
                        User user = comment.user;
                        if (user != null) {
                            j3 = user.uin;
                        }
                    } else {
                        QZLog.e("QzoneCommentDetailActivity", "onFinishReply, comment is null.");
                    }
                    long j16 = j3;
                    Map<Integer, String> map = R.getOperationInfo().busiParam;
                    if (!this.f46864p1) {
                        return;
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    Map<Integer, String> map2 = map;
                    if (TextUtils.isEmpty(intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL))) {
                        hashMap = null;
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("diy_font_id", intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, 0) + "");
                        hashMap2.put("diy_font_type", intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, 0) + "");
                        hashMap2.put("diy_font_url", intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL));
                        hashMap = hashMap2;
                    }
                    if (this.f46853e1 == 4) {
                        str2 = map2.get(12);
                    } else {
                        str2 = this.f46854f1;
                    }
                    if (this.f46853e1 == 334 || comment == null) {
                        str = "QzoneCommentDetailActivity";
                        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
                        lVar.f45708a = R.getFeedCommInfo().ugckey;
                        lVar.f45709b = R.getFeedCommInfo().feedskey;
                        lVar.f45708a = UUID.randomUUID().toString();
                        lVar.f45712e = R.getFeedCommInfo().appid;
                        lVar.f45713f = this.f46852d1;
                        lVar.f45714g = str2;
                        lVar.f45715h = stringExtra2;
                        lVar.f45716i = stringExtra;
                        lVar.f45718k = map2;
                        lVar.f45724q = this.f46857i1;
                        lVar.f45730w = hashMap;
                        QZoneWriteOperationService.v0().Q(getHandler(), lVar);
                    } else {
                        QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                        Handler handler = getHandler();
                        String str3 = R.getFeedCommInfo().ugckey;
                        String str4 = R.getFeedCommInfo().feedskey;
                        String uuid = UUID.randomUUID().toString();
                        int i3 = R.getFeedCommInfo().appid;
                        str = "QzoneCommentDetailActivity";
                        long j17 = R.getUser().uin;
                        User user2 = this.f46866r1;
                        String str5 = comment.commentid;
                        StringBuilder sb5 = new StringBuilder();
                        User user3 = this.f46866r1;
                        sb5.append(u.a(user3.uin, user3.nickName));
                        sb5.append(stringExtra2);
                        v06.c2(handler, str3, str4, uuid, i3, j17, j16, user2, str2, "", str5, sb5.toString(), stringExtra2, stringExtra, 0, map2, f46845t1, this.f46857i1, intValue, 2, hashMap);
                    }
                }
                comment = null;
                long j36 = 0;
                if (comment == null) {
                }
                long j162 = j36;
                Map<Integer, String> map3 = R.getOperationInfo().busiParam;
                if (!this.f46864p1) {
                }
            } else {
                if (R.getCommentInfo() != null && R.getCommentInfo().commments != null && intValue < R.getCommentInfo().commments.size() && R.getCommentInfo().commments.get(intValue) != null) {
                    comment = R.getCommentInfo().commments.get(intValue);
                    long j362 = 0;
                    if (comment == null) {
                    }
                    long j1622 = j362;
                    Map<Integer, String> map32 = R.getOperationInfo().busiParam;
                    if (!this.f46864p1) {
                    }
                }
                comment = null;
                long j3622 = 0;
                if (comment == null) {
                }
                long j16222 = j3622;
                Map<Integer, String> map322 = R.getOperationInfo().busiParam;
                if (!this.f46864p1) {
                }
            }
            e = e16;
            QZLog.e(str, "onFinishReply catch an exception.", e);
            return;
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(659, 6, 0), false, false);
        LpReportInfo_pf00064.allReport(209, 3, 14);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements QZonePullToRefreshListView.c {
        a() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneCommentDetailActivity", 2, "onRefreshComplete");
            }
            QzoneCommentDetailActivity.this.y();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneCommentDetailActivity", 2, "onPullStart");
            }
            QzoneCommentDetailActivity.this.P3(new long[0]);
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneCommentDetailActivity", 2, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            }
            AudioFeedBubble.stopAll();
            QzoneCommentDetailActivity.this.onRefresh();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
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

    @Override // com.qzone.detail.ui.component.b
    public void k3(View view, Object obj) {
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
