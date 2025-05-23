package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.LoadingUtil;
import com.tencent.util.PermissionUtil;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DialogUtil {
    public static final int ALERT_DIALOG = 230;
    public static final int BUTTON0_ID = 0;
    public static final int BUTTON1_ID = 1;
    public static final int BUTTON2_ID = 2;
    public static final int FAIL_DIALOG = 233;
    public static final int REPORT_LOADING = 231;
    public static final int SUCCESS_DIALOG = 232;
    public static final HashMap<String, String> mPermissionWordings;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface IDialogView {
        View getView(Context context, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f306927d;

        a(QQCustomDialog qQCustomDialog) {
            this.f306927d = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f306927d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f306928d;

        b(Activity activity) {
            this.f306928d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f306928d.getPackageName(), null));
                this.f306928d.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f306929d;

        c(QQCustomDialog qQCustomDialog) {
            this.f306929d = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f306929d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f306930d;

        d(Activity activity) {
            this.f306930d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f306930d.getPackageName(), null));
                this.f306930d.startActivity(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f306931d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PermissionUtil.SDCardPermissionCallback f306932e;

        e(Activity activity, PermissionUtil.SDCardPermissionCallback sDCardPermissionCallback) {
            this.f306931d = activity;
            this.f306932e = sDCardPermissionCallback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f306931d.getPackageName(), null));
                this.f306931d.startActivity(intent);
            } else {
                PermissionUtil.SDCardPermissionCallback sDCardPermissionCallback = this.f306932e;
                if (sDCardPermissionCallback != null) {
                    sDCardPermissionCallback.reject();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f306933d;

        f(Context context) {
            this.f306933d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f306933d.getPackageName(), null));
                this.f306933d.startActivity(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f306934d;

        g(Context context) {
            this.f306934d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f306934d.getPackageName(), null));
                this.f306934d.startActivity(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f306935d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Dialog f306936e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f306937f;

        h(DialogInterface.OnClickListener onClickListener, Dialog dialog, DialogInterface.OnClickListener onClickListener2) {
            this.f306935d = onClickListener;
            this.f306936e = dialog;
            this.f306937f = onClickListener2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                if (view.getId() == R.id.bk5) {
                    DialogInterface.OnClickListener onClickListener = this.f306935d;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f306936e, 0);
                    }
                    if (this.f306936e.isShowing()) {
                        this.f306936e.dismiss();
                    }
                } else if (view.getId() == R.id.bka) {
                    DialogInterface.OnClickListener onClickListener2 = this.f306937f;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(this.f306936e, 1);
                    }
                    if (this.f306936e.isShowing()) {
                        this.f306936e.dismiss();
                    }
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f306938d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f306939e;

        i(DialogInterface.OnClickListener onClickListener, QQCustomDialog qQCustomDialog) {
            this.f306938d = onClickListener;
            this.f306939e = qQCustomDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f306938d.onClick(this.f306939e, 2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f306940d;

        j(QQCustomDialog qQCustomDialog) {
            this.f306940d = qQCustomDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomDialog qQCustomDialog = this.f306940d;
            if (qQCustomDialog != null) {
                qQCustomDialog.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class k implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f306941d;

        k(Activity activity) {
            this.f306941d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f306941d.getPackageName(), null));
                this.f306941d.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f306942d;

        l(Activity activity) {
            this.f306942d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f306942d.getPackageName(), null));
                this.f306942d.startActivity(intent);
            }
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        mPermissionWordings = hashMap;
        hashMap.put(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, HardCodeUtil.qqStr(R.string.lly));
        hashMap.put(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, HardCodeUtil.qqStr(R.string.lmc));
        hashMap.put(DeviceInfoUtil.PERMISSION_READ_PHONE, "QQ\u4f7f\u7528\u7535\u8bdd\u6743\u9650\u786e\u5b9a\u672c\u673a\u53f7\u7801\u548c\u8bbe\u5907ID\uff0c\u4ee5\u4fdd\u8bc1\u8d26\u53f7\u767b\u5f55\u7684\u5b89\u5168\u6027\u3002QQ\u4e0d\u4f1a\u62e8\u6253\u5176\u4ed6\u53f7\u7801\u6216\u7ec8\u6b62\u901a\u8bdd\u3002\n" + HardCodeUtil.qqStr(R.string.llk));
        hashMap.put(QQPermissionConstants.Permission.CAMERA, HardCodeUtil.qqStr(R.string.lmo));
        hashMap.put(QQPermissionConstants.Permission.RECORD_AUDIO, HardCodeUtil.qqStr(R.string.llw));
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", HardCodeUtil.qqStr(R.string.llr));
        hashMap.put("android.permission.ACCESS_FINE_LOCATION", HardCodeUtil.qqStr(R.string.llx));
        hashMap.put("android.permission.READ_CALENDAR", HardCodeUtil.qqStr(R.string.f171885ln4));
        hashMap.put(QQPermissionConstants.Permission.WRITE_CALENDAR, HardCodeUtil.qqStr(R.string.f171883ln2));
        hashMap.put(QQPermissionConstants.Permission.SEND_SMS, HardCodeUtil.qqStr(R.string.lmq));
        hashMap.put(QQPermissionConstants.Permission.READ_CONTACTS, HardCodeUtil.qqStr(R.string.lmf));
        hashMap.put(QQPermissionConstants.Permission.WRITE_CONTACTS, HardCodeUtil.qqStr(R.string.lmx));
    }

    public static QQCustomDialog createCenterTextDialog(Context context, int i3, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(str3, onClickListener2);
        qQCustomDialog.setPositiveButton(str4, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        TextView textView = (TextView) qQCustomDialog.findViewById(R.id.dialogText);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        return qQCustomDialog;
    }

    public static Dialog createContentClickableDialog(Context context, String str, CharSequence charSequence, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, ClickableColorSpanTextView.a aVar) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.atf);
        TextView textView = (TextView) reportDialog.findViewById(R.id.bkh);
        ClickableColorSpanTextView clickableColorSpanTextView = (ClickableColorSpanTextView) reportDialog.findViewById(R.id.bk8);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.bk5);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.bka);
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        clickableColorSpanTextView.setText(charSequence);
        clickableColorSpanTextView.setMovementMethod(LinkMovementMethod.getInstance());
        if (i3 == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(i3);
        }
        if (i16 == 0) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(i16);
        }
        h hVar = new h(onClickListener, reportDialog, onClickListener2);
        textView2.setOnClickListener(hVar);
        textView3.setOnClickListener(hVar);
        clickableColorSpanTextView.setSpanClickListener(aVar);
        return reportDialog;
    }

    public static Dialog createContentOnlyDialog(Context context, String str, int i3, int i16, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.getWindow().setWindowAnimations(R.style.f173401cf);
        reportDialog.setContentView(R.layout.atf);
        ((TextView) reportDialog.findViewById(R.id.bkh)).setVisibility(8);
        TextView textView = (TextView) reportDialog.findViewById(R.id.bk8);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.bk5);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.bka);
        textView.setText(str);
        textView.setGravity(3);
        if (i3 == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(i3);
        }
        textView3.setText(i16);
        textView2.setOnClickListener(onClickListener);
        textView3.setOnClickListener(onClickListener2);
        return reportDialog;
    }

    public static QQCustomDialog createCountdownDialog(Context context, String str, CharSequence charSequence, String str2, String str3, boolean z16, int i3, int i16, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.azf, i3, i16, str2, str3, z16) { // from class: com.tencent.mobileqq.utils.DialogUtil.4
            private Handler C = new Handler(Looper.getMainLooper());
            private int D;
            private String E;
            final /* synthetic */ int F;
            final /* synthetic */ int G;
            final /* synthetic */ String H;
            final /* synthetic */ String I;
            final /* synthetic */ boolean J;

            {
                this.F = i3;
                this.G = i16;
                this.H = str2;
                this.I = str3;
                this.J = z16;
                this.D = i3;
                this.E = i16 != 0 ? str3 : str2;
            }

            private Runnable Q() {
                return new Runnable() { // from class: com.tencent.mobileqq.utils.DialogUtil.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        anonymousClass4.D--;
                        R(this);
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void R(Runnable runnable) {
                TextView textView;
                if (this.G == 0) {
                    textView = this.lBtn;
                } else {
                    textView = this.rBtn;
                }
                int i17 = this.D;
                if (i17 > 0) {
                    textView.setText(String.format("%s(%ds)", this.E, Integer.valueOf(i17)));
                    this.C.postDelayed(runnable, 1000L);
                } else {
                    textView.setText(this.E);
                    this.D = this.F;
                    textView.setEnabled(true);
                }
            }

            @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
            public void dismiss() {
                super.dismiss();
                this.C.removeCallbacksAndMessages(null);
            }

            @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
            public void show() {
                TextView textView;
                int i17;
                super.show();
                if (this.G == 0) {
                    textView = this.lBtn;
                } else {
                    textView = this.rBtn;
                }
                if (this.J && (i17 = this.D) > 0) {
                    textView.setText(String.format("%s(%ds)", this.E, Integer.valueOf(i17)));
                    textView.setEnabled(false);
                    this.C.postDelayed(Q(), 1000L);
                }
            }

            @Override // android.app.Dialog
            public void onBackPressed() {
            }
        };
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(charSequence);
        qQCustomDialog.title.setTypeface(Typeface.DEFAULT_BOLD);
        qQCustomDialog.rBtn.setTypeface(Typeface.DEFAULT_BOLD);
        qQCustomDialog.lBtn.setTypeface(Typeface.DEFAULT_BOLD);
        if (i16 == 0) {
            qQCustomDialog.lBtn.setTextColor(context.getResources().getColorStateList(R.color.countdown_dialog_btn_text_selector));
        } else {
            qQCustomDialog.rBtn.setTextColor(context.getResources().getColorStateList(R.color.countdown_dialog_btn_text_selector));
        }
        qQCustomDialog.lBtn.setText(str2);
        qQCustomDialog.lBtn.setVisibility(0);
        qQCustomDialog.lBtn.setOnClickListener(onClickListener);
        qQCustomDialog.rBtn.setVisibility(0);
        qQCustomDialog.rBtn.setText(str3);
        qQCustomDialog.rBtn.setOnClickListener(onClickListener2);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomCloseDialog(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167834j4);
        TextView textView = (TextView) qQCustomDialog.findViewById(R.id.dialogTitle);
        TextView textView2 = (TextView) qQCustomDialog.findViewById(R.id.dialogText);
        ImageView imageView = (ImageView) qQCustomDialog.findViewById(R.id.close);
        textView.setText(str);
        textView2.setText(str2);
        qQCustomDialog.setNegativeButton(str3, onClickListener);
        qQCustomDialog.setPositiveButton(str4, onClickListener2);
        imageView.setOnClickListener(onClickListener3);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        return qQCustomDialog;
    }

    public static ct createCustomContextMenuDialog(Context context, com.tencent.mobileqq.utils.dialogutils.a aVar, DialogInterface.OnClickListener onClickListener) {
        if (aVar != null && aVar.h() > 0) {
            ct ctVar = new ct(context, R.style.qZoneInputDialog);
            ctVar.setCanceledOnTouchOutside(true);
            ctVar.setContentView(R.layout.f167856jn);
            ctVar.O(aVar, onClickListener);
            ctVar.N(R.layout.f167844jd);
            ((LinearLayout) ctVar.findViewById(R.id.aew)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
            ListView listView = (ListView) ctVar.findViewById(R.id.eap);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id.dialogTitle);
            listView.setLayoutParams(layoutParams);
            return ctVar;
        }
        return null;
    }

    public static QQCustomDialog createCustomDialog(Context context, int i3) {
        return createCustomDialog(context, i3, (String) null, (String) null, R.string.cancel, R.string.f171151ok, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
    }

    public static QQCustomDialog createCustomDialogUrl(Context context, int i3) {
        return createCustomDialogUrl(context, i3, null, null, R.string.cancel, R.string.f171151ok, null, null);
    }

    public static QQCustomDialog createCustomDialogUrlWithoutAutoLink(Context context, int i3, int i16, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(i16);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessageWithoutAutoLink(charSequence);
        qQCustomDialog.setNegativeButton(str2, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(true);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomProgressDialog(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167853jk);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setNegativeButton(str2, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static QQCustomDialogThreeBtns createCustomThreeBtnsDialog(Context context, int i3) {
        return createCustomThreeBtnsDialog(context, i3, null, null, "", "", "", null, null, null);
    }

    public static Dialog createCustomViewDialog(Context context, int i3, IDialogView iDialogView, Object obj, int i16, int i17, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2, boolean z16, boolean z17) {
        Resources resources = context.getResources();
        String string = resources.getString(i16);
        String string2 = resources.getString(i17);
        final ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167860js);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        FrameLayout frameLayout = (FrameLayout) reportDialog.findViewById(R.id.bjj);
        if (i3 <= 0) {
            ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = 0;
            textView.setVisibility(8);
            textView.requestLayout();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
            int i18 = ((int) resources.getDisplayMetrics().density) * 18;
            marginLayoutParams.topMargin = i18;
            marginLayoutParams.bottomMargin = i18;
            frameLayout.requestLayout();
        } else {
            String string3 = resources.getString(i3);
            if (textView != null) {
                textView.setText(string3);
                textView.setContentDescription(string3);
            }
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        if (textView2 != null) {
            textView2.setText(string);
            textView2.setContentDescription(string);
            if (onClickListener != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.utils.ai
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogUtil.lambda$createCustomViewDialog$0(onClickListener, reportDialog, view);
                    }
                });
            }
            if (z16) {
                textView2.getPaint().setFakeBoldText(true);
            }
        }
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        if (textView3 != null) {
            textView3.setText(string2);
            textView3.setContentDescription(string2);
            if (onClickListener2 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.utils.aj
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogUtil.lambda$createCustomViewDialog$1(onClickListener2, reportDialog, view);
                    }
                });
            }
            if (z17) {
                textView3.getPaint().setFakeBoldText(true);
            }
        }
        frameLayout.addView(iDialogView.getView(frameLayout.getContext(), obj));
        return reportDialog;
    }

    public static QQCustomDialog createDialogInGroupTeamWork(Context context, int i3, String str, String str2, String str3, String str4, String str5, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167838j8);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(str4, onClickListener3);
        qQCustomDialog.setPositiveButton(str5, onClickListener2);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCheckBox(str3, onClickListener);
        return qQCustomDialog;
    }

    public static QQCustomDialog createDialogWithBanner(Context context, int i3, int i16, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = createCustomDialog(context, i3, str, charSequence, str2, str3, onClickListener, onClickListener2);
        createCustomDialog.setBannerDrawable(i16);
        return createCustomDialog;
    }

    public static QQCustomDialog createDialogWithCheckBox(Context context, int i3, String str, String str2, String str3, boolean z16, String str4, String str5, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        QQCustomDialog createCustomDialog = createCustomDialog(context, i3, str, str2, str4, str5, onClickListener2, onClickListener3);
        createCustomDialog.setCheckBox(str3, z16, onClickListener);
        return createCustomDialog;
    }

    public static Dialog createDialogWithIcon(Context context, Bitmap bitmap, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167865jx);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.icon);
        TextView textView = (TextView) reportDialog.findViewById(R.id.title);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.content);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.cancel);
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.b7m);
        if (bitmap == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageBitmap(bitmap);
        }
        if (str2 == null) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        textView.setText(str);
        if (onClickListener == null) {
            textView3.setVisibility(8);
        } else {
            textView3.setOnClickListener(onClickListener);
            textView3.setText(str3);
        }
        if (onClickListener2 == null) {
            textView4.setVisibility(8);
        } else {
            textView4.setOnClickListener(onClickListener2);
            textView4.setText(str4);
        }
        reportDialog.setCanceledOnTouchOutside(false);
        return reportDialog;
    }

    public static Dialog createDialogWithIcon2(Context context, Drawable drawable, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167866jy);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.icon);
        TextView textView = (TextView) reportDialog.findViewById(R.id.title);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.content);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.cancel);
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.b7m);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (str2 == null) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        textView.setText(str);
        if (onClickListener2 == null) {
            textView3.setVisibility(8);
        } else {
            textView3.setOnClickListener(onClickListener2);
            textView3.setText(str3);
        }
        if (onClickListener == null) {
            textView4.setVisibility(8);
        } else {
            textView4.setOnClickListener(onClickListener);
            textView4.setText(str4);
        }
        reportDialog.setCanceledOnTouchOutside(false);
        return reportDialog;
    }

    public static QQCustomDialog createDisclaimerDialog(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 0, str, str2, null, null);
        if (createCustomDialog.getTitleTextView() != null) {
            createCustomDialog.getTitleTextView().getPaint().setFakeBoldText(true);
        }
        if (createCustomDialog.getBtnight() != null) {
            createCustomDialog.getBtnight().getPaint().setFakeBoldText(true);
        }
        createCustomDialog.setPositiveButton(str3, onClickListener);
        createCustomDialog.setCancelable(true);
        createCustomDialog.setCanceledOnTouchOutside(true);
        return createCustomDialog;
    }

    public static Dialog createDownloadDialog(Context context, Drawable drawable, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.qfile_file_ufdownload);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.khs);
        TextView textView = (TextView) reportDialog.findViewById(R.id.kht);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.khu);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.kho);
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.khp);
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(drawable);
        }
        if (str2 == null) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        textView.setText(str);
        if (onClickListener == null) {
            textView3.setVisibility(8);
        } else {
            textView3.setOnClickListener(onClickListener);
            textView3.setText(str3);
        }
        if (onClickListener2 == null) {
            textView4.setVisibility(8);
        } else {
            textView4.setOnClickListener(onClickListener2);
            textView4.setText(str4);
        }
        reportDialog.setCanceledOnTouchOutside(false);
        return reportDialog;
    }

    public static Dialog createFileInfoDialog(Context context, Drawable drawable, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167871k5);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.khs);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.kht);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.khu);
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.kho);
        TextView textView5 = (TextView) reportDialog.findViewById(R.id.khp);
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(drawable);
        }
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        if (str3 == null) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(str3);
        }
        textView2.setText(str2);
        if (onClickListener == null) {
            textView4.setVisibility(8);
        } else {
            textView4.setOnClickListener(onClickListener);
            textView4.setText(str4);
        }
        if (onClickListener2 == null) {
            textView5.setVisibility(8);
        } else {
            textView5.setOnClickListener(onClickListener2);
            textView5.setText(str5);
        }
        reportDialog.setCanceledOnTouchOutside(false);
        return reportDialog;
    }

    public static QQCustomDialog createForceDialog(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(charSequence);
        qQCustomDialog.setNegativeButton(str2, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        return qQCustomDialog;
    }

    public static Dialog createGPSEnableDialog(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Dialog a16 = com.tencent.mobileqq.util.t.a(activity, R.string.f4q, R.string.f4o, R.string.f4n, R.string.f4p, onClickListener, onClickListener2);
        a16.setCancelable(false);
        return a16;
    }

    public static QQCustomDialog createNoTitleDialog(Activity activity, String str) {
        return createNoTitleDialog(activity, str, R.string.cancel, R.string.f171151ok, null, null);
    }

    public static QQCustomDialog createPrivacyPolicyDialog(Context context, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setUpdateTextColor(false);
        qQCustomDialog.setContentView(R.layout.f167852e55);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(i16, onClickListener2);
        qQCustomDialog.setPositiveButton(i3, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static Dialog createTipDialog(Context context, int i3, String str, int i16, int i17, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        return createTipDialog(context, i3, str, i16, i17, onClickListener, onClickListener2, false, false);
    }

    public static QQCustomDialog createVerticalThreeBtnDialog(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return createVerticalThreeBtnDialog(context, i3, str, charSequence, str2, str3, str4, onClickListener, onClickListener2, null);
    }

    public static Dialog createWaitingDialog(Activity activity, int i3) {
        ReportDialog reportDialog = new ReportDialog(activity, R.style.azd);
        reportDialog.setContentView(R.layout.h19);
        ((TextView) reportDialog.findViewById(R.id.f61882zb)).setText(activity.getString(i3));
        reportDialog.setCancelable(true);
        reportDialog.setCanceledOnTouchOutside(false);
        return reportDialog;
    }

    public static String getPermissionWording(String... strArr) {
        String qqStr = HardCodeUtil.qqStr(R.string.lml);
        String str = null;
        if (strArr != null) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : strArr) {
                if (QQPermissionConstants.Permission.CAMERA.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.llp);
                } else if (QQPermissionConstants.Permission.RECORD_AUDIO.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.f171880lm4);
                } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.llt);
                } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.lma);
                } else if ("android.permission.READ_CALENDAR".equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.lmm);
                } else if (QQPermissionConstants.Permission.WRITE_CALENDAR.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.lms);
                } else if (QQPermissionConstants.Permission.SEND_SMS.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.lln);
                } else if (QQPermissionConstants.Permission.READ_CONTACTS.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.llu);
                } else if (QQPermissionConstants.Permission.WRITE_CONTACTS.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.lmv);
                } else if (QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.w5m);
                } else if (QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.w5k);
                }
                if (str != null && sb5.indexOf(str) < 0) {
                    if (sb5.length() > 0) {
                        sb5.append("\u548c");
                    }
                    sb5.append(str);
                }
            }
            str = sb5.toString();
        }
        return String.format(qqStr, str);
    }

    static int[] integerListToArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int[] iArr = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createCustomViewDialog$0(DialogInterface.OnClickListener onClickListener, Dialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onClickListener.onClick(dialog, -2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createCustomViewDialog$1(DialogInterface.OnClickListener onClickListener, Dialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onClickListener.onClick(dialog, -1);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static Dialog showLoadingDialog(Context context, String str, boolean z16) {
        return LoadingUtil.showLoadingDialog(context, str, z16);
    }

    public static QQCustomDialog showPermissionDialogForOnlineStatusLocation(Activity activity, int i3, int i16) {
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 230);
        createCustomDialog.setTitle(activity.getString(i16));
        createCustomDialog.setMessage(i3);
        createCustomDialog.setNegativeButton(activity.getString(R.string.cancel), new c(createCustomDialog));
        createCustomDialog.setPositiveButton(activity.getString(R.string.hhb), new d(activity));
        createCustomDialog.setOnCancelListener(null);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static QQCustomDialog showPermissionDialogForShareLocation(Activity activity) {
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 230);
        createCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.llm));
        createCustomDialog.setMessage(R.string.f171096it4);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new a(createCustomDialog));
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.u4x), new b(activity));
        createCustomDialog.setOnCancelListener(null);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static QQCustomDialog showPermissionDialogForStorage(Context context) {
        f fVar = new f(context);
        QQCustomDialog createCustomDialog = createCustomDialog(context, 230);
        createCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.qo_));
        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.f214885u4));
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), fVar);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f214865u2), fVar);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static QQCustomDialog showPermissionDialogForStorageWithCallback(Activity activity, PermissionUtil.SDCardPermissionCallback sDCardPermissionCallback) {
        e eVar = new e(activity, sDCardPermissionCallback);
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 230);
        createCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.qo_));
        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.f214885u4));
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), eVar);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f214865u2), eVar);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static QQCustomDialog showPermissionSettingDialog(Activity activity, String str, String str2) {
        l lVar = new l(activity);
        return showPermissionSettingDialog(activity, str, str2, lVar, lVar, null);
    }

    public static QQCustomDialog showPermissionSettingDialog2(Activity activity, List<String> list, List<Integer> list2) {
        if (list == null || list2 == null || list.isEmpty() || list.size() != list2.size()) {
            return null;
        }
        return showPermissionSettingDialog2(activity, (String[]) list.toArray(new String[0]), integerListToArray(list2));
    }

    public static ProgressDialog showProgressDialog(Context context, int i3) {
        return showProgressDialog(context, context.getResources().getDrawable(R.drawable.sc_publish_spinner_temp), i3);
    }

    public static QQCustomDialog showSlideAcceptDialog(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 230);
        if (str == null || str.equals("")) {
            str = activity.getResources().getString(R.string.d_o);
        }
        createCustomDialog.setTitle(str);
        if (str2 == null || str2.equals("")) {
            str2 = activity.getResources().getString(R.string.d_l);
        }
        createCustomDialog.setMessage(str2);
        createCustomDialog.setNegativeButton(activity.getResources().getString(R.string.cancel), onClickListener);
        createCustomDialog.setPositiveButton(activity.getResources().getString(R.string.f171151ok), onClickListener2);
        createCustomDialog.setOnCancelListener(onCancelListener);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static QQCustomDialog showWriteSetting(Activity activity, String str, String str2) {
        k kVar = new k(activity);
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 230);
        if (str == null || str.equals("")) {
            str = HardCodeUtil.qqStr(R.string.llq);
        }
        createCustomDialog.setTitle(str);
        if (str2 == null || str2.equals("")) {
            str2 = HardCodeUtil.qqStr(R.string.ln5);
        }
        createCustomDialog.setMessage(str2);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.ln8), kVar);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static QQCustomDialog createCustomDialog(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(i16, onClickListener2);
        qQCustomDialog.setPositiveButton(i17, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomDialogUrl(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessageWithUrl(str2);
        qQCustomDialog.setNegativeButton(i16, onClickListener2);
        qQCustomDialog.setPositiveButton(i17, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(true);
        return qQCustomDialog;
    }

    public static QQCustomDialogThreeBtns createCustomThreeBtnsDialog(Context context, int i3, String str, String str2, String str3, String str4, String str5, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        QQCustomDialogThreeBtns qQCustomDialogThreeBtns = new QQCustomDialogThreeBtns(context, R.style.qZoneInputDialog);
        qQCustomDialogThreeBtns.setContentView(R.layout.custom_dialog_treebtns);
        qQCustomDialogThreeBtns.setTitle(str);
        qQCustomDialogThreeBtns.setMessage(str2);
        qQCustomDialogThreeBtns.setLeftButton(str4, onClickListener);
        qQCustomDialogThreeBtns.setMiddleButton(str5, onClickListener2);
        qQCustomDialogThreeBtns.setMiddleButton(str4, onClickListener3);
        qQCustomDialogThreeBtns.setCanceledOnTouchOutside(true);
        return qQCustomDialogThreeBtns;
    }

    public static QQCustomDialog createNoTitleDialog(Activity activity, int i3) {
        return createNoTitleDialog(activity, activity.getString(i3), R.string.cancel, R.string.f171151ok, null, null);
    }

    public static Dialog createTipDialog(Context context, int i3, String str, int i16, int i17, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, boolean z16, boolean z17) {
        Resources resources = context.getResources();
        String string = resources.getString(i16);
        String string2 = resources.getString(i17);
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.custom_dialog);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogText);
        if (i3 <= 0) {
            ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = 0;
            textView.setVisibility(8);
            textView.requestLayout();
            if (textView2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                int i18 = ((int) resources.getDisplayMetrics().density) * 18;
                marginLayoutParams.topMargin = i18;
                marginLayoutParams.bottomMargin = i18;
                textView2.requestLayout();
            }
        } else {
            String string3 = resources.getString(i3);
            if (textView != null) {
                textView.setText(string3);
                textView.setContentDescription(string3);
            }
        }
        if (textView2 != null) {
            textView2.setText(str != null ? str : "");
            if (str == null) {
                str = "";
            }
            textView2.setContentDescription(str);
        }
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        if (textView3 != null) {
            textView3.setText(string);
            textView3.setContentDescription(string);
            textView3.setOnClickListener(onClickListener);
            if (z16) {
                textView3.getPaint().setFakeBoldText(true);
            }
        }
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        if (textView4 != null) {
            textView4.setText(string2);
            textView4.setContentDescription(string2);
            textView4.setOnClickListener(onClickListener2);
            if (z17) {
                textView4.getPaint().setFakeBoldText(true);
            }
        }
        return reportDialog;
    }

    public static QQCustomDialog createVerticalThreeBtnDialog(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167859jr);
        if (i3 != 0) {
            qQCustomDialog.setOperateImage(context.getResources().getDrawable(i3));
        } else {
            qQCustomDialog.setTitle(str);
        }
        qQCustomDialog.setMessage(charSequence);
        qQCustomDialog.setNegativeButton(str2, onClickListener);
        qQCustomDialog.setPositiveButton(str3, onClickListener2);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        TextView textView = (TextView) qQCustomDialog.findViewById(R.id.biv);
        if (str4 == null) {
            str4 = HardCodeUtil.qqStr(R.string.j6l);
        }
        textView.setText(str4);
        if (onClickListener3 != null) {
            textView.setOnClickListener(new i(onClickListener3, qQCustomDialog));
        } else {
            textView.setOnClickListener(new j(qQCustomDialog));
        }
        return qQCustomDialog;
    }

    public static QQCustomDialog createDialogWithBanner(Context context, int i3, String str, String str2, CharSequence charSequence, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = createCustomDialog(context, i3, str2, charSequence, str3, str4, onClickListener, onClickListener2);
        createCustomDialog.setBannerDrawable(str);
        return createCustomDialog;
    }

    public static QQCustomDialog createNoTitleDialog(Activity activity, String str, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 230, (String) null, str, i3, i16, onClickListener, onClickListener2);
        if (createCustomDialog != null) {
            ((TextView) createCustomDialog.findViewById(R.id.bit)).setVisibility(8);
            ((TextView) createCustomDialog.findViewById(R.id.dialogText)).setMinHeight(com.tencent.mobileqq.util.x.c(activity, 35.0f));
        }
        return createCustomDialog;
    }

    public static QQCustomDialog showPermissionSettingDialog(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        QQCustomDialog createCustomDialog = createCustomDialog(activity, 230);
        if (str == null || str.equals("")) {
            str = HardCodeUtil.qqStr(R.string.llm);
        }
        createCustomDialog.setTitle(str);
        if (str2 == null || str2.equals("")) {
            str2 = HardCodeUtil.qqStr(R.string.lmn);
        }
        createCustomDialog.setMessage(str2);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), onClickListener);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f171877lm1), onClickListener2);
        createCustomDialog.setOnCancelListener(onCancelListener);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static ProgressDialog showProgressDialog(Context context, Drawable drawable, int i3) {
        return showProgressDialog(context, drawable, i3, 0);
    }

    public static ProgressDialog showProgressDialog(Context context, Drawable drawable, int i3, int i16) {
        if (i16 <= 0) {
            i16 = R.style.qZoneInputDialog;
        }
        ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context, i16);
        try {
            reportProgressDialog.show();
        } catch (Exception unused) {
        }
        reportProgressDialog.getWindow().setContentView(R.layout.account_wait);
        reportProgressDialog.setContentView(R.layout.account_wait);
        ((TextView) reportProgressDialog.findViewById(R.id.dialogText)).setText(i3);
        ((ProgressBar) reportProgressDialog.findViewById(R.id.cib)).setIndeterminateDrawable(drawable);
        return reportProgressDialog;
    }

    public static QQCustomDialog showPermissionSettingDialog2(Activity activity, String[] strArr, int[] iArr) {
        String permissionWording;
        if (strArr == null) {
            return null;
        }
        try {
            if (strArr.length == 1) {
                permissionWording = getPermissionWording(strArr[0]);
            } else {
                String str = null;
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    if (iArr[i3] != 0) {
                        str = str != null ? str + "#" + strArr[i3] : strArr[i3];
                    }
                }
                permissionWording = str != null ? getPermissionWording(str.split("#")) : null;
            }
            return showPermissionSettingDialog(activity, null, permissionWording);
        } catch (Exception unused) {
            return null;
        }
    }

    public static QQCustomDialog createCustomDialogUrlWithoutAutoLink(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return createCustomDialogUrlWithoutAutoLink(context, i3, R.layout.f167856jn, str, charSequence, str2, str3, onClickListener, onClickListener2);
    }

    public static QQCustomDialog showPermissionDialogForStorage(Context context, String str) {
        g gVar = new g(context);
        QQCustomDialog createCustomDialog = createCustomDialog(context, 230);
        createCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.qo_));
        createCustomDialog.setMessage(str);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), gVar);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f214865u2), gVar);
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static QQCustomDialog createCustomDialog(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(charSequence);
        qQCustomDialog.setNegativeButton(str2, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomDialogUrlWithoutAutoLink(Context context, int i3, int i16, String str, CharSequence charSequence, int i17, int i18, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(i16);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessageWithoutAutoLink(charSequence);
        qQCustomDialog.setNegativeButton(i17, onClickListener2);
        qQCustomDialog.setPositiveButton(i18, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(true);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomDialog(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(charSequence);
        qQCustomDialog.setNegativeButton(str2, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.setOnDismissListener(onDismissListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomDialogUrlWithoutAutoLink(Context context, int i3, String str, CharSequence charSequence, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return createCustomDialogUrlWithoutAutoLink(context, i3, R.layout.f167856jn, str, charSequence, i16, i17, onClickListener, onClickListener2);
    }

    public static QQCustomDialog createCustomDialog(Context context, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(charSequence);
        qQCustomDialog.setNegativeButton(str2, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.title.setTypeface(Typeface.DEFAULT_BOLD);
        qQCustomDialog.rBtn.setTypeface(Typeface.DEFAULT_BOLD);
        qQCustomDialog.lBtn.setTypeface(Typeface.DEFAULT_BOLD);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomDialog(Context context, int i3, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return createCustomDialog(context, i3, str, str2, R.string.cancel, R.string.f171151ok, onClickListener, onClickListener2);
    }

    public static QQCustomDialog createCustomDialog(Context context, String str, String str2, String str3, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = createCustomDialog(context, 230, str, str2, i3, i16, onClickListener, onClickListener2);
        createCustomDialog.setEditLint(str3);
        return createCustomDialog;
    }

    public static QQCustomDialog createCustomDialog(Context context, int i3, String str, String str2, String str3, String str4, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(str3, onClickListener2);
        qQCustomDialog.setPositiveButton(str4, i16, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static QQCustomDialog createCustomDialog(Context context, int i3, int i16, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(i16);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(str3, onClickListener2);
        qQCustomDialog.setPositiveButton(str4, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class DialogOnClickAdapter implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
