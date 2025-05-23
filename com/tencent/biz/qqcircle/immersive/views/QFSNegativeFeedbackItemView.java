package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSNegativeItemInfo;
import com.tencent.biz.qqcircle.events.QFSNegativeSelectChangeEvent;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.utils.QCircleCommonUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNegativeFeedbackItemView extends QCircleBaseWidgetView<QFSNegativeItemInfo> {

    /* renamed from: i, reason: collision with root package name */
    private static final String f90400i = "com.tencent.biz.qqcircle.immersive.views.QFSNegativeFeedbackItemView";

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f90401d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f90402e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90403f;

    /* renamed from: h, reason: collision with root package name */
    private QFSNegativeItemInfo f90404h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSNegativeFeedbackItemView.this.n0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSNegativeFeedbackItemView(@NonNull Context context) {
        super(context);
        o0(this);
    }

    private void m0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f90403f.setVisibility(8);
            this.f90402e.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f90402e.setGravity(17);
            return;
        }
        this.f90403f.setVisibility(0);
        this.f90403f.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        boolean z16 = !this.f90404h.isSelected();
        this.f90404h.setSelected(z16);
        p0(z16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSNegativeSelectChangeEvent(Boolean.valueOf(z16), this.f90404h.getTitle()));
    }

    private void o0(View view) {
        this.f90401d = (LinearLayout) view.findViewById(R.id.f47551xl);
        this.f90402e = (TextView) view.findViewById(R.id.f47541xk);
        this.f90403f = (TextView) view.findViewById(R.id.f47531xj);
        this.f90401d.setOnClickListener(new a());
    }

    private void p0(boolean z16) {
        Drawable drawable;
        Drawable drawable2 = getContext().getResources().getDrawable(R.drawable.qui_common_bg_qui_common_fill_standard_extra_bg_corner_4);
        int color = getContext().getResources().getColor(R.color.qui_common_text_primary);
        int color2 = getContext().getResources().getColor(R.color.qui_common_text_secondary);
        if (z16) {
            if (QCircleCommonUtil.isInNightMode()) {
                drawable = getContext().getResources().getDrawable(R.drawable.kku);
            } else {
                drawable = getContext().getResources().getDrawable(R.drawable.kkt);
            }
            drawable2 = drawable;
            color = getContext().getResources().getColor(R.color.f157870cl3);
            color2 = getContext().getResources().getColor(R.color.cl5);
        }
        this.f90401d.setBackground(drawable2);
        this.f90402e.setTextColor(color);
        if (!TextUtils.isEmpty(this.f90403f.getText())) {
            this.f90403f.setTextColor(color2);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gjl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return f90400i;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSNegativeItemInfo qFSNegativeItemInfo, int i3) {
        if (qFSNegativeItemInfo == null) {
            return;
        }
        this.f90404h = qFSNegativeItemInfo;
        this.f90402e.setText(qFSNegativeItemInfo.getTitle());
        m0(qFSNegativeItemInfo.getSubTitle());
        p0(qFSNegativeItemInfo.isSelected());
    }
}
