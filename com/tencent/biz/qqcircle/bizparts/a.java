package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.richframework.part.BaseListAdapterIOCKt;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a<E> extends MultiViewBlock<E> implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    private static final String TAG = "QCircleBaseMultiViewBlock";
    protected boolean isOnResume;
    protected QCircleReportBean mReportBean;

    public a(Bundle bundle) {
        super(bundle);
        this.isOnResume = true;
    }

    private QCircleReportBean compatQFSReportDataBean() {
        Object viewTagData = getViewTagData();
        if (!(viewTagData instanceof QCircleReportBean)) {
            return null;
        }
        return (QCircleReportBean) viewTagData;
    }

    private Object getViewTagData() {
        if (getParentRecyclerView() == null) {
            return null;
        }
        return ab0.b.a(TagData.TAG_DATA_ID, this.mRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getIocInterface(Class<T> cls) {
        return (T) BaseListAdapterIOCKt.getIocInterface(this, cls);
    }

    protected abstract String getLogTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPageId() {
        return QCircleReportBean.getPageId(TAG, this.mReportBean);
    }

    protected int getParentPageId() {
        return QCircleReportBean.getParentPageId(TAG, this.mReportBean);
    }

    public QCircleExtraTypeInfo getQCircleExtraTypeInfo() {
        if (getExtraTypeInfo() instanceof QCircleExtraTypeInfo) {
            return (QCircleExtraTypeInfo) getExtraTypeInfo();
        }
        return null;
    }

    @NonNull
    public abstract RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder onCreateItemViewHolder = onCreateItemViewHolder(viewGroup, i3);
        if (onCreateItemViewHolder != null) {
            View view = onCreateItemViewHolder.itemView;
            if (view instanceof BaseWidgetView) {
                ((BaseWidgetView) view).setParentView(viewGroup);
            }
        }
        return onCreateItemViewHolder;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.isOnResume = false;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.isOnResume = true;
    }

    protected void registerIoc(Object obj, Class<?> cls) {
        registerIoc(getRecyclerView(), obj, cls);
    }

    protected void unregisterIoc(Class<?> cls) {
        BaseListAdapterIOCKt.unregisterIoc(this, cls);
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
        BaseListAdapterIOCKt.registerIoc(this, view, obj, cls);
    }

    @Override // 
    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }
}
