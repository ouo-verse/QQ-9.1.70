package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.g;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopNickRuleFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    public static String Q;
    public static String R;
    public static String S;
    public static String T;
    public static String U;
    public static String V;
    public static String W;
    public static int X;
    public static int Y;
    public static int Z;
    protected PresetWordFlowLayout C;
    protected com.tencent.mobileqq.troop.activity.g D;
    protected ArrayList<String> E;
    protected QQAppInterface F;
    protected BaseActivity G;
    protected EditText H;
    protected TextView I;
    private String J;
    private String K;
    private View L;
    private EditText M;
    private boolean N;
    private View.OnTouchListener P;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            TroopNickRuleFragment.this.zh(motionEvent.getX(), motionEvent.getY());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements g.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.activity.g.a
        public void a(View view, int i3, g.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), bVar);
            } else if (view.getTag() == TroopNickRuleFragment.U) {
                TroopNickRuleFragment.this.uh(i3);
            } else if (view.getTag() == TroopNickRuleFragment.V) {
                TroopNickRuleFragment.this.vh(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (view == TroopNickRuleFragment.this.H) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (action == 1 || action == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements TextWatcher {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (TroopNickRuleFragment.this.I == null) {
                return;
            }
            int length = charSequence.length();
            String str = (TroopNickRuleFragment.Z - length) + "/" + TroopNickRuleFragment.Z + "\u5b57";
            if (length >= TroopNickRuleFragment.Z) {
                TroopNickRuleFragment troopNickRuleFragment = TroopNickRuleFragment.this;
                troopNickRuleFragment.I.setTextColor(troopNickRuleFragment.getResources().getColor(R.color.f157924ab3));
            } else {
                TroopNickRuleFragment.this.I.setTextColor(com.tencent.mobileqq.util.n.a("#878B99"));
            }
            TroopNickRuleFragment.this.I.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopNickRuleFragment.this.Bh();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements InputFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Pattern f293687d;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            } else {
                this.f293687d = Pattern.compile("[\u1f000-\u1f3ff]|[\u1f400-\u1f7ff]|[\u2600-\u27ff]", 66);
            }
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), spanned, Integer.valueOf(i17), Integer.valueOf(i18));
            }
            if (this.f293687d.matcher(charSequence).find()) {
                return "";
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class g implements TextWatcher {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            g.b bVar;
            CharSequence text;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (!TextUtils.isEmpty(TroopNickRuleFragment.this.M.getText().toString())) {
                TroopNickRuleFragment.this.M.setHint("");
                z16 = false;
            } else {
                TroopNickRuleFragment.this.M.setHint(R.string.f235517bv);
            }
            if (TroopNickRuleFragment.this.C.getChildCount() > 0 && TroopNickRuleFragment.this.N && (bVar = (g.b) TroopNickRuleFragment.this.C.getChildAt(0).getTag()) != null) {
                TextView textView = bVar.f293740e;
                if (z16) {
                    text = TroopNickRuleFragment.this.getString(R.string.f235517bv);
                } else {
                    text = TroopNickRuleFragment.this.M.getText();
                }
                textView.setText(text);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class h implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else if (i3 == 6 || i3 == 2) {
                TroopNickRuleFragment.this.zh(-1.0f, -1.0f);
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class i implements com.tencent.qqnt.troop.e {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNickRuleFragment.this);
            }
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopNickRuleFragment.this.Ah(z16, i3, str);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76179);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        Q = "PARAM_UIN";
        R = "PARAM_INTRO";
        S = "PARAM_PRESET_WORDS";
        T = "";
        U = "close";
        V = "add";
        W = "none";
        X = 15;
        Y = 10;
        Z = 600;
    }

    public TroopNickRuleFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = new ArrayList<>();
        this.J = "";
        this.K = "";
        this.L = null;
        this.M = null;
        this.N = false;
        this.P = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(boolean z16, long j3, String str) {
        int i3;
        String str2;
        if (z16) {
            QLog.i("TroopNickRuleFragment", 1, "[onModifyTroopNickRule] susccess");
            Ch();
            return;
        }
        QLog.e("TroopNickRuleFragment", 1, "[onModifyTroopNickRule] failed, errCode:" + j3 + ", errInfo:" + str);
        BaseActivity baseActivity = this.G;
        if (j3 == 1298) {
            i3 = R.string.f235547by;
        } else {
            i3 = R.string.f235537bx;
        }
        QQToast.makeText(baseActivity, i3, 0).show();
        if (j3 == 1298) {
            str2 = "3";
        } else {
            str2 = "1";
        }
        ReportController.o(this.F, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, String.valueOf(this.J), str2, "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh() {
        if (!NetworkUtil.isNetSupport(this.G)) {
            ReportController.o(this.F, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, String.valueOf(this.J), "1", "", "");
            QQToast.makeText(this.G, 1, R.string.f171139ci4, 0).show();
        } else {
            this.K = this.H.getText().toString();
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopNickRule(this.J, this.K, this.E, this, new i());
        }
    }

    private void Dh() {
        this.D.b();
        int i3 = 0;
        if (this.E.size() < X) {
            this.D.a(getString(R.string.f235517bv));
            this.D.f293735e = true;
        } else {
            this.D.f293735e = false;
        }
        Iterator<String> it = this.E.iterator();
        while (it.hasNext()) {
            this.D.a(it.next());
        }
        PresetWordFlowLayout presetWordFlowLayout = this.C;
        if (this.D.getCount() == 0) {
            i3 = 8;
        }
        presetWordFlowLayout.setVisibility(i3);
        this.D.notifyDataSetChanged();
    }

    private void Eh(boolean z16) {
        int i3;
        int i16;
        int i17;
        EditText editText = this.H;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ViewCompat.setImportantForAccessibility(editText, i3);
        for (int i18 = 0; i18 < this.C.getChildCount(); i18++) {
            g.b bVar = (g.b) this.C.getChildAt(i18).getTag();
            if (bVar != null) {
                TextView textView = bVar.f293741f;
                if (textView != null) {
                    if (z16) {
                        i17 = 1;
                    } else {
                        i17 = 2;
                    }
                    ViewCompat.setImportantForAccessibility(textView, i17);
                }
                TextView textView2 = bVar.f293740e;
                if (textView2 != null) {
                    if (z16) {
                        i16 = 1;
                    } else {
                        i16 = 2;
                    }
                    ViewCompat.setImportantForAccessibility(textView2, i16);
                }
            }
        }
    }

    private void initData() {
        String str;
        String str2;
        Intent intent = this.G.getIntent();
        if (intent != null) {
            String str3 = "";
            if (intent.getStringExtra(Q) == null) {
                str = "";
            } else {
                str = intent.getStringExtra(Q);
            }
            this.J = str;
            if (intent.getStringExtra(R) == null) {
                str2 = "";
            } else {
                str2 = intent.getStringExtra(R);
            }
            this.K = str2;
            if (!TextUtils.isEmpty(str2)) {
                this.H.setText(this.K);
            }
            EditText editText = this.H;
            editText.setSelection(editText.getText().length());
            this.H.requestFocus();
            if (intent.getStringArrayListExtra(S) != null) {
                this.E = intent.getStringArrayListExtra(S);
            }
            if (intent.getStringExtra(T) != null) {
                str3 = intent.getStringExtra(T);
            }
            ReportController.o(this.F, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_exp", 0, 0, String.valueOf(this.J), str3, "", "");
        }
        Dh();
    }

    private void initView() {
        setTitle(getString(R.string.f235587c2));
        PresetWordFlowLayout presetWordFlowLayout = (PresetWordFlowLayout) getBaseActivity().findViewById(R.id.f103005zf);
        this.C = presetWordFlowLayout;
        presetWordFlowLayout.f302362h = ViewUtils.dpToPx(12.0f);
        this.C.f302364m = ViewUtils.dpToPx(12.0f);
        this.D = new com.tencent.mobileqq.troop.activity.g();
        if (QQTheme.isNowThemeIsNight()) {
            this.D.e();
        }
        this.D.f293738i = new b();
        this.C.setAdapter(this.D);
        this.I = (TextView) this.G.findViewById(R.id.f102975zc);
        EditText editText = (EditText) this.G.findViewById(R.id.f102965zb);
        this.H = editText;
        editText.setOnTouchListener(new c());
        this.H.addTextChangedListener(new d());
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(getString(R.string.f235567c0));
        this.rightViewText.setOnClickListener(new e());
        ViewCompat.setImportantForAccessibility(((IphoneTitleBarFragment) this).mContentView, 2);
    }

    private void xh(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) getBaseActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopNickRuleFragment", 2, String.format("hideInputMethod()", new Object[0]));
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    void Ch() {
        boolean z16;
        String str;
        TroopInfo k3;
        boolean isEmpty = TextUtils.isEmpty(this.K);
        ArrayList<String> arrayList = this.E;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isEmpty) {
            if (z16) {
                str = "4";
            } else {
                str = "2";
            }
        } else if (z16) {
            str = "1";
        } else {
            str = "3";
        }
        ReportController.o(this.F, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_success", 0, 0, String.valueOf(this.J), str, "", "");
        TroopManager troopManager = (TroopManager) this.F.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(this.J)) != null) {
            k3.groupCardPrefix = this.E;
            k3.groupCardPrefixIntro = this.K;
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra(S, this.E);
        intent.putExtra(R, this.K);
        intent.putExtra(Q, this.J);
        this.G.setResult(-1, intent);
        this.G.finish();
    }

    void Fh(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.G.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (QLog.isColorLevel()) {
            QLog.i("TroopNickRuleFragment", 2, String.format("showInputMethod()", new Object[0]));
        }
        inputMethodManager.showSoftInput(editText, 2);
    }

    void Gh(View view) {
        if (this.L != null) {
            RectF wh5 = wh(view);
            View findViewById = this.L.findViewById(R.id.f100905tr);
            if (findViewById != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(findViewById.getLayoutParams());
                layoutParams.topMargin = (int) wh5.top;
                layoutParams.leftMargin = (int) wh5.left;
                findViewById.setLayoutParams(layoutParams);
                this.L.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.fvi;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        removeMaskView();
        xh(this.H);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        BaseActivity baseActivity = getBaseActivity();
        this.G = baseActivity;
        this.F = baseActivity.app;
        initView();
        initData();
    }

    void removeMaskView() {
        View view = this.L;
        if (view != null) {
            if (view.getParent() != null && (this.L.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.L.getParent()).removeView(this.L);
            }
            this.L.setOnTouchListener(null);
        }
    }

    void uh(int i3) {
        if (this.D.d()) {
            i3--;
        }
        if (i3 >= 0 && this.E.size() > i3) {
            this.E.remove(i3);
            Dh();
        }
    }

    void vh(g.b bVar) {
        TextView textView;
        if (bVar != null && (textView = bVar.f293740e) != null && textView.getParent() != null) {
            if (this.L == null) {
                this.L = LayoutInflater.from(this.G).inflate(R.layout.fvj, (ViewGroup) null, false);
                yh();
            }
            View decorView = this.G.getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                if (this.L.getParent() != null) {
                    ((ViewGroup) this.L.getParent()).removeView(this.L);
                }
                ((ViewGroup) decorView).addView(this.L);
                this.L.setOnTouchListener(this.P);
            }
            Gh((View) bVar.f293740e.getParent());
            EditText editText = this.M;
            if (editText != null) {
                editText.setHint(R.string.f235517bv);
                this.M.requestFocus();
                Fh(this.M);
            }
            this.N = true;
            Eh(false);
        }
    }

    RectF wh(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.G);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            statusBarHeight = 0;
        }
        if (statusBarHeight > 0) {
            iArr[1] = iArr[1] - statusBarHeight;
        }
        RectF rectF = new RectF();
        float f16 = iArr[0];
        rectF.left = f16;
        rectF.top = iArr[1];
        rectF.right = f16 + view.getMeasuredWidth();
        rectF.bottom = rectF.top + view.getMeasuredHeight();
        return rectF;
    }

    void yh() {
        View view = this.L;
        if (view != null) {
            View findViewById = view.findViewById(R.id.f100905tr);
            this.M = (EditText) this.L.findViewById(R.id.f26970ez);
            this.M.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Y), new f()});
            this.M.addTextChangedListener(new g());
            if (ThemeUtil.isInNightMode(this.F)) {
                this.M.setTextColor(-1);
                findViewById.setBackgroundDrawable(getResources().getDrawable(R.drawable.kzp));
            }
            this.M.setOnEditorActionListener(new h());
        }
    }

    void zh(float f16, float f17) {
        this.N = false;
        EditText editText = this.M;
        if (editText != null) {
            if (wh(editText).contains(f16, f17)) {
                return;
            }
            xh(this.M);
            String obj = this.M.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                this.E.add(0, obj);
                Dh();
            }
            this.M.setText("");
        }
        removeMaskView();
        Eh(true);
    }
}
