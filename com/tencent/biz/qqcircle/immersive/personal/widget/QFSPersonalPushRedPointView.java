package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.order.IOrderElement;

/* loaded from: classes4.dex */
public class QFSPersonalPushRedPointView extends ImageView implements IOrderElement {

    /* renamed from: d, reason: collision with root package name */
    private boolean f89323d;

    public QFSPersonalPushRedPointView(Context context) {
        this(context, null);
    }

    public void a(boolean z16) {
        this.f89323d = z16;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        if (getContext() == null) {
            return "";
        }
        return String.valueOf(getContext().hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "personal_type_red_point";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 100;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return this.f89323d;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        setVisibility(8);
    }

    public QFSPersonalPushRedPointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPersonalPushRedPointView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
