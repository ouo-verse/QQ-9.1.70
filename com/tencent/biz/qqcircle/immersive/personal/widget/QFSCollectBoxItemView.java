package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCollectBoxItemView extends QCircleBaseWidgetView<FeedCloudFavoritessvr$FavoritesInfo> {

    /* renamed from: i, reason: collision with root package name */
    private static final int f89182i = cx.a(64.0f);

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89183d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89184e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f89185f;

    /* renamed from: h, reason: collision with root package name */
    private String f89186h;

    public QFSCollectBoxItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f89183d = (ImageView) findViewById(R.id.f44191oi);
        this.f89184e = (TextView) findViewById(R.id.f55992je);
        this.f89185f = (TextView) findViewById(R.id.f55982jd);
    }

    private void m0(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        int i3;
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_FOLDER_ITEM);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LIST_COLLECT_FOLDER_ID, Long.valueOf(feedCloudFavoritessvr$FavoritesInfo.f398434id.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_NAME, feedCloudFavoritessvr$FavoritesInfo.title.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_PRODUCT_NUM, Long.valueOf(feedCloudFavoritessvr$FavoritesInfo.feed_num.get()));
        if (this instanceof QFSRecommendCollectBoxItemView) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_RECOMMEND_TYPE, Integer.valueOf(i3));
        VideoReport.setElementParams(this, buildElementParams);
    }

    private void n0(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        if (!TextUtils.isEmpty(this.f89186h)) {
            if (TextUtils.equals(this.f89186h, feedCloudFavoritessvr$FavoritesInfo.cover_url.get())) {
                QLog.d("QFSCollectBoxItemView", 4, "[initImage] -> url is same ! url = " + this.f89186h);
                return;
            }
            if (TextUtils.equals(QCircleFeedPicLoader.getUniKeyFromUrl(this.f89186h), QCircleFeedPicLoader.getUniKeyFromUrl(feedCloudFavoritessvr$FavoritesInfo.cover_url.get()))) {
                QLog.d("QFSCollectBoxItemView", 4, "[initImage] -> getUniKeyFromUrl is same ! oldUrl = " + this.f89186h + " newUrl = " + feedCloudFavoritessvr$FavoritesInfo.cover_url.get());
                return;
            }
            QLog.d("QFSCollectBoxItemView", 4, "[initImage] -> update image ! oldUrl = " + this.f89186h + " newUrl = " + feedCloudFavoritessvr$FavoritesInfo.cover_url.get());
        }
        this.f89186h = feedCloudFavoritessvr$FavoritesInfo.cover_url.get();
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSCollectBoxItemView.this.o0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        if (this.f89186h != null && this.f89183d != null) {
            QLog.d("QFSCollectBoxItemView", 4, "[initImage] -> getMeasuredHeight() = " + getMeasuredHeight() + " getMeasuredWidth() = " + getMeasuredWidth());
            Option obtain = Option.obtain();
            int i3 = f89182i;
            Option targetView = obtain.setRequestHeight(i3).setRequestWidth(i3).setUrl(this.f89186h).setTargetView(this.f89183d);
            targetView.setLoadingDrawableColor(getResources().getColor(R.color.qvideo_skin_color_bg_skeleton));
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gki;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCollectBoxItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0 */
    public void bindData(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, int i3) {
        if (feedCloudFavoritessvr$FavoritesInfo != null && this.f89183d != null && this.f89184e != null && this.f89185f != null) {
            n0(feedCloudFavoritessvr$FavoritesInfo);
            this.f89184e.setText(feedCloudFavoritessvr$FavoritesInfo.title.get());
            this.f89185f.setText(getContext().getString(R.string.f188733xh, Long.valueOf(feedCloudFavoritessvr$FavoritesInfo.feed_num.get())));
            m0(feedCloudFavoritessvr$FavoritesInfo);
        }
    }
}
