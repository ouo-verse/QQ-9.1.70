package com.tencent.biz.qqcircle.immersive.views.search.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.part.BaseViewModel;
import p90.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSSearchBaseWidgetView<T> extends QCircleBaseWidgetView<T> {

    /* renamed from: d, reason: collision with root package name */
    private Fragment f91294d;

    public QFSSearchBaseWidgetView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return b.a().b();
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public QCircleBaseFragment getQCircleBaseFragment() {
        Fragment fragment = this.f91294d;
        if (fragment instanceof QCircleBaseFragment) {
            return (QCircleBaseFragment) fragment;
        }
        return super.getQCircleBaseFragment();
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public <VM extends BaseViewModel> VM getViewModel(Class<VM> cls) {
        VM vm5 = (VM) super.getViewModel(cls);
        if (vm5 == null) {
            Object context = getContext();
            if ((context instanceof Activity) && (context instanceof ViewModelStoreOwner)) {
                return (VM) new ViewModelProvider((ViewModelStoreOwner) context, ViewModelProvider.AndroidViewModelFactory.getInstance(((Activity) context).getApplication())).get(cls.getName(), cls);
            }
        }
        return vm5;
    }

    public void setFragment(Fragment fragment) {
        this.f91294d = fragment;
    }

    public QFSSearchBaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchBaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
