package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.viewmodels.QFSMixFeedTalentPeopleViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleDitto$StPymkItemInfoBizData;

/* loaded from: classes4.dex */
public class QFSMixFeedTalentPeopleItemView extends QFSMixFeedBaseWidgetView<e30.b> implements View.OnClickListener {
    private TextView C;
    private TextView D;
    private ImageView E;
    private LinearLayout F;
    private e30.b G;
    private FeedCloudMeta$StFeed H;
    private QFSMixFeedTalentPeopleViewModel I;
    private final Size J;

    /* renamed from: e, reason: collision with root package name */
    private String f90882e;

    /* renamed from: f, reason: collision with root package name */
    private int f90883f;

    /* renamed from: h, reason: collision with root package name */
    private Object f90884h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleAvatarView f90885i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90886m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if ((loadState == LoadState.STATE_SUCCESS || loadState == LoadState.STATE_DOWNLOAD_SUCCESS) && QFSMixFeedTalentPeopleItemView.this.E != null) {
                QFSMixFeedTalentPeopleItemView.this.E.setVisibility(0);
            }
        }
    }

    public QFSMixFeedTalentPeopleItemView(@NonNull Context context) {
        super(context);
        this.J = n.a(context, R.dimen.d3k);
        initView();
    }

    private void initView() {
        this.f90885i = (QCircleAvatarView) findViewById(R.id.f32800uq);
        this.f90886m = (TextView) findViewById(R.id.f32810ur);
        this.E = (ImageView) findViewById(R.id.f32870ux);
        this.C = (TextView) findViewById(R.id.f31000pv);
        this.D = (TextView) findViewById(R.id.f86784sl);
        this.F = (LinearLayout) findViewById(R.id.f32820us);
        this.f90885i.setOnClickListener(this);
        this.F.setOnClickListener(this);
    }

    private void l0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QFSMixFeedTalentPeopleItemView", 1, "info should not be null.");
            return;
        }
        QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData = new QQCircleDitto$StPymkItemInfoBizData();
        try {
            qQCircleDitto$StPymkItemInfoBizData.mergeFrom(qQCircleDitto$StItemInfo.bizData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSMixFeedTalentPeopleItemView", 1, "[bindPersonInfo] error: ", e16);
        }
        q0(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData);
        this.f90882e = qQCircleDitto$StItemInfo.f429300id.get();
    }

    private void m0(Context context) {
        String str;
        Object obj = this.f90884h;
        if (!(obj instanceof QQCircleDitto$StItemInfo)) {
            QLog.d("QFSMixFeedTalentPeopleItemView", 1, "[jumpPersonDetailPage] current data type not is StItemInfo.");
            return;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = (QQCircleDitto$StItemInfo) obj;
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = qQCircleDitto$StItemInfo.urlInfo;
        if (pBRepeatMessageField != null && pBRepeatMessageField.get() != null && qQCircleDitto$StItemInfo.urlInfo.get().size() != 0) {
            String str2 = qQCircleDitto$StItemInfo.urlInfo.get().get(0).value.get();
            QFSMixFeedTalentPeopleViewModel qFSMixFeedTalentPeopleViewModel = (QFSMixFeedTalentPeopleViewModel) getViewModel(QFSMixFeedTalentPeopleViewModel.class);
            this.I = qFSMixFeedTalentPeopleViewModel;
            qFSMixFeedTalentPeopleViewModel.S1(str2, qQCircleDitto$StItemInfo.f429300id.get());
            w20.a.j().registerDisplaySurface(this.I.T1(qQCircleDitto$StItemInfo), this.I);
            if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str = str2 + "&view_model_key=" + this.I.T1(qQCircleDitto$StItemInfo) + "&from_element=" + QCircleDaTongConstant.ElementId.EM_XSJ_KOL_RANKING_AVATAR;
            } else {
                str = str2 + "?view_model_key=" + this.I.T1(qQCircleDitto$StItemInfo) + "&from_element=" + QCircleDaTongConstant.ElementId.EM_XSJ_KOL_RANKING_AVATAR;
            }
            this.I.d2();
            com.tencent.biz.qqcircle.launcher.c.g(context, str);
        }
    }

    private void o0(int i3) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90882e);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_KOL_RANKING_INDEX, Integer.valueOf(this.f90883f));
        VideoReport.setElementId(this.f90885i, QCircleDaTongConstant.ElementId.EM_XSJ_KOL_RANKING_AVATAR);
        VideoReport.setElementParams(this.f90885i, buildElementParams);
        VideoReport.setElementExposePolicy(this.f90885i, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f90885i, ClickPolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(this.f90885i, QCircleDaTongConstant.ElementId.EM_XSJ_KOL_RANKING_AVATAR + i3);
    }

    private void p0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData) {
        String str;
        if (this.f90885i == null) {
            return;
        }
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = qQCircleDitto$StItemInfo.urlInfo;
        if (pBRepeatMessageField != null && pBRepeatMessageField.get() != null && qQCircleDitto$StItemInfo.urlInfo.get().size() >= 2 && !qQCircleDitto$StItemInfo.urlInfo.get().get(1).value.get().equals("")) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = (FeedCloudCommon$Entry) RFSafeListUtils.get(qQCircleDitto$StItemInfo.urlInfo.get(), 1);
            QCircleAvatarView qCircleAvatarView = this.f90885i;
            if (feedCloudCommon$Entry == null) {
                str = null;
            } else {
                str = feedCloudCommon$Entry.value.get();
            }
            qCircleAvatarView.setAvatarByUrl(str, this.J);
        } else {
            e30.b bVar = this.G;
            if (bVar != null && bVar.g() != null && this.G.g().poster != null) {
                this.f90885i.setAvatar(this.G.g().poster, this.J);
                this.f90885i.setVisibility(0);
            } else if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
                this.f90885i.setAvatarByUin(qQCircleDitto$StItemInfo.f429300id.get(), this.J);
                this.f90885i.setVisibility(0);
            } else {
                this.f90885i.setVisibility(8);
            }
        }
        if (qQCircleDitto$StPymkItemInfoBizData.isNew.get()) {
            this.f90885i.setIsAuth(0);
        }
    }

    private void q0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData) {
        PBRepeatField<String> pBRepeatField;
        if (qQCircleDitto$StItemInfo != null && this.f90886m != null && this.C != null && this.D != null && (pBRepeatField = qQCircleDitto$StItemInfo.des) != null && qQCircleDitto$StItemInfo.name != null) {
            List<String> list = pBRepeatField.get();
            this.f90886m.setText(qQCircleDitto$StItemInfo.name.get());
            if (list != null) {
                this.C.setText(list.get(0));
                this.D.setText(list.get(1));
                this.D.setTypeface(Typeface.DEFAULT_BOLD);
            }
            p0(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g66;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedTalentPeopleItemView";
    }

    public void n0() {
        ImageView imageView = this.E;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && ((id5 = view.getId()) == R.id.f32820us || id5 == R.id.f32800uq)) {
            m0(view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(Object obj, int i3, String str) {
        if (!(obj instanceof QQCircleDitto$StItemInfo)) {
            QLog.w("QFSMixFeedTalentPeopleItemView", 1, "[setData] data not is StItemInfo type.");
            return;
        }
        this.f90884h = obj;
        this.f90883f = i3;
        l0((QQCircleDitto$StItemInfo) obj);
        setRankNumberResource(str);
        o0(i3);
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.H = feedCloudMeta$StFeed;
    }

    public void setRankNumberResource(String str) {
        if (this.E != null) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.E).setUrl(str).setPredecode(true), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (this.H == null || bVar == null) {
            return;
        }
        this.G = bVar;
    }
}
