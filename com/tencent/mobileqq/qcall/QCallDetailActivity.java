package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import common.config.service.QzoneConfig;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCallDetailActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.avatar.observer.a A0;
    private ar B0;
    private com.tencent.mobileqq.discussion.observer.a C0;
    private int D0;
    private int[] E0;
    Runnable F0;
    VipFunCallObserver G0;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f261493a0;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f261494b0;

    /* renamed from: c0, reason: collision with root package name */
    private RelativeLayout f261495c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f261496d0;

    /* renamed from: e0, reason: collision with root package name */
    private ImageView f261497e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f261498f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f261499g0;

    /* renamed from: h0, reason: collision with root package name */
    private ImageView f261500h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f261501i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f261502j0;

    /* renamed from: k0, reason: collision with root package name */
    private XListView f261503k0;

    /* renamed from: l0, reason: collision with root package name */
    private Button f261504l0;

    /* renamed from: m0, reason: collision with root package name */
    private g f261505m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f261506n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f261507o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f261508p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f261509q0;

    /* renamed from: r0, reason: collision with root package name */
    private String f261510r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f261511s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f261512t0;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c f261513u0;

    /* renamed from: v0, reason: collision with root package name */
    private com.tencent.mobileqq.qcall.f f261514v0;

    /* renamed from: w0, reason: collision with root package name */
    private FriendListHandler f261515w0;

    /* renamed from: x0, reason: collision with root package name */
    private String f261516x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f261517y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f261518z0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead isSuccess | " + z16 + ", uin | " + str);
            }
            if (z16 && QCallDetailActivity.this.f261508p0 == 3000 && !Utils.p(str, QCallDetailActivity.this.app.getCurrentAccountUin())) {
                n nVar = (n) QCallDetailActivity.this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                if (nVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead dm is null  ====");
                        return;
                    }
                    return;
                }
                if (nVar.h(QCallDetailActivity.this.f261506n0) == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead info is null ====");
                    }
                } else {
                    if (TextUtils.isEmpty(str)) {
                        QLog.i("QCallDetailActivity", 1, " === onUpdateCustomHead uin is null ====");
                        return;
                    }
                    Map<String, DiscussionMemberInfo> n3 = nVar.n(QCallDetailActivity.this.f261506n0);
                    if (n3 != null && n3.size() > 0 && n3.containsKey(str)) {
                        QCallDetailActivity qCallDetailActivity = QCallDetailActivity.this;
                        qCallDetailActivity.f3(qCallDetailActivity.f261506n0);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void g(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            } else if (QCallDetailActivity.this.f261506n0 != null && QCallDetailActivity.this.f261506n0.equals(str) && QCallDetailActivity.this.f261508p0 == 3000) {
                QCallDetailActivity.this.f3(str);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void r(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
            } else if (z16 && !TextUtils.isEmpty(QCallDetailActivity.this.f261506n0) && QCallDetailActivity.this.f261506n0.equals(str) && !QCallDetailActivity.this.isFinishing()) {
                QCallDetailActivity.this.finish();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void u(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QCallDetailActivity", 2, " === onUpdateDiscussionFaceIcon isSuccess | " + z16 + ", disUin | " + str + ",isComplete | " + z17);
            }
            if (z16 && z17 && QCallDetailActivity.this.f261506n0 != null && QCallDetailActivity.this.f261508p0 == 3000) {
                if (GroupIconHelper.K(str)) {
                    str = GroupIconHelper.C(str);
                }
                if (QCallDetailActivity.this.f261506n0.equals(str)) {
                    QCallDetailActivity qCallDetailActivity = QCallDetailActivity.this;
                    qCallDetailActivity.f3(qCallDetailActivity.f261506n0);
                    if (QLog.isColorLevel()) {
                        QLog.i("QCallDetailActivity", 2, "==== onUpdateDiscussionFaceIcon updateUin ===");
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void w(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (((ArrayList) obj).indexOf(QCallDetailActivity.this.f261506n0) != -1 && z16 && QCallDetailActivity.this.f261508p0 == 3000) {
                QCallDetailActivity qCallDetailActivity = QCallDetailActivity.this;
                qCallDetailActivity.f3(qCallDetailActivity.f261506n0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                QCallDetailActivity.this.f261494b0.setPressed(true);
            } else if (1 == motionEvent.getAction()) {
                QCallDetailActivity.this.f261494b0.setPressed(false);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            String a16 = com.tencent.mobileqq.phonecontact.util.d.a(((TextView) view.findViewById(R.id.gq7)).getText().toString());
            QCallDetailActivity qCallDetailActivity = QCallDetailActivity.this;
            qCallDetailActivity.Q2(qCallDetailActivity.getActivity(), a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements ActionSheet.OnDismissListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ReportController.o(QCallDetailActivity.this.app, "CliOper", "", "", "0X8005AFA", "0X8005AFA", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f261530d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f261531e;

        f(String str, ActionSheet actionSheet) {
            this.f261530d = str;
            this.f261531e = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QCallDetailActivity.this, str, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (QCallDetailActivity.this.E0 != null && i3 < QCallDetailActivity.this.E0.length && QCallDetailActivity.this.E0[i3] == 2) {
                QCallDetailActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f261530d)));
                ReportController.o(QCallDetailActivity.this.app, "CliOper", "", "", "0X8005AF9", "0X8005AF9", 0, 0, "", "", "", "");
                this.f261531e.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public List<QCallRecord> f261533d;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
            } else {
                this.f261533d = new CopyOnWriteArrayList();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (this.f261533d == null) {
                this.f261533d = new CopyOnWriteArrayList();
            }
            return this.f261533d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f261533d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            int i16 = this.f261533d.get(i3).type;
            int i17 = QCallRecord.TYPE_DATE;
            if (i16 == i17) {
                return i17;
            }
            return QCallRecord.TYPE_REALRECORD;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                view2 = view;
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 3;
        }
    }

    public QCallDetailActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.A0 = new a();
        this.B0 = new ar() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.ar
            public void onGetOnlineInfoByUinOrMobile(boolean z16, long j3, String str, GetOnlineInfoResp getOnlineInfoResp) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), str, getOnlineInfoResp);
                } else if (z16 && TextUtils.equals(str, QCallDetailActivity.this.f261506n0)) {
                    QCallDetailActivity.this.d3();
                    QCallDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                QCallDetailActivity.this.e3();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onUpdateFriendInfo(String str, boolean z16) {
                Map<String, DiscussionMemberInfo> n3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, str, Boolean.valueOf(z16));
                    return;
                }
                if (z16 && QCallDetailActivity.this.f261508p0 == 3000) {
                    n nVar = (n) QCallDetailActivity.this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                    if (nVar == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QCallDetailActivity", 2, " === onUpdateFriendInfo dm is null  ====");
                            return;
                        }
                        return;
                    }
                    DiscussionInfo h16 = nVar.h(QCallDetailActivity.this.f261506n0);
                    if (h16 == null) {
                        QLog.i("QCallDetailActivity", 1, " ===onUpdateFriendInfo info is null ====");
                        return;
                    }
                    if (TextUtils.isEmpty(str)) {
                        QLog.i("QCallDetailActivity", 1, " === onUpdateFriendInfo uin is null ====");
                        return;
                    }
                    if (!h16.hasRenamed() && (n3 = nVar.n(QCallDetailActivity.this.f261506n0)) != null && n3.size() > 0 && n3.containsKey(str)) {
                        QCallDetailActivity qCallDetailActivity = QCallDetailActivity.this;
                        qCallDetailActivity.f3(qCallDetailActivity.f261506n0);
                    }
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onUpdateOnlineFriend(boolean z16, String[] strArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    QCallDetailActivity.this.d3();
                    QCallDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.2.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                QCallDetailActivity.this.e3();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                } else {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), strArr);
                }
            }
        };
        this.C0 = new b();
        this.D0 = -1;
        this.F0 = new Runnable() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                PhoneContact queryContactByCodeNumber;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QCallDetailActivity qCallDetailActivity = QCallDetailActivity.this;
                if (qCallDetailActivity.app != null && qCallDetailActivity.P2(qCallDetailActivity.f261506n0)) {
                    int[] iArr = ao.f116570d;
                    int length = iArr.length;
                    boolean z16 = false;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        if (QCallDetailActivity.this.f261508p0 == iArr[i3]) {
                            z16 = true;
                            break;
                        }
                        i3++;
                    }
                    if (z16) {
                        IPhoneContactService iPhoneContactService = (IPhoneContactService) QCallDetailActivity.this.app.getRuntimeService(IPhoneContactService.class, "");
                        if (iPhoneContactService == null) {
                            queryContactByCodeNumber = null;
                        } else {
                            queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(QCallDetailActivity.this.f261506n0);
                        }
                        if (queryContactByCodeNumber != null) {
                            QCallDetailActivity.this.f261514v0.d(queryContactByCodeNumber.mobileCode, 1006, QCallDetailActivity.this.f261506n0, QCallDetailActivity.this.f261508p0);
                        }
                    }
                }
            }
        };
        this.G0 = new VipFunCallObserver() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.vas.vipav.VipFunCallObserver, com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                Bundle bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 2 && (bundle = (Bundle) obj) != null && !TextUtils.isEmpty(QCallDetailActivity.this.f261506n0) && QCallDetailActivity.this.f261506n0.equals(bundle.getString("uin"))) {
                    QQAppInterface qQAppInterface = QCallDetailActivity.this.app;
                    if (qQAppInterface != null) {
                        qQAppInterface.removeObserver(this);
                    }
                    if (z16) {
                        QCallDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.10.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    QCallDetailActivity.this.Z2(false);
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P2(String str) {
        return ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c0(str);
    }

    private String R2(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 1004) {
                    if (i3 != 1006) {
                        return "999";
                    }
                    return "3";
                }
                return "1";
            }
            return "2";
        }
        return "0";
    }

    private void S2(Intent intent) {
        PhoneContact queryContactByCodeNumber;
        if (intent == null) {
            finish();
            return;
        }
        this.f261506n0 = intent.getStringExtra("uin");
        this.f261507o0 = intent.getStringExtra("troop_uin");
        int intExtra = intent.getIntExtra("uintype", 0);
        this.f261508p0 = intExtra;
        if (intExtra == 8) {
            this.f261508p0 = intent.getIntExtra(AppConstants.Key.EXTRA_TYPE, 0);
        }
        this.f261510r0 = intent.getStringExtra("uinname");
        this.f261511s0 = intent.getIntExtra(AppConstants.Key.BIND_TYPE, 0);
        this.f261512t0 = intent.getStringExtra(AppConstants.Key.PHONENUM);
        if (this.f261511s0 == 2) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
        }
        this.rightViewImg.setVisibility(8);
        int i3 = this.f261508p0;
        this.f261509q0 = i3;
        if (i3 == 0 && !P2(this.f261506n0)) {
            this.f261509q0 = 1003;
        }
        int intExtra2 = intent.getIntExtra(AppConstants.Key.CONTACT_ID, -1);
        this.D0 = intExtra2;
        if (intExtra2 == -1) {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
            int i16 = this.f261508p0;
            if (i16 != 1006) {
                if (i16 != 56938) {
                    queryContactByCodeNumber = iPhoneContactService.queryPhoneContactByUin(this.f261506n0);
                } else {
                    queryContactByCodeNumber = iPhoneContactService.queryPhoneContactByMobile(this.f261506n0);
                }
            } else {
                queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(this.f261506n0);
            }
            if (queryContactByCodeNumber != null) {
                this.D0 = queryContactByCodeNumber.contactID;
            }
        }
    }

    private void T2() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f166625gq2);
        Button button = (Button) linearLayout.findViewById(R.id.txt);
        linearLayout.setOnClickListener(this);
        button.setTag(Integer.valueOf(R.id.f166625gq2));
        button.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.f166624gq1);
        Button button2 = (Button) linearLayout2.findViewById(R.id.txt);
        linearLayout2.setOnClickListener(this);
        button2.setTag(Integer.valueOf(R.id.f166624gq1));
        button2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.f166623gq0);
        Button button3 = (Button) linearLayout3.findViewById(R.id.txt);
        linearLayout3.setOnClickListener(this);
        button3.setTag(Integer.valueOf(R.id.f166623gq0));
        button3.setOnClickListener(this);
        button.setText(R.string.heh);
        int i3 = this.f261508p0;
        if (i3 == 3000) {
            button.setContentDescription(HardCodeUtil.qqStr(R.string.q85));
            button3.setText(R.string.bum);
            button3.setContentDescription(button3.getResources().getString(R.string.buh));
            linearLayout2.setVisibility(8);
        } else if (i3 == 1008) {
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(8);
            button3.setText(R.string.buh);
            button3.setContentDescription(getString(R.string.faj));
            this.f261495c0.setVisibility(8);
        } else {
            int i16 = this.f261511s0;
            if (i16 != 2 && i16 != 3 && i3 != 25) {
                button.setContentDescription(HardCodeUtil.qqStr(R.string.f172376q84));
                button3.setText(R.string.buh);
                button3.setContentDescription(button3.getResources().getString(R.string.buh));
                if (!CrmUtils.o(this.app, this.f261506n0, this.f261508p0)) {
                    linearLayout2.setVisibility(0);
                    button2.setText(R.string.fam);
                    button2.setContentDescription(button2.getResources().getString(R.string.fam));
                } else {
                    linearLayout2.setVisibility(8);
                    int i17 = this.f261511s0;
                    if (i17 == 2 || i17 == 3 || this.f261508p0 == 25) {
                        linearLayout2.setVisibility(8);
                        button3.setContentDescription(getString(R.string.fak));
                    }
                }
            } else {
                linearLayout2.setVisibility(8);
                linearLayout.setVisibility(8);
                button3.setText(R.string.buh);
                button3.setContentDescription(getString(R.string.faj));
            }
        }
        if (this.f261508p0 != 0) {
            linearLayout3.setVisibility(8);
            linearLayout2.setVisibility(8);
        }
    }

    private void U2() {
        PhoneContact phoneContact;
        String str;
        String str2;
        int i3;
        List<? extends Entity> list = null;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.ash, (ViewGroup) null);
        this.f261493a0 = linearLayout;
        this.f261497e0 = (ImageView) linearLayout.findViewById(R.id.head);
        this.f261498f0 = (TextView) this.f261493a0.findViewById(R.id.f5e);
        this.f261499g0 = (TextView) this.f261493a0.findViewById(R.id.cwu);
        this.f261500h0 = (ImageView) this.f261493a0.findViewById(R.id.f7_);
        this.f261501i0 = (TextView) this.f261493a0.findViewById(R.id.f79);
        this.f261494b0 = (RelativeLayout) this.f261493a0.findViewById(R.id.e4q);
        this.f261495c0 = (RelativeLayout) this.f261493a0.findViewById(R.id.f166011e33);
        Button button = (Button) findViewById(R.id.ao9);
        this.f261504l0 = button;
        button.setOnClickListener(this);
        this.f261496d0 = (TextView) this.f261493a0.findViewById(R.id.b2c);
        this.f261502j0 = this.f261493a0.findViewById(R.id.f166627gq4);
        int color = getResources().getColor(R.color.qq_profilecard_btns_divider);
        this.f261502j0.setBackgroundColor(color);
        View findViewById = this.f261493a0.findViewById(R.id.gq5);
        if (findViewById != null) {
            findViewById.setBackgroundColor(color);
        }
        this.f261498f0.setText(this.f261510r0);
        TextView textView = (TextView) this.f261493a0.findViewById(R.id.d3u);
        ImageView imageView = (ImageView) this.f261493a0.findViewById(R.id.i_m);
        int i16 = this.f261508p0;
        if (i16 != 25) {
            if (i16 != 26) {
                if (i16 != 1001 && i16 != 1010) {
                    if (i16 != 2016) {
                        if (i16 != 3000) {
                            if (i16 != 10002 && i16 != 10004) {
                                if (i16 != 56938) {
                                    this.f261497e0.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.f261506n0));
                                }
                            }
                        } else {
                            this.f261497e0.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, this.f261506n0));
                            n nVar = (n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                            if (nVar != null) {
                                i3 = nVar.q(this.f261506n0);
                            } else {
                                i3 = 0;
                            }
                            if (i3 > 0) {
                                this.f261499g0.setText("(" + i3 + ")");
                            }
                            RelativeLayout relativeLayout = this.f261495c0;
                            if (relativeLayout != null && findViewById != null) {
                                relativeLayout.setVisibility(8);
                                findViewById.setVisibility(8);
                            }
                            imageView.setVisibility(0);
                            findViewById(R.id.gpz).setVisibility(0);
                            this.f261504l0.setVisibility(8);
                        }
                    }
                    this.f261497e0.setImageResource(R.drawable.day);
                    textView.setVisibility(0);
                    String U = ac.U(this.f261510r0);
                    textView.setText(U);
                    if (ac.o0(U)) {
                        textView.setTextSize(0, getResources().getDimension(R.dimen.ays));
                    } else {
                        textView.setTextSize(0, getResources().getDimension(R.dimen.ayt));
                    }
                    imageView.setVisibility(8);
                    this.f261501i0.setText(R.string.fpy);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    RelativeLayout relativeLayout2 = this.f261495c0;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(8);
                    }
                    findViewById(R.id.gpz).setVisibility(8);
                }
                this.f261497e0.setImageDrawable(FaceDrawable.getStrangerFaceDrawable((AppInterface) this.app, 200, this.f261506n0, true));
            } else {
                this.f261518z0 = null;
                PhoneContact g16 = com.tencent.mobileqq.qcall.a.g(this.app, this.f261506n0);
                if (g16 != null) {
                    this.f261518z0 = g16.uin;
                }
                if (this.f261518z0 == null) {
                    imageView.setVisibility(8);
                    this.f261497e0.setImageResource(R.drawable.day);
                    textView.setVisibility(0);
                    textView.setText(ac.U(this.f261510r0));
                } else {
                    imageView.setVisibility(0);
                    this.f261497e0.setImageDrawable(com.tencent.mobileqq.qcall.a.e(this.app, this.f261506n0));
                }
                findViewById(R.id.gpz).setVisibility(8);
                this.f261504l0.setVisibility(0);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                RelativeLayout relativeLayout3 = this.f261495c0;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(8);
                }
            }
        } else {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null) {
                phoneContact = iPhoneContactService.queryContactByCodeNumber(this.f261512t0);
            } else {
                phoneContact = null;
            }
            if (iPhoneContactService != null && (str2 = this.f261512t0) != null) {
                phoneContact = iPhoneContactService.queryContactByCodeNumber(str2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QCallDetailActivity", 2, "getFaceBitmap contact = " + phoneContact);
            }
            if (phoneContact != null) {
                FaceDrawable mobileFaceDrawable = FaceDrawable.getMobileFaceDrawable(this.app, this.f261512t0, (byte) 3);
                this.f261498f0.setText(phoneContact.name);
                if (mobileFaceDrawable != null) {
                    this.f261497e0.setImageDrawable(mobileFaceDrawable);
                }
            } else {
                Bitmap faceBitmap = this.app.getFaceBitmap(16, this.f261506n0, (byte) 3, true, 16);
                QCallCardInfo c16 = ((com.tencent.mobileqq.qcall.c) this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).c(this.f261506n0);
                if (c16 != null && (str = c16.nickname) != null) {
                    this.f261498f0.setText(str);
                }
                if (faceBitmap != null) {
                    this.f261497e0.setImageBitmap(faceBitmap);
                }
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallDetailActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QCallDetailActivity.this.d3();
                    QCallDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qcall.QCallDetailActivity.5.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                QCallDetailActivity.this.e3();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 8, null, true);
        Z2(true);
        RelativeLayout relativeLayout4 = this.f261495c0;
        if (relativeLayout4 != null) {
            relativeLayout4.setOnClickListener(this);
        }
        this.f261494b0.setOnClickListener(this);
        this.f261501i0.setOnClickListener(this);
        this.f261501i0.setOnTouchListener(new c());
        if (this.D0 != -1) {
            list = this.app.getEntityManagerFactory().createEntityManager().query(PhoneContact.class, false, "contactID = " + this.D0, null, null, null, null, null);
            ReportController.o(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
        }
        if (this.f261508p0 == 26) {
            list = new ArrayList<>();
            PhoneContact phoneContact2 = new PhoneContact();
            phoneContact2.mobileNo = this.f261506n0;
            phoneContact2.type = 0;
            phoneContact2.label = HardCodeUtil.qqStr(R.string.q86);
            list.add(phoneContact2);
        }
        if (list != null && list.size() > 0) {
            this.f261493a0.findViewById(R.id.gq6).setVisibility(0);
            NoScrollListView noScrollListView = (NoScrollListView) this.f261493a0.findViewById(R.id.fmx);
            noScrollListView.setVisibility(0);
            noScrollListView.setAdapter((ListAdapter) new com.tencent.mobileqq.qcall.b(this, list));
            noScrollListView.setOnItemClickListener(new d());
        }
    }

    private void W2() {
        if (this.f261508p0 == 3000) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
            ReportController.o(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
            ChatActivityUtils.d0(this.app, this, this.f261508p0, this.f261516x0, true, true, null, null);
            return;
        }
        ReportController.o(this.app, "CliOper", "", this.f261506n0, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
        ReportController.o(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
        int i3 = this.f261508p0;
        if (i3 == 1024) {
            CrmUtils.z(this.app, this, this.f261510r0, this.f261516x0, "IvrCallDetailEngineFalse");
        } else {
            ChatActivityUtils.h0(this.app, this, i3, this.f261516x0, this.f261510r0, this.f261517y0, true, this.f261507o0, true, true, null, "from_internal");
        }
    }

    private void Y2() {
        ThreadManagerV2.post(this.F0, 8, null, false);
    }

    private void b3() {
        int i3 = this.f261509q0;
        if (i3 == 1024) {
            CrmUtils.n(this, null, this.f261506n0, false, -1, true, 2000);
            return;
        }
        if (i3 == 1008) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this, IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", this.f261506n0);
            activityURIRequest.extra().putInt("uintype", 1008);
            activityURIRequest.extra().putInt("source", 113);
            activityURIRequest.setRequestCode(2000);
            QRoute.startUri(activityURIRequest, (o) null);
            return;
        }
        AllInOne allInOne = new AllInOne(this.f261506n0, 46);
        allInOne.f260789pa = 19;
        allInOne.nickname = ac.F(this.app, this.f261506n0);
        int i16 = this.f261509q0;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 25) {
                    if (i16 != 26) {
                        if (i16 != 1000) {
                            if (i16 != 1001) {
                                if (i16 != 1009) {
                                    if (i16 != 1010) {
                                        if (i16 != 4000) {
                                            if (i16 != 10002) {
                                                if (i16 != 10010) {
                                                    switch (i16) {
                                                        case 1003:
                                                            allInOne.f260789pa = 70;
                                                            break;
                                                        case 1004:
                                                            allInOne.f260789pa = 47;
                                                            allInOne.discussUin = this.f261507o0;
                                                            break;
                                                        case 1005:
                                                            allInOne.f260789pa = 2;
                                                            break;
                                                        case 1006:
                                                            break;
                                                        default:
                                                            switch (i16) {
                                                                case 1020:
                                                                    allInOne.f260789pa = 58;
                                                                    break;
                                                                case 1021:
                                                                    allInOne.f260789pa = 72;
                                                                    break;
                                                                case 1022:
                                                                    allInOne.f260789pa = 27;
                                                                    break;
                                                                case 1023:
                                                                    allInOne.f260789pa = 74;
                                                                    break;
                                                            }
                                                    }
                                                } else {
                                                    allInOne.f260789pa = 117;
                                                }
                                            } else {
                                                allInOne.f260789pa = 86;
                                            }
                                        }
                                        allInOne.f260789pa = 34;
                                    } else {
                                        allInOne.f260789pa = 76;
                                    }
                                } else {
                                    allInOne.f260789pa = 57;
                                }
                            } else {
                                allInOne.f260789pa = 42;
                            }
                        } else {
                            allInOne.f260789pa = 22;
                            allInOne.troopUin = this.f261507o0;
                        }
                    } else {
                        if (TextUtils.isEmpty(this.f261518z0)) {
                            return;
                        }
                        if (this.f261518z0.equals("0")) {
                            allInOne.f260789pa = 34;
                        } else {
                            allInOne.f260789pa = 1;
                            String str = this.f261518z0;
                            allInOne.uin = str;
                            allInOne.nickname = ac.F(this.app, str);
                        }
                    }
                } else {
                    c3();
                    return;
                }
            } else {
                allInOne.f260789pa = 20;
            }
        } else {
            allInOne.f260789pa = 1;
        }
        int i17 = this.f261509q0;
        if (i17 != 1001 && i17 != 10002 && i17 != 10004 && i17 != 1010) {
            ProfileUtils.openProfileCard(this, allInOne);
            return;
        }
        if (i17 != 1001 && i17 != 10002) {
            if (i17 == 1010) {
                allInOne.profileEntryType = 13;
            }
        } else {
            allInOne.profileEntryType = 12;
        }
        Intent intent = new Intent();
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        if (Utils.p(this.f261506n0, this.app.getCurrentAccountUin())) {
            intent.putExtra("param_mode", 2);
        } else {
            intent.putExtra("param_mode", 3);
        }
        RouteUtils.startActivity(BaseApplication.getContext(), intent, "/nearby/people/profile");
    }

    private void c3() {
        PhoneContact phoneContact;
        int i3;
        String str;
        AllInOne allInOne = new AllInOne(this.f261506n0, 80);
        QCallCardInfo c16 = ((com.tencent.mobileqq.qcall.c) this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).c(this.f261506n0);
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && (str = this.f261512t0) != null) {
            phoneContact = iPhoneContactService.queryContactByCodeNumber(str);
        } else {
            phoneContact = null;
        }
        if (c16 != null) {
            allInOne.nickname = c16.nickname;
            allInOne.gender = (byte) c16.gender;
            if (QLog.isColorLevel()) {
                QLog.i("startQCallProfileCardActivity ", 2, "QCallCardInfo.uin = " + c16.uin + "QCallCardInfo.nickname = " + c16.nickname + "mPhoneNumber = " + this.f261512t0 + "mFriendUin = " + this.f261506n0);
            }
        }
        if (phoneContact != null) {
            allInOne.nickname = phoneContact.name;
        }
        if ((phoneContact != null || c16 != null) && this.f261512t0 != null) {
            allInOne.f260789pa = 80;
            ProfileContactInfo profileContactInfo = new ProfileContactInfo(HardCodeUtil.qqStr(R.string.f172375q83), this.f261512t0, "");
            if (allInOne.contactArray == null) {
                ArrayList<ProfileContactInfo> arrayList = new ArrayList<>();
                allInOne.contactArray = arrayList;
                arrayList.add(profileContactInfo);
            }
            ProfileUtils.openProfileCard(this.app.getApplication().getApplicationContext(), allInOne);
            int i16 = this.f261508p0;
            if (i16 == 25) {
                ReportController.o(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
            } else if (i16 == 24 || (i3 = this.f261511s0) == 2 || i3 == 3) {
                ReportController.o(null, "CliOper", "", "", "0X8006250", "0X8006250", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3() {
        if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "updateOnlineStatus mFriendUin : " + this.f261506n0 + " , uinType = " + this.f261508p0);
        }
        this.f261513u0 = bs.A(this.f261506n0, "QCallDetailActivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3() {
        if (this.f261508p0 == 3000) {
            this.f261500h0.setVisibility(8);
            this.f261501i0.setVisibility(8);
            return;
        }
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = this.f261513u0;
        if (cVar != null) {
            if (cVar.z() != 68104 && this.f261513u0.z() != 65805) {
                int a16 = com.tencent.mobileqq.activity.contacts.friend.a.a(this.f261513u0.E(), this.f261513u0.z(), this.f261513u0.C());
                if (QLog.isColorLevel()) {
                    QLog.d("QCallDetailActivity", 2, "friend.getNetWorkType()\uff1a" + a16 + ", friend.detalStatusFlag\uff1a" + ((int) this.f261513u0.u()) + ", friend.iTermType\uff1a" + this.f261513u0.z());
                }
                if (com.tencent.mobileqq.friend.status.b.a(this.f261513u0.u(), this.f261513u0.z()) == 0) {
                    return;
                }
                if (a16 != 2 && a16 != 3 && a16 != 4 && a16 != 5 && a16 != 1 && this.f261513u0.C() != 7 && this.f261513u0.C() != 8) {
                    this.f261500h0.setVisibility(8);
                    return;
                }
                if (a16 == 2) {
                    this.f261500h0.setVisibility(8);
                    this.f261501i0.setText(R.string.fb_);
                    this.f261501i0.setContentDescription(getString(R.string.fb_));
                    return;
                }
                if (a16 == 3) {
                    this.f261500h0.setVisibility(8);
                    this.f261501i0.setText(R.string.fba);
                    this.f261501i0.setContentDescription(getString(R.string.fba));
                    return;
                }
                if (a16 == 4) {
                    this.f261500h0.setVisibility(8);
                    this.f261501i0.setText(R.string.fbb);
                    this.f261501i0.setContentDescription(getString(R.string.fbb));
                    return;
                }
                if (a16 == 5) {
                    this.f261500h0.setVisibility(8);
                    this.f261501i0.setText(R.string.f197854l5);
                    this.f261501i0.setContentDescription(getString(R.string.f197854l5));
                    return;
                }
                if (this.f261513u0.C() == 7) {
                    this.f261500h0.setVisibility(8);
                    this.f261501i0.setText(getString(R.string.fbe));
                    this.f261501i0.setContentDescription(getString(R.string.fbe));
                    return;
                } else if (this.f261513u0.C() == 8) {
                    this.f261500h0.setVisibility(8);
                    this.f261501i0.setText(getString(R.string.fbc));
                    this.f261501i0.setContentDescription(getString(R.string.fbc));
                    return;
                } else if (this.f261513u0.C() == 9) {
                    this.f261500h0.setVisibility(8);
                    this.f261501i0.setText(getString(R.string.fbd));
                    this.f261501i0.setContentDescription(getString(R.string.fbd));
                    return;
                } else {
                    this.f261500h0.setVisibility(0);
                    this.f261500h0.setBackgroundResource(R.drawable.qq_contacts_network_wifi);
                    this.f261501i0.setText(R.string.fbf);
                    this.f261501i0.setContentDescription(getString(R.string.fbf));
                    return;
                }
            }
            this.f261500h0.setVisibility(8);
            this.f261501i0.setVisibility(8);
        }
    }

    private void initListView() {
        XListView xListView = (XListView) findViewById(R.id.f166626gq3);
        this.f261503k0 = xListView;
        xListView.addHeaderView(this.f261493a0);
        g gVar = new g();
        this.f261505m0 = gVar;
        this.f261503k0.setAdapter((ListAdapter) gVar);
    }

    public void Q2(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str);
            return;
        }
        ActionSheet create = ActionSheet.create(context);
        int[] iArr = this.E0;
        iArr[0] = 2;
        iArr[1] = 3;
        if (this.f261508p0 == 26) {
            com.tencent.mobileqq.qcall.a.a(this.app, context, str);
            return;
        }
        create.addButton(R.string.f170660xn);
        create.addCancelButton(R.string.cancel);
        create.setOnDismissListener(new e());
        create.setOnButtonClickListener(new f(str, create));
        create.show();
        ReportController.o(this.app, "CliOper", "", "", "0X8005AF6", "0X8005AF6", 0, 0, "", "", "", "");
    }

    public void V2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) DiscussionInfoCardActivity.class);
        intent.putExtra("uin", this.f261506n0);
        intent.putExtra("uinname", this.f261510r0);
        intent.putExtra("uintype", this.f261509q0);
        startActivityForResult(intent, 2000);
    }

    void Z2(boolean z16) {
        String resourceUrlOrValue;
        QQAppInterface qQAppInterface;
        int resIdByUin = VipFunCallUtil.getResIdByUin(this.app, this.f261506n0, 6, true, null);
        if (resIdByUin == 0 && z16 && (qQAppInterface = this.app) != null) {
            try {
                VipSetFunCallHandler vipSetFunCallHandler = (VipSetFunCallHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
                Bundle bundle = new Bundle();
                bundle.putLong("uin", Long.parseLong(this.f261506n0));
                bundle.putString("phone", "");
                this.app.addObserver(this.G0, true);
                vipSetFunCallHandler.P2(2, bundle);
            } catch (Exception e16) {
                QLog.e("QCallDetailActivity", 1, "VipSetFunCallHandler Error:" + e16.getMessage());
            }
        }
        if (resIdByUin == 0) {
            resourceUrlOrValue = getResources().getString(R.string.f170662xr);
        } else {
            resourceUrlOrValue = VipFunCallUtil.getResourceUrlOrValue(this.app, resIdByUin, -1, "name");
        }
        if (TextUtils.isEmpty(resourceUrlOrValue)) {
            resourceUrlOrValue = getResources().getString(R.string.f170662xr);
        }
        this.f261496d0.setText(resourceUrlOrValue);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 2000) {
            if (intent != null && intent.getExtras() != null) {
                z16 = intent.getExtras().getBoolean(AppConstants.Key.IS_NEED_FINISH);
            }
            if (z16) {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.asg);
        String string = getString(R.string.fbp);
        setTitle(string, string + getString(R.string.f171265dl3));
        setLeftViewName(R.string.d_b);
        this.f261514v0 = (com.tencent.mobileqq.qcall.f) this.app.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        S2(getIntent());
        U2();
        T2();
        initListView();
        addObserver(this.B0);
        addObserver(this.A0);
        addObserver(this.C0);
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.f261515w0 = friendListHandler;
        if (this.f261508p0 == 0 && !friendListHandler.isGetOnlineListRecently() && !this.f261515w0.shouldGetOnlineInfo()) {
            this.f261515w0.getOnlineInfo(this.f261506n0, false);
        }
        this.E0 = new int[3];
        int i16 = this.f261508p0;
        if (i16 == 25) {
            ReportController.o(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
            return true;
        }
        if (i16 == 24 || (i3 = this.f261511s0) == 2 || i3 == 3) {
            ReportController.o(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    public void f3(String str) {
        n nVar;
        DiscussionInfo h16;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (!isFinishing() && (nVar = (n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)) != null && (h16 = nVar.h(str)) != null && (str2 = h16.discussionName) != null) {
            this.f261510r0 = str2;
            this.f261497e0.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, str));
            int q16 = nVar.q(str);
            this.f261498f0.setText(this.f261510r0);
            if (q16 > 0) {
                str3 = "(" + q16 + ")";
            } else {
                str3 = "";
            }
            this.f261499g0.setText(str3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            this.f261516x0 = null;
            this.f261517y0 = null;
            if (this.f261508p0 == 1006) {
                this.f261517y0 = this.f261506n0;
            } else {
                this.f261516x0 = this.f261506n0;
            }
            int id5 = view.getId();
            if (R.id.txt == id5) {
                try {
                    id5 = ((Integer) view.getTag()).intValue();
                } catch (Exception unused) {
                }
            }
            if (id5 == R.id.ivTitleBtnLeft) {
                finish();
            } else if (id5 == R.id.f166625gq2) {
                if (this.f261508p0 == 3000) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
                    ReportController.o(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
                }
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                m3.putExtra("uin", this.f261506n0);
                m3.putExtra("uintype", this.f261508p0);
                m3.putExtra("uinname", this.f261510r0);
                m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
                startActivity(m3);
            } else if (id5 == R.id.f166624gq1) {
                ReportController.o(this.app, "CliOper", "", this.f261506n0, "Two_call", "Two_call_launch", 0, 0, "15", R2(this.f261508p0), "", "");
                ReportController.o(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
                int i17 = this.f261508p0;
                if (i17 == 1024) {
                    if (CrmUtils.o(this.app, this.f261516x0, i17)) {
                        CrmUtils.z(this.app, this, this.f261510r0, this.f261516x0, "IvrCallDetailEngineFalse");
                        ReportController.o(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
                    } else {
                        QQToast.makeText(view.getContext(), R.string.dg5, 1).show(view.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        if (QLog.isColorLevel()) {
                            QLog.d("QCallDetailActivity", 2, "Don't support ivr");
                        }
                    }
                } else {
                    ChatActivityUtils.h0(this.app, this, i17, this.f261516x0, this.f261510r0, this.f261517y0, false, this.f261507o0, true, true, null, "from_internal");
                }
            } else if (id5 == R.id.f166623gq0) {
                W2();
            } else if (id5 == R.id.ao9) {
                if (this.f261508p0 == 26) {
                    com.tencent.mobileqq.qcall.a.a(this.app, this, this.f261506n0);
                }
            } else if (id5 == R.id.f166011e33) {
                int currentUserVipType = ((ISVIPHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
                if (currentUserVipType == 2) {
                    i16 = 0;
                } else if (currentUserVipType == 3) {
                    i16 = 2;
                } else {
                    i16 = currentUserVipType;
                }
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_CALLDETAIL);
                VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.getMarketUrl(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, intent, true, -1);
                ReportController.o(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + i16, "", "", "");
            } else if ((id5 == R.id.f79 || id5 == R.id.e4q) && (i3 = this.f261508p0) != 2016) {
                if (i3 != 3000) {
                    if (i3 != 56938) {
                        b3();
                        ReportController.o(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
                    }
                } else {
                    ReportController.o(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
                    V2();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.G0);
        }
        ChatActivityUtils.I();
        g gVar = this.f261505m0;
        if (gVar != null) {
            gVar.f261533d = null;
            this.f261505m0 = null;
        }
        ThreadManagerV2.remove(this.F0);
        this.F0 = null;
        removeObserver(this.B0);
        removeObserver(this.A0);
        removeObserver(this.C0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            Y2();
        }
    }
}
