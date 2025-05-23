package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes4.dex */
public abstract class QFSPersonalBaseNestScrollFragment extends QFSBaseFragment {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            Activity hostActivity;
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && (hostActivity = QFSPersonalBaseNestScrollFragment.this.getHostActivity()) != null && hostActivity.getParent() != null) {
                QUIImmersiveHelper.s(hostActivity.getParent(), true, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (QFSPersonalBaseNestScrollFragment.this.vh(recyclerView)) {
                QLog.i(QFSPersonalBaseNestScrollFragment.this.getTAG(), 1, "initNestScrollRecyclerView isSlideToBottom = true");
                recyclerView.stopScroll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements NestScrollRecyclerView.NestScrollDelegate {
        b() {
        }

        @Override // com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.NestScrollDelegate
        public float[] getChildOffsetXY() {
            return new float[2];
        }

        @Override // com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.NestScrollDelegate
        public boolean isNestViewNotReachTop(RecyclerView recyclerView) {
            return QFSPersonalBaseNestScrollFragment.this.uh(recyclerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uh(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect)) {
            QLog.d(getTAG(), 2, "[isObscured] true: getLocalVisibleRect return: false");
            return true;
        }
        if (rect.top < 0) {
            QLog.d(getTAG(), 2, "[isObscured] true: displayRect.top < 0, view height=", Integer.valueOf(view.getHeight()), " ,displayRect=", rect);
            return true;
        }
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        if (Math.abs(Math.abs(rect2.top - rect2.bottom) - Math.abs(rect.top - rect.bottom)) > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "pg_xsj_profile_page";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @CallSuper
    public void onViewCreatedAfterPartInit(@NonNull View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        th();
    }

    protected abstract NestScrollRecyclerView sh();

    protected void th() {
        NestScrollRecyclerView sh5 = sh();
        if (sh5 == null) {
            QLog.w(getTAG(), 1, "initNestScrollRecyclerView nestScrollRecyclerView = null");
        } else {
            sh5.addOnScrollListener(new a());
            sh5.setNestScrollDelegate(new b());
        }
    }

    protected boolean vh(RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() < recyclerView.computeVerticalScrollRange()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
