package com.tencent.biz.qqcircle.immersive.search;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudRead$StSearchSubTag;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchResultSubTagsItemView extends QFSSearchBaseWidgetView<FeedCloudRead$StSearchSubTag> {

    /* renamed from: e, reason: collision with root package name */
    private final TextView f89858e;

    /* renamed from: f, reason: collision with root package name */
    private String f89859f;

    public QFSSearchResultSubTagsItemView(@NonNull Context context) {
        super(context);
        this.f89858e = (TextView) findViewById(R.id.f110226hy);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchResultSubTagsItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StSearchSubTag feedCloudRead$StSearchSubTag, int i3) {
        if (feedCloudRead$StSearchSubTag != null && !TextUtils.isEmpty(feedCloudRead$StSearchSubTag.text.get())) {
            String str = feedCloudRead$StSearchSubTag.text.get();
            this.f89859f = str;
            this.f89858e.setText(str);
            if (this.f89858e.isSelected()) {
                this.f89858e.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000));
                this.f89858e.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.f89858e.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary, 1000));
                this.f89858e.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }
}
