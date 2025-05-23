package com.tencent.mobileqq.Doraemon.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends ReportDialog {
    static IPatchRedirector $redirector_;
    public static boolean L;
    public static final DownloadParams.DecodeHandler M;
    private Context C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class ViewOnClickListenerC7088a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f154269d;

        ViewOnClickListenerC7088a(View.OnClickListener onClickListener) {
            this.f154269d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!NetworkUtil.isNetSupport(a.this.C)) {
                QQToast.makeText(a.this.C, a.this.C.getString(R.string.f171137ci2), 0).show();
            } else {
                View.OnClickListener onClickListener = this.f154269d;
                if (onClickListener == null) {
                    QLog.e("SdkAuthDialog", 1, "positiveListener is null");
                } else {
                    onClickListener.onClick(view);
                    ReportController.o(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f154271d;

        b(View.OnClickListener onClickListener) {
            this.f154271d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                View.OnClickListener onClickListener = this.f154271d;
                if (onClickListener == null) {
                    QLog.e("SdkAuthDialog", 1, "negativeListener is null");
                } else {
                    onClickListener.onClick(view);
                    ReportController.o(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "2", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnCancelListener f154273d;

        c(DialogInterface.OnCancelListener onCancelListener) {
            this.f154273d = onCancelListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) onCancelListener);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            DialogInterface.OnCancelListener onCancelListener = this.f154273d;
            if (onCancelListener == null) {
                QLog.e("SdkAuthDialog", 1, "cancelListener is null");
            } else {
                onCancelListener.onCancel(dialogInterface);
                ReportController.o(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnCancelListener f154275d;

        d(DialogInterface.OnCancelListener onCancelListener) {
            this.f154275d = onCancelListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) onCancelListener);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4 && keyEvent.getAction() == 1) {
                DialogInterface.OnCancelListener onCancelListener = this.f154275d;
                if (onCancelListener == null) {
                    QLog.e("SdkAuthDialog", 1, "keyListener is null");
                    return true;
                }
                onCancelListener.onCancel(dialogInterface);
                a.this.P();
                ReportController.o(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    bitmap = BaseImageUtil.getRoundedCornerBitmap3(bitmap, iArr[2], iArr[0], iArr[1]);
                    if (bitmap == null && QLog.isDevelopLevel()) {
                        QLog.w("SdkAuthDialog", 2, "ROUND_CORNER_DECODER bitmap == null");
                    }
                }
            }
            return bitmap;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            L = false;
            M = new e();
        }
    }

    public a(Context context) {
        super(context, R.style.f173533fj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            Q(context);
        }
    }

    private void Q(Context context) {
        this.C = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168354to, (ViewGroup) null);
        setContentView(inflate);
        this.D = (ImageView) N(inflate, R.id.f164379vi);
        this.E = (TextView) N(inflate, R.id.f164389w0);
        this.F = (TextView) N(inflate, R.id.a19);
        this.G = (ImageView) N(inflate, R.id.klf);
        this.H = (TextView) N(inflate, R.id.km_);
        TextView textView = (TextView) N(inflate, R.id.a0z);
        this.I = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.J = (TextView) N(inflate, R.id.e7d);
        this.K = (TextView) N(inflate, R.id.i_w);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
    }

    public <T extends View> T N(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (T) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, i3);
        }
        return (T) view.findViewById(i3);
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            super.dismiss();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (HttpUtil.isValidUrl(str)) {
            URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
            ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
            drawable.setTag(new int[]{layoutParams.width, layoutParams.height, Utils.n(5.0f, this.C.getResources())});
            drawable.setDecodeHandler(M);
            this.D.setImageDrawable(drawable);
        }
    }

    public void S(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.E.setText(str);
        }
    }

    public void U(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.I.setText(str);
        }
    }

    public void W(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.F.setText(str);
        }
    }

    public void X(DialogInterface.OnCancelListener onCancelListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onCancelListener);
        } else {
            setOnCancelListener(new c(onCancelListener));
            setOnKeyListener(new d(onCancelListener));
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onClickListener);
        } else {
            this.J.setOnClickListener(new b(onClickListener));
        }
    }

    public void Z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.J.setText(str);
        }
    }

    public void a0(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onClickListener);
        } else {
            this.K.setOnClickListener(new ViewOnClickListenerC7088a(onClickListener));
        }
    }

    public void b0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.K.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        try {
            super.show();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
