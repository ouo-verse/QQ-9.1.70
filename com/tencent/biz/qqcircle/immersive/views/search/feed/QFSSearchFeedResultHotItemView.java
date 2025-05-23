package com.tencent.biz.qqcircle.immersive.views.search.feed;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFeedResultHotItemView extends QCircleBaseWidgetView<String> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final TextView f91110d;

    /* renamed from: e, reason: collision with root package name */
    private String f91111e;

    /* renamed from: f, reason: collision with root package name */
    private String f91112f;

    /* renamed from: h, reason: collision with root package name */
    private String f91113h;

    public QFSSearchFeedResultHotItemView(@NonNull Context context) {
        super(context);
        TextView textView = (TextView) findViewById(R.id.f53492cn);
        this.f91110d = textView;
        textView.setOnClickListener(this);
    }

    private void l0(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_feed_id", this.f91112f);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PEOPLE_SEARCH_TRANSFER_INFO, this.f91113h);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_MODE_INDEX, Integer.valueOf(i3));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_TEXT, str);
        i.k(this, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_QUERY_WORD, hashMap, str.hashCode());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gqu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchFeedResultHotItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(String str, int i3) {
        if (str == null) {
            return;
        }
        this.f91111e = str;
        this.f91110d.setText(str);
        l0(str, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f91110d) {
            QLog.d("QFSSearchFeedResultHotItemView", 1, "[onClick] keyword = " + this.f91111e);
            QFSSearchBean qFSSearchBean = new QFSSearchBean();
            qFSSearchBean.setSearchKeyword(this.f91111e);
            qFSSearchBean.setQuerySource(4);
            qFSSearchBean.setUserSource(p.s(getContext()));
            qFSSearchBean.setPageInteract(true);
            c.y0(getContext(), qFSSearchBean);
            EventCollector.getInstance().onViewClicked(this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setReportParams(String str, String str2) {
        this.f91112f = str;
        this.f91113h = str2;
    }
}
