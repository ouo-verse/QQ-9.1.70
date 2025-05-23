package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MyAppDialog extends ReportDialog {
    protected final WeakReference<Activity> C;
    TextView D;
    TextView E;
    TextView F;
    TextView G;
    ProgressBar H;
    TextView I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f341404d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f341405e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f341406f;

        a(DialogInterface.OnClickListener onClickListener, int i3, boolean z16) {
            this.f341404d = onClickListener;
            this.f341405e = i3;
            this.f341406f = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f341404d;
            if (onClickListener != null) {
                onClickListener.onClick(MyAppDialog.this, this.f341405e);
            }
            if (this.f341406f) {
                MyAppDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f341408d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f341409e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f341410f;

        b(DialogInterface.OnClickListener onClickListener, int i3, boolean z16) {
            this.f341408d = onClickListener;
            this.f341409e = i3;
            this.f341410f = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f341408d;
            if (onClickListener != null) {
                onClickListener.onClick(MyAppDialog.this, this.f341409e);
            }
            if (this.f341410f) {
                MyAppDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f341412d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f341413e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f341414f;

        c(DialogInterface.OnClickListener onClickListener, int i3, boolean z16) {
            this.f341412d = onClickListener;
            this.f341413e = i3;
            this.f341414f = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f341412d;
            if (onClickListener != null) {
                onClickListener.onClick(MyAppDialog.this, this.f341413e);
            }
            if (this.f341414f) {
                MyAppDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f341416d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f341417e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f341418f;

        d(DialogInterface.OnClickListener onClickListener, int i3, boolean z16) {
            this.f341416d = onClickListener;
            this.f341417e = i3;
            this.f341418f = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f341416d;
            if (onClickListener != null) {
                onClickListener.onClick(MyAppDialog.this, this.f341417e);
            }
            if (this.f341418f) {
                MyAppDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MyAppDialog(Activity activity) {
        super(activity);
        this.C = new WeakReference<>(activity);
        requestWindowFeature(1);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setAlpha(0);
        getWindow().setBackgroundDrawable(colorDrawable);
        setContentView(R.layout.f168449wg);
    }

    public Activity N() {
        Activity activity = this.C.get();
        if (activity == null) {
            return null;
        }
        return activity;
    }

    public MyAppDialog O(int i3, int i16, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(i3);
        this.F.setTextColor(i16);
        this.F.setVisibility(0);
        this.F.setOnClickListener(new b(onClickListener, i3, z16));
        return this;
    }

    public MyAppDialog P(int i3, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(i3);
        this.F.setVisibility(0);
        this.F.setOnClickListener(new a(onClickListener, i3, z16));
        return this;
    }

    public MyAppDialog Q(String str) {
        if (str != null) {
            this.E.setText(str);
        }
        return this;
    }

    public MyAppDialog R(int i3) {
        this.E.setTextColor(i3);
        return this;
    }

    public void S(Drawable drawable) {
        this.H.setProgressDrawable(drawable);
    }

    public MyAppDialog U(int i3, int i16, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.G.setVisibility(8);
            return this;
        }
        this.G.setText(i3);
        this.G.setTextColor(i16);
        this.G.setVisibility(0);
        this.G.setOnClickListener(new d(onClickListener, i3, z16));
        return this;
    }

    public MyAppDialog W(int i3, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.G.setVisibility(8);
            return this;
        }
        this.G.setText(i3);
        this.G.setVisibility(0);
        this.G.setOnClickListener(new c(onClickListener, i3, z16));
        return this;
    }

    public MyAppDialog X(String str) {
        if (str != null) {
            this.D.setText(str);
        }
        if (QQTheme.isNowThemeIsNight()) {
            this.D.setTextColor(getContext().getResources().getColor(R.color.f158017al3));
        } else {
            this.D.setTextColor(getContext().getResources().getColor(R.color.black));
        }
        return this;
    }

    public void Y(final int i3, final int i16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppDialog.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String string;
                int i17 = i3;
                com.tencent.open.base.f.a("MyAppApi", "updateView--progress--" + i17 + " state = " + i16);
                Resources resources = MyAppDialog.this.getContext().getResources();
                int i18 = i16;
                int i19 = 100;
                if (i18 != 1) {
                    if (i18 != 2) {
                        if (i18 != 3) {
                            if (i18 != 4) {
                                if (i18 != 10) {
                                    if (i18 != 20) {
                                        string = null;
                                    }
                                } else {
                                    string = resources.getString(R.string.f170841ao2);
                                }
                            } else {
                                string = resources.getString(R.string.anr);
                                i17 = 100;
                            }
                        } else {
                            string = resources.getString(R.string.f170841ao2, Integer.valueOf(i17));
                        }
                    } else {
                        string = resources.getString(R.string.anu, Integer.valueOf(i17));
                    }
                    if (i17 >= 0) {
                        i19 = 0;
                    } else if (i17 <= 100) {
                        i19 = i17;
                    }
                    if (MyAppDialog.this.H.getVisibility() != 0) {
                        MyAppDialog.this.H.setVisibility(0);
                        MyAppDialog.this.I.setVisibility(0);
                    }
                    if (i16 != 3) {
                        MyAppDialog.this.F.setVisibility(0);
                        MyAppDialog.this.F.setText((CharSequence) null);
                    } else {
                        MyAppDialog.this.F.setVisibility(4);
                    }
                    MyAppDialog.this.H.setProgress(i19);
                    MyAppDialog.this.I.setText(string);
                }
                string = resources.getString(R.string.ao_);
                if (i17 >= 0) {
                }
                if (MyAppDialog.this.H.getVisibility() != 0) {
                }
                if (i16 != 3) {
                }
                MyAppDialog.this.H.setProgress(i19);
                MyAppDialog.this.I.setText(string);
            }
        });
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.D = (TextView) findViewById(R.id.dialogTitle);
        this.E = (TextView) findViewById(R.id.dialogText);
        TextView textView = (TextView) findViewById(R.id.dialogLeftBtn);
        this.F = textView;
        textView.getPaint().setFakeBoldText(true);
        this.G = (TextView) findViewById(R.id.dialogRightBtn);
        this.H = (ProgressBar) findViewById(R.id.g1f);
        this.I = (TextView) findViewById(R.id.f166547g25);
    }
}
