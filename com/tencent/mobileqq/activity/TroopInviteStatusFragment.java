package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.ax;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.common.TroopNotificationErrorCode;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.troop.ITroopNotificationRepoApi;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TroopInviteStatusFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    View C;
    View D;
    View E;
    View F;
    View G;
    Button H;
    TextView I;
    ImageView J;
    SingleLineTextView K;
    SingleLineTextView L;
    TextView M;
    BaseActivity N;
    QQAppInterface P;
    String Q;
    String R;
    String S;
    String T;
    String U;
    long V;
    boolean W;
    Handler X;
    TroopInfo Y;
    boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    QQProgressDialog f177343a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f177344b0;

    /* renamed from: c0, reason: collision with root package name */
    int f177345c0;

    /* renamed from: d0, reason: collision with root package name */
    int f177346d0;

    /* renamed from: e0, reason: collision with root package name */
    ArrayList<String> f177347e0;

    /* renamed from: f0, reason: collision with root package name */
    int f177348f0;

    /* renamed from: g0, reason: collision with root package name */
    Runnable f177349g0;

    /* renamed from: h0, reason: collision with root package name */
    Runnable f177350h0;

    /* renamed from: i0, reason: collision with root package name */
    Runnable f177351i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.b f177352j0;

    /* renamed from: k0, reason: collision with root package name */
    private ax.c f177353k0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInviteStatusFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void d(boolean z16, int i3, int i16, int i17, ArrayList<String> arrayList, int i18) {
            TroopInviteStatusFragment troopInviteStatusFragment;
            String str;
            TroopInviteStatusFragment troopInviteStatusFragment2;
            BaseActivity baseActivity;
            TroopInviteStatusFragment troopInviteStatusFragment3;
            Handler handler;
            int i19 = i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), arrayList, Integer.valueOf(i18));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopInviteStatusFragment", 2, "onGetGroupInviteStatus success:" + z16 + " group_members_num:" + i16 + " group_friends_num:" + i17 + " friends_uins:" + arrayList + " status:" + i19);
            }
            TroopInviteStatusFragment troopInviteStatusFragment4 = TroopInviteStatusFragment.this;
            Handler handler2 = troopInviteStatusFragment4.X;
            if (handler2 != null) {
                handler2.removeCallbacks(troopInviteStatusFragment4.f177349g0);
            }
            QQProgressDialog qQProgressDialog = TroopInviteStatusFragment.this.f177343a0;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            if (z16) {
                synchronized (TroopInviteStatusFragment.this) {
                    troopInviteStatusFragment2 = TroopInviteStatusFragment.this;
                    troopInviteStatusFragment2.f177347e0 = arrayList;
                    troopInviteStatusFragment2.f177346d0 = i17;
                }
                troopInviteStatusFragment2.f177345c0 = i16;
                troopInviteStatusFragment2.f177348f0 = i19;
                if (i19 == 5 && troopInviteStatusFragment2.Z && (baseActivity = troopInviteStatusFragment2.N) != null && !baseActivity.isFinishing() && (handler = (troopInviteStatusFragment3 = TroopInviteStatusFragment.this).X) != null) {
                    troopInviteStatusFragment3.Z = false;
                    handler.postDelayed(troopInviteStatusFragment3.f177351i0, 1000L);
                }
            } else {
                switch (i3) {
                    case 1282:
                    case 1283:
                    case 1284:
                    case 1285:
                        synchronized (TroopInviteStatusFragment.this) {
                            troopInviteStatusFragment = TroopInviteStatusFragment.this;
                            troopInviteStatusFragment.f177347e0 = arrayList;
                            troopInviteStatusFragment.f177346d0 = i17;
                        }
                        troopInviteStatusFragment.f177345c0 = i16;
                        troopInviteStatusFragment.f177348f0 = 6;
                        i19 = 6;
                        break;
                    default:
                        QQToast.makeText(TroopInviteStatusFragment.this.N, 1, HardCodeUtil.qqStr(R.string.uik), 0).show(TroopInviteStatusFragment.this.N.getTitleBarHeight()).show();
                        break;
                }
            }
            if (i19 != 6) {
                String[] strArr = new String[2];
                if (TroopInviteStatusFragment.this.W) {
                    str = "1";
                } else {
                    str = "2";
                }
                strArr[0] = str;
                strArr[1] = String.valueOf(i19);
                com.tencent.mobileqq.utils.eu.g("Grp_AIO", "invite", "in_exp", 0, 0, strArr);
            } else {
                com.tencent.mobileqq.utils.eu.g("Grp_AIO", "invite", "in_past", 0, 0, new String[0]);
            }
            TroopInviteStatusFragment.this.Ah();
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void g(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            QQProgressDialog qQProgressDialog = TroopInviteStatusFragment.this.f177343a0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                TroopInviteStatusFragment.this.f177343a0.dismiss();
            }
            if (!TroopInviteStatusFragment.this.Q.equals(str)) {
                return;
            }
            if (!z16) {
                TroopInviteStatusFragment.this.yh();
                return;
            }
            if (i3 <= 0) {
                TroopInviteStatusFragment.this.yh();
                QQProgressDialog qQProgressDialog2 = TroopInviteStatusFragment.this.f177343a0;
                if (qQProgressDialog2 != null) {
                    qQProgressDialog2.setMessage(R.string.hex);
                    TroopInviteStatusFragment.this.f177343a0.show();
                    return;
                }
                return;
            }
            com.tencent.mobileqq.troop.utils.ax.c(TroopInviteStatusFragment.this.getBaseActivity(), TroopInviteStatusFragment.this.f177353k0, new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements ax.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInviteStatusFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.ax.c
        public void a(Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopInviteStatusFragment.this.yh();
                QQProgressDialog qQProgressDialog = TroopInviteStatusFragment.this.f177343a0;
                if (qQProgressDialog != null) {
                    qQProgressDialog.setMessage(R.string.hex);
                    TroopInviteStatusFragment.this.f177343a0.show();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) objArr);
        }
    }

    public TroopInviteStatusFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.W = false;
        this.Z = false;
        this.f177344b0 = true;
        this.f177345c0 = 0;
        this.f177346d0 = 0;
        this.f177347e0 = null;
        this.f177348f0 = 0;
        this.f177349g0 = new Runnable() { // from class: com.tencent.mobileqq.activity.TroopInviteStatusFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInviteStatusFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseActivity baseActivity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QQProgressDialog qQProgressDialog = TroopInviteStatusFragment.this.f177343a0;
                if (qQProgressDialog != null && !qQProgressDialog.isShowing() && (baseActivity = TroopInviteStatusFragment.this.N) != null && !baseActivity.isFinishing()) {
                    TroopInviteStatusFragment.this.f177343a0.setMessage(R.string.f173059h05);
                    TroopInviteStatusFragment.this.f177343a0.show();
                }
            }
        };
        this.f177350h0 = new Runnable() { // from class: com.tencent.mobileqq.activity.TroopInviteStatusFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInviteStatusFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.troop.api.handler.h hVar = (com.tencent.mobileqq.troop.api.handler.h) TroopInviteStatusFragment.this.P.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
                TroopInviteStatusFragment troopInviteStatusFragment = TroopInviteStatusFragment.this;
                hVar.M0(troopInviteStatusFragment.Q, troopInviteStatusFragment.S, troopInviteStatusFragment.V);
                TroopManager troopManager = (TroopManager) TroopInviteStatusFragment.this.P.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null) {
                    TroopInviteStatusFragment troopInviteStatusFragment2 = TroopInviteStatusFragment.this;
                    troopInviteStatusFragment2.Y = troopManager.k(troopInviteStatusFragment2.Q);
                }
            }
        };
        this.f177351i0 = new Runnable() { // from class: com.tencent.mobileqq.activity.TroopInviteStatusFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInviteStatusFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                BaseActivity baseActivity = TroopInviteStatusFragment.this.N;
                if (baseActivity != null && !baseActivity.isFinishing()) {
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(TroopInviteStatusFragment.this.N), null);
                    m3.putExtra("uin", TroopInviteStatusFragment.this.Q);
                    m3.putExtra("uintype", 1);
                    m3.putExtra("uinname", TroopInviteStatusFragment.this.R);
                    m3.putExtra("troop_uin", TroopInviteStatusFragment.this.Q);
                    TroopInviteStatusFragment.this.startActivity(m3);
                    TroopInviteStatusFragment.this.N.finish();
                }
            }
        };
        this.f177352j0 = new a();
        this.f177353k0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        ArrayList<String> arrayList;
        View view = this.D;
        if (view == null) {
            return;
        }
        if (this.f177348f0 == 6) {
            view.setVisibility(8);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(0);
            this.C.setBackgroundResource(R.drawable.b4w);
            return;
        }
        this.C.setBackgroundResource(R.drawable.bg_texture);
        if (this.W) {
            this.D.setVisibility(0);
            this.E.setVisibility(8);
            this.F.setVisibility(0);
            this.G.setVisibility(8);
            this.L.setVisibility(8);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            int i3 = this.f177348f0;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 == 7) {
                                    this.I.setVisibility(0);
                                    this.I.setText(HardCodeUtil.qqStr(R.string.uih));
                                }
                            } else {
                                this.I.setVisibility(0);
                                this.I.setText(HardCodeUtil.qqStr(R.string.uie));
                            }
                        } else {
                            this.I.setVisibility(0);
                            this.I.setText(HardCodeUtil.qqStr(R.string.uim));
                        }
                    } else {
                        this.I.setVisibility(0);
                        this.I.setText(HardCodeUtil.qqStr(R.string.uif));
                    }
                } else {
                    this.I.setVisibility(0);
                    this.I.setText(HardCodeUtil.qqStr(R.string.uig));
                }
            } else {
                this.I.setVisibility(0);
                this.I.setText(HardCodeUtil.qqStr(R.string.uin));
            }
        } else {
            this.D.setVisibility(0);
            this.F.setVisibility(0);
            this.G.setVisibility(8);
            this.L.setVisibility(0);
            this.L.setText(uh(this.U, this.T, 8) + HardCodeUtil.qqStr(R.string.uij));
            if (TextUtils.isEmpty(this.T) || "0".equals(this.T)) {
                this.L.setVisibility(8);
            }
            synchronized (this) {
                ArrayList<String> arrayList2 = this.f177347e0;
                if (arrayList2 != null && arrayList2.contains(this.T)) {
                    this.f177347e0.remove(this.T);
                    this.f177346d0--;
                }
                if (this.f177346d0 > 0 && (arrayList = this.f177347e0) != null && !arrayList.isEmpty()) {
                    StringBuilder sb5 = new StringBuilder();
                    Iterator<String> it = this.f177347e0.iterator();
                    float f16 = 0.0f;
                    int i16 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        String Q = com.tencent.mobileqq.utils.ac.Q(this.P, next, 0);
                        f16 += com.tencent.mobileqq.utils.ac.d0(Q);
                        if (f16 < 20) {
                            if (i16 > 0) {
                                sb5.append("\u3001");
                            }
                            sb5.append(Q);
                            i16++;
                        } else if (i16 == 0) {
                            sb5.append(uh(Q, next, 20));
                            i16++;
                        }
                    }
                    int i17 = this.f177346d0;
                    if (i17 > 99) {
                        sb5.append("\u7b4999+\u4eba\u4e5f\u5728\u7fa4\u804a\u4e2d");
                    } else if (i16 < i17) {
                        sb5.append("\u7b49");
                        sb5.append(this.f177346d0);
                        sb5.append("\u4eba\u4e5f\u5728\u7fa4\u804a\u4e2d");
                    } else {
                        sb5.append("\u4e5f\u5728\u7fa4\u804a\u4e2d");
                    }
                    this.E.setVisibility(0);
                    this.M.setText(sb5.toString());
                } else {
                    this.E.setVisibility(8);
                }
            }
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            int i18 = this.f177348f0;
            if (i18 != -1) {
                if (i18 != 7) {
                    if (i18 != 1) {
                        if (i18 != 2) {
                            if (i18 != 3) {
                                if (i18 != 4) {
                                    if (i18 == 5) {
                                        this.I.setVisibility(0);
                                        this.I.setText(HardCodeUtil.qqStr(R.string.uil));
                                    }
                                } else {
                                    this.I.setVisibility(0);
                                    this.I.setText(HardCodeUtil.qqStr(R.string.uia));
                                }
                            } else {
                                this.I.setVisibility(0);
                                this.I.setText(HardCodeUtil.qqStr(R.string.uid));
                            }
                        } else {
                            this.I.setVisibility(0);
                            this.I.setText(HardCodeUtil.qqStr(R.string.uib));
                        }
                    } else {
                        this.H.setVisibility(0);
                    }
                } else {
                    this.I.setVisibility(0);
                    this.I.setText(HardCodeUtil.qqStr(R.string.uii));
                }
            } else {
                this.I.setVisibility(0);
                this.I.setText("");
            }
        }
        this.J.setImageDrawable(FaceDrawable.getFaceDrawable(this.P, 4, this.Q));
        String str = "";
        TroopInfo troopInfo = this.Y;
        if (troopInfo != null) {
            str = troopInfo.getTroopDisplayName();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.R;
        }
        if (!TextUtils.isEmpty(str) && this.f177345c0 > 0) {
            str = str + "(" + this.f177345c0 + ")";
        }
        this.K.setText(str);
    }

    private void initViews() {
        this.C = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.root);
        this.D = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.jyy);
        this.E = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.eow);
        this.F = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.j26);
        this.G = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bzr);
        this.H = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164075jb);
        this.I = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.j1x);
        this.J = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.jyu);
        this.K = (SingleLineTextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.k0i);
        this.L = (SingleLineTextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.doe);
        this.M = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166223ep0);
        this.J.setOnClickListener(this);
        this.J.setOnTouchListener(new ba.a());
        this.K.setOnClickListener(this);
        this.K.setOnTouchListener(new ba.a());
        this.H.setOnClickListener(this);
        Ah();
    }

    private String uh(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return com.tencent.mobileqq.utils.ac.x(str, i3);
    }

    private boolean vh() {
        Intent intent = this.N.getIntent();
        String stringExtra = intent.getStringExtra(IProfileProtocolConst.PARAM_TROOP_CODE);
        this.Q = stringExtra;
        if (stringExtra != null) {
            this.Q = stringExtra.trim();
        }
        this.R = intent.getStringExtra("troopName");
        this.S = intent.getStringExtra("invitedUin");
        this.T = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        this.U = intent.getStringExtra("senderNick");
        this.V = intent.getLongExtra("msgSeq", 0L);
        if (QLog.isColorLevel()) {
            QLog.d("TroopInviteStatusFragment", 2, "initData troopCode:" + this.Q + " invitedUin:" + this.S + " msgSeq:" + this.V + " sendUin:" + this.T + " currentUin:" + this.P.getCurrentUin() + " troopName:" + this.R);
        }
        if (TextUtils.equals(this.T, this.P.getCurrentUin())) {
            this.W = true;
        } else if (TextUtils.equals(this.S, this.P.getCurrentUin())) {
            this.W = false;
        } else {
            this.N.finish();
            return false;
        }
        this.P.addObserver(this.f177352j0);
        this.X = new Handler();
        BaseActivity baseActivity = this.N;
        this.f177343a0 = new QQProgressDialog(baseActivity, baseActivity.getTitleBarHeight());
        if (!NetworkUtil.isNetSupport(getBaseActivity())) {
            QQToast.makeText(this.N, getBaseActivity().getString(R.string.f171137ci2), 0).show(this.N.getTitleBarHeight()).show();
            return true;
        }
        TroopManager troopManager = (TroopManager) this.P.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            this.Y = troopManager.k(this.Q);
        }
        this.X.postDelayed(this.f177349g0, 1000L);
        this.X.post(this.f177350h0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit wh(Boolean bool, Integer num, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopInviteStatusFragment", 2, "invoke: ");
        }
        xh(bool.booleanValue(), TroopNotificationErrorCode.f355701a.a().get(num));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).operateNotification(GroupNotifyOperateType.KAGREE, this.V, GroupNotifyMsgType.INVITEDBYMEMBER, this.Q, new Function3() { // from class: com.tencent.mobileqq.activity.fw
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit wh5;
                wh5 = TroopInviteStatusFragment.this.wh((Boolean) obj, (Integer) obj2, (String) obj3);
                return wh5;
            }
        });
    }

    public static void zh(QQAppInterface qQAppInterface, Context context, String str, String str2, String str3, long j3, String str4, String str5) {
        if (qQAppInterface != null && context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopInviteStatusFragment", 2, "troopCode:" + str + " invitedUin:" + str3 + " msgSeq:" + j3 + " senderUin:" + str4 + " currentUin:" + qQAppInterface.getCurrentUin());
            }
            if (TextUtils.equals(str5, str4)) {
                str5 = com.tencent.mobileqq.utils.ac.f(qQAppInterface, str4);
            }
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra(IProfileProtocolConst.PARAM_TROOP_CODE, str);
            intent.putExtra("troopName", str2);
            intent.putExtra("invitedUin", str3);
            intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, str4);
            intent.putExtra("senderNick", str5);
            intent.putExtra("msgSeq", j3);
            PublicFragmentActivity.b.a(context, intent, PublicTransFragmentActivity.class, TroopInviteStatusFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        BaseActivity baseActivity = getBaseActivity();
        this.N = baseActivity;
        if (baseActivity != null && (qQAppInterface = baseActivity.app) != null && ((IphoneTitleBarFragment) this).mContentView != null) {
            this.P = qQAppInterface;
            if (vh()) {
                initViews();
                return;
            }
            return;
        }
        QLog.e("TroopInviteStatusFragment", 1, "doOnCreateView error mActivity:" + this.N + " mContentView:" + ((IphoneTitleBarFragment) this).mContentView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.layout.aje;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.jyu && id5 != R.id.k0i) {
                if (id5 == R.id.f164075jb) {
                    com.tencent.mobileqq.utils.eu.g("Grp_AIO", "invite", "in_agree", 0, 0, new String[0]);
                    if (!NetworkUtil.isNetSupport(getBaseActivity())) {
                        QQToast.makeText(this.N, getBaseActivity().getString(R.string.f171137ci2), 0).show(this.N.getTitleBarHeight()).show();
                    } else {
                        try {
                            ((com.tencent.mobileqq.troop.api.handler.h) this.P.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).v0(Long.valueOf(this.Q).longValue(), Long.valueOf(this.P.getCurrentUin()).longValue(), null);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            QLog.d("TroopInviteStatusFragment", 2, "troopCode is null");
                        }
                        QQProgressDialog qQProgressDialog = this.f177343a0;
                        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                            this.f177343a0.dismiss();
                        }
                        QQProgressDialog qQProgressDialog2 = this.f177343a0;
                        if (qQProgressDialog2 != null) {
                            qQProgressDialog2.setMessage(R.string.hex);
                            this.f177343a0.show();
                        }
                    }
                }
            } else {
                com.tencent.mobileqq.utils.eu.g("Grp_AIO", "invite", "in_clk", 0, 0, new String[0]);
                Bundle b16 = com.tencent.mobileqq.troop.utils.aq.b(this.Q, 4);
                b16.putInt("t_s_f", 1001);
                TroopUtils.I(this.N, b16, 2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(HardCodeUtil.qqStr(R.string.uic));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.P;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f177352j0);
        }
        QQProgressDialog qQProgressDialog = this.f177343a0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f177343a0.dismiss();
        }
        Handler handler = this.X;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        Handler handler = this.X;
        if (handler != null) {
            handler.removeCallbacks(this.f177349g0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        if (!this.f177344b0) {
            Ah();
        }
        this.f177344b0 = false;
    }

    protected void xh(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f177343a0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f177343a0.dismiss();
        }
        if (!z16) {
            String string = this.N.getResources().getString(R.string.he7);
            if (TextUtils.isEmpty(str)) {
                str = string;
            }
            QQToast.makeText(this.N, 1, str, 0).show(this.N.getTitleBarHeight());
            return;
        }
        QQToast.makeText(this.N, 2, this.N.getResources().getString(R.string.bcs), 0).show(this.N.getTitleBarHeight());
        this.f177348f0 = -1;
        Ah();
        this.Z = true;
        this.X.post(this.f177350h0);
    }
}
