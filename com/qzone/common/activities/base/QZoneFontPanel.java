package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.text.QzoneFontManager;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.publish.service.PersonalFontService;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.util.ToastUtil;
import com.qzone.widget.EachRadiusAsyncImageView;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.WorkSpaceView;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes39.dex */
public class QZoneFontPanel extends ADView implements IObserver.main {
    public WeakReference<Activity> I;
    protected WeakReference<EditText> J;
    protected long K;
    protected PersonalFontData L;
    protected boolean M;
    protected ArrayList<View> N;
    protected int P;
    protected int Q;
    protected int R;
    protected int S;
    protected int T;
    protected boolean U;
    protected boolean V;
    protected boolean W;

    /* renamed from: a0, reason: collision with root package name */
    protected int f45332a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QQCustomDialog f45333b0;

    /* renamed from: c0, reason: collision with root package name */
    protected ConcurrentHashMap<String, Object> f45334c0;

    /* renamed from: d0, reason: collision with root package name */
    protected Handler f45335d0;

    /* renamed from: e0, reason: collision with root package name */
    protected LinearLayout f45336e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f45337f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f45338g0;

    /* renamed from: h0, reason: collision with root package name */
    private PersonalFontData.FontInfo f45339h0;

    /* renamed from: i0, reason: collision with root package name */
    protected e f45340i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f45341j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f45342k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f45343l0;

    /* renamed from: m0, reason: collision with root package name */
    WorkSpaceView.b f45344m0;

    /* renamed from: n0, reason: collision with root package name */
    protected f f45345n0;

    /* renamed from: o0, reason: collision with root package name */
    private View.OnClickListener f45346o0;

    /* renamed from: p0, reason: collision with root package name */
    private QzoneFontManager.b f45347p0;

    /* renamed from: q0, reason: collision with root package name */
    private FontInterface.TrueTypeResult f45348q0;

    /* loaded from: classes39.dex */
    class a implements f {
        a() {
        }

        @Override // com.qzone.common.activities.base.QZoneFontPanel.f
        public void a() {
            ClickReport.c(586, 17, "1", true, new String[0]);
        }
    }

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null) {
                if (!com.qzone.util.ao.b(500)) {
                    QZLog.i("QZoneFontPanel", 4, "click too fast return");
                } else {
                    int intValue = ((Integer) view.getTag(R.id.jam)).intValue();
                    if (intValue == -2) {
                        WeakReference<Activity> weakReference = QZoneFontPanel.this.I;
                        if (weakReference != null && weakReference.get() != null) {
                            QZoneFontPanel.this.V = false;
                            ClickReport.m("302", "75", "2");
                            vo.c.V(QZoneFontPanel.this.I.get());
                        }
                    } else if (intValue < 0) {
                        QZLog.e("QZoneFontPanel", "fontId = " + intValue);
                    } else {
                        QZoneFontPanel.this.W("onClick fontId = " + intValue);
                        QZoneFontPanel qZoneFontPanel = QZoneFontPanel.this;
                        qZoneFontPanel.V = true;
                        if (intValue == 0) {
                            qZoneFontPanel.m0(intValue);
                            QZoneFontPanel.this.D(null);
                        } else {
                            PersonalFontData.FontInfo M = qZoneFontPanel.M(intValue);
                            if (M != null) {
                                if (!QZoneFontPanel.this.f45342k0 && !M.hasAuth) {
                                    QZoneFontPanel.this.W = true;
                                    PersonalFontService.K().O();
                                    QZoneFontPanel qZoneFontPanel2 = QZoneFontPanel.this;
                                    qZoneFontPanel2.f45332a0 = intValue;
                                    qZoneFontPanel2.S(M.fontType, M);
                                } else {
                                    ClickReport.c(586, 17, "2", true, "", intValue + "");
                                    if (!TextUtils.isEmpty(((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(intValue, M.fontUrl, null, true, null))) {
                                        QZoneFontPanel.this.D(M);
                                        QZoneFontPanel qZoneFontPanel3 = QZoneFontPanel.this;
                                        if (qZoneFontPanel3.S != intValue && M.fontFormatType == 3) {
                                            qZoneFontPanel3.t0(M);
                                        }
                                        QZoneFontPanel.this.m0(intValue);
                                    } else {
                                        boolean isWifiConn = NetworkState.isWifiConn();
                                        QZoneFontPanel.this.W("onClick isWifi = " + isWifiConn);
                                        if (!isWifiConn) {
                                            QZoneFontPanel.this.r0(view, M, null);
                                        } else {
                                            QZoneFontPanel.this.F(view, M);
                                        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneFontPanel.this.f45333b0.dismiss();
            QZoneFontPanel qZoneFontPanel = QZoneFontPanel.this;
            qZoneFontPanel.F(qZoneFontPanel.f45338g0, QZoneFontPanel.this.f45339h0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneFontPanel.this.f45333b0.dismiss();
        }
    }

    /* loaded from: classes39.dex */
    public interface e {
        void a(PersonalFontData.FontInfo fontInfo);
    }

    /* loaded from: classes39.dex */
    public interface f {
        void a();
    }

    public QZoneFontPanel(Activity activity, EditText editText, long j3, int i3, boolean z16, boolean z17) {
        super(activity);
        this.N = new ArrayList<>();
        this.P = com.qzone.util.ar.e(12.5f);
        this.Q = R.color.qzone_skin_font_panel_background_color;
        this.R = R.drawable.azf;
        this.S = -1;
        this.T = -1;
        this.U = false;
        this.V = false;
        this.W = true;
        this.f45332a0 = 0;
        this.f45334c0 = new ConcurrentHashMap<>();
        this.f45341j0 = false;
        this.f45342k0 = false;
        this.f45343l0 = 0;
        this.f45344m0 = new WorkSpaceView.b() { // from class: com.qzone.common.activities.base.QZoneFontPanel.1
            /* JADX WARN: Code restructure failed: missing block: B:26:0x002a, code lost:
            
                if (r7 == r0) goto L15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0031, code lost:
            
                if (r7 == r0) goto L11;
             */
            @Override // com.tencent.mobileqq.widget.WorkSpaceView.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a(int i16) {
                View childAt;
                int childCount = QZoneFontPanel.this.f45336e0.getChildCount();
                for (int i17 = 0; i17 < childCount; i17++) {
                    View childAt2 = QZoneFontPanel.this.f45336e0.getChildAt(i17);
                    if (childAt2 != null) {
                        childAt2.setEnabled(false);
                    }
                }
                if (QZoneFontPanel.this.e()) {
                    if (i16 != -1) {
                    }
                    i16 = childCount - 1;
                } else {
                    if (i16 != -1) {
                    }
                    i16 = 0;
                }
                if (i16 > -1 && i16 < childCount && (childAt = QZoneFontPanel.this.f45336e0.getChildAt(i16)) != null) {
                    childAt.setEnabled(true);
                    QZoneFontPanel qZoneFontPanel = QZoneFontPanel.this;
                    qZoneFontPanel.f45343l0 = i16;
                    qZoneFontPanel.f45335d0.postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontPanel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneFontPanel.this.b0(false, true);
                        }
                    }, 400L);
                }
                if (i16 == childCount - 1) {
                    ClickReport.m("302", "75", "1");
                }
            }
        };
        this.f45345n0 = new a();
        this.f45346o0 = new b();
        this.f45347p0 = new QzoneFontManager.b() { // from class: com.qzone.common.activities.base.QZoneFontPanel.8
            @Override // com.qzone.proxy.feedcomponent.text.QzoneFontManager.b
            public void a(final Typeface typeface) {
                if (typeface != null) {
                    QZoneFontPanel.this.f45335d0.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontPanel.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (typeface == null) {
                                QZLog.e("QZoneFontPanel", "loadTypeFaceListener, return typeface is null!!!");
                            }
                            QZoneFontPanel.this.j0(typeface);
                        }
                    });
                }
            }
        };
        this.f45348q0 = new FontInterface.TrueTypeResult() { // from class: com.qzone.common.activities.base.QZoneFontPanel.9
            @Override // cooperation.qzone.font.FontInterface.TrueTypeResult, cooperation.qzone.font.FontInterface.FontResult
            public void result(final int i16, final String str, final String str2) {
                QZoneFontPanel.this.W("download TrueTypeResult : font id [" + i16 + "], fontPath = " + str);
                if (QZoneFontPanel.this.I.get() != null) {
                    QZoneFontPanel.this.f45335d0.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontPanel.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneFontPanel.this.G(str2, i16, !TextUtils.isEmpty(str));
                        }
                    });
                }
            }
        };
        this.f45342k0 = z17;
        this.V = i3 > 0;
        this.T = i3;
        this.S = i3;
        this.f45341j0 = z16;
        T(activity, editText, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final PersonalFontData.FontInfo fontInfo) {
        if (this.f45340i0 == null || this.I.get() == null) {
            return;
        }
        this.f45335d0.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontPanel.3
            @Override // java.lang.Runnable
            public void run() {
                e eVar = QZoneFontPanel.this.f45340i0;
                if (eVar != null) {
                    eVar.a(fontInfo);
                }
            }
        });
    }

    private void E(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout == null || linearLayout.getChildCount() == 0) {
            return;
        }
        linearLayout.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view, PersonalFontData.FontInfo fontInfo) {
        String str = System.currentTimeMillis() + "";
        if (!TextUtils.isEmpty(((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(fontInfo.f51895id, fontInfo.fontUrl, str, true, this.f45348q0))) {
            m0(fontInfo.f51895id);
            return;
        }
        this.f45337f0 = str;
        if (view != null) {
            WeakReference weakReference = new WeakReference(view);
            W("downloadFont, add key = " + str + " to download map");
            this.f45334c0.put(str, weakReference);
            ImageView imageView = (ImageView) view.findViewById(R.id.chv);
            View findViewById = view.findViewById(R.id.chm);
            if (imageView == null || findViewById == null) {
                return;
            }
            imageView.setImageResource(R.anim.f155037hd);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            if (animationDrawable != null) {
                animationDrawable.start();
            }
            setViewVisible(findViewById, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, int i3, boolean z16) {
        View view;
        WeakReference weakReference = (WeakReference) this.f45334c0.remove(str);
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.chv);
            View findViewById = view.findViewById(R.id.chm);
            if (imageView != null && findViewById != null) {
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                imageView.setImageDrawable(null);
                setViewVisible(findViewById, 4);
            }
        }
        PersonalFontData.FontInfo M = M(i3);
        if (z16 && TextUtils.equals(str, this.f45337f0)) {
            if (M != null) {
                D(M);
                if (M.fontFormatType == 3) {
                    t0(M);
                }
            }
            m0(i3);
            return;
        }
        if (z16) {
            return;
        }
        if (!((IFontManager) QRoute.api(IFontManager.class)).ETEngineLoaded()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastEngineLoading", "\u5f15\u64ce\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5"));
        } else {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFontLoadingFail", "\u5b57\u4f53\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5"));
        }
    }

    private boolean I(View view) {
        Activity activity = this.I.get();
        if (activity == null) {
            return false;
        }
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout == null) {
            linearLayout = (LinearLayout) Y();
        }
        if (linearLayout == null || linearLayout.getChildCount() > 0) {
            return false;
        }
        LinearLayout linearLayout2 = new LinearLayout(activity);
        int i3 = this.P;
        linearLayout2.setPadding(i3, i3, i3, 0);
        linearLayout2.setOrientation(0);
        X(linearLayout2);
        X(linearLayout2);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout3 = new LinearLayout(activity);
        int i16 = this.P;
        linearLayout3.setPadding(i16, 0, i16, i16);
        linearLayout3.setOrientation(0);
        X(linearLayout3);
        X(linearLayout3);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        ((LinearLayout.LayoutParams) linearLayout3.getLayoutParams()).setMargins(0, 0, 0, com.qzone.util.ar.e(17.5f));
        return true;
    }

    private View K(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return null;
        }
        return L((ViewGroup) this.N.get(i16), i3 - (i16 * 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonalFontData.FontInfo M(int i3) {
        PersonalFontData personalFontData = this.L;
        if (personalFontData != null && !personalFontData.fontList.isEmpty()) {
            Iterator<PersonalFontData.FontInfo> it = this.L.fontList.iterator();
            while (it.hasNext()) {
                PersonalFontData.FontInfo next = it.next();
                if (next.f51895id == i3) {
                    return next;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i3, PersonalFontData.FontInfo fontInfo) {
        W("gotoPayFont, fontType = " + i3);
        if (fontInfo.fontFormatType == 3) {
            v0(fontInfo);
            return;
        }
        if (i3 != 2) {
            if (i3 != 14) {
                if (i3 == 19) {
                    w0(fontInfo);
                    return;
                }
                if (i3 != 304) {
                    if (i3 == 301) {
                        u0(fontInfo);
                        return;
                    } else if (i3 != 302) {
                        WeakReference<Activity> weakReference = this.I;
                        if (weakReference == null || weakReference.get() == null) {
                            return;
                        }
                        vo.c.V(this.I.get());
                        return;
                    }
                }
            }
            v0(fontInfo);
            return;
        }
        x0();
    }

    private void V() {
        int i3;
        DefaultFontInfo defaultFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultFont(this.K);
        if (defaultFont == null || defaultFont.fontId <= 0 || (i3 = defaultFont.formatType) == 3 || i3 == 4) {
            return;
        }
        if (TextUtils.isEmpty(((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(defaultFont.fontId, defaultFont.fontUrl, null, true, null))) {
            W("setEditTypeFace, font file not found, so reset to system font.");
            j0(Typeface.DEFAULT);
        } else {
            Typeface g16 = QzoneFontManager.f().g(defaultFont.fontId, defaultFont.fontUrl, this.f45347p0);
            if (g16 != null) {
                j0(g16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneFontPanel", 2, str);
        }
    }

    private void X(LinearLayout linearLayout) {
        Activity activity = this.I.get();
        if (activity == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.boi, (ViewGroup) null);
        relativeLayout.setOnClickListener(this.f45346o0);
        relativeLayout.setTag(R.id.jam, -1);
        ViewGroup viewGroup = (ViewGroup) relativeLayout.findViewById(R.id.chq);
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(this.R);
        }
        linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    private View Y() {
        Activity activity = this.I.get();
        if (activity == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        p0(linearLayout, this.Q);
        return linearLayout;
    }

    private void Z(long j3, PersonalFontData personalFontData, int i3) {
        int i16;
        int i17;
        Activity activity;
        if (this.K != j3) {
            QZLog.e("QZoneFontPanel", "onDataChanged but uin are not the same , this.uin = " + this.K + ", enter uin= " + j3);
            return;
        }
        if (1 == i3 && personalFontData == null && this.L == null) {
            d0(false);
            return;
        }
        if (!this.f45341j0 && personalFontData != null) {
            personalFontData = c0(personalFontData);
        }
        if (i3 == 0) {
            this.W = false;
        }
        WeakReference<Activity> weakReference = this.I;
        boolean g46 = (weakReference == null || (activity = weakReference.get()) == null || !(activity instanceof FeedActionPanelActivity)) ? false : ((FeedActionPanelActivity) activity).g4();
        if (H(this.L, personalFontData)) {
            if (i3 != 0 || g46) {
                return;
            }
            this.f45332a0 = 0;
            return;
        }
        if (this.L == null && !this.V) {
            DefaultFontInfo defaultFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultFont(j3);
            if (defaultFont != null) {
                this.U = true;
                this.T = defaultFont.fontId;
            } else {
                this.U = false;
                this.T = 0;
            }
        }
        this.L = personalFontData;
        if (i3 == 0 && personalFontData != null && (i17 = personalFontData.defaultFont) >= 0 && i17 != this.T) {
            this.T = i17;
            W("saveDefaultFontData from onDataChanged, defaultFont = " + personalFontData.defaultFont);
            h0(this.T, false);
            if (!this.V) {
                this.S = this.T;
            }
            int i18 = personalFontData.defaultFont;
            if (i18 > 0) {
                this.U = true;
            } else if (i18 == 0) {
                this.U = false;
            }
        }
        PersonalFontData personalFontData2 = this.L;
        if (personalFontData2 != null && personalFontData2.mType == 2 && this.S == -1) {
            this.T = 0;
        }
        int i19 = this.S;
        if (i19 >= 0) {
            m0(i19);
        } else if (i19 < 0 && personalFontData2 != null && (i16 = this.T) >= 0) {
            n0(i16);
        } else {
            b0(false, false);
        }
        if (i3 == 0) {
            i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e5, code lost:
    
        o0(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b0(boolean z16, boolean z17) {
        if (this.M) {
            PersonalFontData personalFontData = this.L;
            if (personalFontData != null && this.K != personalFontData.uin) {
                QZLog.w("QZoneFontPanel", "refreshUi fail, mData is null, uin = " + this.K);
                return;
            }
            WeakReference<Activity> weakReference = this.I;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ArrayList<PersonalFontData.FontInfo> s06 = s0();
            int N = N(s06);
            if (this.L != null) {
                W("refreshUi , font list size = " + N + ", default id = " + this.T + ", select id = " + this.S);
            } else {
                W("refreshUi , mData is empty.");
            }
            C(N);
            int i3 = this.f45343l0;
            int i16 = i3 - 1;
            int i17 = i3 + 1;
            if (z16) {
                i17 = 1;
                if (i3 < 1) {
                    i16 = 0;
                } else {
                    i16 = i3 - 1;
                    i17 = 1 + i3;
                }
            }
            int size = this.N.size() * 4;
            int i18 = -1;
            while (size > 0) {
                size--;
                View P = P(size);
                if (P != null) {
                    int Q = Q(size);
                    if (Q >= i16 && Q <= i17) {
                        boolean I = I(P);
                        if (z17) {
                            if (I) {
                                i18 = Q;
                            } else if (i18 != Q) {
                                a0(s06, size);
                            }
                        }
                        if (size >= N) {
                            e0(size);
                        } else if (size == N - 1) {
                            l0(size);
                        } else if (s06 != null && !s06.isEmpty() && size > 0 && size <= s06.size()) {
                            k0(size, s06.get(size - 1));
                        }
                    } else if (z16) {
                        E(P);
                    }
                }
            }
        }
    }

    private PersonalFontData c0(PersonalFontData personalFontData) {
        PersonalFontData personalFontData2;
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, personalFontData);
        try {
            obtain.setDataPosition(0);
            personalFontData2 = (PersonalFontData) ParcelableWrapper.createDataFromParcel(obtain);
        } catch (Exception e16) {
            e16.printStackTrace();
            personalFontData2 = null;
        }
        OaidMonitor.parcelRecycle(obtain);
        if (personalFontData2 == null) {
            return null;
        }
        if (personalFontData2.fontList != null) {
            ArrayList<PersonalFontData.FontInfo> arrayList = new ArrayList<>(personalFontData2.fontList.size());
            int size = personalFontData2.fontList.size();
            for (int i3 = 0; i3 < size; i3++) {
                PersonalFontData.FontInfo fontInfo = personalFontData2.fontList.get(i3);
                if (fontInfo.fontFormatType != 3) {
                    arrayList.add(fontInfo);
                }
            }
            personalFontData2.fontList = arrayList;
        }
        return personalFontData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(int i3, boolean z16) {
        if (this.L == null || i3 < 0) {
            return;
        }
        PersonalFontData.FontInfo M = M(i3);
        if (M != null) {
            DefaultFontInfo defaultFontInfo = new DefaultFontInfo();
            defaultFontInfo.fontId = M.f51895id;
            defaultFontInfo.fontUrl = M.fontUrl;
            defaultFontInfo.formatType = M.fontFormatType;
            ((IFontManager) QRoute.api(IFontManager.class)).setDefaultFont(this.K, defaultFontInfo);
            return;
        }
        if (z16 && this.U) {
            PersonalFontService.K().U(this.K, null);
        }
        ((IFontManager) QRoute.api(IFontManager.class)).setDefaultFont(this.K, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(Typeface typeface) {
        EditText editText = this.J.get();
        if (editText == null) {
            W("setEditTypeFace, editText is null , so return");
        } else {
            editText.setTypeface(typeface);
        }
    }

    private void k0(int i3, PersonalFontData.FontInfo fontInfo) {
        Drawable drawable;
        View K = K(i3);
        if (K == null) {
            return;
        }
        setViewVisible(K, 0);
        K.setTag(R.id.jam, Integer.valueOf(fontInfo.f51895id));
        EachRadiusAsyncImageView eachRadiusAsyncImageView = (EachRadiusAsyncImageView) K.findViewById(R.id.chp);
        TextView textView = (TextView) K.findViewById(R.id.chr);
        TextView textView2 = (TextView) K.findViewById(R.id.chs);
        ImageView imageView = (ImageView) K.findViewById(R.id.cho);
        TextView textView3 = (TextView) K.findViewById(R.id.chu);
        View findViewById = K.findViewById(R.id.chm);
        ImageView imageView2 = (ImageView) K.findViewById(R.id.chy);
        eachRadiusAsyncImageView.setNeedGifStream(true);
        eachRadiusAsyncImageView.setPlayingGif(true);
        eachRadiusAsyncImageView.setAsyncImage(fontInfo.coverUrl);
        eachRadiusAsyncImageView.setRadiusForEach(com.qzone.util.ar.e(5.0f), com.qzone.util.ar.e(5.0f), 0.0f, 0.0f);
        ThemeUtil.setColorFilterIfNeed(eachRadiusAsyncImageView, com.qzone.adapter.feedcomponent.i.H().p1());
        setViewVisible(eachRadiusAsyncImageView, 0);
        textView.setText(fontInfo.fontName);
        setViewVisible(textView, 0);
        setViewVisible(textView2, 8);
        int i16 = fontInfo.fontType;
        if (i16 == 2) {
            drawable = getResources().getDrawable(R.drawable.gjj);
        } else if (i16 == 12) {
            drawable = getResources().getDrawable(R.drawable.hxn);
        } else if (i16 == 14) {
            drawable = getResources().getDrawable(R.drawable.gji);
        } else if (i16 == 19) {
            drawable = getResources().getDrawable(R.drawable.hxl);
        } else if (i16 != 304) {
            drawable = null;
            if (i16 == 301) {
                Drawable drawable2 = getResources().getDrawable(R.drawable.hxm);
                if (!fontInfo.hasAuth) {
                    try {
                        if (!TextUtils.isEmpty(fontInfo.strPriceDesc)) {
                            textView2.setText(fontInfo.strPriceDesc);
                        } else {
                            textView2.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.g7d), (Drawable) null, (Drawable) null, (Drawable) null);
                            textView2.setText(fontInfo.iPrice);
                        }
                    } catch (Exception e16) {
                        QZLog.e("QZoneFontPanel", "exception " + e16);
                    }
                    setViewVisible(textView2, 0);
                } else {
                    setViewVisible(textView2, 8);
                }
                drawable = drawable2;
            } else if (i16 == 302) {
                drawable = getResources().getDrawable(R.drawable.nzf);
            }
        } else {
            drawable = getResources().getDrawable(R.drawable.nze);
        }
        if (!fontInfo.hasAuth) {
            imageView.setImageDrawable(drawable);
            setViewVisible(imageView, 0);
        } else {
            setViewVisible(imageView, 8);
        }
        setViewVisible(textView3, 8);
        setViewVisible(findViewById, 8);
        if (this.S == fontInfo.f51895id) {
            setViewVisible(imageView2, 0);
        } else {
            setViewVisible(imageView2, 8);
        }
    }

    private void l0(int i3) {
        View K = K(i3);
        if (K == null) {
            return;
        }
        setViewVisible(K, 0);
        K.setTag(R.id.jam, -2);
        EachRadiusAsyncImageView eachRadiusAsyncImageView = (EachRadiusAsyncImageView) K.findViewById(R.id.chp);
        TextView textView = (TextView) K.findViewById(R.id.chu);
        ImageView imageView = (ImageView) K.findViewById(R.id.chy);
        View findViewById = K.findViewById(R.id.chm);
        PersonalFontData personalFontData = this.L;
        if (personalFontData != null) {
            textView.setText(personalFontData.hasMoreString);
        } else {
            textView.setText(com.qzone.util.l.a(R.string.rwd));
        }
        textView.setTextSize(14.0f);
        setViewVisible(eachRadiusAsyncImageView, 8);
        setViewVisible(textView, 0);
        setViewVisible(findViewById, 8);
        setViewVisible(imageView, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0(int i3) {
        W("setSelectFont fontId = " + i3 + ", old select id = " + this.S);
        if (i3 != 0) {
            PersonalFontData.FontInfo M = M(i3);
            if (M == null) {
                QZLog.e("QZoneFontPanel", "setSelectFont, getFontInfo return null, fontId = " + i3);
                j0(Typeface.DEFAULT);
            } else if (!this.f45342k0 && !M.hasAuth) {
                QZLog.e("QZoneFontPanel", "setSelectFont, no auth, fontId = " + i3);
                j0(Typeface.DEFAULT);
            } else {
                int i16 = M.fontFormatType;
                if (i16 != 3 && i16 != 4) {
                    if (TextUtils.isEmpty(((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(i3, M.fontUrl, null, true, null))) {
                        W("setEditTypeFace, font file not found, so reset to system font.");
                        j0(Typeface.DEFAULT);
                    } else {
                        Typeface g16 = QzoneFontManager.f().g(M.f51895id, M.fontUrl, this.f45347p0);
                        if (g16 != null) {
                            j0(g16);
                        }
                    }
                } else {
                    j0(Typeface.DEFAULT);
                }
            }
            i3 = 0;
        } else {
            j0(Typeface.DEFAULT);
        }
        this.f45337f0 = null;
        this.S = i3;
        b0(false, false);
        return true;
    }

    private void o0(int i3) {
        View K = K(i3);
        if (K == null) {
            return;
        }
        setViewVisible(K, 0);
        K.setTag(R.id.jam, 0);
        EachRadiusAsyncImageView eachRadiusAsyncImageView = (EachRadiusAsyncImageView) K.findViewById(R.id.chp);
        TextView textView = (TextView) K.findViewById(R.id.chu);
        ImageView imageView = (ImageView) K.findViewById(R.id.chy);
        View findViewById = K.findViewById(R.id.chm);
        textView.setText(getResources().getString(R.string.gg9));
        textView.setTextSize(20.0f);
        setViewVisible(eachRadiusAsyncImageView, 8);
        setViewVisible(textView, 0);
        setViewVisible(findViewById, 8);
        if (this.S <= 0) {
            setViewVisible(imageView, 0);
        } else {
            setViewVisible(imageView, 8);
        }
    }

    private void p0(View view, int i3) {
        Activity activity;
        WeakReference<Activity> weakReference = this.I;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        view.setBackgroundColor(activity.getResources().getColor(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(View view, PersonalFontData.FontInfo fontInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.qzone.util.l.a(R.string.rwg) + (fontInfo.fontFileSize / 1024) + com.qzone.util.l.a(R.string.rwc);
        }
        String str2 = str;
        Activity activity = this.I.get();
        this.f45339h0 = fontInfo;
        this.f45338g0 = view;
        QQCustomDialog qQCustomDialog = this.f45333b0;
        if (qQCustomDialog == null && activity != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleFontLoading", "\u5b57\u4f53\u4e0b\u8f7d"), str2, new c(), new d());
            this.f45333b0 = createCustomDialog;
            createCustomDialog.show();
        } else if (qQCustomDialog != null) {
            qQCustomDialog.setMessage(str2);
            if (this.f45333b0.isShowing()) {
                return;
            }
            this.f45333b0.show();
        }
    }

    private ArrayList<PersonalFontData.FontInfo> s0() {
        PersonalFontData personalFontData = this.L;
        if (personalFontData == null || personalFontData.fontList.isEmpty()) {
            return null;
        }
        ArrayList<PersonalFontData.FontInfo> arrayList = new ArrayList<>();
        PersonalFontData personalFontData2 = this.L;
        if (personalFontData2.defaultFont > 0) {
            Iterator<PersonalFontData.FontInfo> it = personalFontData2.fontList.iterator();
            while (it.hasNext()) {
                PersonalFontData.FontInfo next = it.next();
                if (next.f51895id == this.T) {
                    arrayList.add(0, next);
                } else {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList.addAll(personalFontData2.fontList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(PersonalFontData.FontInfo fontInfo) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        Activity activity = this.I.get();
        if (activity != null) {
            yo.d.q(activity, yo.f.i(yo.f.j(yo.f.j(yo.f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FONT_PREVIEW_URL, "https://h5.qzone.qq.com/font/preview/{fontId}?actId={actId}&ruleId={ruleId}&hasAuth={hasAuth}"), "{fontId}", fontInfo.f51895id), "{actId}", fontInfo.actId), "{ruleId}", fontInfo.ruleId), "{hasAuth}", fontInfo.hasAuth ? 1L : 0L), 608, null, null, null, false);
        }
    }

    private void u0(PersonalFontData.FontInfo fontInfo) {
        String str;
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        Activity activity = this.I.get();
        if (activity != null) {
            String k3 = yo.f.k(yo.f.k(yo.f.k(yo.f.k(yo.f.k(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FONT_PREVIEW_FOR_SALE_URL, "https://h5.qzone.qq.com/font/itemPreview/{itemid}?actId={actId}&vipActId={vipActId}&ruleId={ruleId}&vipRuleId={vipRuleId}&platform=ua&hasAuth={hasAuth}"), "{itemid}", fontInfo.f51895id + ""), "{actId}", fontInfo.actId), "{ruleId}", fontInfo.ruleId), "{vipActId}", fontInfo.iVipActId), "{vipRuleId}", fontInfo.iVipRuleId);
            if (fontInfo.hasAuth) {
                str = "1";
            } else {
                str = "0";
            }
            yo.d.q(activity, yo.f.k(k3, "{hasAuth}", str), 608, null, null, null, false);
        }
    }

    private void v0(PersonalFontData.FontInfo fontInfo) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        Activity activity = this.I.get();
        if (activity != null) {
            String i3 = yo.f.i(yo.f.j(yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_BUY_FONT_URL, "https://h5.qzone.qq.com/vip/actpay?_wv=3&actId={actId}&ruleId={ruleId}&itemid={itemid}"), "{actId}", fontInfo.actId), "{ruleId}", fontInfo.ruleId), "{itemid}", fontInfo.f51895id);
            W("startH5Pay, h5url = " + i3);
            yo.d.q(activity, i3, 608, null, null, null, false);
        }
    }

    private void w0(PersonalFontData.FontInfo fontInfo) {
        Activity activity;
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        String str = fontInfo.strJumpUrlForActivity;
        WeakReference<Activity> weakReference = this.I;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        W("startItemActivityH5Page, url = " + str);
        yo.d.d(str, activity, null);
    }

    private void x0() {
        Activity activity = this.I.get();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("aid", "jhan_ssziti");
            intent.putExtra("direct_go", true);
            VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(activity, intent, 608);
        }
    }

    protected void A() {
        EventCenter.getInstance().addUIObserver(this, "PersonalFont", 1);
    }

    protected void B() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout = this.f45336e0;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f45336e0.getChildAt(i3);
                if (childAt != null && (layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams()) != null) {
                    layoutParams.setMargins(0, 0, com.qzone.util.ar.e(9.0f), 0);
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public long O() {
        PersonalFontData personalFontData = this.L;
        if (personalFontData == null || personalFontData.newCustomFontId <= 0) {
            return 0L;
        }
        return personalFontData.newCustomFontIdEndTime;
    }

    protected View P(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return null;
        }
        return this.N.get(i16);
    }

    protected int Q(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return 0;
        }
        return i16;
    }

    public PersonalFontData.FontInfo R() {
        return M(this.S);
    }

    protected void U() {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneFontPanel", 4, "begin initFontPanel");
        }
        this.W = true;
        A();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontPanel.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneFontPanel.this.f0();
            }
        });
        ((IFontManager) QRoute.api(IFontManager.class)).getETEngine();
        V();
    }

    public void d0(boolean z16) {
        if (this.W || z16) {
            PersonalFontService.K().J(this.K, null, this.f45342k0 ? 2 : 1);
        }
    }

    protected void e0(int i3) {
        setViewVisible(K(i3), 4);
    }

    protected void f0() {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneFontPanel", 4, "restoreCacheFontData");
        }
        if (VipMMKV.getCommon().decodeBool("qzone_font_panel_request_key", false)) {
            PersonalFontService.K().I(LoginData.getInstance().getUin(), null);
            VipMMKV.getCommon(this.K + "").encodeBool("qzone_font_panel_request_key", false);
            return;
        }
        PersonalFontService.K().S(this.K, this.f45342k0 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.ADView
    public void g(Context context) {
        super.g(context);
        p0(this, this.Q);
        setCircle(false);
    }

    public void g0() {
        int i3;
        W("saveFontData, selFontId = " + this.S);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontPanel.10
            @Override // java.lang.Runnable
            public void run() {
                QZoneFontPanel qZoneFontPanel = QZoneFontPanel.this;
                qZoneFontPanel.h0(qZoneFontPanel.S, true);
            }
        });
        PersonalFontData personalFontData = this.L;
        if (personalFontData == null || (i3 = this.S) < 0) {
            return;
        }
        personalFontData.defaultFont = i3;
        PersonalFontService.K().V(this.K, this.L, 1, this.f45342k0 ? 2 : 1);
    }

    @Override // com.tencent.mobileqq.widget.ADView
    protected void h(LinearLayout linearLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, 100000);
        layoutParams.addRule(14, 100000);
        layoutParams.setMargins(0, 0, 0, com.qzone.util.ar.e(17.5f));
        linearLayout.setGravity(16);
        this.f45336e0 = linearLayout;
        linearLayout.setLayoutParams(layoutParams);
    }

    protected boolean i0() {
        int i3 = this.f45332a0;
        if (i3 <= 0) {
            return false;
        }
        this.f45332a0 = 0;
        PersonalFontData.FontInfo M = M(i3);
        if (M != null && M.hasAuth) {
            String trueTypeFont = ((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(i3, null, null, true, null);
            View J = J(i3);
            if (TextUtils.isEmpty(trueTypeFont)) {
                boolean isWifiConn = NetworkState.isWifiConn();
                W("onClick isWifi = " + isWifiConn);
                if (!isWifiConn) {
                    r0(J, M, null);
                    return false;
                }
                F(J, M);
                return false;
            }
            m0(i3);
            return true;
        }
        W("selectfont check info not auth , font id " + i3);
        return false;
    }

    public boolean n0(int i3) {
        W("setSelectFontInfo, fontId = " + i3);
        if (i3 > 0 && TextUtils.isEmpty(((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(i3, null, null, true, null))) {
            QZLog.w("QZoneFontPanel", "setSelectFontInfo, font[" + i3 + "] has not cache. so reset select font id -> 0");
            i3 = 0;
        }
        return m0(i3);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object obj;
        if ("PersonalFont".equals(event.source.getName())) {
            W("onEventUIThread, event = " + event);
            if (event.what == 1 && (obj = event.params) != null && (obj instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length >= 3) {
                    Z(((Long) objArr[0]).longValue(), (PersonalFontData) objArr[1], ((Integer) objArr[2]).intValue());
                }
            }
        }
    }

    public void setBackgroundResId(int i3) {
        this.Q = i3;
    }

    public void setFontItemClickListener(e eVar) {
        this.f45340i0 = eVar;
    }

    public void setItemBackgroundDrawable(int i3) {
        this.R = i3;
    }

    public void setReportCallback(f fVar) {
        this.f45345n0 = fVar;
    }

    public void y0() {
        this.U = true;
        m0(0);
    }

    private void a0(ArrayList<PersonalFontData.FontInfo> arrayList, int i3) {
        if (arrayList == null || arrayList.isEmpty() || i3 <= 0 || i3 > arrayList.size()) {
            return;
        }
        PersonalFontData.FontInfo fontInfo = arrayList.get(i3 - 1);
        View K = K(i3);
        if (K == null) {
            return;
        }
        ImageView imageView = (ImageView) K.findViewById(R.id.chy);
        if (this.S == fontInfo.f51895id) {
            setViewVisible(imageView, 0);
        } else {
            setViewVisible(imageView, 8);
        }
    }

    private void q0() {
        b0(true, false);
        d0(false);
    }

    private void T(Activity activity, EditText editText, long j3) {
        this.f315348d = R.drawable.atx;
        this.f315349e = R.drawable.atx;
        this.I = new WeakReference<>(activity);
        this.J = new WeakReference<>(editText);
        this.f45335d0 = new Handler(Looper.getMainLooper());
        this.K = j3;
        U();
    }

    public static void setViewVisible(View view, int i3) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != 0) {
            this.M = false;
        } else {
            this.M = true;
            f fVar = this.f45345n0;
            if (fVar != null) {
                fVar.a();
            }
            q0();
        }
        super.setVisibility(i3);
    }

    private View J(int i3) {
        PersonalFontData personalFontData;
        if (i3 != 0 && (personalFontData = this.L) != null && !personalFontData.fontList.isEmpty()) {
            int size = this.L.fontList.size();
            for (int i16 = 0; i16 < size; i16++) {
                View K = K(i16);
                if (K != null) {
                    Object tag = K.getTag(R.id.jam);
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i3) {
                        return K;
                    }
                }
            }
        }
        return null;
    }

    protected int N(ArrayList<PersonalFontData.FontInfo> arrayList) {
        if (arrayList == null) {
            return 2;
        }
        return 2 + arrayList.size();
    }

    private void C(int i3) {
        int i16 = i3 > 4 ? 1 + ((i3 - 1) / 4) : 1;
        if (i16 == this.N.size()) {
            return;
        }
        this.N.clear();
        i();
        while (this.N.size() < i16) {
            View Y = Y();
            if (Y == null) {
                return;
            }
            b(Y, this.N.size());
            B();
            this.N.add(Y);
        }
        p0(this.f315352i, this.Q);
        this.f315352i.setOnScreenChangeListener(this.f45344m0);
    }

    private boolean H(PersonalFontData personalFontData, PersonalFontData personalFontData2) {
        if (personalFontData == personalFontData2) {
            return true;
        }
        if (personalFontData == null || personalFontData2 == null || personalFontData.defaultFont != personalFontData2.defaultFont || personalFontData.fontList.size() != personalFontData2.fontList.size()) {
            return false;
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain, 0, personalFontData);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            Parcel obtain2 = Parcel.obtain();
            obtain2.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain2, 0, personalFontData2);
            byte[] marshall2 = obtain2.marshall();
            OaidMonitor.parcelRecycle(obtain2);
            if (marshall.length != marshall2.length) {
                return false;
            }
            for (int i3 = 0; i3 < marshall.length; i3++) {
                if (marshall[i3] != marshall2[i3]) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            W("equalsListData error, exception = " + th5.getMessage());
            return false;
        }
    }

    private View L(ViewGroup viewGroup, int i3) {
        if (viewGroup != null && i3 >= 0 && i3 <= 4) {
            if (i3 < 2) {
                LinearLayout linearLayout = (LinearLayout) viewGroup.getChildAt(0);
                if (linearLayout != null) {
                    return linearLayout.getChildAt(i3);
                }
            } else {
                LinearLayout linearLayout2 = (LinearLayout) viewGroup.getChildAt(1);
                if (linearLayout2 != null) {
                    return linearLayout2.getChildAt(i3 - 2);
                }
            }
        }
        return null;
    }
}
