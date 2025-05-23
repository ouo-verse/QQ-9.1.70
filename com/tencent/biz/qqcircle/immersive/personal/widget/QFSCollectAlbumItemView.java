package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$FeedAlbum;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCollectAlbumItemView extends QCircleBaseWidgetView<FeedCloudMeta$FeedAlbum> {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89177d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89178e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f89179f;

    /* renamed from: h, reason: collision with root package name */
    private String f89180h;

    /* renamed from: i, reason: collision with root package name */
    private Option f89181i;

    public QFSCollectAlbumItemView(@NonNull Context context) {
        super(context);
        this.f89181i = null;
        initView();
    }

    private void initView() {
        this.f89177d = (ImageView) findViewById(R.id.f44111oa);
        this.f89178e = (TextView) findViewById(R.id.f55922j8);
        this.f89179f = (TextView) findViewById(R.id.f55912j7);
    }

    private void m0(FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum) {
        if (!TextUtils.isEmpty(this.f89180h)) {
            if (TextUtils.equals(this.f89180h, feedCloudMeta$FeedAlbum.cover_url.get())) {
                QLog.d("QFSCollectAlbumItemView", 4, "[initImage] -> url is same ! url = " + this.f89180h);
                return;
            }
            if (TextUtils.equals(QCircleFeedPicLoader.getUniKeyFromUrl(this.f89180h), QCircleFeedPicLoader.getUniKeyFromUrl(feedCloudMeta$FeedAlbum.cover_url.get()))) {
                QLog.d("QFSCollectAlbumItemView", 4, "[initImage] -> getUniKeyFromUrl is same ! oldUrl = " + this.f89180h + " newUrl = " + feedCloudMeta$FeedAlbum.cover_url.get());
                return;
            }
            QLog.d("QFSCollectAlbumItemView", 4, "[initImage] -> update image ! oldUrl = " + this.f89180h + " newUrl = " + feedCloudMeta$FeedAlbum.cover_url.get());
        }
        this.f89180h = feedCloudMeta$FeedAlbum.cover_url.get();
        this.f89177d.setImageDrawable(null);
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSCollectAlbumItemView.this.n0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        if (this.f89180h != null && this.f89177d != null) {
            QLog.d("QFSCollectAlbumItemView", 4, "[initImage] -> getMeasuredHeight() = " + getMeasuredHeight() + " getMeasuredWidth() = " + getMeasuredWidth());
            this.f89181i = Option.obtain().setRequestHeight(getMeasuredHeight()).setRequestWidth(getMeasuredWidth()).setUrl(this.f89180h).setTargetView(this.f89177d);
            q50.b.e().q(this.f89181i, false);
            this.f89181i.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            this.f89181i.setLoadingDrawableColor(getResources().getColor(R.color.qvideo_skin_color_bg_default));
            QCircleFeedPicLoader.g().loadImage(this.f89181i);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCollectAlbumItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum, int i3) {
        if (feedCloudMeta$FeedAlbum != null && this.f89177d != null && this.f89178e != null && this.f89179f != null) {
            m0(feedCloudMeta$FeedAlbum);
            this.f89178e.setText(feedCloudMeta$FeedAlbum.title.get());
            this.f89179f.setText(getContext().getString(R.string.f188733xh, Integer.valueOf(feedCloudMeta$FeedAlbum.feed_count.get())));
        }
    }
}
