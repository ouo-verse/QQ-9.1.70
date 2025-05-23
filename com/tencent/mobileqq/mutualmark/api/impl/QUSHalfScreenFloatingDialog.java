package com.tencent.mobileqq.mutualmark.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.widget.util.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.utils.j;
import com.tencent.relation.common.widget.banner.Banner;
import com.tencent.relation.common.widget.banner.adapter.e;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QUSHalfScreenFloatingDialog extends Dialog {

    /* renamed from: m, reason: collision with root package name */
    public static final List<String> f251984m = new ArrayList(Arrays.asList("https://downv6.qq.com/extendfriend/mutual_mark_float_view_A.png", "https://downv6.qq.com/extendfriend/mutual_mark_float_view_B.png", "https://downv6.qq.com/extendfriend/mutual_mark_float_view_C.png", "https://downv6.qq.com/extendfriend/mutual_mark_float_view_D.png"));

    /* renamed from: d, reason: collision with root package name */
    private Banner f251985d;

    /* renamed from: e, reason: collision with root package name */
    private RadioGroup f251986e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.mutualmark.util.a f251987f;

    /* renamed from: h, reason: collision with root package name */
    LinearLayout f251988h;

    /* renamed from: i, reason: collision with root package name */
    private final QUSHalfScreenFloatingView f251989i;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes33.dex */
    @interface QUSHalfScreenFloatShowMode {
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUIButton f251992d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f251993e;

        b(QUIButton qUIButton, String str) {
            this.f251992d = qUIButton;
            this.f251993e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = this.f251992d.getTag();
            if (tag != null && (tag instanceof String)) {
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).jumpUrl(QUSHalfScreenFloatingDialog.this.getContext(), (String) tag);
            }
            QUSHalfScreenFloatingDialog.this.f251989i.t();
            QUSHalfScreenFloatingDialog.this.l(this.f251993e, "dt_clck");
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d extends e<String> {
        public d(List<String> list) {
            super(list);
        }

        private int u0() {
            Resources resources;
            Context context = QUSHalfScreenFloatingDialog.this.getContext();
            if (context == null || (resources = context.getResources()) == null) {
                return 0;
            }
            return resources.getColor(R.color.qui_common_fill_standard_primary, null);
        }

        @Override // com.tencent.relation.common.widget.banner.adapter.d
        /* renamed from: v0, reason: merged with bridge method [inline-methods] */
        public void p0(com.tencent.relation.common.widget.banner.holder.a aVar, String str, int i3, int i16) {
            URLDrawable c16;
            super.p0(aVar, str, i3, i16);
            QLog.d("MutualMarkFloatViewBannerAdapter", 1, "headerUrl\uff1a" + str);
            if (TextUtils.isEmpty(str) || (c16 = f.c(str, null, new ColorDrawable(u0()), new ColorDrawable(u0()))) == null) {
                return;
            }
            if (c16.getStatus() == 2) {
                QLog.d("MutualMarkFloatViewBannerAdapter", 1, "MutualMarkFloatViewBannerAdapter restartDownload");
                c16.restartDownload();
            } else {
                QLog.d("MutualMarkFloatViewBannerAdapter", 1, "MutualMarkFloatViewBannerAdapter success");
                aVar.E.setImageDrawable(c16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3) {
        int childCount = this.f251986e.getChildCount();
        int i16 = 0;
        while (i16 < childCount) {
            ((RadioButton) this.f251986e.getChildAt(i16)).setChecked(i16 == i3);
            i16++;
        }
    }

    private RadioButton f() {
        RadioButton radioButton = new RadioButton(getContext());
        radioButton.setButtonDrawable(R.drawable.f161100k20);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) radioButton.getLayoutParams();
        if (layoutParams == null) {
            int a16 = j.a(6.0f);
            layoutParams = new LinearLayout.LayoutParams(a16, a16);
        }
        layoutParams.leftMargin = j.a(4.0f);
        layoutParams.rightMargin = j.a(4.0f);
        radioButton.setLayoutParams(layoutParams);
        return radioButton;
    }

    private void i() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QUSHalfScreenFloatingDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        dismiss();
    }

    private boolean k(MotionEvent motionEvent) {
        Activity m3 = m(getContext());
        return m3 != null && m3.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, String str2) {
        HashMap<String, Object> pgTagProfileData = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagProfileData();
        if (HardCodeUtil.qqStr(R.string.f161841yt).equals(str)) {
            pgTagProfileData.put("interact_tag_wear_context_type", "1");
        } else {
            pgTagProfileData.put("interact_tag_wear_context_type", "2");
        }
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent(str2, "pg_tag_detail", "em_interact_tag_wear_context", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), pgTagProfileData);
    }

    public void h(String str, String str2, String str3, String str4, List<String> list) {
        ((ImageView) this.f251988h.findViewById(R.id.ohh)).setBackground(f.a(str));
        ((TextView) this.f251988h.findViewById(R.id.ohi)).setText(str2);
        QUIButton qUIButton = (QUIButton) this.f251988h.findViewById(R.id.f163135oh4);
        qUIButton.setText(str3);
        qUIButton.setTag(str4);
        qUIButton.setOnClickListener(new b(qUIButton, str3));
        if (list == null) {
            return;
        }
        Banner banner = (Banner) this.f251988h.findViewById(R.id.ohj);
        this.f251985d = banner;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) banner.getLayoutParams();
        layoutParams.topMargin = this.f251987f.g();
        this.f251985d.setLayoutParams(layoutParams);
        this.f251985d.A(new d(list)).B(g(4.0f, getContext().getResources())).z().x(true).f(new c());
        RadioGroup radioGroup = (RadioGroup) this.f251988h.findViewById(R.id.ohk);
        this.f251986e = radioGroup;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) radioGroup.getLayoutParams();
        layoutParams2.topMargin = this.f251987f.h();
        this.f251986e.setLayoutParams(layoutParams2);
        for (String str5 : list) {
            this.f251986e.addView(f());
        }
        l(str3, "dt_imp");
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent) || k(motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f251990d;

        a(Context context) {
            this.f251990d = context;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF52508d() {
            QUSHalfScreenFloatingDialog.this.f251988h = (LinearLayout) LayoutInflater.from(this.f251990d).inflate(R.layout.f167361cw4, (ViewGroup) null, false);
            return QUSHalfScreenFloatingDialog.this.f251988h;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return ViewUtils.dip2px(489.0f);
        }
    }

    public QUSHalfScreenFloatingDialog(Context context, int i3) {
        super(context, R.style.f173448dl);
        this.f251987f = new com.tencent.mobileqq.mutualmark.util.a(context);
        i();
        setContentView(R.layout.e3i);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        this.f251989i = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setQUSDragFloatController(new a(context));
        if (i3 == 2) {
            qUSHalfScreenFloatingView.setThemeId(1002);
        }
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.mutualmark.api.impl.b
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                QUSHalfScreenFloatingDialog.this.j();
            }
        });
    }

    private static Activity m(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private int g(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements qz3.b {
        c() {
        }

        @Override // qz3.b
        public void onPageScrolled(int i3, float f16, int i16) {
            QUSHalfScreenFloatingDialog.this.e(i3);
        }

        @Override // qz3.b
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // qz3.b
        public void onPageSelected(int i3) {
        }
    }
}
