package com.tencent.mobileqq.vas.qqvaluecard.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.api.e;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import m23.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* loaded from: classes20.dex */
public class QQValuePagView extends VasPagView {
    private static final Map<String, Integer> D = new HashMap();
    public static int E = 42;
    public static int F = 15;
    Function1<View, Unit> C;

    /* renamed from: d, reason: collision with root package name */
    private String f310592d;

    /* renamed from: e, reason: collision with root package name */
    private String f310593e;

    /* renamed from: f, reason: collision with root package name */
    protected n23.a f310594f;

    /* renamed from: h, reason: collision with root package name */
    private String f310595h;

    /* renamed from: i, reason: collision with root package name */
    private int f310596i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f310597m;

    /* loaded from: classes20.dex */
    class a implements Function1<View, Unit> {
        a() {
        }

        private boolean b(View view, ViewGroup.LayoutParams layoutParams) {
            String str;
            if (!TextUtils.isEmpty(QQValuePagView.this.f310593e)) {
                boolean v3 = QQValuePagView.this.v();
                int t16 = QQValuePagView.this.t(0, v3);
                if (t16 == 1) {
                    str = "up";
                } else if (t16 == -1) {
                    str = "down";
                } else {
                    str = "nochange";
                }
                String str2 = QQValuePagView.this.f310594f.f418041h + str;
                if (!QQValuePagView.this.o(view, layoutParams, t16, v3, str2 + "/qqvalue.pag", str2 + "/number.ttf", view.getLayoutParams().width)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(0, 0);
                view.setLayoutParams(layoutParams);
            }
            layoutParams.width = 0;
            layoutParams.height = BaseAIOUtils.f(QQValuePagView.F, view.getResources());
            if (view instanceof PAGView) {
                if (b(view, layoutParams)) {
                    return Unit.INSTANCE;
                }
            } else {
                layoutParams.width = 0;
            }
            return Unit.INSTANCE;
        }
    }

    public QQValuePagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f310592d = "";
        this.f310593e = "";
        this.f310595h = "";
        this.f310596i = -2;
        this.f310597m = true;
        this.C = new a();
    }

    private boolean D(final PAGView pAGView, String str, String str2, String str3) {
        String str4;
        if (pAGView == null) {
            return false;
        }
        File file = new File(str2);
        File file2 = new File(str3);
        if (file.exists() && file2.exists()) {
            PAGFont RegisterFont = PAGFont.RegisterFont(str2);
            PAGFile Load = PagViewMonitor.Load(str3);
            if (Load == null || RegisterFont == null) {
                return false;
            }
            if (Load.numTexts() > 0) {
                PAGText textData = Load.getTextData(0);
                textData.fontFamily = RegisterFont.fontFamily;
                textData.fontStyle = RegisterFont.fontStyle;
                int i3 = this.f310594f.f418034a;
                if (i3 == -1) {
                    str4 = "????";
                } else {
                    str4 = i3 + "";
                }
                textData.text = str4;
                Load.replaceText(0, textData);
            }
            pAGView.setComposition(Load);
            pAGView.setRepeatCount(-1);
            pAGView.post(new Runnable() { // from class: com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView.3
                @Override // java.lang.Runnable
                public void run() {
                    pAGView.play();
                }
            });
            return true;
        }
        b.b().f(str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(final View view, final ViewGroup.LayoutParams layoutParams, final int i3, boolean z16, final String str, final String str2, int i16) {
        if (i16 <= 0 || z16) {
            if (((PAGView) view).getComposition() != null) {
                api().build();
                return true;
            }
            if (VasToggle.isEnable(VasToggle.PAGVIEW_ASYNC, false)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQValuePagView.this.C(view, str2, str, i3, layoutParams);
                    }
                }, 16, null, true);
            } else {
                C(view, str2, str, i3, layoutParams);
            }
        }
        return false;
    }

    private int p(String str, String str2) {
        Integer num = D.get(r(str, str2));
        if (num == null) {
            return -2;
        }
        return num.intValue();
    }

    private int q(String str, String str2) {
        Integer num = D.get(s(str, str2));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private String r(String str, String str2) {
        return "old_" + str + "_" + str2;
    }

    private String s(String str, String str2) {
        return "old_" + str + "_" + str2 + "_Trend";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t(int i3, boolean z16) {
        int p16 = p(this.f310593e, this.f310592d);
        if (z16 && p16 != -2 && this.f310594f.f418034a != p(this.f310593e, "setting") && this.f310594f.f418034a != p(this.f310593e, IndividuationUrlHelper.UrlId.CARD_HOME)) {
            int i16 = this.f310594f.f418034a;
            if (i16 == p16) {
                return 0;
            }
            if (i16 > p16) {
                return 1;
            }
            return -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        if (this.f310596i == this.f310594f.f418034a && q(this.f310593e, this.f310592d) == 0 && (this.f310592d != "setting" || this.f310593e == this.f310595h)) {
            return false;
        }
        return true;
    }

    private void w(String str, String str2, int i3) {
        D.put(r(str, str2), Integer.valueOf(i3));
    }

    private void x(String str, String str2, int i3) {
        D.put(s(str, str2), Integer.valueOf(i3));
    }

    private boolean y() {
        n23.a aVar;
        if ((this.f310597m && ((aVar = this.f310594f) == null || !aVar.f418040g)) || this.f310594f == null) {
            return false;
        }
        removeAllViews();
        TextView textView = new TextView(getContext());
        if (this.f310594f.f418034a == -1) {
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.o2x));
        } else {
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.o2y));
            textView.setText(this.f310594f.f418034a + "");
        }
        textView.setGravity(17);
        textView.setTextColor(-1);
        if (ar.b("kenaiyu", "2024-12-02", "vas_bug_134298457").isEnable(true)) {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
            textView.setTextSize(9.0f);
            wr0.a aVar2 = wr0.a.f446116a;
            textView.setPadding(aVar2.b(10), aVar2.b(1), 0, 0);
        } else {
            wr0.a aVar3 = wr0.a.f446116a;
            textView.setPadding(aVar3.b(10), 0, 0, aVar3.b(2));
            textView.setTextSize(11.0f);
            textView.setTextScaleX(0.9f);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        addView(textView, BaseAIOUtils.f(E, textView.getResources()), BaseAIOUtils.f(F, textView.getResources()));
        return true;
    }

    public void A(final String str, final boolean z16) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (this.f310595h.equals(str)) {
                B(str, this.f310592d, z16);
                return;
            }
            return;
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView.4
            @Override // java.lang.Runnable
            public void run() {
                if (QQValuePagView.this.f310595h.equals(str)) {
                    QQValuePagView qQValuePagView = QQValuePagView.this;
                    qQValuePagView.B(str, qQValuePagView.f310592d, z16);
                }
            }
        });
    }

    public void B(String str, String str2, boolean z16) {
        n23.a c16 = b.b().c(str);
        this.f310594f = c16;
        this.f310592d = str2;
        this.f310593e = str;
        if (c16 != null && c16.f418039f != 1 && c16.f418034a >= -1 && c16.f418035b != 0) {
            setVisibility(0);
            b.b().a(str2, this);
            if (str2 == IndividuationUrlHelper.UrlId.CARD_HOME && this.f310596i == this.f310594f.f418034a) {
                return;
            }
            if (this.f310594f != null) {
                setContentDescription("\u80fd\u91cf\u503c:" + this.f310594f.f418034a);
            }
            if (y()) {
                return;
            }
            VasCommonReporter.getHistoryFeature("QQValuePag").setValue2("updateQQValueCard").report();
            api().setStateChangeListener(this.C);
            if (!getIsBuild()) {
                api().build();
                return;
            } else {
                api().refresh();
                return;
            }
        }
        setVisibility(8);
    }

    protected void C(View view, String str, String str2, int i3, ViewGroup.LayoutParams layoutParams) {
        if (D((PAGView) view, this.f310593e, str, str2)) {
            z(view, i3, layoutParams);
        } else {
            layoutParams.width = 0;
        }
        view.postInvalidate();
    }

    public void setDynamicEnable(boolean z16) {
        this.f310597m = z16;
    }

    public void u(String str, String str2) {
        if (getContext() == null) {
            return;
        }
        if (this.f310594f == null) {
            this.f310594f = b.b().c(str2);
        }
        n23.a aVar = this.f310594f;
        if (aVar != null && !TextUtils.isEmpty(aVar.f418038e)) {
            String str3 = this.f310594f.f418038e;
            StringBuilder sb5 = new StringBuilder(str3);
            if (str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                sb5.append("&from=" + str);
            } else {
                sb5.append("?from=" + str);
            }
            String sb6 = sb5.toString();
            if (str.equals("setting")) {
                sb6 = e.a().buildTraceDetailUrl(sb6, IVipTraceDetailReport.FROM.QQSETTINGS_QQVALUE);
            } else if (str.equals(IndividuationUrlHelper.UrlId.CARD_HOME)) {
                sb6 = e.a().buildTraceDetailUrl(sb6, IVipTraceDetailReport.FROM.PROFILECARD_QQVALUE);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(getContext(), sb6);
                return;
            }
            Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", qQAppInterface.getCurrentUin());
            intent.putExtra("url", sb6);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            getContext().startActivity(intent);
        }
    }

    protected void z(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        x(this.f310593e, this.f310592d, i3);
        w(this.f310593e, this.f310592d, this.f310594f.f418034a);
        this.f310595h = this.f310593e;
        this.f310596i = this.f310594f.f418034a;
        layoutParams.width = BaseAIOUtils.f(E, view.getResources());
    }

    public QQValuePagView(@NotNull Context context) {
        super(context);
        this.f310592d = "";
        this.f310593e = "";
        this.f310595h = "";
        this.f310596i = -2;
        this.f310597m = true;
        this.C = new a();
    }

    public QQValuePagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f310592d = "";
        this.f310593e = "";
        this.f310595h = "";
        this.f310596i = -2;
        this.f310597m = true;
        this.C = new a();
    }

    public void n(boolean z16) {
    }
}
