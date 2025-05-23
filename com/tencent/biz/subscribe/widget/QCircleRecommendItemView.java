package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRecommendItemView extends BaseWidgetView<FeedCloudMeta$StFeed> {
    private SubscribeSquareImageView E;
    private QCircleAvatarView F;
    private LinearLayout G;
    private TextView H;
    private TextView I;
    private RFWAsyncRichTextView J;
    private Size K;

    public QCircleRecommendItemView(@NonNull Context context) {
        super(context);
    }

    private void t(String str) {
        if (this.J == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.J.setVisibility(8);
        } else {
            this.J.setText(str);
            this.J.setVisibility(0);
        }
    }

    private void u(String str) {
        if (TextUtils.isEmpty(str)) {
            v(false);
            return;
        }
        v(true);
        TextView textView = this.H;
        if (textView == null) {
            QLog.e("SCF-QCircleRecommendItemView", 1, "[updateRecommendReason] recommend reason text should not be null.");
        } else {
            textView.setText(str);
        }
    }

    private void v(boolean z16) {
        int i3;
        LinearLayout linearLayout = this.G;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        w(linearLayout, i3);
    }

    private void w(View view, int i3) {
        if (view == null) {
            QLog.e("SCF-QCircleRecommendItemView", 1, "[updateViewVisible] view should not be null.");
        } else if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.e1h;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (SubscribeSquareImageView) view.findViewById(R.id.duw);
        this.F = (QCircleAvatarView) view.findViewById(R.id.dvn);
        this.G = (LinearLayout) view.findViewById(R.id.tqj);
        this.H = (TextView) view.findViewById(R.id.tqk);
        this.I = (TextView) view.findViewById(R.id.tv_name);
        RFWAsyncRichTextView rFWAsyncRichTextView = (RFWAsyncRichTextView) view.findViewById(R.id.f167042k73);
        this.J = rFWAsyncRichTextView;
        rFWAsyncRichTextView.setSpecialClickAreaColor(R.color.f158017al3);
        this.J.setNeedSpecialHashTagAreaBackground(false);
        this.K = new Size((int) context.getResources().getDimension(R.dimen.f158493c61), (int) context.getResources().getDimension(R.dimen.f158493c61));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        Option targetView = Option.obtain().setRequestWidth(this.E.getMeasuredWidth()).setRequestHeight(this.E.getMeasuredHeight()).setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565).setTargetView(this.E);
        targetView.setLoadingDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_default)));
        QCircleFeedPicLoader.g().loadImage(targetView);
        this.F.setUser(feedCloudMeta$StFeed.poster, this.K);
        this.I.setText(feedCloudMeta$StFeed.poster.nick.get());
        t(feedCloudMeta$StFeed.content.get());
        u(feedCloudMeta$StFeed.recomInfo.recomReason.get());
    }
}
