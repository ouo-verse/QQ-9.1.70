package com.tencent.biz.pubaccount.weishi.comment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi.event.WSCommentSuccessEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.q;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class WsCommentInputPopupWindow extends com.tencent.biz.subscribe.comment.p implements View.OnClickListener, DialogInterface.OnDismissListener, wz.c, com.tencent.biz.pubaccount.weishi.comment.e {
    private SharedPreferences D;
    private SharedPreferences.Editor E;
    private final Activity F;
    private final BaseFragment G;
    private final View H;
    private LinearLayout I;
    private ImageButton J;
    private EditText K;
    private CommentEditText L;
    private KandianUrlImageView M;
    private ImageButton N;
    private View P;
    private q.a Q;
    private com.tencent.biz.subscribe.comment.q R;
    private com.tencent.biz.pubaccount.weishi.comment.b S;
    private com.tencent.biz.subscribe.comment.b T;
    private InputMethodManager U;
    private g V;
    private Handler W;
    private WSCommentInputPresenter X;
    private m Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f80495a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f80496b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements CommentEditText.b {
        a() {
        }

        @Override // com.tencent.biz.subscribe.comment.CommentEditText.b
        public void a(View view) {
            if (!WsCommentInputPopupWindow.this.isShowing() || WsCommentInputPopupWindow.this.F.isFinishing()) {
                return;
            }
            WsCommentInputPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WsCommentInputPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements q.a {
        c() {
        }

        @Override // com.tencent.biz.subscribe.comment.q.a
        public void onSoftKeyboardClosed() {
            x.b("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][onSoftKeyboardClosed]");
            if (WsCommentInputPopupWindow.this.q0().i()) {
                WsCommentInputPopupWindow.this.q0().j();
            } else {
                WsCommentInputPopupWindow.this.dismiss();
            }
            WsCommentInputPopupWindow.this.Z = false;
        }

        @Override // com.tencent.biz.subscribe.comment.q.a
        public void onSoftKeyboardOpened(int i3) {
            x.b("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][onSoftKeyboardOpened]");
            if (WsCommentInputPopupWindow.this.f80496b0 != i3) {
                WsCommentInputPopupWindow.this.f80496b0 = i3;
                WsCommentInputPopupWindow.this.A0();
                WsCommentInputPopupWindow.this.E.putInt("GroupSoftKeyboardHeight", i3);
                WsCommentInputPopupWindow.this.E.commit();
            }
            WsCommentInputPopupWindow.this.Z = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f extends j {
        f(CommentEditText commentEditText) {
            super(commentEditText);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WsCommentInputPopupWindow.this.q0().k();
            super.afterTextChanged(editable);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.j
        List<WSCommentFriendBaseInfo> b() {
            return WsCommentInputPopupWindow.this.X.f();
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.j
        int c() {
            return WsCommentInputPopupWindow.this.X.d();
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.j
        void e() {
            if (o10.a.f421718a.h()) {
                WsCommentInputPopupWindow.this.z0();
            }
        }
    }

    /* loaded from: classes32.dex */
    public interface g {
        void a(String str);

        void onShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        q0().l(this.f80496b0);
        x.a("WsCommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.f80496b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(boolean z16) {
        if (this.Z) {
            k.h(this.P);
        }
        q0().j();
        if (z16) {
            this.L.clearFocus();
        }
        s0(this.L);
        if (this.K == null) {
            EditText editText = new EditText(this.I.getContext());
            this.K = editText;
            editText.setBackgroundColor(0);
        }
        if (this.K.getParent() == null) {
            this.I.addView(this.K, 0, new LinearLayout.LayoutParams(1, 1));
        }
    }

    private void L0() {
        o10.a aVar = o10.a.f421718a;
        if (aVar.h()) {
            this.M.setVisibility(0);
            WSPicLoader.g().w(this.M, aVar.f(), r.i(R.drawable.ocj));
            return;
        }
        this.M.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(boolean z16) {
        this.f80495a0 = z16;
        this.J.setImageResource(z16 ? R.drawable.ocv : R.drawable.weishi_ic_emoji);
    }

    private void initView() {
        this.I = (LinearLayout) this.H.findViewById(R.id.bak);
        this.J = (ImageButton) this.H.findViewById(R.id.ah5);
        CommentEditText commentEditText = (CommentEditText) this.H.findViewById(R.id.jha);
        this.L = commentEditText;
        commentEditText.setOnInputBackListener(new a());
        KandianUrlImageView kandianUrlImageView = (KandianUrlImageView) this.H.findViewById(R.id.tcu);
        this.M = kandianUrlImageView;
        kandianUrlImageView.setOnClickListener(this);
        L0();
        this.N = (ImageButton) this.H.findViewById(R.id.aiz);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
        this.D = sharedPreferences;
        this.E = sharedPreferences.edit();
        this.f80496b0 = this.D.getInt("GroupSoftKeyboardHeight", BaseAIOUtils.f(250.0f, getContext().getResources()));
        x.a("WsCommentInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.f80496b0);
        if (this.f80496b0 == 0) {
            this.f80496b0 = ScreenUtil.dip2px(250.0f);
            x.a("WsCommentInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.f80496b0);
        }
        q0().h(m0(), (ViewGroup) this.H.findViewById(R.id.ezu), this.L, this.f80496b0);
        View findViewById = this.H.findViewById(R.id.aav);
        this.P = findViewById;
        findViewById.setOnClickListener(new b());
        this.U = (InputMethodManager) this.F.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        A0();
    }

    private void k0() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.setSoftInputMode(16);
    }

    private BaseActivity m0() {
        Activity activity = this.F;
        if (activity instanceof SplashActivity) {
            return (SplashActivity) activity;
        }
        if (activity instanceof PublicFragmentActivity) {
            return (PublicFragmentActivity) activity;
        }
        return null;
    }

    private Handler o0() {
        if (this.W == null) {
            this.W = new Handler(Looper.getMainLooper());
        }
        return this.W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.biz.pubaccount.weishi.comment.b q0() {
        if (this.S == null) {
            this.S = new com.tencent.biz.pubaccount.weishi.comment.b();
        }
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(boolean z16) {
        q0().g();
        k.k(this.P);
        if (z16) {
            K0(this.L);
        } else {
            s0(this.L);
        }
    }

    private void u0() {
        wz.b.b().d(this);
        this.J.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.N.setOnClickListener(this);
        w0();
    }

    private void w0() {
        this.L.setImeOptions(268435456);
        this.L.setOnFocusChangeListener(new d());
        this.L.setOnEditorActionListener(new e());
        CommentEditText commentEditText = this.L;
        commentEditText.addTextChangedListener(new f(commentEditText));
    }

    private void x0() {
        this.R = new com.tencent.biz.subscribe.comment.q(this.H);
        c cVar = new c();
        this.Q = cVar;
        this.R.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (this.L == null) {
            return;
        }
        z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        com.tencent.biz.subscribe.comment.q qVar = this.R;
        if (qVar == null) {
            return;
        }
        qVar.e(this.Q);
        x.b("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][onAtClick] \u547c\u8d77\u597d\u53cb\u9009\u62e9\u5668");
        this.X.j(this.G, 1056, this.L.getText().toString());
    }

    public void B0() {
        wz.b.b().f(this);
        o0().removeCallbacksAndMessages(null);
    }

    public void C0() {
        o0().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow.3
            @Override // java.lang.Runnable
            public void run() {
                WsCommentInputPopupWindow.this.y0();
            }
        });
    }

    public void D0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.L.setHint(str);
    }

    public void E0(com.tencent.biz.subscribe.comment.b bVar) {
        this.T = bVar;
    }

    public void F0(g gVar) {
        this.V = gVar;
    }

    public void H0(String str) {
        CommentEditText commentEditText = this.L;
        if (commentEditText == null) {
            return;
        }
        commentEditText.setText(str);
        this.L.setSelection(!TextUtils.isEmpty(this.L.getText()) ? str.length() : 0);
    }

    public void I0(int i3) {
        show();
        x0();
        if (i3 > 0) {
            o0().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow.10
                @Override // java.lang.Runnable
                public void run() {
                    WsCommentInputPopupWindow.this.J0(true);
                    WsCommentInputPopupWindow.this.M0(true);
                }
            });
        } else {
            o0().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow.11
                @Override // java.lang.Runnable
                public void run() {
                    WsCommentInputPopupWindow.this.M0(false);
                    WsCommentInputPopupWindow.this.r0(true);
                    WsCommentInputPopupWindow.this.L.requestFocus();
                }
            });
        }
        g gVar = this.V;
        if (gVar != null) {
            gVar.onShow();
        }
    }

    public void K0(final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow.9
            @Override // java.lang.Runnable
            public void run() {
                WsCommentInputPopupWindow.this.U.showSoftInput(view, 1);
            }
        });
    }

    @Override // com.tencent.biz.subscribe.comment.a
    public void N() {
        super.N();
        k.j(getWindow());
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof WSActivityResultEvent) {
            x.b("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][onReceiveEvent] event:" + wSSimpleBaseEvent);
            if (((WSActivityResultEvent) wSSimpleBaseEvent).getRequestCode() == 1056) {
                o0().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.comment.WsCommentInputPopupWindow.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WsCommentInputPopupWindow.this.R == null) {
                            return;
                        }
                        WsCommentInputPopupWindow.this.R.a(WsCommentInputPopupWindow.this.Q);
                        WsCommentInputPopupWindow.this.r0(true);
                        WsCommentInputPopupWindow.this.L.requestFocus();
                        WsCommentInputPopupWindow.this.M0(false);
                    }
                }, 200L);
                this.X.k(wSSimpleBaseEvent);
                return;
            }
            return;
        }
        if (wSSimpleBaseEvent instanceof WSCommentSuccessEvent) {
            this.X.k(wSSimpleBaseEvent);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        s0(this.L);
        r0(false);
        super.dismiss();
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WSActivityResultEvent.class);
        arrayList.add(WSCommentSuccessEvent.class);
        return arrayList;
    }

    public ArrayList<String> l0() {
        return this.X.e();
    }

    public String n0() {
        QQTextBuilder qQTextBuilder;
        String obj;
        CommentEditText commentEditText = this.L;
        String str = "";
        if (commentEditText == null) {
            return "";
        }
        if (commentEditText.getText() instanceof com.tencent.mobileqq.text.o) {
            com.tencent.mobileqq.text.o oVar = (com.tencent.mobileqq.text.o) this.L.getText();
            if (oVar != null) {
                str = oVar.toPlainText();
            }
        } else if ((this.L.getText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) this.L.getText()) != null) {
            str = k.i(qQTextBuilder);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI, str)) {
            obj = QzoneEmotionUtils.splash2Emo(str);
        } else {
            obj = this.L.getText().toString();
        }
        x.j("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][getText] text:" + obj);
        return obj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x.a("WsCommentInputPopupWindow", 1, "onClick:" + view.getId());
        switch (view.getId()) {
            case R.id.tcu /* 2131364462 */:
                y0();
                com.tencent.biz.pubaccount.weishi.report.b.q(this.Y.e(), this.Y.getPlayScene(), this.Y.h(), this.Y.g());
                return;
            case R.id.ah5 /* 2131364567 */:
                x.a("WsCommentInputPopupWindow", 1, "btn_emotion");
                if (this.f80495a0) {
                    r0(true);
                    M0(false);
                    return;
                } else {
                    J0(false);
                    M0(true);
                    return;
                }
            case R.id.aiz /* 2131364667 */:
                com.tencent.biz.subscribe.comment.b bVar = this.T;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            case R.id.jha /* 2131389241 */:
                x.a("WsCommentInputPopupWindow", 1, "text_input");
                r0(true);
                M0(false);
                return;
            default:
                return;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.tencent.biz.subscribe.comment.q qVar = this.R;
        if (qVar != null) {
            qVar.d();
        }
        this.R = null;
        M0(true);
        this.Z = false;
        r0(false);
        g gVar = this.V;
        if (gVar != null) {
            gVar.a(n0());
        }
        EditText editText = this.K;
        if (editText == null || editText.getParent() == null) {
            return;
        }
        this.I.removeView(this.K);
        this.K = null;
        this.L.clearFocus();
    }

    public String p0() {
        return this.X.l(n0());
    }

    @Override // com.tencent.biz.pubaccount.weishi.comment.e
    public void y(SpannableStringBuilder spannableStringBuilder) {
        int selectionStart = this.L.getSelectionStart();
        if (selectionStart >= 1) {
            int i3 = selectionStart - 1;
            if (this.L.getText().charAt(i3) == '@') {
                this.L.getText().delete(i3, selectionStart);
                selectionStart = i3;
            }
        }
        this.L.getText().insert(selectionStart, spannableStringBuilder);
        this.L.setSelection(selectionStart + spannableStringBuilder.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (!z16) {
                WsCommentInputPopupWindow.this.M0(true);
                WsCommentInputPopupWindow.this.s0(view);
            } else {
                WsCommentInputPopupWindow wsCommentInputPopupWindow = WsCommentInputPopupWindow.this;
                wsCommentInputPopupWindow.onClick(wsCommentInputPopupWindow.L);
            }
        }
    }

    public void s0(View view) {
        if (view != null) {
            this.U.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public WsCommentInputPopupWindow(Activity activity, BaseFragment baseFragment, m mVar) {
        super(activity, R.style.air);
        this.Z = false;
        this.Y = mVar;
        this.F = activity;
        this.G = baseFragment;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fvq, (ViewGroup) null);
        this.H = inflate;
        this.X = new WSCommentInputPresenter(this);
        k0();
        setCancelable(true);
        setContentView(inflate);
        initView();
        u0();
        setOnDismissListener(this);
        N();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements TextView.OnEditorActionListener {
        e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (i3 != 4 && i3 != 6) {
                return false;
            }
            if (WsCommentInputPopupWindow.this.T == null) {
                return true;
            }
            WsCommentInputPopupWindow.this.T.a();
            return true;
        }
    }
}
