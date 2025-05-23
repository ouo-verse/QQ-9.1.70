package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchResultHintView extends QFSFaultHintView {
    private QFSSearchInfo E;

    public QFSSearchResultHintView(@NonNull Context context) {
        this(context, null);
    }

    private void z0() {
        HashMap hashMap = new HashMap();
        QFSSearchInfo qFSSearchInfo = this.E;
        if (qFSSearchInfo != null) {
            hashMap.put("xsj_query_text", qFSSearchInfo.f());
        }
        VideoReport.setPageId(this, QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        TextView textView = this.f90326i;
        ua0.i.k(textView, QCircleDaTongConstant.ElementId.EM_XSJ_VOID_ITEM, hashMap, textView.hashCode());
    }

    public void A0(String str) {
        w0(str, "", QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_search"), R.drawable.qvideo_skin_emptystate_img_offline);
        this.C.setVisibility(8);
        z0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchResultHintView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    protected String l0() {
        return QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_offline");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    protected String m0() {
        return uq3.c.N1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    protected String n0() {
        return uq3.c.O1();
    }

    public void setSearchInfo(QFSSearchInfo qFSSearchInfo) {
        this.E = qFSSearchInfo;
    }

    public QFSSearchResultHintView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f90326i.setTypeface(Typeface.DEFAULT);
        this.f90326i.setTextColor(ie0.a.f().g(context, R.color.qui_common_text_primary, 1000));
        this.f90323e.setBackground(ie0.a.f().k(context, R.color.qui_common_bg_bottom_light, 0.0f, 1000));
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
