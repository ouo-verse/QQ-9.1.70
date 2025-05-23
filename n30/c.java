package n30;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.helpers.u;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StNotice;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f418115a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$StNotice f418116b;

    /* renamed from: c, reason: collision with root package name */
    private int f418117c;

    /* renamed from: d, reason: collision with root package name */
    private final View f418118d;

    /* renamed from: e, reason: collision with root package name */
    private View f418119e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleRoundImageView f418120f;

    public c(int i3, @NonNull View view) {
        this.f418115a = i3;
        this.f418118d = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == null) {
            QLog.d("QFSMessageCommentCoverWrapper", 1, "[handleCoverClick] view == null");
        } else {
            FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418116b;
            if (feedCloudMeta$StNotice != null && feedCloudMeta$StNotice.image != null) {
                QLog.d("QFSMessageCommentCoverWrapper", 1, "[handleCoverClick] url = " + this.f418116b.image.picUrl.get());
                QCircleCommentPicLayerBean qCircleCommentPicLayerBean = new QCircleCommentPicLayerBean();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new QFSCommentPicInfo(this.f418116b.image.get()));
                qCircleCommentPicLayerBean.setCommentPicInfoList(arrayList);
                qCircleCommentPicLayerBean.setNeedSaveOperate(false);
                com.tencent.biz.qqcircle.launcher.c.t(view.getContext(), qCircleCommentPicLayerBean);
                g(view, "ev_xsj_abnormal_clck", this.f418116b);
            } else {
                QLog.d("QFSMessageCommentCoverWrapper", 1, "[handleCoverClick] notice or image is null");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void d() {
        if (this.f418119e == null) {
            ViewStub viewStub = (ViewStub) this.f418118d.findViewById(R.id.f1204679m);
            if (viewStub == null) {
                QLog.d("QFSMessageCommentCoverWrapper", 1, "[inflateView] vsCommentCover = null");
                return;
            }
            QLog.d("QFSMessageCommentCoverWrapper", 1, "[inflateView]");
            View inflate = viewStub.inflate();
            this.f418119e = inflate;
            QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) inflate.findViewById(R.id.f47011w5);
            this.f418120f = qCircleRoundImageView;
            qCircleRoundImageView.setRoundRect(cx.a(4.0f));
            this.f418120f.setOnClickListener(new View.OnClickListener() { // from class: n30.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.c(view);
                }
            });
        }
    }

    private boolean e() {
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418116b;
        if (feedCloudMeta$StNotice != null && (feedCloudMeta$StImage = feedCloudMeta$StNotice.image) != null && !TextUtils.isEmpty(feedCloudMeta$StImage.picUrl.get())) {
            return true;
        }
        return false;
    }

    private void g(View view, String str, FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_VIDEO_STYLE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_VIDEO_STYLE);
        if (feedCloudMeta$StNotice != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, feedCloudMeta$StNotice.feedId.get());
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StNotice.operation.opUser.f398463id.get());
            q.r().l(feedCloudMeta$StNotice, buildElementParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(str, view, buildElementParams);
    }

    public void b(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice, int i3) {
        this.f418116b = feedCloudMeta$StNotice;
        this.f418117c = i3;
        if (!e()) {
            View view = this.f418119e;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        d();
        View view2 = this.f418119e;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        u.f84666a.b(this.f418120f);
        String str = feedCloudMeta$StNotice.image.picUrl.get();
        Option requestHeight = Option.obtain().setUrl(str).setTargetView(this.f418120f).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(this.f418120f.getWidth()).setRequestHeight(this.f418120f.getHeight());
        requestHeight.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        LibraGroupKey libraGroupKey = new LibraGroupKey(str);
        libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.ONLY_SAVE);
        requestHeight.setGroupKey(libraGroupKey);
        QCircleFeedPicLoader.g().loadImage(requestHeight);
    }

    public void f() {
        if (e()) {
            g(this.f418119e, "ev_xsj_abnormal_imp", this.f418116b);
        }
    }
}
