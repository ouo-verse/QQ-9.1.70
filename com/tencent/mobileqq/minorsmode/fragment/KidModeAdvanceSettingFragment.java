package com.tencent.mobileqq.minorsmode.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes33.dex */
public class KidModeAdvanceSettingFragment extends IphoneTitleBarFragment {
    private QQAppInterface C;
    private FormSwitchItem D;
    private FormSwitchItem E;
    private FormSwitchItem F;
    private FormSwitchItem G;
    private FormSwitchItem H;
    private FormMultiLineSwitchItem I;
    private Button J;
    private QUISingleLineListItem K;
    private boolean L = false;
    private boolean M = false;
    private int N = 0;
    private int P = 0;
    private KidModeObserver Q = new h();
    private CompoundButton.OnCheckedChangeListener R = new i();
    private CompoundButton.OnCheckedChangeListener S = new c();
    private CompoundButton.OnCheckedChangeListener T = new d();
    private CompoundButton.OnCheckedChangeListener U = new e();
    private CompoundButton.OnCheckedChangeListener V = new f();
    private CompoundButton.OnCheckedChangeListener W = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            KidModeAdvanceSettingFragment.this.I.setEnabled(true);
            KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
            kidModeAdvanceSettingFragment.Hh(kidModeAdvanceSettingFragment.I, false, KidModeAdvanceSettingFragment.this.R);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            KidModeAdvanceSettingFragment.this.I.setEnabled(true);
            KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
            kidModeAdvanceSettingFragment.Hh(kidModeAdvanceSettingFragment.I, false, KidModeAdvanceSettingFragment.this.R);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            KidModeAdvanceSettingFragment.this.Nh(16, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            KidModeAdvanceSettingFragment.this.Nh(32, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            KidModeAdvanceSettingFragment.this.Nh(8, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class f implements CompoundButton.OnCheckedChangeListener {
        f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            if (compoundButton.isPressed()) {
                KidModeAdvanceSettingFragment.this.Nh(128, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class g implements CompoundButton.OnCheckedChangeListener {
        g() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            if (compoundButton.isPressed()) {
                KidModeAdvanceSettingFragment.this.Nh(80, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class i implements CompoundButton.OnCheckedChangeListener {
        i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            if (!NetworkUtil.isNetSupport(KidModeAdvanceSettingFragment.this.getBaseActivity())) {
                QQToast.makeText(KidModeAdvanceSettingFragment.this.getBaseActivity(), 1, R.string.cjm, 1).show();
                KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
                kidModeAdvanceSettingFragment.Hh(kidModeAdvanceSettingFragment.I, !z16, KidModeAdvanceSettingFragment.this.R);
            } else {
                compoundButton.setEnabled(false);
                KidModeAdvanceSettingFragment.this.Ih(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f247137d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f247138e;

        j(Intent intent, Activity activity) {
            this.f247137d = intent;
            this.f247138e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int n3 = StudyModeManager.n();
            int a16 = com.tencent.mobileqq.studymode.g.a();
            int intExtra = this.f247137d.getIntExtra("outer_specific_business_src", -1);
            QLog.d("IphoneTitleBarFragment", 2, "targetMode:" + n3 + ", oldMode:" + a16 + ", specificBusinessSrc:" + intExtra);
            if (com.tencent.mobileqq.studymode.p.g(intExtra)) {
                JumpKidModeMgr.b().i(n3, a16, this.f247138e, intExtra, 1, false);
            } else {
                Intent intent = new Intent();
                intent.putExtra("extra_target_mode", n3);
                intent.putExtra("extra_old_mode", a16);
                intent.putExtra("extra_source", 5);
                this.f247138e.setResult(-1, intent);
            }
            this.f247138e.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            KidModeAdvanceSettingFragment.this.Uh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class n implements DialogInterface.OnClickListener {
        n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            KidModeAdvanceSettingFragment.this.M = true;
            KidModeAdvanceSettingFragment.this.I.setEnabled(true);
            KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
            kidModeAdvanceSettingFragment.Hh(kidModeAdvanceSettingFragment.I, false, KidModeAdvanceSettingFragment.this.R);
            PhoneUnityManager.m(KidModeAdvanceSettingFragment.this.getBaseActivity(), KidModeAdvanceSettingFragment.this.C, StudyModeManager.o(), 2002);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class o implements DialogInterface.OnClickListener {
        o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            KidModeAdvanceSettingFragment.this.I.setEnabled(true);
            KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
            kidModeAdvanceSettingFragment.Hh(kidModeAdvanceSettingFragment.I, false, KidModeAdvanceSettingFragment.this.R);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class p implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f247146d;

        p(int i3) {
            this.f247146d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (NetworkUtil.isNetSupport(KidModeAdvanceSettingFragment.this.getBaseActivity())) {
                KidModeAdvanceSettingFragment.this.Ph(this.f247146d);
                dialogInterface.dismiss();
            } else {
                QQToast.makeText(KidModeAdvanceSettingFragment.this.getBaseActivity(), 1, R.string.cjm, 1).show();
                KidModeAdvanceSettingFragment.this.I.setEnabled(true);
                KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
                kidModeAdvanceSettingFragment.Hh(kidModeAdvanceSettingFragment.I, false, KidModeAdvanceSettingFragment.this.R);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(int i3) {
        if (this.M) {
            this.M = false;
            KidModeServlet.o(this.C, 1);
            return;
        }
        int g16 = StudyModeManager.g();
        this.L = g16 == 0;
        if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarFragment", 1, "isBindPhoneStatus: ", Integer.valueOf(g16), ", setUrl: ", StudyModeManager.o());
        }
        if (this.L) {
            if (this.I.isChecked()) {
                Th(i3);
                return;
            } else {
                Ph(i3);
                return;
            }
        }
        Sh();
    }

    private void Kh() {
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ybt);
        this.K = qUISingleLineListItem;
        qUISingleLineListItem.setStyle(QUIListItemStyle.Card);
        this.K.setBackgroundType(QUIListItemBackgroundType.AllRound);
        this.K.setOnClickListener(new k());
    }

    private void Lh() {
        Intent intent;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (intent = baseActivity.getIntent()) == null) {
            return;
        }
        Button button = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f896450b);
        this.J = button;
        button.setVisibility(intent.getBooleanExtra("need_show_completed_btn", false) ? 0 : 8);
        this.J.setOnClickListener(new j(intent, baseActivity));
    }

    private void Mh() {
        this.H.setVisibility(StudyModeManager.S().booleanValue() ? 0 : 8);
        if (com.tencent.common.config.pad.f.o()) {
            ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.jjt).setVisibility(8);
            this.D.setVisibility(8);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.I.setVisibility(8);
            this.H.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        int i3 = this.P;
        if (i3 == 0 || i3 == this.N) {
            return;
        }
        KidModeServlet.s(this.C, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(String str) {
        if (this.K == null) {
            return;
        }
        if (com.tencent.common.config.pad.f.o()) {
            str = com.tencent.common.config.pad.f.j(getContext());
        }
        this.K.setConfig(new x<>(new x.b.d(HardCodeUtil.qqStr(R.string.f161751yk)), new x.c.g(str, true, false)));
    }

    private void Rh() {
        this.I.setOnCheckedChangeListener(this.R);
        this.D.setOnCheckedChangeListener(this.S);
        this.E.setOnCheckedChangeListener(this.T);
        this.F.setOnCheckedChangeListener(this.U);
        this.G.setOnCheckedChangeListener(this.V);
        this.H.setOnCheckedChangeListener(this.W);
    }

    private void Th(int i3) {
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(getBaseActivity(), 230).setTitle(HardCodeUtil.qqStr(R.string.wn6)).setMessage(getString(R.string.f171056wn0, StudyModeManager.r())).setNegativeButton(HardCodeUtil.qqStr(R.string.iro), new a()).setPositiveButton(HardCodeUtil.qqStr(R.string.wnb), new p(i3));
        positiveButton.setOnCancelListener(new b());
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        positiveButton.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        int i3;
        int i16;
        if (com.tencent.common.config.pad.f.o()) {
            DialogUtil.createCustomDialog(getContext(), 230, "", "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u77ed\u89c6\u9891\u5e74\u9f84\u8bbe\u7f6e\u5f53\u524d\u9ed8\u8ba4\u8ddf\u968f\u7cfb\u7edf\uff0c\u8bf7\u524d\u5f80\u7cfb\u7edf\u8bbe\u7f6e\u4fee\u6539\u3002", (String) null, "\u6211\u77e5\u9053\u4e86", new l(), (DialogInterface.OnClickListener) null).show();
            return;
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.widget.selectorview.e eVar = new com.tencent.mobileqq.widget.selectorview.e(context);
        eVar.k(HardCodeUtil.qqStr(R.string.f161751yk));
        int i17 = this.P;
        if (i17 == 0 && (i17 = this.N) == 0) {
            Calendar calendar = Calendar.getInstance();
            i3 = calendar.get(1);
            i16 = calendar.get(2) + 1;
        } else {
            i3 = i17 >> 16;
            i16 = (i17 & 65280) >>> 8;
        }
        eVar.F(i3, i16, 0);
        eVar.m();
        eVar.i(new m(eVar));
    }

    public static void Vh(Context context, boolean z16) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("need_show_completed_btn", z16);
        intent.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.start(context, intent, KidModeAdvanceSettingFragment.class);
    }

    public static void Wh(Context context, boolean z16, int i3) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("need_show_completed_btn", z16);
        intent.putExtra("outer_specific_business_src", i3);
        intent.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.start(context, intent, KidModeAdvanceSettingFragment.class);
    }

    public static void Xh(Activity activity, boolean z16, int i3) {
        Intent intent = new Intent();
        intent.putExtra("need_show_completed_btn", z16);
        intent.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.startForResult(activity, intent, KidModeAdvanceSettingFragment.class, i3);
    }

    private void Yh() {
        bi();
    }

    private void Zh() {
        int e16 = StudyModeManager.e();
        this.N = e16;
        Qh(Jh(e16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i3, boolean z16) {
        FormSwitchItem formSwitchItem;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarFragment", 2, "updateAdvanceSettingSwitch mask: " + i3 + ", isChecked: " + z16);
        }
        if (i3 == 4) {
            formSwitchItem = this.I;
            onCheckedChangeListener = this.R;
        } else if (i3 == 8) {
            formSwitchItem = this.F;
            onCheckedChangeListener = this.U;
        } else if (i3 == 16) {
            formSwitchItem = this.D;
            onCheckedChangeListener = this.S;
        } else if (i3 == 32) {
            formSwitchItem = this.E;
            onCheckedChangeListener = this.T;
        } else if (i3 == 80) {
            formSwitchItem = this.H;
            onCheckedChangeListener = this.W;
        } else if (i3 != 128) {
            formSwitchItem = null;
            onCheckedChangeListener = null;
        } else {
            formSwitchItem = this.G;
            onCheckedChangeListener = this.V;
        }
        if (formSwitchItem != null) {
            formSwitchItem.setEnabled(true);
            if (formSwitchItem.isChecked() != z16) {
                Hh(formSwitchItem, z16, onCheckedChangeListener);
            }
        }
    }

    private void initUI() {
        this.D = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ybu);
        this.E = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ybv);
        this.F = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ybx);
        this.G = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.yby);
        this.H = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ybw);
        this.I = (FormMultiLineSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ybs);
        Lh();
        Kh();
        Yh();
        Mh();
        Rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (this.C == null || !(getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
            return;
        }
        this.C = (QQAppInterface) getBaseActivity().getAppRuntime();
        initUI();
        KidModeServlet.n(this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gxa;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            this.C = (QQAppInterface) getBaseActivity().getAppRuntime();
        }
        this.C.registObserver(this.Q);
        this.L = StudyModeManager.g() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getBaseActivity().getString(R.string.f171054wm2));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C.unRegistObserver(this.Q);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(FormSwitchItem formSwitchItem, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        formSwitchItem.setOnCheckedChangeListener(null);
        formSwitchItem.setChecked(z16);
        formSwitchItem.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(int i3) {
        StudyModeManager.L(-1);
        KidModeServlet.w(getBaseActivity().app, i3, this.I.isChecked() ? 1 : 0);
    }

    private void Sh() {
        this.M = true;
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(getBaseActivity(), 230).setTitle(HardCodeUtil.qqStr(R.string.cri)).setMessage(HardCodeUtil.qqStr(R.string.f161781yn)).setNegativeButton(HardCodeUtil.qqStr(R.string.f170647xd), new o()).setPositiveButton(HardCodeUtil.qqStr(R.string.f161771ym), new n());
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        positiveButton.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Jh(int i3) {
        String valueOf;
        if (i3 == 0) {
            return "";
        }
        int i16 = i3 >> 16;
        int i17 = (i3 & 65280) >>> 8;
        Calendar calendar = Calendar.getInstance();
        int i18 = calendar.get(1) - i16;
        if (calendar.get(2) + 1 < i17) {
            i18--;
        }
        if (i18 <= 0) {
            valueOf = "\u534a";
        } else {
            valueOf = String.valueOf(i18);
        }
        return valueOf + HardCodeUtil.qqStr(R.string.htz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi() {
        boolean f16 = StudyModeManager.f(16);
        boolean f17 = StudyModeManager.f(32);
        boolean f18 = StudyModeManager.f(8);
        boolean f19 = StudyModeManager.f(128);
        boolean f26 = StudyModeManager.f(80);
        ai(16, f16);
        ai(32, f17);
        ai(8, f18);
        ai(128, f19);
        ai(80, f26);
        ai(4, StudyModeManager.j() == 1 && StudyModeManager.g() == 0);
        Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    public void Nh(int i3, boolean z16) {
        FormSwitchItem formSwitchItem;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (i3 == 8) {
            formSwitchItem = this.F;
            onCheckedChangeListener = this.U;
        } else if (i3 == 16) {
            formSwitchItem = this.D;
            onCheckedChangeListener = this.S;
        } else if (i3 == 32) {
            formSwitchItem = this.E;
            onCheckedChangeListener = this.T;
        } else if (i3 == 80) {
            formSwitchItem = this.H;
            onCheckedChangeListener = this.W;
        } else if (i3 != 128) {
            formSwitchItem = null;
            onCheckedChangeListener = null;
        } else {
            formSwitchItem = this.G;
            onCheckedChangeListener = this.V;
        }
        if (formSwitchItem == null || onCheckedChangeListener == null) {
            return;
        }
        ?? r85 = z16;
        if (!NetworkUtil.isNetSupport(getBaseActivity())) {
            QLog.d("IphoneTitleBarFragment", 1, "network error");
            Hh(formSwitchItem, !z16, onCheckedChangeListener);
            QQToast.makeText(getBaseActivity(), 1, R.string.mqb, 0).show();
        } else {
            if (i3 == 128) {
                r85 = !z16;
            } else if (i3 == 80) {
                r85 = z16 ? 1 : 2;
            }
            KidModeServlet.w(getBaseActivity().app, i3, r85);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class h extends KidModeObserver {
        h() {
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void d(boolean z16, Bundle bundle) {
            QLog.i("KidModeObserver", 1, "onSendGetKidModeStatusSuccess    banNetSearch:" + bundle.getInt("KID_MODE_NET_SEARCH", -99));
            KidModeAdvanceSettingFragment.this.bi();
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void e(boolean z16, Bundle bundle) {
            String string = bundle.getString("phone");
            StudyModeManager.K(StringUtil.isEmpty(string) ? 1 : 0, string, bundle.getString("mibao_set_url"));
            KidModeAdvanceSettingFragment.this.L = StringUtil.isEmpty(string);
            KidModeAdvanceSettingFragment.this.Ih(4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        
            if (r10 == 0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
        
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
        
            if (r10 == 1) goto L25;
         */
        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void h(boolean z16, int i3, int i16) {
            if (i3 != 4) {
                if (i3 != 8 && i3 != 16 && i3 != 32) {
                    if (i3 == 64) {
                        if (!z16) {
                            KidModeAdvanceSettingFragment.this.P = 0;
                            com.tencent.mobileqq.studymode.f.a(KidModeAdvanceSettingFragment.this.getBaseActivity(), HardCodeUtil.qqStr(R.string.huv), 1);
                            return;
                        } else {
                            StudyModeManager.V(KidModeAdvanceSettingFragment.this.P);
                            return;
                        }
                    }
                    if (i3 != 80 && i3 != 128) {
                        return;
                    }
                }
                KidModeAdvanceSettingFragment.this.ai(i3, StudyModeManager.f(i3));
                if (z16) {
                    return;
                }
                boolean z17 = i16 != 0;
                if (i3 != 128) {
                    if (i3 == 80) {
                    }
                }
                KidModeAdvanceSettingFragment.this.ai(i3, !z17);
                QQToast.makeText(KidModeAdvanceSettingFragment.this.getBaseActivity(), 1, R.string.huv, 0).show();
                return;
            }
            if (z16) {
                StudyModeManager.L(KidModeAdvanceSettingFragment.this.I.isChecked() ? 1 : 0);
            } else {
                KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
                kidModeAdvanceSettingFragment.Hh(kidModeAdvanceSettingFragment.I, !KidModeAdvanceSettingFragment.this.I.isChecked(), KidModeAdvanceSettingFragment.this.R);
                com.tencent.mobileqq.studymode.f.a(KidModeAdvanceSettingFragment.this.getBaseActivity(), HardCodeUtil.qqStr(R.string.huv), 1);
            }
            KidModeAdvanceSettingFragment.this.I.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class m implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.e f247142d;

        m(com.tencent.mobileqq.widget.selectorview.e eVar) {
            this.f247142d = eVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            KidModeAdvanceSettingFragment.this.P = this.f247142d.z();
            KidModeAdvanceSettingFragment kidModeAdvanceSettingFragment = KidModeAdvanceSettingFragment.this;
            kidModeAdvanceSettingFragment.Qh(kidModeAdvanceSettingFragment.Jh(kidModeAdvanceSettingFragment.P));
            KidModeAdvanceSettingFragment.this.Oh();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class l implements DialogInterface.OnClickListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
