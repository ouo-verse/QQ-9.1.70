package com.tencent.biz.pubaccount.weishi.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSCommentSuccessEvent;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class WsCommentPresenter implements View.OnClickListener, IEventReceiver {
    private com.tencent.biz.pubaccount.weishi.verticalvideo.d D;
    private ArrayList<stSimpleMetaComment> E;
    private com.tencent.biz.pubaccount.weishi.comment.f F;
    private WsCommentInputPopupWindow G;
    private ListView H;
    private View I;
    private FrameLayout J;
    private p K;
    private TextView L;
    private TextView M;
    private ImageButton N;
    private TextView P;
    private View Q;
    private View R;
    private String V;
    private String W;
    private String X;
    private int Y;

    /* renamed from: b0, reason: collision with root package name */
    private long f80504b0;

    /* renamed from: d, reason: collision with root package name */
    private final BaseFragment f80506d;

    /* renamed from: e, reason: collision with root package name */
    private final Activity f80508e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f80510f;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.comment.c f80514m;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<Integer, stSimpleMetaFeed> f80512h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private final AbsListView.OnScrollListener f80513i = new f(this);
    private String S = "";
    private String T = "";
    private String U = "";
    private int Z = -1;

    /* renamed from: a0, reason: collision with root package name */
    private int f80503a0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f80505c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f80507d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f80509e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    m f80511f0 = new a();
    private q C = new q(this);

    /* loaded from: classes32.dex */
    class a implements m {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.m
        public String e() {
            return WsCommentPresenter.this.R();
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.m
        public int f() {
            return WsCommentPresenter.this.Y;
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.m
        public Map<String, String> g() {
            return WsCommentPresenter.this.P();
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.m
        public String getPlayScene() {
            return WsCommentPresenter.this.L();
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.m
        public stSimpleMetaFeed h() {
            return WsCommentPresenter.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            WsCommentPresenter.this.V();
            wz.b.b().a(new WSCommentShowEvent(false));
            WsCommentPresenter.this.W = null;
            WsCommentPresenter.this.X = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x.i("comment", "onClick hide comment");
            WsCommentPresenter.this.V();
            wz.b.b().a(new WSCommentShowEvent(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements com.tencent.biz.subscribe.comment.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaComment f80520a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f80521b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaReply f80522c;

        d(stSimpleMetaComment stsimplemetacomment, boolean z16, stSimpleMetaReply stsimplemetareply) {
            this.f80520a = stsimplemetacomment;
            this.f80521b = z16;
            this.f80522c = stsimplemetareply;
        }

        @Override // com.tencent.biz.subscribe.comment.b
        public void a() {
            WsCommentPresenter.this.S(this.f80520a, this.f80521b, this.f80522c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements WsCommentInputPopupWindow.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaComment f80524a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaReply f80525b;

        e(stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply) {
            this.f80524a = stsimplemetacomment;
            this.f80525b = stsimplemetareply;
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow.g
        public void a(String str) {
            WsCommentPresenter.this.I.setVisibility(8);
            WsCommentPresenter.this.w(str);
            i g16 = i.g();
            stSimpleMetaFeed G = WsCommentPresenter.this.G();
            stSimpleMetaComment stsimplemetacomment = this.f80524a;
            stSimpleMetaReply stsimplemetareply = this.f80525b;
            g16.j(G, stsimplemetacomment, stsimplemetareply, str, WsCommentPresenter.this.O(stsimplemetacomment, stsimplemetareply));
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow.g
        public void onShow() {
            WsCommentPresenter.this.I.setVisibility(0);
            WsCommentPresenter.this.G.H0(i.g().i(WsCommentPresenter.this.G(), this.f80524a, this.f80525b));
            if (this.f80524a == null || WsCommentPresenter.this.E == null) {
                return;
            }
            int indexOf = WsCommentPresenter.this.E.indexOf(this.f80524a);
            x.i("comment", "index:" + indexOf);
            if (this.f80525b == null) {
                WsCommentPresenter.this.H.setSelectionFromTop(indexOf, 0);
                return;
            }
            int h16 = i.g().h(WsCommentPresenter.this.G(), this.f80524a, this.f80525b);
            if (h16 == 0) {
                h16 = WsCommentPresenter.this.O(this.f80524a, this.f80525b);
            }
            WsCommentPresenter.this.H.setSelectionFromTop(indexOf, -h16);
        }
    }

    public WsCommentPresenter(BaseFragment baseFragment, int i3) {
        this.f80506d = baseFragment;
        this.f80508e = baseFragment.getActivity();
        this.f80510f = baseFragment.getActivity().getApplicationContext();
        if (this.f80514m == null) {
            this.f80514m = new com.tencent.biz.pubaccount.weishi.comment.c(this);
            com.tencent.biz.qqstory.base.c.a().registerSubscriber(this.f80514m);
            x.f("comment", "\u6ce8\u518c\u4e00\u6b21\u8bc4\u8bba\u76d1\u542c\u5668 , currentPage:" + i3);
            return;
        }
        x.f("comment", "\u590d\u7528\u8bc4\u8bba\u76d1\u542c\u5668 , currentPage:" + i3);
    }

    private WSCommentSuccessEvent A(stPostCommentReplyV2Rsp stpostcommentreplyv2rsp) {
        String str;
        stSimpleMetaReply stsimplemetareply = stpostcommentreplyv2rsp.reply;
        if (stsimplemetareply == null) {
            str = "";
        } else {
            str = stsimplemetareply.f25131id;
        }
        return new WSCommentSuccessEvent(stpostcommentreplyv2rsp.sendArk == 1, stpostcommentreplyv2rsp.arkPopWindow == 1, "", str);
    }

    private WSCommentSuccessEvent B(stPostFeedCommentV2Rsp stpostfeedcommentv2rsp) {
        String str;
        stSimpleMetaComment stsimplemetacomment = stpostfeedcommentv2rsp.comment;
        if (stsimplemetacomment == null) {
            str = "";
        } else {
            str = stsimplemetacomment.f25128id;
        }
        return new WSCommentSuccessEvent(stpostfeedcommentv2rsp.sendArk == 1, stpostfeedcommentv2rsp.arkPopWindow == 1, str, "");
    }

    private void B0() {
        if (this.f80509e0) {
            this.f80509e0 = false;
            x.f("comment", "\u8bf7\u6c42\u7ed3\u675f preLoading = false");
        }
    }

    private void C0() {
        Activity activity = this.f80508e;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter.10
                @Override // java.lang.Runnable
                public void run() {
                    if (WsCommentPresenter.this.K != null) {
                        WsCommentPresenter.this.K.notifyDataSetChanged();
                    } else {
                        x.f("comment", "updateAdapterOnUI, mCommentAdapter is null");
                    }
                }
            });
        }
    }

    private void D0(KandianUrlImageView kandianUrlImageView) {
        o10.a aVar = o10.a.f421718a;
        if (aVar.h()) {
            kandianUrlImageView.setVisibility(0);
            WSPicLoader.g().w(kandianUrlImageView, aVar.f(), r.i(R.drawable.ocj));
            return;
        }
        kandianUrlImageView.setVisibility(8);
    }

    private int E() {
        if (this.Y == 6) {
            return ba.p();
        }
        return -1;
    }

    private void E0(int i3) {
        if (this.f80504b0 == 0) {
            this.f80504b0 = D().p(I());
        }
        this.f80504b0 += i3;
        Activity activity = this.f80508e;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter.9
                @Override // java.lang.Runnable
                public void run() {
                    if (WsCommentPresenter.this.P != null) {
                        if (WsCommentPresenter.this.f80504b0 > 0) {
                            WsCommentPresenter.this.P.setText(com.tencent.biz.subscribe.comment.i.a(WsCommentPresenter.this.f80504b0));
                            WsCommentPresenter.this.P.setVisibility(0);
                        } else {
                            WsCommentPresenter.this.P.setText("");
                            WsCommentPresenter.this.P.setVisibility(8);
                        }
                    }
                }
            });
        }
        com.tencent.biz.qqstory.base.c.a().dispatch(new wz.a(5, I(), Long.valueOf(this.f80504b0)));
    }

    private void F0(boolean z16) {
        View view = this.R;
        if (view == null || this.f80507d0) {
            return;
        }
        if (z16) {
            view.setVisibility(0);
            this.L.setText(R.string.c2w);
        } else {
            view.setVisibility(8);
            this.L.setText("");
        }
    }

    private stSimpleMetaPerson H() {
        if (com.tencent.biz.subscribe.c.c() != null) {
            CertifiedAccountMeta$StUser c16 = com.tencent.biz.subscribe.c.c();
            stSimpleMetaPerson stsimplemetaperson = new stSimpleMetaPerson();
            stsimplemetaperson.f25130id = c16.f24929id.get();
            stsimplemetaperson.nick = c16.nick.get();
            stsimplemetaperson.type = c16.type.get();
            return stsimplemetaperson;
        }
        stSimpleMetaPerson stsimplemetaperson2 = new stSimpleMetaPerson();
        stsimplemetaperson2.f25130id = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            stsimplemetaperson2.nick = ac.f((QQAppInterface) runtime, stsimplemetaperson2.f25130id);
        } else {
            stsimplemetaperson2.nick = "";
        }
        stsimplemetaperson2.type = 0;
        return stsimplemetaperson2;
    }

    private void W(stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply) {
        WsCommentInputPopupWindow wsCommentInputPopupWindow = this.G;
        if (wsCommentInputPopupWindow == null) {
            x.f("comment", "mCommentInputPopupWindow == null");
        } else {
            wsCommentInputPopupWindow.F0(new e(stsimplemetacomment, stsimplemetareply));
        }
    }

    private void X() {
        View view = this.Q;
        if (view == null) {
            return;
        }
        this.H = (ListView) view.findViewById(R.id.c4v);
        this.I = new View(this.f80510f);
        this.I.setLayoutParams(new ViewGroup.LayoutParams(100, ScreenUtil.dip2px(491.0f)));
        FrameLayout frameLayout = new FrameLayout(this.f80510f);
        this.J = frameLayout;
        frameLayout.addView(this.I);
        this.H.addFooterView(this.J);
        this.I.setVisibility(8);
        this.P = (TextView) view.findViewById(R.id.b4k);
        View findViewById = view.findViewById(R.id.f164853b42);
        this.R = findViewById;
        this.L = (TextView) findViewById.findViewById(R.id.f166327f13);
        TextView textView = (TextView) view.findViewById(R.id.jha);
        this.M = textView;
        textView.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.ajw);
        this.N = imageButton;
        imageButton.setOnClickListener(this);
        view.findViewById(R.id.ah5).setOnClickListener(this);
        KandianUrlImageView kandianUrlImageView = (KandianUrlImageView) view.findViewById(R.id.tcu);
        kandianUrlImageView.setOnClickListener(this);
        D0(kandianUrlImageView);
        this.H.setOnScrollListener(this.f80513i);
        if (this.K == null) {
            x.i("comment", "create mCommentAdapter ...");
            p pVar = new p(this.f80510f, new g(), this.f80511f0);
            this.K = pVar;
            pVar.m(G());
            this.K.l(R(), L());
        } else {
            x.i("comment", "\u590d\u7528 mCommentAdapter ...");
        }
        this.K.n(this.S);
        this.K.m(G());
        this.H.setAdapter((ListAdapter) this.K);
        view.setOnClickListener(new c());
        n0();
    }

    private void Y(stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply) {
        if (stsimplemetareply != null && stsimplemetareply.poster != null) {
            String format = String.format(this.f80510f.getString(R.string.f170928b51), stsimplemetareply.poster.nick);
            if (format.length() > 10) {
                format = format.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            this.G.D0(format);
            return;
        }
        if (stsimplemetacomment != null && stsimplemetacomment.poster != null) {
            String format2 = String.format(this.f80510f.getString(R.string.f170928b51), stsimplemetacomment.poster.nick);
            if (format2.length() > 10) {
                format2 = format2.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            this.G.D0(format2);
            return;
        }
        this.G.D0(iz.a.g().d());
    }

    private synchronized void Z() {
        if (this.C == null) {
            x.f("comment", "innerInitData return empty because WsCommentBusiness is null ");
            return;
        }
        this.E = D().o(I());
        this.T = D().k(I());
        if (this.E == null) {
            return;
        }
        p pVar = this.K;
        if (pVar != null) {
            pVar.g();
            this.K.f(this.E);
            this.K.notifyDataSetChanged();
        }
        x.f("comment", "innerInitData, lastPosition:" + this.Z + ",currentPosition:" + M());
        if (this.H != null && this.Z != M()) {
            this.Z = M();
            this.H.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    WsCommentPresenter.this.H.setSelection(0);
                }
            });
        }
        ArrayList<stSimpleMetaComment> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            this.f80504b0 = D().p(I());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a0() {
        Z();
        ArrayList<stSimpleMetaComment> arrayList = this.E;
        boolean z16 = true;
        boolean z17 = arrayList != null && arrayList.size() > 0;
        if (z17) {
            TextView textView = this.P;
            if (textView != null) {
                textView.setText(com.tencent.biz.subscribe.comment.i.a(this.f80504b0));
                this.P.setVisibility(0);
            }
        } else {
            TextView textView2 = this.P;
            if (textView2 != null) {
                textView2.setText("");
                this.P.setVisibility(8);
            }
        }
        if (z17) {
            z16 = false;
        }
        F0(z16);
        f0();
        j0();
    }

    private boolean b0(int i3, Object[] objArr) {
        return i3 < objArr.length && (objArr[i3] instanceof Integer) && D().hashCode() != ((Integer) objArr[i3]).intValue();
    }

    private void e0() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.d dVar = this.D;
        if (dVar != null) {
            dVar.H0(1);
        }
    }

    private void f0() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.d dVar = this.D;
        if (dVar != null) {
            dVar.K1(1);
        }
    }

    private void i0(int i3, int i16) {
        com.tencent.biz.pubaccount.weishi.report.b.n(R(), L(), N(), i3, i16, G(), K(), P());
    }

    private void j0() {
        String d16 = com.tencent.biz.pubaccount.weishi.report.b.d(this.U);
        if (!d16.equals("comment_page")) {
            d16 = d16 + Q();
        }
        com.tencent.biz.pubaccount.weishi.report.b.o(this.U, L(), d16, G(), this.Y, P());
    }

    private void n0() {
        String d16 = iz.a.g().d();
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        this.M.setHint(d16);
    }

    private Runnable v(final int i3, final int i16) {
        return new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                WsCommentPresenter.this.y0(i.g().d(WsCommentPresenter.this.I()), i.g().e(WsCommentPresenter.this.I()), i3, true, i16 == 8);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(str);
        }
        ImageButton imageButton = this.N;
        if (imageButton != null) {
            imageButton.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    private void x(String str, ArrayList<String> arrayList) {
        stSimpleMetaComment stsimplemetacomment = new stSimpleMetaComment();
        stsimplemetacomment.f25128id = "fakeId_" + System.currentTimeMillis();
        stsimplemetacomment.wording = str;
        stsimplemetacomment.createtime = (int) (System.currentTimeMillis() / 1000);
        stsimplemetacomment.poster = H();
        stsimplemetacomment.replyList = new ArrayList<>();
        D().i(G(), stsimplemetacomment, arrayList);
        this.f80505c0 = true;
        x.l("comment", "2 mCommentListChanged:" + this.f80505c0 + ", hashCode" + hashCode());
        BaseFragment baseFragment = this.f80506d;
        if (baseFragment instanceof WSFollowFragment) {
            ((WSFollowFragment) baseFragment).vi(M(), G());
        }
        p pVar = this.K;
        if (pVar != null) {
            pVar.d(0, stsimplemetacomment);
            this.K.notifyDataSetChanged();
        }
        x.f("comment", "onCommentSend, lastPosition:" + this.Z + ",currentPosition:" + M());
        ListView listView = this.H;
        if (listView != null) {
            listView.setSelection(0);
        }
    }

    private void y(String str, stSimpleMetaReply stsimplemetareply, stSimpleMetaComment stsimplemetacomment, ArrayList<String> arrayList) {
        stSimpleMetaReply stsimplemetareply2 = new stSimpleMetaReply();
        stsimplemetareply2.f25131id = "fakeId_" + System.currentTimeMillis();
        stsimplemetareply2.wording = str;
        stsimplemetareply2.createtime = (int) (System.currentTimeMillis() / 1000);
        stsimplemetareply2.poster = H();
        if (stsimplemetareply != null) {
            stsimplemetareply2.receiver = stsimplemetareply.poster;
            stsimplemetareply2.beReplyReplyId = stsimplemetareply.f25131id;
        } else {
            stsimplemetareply2.receiver = stsimplemetacomment.poster;
        }
        x.f("comment", "\u56de\u590d\u8bf7\u6c42\u524d,\u53d1\u9001\u8005:" + stsimplemetareply2.poster.nick + ",\u63a5\u53d7\u8005:" + stsimplemetareply2.receiver.nick);
        D().h(G(), stsimplemetacomment, stsimplemetareply2, arrayList);
        this.f80505c0 = true;
        p pVar = this.K;
        if (pVar != null) {
            pVar.e(stsimplemetacomment.f25128id, stsimplemetareply2);
            this.K.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply, int i3, boolean z16, boolean z17) {
        if (this.f80510f != null && BaseApplication.getContext() != null) {
            if (this.G == null) {
                this.G = new WsCommentInputPopupWindow(this.f80508e, this.f80506d, this.f80511f0);
            }
            this.G.E0(new d(stsimplemetacomment, z16, stsimplemetareply));
            W(stsimplemetacomment, stsimplemetareply);
            this.G.I0(i3);
            if (z17) {
                this.G.C0();
                return;
            } else {
                Y(stsimplemetacomment, stsimplemetareply);
                return;
            }
        }
        x.e("comment", 1, "plugin environment exception ! ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p C() {
        return this.K;
    }

    public q D() {
        if (this.C == null) {
            this.C = new q(this);
        }
        return this.C;
    }

    public Map<String, String> F(stSimpleMetaComment stsimplemetacomment, ArrayList<String> arrayList) {
        String str;
        String str2;
        Map<String, String> P = P();
        if (arrayList.isEmpty()) {
            str = "0";
        } else {
            str = "1";
        }
        P.put("is_reply_at_friends", str);
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        if (arrayList.size() > 0) {
            sb5.append(arrayList.get(0));
            sb6.append("2");
            for (int i3 = 1; i3 < arrayList.size(); i3++) {
                sb5.append(",");
                sb5.append(arrayList.get(i3));
                sb6.append(",");
                sb6.append("2");
            }
        }
        P.put("uid", sb5.toString());
        P.put("uid_type", sb6.toString());
        if (stsimplemetacomment == null) {
            str2 = "";
        } else {
            str2 = stsimplemetacomment.f25128id;
        }
        P.put("comment_id", str2);
        return P;
    }

    public stSimpleMetaFeed G() {
        return this.f80512h.get(Integer.valueOf(M()));
    }

    public String I() {
        if (G() == null) {
            x.e("comment", 2, "getFeedId is null");
            return "";
        }
        return G().f25129id;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseFragment J() {
        return this.f80506d;
    }

    public int K() {
        return this.Y;
    }

    public String L() {
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int M() {
        return this.f80503a0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String N() {
        if (com.tencent.biz.pubaccount.weishi.report.b.g(R())) {
            return com.tencent.biz.pubaccount.weishi.report.b.d(R());
        }
        return com.tencent.biz.pubaccount.weishi.report.b.d(R()) + Q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> P() {
        BaseFragment baseFragment = this.f80506d;
        if (baseFragment instanceof WSVerticalPageFragment) {
            return ((WSVerticalPageFragment) baseFragment).getPresenter().h0();
        }
        return new HashMap();
    }

    public int Q() {
        if (com.tencent.biz.pubaccount.weishi.report.b.g(R())) {
            return this.f80503a0;
        }
        return jz.f.d().f411219f.get(this.f80503a0) + 1;
    }

    public String R() {
        return this.U;
    }

    public void T(Object[] objArr) {
        boolean z16;
        BaseActivity baseActivity;
        int intValue = ((Integer) objArr[0]).intValue();
        Integer num = (Integer) objArr[1];
        Object obj = objArr[2];
        String str = obj == null ? "" : (String) obj;
        x.l("comment", "handleResponseEvent, action: " + objArr[0] + ",resultCode:" + num + ",msg:" + str + this);
        if (intValue == 3) {
            WsCommentInputPopupWindow wsCommentInputPopupWindow = this.G;
            if (wsCommentInputPopupWindow != null) {
                wsCommentInputPopupWindow.s0(this.M);
            }
            if (b0(5, objArr)) {
                x.e("comment", 1, "handleResponseEvent add comment isInterceptEvent");
                return;
            }
            stPostFeedCommentV2Rsp stpostfeedcommentv2rsp = (stPostFeedCommentV2Rsp) objArr[3];
            if (num.intValue() == 1000) {
                wz.b.b().a(B(stpostfeedcommentv2rsp));
                p pVar = this.K;
                if (pVar != null && pVar.q(String.valueOf(objArr[4]), stpostfeedcommentv2rsp.comment)) {
                    C0();
                }
                this.f80505c0 = true;
                E0(1);
            } else {
                p pVar2 = this.K;
                if (pVar2 != null && pVar2.j(String.valueOf(objArr[4]))) {
                    C0();
                }
            }
            x.e("comment", 1, "ACTION_ADD_FEED_COMMENT fail, result =" + num + " msg=" + str);
            A0((long) num.intValue(), HardCodeUtil.qqStr(R.string.ktj), str);
            return;
        }
        if (intValue == 4) {
            if (b0(6, objArr)) {
                x.e("comment", 1, "handleResponseEvent add reply isInterceptEvent");
                return;
            }
            this.f80505c0 = true;
            WsCommentInputPopupWindow wsCommentInputPopupWindow2 = this.G;
            if (wsCommentInputPopupWindow2 != null) {
                wsCommentInputPopupWindow2.s0(this.M);
            }
            if (num.intValue() != 1000) {
                x.e("comment", 1, "reply fail ret=" + num + " msg=" + str);
            }
            stPostCommentReplyV2Rsp stpostcommentreplyv2rsp = (stPostCommentReplyV2Rsp) objArr[3];
            stSimpleMetaReply stsimplemetareply = stpostcommentreplyv2rsp.reply;
            String str2 = (String) objArr[5];
            x.f("comment", "fakeReplyId:" + str2 + ",reply toString :" + stsimplemetareply.toString());
            if (num.intValue() == 1000) {
                if (D().hashCode() == ((Integer) objArr[6]).intValue()) {
                    wz.b.b().a(A(stpostcommentreplyv2rsp));
                }
                p pVar3 = this.K;
                if (pVar3 != null && pVar3.r(stsimplemetareply.f25131id, str2, stsimplemetareply)) {
                    C0();
                }
            } else {
                p pVar4 = this.K;
                if (pVar4 != null && pVar4.k(stsimplemetareply.f25131id, str2)) {
                    C0();
                }
            }
            A0(num.intValue(), HardCodeUtil.qqStr(R.string.kta), HardCodeUtil.qqStr(R.string.ktn));
            return;
        }
        if (intValue == 5) {
            if (b0(4, objArr)) {
                x.e("comment", 1, "handleResponseEvent delete isInterceptEvent");
                return;
            }
            if (num.intValue() == 1000 && (objArr[3] instanceof stDeleteFeedCommentRsp)) {
                String str3 = (String) objArr[4];
                p pVar5 = this.K;
                if (pVar5 != null && pVar5.j(str3)) {
                    C0();
                }
                E0(-1);
            }
            A0(num.intValue(), HardCodeUtil.qqStr(R.string.ktc), HardCodeUtil.qqStr(R.string.ktm));
            return;
        }
        if (intValue == 6) {
            if (b0(5, objArr)) {
                x.e("comment", 1, "handleResponseEvent delete reply isInterceptEvent");
                return;
            }
            A0(num.intValue(), HardCodeUtil.qqStr(R.string.kti), HardCodeUtil.qqStr(R.string.ktp));
            Object obj2 = objArr[3];
            if (obj2 instanceof String) {
                Object obj3 = objArr[4];
                if (obj3 instanceof stSimpleMetaReply) {
                    String str4 = (String) obj2;
                    String str5 = ((stSimpleMetaReply) obj3).f25131id;
                    if (num.intValue() != 1000 || this.K == null || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                        return;
                    }
                    this.K.k(str4, str5);
                    C0();
                    return;
                }
                return;
            }
            return;
        }
        if (intValue != 9) {
            return;
        }
        x.f("comment", "onEvent: ACTION_GET_MORE_COMMENT\uff01");
        B0();
        Object obj4 = objArr[6];
        if ((obj4 instanceof String) && !((String) obj4).equals(I())) {
            x.f("comment", "\u4e0d\u662f\u5f53\u524dfeedId\u7684\u6570\u636e\uff0c\u4e0d\u54cd\u5e94\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01\uff01");
            return;
        }
        if (b0(4, objArr)) {
            B0();
            return;
        }
        Object obj5 = objArr[5];
        if (obj5 instanceof Boolean) {
            z16 = ((Boolean) obj5).booleanValue();
            if (!z16) {
                this.f80505c0 = false;
                x.l("comment", "if(!loadMore) mCommentListChanged = false, hashCode" + hashCode());
            }
        } else {
            z16 = true;
        }
        Object obj6 = objArr[3];
        if (obj6 instanceof stGetFeedCommentListV2Rsp) {
            if (this.K != null) {
                ArrayList<stSimpleMetaComment> arrayList = ((stGetFeedCommentListV2Rsp) obj6).comments;
                if (arrayList.size() == 0) {
                    F0(true);
                } else {
                    if (!z16) {
                        this.K.g();
                    }
                    this.K.f(arrayList);
                    C0();
                    E0(0);
                }
            }
            if (!this.f80507d0 || z16 || (baseActivity = this.f80506d.getBaseActivity()) == null) {
                return;
            }
            baseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter.8
                @Override // java.lang.Runnable
                public void run() {
                    WsCommentPresenter.this.f80507d0 = false;
                    WsCommentPresenter.this.a0();
                    x.f("comment", "onResponse, lastPosition:" + WsCommentPresenter.this.Z + ",currentPosition:" + WsCommentPresenter.this.M());
                    if (WsCommentPresenter.this.H != null) {
                        WsCommentPresenter.this.H.setSelection(0);
                    }
                }
            });
            return;
        }
        x.f("comment", "\u83b7\u53d6\u8bc4\u8bbaresponse\u5931\u8d25");
    }

    public void U() {
        WsCommentInputPopupWindow wsCommentInputPopupWindow = this.G;
        if (wsCommentInputPopupWindow == null || !wsCommentInputPopupWindow.isShowing()) {
            return;
        }
        this.G.dismiss();
    }

    public void V() {
        com.tencent.biz.pubaccount.weishi.comment.f fVar = this.F;
        if (fVar != null && fVar.isShowing()) {
            this.F.dismiss();
        }
        if (this.Q != null) {
            this.K.h();
            this.K.g();
            this.K.notifyDataSetChanged();
            F0(false);
            e0();
        }
        this.f80507d0 = false;
    }

    public boolean c0() {
        return true;
    }

    public boolean d0() {
        boolean isShowing = isShowing();
        if (isShowing) {
            V();
        }
        return isShowing;
    }

    public void g0() {
        x.l("comment", "comment onRecycle");
        if (this.f80514m != null) {
            com.tencent.biz.qqstory.base.c.a().unRegisterSubscriber(this.f80514m);
        }
        D().u();
        this.C = null;
        ArrayList<stSimpleMetaComment> arrayList = this.E;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f80512h.clear();
        WsCommentInputPopupWindow wsCommentInputPopupWindow = this.G;
        if (wsCommentInputPopupWindow != null) {
            wsCommentInputPopupWindow.B0();
        }
        i.g().a();
    }

    public boolean isShowing() {
        com.tencent.biz.pubaccount.weishi.comment.f fVar = this.F;
        return fVar != null && fVar.isShowing();
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return true;
    }

    public void l0(stSimpleMetaComment stsimplemetacomment) {
        String str;
        stSimpleMetaFeed G = G();
        int i3 = 0;
        if (G != null) {
            int i16 = G.total_comment_num + 1;
            G.total_comment_num = i16;
            if (G.simpleComments == null) {
                G.simpleComments = new ArrayList<>();
            }
            G.simpleComments.add(0, k.d(stsimplemetacomment, H()));
            i3 = i16;
        }
        if (G() != null) {
            str = G().f25129id;
        } else {
            str = "";
        }
        wz.b.b().a(new WSAddCommentEvent(str, M(), i3));
    }

    public WsCommentPresenter m0(String str, String str2) {
        this.U = str;
        this.V = str2;
        p pVar = this.K;
        if (pVar != null) {
            pVar.l(str, str2);
        }
        return this;
    }

    public WsCommentPresenter o0(boolean z16) {
        this.f80505c0 = z16;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        stSimpleMetaComment d16 = i.g().d(I());
        stSimpleMetaReply e16 = i.g().e(I());
        switch (id5) {
            case R.id.tcu /* 2131364462 */:
                i0(1000001, 8);
                y0(d16, e16, 0, false, true);
                return;
            case R.id.ah5 /* 2131364567 */:
                i0(1000001, 7);
                x0(d16, e16, 1);
                return;
            case R.id.ajw /* 2131364713 */:
                i0(1000001, 10);
                i.g().i(G(), d16, e16);
                S(d16, false, e16);
                w("");
                return;
            case R.id.jha /* 2131389241 */:
                i0(1000001, 4);
                y0(d16, e16, 0, false, false);
                return;
            default:
                return;
        }
    }

    public WsCommentPresenter p0(String str) {
        this.W = str;
        return this;
    }

    public WsCommentPresenter q0(String str) {
        this.X = str;
        return this;
    }

    public void s0(com.tencent.biz.pubaccount.weishi.verticalvideo.d dVar) {
        this.D = dVar;
    }

    public WsCommentPresenter t0(int i3) {
        this.Y = i3;
        return this;
    }

    public void u0(View view) {
        this.Q = view;
        X();
    }

    public WsCommentPresenter v0(int i3) {
        p pVar;
        if (i3 != this.f80503a0 && (pVar = this.K) != null) {
            pVar.C.clear();
            this.K.f80603m.clear();
        }
        this.f80503a0 = i3;
        p.H = Q();
        return this;
    }

    public void w0() {
        if (!TextUtils.equals(I(), i.g().f())) {
            i.g().a();
            TextView textView = this.M;
            if (textView != null) {
                textView.setText("");
            }
        }
        if (this.F == null) {
            this.F = com.tencent.biz.pubaccount.weishi.comment.f.c(this.f80508e, E(), -1);
        }
        Window window = this.f80508e.getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
            this.F.h();
            this.F.showAtLocation(window.getDecorView(), 85, 0, 0);
        }
        this.F.setOnDismissListener(new b());
        if (this.Q == null) {
            u0(this.F.d());
        }
        stSimpleMetaFeed G = G();
        if (G == null) {
            x.f("comment", "showCommentListWithAnim, but feed is null");
            return;
        }
        if (G.total_comment_num <= 0) {
            x0(null, null, 0);
        }
        String I = I();
        if (I != null) {
            ArrayList<stSimpleMetaComment> o16 = D().o(I);
            this.E = o16;
            x.l("comment", "position:" + M() + ",feedId:" + G.f25129id + ",cellId:" + I + ",loadedComments size:" + (o16 == null ? 0 : o16.size()) + ",mCommentListChanged:" + this.f80505c0 + ",hashCode:" + hashCode());
            if (this.f80505c0) {
                x.l("comment", "11111111111111111111111111 mCommentListChanged");
                D().m(G, false, this.W, this.X);
                this.f80507d0 = true;
            } else if (this.E == null) {
                if (this.f80509e0) {
                    x.l("comment", "444444444444444444444444 loadedComments == null and preloading is true");
                } else {
                    x.l("comment", "2222222222222222222222222 loadedComments == null and preloading is false");
                    D().m(G, false, this.W, this.X);
                }
                this.f80507d0 = true;
            } else {
                x.l("comment", "333333333333333333333 \u8bfb\u53d6\u8bc4\u8bba" + this.E.size() + "\u6761");
                this.f80507d0 = false;
            }
            a0();
        }
    }

    public void z() {
        if (I() != null) {
            if (this.f80509e0) {
                x.f("comment", "\u5df2\u7ecf\u6709\u9884\u52a0\u8f7d\u8fdb\u884c\u4e2d\uff0c\u62e6\u622a----------------------------------------------------\u300b\u300b\u300b\u300b\u300b\u300b\u300b\u300b");
            } else {
                if (!TextUtils.isEmpty(D().k(I()))) {
                    x.f("comment", "\u5df2\u7ecf\u770b\u8fc7\u7684\u89c6\u9891\uff0cattachInfo\u4e0d\u4e3a\u7a7a\uff0c\u9009\u62e9\u62e6\u622a------------------------------------------------");
                    return;
                }
                this.f80509e0 = true;
                x.f("comment", "\u8bf7\u6c42\u5f00\u59cb preLoading = true");
                D().m(G(), false, this.W, this.X);
            }
        }
    }

    public void z0(int i3, int i16, String str, Map<String, String> map) {
        com.tencent.biz.pubaccount.weishi.report.b.n(R(), str, "comment_page_explicit", 1000001, i16, G(), K(), map);
        w0();
        D().n().postDelayed(v(i3, i16), 200L);
    }

    /* loaded from: classes32.dex */
    private class f implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f80527d = false;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<WsCommentPresenter> f80528e;

        f(WsCommentPresenter wsCommentPresenter) {
            this.f80528e = new WeakReference<>(wsCommentPresenter);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (this.f80527d && i3 == 0) {
                x.l("comment", "onScrollStateChanged scrollState:" + i3);
                WsCommentPresenter wsCommentPresenter = WsCommentPresenter.this;
                wsCommentPresenter.T = wsCommentPresenter.D().k(WsCommentPresenter.this.I());
                if (WsCommentPresenter.this.T != null) {
                    WsCommentPresenter.this.D().m(WsCommentPresenter.this.G(), true, WsCommentPresenter.this.W, WsCommentPresenter.this.X);
                    WsCommentPresenter.this.f80507d0 = true;
                } else {
                    x.l("comment", "mCommentAttachInfo is null");
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            this.f80527d = i17 > 0 && absListView.getFirstVisiblePosition() + i16 >= i17;
        }
    }

    public void k0() {
        this.E = null;
        this.T = "";
        this.f80504b0 = 0L;
        this.f80507d0 = false;
    }

    public WsCommentPresenter r0(stSimpleMetaFeed stsimplemetafeed) {
        stSimpleMetaPerson stsimplemetaperson;
        if (stsimplemetafeed != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
            this.S = stsimplemetaperson.f25130id;
            p pVar = this.K;
            if (pVar != null) {
                pVar.m(stsimplemetafeed);
            }
        }
        this.f80512h.put(Integer.valueOf(M()), stsimplemetafeed);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply) {
        ArrayList<stSimpleMetaComment> arrayList;
        if (stsimplemetareply != null && (arrayList = this.E) != null) {
            int indexOf = arrayList.indexOf(stsimplemetacomment);
            int indexOf2 = stsimplemetacomment.replyList.indexOf(stsimplemetareply);
            x.i("comment", "indexOfReply:" + indexOf2);
            View childAt = this.H.getChildAt(indexOf - this.H.getFirstVisiblePosition());
            x.i("comment", "commentChild:" + childAt);
            if (childAt instanceof WsCommentView) {
                WsCommentView wsCommentView = (WsCommentView) childAt;
                RelativeLayout relativeLayout = wsCommentView.f80533f;
                if (relativeLayout == null) {
                    return 0;
                }
                int height = relativeLayout.getHeight();
                View childAt2 = wsCommentView.C.getChildAt(indexOf2);
                x.i("comment", "replyChild:" + childAt2);
                r0 = childAt2 != null ? childAt2.getTop() + height : 0;
                x.i("comment", "offset:" + r0);
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(stSimpleMetaComment stsimplemetacomment, boolean z16, stSimpleMetaReply stsimplemetareply) {
        x.a("comment", 1, "onCommentSend()");
        WsCommentInputPopupWindow wsCommentInputPopupWindow = this.G;
        if (wsCommentInputPopupWindow == null) {
            x.a("comment", 1, "onCommentSend(): mCommentInputPopupWindow null");
            return;
        }
        String p06 = wsCommentInputPopupWindow.p0();
        if (TextUtils.isEmpty(p06.trim())) {
            Context context = this.f80510f;
            QQToast.makeText(context, context.getString(R.string.f170929b52), 0).show();
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(this.f80510f)) {
            Context context2 = this.f80510f;
            QQToast.makeText(context2, 1, context2.getString(R.string.cib), 0).show();
            return;
        }
        if (G() == null) {
            x.e("comment", 1, "feed is null");
            return;
        }
        boolean z17 = stsimplemetacomment == null;
        ArrayList<String> l06 = this.G.l0();
        com.tencent.biz.pubaccount.weishi.report.b.p(R(), L(), Q(), G(), z16, z17, K(), F(stsimplemetacomment, l06));
        if (z17) {
            x(p06, l06);
        } else {
            y(p06, stsimplemetareply, stsimplemetacomment, l06);
        }
        this.G.H0("");
        this.G.dismiss();
        if (this.f80504b0 == 0) {
            F0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0(stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply, int i3) {
        y0(stsimplemetacomment, stsimplemetareply, i3, false, false);
    }

    private void A0(long j3, String str, String str2) {
        if (j3 == 1000) {
            QQToast.makeText(this.f80510f, 2, str, 0).show();
        } else if (!NetworkUtils.isNetworkAvailable(this.f80510f)) {
            Context context = this.f80510f;
            QQToast.makeText(context, 1, context.getResources().getString(R.string.cib), 0).show();
        } else {
            QQToast.makeText(this.f80510f, 1, str2, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements com.tencent.biz.subscribe.comment.m {
        g() {
        }

        @Override // com.tencent.biz.subscribe.comment.m
        public void onClick(View view, int i3, int i16, Object obj) {
            com.tencent.biz.pubaccount.weishi.comment.a.a(WsCommentPresenter.this, i3).a(obj, i16);
        }

        @Override // com.tencent.biz.subscribe.comment.m
        public void onLongClick(View view, int i3, int i16, Object obj) {
        }
    }
}
