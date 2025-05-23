package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetCommentListRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoCommentRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoReplyRsp;
import NS_COMM.COMM;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.CommentReplyEvent;
import com.tencent.biz.subscribe.utils.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.Constants;

/* loaded from: classes5.dex */
public class CommentPresenter extends com.tencent.biz.subscribe.baseUI.b<CertifiedAccountMeta$StComment> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Animation.AnimationListener, IEventReceiver {
    private static final String B0 = "CommentPresenter";
    private int A0;
    private final f C;
    private final Activity D;
    private ViewStub E;
    ListView F;
    private i G;
    View H;
    private View I;
    private TextView J;
    private TextView K;
    private View L;
    private SubscribeCommentInputPopupWindow M;
    private CertifiedAccountMeta$StComment N;
    private CertifiedAccountMeta$StReply P;
    private long Q;
    private Map<Long, CertifiedAccountMeta$StUser> R;
    private Map<Long, CertifiedAccountMeta$StComment> S;
    private Map<Long, CertifiedAccountMeta$StReply> T;
    private l U;
    private ActionSheetDialog V;
    private boolean W;
    private boolean X;
    private COMM.StCommonExt Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f95858a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f95859b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f95860c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f95861d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f95862e0;

    /* renamed from: f0, reason: collision with root package name */
    private Animation f95863f0;

    /* renamed from: g0, reason: collision with root package name */
    private Animation f95864g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f95865h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f95866i0;

    /* renamed from: j0, reason: collision with root package name */
    private Map<Integer, CertifiedAccountMeta$StFeed> f95867j0;

    /* renamed from: k0, reason: collision with root package name */
    protected com.tencent.biz.subscribe.comment.c f95868k0;

    /* renamed from: l0, reason: collision with root package name */
    private ArrayList<CertifiedAccountMeta$StComment> f95869l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f95870m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f95871n0;

    /* renamed from: o0, reason: collision with root package name */
    private g f95872o0;

    /* renamed from: p0, reason: collision with root package name */
    private n f95873p0;

    /* renamed from: q0, reason: collision with root package name */
    private h f95874q0;

    /* renamed from: r0, reason: collision with root package name */
    private View f95875r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f95876s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f95877t0;

    /* renamed from: u0, reason: collision with root package name */
    private ExtraTypeInfo f95878u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f95879v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f95880w0;

    /* renamed from: x0, reason: collision with root package name */
    private AbsListView.OnScrollListener f95881x0;

    /* renamed from: y0, reason: collision with root package name */
    private View.OnLayoutChangeListener f95882y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f95883z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommentPresenter.this.U0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes5.dex */
    class b implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        boolean f95889d = false;

        b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (i17 > 0 && absListView.getFirstVisiblePosition() + i16 >= i17) {
                this.f95889d = true;
            } else {
                this.f95889d = false;
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
            if (this.f95889d && i3 == 0 && !CommentPresenter.this.W && !CommentPresenter.this.X) {
                QLog.i(CommentPresenter.B0, 1, "onLastItemVisible");
                CommentPresenter commentPresenter = CommentPresenter.this;
                commentPresenter.Y = commentPresenter.O0().j(CommentPresenter.this.N0());
                if (CommentPresenter.this.Y != null) {
                    CommentPresenter.this.O0().m(CommentPresenter.this.P0(), true);
                    CommentPresenter.this.f95866i0 = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements SubscribeCommentInputPopupWindow.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StComment f95891a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StReply f95892b;

        c(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
            this.f95891a = certifiedAccountMeta$StComment;
            this.f95892b = certifiedAccountMeta$StReply;
        }

        @Override // com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.g
        public void a() {
            QLog.d(CommentPresenter.B0, 1, "onCommentSend()");
            if (CommentPresenter.this.M == null) {
                QLog.d(CommentPresenter.B0, 1, "onCommentSend(): mCommentInputPopupWindow null");
                return;
            }
            String k06 = CommentPresenter.this.M.k0();
            if (TextUtils.isEmpty(k06.trim())) {
                QQToast.makeText(CommentPresenter.this.a(), CommentPresenter.this.a().getString(R.string.f170929b52), 0).show();
                return;
            }
            if (!NetworkUtils.isNetworkAvailable(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d)) {
                QQToast.makeText(CommentPresenter.this.a(), 1, CommentPresenter.this.a().getString(R.string.cib), 0).show();
                return;
            }
            if (CommentPresenter.this.P0() == null) {
                QLog.e(CommentPresenter.B0, 1, "feed is null");
                return;
            }
            if (this.f95891a != null) {
                if (CommentPresenter.this.P == null) {
                    CommentPresenter commentPresenter = CommentPresenter.this;
                    commentPresenter.P = commentPresenter.K0(this.f95891a, this.f95892b);
                }
                CommentPresenter.this.P.content.set(k06);
                CertifiedAccountMeta$StReply certifiedAccountMeta$StReply = new CertifiedAccountMeta$StReply();
                certifiedAccountMeta$StReply.f24928id.set("fakeId_" + System.currentTimeMillis());
                certifiedAccountMeta$StReply.content.set(k06);
                certifiedAccountMeta$StReply.createTime.set((long) ((int) (System.currentTimeMillis() / 1000)));
                certifiedAccountMeta$StReply.postUser.set(CommentPresenter.this.Q0());
                CertifiedAccountMeta$StReply certifiedAccountMeta$StReply2 = this.f95892b;
                if (certifiedAccountMeta$StReply2 != null) {
                    certifiedAccountMeta$StReply.targetUser = certifiedAccountMeta$StReply2.postUser.get();
                } else {
                    certifiedAccountMeta$StReply.targetUser = this.f95891a.postUser;
                }
                if (CommentPresenter.this.P.targetUser != null) {
                    CommentPresenter.this.R.put(Long.valueOf(CommentPresenter.this.Q), CommentPresenter.this.P.targetUser);
                }
                CommentPresenter commentPresenter2 = CommentPresenter.this;
                commentPresenter2.Q = commentPresenter2.O0().f(CommentPresenter.this.P0(), this.f95891a, certifiedAccountMeta$StReply);
                CommentPresenter.this.f95860c0 = true;
                CommentPresenter.this.f95862e0 = true;
                if (CommentPresenter.this.T != null) {
                    CommentPresenter.this.T.put(Long.valueOf(CommentPresenter.this.Q), CommentPresenter.this.P);
                }
                CommentPresenter.this.P = null;
                if (CommentPresenter.this.U != null) {
                    CommentPresenter.this.U.b(this.f95891a.f24924id.get(), certifiedAccountMeta$StReply);
                    CommentPresenter.this.U.notifyDataSetChanged();
                }
            } else {
                if (CommentPresenter.this.N == null) {
                    CommentPresenter commentPresenter3 = CommentPresenter.this;
                    commentPresenter3.N = commentPresenter3.J0(this.f95891a);
                }
                CommentPresenter.this.N.content.set(k06);
                CertifiedAccountMeta$StComment certifiedAccountMeta$StComment = new CertifiedAccountMeta$StComment();
                certifiedAccountMeta$StComment.f24924id.set("fakeId_" + System.currentTimeMillis());
                certifiedAccountMeta$StComment.content.set(k06);
                certifiedAccountMeta$StComment.createTime.set((long) ((int) (System.currentTimeMillis() / 1000)));
                certifiedAccountMeta$StComment.postUser.set(CommentPresenter.this.Q0());
                CommentPresenter.this.O0().g(CommentPresenter.this.P0(), certifiedAccountMeta$StComment);
                CommentPresenter.this.f95860c0 = true;
                CommentPresenter.this.f95862e0 = true;
                CommentPresenter.this.N = null;
                if (CommentPresenter.this.U != null) {
                    CommentPresenter.this.U.a(0, certifiedAccountMeta$StComment);
                    CommentPresenter.this.U.notifyDataSetChanged();
                }
                if (CommentPresenter.this.F != null) {
                    QLog.d(CommentPresenter.B0, 1, "mNeedShowCommentList1");
                    CommentPresenter.this.F.setSelection(0);
                }
            }
            CommentPresenter.this.M.z0("");
            CommentPresenter.this.M.w0(null);
            CommentPresenter.this.M.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnShowListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StComment f95894d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StReply f95895e;

        d(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
            this.f95894d = certifiedAccountMeta$StComment;
            this.f95895e = certifiedAccountMeta$StReply;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (CommentPresenter.this.f95873p0 != null) {
                CommentPresenter.this.f95873p0.f(dialogInterface);
            }
            CommentPresenter.this.M.z0(com.tencent.biz.subscribe.utils.i.d().c(CommentPresenter.this.P0(), this.f95894d, this.f95895e));
            SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements SubscribeCommentInputPopupWindow.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StComment f95897a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StReply f95898b;

        e(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
            this.f95897a = certifiedAccountMeta$StComment;
            this.f95898b = certifiedAccountMeta$StReply;
        }

        @Override // com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.h
        public void onDismiss() {
            CommentPresenter.this.N = null;
            if (CommentPresenter.this.M != null) {
                CommentPresenter.this.M.w0(null);
                if (CommentPresenter.this.f95861d0 && CommentPresenter.this.J != null) {
                    CommentPresenter.this.J.setText(CommentPresenter.this.M.k0());
                }
                com.tencent.biz.subscribe.utils.i.d().e(CommentPresenter.this.P0(), this.f95897a, this.f95898b, CommentPresenter.this.M.k0());
                CommentPresenter.this.M.z0("");
            }
            if (CommentPresenter.this.f95862e0 && CommentPresenter.this.Q != 0) {
                CommentPresenter.this.e1(false);
                CommentPresenter.this.f95862e0 = false;
            }
            if (CommentPresenter.this.f95873p0 != null) {
                CommentPresenter.this.f95873p0.d();
            }
            View view = CommentPresenter.this.H;
            if (view != null && view.getVisibility() == 8) {
                SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends QQUIEventReceiver<CommentPresenter, com.tencent.biz.subscribe.comment.d> {
        public f(@NonNull CommentPresenter commentPresenter) {
            super(commentPresenter);
        }

        @Override // com.tribe.async.dispatch.QQUIEventReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(@NonNull CommentPresenter commentPresenter, @NonNull com.tencent.biz.subscribe.comment.d dVar) {
            int i3 = dVar.f96002d;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        commentPresenter.f95866i0 = false;
                        commentPresenter.f95869l0 = null;
                        commentPresenter.Y = null;
                        Object obj = dVar.f96003e;
                        if (obj instanceof Object[]) {
                            Object[] objArr = (Object[]) obj;
                            if (objArr.length >= 2) {
                                Object obj2 = objArr[0];
                                if (obj2 instanceof CertifiedAccountMeta$StFeed) {
                                    Object obj3 = objArr[1];
                                    if (obj3 instanceof Integer) {
                                        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = (CertifiedAccountMeta$StFeed) obj2;
                                        int intValue = ((Integer) obj3).intValue();
                                        if (commentPresenter.c1(certifiedAccountMeta$StFeed)) {
                                            commentPresenter.f95867j0.put(Integer.valueOf(intValue), certifiedAccountMeta$StFeed);
                                            QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + intValue + ", cellId:" + certifiedAccountMeta$StFeed.f24925id.get());
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i3 == 6) {
                        commentPresenter.T0((Object[]) dVar.f96003e);
                        return;
                    }
                    return;
                }
                commentPresenter.H0();
                return;
            }
            commentPresenter.I0();
        }

        @Override // com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect
        public Class acceptEventClass() {
            return com.tencent.biz.subscribe.comment.d.class;
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onDismiss();

        void onShow();
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, boolean z16, long j3, String str);

        void b(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i implements m {

        /* loaded from: classes5.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StComment f95901d;

            a(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
                this.f95901d = certifiedAccountMeta$StComment;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (CommentPresenter.this.P0() != null) {
                    CommentPresenter commentPresenter = CommentPresenter.this;
                    commentPresenter.Z = commentPresenter.O0().i(CommentPresenter.this.P0(), this.f95901d);
                    CommentPresenter.this.f95860c0 = true;
                }
                CommentPresenter.this.V.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* loaded from: classes5.dex */
        class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StComment f95903d;

            b(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
                this.f95903d = certifiedAccountMeta$StComment;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                CommentPresenter commentPresenter = CommentPresenter.this;
                commentPresenter.L0(commentPresenter.P0(), this.f95903d, null);
                CommentPresenter.this.V.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* loaded from: classes5.dex */
        class c implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StComment f95905d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StReply f95906e;

            c(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
                this.f95905d = certifiedAccountMeta$StComment;
                this.f95906e = certifiedAccountMeta$StReply;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                CommentPresenter commentPresenter = CommentPresenter.this;
                commentPresenter.f95858a0 = commentPresenter.O0().h(CommentPresenter.this.P0(), this.f95905d, this.f95906e);
                CommentPresenter.this.f95860c0 = true;
                CommentPresenter.this.V.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* loaded from: classes5.dex */
        class d implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StComment f95908d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StReply f95909e;

            d(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
                this.f95908d = certifiedAccountMeta$StComment;
                this.f95909e = certifiedAccountMeta$StReply;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                CommentPresenter commentPresenter = CommentPresenter.this;
                commentPresenter.L0(commentPresenter.P0(), this.f95908d, this.f95909e);
                CommentPresenter.this.V.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        i() {
        }

        @Override // com.tencent.biz.subscribe.comment.m
        public void onClick(View view, int i3, int i16, Object obj) {
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            switch (i3) {
                case 1:
                case 2:
                    if (obj != null && (obj instanceof CertifiedAccountMeta$StUser)) {
                        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = (CertifiedAccountMeta$StUser) obj;
                        if (certifiedAccountMeta$StUser.type.get() == 1) {
                            com.tencent.biz.subscribe.d.t(CommentPresenter.this.D, certifiedAccountMeta$StUser);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                case 5:
                case 8:
                default:
                    return;
                case 4:
                    if (obj != null && (obj instanceof CertifiedAccountMeta$StComment)) {
                        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment = (CertifiedAccountMeta$StComment) obj;
                        QLog.d(CommentPresenter.B0, 1, "click comment, feedId: " + CommentPresenter.this.P0().f24925id + " commentId: " + certifiedAccountMeta$StComment.f24924id);
                        CommentPresenter.this.i1(certifiedAccountMeta$StComment, null);
                        return;
                    }
                    return;
                case 6:
                    if (obj != null && (obj instanceof CertifiedAccountMeta$StComment)) {
                        CommentPresenter commentPresenter = CommentPresenter.this;
                        commentPresenter.f95859b0 = commentPresenter.O0().w(CommentPresenter.this.P0(), (CertifiedAccountMeta$StComment) obj);
                        CommentPresenter.this.f95860c0 = true;
                        return;
                    }
                    return;
                case 7:
                    if (obj != null && (obj instanceof Object[])) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length > 1 && (obj2 = objArr[0]) != null && (obj3 = objArr[1]) != null && (obj2 instanceof CertifiedAccountMeta$StComment) && (obj3 instanceof CertifiedAccountMeta$StReply)) {
                            CertifiedAccountMeta$StComment certifiedAccountMeta$StComment2 = (CertifiedAccountMeta$StComment) obj2;
                            CertifiedAccountMeta$StReply certifiedAccountMeta$StReply = (CertifiedAccountMeta$StReply) obj3;
                            QLog.d(CommentPresenter.B0, 1, "click reply, feedId: " + CommentPresenter.this.P0().f24925id + " commentId: " + certifiedAccountMeta$StComment2.f24924id + " replyId: " + certifiedAccountMeta$StReply.f24928id);
                            CommentPresenter.this.i1(certifiedAccountMeta$StComment2, certifiedAccountMeta$StReply);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    if (obj != null && (obj instanceof Object[])) {
                        Object[] objArr2 = (Object[]) obj;
                        if (objArr2.length > 1 && (obj4 = objArr2[0]) != null && objArr2[1] != null) {
                            CommentPresenter.this.O0().x(CommentPresenter.this.P0(), (CertifiedAccountMeta$StComment) obj4, (CertifiedAccountMeta$StReply) objArr2[1]);
                            CommentPresenter.this.f95860c0 = true;
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (obj != null && (obj instanceof CertifiedAccountMeta$StComment)) {
                        CommentPresenter.this.U.k((CertifiedAccountMeta$StComment) obj);
                        return;
                    }
                    return;
                case 11:
                    if (obj != null && (obj instanceof Object[])) {
                        Object[] objArr3 = (Object[]) obj;
                        if (objArr3.length > 1 && (obj5 = objArr3[0]) != null) {
                            int j3 = CommentPresenter.this.U.j((CertifiedAccountMeta$StComment) obj5);
                            if (j3 >= 0 && (obj6 = objArr3[1]) != null) {
                                CommentPresenter.this.F.setSelectionFromTop(i16, j3 * (-1) * ((Integer) obj6).intValue());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
            }
        }

        @Override // com.tencent.biz.subscribe.comment.m
        public void onLongClick(View view, int i3, int i16, Object obj) {
            Object obj2;
            Object obj3;
            if (i3 != 5) {
                if (i3 == 8 && obj != null && (obj instanceof Object[])) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length > 1 && (obj2 = objArr[0]) != null && (obj3 = objArr[1]) != null && (obj2 instanceof CertifiedAccountMeta$StComment) && (obj3 instanceof CertifiedAccountMeta$StReply)) {
                        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment = (CertifiedAccountMeta$StComment) obj2;
                        CertifiedAccountMeta$StReply certifiedAccountMeta$StReply = (CertifiedAccountMeta$StReply) obj3;
                        CommentPresenter.this.V = new ActionSheetDialog(CommentPresenter.this.a(), false, true);
                        if (CommentPresenter.this.d1(certifiedAccountMeta$StReply.postUser)) {
                            CommentPresenter.this.V.addButton(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d.getString(R.string.ajx), 1, new c(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply));
                        } else {
                            CommentPresenter.this.V.addButton(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d.getString(R.string.h1u), 6, new d(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply));
                        }
                        CommentPresenter.this.V.X(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d.getString(R.string.cancel));
                        CommentPresenter.this.V.show();
                        return;
                    }
                    return;
                }
                return;
            }
            if (obj != null && (obj instanceof CertifiedAccountMeta$StComment)) {
                CertifiedAccountMeta$StComment certifiedAccountMeta$StComment2 = (CertifiedAccountMeta$StComment) obj;
                CommentPresenter.this.V = new ActionSheetDialog(CommentPresenter.this.a(), false, true);
                if (CommentPresenter.this.d1(certifiedAccountMeta$StComment2.postUser)) {
                    CommentPresenter.this.V.addButton(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d.getString(R.string.ajx), 1, new a(certifiedAccountMeta$StComment2));
                } else {
                    CommentPresenter.this.V.addButton(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d.getString(R.string.h1u), 6, new b(certifiedAccountMeta$StComment2));
                }
                CommentPresenter.this.V.X(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d.getString(R.string.cancel));
                CommentPresenter.this.V.show();
            }
        }
    }

    public CommentPresenter(Activity activity, boolean z16, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, h hVar, ExtraTypeInfo extraTypeInfo) {
        super(activity, z16);
        this.R = new HashMap();
        this.S = new HashMap();
        this.T = new HashMap();
        this.f95861d0 = false;
        this.f95862e0 = false;
        this.f95865h0 = false;
        this.f95866i0 = false;
        this.f95867j0 = new HashMap();
        this.f95881x0 = new b();
        this.f95882y0 = new View.OnLayoutChangeListener() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                QLog.d(CommentPresenter.B0, 2, "OnLayoutChangeListener scrollToReplyView start mScrollToTargetReply" + CommentPresenter.this.f95880w0);
                if (CommentPresenter.this.f95878u0 != null && CommentPresenter.this.f95880w0) {
                    CommentPresenter.this.h(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CommentPresenter commentPresenter = CommentPresenter.this;
                            commentPresenter.m1(0, commentPresenter.f95878u0.getReplyId());
                            CommentPresenter.this.f95880w0 = false;
                        }
                    });
                }
            }
        };
        this.A0 = -1;
        this.D = activity;
        f fVar = new f(this);
        this.C = fVar;
        com.tencent.biz.qqstory.base.c.a().registerSubscriber(fVar);
        this.f95874q0 = hVar;
        this.f95878u0 = extraTypeInfo;
        l1();
        p1(certifiedAccountMeta$StFeed);
        M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CertifiedAccountMeta$StComment J0(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        return new CertifiedAccountMeta$StComment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CertifiedAccountMeta$StReply K0(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        if (certifiedAccountMeta$StComment == null) {
            return null;
        }
        return new CertifiedAccountMeta$StReply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        String str;
        String str2;
        if (certifiedAccountMeta$StFeed != null && certifiedAccountMeta$StComment != null) {
            StringBuilder sb5 = new StringBuilder();
            if (certifiedAccountMeta$StReply == null) {
                str2 = certifiedAccountMeta$StComment.postUser.f24929id.get();
                sb5.append("uin:");
                sb5.append(certifiedAccountMeta$StFeed.poster.f24929id.get());
                sb5.append("|evil_uin:");
                sb5.append(str2);
                sb5.append("|feed_id:");
                sb5.append(certifiedAccountMeta$StFeed.f24925id.get());
                sb5.append("|comment_id:");
                sb5.append(certifiedAccountMeta$StComment.f24924id.get());
                str = certifiedAccountMeta$StComment.content.get();
            } else {
                String str3 = certifiedAccountMeta$StReply.postUser.f24929id.get();
                sb5.append("uin:");
                sb5.append(certifiedAccountMeta$StFeed.poster.f24929id.get());
                sb5.append("|evil_uin:");
                sb5.append(str3);
                sb5.append("|feed_id:");
                sb5.append(certifiedAccountMeta$StFeed.f24925id.get());
                sb5.append("|comment_id:");
                sb5.append(certifiedAccountMeta$StComment.f24924id.get());
                sb5.append("|reply_id:");
                sb5.append(certifiedAccountMeta$StReply.f24928id.get());
                str = certifiedAccountMeta$StReply.content.get();
                str2 = str3;
            }
            a.b bVar = new a.b();
            bVar.f96249a = "android";
            bVar.f96250b = AppSetting.n();
            bVar.f96251c = "1";
            bVar.f96252d = str2;
            bVar.f96253e = "KQQ";
            bVar.f96254f = "2400002";
            bVar.f96255g = "qzone_authentication_comment";
            bVar.f96256h = "24000";
            bVar.f96257i = "0";
            bVar.f96259k = sb5.toString();
            bVar.f96260l = str;
            com.tencent.biz.subscribe.utils.a.c(this.f95710d, bVar);
        }
    }

    private void M0() {
        if (N0() != null) {
            this.f95871n0 = true;
            ExtraTypeInfo extraTypeInfo = this.f95878u0;
            if (extraTypeInfo != null && !TextUtils.isEmpty(extraTypeInfo.getCommentId())) {
                O0().n(P0(), false, this.f95878u0.getCommentId());
            } else {
                O0().n(P0(), false, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N0() {
        if (P0() == null) {
            QLog.e(B0, 2, "getCellId null");
            return "";
        }
        return P0().f24925id.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.biz.subscribe.comment.c O0() {
        if (this.f95868k0 == null) {
            com.tencent.biz.subscribe.comment.c cVar = new com.tencent.biz.subscribe.comment.c();
            this.f95868k0 = cVar;
            this.f95876s0 = cVar.hashCode();
        }
        return this.f95868k0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CertifiedAccountMeta$StFeed P0() {
        return this.f95867j0.get(Integer.valueOf(R0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CertifiedAccountMeta$StUser Q0() {
        if (com.tencent.biz.subscribe.c.c() != null) {
            return com.tencent.biz.subscribe.c.c();
        }
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = new CertifiedAccountMeta$StUser();
        certifiedAccountMeta$StUser.f24929id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        certifiedAccountMeta$StUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        certifiedAccountMeta$StUser.type.set(0);
        return certifiedAccountMeta$StUser;
    }

    private CertifiedAccountMeta$StReply S0(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, String str) {
        if (certifiedAccountMeta$StComment != null && certifiedAccountMeta$StComment.vecReply.get() != null && certifiedAccountMeta$StComment.vecReply.get().size() > 0) {
            for (CertifiedAccountMeta$StReply certifiedAccountMeta$StReply : certifiedAccountMeta$StComment.vecReply.get()) {
                if (certifiedAccountMeta$StReply.f24928id.get().equals(str)) {
                    return certifiedAccountMeta$StReply;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(Object[] objArr) {
        String str;
        Object obj;
        Object obj2;
        l lVar;
        l lVar2;
        l lVar3;
        Long l3 = (Long) objArr[1];
        Object obj3 = objArr[2];
        if (((String) obj3) == null) {
            str = "";
        } else {
            str = (String) obj3;
        }
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue != 9) {
            switch (intValue) {
                case 1:
                    M0();
                    return;
                case 2:
                    this.f95860c0 = false;
                    Object obj4 = objArr[3];
                    if (obj4 != null) {
                        CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp = (CertifiedAccountRead$StGetFeedDetailRsp) obj4;
                        if (b1(4, objArr)) {
                            return;
                        }
                        p1(certifiedAccountRead$StGetFeedDetailRsp.feed.get());
                        h hVar = this.f95874q0;
                        if (hVar != null) {
                            hVar.a(certifiedAccountRead$StGetFeedDetailRsp, VSNetworkHelper.isProtocolCache(str), l3.longValue(), str);
                        }
                        if (objArr.length >= 6 && (obj2 = objArr[5]) != null) {
                            COMM.StCommonExt stCommonExt = (COMM.StCommonExt) obj2;
                            ArrayList<CertifiedAccountMeta$StComment> s16 = O0().s(N0());
                            if (stCommonExt.mapInfo.size() > 0) {
                                String str2 = stCommonExt.mapInfo.get(0).value.get();
                                if (s16 != null && s16.size() > 0 && s16.get(0).f24924id.get().equals(str2)) {
                                    ExtraTypeInfo extraTypeInfo = this.f95878u0;
                                    if (extraTypeInfo != null && !TextUtils.isEmpty(extraTypeInfo.getReplyId())) {
                                        CertifiedAccountMeta$StReply S0 = S0(s16.get(0), this.f95878u0.getReplyId());
                                        if (S0 != null) {
                                            s1();
                                            SimpleEventBus.getInstance().dispatchEvent(new CommentReplyEvent(s16.get(0), S0));
                                            this.f95879v0 = true;
                                            this.f95880w0 = true;
                                        } else {
                                            h(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.11
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    QQToast.makeText(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d, "\u8bc4\u8bba\u5df2\u88ab\u5220\u9664", 0).show();
                                                }
                                            });
                                        }
                                    } else {
                                        s1();
                                        SimpleEventBus.getInstance().dispatchEvent(new CommentReplyEvent(s16.get(0), null));
                                    }
                                } else {
                                    h(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.12
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            QQToast.makeText(((com.tencent.biz.subscribe.baseUI.a) CommentPresenter.this).f95710d, "\u8bc4\u8bba\u5df2\u88ab\u5220\u9664", 0).show();
                                        }
                                    });
                                }
                            }
                        }
                        if (this.f95866i0) {
                            h(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.13
                                @Override // java.lang.Runnable
                                public void run() {
                                    CommentPresenter.this.Y0();
                                    ListView listView = CommentPresenter.this.F;
                                    if (listView != null) {
                                        listView.setSelection(0);
                                    }
                                }
                            });
                        }
                    } else {
                        QLog.w(B0, 1, "get feed detail response failed");
                        h hVar2 = this.f95874q0;
                        if (hVar2 != null) {
                            hVar2.a(null, VSNetworkHelper.isProtocolCache(str), l3.longValue(), str);
                        }
                        if (!this.f95871n0) {
                            QQToast.makeText(a(), str, 0).show();
                        }
                    }
                    if (this.f95871n0) {
                        this.f95871n0 = false;
                        return;
                    }
                    return;
                case 3:
                    SubscribeCommentInputPopupWindow subscribeCommentInputPopupWindow = this.M;
                    if (subscribeCommentInputPopupWindow != null) {
                        subscribeCommentInputPopupWindow.m0(this.J);
                    }
                    if (b1(5, objArr)) {
                        return;
                    }
                    if (l3.longValue() != 0) {
                        QLog.e(B0, 1, "comment fail ret=" + l3 + " msg=" + str);
                    }
                    Object obj5 = objArr[3];
                    if (obj5 instanceof CertifiedAccountWrite$StDoCommentRsp) {
                        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment = ((CertifiedAccountWrite$StDoCommentRsp) obj5).comment;
                        if (l3.longValue() != 0 && (lVar = this.U) != null && lVar.e(String.valueOf(objArr[4]))) {
                            w1();
                        }
                        if (l3.longValue() == 0) {
                            l lVar4 = this.U;
                            if (lVar4 != null && lVar4.l(String.valueOf(objArr[4]), certifiedAccountMeta$StComment)) {
                                w1();
                            }
                            x1(1);
                        }
                    }
                    v1(l3.longValue(), HardCodeUtil.qqStr(R.string.ktj), str);
                    O0().r().postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.14
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.biz.qqstory.base.c.a().dispatch(new com.tencent.biz.subscribe.comment.d(1, new Object[0]));
                        }
                    }, 1000L);
                    return;
                case 4:
                    if (b1(6, objArr)) {
                        return;
                    }
                    SubscribeCommentInputPopupWindow subscribeCommentInputPopupWindow2 = this.M;
                    if (subscribeCommentInputPopupWindow2 != null) {
                        subscribeCommentInputPopupWindow2.m0(this.J);
                    }
                    if (l3.longValue() != 0) {
                        QLog.e(B0, 1, "reply fail ret=" + l3 + " msg=" + str);
                    }
                    Object obj6 = objArr[3];
                    if (obj6 instanceof CertifiedAccountWrite$StDoReplyRsp) {
                        CertifiedAccountMeta$StReply certifiedAccountMeta$StReply = ((CertifiedAccountWrite$StDoReplyRsp) obj6).reply;
                        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment2 = (CertifiedAccountMeta$StComment) objArr[4];
                        String str3 = (String) objArr[5];
                        if (l3.longValue() != 0 && (lVar3 = this.U) != null && lVar3.f(certifiedAccountMeta$StComment2.f24924id.get(), str3)) {
                            w1();
                        }
                        if (l3.longValue() == 0 && (lVar2 = this.U) != null && lVar2.m(certifiedAccountMeta$StComment2.f24924id.get(), str3, certifiedAccountMeta$StReply)) {
                            w1();
                        }
                    }
                    v1(l3.longValue(), HardCodeUtil.qqStr(R.string.kta), HardCodeUtil.qqStr(R.string.ktn));
                    return;
                case 5:
                    if (b1(4, objArr)) {
                        return;
                    }
                    if (l3.longValue() == 0) {
                        Object obj7 = objArr[3];
                        if (obj7 instanceof CertifiedAccountWrite$StDoCommentRsp) {
                            String str4 = ((CertifiedAccountWrite$StDoCommentRsp) obj7).comment.f24924id.get();
                            l lVar5 = this.U;
                            if (lVar5 != null && lVar5.e(str4)) {
                                w1();
                            }
                            x1(-1);
                        }
                    }
                    v1(l3.longValue(), HardCodeUtil.qqStr(R.string.ktc), HardCodeUtil.qqStr(R.string.ktm));
                    return;
                case 6:
                    if (b1(5, objArr)) {
                        return;
                    }
                    v1(l3.longValue(), HardCodeUtil.qqStr(R.string.kti), HardCodeUtil.qqStr(R.string.ktp));
                    Object obj8 = objArr[3];
                    if ((obj8 instanceof CertifiedAccountWrite$StDoReplyRsp) && (objArr[4] instanceof CertifiedAccountMeta$StComment)) {
                        String str5 = ((CertifiedAccountWrite$StDoReplyRsp) obj8).reply.f24928id.get();
                        String str6 = ((CertifiedAccountMeta$StComment) objArr[4]).f24924id.get();
                        if (l3.longValue() == 0 && this.U != null && !TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str5)) {
                            this.U.f(str6, str5);
                            w1();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        if (b1(4, objArr)) {
            return;
        }
        Object obj9 = objArr[3];
        if (obj9 instanceof CertifiedAccountRead$StGetCommentListRsp) {
            if (this.U != null) {
                List<CertifiedAccountMeta$StComment> list = ((CertifiedAccountRead$StGetCommentListRsp) obj9).vecComment.get();
                if (objArr.length >= 6 && (obj = objArr[5]) != null && (obj instanceof String)) {
                    list = this.f95868k0.p(list, (String) obj);
                }
                this.U.c(list);
            }
            w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        if (this.H != null && !this.f95865h0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f95710d, R.anim.f154517am);
            this.f95863f0 = loadAnimation;
            loadAnimation.setAnimationListener(this);
            this.f95875r0.startAnimation(this.f95863f0);
            SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
        }
        this.f95866i0 = false;
    }

    private void V0(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        SubscribeCommentInputPopupWindow subscribeCommentInputPopupWindow = this.M;
        if (subscribeCommentInputPopupWindow == null) {
            QLog.e(B0, 1, "mCommentInputPopupWindow == null");
        } else {
            subscribeCommentInputPopupWindow.setOnShowListener(new d(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply));
            this.M.y0(new e(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply));
        }
    }

    private void W0() {
        this.F = (ListView) m(R.id.c4v);
        this.H = m(R.id.b3r);
        this.f95875r0 = m(R.id.c4w);
        this.K = (TextView) m(R.id.b4k);
        this.I = m(R.id.f164853b42);
        TextView textView = (TextView) m(R.id.jha);
        this.J = textView;
        textView.setOnClickListener(this);
        View m3 = m(R.id.ah5);
        this.L = m3;
        m3.setOnClickListener(this);
        this.F.setOnScrollListener(this.f95881x0);
        this.F.addOnLayoutChangeListener(this.f95882y0);
        this.G = new i();
        l lVar = new l(this.f95710d, this.G);
        this.U = lVar;
        lVar.g(this.f95877t0);
        this.F.setAdapter((ListAdapter) this.U);
        this.F.setEmptyView(this.I);
        View view = this.H;
        if (view != null) {
            view.setOnClickListener(new a());
        }
    }

    private synchronized void X0() {
        if (this.f95868k0 == null) {
            QLog.e(B0, 1, "innerInitData return empty because CommentBusiness is null ");
            return;
        }
        this.f95869l0 = O0().s(N0());
        this.Y = O0().j(N0());
        if (this.f95869l0 == null) {
            return;
        }
        l lVar = this.U;
        if (lVar != null) {
            lVar.d();
            this.U.c(this.f95869l0);
            if (this.f95879v0) {
                this.U.h(0);
            }
            this.U.notifyDataSetChanged();
        }
        if (this.F != null && this.A0 != R0() && this.f95879v0) {
            this.A0 = R0();
            QLog.d(B0, 1, "mNeedShowCommentList2");
            this.F.setSelection(0);
        }
        ArrayList<CertifiedAccountMeta$StComment> arrayList = this.f95869l0;
        if (arrayList != null && arrayList.size() > 0) {
            this.f95870m0 = O0().t(N0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Y0() {
        TextUtils.isEmpty(N0());
        X0();
        boolean z16 = true;
        SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(true));
        ArrayList<CertifiedAccountMeta$StComment> arrayList = this.f95869l0;
        if (arrayList != null && arrayList.size() > 0) {
            TextView textView = this.K;
            if (textView != null) {
                textView.setText(com.tencent.biz.subscribe.comment.i.a(this.f95870m0));
                this.K.setVisibility(0);
            }
        } else {
            TextView textView2 = this.K;
            if (textView2 != null) {
                textView2.setText("");
                this.K.setVisibility(8);
            }
        }
        View view = this.H;
        if (view != null && view.getVisibility() != 0) {
            this.H.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            this.f95864g0 = translateAnimation;
            translateAnimation.setDuration(200L);
            this.f95864g0.setAnimationListener(this);
            this.f95864g0.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f95875r0.startAnimation(this.f95864g0);
        }
        if (this.U.getCount() != 0) {
            z16 = false;
        }
        y1(z16);
    }

    private boolean b1(int i3, Object[] objArr) {
        if (this.f95876s0 != ((Integer) objArr[i3]).intValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d1(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
        if (certifiedAccountMeta$StUser != null && com.tencent.biz.subscribe.c.c() != null && certifiedAccountMeta$StUser.f24929id.get().equals(com.tencent.biz.subscribe.c.c().f24929id.get())) {
            return true;
        }
        if (certifiedAccountMeta$StUser != null && certifiedAccountMeta$StUser.f24929id.get().equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(boolean z16) {
        TextView textView;
        boolean z17 = true;
        QLog.d(B0, 1, "loadFeedDisplay() isRefresh => " + z16);
        if (z16) {
            k1();
        }
        if (this.H.getVisibility() == 0) {
            z17 = false;
        }
        n1(0);
        if (z17) {
            s1();
        }
        SubscribeCommentInputPopupWindow subscribeCommentInputPopupWindow = this.M;
        if (subscribeCommentInputPopupWindow != null && (textView = this.J) != null) {
            textView.setText(subscribeCommentInputPopupWindow.k0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        QLog.e(B0, 1, "popupComment");
        u1(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply, true, false);
    }

    private void k1() {
        O0().m(P0(), false);
    }

    private void l1() {
        this.f95879v0 = false;
        this.f95880w0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i3, String str) {
        View childAt = this.F.getChildAt(i3);
        if (childAt instanceof CommentView) {
            CommentView commentView = (CommentView) childAt;
            ReplyView f16 = commentView.f(str);
            LinearLayout e16 = commentView.e();
            if (f16 != null && e16 != null) {
                int top = e16.getTop();
                int top2 = f16.getTop();
                QLog.d(B0, 2, "scrollToReplyView getTop containerTop:" + top + "replyViewTop:" + top2);
                this.F.setSelectionFromTop(i3, -(top + top2));
            }
        }
    }

    private void n1(int i3) {
        if (this.H == null) {
            QLog.d(B0, 1, "setCommentContainerVisible() mCommentContainer == null.");
            return;
        }
        if (i3 == 0) {
            this.U.g(P0().poster.f24929id.get());
        }
        this.H.setVisibility(i3);
    }

    private void p1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed != null) {
            this.f95877t0 = certifiedAccountMeta$StFeed.poster.f24929id.get();
        }
        this.f95867j0.put(Integer.valueOf(R0()), certifiedAccountMeta$StFeed);
    }

    private void u1(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply, boolean z16, boolean z17) {
        if (this.f95710d != null && BaseApplication.getContext() != null) {
            if (this.M == null) {
                this.M = new SubscribeCommentInputPopupWindow((Activity) this.f95710d);
            }
            if (certifiedAccountMeta$StReply != null) {
                if (certifiedAccountMeta$StReply.postUser != null) {
                    String format = String.format(this.f95710d.getString(R.string.f170928b51), certifiedAccountMeta$StReply.postUser.nick.get());
                    if (format.length() > 10) {
                        format = format.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    this.M.w0(format);
                }
            } else if (certifiedAccountMeta$StComment != null && certifiedAccountMeta$StComment.postUser != null) {
                String format2 = String.format(this.f95710d.getString(R.string.f170928b51), certifiedAccountMeta$StComment.postUser.nick.get());
                if (format2.length() > 10) {
                    format2 = format2.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.M.w0(format2);
            } else {
                this.M.w0(this.f95710d.getString(R.string.b4w));
            }
            this.M.x0(new c(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply));
            V0(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply);
            this.M.A0(z17);
            return;
        }
        QLog.e(B0, 1, "plugin environment exception ! ");
    }

    private void v1(long j3, String str, String str2) {
        if (j3 == 0) {
            QQToast.makeText(a(), 2, str, 0).show();
        } else if (!NetworkUtils.isNetworkAvailable(this.f95710d)) {
            QQToast.makeText(a(), 1, a().getResources().getString(R.string.cib), 0).show();
        } else {
            QQToast.makeText(a(), 1, str2, 0).show();
        }
    }

    private void w1() {
        h(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                CommentPresenter.this.U.notifyDataSetChanged();
            }
        });
    }

    private void x1(int i3) {
        if (this.f95870m0 == 0) {
            this.f95870m0 = O0().t(N0());
        }
        this.f95870m0 += i3;
        h(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                if (CommentPresenter.this.f95874q0 != null) {
                    CommentPresenter.this.f95874q0.b(CommentPresenter.this.f95870m0);
                }
                if (CommentPresenter.this.K != null) {
                    if (CommentPresenter.this.f95870m0 > 0) {
                        CommentPresenter.this.K.setText(com.tencent.biz.subscribe.comment.i.a(CommentPresenter.this.f95870m0));
                        CommentPresenter.this.K.setVisibility(0);
                    } else {
                        CommentPresenter.this.K.setText("");
                        CommentPresenter.this.K.setVisibility(8);
                    }
                }
            }
        });
        com.tencent.biz.qqstory.base.c.a().dispatch(new com.tencent.biz.subscribe.comment.d(5, N0(), Integer.valueOf(this.f95870m0)));
    }

    private void y1(boolean z16) {
        TextView textView;
        View view = this.I;
        if (view != null && (textView = (TextView) view.findViewById(R.id.f166327f13)) != null) {
            if (z16) {
                textView.setText(R.string.c2w);
            } else {
                textView.setText("");
            }
        }
    }

    public void H0() {
        boolean z16;
        View view = this.H;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            U0();
        }
    }

    public void I0() {
        boolean z16;
        View view = this.H;
        if (view != null && view.getVisibility() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            l lVar = this.U;
            if (lVar != null) {
                lVar.g(P0().poster.f24929id.get());
            }
            s1();
        }
    }

    public int R0() {
        return 0;
    }

    public boolean Z0() {
        View view = this.H;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean a1() {
        SubscribeCommentInputPopupWindow subscribeCommentInputPopupWindow = this.M;
        if (subscribeCommentInputPopupWindow != null && subscribeCommentInputPopupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public boolean c1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed != null && !TextUtils.isEmpty(certifiedAccountMeta$StFeed.f24925id.get())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.subscribe.baseUI.a
    protected void d() {
        com.tencent.biz.qqstory.base.c.a().unRegisterSubscriber(this.C);
        O0().y();
        this.f95868k0 = null;
        ArrayList<CertifiedAccountMeta$StComment> arrayList = this.f95869l0;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f95867j0.clear();
    }

    public boolean f1() {
        View view = this.H;
        if (view != null && view.getVisibility() == 0) {
            U0();
            return true;
        }
        return false;
    }

    public void g1(View view) {
        u1(null, null, true, true);
    }

    public void h1(View view) {
        u1(null, null, true, false);
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return true;
    }

    public void j1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        p1(certifiedAccountMeta$StFeed);
        M0();
    }

    @Override // com.tencent.biz.subscribe.baseUI.b
    protected View l() {
        return null;
    }

    @Override // com.tencent.biz.subscribe.baseUI.b
    protected int n() {
        return R.layout.f167708eo;
    }

    @Override // com.tencent.biz.subscribe.baseUI.b
    protected void o() {
        W0();
    }

    public void o1(n nVar) {
        this.f95873p0 = nVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.f95863f0) {
            View view = this.H;
            if (view != null) {
                view.setVisibility(8);
            }
            Activity activity = this.D;
            if (activity != null && (activity instanceof BaseActivity)) {
                SystemBarActivityModule.getSystemBarComp((BaseActivity) activity).setStatusBarMask(null);
            }
            this.f95865h0 = false;
            g gVar = this.f95872o0;
            if (gVar != null) {
                gVar.onDismiss();
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (animation == this.f95863f0) {
            this.f95865h0 = true;
            QLog.d(B0, 2, "mHideCommentListAnimation onAnimationStarttrue");
            return;
        }
        if (animation == this.f95864g0) {
            g gVar = this.f95872o0;
            if (gVar != null) {
                gVar.onShow();
            }
            QLog.d(B0, 2, "mShowCommentListAnimation onAnimationStarttrue");
            if (this.D instanceof BaseActivity) {
                Resources b16 = b();
                SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((BaseActivity) this.D);
                if (b16 != null && systemBarComp != null) {
                    systemBarComp.setStatusBarMask(new PorterDuffColorFilter(b16.getColor(R.color.aeo), PorterDuff.Mode.SRC_ATOP));
                }
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        compoundButton.getId();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.jha) {
            h1(view);
        } else if (id5 == R.id.ah5) {
            g1(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void q1(ViewStub viewStub) {
        this.E = viewStub;
    }

    public void r1(g gVar) {
        this.f95872o0 = gVar;
    }

    public void s1() {
        int i3;
        ViewStub viewStub = this.E;
        if (viewStub != null) {
            p(viewStub);
            this.E = null;
        }
        if (N0() == null && (i3 = this.f95883z0) <= 3) {
            this.f95883z0 = i3 + 1;
            O0().r().postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.9
                @Override // java.lang.Runnable
                public void run() {
                    CommentPresenter.this.s1();
                }
            }, this.f95883z0 * 500);
            return;
        }
        CertifiedAccountMeta$StFeed P0 = P0();
        String N0 = N0();
        if (N0 != null) {
            ArrayList<CertifiedAccountMeta$StComment> s16 = O0().s(N0);
            this.f95869l0 = s16;
            if (this.f95860c0) {
                this.f95866i0 = true;
                O0().m(P0, false);
            } else if (s16 == null) {
                this.f95866i0 = true;
                O0().m(P0, false);
            } else {
                Y0();
            }
        }
    }

    public void t1(final CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, final CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        int i3;
        ViewStub viewStub = this.E;
        if (viewStub != null) {
            p(viewStub);
            this.E = null;
        }
        if (N0() == null && (i3 = this.f95883z0) <= 3) {
            this.f95883z0 = i3 + 1;
            O0().r().postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentPresenter.10
                @Override // java.lang.Runnable
                public void run() {
                    CommentPresenter.this.t1(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply);
                }
            }, this.f95883z0 * 500);
            return;
        }
        String N0 = N0();
        if (!StringUtil.isEmpty(N0) && P0() != null && P0().vecComment.size() == 0 && P0().commentCount.get() != 0) {
            ArrayList<CertifiedAccountMeta$StComment> s16 = O0().s(N0);
            this.f95869l0 = s16;
            if (s16 != null && !this.f95860c0) {
                X0();
            } else {
                O0().m(P0(), false);
            }
        }
        u1(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply, true, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.a
    public void e() {
    }

    @Override // com.tencent.biz.subscribe.baseUI.a
    protected void f() {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
