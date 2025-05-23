package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.api.e;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.mobilereport.MobileReportManager;
import f61.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ElegantSpecialWordView extends IntimateContentItemBaseView {
    private View F;
    private Boolean G;

    public ElegantSpecialWordView(Context context) {
        this(context, null);
    }

    private void s(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        return ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.f168826gz3, (ViewGroup) this, true);
        this.F = inflate;
        inflate.setOnClickListener(this);
        this.F.setOnTouchListener(this);
        if (com.tencent.mobileqq.activity.aio.intimate.a.a("special_word", this.f179223i.friendUin)) {
            this.F.findViewById(R.id.xex).setVisibility(0);
        } else {
            this.F.findViewById(R.id.xex).setVisibility(8);
        }
        s(this.F, "em_luckynumber", null);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
        l lVar;
        IntimateInfo intimateInfo = this.f179223i;
        if (intimateInfo != null && (lVar = intimateInfo.specialWordInfo) != null && !TextUtils.isEmpty(lVar.f397959i)) {
            if (w.a(1000L)) {
                if (!TextUtils.isEmpty(this.f179223i.specialWordInfo.f397951a)) {
                    MobileReportManager.getInstance().reportAction("draw_card", "4", "DressVip", "3001142", "9", 102, 0, System.currentTimeMillis());
                } else {
                    MobileReportManager.getInstance().reportAction("open", "4", "DressVip", "3001142", "8", 102, 0, System.currentTimeMillis());
                }
                this.F.findViewById(R.id.xex).setVisibility(8);
                ReportController.o(null, "dc00898", "", "", "0X800B68D", "0X800B68D", 0, 0, "", "", "", "");
                Intent intent = new Intent(this.f179219d, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", e.a().buildTraceDetailUrl(this.f179223i.specialWordInfo.f397959i, IVipTraceDetailReport.FROM.LUCKYNUMBER_AIO));
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                this.f179219d.startActivity(intent);
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_luckynumber", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
                return;
            }
            QQToast.makeText(getContext(), 1, this.f179219d.getString(R.string.f161101wt), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void e() {
        View view;
        super.e();
        if (a() && (view = this.F) != null && view.findViewById(R.id.xex) != null) {
            this.F.findViewById(R.id.xex).setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
        l lVar;
        if (this.F != null && intimateInfo != null && (lVar = intimateInfo.specialWordInfo) != null) {
            if (!TextUtils.isEmpty(lVar.f397953c)) {
                ((TextView) this.F.findViewById(R.id.f165738xf4)).setText(intimateInfo.specialWordInfo.f397953c);
            }
            if (!TextUtils.isEmpty(intimateInfo.specialWordInfo.f397954d)) {
                ((TextView) this.F.findViewById(R.id.xez)).setText(intimateInfo.specialWordInfo.f397954d);
            }
            if (!TextUtils.isEmpty(intimateInfo.specialWordInfo.f397952b)) {
                ((ImageView) this.F.findViewById(R.id.f165736xf2)).setImageDrawable(com.tencent.mobileqq.vas.apng.api.a.a().getDynamicDrawable(intimateInfo.specialWordInfo.f397952b, new ApngOptions(), ""));
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(intimateInfo.specialWordInfo.f397951a)) {
                ((TextView) this.F.findViewById(R.id.f165734xf0)).setText("\u53bb\u62bd\u5361");
                MobileReportManager.getInstance().reportAction("", "", "DressVip", "3001142", "9", 100, 0, System.currentTimeMillis());
                hashMap.put("is_luckynumber_unlock", "0");
            } else {
                MobileReportManager.getInstance().reportAction("", "", "DressVip", "3001142", "8", 100, 0, System.currentTimeMillis());
                hashMap.put("is_luckynumber_unlock", "1");
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_luckynumber", null, hashMap);
        }
    }

    public ElegantSpecialWordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ElegantSpecialWordView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = Boolean.FALSE;
    }
}
