package com.tencent.biz.qqcircle.widgets.search;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudRead$StSearchMixTag;
import feedcloud.FeedCloudRead$StSearchMixTagBanner;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSearchTopHashTagResultView extends QCircleBaseWidgetView<FeedCloudRead$StSearchMixTag> implements View.OnClickListener {
    private static final int F = cx.a(4.0f);
    private String C;
    private String D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f93872d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f93873e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93874f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93875h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleRoundImageView f93876i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudRead$StSearchMixTag f93877m;

    public QFSSearchTopHashTagResultView(@NonNull Context context, QFSSearchInfo qFSSearchInfo) {
        super(context);
        this.C = "";
        this.D = "";
        o0(qFSSearchInfo);
        initView();
        p0();
    }

    private void initView() {
        this.f93872d = (LinearLayout) findViewById(R.id.f54312ev);
        this.f93873e = (ImageView) findViewById(R.id.y5n);
        this.f93874f = (TextView) findViewById(R.id.kbs);
        this.f93875h = (TextView) findViewById(R.id.f109826gv);
        this.f93876i = (QCircleRoundImageView) findViewById(R.id.f113906rw);
        this.f93872d.setOnClickListener(this);
        this.f93876i.setOnClickListener(this);
    }

    private void l0() {
        QCircleRoundImageView qCircleRoundImageView = this.f93876i;
        if (qCircleRoundImageView == null) {
            return;
        }
        VideoReport.setElementId(qCircleRoundImageView, QCircleDaTongConstant.ElementId.EM_XSJ_BANNER);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_query_text", this.D);
        buildElementParams.put("xsj_banner_type", "topic");
        VideoReport.setElementParams(this.f93876i, buildElementParams);
    }

    private void m0() {
        LinearLayout linearLayout = this.f93872d;
        if (linearLayout == null) {
            return;
        }
        VideoReport.setElementId(linearLayout, "em_xsj_topic_item");
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_query_text", this.D);
        buildElementParams.put("xsj_topic_name", this.C);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.E);
        VideoReport.setElementParams(this.f93872d, buildElementParams);
    }

    private String n0(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        if (feedCloudMeta$StTagInfo == null) {
            return "";
        }
        String f16 = r.f(feedCloudMeta$StTagInfo.tagTotalFeed.get());
        String f17 = r.f(feedCloudMeta$StTagInfo.userViewHistory.get());
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(f17)) {
            sb5.append(f17);
            sb5.append(TokenParser.SP);
            sb5.append(h.a(R.string.f19191463));
        }
        if (!TextUtils.isEmpty(f16)) {
            sb5.append(" / ");
            sb5.append(f16);
            sb5.append(TokenParser.SP);
            sb5.append(h.a(R.string.f184183l7));
        }
        return sb5.toString();
    }

    private void o0(QFSSearchInfo qFSSearchInfo) {
        if (qFSSearchInfo == null) {
            QLog.e("QFSSearchTopHashTagResultView", 1, "[initSearchKeyword] currentSearchInfo is null");
            return;
        }
        this.D = qFSSearchInfo.f();
        QLog.d("QFSSearchTopHashTagResultView", 1, "[initSearchKeyword] mSearchKeyword = " + this.D);
    }

    private void p0() {
        if (!TextUtils.isEmpty(this.D) && this.f93874f != null) {
            if (this.D.startsWith("#")) {
                this.C = this.D.replace("#", "");
            }
            QLog.d("QFSSearchTopHashTagResultView", 1, "[initTitleText] mTagName = " + this.C);
            this.f93874f.setText(this.C);
        }
    }

    private void q0() {
        if (this.f93877m == null) {
            QLog.e("QFSSearchTopHashTagResultView", 1, "[jumpBannerPage] mStSearchMixTag is null");
        } else {
            c.g(getContext(), this.f93877m.picBanner.actionUrl.get());
        }
    }

    private void r0() {
        if (TextUtils.isEmpty(this.C)) {
            QLog.e("QFSSearchTopHashTagResultView", 1, "[jumpPolymerizationPage] mTagName is null");
            return;
        }
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(this.C);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setPolymerizationType(7);
        qCirclePolymerizationBean.setExt1From(3);
        c.j0(getContext(), qCirclePolymerizationBean);
    }

    private void s0(FeedCloudRead$StSearchMixTagBanner feedCloudRead$StSearchMixTagBanner) {
        if (feedCloudRead$StSearchMixTagBanner != null && this.f93876i != null) {
            if (TextUtils.isEmpty(feedCloudRead$StSearchMixTagBanner.image.picUrl.get())) {
                QLog.e("QFSSearchTopHashTagResultView", 1, "[updateBanner] image.picUrl is null");
                this.f93876i.setVisibility(8);
                return;
            }
            this.f93876i.setVisibility(0);
            u0();
            this.f93876i.setRoundRect(F);
            Option supportRecycler = Option.obtain().setUrl(feedCloudRead$StSearchMixTagBanner.image.picUrl.get()).setTargetView(this.f93876i).setPredecode(true).setSupportRecycler(true);
            QCircleFeedPicLoader.setViewWidthHeight(supportRecycler, this.f93876i);
            QCircleFeedPicLoader.g().loadImage(supportRecycler);
            return;
        }
        QLog.e("QFSSearchTopHashTagResultView", 1, "[updateBanner] stSearchMixTagBanner == null");
    }

    private void u0() {
        if (this.f93876i == null) {
            return;
        }
        int c16 = cx.c(getContext()) - (cx.a(16.0f) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f93876i.getLayoutParams();
        layoutParams.width = c16;
        layoutParams.height = (int) (c16 / 11.7f);
        this.f93876i.setLayoutParams(layoutParams);
    }

    private void v0(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        if (this.f93875h == null) {
            QLog.e("QFSSearchTopHashTagResultView", 1, "[updateDesc] mTvOther is null");
            return;
        }
        String n06 = n0(feedCloudMeta$StTagInfo);
        if (TextUtils.isEmpty(n06)) {
            this.f93875h.setVisibility(8);
        } else {
            this.f93875h.setVisibility(0);
        }
        this.f93875h.setText(n06);
    }

    private void w0(FeedCloudRead$StSearchMixTag feedCloudRead$StSearchMixTag) {
        int i3;
        if (feedCloudRead$StSearchMixTag != null && this.f93873e != null) {
            boolean z16 = feedCloudRead$StSearchMixTag.isShowTagMedal.get();
            QLog.d("QFSSearchTopHashTagResultView", 1, "updateMedalIcon, isShowMedal: " + z16);
            ImageView imageView = this.f93873e;
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            if (z16) {
                i3 = R.drawable.ook;
            } else {
                i3 = R.drawable.qui_hashtag;
            }
            imageView.setImageDrawable(qCircleSkinHelper.getDrawable(i3));
            return;
        }
        QLog.e("QFSSearchTopHashTagResultView", 1, "[updateMedalIcon] mStSearchMixTag == null");
    }

    private void x0(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f93874f) != null) {
            this.C = str;
            textView.setText(str);
        } else {
            QLog.e("QFSSearchTopHashTagResultView", 1, "[updateTitle] tagName is null");
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchTopHashTagResultView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StSearchMixTag feedCloudRead$StSearchMixTag, int i3) {
        if (feedCloudRead$StSearchMixTag == null) {
            return;
        }
        this.f93877m = feedCloudRead$StSearchMixTag;
        w0(feedCloudRead$StSearchMixTag);
        x0(feedCloudRead$StSearchMixTag.tagInfo.tagName.get());
        v0(feedCloudRead$StSearchMixTag.tagInfo);
        s0(feedCloudRead$StSearchMixTag.picBanner);
        m0();
        l0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f54312ev) {
            r0();
        } else if (id5 == R.id.f113906rw) {
            q0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        u0();
    }

    public void setTransferInfo(String str) {
        this.E = str;
    }
}
