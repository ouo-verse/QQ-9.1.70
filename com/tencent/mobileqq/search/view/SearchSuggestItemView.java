package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.am;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchSuggestItemView extends BaseWidgetView<am> {

    /* renamed from: d, reason: collision with root package name */
    private TextView f285108d;

    public SearchSuggestItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f285108d = (TextView) findViewById(R.id.f111676lv);
    }

    private void m0(final View view, int i3, final am amVar) {
        final HashMap hashMap = new HashMap();
        hashMap.put("search_query_text", amVar.getWord());
        hashMap.put("serial_number", Integer.valueOf(i3 + 1));
        hashMap.put("trans_info", amVar.getSugTransInfo());
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.view.t
            @Override // java.lang.Runnable
            public final void run() {
                SearchSuggestItemView.n0(view, amVar, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(View view, am amVar, Map map) {
        VideoReport.setElementId(view, "em_bas_associative_word");
        VideoReport.setElementReuseIdentifier(view, String.valueOf(amVar.hashCode()));
        VideoReport.setElementParams(view, map);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.traverseExposure();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.h5d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(am amVar, int i3) {
        if (amVar != null && !TextUtils.isEmpty(amVar.getWord())) {
            String word = amVar.getWord();
            String hitKeyword = amVar.getHitKeyword();
            if (QLog.isColorLevel()) {
                QLog.d("SearchSuggestItemView", 1, "[bindData] pos: " + i3 + " word: " + word + " hintKeyword: " + hitKeyword);
            }
            this.f285108d.setText(SearchUtils.u0(word, hitKeyword, 10, true));
            m0(this, i3, amVar);
        }
    }
}
