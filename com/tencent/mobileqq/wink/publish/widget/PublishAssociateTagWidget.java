package com.tencent.mobileqq.wink.publish.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.publish.event.PublishAssociateTagEvent;
import com.tencent.mobileqq.wink.publish.util.WinkPublishConfigUtil;
import com.tencent.mobileqq.wink.publish.widget.PublishAssociateTagWidget;
import com.tencent.mobileqq.wink.utils.i;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StTagInfo;

/* loaded from: classes21.dex */
public class PublishAssociateTagWidget extends PublishBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    TextView f326086d;

    /* renamed from: e, reason: collision with root package name */
    TextView f326087e;

    /* renamed from: f, reason: collision with root package name */
    URLImageView f326088f;

    public PublishAssociateTagWidget(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f326086d = (TextView) findViewById(R.id.f9248580);
        this.f326087e = (TextView) findViewById(R.id.f924657y);
        this.f326088f = (URLImageView) findViewById(R.id.f924757z);
        this.f326086d.setTextSize(0, i.a(getContext(), 14.0f));
        this.f326087e.setTextSize(0, i.a(getContext(), 11.0f));
        int a16 = i.a(getContext(), 16.0f);
        this.f326088f.getLayoutParams().width = a16;
        this.f326088f.getLayoutParams().height = a16;
    }

    private void l0(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        if (!TextUtils.isEmpty(feedCloudMeta$StTagInfo.operateIconUrl.get())) {
            this.f326088f.setVisibility(0);
            this.f326088f.setBackgroundURL(feedCloudMeta$StTagInfo.operateIconUrl.get());
        } else if (feedCloudMeta$StTagInfo.tagType.get() == 1001) {
            this.f326088f.setVisibility(0);
            this.f326088f.setBackgroundURL(WinkPublishConfigUtil.f325969a.b());
        } else {
            this.f326088f.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new PublishAssociateTagEvent("#" + this.f326086d.getText().toString()));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj != null && (obj instanceof FeedCloudMeta$StTagInfo)) {
            setVisibility(0);
            FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = (FeedCloudMeta$StTagInfo) obj;
            this.f326086d.setText(feedCloudMeta$StTagInfo.tagName.get());
            this.f326087e.setText(feedCloudMeta$StTagInfo.tagDec.get());
            l0(feedCloudMeta$StTagInfo);
            this.f326086d.requestLayout();
        } else {
            setVisibility(8);
        }
        setOnClickListener(new View.OnClickListener() { // from class: q93.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishAssociateTagWidget.this.m0(view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.guv;
    }
}
