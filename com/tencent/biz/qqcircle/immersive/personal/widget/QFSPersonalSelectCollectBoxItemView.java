package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;

/* loaded from: classes4.dex */
public class QFSPersonalSelectCollectBoxItemView extends QCircleBaseWidgetView<FeedCloudFavoritessvr$FavoritesInfo> {

    /* renamed from: f, reason: collision with root package name */
    private static final int f89337f = cx.a(54.0f);

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89338d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89339e;

    public QFSPersonalSelectCollectBoxItemView(@NonNull Context context) {
        super(context);
        l0(this);
    }

    private void l0(View view) {
        this.f89338d = (ImageView) view.findViewById(R.id.f44211ok);
        this.f89339e = (TextView) view.findViewById(R.id.kbs);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gn5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalCollectBoxAddFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, int i3) {
        Option obtain = Option.obtain();
        int i16 = f89337f;
        Option targetView = obtain.setRequestHeight(i16).setRequestWidth(i16).setUrl(feedCloudFavoritessvr$FavoritesInfo.cover_url.get()).setTargetView(this.f89338d);
        targetView.setLoadingDrawableColor(getResources().getColor(R.color.qvideo_skin_color_bg_skeleton));
        QCircleFeedPicLoader.g().loadImage(targetView);
        this.f89339e.setText(feedCloudFavoritessvr$FavoritesInfo.title.get());
    }
}
