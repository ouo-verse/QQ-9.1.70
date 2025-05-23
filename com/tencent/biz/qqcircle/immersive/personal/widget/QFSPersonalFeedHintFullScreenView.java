package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSPersonalFeedHintFullScreenView extends QFSPersonalFeedHintView {
    public QFSPersonalFeedHintFullScreenView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedHintView, com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g_x;
    }

    public QFSPersonalFeedHintFullScreenView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
