package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSMixFeedBaseWidgetView<T> extends QCircleBaseWidgetView<T> {

    /* renamed from: d, reason: collision with root package name */
    private j20.a f90842d;

    public QFSMixFeedBaseWidgetView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public BaseWidgetView.IInteractor getInteractor() {
        if (this.f90842d == null) {
            this.f90842d = (j20.a) getIocInterface(j20.a.class);
        }
        return this.f90842d;
    }

    public QFSMixFeedBaseWidgetView(@NonNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSMixFeedBaseWidgetView(@NonNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
