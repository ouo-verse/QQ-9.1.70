package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.ocr.api.impl.OCRHandler;
import com.tencent.mobileqq.ocr.d;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TranslateFragment extends QPublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private TranslateLanguageOptionsView C;
    private TranslateLanguageOptionsView D;
    private QQProgressDialog E;
    private OCRBottomTabView F;
    private OCRBottomTabView G;
    private OCRBottomTabView H;
    private OCRBottomTabView I;
    private ImageView J;
    private ImageView K;
    private ScrollView L;
    private ScrollView M;
    private TextView N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private RelativeLayout S;
    private LinearLayout T;
    private OCRHandler U;
    private TranslateResult V;
    private boolean W;
    private QBaseActivity X;
    private String Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.ocr.c f254612a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements TranslateLanguageOptionsView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.a f254617a;

        a(d.a aVar) {
            this.f254617a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TranslateFragment.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.a
        public void a(int i3, TranslateLanguageOptionsView.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bVar);
                return;
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.f254924b)) {
                if (!this.f254617a.f254716d.equalsIgnoreCase(bVar.f254924b)) {
                    TranslateFragment translateFragment = TranslateFragment.this;
                    String str = bVar.f254924b;
                    translateFragment.Dh(str, this.f254617a.c(str));
                }
                com.tencent.mobileqq.ocr.d.n("0X800AD30", com.tencent.mobileqq.ocr.d.f(bVar.f254924b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements PopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.a f254619d;

        b(d.a aVar) {
            this.f254619d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TranslateFragment.this, (Object) aVar);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TranslateFragment.this.D = null;
                List<String> list = this.f254619d.f254718f;
                if (list != null && list.size() > 1) {
                    TranslateFragment.this.Q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, TranslateFragment.this.getResources().getDrawable(R.drawable.hvd));
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements TranslateLanguageOptionsView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.a f254621a;

        c(d.a aVar) {
            this.f254621a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TranslateFragment.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.a
        public void a(int i3, TranslateLanguageOptionsView.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bVar);
            } else if (bVar != null && !TextUtils.isEmpty(bVar.f254924b)) {
                if (!this.f254621a.f254717e.equalsIgnoreCase(bVar.f254924b)) {
                    TranslateFragment.this.Dh(this.f254621a.f254716d, bVar.f254924b);
                }
                com.tencent.mobileqq.ocr.d.n("0X800AD31", com.tencent.mobileqq.ocr.d.f(bVar.f254924b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements PopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.a f254623d;

        d(d.a aVar) {
            this.f254623d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TranslateFragment.this, (Object) aVar);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TranslateFragment.this.C = null;
                List<String> list = this.f254623d.f254719g;
                if (list != null && list.size() > 1) {
                    TranslateFragment.this.R.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, TranslateFragment.this.getResources().getDrawable(R.drawable.hvd));
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public TranslateFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.Z = 2;
            this.f254612a0 = new com.tencent.mobileqq.ocr.c() { // from class: com.tencent.mobileqq.ocr.TranslateFragment.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TranslateFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.ocr.c
                public void c(boolean z16, int i3, TranslateResult translateResult) {
                    int i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), translateResult);
                        return;
                    }
                    if (!TranslateFragment.this.W) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TranslateFragment", 2, String.format("onGetTranslateResult isSuccess:%s, type:%s, result:%s", Boolean.valueOf(z16), Integer.valueOf(i3), translateResult));
                    }
                    TranslateFragment.this.X.runOnUiThread(new Runnable(z16, translateResult) { // from class: com.tencent.mobileqq.ocr.TranslateFragment.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f254614d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ TranslateResult f254615e;

                        {
                            this.f254614d = z16;
                            this.f254615e = translateResult;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z16), translateResult);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            TranslateResult translateResult2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                TranslateFragment.this.W = false;
                                TranslateFragment.this.Bh();
                                if (this.f254614d && (translateResult2 = this.f254615e) != null && translateResult2.j() && !this.f254615e.g()) {
                                    TranslateFragment.this.V = this.f254615e;
                                    TranslateFragment.this.Ih(2, this.f254615e);
                                    return;
                                }
                                String string = TranslateFragment.this.getResources().getString(R.string.fou);
                                TranslateResult translateResult3 = this.f254615e;
                                if (translateResult3 != null) {
                                    if (!TextUtils.isEmpty(translateResult3.E)) {
                                        string = this.f254615e.E;
                                    } else if (this.f254615e.g()) {
                                        string = TranslateFragment.this.getResources().getString(R.string.fo_);
                                    }
                                }
                                QQToast.makeText(TranslateFragment.this.X, 1, string, 0).show();
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    });
                    HashMap<String, String> hashMap = new HashMap<>();
                    if (translateResult != null) {
                        i16 = translateResult.D;
                    } else {
                        i16 = 2000;
                    }
                    hashMap.put("errCode", String.valueOf(i16));
                    hashMap.put("type", String.valueOf(i3));
                    StatisticCollector.getInstance(TranslateFragment.this.X).collectPerformance("", "SCAN_TRANSLATE_RESULT", z16, 0L, 0L, hashMap, "", false);
                }
            };
        }
    }

    private void Ah(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                TranslateResult translateResult = this.V;
                if (translateResult != null) {
                    Ih(1, translateResult);
                } else {
                    Ch(com.tencent.mobileqq.ocr.d.f254707d);
                }
                com.tencent.mobileqq.ocr.d.n("0X800AB95", 2);
                return;
            }
            return;
        }
        Ih(2, this.V);
        com.tencent.mobileqq.ocr.d.n("0X800AB95", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh() {
        QQProgressDialog qQProgressDialog = this.E;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.E.dismiss();
        }
    }

    private void Ch(d.a aVar) {
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("TranslateFragment", 2, "requestTranslate, lanHolder:" + aVar.e());
            }
            Dh(aVar.f254716d, aVar.f254717e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(String str, String str2) {
        if (!NetworkUtil.isNetworkAvailable(this.X)) {
            QQToast.makeText(this.X, 1, R.string.b3j, 0).show();
            return;
        }
        if (TextUtils.isEmpty(this.Y)) {
            QLog.d("TranslateFragment", 1, "requestTranslate, mInputTransText null");
            return;
        }
        if (this.W) {
            QLog.d("TranslateFragment", 1, "requestTranslate, in translate request,");
            return;
        }
        showProgressDialog(R.string.fow);
        this.W = true;
        if (QLog.isColorLevel()) {
            QLog.d("TranslateFragment", 2, "requestTranslate, srcLan:" + str + ", dstLan:" + str2);
        }
        OCRHandler oCRHandler = this.U;
        if (oCRHandler != null) {
            oCRHandler.batchTranslate(this.Y, str, str2);
        }
    }

    private void Eh(d.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("TranslateFragment", 2, "showTranslateDstLanOptions, lanHolder:" + aVar.e());
        }
        TranslateLanguageOptionsView translateLanguageOptionsView = this.D;
        if (translateLanguageOptionsView != null && translateLanguageOptionsView.isShowing()) {
            this.D.dismiss();
        }
        TranslateLanguageOptionsView translateLanguageOptionsView2 = this.C;
        if (translateLanguageOptionsView2 != null && translateLanguageOptionsView2.isShowing()) {
            this.C.dismiss();
            return;
        }
        List<String> list = aVar.f254719g;
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < aVar.f254719g.size(); i16++) {
                String str = aVar.f254719g.get(i16);
                if (!str.equalsIgnoreCase(aVar.f254716d)) {
                    if (str.equalsIgnoreCase(aVar.f254717e)) {
                        i3 = i16;
                    }
                    TranslateLanguageOptionsView.b bVar = new TranslateLanguageOptionsView.b();
                    bVar.f254924b = str;
                    bVar.f254923a = com.tencent.mobileqq.ocr.d.h(str);
                    arrayList.add(bVar);
                }
            }
            this.C = TranslateLanguageOptionsView.a(this.X, arrayList, i3, new c(aVar));
            int measuredWidth = (this.R.getMeasuredWidth() / 2) - x.c(this.X, 75.0f);
            this.R.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.C.showAsDropDown(this.R, measuredWidth, 0);
            this.C.setOnDismissListener(new d(aVar));
        }
    }

    private void Fh(d.a aVar) {
        List<String> list;
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showTranslateSrcLanOptions, lanHolder:");
            if (aVar != null) {
                str = aVar.e();
            } else {
                str = "null";
            }
            sb5.append(str);
            QLog.d("TranslateFragment", 2, sb5.toString());
        }
        TranslateLanguageOptionsView translateLanguageOptionsView = this.C;
        if (translateLanguageOptionsView != null && translateLanguageOptionsView.isShowing()) {
            this.C.dismiss();
        }
        TranslateLanguageOptionsView translateLanguageOptionsView2 = this.D;
        if (translateLanguageOptionsView2 != null && translateLanguageOptionsView2.isShowing()) {
            this.D.dismiss();
            return;
        }
        if (aVar != null && (list = aVar.f254718f) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < aVar.f254718f.size(); i16++) {
                String str2 = aVar.f254718f.get(i16);
                if (str2.equalsIgnoreCase(aVar.f254716d)) {
                    i3 = i16;
                }
                TranslateLanguageOptionsView.b bVar = new TranslateLanguageOptionsView.b();
                bVar.f254924b = str2;
                bVar.f254923a = com.tencent.mobileqq.ocr.d.h(str2);
                arrayList.add(bVar);
            }
            this.D = TranslateLanguageOptionsView.a(this.X, arrayList, i3, new a(aVar));
            int measuredWidth = (this.Q.getMeasuredWidth() / 2) - x.c(this.X, 75.0f);
            this.Q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.D.showAsDropDown(this.Q, measuredWidth, 0);
            this.D.setOnDismissListener(new b(aVar));
        }
    }

    public static void Gh(QBaseActivity qBaseActivity, String str) {
        Intent intent = new Intent(qBaseActivity, (Class<?>) TranslateFragment.class);
        intent.putExtra("TranslateText", str);
        QPublicFragmentActivity.start(qBaseActivity, intent, TranslateFragment.class);
    }

    private CharSequence Hh(int i3, TranslateResult translateResult) {
        if (i3 == 1) {
            return translateResult.a();
        }
        if (i3 == 2) {
            return translateResult.c();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(int i3, TranslateResult translateResult) {
        int i16;
        String str;
        int i17;
        this.Z = i3;
        OCRBottomTabView oCRBottomTabView = this.F;
        if (oCRBottomTabView != null && oCRBottomTabView.getVisibility() == 0) {
            int i18 = R.string.w5n;
            String str2 = "#000000";
            if (i3 == 1) {
                str = "#00CAFC";
                i17 = R.drawable.chl;
                i16 = R.string.w5n;
            } else {
                i16 = -1;
                str = "#000000";
                i17 = -1;
            }
            if (i3 == 2) {
                i17 = R.drawable.chk;
            } else {
                i18 = i16;
                str2 = str;
            }
            this.F.setTabText(getResources().getString(i18));
            if (QQTheme.isNowThemeIsNight()) {
                this.F.setTabImage(getResources().getDrawable(R.drawable.n4s));
                this.F.setTabTextColor(Color.parseColor("#999999"));
            } else {
                this.F.setTabImage(getResources().getDrawable(i17));
                this.F.setTabTextColor(Color.parseColor(str2));
            }
        }
        if (translateResult != null) {
            if (i3 == 2) {
                this.L.setVisibility(0);
                this.M.setVisibility(0);
                this.N.setText(this.Y);
                this.P.setText(Hh(i3, translateResult));
            }
            if (i3 == 1) {
                this.M.setVisibility(0);
                this.L.setVisibility(8);
                this.P.setText(Hh(i3, translateResult));
            }
            if (com.tencent.mobileqq.ocr.d.f254707d != null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TranslateFragment", 2, "src:" + translateResult.f254722e + ", dst:" + translateResult.f254723f + ", OCRLanHolder:" + com.tencent.mobileqq.ocr.d.f254707d.e());
                }
                com.tencent.mobileqq.ocr.d.f254707d.g(translateResult.f254722e);
                com.tencent.mobileqq.ocr.d.f254707d.f(translateResult.f254723f);
                Jh(com.tencent.mobileqq.ocr.d.f254707d);
            }
        }
    }

    private void Jh(d.a aVar) {
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder:" + aVar.e());
        }
        this.Q.setText(aVar.d(aVar.f254716d));
        this.R.setText(aVar.d(aVar.f254717e));
        List<String> list = aVar.f254718f;
        if (list != null && list.size() > 1) {
            this.Q.setClickable(true);
            this.Q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.hvd));
        } else {
            this.Q.setClickable(false);
            this.Q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        List<String> list2 = aVar.f254719g;
        if (list2 != null && list2.size() > 1) {
            this.R.setClickable(true);
            this.R.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.hvd));
        } else {
            this.R.setClickable(false);
            this.R.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private void showProgressDialog(int i3) {
        if (this.E == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.X, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.E = qQProgressDialog;
            qQProgressDialog.setMessage(i3);
        }
        if (!getActivity().isFinishing()) {
            this.E.show();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        activity.getWindow().setFlags(1024, 1024);
        activity.getWindow().getDecorView().setSystemUiVisibility(1);
        activity.getWindow().addFlags(134217728);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.onAttach(activity);
            this.X = (QBaseActivity) activity;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.mb_) {
                Fh(com.tencent.mobileqq.ocr.d.f254707d);
            } else if (id5 == R.id.mb9) {
                Eh(com.tencent.mobileqq.ocr.d.f254707d);
            } else if (id5 == R.id.mb8) {
                this.X.finish();
            } else if (id5 != R.id.mba) {
                if (id5 == R.id.f165143fb2) {
                    ((IFavoriteOCR) QRoute.api(IFavoriteOCR.class)).favorite(this.X, String.valueOf(this.P.getText()));
                    com.tencent.mobileqq.ocr.d.n("0X800AB94", 0);
                } else if (id5 == R.id.cju) {
                    com.tencent.mobileqq.ocr.d.i(this.X, String.valueOf(this.P.getText()));
                    com.tencent.mobileqq.ocr.d.n("0X800AB93", 0);
                } else if (id5 == R.id.f164918dv4) {
                    BaseMenuUtil.copy(String.valueOf(this.P.getText()), "TranslateFragment");
                    com.tencent.mobileqq.ocr.d.n("0X800AB92", 0);
                } else if (id5 == R.id.dqm) {
                    Ah(this.Z);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.Y = getActivity().getIntent().getStringExtra("TranslateText");
        this.U = (OCRHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(OCRHandler.f254678e);
        this.X.addObserver(this.f254612a0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.bvl, viewGroup, false);
            if (QQTheme.isNowThemeIsNight()) {
                inflate.setBackgroundColor(Color.parseColor("#000000"));
            } else {
                inflate.setBackgroundResource(R.drawable.f160251e7);
            }
            this.S = (RelativeLayout) inflate.findViewById(R.id.jp7);
            this.Q = (TextView) inflate.findViewById(R.id.mb_);
            this.R = (TextView) inflate.findViewById(R.id.mb9);
            this.J = (ImageView) inflate.findViewById(R.id.mba);
            this.T = (LinearLayout) inflate.findViewById(R.id.acy);
            this.K = (ImageView) inflate.findViewById(R.id.mb8);
            this.L = (ScrollView) inflate.findViewById(R.id.j5t);
            this.N = (TextView) inflate.findViewById(R.id.j87);
            this.M = (ScrollView) inflate.findViewById(R.id.j86);
            this.P = (TextView) inflate.findViewById(R.id.mbf);
            this.F = (OCRBottomTabView) inflate.findViewById(R.id.dqm);
            this.I = (OCRBottomTabView) inflate.findViewById(R.id.f165143fb2);
            this.H = (OCRBottomTabView) inflate.findViewById(R.id.cju);
            this.G = (OCRBottomTabView) inflate.findViewById(R.id.f164918dv4);
            this.Q.setOnClickListener(this);
            this.R.setOnClickListener(this);
            this.K.setOnClickListener(this);
            this.F.setOnClickListener(this);
            this.I.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.G.setOnClickListener(this);
            if (QQTheme.isNowThemeIsNight()) {
                this.Q.setTextColor(Color.parseColor("#999999"));
                this.R.setTextColor(Color.parseColor("#999999"));
                this.N.setTextColor(Color.parseColor("#999999"));
                this.P.setTextColor(Color.parseColor("#999999"));
                this.F.setTabTextColor(Color.parseColor("#999999"));
                this.F.setTabImage(getResources().getDrawable(R.drawable.n4s));
                this.I.setTabTextColor(Color.parseColor("#999999"));
                this.I.setTabImage(getResources().getDrawable(R.drawable.nfm));
                this.H.setTabTextColor(Color.parseColor("#999999"));
                this.H.setTabImage(getResources().getDrawable(R.drawable.nfq));
                this.G.setTabTextColor(Color.parseColor("#999999"));
                this.G.setTabImage(getResources().getDrawable(R.drawable.nfp));
                this.T.setBackgroundColor(Color.parseColor("#1A1A1A"));
                this.L.setBackgroundColor(Color.parseColor("#1A1A1A"));
            } else {
                this.Q.setTextColor(Color.parseColor("#03081A"));
                this.R.setTextColor(Color.parseColor("#03081A"));
                this.N.setTextColor(Color.parseColor("#000000"));
                this.P.setTextColor(Color.parseColor("#000000"));
                this.F.setTabTextColor(Color.parseColor("#000000"));
                this.I.setTabTextColor(Color.parseColor("#000000"));
                this.H.setTabTextColor(Color.parseColor("#000000"));
                this.G.setTabTextColor(Color.parseColor("#000000"));
            }
            this.N.setText(this.Y);
            this.P.setText("");
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.drawable.kyd;
                i16 = R.drawable.n4p;
            } else {
                i3 = R.drawable.hh5;
                i16 = R.drawable.n4o;
            }
            this.K.setImageDrawable(getResources().getDrawable(i3));
            this.J.setImageDrawable(getResources().getDrawable(i16));
            Jh(com.tencent.mobileqq.ocr.d.f254707d);
            Ch(com.tencent.mobileqq.ocr.d.f254707d);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        this.X.removeObserver(this.f254612a0);
        this.X = null;
    }
}
