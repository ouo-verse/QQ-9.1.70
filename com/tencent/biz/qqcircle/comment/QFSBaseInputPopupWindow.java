package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.tencent.biz.qcircleshadow.lib.QCircleHostTextBuilder;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class QFSBaseInputPopupWindow extends com.tencent.biz.qqcircle.widgets.comment.e implements View.OnClickListener, DialogInterface.OnDismissListener {
    public static int U;
    protected static final int V = cx.a(60.0f);
    protected View E;
    protected CommentEditText F;
    protected Button G;
    private InputMethodManager H;
    public boolean I;
    protected boolean J;
    protected b K;
    private c L;
    protected View M;
    protected com.tencent.biz.qqcircle.widgets.comment.f N;
    private Handler P;
    private AlphaAnimation Q;
    protected boolean R;
    protected final List<HostSelectMemberUtils.QCircleResultData> S;
    protected boolean T;

    /* loaded from: classes4.dex */
    class a extends sa0.a {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = QFSBaseInputPopupWindow.this.E;
            if (view != null) {
                view.setVisibility(0);
            }
            QFSBaseInputPopupWindow qFSBaseInputPopupWindow = QFSBaseInputPopupWindow.this;
            if (qFSBaseInputPopupWindow.T) {
                qFSBaseInputPopupWindow.r0(true);
                QFSBaseInputPopupWindow.this.T = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onDismiss();
    }

    public QFSBaseInputPopupWindow(Context context) {
        super(context, R.style.f173747jj);
        this.I = false;
        this.J = false;
        this.R = false;
        this.S = new ArrayList();
        this.E = LayoutInflater.from(context).inflate(d0(), (ViewGroup) null);
        a0();
        setCancelable(true);
        initView();
        setContentView(this.E);
        m0(this.E);
        l0();
        setOnDismissListener(this);
    }

    private String E0(boolean z16, boolean z17, boolean z18) {
        String obj;
        CommentEditText commentEditText = this.F;
        if (commentEditText == null) {
            return "";
        }
        if (z18) {
            obj = QCircleHostTextBuilder.toPlainText(commentEditText.getText(), z16);
        } else {
            obj = commentEditText.getText().toString();
        }
        if (z17) {
            return b0(obj);
        }
        return obj;
    }

    private QFSCommentAtEntity Z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        QFSCommentAtEntity qFSCommentAtEntity = new QFSCommentAtEntity(str, null, str2, 0);
        this.S.add(qFSCommentAtEntity);
        return qFSCommentAtEntity;
    }

    private String b0(String str) {
        String replace;
        if (str == null) {
            return "";
        }
        if (RFSafeListUtils.isEmpty(this.S)) {
            return str;
        }
        for (HostSelectMemberUtils.QCircleResultData qCircleResultData : this.S) {
            String str2 = qCircleResultData.name;
            if (TextUtils.isEmpty(str2)) {
                replace = qCircleResultData.uin + "";
            } else {
                replace = str2.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E");
            }
            String str3 = "@{uin:" + qCircleResultData.uin + ",nick:" + replace + "}";
            String str4 = "@" + qCircleResultData.name;
            if (!TextUtils.isEmpty(qCircleResultData.name) && str.contains(str4)) {
                str = w0(str4, str, str3);
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(String str) {
        CommentEditText commentEditText = this.F;
        if (commentEditText == null) {
            return;
        }
        commentEditText.setHint(p0(str));
    }

    private String p0(String str) {
        CommentEditText commentEditText;
        if (!TextUtils.isEmpty(str) && (commentEditText = this.F) != null) {
            if (commentEditText.getMeasuredWidth() == 0) {
                QLog.d("QFSBaseInputPopupWindow", 1, "mTextInput getMeasuredWidth is 0");
                return str;
            }
            TextPaint paint = this.F.getPaint();
            if (paint == null) {
                QLog.d("QFSBaseInputPopupWindow", 1, "mTextInput paint is null");
                return str;
            }
            float measureText = paint.measureText(str);
            float i06 = i0();
            if (this.G != null) {
                i06 += r5.getMeasuredWidth();
            }
            QLog.d("QFSBaseInputPopupWindow", 1, "limitTextWidthPx: " + i06);
            if (measureText < i06) {
                return str;
            }
            for (int length = str.length(); length > 0; length--) {
                String str2 = str.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                if (paint.measureText(str2) < i06) {
                    return str2;
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(boolean z16) {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = this.N;
        if (fVar == null) {
            return;
        }
        fVar.f(z16);
        this.N.g(z16);
    }

    public static String u0(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        sb5.replace(indexOf, str2.length() + indexOf, str3);
        return sb5.toString();
    }

    public static String w0(String str, String str2, String str3) {
        try {
            return Pattern.compile(str, 16).matcher(str2).replaceFirst(str3);
        } catch (Exception unused) {
            return u0(str2, str, str3);
        }
    }

    public void A0(boolean z16) {
        this.T = z16;
    }

    public void B0(c cVar) {
        this.L = cVar;
    }

    public void C0(CharSequence charSequence) {
        CommentEditText commentEditText = this.F;
        if (commentEditText == null) {
            return;
        }
        try {
            commentEditText.setText(charSequence);
            CommentEditText commentEditText2 = this.F;
            commentEditText2.setSelection(commentEditText2.getText().length());
        } catch (Exception e16) {
            QLog.e("QFSBaseInputPopupWindow", 1, "setText error. " + e16);
        }
    }

    public void D0(final View view, int i3) {
        view.requestFocus();
        view.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QFSBaseInputPopupWindow", 1, "showKeyBoard");
                QFSBaseInputPopupWindow.this.H.showSoftInput(view, 1);
                QFSBaseInputPopupWindow.this.q0(true);
            }
        }, i3);
    }

    protected void a0() {
        int i3;
        if (getWindow() != null && getWindow().getAttributes() != null && getWindow().getDecorView() != null) {
            Window window = getWindow();
            window.clearFlags(67108864);
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_comment_input_status_bar_visible", true)) {
                i3 = 5894;
            } else {
                i3 = 1280;
            }
            window.getDecorView().setSystemUiVisibility(i3);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (Build.VERSION.SDK_INT >= 28 && bz.o()) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setSoftInputMode(48);
            com.tencent.mobileqq.qui.b.f276860a.l(window);
        }
    }

    public int c0() {
        if (this.D.get() == null) {
            return 0;
        }
        int realHeight = (DisplayUtil.getRealHeight(this.D.get()) - U) - cx.a(80.0f);
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(this.D.get()) - DisplayUtil.getScreenHeight();
        int i3 = realHeight - instantScreenHeight;
        QLog.i("QFSBaseInputPopupWindow", 1, "getInputLayoutLocationYOnScreen  yOnScreen : " + i3 + ", offsetY: " + instantScreenHeight);
        return i3;
    }

    protected abstract int d0();

    @Override // com.tencent.biz.qqcircle.widgets.comment.a, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        k0(this.F);
        View view = this.E;
        if (view != null && view.getVisibility() == 0) {
            this.E.setVisibility(8);
        }
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Handler e0() {
        if (this.P == null) {
            this.P = new Handler(Looper.getMainLooper());
        }
        return this.P;
    }

    public String f0() {
        return E0(false, false, false);
    }

    public String g0() {
        return E0(false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float i0() {
        return (this.F.getMeasuredWidth() - this.F.getPaddingLeft()) - this.F.getPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        CommentEditText commentEditText = (CommentEditText) this.E.findViewById(R.id.jha);
        this.F = commentEditText;
        commentEditText.setOnInputBackListener(new CommentEditText.d() { // from class: com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.1
            @Override // com.tencent.biz.qqcircle.widgets.comment.CommentEditText.d
            public void a(View view) {
                if (QFSBaseInputPopupWindow.this.isShowing() && (((com.tencent.biz.qqcircle.widgets.comment.e) QFSBaseInputPopupWindow.this).D.get() instanceof Activity)) {
                    ((Activity) ((com.tencent.biz.qqcircle.widgets.comment.e) QFSBaseInputPopupWindow.this).D.get()).runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSBaseInputPopupWindow.this.dismiss();
                        }
                    });
                }
            }
        });
        this.F.setEditableFactory(QCircleHostTextBuilder.getEmoctationFacory());
        this.G = (Button) this.E.findViewById(R.id.aiz);
        int e16 = uq3.k.b().e("sp_key_soft_keyboard_height", com.tencent.biz.qqcircle.widgets.comment.f.f93570g);
        U = e16;
        if (e16 > DisplayUtil.getScreenHeight() - V && bz.o()) {
            U = (int) (DisplayUtil.getScreenHeight() * 0.7d);
        }
        QLog.d("QFSBaseInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + U);
        View findViewById = this.E.findViewById(R.id.aav);
        this.M = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSBaseInputPopupWindow.this.n0(view);
            }
        });
        this.H = (InputMethodManager) this.D.get().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.E.setVisibility(4);
    }

    public String j0() {
        return E0(true, true, true);
    }

    public void k0(View view) {
        boolean z16;
        if (view == null) {
            QLog.e("QFSBaseInputPopupWindow", 1, "hideSoftInput error paramEditText is null");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("hideSoftInput, windowToken is null: ");
        if (view.getWindowToken() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("QFSBaseInputPopupWindow", 1, sb5.toString());
        this.H.hideSoftInputFromWindow(view.getWindowToken(), 0);
        q0(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0() {
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
    }

    protected abstract void m0(View view);

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = this.N;
        if (fVar != null) {
            fVar.r();
            this.N = null;
        }
        this.J = false;
        c cVar = this.L;
        if (cVar != null) {
            cVar.onDismiss();
        }
    }

    public void r0(boolean z16) {
        if (this.D.get() != null) {
            QFSCommentHelper.p0(getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0() {
        if (this.E != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.Q = alphaAnimation;
            alphaAnimation.setDuration(200L);
            this.Q.setAnimationListener(new a());
            this.E.startAnimation(this.Q);
        }
    }

    public SpannableStringBuilder x0(String str, boolean z16) {
        this.S.clear();
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder("");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = RichTextAtParser.AT_PATTERN.matcher(spannableStringBuilder);
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                int indexOf = group.indexOf("uin:") + 4;
                int indexOf2 = group.indexOf(",nick:");
                String substring = group.substring(indexOf, indexOf2);
                String replace = group.substring(indexOf2 + 6, group.length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
                String str2 = "@" + replace;
                spannableStringBuilder.replace(start, end, (CharSequence) str2);
                i3 += group.length() - str2.length();
                int length = str2.length() + start;
                if (z16) {
                    this.F.c(spannableStringBuilder, start, length, Z(substring, replace));
                }
            } catch (Exception e16) {
                QLog.e("QFSBaseInputPopupWindow", 1, "restoreATContent error" + e16.getMessage());
            }
        }
        return spannableStringBuilder;
    }

    public void y0(final String str) {
        CommentEditText commentEditText = this.F;
        if (commentEditText != null) {
            commentEditText.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.a
                @Override // java.lang.Runnable
                public final void run() {
                    QFSBaseInputPopupWindow.this.o0(str);
                }
            });
        }
    }

    public void z0(b bVar) {
        this.K = bVar;
    }
}
