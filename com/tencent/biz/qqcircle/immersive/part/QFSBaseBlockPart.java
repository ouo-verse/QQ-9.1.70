package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSBaseBlockPart extends BlockPart {
    public QFSBaseBlockPart() {
    }

    private void initializeScrollListener() {
        NestScrollRecyclerView recyclerView;
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || (recyclerView = blockContainer.getRecyclerView()) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart.1
            private void handleScrollStateChanged(int i3) {
                QCircleAspectScrollProcessor.getInstance().onScrollState(QFSBaseBlockPart.this, i3);
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

    public String getFromPageId() {
        return String.valueOf(getReportBean().getFromPageId());
    }

    public String getPageId() {
        return String.valueOf(getReportBean().getPageId());
    }

    public QCircleReportBean getReportBean() {
        Object viewTagData = super.getViewTagData();
        if (!(viewTagData instanceof QCircleReportBean)) {
            if (!RFWApplication.isDebug()) {
                QLog.e(BlockPart.TAG, 1, "getReportBean but QCircleReportBean is null");
                return new QCircleReportBean();
            }
            QLog.e(BlockPart.TAG, 1, "getReportBean but QCircleReportBean is null , debug");
            throw new RuntimeException("getReportBean but QCircleReportBean is null");
        }
        return (QCircleReportBean) viewTagData;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        initializeScrollListener();
    }

    public QFSBaseBlockPart(int i3) {
        super(i3);
    }

    public QFSBaseBlockPart(int i3, List<MultiViewBlock> list) {
        super(i3, list);
    }

    public QFSBaseBlockPart(int i3, List<MultiViewBlock> list, int i16, int i17) {
        super(i3, list, i16, i17);
    }
}
