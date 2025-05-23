package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
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
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.publish.service.QzoneSuperPersonalFontService;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.util.ToastUtil;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.ExtendEditText;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.WorkSpaceView;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneSuperFontPanel extends ADView implements IObserver.main {
    public WeakReference<Activity> I;
    protected WeakReference<EditText> J;
    protected long K;
    protected QzoneSuperPersonalFontData L;
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
    protected int f45380a0;

    /* renamed from: b0, reason: collision with root package name */
    protected View f45381b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Handler f45382c0;

    /* renamed from: d0, reason: collision with root package name */
    protected LinearLayout f45383d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f45384e0;

    /* renamed from: f0, reason: collision with root package name */
    private RoundCornerProcessor f45385f0;

    /* renamed from: g0, reason: collision with root package name */
    protected c f45386g0;

    /* renamed from: h0, reason: collision with root package name */
    private ColorStateList f45387h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f45388i0;

    /* renamed from: j0, reason: collision with root package name */
    WorkSpaceView.b f45389j0;

    /* renamed from: k0, reason: collision with root package name */
    protected d f45390k0;

    /* renamed from: l0, reason: collision with root package name */
    private View.OnClickListener f45391l0;

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null) {
                int intValue = ((Integer) view.getTag(R.id.jam)).intValue();
                if (intValue < 0) {
                    QZLog.e("QZoneSuperFontPanel", "fontId = " + intValue);
                } else {
                    QZoneSuperFontPanel.this.O("onClick fontId = " + intValue);
                    QZoneSuperFontPanel qZoneSuperFontPanel = QZoneSuperFontPanel.this;
                    qZoneSuperFontPanel.V = true;
                    if (intValue == 0) {
                        qZoneSuperFontPanel.c0(intValue);
                        QZoneSuperFontPanel.this.w(intValue);
                    } else {
                        QzoneSuperPersonalFontData.SuperFontInfo D = qZoneSuperFontPanel.D(intValue);
                        if (D != null) {
                            if (!D.hasAuth) {
                                QZoneSuperFontPanel qZoneSuperFontPanel2 = QZoneSuperFontPanel.this;
                                qZoneSuperFontPanel2.W = true;
                                qZoneSuperFontPanel2.f45380a0 = intValue;
                                qZoneSuperFontPanel2.x(intValue);
                                QZoneSuperFontPanel.this.J(D.fontType, D);
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
                                QZoneSuperFontPanel.this.w(intValue);
                                QZoneSuperFontPanel.this.c0(intValue);
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public interface c {
        void a(int i3);

        void onClick(int i3);
    }

    /* loaded from: classes39.dex */
    public interface d {
        void a();
    }

    public QZoneSuperFontPanel(Activity activity, EditText editText, long j3) {
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
        this.f45380a0 = 0;
        this.f45381b0 = null;
        this.f45387h0 = null;
        this.f45388i0 = 0;
        this.f45389j0 = new WorkSpaceView.b() { // from class: com.qzone.common.activities.base.QZoneSuperFontPanel.1
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
                int childCount = QZoneSuperFontPanel.this.f45383d0.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt2 = QZoneSuperFontPanel.this.f45383d0.getChildAt(i16);
                    if (childAt2 != null) {
                        childAt2.setEnabled(false);
                    }
                }
                if (QZoneSuperFontPanel.this.e()) {
                    if (i3 != -1) {
                    }
                    i3 = childCount - 1;
                } else {
                    if (i3 != -1) {
                    }
                    i3 = 0;
                }
                if (i3 <= -1 || i3 >= childCount || (childAt = QZoneSuperFontPanel.this.f45383d0.getChildAt(i3)) == null) {
                    return;
                }
                childAt.setEnabled(true);
                QZoneSuperFontPanel qZoneSuperFontPanel = QZoneSuperFontPanel.this;
                qZoneSuperFontPanel.f45388i0 = i3;
                qZoneSuperFontPanel.f45382c0.postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.QZoneSuperFontPanel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneSuperFontPanel.this.T(false, false);
                    }
                }, 400L);
            }
        };
        this.f45390k0 = new a();
        this.f45391l0 = new b();
        L(activity, editText, j3);
    }

    private boolean A(View view) {
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

    private View B(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return null;
        }
        return C((ViewGroup) this.N.get(i16), i3 - (i16 * 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QzoneSuperPersonalFontData.SuperFontInfo D(int i3) {
        QzoneSuperPersonalFontData qzoneSuperPersonalFontData = this.L;
        if (qzoneSuperPersonalFontData != null && !qzoneSuperPersonalFontData.fontList.isEmpty()) {
            Iterator<QzoneSuperPersonalFontData.SuperFontInfo> it = this.L.fontList.iterator();
            while (it.hasNext()) {
                QzoneSuperPersonalFontData.SuperFontInfo next = it.next();
                if (next.f51897id == i3) {
                    return next;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        O("gotoPayFont, fontType = " + i3);
        if (i3 == 2) {
            k0();
            return;
        }
        if (i3 != 14 && i3 != 304 && i3 != 301 && i3 != 302) {
            i0();
        } else {
            j0(superFontInfo);
        }
    }

    private void N() {
        QzoneSuperPersonalFontData.SuperFontInfo fromJson;
        DefaultSuperFontInfo defaultSuperFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultSuperFont(this.K);
        if (defaultSuperFont == null || defaultSuperFont.fontId <= 0 || TextUtils.isEmpty(defaultSuperFont.jsonStr) || (fromJson = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(defaultSuperFont.jsonStr)) == null || fromJson.f51897id <= 0) {
            return;
        }
        a0(fromJson);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str) {
        QLog.d("QZoneSuperFontPanel", 4, str);
    }

    private void P(LinearLayout linearLayout) {
        Activity activity = this.I.get();
        if (activity == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(activity).inflate(R.layout.bok, (ViewGroup) null);
        frameLayout.setOnClickListener(this.f45391l0);
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

    private void R(long j3, QzoneSuperPersonalFontData qzoneSuperPersonalFontData, int i3) {
        int i16;
        int i17;
        if (this.K != j3) {
            QZLog.e("QZoneSuperFontPanel", "onDataChanged but uin are not the same , this.uin = " + this.K + ", enter uin= " + j3);
            return;
        }
        if (1 == i3 && qzoneSuperPersonalFontData == null && this.L == null) {
            U(false);
            return;
        }
        if (i3 == 0) {
            this.W = false;
        }
        if (z(this.L, qzoneSuperPersonalFontData)) {
            if (i3 == 0) {
                this.f45380a0 = 0;
                return;
            }
            return;
        }
        if (this.L == null && !this.V) {
            DefaultSuperFontInfo defaultSuperFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultSuperFont(j3);
            if (defaultSuperFont != null) {
                this.U = true;
                this.T = defaultSuperFont.fontId;
            } else if (1 == i3 && VasNormalToggle.VAS_BUG_SUPER_FONT_SWITCH.isEnable(true)) {
                U(true);
                return;
            } else {
                this.U = false;
                this.T = 0;
            }
        }
        if (i3 == 0 && qzoneSuperPersonalFontData != null && (i17 = qzoneSuperPersonalFontData.defaultFont) >= 0 && i17 != this.T) {
            this.T = i17;
            O("saveDefaultFontData from onDataChanged, defaultFont = " + qzoneSuperPersonalFontData.defaultFont);
            Y(this.T, false);
            if (!this.V) {
                this.S = this.T;
            }
            int i18 = qzoneSuperPersonalFontData.defaultFont;
            if (i18 > 0) {
                this.U = true;
            } else if (i18 == 0) {
                this.U = false;
            }
        }
        this.L = qzoneSuperPersonalFontData;
        int i19 = this.S;
        if (i19 >= 0) {
            c0(i19);
        } else if (i19 < 0 && qzoneSuperPersonalFontData != null && (i16 = this.T) >= 0) {
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
            QzoneSuperPersonalFontData qzoneSuperPersonalFontData = this.L;
            if (qzoneSuperPersonalFontData != null && this.K != qzoneSuperPersonalFontData.uin) {
                QZLog.w("QZoneSuperFontPanel", "refreshUi fail, mData is null, uin = " + this.K);
                return;
            }
            if (this.I.get() == null) {
                return;
            }
            ArrayList<QzoneSuperPersonalFontData.SuperFontInfo> h06 = h0();
            int F = F(h06);
            if (this.L != null) {
                O("refreshUi , font list size = " + F + ", default id = " + this.T + ", select id = " + this.S);
            } else {
                O("refreshUi , mData is empty.");
            }
            v(F);
            int i3 = this.f45388i0;
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
                View G = G(size);
                if (G != null) {
                    int H = H(size);
                    if (H >= i16 && H <= i17) {
                        boolean A = A(G);
                        if (z17) {
                            if (A) {
                                i18 = H;
                            } else if (i18 != H) {
                                S(h06, size);
                            }
                        }
                        if (size >= F) {
                            V(size);
                        } else if (h06 != null && !h06.isEmpty() && size > 0 && size <= h06.size()) {
                            b0(size, h06.get(size - 1));
                        }
                    } else if (z16) {
                        y(G);
                    }
                }
            }
        }
    }

    private void Y(int i3, boolean z16) {
        if (this.L == null || i3 < 0) {
            return;
        }
        QzoneSuperPersonalFontData.SuperFontInfo D = D(i3);
        if (D != null) {
            DefaultSuperFontInfo defaultSuperFontInfo = new DefaultSuperFontInfo();
            defaultSuperFontInfo.fontId = D.f51897id;
            defaultSuperFontInfo.jsonStr = D.toJson();
            ((IFontManager) QRoute.api(IFontManager.class)).setDefaultSuperFont(this.K, defaultSuperFontInfo);
            return;
        }
        if (z16 && this.U) {
            QzoneSuperPersonalFontService.F().N(this.K, null);
            QLog.i("QZoneSuperFontPanel", 1, "saveFontDataToConfig set default " + i3);
        }
        ((IFontManager) QRoute.api(IFontManager.class)).setDefaultSuperFont(this.K, null);
    }

    private void a0(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        EditText editText = this.J.get();
        if (editText == null) {
            O("setEditEffect, editText is null , so return");
            return;
        }
        if (editText instanceof ExtendEditText) {
            ExtendEditText extendEditText = (ExtendEditText) editText;
            if (superFontInfo == null) {
                ColorStateList colorStateList = this.f45387h0;
                if (colorStateList != null) {
                    extendEditText.setTextColor(colorStateList);
                    extendEditText.setHintTextColor(this.f45387h0);
                }
                extendEditText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                extendEditText.setTextColorAnimation(null, 0);
                extendEditText.setGradientColor(null, null, null);
                return;
            }
            if (this.f45387h0 == null) {
                this.f45387h0 = extendEditText.getTextColors();
            }
            if ((superFontInfo.lSparkleFlag & 1) != 0) {
                int parseColor = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor);
                extendEditText.setTextColor(parseColor);
                extendEditText.setHintTextColor(parseColor);
            } else {
                extendEditText.setTextColor(this.f45387h0);
                extendEditText.setHintTextColor(this.f45387h0);
            }
            if ((superFontInfo.lSparkleFlag & 2) != 0) {
                extendEditText.setShadowLayer(com.qzone.util.ar.e(superFontInfo.iShadowBlurRadius), com.qzone.util.ar.e(superFontInfo.iShadowOffsetX), com.qzone.util.ar.e(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
            } else {
                extendEditText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
                ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
                int size = superFontInfo.vecTextColorAnimation.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
                }
                extendEditText.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
            } else {
                extendEditText.setTextColorAnimation(null, 0);
            }
            if ((superFontInfo.lSparkleFlag & 4) != 0 && (arrayList = superFontInfo.vecGradientColor) != null && arrayList.size() >= 2 && (arrayList2 = superFontInfo.vecGradientPosition) != null && arrayList2.size() >= 2) {
                int size2 = superFontInfo.vecGradientColor.size();
                int[] iArr = new int[size2];
                for (int i16 = 0; i16 < size2; i16++) {
                    iArr[i16] = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecGradientColor.get(i16));
                }
                int size3 = superFontInfo.vecGradientPosition.size();
                float[] fArr = new float[size3];
                for (int i17 = 0; i17 < size3; i17++) {
                    fArr[i17] = superFontInfo.vecGradientPosition.get(i17).floatValue();
                }
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                int i18 = superFontInfo.iGradientDirection;
                if (i18 != 0) {
                    if (i18 == 1) {
                        orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                    } else if (i18 == 2) {
                        orientation = GradientDrawable.Orientation.TL_BR;
                    } else if (i18 == 3) {
                        orientation = GradientDrawable.Orientation.BL_TR;
                    }
                }
                extendEditText.setGradientColor(iArr, fArr, orientation);
                return;
            }
            extendEditText.setGradientColor(null, null, null);
        }
    }

    private void b0(int i3, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        Drawable drawable;
        View B = B(i3);
        if (B == null) {
            return;
        }
        int i16 = this.f45380a0;
        if (i16 > 0 && i16 == superFontInfo.f51897id && superFontInfo.hasAuth) {
            this.f45381b0 = B;
        }
        setViewVisible(B, 0);
        B.setTag(R.id.jam, Integer.valueOf(superFontInfo.f51897id));
        AsyncImageView asyncImageView = (AsyncImageView) B.findViewById(R.id.chp);
        TextView textView = (TextView) B.findViewById(R.id.chu);
        ImageView imageView = (ImageView) B.findViewById(R.id.cho);
        View findViewById = B.findViewById(R.id.chm);
        ImageView imageView2 = (ImageView) B.findViewById(R.id.chy);
        asyncImageView.setAsyncImageProcessor(this.f45385f0);
        asyncImageView.setAsyncImage(superFontInfo.coverUrl);
        ThemeUtil.setColorFilterIfNeed(asyncImageView, com.qzone.adapter.feedcomponent.i.H().p1());
        setViewVisible(asyncImageView, 0);
        setViewVisible(textView, 8);
        int i17 = superFontInfo.fontType;
        if (i17 == 2) {
            drawable = getResources().getDrawable(R.drawable.gjj);
        } else if (i17 == 14) {
            drawable = getResources().getDrawable(R.drawable.gji);
        } else {
            drawable = !TextUtils.isEmpty(superFontInfo.fontUsedTips) ? getResources().getDrawable(R.drawable.gjh) : null;
        }
        if (drawable != null) {
            setViewVisible(imageView, 0);
            imageView.setImageDrawable(drawable);
        } else {
            setViewVisible(imageView, 8);
        }
        setViewVisible(findViewById, 8);
        if (this.S == superFontInfo.f51897id) {
            setViewVisible(imageView2, 0);
        } else {
            setViewVisible(imageView2, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c0(int i3) {
        O("setSelectFont fontId = " + i3 + ", old select id = " + this.S);
        if (i3 != 0) {
            QzoneSuperPersonalFontData.SuperFontInfo D = D(i3);
            if (D == null) {
                QZLog.e("QZoneSuperFontPanel", "setSelectFont, getFontInfo return null, fontId = " + i3);
                a0(null);
            } else if (!D.hasAuth) {
                QZLog.e("QZoneSuperFontPanel", "setSelectFont, no auth, fontId = " + i3);
                a0(null);
            } else {
                a0(D);
            }
            i3 = 0;
        } else {
            a0(null);
        }
        this.f45384e0 = null;
        this.S = i3;
        T(false, false);
        return true;
    }

    private void e0(int i3) {
        View B = B(i3);
        if (B == null) {
            return;
        }
        setViewVisible(B, 0);
        B.setTag(R.id.jam, 0);
        AsyncImageView asyncImageView = (AsyncImageView) B.findViewById(R.id.chp);
        TextView textView = (TextView) B.findViewById(R.id.chu);
        ImageView imageView = (ImageView) B.findViewById(R.id.chy);
        View findViewById = B.findViewById(R.id.chm);
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

    private ArrayList<QzoneSuperPersonalFontData.SuperFontInfo> h0() {
        QzoneSuperPersonalFontData qzoneSuperPersonalFontData = this.L;
        if (qzoneSuperPersonalFontData == null || qzoneSuperPersonalFontData.fontList.isEmpty()) {
            return null;
        }
        ArrayList<QzoneSuperPersonalFontData.SuperFontInfo> arrayList = new ArrayList<>();
        QzoneSuperPersonalFontData qzoneSuperPersonalFontData2 = this.L;
        if (qzoneSuperPersonalFontData2.defaultFont > 0) {
            Iterator<QzoneSuperPersonalFontData.SuperFontInfo> it = qzoneSuperPersonalFontData2.fontList.iterator();
            while (it.hasNext()) {
                QzoneSuperPersonalFontData.SuperFontInfo next = it.next();
                if (next.f51897id == this.T) {
                    arrayList.add(0, next);
                } else {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList.addAll(qzoneSuperPersonalFontData2.fontList);
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

    private void j0(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        Activity activity = this.I.get();
        if (activity != null) {
            String j3 = yo.f.j(yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_BUY_FONT_URL, "https://h5.qzone.qq.com/vip/actpay?_wv=3&actId={actId}&ruleId={ruleId}&itemid={itemid}"), "{actId}", superFontInfo.actId), "{ruleId}", superFontInfo.ruleId);
            O("startH5Pay, h5url = " + j3);
            yo.d.q(activity, j3, -1, null, null, null, false);
        }
    }

    private void k0() {
        Activity activity = this.I.get();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("aid", "jhan_xczzb");
            intent.putExtra("direct_go", true);
            VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(activity, intent, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final int i3) {
        if (this.f45386g0 == null || this.I.get() == null) {
            return;
        }
        this.f45382c0.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneSuperFontPanel.3
            @Override // java.lang.Runnable
            public void run() {
                c cVar = QZoneSuperFontPanel.this.f45386g0;
                if (cVar != null) {
                    cVar.onClick(i3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final int i3) {
        if (this.f45386g0 == null || this.I.get() == null) {
            return;
        }
        this.f45382c0.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneSuperFontPanel.4
            @Override // java.lang.Runnable
            public void run() {
                c cVar = QZoneSuperFontPanel.this.f45386g0;
                if (cVar != null) {
                    cVar.a(i3);
                }
            }
        });
    }

    private void y(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout == null || linearLayout.getChildCount() == 0) {
            return;
        }
        linearLayout.removeAllViews();
    }

    public Map<String, String> E(Map<String, String> map) {
        QzoneSuperPersonalFontData.SuperFontInfo I = I();
        if (I != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, String.valueOf(I.f51897id));
            map.put("sparkle_json", I.toJson());
        }
        X();
        return map;
    }

    protected View G(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return null;
        }
        return this.N.get(i16);
    }

    protected int H(int i3) {
        int i16 = i3 / 4;
        if (i16 >= this.N.size()) {
            return 0;
        }
        return i16;
    }

    public QzoneSuperPersonalFontData.SuperFontInfo I() {
        return D(this.S);
    }

    public boolean K() {
        QzoneSuperPersonalFontData.SuperFontInfo I = I();
        return I != null && I.f51897id > 0;
    }

    public void U(boolean z16) {
        if (this.W || z16) {
            QzoneSuperPersonalFontService.F().E(this.K, null);
        }
    }

    protected void V(int i3) {
        setViewVisible(B(i3), 4);
    }

    protected void W() {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneSuperFontPanel", 4, "restoreCacheFontData");
        }
        QzoneSuperPersonalFontService.F().L(this.K);
    }

    public void X() {
        int i3;
        O("saveFontData, selFontId = " + this.S);
        Y(this.S, true);
        QzoneSuperPersonalFontData qzoneSuperPersonalFontData = this.L;
        if (qzoneSuperPersonalFontData == null || (i3 = this.S) < 0) {
            return;
        }
        qzoneSuperPersonalFontData.defaultFont = i3;
        QzoneSuperPersonalFontService.F().O(this.K, this.L, 1);
    }

    protected void Z() {
        final View view = this.f45381b0;
        this.f45381b0 = null;
        this.f45380a0 = 0;
        if (view != null) {
            this.f45382c0.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneSuperFontPanel.6
                @Override // java.lang.Runnable
                public void run() {
                    QZoneSuperFontPanel.this.f45391l0.onClick(view);
                }
            });
        }
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
        this.f45383d0 = linearLayout;
        linearLayout.setLayoutParams(layoutParams);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object obj;
        if ("PersonalFont".equals(event.source.getName())) {
            O("onEventUIThread, event = " + event);
            if (event.what == 2 && (obj = event.params) != null && (obj instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length >= 3) {
                    R(((Long) objArr[0]).longValue(), (QzoneSuperPersonalFontData) objArr[1], ((Integer) objArr[2]).intValue());
                }
            }
        }
    }

    public void setBackgroundResId(int i3) {
        this.Q = i3;
    }

    public void setFontItemClickListener(c cVar) {
        this.f45386g0 = cVar;
    }

    public void setItemBackgroundDrawable(int i3) {
        this.R = i3;
    }

    public void setReportCallback(d dVar) {
        this.f45390k0 = dVar;
    }

    protected void t() {
        EventCenter.getInstance().addUIObserver(this, "PersonalFont", 2);
    }

    protected void u() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout = this.f45383d0;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f45383d0.getChildAt(i3);
                if (childAt != null && (layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams()) != null) {
                    layoutParams.setMargins(0, 0, com.qzone.util.ar.e(9.0f), 0);
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    protected void M() {
        QLog.d("QZoneSuperFontPanel", 4, "begin initFontPanel");
        this.W = true;
        t();
        this.f45385f0 = new RoundCornerProcessor(com.qzone.util.ar.e(3.0f));
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneSuperFontPanel.5
            @Override // java.lang.Runnable
            public void run() {
                QZoneSuperFontPanel.this.W();
            }
        });
        N();
    }

    public void l0() {
        this.U = true;
        c0(0);
    }

    private void S(ArrayList<QzoneSuperPersonalFontData.SuperFontInfo> arrayList, int i3) {
        if (arrayList == null || arrayList.isEmpty() || i3 <= 0 || i3 > arrayList.size()) {
            return;
        }
        QzoneSuperPersonalFontData.SuperFontInfo superFontInfo = arrayList.get(i3 - 1);
        View B = B(i3);
        if (B == null) {
            return;
        }
        ImageView imageView = (ImageView) B.findViewById(R.id.chy);
        if (this.S == superFontInfo.f51897id) {
            setViewVisible(imageView, 0);
        } else {
            setViewVisible(imageView, 8);
        }
    }

    private void g0() {
        T(true, false);
        U(this.f45380a0 > 0);
    }

    private void L(Activity activity, EditText editText, long j3) {
        this.f315348d = R.drawable.atx;
        this.f315349e = R.drawable.atx;
        this.I = new WeakReference<>(activity);
        this.J = new WeakReference<>(editText);
        this.f45382c0 = new Handler(Looper.getMainLooper());
        this.K = j3;
        M();
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
            d dVar = this.f45390k0;
            if (dVar != null) {
                dVar.a();
            }
            g0();
        }
        super.setVisibility(i3);
    }

    /* loaded from: classes39.dex */
    class a implements d {
        a() {
        }

        @Override // com.qzone.common.activities.base.QZoneSuperFontPanel.d
        public void a() {
            LpReportInfo_pf00064.report(586, 23, 1);
        }
    }

    protected int F(ArrayList<QzoneSuperPersonalFontData.SuperFontInfo> arrayList) {
        if (arrayList == null) {
            return 1;
        }
        return 1 + arrayList.size();
    }

    private void v(int i3) {
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
                u();
                this.N.add(Q);
            }
        }
        f0(this.f315352i, this.Q);
        this.f315352i.setOnScreenChangeListener(this.f45389j0);
    }

    private boolean z(QzoneSuperPersonalFontData qzoneSuperPersonalFontData, QzoneSuperPersonalFontData qzoneSuperPersonalFontData2) {
        if (qzoneSuperPersonalFontData == qzoneSuperPersonalFontData2) {
            return true;
        }
        if (qzoneSuperPersonalFontData == null || qzoneSuperPersonalFontData2 == null || qzoneSuperPersonalFontData.defaultFont != qzoneSuperPersonalFontData2.defaultFont || qzoneSuperPersonalFontData.fontList.size() != qzoneSuperPersonalFontData2.fontList.size()) {
            return false;
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain, 0, qzoneSuperPersonalFontData);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            Parcel obtain2 = Parcel.obtain();
            obtain2.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain2, 0, qzoneSuperPersonalFontData2);
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

    private View C(ViewGroup viewGroup, int i3) {
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
