package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneBarrageEffectPanel;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.publish.service.QzoneBarrageEffectService;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.util.ToastUtil;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.WorkSpaceView;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class QZoneBarrageEffectPanel extends ADView implements IObserver.main {
    public WeakReference<Activity> I;
    protected WeakReference<EditText> J;
    protected long K;
    protected QzoneBarrageEffectData L;
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
    protected int f45209a0;

    /* renamed from: b0, reason: collision with root package name */
    protected View f45210b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Handler f45211c0;

    /* renamed from: d0, reason: collision with root package name */
    protected LinearLayout f45212d0;

    /* renamed from: e0, reason: collision with root package name */
    private f6.c f45213e0;

    /* renamed from: f0, reason: collision with root package name */
    protected b f45214f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f45215g0;

    /* renamed from: h0, reason: collision with root package name */
    WorkSpaceView.b f45216h0;

    /* renamed from: i0, reason: collision with root package name */
    protected c f45217i0;

    /* renamed from: j0, reason: collision with root package name */
    private View.OnClickListener f45218j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements WorkSpaceView.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            QZoneBarrageEffectPanel.this.T(false, false);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
        
            if (r5 == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0031, code lost:
        
            if (r5 == r0) goto L11;
         */
        @Override // com.tencent.mobileqq.widget.WorkSpaceView.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i3) {
            View childAt;
            int childCount = QZoneBarrageEffectPanel.this.f45212d0.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = QZoneBarrageEffectPanel.this.f45212d0.getChildAt(i16);
                if (childAt2 != null) {
                    childAt2.setEnabled(false);
                }
            }
            if (QZoneBarrageEffectPanel.this.e()) {
                if (i3 != -1) {
                }
                i3 = childCount - 1;
            } else {
                if (i3 != -1) {
                }
                i3 = 0;
            }
            if (i3 <= -1 || i3 >= childCount || (childAt = QZoneBarrageEffectPanel.this.f45212d0.getChildAt(i3)) == null) {
                return;
            }
            childAt.setEnabled(true);
            QZoneBarrageEffectPanel qZoneBarrageEffectPanel = QZoneBarrageEffectPanel.this;
            qZoneBarrageEffectPanel.f45215g0 = i3;
            qZoneBarrageEffectPanel.f45211c0.postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.as
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneBarrageEffectPanel.a.this.c();
                }
            }, 400L);
        }
    }

    /* loaded from: classes39.dex */
    public interface b {
        void a(int i3);

        void onClick(int i3);
    }

    /* loaded from: classes39.dex */
    public interface c {
        void a();
    }

    public QZoneBarrageEffectPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.N = new ArrayList<>();
        this.P = com.qzone.util.ar.e(12.5f);
        this.Q = R.color.qzone_skin_font_panel_background_color;
        this.R = R.drawable.azf;
        this.S = -1;
        this.T = -1;
        this.U = false;
        this.V = false;
        this.W = true;
        this.f45209a0 = 0;
        this.f45210b0 = null;
        this.f45215g0 = 0;
        this.f45216h0 = new a();
        this.f45217i0 = new c() { // from class: com.qzone.common.activities.base.am
            @Override // com.qzone.common.activities.base.QZoneBarrageEffectPanel.c
            public final void a() {
                QZoneBarrageEffectPanel.L();
            }
        };
        this.f45218j0 = new View.OnClickListener() { // from class: com.qzone.common.activities.base.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneBarrageEffectPanel.this.M(view);
            }
        };
    }

    private QzoneBarrageEffectData.BarrageEffectInfo B(int i3) {
        QzoneBarrageEffectData qzoneBarrageEffectData = this.L;
        if (qzoneBarrageEffectData != null && !qzoneBarrageEffectData.fontList.isEmpty()) {
            Iterator<QzoneBarrageEffectData.BarrageEffectInfo> it = this.L.fontList.iterator();
            while (it.hasNext()) {
                QzoneBarrageEffectData.BarrageEffectInfo next = it.next();
                if (next.f51896id == i3) {
                    return next;
                }
            }
        }
        return null;
    }

    private void G(int i3, QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        O("gotoPayFont, fontType = " + i3);
        if (i3 != 2 && i3 != 14 && i3 != 304 && i3 != 301 && i3 != 302) {
            i0();
        } else {
            j0(barrageEffectInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(int i3) {
        b bVar;
        if (com.qzone.reborn.feedx.util.l.a("QZoneBarrageEffectPanel") || (bVar = this.f45214f0) == null) {
            return;
        }
        bVar.onClick(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(int i3) {
        b bVar = this.f45214f0;
        if (bVar != null) {
            bVar.a(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int intValue = ((Integer) view.getTag(R.id.jam)).intValue();
            if (intValue < 0) {
                QZLog.e("QZoneBarrageEffectPanel", "fontId = " + intValue);
            } else {
                O("onClick fontId = " + intValue);
                this.V = true;
                if (intValue == 0) {
                    c0(intValue);
                    u(intValue);
                } else {
                    QzoneBarrageEffectData.BarrageEffectInfo B = B(intValue);
                    if (B != null) {
                        if (!B.hasAuth) {
                            this.W = true;
                            this.f45209a0 = intValue;
                            v(intValue);
                            G(B.fontType, B);
                        } else {
                            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
                            lpReportInfo_pf00064.toUin = LoginData.getInstance().getUin();
                            lpReportInfo_pf00064.toUin = LoginData.getInstance().getUin();
                            lpReportInfo_pf00064.actionType = 586;
                            lpReportInfo_pf00064.subactionType = 23;
                            lpReportInfo_pf00064.reserves = 2;
                            ArrayList<String> arrayList = new ArrayList<>(2);
                            lpReportInfo_pf00064.reservesExt = arrayList;
                            arrayList.add("");
                            lpReportInfo_pf00064.reservesExt.add(String.valueOf(intValue));
                            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064);
                            u(intValue);
                            c0(intValue);
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        this.f45218j0.onClick(view);
    }

    private void O(String str) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneBarrageEffectPanel", 2, str);
        }
    }

    private void P(LinearLayout linearLayout) {
        Activity activity = this.I.get();
        if (activity == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(activity).inflate(R.layout.boh, (ViewGroup) null);
        frameLayout.setOnClickListener(this.f45218j0);
        frameLayout.setTag(R.id.jam, -1);
        ViewGroup viewGroup = (ViewGroup) frameLayout.findViewById(R.id.chq);
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(this.R);
        }
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    private View Q() {
        Activity activity = this.I.get();
        if (activity == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        f0(linearLayout, this.Q);
        return linearLayout;
    }

    private void R(long j3, QzoneBarrageEffectData qzoneBarrageEffectData, int i3) {
        int i16;
        int i17;
        if (this.K != j3) {
            QZLog.e("QZoneBarrageEffectPanel", "onDataChanged but uin are not the same , this.uin = " + this.K + ", enter uin= " + j3);
            return;
        }
        if (1 == i3 && qzoneBarrageEffectData == null && this.L == null) {
            U(false);
            return;
        }
        if (i3 == 0) {
            this.W = false;
        }
        if (x(this.L, qzoneBarrageEffectData)) {
            if (i3 == 0) {
                this.f45209a0 = 0;
                return;
            }
            return;
        }
        if (this.L == null && !this.V) {
            DefaultBarrageEffectInfo defaultBarrageEffectInfo = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultBarrageEffectInfo(j3);
            if (defaultBarrageEffectInfo != null) {
                this.U = true;
                this.T = defaultBarrageEffectInfo.itemId;
            } else {
                this.U = false;
                this.T = 0;
            }
        }
        this.L = qzoneBarrageEffectData;
        if (i3 == 0 && qzoneBarrageEffectData != null && (i17 = qzoneBarrageEffectData.defaultFont) >= 0 && i17 != this.T) {
            this.T = i17;
            O("saveDefaultFontData from onDataChanged, defaultFont = " + qzoneBarrageEffectData.defaultFont);
            Y(this.T, false);
            if (!this.V) {
                this.S = this.T;
            }
            int i18 = qzoneBarrageEffectData.defaultFont;
            if (i18 > 0) {
                this.U = true;
            } else if (i18 == 0) {
                this.U = false;
            }
        }
        int i19 = this.S;
        if (i19 >= 0) {
            c0(i19);
        } else if (i19 < 0 && this.L != null && (i16 = this.T) >= 0) {
            d0(i16);
        } else {
            T(false, false);
        }
        if (i3 == 0) {
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00da, code lost:
    
        e0(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T(boolean z16, boolean z17) {
        if (this.M) {
            QzoneBarrageEffectData qzoneBarrageEffectData = this.L;
            if (qzoneBarrageEffectData != null && this.K != qzoneBarrageEffectData.uin) {
                QZLog.w("QZoneBarrageEffectPanel", "refreshUi fail, mData is null, uin = " + this.K);
                return;
            }
            if (this.I.get() == null) {
                return;
            }
            ArrayList<QzoneBarrageEffectData.BarrageEffectInfo> h06 = h0();
            int C = C(h06);
            if (this.L != null) {
                O("refreshUi , font list size = " + C + ", default id = " + this.T + ", select id = " + this.S);
            } else {
                O("refreshUi , mData is empty.");
            }
            t(C);
            int i3 = this.f45215g0;
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
                View D = D(size);
                if (D != null) {
                    int E = E(size);
                    if (E >= i16 && E <= i17) {
                        boolean y16 = y(D);
                        if (z17) {
                            if (y16) {
                                i18 = E;
                            } else if (i18 != E) {
                                S(h06, size);
                            }
                        }
                        if (size >= C) {
                            V(size);
                        } else if (h06 != null && !h06.isEmpty() && size > 0 && size <= h06.size()) {
                            b0(size, h06.get(size - 1));
                        }
                    } else if (z16) {
                        w(D);
                    }
                }
            }
        }
    }

    private void Y(int i3, boolean z16) {
        if (this.L == null || i3 < 0) {
            return;
        }
        QzoneBarrageEffectData.BarrageEffectInfo B = B(i3);
        if (B != null) {
            DefaultBarrageEffectInfo defaultBarrageEffectInfo = new DefaultBarrageEffectInfo();
            defaultBarrageEffectInfo.itemId = B.f51896id;
            defaultBarrageEffectInfo.jsonStr = B.toJson();
            ((IFontManager) QRoute.api(IFontManager.class)).setDefaultBarrageEffect(this.K, defaultBarrageEffectInfo);
            return;
        }
        if (z16 && this.U) {
            QzoneBarrageEffectService.G().O(this.K, null);
        }
        ((IFontManager) QRoute.api(IFontManager.class)).setDefaultBarrageEffect(this.K, null);
    }

    private void b0(int i3, QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        View z16 = z(i3);
        if (z16 == null) {
            return;
        }
        int i16 = this.f45209a0;
        if (i16 > 0 && i16 == barrageEffectInfo.f51896id) {
            this.f45210b0 = z16;
        }
        setViewVisible(z16, 0);
        z16.setTag(R.id.jam, Integer.valueOf(barrageEffectInfo.f51896id));
        AsyncImageView asyncImageView = (AsyncImageView) z16.findViewById(R.id.chp);
        ImageView imageView = (ImageView) z16.findViewById(R.id.a69);
        TextView textView = (TextView) z16.findViewById(R.id.chu);
        TextView textView2 = (TextView) z16.findViewById(R.id.a68);
        ImageView imageView2 = (ImageView) z16.findViewById(R.id.cho);
        TextView textView3 = (TextView) z16.findViewById(R.id.a66);
        View findViewById = z16.findViewById(R.id.chm);
        ImageView imageView3 = (ImageView) z16.findViewById(R.id.chy);
        asyncImageView.setAsyncImageProcessor(this.f45213e0);
        asyncImageView.setAsyncImage(barrageEffectInfo.coverUrl);
        ThemeUtil.setColorFilterIfNeed(asyncImageView, com.qzone.adapter.feedcomponent.i.H().p1());
        setViewVisible(asyncImageView, 0);
        textView3.setText(barrageEffectInfo.name);
        int i17 = barrageEffectInfo.fontType;
        if (i17 == 2) {
            imageView2.setImageDrawable(getResources().getDrawable(R.drawable.gjj));
            setViewVisible(imageView2, 0);
            textView3.setContentDescription(barrageEffectInfo.name + getResources().getString(R.string.f2203268t));
        } else if (i17 == 14) {
            imageView2.setImageDrawable(getResources().getDrawable(R.drawable.gji));
            setViewVisible(imageView2, 0);
            textView3.setContentDescription(barrageEffectInfo.name + getResources().getString(R.string.f2195966u));
        } else if (i17 == 12) {
            setViewVisible(imageView2, 8);
        } else if (i17 == 301) {
            if (!barrageEffectInfo.hasAuth) {
                textView2.setVisibility(0);
                textView2.setText((barrageEffectInfo.price / 10.0f) + "");
                imageView.setVisibility(0);
            }
        } else {
            setViewVisible(imageView2, 8);
        }
        setViewVisible(textView, 8);
        setViewVisible(findViewById, 8);
        if (this.S == barrageEffectInfo.f51896id) {
            setViewVisible(imageView3, 0);
        } else {
            setViewVisible(imageView3, 8);
        }
    }

    private boolean c0(int i3) {
        O("setSelectFont fontId = " + i3 + ", old select id = " + this.S);
        if (i3 != 0) {
            QzoneBarrageEffectData.BarrageEffectInfo B = B(i3);
            if (B == null) {
                QZLog.e("QZoneBarrageEffectPanel", "setSelectFont, getBarrageEffectInfo return null, fontId = " + i3);
                a0(null);
            } else if (!B.hasAuth) {
                QZLog.e("QZoneBarrageEffectPanel", "setSelectFont, no auth, fontId = " + i3);
                a0(null);
            } else {
                a0(B);
            }
            i3 = 0;
        } else {
            a0(null);
        }
        this.S = i3;
        u(i3);
        T(false, false);
        return true;
    }

    private void e0(int i3) {
        View z16 = z(i3);
        if (z16 == null) {
            return;
        }
        setViewVisible(z16, 0);
        z16.setTag(R.id.jam, 0);
        AsyncImageView asyncImageView = (AsyncImageView) z16.findViewById(R.id.chp);
        TextView textView = (TextView) z16.findViewById(R.id.chu);
        ImageView imageView = (ImageView) z16.findViewById(R.id.chy);
        View findViewById = z16.findViewById(R.id.chm);
        textView.setText(getResources().getString(R.string.gol));
        textView.setTextSize(20.0f);
        setViewVisible(asyncImageView, 8);
        setViewVisible(textView, 0);
        setViewVisible(findViewById, 8);
        if (this.S <= 0) {
            setViewVisible(imageView, 0);
        } else {
            setViewVisible(imageView, 8);
        }
    }

    private void f0(View view, int i3) {
        Activity activity;
        WeakReference<Activity> weakReference = this.I;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        view.setBackgroundColor(activity.getResources().getColor(i3));
    }

    private ArrayList<QzoneBarrageEffectData.BarrageEffectInfo> h0() {
        QzoneBarrageEffectData qzoneBarrageEffectData = this.L;
        if (qzoneBarrageEffectData == null || qzoneBarrageEffectData.fontList.isEmpty()) {
            return null;
        }
        ArrayList<QzoneBarrageEffectData.BarrageEffectInfo> arrayList = new ArrayList<>();
        QzoneBarrageEffectData qzoneBarrageEffectData2 = this.L;
        if (qzoneBarrageEffectData2.defaultFont > 0) {
            Iterator<QzoneBarrageEffectData.BarrageEffectInfo> it = qzoneBarrageEffectData2.fontList.iterator();
            while (it.hasNext()) {
                QzoneBarrageEffectData.BarrageEffectInfo next = it.next();
                if (next.f51896id == this.T) {
                    arrayList.add(0, next);
                } else {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList.addAll(qzoneBarrageEffectData2.fontList);
        }
        return arrayList;
    }

    private void i0() {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        Activity activity = this.I.get();
        if (activity != null) {
            String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FONT_STORE_URL, "https://h5.qzone.qq.com/fontStore/index?_wv=2098179");
            O("startFontMallPay, h5url = " + config);
            yo.d.p(activity, config, -1, null, null, null);
        }
    }

    private void j0(QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        String str;
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        Activity activity = this.I.get();
        if (activity != null) {
            String i3 = yo.f.i(yo.f.j(yo.f.j(yo.f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_BARRAGE_PREVIEW_URL, "https://h5.qzone.qq.com/font/preview/{fontId}?actId={actId}&ruleId={ruleId}&hasAuth={hasAuth}"), "{fontId}", barrageEffectInfo.f51896id), "{actId}", barrageEffectInfo.actId), "{ruleId}", barrageEffectInfo.ruleId), "{hasAuth}", barrageEffectInfo.hasAuth ? 1L : 0L);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            sb5.append("&isBubble=1&vip=");
            if (barrageEffectInfo.fontType == 2) {
                str = "1";
            } else {
                str = "2";
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            O("startBarrageEffectPreview, h5url = " + sb6);
            yo.d.p(activity, sb6, barrageEffectInfo.hasAuth ? -1 : 608, null, null, null);
        }
    }

    private void u(final int i3) {
        if (this.f45214f0 == null || this.I.get() == null) {
            return;
        }
        this.f45211c0.post(new Runnable() { // from class: com.qzone.common.activities.base.aq
            @Override // java.lang.Runnable
            public final void run() {
                QZoneBarrageEffectPanel.this.J(i3);
            }
        });
    }

    private void v(final int i3) {
        if (this.f45214f0 == null || this.I.get() == null) {
            return;
        }
        this.f45211c0.post(new Runnable() { // from class: com.qzone.common.activities.base.ao
            @Override // java.lang.Runnable
            public final void run() {
                QZoneBarrageEffectPanel.this.K(i3);
            }
        });
    }

    private void w(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout == null || linearLayout.getChildCount() == 0) {
            return;
        }
        linearLayout.removeAllViews();
    }

    private boolean y(View view) {
        Activity activity = this.I.get();
        if (activity == null) {
            return false;
        }
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout == null) {
            linearLayout = (LinearLayout) Q();
        }
        if (linearLayout == null || linearLayout.getChildCount() > 0) {
            return false;
        }
        LinearLayout linearLayout2 = new LinearLayout(activity);
        int i3 = this.P;
        linearLayout2.setPadding(i3, i3, i3, 0);
        linearLayout2.setOrientation(0);
        P(linearLayout2);
        P(linearLayout2);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout3 = new LinearLayout(activity);
        int i16 = this.P;
        linearLayout3.setPadding(i16, 0, i16, i16);
        linearLayout3.setOrientation(0);
        P(linearLayout3);
        P(linearLayout3);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        ((LinearLayout.LayoutParams) linearLayout3.getLayoutParams()).setMargins(0, 0, 0, com.qzone.util.ar.e(17.5f));
        return true;
    }

    private View z(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return null;
        }
        return A((ViewGroup) this.N.get(i16), i3 - (i16 * 4));
    }

    protected View D(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return null;
        }
        return this.N.get(i16);
    }

    protected int E(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return 0;
        }
        return i16;
    }

    public QzoneBarrageEffectData.BarrageEffectInfo F() {
        return B(this.S);
    }

    protected void I() {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneBarrageEffectPanel", 4, "begin initBarrageEffectPanel");
        }
        this.W = true;
        r();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.ap
            @Override // java.lang.Runnable
            public final void run() {
                QZoneBarrageEffectPanel.this.W();
            }
        });
        this.f45213e0 = new f6.c(com.qzone.util.ar.e(3.0f));
    }

    public void U(boolean z16) {
        if (this.W || z16) {
            QzoneBarrageEffectService.G().F(this.K, null);
        }
    }

    protected void V(int i3) {
        setViewVisible(z(i3), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W() {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneBarrageEffectPanel", 4, "restoreCacheFontData");
        }
        QzoneBarrageEffectService.G().M(this.K);
    }

    public void X() {
        int i3;
        O("saveFontData, selFontId = " + this.S);
        Y(this.S, true);
        QzoneBarrageEffectData qzoneBarrageEffectData = this.L;
        if (qzoneBarrageEffectData == null || (i3 = this.S) < 0) {
            return;
        }
        qzoneBarrageEffectData.defaultFont = i3;
        QzoneBarrageEffectService.G().P(this.K, this.L, 1);
    }

    protected void Z() {
        final View view = this.f45210b0;
        int i3 = this.f45209a0;
        this.f45210b0 = null;
        this.f45209a0 = 0;
        QzoneBarrageEffectData.BarrageEffectInfo B = B(i3);
        if (B == null || !B.hasAuth || view == null) {
            return;
        }
        this.f45211c0.post(new Runnable() { // from class: com.qzone.common.activities.base.ar
            @Override // java.lang.Runnable
            public final void run() {
                QZoneBarrageEffectPanel.this.N(view);
            }
        });
    }

    public boolean d0(int i3) {
        O("setSelectFontInfo, fontId = " + i3);
        return c0(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.ADView
    public void g(Context context) {
        super.g(context);
        f0(this, this.Q);
        setCircle(false);
    }

    @Override // com.tencent.mobileqq.widget.ADView
    protected void h(LinearLayout linearLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, 100000);
        layoutParams.addRule(14, 100000);
        layoutParams.setMargins(0, 0, 0, com.qzone.util.ar.e(17.5f));
        linearLayout.setGravity(16);
        this.f45212d0 = linearLayout;
        linearLayout.setLayoutParams(layoutParams);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object obj;
        if ("BarrageEffect".equals(event.source.getName())) {
            O("onEventUIThread, event = " + event);
            if (event.what == 1 && (obj = event.params) != null && (obj instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length >= 3) {
                    R(((Long) objArr[0]).longValue(), (QzoneBarrageEffectData) objArr[1], ((Integer) objArr[2]).intValue());
                }
            }
        }
    }

    protected void r() {
        EventCenter.getInstance().addUIObserver(this, "BarrageEffect", 1);
    }

    protected void s() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout = this.f45212d0;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f45212d0.getChildAt(i3);
                if (childAt != null && (layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams()) != null) {
                    layoutParams.setMargins(0, 0, com.qzone.util.ar.e(9.0f), 0);
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setBackgroundResId(int i3) {
        this.Q = i3;
    }

    public void setFontItemClickListener(b bVar) {
        this.f45214f0 = bVar;
    }

    public void setItemBackgroundDrawable(int i3) {
        this.R = i3;
    }

    public void setReportCallback(c cVar) {
        this.f45217i0 = cVar;
    }

    public void k0() {
        this.U = true;
        c0(0);
    }

    private void S(ArrayList<QzoneBarrageEffectData.BarrageEffectInfo> arrayList, int i3) {
        if (arrayList == null || arrayList.isEmpty() || i3 <= 0 || i3 > arrayList.size()) {
            return;
        }
        QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = arrayList.get(i3 - 1);
        View z16 = z(i3);
        if (z16 == null) {
            return;
        }
        ImageView imageView = (ImageView) z16.findViewById(R.id.chy);
        if (this.S == barrageEffectInfo.f51896id) {
            setViewVisible(imageView, 0);
        } else {
            setViewVisible(imageView, 8);
        }
    }

    private void g0() {
        T(true, false);
        U(this.f45209a0 > 0);
    }

    public static void setViewVisible(View view, int i3) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }

    public void H(Activity activity, EditText editText, long j3) {
        this.f315348d = R.drawable.atx;
        this.f315349e = R.drawable.atx;
        this.I = new WeakReference<>(activity);
        this.J = new WeakReference<>(editText);
        this.f45211c0 = new Handler(Looper.getMainLooper());
        this.K = j3;
        I();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != 0) {
            this.M = false;
        } else {
            this.M = true;
            c cVar = this.f45217i0;
            if (cVar != null) {
                cVar.a();
            }
            g0();
        }
        super.setVisibility(i3);
    }

    protected int C(ArrayList<QzoneBarrageEffectData.BarrageEffectInfo> arrayList) {
        if (arrayList == null) {
            return 1;
        }
        return 1 + arrayList.size();
    }

    private void t(int i3) {
        int i16 = i3 > 4 ? ((i3 - 1) / 4) + 1 : 1;
        if (i16 == this.N.size()) {
            return;
        }
        if (i16 < this.N.size()) {
            while (this.N.size() > i16) {
                j(0, this.N.size() - 1);
                ArrayList<View> arrayList = this.N;
                arrayList.remove(arrayList.size() - 1);
            }
        } else {
            while (this.N.size() < i16) {
                View Q = Q();
                if (Q == null) {
                    return;
                }
                b(Q, this.N.size());
                s();
                this.N.add(Q);
            }
        }
        f0(this.f315352i, this.Q);
        this.f315352i.setOnScreenChangeListener(this.f45216h0);
    }

    private boolean x(QzoneBarrageEffectData qzoneBarrageEffectData, QzoneBarrageEffectData qzoneBarrageEffectData2) {
        if (qzoneBarrageEffectData == qzoneBarrageEffectData2) {
            return true;
        }
        if (qzoneBarrageEffectData == null || qzoneBarrageEffectData2 == null || qzoneBarrageEffectData.defaultFont != qzoneBarrageEffectData2.defaultFont || qzoneBarrageEffectData.fontList.size() != qzoneBarrageEffectData2.fontList.size()) {
            return false;
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain, 0, qzoneBarrageEffectData);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            Parcel obtain2 = Parcel.obtain();
            obtain2.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain2, 0, qzoneBarrageEffectData2);
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
            O("equalsListData error, exception = " + th5.getMessage());
            return false;
        }
    }

    private View A(ViewGroup viewGroup, int i3) {
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

    public QZoneBarrageEffectPanel(Activity activity, EditText editText, long j3) {
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
        this.f45209a0 = 0;
        this.f45210b0 = null;
        this.f45215g0 = 0;
        this.f45216h0 = new a();
        this.f45217i0 = new c() { // from class: com.qzone.common.activities.base.am
            @Override // com.qzone.common.activities.base.QZoneBarrageEffectPanel.c
            public final void a() {
                QZoneBarrageEffectPanel.L();
            }
        };
        this.f45218j0 = new View.OnClickListener() { // from class: com.qzone.common.activities.base.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneBarrageEffectPanel.this.M(view);
            }
        };
        H(activity, editText, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L() {
    }

    private void a0(QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
    }
}
