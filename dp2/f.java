package dp2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher;
import com.tencent.mobileqq.search.event.SearchSettingStateChangeEvent;
import com.tencent.mobileqq.search.util.u;
import com.tencent.mobileqq.search.util.x;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends ReportDialog {
    private final Activity C;
    private final QUSHalfScreenFloatingView D;
    private FrameLayout E;
    private LinearLayout F;
    private final Map<Integer, String> G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @SuppressLint({"UseCompatLoadingForDrawables"})
        /* renamed from: createContentView */
        public View getF57419d() {
            f.this.E = new FrameLayout(f.this.getContext());
            f.this.E.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            f.this.E.setBackground(ie0.a.f().k(f.this.getContext(), R.color.qui_common_bg_top_light, 0.0f, 1000));
            f.this.E.setPadding(0, 0, 0, ViewUtils.dip2px(20.0f));
            f.this.initView();
            return f.this.E;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            int i3 = 3;
            if (f.this.G != null) {
                i3 = 3 + f.this.G.size();
            }
            return ViewUtils.dip2px(56.0f) * i3;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.widget.qus.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
            QLog.i("SearchSettingFloatingDialog", 1, "onShowDefault");
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
            QLog.i("SearchSettingFloatingDialog", 1, "onShowDefaultStart");
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
            QLog.i("SearchSettingFloatingDialog", 1, "onShowMin");
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
            QLog.i("SearchSettingFloatingDialog", 1, "onShowMinStart");
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            QLog.i("SearchSettingFloatingDialog", 1, "onShowTotal");
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            QLog.i("SearchSettingFloatingDialog", 1, "onShowTotalStart");
        }
    }

    public f(@NonNull Activity activity, Map<Integer, String> map) {
        super(activity, R.style.f173448dl);
        this.C = activity;
        this.G = map;
        initWindow();
        setContentView(R.layout.hpv);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        this.D = qUSHalfScreenFloatingView;
        AccessibilityUtil.n(qUSHalfScreenFloatingView, true);
        AccessibilityUtil.c(qUSHalfScreenFloatingView, "\u5173\u95ed", Button.class.getName());
        Z();
    }

    private void Y() {
        x.n(this.C, this.E);
    }

    private void Z() {
        this.D.setQUSDragFloatController(new a());
        this.D.j(new b());
        this.D.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: dp2.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                f.this.dismiss();
            }
        });
    }

    private void a0() {
        String str;
        Map<Integer, String> map = this.G;
        if (map == null) {
            return;
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            final int intValue = entry.getKey().intValue();
            final String value = entry.getValue();
            QLog.i("SearchSettingFloatingDialog", 1, "initHListSearchSwitch ={\u201cKey: " + intValue + ", Value: " + value + "}");
            boolean isEnableEntryModuleByType = ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).isEnableEntryModuleByType(intValue);
            final QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(this.C);
            qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.None);
            qUISingleLineListItem.setConfig(new x.b.d(value), new x.c.f(isEnableEntryModuleByType, new CompoundButton.OnCheckedChangeListener() { // from class: dp2.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    f.c0(intValue, qUISingleLineListItem, value, compoundButton, z16);
                }
            }));
            final Switch r65 = (Switch) qUISingleLineListItem.findViewById(R.id.f66283a8);
            TextView textView = (TextView) qUISingleLineListItem.findViewById(R.id.f66203a0);
            textView.setFocusable(true);
            if (AppSetting.f99565y) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: dp2.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f.d0(Switch.this, view);
                    }
                });
                qUISingleLineListItem.setOnClickListener(new View.OnClickListener() { // from class: dp2.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f.e0(Switch.this, view);
                    }
                });
            }
            r65.setFocusable(true);
            if (isEnableEntryModuleByType) {
                str = "\u5df2\u6253\u5f00";
            } else {
                str = "\u5df2\u5173\u95ed";
            }
            AccessibilityUtil.n(r65, true);
            AccessibilityUtil.s(r65, str + " " + value);
            AccessibilityUtil.c(textView, str + " " + value, android.widget.Switch.class.getName());
            AccessibilityUtil.c(qUISingleLineListItem, str + " " + value, android.widget.Switch.class.getName());
            u.p(r65, intValue, isEnableEntryModuleByType);
            this.F.addView(qUISingleLineListItem);
        }
        AccessibilityUtil.n(this.F, false);
        AccessibilityUtil.e(this.F, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(int i3, final QUISingleLineListItem qUISingleLineListItem, String str, CompoundButton compoundButton, boolean z16) {
        String str2;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            str2 = "\u5df2\u6253\u5f00";
        } else {
            str2 = "\u5df2\u5173\u95ed";
        }
        ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).setEnableEntryModuleByType(i3, z16);
        Switch r16 = (Switch) qUISingleLineListItem.findViewById(R.id.f66283a8);
        TextView textView = (TextView) qUISingleLineListItem.findViewById(R.id.f66203a0);
        u.o(r16, i3, z16);
        AccessibilityUtil.s(r16, str2 + " " + str);
        AccessibilityUtil.s(textView, str2 + " " + str);
        AccessibilityUtil.c(qUISingleLineListItem, str2 + " " + str, android.widget.Switch.class.getName());
        SimpleEventBus.getInstance().dispatchEvent(new SearchSettingStateChangeEvent());
        qUISingleLineListItem.postDelayed(new Runnable() { // from class: dp2.e
            @Override // java.lang.Runnable
            public final void run() {
                AccessibilityUtil.m(QUISingleLineListItem.this);
            }
        }, 1000L);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(Switch r16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        r16.toggle();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(Switch r16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        r16.toggle();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        LinearLayout X = X();
        this.F = X;
        X.setClickable(false);
        this.F.setFocusable(true);
        a0();
        Y();
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("SearchSettingFloatingDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    public LinearLayout X() {
        LinearLayout linearLayout = new LinearLayout(this.C);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        int dimensionPixelSize = this.C.getResources().getDimensionPixelSize(R.dimen.aes);
        TextView textView = new TextView(this.C);
        textView.setText(this.C.getString(R.string.f214025rs));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setGravity(1);
        textView.setTypeface(null, 1);
        textView.setTextSize(17.0f);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, ViewUtils.dip2px(8.0f));
        textView.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_text_primary));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this.C);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView2.setText(this.C.getString(R.string.f214015rr));
        textView2.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_text_secondary));
        textView2.setTextSize(14.0f);
        textView2.setPadding(dimensionPixelSize, ViewUtils.dip2px(8.0f), dimensionPixelSize * 2, dimensionPixelSize);
        linearLayout.addView(textView2);
        AccessibilityUtil.e(linearLayout, true);
        this.E.addView(linearLayout);
        return linearLayout;
    }
}
