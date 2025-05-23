package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* loaded from: classes4.dex */
public class QFSPersonalJustSeeFeedItemView extends QCircleBaseWidgetView<com.tencent.biz.qqcircle.immersive.personal.bean.k> {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89270d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f89271e;

    /* renamed from: f, reason: collision with root package name */
    private String f89272f;

    public QFSPersonalJustSeeFeedItemView(@NonNull Context context) {
        super(context);
        p0(this);
    }

    private void n0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (!TextUtils.isEmpty(this.f89272f)) {
            if (TextUtils.equals(this.f89272f, kVar.a())) {
                QLog.d("FSPersonalFeedItemView", 4, "[initImage] -> url is same ! url = " + this.f89272f);
                return;
            }
            if (TextUtils.equals(QCircleFeedPicLoader.getUniKeyFromUrl(this.f89272f), QCircleFeedPicLoader.getUniKeyFromUrl(kVar.a()))) {
                QLog.d("FSPersonalFeedItemView", 4, "[initImage] -> getUniKeyFromUrl is same ! oldUrl = " + this.f89272f + " newUrl = " + kVar.a());
                return;
            }
            QLog.d("FSPersonalFeedItemView", 4, "[initImage] -> update image ! oldUrl = " + this.f89272f + " newUrl = " + kVar.a());
        }
        this.f89272f = kVar.a();
        this.f89271e.setImageDrawable(null);
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalJustSeeFeedItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSPersonalJustSeeFeedItemView.this.f89272f != null && QFSPersonalJustSeeFeedItemView.this.f89271e != null) {
                    QLog.d("FSPersonalFeedItemView", 4, "[initImage] -> getMeasuredHeight() = " + QFSPersonalJustSeeFeedItemView.this.getMeasuredHeight() + " getMeasuredWidth() = " + QFSPersonalJustSeeFeedItemView.this.getMeasuredWidth());
                    Option targetView = Option.obtain().setRequestHeight(QFSPersonalJustSeeFeedItemView.this.getMeasuredHeight()).setRequestWidth(QFSPersonalJustSeeFeedItemView.this.getMeasuredWidth()).setUrl(QFSPersonalJustSeeFeedItemView.this.f89272f).setTargetView(QFSPersonalJustSeeFeedItemView.this.f89271e);
                    targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
                    targetView.setLoadingDrawable(new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton)));
                    QCircleFeedPicLoader.g().loadImage(targetView);
                }
            }
        });
    }

    private void o0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        int i3;
        ImageView imageView = this.f89270d;
        if (kVar.q()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void p0(View view) {
        this.f89270d = (ImageView) view.findViewById(R.id.y9q);
        this.f89271e = (ImageView) view.findViewById(R.id.y2y);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gli;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        if (kVar != null && kVar.b() != null) {
            o0(kVar);
            n0(kVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        q0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) * 4) / 3, 1073741824));
    }

    private void q0() {
    }
}
