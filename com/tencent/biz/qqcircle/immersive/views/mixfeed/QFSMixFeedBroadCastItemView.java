package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.viewmodels.QFSMixFeedTalentPeopleViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import feedcloud.FeedCloudCommon$Entry;
import java.util.HashMap;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedBroadCastItemView extends QFSMixFeedBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {
    private TextView C;
    private ImageView D;
    private Size E;
    private QQCircleDitto$StItemInfo F;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f90843e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarView f90844f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90845h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90846i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90847m;

    public QFSMixFeedBroadCastItemView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        this.f90843e = (LinearLayout) findViewById(R.id.f47121wf);
        this.f90844f = (QCircleAvatarView) findViewById(R.id.f47091wc);
        this.f90845h = (TextView) findViewById(R.id.f47151wi);
        this.f90846i = (TextView) findViewById(R.id.f47131wg);
        this.f90847m = (TextView) findViewById(R.id.f47141wh);
        this.C = (TextView) findViewById(R.id.f47101wd);
        this.D = (ImageView) findViewById(R.id.f47111we);
        this.f90843e.setOnClickListener(this);
        this.E = n.a(getContext(), R.dimen.d3i);
    }

    private void l0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        LinearLayout linearLayout = this.f90843e;
        if (linearLayout != null && qQCircleDitto$StItemInfo != null) {
            VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_BROADCAST);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, qQCircleDitto$StItemInfo.f429300id.get());
            VideoReport.setElementParams(this.f90843e, hashMap);
            VideoReport.setElementReuseIdentifier(this.f90843e, qQCircleDitto$StItemInfo.f429300id.get());
        }
    }

    private void m0(Context context) {
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField;
        String str;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.F;
        if (qQCircleDitto$StItemInfo != null && (pBRepeatMessageField = qQCircleDitto$StItemInfo.urlInfo) != null && pBRepeatMessageField.size() != 0) {
            String f16 = d.f(this.F, "item_jump_url");
            QFSMixFeedTalentPeopleViewModel qFSMixFeedTalentPeopleViewModel = (QFSMixFeedTalentPeopleViewModel) getViewModel(QFSMixFeedTalentPeopleViewModel.class);
            qFSMixFeedTalentPeopleViewModel.S1(f16, this.F.f429300id.get());
            w20.a.j().registerDisplaySurface(qFSMixFeedTalentPeopleViewModel.T1(this.F), qFSMixFeedTalentPeopleViewModel);
            if (f16.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str = f16 + "&view_model_key=" + qFSMixFeedTalentPeopleViewModel.T1(this.F);
            } else {
                str = f16 + "?view_model_key=" + qFSMixFeedTalentPeopleViewModel.T1(this.F);
            }
            qFSMixFeedTalentPeopleViewModel.d2();
            com.tencent.biz.qqcircle.launcher.c.g(context, str);
            return;
        }
        QLog.i("QFSMixFeedBroadCastItemView", 1, "[jumpContentLayerPage] mStItemInfo == null || mStItemInfo.urlInfo == null|| mStItemInfo.urlInfo.size() == 0");
    }

    private void n0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo != null && qQCircleDitto$StItemInfo.busiInfo.get() != null) {
            this.f90845h.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "des_copywriting_1"));
            this.f90847m.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "des_copywriting_2"));
            String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "des_copywriting_3");
            this.C.setText(valueFromListEntry);
            this.C.setTypeface(Typeface.DEFAULT_BOLD);
            if (TextUtils.isEmpty(valueFromListEntry)) {
                this.D.setVisibility(8);
                return;
            }
            return;
        }
        QLog.i("QFSMixFeedBroadCastItemView", 1, "[updateText] info == null || info.busiInfo.get() == null");
    }

    private void o0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        this.f90844f.setAvatar(d.f(qQCircleDitto$StItemInfo, "avatra_url"), qQCircleDitto$StItemInfo.f429300id.get(), this.E);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gj8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedBroadCastItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.e("QFSMixFeedBroadCastItemView", 1, "[bindData] stItemInfo == null");
            return;
        }
        this.F = qQCircleDitto$StItemInfo;
        o0(qQCircleDitto$StItemInfo);
        this.f90846i.setText(this.F.name.get());
        n0(this.F);
        l0(qQCircleDitto$StItemInfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f47121wf) {
            m0(view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public QFSMixFeedBroadCastItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSMixFeedBroadCastItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }
}
