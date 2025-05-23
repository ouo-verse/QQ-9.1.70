package com.tencent.biz.qqcircle.immersive.views.search.feed;

import android.content.Context;
import android.text.TextUtils;
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
import feedcloud.FeedCloudMeta$RecommendItem;
import java.util.HashMap;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFeedResultRelateItemView extends QCircleBaseWidgetView<FeedCloudMeta$RecommendItem> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final TextView f91119d;

    /* renamed from: e, reason: collision with root package name */
    private String f91120e;

    /* renamed from: f, reason: collision with root package name */
    private String f91121f;

    /* renamed from: h, reason: collision with root package name */
    private String f91122h;

    public QFSSearchFeedResultRelateItemView(@NonNull Context context) {
        super(context);
        TextView textView = (TextView) findViewById(R.id.f54172eh);
        this.f91119d = textView;
        textView.setOnClickListener(this);
    }

    private void l0(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_feed_id", this.f91121f);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_RELATED_SEARCH_TRANSFER_INFO, this.f91122h);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_MODE_INDEX, Integer.valueOf(i3));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_TEXT, str);
        i.k(this, QCircleDaTongConstant.ElementId.EM_XSJ_RELATED_SEARCH_WORD, hashMap, str.hashCode());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gqy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchFeedResultRelateItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$RecommendItem feedCloudMeta$RecommendItem, int i3) {
        if (feedCloudMeta$RecommendItem != null && !TextUtils.isEmpty(feedCloudMeta$RecommendItem.suggestion_word.get())) {
            String str = feedCloudMeta$RecommendItem.suggestion_word.get();
            this.f91120e = str;
            this.f91119d.setText(str);
            l0(this.f91120e, i3);
            return;
        }
        QLog.w("QFSSearchFeedResultRelateItemView", 1, "[onBindData] data should not be null.");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f91119d) {
            QLog.d("QFSSearchFeedResultRelateItemView", 1, "[onClick] keyword = " + this.f91120e);
            QFSSearchBean qFSSearchBean = new QFSSearchBean();
            qFSSearchBean.setSearchKeyword(this.f91120e);
            qFSSearchBean.setQuerySource(10);
            qFSSearchBean.setUserSource(p.s(getContext()));
            qFSSearchBean.setPageInteract(true);
            c.y0(view.getContext(), qFSSearchBean);
            EventCollector.getInstance().onViewClicked(this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setReportParams(String str, String str2) {
        this.f91121f = str;
        this.f91122h = str2;
    }
}
