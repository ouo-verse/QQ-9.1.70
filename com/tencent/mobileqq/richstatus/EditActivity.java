package com.tencent.mobileqq.richstatus;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ClickableImageSpan;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class EditActivity extends IphoneTitleBarActivity implements View.OnClickListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;

    /* renamed from: v0, reason: collision with root package name */
    public static boolean f282123v0;

    /* renamed from: w0, reason: collision with root package name */
    public static int f282124w0;

    /* renamed from: x0, reason: collision with root package name */
    public static int f282125x0;

    /* renamed from: a0, reason: collision with root package name */
    public long f282126a0;

    /* renamed from: b0, reason: collision with root package name */
    private RichStatusEditText f282127b0;

    /* renamed from: c0, reason: collision with root package name */
    TextView f282128c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f282129d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f282130e0;

    /* renamed from: f0, reason: collision with root package name */
    private StatusManager f282131f0;

    /* renamed from: g0, reason: collision with root package name */
    private RichStatus f282132g0;

    /* renamed from: h0, reason: collision with root package name */
    private ClickableImageSpan f282133h0;

    /* renamed from: i0, reason: collision with root package name */
    private Intent f282134i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f282135j0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f282136k0;

    /* renamed from: l0, reason: collision with root package name */
    Drawable f282137l0;

    /* renamed from: m0, reason: collision with root package name */
    boolean f282138m0;

    /* renamed from: n0, reason: collision with root package name */
    long f282139n0;

    /* renamed from: o0, reason: collision with root package name */
    View f282140o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.tencent.mobileqq.richstatus.d f282141p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f282142q0;

    /* renamed from: r0, reason: collision with root package name */
    private TextWatcher f282143r0;

    /* renamed from: s0, reason: collision with root package name */
    protected View.OnClickListener f282144s0;

    /* renamed from: t0, reason: collision with root package name */
    private RichStatusEditText.c f282145t0;

    /* renamed from: u0, reason: collision with root package name */
    protected String f282146u0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.mobileqq.richstatus.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.d
        public void v2(int i3, int i16) {
            com.tencent.mobileqq.richstatus.a J;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == 102 && EditActivity.this.f282132g0.actionId != 0 && " ".equals(EditActivity.this.f282132g0.actionText) && (J = EditActivity.this.f282131f0.J(EditActivity.this.f282132g0.actionId)) != null) {
                EditActivity.this.f282132g0.actionText = J.f282299f;
                EditActivity.this.R2(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            EditActivity.f282123v0 = true;
            ReportController.o(EditActivity.this.app, "CliOper", "", "", "signiture", "set_clk_mdf", 0, 0, "", "", "", "");
            if (EditActivity.this.f282127b0.getSelectionStart() == 7 && EditActivity.this.f282127b0.getText().toString().trim().length() == 7) {
                EditActivity.this.f282127b0.setSelection(editable.length());
            }
            EditActivity.this.S2();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            QLog.d("EditActivity", 2, "beforeTextChanged CharSequence = " + ((Object) charSequence) + ", start = " + i3 + ", count = " + i16 + ", after = " + i17);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            QLog.d("EditActivity", 2, "onTextChanged CharSequence = " + ((Object) charSequence) + ", start = " + i3 + ", count = " + i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EditActivity.this.N2();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements RichStatusEditText.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.RichStatusEditText.c
        public boolean a(ClickableImageSpan clickableImageSpan) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clickableImageSpan)).booleanValue();
            }
            if (clickableImageSpan == EditActivity.this.f282133h0) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.richstatus.RichStatusEditText.c
        public void b(ClickableImageSpan clickableImageSpan) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) clickableImageSpan);
            } else if (EditActivity.this.f282133h0 == clickableImageSpan) {
                if (EditActivity.this.f282133h0 != null) {
                    EditActivity.this.f282133h0.setClickListener(null);
                }
                EditActivity.this.f282133h0 = null;
            }
        }
    }

    public EditActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f282130e0 = 47;
        this.f282138m0 = false;
        this.f282139n0 = 0L;
        this.f282141p0 = new a();
        this.f282142q0 = true;
        this.f282143r0 = new b();
        this.f282144s0 = new c();
        this.f282145t0 = new d();
        this.f282146u0 = null;
    }

    private Drawable P2(boolean z16, boolean z17) {
        SignatureManager signatureManager = (SignatureManager) this.app.getManager(QQManagerFactory.SIGNATURE_MANAGER);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.f168234pv, (ViewGroup) null);
        inflate.setPadding(0, 0, 0, 0);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.def);
        TextView textView = (TextView) inflate.findViewById(R.id.deg);
        RichStatus richStatus = this.f282132g0;
        String str = richStatus.actionText;
        if (richStatus.dataText != null) {
            str = str + this.f282132g0.dataText;
        }
        if (str.length() > 10) {
            str = str.substring(0, 9) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        textView.setText(str);
        if (z17) {
            textView.setTextColor(Color.parseColor("#ffa8a8a8"));
        } else {
            SignatureTemplateInfo signatureTemplateInfo = signatureManager.f195077h;
            if (signatureTemplateInfo != null && !TextUtils.isEmpty(signatureTemplateInfo.fontColor)) {
                textView.setTextColor(Color.parseColor(signatureManager.f195077h.fontColor));
            }
        }
        imageView.setImageBitmap(this.f282131f0.K(this.f282132g0.actionId, 200));
        inflate.setBackgroundResource(R.drawable.f162392gm4);
        return Q2(inflate);
    }

    private Drawable Q2(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        if (QLog.isColorLevel()) {
            QLog.d("EditActivity", 2, "tv.getWidth() = " + view.getWidth() + ",tv.getHeight()" + view.getHeight());
        }
        try {
            Canvas canvas = new Canvas(Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888));
            canvas.translate(-view.getScrollX(), -view.getScrollY());
            view.draw(canvas);
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("EditActivity", 2, "cacheBm is null");
                }
                return null;
            }
            Bitmap copy = drawingCache.copy(Bitmap.Config.ARGB_8888, true);
            view.destroyDrawingCache();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), copy);
            bitmapDrawable.setBounds(0, 0, copy.getWidth(), copy.getHeight());
            return bitmapDrawable;
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("EditActivity", 2, e16.getMessage());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(boolean z16) {
        if (this.f282132g0.actionId == 0) {
            ClickableImageSpan clickableImageSpan = this.f282133h0;
            if (clickableImageSpan != null) {
                this.f282127b0.p(clickableImageSpan, true, true);
                return;
            }
            return;
        }
        Drawable P2 = P2(false, z16);
        Drawable P22 = P2(true, z16);
        if (P2 != null && P22 != null) {
            ClickableImageSpan clickableImageSpan2 = new ClickableImageSpan(P2, P22);
            if (this.f282135j0 != 1) {
                clickableImageSpan2.setEnable(false);
            }
            ClickableImageSpan clickableImageSpan3 = this.f282133h0;
            if (clickableImageSpan3 != null && clickableImageSpan3.getDrawable() != null) {
                clickableImageSpan2.getDrawable().setState(this.f282133h0.getDrawable().getState());
            }
            Editable editableText = this.f282127b0.getEditableText();
            if (editableText == null) {
                return;
            }
            if (((ImageSpan[]) editableText.getSpans(0, editableText.length(), ClickableImageSpan.class)).length > 0) {
                this.f282127b0.r(this.f282133h0, clickableImageSpan2);
            } else {
                this.f282127b0.getText().insert(0, RichStatus.EVENT_SPAN_PLACE_HOLDER);
                this.f282127b0.setSpan(clickableImageSpan2, 0, 3);
            }
            this.f282133h0 = clickableImageSpan2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2() {
        int i3;
        SignatureManager signatureManager = (SignatureManager) this.app.getManager(QQManagerFactory.SIGNATURE_MANAGER);
        if (!this.f282142q0) {
            return;
        }
        if (this.f282133h0 != null) {
            i3 = Math.max(this.f282127b0.getText().getSpanEnd(this.f282133h0), 0);
        } else {
            i3 = 0;
        }
        int length = this.f282127b0.getText().length();
        if (this.f282132g0 == null || (length == 0 && this.f282135j0 == 1)) {
            RichStatus richStatus = new RichStatus(null);
            this.f282132g0 = richStatus;
            richStatus.plainText = new ArrayList<>();
            while (this.f282132g0.plainText.size() < 2) {
                this.f282132g0.plainText.add(null);
            }
        }
        SignatureTemplateInfo signatureTemplateInfo = signatureManager.f195077h;
        if (signatureTemplateInfo == null || signatureTemplateInfo.imageItem == null) {
            if (this.f282135j0 == 1) {
                this.f282132g0.plainText.set(0, this.f282127b0.getText().subSequence(i3, length).toString().trim());
            } else {
                this.f282132g0.plainText.set(0, this.f282127b0.getText().subSequence(i3, length).toString());
            }
        }
        this.f282132g0.plainText.set(1, null);
        int countLength = this.f282132g0.countLength();
        RichStatus richStatus2 = this.f282132g0;
        if (richStatus2 != null && richStatus2.actionText != null && richStatus2.actionId == 0) {
            countLength -= 7;
        }
        String num = Integer.toString(this.f282130e0 - countLength);
        if (countLength > this.f282130e0) {
            this.f282128c0.setTextColor(SupportMenu.CATEGORY_MASK);
            this.f282128c0.setText(num);
        } else {
            this.f282128c0.setTextColor(Color.parseColor("#777777"));
            this.f282128c0.setText(num);
        }
    }

    protected void N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.f282135j0 == 1) {
            if (this.f282132g0.countLength() > this.f282130e0) {
                toast(R.string.h2k);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("param_new_xuan_yan", this.f282132g0.encode());
            setResult(-1, intent);
            super.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && i3 == 17) {
            Intent intent2 = this.f282134i0;
            if (intent2 == null) {
                this.f282134i0 = intent;
            } else {
                intent2.putExtras(intent);
            }
            this.f282132g0.actionId = (int) this.f282134i0.getLongExtra("k_action_id", 0L);
            this.f282132g0.actionText = this.f282134i0.getStringExtra("k_action_text");
            if (TextUtils.isEmpty(this.f282132g0.actionText)) {
                com.tencent.mobileqq.richstatus.a J = this.f282131f0.J(this.f282132g0.actionId);
                RichStatus richStatus = this.f282132g0;
                if (J != null) {
                    str = J.f282299f;
                } else {
                    str = " ";
                }
                richStatus.actionText = str;
            }
            this.f282132g0.dataId = (int) intent.getLongExtra(SignJsPlugin.PARAM_DATA_ID, 0L);
            this.f282132g0.dataText = intent.getStringExtra(SignJsPlugin.PARAM_DATA_TEXT);
            R2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f282135j0 = getIntent().getIntExtra("param_entry", 0);
        int intExtra = getIntent().getIntExtra("max_word_count", -1);
        if (intExtra != -1) {
            this.f282130e0 = intExtra;
        }
        if (this.f282135j0 == 1) {
            super.setContentView(R.layout.bz4);
        } else {
            super.setContentViewNoTitle(R.layout.bz4);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        f282124w0 = displayMetrics.heightPixels;
        f282125x0 = displayMetrics.widthPixels;
        StatusManager statusManager = (StatusManager) this.app.getManager(QQManagerFactory.STATUS_MANAGER);
        this.f282131f0 = statusManager;
        if (statusManager == null) {
            toast(R.string.g0j);
            super.finish();
            return false;
        }
        if (statusManager.T()) {
            toast(R.string.h2o);
            super.finish();
            return false;
        }
        this.f282137l0 = new ColorDrawable(Color.parseColor("#dedede"));
        this.f282131f0.C(this.f282141p0);
        this.f282136k0 = (LinearLayout) super.findViewById(R.id.dmz);
        this.f282140o0 = super.findViewById(R.id.dmv);
        if (this.f282135j0 == 1) {
            LayoutInflater.from(this).inflate(R.layout.bz5, (ViewGroup) this.f282136k0, true);
            setTitle(HardCodeUtil.qqStr(R.string.lv7));
            this.leftView.setText(R.string.f170549u3);
            this.f282140o0.setVisibility(4);
            TextView textView = (TextView) super.findViewById(R.id.bap);
            this.f282128c0 = textView;
            textView.setTextColor(getResources().getColor(R.color.skin_gray3));
            RichStatusEditText richStatusEditText = (RichStatusEditText) super.findViewById(R.id.input_edit);
            this.f282127b0 = richStatusEditText;
            richStatusEditText.setHint(HardCodeUtil.qqStr(R.string.f171919lv4));
            this.f282127b0.setEditListener(this.f282145t0);
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("param_old_xuan_yan");
            if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                this.f282132g0 = RichStatus.parseStatus(byteArrayExtra);
            } else {
                this.f282132g0 = new RichStatus(null);
            }
            RichStatus richStatus = this.f282132g0;
            richStatus.locationText = "";
            ArrayList<String> arrayList = richStatus.plainText;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f282132g0.plainText = arrayList;
            }
            while (arrayList.size() < 2) {
                arrayList.add(null);
            }
            this.f282127b0.setText("");
            R2(false);
            if (arrayList.get(0) != null) {
                this.f282127b0.getText().append((CharSequence) arrayList.get(0));
            }
            if (arrayList.get(1) != null) {
                this.f282127b0.getText().append((CharSequence) arrayList.get(1));
            }
            S2();
            this.f282127b0.addTextChangedListener(this.f282143r0);
            View findViewById = super.findViewById(R.id.egj);
            this.f282129d0 = findViewById;
            findViewById.setVisibility(8);
            this.leftView.setOnClickListener(this.f282144s0);
            ((RelativeLayout) super.findViewById(R.id.a58)).setVisibility(8);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        URLDrawable.resume();
        ClickableImageSpan clickableImageSpan = this.f282133h0;
        if (clickableImageSpan != null) {
            clickableImageSpan.setClickListener(null);
        }
        StatusManager statusManager = this.f282131f0;
        if (statusManager != null) {
            statusManager.b0(this.f282141p0);
        }
        RichStatusEditText richStatusEditText = this.f282127b0;
        if (richStatusEditText != null) {
            richStatusEditText.removeTextChangedListener(this.f282143r0);
            this.f282127b0.setEditListener(null);
        }
        hideInputMethod();
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f282138m0 = false;
        hideInputMethod();
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bundle);
            return;
        }
        this.f282142q0 = false;
        super.doOnRestoreInstanceState(bundle);
        this.f282142q0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f282138m0 = true;
        if (this.f282135j0 == 1) {
            showInputMethod();
        }
        super.doOnResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle);
            return;
        }
        RichStatus richStatus = this.f282132g0;
        if (richStatus != null) {
            bundle.putByteArray("param_rich_status", richStatus.encode());
        }
        super.doOnSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        SignatureTemplateInfo signatureTemplateInfo = ((SignatureManager) this.app.getManager(QQManagerFactory.SIGNATURE_MANAGER)).f195077h;
        if (signatureTemplateInfo != null && signatureTemplateInfo.imageItem == null) {
            this.f282127b0.setVisibility(0);
        }
        super.doOnStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        RichStatusEditText richStatusEditText = this.f282127b0;
        if (richStatusEditText != null) {
            richStatusEditText.setVisibility(4);
        }
        super.doOnStop();
    }

    void hideInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f282135j0 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        this.f282126a0 = System.currentTimeMillis();
        if (this.f282135j0 == 1) {
            if (this.f282132g0.countLength() > this.f282130e0) {
                toast(R.string.h2k);
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra("param_new_xuan_yan", this.f282132g0.encode());
            setResult(-1, intent);
            super.finish();
            return super.onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    @TargetApi(9)
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            view.getId();
            if (view.getId() != R.id.input_edit) {
                hideInputMethod();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) absListView, i3);
        } else if (i3 == 0) {
            URLDrawable.resume();
        } else {
            URLDrawable.pause();
        }
    }

    void showInputMethod() {
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.richstatus.EditActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    EditActivity.this.f282127b0.requestFocus();
                    ((InputMethodManager) EditActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(EditActivity.this.f282127b0, 2);
                }
            }
        }, 500L);
    }

    protected void toast(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            QQToast.makeText(getActivity(), i3, 0).show(getTitleBarHeight());
        }
    }
}
