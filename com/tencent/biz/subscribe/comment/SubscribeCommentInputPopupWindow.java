package com.tencent.biz.subscribe.comment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.q;
import com.tencent.biz.subscribe.widget.textview.RichTextParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import mqq.app.AppRuntime;

/* loaded from: classes5.dex */
public class SubscribeCommentInputPopupWindow extends p implements View.OnClickListener, DialogInterface.OnDismissListener {
    protected View D;
    private SharedPreferences E;
    private SharedPreferences.Editor F;
    private Activity G;
    private ImageButton H;
    protected CommentEditText I;
    private ImageButton J;
    private Button K;
    private int L;
    private IEmoticonMainPanel M;
    private SystemAndEmojiEmoticonPanel N;
    private InputMethodManager P;
    private boolean Q;
    private int R;
    private boolean S;
    private int T;
    private g U;
    private h V;
    private View W;
    private q X;
    private Handler Y;
    private AlphaAnimation Z;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f95955a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f95956b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SubscribeCommentInputPopupWindow.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements EmoticonCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (SubscribeCommentInputPopupWindow.this.I.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = SubscribeCommentInputPopupWindow.this.I.getText();
                int selectionStart = SubscribeCommentInputPopupWindow.this.I.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(SubscribeCommentInputPopupWindow.this.I.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = SubscribeCommentInputPopupWindow.this.I.getSelectionStart();
                int selectionEnd = SubscribeCommentInputPopupWindow.this.I.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                SubscribeCommentInputPopupWindow.this.I.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = SubscribeCommentInputPopupWindow.this.I.getSelectionStart();
                int selectionEnd2 = SubscribeCommentInputPopupWindow.this.I.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    SubscribeCommentInputPopupWindow.this.I.getEditableText().replace(selectionStart2, selectionEnd2, i3 == 1 ? com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16) : com.tencent.mobileqq.text.TextUtils.getEmojiString(i16));
                    SubscribeCommentInputPopupWindow.this.I.requestFocus();
                }
                if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
                    systemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), (Parcelable) null);
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements q.a {
        d() {
        }

        @Override // com.tencent.biz.subscribe.comment.q.a
        public void onSoftKeyboardClosed() {
            QLog.d("SubscribeCommentInputPopupWindow", 1, "onSoftKeyboardClosed");
            if (SubscribeCommentInputPopupWindow.this.f95956b0) {
                SubscribeCommentInputPopupWindow.this.f95956b0 = false;
                if (SubscribeCommentInputPopupWindow.this.M != null) {
                    SubscribeCommentInputPopupWindow.this.M.getView().setVisibility(0);
                }
                if (SubscribeCommentInputPopupWindow.this.N != null) {
                    SubscribeCommentInputPopupWindow.this.N.setVisibility(0);
                }
            } else {
                SubscribeCommentInputPopupWindow.this.dismiss();
            }
            SubscribeCommentInputPopupWindow.this.S = false;
        }

        @Override // com.tencent.biz.subscribe.comment.q.a
        public void onSoftKeyboardOpened(int i3) {
            QLog.d("SubscribeCommentInputPopupWindow", 1, "onSoftKeyboardOpened");
            if (SubscribeCommentInputPopupWindow.this.L != i3) {
                SubscribeCommentInputPopupWindow.this.L = i3;
                SubscribeCommentInputPopupWindow.this.s0();
                SubscribeCommentInputPopupWindow.this.F.putInt("GroupSoftKeyboardHeight", i3);
                SubscribeCommentInputPopupWindow.this.F.commit();
            }
            SubscribeCommentInputPopupWindow.this.u0();
            SubscribeCommentInputPopupWindow.this.S = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements TextView.OnEditorActionListener {
        e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16;
            if (i3 != 4 && i3 != 6) {
                z16 = false;
            } else {
                if (SubscribeCommentInputPopupWindow.this.U != null) {
                    SubscribeCommentInputPopupWindow.this.U.a();
                }
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface h {
        void onDismiss();
    }

    public SubscribeCommentInputPopupWindow(Activity activity) {
        super(activity, R.style.f173747jj);
        this.Q = false;
        this.R = -1;
        this.S = false;
        this.T = 0;
        this.f95956b0 = false;
        this.G = activity;
        this.D = LayoutInflater.from(getContext()).inflate(R.layout.f167694ej, (ViewGroup) null);
        i0();
        setCancelable(true);
        initView();
        setContentView(this.D);
        o0();
        setOnDismissListener(this);
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        if (this.S) {
            r0(this.W);
        }
        this.f95956b0 = true;
        IEmoticonMainPanel iEmoticonMainPanel = this.M;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.getView().setVisibility(0);
        }
        SystemAndEmojiEmoticonPanel systemAndEmojiEmoticonPanel = this.N;
        if (systemAndEmojiEmoticonPanel != null) {
            systemAndEmojiEmoticonPanel.setVisibility(0);
        }
        m0(this.I);
    }

    private void D0(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.weight = 1.0f;
        view.setLayoutParams(layoutParams);
    }

    private void initView() {
        this.f95955a0 = (LinearLayout) this.D.findViewById(R.id.b3r);
        this.H = (ImageButton) this.D.findViewById(R.id.ah5);
        CommentEditText commentEditText = (CommentEditText) this.D.findViewById(R.id.jha);
        this.I = commentEditText;
        commentEditText.setOnInputBackListener(new CommentEditText.b() { // from class: com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.1
            @Override // com.tencent.biz.subscribe.comment.CommentEditText.b
            public void a(View view) {
                if (SubscribeCommentInputPopupWindow.this.isShowing()) {
                    SubscribeCommentInputPopupWindow.this.G.runOnUiThread(new Runnable() { // from class: com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SubscribeCommentInputPopupWindow.this.dismiss();
                        }
                    });
                }
            }
        });
        this.I.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        this.J = (ImageButton) this.D.findViewById(R.id.f164666ai3);
        this.K = (Button) this.D.findViewById(R.id.aiz);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
        this.E = sharedPreferences;
        this.F = sharedPreferences.edit();
        this.L = this.E.getInt("GroupSoftKeyboardHeight", BaseAIOUtils.f(250.0f, getContext().getResources()));
        QLog.d("SubscribeCommentInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.L);
        if (this.L == 0) {
            this.L = ScreenUtil.dip2px(250.0f);
            QLog.d("SubscribeCommentInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.L);
        }
        n0();
        View findViewById = this.D.findViewById(R.id.aav);
        this.W = findViewById;
        findViewById.setOnClickListener(new a());
        this.P = (InputMethodManager) this.G.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.Q = true;
        s0();
        this.D.setVisibility(4);
    }

    private Handler j0() {
        if (this.Y == null) {
            this.Y = new Handler(Looper.getMainLooper());
        }
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(boolean z16) {
        IEmoticonMainPanel iEmoticonMainPanel = this.M;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.getView().setVisibility(8);
        }
        SystemAndEmojiEmoticonPanel systemAndEmojiEmoticonPanel = this.N;
        if (systemAndEmojiEmoticonPanel != null) {
            systemAndEmojiEmoticonPanel.setVisibility(8);
        }
        D0(this.W);
        if (z16) {
            C0(this.I);
        }
    }

    private void n0() {
        b bVar = new b();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            IEmoticonMainPanel iEmoticonMainPanel = (IEmoticonMainPanel) this.D.findViewById(R.id.bul);
            this.M = iEmoticonMainPanel;
            iEmoticonMainPanel.setCallBack(bVar);
            this.M.setOnlySysAndEmoji(true);
            this.M.init((BaseQQAppInterface) runtime, 100003, getContext(), dimensionPixelSize, (String) null, (IPanelInteractionListener) null, false);
            this.M.hideAllTabs();
            return;
        }
        QLog.e("SubscribeCommentInputPopupWindow", 1, "initEmojiPanel() runtime != QQAppInterface");
        if (this.G != null && this.f95955a0 != null) {
            SystemAndEmojiEmoticonPanel systemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this.G, bVar);
            this.N = systemAndEmojiEmoticonPanel;
            systemAndEmojiEmoticonPanel.setBackgroundColor(-1);
            this.f95955a0.addView(this.N);
        }
    }

    private void o0() {
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        p0();
    }

    private void p0() {
        this.I.setImeOptions(268435456);
        this.I.setOnEditorActionListener(new e());
        this.I.addTextChangedListener(new f());
    }

    private void q0() {
        q qVar = new q(this.D);
        this.X = qVar;
        qVar.a(new d());
        this.D.getViewTreeObserver();
    }

    private void r0(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = view.getHeight();
        layoutParams.weight = 0.0f;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        IEmoticonMainPanel iEmoticonMainPanel = this.M;
        if (iEmoticonMainPanel != null && iEmoticonMainPanel.getView().getLayoutParams() != null) {
            this.M.getView().getLayoutParams().height = this.L;
            this.M.getView().invalidate();
            QLog.d("SubscribeCommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.L);
        }
        SystemAndEmojiEmoticonPanel systemAndEmojiEmoticonPanel = this.N;
        if (systemAndEmojiEmoticonPanel != null && systemAndEmojiEmoticonPanel.getLayoutParams() != null) {
            this.N.getLayoutParams().height = this.L;
            this.N.invalidate();
            QLog.d("SubscribeCommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.L);
        }
    }

    public void A0(boolean z16) {
        show();
        q0();
        if (z16) {
            j0().post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.11
                @Override // java.lang.Runnable
                public void run() {
                    SubscribeCommentInputPopupWindow.this.B0();
                    SubscribeCommentInputPopupWindow.this.J.setVisibility(0);
                    SubscribeCommentInputPopupWindow.this.H.setVisibility(8);
                }
            });
        } else {
            j0().post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.12
                @Override // java.lang.Runnable
                public void run() {
                    SubscribeCommentInputPopupWindow.this.J.setVisibility(8);
                    SubscribeCommentInputPopupWindow.this.H.setVisibility(0);
                    SubscribeCommentInputPopupWindow.this.l0(true);
                    SubscribeCommentInputPopupWindow.this.I.requestFocus();
                }
            });
        }
    }

    public void C0(final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.9
            @Override // java.lang.Runnable
            public void run() {
                SubscribeCommentInputPopupWindow.this.P.showSoftInput(view, 1);
            }
        });
    }

    @Override // com.tencent.biz.subscribe.comment.a
    @TargetApi(19)
    public void N() {
        super.N();
        Window window = getWindow();
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        if (decorView instanceof ViewGroup) {
            View childAt = ((ViewGroup) decorView).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2 != null && childAt2.getId() != 16908290) {
                        if (!(childAt2 instanceof ViewStub)) {
                            childAt2.setAlpha(0.0f);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        m0(this.I);
        l0(false);
        super.dismiss();
    }

    protected void i0() {
        if (getWindow() != null && getWindow().getAttributes() != null) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setSoftInputMode(16);
        }
    }

    public String k0() {
        QQTextBuilder qQTextBuilder;
        CommentEditText commentEditText = this.I;
        String str = "";
        if (commentEditText == null) {
            return "";
        }
        if (commentEditText.getText() instanceof com.tencent.mobileqq.text.o) {
            com.tencent.mobileqq.text.o oVar = (com.tencent.mobileqq.text.o) this.I.getText();
            if (oVar != null) {
                str = oVar.toPlainText();
            }
        } else if ((this.I.getText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) this.I.getText()) != null) {
            str = qQTextBuilder.toPlainText();
        }
        return QzoneEmotionUtils.splash2Emo(str.replaceAll(HardCodeUtil.qqStr(R.string.f172111ng0), HardCodeUtil.qqStr(R.string.f172113ng2)).replaceAll(HardCodeUtil.qqStr(R.string.nfz), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2192465w), "/chigua")).trim();
    }

    public void m0(final View view) {
        view.post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.10
            @Override // java.lang.Runnable
            public void run() {
                SubscribeCommentInputPopupWindow.this.P.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("SubscribeCommentInputPopupWindow", 1, "onClick:" + view.getId());
        int id5 = view.getId();
        if (id5 == R.id.ah5) {
            QLog.d("SubscribeCommentInputPopupWindow", 1, "btn_emotion");
            B0();
            this.J.setVisibility(0);
            this.H.setVisibility(8);
        } else if (id5 == R.id.jha) {
            QLog.d("SubscribeCommentInputPopupWindow", 1, "text_input");
            l0(true);
            this.J.setVisibility(8);
            this.H.setVisibility(0);
        } else if (id5 == R.id.aiz) {
            g gVar = this.U;
            if (gVar != null) {
                gVar.a();
            }
        } else if (id5 == R.id.f164666ai3) {
            QLog.d("SubscribeCommentInputPopupWindow", 1, "btn_keyboard");
            l0(true);
            this.J.setVisibility(8);
            this.H.setVisibility(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        q qVar = this.X;
        if (qVar != null) {
            qVar.d();
            this.X = null;
        }
        this.H.setVisibility(8);
        this.J.setVisibility(0);
        this.S = false;
        h hVar = this.V;
        if (hVar != null) {
            hVar.onDismiss();
        }
    }

    protected void u0() {
        if (this.D != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.Z = alphaAnimation;
            alphaAnimation.setDuration(200L);
            this.Z.setAnimationListener(new c());
            this.D.setAnimation(this.Z);
            this.Z.start();
        }
    }

    public void w0(String str) {
        CommentEditText commentEditText = this.I;
        if (commentEditText != null) {
            commentEditText.setHint(str);
        }
    }

    public void x0(g gVar) {
        this.U = gVar;
    }

    public void y0(h hVar) {
        this.V = hVar;
    }

    public void z0(String str) {
        CommentEditText commentEditText = this.I;
        if (commentEditText == null) {
            return;
        }
        commentEditText.setText(str);
        this.I.setSelection(str.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = SubscribeCommentInputPopupWindow.this.D;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private int f95966d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f95967e = 0;

        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            RichTextParser.a aVar;
            if (editable == null) {
                return;
            }
            SubscribeCommentInputPopupWindow.this.I.removeTextChangedListener(this);
            String obj = editable.toString();
            int i3 = this.f95966d;
            String substring = obj.substring(i3, this.f95967e + i3);
            int indexOf = substring.indexOf(47);
            if (indexOf >= 0 && indexOf < substring.length() - 1) {
                aVar = new RichTextParser.a(editable.toString());
                RichTextParser.b bVar = new RichTextParser.b();
                bVar.f96587a = (int) ((BaseApplication.getContext().getResources().getDisplayMetrics().density * 22.0d) + 0.5d);
                bVar.f96588b = 0;
                bVar.f96589c = editable.toString();
                RichTextParser.b(bVar, substring, null, aVar, null, false);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                int selectionEnd = SubscribeCommentInputPopupWindow.this.I.getSelectionEnd();
                try {
                    SubscribeCommentInputPopupWindow.this.I.setText(aVar);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    SubscribeCommentInputPopupWindow.this.I.setText(editable.toString());
                    selectionEnd = editable.toString().length();
                }
                SubscribeCommentInputPopupWindow.this.I.setSelection(selectionEnd);
            }
            this.f95967e = 0;
            this.f95966d = 0;
            SubscribeCommentInputPopupWindow.this.I.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null) {
                return;
            }
            this.f95966d = i3;
            this.f95967e = i17;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
