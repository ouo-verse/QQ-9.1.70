package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;

/* loaded from: classes4.dex */
public class QCircleBaseBlockPart extends BlockPart implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    protected QCircleReportBean mReportBean;

    public QCircleBaseBlockPart() {
    }

    private void initializeScrollListener() {
        NestScrollRecyclerView recyclerView;
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || (recyclerView = blockContainer.getRecyclerView()) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart.1
            private void handleScrollStateChanged(int i3) {
                QCircleAspectScrollProcessor.getInstance().onScrollState(QCircleBaseBlockPart.this, i3);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView2, int i3) {
                super.onScrollStateChanged(recyclerView2, i3);
                handleScrollStateChanged(i3);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView2, int i3, int i16) {
                super.onScrolled(recyclerView2, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getIocInterface(Class<T> cls) {
        return (T) PartIOCKt.getIocInterface(this, cls);
    }

    protected int getPageId() {
        return QCircleReportBean.getPageId(getTAG(), this.mReportBean);
    }

    protected int getParentPageId() {
        return QCircleReportBean.getParentPageId(getTAG(), this.mReportBean);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart
    public IStatusViewProvider getStatusViewProvider() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer != null) {
            if (blockContainer.getStatusInterface() != null) {
                return this.mBlockContainer.getStatusInterface();
            }
            QCircleStatusView qCircleStatusView = new QCircleStatusView(getContext());
            this.mBlockContainer.setStatusViewInterface(qCircleStatusView);
            return qCircleStatusView;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart
    protected BlockContainer initBlockContainer(Context context) {
        return new QCircleBlockContainer(context);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        initializeScrollListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(Object obj, Class<?> cls) {
        PartIOCKt.registerIoc(this, obj, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterIoc(Class<?> cls) {
        PartIOCKt.unregisterIoc(this, cls);
    }

    public QCircleBaseBlockPart(int i3) {
        super(i3);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart
    public QCircleBlockContainer getBlockContainer() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QCircleBlockContainer) {
            return (QCircleBlockContainer) blockContainer;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public QCircleBaseFragment getHostFragment() {
        Fragment hostFragment = super.getHostFragment();
        if (hostFragment instanceof QCircleBaseFragment) {
            return (QCircleBaseFragment) hostFragment;
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        return QCircleReportBean.getReportBean(getTAG(), this.mReportBean);
    }

    protected void registerIoc(View view, Object obj, Class<?> cls) {
        PartIOCKt.registerIoc(this, view, obj, cls);
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = QCircleReportBean.setReportBean(getTAG(), qCircleReportBean);
    }

    public QCircleBaseBlockPart(int i3, List<MultiViewBlock> list) {
        super(i3, list);
    }

    public QCircleBaseBlockPart(int i3, List<MultiViewBlock> list, int i16, int i17) {
        super(i3, list, i16, i17);
    }
}
