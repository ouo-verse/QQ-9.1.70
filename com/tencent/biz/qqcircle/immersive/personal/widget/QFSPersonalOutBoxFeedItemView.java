package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* loaded from: classes4.dex */
public class QFSPersonalOutBoxFeedItemView extends QFSPersonalOutBoxFeedItemBaseView {

    /* renamed from: i, reason: collision with root package name */
    public ImageView f89313i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f89314m;

    public QFSPersonalOutBoxFeedItemView(@NonNull Context context) {
        super(context);
        w0(this);
    }

    private void u0() {
        TextView textView = this.f89314m;
        if (textView == null) {
            return;
        }
        textView.setText(getResources().getString(R.string.f183543jg, n0()));
    }

    private void v0() {
        if (this.f89313i == null) {
            return;
        }
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemView.1
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = QFSPersonalOutBoxFeedItemView.this.getMeasuredWidth();
                int measuredHeight = QFSPersonalOutBoxFeedItemView.this.getMeasuredHeight();
                String a16 = QFSPersonalOutBoxFeedItemView.this.f89294d.a();
                QLog.d("QFSPersonalOutBoxFeedItemView", 4, "bindCover, w: " + measuredWidth + ", h: " + measuredHeight + ", coverUrl: " + a16);
                Option requestHeight = Option.obtain().setUrl(a16).setTargetView(QFSPersonalOutBoxFeedItemView.this.f89313i).setRequestWidth(measuredWidth).setRequestHeight(measuredHeight);
                requestHeight.setLoadingDrawable(new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton)));
                QCircleFeedPicLoader.g().loadImage(requestHeight);
            }
        });
    }

    private void w0(View view) {
        this.f89313i = (ImageView) view.findViewById(R.id.y2g);
        this.f89314m = (TextView) view.findViewById(R.id.f112476o1);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168620g31;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalOutBoxFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemBaseView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0 */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        super.bindData(kVar, i3);
        if (this.f89294d == null) {
            return;
        }
        v0();
        u0();
    }
}
