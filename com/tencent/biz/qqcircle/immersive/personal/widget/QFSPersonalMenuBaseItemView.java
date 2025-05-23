package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSPersonalMenuInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* loaded from: classes4.dex */
public abstract class QFSPersonalMenuBaseItemView extends QCircleBaseWidgetView<QFSPersonalMenuInfo> {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89273d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89274e;

    public QFSPersonalMenuBaseItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f89273d = (ImageView) findViewById(R.id.f46781vi);
        this.f89274e = (TextView) findViewById(R.id.f46791vj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalMenuItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSPersonalMenuInfo qFSPersonalMenuInfo, int i3) {
        if (qFSPersonalMenuInfo == null) {
            return;
        }
        this.f89273d.setBackground(QCircleSkinHelper.getInstance().getDrawable(qFSPersonalMenuInfo.getIconResource()));
        this.f89274e.setText(qFSPersonalMenuInfo.getTitle());
        if (!TextUtils.isEmpty(qFSPersonalMenuInfo.getBubbleTipText())) {
            mc0.a.d(getContext(), qFSPersonalMenuInfo.getBubbleTipText()).setAnchor(this.f89274e).setPosition(3).setAlignment(0).addStatusCallback(qFSPersonalMenuInfo.getBubbleCallBack());
        }
    }
}
