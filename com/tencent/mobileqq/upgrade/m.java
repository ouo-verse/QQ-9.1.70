package com.tencent.mobileqq.upgrade;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m extends ReportDialog {
    static IPatchRedirector $redirector_;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private View.OnClickListener J;
    private View.OnClickListener K;
    private View.OnClickListener L;
    private boolean M;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
            } else {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 24.0f);
            }
        }
    }

    public m(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.M = true;
        }
    }

    public static m O(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        m mVar = new m(activity);
        mVar.Y(str).U(str3).Z(str2).X(str5).S(str4, onClickListener).R(onClickListener2);
        e.e().n(str2);
        return mVar;
    }

    public static String P(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("\\|")) {
                if (Pattern.matches("\\d+\\.\\d+\\.\\d+", str2)) {
                    return "V " + str2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public m R(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (m) iPatchRedirector.redirect((short) 8, (Object) this, (Object) onClickListener);
        }
        this.L = onClickListener;
        return this;
    }

    public m S(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (m) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) onClickListener);
        }
        this.G = str;
        this.J = onClickListener;
        return this;
    }

    public m U(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.E = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.E.contains("%n")) {
                this.E = this.E.replace("%n", "\n");
            }
            if (!str.contains("\n") && !str.contains("%n")) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.M = z16;
        }
        return this;
    }

    public void W(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) onClickListener);
        } else {
            this.H = str;
            this.K = onClickListener;
        }
    }

    public m X(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (m) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.I = str;
        return this;
    }

    public m Y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        String trim = str.trim();
        if (!TextUtils.isEmpty(trim)) {
            if (trim.contains("%n")) {
                String[] split = trim.split("%n", 2);
                this.C = split[0];
                this.D = split[1];
            } else if (trim.contains("\n")) {
                String[] split2 = trim.split("\n", 2);
                this.C = split2[0];
                this.D = split2[1];
            } else {
                this.C = trim;
            }
        }
        return this;
    }

    public m Z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (m) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.F = str;
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
        setContentView(R.layout.i2y);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f114556tn);
        viewGroup.setOutlineProvider(new a());
        viewGroup.setClipToOutline(true);
        TextView textView = (TextView) viewGroup.findViewById(R.id.f114566to);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.f114576tp);
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.f114526tk);
        TextView textView4 = (TextView) viewGroup.findViewById(R.id.f114586tq);
        TextView textView5 = (TextView) viewGroup.findViewById(R.id.f114546tm);
        TextView textView6 = (TextView) viewGroup.findViewById(R.id.f114516tj);
        TextView textView7 = (TextView) viewGroup.findViewById(R.id.f114536tl);
        ImageView imageView = (ImageView) findViewById(R.id.f114506ti);
        if (this.M) {
            textView3.setGravity(8388611);
            textView5.setGravity(8388611);
        } else {
            textView3.setGravity(17);
            textView5.setGravity(17);
        }
        if (!TextUtils.isEmpty(this.F)) {
            textView4.setText(this.F);
        } else {
            textView4.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.I)) {
            textView5.setVisibility(0);
        } else {
            textView5.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.C)) {
            textView.setText(this.C);
        }
        if (!TextUtils.isEmpty(this.D)) {
            textView2.setText(this.D);
        }
        textView3.setText(this.E);
        if (!TextUtils.isEmpty(this.G)) {
            textView6.setText(this.G);
        }
        textView6.setContentDescription(this.G);
        textView6.setOnClickListener(this.J);
        if (!TextUtils.isEmpty(this.H) && this.K != null) {
            textView7.setText(this.H);
            textView7.setOnClickListener(this.K);
        } else {
            textView7.setVisibility(4);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView7.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            textView7.setLayoutParams(layoutParams);
        }
        View.OnClickListener onClickListener = this.L;
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        } else {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.this.Q(view);
                }
            });
        }
        imageView.setContentDescription(getContext().getString(R.string.f170202in));
    }
}
