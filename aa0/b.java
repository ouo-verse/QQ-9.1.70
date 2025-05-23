package aa0;

import aa0.a;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$JumpInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.utils.cf;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b<T extends a> extends RecyclerView.ViewHolder implements View.OnClickListener {
    private QCircleReportBean E;
    protected int F;
    protected T G;

    public b(@NonNull View view) {
        super(view);
        view.setOnClickListener(this);
    }

    private int o() {
        QCircleReportBean qCircleReportBean = this.E;
        if (qCircleReportBean == null) {
            return 0;
        }
        return qCircleReportBean.getPageId();
    }

    private void p(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("QFSSearchItemBaseViewHolder", 1, "#jumpToH5: url is empty");
        } else {
            QCircleSchemeLauncher.f(this.itemView.getContext(), str);
        }
    }

    public void l(T t16, int i3) {
        this.G = t16;
        this.F = i3;
    }

    protected void m(CircleSearchExhibition$JumpInfo circleSearchExhibition$JumpInfo) {
        if (!circleSearchExhibition$JumpInfo.type.has()) {
            QLog.w("QFSSearchItemBaseViewHolder", 1, "#doJump: type in empty");
            return;
        }
        QLog.d("QFSSearchItemBaseViewHolder", 1, "[doJump] type: " + circleSearchExhibition$JumpInfo.type.get() + " query: " + circleSearchExhibition$JumpInfo.query.get() + " url: " + circleSearchExhibition$JumpInfo.url.get());
        int i3 = circleSearchExhibition$JumpInfo.type.get();
        if (i3 != 1) {
            if (i3 == 2) {
                p(circleSearchExhibition$JumpInfo.url.get());
                return;
            }
            return;
        }
        q(circleSearchExhibition$JumpInfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.itemView) {
            m(this.G.a());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void q(CircleSearchExhibition$JumpInfo circleSearchExhibition$JumpInfo) {
        PartManager partManager;
        String str = circleSearchExhibition$JumpInfo.query.get();
        if (TextUtils.isEmpty(str)) {
            QLog.w("QFSSearchItemBaseViewHolder", 1, "#jumpToSearchResultPage: queryText is empty");
            return;
        }
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        qFSSearchInfo.k(str);
        if (circleSearchExhibition$JumpInfo.query_source.has()) {
            qFSSearchInfo.j(circleSearchExhibition$JumpInfo.query_source.get());
        }
        s(qFSSearchInfo);
        QCircleBaseFragment qCircleBaseFragment = QCirclePluginUtil.getQCircleBaseFragment(this.itemView.getContext());
        if (qCircleBaseFragment != null && (partManager = qCircleBaseFragment.getPartManager()) != null) {
            partManager.broadcastMessage("qfs_search_words_auto_complete", qFSSearchInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(int i3, String str) {
        cf.a(this.itemView.getContext(), i3, this.E, o(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(QFSSearchInfo qFSSearchInfo) {
    }
}
