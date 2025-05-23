package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRecentlyWatchTopTipsWidget extends QCircleBaseWidgetView<String> {

    /* renamed from: d, reason: collision with root package name */
    private final TextView f89359d;

    public QFSRecentlyWatchTopTipsWidget(@NonNull Context context) {
        super(context);
        this.f89359d = (TextView) findViewById(R.id.f56662l8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gmz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
        } else {
            this.f89359d.setText(str);
        }
    }
}
