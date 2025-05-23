package com.tencent.mobileqq.qrscan.activity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.n;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRCardActivity extends QIphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected static String H0;
    protected int A0;
    protected ActionSheet B0;
    protected Resources C0;
    protected boolean D0;
    protected String E0;
    protected Handler F0;
    private View.OnLongClickListener G0;

    /* renamed from: a0, reason: collision with root package name */
    private AppRuntime f276541a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f276542b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f276543c0;

    /* renamed from: d0, reason: collision with root package name */
    protected LinearLayout f276544d0;

    /* renamed from: e0, reason: collision with root package name */
    protected ImageView f276545e0;

    /* renamed from: f0, reason: collision with root package name */
    protected TextView f276546f0;

    /* renamed from: g0, reason: collision with root package name */
    protected TextView f276547g0;

    /* renamed from: h0, reason: collision with root package name */
    protected TextView f276548h0;

    /* renamed from: i0, reason: collision with root package name */
    protected Button f276549i0;

    /* renamed from: j0, reason: collision with root package name */
    protected n f276550j0;

    /* renamed from: k0, reason: collision with root package name */
    protected float f276551k0;

    /* renamed from: l0, reason: collision with root package name */
    protected String f276552l0;

    /* renamed from: m0, reason: collision with root package name */
    protected String f276553m0;

    /* renamed from: n0, reason: collision with root package name */
    protected String f276554n0;

    /* renamed from: o0, reason: collision with root package name */
    protected String f276555o0;

    /* renamed from: p0, reason: collision with root package name */
    protected String f276556p0;

    /* renamed from: q0, reason: collision with root package name */
    protected String f276557q0;

    /* renamed from: r0, reason: collision with root package name */
    protected String f276558r0;

    /* renamed from: s0, reason: collision with root package name */
    protected String f276559s0;

    /* renamed from: t0, reason: collision with root package name */
    protected String f276560t0;

    /* renamed from: u0, reason: collision with root package name */
    protected String f276561u0;

    /* renamed from: v0, reason: collision with root package name */
    protected String f276562v0;

    /* renamed from: w0, reason: collision with root package name */
    protected String f276563w0;

    /* renamed from: x0, reason: collision with root package name */
    protected String f276564x0;

    /* renamed from: y0, reason: collision with root package name */
    protected String f276565y0;

    /* renamed from: z0, reason: collision with root package name */
    protected Thread f276566z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class NumberSpan extends URLSpan {
        static IPatchRedirector $redirector_;

        public NumberSpan(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this, (Object) str);
            }
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            String url = getURL();
            if (!TextUtils.isEmpty(url)) {
                if (Pattern.compile("\\d{5,}").matcher(url).matches()) {
                    QRCardActivity.this.R2(view.getContext(), 3, url, null);
                } else if (Pattern.compile(QRCardActivity.H0).matcher(url).matches()) {
                    QRCardActivity.this.P2(url);
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                textPaint.setColor(QRCardActivity.this.A0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 0) {
                QRCardActivity qRCardActivity = QRCardActivity.this;
                if (!qRCardActivity.f276542b0) {
                    Object obj = message.obj;
                    if ((obj instanceof Bitmap) && (bitmap = (Bitmap) obj) != null) {
                        qRCardActivity.f276545e0.setBackgroundResource(0);
                        QRCardActivity.this.f276545e0.setImageBitmap(bitmap);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean[] f276569d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f276570e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f276571f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f276572h;

        b(boolean[] zArr, String str, Context context, String str2) {
            this.f276569d = zArr;
            this.f276570e = str;
            this.f276571f = context;
            this.f276572h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QRCardActivity.this, zArr, str, context, str2);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        @SuppressLint({"NewApi"})
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            QRCardActivity qRCardActivity = QRCardActivity.this;
            if (qRCardActivity.D0) {
                return;
            }
            qRCardActivity.D0 = true;
            boolean[] zArr = this.f276569d;
            if (zArr[0]) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        String str = qRCardActivity.f276550j0.f276776f.get(qRCardActivity.f276562v0);
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.EMAIL", str);
                        intent.putExtra("android.intent.extra.TEXT", "The email body text");
                        intent.setType("text/plain");
                        try {
                            QRCardActivity.this.startActivity(Intent.createChooser(intent, "Choose Email Client"));
                        } catch (ActivityNotFoundException unused) {
                            if (QLog.isColorLevel()) {
                                QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_SEND do not exist");
                            }
                        }
                    }
                } else {
                    String account = qRCardActivity.f276541a0.getAccount();
                    QRCardActivity qRCardActivity2 = QRCardActivity.this;
                    String str2 = qRCardActivity2.f276550j0.f276776f.get(qRCardActivity2.f276562v0);
                    if (!TextUtils.isEmpty(account)) {
                        String str3 = "https://w.mail.qq.com/cgi-bin/login?target=mobileqqwrite&fwd=mq&fun=from3g&uin=" + account + "&to=" + str2;
                        String lowerCase = str3.toLowerCase();
                        if (lowerCase.startsWith("www.")) {
                            str3 = "https://" + str3;
                        } else if (lowerCase.startsWith("https:")) {
                            str3 = "https" + str3.substring(5);
                        } else if (lowerCase.startsWith("http:")) {
                            str3 = "http" + str3.substring(4);
                        }
                        Intent intent2 = new Intent(QRCardActivity.this, (Class<?>) QQBrowserActivity.class);
                        intent2.putExtra("url", str3);
                        intent2.putExtra("key_isReadModeEnabled", true);
                        intent2.putExtra("injectrecommend", false);
                        QRCardActivity.this.startActivity(intent2);
                    }
                }
                QRCardActivity.this.B0.dismiss();
                return;
            }
            if (zArr[1]) {
                if (i3 == 0) {
                    if (this.f276570e.contains("-")) {
                        this.f276570e.replaceAll("-", "");
                    }
                    if (this.f276570e.contains(" ")) {
                        this.f276570e.replaceAll(" ", "");
                    }
                    try {
                        this.f276571f.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f276570e)));
                    } catch (ActivityNotFoundException unused2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
                        }
                    }
                }
                QRCardActivity.this.B0.dismiss();
                return;
            }
            if (zArr[2]) {
                HashMap<String, String> hashMap = new HashMap<>();
                if (!QRCardActivity.this.f276550j0.f276773c.isEmpty()) {
                    hashMap.putAll(QRCardActivity.this.f276550j0.f276773c);
                }
                if (!QRCardActivity.this.f276550j0.f276776f.isEmpty()) {
                    hashMap.putAll(QRCardActivity.this.f276550j0.f276776f);
                }
                HashMap<String, String> hashMap2 = QRCardActivity.this.f276550j0.f276775e;
                if (hashMap2 != null) {
                    hashMap.putAll(hashMap2);
                }
                if (!QRCardActivity.this.f276550j0.f276774d.isEmpty()) {
                    hashMap.putAll(QRCardActivity.this.f276550j0.f276774d);
                }
                if (i3 != 0) {
                    if (i3 == 1) {
                        Intent intent3 = new Intent("android.intent.action.INSERT_OR_EDIT");
                        intent3.setType("vnd.android.cursor.item/person");
                        intent3.setType("vnd.android.cursor.item/contact");
                        intent3.setType("vnd.android.cursor.item/raw_contact");
                        QRCardActivity.this.I2(intent3, hashMap);
                    }
                } else {
                    Intent intent4 = new Intent("android.intent.action.INSERT");
                    intent4.setType("vnd.android.cursor.dir/person");
                    intent4.setType("vnd.android.cursor.dir/contact");
                    intent4.setType("vnd.android.cursor.dir/raw_contact");
                    QRCardActivity.this.I2(intent4, hashMap);
                }
                QRCardActivity.this.B0.dismiss();
                return;
            }
            if (zArr[3]) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).startActivity(this.f276571f, true, this.f276572h, true);
                            }
                        } else {
                            ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).startActivity(this.f276571f, false, this.f276572h, true);
                        }
                    } else if (!TextUtils.isEmpty(this.f276572h)) {
                        ClipboardMonitor.setText((ClipboardManager) QRCardActivity.this.getSystemService("clipboard"), this.f276572h);
                    }
                } else {
                    if (this.f276572h.contains("-")) {
                        this.f276572h.replaceAll("-", "");
                    }
                    if (this.f276572h.contains(" ")) {
                        this.f276572h.replaceAll(" ", "");
                    }
                    try {
                        this.f276571f.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f276572h)));
                    } catch (ActivityNotFoundException unused3) {
                        if (QLog.isColorLevel()) {
                            QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
                        }
                    }
                }
                QRCardActivity.this.B0.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QRCardActivity.this.D0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f276576d;

        e(String str) {
            this.f276576d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            String lowerCase = this.f276576d.toLowerCase();
            if (lowerCase.startsWith("www.")) {
                str = "http://" + this.f276576d;
            } else if (lowerCase.startsWith("https:")) {
                str = "https" + this.f276576d.substring(5);
            } else if (lowerCase.startsWith("http:")) {
                str = "http" + this.f276576d.substring(4);
            } else {
                str = "http://" + this.f276576d;
            }
            Intent intent = new Intent(QRCardActivity.this, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra("injectrecommend", false);
            QRCardActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    Integer num = (Integer) tag;
                    if (num.intValue() == 0) {
                        str = (String) ((TextView) view.findViewById(R.id.content)).getText();
                    } else {
                        str = null;
                    }
                    if (num.intValue() != 1) {
                        QRCardActivity.this.R2(view.getContext(), num.intValue(), null, str);
                    } else {
                        QRCardActivity qRCardActivity = QRCardActivity.this;
                        qRCardActivity.P2(qRCardActivity.f276550j0.f276774d.get(qRCardActivity.f276559s0));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class g implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        View f276579d;

        /* renamed from: e, reason: collision with root package name */
        private View.OnClickListener f276580e;

        /* compiled from: P */
        /* loaded from: classes17.dex */
        class a implements BubblePopupWindow.OnDismissListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f276582d;

            a(View view) {
                this.f276582d = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) view);
                }
            }

            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public void onDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f276582d.setSelected(false);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes17.dex */
        class b implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    TextView textView = (TextView) g.this.f276579d.findViewById(R.id.content);
                    if (textView.getText() instanceof String) {
                        g.this.a((String) textView.getText());
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this);
            } else {
                this.f276580e = new b();
            }
        }

        @SuppressLint({"ServiceCast", "NewApi"})
        void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                ClipboardMonitor.setText((ClipboardManager) QRCardActivity.this.getSystemService("clipboard"), str);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else if (view == null) {
                z16 = false;
            } else {
                this.f276579d = view;
                z16 = true;
                view.setSelected(true);
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                aVar.b(R.id.bbi, QRCardActivity.this.getString(R.string.aet), R.drawable.cb5);
                QRCardActivity.showAsDropDown(view, aVar, this.f276580e, new a(view));
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            H0 = "((?:(?i)https?://|www\\.|[a-zA-Z0-9]+\\.)[a-zA-Z0-9\\-.]+(?::(\\d+))?(?:(?:/[a-zA-Z0-9\\-._?,'+\\\\&%$=~*!;#():@\\\\]*)+)?)";
        }
    }

    public QRCardActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f276542b0 = false;
        this.f276543c0 = false;
        this.D0 = false;
        this.E0 = null;
        this.F0 = new a();
        this.G0 = new g();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void J2(ViewGroup viewGroup, int i3) {
        int i16;
        int size;
        int size2;
        int i17;
        String str;
        ViewGroup viewGroup2;
        int i18;
        String str2;
        ViewGroup viewGroup3;
        LayoutInflater layoutInflater = super.getLayoutInflater();
        int i19 = 1;
        int i26 = 0;
        if (i3 == 0) {
            size = this.f276550j0.f276773c.size();
            size2 = this.f276550j0.f276772b.size();
        } else if (i3 == 1) {
            size = this.f276550j0.f276775e.size() + this.f276550j0.f276776f.size() + this.f276550j0.f276774d.size();
            size2 = this.f276550j0.f276771a.size();
        } else {
            i16 = 0;
            int i27 = R.id.title;
            ViewGroup viewGroup4 = null;
            if (i3 != 0) {
                String str3 = ";";
                if (this.f276550j0.f276773c.isEmpty()) {
                    str = ";";
                    viewGroup2 = null;
                    i18 = 0;
                } else {
                    i18 = 0;
                    for (String str4 : this.f276550j0.f276773c.keySet()) {
                        String str5 = this.f276550j0.f276773c.get(str4);
                        String[] split = str5.split(str3);
                        if (split != null && split.length > 0) {
                            i16 += split.length - i19;
                            if (split.length > i19) {
                                int length = split.length;
                                int i28 = i26;
                                while (i28 < length) {
                                    String str6 = split[i28];
                                    View inflate = layoutInflater.inflate(R.layout.f168566c54, viewGroup4);
                                    inflate.setTag(0);
                                    TextView textView = (TextView) inflate.findViewById(R.id.content);
                                    ((TextView) inflate.findViewById(i27)).setText(str4);
                                    textView.setText(str6);
                                    Q2(i18, i16, inflate, viewGroup, 1);
                                    i18++;
                                    i28++;
                                    length = length;
                                    str3 = str3;
                                    viewGroup4 = null;
                                    split = split;
                                    str4 = str4;
                                    i27 = R.id.title;
                                }
                            } else {
                                str2 = str3;
                                viewGroup3 = viewGroup4;
                                View inflate2 = layoutInflater.inflate(R.layout.f168566c54, viewGroup3);
                                inflate2.setTag(0);
                                TextView textView2 = (TextView) inflate2.findViewById(R.id.content);
                                ((TextView) inflate2.findViewById(R.id.title)).setText(str4);
                                textView2.setText(str5);
                                Q2(i18, i16, inflate2, viewGroup, 1);
                                i18++;
                                str3 = str2;
                                viewGroup4 = viewGroup3;
                                i19 = 1;
                                i26 = 0;
                                i27 = R.id.title;
                            }
                        }
                        str2 = str3;
                        viewGroup3 = viewGroup4;
                        str3 = str2;
                        viewGroup4 = viewGroup3;
                        i19 = 1;
                        i26 = 0;
                        i27 = R.id.title;
                    }
                    str = str3;
                    viewGroup2 = viewGroup4;
                }
                if (!this.f276550j0.f276772b.isEmpty()) {
                    for (String str7 : this.f276550j0.f276772b.keySet()) {
                        String str8 = this.f276550j0.f276772b.get(str7);
                        String[] split2 = str8.split(str);
                        if (split2 != null && split2.length > 0) {
                            i16 += split2.length - 1;
                            if (split2.length > 1) {
                                for (String str9 : split2) {
                                    View inflate3 = layoutInflater.inflate(R.layout.f168565c53, viewGroup2);
                                    TextView textView3 = (TextView) inflate3.findViewById(R.id.content);
                                    ((TextView) inflate3.findViewById(R.id.title)).setText(str7);
                                    textView3.setText(str9);
                                    Q2(i18, i16, inflate3, viewGroup, 0);
                                    i18++;
                                }
                            } else {
                                View inflate4 = layoutInflater.inflate(R.layout.f168565c53, viewGroup2);
                                TextView textView4 = (TextView) inflate4.findViewById(R.id.content);
                                ((TextView) inflate4.findViewById(R.id.title)).setText(str7);
                                textView4.setText(str8);
                                Q2(i18, i16, inflate4, viewGroup, 0);
                                i18++;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (i3 == 1) {
                if (!this.f276550j0.f276776f.isEmpty()) {
                    String str10 = this.f276562v0;
                    String str11 = this.f276550j0.f276776f.get(str10);
                    View inflate5 = layoutInflater.inflate(R.layout.f168566c54, (ViewGroup) null);
                    inflate5.setTag(2);
                    TextView textView5 = (TextView) inflate5.findViewById(R.id.content);
                    ((TextView) inflate5.findViewById(R.id.title)).setText(str10);
                    textView5.setText(str11);
                    Q2(0, i16, inflate5, viewGroup, 1);
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                if (!this.f276550j0.f276775e.isEmpty()) {
                    String str12 = this.f276561u0;
                    String str13 = this.f276550j0.f276775e.get(str12);
                    View inflate6 = layoutInflater.inflate(R.layout.f168565c53, (ViewGroup) null);
                    TextView textView6 = (TextView) inflate6.findViewById(R.id.content);
                    ((TextView) inflate6.findViewById(R.id.title)).setText(str12);
                    textView6.setText(str13);
                    Q2(i17, i16, inflate6, viewGroup, 0);
                    i17++;
                }
                int i29 = i17;
                if (!this.f276550j0.f276774d.isEmpty()) {
                    String str14 = this.f276559s0;
                    String str15 = this.f276550j0.f276774d.get(str14);
                    if (Pattern.compile(H0).matcher(str15).matches()) {
                        View inflate7 = layoutInflater.inflate(R.layout.f168566c54, (ViewGroup) null);
                        inflate7.setTag(1);
                        TextView textView7 = (TextView) inflate7.findViewById(R.id.content);
                        ((TextView) inflate7.findViewById(R.id.title)).setText(str14);
                        textView7.setText(str15);
                        Q2(i29, i16, inflate7, viewGroup, 1);
                    } else {
                        View inflate8 = layoutInflater.inflate(R.layout.f168565c53, (ViewGroup) null);
                        TextView textView8 = (TextView) inflate8.findViewById(R.id.content);
                        ((TextView) inflate8.findViewById(R.id.title)).setText(str14);
                        textView8.setText(str15);
                        Q2(i29, i16, inflate8, viewGroup, 0);
                    }
                }
                if (!this.f276550j0.f276771a.isEmpty()) {
                    View inflate9 = layoutInflater.inflate(R.layout.f168565c53, (ViewGroup) null);
                    TextView textView9 = (TextView) inflate9.findViewById(R.id.content);
                    TextView textView10 = (TextView) inflate9.findViewById(R.id.title);
                    textView9.setMovementMethod(LinkMovementMethod.getInstance());
                    textView10.setText(this.f276560t0);
                    String str16 = this.f276550j0.f276771a.get(this.f276560t0);
                    SpannableString spannableString = new SpannableString(str16);
                    Matcher matcher = Pattern.compile("\\d{5,}").matcher(str16);
                    while (matcher.find()) {
                        int start = matcher.start();
                        int end = matcher.end();
                        if (end - start <= 16) {
                            spannableString.setSpan(new NumberSpan(str16.toString().substring(start, end)), start, end, 33);
                        }
                    }
                    Matcher matcher2 = Pattern.compile(H0).matcher(str16);
                    while (matcher2.find()) {
                        int start2 = matcher2.start();
                        int end2 = matcher2.end();
                        spannableString.setSpan(new NumberSpan(str16.toString().substring(start2, end2)), start2, end2, 33);
                    }
                    textView9.setText(spannableString);
                    if (i16 == 1) {
                        inflate9.setBackgroundResource(R.drawable.common_strip_setting_bg);
                    } else {
                        inflate9.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                    }
                    viewGroup.addView(inflate9);
                    return;
                }
                return;
            }
            return;
        }
        i16 = size + size2;
        int i272 = R.id.title;
        ViewGroup viewGroup42 = null;
        if (i3 != 0) {
        }
    }

    public static QQCustomMenuNoIconLayout K2(BubblePopupWindow bubblePopupWindow, Context context, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener) {
        QQCustomMenuItemPriorityHelper.d(aVar);
        QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(context);
        qQCustomMenuNoIconLayout.setGravity(17);
        qQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuNoIconLayout.setPopupWindow(bubblePopupWindow, null);
        qQCustomMenuNoIconLayout.setMenu(aVar);
        qQCustomMenuNoIconLayout.setMenuIconClickListener(onClickListener);
        qQCustomMenuNoIconLayout.D();
        return qQCustomMenuNoIconLayout;
    }

    private void M2() {
        super.setTitle(R.string.zqz);
        this.f276545e0 = (ImageView) super.findViewById(R.id.icon);
        this.f276546f0 = (TextView) super.findViewById(R.id.jfb);
        this.f276547g0 = (TextView) super.findViewById(R.id.f167076kh2);
        this.f276549i0 = (Button) super.findViewById(R.id.cgs);
        this.f276548h0 = (TextView) super.findViewById(R.id.nickname);
        this.f276549i0.setOnClickListener(this);
        this.f276544d0 = (LinearLayout) super.findViewById(R.id.dpq);
        if (!TextUtils.isEmpty(this.f276564x0)) {
            this.f276546f0.setText(this.f276564x0);
        }
        if (TextUtils.isEmpty(this.f276552l0)) {
            if (!TextUtils.isEmpty(this.f276565y0)) {
                this.f276548h0.setText(this.C0.getString(R.string.title) + MsgSummary.STR_COLON + this.f276565y0);
            }
        } else {
            this.f276548h0.setText(this.C0.getString(R.string.ciy) + MsgSummary.STR_COLON + this.f276552l0);
            if (!TextUtils.isEmpty(this.f276565y0)) {
                this.f276547g0.setText(this.C0.getString(R.string.title) + MsgSummary.STR_COLON + this.f276565y0);
            }
        }
        boolean isWifiConn = AppNetConnInfo.isWifiConn();
        if (this.f276543c0 && isWifiConn) {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.qrscan.activity.QRCardActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCardActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap decodeByteArray;
                    int i3;
                    int i16;
                    int i17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QRCardActivity qRCardActivity = QRCardActivity.this;
                        byte[] openUrlForByte = HttpUtil.openUrlForByte(qRCardActivity, qRCardActivity.f276563w0, "GET", null, null);
                        if (openUrlForByte == null || (decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length)) == null) {
                            return;
                        }
                        int width = decodeByteArray.getWidth();
                        int height = decodeByteArray.getHeight();
                        if (width > height) {
                            i3 = height;
                        } else {
                            i3 = width;
                        }
                        if (width > height) {
                            i16 = (width - height) / 2;
                        } else {
                            i16 = 0;
                        }
                        if (width > height) {
                            i17 = 0;
                        } else {
                            i17 = (height - width) / 2;
                        }
                        float f16 = 75;
                        float f17 = QRCardActivity.this.f276551k0;
                        int i18 = (int) (f16 * f17);
                        int i19 = (int) (f16 * f17);
                        Rect rect = new Rect(0, 0, i3, i3);
                        Rect rect2 = new Rect(0, 0, i18, i19);
                        RectF rectF = new RectF(rect2);
                        Matrix matrix = new Matrix();
                        matrix.setRectToRect(new RectF(rect), new RectF(rect2), Matrix.ScaleToFit.FILL);
                        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, i16, i17, i3, i3, matrix, false);
                        decodeByteArray.recycle();
                        Bitmap createBitmap2 = Bitmap.createBitmap(i18, i19, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap2);
                        Paint paint = new Paint();
                        paint.setAntiAlias(true);
                        canvas.drawARGB(0, 0, 0, 0);
                        paint.setColor(-12434878);
                        float f18 = (int) (QRCardActivity.this.f276551k0 * 6.0d);
                        canvas.drawRoundRect(rectF, f18, f18, paint);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                        canvas.drawBitmap(createBitmap, rect2, rect2, paint);
                        createBitmap.recycle();
                        Message message = new Message();
                        message.what = 0;
                        message.obj = createBitmap2;
                        QRCardActivity.this.F0.sendMessage(message);
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("IQRScanConst_QrcodeScannerCard", 2, e16.getMessage());
                        }
                    } catch (IllegalArgumentException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("IQRScanConst_QrcodeScannerCard", 2, e17.getMessage());
                        }
                    } catch (OutOfMemoryError e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("IQRScanConst_QrcodeScannerCard", 2, e18.getMessage());
                        }
                    }
                }
            });
            this.f276566z0 = baseThread;
            baseThread.start();
        }
        updateView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(Context context, int i3, String str, String str2) {
        this.B0 = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        boolean[] zArr = {false, false, false, false};
        if (i3 == 2) {
            zArr[0] = true;
            this.B0.addButton(this.C0.getString(R.string.ibm), 0);
            this.B0.addButton(this.C0.getString(R.string.ibk), 0);
        }
        if (i3 == 0) {
            zArr[1] = true;
            this.B0.addButton(this.C0.getString(R.string.ano), 1);
        }
        if (i3 == 4) {
            zArr[2] = true;
            this.B0.addButton(this.C0.getString(R.string.f170126ha), 1);
            this.B0.addButton(this.C0.getString(R.string.f170123h6), 1);
        }
        if (i3 == 3) {
            zArr[3] = true;
            this.B0.addButton(R.string.ano, 1);
            this.B0.addButton(R.string.aet, 1);
            this.B0.addButton(R.string.f170048dx, 1);
            this.B0.addButton(R.string.f171053c05, 1);
            this.B0.setMainTitle(String.format(context.getString(R.string.clm), str));
        }
        this.B0.setOnButtonClickListener(new b(zArr, str2, context, str));
        this.B0.addCancelButton(R.string.cancel);
        this.B0.setOnDismissListener(new c());
        if (!this.B0.isShowing()) {
            this.D0 = false;
            this.B0.show();
        }
    }

    private ViewGroup createGroupLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i3 = (int) (this.f276551k0 * 5.0f);
        layoutParams.setMargins(0, i3, 0, i3 << 1);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public static BubblePopupWindow showAsDropDown(View view, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(K2(bubblePopupWindow, view.getContext(), aVar, onClickListener));
        bubblePopupWindow.setOnDismissListener(onDismissListener);
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(true);
        bubblePopupWindow.showAsDropDown(view);
        return bubblePopupWindow;
    }

    private void updateView() {
        this.f276544d0.removeAllViewsInLayout();
        ViewGroup createGroupLayout = createGroupLayout();
        J2(createGroupLayout, 0);
        ViewGroup createGroupLayout2 = createGroupLayout();
        J2(createGroupLayout2, 1);
        this.f276544d0.addView(createGroupLayout);
        this.f276544d0.addView(createGroupLayout2);
        this.f276544d0.requestLayout();
        this.f276544d0.invalidate();
    }

    protected void I2(Intent intent, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent, (Object) hashMap);
            return;
        }
        intent.putExtra("job_title", this.f276565y0);
        intent.putExtra("name", this.f276546f0.getText().toString());
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            String[] split = str2.split(";");
            if (split != null && split.length > 0) {
                if (str.equals(this.f276561u0)) {
                    intent.putExtra(IProfileProtocolConst.KEY_COMPANY, str2);
                } else if (str.equals(this.f276562v0)) {
                    intent.putExtra("email", str2);
                } else if (str.contains(this.f276553m0)) {
                    intent.putExtra("phone", split[0]);
                    if (str.contains(this.f276554n0)) {
                        intent.putExtra("phone_type", 1);
                    } else if (str.contains(this.f276555o0)) {
                        intent.putExtra("phone_type", 3);
                    } else {
                        intent.putExtra("phone_type", 7);
                    }
                    if (split.length > 1) {
                        intent.putExtra("secondary_phone", split[1]);
                        if (str.contains(this.f276554n0)) {
                            intent.putExtra("phone_type", 1);
                        } else if (str.contains(this.f276555o0)) {
                            intent.putExtra("phone_type", 3);
                        } else {
                            intent.putExtra("phone_type", 7);
                        }
                    }
                }
            }
        }
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_INSERT or ACTION_INSERT_OR_EDIT do not exist");
            }
        }
    }

    public void L2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Resources resources = super.getResources();
        this.C0 = resources;
        this.f276551k0 = resources.getDisplayMetrics().density;
        this.f276553m0 = this.C0.getString(R.string.hz_);
        this.f276554n0 = this.C0.getString(R.string.bpm);
        this.f276555o0 = this.C0.getString(R.string.igl);
        this.f276556p0 = this.C0.getString(R.string.f170127hb);
        this.f276557q0 = this.C0.getString(R.string.bpl);
        this.f276558r0 = this.C0.getString(R.string.igk);
        this.f276559s0 = this.C0.getString(R.string.ibi);
        this.f276560t0 = this.C0.getString(R.string.ckn);
        this.f276561u0 = this.C0.getString(R.string.cps);
        this.f276562v0 = this.C0.getString(R.string.awj);
        this.A0 = super.getResources().getColor(R.color.f157232m1);
        this.f276550j0 = new n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x0289, code lost:
    
        if (r2.equals("fn") != false) goto L142;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void N2(int i3, String str) {
        String[] split;
        Object obj;
        String[] split2;
        String[] split3;
        String[] strArr;
        String str2;
        int i16;
        String[] split4;
        String str3;
        String[] split5;
        String str4;
        String[] split6;
        String[] strArr2;
        String str5;
        String[] split7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        String str6 = "note";
        String str7 = "nickname";
        String str8 = DomainData.DOMAIN_NAME;
        int i17 = 1;
        if (i3 == 0) {
            if (str.length() <= 7) {
                return;
            }
            String substring = str.substring(7);
            if (TextUtils.isEmpty(substring) || (split6 = substring.split(";")) == null) {
                return;
            }
            int i18 = 0;
            while (i18 < split6.length) {
                if (split6[i18].contains(":") && (split7 = split6[i18].split(":")) != null) {
                    strArr2 = split6;
                    if (split7.length > i17 && !TextUtils.isEmpty(split7[0]) && !TextUtils.isEmpty(split7[i17])) {
                        String trim = split7[0].toLowerCase().trim();
                        String trim2 = split7[i17].trim();
                        if (trim.equalsIgnoreCase(str8)) {
                            this.f276564x0 = trim2;
                        } else {
                            str5 = str8;
                            if (trim.equalsIgnoreCase("til")) {
                                this.f276565y0 = trim2;
                            } else if (trim.startsWith("photo")) {
                                if (split7.length > 2) {
                                    StringBuilder sb5 = new StringBuilder();
                                    for (int i19 = 1; i19 < split7.length; i19++) {
                                        sb5.append(split7[i19]);
                                        if (i19 != split7.length - 1) {
                                            sb5.append(":");
                                        }
                                    }
                                    trim2 = sb5.toString();
                                }
                                this.f276563w0 = trim2;
                                this.f276543c0 = true;
                            } else if (trim.equals("tel")) {
                                if (this.f276550j0.f276773c.containsKey(this.f276553m0)) {
                                    trim2 = this.f276550j0.f276773c.get(this.f276553m0) + ";" + trim2;
                                }
                                this.f276550j0.f276773c.put(this.f276553m0, trim2);
                            } else if (trim.equals("adr")) {
                                if (this.f276550j0.f276772b.containsKey(this.f276556p0)) {
                                    trim2 = this.f276550j0.f276772b.get(this.f276556p0) + ";" + trim2;
                                }
                                this.f276550j0.f276772b.put(this.f276556p0, trim2);
                            } else if (trim.equals("email")) {
                                this.f276550j0.f276776f.put(this.f276562v0, trim2);
                            } else if (trim.equals("org")) {
                                this.f276550j0.f276775e.put(this.f276561u0, trim2);
                            } else if (trim.equals("url")) {
                                if (split7.length > 2) {
                                    StringBuilder sb6 = new StringBuilder();
                                    for (int i26 = 1; i26 < split7.length; i26++) {
                                        sb6.append(split7[i26]);
                                        if (i26 != split7.length - 1) {
                                            sb6.append(":");
                                        }
                                    }
                                    trim2 = sb6.toString();
                                }
                                this.f276550j0.f276774d.put(this.f276559s0, trim2);
                            } else if (trim.equals("note")) {
                                if (split7.length > 2) {
                                    StringBuilder sb7 = new StringBuilder();
                                    for (int i27 = 1; i27 < split7.length; i27++) {
                                        sb7.append(split7[i27]);
                                        if (i27 != split7.length - 1) {
                                            sb7.append(":");
                                        }
                                    }
                                    trim2 = sb7.toString();
                                }
                                this.f276550j0.f276771a.put(this.f276560t0, trim2);
                            } else if (trim.equals("nickname")) {
                                this.f276552l0 = trim2;
                            }
                            i18++;
                            split6 = strArr2;
                            str8 = str5;
                            i17 = 1;
                        }
                    }
                } else {
                    strArr2 = split6;
                }
                str5 = str8;
                i18++;
                split6 = strArr2;
                str8 = str5;
                i17 = 1;
            }
            return;
        }
        Object obj2 = DomainData.DOMAIN_NAME;
        if (i3 == 1) {
            if (str.length() <= 21) {
                return;
            }
            String str9 = "\n";
            if (!str.contains("\n")) {
                str9 = "\r";
                if (!str.contains("\r")) {
                    str9 = "\r\n";
                    if (!str.contains("\r\n")) {
                        return;
                    }
                }
            }
            String substring2 = str.substring(11, str.length() - 9);
            if (TextUtils.isEmpty(substring2) || (split3 = substring2.split(str9)) == null) {
                return;
            }
            int i28 = 0;
            while (i28 < split3.length) {
                if (split3[i28].contains(":") && (split4 = split3[i28].split(":")) != null) {
                    strArr = split3;
                    i16 = i28;
                    if (split4.length <= 1 || TextUtils.isEmpty(split4[0]) || TextUtils.isEmpty(split4[1])) {
                        str2 = str7;
                    } else {
                        String trim3 = split4[0].toLowerCase().trim();
                        String trim4 = split4[1].trim();
                        String str10 = str6;
                        Object obj3 = obj2;
                        if (trim3.equals(obj3)) {
                            obj2 = obj3;
                        } else {
                            obj2 = obj3;
                        }
                        if (TextUtils.isEmpty(this.f276564x0)) {
                            if (trim4.contains(";")) {
                                String[] split8 = trim4.split(";");
                                if (split8 == null || split8.length <= 0) {
                                    trim4 = "";
                                } else {
                                    int length = split8.length;
                                    String str11 = trim4;
                                    int i29 = 0;
                                    while (i29 < length) {
                                        int i36 = length;
                                        str11 = str11 + " " + split8[i29];
                                        i29++;
                                        length = i36;
                                        split8 = split8;
                                    }
                                    trim4 = str11;
                                }
                            }
                            this.f276564x0 = trim4;
                            str2 = str7;
                            str6 = str10;
                        }
                        if (trim3.equals("title")) {
                            this.f276565y0 = trim4;
                        } else if (trim3.startsWith("photo")) {
                            if (split4.length > 2) {
                                StringBuilder sb8 = new StringBuilder();
                                for (int i37 = 1; i37 < split4.length; i37++) {
                                    sb8.append(split4[i37]);
                                    if (i37 != split4.length - 1) {
                                        sb8.append(":");
                                    }
                                }
                                trim4 = sb8.toString();
                            }
                            this.f276563w0 = trim4;
                            this.f276543c0 = true;
                        } else if (trim3.equals(str7)) {
                            this.f276552l0 = trim4;
                        } else {
                            str2 = str7;
                            if (trim3.startsWith("tel")) {
                                if (trim3.contains("home")) {
                                    str4 = this.f276554n0;
                                } else if (trim3.contains(WidgetCacheConstellationData.WORK)) {
                                    str4 = this.f276555o0;
                                } else {
                                    str4 = this.f276553m0;
                                }
                                if ("tel".equals(trim4) && split4.length > 2) {
                                    trim4 = split4[2];
                                }
                                if (this.f276550j0.f276773c.containsKey(str4)) {
                                    trim4 = this.f276550j0.f276773c.get(str4) + ";" + trim4;
                                }
                                this.f276550j0.f276773c.put(str4, trim4);
                            } else if (trim3.contains("adr")) {
                                if (trim3.contains("home")) {
                                    str3 = this.f276557q0;
                                } else if (trim3.contains(WidgetCacheConstellationData.WORK)) {
                                    str3 = this.f276558r0;
                                } else {
                                    str3 = this.f276556p0;
                                }
                                if (trim4.contains(";;")) {
                                    StringBuilder sb9 = new StringBuilder();
                                    String substring3 = trim4.substring(2);
                                    if (!TextUtils.isEmpty(substring3) && (split5 = substring3.split(";")) != null) {
                                        for (int i38 = 0; i38 < split5.length; i38++) {
                                            if (!TextUtils.isEmpty(split5[i38])) {
                                                sb9.append(split5[i38]);
                                                if (i38 != split5.length - 1) {
                                                    sb9.append(str9);
                                                }
                                            }
                                        }
                                        trim4 = sb9.toString();
                                    }
                                }
                                if (this.f276550j0.f276772b.containsKey(str3)) {
                                    trim4 = this.f276550j0.f276772b.get(str3) + ";" + trim4;
                                }
                                this.f276550j0.f276772b.put(str3, trim4);
                            } else if (trim3.equals("email")) {
                                this.f276550j0.f276776f.put(this.f276562v0, trim4);
                            } else if (trim3.equals("org")) {
                                this.f276550j0.f276775e.put(this.f276561u0, trim4);
                            } else if (trim3.equals("url")) {
                                if (split4.length > 2) {
                                    StringBuilder sb10 = new StringBuilder();
                                    for (int i39 = 1; i39 < split4.length; i39++) {
                                        sb10.append(split4[i39]);
                                        if (i39 != split4.length - 1) {
                                            sb10.append(":");
                                        }
                                    }
                                    trim4 = sb10.toString();
                                }
                                this.f276550j0.f276774d.put(this.f276559s0, trim4);
                            } else {
                                str6 = str10;
                                if (trim3.equals(str6)) {
                                    if (split4.length > 2) {
                                        StringBuilder sb11 = new StringBuilder();
                                        for (int i46 = 1; i46 < split4.length; i46++) {
                                            sb11.append(split4[i46]);
                                            if (i46 != split4.length - 1) {
                                                sb11.append(":");
                                            }
                                        }
                                        trim4 = sb11.toString();
                                    }
                                    this.f276550j0.f276771a.put(this.f276560t0, trim4);
                                }
                            }
                            str6 = str10;
                        }
                        str2 = str7;
                        str6 = str10;
                    }
                } else {
                    strArr = split3;
                    str2 = str7;
                    i16 = i28;
                }
                i28 = i16 + 1;
                split3 = strArr;
                str7 = str2;
            }
            return;
        }
        if (str.length() <= 10) {
            return;
        }
        String substring4 = str.substring(8, str.length() - 2);
        if (TextUtils.isEmpty(substring4) || (split = substring4.split(";")) == null) {
            return;
        }
        String str12 = null;
        String str13 = null;
        int i47 = 0;
        while (i47 < split.length) {
            if (!split[i47].contains(":") || (split2 = split[i47].split(":")) == null) {
                obj = obj2;
            } else if (split2.length > 1) {
                if (!TextUtils.isEmpty(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                    String trim5 = split2[0].toLowerCase().trim();
                    String trim6 = split2[1].trim();
                    if (trim5.equals(HippyTKDListViewAdapter.X)) {
                        str12 = trim6;
                    } else {
                        obj = obj2;
                        if (trim5.equals(obj)) {
                            str13 = trim6;
                        } else if (trim5.equals("t")) {
                            this.f276565y0 = trim6;
                        } else if (trim5.equals("b")) {
                            if (this.f276550j0.f276773c.containsKey(this.f276553m0)) {
                                trim6 = this.f276550j0.f276773c.get(this.f276553m0) + ";" + trim6;
                            }
                            this.f276550j0.f276773c.put(this.f276553m0, trim6);
                        } else if (trim5.equals("a")) {
                            if (this.f276550j0.f276772b.containsKey(this.f276556p0)) {
                                trim6 = this.f276550j0.f276772b.get(this.f276556p0) + ";" + trim6;
                            }
                            this.f276550j0.f276772b.put(this.f276556p0, trim6);
                        } else if (trim5.equals("e")) {
                            this.f276550j0.f276776f.put(this.f276562v0, trim6);
                        } else if (trim5.equals("c")) {
                            this.f276550j0.f276775e.put(this.f276561u0, trim6);
                        }
                    }
                }
                obj = obj2;
            } else {
                obj = obj2;
            }
            i47++;
            obj2 = obj;
        }
        if (!TextUtils.isEmpty(str12)) {
            if (!TextUtils.isEmpty(str13)) {
                this.f276564x0 = str12 + " " + str13;
                return;
            }
            this.f276564x0 = str12;
            return;
        }
        if (TextUtils.isEmpty(str13)) {
            return;
        }
        this.f276564x0 = str13;
    }

    protected void P2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        createCustomDialog.setTitle(R.string.g2p);
        createCustomDialog.setMessage(str);
        d dVar = new d();
        createCustomDialog.setPositiveButton(R.string.f171151ok, new e(str));
        createCustomDialog.setNegativeButton(R.string.cancel, dVar);
        createCustomDialog.show();
    }

    public void Q2(int i3, int i16, View view, ViewGroup viewGroup, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), view, viewGroup, Integer.valueOf(i17));
            return;
        }
        if (i3 == 0) {
            view.setBackgroundResource(R.drawable.common_strip_setting_top);
        } else if (i3 == i16 - 1) {
            view.setBackgroundResource(R.drawable.common_strip_setting_bottom);
        } else {
            view.setBackgroundResource(R.drawable.common_strip_setting_middle);
        }
        if (i16 == 1) {
            view.setBackgroundResource(R.drawable.common_strip_setting_bg);
        }
        if (i17 == 1) {
            view.setOnClickListener(new f());
            view.setOnLongClickListener(this.G0);
        }
        viewGroup.addView(view);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else if (view.getId() == R.id.cgs) {
            R2(null, 4, null, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        super.setContentView(R.layout.acj);
        this.f276541a0 = getAppRuntime();
        Intent intent = super.getIntent();
        L2();
        N2(intent.getIntExtra("CARDMODE", 3), intent.getStringExtra("QRCARDSTR"));
        M2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.f276566z0 != null) {
            this.f276542b0 = true;
            this.F0.removeMessages(0);
        }
        ActionSheet actionSheet = this.B0;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }
}
