package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleRankinglist$RankingItem;

/* loaded from: classes5.dex */
public class QCirclePolymerizationFuelListItemView extends QCircleBaseWidgetView implements View.OnClickListener {
    private QQCircleRankinglist$RankingItem C;
    private SquareImageView D;
    private QCirclePolymerizationBean E;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f93755d;

    /* renamed from: e, reason: collision with root package name */
    private SquareImageView f93756e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93757f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93758h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93759i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f93760m;

    public QCirclePolymerizationFuelListItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93755d = (RelativeLayout) findViewById(R.id.f75713zp);
        this.f93756e = (SquareImageView) findViewById(R.id.f85674pl);
        this.f93757f = (TextView) findViewById(R.id.f112296nj);
        this.f93758h = (TextView) findViewById(R.id.f108126c_);
        this.f93759i = (TextView) findViewById(R.id.f108116c9);
        this.f93760m = (ImageView) findViewById(R.id.dxi);
        this.D = (SquareImageView) findViewById(R.id.f165730xe4);
        this.f93755d.setOnClickListener(this);
    }

    private void k0() {
        if (this.f93755d == null) {
            return;
        }
        String str = this.C.user.f398463id.get();
        VideoReport.setElementId(this.f93755d, QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_RANKING_ITEM);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_UIN, str);
        VideoReport.setElementParams(this.f93755d, buildElementParams);
    }

    private void l0() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_TYPE, "clck");
        hashMap.put("dt_pgstp", QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE);
        hashMap.put("dt_ref_pgid", QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_UIN, this.C.get().user.f398463id.get());
        VideoReport.reportEvent(QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_RANKING_ITEM, this, hashMap);
    }

    private void m0(SquareImageView squareImageView, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        String str = feedCloudMeta$StUser.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str)) {
            Option obtain = Option.obtain();
            obtain.setTargetView(squareImageView);
            obtain.setUrl(str);
            n0(squareImageView, obtain);
            QCircleFeedPicLoader.g().loadImage(obtain);
            return;
        }
        squareImageView.setImageDrawable(HostFaceUtils.getFaceDrawable(1, 4, feedCloudMeta$StUser.f398463id.get()));
    }

    private void n0(@NonNull SquareImageView squareImageView, @NonNull Option option) {
        ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        option.setRequestWidth(layoutParams.width);
        option.setRequestHeight(layoutParams.height);
    }

    private void o0(QQCircleRankinglist$RankingItem qQCircleRankinglist$RankingItem) {
        if (this.D == null) {
            return;
        }
        if (qQCircleRankinglist$RankingItem.user.medal.has()) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(uq3.c.h4()).setTargetView(this.D));
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        if (!(obj instanceof QQCircleRankinglist$RankingItem)) {
            return;
        }
        QQCircleRankinglist$RankingItem qQCircleRankinglist$RankingItem = (QQCircleRankinglist$RankingItem) obj;
        this.C = qQCircleRankinglist$RankingItem;
        m0(this.f93756e, qQCircleRankinglist$RankingItem.user);
        this.f93757f.setText(this.C.user.nick.get());
        this.f93758h.setText(r.f(this.C.score.get()));
        String str = this.C.scoreName.get();
        if (!TextUtils.isEmpty(str)) {
            this.f93759i.setText(str);
        }
        o0(this.C);
        p0(i3);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(46).setSubActionType(4).setThrActionType(1).setExt6(String.valueOf(this.E.getPolymerizationName())).setExt7(this.C.user.nick.get()).setPageId(getPageId()).setfPageId(getParentPageId()));
        k0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168639g62;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleFuelListItemView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f75713zp && this.C != null) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(this.C.user.f398463id.get());
            qCircleInitBean.setFromReportBean(getReportBean());
            com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(46).setSubActionType(4).setThrActionType(2).setExt6(String.valueOf(this.E.getPolymerizationName())).setExt7(this.C.user.nick.get()).setPageId(getPageId()));
            l0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p0(int i3) {
        ImageView imageView = this.f93760m;
        if (imageView == null) {
            QLog.e("QCircleFuelListItemView", 1, "[updateRankIconByPosition] mIvRankIcon should not be null");
            return;
        }
        imageView.setVisibility(0);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f93760m.setVisibility(8);
                    return;
                } else {
                    this.f93760m.setImageResource(R.drawable.nty);
                    return;
                }
            }
            this.f93760m.setImageResource(R.drawable.ntx);
            return;
        }
        this.f93760m.setImageResource(R.drawable.ntw);
    }

    public void setInitBean(QCirclePolymerizationBean qCirclePolymerizationBean) {
        this.E = qCirclePolymerizationBean;
    }
}
