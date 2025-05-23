package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSCheckBoxStatus;
import com.tencent.biz.qqcircle.immersive.personal.bean.e;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSPersonalBaseFeedItemView<T extends com.tencent.biz.qqcircle.immersive.personal.bean.e> extends QCircleBaseWidgetView<T> {

    /* renamed from: d, reason: collision with root package name */
    public ImageView f89200d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f89201e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f89202f;

    /* renamed from: h, reason: collision with root package name */
    private String f89203h;

    /* renamed from: i, reason: collision with root package name */
    private Option f89204i;

    /* renamed from: m, reason: collision with root package name */
    public QUICheckBox f89205m;

    public QFSPersonalBaseFeedItemView(@NonNull Context context) {
        super(context);
        this.f89204i = null;
        u0(this);
    }

    private Drawable o0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        cq cqVar = cq.f92752a;
        if (cqVar.s(feedCloudMeta$StFeed)) {
            if (!QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed) || (i3 = cqVar.i(feedCloudMeta$StFeed)) == 1) {
                return null;
            }
            return cqVar.m(getContext(), i3);
        }
        if (feedCloudMeta$StFeed.right.ugcRight.rightFlag.get() != 2) {
            return null;
        }
        return QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.osp);
    }

    private void p0(T t16) {
        QFSCheckBoxStatus qFSCheckBoxStatus = t16.f88465d;
        if (qFSCheckBoxStatus != null && qFSCheckBoxStatus.getNeedShow()) {
            this.f89205m.setVisibility(0);
            this.f89205m.setClickable(false);
            this.f89205m.setEnabled(qFSCheckBoxStatus.getEnabled());
            this.f89205m.setChecked(qFSCheckBoxStatus.getSelected());
            int index = qFSCheckBoxStatus.getIndex();
            if (index > 0) {
                this.f89205m.setText(String.valueOf(index));
                return;
            } else {
                this.f89205m.setText("");
                return;
            }
        }
        this.f89205m.setVisibility(8);
    }

    private void q0(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        if (this.f89200d == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f89203h)) {
            if (TextUtils.equals(this.f89203h, eVar.a())) {
                QLog.d("QFSPersonalFeedBaseItemView", 4, "[initImage] -> url is same ! url = " + this.f89203h);
                return;
            }
            if (TextUtils.equals(QCircleFeedPicLoader.getUniKeyFromUrl(this.f89203h), QCircleFeedPicLoader.getUniKeyFromUrl(eVar.a()))) {
                QLog.d("QFSPersonalFeedBaseItemView", 4, "[initImage] -> getUniKeyFromUrl is same ! oldUrl = " + this.f89203h + " newUrl = " + eVar.a());
                return;
            }
            QLog.d("QFSPersonalFeedBaseItemView", 4, "[initImage] -> update image ! oldUrl = " + this.f89203h + " newUrl = " + eVar.a());
        }
        this.f89203h = eVar.a();
        this.f89200d.setImageDrawable(null);
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSPersonalBaseFeedItemView.this.f89203h != null && QFSPersonalBaseFeedItemView.this.f89200d != null) {
                    QLog.d("QFSPersonalFeedBaseItemView", 4, "[initImage] -> getMeasuredHeight() = " + QFSPersonalBaseFeedItemView.this.getMeasuredHeight() + " getMeasuredWidth() = " + QFSPersonalBaseFeedItemView.this.getMeasuredWidth());
                    QFSPersonalBaseFeedItemView.this.f89204i = Option.obtain().setUrl(QFSPersonalBaseFeedItemView.this.f89203h).setRequestWidth(QFSPersonalBaseFeedItemView.this.getMeasuredWidth()).setRequestHeight(QFSPersonalBaseFeedItemView.this.getMeasuredHeight()).setTargetView(QFSPersonalBaseFeedItemView.this.f89200d);
                    QFSPersonalBaseFeedItemView.this.f89204i.setSupportRecycler(true);
                    QFSPersonalBaseFeedItemView.this.f89204i.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
                    QFSPersonalBaseFeedItemView.this.f89204i.setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default));
                    QCircleFeedPicLoader.g().loadImage(QFSPersonalBaseFeedItemView.this.f89204i, null);
                }
            }
        });
    }

    private void v0() {
        if (!q50.b.e().h() || this.f89204i == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalFeedBaseItemView", 2, "[releaseLowDevicePicture] load image url cache key: " + this.f89204i.getCacheKey());
        }
        q50.b.e().b(this.f89204i);
    }

    private void w0() {
        if (!q50.b.e().h() || this.f89204i == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalFeedBaseItemView", 2, "[updateLowDevicePicture] load image url cache key: " + this.f89204i.getCacheKey());
        }
        QCircleFeedPicLoader.g().loadImage(this.f89204i);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gl6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalFeedBaseItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(T t16, int i3) {
        if (t16 != null && t16.c() != null) {
            q0(t16);
            r0(t16);
            s0(t16);
            p0(t16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) * 4) / 3, 1073741824));
    }

    protected void r0(T t16) {
        int i3;
        ImageView imageView = this.f89201e;
        if (t16.e() == 2) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    protected void s0(T t16) {
        if (t16 == null) {
            return;
        }
        Drawable o06 = o0(t16.b());
        if (o06 == null) {
            this.f89202f.setVisibility(8);
            if (this.f89201e.getVisibility() == 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f89201e.getLayoutParams();
                layoutParams.rightMargin = cx.a(8.0f);
                this.f89201e.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f89202f.setVisibility(8);
        this.f89202f.setImageDrawable(o06);
        if (this.f89201e.getVisibility() == 0) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f89201e.getLayoutParams();
            layoutParams2.rightMargin = cx.a(28.0f);
            this.f89201e.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0(View view) {
        this.f89200d = (ImageView) view.findViewById(R.id.f44211ok);
        this.f89201e = (ImageView) view.findViewById(R.id.f44501pc);
        this.f89202f = (ImageView) view.findViewById(R.id.f241708e);
        this.f89205m = (QUICheckBox) view.findViewById(R.id.f3484109);
    }
}
