package com.qzone.reborn.widget;

import android.content.Context;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.widget.AsyncImageView;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes37.dex */
public class QZoneFeedPicItemView extends BaseWidgetView<FeedPictureInfo> {

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f59627d;

    /* renamed from: e, reason: collision with root package name */
    public FeedPictureInfo f59628e;

    /* renamed from: f, reason: collision with root package name */
    public int f59629f;

    public QZoneFeedPicItemView(Context context) {
        super(context);
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.f69543j1);
        this.f59627d = asyncImageView;
        asyncImageView.setDefaultImage(R.drawable.ldo);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.hkt;
    }

    private void l0(FeedPictureInfo feedPictureInfo) {
        if (feedPictureInfo != null && feedPictureInfo.h() != null) {
            String str = feedPictureInfo.h().url;
            this.f59627d.setAsyncImage(feedPictureInfo.h().imageUrl, str);
            return;
        }
        QLog.e("QZoneFeedPicItemView", 1, "[getDrawableByPicInfo] pictureInfo == null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedPictureInfo feedPictureInfo, int i3) {
        if (feedPictureInfo == null) {
            return;
        }
        this.f59628e = feedPictureInfo;
        this.f59629f = i3;
        l0(feedPictureInfo);
    }
}
