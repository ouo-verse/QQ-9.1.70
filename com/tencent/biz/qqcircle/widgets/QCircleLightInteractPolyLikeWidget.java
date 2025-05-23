package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.message.widget.QFSChatGiftRecordView;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayout;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleTagFlowLayout;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSDoThanksRequest;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoThanksRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$LightInteractionBusiData;
import qqcircle.QQCircleFeedBase$StPolyLike;

/* loaded from: classes5.dex */
public class QCircleLightInteractPolyLikeWidget extends QCircleBaseLightInteractWidget {
    private ImageView C;
    private QFSFollowView D;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> E;
    private QCircleTagFlowLayout F;
    private int G;
    private Size H;
    private TextView I;
    private TextView J;
    private String K;
    private int L;
    private String M;
    private String N;

    /* renamed from: i, reason: collision with root package name */
    private QCircleAvatarView f93013i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f93014m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements QFSFollowView.c {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
        public void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            int i3;
            String str;
            int i16;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            QCircleExtraTypeInfo qCircleExtraTypeInfo = QCircleLightInteractPolyLikeWidget.this.f92935h;
            if (qCircleExtraTypeInfo != null) {
                feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            QCircleLpReportDc05501.DataBuilder a16 = ua0.c.a(feedCloudMeta$StFeed);
            if (z16) {
                i3 = 73;
            } else {
                i3 = 74;
            }
            QCircleLpReportDc05501.DataBuilder subActionType = a16.setActionType(i3).setSubActionType(2);
            QCircleExtraTypeInfo qCircleExtraTypeInfo2 = QCircleLightInteractPolyLikeWidget.this.f92935h;
            if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
                str = feedCloudMeta$StFeed2.poster.f398463id.get();
            } else {
                str = "";
            }
            QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
            QCircleExtraTypeInfo qCircleExtraTypeInfo3 = QCircleLightInteractPolyLikeWidget.this.f92935h;
            if (qCircleExtraTypeInfo3 != null) {
                i16 = qCircleExtraTypeInfo3.mDataPosition;
            } else {
                i16 = -1;
            }
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(QCircleLightInteractPolyLikeWidget.this.getPageId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f93016d;

        b(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f93016d = feedCloudMeta$StUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            int i3;
            String str;
            int i16;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(this.f93016d);
            qCircleInitBean.setFromReportBean(QCircleLightInteractPolyLikeWidget.this.getReportBean().m466clone());
            com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
            QCircleExtraTypeInfo qCircleExtraTypeInfo = QCircleLightInteractPolyLikeWidget.this.f92935h;
            if (qCircleExtraTypeInfo != null) {
                feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            QCircleLpReportDc05501.DataBuilder a16 = ua0.c.a(feedCloudMeta$StFeed);
            if (view == QCircleLightInteractPolyLikeWidget.this.f93013i) {
                i3 = 71;
            } else {
                i3 = 72;
            }
            QCircleLpReportDc05501.DataBuilder subActionType = a16.setActionType(i3).setSubActionType(2);
            QCircleExtraTypeInfo qCircleExtraTypeInfo2 = QCircleLightInteractPolyLikeWidget.this.f92935h;
            if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
                str = feedCloudMeta$StFeed2.poster.f398463id.get();
            } else {
                str = "";
            }
            QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
            QCircleExtraTypeInfo qCircleExtraTypeInfo3 = QCircleLightInteractPolyLikeWidget.this.f92935h;
            if (qCircleExtraTypeInfo3 != null) {
                i16 = qCircleExtraTypeInfo3.mDataPosition;
            } else {
                i16 = -1;
            }
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(QCircleLightInteractPolyLikeWidget.this.getPageId())));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StLightInteractInfo f93018d;

        /* loaded from: classes5.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoThanksRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f93020a;

            a(boolean z16) {
                this.f93020a = z16;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoThanksRsp feedCloudWrite$StDoThanksRsp) {
                if (!z16 || j3 != 0) {
                    c.this.f93018d.thanked.set(!this.f93020a);
                    c cVar = c.this;
                    QCircleLightInteractPolyLikeWidget.this.y0(cVar.f93018d);
                    QCircleToast.h(R.string.f19228473, 0);
                }
            }
        }

        c(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
            this.f93018d = feedCloudMeta$StLightInteractInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = !this.f93018d.thanked.get();
            this.f93018d.thanked.set(z16);
            QCircleLightInteractPolyLikeWidget.this.y0(this.f93018d);
            String str = this.f93018d.user.f398463id.get();
            int i3 = QCircleLightInteractPolyLikeWidget.this.L;
            QCircleLightInteractPolyLikeWidget qCircleLightInteractPolyLikeWidget = QCircleLightInteractPolyLikeWidget.this;
            VSNetworkHelper.getInstance().sendRequest(new QFSDoThanksRequest(z16, i3, qCircleLightInteractPolyLikeWidget.f92932d, str, qCircleLightInteractPolyLikeWidget.K, QCircleLightInteractPolyLikeWidget.this.M, QCircleLightInteractPolyLikeWidget.this.N), new a(z16));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d extends com.tencent.biz.qqcircle.polylike.flowlayout.a<QQCircleFeedBase$StPolyLike> {
        public d(List<QQCircleFeedBase$StPolyLike> list) {
            super(list);
        }

        @Override // com.tencent.biz.qqcircle.polylike.flowlayout.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public View d(QCircleFlowLayout qCircleFlowLayout, int i3, QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike) {
            View inflate = LayoutInflater.from(QCircleLightInteractPolyLikeWidget.this.getContext()).inflate(R.layout.f168631g50, (ViewGroup) qCircleFlowLayout, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f30840pf);
            QFSChatGiftRecordView qFSChatGiftRecordView = (QFSChatGiftRecordView) inflate.findViewById(R.id.f32510ty);
            if (qQCircleFeedBase$StPolyLike.articleType.get() == 0) {
                qFSChatGiftRecordView.setVisibility(8);
                imageView.setVisibility(0);
                Option obtain = Option.obtain();
                obtain.setTargetView(imageView).setUrl(qQCircleFeedBase$StPolyLike.polyIconUrl.get());
                QCircleFeedPicLoader.g().loadImage(obtain);
            } else {
                imageView.setVisibility(8);
                qFSChatGiftRecordView.setVisibility(0);
                qFSChatGiftRecordView.setIconUrl(qQCircleFeedBase$StPolyLike.polyIconUrl.get());
                qFSChatGiftRecordView.setGiftCount(qQCircleFeedBase$StPolyLike.count.get());
                qFSChatGiftRecordView.setUIStyle(qQCircleFeedBase$StPolyLike.polyTxtColor.get(), qQCircleFeedBase$StPolyLike.polyUnderColor.get());
            }
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final FeedCloudMeta$StLightInteractInfo f93023a;

        e(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
            this.f93023a = feedCloudMeta$StLightInteractInfo;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            if (this.f93023a == null) {
                return null;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (this.f93023a.thanked.get()) {
                str2 = "thank";
            } else {
                str2 = "thank_cancel";
            }
            buildElementParams.put("xsj_action_type", str2);
            return buildElementParams;
        }
    }

    public QCircleLightInteractPolyLikeWidget(@NonNull Context context, int i3, int i16) {
        super(context, i3);
        u0(this);
        this.G = i16;
        this.H = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d3_);
    }

    private void r0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_USER_ROW);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_LIKES_LIST);
        buildElementParams.put("xsj_target_qq", feedCloudMeta$StUser.f398463id.get());
        int i3 = this.G;
        if (i3 != 0) {
            if (i3 != 23) {
                if (i3 != 6 && i3 != 7) {
                    switch (i3) {
                        case 19:
                            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 3);
                            break;
                        case 20:
                            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 4);
                            break;
                        case 21:
                            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 5);
                            break;
                    }
                } else {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 2);
                }
            } else {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 6);
            }
        } else {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 1);
        }
        VideoReport.setElementParams(this, buildElementParams);
        VideoReport.setElementId(this.f93013i, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
        VideoReport.setElementId(this.f93014m, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
    }

    private void s0(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        TextView textView = this.J;
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_THANK_BUTTON);
        VideoReport.setElementReuseIdentifier(textView, feedCloudMeta$StLightInteractInfo.user.f398463id.get() + feedCloudMeta$StLightInteractInfo.opTime.get());
        VideoReport.setEventDynamicParams(textView, new e(feedCloudMeta$StLightInteractInfo));
    }

    private void v0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.D.setFollowedDismiss(false);
        this.D.setUserData(feedCloudMeta$StUser);
        this.D.setFollowStateChangeListener(new a());
    }

    private void w0(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        QQCircleFeedBase$LightInteractionBusiData qQCircleFeedBase$LightInteractionBusiData = new QQCircleFeedBase$LightInteractionBusiData();
        try {
            qQCircleFeedBase$LightInteractionBusiData.mergeFrom(feedCloudMeta$StLightInteractInfo.busiData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        if (qQCircleFeedBase$LightInteractionBusiData.polyInfos.size() == 0) {
            arrayList.add(qQCircleFeedBase$LightInteractionBusiData.polyInfo);
        } else {
            arrayList.addAll(qQCircleFeedBase$LightInteractionBusiData.polyInfos.get());
        }
        this.F.setAdapter(new d(arrayList));
    }

    private void x0(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        if (feedCloudMeta$StLightInteractInfo.opMask.get().contains(1) && !com.tencent.biz.qqcircle.immersive.utils.r.u0(feedCloudMeta$StLightInteractInfo.user)) {
            this.J.setVisibility(0);
            y0(feedCloudMeta$StLightInteractInfo);
            this.J.setOnClickListener(new c(feedCloudMeta$StLightInteractInfo));
            s0(feedCloudMeta$StLightInteractInfo);
            return;
        }
        this.J.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        if (feedCloudMeta$StLightInteractInfo.thanked.get()) {
            this.J.setSelected(true);
            this.J.setText(uq3.o.g0("msgThankConfirmTxt"));
        } else {
            this.J.setSelected(false);
            this.J.setText(uq3.o.g0("msgThankNoneTxt"));
        }
    }

    private void z0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f93013i.setUser(feedCloudMeta$StUser, this.H);
        this.f93014m.setText(feedCloudMeta$StUser.nick.get());
        if (feedCloudMeta$StUser.f398463id.get().equals(this.f92932d.poster.f398463id.get())) {
            this.C.setVisibility(0);
            this.C.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qcircle_skin_feed_comment_tag_author));
        } else {
            this.C.setVisibility(8);
        }
        b bVar = new b(feedCloudMeta$StUser);
        this.f93013i.setOnClickListener(bVar);
        this.f93014m.setOnClickListener(bVar);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj instanceof FeedCloudMeta$StLightInteractInfo) {
            FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo = (FeedCloudMeta$StLightInteractInfo) obj;
            this.f92933e = feedCloudMeta$StLightInteractInfo;
            z0(feedCloudMeta$StLightInteractInfo.user);
            v0(this.f92933e.user);
            x0(this.f92933e);
            int i16 = this.G;
            if (i16 != 19 && i16 != 20 && i16 != 22 && i16 != 23 && i16 != 2 && i16 != 0 && i16 != 6 && i16 != 7) {
                this.I.setVisibility(8);
                w0(this.f92933e);
            } else {
                this.F.setVisibility(8);
                int i17 = this.f92933e.opTime.get();
                if (!com.tencent.biz.qqcircle.immersive.utils.r.u0(this.f92933e.user) && i17 > 0) {
                    this.I.setVisibility(0);
                    this.I.setText(com.tencent.biz.qqcircle.widgets.comment.b.f(i17 * 1000));
                } else {
                    this.I.setVisibility(8);
                }
            }
            r0(this.f92933e.user);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168632g51;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleLightInteractPolyLikeWidget";
    }

    public void setOtherParams(String str, int i3, String str2, String str3) {
        this.K = str;
        this.L = i3;
        this.M = str2;
        this.N = str3;
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.E = aVar;
    }

    protected void u0(View view) {
        this.f93013i = (QCircleAvatarView) view.findViewById(R.id.f31800s1);
        this.f93014m = (TextView) view.findViewById(R.id.f31850s6);
        this.C = (ImageView) view.findViewById(R.id.f31870s8);
        this.D = (QFSFollowView) view.findViewById(R.id.f31820s3);
        this.F = (QCircleTagFlowLayout) view.findViewById(R.id.f32780uo);
        this.I = (TextView) view.findViewById(R.id.f109336fj);
        this.J = (TextView) view.findViewById(R.id.f111866md);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPolyLikeWidget", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.E;
        if (aVar != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPolyLikeWidget", aVar.getReportBean());
        }
        return null;
    }
}
