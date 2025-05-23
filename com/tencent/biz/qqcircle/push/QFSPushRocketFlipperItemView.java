package com.tencent.biz.qqcircle.push;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.utils.al;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$PopStUserInfo;

/* loaded from: classes5.dex */
public class QFSPushRocketFlipperItemView extends QCircleBaseWidgetView<FeedCloudRead$PopStUserInfo> {

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f91809d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleRoundImageView f91810e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f91811f;

    /* renamed from: h, reason: collision with root package name */
    private Size f91812h;

    public QFSPushRocketFlipperItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f91809d = (FrameLayout) findViewById(R.id.f510126y);
        this.f91811f = (TextView) findViewById(R.id.f510226z);
        this.f91812h = n.a(getContext(), R.dimen.d0k);
        l0();
    }

    private void l0() {
        int dpToPx = ImmersiveUtils.dpToPx(0.5f);
        this.f91810e = new QCircleRoundImageView(getContext(), null, 0);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f91810e.setLayoutParams(layoutParams);
        this.f91810e.setRoundRect(DisplayUtil.getScreenHeight() / 2);
        this.f91810e.setBackgroundDrawable(null);
        this.f91809d.addView(this.f91810e);
        if (dpToPx != 0) {
            View view = new View(getContext());
            view.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setStroke(dpToPx, getResources().getColor(R.color.ciz));
            view.setBackgroundDrawable(gradientDrawable);
            this.f91809d.addView(view);
        }
    }

    private void n0(String str, String str2) {
        if (this.f91811f != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(str2);
            if (indexOf < 0) {
                this.f91811f.setText(str);
                return;
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.clg)), indexOf, str2.length() + indexOf, 34);
            spannableString.setSpan(new StyleSpan(1), indexOf, str2.length() + indexOf, 34);
            this.f91811f.setText(spannableString);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPushRocketFlipperItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$PopStUserInfo feedCloudRead$PopStUserInfo, int i3) {
        if (feedCloudRead$PopStUserInfo == null) {
            return;
        }
        m0(feedCloudRead$PopStUserInfo.user.get(), this.f91812h);
        n0(feedCloudRead$PopStUserInfo.desc.get(), feedCloudRead$PopStUserInfo.keyword.get());
    }

    protected void m0(FeedCloudMeta$StUser feedCloudMeta$StUser, Size size) {
        if (feedCloudMeta$StUser != null && this.f91810e != null) {
            String str = feedCloudMeta$StUser.icon.iconUrl.get();
            if (!TextUtils.isEmpty(str)) {
                Option obtain = Option.obtain();
                obtain.setTargetView(this.f91810e);
                obtain.setUrl(QCircleSkinHelper.getInstance().getUrl(str));
                obtain.setRequestWidth(this.f91812h.getWidth());
                obtain.setRequestHeight(this.f91812h.getHeight());
                QCircleFeedPicLoader.g().loadImage(obtain);
                this.f91810e.setTag(HostUIHelper.getInstance().getHostResourceId("id", "qfs_push_flipper_avatar_tag_id"), str);
                return;
            }
            if (!TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get())) {
                al.a(this.f91810e, feedCloudMeta$StUser.f398463id.get(), size);
            }
        }
    }
}
