package com.qzone.reborn.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseWidgetIOCKt;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import cooperation.qzone.util.ProcessUtils;
import gf.u;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneBaseWidgetView<T> extends BaseWidgetView<T> {

    /* renamed from: d, reason: collision with root package name */
    private gf.k f59607d;

    public QZoneBaseWidgetView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public Activity getHostActivity() {
        if (super.getHostActivity() == null) {
            RFWLog.fatal("BaseWidgetView", 1, new RuntimeException("you must call setHostActivity first"));
            return ProcessUtils.getTopActivity();
        }
        return super.getHostActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <E> E getIocInterface(Class<E> cls) {
        return (E) BaseWidgetIOCKt.getIocInterface(this, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return jm.b.f410600a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initLayout(Context context) {
        jo.h hVar = jo.h.f410717a;
        hVar.g("widget_view_inflate").f(this);
        hVar.b(getClass().getSimpleName() + "_initLayout");
        super.initLayout(context);
        hVar.d();
        hVar.g("widget_view_inflate").a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public gf.k k0() {
        if (this.f59607d == null) {
            this.f59607d = (gf.k) getIocInterface(gf.k.class);
        }
        if (this.f59607d == null && !AppSetting.isDebugVersion()) {
            try {
                return (gf.k) u.class.newInstance();
            } catch (Exception e16) {
                QLog.e(getClass().getName(), 1, "getPageTypeIoc  e = " + e16.getMessage());
                return null;
            }
        }
        return this.f59607d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePartFragment l0() {
        if (getContext() instanceof QZoneBaseActivity) {
            return ((QZoneBaseActivity) getContext()).getQZoneBaseFragment();
        }
        try {
            Fragment findFragment = FragmentManager.findFragment(this.mParentView);
            if (findFragment instanceof BasePartFragment) {
                return (BasePartFragment) findFragment;
            }
            return null;
        } catch (Throwable th5) {
            RFWLog.fatal("BaseWidgetView", RFWLog.USR, th5);
            return null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        jo.h hVar = jo.h.f410717a;
        hVar.g("item_view_layout").f(this);
        super.onLayout(z16, i3, i16, i17, i18);
        hVar.g("item_view_layout").a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        jo.h hVar = jo.h.f410717a;
        hVar.g("item_view_measure").f(this);
        super.onMeasure(i3, i16);
        hVar.g("item_view_measure").a(this);
    }

    public <VM extends ViewModel> VM p(Class<VM> cls) {
        if (l0() != null) {
            return (VM) l0().getViewModel(cls);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(Object obj, Class<?> cls) {
        registerIoc(this, obj, cls);
    }

    public QZoneBaseWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    protected void registerIoc(View view, Object obj, Class<?> cls) {
        BaseWidgetIOCKt.registerIoc(this, view, obj, cls);
    }

    public QZoneBaseWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
