package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanelUtils;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class EditActivity extends IphoneTitleBarActivity implements EmoticonCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f175662a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f175663b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f175664c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f175665d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f175666e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f175667f0;

    /* renamed from: g0, reason: collision with root package name */
    ClearableEditText f175668g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f175669h0;

    /* renamed from: i0, reason: collision with root package name */
    TextView f175670i0;

    /* renamed from: j0, reason: collision with root package name */
    TextView f175671j0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f175672k0;

    /* renamed from: l0, reason: collision with root package name */
    private IEmoticonMainPanel f175673l0;

    /* renamed from: m0, reason: collision with root package name */
    private LinearLayout f175674m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f175675n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f175676o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f175677p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f175678q0;

    /* renamed from: r0, reason: collision with root package name */
    private QQProgressDialog f175679r0;

    /* renamed from: s0, reason: collision with root package name */
    int f175680s0;

    /* renamed from: t0, reason: collision with root package name */
    private Dialog f175681t0;

    /* renamed from: u0, reason: collision with root package name */
    float f175682u0;

    /* renamed from: v0, reason: collision with root package name */
    private FavEmoRoamingObserver f175683v0;

    /* renamed from: w0, reason: collision with root package name */
    private TextWatcher f175684w0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends FavEmoRoamingObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
        protected void onModifyFavData(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                EditActivity.this.T2();
                if (z16) {
                    CustomEmotionData customEmotionData = (CustomEmotionData) obj;
                    if (customEmotionData != null) {
                        ((IFavroamingManagerService) EditActivity.this.app.getRuntimeService(IFavroamingManagerService.class)).updateCustomEmotionDataOCR(customEmotionData);
                        EditActivity.this.Z2();
                        return;
                    }
                    return;
                }
                if (obj instanceof String) {
                    QQToast.makeText(EditActivity.this, 1, (String) obj, 1).show();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
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
                EditActivity.this.f175662a0 = !r0.f175662a0;
                if (EditActivity.this.f175662a0) {
                    EditActivity.this.hideInputMethod();
                    EditActivity.this.f175672k0.setImageResource(R.drawable.f160147bi);
                    if (EditActivity.this.f175674m0 != null) {
                        EditActivity.this.f175674m0.setVisibility(0);
                    }
                } else {
                    if (EditActivity.this.f175674m0 != null) {
                        EditActivity.this.f175674m0.setVisibility(4);
                    }
                    EditActivity.this.f175672k0.setImageResource(R.drawable.asw);
                    EditActivity.this.showInputMethod();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
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
                EditActivity.this.f175674m0.setVisibility(4);
                EditActivity.this.f175672k0.setImageResource(R.drawable.asw);
                EditActivity.this.f175662a0 = false;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
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
                EditActivity.this.hideInputMethod();
                EditActivity editActivity = EditActivity.this;
                if (editActivity.f175680s0 != 105) {
                    editActivity.Z2();
                } else {
                    Editable text = editActivity.f175668g0.getText();
                    if (text != null) {
                        String trim = text.toString().trim();
                        if (trim.length() == 0) {
                            EditActivity editActivity2 = EditActivity.this;
                            QQToast.makeText(editActivity2, editActivity2.getString(R.string.inm), 0).show();
                        } else if (EditActivity.this.W2(trim)) {
                            EditActivity editActivity3 = EditActivity.this;
                            QQToast.makeText(editActivity3, editActivity3.getString(R.string.inn), 0).show();
                        } else {
                            IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) EditActivity.this.app.getRuntimeService(IFavroamingDBManagerService.class);
                            IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) EditActivity.this.app.getRuntimeService(IFavroamingManagerService.class);
                            List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
                            if (EditActivity.this.f175667f0 != -1 && emoticonDataList != null) {
                                Iterator<CustomEmotionData> it = emoticonDataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    CustomEmotionData next = it.next();
                                    if (EditActivity.this.f175667f0 == next.emoId) {
                                        EditActivity.this.b3();
                                        iFavroamingManagerService.updateCustomEmotionDataOCRReq(next, trim);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements TextWatcher {
        static IPatchRedirector $redirector_;
        boolean C;

        /* renamed from: d, reason: collision with root package name */
        String f175689d;

        /* renamed from: e, reason: collision with root package name */
        String f175690e;

        /* renamed from: f, reason: collision with root package name */
        String f175691f;

        /* renamed from: h, reason: collision with root package name */
        boolean f175692h;

        /* renamed from: i, reason: collision with root package name */
        int f175693i;

        /* renamed from: m, reason: collision with root package name */
        boolean f175694m;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditActivity.this);
                return;
            }
            this.f175692h = true;
            this.f175693i = 0;
            this.f175694m = true;
            this.C = false;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                EditActivity.this.f175678q0 = true;
                if (!this.f175694m) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.f175689d);
                if (this.f175692h) {
                    str = this.f175691f;
                } else {
                    str = "";
                }
                sb5.append(str);
                sb5.append(this.f175690e);
                String sb6 = sb5.toString();
                if (this.C) {
                    this.f175694m = false;
                    EditActivity.this.f175668g0.setText(sb6);
                    this.f175694m = true;
                }
                EditActivity.this.f175668g0.setSelection(this.f175689d.length() + this.f175693i);
                EditActivity.this.Y2();
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (!this.f175694m) {
                return;
            }
            this.C = false;
            this.f175689d = charSequence.toString().substring(0, i3);
            this.f175690e = charSequence.toString().substring(i3 + i16);
            if (i17 > 0) {
                this.f175692h = true;
            } else {
                this.f175692h = false;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (!this.f175694m) {
                return;
            }
            String substring = charSequence.toString().substring(i3, i17 + i3);
            this.f175691f = substring;
            if (this.f175692h) {
                if (EditActivity.this.f175680s0 == 100 && substring.contains("\n")) {
                    this.C = true;
                    this.f175691f = this.f175691f.replace("\n", "");
                }
                this.f175693i = this.f175691f.length();
                return;
            }
            this.f175693i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
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
                if (EditActivity.this.f175681t0 != null && EditActivity.this.f175681t0.isShowing() && EditActivity.this.f175681t0.getWindow() != null) {
                    EditActivity.this.f175681t0.dismiss();
                }
                EditActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
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
            } else if (EditActivity.this.f175681t0 != null && EditActivity.this.f175681t0.isShowing() && EditActivity.this.f175681t0.getWindow() != null) {
                EditActivity.this.f175681t0.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public EditActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175662a0 = false;
        this.f175663b0 = 0;
        this.f175664c0 = 0;
        this.f175675n0 = 0;
        this.f175676o0 = false;
        this.f175677p0 = true;
        this.f175678q0 = false;
        this.f175682u0 = 1.5f;
        this.f175683v0 = new a();
        this.f175684w0 = new e();
    }

    private void S2() {
        int i3 = this.f175680s0;
        if (i3 != 102 && i3 != 105) {
            this.f175671j0.setVisibility(8);
            this.f175669h0.setVisibility(0);
            ClearableEditText clearableEditText = this.f175668g0;
            clearableEditText.setPadding(clearableEditText.getPaddingLeft(), this.f175668g0.getPaddingTop(), this.f175668g0.getPaddingRight(), com.tencent.mobileqq.util.x.c(this, 30.0f));
            this.f175668g0.setMinHeight(com.tencent.mobileqq.util.x.c(this, 74.0f));
            return;
        }
        this.f175671j0.setVisibility(0);
        this.f175669h0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        QQProgressDialog qQProgressDialog = this.f175679r0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f175679r0.dismiss();
        }
    }

    private int U2(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.trim().length();
    }

    private void V2() {
        ImageView imageView = (ImageView) findViewById(R.id.j9_);
        this.f175672k0 = imageView;
        imageView.setVisibility(0);
        this.f175672k0.setOnClickListener(new b());
        IEmoticonMainPanel initEmojiPanel = EmoticonMainPanelUtils.initEmojiPanel(this.app, this, this.f175668g0, this);
        this.f175673l0 = initEmojiPanel;
        initEmojiPanel.getView().setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.bvt);
        this.f175674m0 = linearLayout;
        linearLayout.addView(this.f175673l0.getView());
        this.f175668g0.setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W2(String str) {
        if (str.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*,*\uff0c*\u3002*\u3001*\uff1f*\\?*!*\uff01*_*\\s*", "").length() == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2() {
        String obj = this.f175668g0.getText().toString();
        Intent intent = getIntent();
        intent.putExtra("result", obj);
        if (this.f175680s0 == 103) {
            intent.putExtra("hasChange", this.f175678q0);
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3() {
        if (this.f175679r0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.f175679r0 = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.inv);
        }
        this.f175679r0.show();
    }

    private void c3() {
        hideInputMethod();
        if (this.f175681t0 == null) {
            this.f175681t0 = DialogUtil.createContentOnlyDialog(this, HardCodeUtil.qqStr(R.string.lv6), R.string.bjz, R.string.f171032bu3, new f(), new g());
        }
        this.f175681t0.show();
    }

    private void initUI() {
        this.f175682u0 = getResources().getDisplayMetrics().density;
        this.f175669h0 = (TextView) findViewById(R.id.cxq);
        this.f175670i0 = (TextView) findViewById(R.id.f165398lk3);
        this.f175671j0 = (TextView) findViewById(R.id.cxr);
        this.f175668g0.addTextChangedListener(this.f175684w0);
        this.f175668g0.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        if (getIntent().getBooleanExtra("key_null_bg", false)) {
            this.f175668g0.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
            this.f175668g0.setPadding((int) com.tencent.mobileqq.utils.al.a(this, 10.0f), (int) com.tencent.mobileqq.utils.al.a(this, 10.0f), (int) com.tencent.mobileqq.utils.al.a(this, 10.0f), (int) com.tencent.mobileqq.utils.al.a(this, 30.0f));
        }
        this.f175668g0.requestFocus();
        if (getIntent().getBooleanExtra("key_hide_clear_btn", false)) {
            this.f175668g0.setClearButtonStyle(1);
        }
        setTitle(this.f175663b0);
        if (!TextUtils.isEmpty(this.f175666e0)) {
            this.f175670i0.setText(this.f175666e0);
            this.f175670i0.setVisibility(0);
        }
        if (getIntent().getIntExtra("key_title_style", 0) == 0) {
            setRightHighlightButton(R.string.b9f, new d());
            Resources resources = getResources();
            enableRightHighlight(true);
            TextView textView = this.rightViewText;
            if (textView != null && resources != null) {
                textView.setTextColor(resources.getColorStateList(R.color.qui_common_text_nav_secondary_selector));
            }
            TextView textView2 = this.rightHighLView;
            if (textView2 != null && resources != null) {
                textView2.setTextColor(resources.getColorStateList(R.color.qui_common_text_nav_secondary_selector));
            }
        } else if (getIntent().getIntExtra("key_title_style", 0) == 1) {
            this.leftView.setText(R.string.f170549u3);
        }
        ViewGroup.LayoutParams layoutParams = this.f175668g0.getLayoutParams();
        if (!this.f175676o0) {
            this.f175668g0.setSingleLine(true);
            this.f175668g0.setText(this.f175665d0);
            int length = this.f175668g0.getText().length();
            this.f175668g0.setSelection(length, length);
            if (layoutParams != null) {
                int i3 = this.f175680s0;
                if (i3 != 102 && i3 != 105) {
                    layoutParams.height = (int) (this.f175682u0 * 74.0f);
                } else {
                    layoutParams.height = (int) (this.f175682u0 * 48.0f);
                }
            }
        } else {
            this.f175668g0.setSingleLine(false);
            this.f175668g0.setText(this.f175665d0);
            int length2 = this.f175668g0.getText().length();
            this.f175668g0.setSelection(length2, length2);
            this.f175668g0.setGravity(48);
            if (layoutParams != null) {
                layoutParams.height = (int) (this.f175682u0 * 150.0f);
            }
        }
        if (layoutParams != null) {
            this.f175668g0.setLayoutParams(layoutParams);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.EditActivity.5
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
                    EditActivity.this.showInputMethod();
                }
            }
        }, 500L);
    }

    void Y2() {
        int i3;
        ColorStateList colorStateList;
        String str;
        String obj = this.f175668g0.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            byte[] bArr = new byte[0];
            try {
                bArr = obj.getBytes("utf-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            i3 = bArr.length;
            if (this.f175680s0 == 105) {
                i3 = U2(obj);
            }
        } else {
            i3 = 0;
        }
        if (i3 > this.f175664c0) {
            colorStateList = getResources().getColorStateList(R.color.qui_common_feedback_error);
        } else {
            colorStateList = getResources().getColorStateList(R.color.qui_common_text_secondary);
        }
        if (getIntent().getBooleanExtra("key_simple_count_style", false)) {
            int i16 = this.f175664c0;
            if (i3 > i16) {
                str = String.valueOf(((i16 - i3) - 2) / 3);
            } else {
                str = String.valueOf((i16 - i3) / 3);
            }
        } else if (i3 > this.f175664c0) {
            str = getString(R.string.a_d) + "\uff01 " + i3 + "/" + this.f175664c0;
        } else {
            str = i3 + "/" + this.f175664c0;
        }
        if (colorStateList != null) {
            this.f175669h0.setTextColor(colorStateList);
            this.f175671j0.setTextColor(colorStateList);
        }
        this.f175669h0.setText(str);
        this.f175671j0.setText(str);
        if (this.f175680s0 == 101 && TextUtils.isEmpty(obj.trim())) {
            enableRightHighlight(false);
            return;
        }
        if (this.f175680s0 == 105) {
            int i17 = this.f175664c0;
            if (i3 > i17) {
                this.f175668g0.setText(obj.substring(0, i17));
            }
            enableRightHighlight(true);
            return;
        }
        if (i3 > 0 && i3 <= this.f175664c0) {
            enableRightHighlight(true);
        } else if (i3 == 0 && this.f175677p0) {
            enableRightHighlight(true);
        } else {
            enableRightHighlight(false);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            com.tencent.mobileqq.text.TextUtils.backspace(this.f175668g0);
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
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        this.f175675n0 = intent.getIntExtra("support_emotion", 0);
        this.f175680s0 = intent.getIntExtra("action", 0);
        super.setContentView(R.layout.f168012oy);
        setContentBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        this.f175668g0 = (ClearableEditText) findViewById(R.id.cxp);
        if (this.f175675n0 == 1) {
            V2();
        }
        this.f175663b0 = intent.getIntExtra("title", 0);
        this.f175664c0 = intent.getIntExtra("limit", 0);
        this.f175667f0 = intent.getIntExtra("key_emo_id", -1);
        this.f175676o0 = intent.getBooleanExtra("multiLine", false);
        this.f175677p0 = intent.getBooleanExtra("canPostNull", true);
        this.f175665d0 = intent.getStringExtra("current");
        this.f175666e0 = intent.getStringExtra("key_input_tip");
        String str = "";
        if (this.f175665d0 == null) {
            this.f175665d0 = "";
        }
        initUI();
        S2();
        int i3 = this.f175680s0;
        if (i3 == 103) {
            str = HardCodeUtil.qqStr(R.string.f171918lv3);
        } else if (i3 != 102) {
            if (i3 == 105) {
                str = getString(R.string.ino);
            } else {
                str = HardCodeUtil.qqStr(R.string.lv5) + getString(this.f175663b0);
            }
        }
        this.f175668g0.setHint(str);
        if (AppSetting.f99565y) {
            this.f175668g0.setContentDescription(str);
        }
        if (this.f175680s0 == 105) {
            addObserver(this.f175683v0);
        }
        if (isInMultiWindow() && (relativeLayout = this.titleRoot) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
            marginLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this) - ViewUtils.dpToPx(9.0f), 0, 0);
            this.titleRoot.setLayoutParams(marginLayoutParams);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.f175673l0;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onDestory();
        }
        ViewGroup viewGroup = (ViewGroup) this.f175668g0.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f175668g0);
        }
        if (this.f175680s0 == 105) {
            removeObserver(this.f175683v0);
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public void enableRightHighlight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        super.enableRightHighlight(z16);
        int currentTextColor = this.rightViewText.getCurrentTextColor();
        if (!z16 && currentTextColor == -1) {
            this.rightViewText.setAlpha(0.6f);
        } else {
            this.rightViewText.setAlpha(1.0f);
        }
    }

    void hideInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        View peekDecorView = getWindow().peekDecorView();
        if (peekDecorView != null && peekDecorView.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (getIntent().getIntExtra("key_title_style", 0) == 1) {
            String obj = this.f175668g0.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                byte[] bArr = new byte[0];
                try {
                    bArr = obj.getBytes("utf-8");
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
                i3 = bArr.length;
                if (this.f175680s0 == 105) {
                    i3 = U2(obj);
                }
            } else {
                i3 = 0;
            }
            if (i3 > this.f175664c0) {
                QQToast.makeText(this, R.string.her, 0).show(getTitleBarHeight());
                return true;
            }
            hideInputMethod();
            Intent intent = getIntent();
            intent.putExtra("result", obj);
            setResult(-1, intent);
            finish();
            return false;
        }
        String obj2 = this.f175668g0.getText().toString();
        if (this.f175680s0 == 104 && !TextUtils.equals(obj2, this.f175665d0)) {
            c3();
            return true;
        }
        hideInputMethod();
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            hideInputMethod();
            super.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.f175662a0) {
            showInputMethod();
        }
        super.onResume();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, emoticonInfo, emoticonInfo2, drawable);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    void showInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        ClearableEditText clearableEditText = this.f175668g0;
        if (clearableEditText != null) {
            inputMethodManager.showSoftInput(clearableEditText, 2);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            emoticonInfo.send(this.app, this, this.f175668g0, null);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) emoticonInfo);
        }
    }
}
