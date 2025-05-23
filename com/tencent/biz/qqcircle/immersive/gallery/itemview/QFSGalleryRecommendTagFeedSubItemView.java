package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryRecommendTagFeedSubItemView;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGalleryRecommendTagFeedSubItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> {
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private View f86443d;

    /* renamed from: e, reason: collision with root package name */
    private SquareImageView f86444e;

    /* renamed from: f, reason: collision with root package name */
    private SquareImageView f86445f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f86446h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f86447i;

    /* renamed from: m, reason: collision with root package name */
    private String f86448m;

    public QFSGalleryRecommendTagFeedSubItemView(@NonNull Context context) {
        super(context);
    }

    private String m0(String str) {
        return "#" + str;
    }

    private QCirclePolymerizationBean n0() {
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(this.f86448m);
        feedCloudMeta$StTagInfo.tagId.set(this.C);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setFromReportBean(getReportBean().m466clone());
        qCirclePolymerizationBean.setPolymerizationType(7);
        qCirclePolymerizationBean.setIsFromGalleryPage(true);
        return qCirclePolymerizationBean;
    }

    private void o0() {
        c.j0(getContext(), n0());
    }

    private void p0(View view) {
        if (view == null) {
            QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "rootView is null");
            return;
        }
        View findViewById = view.findViewById(R.id.f43241ly);
        this.f86443d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: s40.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSGalleryRecommendTagFeedSubItemView.this.q0(view2);
            }
        });
        this.f86445f = (SquareImageView) view.findViewById(R.id.f43091lj);
        this.f86444e = (SquareImageView) view.findViewById(R.id.f43231lx);
        this.f86446h = (TextView) view.findViewById(R.id.f43281m2);
        this.f86447i = (TextView) view.findViewById(R.id.f43251lz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        o0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void r0(SquareImageView squareImageView, String str, int i3, int i16) {
        if (squareImageView == null) {
            return;
        }
        squareImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(squareImageView).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setFailedDrawableId(R.drawable.ojc));
    }

    private void s0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        VideoReport.setElementId(this.f86443d, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC);
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "item info is null");
            return;
        }
        String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), WinkDaTongReportConstant.ElementParamKey.ADID);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_tianshu_task_id", valueFromListEntry);
        buildElementParams.put("xsj_topic_id", qQCircleDitto$StItemInfo.f429300id.get());
        buildElementParams.put("xsj_topic_name", qQCircleDitto$StItemInfo.name.get());
        VideoReport.setElementParams(this.f86443d, buildElementParams);
        VideoReport.setElementExposePolicy(this.f86443d, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f86443d, ClickPolicy.REPORT_ALL);
    }

    private void u0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "item info is null");
            return;
        }
        if (this.f86444e == null) {
            return;
        }
        List<FeedCloudMeta$StImage> list = qQCircleDitto$StItemInfo.images.get();
        if (list != null && !list.isEmpty()) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = list.get(0);
            if (feedCloudMeta$StImage == null) {
                QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "stImage is null");
                return;
            } else {
                r0(this.f86444e, feedCloudMeta$StImage.picUrl.get(), ImmersiveUtils.dpToPx(50.0f), ImmersiveUtils.dpToPx(50.0f));
                return;
            }
        }
        QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "item info image is null or empty");
    }

    private void v0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "item info is null");
            return;
        }
        if (this.f86445f == null) {
            return;
        }
        String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "is_hot");
        String valueFromListEntry2 = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "label_url");
        if (TextUtils.equals(valueFromListEntry, "1")) {
            this.f86445f.setVisibility(0);
            r0(this.f86445f, valueFromListEntry2, ImmersiveUtils.dpToPx(16.0f), ImmersiveUtils.dpToPx(16.0f));
        } else {
            this.f86445f.setVisibility(8);
        }
    }

    private void w0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "item info is null");
        } else {
            if (this.f86446h == null) {
                return;
            }
            this.f86448m = qQCircleDitto$StItemInfo.name.get();
            this.C = qQCircleDitto$StItemInfo.f429300id.get();
            this.f86446h.setText(m0(qQCircleDitto$StItemInfo.name.get()));
        }
    }

    private void x0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QFSGalleryRecommendTagFeedSubItemView", 1, "item info is null");
        } else {
            if (this.f86447i == null) {
                return;
            }
            this.f86447i.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "view_count_text"));
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168680gd0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSGalleryRecommendTagFeedSubItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        u0(qQCircleDitto$StItemInfo);
        w0(qQCircleDitto$StItemInfo);
        x0(qQCircleDitto$StItemInfo);
        v0(qQCircleDitto$StItemInfo);
        s0(qQCircleDitto$StItemInfo);
    }

    public QFSGalleryRecommendTagFeedSubItemView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p0(this);
    }
}
