package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.ba;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.sign.b;
import com.tencent.mobileqq.richstatus.topic.c;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.widget.bo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BaseSignViewHolder implements com.tencent.mobileqq.richstatus.sign.b, ITopic.OnTopicClickListener, ETTextView.d, View.OnClickListener, ViewTreeObserver.OnPreDrawListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name */
    static int[] f282380f0;
    ImageView C;
    public ETTextView D;
    View E;
    View F;
    View G;
    View H;
    int I;
    Context J;
    RichStatus K;
    SignatureTemplateInfo L;
    public int M;
    AppInterface N;
    public String P;
    int Q;
    VasRes R;
    VasResDrawable S;
    protected int T;
    protected int U;
    long V;
    boolean W;
    boolean X;
    boolean Y;
    boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    WeakReference<b.a> f282381a0;

    /* renamed from: b0, reason: collision with root package name */
    WeakReference<ITopic.OnTopicClickListener> f282382b0;

    /* renamed from: c0, reason: collision with root package name */
    private VasResDrawable.RefreshListener f282383c0;

    /* renamed from: d, reason: collision with root package name */
    BoxShadowLayout f282384d;

    /* renamed from: d0, reason: collision with root package name */
    public Observer f282385d0;

    /* renamed from: e, reason: collision with root package name */
    LinearLayout f282386e;

    /* renamed from: e0, reason: collision with root package name */
    Runnable f282387e0;

    /* renamed from: f, reason: collision with root package name */
    View f282388f;

    /* renamed from: h, reason: collision with root package name */
    SingleLineTextView f282389h;

    /* renamed from: i, reason: collision with root package name */
    SingleLineTextView f282390i;

    /* renamed from: m, reason: collision with root package name */
    ImageView f282391m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements VasResDrawable.RefreshListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseSignViewHolder.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.RefreshListener
        public void downloadDone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.RefreshListener
        public void refresh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                BaseSignViewHolder.this.n();
                BaseSignViewHolder.this.r();
            }
        }

        @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.RefreshListener
        public void reload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Observer {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseSignViewHolder.this);
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            SignatureTemplateInfo j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
                return;
            }
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 3 && (j3 = BaseSignViewHolder.this.j()) != null && !j3.isParsing.get()) {
                BaseSignViewHolder baseSignViewHolder = BaseSignViewHolder.this;
                if (baseSignViewHolder.X && baseSignViewHolder.K != null && !baseSignViewHolder.Y && !baseSignViewHolder.Z) {
                    if (QLog.isColorLevel()) {
                        QLog.i("BaseSignViewHolder", 2, "update tplId=" + BaseSignViewHolder.this.K.tplId);
                    }
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(BaseSignViewHolder.this.f282387e0);
                    ThreadManagerV2.getUIHandlerV2().post(BaseSignViewHolder.this.f282387e0);
                }
            }
        }
    }

    public BaseSignViewHolder(Context context, AppInterface appInterface, View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, view, str);
            return;
        }
        this.X = false;
        this.f282383c0 = new a();
        this.f282385d0 = new b();
        this.f282387e0 = new Runnable() { // from class: com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseSignViewHolder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                BaseSignViewHolder baseSignViewHolder = BaseSignViewHolder.this;
                if (baseSignViewHolder.Z) {
                    return;
                }
                baseSignViewHolder.c(baseSignViewHolder.K);
            }
        };
        this.J = context;
        this.f282384d = (BoxShadowLayout) view;
        this.N = appInterface;
        this.P = str;
        this.T = BaseAIOUtils.f(12.0f, context.getResources());
        this.U = R.drawable.hv8;
        k();
        l();
        SignatureManagerForTool.j().addObserver(this.f282385d0);
    }

    private void k() {
        if (f282380f0 == null) {
            int[] iArr = new int[17];
            f282380f0 = iArr;
            iArr[0] = this.J.getResources().getColor(R.color.f157830cb);
            f282380f0[1] = this.J.getResources().getColor(R.color.f157831cs);
            f282380f0[2] = this.J.getResources().getColor(R.color.f157832d9);
            f282380f0[3] = this.J.getResources().getColor(R.color.d_);
            f282380f0[4] = this.J.getResources().getDimensionPixelSize(R.dimen.b_3);
            f282380f0[5] = this.J.getResources().getDimensionPixelSize(R.dimen.b_2);
            f282380f0[6] = this.J.getResources().getDimensionPixelSize(R.dimen.b8y);
            f282380f0[7] = this.J.getResources().getDimensionPixelSize(R.dimen.b_4);
            f282380f0[8] = BaseAIOUtils.f(12.0f, this.J.getResources());
            f282380f0[9] = BaseAIOUtils.f(17.0f, this.J.getResources());
            f282380f0[10] = BaseAIOUtils.f(20.0f, this.J.getResources());
            f282380f0[11] = BaseAIOUtils.f(8.0f, this.J.getResources());
            f282380f0[12] = BaseAIOUtils.f(12.0f, this.J.getResources());
            f282380f0[13] = this.J.getResources().getColor(R.color.aea);
            f282380f0[14] = this.J.getResources().getColor(R.color.f157830cb);
            f282380f0[15] = this.J.getResources().getColor(R.color.ale);
            f282380f0[16] = this.J.getResources().getColor(R.color.f158017al3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t() {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z17;
        int i19;
        boolean B = B();
        boolean A = A();
        boolean D = D();
        boolean z18 = z();
        boolean z19 = true;
        int i26 = 0;
        if (B) {
            String t16 = en.t(this.J, this.K.time * 1000);
            this.f282389h.setText(t16);
            if (AppSetting.f99565y) {
                this.f282389h.setFocusable(true);
                AccessibilityUtil.n(this.f282389h, true);
                AccessibilityUtil.s(this.f282389h, t16);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        SingleLineTextView singleLineTextView = this.f282389h;
        if (B) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        singleLineTextView.setVisibility(i3);
        if (A) {
            if (!TextUtils.isEmpty(this.K.locationText)) {
                this.f282390i.setText(this.K.locationText);
                this.f282390i.setVisibility(0);
                View view = this.f282388f;
                if (!z19 && z18) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                view.setVisibility(i16);
                ImageView imageView = this.C;
                if (!D) {
                    i17 = 0;
                } else {
                    i17 = 8;
                }
                imageView.setVisibility(i17);
                ImageView imageView2 = this.f282391m;
                if (!D) {
                    i18 = 0;
                } else {
                    i18 = 8;
                }
                imageView2.setVisibility(i18);
                G();
                z17 = z19 | D;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.G.getLayoutParams();
                if (!D) {
                    i19 = f282380f0[7];
                } else {
                    i19 = 0;
                }
                marginLayoutParams.rightMargin = i19;
                View view2 = this.E;
                if (!z17) {
                    i26 = 8;
                }
                view2.setVisibility(i26);
            }
            this.f282390i.setText("");
            this.f282390i.setVisibility(8);
        } else {
            this.f282390i.setVisibility(8);
        }
        z19 = z16;
        View view3 = this.f282388f;
        if (!z19) {
        }
        i16 = 8;
        view3.setVisibility(i16);
        ImageView imageView3 = this.C;
        if (!D) {
        }
        imageView3.setVisibility(i17);
        ImageView imageView22 = this.f282391m;
        if (!D) {
        }
        imageView22.setVisibility(i18);
        G();
        z17 = z19 | D;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.G.getLayoutParams();
        if (!D) {
        }
        marginLayoutParams2.rightMargin = i19;
        View view22 = this.E;
        if (!z17) {
        }
        view22.setVisibility(i26);
    }

    private void y() {
        boolean z16;
        CharSequence i3;
        SignatureTemplateInfo signatureTemplateInfo = this.L;
        if (signatureTemplateInfo.imageItem != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = signatureTemplateInfo.defText;
        } else {
            i3 = i(this.K, this, this.Q);
        }
        if (!this.D.getText().equals(i3)) {
            this.V = System.currentTimeMillis();
        }
        if (TextUtils.isEmpty(i3)) {
            if (this.L.isParsing.get() || TextUtils.isEmpty(this.L.defText)) {
                i3 = "";
            } else {
                i3 = this.L.defText;
            }
            RichStatus richStatus = this.K;
            if (richStatus.plainText == null) {
                richStatus.plainText = new ArrayList<>(2);
                this.K.plainText.add("");
                this.K.plainText.add("");
            }
            RichStatus richStatus2 = this.K;
            if (richStatus2.tplId != 0) {
                richStatus2.plainText.set(0, i3.toString());
            }
            this.D.setHint(R.string.fru);
            this.D.setHintTextColor(this.J.getResources().getColor(R.color.f157831cs));
        } else {
            this.D.setHint((CharSequence) null);
        }
        this.D.setTextMsg(new QQText(i3, 1, 20));
        this.D.getViewTreeObserver().addOnPreDrawListener(this);
    }

    protected boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return true;
    }

    protected void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            y();
            t();
        }
    }

    protected void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        q();
        x();
        r();
    }

    public void G() {
        boolean z16;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        ImageView imageView = this.f282391m;
        if (this.M != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        imageView.setSelected(z16);
        if (AppSetting.f99565y) {
            AccessibilityUtil.w(this.f282391m);
            ImageView imageView2 = this.f282391m;
            if (this.M != 0) {
                string = this.J.getString(R.string.ifd);
            } else {
                string = this.J.getString(R.string.ifc);
            }
            imageView2.setContentDescription(string);
        }
    }

    @Override // com.etrump.mixlayout.ETTextView.d
    public void a(ETTextView eTTextView, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) eTTextView, (Object) charSequence);
        } else {
            c.e(eTTextView, charSequence, 0);
        }
    }

    @Override // com.etrump.mixlayout.ETTextView.d
    public void b(ETTextView eTTextView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) eTTextView);
        } else {
            c.e(eTTextView, eTTextView.getText(), 1);
        }
    }

    public View c(RichStatus richStatus) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) richStatus);
        }
        this.K = richStatus;
        if (richStatus == null) {
            return this.f282384d;
        }
        SignatureTemplateInfo j3 = j();
        this.L = j3;
        richStatus.signType = j3.signType;
        if (j3.imageItem != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.W = z16;
        this.X = j3.isParsing.get();
        if (C() && !this.X && !this.W) {
            F();
        } else {
            o();
        }
        E();
        return this.f282384d;
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        int[] iArr = f282380f0;
        int i3 = iArr[4];
        int i16 = iArr[5];
        int i17 = iArr[6];
        this.f282386e.setPadding(i17, i3, i17, i16);
    }

    @Override // com.tencent.mobileqq.richstatus.sign.b
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BaseSignViewHolder", 2, "destroy");
        }
        this.Z = true;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f282387e0);
        VasRes vasRes = this.R;
        if (vasRes != null && vasRes.getVasResAdapter() != null) {
            this.R.getVasResAdapter().destroy();
        }
        VasResDrawable vasResDrawable = this.S;
        if (vasResDrawable != null) {
            vasResDrawable.recycle();
        }
        SignatureManagerForTool.j().deleteObserver(this.f282385d0);
    }

    protected int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return -1;
    }

    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return f282380f0[10];
    }

    public View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (View) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.H;
    }

    public View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (View) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.f282386e;
    }

    protected CharSequence i(RichStatus richStatus, ITopic.OnTopicClickListener onTopicClickListener, int i3) {
        Bitmap g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (CharSequence) iPatchRedirector.redirect((short) 24, this, richStatus, onTopicClickListener, Integer.valueOf(i3));
        }
        AppInterface appInterface = this.N;
        if (!(appInterface instanceof QQAppInterface)) {
            return "";
        }
        if (richStatus == null) {
            return new SpannableString("");
        }
        StatusManager statusManager = (StatusManager) appInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        Resources resources = this.J.getResources();
        SpannableString spannableString = new SpannableString(richStatus.toSpannableStringWithoutAction(onTopicClickListener));
        if (resources != null && !TextUtils.isEmpty(richStatus.actionText)) {
            String str = richStatus.actionText;
            if (!TextUtils.isEmpty(richStatus.dataText)) {
                str = str + richStatus.dataText;
            }
            String str2 = str;
            Drawable drawable = resources.getDrawable(R.drawable.f162392gm4);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
            spannableStringBuilder.insert(0, (CharSequence) "[S] ");
            if (statusManager != null) {
                g16 = statusManager.K(richStatus.actionId, 200);
            } else {
                g16 = j.g(resources, R.drawable.bwk);
            }
            bo boVar = new bo(resources, g16, false, false);
            boVar.setBounds(0, 0, i3, i3);
            spannableStringBuilder.setSpan(new com.tencent.mobileqq.richstatus.j(boVar, 1, str2, Color.parseColor("#ffa8a8a8"), drawable, i3), 0, 3, 17);
            return new QQText(spannableStringBuilder, 1);
        }
        return new QQText(spannableString, 1);
    }

    protected SignatureTemplateInfo j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SignatureTemplateInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.K == null) {
            return null;
        }
        return SignatureManagerForTool.j().l(this.K.tplId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        int f16 = f();
        int i3 = this.T;
        int[] iArr = f282380f0;
        this.Q = iArr[9];
        int i16 = iArr[11];
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.J).inflate(R.layout.aec, (ViewGroup) null, false);
        this.f282386e = linearLayout;
        this.f282384d.a(linearLayout, f16, i3, f282380f0[3]);
        this.E = this.f282384d.findViewById(R.id.f166801do0);
        this.H = this.f282384d.findViewById(R.id.bky);
        this.F = this.f282384d.findViewById(R.id.f166116bm3);
        this.G = this.f282384d.findViewById(R.id.f166117gm4);
        this.f282388f = this.f282384d.findViewById(R.id.bmt);
        this.f282389h = (SingleLineTextView) this.f282384d.findViewById(R.id.kbp);
        this.f282390i = (SingleLineTextView) this.f282384d.findViewById(R.id.e8c);
        ImageView imageView = (ImageView) this.f282384d.findViewById(R.id.dup);
        this.C = imageView;
        UIUtils.c(imageView, i16, i16, i16, i16);
        ImageView imageView2 = (ImageView) this.f282384d.findViewById(R.id.dyw);
        this.f282391m = imageView2;
        UIUtils.c(imageView2, i16, i16, i16, i16);
        ETTextView eTTextView = (ETTextView) this.f282384d.findViewById(R.id.e9z);
        this.D = eTTextView;
        eTTextView.setOnTextOrFontChangeListener(this);
        this.D.setMovementMethod(com.tencent.mobileqq.richstatus.topic.b.getInstance());
        this.D.setGravity(19);
        ImageView imageView3 = this.C;
        ba.a aVar = ba.f77070d;
        imageView3.setOnTouchListener(aVar);
        this.f282391m.setOnTouchListener(aVar);
        this.f282386e.setOnTouchListener(aVar);
        this.D.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f282391m.setOnClickListener(this);
        this.f282386e.setOnClickListener(this);
    }

    public boolean m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, i3)).booleanValue();
        }
        if (1.0d - ((((Color.red(i3) * 0.299d) + (Color.green(i3) * 0.587d)) + (Color.blue(i3) * 0.114d)) / 255.0d) < 0.5d) {
            return false;
        }
        return true;
    }

    protected void n() {
        RichStatus richStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else if (QLog.isColorLevel() && (richStatus = this.K) != null) {
            RichStatus richStatus2 = this.K;
            RichStatus richStatus3 = this.K;
            QLog.i("BaseSignViewHolder", 2, String.format("logRichStatus [tplId=%d fontId=%d fontType=%d] action[%d,%s] data[%d,%s] plainText=%s", Integer.valueOf(richStatus.tplId), Integer.valueOf(this.K.fontId), Integer.valueOf(this.K.fontType), Integer.valueOf(this.K.actionId), richStatus2.actionText, Integer.valueOf(richStatus2.dataId), richStatus3.dataText, richStatus3.getPlainText()));
        }
    }

    protected void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        int[] iArr = f282380f0;
        int i3 = iArr[0];
        int i16 = iArr[1];
        int i17 = iArr[2];
        this.f282384d.setShadowColor(iArr[3]);
        this.f282386e.setBackgroundResource(R.drawable.hv8);
        this.f282386e.setTag(R.id.dwv, -1);
        d();
        this.D.setTextColor(i3);
        this.D.setHintTextColor(i16);
        this.f282388f.setBackgroundColor(i17);
        this.f282390i.setTextColor(i17);
        this.f282389h.setTextColor(i17);
        this.f282391m.setImageResource(R.drawable.b5j);
        this.C.setImageResource(R.drawable.clk);
        s(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            WeakReference<b.a> weakReference = this.f282381a0;
            b.a aVar = weakReference != null ? weakReference.get() : null;
            int id5 = view.getId();
            int i3 = id5 == R.id.dwv ? 1 : id5 == R.id.e9z ? 2 : id5 == R.id.dyw ? 4 : id5 == R.id.dup ? 3 : 0;
            QLog.d("BaseSignViewHolder", 1, "onClick viewType=", Integer.valueOf(i3));
            if (i3 > 0 && aVar != null) {
                aVar.He(view, i3, this);
            }
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        p();
        this.D.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void p() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.K.actionText)) {
            RichStatus richStatus = this.K;
            if (richStatus.actionId == 0 && richStatus.fontId == 0) {
                int lineCount = this.D.getLineCount();
                int gravity = this.D.getGravity();
                if (lineCount <= 1 && (gravity & 3) == 3) {
                    this.D.setGravity(17);
                } else if (lineCount > 1 && (gravity & 3) != 3) {
                    this.D.setGravity(19);
                } else {
                    z16 = false;
                    if (!QLog.isColorLevel()) {
                        QLog.i("BaseSignViewHolder", 2, String.format("resolveLineCountGravity line=%d set=%b", Integer.valueOf(lineCount), Boolean.valueOf(z16)));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (!QLog.isColorLevel()) {
                }
            }
        }
    }

    protected void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        boolean z16 = true;
        if (this.K.tplId == 1) {
            this.f282386e.setBackgroundResource(this.U);
            return;
        }
        if (this.S == null) {
            VasResDrawable vasResDrawable = new VasResDrawable(this.N, this.K.tplId);
            this.S = vasResDrawable;
            SignatureAdapter signatureAdapter = new SignatureAdapter(vasResDrawable, this.N, this.U);
            this.S.setAdapter(signatureAdapter);
            if (e() != -1) {
                z16 = false;
            }
            signatureAdapter.h(z16);
            this.S.setRefreshListener(this.f282383c0);
            this.S.setRadius(f282380f0[8]);
        }
        this.f282386e.setBackgroundDrawable(this.S);
        this.f282386e.setTag(R.id.dwv, Integer.valueOf(this.L.materialVersion));
        this.f282386e.setTag(R.id.ivt, Integer.valueOf(this.K.tplId));
        this.S.update(this.K.tplId);
        d();
    }

    protected void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        int[] iArr = f282380f0;
        int i3 = iArr[0];
        int i16 = iArr[1];
        int i17 = iArr[2];
        this.f282384d.setShadowColor(iArr[3]);
        if (!TextUtils.isEmpty(this.L.fontColor)) {
            i3 = Color.parseColor(this.L.fontColor);
        }
        boolean m3 = m(i3);
        this.D.setTextColor(i3);
        this.D.setHintTextColor(i16);
        if (m3) {
            this.f282390i.setTextColor(i17);
            this.f282389h.setTextColor(i17);
            this.f282388f.setBackgroundColor(i17);
            this.f282391m.setImageResource(R.drawable.b5j);
            this.C.setImageResource(R.drawable.clk);
        } else {
            this.f282390i.setTextColor(-1711276033);
            this.f282389h.setTextColor(-1711276033);
            this.f282388f.setBackgroundColor(-1711276033);
            this.f282391m.setImageResource(R.drawable.f162423cf3);
            this.C.setImageResource(R.drawable.cln);
        }
        s(m3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
    }

    public void u(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            this.f282381a0 = new WeakReference<>(aVar);
        } else {
            this.f282381a0 = null;
        }
    }

    public void v(ITopic.OnTopicClickListener onTopicClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onTopicClickListener);
        } else if (onTopicClickListener != null) {
            this.f282382b0 = new WeakReference<>(onTopicClickListener);
        } else {
            this.f282382b0 = null;
        }
    }

    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
            return;
        }
        this.Y = z16;
        BoxShadowLayout boxShadowLayout = this.f282384d;
        if (boxShadowLayout != null) {
            boxShadowLayout.setScrolling(z16);
        }
        if (this.f282386e.getBackground() != null && (this.f282386e.getBackground() instanceof VasResDrawable)) {
            ((VasResDrawable) this.f282386e.getBackground()).setPaused(z16);
        }
    }

    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        RichStatus richStatus = this.K;
        int i3 = richStatus.fontId;
        int i16 = richStatus.fontType;
        if (i3 == 0) {
            this.D.setFont(i3, 0L);
            return;
        }
        VasRes vasRes = this.R;
        if (vasRes == null) {
            VasRes vasRes2 = new VasRes(this.N, i3);
            this.R = vasRes2;
            com.tencent.mobileqq.vas.adapter.a aVar = new com.tencent.mobileqq.vas.adapter.a(vasRes2, this.N, i16);
            aVar.j(this.D, this.Q, !TextUtils.isEmpty(this.K.toSpannableStringWithoutAction()));
            this.R.setAdapter(aVar);
            aVar.i(e());
        } else {
            ((com.tencent.mobileqq.vas.adapter.a) vasRes.getVasResAdapter()).j(this.D, this.Q, !TextUtils.isEmpty(this.K.toSpannableStringWithoutAction()));
            ((com.tencent.mobileqq.vas.adapter.a) this.R.getVasResAdapter()).k(i3, i16);
        }
        this.f282386e.setTag(R.id.ivp, Integer.valueOf(i3));
    }

    protected boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.text.ITopic.OnTopicClickListener
    public void onClick(ITopic iTopic, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) iTopic, (Object) view);
            return;
        }
        QLog.d("BaseSignViewHolder", 1, "onClick topic=", iTopic);
        WeakReference<ITopic.OnTopicClickListener> weakReference = this.f282382b0;
        ITopic.OnTopicClickListener onTopicClickListener = weakReference != null ? weakReference.get() : null;
        if (onTopicClickListener != null) {
            onTopicClickListener.onClick(iTopic, view);
        }
    }
}
