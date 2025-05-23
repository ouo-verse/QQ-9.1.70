package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSNegativeItemInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNegativeHeadItemView extends QCircleBaseWidgetView<QFSNegativeItemInfo> {

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f89190d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89191e;

    public QFSNegativeHeadItemView(@NonNull Context context) {
        super(context);
        this.f89190d = (LinearLayout) findViewById(R.id.f47521xi);
        this.f89191e = (TextView) findViewById(R.id.f47511xh);
    }

    private void l0(int i3) {
        if (i3 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = ViewUtils.dip2px(36.0f);
            this.f89190d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gjk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSNegativeHeadItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSNegativeItemInfo qFSNegativeItemInfo, int i3) {
        if (qFSNegativeItemInfo == null) {
            QLog.e("QFSNegativeHeadItemView", 1, "[bindData] headItemInfo should not be null");
        } else {
            this.f89191e.setText(qFSNegativeItemInfo.getTitle());
            l0(i3);
        }
    }
}
