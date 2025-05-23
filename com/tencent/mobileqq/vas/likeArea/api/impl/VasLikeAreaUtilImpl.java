package com.tencent.mobileqq.vas.likeArea.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.likeArea.api.IVasLikeAreaUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.api.e;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasLikeAreaUtilImpl implements IVasLikeAreaUtil {
    private static final String KEY_EID = "dt_eid";
    private static final String KEY_PGID = "dt_pgid";
    private static final String LIKE_AREA_MORE = "em_likeplace_more";
    private static final String LIKE_AREA_SET = "pg_user_profile_likeplace_set";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f309988d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f309989e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f309990f;

        a(ActionSheet actionSheet, Activity activity, Map map) {
            this.f309988d = actionSheet;
            this.f309989e = activity;
            this.f309990f = map;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            this.f309988d.dismiss();
            if (i3 == 0) {
                String stringDataSet = VasToggle.VAS_LIKE_AREA_ENTRY.getStringDataSet("url", "");
                if (!TextUtils.isEmpty(stringDataSet)) {
                    String buildTraceDetailUrl = e.a().buildTraceDetailUrl(stringDataSet, IVipTraceDetailReport.FROM.PROFILECARD_LIKEAREA_SHEET);
                    if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.f309989e, buildTraceDetailUrl);
                    } else {
                        Intent intent = new Intent(this.f309989e, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", buildTraceDetailUrl);
                        this.f309989e.startActivity(intent);
                    }
                }
                VideoReport.reportEvent("clck", this.f309990f);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.likeArea.api.IVasLikeAreaUtil
    public void showLikeAreaSheet() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        ActionSheet create = ActionSheet.create(qBaseActivity);
        create.addButton("\u66f4\u591a\u4e2a\u6027\u8d5e\u533a");
        create.addCancelButton(R.string.cancel);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", LIKE_AREA_SET);
        hashMap.put("dt_eid", LIKE_AREA_MORE);
        create.setOnButtonClickListener(new a(create, qBaseActivity, hashMap));
        create.show();
        VideoReport.reportEvent("imp", hashMap);
    }
}
