package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView;
import com.tencent.aelight.camera.aioeditor.capture.text.w;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleTextView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditTextDialog extends ReportDialog implements XPanelContainer.g, Handler.Callback, EditTextPanel.b, AEHorizontalSelectColorLayout.d {
    public ViewGroup C;
    public FitSystemWindowsRelativeLayout D;
    public XPanelContainer E;
    public EditText F;
    public View G;
    public AEHorizontalSelectColorLayout H;
    private int I;
    private float J;
    private float K;
    private int L;
    private int M;
    private QQToast N;
    protected int P;
    public i Q;
    public ViewTreeObserver.OnGlobalLayoutListener R;
    public int S;
    public int T;
    public int U;
    public String V;
    public int W;
    public int X;
    public vr.b Y;
    protected final MqqHandler Z;

    /* renamed from: a0, reason: collision with root package name */
    EditTextPanel f68087a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f68088b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f68089c0;

    /* renamed from: d0, reason: collision with root package name */
    Context f68090d0;

    /* renamed from: e0, reason: collision with root package name */
    EditTextPreView f68091e0;

    /* renamed from: f0, reason: collision with root package name */
    DynamicTextBuilder f68092f0;

    /* renamed from: g0, reason: collision with root package name */
    public DynamicTextItem.TextMap f68093g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f68094h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f68095i0;

    /* renamed from: j0, reason: collision with root package name */
    public RelativeLayout f68096j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f68097k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f68098l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f68099m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f68100n0;

    /* renamed from: o0, reason: collision with root package name */
    private PressScaleTextView f68101o0;

    /* renamed from: p0, reason: collision with root package name */
    private View f68102p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f68103q0;

    /* renamed from: r0, reason: collision with root package name */
    private InputFilter[] f68104r0;

    /* renamed from: s0, reason: collision with root package name */
    private InputFilter[] f68105s0;

    /* renamed from: t0, reason: collision with root package name */
    public DynamicTextItem f68106t0;

    /* renamed from: u0, reason: collision with root package name */
    public DynamicTextItem f68107u0;

    /* renamed from: v0, reason: collision with root package name */
    public String f68108v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f68109w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f68110x0;

    /* renamed from: y0, reason: collision with root package name */
    private View.OnClickListener f68111y0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class InitialLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        InitialLayoutListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int bottom = EditTextDialog.this.G.getBottom();
            EditTextDialog editTextDialog = EditTextDialog.this;
            int i3 = editTextDialog.T;
            if (i3 < 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("EditTextDialog", 2, "onGlobalLayout first bottom:" + bottom);
                }
                EditTextDialog editTextDialog2 = EditTextDialog.this;
                editTextDialog2.T = bottom;
                editTextDialog2.Z.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditTextDialog editTextDialog3 = EditTextDialog.this;
                        editTextDialog3.Q.e(editTextDialog3.f68095i0 != 0);
                    }
                });
                return;
            }
            if (i3 - bottom > editTextDialog.S) {
                if (QLog.isColorLevel()) {
                    QLog.i("EditTextDialog", 2, "onGlobalLayout second bottom:" + bottom);
                }
                EditTextDialog.this.C.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                EditTextDialog.this.C.getViewTreeObserver().addOnGlobalLayoutListener(EditTextDialog.this.R);
                EditTextDialog editTextDialog3 = EditTextDialog.this;
                editTextDialog3.T = bottom;
                editTextDialog3.C.requestLayout();
                EditTextDialog.this.Z.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EditTextDialog editTextDialog4 = EditTextDialog.this;
                        editTextDialog4.Q.b(editTextDialog4.j0(), EditTextDialog.this.k0());
                        EditTextDialog.this.Q.c(true);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class LayoutChangeListener implements ViewTreeObserver.OnGlobalLayoutListener {
        LayoutChangeListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int bottom = EditTextDialog.this.G.getBottom();
            if (QLog.isColorLevel()) {
                QLog.i("EditTextDialog", 2, "onGlobalLayout third bottom:" + bottom + " last:" + EditTextDialog.this.T);
            }
            AEHorizontalSelectColorLayout aEHorizontalSelectColorLayout = EditTextDialog.this.H;
            if (aEHorizontalSelectColorLayout != null) {
                int[] iArr = new int[2];
                aEHorizontalSelectColorLayout.getLocationOnScreen(iArr);
                int i3 = iArr[1];
                int f16 = i3 - BaseAIOUtils.f(62.0f, BaseApplication.getContext().getResources());
                if (f16 < EditTextDialog.this.I) {
                    EditTextDialog.this.I = f16;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EditTextDialog", 2, "max height" + f16 + "preViewTextMaxHeight" + EditTextDialog.this.I + "y" + i3);
                }
            }
            EditTextDialog editTextDialog = EditTextDialog.this;
            if (bottom - editTextDialog.T > editTextDialog.S) {
                editTextDialog.e0(false);
                DynamicTextItem dynamicTextItem = EditTextDialog.this.f68106t0;
                if (dynamicTextItem != null) {
                    dynamicTextItem.f66900m = false;
                    return;
                }
                return;
            }
            editTextDialog.Z.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LayoutChangeListener.1
                @Override // java.lang.Runnable
                public void run() {
                    EditTextDialog editTextDialog2 = EditTextDialog.this;
                    editTextDialog2.Q.d(editTextDialog2.l0());
                    EditTextDialog editTextDialog3 = EditTextDialog.this;
                    editTextDialog3.Q.b(editTextDialog3.j0(), EditTextDialog.this.k0());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EditTextDialog.this.f68099m0 = true;
            EditTextDialog editTextDialog = EditTextDialog.this;
            DynamicTextItem dynamicTextItem = editTextDialog.f68107u0;
            if (dynamicTextItem != null) {
                editTextDialog.f68098l0 = false;
                editTextDialog.f68106t0 = dynamicTextItem;
                dynamicTextItem.M(editTextDialog.L, EditTextDialog.this.f68108v0);
                EditTextDialog editTextDialog2 = EditTextDialog.this;
                editTextDialog2.f68106t0.N(editTextDialog2.f68110x0);
                EditTextDialog editTextDialog3 = EditTextDialog.this;
                DynamicTextItem dynamicTextItem2 = editTextDialog3.f68106t0;
                if (dynamicTextItem2 instanceof w) {
                    ((w) dynamicTextItem2).V(editTextDialog3.f68109w0);
                }
                EditTextDialog.this.e0(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EditTextDialog.this.e0(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private int f68124d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f68125e = false;

        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            motionEvent.getX();
            float y16 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f68124d = (int) y16;
                this.f68125e = false;
            } else {
                if (action == 1) {
                    return this.f68125e;
                }
                if (action == 2 && Math.abs(y16 - this.f68124d) > 10.0f) {
                    this.f68125e = true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EditTextDialog.this.F.setSelectAllOnFocus(false);
            EditText editText = EditTextDialog.this.F;
            editText.setSelection(editText.length());
            EditTextDialog.this.F.setOnClickListener(null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface i {
        void a(DynamicTextItem dynamicTextItem, boolean z16, int i3, boolean z17);

        void b(int i3, int i16);

        void c(boolean z16);

        void d(int i3);

        void e(boolean z16);

        void f();

        void onPanelChanged(int i3, int i16);

        void onWindowFocusChanged(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class j implements InputFilter {

        /* renamed from: d, reason: collision with root package name */
        protected int f68129d;

        /* renamed from: e, reason: collision with root package name */
        private QQToast f68130e;

        public j(int i3) {
            this.f68129d = i3;
        }

        public int a(CharSequence charSequence) {
            int length = charSequence.length();
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                char charAt = charSequence.charAt(i16);
                if (charAt == '\n' || charAt == '\r') {
                    i3++;
                }
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b() {
            if (this.f68130e == null) {
                this.f68130e = QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.lxd), 0);
            }
            if (this.f68130e.isShowing()) {
                return;
            }
            this.f68130e.show();
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int length = this.f68129d - (spanned.length() - (i18 - i17));
            int a16 = (i16 - i3) - a(charSequence.subSequence(i3, i16));
            if (length <= 0 || length < a16) {
                length += a(spanned);
            }
            if ((length <= 0 || length < a16) && !TextUtils.equals("", charSequence)) {
                b();
            }
            if (length <= 0) {
                return "";
            }
            if (length >= a16) {
                return null;
            }
            int i19 = length + i3;
            if (Character.isHighSurrogate(charSequence.charAt(i19 - 1)) && i19 - 1 == i3) {
                return "";
            }
            return charSequence.subSequence(i3, i19);
        }
    }

    private boolean d0() {
        String str = Build.MANUFACTURER;
        return (str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) || (DeviceInfoMonitor.getModel().equalsIgnoreCase("RedMI NOTE 8") || DeviceInfoMonitor.getModel().equalsIgnoreCase("OPPO a5") || DeviceInfoMonitor.getModel().equalsIgnoreCase("M2002J9E") || DeviceInfoMonitor.getModel().equalsIgnoreCase("Redmi 7") || DeviceInfoMonitor.getModel().equalsIgnoreCase("PCNM00") || DeviceInfoMonitor.getModel().equalsIgnoreCase("PBBM00") || DeviceInfoMonitor.getModel().equalsIgnoreCase("PCAM10") || DeviceInfoMonitor.getModel().equalsIgnoreCase("PCHM10"));
    }

    private void initView() {
        this.C = (ViewGroup) LayoutInflater.from(getContext()).inflate(g0(), (ViewGroup) null);
        this.R = new LayoutChangeListener();
        this.C.getViewTreeObserver().addOnGlobalLayoutListener(new InitialLayoutListener());
        FitSystemWindowsRelativeLayout fitSystemWindowsRelativeLayout = (FitSystemWindowsRelativeLayout) this.C.findViewById(R.id.if7);
        this.D = fitSystemWindowsRelativeLayout;
        fitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
        this.D.setOnTouchListener(new a());
        this.E = (XPanelContainer) this.C.findViewById(R.id.root);
        EditText editText = (EditText) this.C.findViewById(R.id.jhk);
        this.F = editText;
        editText.setHighlightColor(Color.parseColor("#cceae8"));
        this.G = this.C.findViewById(R.id.jhb);
        EditTextPanel editTextPanel = (EditTextPanel) this.C.findViewById(R.id.btx).findViewById(R.id.panelLayout);
        this.f68087a0 = editTextPanel;
        editTextPanel.setPanelListener(this);
        this.f68087a0.b(this.F);
        this.f68087a0.setOpIn(this.f68097k0);
        this.f68087a0.setEditPhoto(this.f68103q0);
        this.f68101o0 = (PressScaleTextView) this.C.findViewById(R.id.jgq);
        this.f68102p0 = this.C.findViewById(R.id.jgr);
        if (this.f68100n0) {
            this.f68101o0.setVisibility(0);
            this.f68102p0.setVisibility(0);
            this.f68101o0.setOnClickListener(new b());
            this.f68102p0.setOnClickListener(new c());
        }
        EditTextPreView editTextPreView = (EditTextPreView) this.C.findViewById(R.id.jhn);
        this.f68091e0 = editTextPreView;
        editTextPreView.setOnClickListener(new d());
        this.F.setFocusableInTouchMode(true);
        this.F.setFocusable(true);
        this.F.setOnFocusChangeListener(new e());
        this.E.c(this.F);
        u0();
        this.F.setOnTouchListener(new f());
        AEHorizontalSelectColorLayout aEHorizontalSelectColorLayout = (AEHorizontalSelectColorLayout) this.C.findViewById(R.id.f8l);
        this.H = aEHorizontalSelectColorLayout;
        aEHorizontalSelectColorLayout.setColorSelectListener(this);
    }

    private void initWindow() {
        int i3;
        Window window = super.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        if (this.f68094h0) {
            attributes.height = zr.a.e(getContext());
            if (LiuHaiUtils.needShowLiuHaiTopBar()) {
                int[] realDisplay = LiuHaiUtils.getRealDisplay(this.f68090d0);
                if (realDisplay.length == 2 && realDisplay[0] > 0 && (i3 = realDisplay[1]) > 0) {
                    attributes.height = i3;
                    boolean z16 = (d0() && DisplayUtil.checkNavigationBarShow(this.f68090d0)) || DisplayUtil.isFlymeOS7NavBarShow();
                    QLog.d("EditTextDialog", 1, "isNavigationBarExist, ", Boolean.valueOf(z16), "  Build.MODEL: ", DeviceInfoMonitor.getModel());
                    if (z16) {
                        attributes.height -= DisplayUtil.getNavigationBarHeight(this.f68090d0);
                    }
                }
            }
        } else {
            attributes.height = -1;
        }
        attributes.flags |= 32;
        attributes.gravity = 80;
        window.setSoftInputMode(21);
        window.setAttributes(attributes);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
            SystemBarCompact systemBarCompact = new SystemBarCompact((Dialog) this, true, this.f68090d0.getResources().getColor(17170445));
            systemBarCompact.setStatusBarDrawable(null);
            systemBarCompact.init();
        }
        setCanceledOnTouchOutside(false);
    }

    public static boolean m0(int i3) {
        if (i3 != 0 && i3 != 32 && i3 != 31 && i3 != 30 && i3 != 33) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        DynamicTextItem dynamicTextItem = this.f68106t0;
        if (dynamicTextItem == null || this.f68091e0 == null) {
            return;
        }
        String p16 = dynamicTextItem.p(this.L);
        if (TextUtils.isEmpty(p16)) {
            p16 = "";
        }
        EditTextPreView editTextPreView = this.f68091e0;
        if (editTextPreView != null) {
            editTextPreView.setPreViewDrawer(this.f68106t0);
            this.f68091e0.setText(this.L, p16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("EditTextDialog", 2, "text size changednow text size:" + this.M);
        }
    }

    private void w0(int i3) {
        DynamicTextItem dynamicTextItem;
        this.P = i3;
        if (i3 != 0) {
            if (i3 == 1 && (dynamicTextItem = this.f68106t0) != null) {
                dynamicTextItem.z();
                EditTextPreView editTextPreView = this.f68091e0;
                if (editTextPreView != null) {
                    editTextPreView.invalidate();
                    return;
                }
                return;
            }
            return;
        }
        DynamicTextItem dynamicTextItem2 = this.f68106t0;
        if (dynamicTextItem2 != null) {
            int h16 = dynamicTextItem2.h();
            this.f68106t0.P();
            this.f68106t0.O(h16, true);
            EditTextPreView editTextPreView2 = this.f68091e0;
            if (editTextPreView2 != null) {
                editTextPreView2.invalidate();
            }
        }
    }

    public void A0(int i3) {
        this.X = i3;
    }

    public void B0() {
        XPanelContainer xPanelContainer = this.E;
        if (xPanelContainer != null) {
            xPanelContainer.N(1);
        }
    }

    public void C0() {
        this.F.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.F, 1);
        }
    }

    protected void D0(int i3) {
        Iterator<Integer> it = com.tencent.aelight.camera.aioeditor.takevideo.a.f67928a.iterator();
        int i16 = 0;
        while (it.hasNext() && i3 != it.next().intValue()) {
            i16++;
        }
        this.H.c(com.tencent.aelight.camera.aioeditor.takevideo.a.f67928a, i16, false);
    }

    protected void E0() {
        this.f68106t0.d(-1, this.f68091e0, true, 3000, 500, new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.11
            @Override // java.lang.Runnable
            public void run() {
                EditTextDialog.this.f68106t0.z();
                EditTextDialog editTextDialog = EditTextDialog.this;
                if (editTextDialog.P != 1) {
                    DynamicTextItem dynamicTextItem = editTextDialog.f68106t0;
                    dynamicTextItem.O(dynamicTextItem.h(), true);
                }
                EditTextDialog.this.f68091e0.invalidate();
            }
        });
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public View E2(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("EditTextDialog", 2, "onCreatePanel id = " + i3);
        }
        int i16 = (int) (this.f68090d0.getResources().getDisplayMetrics().density * 50.0f);
        XPanelContainer.f384714h0 = i16;
        RelativeLayout relativeLayout = this.f68096j0;
        if (relativeLayout == null) {
            return null;
        }
        XPanelContainer.f384714h0 = i16 + relativeLayout.getHeight();
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.b
    public void F(DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("EditTextDialog", 2, "onPanelItemClick position = " + i3);
        }
        if (dynamicTextConfigBean != null) {
            com.tencent.aelight.camera.ae.report.b.b().y0(dynamicTextConfigBean.text_id + "");
        }
        DynamicTextItem dynamicTextItem = this.f68106t0;
        if (dynamicTextItem == null || this.F == null || dynamicTextConfigBean == null) {
            return;
        }
        dynamicTextItem.h();
        List<String> s16 = this.f68106t0.s();
        if (dynamicTextConfigBean.text_id != this.f68106t0.v()) {
            s16 = DynamicTextBuilder.h(DynamicTextBuilder.e(dynamicTextConfigBean.text_id), this.f68106t0);
            this.Z.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.10
                @Override // java.lang.Runnable
                public void run() {
                    EditTextDialog.this.Q.f();
                }
            });
        }
        DynamicTextItem b16 = this.f68092f0.b(dynamicTextConfigBean.text_id, s16);
        b16.N(b16.r());
        this.M = b16.r();
        b16.f66891d = this.f68106t0.f66891d;
        b16.c(0);
        b16.M(0, b16.p(0));
        if (b16 instanceof w) {
            w wVar = (w) b16;
            wVar.V(this.W);
            this.H.setVisibility(0);
            D0(wVar.R());
        } else {
            this.H.setVisibility(8);
        }
        this.f68106t0.P();
        if (!this.f68106t0.equals(b16)) {
            this.f68106t0 = b16;
        }
        this.f68091e0.setPreViewDrawer(this.f68106t0);
        E0();
        this.F.setFilters(this.f68105s0);
        s0(this.f68106t0.i());
        if (m0(this.f68106t0.v())) {
            if (this.f68106t0.n() == null) {
                this.F.setFilters(this.f68104r0);
            } else {
                this.F.setFilters(new InputFilter[]{this.f68106t0.n()});
            }
        }
        EditText editText = this.F;
        editText.setSelection(editText.length());
        if (this.f68106t0.i().equals(DynamicTextBuilder.d(this.f68106t0.v(), this.f68106t0.h()))) {
            this.F.setSelectAllOnFocus(true);
            if (this.F.hasFocus()) {
                this.F.selectAll();
            }
        } else {
            this.F.setOnClickListener(null);
            this.F.setSelectAllOnFocus(false);
            this.F.requestFocus();
        }
        this.f68089c0 = i3;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public boolean T(int i3) {
        return false;
    }

    public void e0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("EditTextDialog", 2, "dismiss isCancel:" + z16 + ", mText:" + this.f68108v0);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (this.F != null) {
            inputMethodManager.hideSoftInputFromWindow(this.C.getWindowToken(), 0);
        }
        this.Q.c(false);
        this.Q.b(j0(), k0());
        this.f68091e0.setPreViewDrawer(null);
        EditText editText = this.F;
        if (editText != null && TextUtils.isEmpty(editText.getText().toString())) {
            DynamicTextItem dynamicTextItem = this.f68106t0;
            dynamicTextItem.M(dynamicTextItem.h(), this.f68108v0);
        }
        this.Q.a(this.f68106t0, !z16, this.f68095i0, this.f68098l0);
        this.f68098l0 = false;
        super.dismiss();
    }

    public void f0(final int i3, final int i16) {
        DynamicTextItem dynamicTextItem;
        if (QLog.isColorLevel()) {
            QLog.d("EditTextDialog", 2, "doPanelChanged oldPanel = " + i3 + "newPanel=" + i16);
        }
        if (i16 == 34) {
            if (this.f68089c0 == -1 && (dynamicTextItem = this.f68106t0) != null) {
                this.f68089c0 = this.f68087a0.d(this.f68092f0.g(dynamicTextItem));
            }
            int i17 = this.f68089c0;
            if (i17 != -1) {
                this.f68087a0.e(-1, i17);
            }
            w0(1);
        } else if (i16 == 1) {
            w0(0);
        } else if (i16 == 0) {
            w0(1);
        }
        this.Z.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.9
            @Override // java.lang.Runnable
            public void run() {
                EditTextDialog.this.Q.onPanelChanged(i3, i16);
            }
        });
    }

    protected int g0() {
        return R.layout.f167922mj;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        f0(message.arg1, message.arg2);
        return false;
    }

    protected int i0() {
        return this.X;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int j0() {
        EditTextPreView editTextPreView = this.f68091e0;
        int width = editTextPreView != null ? (editTextPreView.getWidth() / 2) + this.f68091e0.getLeft() : 0;
        hd0.c.a("EditTextDialog", "getPreViewCenterX:" + width);
        return width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k0() {
        EditTextPreView editTextPreView = this.f68091e0;
        int height = editTextPreView != null ? (editTextPreView.getHeight() / 2) + this.f68091e0.getTop() : 0;
        hd0.c.a("EditTextDialog", "getPreViewCenterY()=" + height);
        return height;
    }

    protected int l0() {
        return (int) (this.F.getTop() + i0() + this.F.getBaseline() + this.F.getPaint().ascent());
    }

    public void o0(boolean z16) {
        this.f68094h0 = z16;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        DynamicTextItem dynamicTextItem = this.f68106t0;
        if (dynamicTextItem != null) {
            dynamicTextItem.f66900m = true;
        }
        e0(true);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XPanelContainer.f384714h0 = this.f68088b0;
        if (this.Q == null) {
            return;
        }
        String obj = this.F.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            obj = this.f68108v0;
        }
        DynamicTextItem dynamicTextItem = this.f68106t0;
        if (dynamicTextItem != null) {
            DynamicTextItem.TextMap q16 = dynamicTextItem.q();
            DynamicTextItem dynamicTextItem2 = this.f68106t0;
            if (!dynamicTextItem2.p(dynamicTextItem2.h()).equals(obj) && !this.f68099m0) {
                DynamicTextItem dynamicTextItem3 = this.f68106t0;
                dynamicTextItem3.M(dynamicTextItem3.h(), obj);
            }
            if (!q16.equals(this.f68093g0) && this.f68106t0.E()) {
                this.f68106t0.L(false);
            }
        }
        this.f68093g0 = null;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void onPanelChanged(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("EditTextDialog", 2, "onPanelChanged oldPanel = " + i3 + "newPanel=" + i16);
        }
        this.Z.obtainMessage(0, i3, i16).sendToTarget();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ((Activity) this.f68090d0).dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (this.U < 0) {
            this.U = z16 ? 1 : 0;
            this.Q.onWindowFocusChanged(z16);
        }
    }

    public void p0(DynamicTextBuilder dynamicTextBuilder) {
        this.f68092f0 = dynamicTextBuilder;
    }

    public void q0(boolean z16) {
        this.f68103q0 = z16;
    }

    public void r0(i iVar) {
        this.Q = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0(String str) {
        this.F.setText(str);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        this.S = BaseAIOUtils.f(100.0f, getContext().getResources());
        initWindow();
        initView();
        super.setContentView(this.C);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        DynamicTextItem dynamicTextItem = this.f68106t0;
        if (dynamicTextItem != null) {
            this.f68093g0 = dynamicTextItem.q();
            if (this.P == 0) {
                DynamicTextItem dynamicTextItem2 = this.f68106t0;
                dynamicTextItem2.O(dynamicTextItem2.h(), true);
            }
        } else {
            this.f68093g0 = null;
        }
        if (this.f68106t0 instanceof w) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
        this.f68098l0 = false;
        this.E.N(1);
        this.E.setOnPanelChangeListener(this);
    }

    protected void u0() {
        this.F.addTextChangedListener(new g());
    }

    public void x0(int i3) {
        this.W = i3;
    }

    public void y0(boolean z16) {
        this.f68100n0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            DynamicTextItem dynamicTextItem;
            if (z16 && (dynamicTextItem = EditTextDialog.this.f68106t0) != null) {
                dynamicTextItem.O(dynamicTextItem.h(), true);
            }
            hd0.c.a("EditTextDialog", "onFocusChange:" + z16);
        }
    }

    public EditTextDialog(Context context) {
        super(context, R.style.f173455dt);
        this.I = 580;
        this.L = 0;
        this.M = w.f67161v;
        this.P = 0;
        this.T = -1;
        this.U = -1;
        this.W = gs.b.b(false);
        this.Y = new vr.b();
        this.Z = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.f68088b0 = XPanelContainer.f384714h0;
        this.f68089c0 = -1;
        this.f68093g0 = null;
        this.f68096j0 = null;
        this.f68099m0 = false;
        this.f68100n0 = false;
        this.f68103q0 = false;
        this.f68104r0 = new InputFilter[]{new j(20)};
        this.f68105s0 = new InputFilter[0];
        this.f68108v0 = "";
        this.f68111y0 = new h();
        this.f68090d0 = context;
        if (context instanceof Activity) {
            this.f68097k0 = ((Activity) context).getIntent().getIntExtra(ShortVideoConstants.CAPTURE_OPERATION_IN, -1);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout.d
    public void c(int i3, int i16) {
        if (i3 == 1) {
            this.Y.f443186b = i16;
            this.W = i16;
            DynamicTextItem dynamicTextItem = this.f68106t0;
            if (dynamicTextItem instanceof w) {
                ((w) dynamicTextItem).V(i16);
                this.f68091e0.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements EditTextPreView.b {
        d() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView.b
        public void a(View view, DynamicTextItem dynamicTextItem, int i3) {
            if (dynamicTextItem != null && i3 > -1) {
                String p16 = dynamicTextItem.p(i3);
                if (p16 != null) {
                    EditTextDialog.this.F.setText(p16);
                    EditText editText = EditTextDialog.this.F;
                    editText.setSelection(editText.length());
                    if (p16.equals(DynamicTextBuilder.d(dynamicTextItem.v(), i3))) {
                        EditTextDialog editTextDialog = EditTextDialog.this;
                        editTextDialog.F.setOnClickListener(editTextDialog.f68111y0);
                        EditTextDialog.this.F.setSelectAllOnFocus(true);
                        if (EditTextDialog.this.F.hasFocus()) {
                            EditTextDialog.this.F.selectAll();
                        }
                    } else {
                        EditTextDialog.this.F.setOnClickListener(null);
                    }
                    XPanelContainer xPanelContainer = EditTextDialog.this.E;
                    if (xPanelContainer != null) {
                        xPanelContainer.N(34);
                        return;
                    }
                    return;
                }
                return;
            }
            EditTextDialog.this.e0(false);
        }
    }

    public void z0(DynamicTextItem dynamicTextItem, int i3) {
        if (i3 == -1) {
            return;
        }
        this.L = i3;
        this.f68106t0 = dynamicTextItem;
        this.f68107u0 = dynamicTextItem;
        if (dynamicTextItem == null) {
            return;
        }
        int r16 = dynamicTextItem.r();
        this.M = r16;
        this.f68110x0 = r16;
        this.f68108v0 = this.f68106t0.p(this.L);
        if (QLog.isColorLevel()) {
            QLog.d("EditTextDialog", 2, "normalTextSize" + this.M);
        }
        String p16 = this.f68106t0.p(i3);
        if (TextUtils.isEmpty(p16)) {
            p16 = "";
        }
        EditTextPreView editTextPreView = this.f68091e0;
        if (editTextPreView != null) {
            editTextPreView.setPreViewDrawer(this.f68106t0);
            this.f68091e0.setText(i3, p16);
        }
        this.F.setFilters(this.f68105s0);
        this.f68106t0.M(i3, p16);
        this.V = p16;
        hd0.c.a("EditTextDialog", "setTextInfo:" + dynamicTextItem + " index:" + i3 + " text:" + p16);
        this.Y.f443185a = p16;
        s0(p16);
        if (m0(this.f68106t0.v())) {
            if (this.f68106t0.n() == null) {
                this.F.setFilters(this.f68104r0);
            } else {
                this.F.setFilters(new InputFilter[]{this.f68106t0.n()});
            }
        }
        EditText editText = this.F;
        editText.setSelection(editText.length());
        if (this.f68106t0.i().equals(DynamicTextBuilder.d(this.f68106t0.v(), this.f68106t0.h()))) {
            this.F.setOnClickListener(this.f68111y0);
            this.F.setSelectAllOnFocus(true);
            if (this.F.hasFocus()) {
                this.F.selectAll();
            }
        } else {
            this.F.setOnClickListener(null);
        }
        int g16 = this.f68092f0.g(dynamicTextItem);
        EditTextPanel editTextPanel = this.f68087a0;
        if (editTextPanel != null) {
            this.f68089c0 = editTextPanel.d(g16);
        }
        if (this.P == 0) {
            w0(0);
        }
        DynamicTextItem dynamicTextItem2 = this.f68106t0;
        if (dynamicTextItem2 instanceof w) {
            this.J = dynamicTextItem2.m();
            this.K = r6.Q();
            this.H.setCurrentTextItemType(this.f68106t0.v());
            this.H.setVisibility(0);
            int R = ((w) dynamicTextItem2).R();
            this.f68109w0 = R;
            D0(R);
            return;
        }
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements TextWatcher {
        g() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            EditTextDialog editTextDialog = EditTextDialog.this;
            if (editTextDialog.Q == null || charSequence == null) {
                return;
            }
            editTextDialog.f68098l0 = true;
            if (editTextDialog.f68106t0 != null) {
                if (charSequence.length() > 0) {
                    EditTextDialog editTextDialog2 = EditTextDialog.this;
                    editTextDialog2.f68091e0.setText(editTextDialog2.f68106t0.h(), charSequence.toString());
                } else {
                    EditTextDialog editTextDialog3 = EditTextDialog.this;
                    editTextDialog3.f68091e0.setText(editTextDialog3.f68106t0.h(), (String) EditTextDialog.this.F.getHint());
                }
            }
            DynamicTextItem dynamicTextItem = EditTextDialog.this.f68106t0;
            if (dynamicTextItem instanceof w) {
                w wVar = (w) dynamicTextItem;
                if (wVar.S(charSequence.toString()) && i17 != 0 && (EditTextDialog.this.N == null || !EditTextDialog.this.N.isShowing())) {
                    EditTextDialog editTextDialog4 = EditTextDialog.this;
                    editTextDialog4.N = QQToast.makeText(editTextDialog4.getContext(), HardCodeUtil.qqStr(R.string.lxh), 0);
                    EditTextDialog.this.N.show();
                }
                if (EditTextDialog.this.f68106t0.m() == EditTextDialog.this.J || wVar.Q() == EditTextDialog.this.K) {
                    return;
                }
                if (EditTextDialog.this.f68106t0.m() > EditTextDialog.this.I && EditTextDialog.this.K < wVar.Q()) {
                    boolean W = wVar.W(EditTextDialog.this.L, charSequence.toString(), EditTextDialog.this.I, EditTextDialog.this.M);
                    EditTextDialog.this.M = wVar.r();
                    EditTextDialog.this.n0();
                    if (W && (EditTextDialog.this.N == null || !EditTextDialog.this.N.isShowing())) {
                        EditTextDialog editTextDialog5 = EditTextDialog.this;
                        editTextDialog5.N = QQToast.makeText(editTextDialog5.getContext(), HardCodeUtil.qqStr(R.string.lxg), 0);
                        EditTextDialog.this.N.show();
                    }
                } else if (EditTextDialog.this.f68106t0.m() < EditTextDialog.this.I && EditTextDialog.this.M < w.f67161v && EditTextDialog.this.K > wVar.Q()) {
                    EditTextDialog editTextDialog6 = EditTextDialog.this;
                    editTextDialog6.M = wVar.X(editTextDialog6.L, charSequence.toString(), EditTextDialog.this.I, EditTextDialog.this.M);
                    EditTextDialog.this.n0();
                }
                EditTextDialog editTextDialog7 = EditTextDialog.this;
                editTextDialog7.J = editTextDialog7.f68106t0.m();
                EditTextDialog.this.K = wVar.Q();
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout.d
    public void J(int i3) {
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void E() {
    }
}
