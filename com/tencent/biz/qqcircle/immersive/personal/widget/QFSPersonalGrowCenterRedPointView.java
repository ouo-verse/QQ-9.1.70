package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* loaded from: classes4.dex */
public class QFSPersonalGrowCenterRedPointView extends ImageView implements IOrderElement {

    /* renamed from: d, reason: collision with root package name */
    private boolean f89261d;

    public QFSPersonalGrowCenterRedPointView(Context context) {
        this(context, null);
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
        return 101;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return this.f89261d;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_remove_personal_red_dot_order", true)) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_remove_personal_red_dot_order", true)) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().removeElement(this);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        setVisibility(8);
    }

    public QFSPersonalGrowCenterRedPointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPersonalGrowCenterRedPointView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
    }
}
