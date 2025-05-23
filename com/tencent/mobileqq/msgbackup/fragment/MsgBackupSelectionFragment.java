package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.j;
import com.tencent.mobileqq.msgbackup.fragment.a;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupSelectionFragment extends QIphoneTitleBarFragment implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private RecyclerView C;
    private com.tencent.mobileqq.msgbackup.fragment.a D;
    private TextView E;
    private RelativeLayout F;
    private TextView G;
    private TextView H;
    private Button I;
    protected List<j> J;
    private MsgBackupManager K;
    private boolean L;
    private int M;
    private LinearLayoutManager N;
    private long P;
    private long Q;
    private int R;
    private String S;
    private String T;
    private String U;
    private MqqHandler V;
    private final int W;
    private View X;
    private View Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private a.b f251247a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements com.tencent.mobileqq.msgbackup.controller.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupSelectionFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.b
        public void a(List<j> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MsgBackupSelectionFragment.this.Z = true;
                if (list != null && list.size() > 0) {
                    MsgBackupSelectionFragment.this.J.clear();
                    MsgBackupSelectionFragment.this.J.addAll(list);
                } else if (MsgBackupSelectionFragment.this.M == 0) {
                    d.e("0X800A232");
                } else if (MsgBackupManager.N) {
                    d.e("0X800A257");
                }
                MsgBackupSelectionFragment.this.V.sendMessage(MsgBackupSelectionFragment.this.V.obtainMessage(10000));
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupSelectionFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 1) {
                f.D("MsgBackup.MsgBackupSelectionFragment", "click cancel btn mfrom = %d,  pcHandler = %b", Integer.valueOf(MsgBackupSelectionFragment.this.M), Boolean.valueOf(MsgBackupManager.N));
                if (MsgBackupSelectionFragment.this.M == 0) {
                    if (MsgBackupSelectionFragment.this.Z) {
                        i16 = 3;
                    }
                    d.f("0X800A242", i16);
                } else if (MsgBackupManager.N && com.tencent.mobileqq.msgbackup.authentication.a.d().b() == 1) {
                    d.f("0X800A266", 5);
                }
                MsgBackupSelectionFragment.this.onBackEvent();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements a.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupSelectionFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.fragment.a.b
        public void a(boolean z16, j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), jVar);
                return;
            }
            if (z16) {
                MsgBackupSelectionFragment.this.K.f251037a.add(jVar);
            } else {
                MsgBackupSelectionFragment.this.K.f251037a.remove(jVar);
            }
            MsgBackupSelectionFragment.this.Dh(MsgBackupSelectionFragment.this.K.f251037a.size());
        }
    }

    public MsgBackupSelectionFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.J = new ArrayList();
        this.L = false;
        this.P = 0L;
        this.Q = 0L;
        this.R = -1000;
        this.W = 10000;
        this.Z = false;
        this.f251247a0 = new c();
    }

    private void Ah() {
        this.L = !this.L;
        if (this.J.size() > 0) {
            Eh(this.J.size(), this.L);
        }
        Iterator<j> it = this.J.iterator();
        while (it.hasNext()) {
            MsgBackupManager.x().f251037a.add(it.next());
        }
        this.D.v();
    }

    private void Bh(TextView textView, int i3) {
        if (textView != null) {
            textView.setText(i3);
            if (AppSetting.f99565y) {
                textView.setContentDescription(getString(i3));
            }
        }
    }

    private void Ch() {
        boolean z16 = !this.L;
        this.L = z16;
        Eh(0, z16);
        this.D.y();
        MsgBackupManager.x().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(int i3) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 > 0) {
            sb5.append(getString(R.string.ijn, Integer.valueOf(i3)));
        }
        if (this.P != 0 && this.Q != 0) {
            if (i3 > 0) {
                sb5.append("\n");
            }
            sb5.append(getString(R.string.ij8, this.S, this.T));
        }
        if (this.R == 2) {
            sb5.append("\n");
            sb5.append(getString(R.string.iiy));
        }
        if (sb5.length() > 0) {
            this.E.setVisibility(0);
            this.E.setText(sb5.toString());
        } else {
            this.E.setVisibility(8);
        }
        if (i3 > 0) {
            this.I.setEnabled(true);
            if (i3 == this.J.size()) {
                this.L = true;
                Bh(this.G, R.string.ikh);
                return;
            } else {
                this.L = false;
                Bh(this.G, R.string.ijw);
                return;
            }
        }
        this.I.setEnabled(false);
        this.L = false;
        Bh(this.G, R.string.ijw);
    }

    private void Eh(int i3, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 > 0) {
            sb5.append(getString(R.string.ijn, Integer.valueOf(i3)));
        }
        if (this.P != 0 && this.Q != 0) {
            if (i3 > 0) {
                sb5.append("\n");
            }
            sb5.append(getString(R.string.ij8, this.S, this.T));
        }
        if (this.R == 2) {
            sb5.append("\n");
            sb5.append(getString(R.string.iiy));
        }
        if (sb5.length() > 0) {
            this.E.setVisibility(0);
            this.E.setText(sb5.toString());
        } else {
            this.E.setVisibility(8);
        }
        if (z16) {
            Bh(this.G, R.string.ikh);
            this.I.setEnabled(true);
        } else {
            Bh(this.G, R.string.ijw);
            this.I.setEnabled(false);
        }
    }

    private void initData() {
        MsgBackupManager.x().f251037a.clear();
        MsgBackupManager.x().Z(new a());
        MsgBackupManager.x().E();
    }

    private void initUI() {
        this.F = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lae);
        this.G = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ilv);
        Bh(this.I, R.string.ijw);
        TextView textView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lfa);
        this.H = textView;
        Bh(textView, R.string.ijx);
        Button button = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.m7v);
        this.I = button;
        Bh(button, R.string.ijm);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.I.setEnabled(false);
        TextView textView2 = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lse);
        this.E = textView2;
        textView2.setVisibility(8);
        this.C = (RecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lsa);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.N = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.C.setLayoutManager(this.N);
        com.tencent.mobileqq.msgbackup.fragment.a aVar = new com.tencent.mobileqq.msgbackup.fragment.a(getActivity(), (BaseQQAppInterface) getQBaseActivity().getAppRuntime(), this.C);
        this.D = aVar;
        this.C.setAdapter(aVar);
        this.D.w(this.f251247a0);
        this.Y = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bwv);
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.eet);
        this.X = findViewById;
        findViewById.setVisibility(0);
        this.f211174vg.setOnItemSelectListener(new b());
    }

    private void vh() {
        if (this.L) {
            Ch();
            if (this.M == 0) {
                d.f("0X800A233", 2);
                return;
            } else {
                if (MsgBackupManager.N) {
                    d.f("0X800A258", 2);
                    return;
                }
                return;
            }
        }
        Ah();
        if (this.M == 0) {
            d.f("0X800A233", 1);
        } else if (MsgBackupManager.N) {
            d.f("0X800A258", 1);
        }
    }

    private void wh() {
        Bundle arguments = getArguments();
        this.M = arguments.getInt("backup_select_from", 0);
        this.U = arguments.getString("0x11bpush_extra");
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "handlerArg, mFrom = " + this.M);
        }
    }

    private void xh() {
        this.K = MsgBackupManager.x();
    }

    private void yh() {
        int i3;
        int i16;
        String str;
        Iterator<j> it = MsgBackupManager.x().f251037a.iterator();
        int i17 = 0;
        while (true) {
            i3 = 3;
            i16 = 2;
            if (!it.hasNext()) {
                break;
            }
            if (ao.r(it.next().f())) {
                if (i17 == 2) {
                    i17 = 3;
                    break;
                }
                i17 = 1;
            } else if (i17 == 1) {
                i17 = 3;
            } else {
                i17 = 2;
            }
        }
        if (this.P != 0 && this.Q != 0) {
            i3 = 1;
        }
        if (this.R == 2) {
            if (i3 != 1) {
                i16 = 4;
            }
        } else {
            i16 = i3;
        }
        if (this.M == 0) {
            str = "0X800A238";
        } else if (MsgBackupManager.N) {
            str = "0X800A25D";
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            d.g(str, i17, i16);
        }
    }

    private void zh() {
        ViewUtils.setVisible(this.C, 0);
        ViewUtils.setVisible(this.Y, 8);
        ViewUtils.setVisible(this.X, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.V = new MqqHandler(Looper.getMainLooper(), this);
        wh();
        xh();
        initUI();
        initData();
        MsgBackupManager.x().n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.cbu;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 10000) {
            zh();
            List<j> list = this.J;
            if (list != null && list.size() > 0) {
                this.D.x(this.J);
                this.D.s();
                this.D.notifyDataSetChanged();
            } else {
                this.C.setVisibility(4);
                this.H.setEnabled(false);
                this.G.setEnabled(false);
                this.Y.setVisibility(0);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1000 && i16 == 0) {
            if (intent != null) {
                this.P = intent.getLongExtra("session_start_time", 0L);
                this.Q = intent.getLongExtra("session_end_time", 0L);
                this.S = intent.getStringExtra("session_start_time_str");
                this.T = intent.getStringExtra("session_end_time_str");
                this.R = intent.getIntExtra("session_content_type", 1);
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onActivityResult startTime = " + this.P + ", endTime = " + this.Q + ", mCurContentType = " + this.R + ", startTimeShow = " + this.S + ", endTimeShow = " + this.T);
                }
                Dh(this.K.f251037a.size());
                return;
            }
            return;
        }
        if (1000 == i3 && i16 == 1001) {
            if (getActivity() != null) {
                getActivity().setResult(1001);
            }
            onBackEvent();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ilv) {
                vh();
            } else if (id5 == R.id.lfa) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "date_select startTime = " + this.P + ", endTime = " + this.Q + ", mCurContentType = " + this.R + ", startTimeShow = " + this.S + ", endTimeShow = " + this.T);
                }
                Intent intent = new Intent();
                intent.putExtra("session_start_time", this.P);
                intent.putExtra("session_end_time", this.Q);
                intent.putExtra("session_start_time_str", this.S);
                intent.putExtra("session_end_time_str", this.T);
                intent.putExtra("session_content_type", this.R);
                intent.putExtra("backup_select_from", this.M);
                QPublicFragmentActivity.startForResult(getActivity(), intent, (Class<? extends QPublicBaseFragment>) MsgBackupDateFragment.class, 1000);
            } else if (id5 == R.id.m7v) {
                MsgBackupManager.K = MsgBackupManager.x().f251037a.size();
                d.b();
                d.f251402a.f251377g = MsgBackupManager.K;
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "select session detail, sessionCount = " + MsgBackupManager.K);
                }
                Intent intent2 = new Intent();
                intent2.putExtra("session_start_time", this.P);
                intent2.putExtra("session_end_time", this.Q);
                intent2.putExtra("session_content_type", this.R);
                int i3 = this.M;
                if (i3 == 0) {
                    intent2.putExtra("session_net_status", NetworkUtil.isWifiEnabled(BaseApplication.getContext()));
                    QPublicFragmentActivity.startForResult(getActivity(), intent2, (Class<? extends QPublicBaseFragment>) MsgBackupQRFragment.class, 1000);
                } else if (i3 == 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_PC");
                    }
                    intent2.putExtra("0x11bpush_extra", this.U);
                    intent2.putExtra("param_start", 2);
                    QPublicFragmentActivity.startForResult(getActivity(), intent2, (Class<? extends QPublicBaseFragment>) MsgBackupPCTransportFragment.class, 1000);
                }
                yh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getActivity().getString(R.string.ijy));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        MsgBackupManager.x().Z(null);
        ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).destoryFaceDecord();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            this.D.notifyDataSetChanged();
        }
    }
}
