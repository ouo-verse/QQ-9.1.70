package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecommendFriendAdapter extends j implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private CopyOnWriteArrayList<MayKnowRecommend> F;
    private Context G;
    private final WeakReference<QQAppInterface> H;
    private MayknowRecommendManager I;
    private XListView J;
    private int K;
    private int L;
    private int M;
    private int N;
    g P;
    private StatusManager Q;
    private Resources R;
    private String S;
    int T;
    private f U;
    private IMessageFacade V;
    private boolean W;
    private int X;
    private final HashSet<String> Y;
    private com.tencent.mobileqq.pymk.c Z;

    /* renamed from: a0, reason: collision with root package name */
    private final com.tencent.mobileqq.pymk.api.b f187044a0;

    /* renamed from: b0, reason: collision with root package name */
    private Boolean f187045b0;

    /* renamed from: c0, reason: collision with root package name */
    private SwipListView.RightIconMenuListener f187046c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.richstatus.e f187047d0;

    /* renamed from: e0, reason: collision with root package name */
    protected Runnable f187048e0;

    /* renamed from: f0, reason: collision with root package name */
    ar f187049f0;

    /* renamed from: g0, reason: collision with root package name */
    private AbsListView.OnScrollListener f187050g0;

    /* renamed from: h0, reason: collision with root package name */
    protected Runnable f187051h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.newfriend.observer.b f187052i0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.newfriend.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected void a(int i3, structmsg$StructMsg structmsg_structmsg, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), structmsg_structmsg, Long.valueOf(j3));
                return;
            }
            if (i3 == 0 && structmsg_structmsg != null) {
                Bundle bundle = new Bundle();
                bundle.putString("base_uin", String.valueOf(structmsg_structmsg.req_uin.get()));
                String str = structmsg_structmsg.f436065msg.req_uin_nick.get();
                if (TextUtils.isEmpty(str)) {
                    str = String.valueOf(structmsg_structmsg.req_uin.get());
                }
                bundle.putString("base_nick", str);
                bundle.putInt("verfy_type", structmsg_structmsg.f436065msg.sub_type.get());
                bundle.putString("verfy_msg", structmsg_structmsg.f436065msg.msg_additional.get());
                if (com.tencent.mobileqq.newfriend.msg.c.h((AppRuntime) RecommendFriendAdapter.this.H.get(), String.valueOf(structmsg_structmsg.req_uin.get()), structmsg_structmsg, false)) {
                    String str2 = new String(structmsg_structmsg.f436065msg.bytes_game_nick.get().toByteArray());
                    if (!TextUtils.isEmpty(str2)) {
                        str = KplRoleInfo.WZRYUIinfo.buildNickName(str, str2);
                    }
                    bundle.putString("base_nick", str);
                    bundle.putBoolean("isFromWzry", true);
                }
                if (!RecommendFriendAdapter.this.W) {
                    RecommendFriendAdapter.this.W = false;
                    ReportController.o((AppRuntime) RecommendFriendAdapter.this.H.get(), "CliOper", "", "", "0X800C00F", "0X800C00F", 0, 0, "", "", String.valueOf(structmsg_structmsg.req_uin.get()), "");
                } else {
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startRemarkAfterAgree((Activity) RecommendFriendAdapter.this.G, 0, String.valueOf(structmsg_structmsg.req_uin.get()), j3, bundle);
                }
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
            String str5 = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str5, str4, Integer.valueOf(i18));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("RecommendFriendAdapter", 2, "onSendSystemMsgActionFin|isSuccess : " + z16 + ",logStr : " + str + ",actionType : " + i3 + ", msgDetail : " + str2 + ",resultCode : " + i16 + ", respType : " + i17 + "msgFail : " + str5 + "msgInvalidDecided : " + str4 + ",remarkRet : " + i18);
            }
            RecommendFriendAdapter.this.notifyDataSetChanged();
            long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            if (!TextUtils.isEmpty(str)) {
                try {
                    currStructMsgKey = Long.parseLong(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
            if (!z16) {
                if (TextUtils.isEmpty(str3)) {
                    str5 = HardCodeUtil.qqStr(R.string.he7);
                }
                QQToast.makeText(RecommendFriendAdapter.this.G, 1, str5, 0).show(44);
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).changeStructMsgActionsWhenFail(structMsgFromMap, i17, str2, str4);
                return;
            }
            if (RecommendFriendAdapter.this.W) {
                QQToast.makeText(RecommendFriendAdapter.this.G, 2, HardCodeUtil.qqStr(R.string.bcs), 0).show(44);
            }
            long currentUniseq = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrentUniseq();
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).changeStructMsgActions(structMsgFromMap, i3, str2, i16);
            if (currentUniseq != 0 && structMsgFromMap != null) {
                try {
                    RecommendFriendAdapter.this.V.updateMsgContentByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, currentUniseq, structMsgFromMap.toByteArray());
                } catch (Exception e17) {
                    e17.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i("RecommendFriendAdapter", 2, "onSendSystemMsgActionFin Exception!");
                    }
                }
            }
            a(i3, structMsgFromMap, currStructMsgKey);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            } else if (i16 == 200 && bitmap != null) {
                RecommendFriendAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends ar {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onCancelMayKnowRecommend(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "onCancelMayKnowRecommend isSuccess = " + z16);
            }
            if (z16) {
                g gVar = RecommendFriendAdapter.this.P;
                if (gVar != null && (gVar instanceof h)) {
                    ((h) gVar).a(str);
                }
                RecommendFriendAdapter.this.G();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGetMayKnowRecommend(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
            } else if (z16) {
                RecommendFriendAdapter.this.G();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onMayKnowListPushDel(boolean z16, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), list);
                return;
            }
            super.onMayKnowListPushDel(z16, list);
            if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "onMayKnowListPushDel isSuccess = " + z16);
            }
            if (z16) {
                RecommendFriendAdapter.this.G();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onMayknowStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "onMayknowStateChanged isSuccess = " + z16);
            }
            if (z16) {
                RecommendFriendAdapter.this.notifyDataSetChanged();
                if (RecommendFriendAdapter.this.J != null) {
                    RecommendFriendAdapter.this.J.removeCallbacks(RecommendFriendAdapter.this.f187048e0);
                    RecommendFriendAdapter.this.J.postDelayed(RecommendFriendAdapter.this.f187048e0, 1600L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements SwipeMenuLayout.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f187060a;

        d(i iVar) {
            this.f187060a = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this, (Object) iVar);
            }
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void a() {
            SwipListView.RightIconMenuListener rightIconMenuListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (RecommendFriendAdapter.this.J != null && (RecommendFriendAdapter.this.J instanceof SwipListView) && (rightIconMenuListener = ((SwipListView) RecommendFriendAdapter.this.J).getRightIconMenuListener()) != null) {
                rightIconMenuListener.onRightIconMenuShow(this.f187060a.f187063i);
            }
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void b() {
            SwipListView.RightIconMenuListener rightIconMenuListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (RecommendFriendAdapter.this.J != null && (RecommendFriendAdapter.this.J instanceof SwipListView) && (rightIconMenuListener = ((SwipListView) RecommendFriendAdapter.this.J).getRightIconMenuListener()) != null) {
                rightIconMenuListener.onRightIconMenuHide(this.f187060a.f187063i);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else if (i3 + i16 > i17 - 5 && RecommendFriendAdapter.this.Z != null && !RecommendFriendAdapter.this.Z.q()) {
                RecommendFriendAdapter.this.Z.t(new ArrayList<>());
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
            } else {
                if (i3 != 0) {
                    return;
                }
                RecommendFriendAdapter.this.H();
                if (RecommendFriendAdapter.this.Z != null) {
                    RecommendFriendAdapter.this.Z.u(RecommendFriendAdapter.this.N);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface f {
        void a();

        void onItemClick();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface g {
        void c();

        void d(int i3);

        void e();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface h extends g {
        void a(String str);

        void b(List<MayKnowRecommend> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class i extends k {
        static IPatchRedirector $redirector_;
        public TextView C;
        public Object D;
        public ViewGroup E;

        /* renamed from: i, reason: collision with root package name */
        public SwipeMenuLayout f187063i;

        /* renamed from: m, reason: collision with root package name */
        LinearLayout f187064m;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public RecommendFriendAdapter(Context context, QQAppInterface qQAppInterface, XListView xListView, int i3, g gVar) {
        super(context, qQAppInterface, xListView, 1, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, qQAppInterface, xListView, Integer.valueOf(i3), gVar);
            return;
        }
        this.F = new CopyOnWriteArrayList<>();
        this.S = "";
        this.W = false;
        this.X = Integer.MAX_VALUE;
        this.Y = new HashSet<>();
        this.Z = null;
        this.f187044a0 = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getPYMKMediaUtil();
        this.f187045b0 = Boolean.TRUE;
        this.f187047d0 = new b();
        this.f187048e0 = new Runnable() { // from class: com.tencent.mobileqq.adapter.RecommendFriendAdapter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    RecommendFriendAdapter.this.G();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.f187049f0 = new c();
        this.f187050g0 = new e();
        this.f187051h0 = new Runnable() { // from class: com.tencent.mobileqq.adapter.RecommendFriendAdapter.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    RecommendFriendAdapter.this.H();
                }
            }
        };
        this.f187052i0 = new a();
        this.G = context;
        this.H = new WeakReference<>(qQAppInterface);
        this.R = this.G.getResources();
        this.I = (MayknowRecommendManager) qQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        xListView.setAdapter((ListAdapter) this);
        this.J = xListView;
        this.K = i3;
        this.L = 3;
        if (i3 == 8) {
            this.L = 24;
        } else if (i3 != 3 && i3 != 6) {
            if (i3 == 10) {
                this.L = 28;
            } else if (i3 == 12) {
                this.L = 54;
            } else if (i3 == 11) {
                this.L = 52;
            } else if (i3 == 23) {
                this.L = 2;
            }
        } else {
            this.L = 21;
        }
        this.M = this.L;
        StatusManager statusManager = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        this.Q = statusManager;
        if (statusManager != null) {
            statusManager.C(this.f187047d0);
        }
        this.P = gVar;
        g(this.f187050g0);
        qQAppInterface.addObserver(this.f187049f0);
        qQAppInterface.addObserver(this.f187052i0);
        this.V = (IMessageFacade) qQAppInterface.getRuntimeService(IMessageFacade.class, "");
    }

    @NonNull
    private View A() {
        if (this.Z != null && !this.f187045b0.booleanValue()) {
            return z();
        }
        Context context = this.G;
        if (context == null) {
            QLog.i("RecommendFriendAdapter", 1, "getNoMoreOrLoadingView context == null");
            return new View(this.G);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.gyx, (ViewGroup) null);
        if (inflate == null) {
            QLog.i("RecommendFriendAdapter", 1, "getNoMoreOrLoadingView view == null");
            return new View(this.G);
        }
        inflate.setClickable(true);
        inflate.setFocusable(true);
        VideoReport.setElementId(inflate, "em_kl_no_more_tag");
        VideoReport.setElementClickPolicy(inflate, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(inflate, ExposurePolicy.REPORT_ALL);
        return inflate;
    }

    private void B(View view, i iVar) {
        SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view.findViewById(R.id.yyy);
        iVar.f187063i = swipeMenuLayout;
        swipeMenuLayout.j(true);
        iVar.f187063i.setSwipeListener(new d(iVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(i iVar, HashMap hashMap, View view) {
        VideoReport.reportEvent("dt_imp", iVar.C, hashMap);
        VideoReport.reportEvent("dt_imp", view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit D() {
        MobileQQ.sMobileQQ.peekAppRuntime().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.adapter.z
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFriendAdapter.this.notifyDataSetChanged();
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        List<MayKnowRecommend> localRecommendData;
        com.tencent.mobileqq.pymk.c cVar = this.Z;
        if (cVar != null) {
            localRecommendData = cVar.p();
        } else {
            localRecommendData = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData();
        }
        g gVar = this.P;
        if (gVar != null && (gVar instanceof h)) {
            ((h) gVar).b(localRecommendData);
        }
        if (localRecommendData != null && localRecommendData.size() > 0) {
            int size = localRecommendData.size();
            int i3 = this.X;
            if (size > i3) {
                P(localRecommendData.subList(0, i3));
            } else {
                P(localRecommendData);
            }
            g gVar2 = this.P;
            if (gVar2 != null) {
                gVar2.c();
                return;
            }
            return;
        }
        P(new ArrayList());
        g gVar3 = this.P;
        if (gVar3 != null) {
            gVar3.e();
        }
    }

    private void K(View view, final i iVar, MayKnowRecommend mayKnowRecommend) {
        if (view == null || iVar == null || mayKnowRecommend == null || this.Y.contains(mayKnowRecommend.uin)) {
            return;
        }
        this.Y.add(mayKnowRecommend.uin);
        VideoReport.setElementId(iVar.C, "em_search_people_recommend_add");
        TextView textView = iVar.C;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(textView, clickPolicy);
        TextView textView2 = iVar.C;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(textView2, exposurePolicy);
        final View findViewById = view.findViewById(R.id.ibi);
        VideoReport.setElementId(findViewById, "em_search_people_recommend_unit");
        VideoReport.setElementClickPolicy(findViewById, clickPolicy);
        VideoReport.setElementExposePolicy(findViewById, exposurePolicy);
        final HashMap hashMap = new HashMap();
        hashMap.put("to_uin", mayKnowRecommend.uin);
        byte[] bArr = mayKnowRecommend.algBuffer;
        if (bArr != null && bArr.length > 0) {
            hashMap.put("algo_id", new String(bArr, StandardCharsets.UTF_8));
        }
        hashMap.put("recommend_reason", mayKnowRecommend.recommendReason);
        hashMap.put("user_request_subsourceid", String.valueOf(this.N));
        hashMap.put("user_request_sourceid", String.valueOf(3045));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.adapter.aa
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFriendAdapter.C(RecommendFriendAdapter.i.this, hashMap, findViewById);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(List<MayKnowRecommend> list, Boolean bool) {
        MayKnowRecommend mayKnowRecommend;
        if (!TextUtils.isEmpty(this.S) && list != null && list.size() > 0) {
            Iterator<MayKnowRecommend> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    mayKnowRecommend = it.next();
                    if (this.S.equals(mayKnowRecommend.uin)) {
                        break;
                    }
                } else {
                    mayKnowRecommend = null;
                    break;
                }
            }
            if (mayKnowRecommend != null) {
                list.remove(mayKnowRecommend);
                list.add(0, mayKnowRecommend);
            }
        }
        this.F.clear();
        if (list != null) {
            this.F.addAll(list);
        }
        this.f187044a0.b(this.F, new Function0() { // from class: com.tencent.mobileqq.adapter.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit D;
                D = RecommendFriendAdapter.this.D();
                return D;
            }
        });
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(bool) { // from class: com.tencent.mobileqq.adapter.RecommendFriendAdapter.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Boolean f187053d;

            {
                this.f187053d = bool;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this, (Object) bool);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                int size;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                RecommendFriendAdapter.this.f187045b0 = this.f187053d;
                RecommendFriendAdapter.this.notifyDataSetChanged();
                RecommendFriendAdapter recommendFriendAdapter = RecommendFriendAdapter.this;
                g gVar = recommendFriendAdapter.P;
                if (gVar != null) {
                    if (recommendFriendAdapter.F == null) {
                        size = 0;
                    } else {
                        size = RecommendFriendAdapter.this.F.size();
                    }
                    gVar.d(size);
                }
                AppInterface appInterface = (AppInterface) RecommendFriendAdapter.this.H.get();
                if (appInterface != null) {
                    ReportController.o(appInterface, "CliOper", "", "", "0X800C00D", "0X800C00D", 0, 0, "", "", appInterface.getAccount(), "");
                }
            }
        });
    }

    public static void W(View view, boolean z16) {
        if (view != null && view.findViewById(R.id.ibi) != null) {
            View findViewById = view.findViewById(R.id.ibi);
            Object tag = findViewById.getTag(R.id.dgx);
            if (tag == null || !(tag instanceof Boolean) || ((Boolean) tag).booleanValue() != z16) {
                findViewById.setTag(R.id.dgx, Boolean.valueOf(z16));
                if (z16) {
                    findViewById.setBackgroundResource(R.drawable.jix);
                } else {
                    findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                }
            }
        }
    }

    private void v(int i3, View view, MayKnowRecommend mayKnowRecommend, i iVar) {
        ((IPYMKAddFrinedApi) QRoute.api(IPYMKAddFrinedApi.class)).bindData(iVar.f187064m, mayKnowRecommend);
        Bundle bundle = new Bundle();
        bundle.putInt("user_request_subsourceid", this.N);
        this.f187044a0.a(iVar.f187064m, mayKnowRecommend, bundle);
        iVar.f187210d = mayKnowRecommend.uin;
        iVar.D = mayKnowRecommend;
        view.setTag(-1, Integer.valueOf(i3));
        iVar.f187064m.setTag(mayKnowRecommend);
        iVar.E.setTag(mayKnowRecommend);
        iVar.f187064m.setOnClickListener(this);
        iVar.C.setOnClickListener(this);
        iVar.C.setTag(mayKnowRecommend);
        W(view, mayKnowRecommend.bHighLight);
        if (com.tencent.mobileqq.search.util.z.d()) {
            view.findViewById(R.id.ibi).setBackgroundResource(0);
        } else if (this.L == 54 && aq.a()) {
            view.findViewById(R.id.ibi).setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
        }
        K(view, iVar, mayKnowRecommend);
    }

    private void x(MayKnowRecommend mayKnowRecommend) {
        int i3;
        String str;
        String str2 = mayKnowRecommend.uin;
        QQAppInterface qQAppInterface = this.H.get();
        if (qQAppInterface != null) {
            FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            if (friendListHandler == null) {
                QLog.e("RecommendFriendAdapter", 1, "delItem is error! flh is null!");
            } else {
                friendListHandler.cancelMayKnowRecommend(str2);
            }
        }
        this.F.remove(mayKnowRecommend);
        notifyDataSetChanged();
        int i16 = this.L;
        if (i16 == 21) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        int i17 = i3;
        if (i16 == 24) {
            str = "2";
        } else {
            str = "";
        }
        ContactReportUtils.d(this.H.get(), str2, "frd_list_dlt", this.L, 0, mayKnowRecommend.recommendReason, this.F.indexOf(mayKnowRecommend), mayKnowRecommend.algBuffer, i17, str);
    }

    private ViewGroup y(RelativeLayout relativeLayout) {
        relativeLayout.setBackgroundColor(this.G.getResources().getColor(R.color.qui_common_feedback_error, null));
        relativeLayout.setBackgroundTintList(this.G.getResources().getColorStateList(R.color.qui_common_feedback_error_selector, null));
        TextView textView = new TextView(this.G);
        textView.setTextColor(this.G.getResources().getColorStateList(R.color.qui_common_text_white));
        textView.setText(HardCodeUtil.qqStr(R.string.f229986xx));
        textView.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        return relativeLayout;
    }

    @NonNull
    private View z() {
        View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(this.G, false);
        if (loadingDialogTipsRight != null) {
            loadingDialogTipsRight.setTag(null);
            return loadingDialogTipsRight;
        }
        return new View(this.G);
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.Y.clear();
        this.f187044a0.onPause();
        QQAppInterface qQAppInterface = this.H.get();
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f187052i0);
            qQAppInterface.removeObserver(this.f187049f0);
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.J != null) {
            if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "onResume firstVisible: " + this.J.getFirstVisiblePosition() + " lastvisible: " + this.J.getLastVisiblePosition());
            }
            this.J.removeCallbacks(this.f187051h0);
            this.J.postDelayed(this.f187051h0, 1000L);
        }
        QQAppInterface qQAppInterface = this.H.get();
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.f187052i0);
            qQAppInterface.addObserver(this.f187049f0);
        }
    }

    public void H() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        XListView xListView = this.J;
        if (xListView != null && xListView.isShown() && !this.F.isEmpty()) {
            this.J.removeCallbacks(this.f187051h0);
            int firstVisiblePosition = this.J.getFirstVisiblePosition();
            int lastVisiblePosition = this.J.getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 >= 0 && i3 < this.F.size()) {
                    try {
                        MayKnowRecommend mayKnowRecommend = this.F.get(i3);
                        if (mayKnowRecommend != null) {
                            arrayList.add(mayKnowRecommend.uin);
                            arrayList2.add(mayKnowRecommend.recommendReason);
                            arrayList4.add(mayKnowRecommend.algBuffer);
                            arrayList3.add(Integer.valueOf(i3));
                        }
                    } catch (IndexOutOfBoundsException unused) {
                        QLog.e("RecommendFriendAdapter", 1, "reportRecommendFrdExpose is error!");
                    }
                }
            }
            int i16 = 2;
            if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + firstVisiblePosition + " lastVisibleItem: " + lastVisiblePosition + " exp_uins: " + arrayList + " exp_positions:" + arrayList3 + " algh_ids:" + arrayList4);
            }
            if (!arrayList.isEmpty()) {
                int i17 = this.L;
                if (i17 != 21) {
                    i16 = 0;
                }
                if (i17 == 24) {
                    str = "2";
                } else {
                    str = "";
                }
                ContactReportUtils.f(this.H.get(), this.L, arrayList, arrayList2, arrayList3, arrayList4, i16, str);
            }
        }
    }

    public void I(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.N = i3;
        }
    }

    public void J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.T = i3;
        }
    }

    public void L(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.X = i3;
        }
    }

    public void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        QLog.d("RecommendFriendAdapter", 2, "setNeedShowQZoneMediaInfo. needShowQZoneMediaInfo: " + z16);
    }

    public void N(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
        } else {
            this.U = fVar;
        }
    }

    public void O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.M = i3;
        }
    }

    public void P(List<MayKnowRecommend> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            ThreadManagerV2.excute(new Runnable(list) { // from class: com.tencent.mobileqq.adapter.RecommendFriendAdapter.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f187054d;

                {
                    this.f187054d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendFriendAdapter.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        RecommendFriendAdapter.this.R(this.f187054d, Boolean.TRUE);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, true);
        }
    }

    public void Q(List<MayKnowRecommend> list, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list, (Object) bool);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RecommendFriendAdapter", 1, "setRecFriends " + QLog.getStackTraceString(new Throwable("text")));
        }
        ThreadManagerV2.excute(new Runnable(list, bool) { // from class: com.tencent.mobileqq.adapter.RecommendFriendAdapter.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f187055d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Boolean f187056e;

            {
                this.f187055d = list;
                this.f187056e = bool;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RecommendFriendAdapter.this, list, bool);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    RecommendFriendAdapter.this.R(this.f187055d, this.f187056e);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, true);
    }

    public void S(com.tencent.mobileqq.pymk.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) cVar);
        } else {
            this.Z = cVar;
        }
    }

    public void T(SwipListView.RightIconMenuListener rightIconMenuListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rightIconMenuListener);
        } else {
            this.f187046c0 = rightIconMenuListener;
        }
    }

    public void U(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        this.S = str;
        if (str == null) {
            this.S = "";
        }
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.J != null) {
            if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "stopVisibleExpose firstVisible: " + this.J.getFirstVisiblePosition() + " lastvisible: " + this.J.getLastVisiblePosition());
            }
            this.J.removeCallbacks(this.f187051h0);
        }
    }

    @Override // com.tencent.mobileqq.adapter.j
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.Q.b0(this.f187047d0);
        IFaceDecoder iFaceDecoder = this.f187206f;
        if (iFaceDecoder != null) {
            iFaceDecoder.setAppRuntime(null);
            this.f187206f.setDecodeTaskCompletionListener(null);
            this.f187206f.destory();
        }
        g(null);
        QQAppInterface qQAppInterface = this.H.get();
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f187049f0);
            qQAppInterface.removeObserver(this.f187052i0);
        }
        XListView xListView = this.J;
        if (xListView != null) {
            xListView.removeCallbacks(this.f187048e0);
        }
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList == null) {
            return 0;
        }
        if (this.Z != null && !copyOnWriteArrayList.isEmpty()) {
            return this.F.size() + 1;
        }
        return this.F.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList == null) {
            QLog.e("RecommendFriendAdapter", 1, "RecommendFriendAdapter getItem is error! mRecObjectList is null!");
            return new MayKnowRecommend();
        }
        if (i3 >= 0 && !copyOnWriteArrayList.isEmpty() && i3 < this.F.size()) {
            return this.F.get(i3);
        }
        return new MayKnowRecommend();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        i iVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            view2 = (View) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), view, viewGroup);
        } else if (i3 >= this.F.size()) {
            view2 = A();
        } else {
            if (view != null && (view.getTag() instanceof i)) {
                iVar = (i) view.getTag();
            } else {
                iVar = new i();
                view = w(this.G, R.layout.h5g, iVar);
                B(view, iVar);
                view.setTag(iVar);
            }
            Object item = getItem(i3);
            if (item instanceof MayKnowRecommend) {
                v(i3, view, (MayKnowRecommend) item, iVar);
            }
            view2 = view;
            view3 = view2;
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
        view3 = view;
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        int i3;
        int i16;
        int i17;
        int i18;
        QQAppInterface qQAppInterface;
        String str;
        String str2;
        int i19;
        int i26;
        int i27;
        int i28;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            int id5 = view.getId();
            if (id5 == R.id.f166198yz0) {
                if (!NetworkUtil.isNetworkAvailable(this.G)) {
                    QQToast.makeText(this.G, HardCodeUtil.qqStr(R.string.b3j), 0).show(this.R.getDimensionPixelSize(R.dimen.title_bar_height));
                }
                int headerViewsCount = this.J.getHeaderViewsCount();
                if (view.getTag() != null) {
                    if (this.J.getChildAt((this.F.indexOf(view.getTag()) + headerViewsCount) - this.J.getFirstVisiblePosition()) != null && (view.getTag() instanceof MayKnowRecommend)) {
                        x((MayKnowRecommend) view.getTag());
                    }
                }
                SwipeMenuLayout f16 = SwipeMenuLayout.f();
                if (f16 != null) {
                    f16.h();
                }
            } else {
                if (id5 == R.id.i8s) {
                    MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) view.getTag();
                    QQAppInterface qQAppInterface2 = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (mayKnowRecommend == null || qQAppInterface2 == null) {
                        view2 = view;
                    } else {
                        FriendsManager friendsManager = (FriendsManager) qQAppInterface2.getManager(QQManagerFactory.FRIENDS_MANAGER);
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(mayKnowRecommend.uin);
                        if (friendsManager != null && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "RecommendFriendAdapter") && !friendsManager.P(mayKnowRecommend.uin)) {
                            int i29 = this.N;
                            boolean booleanExtra = ((Activity) this.G).getIntent().getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false);
                            if (booleanExtra) {
                                i28 = 3083;
                                i27 = 1;
                            } else {
                                i27 = i29;
                                i28 = 3045;
                            }
                            String displayName = mayKnowRecommend.getDisplayName();
                            IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                            Context context = this.G;
                            Intent startAddFriend = iAddFriendApi.startAddFriend(context, 1, mayKnowRecommend.uin, (String) null, i28, i27, displayName, (String) null, (String) null, context.getString(R.string.f170028dd), (String) null, mayKnowRecommend.getToken());
                            str = "2";
                            str2 = "";
                            qQAppInterface = qQAppInterface2;
                            startAddFriend.putExtra("key_param_age_area", ProfileCardUtil.Z(this.G, mayKnowRecommend.gender, mayKnowRecommend.age, mayKnowRecommend.country, mayKnowRecommend.province, mayKnowRecommend.city));
                            startAddFriend.putExtra(AppConstants.Key.KEY_FROM_BABYQ, booleanExtra);
                            byte[] bArr = mayKnowRecommend.algBuffer;
                            if (bArr != null && bArr.length > 0) {
                                startAddFriend.putExtra("algo_id", new String(bArr, StandardCharsets.UTF_8));
                            }
                            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.G, startAddFriend);
                            int i36 = this.K;
                            if (i36 == 1) {
                                view2 = view;
                                ReportController.o(qQAppInterface, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
                            } else if (i36 == 2) {
                                view2 = view;
                                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
                            } else if (i36 == 3) {
                                view2 = view;
                                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
                            } else if (i36 != 4) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("to_uin", mayKnowRecommend.uin);
                                byte[] bArr2 = mayKnowRecommend.algBuffer;
                                if (bArr2 != null && bArr2.length > 0) {
                                    hashMap.put("algo_id", new String(bArr2, StandardCharsets.UTF_8));
                                }
                                hashMap.put("recommend_reason", mayKnowRecommend.recommendReason);
                                hashMap.put("user_request_subsourceid", String.valueOf(this.N));
                                hashMap.put("user_request_sourceid", String.valueOf(3045));
                                view2 = view;
                                VideoReport.reportEvent("dt_clck", view2, hashMap);
                            } else {
                                view2 = view;
                                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
                            }
                        } else {
                            view2 = view;
                            qQAppInterface = qQAppInterface2;
                            str = "2";
                            str2 = "";
                            if (friendsManager != null && friendsManager.c0(mayKnowRecommend.uin)) {
                                mayKnowRecommend.friendStatus = 2;
                                notifyDataSetChanged();
                            } else {
                                mayKnowRecommend.friendStatus = 1;
                                notifyDataSetChanged();
                            }
                        }
                        int i37 = this.L;
                        if (i37 == 21) {
                            i19 = 24;
                            i26 = 2;
                        } else {
                            i19 = 24;
                            i26 = 0;
                        }
                        ContactReportUtils.d(qQAppInterface, mayKnowRecommend.uin, "frd_list_add", i37, 1, mayKnowRecommend.recommendReason, this.F.indexOf(mayKnowRecommend), mayKnowRecommend.algBuffer, i26, i37 == i19 ? str : str2);
                    }
                    f fVar = this.U;
                    if (fVar != null) {
                        fVar.a();
                    }
                } else {
                    view2 = view;
                    if (id5 == R.id.ibi) {
                        MayKnowRecommend mayKnowRecommend2 = (MayKnowRecommend) view.getTag();
                        QQAppInterface qQAppInterface3 = this.H.get();
                        if (mayKnowRecommend2 != null && qQAppInterface3 != null) {
                            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(mayKnowRecommend2.uin), "RecommendFriendAdapter")) {
                                i3 = 1;
                            } else {
                                int i38 = this.K;
                                if (i38 == 8) {
                                    i3 = 101;
                                } else {
                                    if (i38 != 3 && i38 != 4) {
                                        if (i38 == 10) {
                                            i3 = 107;
                                        } else if (this.L != 21) {
                                            i3 = 83;
                                        }
                                    }
                                    i3 = 82;
                                }
                            }
                            AllInOne allInOne = new AllInOne(mayKnowRecommend2.uin, i3);
                            String recommendName = mayKnowRecommend2.getRecommendName();
                            if (!TextUtils.isEmpty(recommendName)) {
                                allInOne.recommendName = recommendName;
                            }
                            if (!TextUtils.isEmpty(mayKnowRecommend2.nick)) {
                                allInOne.nickname = mayKnowRecommend2.nick;
                            }
                            allInOne.profileEntryType = 88;
                            boolean booleanExtra2 = ((Activity) this.G).getIntent().getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false);
                            if (booleanExtra2) {
                                allInOne.extras.putBoolean(AppConstants.Key.KEY_FROM_BABYQ, true);
                            }
                            int i39 = this.L;
                            int i46 = i39 == 21 ? 2 : 0;
                            allInOne.extras.putString("recommend_entry_type", i39 == 24 ? "2" : "");
                            allInOne.extras.putInt("key_display_type", i46);
                            allInOne.extras.putString("recommend_reason", mayKnowRecommend2.getMultiReason());
                            allInOne.extras.putInt("recommend_pos", this.F.indexOf(mayKnowRecommend2));
                            allInOne.extras.putByteArray("recommend_algh_id", mayKnowRecommend2.algBuffer);
                            int i47 = this.M;
                            if (i47 == 2) {
                                i47 = 32;
                            } else if (i47 == 24) {
                                i47 = 31;
                            } else if (i47 == 52) {
                                i47 = 34;
                            } else if (i47 != 54) {
                                switch (i47) {
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                        break;
                                    default:
                                        i47 = 35;
                                        break;
                                }
                            } else {
                                i47 = 33;
                            }
                            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 3);
                            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, i47);
                            allInOne.extras.putBoolean(ProfileCardConst.ENTER_PAGE_OPEN_STAND_IN_PAD, true);
                            int i48 = this.N;
                            if (booleanExtra2) {
                                i16 = 1;
                                i17 = 3083;
                            } else {
                                i16 = i48;
                                i17 = 3045;
                            }
                            allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_ID, i17);
                            allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID, i16);
                            ProfileUtils.openProfileCard(this.G, allInOne);
                            QLog.i("RecommendFriendAdapter", 1, "TTEST rlSystemMsg onClick." + mayKnowRecommend2.uin + ", " + mayKnowRecommend2.nick + ", mEntranceId: " + this.K + ", mPageId: " + this.L);
                            if (QLog.isColorLevel()) {
                                i18 = 2;
                                QLog.d("RecommendFriendAdapter", 2, "onClick_ open profile item uin = " + mayKnowRecommend2.uin);
                            } else {
                                i18 = 2;
                            }
                            int i49 = this.K;
                            if (i49 == 1) {
                                ReportController.o(qQAppInterface3, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
                            } else if (i49 == i18) {
                                ReportController.o(qQAppInterface3, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
                            } else if (i49 == 3) {
                                ReportController.o(qQAppInterface3, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
                            } else if (i49 != 4) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("to_uin", mayKnowRecommend2.uin);
                                byte[] bArr3 = mayKnowRecommend2.algBuffer;
                                if (bArr3 != null && bArr3.length > 0) {
                                    hashMap2.put("algo_id", new String(bArr3, StandardCharsets.UTF_8));
                                }
                                hashMap2.put("recommend_reason", mayKnowRecommend2.recommendReason);
                                hashMap2.put("user_request_subsourceid", String.valueOf(this.N));
                                hashMap2.put("user_request_sourceid", String.valueOf(3045));
                                VideoReport.reportEvent("dt_clck", view2, hashMap2);
                            } else {
                                ReportController.o(qQAppInterface3, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
                            }
                            int i56 = this.L;
                            ContactReportUtils.d(qQAppInterface3, mayKnowRecommend2.uin, "frd_list_clk", i56, 0, mayKnowRecommend2.recommendReason, this.F.indexOf(mayKnowRecommend2), mayKnowRecommend2.algBuffer, i46, i56 == 24 ? "2" : "");
                            f fVar2 = this.U;
                            if (fVar2 != null) {
                                fVar2.onItemClick();
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        }
        view2 = view;
        EventCollector.getInstance().onViewClicked(view2);
    }

    protected View w(Context context, int i3, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, this, context, Integer.valueOf(i3), iVar);
        }
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        iVar.f187064m = ((IPYMKAddFrinedApi) QRoute.api(IPYMKAddFrinedApi.class)).getPYMKItemView(this.G);
        ((RelativeLayout) inflate.findViewById(R.id.yyz)).addView(iVar.f187064m);
        iVar.C = (TextView) iVar.f187064m.findViewById(R.id.i8s);
        ViewGroup y16 = y((RelativeLayout) inflate.findViewById(R.id.f166198yz0));
        iVar.E = y16;
        y16.setOnClickListener(this);
        return inflate;
    }
}
