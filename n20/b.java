package n20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends BaseListViewAdapter<FeedCloudMeta$StComment> {
    private View.OnClickListener C;
    private QFSCommentInputWindowConfig D;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f418025m;

    private void j0(boolean z16, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.D;
        if (qFSCommentInputWindowConfig != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFeedCommentInfo.mFeed;
            FeedCloudMeta$StComment feedCloudMeta$StComment2 = qFSFeedCommentInfo.mComment;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_AI_REC_CMT_BAR);
            String str6 = "";
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            buildElementParams.put("xsj_feed_id", str);
            if (feedCloudMeta$StComment == null) {
                str2 = "";
            } else {
                str2 = feedCloudMeta$StComment.f398447id.get();
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_COMMENT_ID, str2);
            if (feedCloudMeta$StComment2 == null) {
                str3 = "";
            } else {
                str3 = feedCloudMeta$StComment2.f398447id.get();
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str3);
            if (feedCloudMeta$StComment2 == null) {
                str4 = "cmt";
            } else {
                str4 = "reply";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str4);
            QCircleReportBean qCircleReportBean = this.D.reportBean;
            if (qCircleReportBean != null) {
                str6 = qCircleReportBean.getDtPageId();
            }
            buildElementParams.put("xsj_custom_pgid", str6);
            if (z16) {
                str5 = "ev_xsj_abnormal_clck";
            } else {
                str5 = "ev_xsj_abnormal_imp";
            }
            VideoReport.reportEvent(str5, buildElementParams);
        }
    }

    private void k0(boolean z16) {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        String str;
        String str2;
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.D;
        if (qFSCommentInputWindowConfig != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFeedCommentInfo.mFeed;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_AI_REC_CMT_SWITCH);
            String str3 = "";
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            buildElementParams.put("xsj_feed_id", str);
            QCircleReportBean qCircleReportBean = this.D.reportBean;
            if (qCircleReportBean != null) {
                str3 = qCircleReportBean.getDtPageId();
            }
            buildElementParams.put("xsj_custom_pgid", str3);
            if (z16) {
                str2 = "ev_xsj_abnormal_clck";
            } else {
                str2 = "ev_xsj_abnormal_imp";
            }
            VideoReport.reportEvent(str2, buildElementParams);
        }
    }

    private void l0(@NonNull View view) {
        if (view.getTag() != null && (view.getTag() instanceof FeedCloudMeta$StComment) && this.f418025m != null) {
            j0(true, (FeedCloudMeta$StComment) view.getTag());
            this.f418025m.onClick(view);
        }
    }

    private void m0(@NonNull View view) {
        if (this.f418025m == null) {
            return;
        }
        k0(true);
        this.f418025m.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f33440wg) {
            m0(view);
        } else if (view.getId() == R.id.f33450wh) {
            l0(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 >= getNUM_BACKGOURND_ICON() - 1) {
            return 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public BaseListViewAdapter<FeedCloudMeta$StComment>.BaseVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        View inflate;
        if (i3 == 0) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g7p, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g7o, viewGroup, false);
        }
        inflate.setTag(Integer.valueOf(i3));
        return new BaseListViewAdapter.BaseVH(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        String str;
        if ((viewHolder.itemView.getTag() instanceof Integer) && ((Integer) viewHolder.itemView.getTag()).intValue() == 0) {
            TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.f33450wh);
            FeedCloudMeta$StComment item = getItem(i3);
            if (item != null) {
                str = item.content.get();
            } else {
                str = "";
            }
            textView.setText(str);
            textView.setTag(item);
            textView.setOnClickListener(this.C);
            j0(false, item);
            return;
        }
        if ((viewHolder.itemView.getTag() instanceof Integer) && ((Integer) viewHolder.itemView.getTag()).intValue() == 1) {
            ((LinearLayout) viewHolder.itemView.findViewById(R.id.f33440wg)).setOnClickListener(this.C);
            k0(false);
        }
    }

    public void p0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        this.D = qFSCommentInputWindowConfig;
    }

    public void q0(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            return;
        }
        this.f418025m = onClickListener;
        this.C = new View.OnClickListener() { // from class: n20.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.n0(view);
            }
        };
    }
}
