package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes33.dex */
public class TextPreviewTranslateActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private String f177267a0;

    /* renamed from: b0, reason: collision with root package name */
    public RelativeLayout f177268b0;

    /* renamed from: c0, reason: collision with root package name */
    private EditText f177269c0;

    /* renamed from: d0, reason: collision with root package name */
    private ContainerView f177270d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f177271e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f177272f0;

    /* renamed from: g0, reason: collision with root package name */
    private ImageView f177273g0;

    /* renamed from: h0, reason: collision with root package name */
    private ImageView f177274h0;

    /* renamed from: i0, reason: collision with root package name */
    private ScrollView f177275i0;

    /* renamed from: j0, reason: collision with root package name */
    private TranslateSelectableMenu f177276j0;

    /* renamed from: k0, reason: collision with root package name */
    protected QQProgressDialog f177277k0;

    /* renamed from: m0, reason: collision with root package name */
    private OcrConfig f177279m0;

    /* renamed from: n0, reason: collision with root package name */
    private List<String> f177280n0;

    /* renamed from: o0, reason: collision with root package name */
    private List<String> f177281o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f177282p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f177283q0;

    /* renamed from: r0, reason: collision with root package name */
    private String f177284r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f177285s0;

    /* renamed from: t0, reason: collision with root package name */
    private TranslateController f177286t0;

    /* renamed from: u0, reason: collision with root package name */
    TranslateLanguageOptionsView f177287u0;

    /* renamed from: v0, reason: collision with root package name */
    TranslateLanguageOptionsView f177288v0;

    /* renamed from: x0, reason: collision with root package name */
    public static final int f177264x0 = Color.parseColor("#03081A");

    /* renamed from: y0, reason: collision with root package name */
    public static final int f177265y0 = Color.parseColor("#00CAFC");

    /* renamed from: z0, reason: collision with root package name */
    public static final int f177266z0 = Color.parseColor("#FFFFFF");
    public static final int A0 = Color.parseColor("#A8A8A8");
    public static final int B0 = Color.parseColor("#004080");
    public static final int C0 = Color.parseColor("#1F1F1F");
    public static final int D0 = Color.parseColor("#000000");

    /* renamed from: l0, reason: collision with root package name */
    private boolean f177278l0 = false;

    /* renamed from: w0, reason: collision with root package name */
    private com.tencent.mobileqq.ocr.c f177289w0 = new b();

    /* loaded from: classes33.dex */
    class b extends com.tencent.mobileqq.ocr.c {
        b() {
        }

        @Override // com.tencent.mobileqq.ocr.c
        public void c(boolean z16, int i3, TranslateResult translateResult) {
            TextPreviewTranslateActivity.this.hideProgressDialog();
            if (z16 && translateResult != null && translateResult.j() && !translateResult.g()) {
                TextPreviewTranslateActivity.this.s3(translateResult);
                return;
            }
            String string = TextPreviewTranslateActivity.this.getResources().getString(R.string.fou);
            if (translateResult != null) {
                if (!TextUtils.isEmpty(translateResult.E)) {
                    string = translateResult.E;
                } else if (translateResult.g()) {
                    string = TextPreviewTranslateActivity.this.getResources().getString(R.string.fo_);
                }
            }
            QQToast.makeText(TextPreviewTranslateActivity.this, 1, string, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements TranslateLanguageOptionsView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.a
        public void a(int i3, TranslateLanguageOptionsView.b bVar) {
            if (TextUtils.isEmpty(TextPreviewTranslateActivity.this.f177284r0) || TextPreviewTranslateActivity.this.f177284r0.equals(bVar.f254924b)) {
                return;
            }
            TextPreviewTranslateActivity.this.t3(bVar.f254924b);
            TextPreviewTranslateActivity textPreviewTranslateActivity = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity.h3(textPreviewTranslateActivity.g3(textPreviewTranslateActivity.f177282p0), TextPreviewTranslateActivity.this.f177284r0, TextPreviewTranslateActivity.this.f177285s0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements PopupWindow.OnDismissListener {
        d() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            TextPreviewTranslateActivity textPreviewTranslateActivity = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity.f177288v0 = null;
            if (textPreviewTranslateActivity.f177280n0 == null || TextPreviewTranslateActivity.this.f177280n0.size() <= 1) {
                return;
            }
            TextPreviewTranslateActivity.this.f177271e0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, TextPreviewTranslateActivity.this.getResources().getDrawable(TextPreviewTranslateActivity.this.f177278l0 ? R.drawable.f18 : R.drawable.hvd));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class f implements PopupWindow.OnDismissListener {
        f() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            TextPreviewTranslateActivity textPreviewTranslateActivity = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity.f177287u0 = null;
            if (textPreviewTranslateActivity.f177281o0 == null || TextPreviewTranslateActivity.this.f177281o0.size() <= 1) {
                return;
            }
            TextPreviewTranslateActivity.this.f177272f0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, TextPreviewTranslateActivity.this.getResources().getDrawable(TextPreviewTranslateActivity.this.f177278l0 ? R.drawable.f18 : R.drawable.hvd));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static final class g implements DispatchTouchEventRelativeLayout.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<TranslateSelectableMenu> f177296a;

        g(TranslateSelectableMenu translateSelectableMenu) {
            this.f177296a = new WeakReference<>(translateSelectableMenu);
        }

        @Override // com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout.a
        public void onDispatchTouchEvent(MotionEvent motionEvent) {
            TranslateSelectableMenu translateSelectableMenu = this.f177296a.get();
            if (translateSelectableMenu != null) {
                translateSelectableMenu.e(motionEvent);
            }
        }
    }

    private boolean Y2(String str) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("key_translate_strip", true)) {
            return true;
        }
        String[] split = str.split("\n");
        ArrayList arrayList = new ArrayList();
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2.trim().replace("\n", ""))) {
                    arrayList.add(str2);
                }
            }
        }
        return !arrayList.isEmpty();
    }

    private String b3(String str) {
        OcrConfig ocrConfig = this.f177279m0;
        if (ocrConfig != null) {
            return ocrConfig.getTranslateLanguageName(str);
        }
        return OcrConfig.getDefaultLanguageName(str);
    }

    private List<String> c3(String str) {
        OcrConfig ocrConfig = this.f177279m0;
        if (ocrConfig != null) {
            return ocrConfig.getTranslateSupportLanguages(str);
        }
        return OcrConfig.getDefaultSupportLanguages(str);
    }

    private void d3() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("TranslateText");
        this.f177283q0 = stringExtra;
        this.f177282p0 = stringExtra;
        this.f177267a0 = intent.getStringExtra("WhereAreYouFrom");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3() {
        if (Z2(this.f177282p0)) {
            this.f177284r0 = OcrConfig.CHINESE;
            this.f177285s0 = "en";
        } else {
            this.f177284r0 = "en";
            this.f177285s0 = OcrConfig.CHINESE;
        }
        this.f177271e0.setText(b3(this.f177284r0));
        this.f177272f0.setText(b3(this.f177285s0));
        this.f177280n0 = c3(this.f177284r0);
        this.f177281o0 = c3(this.f177285s0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g3(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        return new QQText(str, 5, 25).toPlainText(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3(String str, String str2, String str3) {
        if (!Y2(str)) {
            QQToast.makeText(this, 0, R.string.f131070, 0).show();
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        showProgressDialog(R.string.fow);
        TranslateController translateController = this.f177286t0;
        if (translateController != null) {
            translateController.e(str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressDialog() {
        QQProgressDialog qQProgressDialog = this.f177277k0;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            return;
        }
        this.f177277k0.dismiss();
    }

    private void i3() {
        this.f177268b0.setBackgroundColor(D0);
        this.f177269c0.setBackgroundColor(C0);
        this.f177270d0.setTextColor(B0);
        TextView textView = this.f177271e0;
        int i3 = A0;
        textView.setTextColor(i3);
        this.f177272f0.setTextColor(i3);
        this.f177269c0.setTextColor(i3);
        this.f177273g0.setImageDrawable(getResources().getDrawable(R.drawable.afk));
        this.f177274h0.setImageDrawable(getResources().getDrawable(R.drawable.kyd));
    }

    private void j3() {
        this.f177269c0.setBackgroundColor(f177266z0);
        this.f177270d0.setTextColor(f177265y0);
        TextView textView = this.f177271e0;
        int i3 = f177264x0;
        textView.setTextColor(i3);
        this.f177272f0.setTextColor(i3);
        this.f177273g0.setImageDrawable(getResources().getDrawable(R.drawable.hh6));
        this.f177274h0.setImageDrawable(getResources().getDrawable(R.drawable.hh5));
    }

    private void l3() {
        Intent intent = new Intent();
        intent.putExtra("PARAM_FROM", 1);
        setResult(1, intent);
    }

    private void n3() {
        TranslateLanguageOptionsView translateLanguageOptionsView = this.f177288v0;
        if (translateLanguageOptionsView != null && translateLanguageOptionsView.isShowing()) {
            this.f177288v0.dismiss();
        }
        TranslateLanguageOptionsView translateLanguageOptionsView2 = this.f177287u0;
        if (translateLanguageOptionsView2 != null && translateLanguageOptionsView2.isShowing()) {
            this.f177287u0.dismiss();
            return;
        }
        List<String> list = this.f177281o0;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (int i16 = 0; i16 < this.f177281o0.size(); i16++) {
            String str = this.f177281o0.get(i16);
            if (!str.equals(this.f177284r0)) {
                TranslateLanguageOptionsView.b bVar = new TranslateLanguageOptionsView.b();
                bVar.f254924b = str;
                bVar.f254923a = b3(str);
                if (str.equalsIgnoreCase(this.f177285s0)) {
                    i3 = i16;
                }
                arrayList.add(bVar);
            }
        }
        TranslateLanguageOptionsView a16 = TranslateLanguageOptionsView.a(this, arrayList, i3, new e());
        this.f177287u0 = a16;
        if (a16 != null) {
            a16.setOnDismissListener(new f());
            int measuredWidth = (this.f177272f0.getMeasuredWidth() / 2) - BaseAIOUtils.f(75.0f, getResources());
            this.f177272f0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f177287u0.showAsDropDown(this.f177272f0, measuredWidth, 0);
        }
    }

    private void p3() {
        TranslateLanguageOptionsView translateLanguageOptionsView = this.f177287u0;
        if (translateLanguageOptionsView != null && translateLanguageOptionsView.isShowing()) {
            this.f177287u0.dismiss();
        }
        TranslateLanguageOptionsView translateLanguageOptionsView2 = this.f177288v0;
        if (translateLanguageOptionsView2 != null && translateLanguageOptionsView2.isShowing()) {
            this.f177288v0.dismiss();
            return;
        }
        List<String> list = this.f177280n0;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (int i16 = 0; i16 < this.f177280n0.size(); i16++) {
            String str = this.f177280n0.get(i16);
            if (!str.equals(this.f177281o0)) {
                TranslateLanguageOptionsView.b bVar = new TranslateLanguageOptionsView.b();
                bVar.f254924b = str;
                bVar.f254923a = b3(str);
                if (str.equalsIgnoreCase(this.f177284r0)) {
                    i3 = i16;
                }
                arrayList.add(bVar);
            }
        }
        TranslateLanguageOptionsView a16 = TranslateLanguageOptionsView.a(this, arrayList, i3, new c());
        this.f177288v0 = a16;
        if (a16 != null) {
            a16.setOnDismissListener(new d());
            int measuredWidth = (this.f177271e0.getMeasuredWidth() / 2) - BaseAIOUtils.f(75.0f, getResources());
            this.f177271e0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f177288v0.showAsDropDown(this.f177271e0, measuredWidth, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        this.f177285s0 = lowerCase;
        this.f177272f0.setText(b3(lowerCase));
        List<String> c36 = c3(str);
        this.f177280n0 = c36;
        if (c36 != null && c36.size() > 1) {
            this.f177271e0.setClickable(true);
            this.f177271e0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(this.f177278l0 ? R.drawable.f18 : R.drawable.hvd));
        } else {
            this.f177271e0.setClickable(false);
            this.f177271e0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(this.f177272f0, b3(this.f177285s0), getString(R.string.fov));
        }
    }

    private void showProgressDialog(int i3) {
        if (this.f177277k0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.f177277k0 = qQProgressDialog;
            qQProgressDialog.setMessage(i3);
        }
        if (isFinishing()) {
            return;
        }
        this.f177277k0.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        this.f177284r0 = lowerCase;
        this.f177271e0.setText(b3(lowerCase));
        List<String> c36 = c3(this.f177284r0);
        this.f177281o0 = c36;
        if (c36 != null && c36.size() > 1) {
            this.f177272f0.setClickable(true);
            this.f177272f0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(this.f177278l0 ? R.drawable.f18 : R.drawable.hvd));
        } else {
            this.f177272f0.setClickable(false);
            this.f177272f0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(this.f177271e0, b3(this.f177284r0), getString(R.string.fov));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (intent != null) {
            ForwardUtils.V(this.app, intent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        removeObserver(this.f177289w0);
        this.f177276j0.b(this.f177270d0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        this.f177276j0.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.f177276j0.onResume();
        if (ImmersiveUtils.isSupporImmersive() == 0 || !ImmersiveUtils.couldSetStatusTextColor()) {
            return;
        }
        ImmersiveUtils.setStatusTextColor(true, getWindow());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mb8 /* 2131390070 */:
                finish();
                return;
            case R.id.mb9 /* 2131390071 */:
                n3();
                return;
            case R.id.jv9 /* 2131390072 */:
            case R.id.jv_ /* 2131390073 */:
            case R.id.jva /* 2131390074 */:
            default:
                return;
            case R.id.mb_ /* 2131390075 */:
                p3();
                return;
            case R.id.mba /* 2131390076 */:
                String str = this.f177284r0;
                t3(this.f177285s0);
                r3(str);
                h3(g3(this.f177282p0), this.f177284r0, this.f177285s0);
                TranslateLanguageOptionsView translateLanguageOptionsView = this.f177288v0;
                if (translateLanguageOptionsView != null && translateLanguageOptionsView.isShowing()) {
                    this.f177288v0.dismiss();
                }
                TranslateLanguageOptionsView translateLanguageOptionsView2 = this.f177287u0;
                if (translateLanguageOptionsView2 == null || !translateLanguageOptionsView2.isShowing()) {
                    return;
                }
                this.f177287u0.dismiss();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class e implements TranslateLanguageOptionsView.a {
        e() {
        }

        @Override // com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.a
        public void a(int i3, TranslateLanguageOptionsView.b bVar) {
            if (bVar == null || TextUtils.isEmpty(TextPreviewTranslateActivity.this.f177285s0) || TextPreviewTranslateActivity.this.f177285s0.equals(bVar.f254924b)) {
                return;
            }
            TextPreviewTranslateActivity.this.r3(bVar.f254924b);
            TextPreviewTranslateActivity textPreviewTranslateActivity = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity.h3(textPreviewTranslateActivity.g3(textPreviewTranslateActivity.f177282p0), TextPreviewTranslateActivity.this.f177284r0, TextPreviewTranslateActivity.this.f177285s0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.cc6);
        d3();
        f3();
        l3();
        this.f177286t0 = new TranslateController(this.app);
        addObserver(this.f177289w0);
        e3();
        t3(this.f177284r0);
        r3(this.f177285s0);
        h3(g3(this.f177282p0), this.f177284r0, this.f177285s0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements TextView.OnEditorActionListener {
        a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (i3 != 6 || TextPreviewTranslateActivity.this.f177269c0 == null) {
                return false;
            }
            TextPreviewTranslateActivity textPreviewTranslateActivity = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity.f177282p0 = textPreviewTranslateActivity.f177269c0.getText().toString();
            TextPreviewTranslateActivity.this.e3();
            TextPreviewTranslateActivity textPreviewTranslateActivity2 = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity2.t3(textPreviewTranslateActivity2.f177284r0);
            TextPreviewTranslateActivity textPreviewTranslateActivity3 = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity3.r3(textPreviewTranslateActivity3.f177285s0);
            TextPreviewTranslateActivity textPreviewTranslateActivity4 = TextPreviewTranslateActivity.this;
            textPreviewTranslateActivity4.h3(textPreviewTranslateActivity4.g3(textPreviewTranslateActivity4.f177282p0), TextPreviewTranslateActivity.this.f177284r0, TextPreviewTranslateActivity.this.f177285s0);
            return true;
        }
    }

    private static boolean Z2(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if ('\u4e00' <= charAt && charAt < '\u9fa5') {
                return true;
            }
        }
        return false;
    }

    private void f3() {
        this.f177268b0 = (RelativeLayout) findViewById(R.id.ma6);
        EditText editText = (EditText) findViewById(R.id.mbe);
        this.f177269c0 = editText;
        editText.setText(new QQText(this.f177282p0, 5, 25));
        this.f177270d0 = (ContainerView) findViewById(R.id.mbf);
        ColorStateList colorStateList = ContextCompat.getColorStateList(this, R.color.qui_common_brand_light);
        this.f177270d0.f315580h.setHighlightColor(colorStateList.getDefaultColor());
        this.f177270d0.f315580h.n(colorStateList.getDefaultColor());
        this.f177271e0 = (TextView) findViewById(R.id.mb_);
        this.f177272f0 = (TextView) findViewById(R.id.mb9);
        this.f177273g0 = (ImageView) findViewById(R.id.mba);
        this.f177274h0 = (ImageView) findViewById(R.id.mb8);
        this.f177275i0 = (ScrollView) findViewById(R.id.iia);
        this.f177271e0.setOnClickListener(this);
        this.f177272f0.setOnClickListener(this);
        this.f177273g0.setOnClickListener(this);
        this.f177274h0.setOnClickListener(this);
        TranslateSelectableMenu translateSelectableMenu = new TranslateSelectableMenu();
        this.f177276j0 = translateSelectableMenu;
        translateSelectableMenu.a(this, this.f177270d0);
        if (QQTheme.isNowThemeIsNight()) {
            i3();
        } else {
            j3();
        }
        this.f177279m0 = ((IOCRService) this.app.getRuntimeService(IOCRService.class, "")).getOCRConfig(false);
        RelativeLayout relativeLayout = this.f177268b0;
        if (relativeLayout instanceof DispatchTouchEventRelativeLayout) {
            ((DispatchTouchEventRelativeLayout) relativeLayout).setOnDispatchListener(new g(this.f177276j0));
        }
        this.f177269c0.setHorizontallyScrolling(false);
        this.f177269c0.setMaxLines(this.f177269c0.getLineHeight() != 0 ? com.tencent.mobileqq.util.x.c(this, 360.0f) / this.f177269c0.getLineHeight() : 17);
        this.f177269c0.setOnEditorActionListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(TranslateResult translateResult) {
        ContainerView containerView;
        TranslateSelectableMenu translateSelectableMenu;
        if (translateResult == null || (containerView = this.f177270d0) == null || (translateSelectableMenu = this.f177276j0) == null) {
            return;
        }
        String f16 = translateResult.f();
        translateSelectableMenu.D = f16;
        containerView.setText(f16);
        r3(translateResult.f254723f);
        t3(translateResult.f254722e);
    }
}
