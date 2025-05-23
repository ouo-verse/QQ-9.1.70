package com.tencent.mobileqq.widget.participle;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;

/* loaded from: classes20.dex */
public class ParticipleBottomMenuView extends LinearLayout implements View.OnClickListener {
    private ImageView C;
    private ImageView D;
    private c E;

    /* renamed from: d, reason: collision with root package name */
    private ParticipleView f317130d;

    /* renamed from: e, reason: collision with root package name */
    private int f317131e;

    /* renamed from: f, reason: collision with root package name */
    private int f317132f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f317133h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f317134i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f317135m;

    /* loaded from: classes20.dex */
    class a implements ParticipleView.d {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleView.d
        public void a() {
            ParticipleBottomMenuView.this.f();
        }
    }

    /* loaded from: classes20.dex */
    class b implements ParticipleView.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleView.e
        public void onThemeChanged() {
            ParticipleBottomMenuView.this.f();
        }
    }

    /* loaded from: classes20.dex */
    public interface c {
        void a(String str);

        void b(String str);

        void c(String str);

        void d(String str);

        void onCancelClick();
    }

    public ParticipleBottomMenuView(Context context) {
        super(context);
        e(context, null);
    }

    private Drawable d(int i3, int i16) {
        return ie0.a.f().o(getContext(), i3, i16, 1000);
    }

    private void e(Context context, AttributeSet attributeSet) {
        String str;
        LayoutInflater.from(getContext()).inflate(R.layout.c9p, (ViewGroup) this, true);
        this.f317133h = (LinearLayout) findViewById(R.id.root);
        this.f317134i = (ImageView) findViewById(R.id.lyw);
        this.f317135m = (ImageView) findViewById(R.id.f166483lz0);
        this.C = (ImageView) findViewById(R.id.lyy);
        this.D = (ImageView) findViewById(R.id.f166485lz2);
        this.f317134i.setContentDescription(c(HardCodeUtil.qqStr(R.string.ozn)));
        this.f317135m.setContentDescription(c(HardCodeUtil.qqStr(R.string.ozr)));
        this.C.setContentDescription(c(HardCodeUtil.qqStr(R.string.ozq)));
        this.D.setContentDescription(c(HardCodeUtil.qqStr(R.string.ozo)));
        TextView textView = (TextView) findViewById(R.id.mdj);
        findViewById(R.id.lyx).setOnClickListener(this);
        findViewById(R.id.f166484lz1).setOnClickListener(this);
        findViewById(R.id.lyz).setOnClickListener(this);
        findViewById(R.id.f166486lz3).setOnClickListener(this);
        textView.setOnClickListener(this);
        if (attributeSet != null && context != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.P4);
            this.f317131e = obtainStyledAttributes.getInteger(jj2.b.R4, 0);
            this.f317132f = obtainStyledAttributes.getInteger(jj2.b.Q4, 200);
            obtainStyledAttributes.recycle();
        }
        f();
        int i3 = this.f317131e;
        if (i3 == 2) {
            return;
        }
        String str2 = "#000000";
        if (i3 == 1) {
            str = "#000000";
        } else {
            str = "#e6ffffff";
        }
        setBackgroundColor(Color.parseColor(str));
        if (QQTheme.isNowThemeIsNight()) {
            this.f317133h.setBackgroundColor(Color.parseColor("#000000"));
            textView.setTextColor(Color.parseColor("#999999"));
        } else {
            if (this.f317131e == 1) {
                str2 = TipsElementData.DEFAULT_COLOR;
            }
            textView.setTextColor(Color.parseColor(str2));
        }
    }

    public void a() {
        f();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(this.f317132f);
        setAlpha(0.0f);
        setVisibility(0);
        ofFloat.start();
    }

    public void b(ParticipleView participleView) {
        this.f317130d = participleView;
        participleView.setOnParticipleSelectChangeListener(new a());
        this.f317130d.setOnThemeChangedListener(new b());
    }

    public String c(String str) {
        return getContext().getString(R.string.ilz, str);
    }

    public void f() {
        ParticipleView participleView = this.f317130d;
        if (participleView != null && !TextUtils.isEmpty(participleView.B())) {
            int i3 = this.f317131e;
            if (i3 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_BLACK");
                }
                this.f317134i.setBackgroundResource(R.drawable.huk);
                this.f317135m.setBackgroundResource(R.drawable.f161808f12);
                this.C.setBackgroundResource(R.drawable.hup);
                this.D.setBackgroundResource(jj2.a.qq_ocr_translation_icon_normal);
                return;
            }
            if (i3 == 2) {
                this.f317134i.setBackground(d(R.drawable.qui_copy, R.color.qui_common_icon_primary));
                this.f317135m.setBackground(d(R.drawable.qui_share, R.color.qui_common_icon_primary));
                this.C.setBackground(d(R.drawable.qui_collection, R.color.qui_common_icon_primary));
                this.D.setBackground(d(R.drawable.qui_translate, R.color.qui_common_icon_primary));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
            }
            if (QQTheme.isNowThemeIsNight()) {
                this.f317134i.setBackgroundResource(R.drawable.f161803kt2);
                this.f317135m.setBackgroundResource(R.drawable.f161805kt4);
                this.C.setBackgroundResource(R.drawable.f161804kt3);
                this.D.setBackgroundResource(R.drawable.kt5);
                return;
            }
            this.f317134i.setBackgroundResource(R.drawable.hgl);
            this.f317135m.setBackgroundResource(R.drawable.hgo);
            this.C.setBackgroundResource(R.drawable.hgm);
            this.D.setBackgroundResource(R.drawable.hgp);
            return;
        }
        int i16 = this.f317131e;
        if (i16 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
            }
            this.f317134i.setBackgroundResource(R.drawable.hui);
            this.f317135m.setBackgroundResource(R.drawable.huu);
            this.C.setBackgroundResource(R.drawable.hun);
            this.D.setBackgroundResource(R.drawable.huw);
            return;
        }
        if (i16 == 2) {
            this.f317134i.setBackground(d(R.drawable.qui_copy, R.color.qui_common_icon_secondary));
            this.f317135m.setBackground(d(R.drawable.qui_share, R.color.qui_common_icon_secondary));
            this.C.setBackground(d(R.drawable.qui_collection, R.color.qui_common_icon_secondary));
            this.D.setBackground(d(R.drawable.qui_translate, R.color.qui_common_icon_secondary));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
        }
        if (QQTheme.isNowThemeIsNight()) {
            this.f317134i.setBackgroundResource(R.drawable.f161803kt2);
            this.f317135m.setBackgroundResource(R.drawable.f161805kt4);
            this.C.setBackgroundResource(R.drawable.f161804kt3);
            this.D.setBackgroundResource(R.drawable.kt5);
            return;
        }
        this.f317134i.setBackgroundResource(R.drawable.huj);
        this.f317135m.setBackgroundResource(R.drawable.huv);
        this.C.setBackgroundResource(R.drawable.huo);
        this.D.setBackgroundResource(R.drawable.huz);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.E != null) {
            if (view.getId() == R.id.mdj) {
                this.E.onCancelClick();
                ReportController.o(null, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
            } else {
                ParticipleView participleView = this.f317130d;
                if (participleView != null) {
                    String B = participleView.B();
                    if (!TextUtils.isEmpty(B)) {
                        if (view.getId() == R.id.lyx) {
                            this.E.a(B);
                            ReportController.o(null, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
                        } else if (view.getId() == R.id.lyz) {
                            this.E.d(B);
                            ReportController.o(null, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
                        } else if (view.getId() == R.id.f166484lz1) {
                            this.E.b(B);
                            ReportController.o(null, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
                        } else if (view.getId() == R.id.f166486lz3) {
                            this.E.c(B);
                            ReportController.o(null, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
                        }
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), -1, HardCodeUtil.qqStr(R.string.ozm), 0).show();
                    }
                } else {
                    QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.ozp), 0).show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnMenuClickListener(c cVar) {
        this.E = cVar;
    }

    public ParticipleBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }

    public ParticipleBottomMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e(context, attributeSet);
    }
}
