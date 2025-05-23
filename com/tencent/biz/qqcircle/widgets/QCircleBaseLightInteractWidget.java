package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QCircleBaseLightInteractWidget extends QCircleBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    protected FeedCloudMeta$StFeed f92932d;

    /* renamed from: e, reason: collision with root package name */
    protected FeedCloudMeta$StLightInteractInfo f92933e;

    /* renamed from: f, reason: collision with root package name */
    protected int f92934f;

    /* renamed from: h, reason: collision with root package name */
    protected QCircleExtraTypeInfo f92935h;

    public QCircleBaseLightInteractWidget(@NonNull Context context, int i3) {
        super(context, i3);
    }

    public void k0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3) {
        this.f92932d = feedCloudMeta$StFeed;
        this.f92935h = qCircleExtraTypeInfo;
        this.f92934f = i3;
    }
}
