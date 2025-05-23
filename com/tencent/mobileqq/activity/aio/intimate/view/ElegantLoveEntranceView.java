package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.vip.manager.d;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ElegantLoveEntranceView extends IntimateContentItemBaseView {
    private static final boolean L = VasToggle.VAS_LOVE_FLASH_ENTRY_NEW.isEnable(false);
    private d F;
    public boolean G;
    private View H;
    private View I;
    private View J;
    private View K;

    public ElegantLoveEntranceView(Context context) {
        this(context, null);
    }

    private void A(String str, View view) {
        if (com.tencent.mobileqq.activity.aio.intimate.a.a(str, this.f179223i.friendUin)) {
            view.findViewById(R.id.xex).setVisibility(0);
        } else {
            view.findViewById(R.id.xex).setVisibility(8);
        }
    }

    private void B() {
        View view;
        View view2;
        View view3;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101089", false)) {
            QLog.d("intimate_relationship", 1, "updateGlobalViewVisibility disable lover show");
            View view4 = this.H;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        View view5 = this.H;
        if (view5 != null && view5.getVisibility() == 8 && (view = this.I) != null && view.getVisibility() == 8 && (view2 = this.J) != null && view2.getVisibility() == 8 && (view3 = this.K) != null && view3.getVisibility() == 8) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    private void s(View view, String str) {
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        if ((view.getTag() instanceof String) && !TextUtils.isEmpty((CharSequence) view.getTag())) {
            intent.putExtra("url", (String) view.getTag());
            getContext().startActivity(intent);
            if (view.findViewById(R.id.xex) != null) {
                view.findViewById(R.id.xex).setVisibility(8);
            }
            MobileReportManager.getInstance().reportAction(str, "4", "qzone_vip_lovers", "aio_zuohua", "qq_lovers", 102, 0, System.currentTimeMillis());
        }
    }

    private String x(String str, String str2) {
        return "<font color=\"#999999\">" + str + " </font> <font color=\"#FF7EAE\">" + str2 + "</font>";
    }

    private void y() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_couplearea", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
    }

    private void z(JSONObject jSONObject, View view, String str) {
        try {
            if (jSONObject == null) {
                view.setVisibility(8);
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            String string = jSONObject2.getString("title");
            String string2 = jSONObject2.getString("content");
            String string3 = jSONObject2.getString("url");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                ((TextView) view.findViewById(R.id.sio)).setText(string);
                ((TextView) view.findViewById(R.id.sim)).setText(string2);
                view.setVisibility(0);
                view.setTag(string3);
                MobileReportManager.getInstance().reportAction(str, "4", "qzone_vip_lovers", "aio_zuohua", "qq_lovers", 101, 0, System.currentTimeMillis());
                QLog.d("ElegantLoveEntranceView", 4, "config: " + jSONObject);
                return;
            }
            view.setVisibility(8);
        } catch (Exception unused) {
            QLog.e("ElegantLoveEntranceView", 1, "");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        if (1 == this.f179224m && ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.fcz, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.f166152yv2);
        this.H = findViewById;
        findViewById.setOnClickListener(this);
        this.H.setOnTouchListener(this);
        View findViewById2 = inflate.findViewById(R.id.f165213v71);
        this.I = findViewById2;
        findViewById2.setOnClickListener(this);
        this.I.setOnTouchListener(this);
        View findViewById3 = inflate.findViewById(R.id.f112816oy);
        this.J = findViewById3;
        findViewById3.setOnClickListener(this);
        this.J.setOnTouchListener(this);
        View findViewById4 = inflate.findViewById(R.id.f96825iq);
        this.K = findViewById4;
        findViewById4.setOnClickListener(this);
        this.K.setOnTouchListener(this);
        MobileReportManager.getInstance().reportAction("qzone_lovers", "4", "qzone_vip_lovers", "aio_zuohua", "qq_lovers", 101, 0, System.currentTimeMillis());
        if (L) {
            JSONObject jsonString = VasToggle.VAS_LOVE_FLASH_ENTRY_NEW.getJsonString();
            z(jsonString, this.I, "xmz_1");
            z(jsonString, this.J, "xmz_2");
            z(jsonString, this.K, "xmz_3");
        } else {
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            this.K.setVisibility(8);
        }
        A("love", this.H);
        A("love_xmz_1", this.I);
        A("love_xmz_2", this.J);
        A("love_xmz_3", this.K);
        B();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
        int id5 = view.getId();
        if (id5 == R.id.f166152yv2) {
            if (j() == null) {
                return;
            }
            com.tencent.mobileqq.loverzone.a.b(j(), this.f179219d, 2064, "2");
            ReportController.o(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
            MobileReportManager.getInstance().reportAction("qzone_lovers", "4", "qzone_vip_lovers", "aio_zuohua", "qq_lovers", 102, 0, System.currentTimeMillis());
            View view2 = this.H;
            if (view2 != null && view2.findViewById(R.id.xex) != null) {
                this.H.findViewById(R.id.xex).setVisibility(8);
                return;
            }
            return;
        }
        if (id5 == R.id.f165213v71) {
            s(view, "xmz_1");
            y();
        } else if (id5 == R.id.f112816oy) {
            s(view, "xmz_2");
            y();
        } else if (id5 == R.id.f96825iq) {
            s(view, "xmz_3");
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void e() {
        super.e();
        if (!a()) {
            return;
        }
        View view = this.H;
        if (view != null && view.findViewById(R.id.xex) != null) {
            this.H.findViewById(R.id.xex).setVisibility(8);
        }
        View view2 = this.I;
        if (view2 != null && view2.findViewById(R.id.xex) != null) {
            this.I.findViewById(R.id.xex).setVisibility(8);
        }
        View view3 = this.J;
        if (view3 != null && view3.findViewById(R.id.xex) != null) {
            this.J.findViewById(R.id.xex).setVisibility(8);
        }
        View view4 = this.K;
        if (view4 != null && view4.findViewById(R.id.xex) != null) {
            this.K.findViewById(R.id.xex).setVisibility(8);
        }
    }

    public void t() {
        if (this.G) {
            u();
        }
    }

    public void u() {
        if (!a()) {
            if (QLog.isColorLevel()) {
                QLog.d("intimate_relationship", 2, "showLoverValueText stop request");
                return;
            }
            return;
        }
        this.G = false;
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "getLoverIntimateValue sendRequest");
        }
        if (this.F == null) {
            this.F = new d();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ElegantLoveEntranceView", 1, "getLoverIntimateValue fail, app is null");
            return;
        }
        try {
            this.F.f(Long.parseLong(peekAppRuntime.getCurrentAccountUin()));
        } catch (NumberFormatException e16) {
            QLog.d("ElegantLoveEntranceView", 1, "getLoverIntimateValue", e16);
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
    }

    public void v() {
        if (this.D) {
            this.H.setVisibility(8);
            B();
        }
    }

    public void w(String str, String str2, String str3) {
        if (this.D && a()) {
            ((TextView) this.H.findViewById(R.id.sim)).setText(Html.fromHtml(x(str, str2)));
            this.H.setTag(str3);
            this.H.setVisibility(0);
            B();
        }
    }

    public ElegantLoveEntranceView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ElegantLoveEntranceView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = true;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
    }
}
