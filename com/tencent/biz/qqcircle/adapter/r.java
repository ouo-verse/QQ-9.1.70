package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaBottomWidget;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSCommentAreaBottomWidget C;
    private QFSCommentInfo D;
    private boolean E;

    public r(Bundle bundle) {
        super(bundle);
        boolean z16;
        if (bundle != null) {
            if (bundle.getInt("orientation_type_flag", -1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.E = z16;
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = new QFSCommentAreaBottomWidget(viewGroup.getContext(), getReportBean());
        this.C = qFSCommentAreaBottomWidget;
        qFSCommentAreaBottomWidget.setIsFullScreen(this.E);
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSCommentAreaTabBlock";
    }

    public void i0(int i3) {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            QLog.e(getLogTag(), 1, "[adjustBottomPadding] mBottomWidget == null");
        } else {
            qFSCommentAreaBottomWidget.z0(i3);
        }
    }

    public void j0(int i3) {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            QLog.e(getLogTag(), 1, "[adjustBottomWidgetHeight] mBottomWidget == null");
        } else {
            qFSCommentAreaBottomWidget.A0(i3);
        }
    }

    public void k0(String str) {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            return;
        }
        qFSCommentAreaBottomWidget.D0(str);
    }

    public int l0() {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            QLog.e(getLogTag(), 1, "[getBottomWidgetHeight] mBottomWidget == null");
            return 0;
        }
        return qFSCommentAreaBottomWidget.N0();
    }

    public BlockContainer m0() {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            return null;
        }
        return qFSCommentAreaBottomWidget.E0();
    }

    public int n0() {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            return 0;
        }
        return qFSCommentAreaBottomWidget.H0();
    }

    public boolean o0() {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            return true;
        }
        return qFSCommentAreaBottomWidget.T0();
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            QLog.e(getLogTag(), 1, "[onBindViewHolder] i = " + i3);
            return;
        }
        qFSCommentAreaBottomWidget.j1(this.D);
    }

    public boolean p0() {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            return false;
        }
        return qFSCommentAreaBottomWidget.C0();
    }

    public void q0(int i3, boolean z16) {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            return;
        }
        qFSCommentAreaBottomWidget.d1(i3, z16);
    }

    public void r0(int i3) {
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget == null) {
            return;
        }
        qFSCommentAreaBottomWidget.i1(i3);
    }

    public void s0(QFSCommentInfo qFSCommentInfo) {
        this.D = qFSCommentInfo;
        QFSCommentAreaBottomWidget qFSCommentAreaBottomWidget = this.C;
        if (qFSCommentAreaBottomWidget != null) {
            qFSCommentAreaBottomWidget.j1(qFSCommentInfo);
        } else {
            QLog.e(getLogTag(), 1, "[updateCommentInfo] mBottomWidget == null");
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
