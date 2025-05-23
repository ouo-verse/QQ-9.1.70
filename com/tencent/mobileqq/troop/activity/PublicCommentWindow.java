package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.KeyEventDispatcher;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.s;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes19.dex */
public class PublicCommentWindow extends ReportDialog implements View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.b {
    static IPatchRedirector $redirector_;
    protected ImageView C;
    protected EditText D;
    protected Button E;
    protected InputMethodRelativeLayout F;
    protected SystemAndEmojiEmoticonPanel G;
    protected FrameLayout H;
    protected JSONObject I;
    protected String J;
    protected int K;
    protected int L;
    protected String M;
    protected boolean N;
    protected long P;
    protected Handler Q;
    protected boolean R;
    protected a S;
    protected ArrayList<String> T;
    protected QBaseActivity U;
    protected String V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicCommentWindow.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(intent.getAction()) && "CommentSendSuccess".equals(intent.getStringExtra("event"))) {
                PublicCommentWindow publicCommentWindow = PublicCommentWindow.this;
                publicCommentWindow.N = true;
                publicCommentWindow.dismiss();
                if (QLog.isColorLevel()) {
                    QLog.d("PublicCommentPopupWindow", 2, "web call finish----------------");
                }
            }
        }
    }

    public PublicCommentWindow(QBaseActivity qBaseActivity, Bundle bundle) {
        super(qBaseActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.N = false;
        this.P = 0L;
        this.Q = null;
        this.R = false;
        this.S = null;
        this.T = null;
        requestWindowFeature(1);
        this.U = qBaseActivity;
        O(bundle);
    }

    protected void N(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        try {
            com.tencent.mobileqq.jsp.h.w("qbrowserCommentOnSend", new JSONObject(TroopBarPublishUtils.c(str, null, null)), this.T, null);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(e16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        String string = bundle.getString("options");
        this.V = bundle.getString("onclose");
        if (QLog.isColorLevel()) {
            QLog.d("PublicCommentPopupWindow", 2, "Comment option: " + string);
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            this.I = jSONObject;
            this.J = jSONObject.optString("draftID");
            this.K = this.I.optInt("maxContentLength");
            this.L = this.I.optInt("minContentLength");
            this.M = this.I.optString("contentPlaceholder");
            this.T = new ArrayList<>();
            try {
                this.T.add(Uri.parse(this.I.optString(ISchemeApi.KEY_REFERER)).getHost());
            } catch (NullPointerException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(e16));
                }
            }
            this.S = new a();
            this.U.registerReceiver(this.S, new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT"));
        } catch (NullPointerException unused) {
            dismiss();
        } catch (JSONException unused2) {
            dismiss();
        }
    }

    protected void P(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        this.F = (InputMethodRelativeLayout) view.findViewById(R.id.root);
        this.C = (ImageView) view.findViewById(R.id.emo_btn);
        this.D = (EditText) view.findViewById(R.id.input);
        this.E = (Button) view.findViewById(R.id.send_btn);
        this.H = (FrameLayout) view.findViewById(R.id.e3e);
        this.C.setOnClickListener(this);
        this.E.setSelected(true);
        this.E.setEnabled(true);
        this.E.setOnClickListener(this);
        view.findViewById(R.id.jvv).setOnClickListener(this);
        this.G = TroopBarPublishUtils.a(this.U, this.H, this.D, this);
        this.F.setOnSizeChangedListenner(this);
        this.Q = new Handler();
        this.D.setHint(this.M);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(String str, String str2, boolean z16) {
        WebViewFragment currentWebViewFragment;
        CustomWebView webView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            KeyEventDispatcher.Component component = this.U;
            if ((component instanceof u) && (currentWebViewFragment = ((u) component).getCurrentWebViewFragment()) != null && (webView = currentWebViewFragment.getWebView()) != null) {
                if (z16) {
                    webView.callJs(str, "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + str2 + "}}");
                    return;
                }
                webView.callJs(str, "{\"code\":-1}");
            }
        }
    }

    protected boolean R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        HashMap<String, String> hashMap = s.f302209j;
        String str = hashMap.get(this.J);
        hashMap.clear();
        if (!TextUtils.isEmpty(str)) {
            this.D.setText(str);
            this.D.setSelection(str.length());
            return true;
        }
        return false;
    }

    protected void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        String obj = this.D.getEditableText().toString();
        if (!TextUtils.isEmpty(obj)) {
            s.f302209j.put(this.J, obj);
        }
    }

    public void U(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.a2h, (ViewGroup) null);
        setContentView(inflate);
        P(inflate);
        R();
        super.show();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 83;
        attributes.softInputMode = 21;
        getWindow().setBackgroundDrawable(new ColorDrawable());
        if (QLog.isColorLevel()) {
            QLog.d("PublicCommentPopupWindow", 2, "PublicCommentWindow show time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.mobileqq.text.TextUtils.backspace(this.D);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a aVar = this.S;
        if (aVar != null) {
            this.U.unregisterReceiver(aVar);
            this.S = null;
        }
        if (this.G != null) {
            this.G = null;
        }
        InputMethodUtil.hide(this.D);
        if (!this.N) {
            S();
        }
        com.tencent.mobileqq.jsp.h.w("qbrowserCommentOnClose", null, this.T, null);
        super.dismiss();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.widget.InputMethodRelativeLayout.b
    public void n(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        SystemAndEmojiEmoticonPanel systemAndEmojiEmoticonPanel = this.G;
        if (systemAndEmojiEmoticonPanel == null) {
            return;
        }
        if (z16) {
            com.tencent.mobileqq.jsp.h.w("qbrowserCommentOnCreate", null, this.T, null);
            if (this.G.getVisibility() == 0) {
                this.G.setVisibility(8);
            }
            this.C.setImageResource(R.drawable.asw);
            this.C.setContentDescription(this.U.getString(R.string.dty));
            return;
        }
        if (systemAndEmojiEmoticonPanel.getVisibility() == 8 && !this.R) {
            dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.jvv) {
                dismiss();
            } else if (id5 == R.id.emo_btn) {
                if (System.currentTimeMillis() - this.P >= 500) {
                    this.P = System.currentTimeMillis();
                    if (this.G.getVisibility() == 0) {
                        this.G.setVisibility(8);
                        InputMethodUtil.show(this.D);
                        this.C.setImageResource(R.drawable.asw);
                        this.C.setContentDescription(this.U.getString(R.string.dty));
                    } else {
                        this.R = true;
                        InputMethodUtil.hide(this.D);
                        this.Q.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.PublicCommentWindow.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublicCommentWindow.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                SystemAndEmojiEmoticonPanel systemAndEmojiEmoticonPanel;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                PublicCommentWindow publicCommentWindow = PublicCommentWindow.this;
                                publicCommentWindow.R = false;
                                if (publicCommentWindow.isShowing() && (systemAndEmojiEmoticonPanel = PublicCommentWindow.this.G) != null) {
                                    systemAndEmojiEmoticonPanel.setVisibility(0);
                                    PublicCommentWindow.this.C.setImageResource(R.drawable.buz);
                                    PublicCommentWindow publicCommentWindow2 = PublicCommentWindow.this;
                                    publicCommentWindow2.C.setContentDescription(publicCommentWindow2.U.getString(R.string.dtz));
                                }
                            }
                        }, 200L);
                    }
                }
            } else if (id5 == R.id.send_btn) {
                send();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticonInfo)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, emoticonInfo, emoticonInfo2, drawable);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            emoticonInfo.send(null, this.U, this.D, null);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        String a16 = s.a(this.D);
        if (TextUtils.isEmpty(a16)) {
            i3 = 0;
        } else {
            a16 = a16.trim();
            i3 = a16.length();
        }
        if (i3 == 0) {
            QQToast.makeText(this.U, R.string.duf, 0).show(this.U.getTitleBarHeight());
            return;
        }
        int i16 = this.L;
        if (i3 < i16) {
            QBaseActivity qBaseActivity = this.U;
            QQToast.makeText(qBaseActivity, qBaseActivity.getString(R.string.dud, Integer.valueOf(i16)), 0).show(this.U.getTitleBarHeight());
            return;
        }
        int i17 = this.K;
        if (i3 > i17) {
            QBaseActivity qBaseActivity2 = this.U;
            QQToast.makeText(qBaseActivity2, qBaseActivity2.getString(R.string.due, Integer.valueOf(i17)), 0).show(this.U.getTitleBarHeight());
        } else if (!HttpUtil.isConnect(this.U)) {
            QQToast.makeText(this.U, R.string.cgc, 0).show(this.U.getTitleBarHeight());
        } else {
            N(a16);
        }
    }
}
