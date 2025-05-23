package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoErrorStatusView extends QCircleStatusView {
    public TVideoErrorStatusView(@NonNull Context context) {
        this(context, null);
    }

    public void G0(int i3) {
        QUIEmptyState qUIEmptyState = this.f93161f;
        if (qUIEmptyState == null) {
            return;
        }
        qUIEmptyState.setGravity(1);
        this.f93161f.setPadding(0, i3, 0, 0);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleStatusView
    public void x0(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
        }
        z0(str, true, 5);
    }

    public TVideoErrorStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, true);
    }
}
