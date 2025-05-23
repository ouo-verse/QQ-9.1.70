package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.part.BaseWidgetIOCKt;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QCircleBaseWidgetView<T> extends BaseWidgetView<T> implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    private static final String TAG = "QCircleBaseWidgetView";
    private QCircleReportBean mCacheReportBean;
    protected QCircleReportBean mReportBean;

    public QCircleBaseWidgetView(@NonNull Context context) {
        super(context);
    }

    private QCircleReportBean compatQFSReportDataBean() {
        Object viewTagData = super.getViewTagData();
        if (viewTagData instanceof QCircleReportBean) {
            QCircleReportBean qCircleReportBean = (QCircleReportBean) viewTagData;
            this.mCacheReportBean = qCircleReportBean;
            return qCircleReportBean;
        }
        return this.mCacheReportBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <E> E getIocInterface(Class<E> cls) {
        return (E) BaseWidgetIOCKt.getIocInterface(this, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLogTag() {
        return getClass().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPageId() {
        if (this.mReportBean == null) {
            this.mReportBean = getReportBean();
        }
        return QCircleReportBean.getPageId(getLogTag(), this.mReportBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getParentPageId() {
        return QCircleReportBean.getParentPageId(getLogTag(), this.mReportBean);
    }

    public QCircleBaseFragment getQCircleBaseFragment() {
        return QCirclePluginUtil.getQCircleBaseFragment(getContext());
    }

    public QCircleExtraTypeInfo getQCircleExtraTypeInfo() {
        if (getExtraTypeInfo() instanceof QCircleExtraTypeInfo) {
            return (QCircleExtraTypeInfo) getExtraTypeInfo();
        }
        return null;
    }

    public <VM extends BaseViewModel> VM getViewModel(Class<VM> cls) {
        if (getQCircleBaseFragment() != null) {
            return (VM) getQCircleBaseFragment().getViewModel(cls);
        }
        return null;
    }

    protected void registerIoc(Object obj, Class<?> cls) {
        registerIoc(this, obj, cls);
    }

    public void setCacheReportBean(QCircleReportBean qCircleReportBean) {
        if (qCircleReportBean == null) {
            return;
        }
        this.mCacheReportBean = qCircleReportBean;
    }

    protected void unregisterIoc(Class<?> cls) {
        BaseWidgetIOCKt.unregisterIoc(this, cls);
    }

    public QCircleBaseWidgetView(@NonNull Context context, int i3) {
        super(context, Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean compatQFSReportDataBean = compatQFSReportDataBean();
        if (compatQFSReportDataBean != null) {
            this.mReportBean = compatQFSReportDataBean;
            return compatQFSReportDataBean;
        }
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
    }

    protected void registerIoc(View view, Object obj, Class<?> cls) {
        BaseWidgetIOCKt.registerIoc(this, view, obj, cls);
    }

    @Override // 
    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }

    public QCircleBaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public <VM extends BaseViewModel> VM getViewModel(QCircleBaseFragment qCircleBaseFragment, Class<VM> cls) {
        if (qCircleBaseFragment != null) {
            return (VM) qCircleBaseFragment.getViewModel(cls);
        }
        return null;
    }

    public QCircleBaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
