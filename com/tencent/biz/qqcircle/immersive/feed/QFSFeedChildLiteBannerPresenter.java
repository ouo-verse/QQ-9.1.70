package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.events.QCircleShoppingCartPopWindowEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSModifyFeedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPolymerizationPanelEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.URLUtil;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StEShopGoods;
import feedcloud.FeedCloudMeta$StEShopGoodsInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StLiteBanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import seal.SealSchemejump$SchemeJump;

/* loaded from: classes4.dex */
public class QFSFeedChildLiteBannerPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private View I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private View N;
    private View P;
    private View Q;
    private ImageView R;
    private ImageView S;
    private TextView T;
    private View U;
    private ImageView V;
    private ImageView W;
    private TextView X;
    private g70.a Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f85113a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f85114b0;

    /* renamed from: c0, reason: collision with root package name */
    private final Runnable f85115c0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildLiteBannerPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            e30.b bVar = QFSFeedChildLiteBannerPresenter.this.E;
            if (bVar == null) {
                return;
            }
            bVar.o("banner_has_rolled", Boolean.TRUE);
            QFSFeedChildLiteBannerPresenter.this.W1();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            QFSFeedChildLiteBannerPresenter qFSFeedChildLiteBannerPresenter = QFSFeedChildLiteBannerPresenter.this;
            qFSFeedChildLiteBannerPresenter.Z1(qFSFeedChildLiteBannerPresenter.S, loadState, option);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            QFSFeedChildLiteBannerPresenter qFSFeedChildLiteBannerPresenter = QFSFeedChildLiteBannerPresenter.this;
            qFSFeedChildLiteBannerPresenter.Z1(qFSFeedChildLiteBannerPresenter.V, loadState, option);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            QFSFeedChildLiteBannerPresenter qFSFeedChildLiteBannerPresenter = QFSFeedChildLiteBannerPresenter.this;
            qFSFeedChildLiteBannerPresenter.Z1(qFSFeedChildLiteBannerPresenter.V, loadState, option);
        }
    }

    private void A1() {
        if (this.Z != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f57532nk)).inflate();
        this.Z = inflate;
        if (inflate != null) {
            this.f85113a0 = (ImageView) inflate.findViewById(R.id.f41591hh);
            this.f85114b0 = (TextView) this.Z.findViewById(R.id.f41581hg);
            this.Z.setVisibility(0);
            this.Z.setOnClickListener(this);
            return;
        }
        QLog.e("QFSFeedChildLiteBannerPresenter", 1, "[inflateWangzheBannerWrapper] mWangzheBannerWrapper is null");
    }

    private boolean B1() {
        if (System.currentTimeMillis() - uq3.k.a().f("sp_key_home_banner_timestamp", 0L) >= com.tencent.biz.qqcircle.utils.cv.d(uq3.c.Z1())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C1(View view) {
        String str;
        MutableLiveData<QCircleInitBean> L1;
        QCircleInitBean value;
        if (this.f85017h == 0) {
            return;
        }
        g70.a aVar = this.Y;
        if (aVar != null && (L1 = aVar.L1()) != null && (value = L1.getValue()) != null && value.getSchemeAttrs() != null && value.getSchemeAttrs().containsKey("key_scheme")) {
            str = value.getSchemeAttrs().get("key_scheme");
        } else {
            str = "";
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.get() == 11) {
            T1();
            return;
        }
        String str2 = ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpUrl.get();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true) && !QCircleScheme.isPolymerizeSchema(str2)) {
            QLog.d("QFSFeedChildLiteBannerPresenter", 1, "[jumpWhenClickLiteBanner] forbid launch other page because of sencebeat");
            return;
        }
        String n16 = n1(str2);
        String k3 = com.tencent.biz.qqcircle.utils.cy.k(n16, QCircleSchemeAttr.UnifiedTagFlow.UNIFIED_TYPE);
        if (com.tencent.biz.qqcircle.utils.cy.m(n16) && "meterial".equals(k3) && !TextUtils.isEmpty(((FeedCloudMeta$StFeed) this.f85017h).musicInfo.MID.get()) && ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_fabuqi_genpaidaojuzidongfuyongyinyue")) {
            n16 = com.tencent.biz.qqcircle.utils.cy.d(n16, ((FeedCloudMeta$StFeed) this.f85017h).musicInfo.MID.get());
        }
        if (com.tencent.biz.qqcircle.utils.cy.n(n16)) {
            com.tencent.biz.qqcircle.launcher.c.h(view.getContext(), com.tencent.biz.qqcircle.utils.cy.g(n16, 3), str);
            return;
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.get() == 1) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleShoppingCartPopWindowEvent(n16, (FeedCloudMeta$StFeed) this.f85017h));
            return;
        }
        if (J1() && QCircleScheme.isFolderSchema(n16)) {
            E1();
            return;
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.get() == 6) {
            QCircleHostLauncher.launchChannelPage(com.tencent.biz.qqcircle.immersive.utils.r.x(m0()), n16, false);
            return;
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.get() == 7) {
            D1(n16);
            return;
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.get() == 8) {
            G1(n16, ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpAuth.get().toStringUtf8());
        } else if (K1(((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.get())) {
            F1(n16);
        } else {
            com.tencent.biz.qqcircle.launcher.c.h(view.getContext(), n16, str);
        }
    }

    private void D1(String str) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        QCircleSchemeBean qCircleSchemeBean = new QCircleSchemeBean();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uin", argumentsFromURL.get("uin"));
        hashMap.put("type", argumentsFromURL.get("type"));
        hashMap.put(QCircleScheme.AttrAio.SH_MSG_SEQ, argumentsFromURL.get(QCircleScheme.AttrAio.SH_MSG_SEQ));
        hashMap.put("halfscreen", argumentsFromURL.get("halfscreen"));
        qCircleSchemeBean.setAttrs(hashMap);
        qCircleSchemeBean.setSchemeAction(QCircleScheme.Q_CIRCLE_ACTION_OPEN_AIO);
        QCircleSchemeLauncher.b(m0(), qCircleSchemeBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void E1() {
        QCircleInitBean mInitBean;
        QCircleFolderBean qCircleFolderBean = new QCircleFolderBean();
        qCircleFolderBean.setAssignShowTabType(6);
        qCircleFolderBean.setFromReportBean(getReportBean().m466clone());
        qCircleFolderBean.setEnableSplash(true);
        qCircleFolderBean.setForceFromNetwork(true);
        if (this.f85017h != 0) {
            SealSchemejump$SchemeJump sealSchemejump$SchemeJump = new SealSchemejump$SchemeJump();
            sealSchemejump$SchemeJump.feed_id.set(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            if (s0() == null) {
                mInitBean = null;
            } else {
                mInitBean = s0().getMInitBean();
            }
            if (mInitBean != null && mInitBean.getSchemeAttrs() != null && mInitBean.getSchemeAttrs().containsKey("xsj_custom_pgid")) {
                sealSchemejump$SchemeJump.pageinfo.set(mInitBean.getSchemeAttrs().get("xsj_custom_pgid"));
            }
            qCircleFolderBean.setSchemeJumpInfo(sealSchemejump$SchemeJump.toByteArray());
        }
        com.tencent.biz.qqcircle.launcher.c.I(m0(), qCircleFolderBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F1(String str) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSShowPolymerizationPanelEvent((FeedCloudMeta$StFeed) this.f85017h, (QCirclePolymerizationBean) QCircleSchemeLauncher.a(m0(), str), true, m0().hashCode()));
    }

    private void G1(String str, String str2) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        QCircleSchemeBean qCircleSchemeBean = new QCircleSchemeBean();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uin", argumentsFromURL.get("uin"));
        hashMap.put(QCircleScheme.AttrQQGroupDetail.AUTH_SIG, str2);
        hashMap.put("from", "feed");
        qCircleSchemeBean.setAttrs(hashMap);
        qCircleSchemeBean.setSchemeAction(QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQ_GROUP_DETAIL);
        QCircleSchemeLauncher.b(m0(), qCircleSchemeBean);
    }

    private void H1(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        String str;
        View view2;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner;
        if (view != null && feedCloudMeta$StLiteBanner != null) {
            String str2 = feedCloudMeta$StLiteBanner.jumpUrl.get();
            if (TextUtils.isEmpty(str2) && feedCloudMeta$StLiteBanner.business_type.get() != 17) {
                P1(view);
                return;
            }
            HashMap hashMap = new HashMap();
            if (feedCloudMeta$StLiteBanner.business_type.get() == 2) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CAMPUS_NAME, q1());
                str = QCircleDaTongConstant.ElementId.EM_XSJ_CAMPUS_LABEL;
            } else {
                if (feedCloudMeta$StLiteBanner.business_type.get() == 6) {
                    hashMap.put("xsj_publish_source", 2);
                    hashMap.put("xsj_publish_source_name", feedCloudMeta$StLiteBanner.title.get());
                    hashMap.put("xsj_publish_source_id", String.valueOf(feedCloudMeta$StFeed.feedExtraInfo.inner_jump.guild_id.get()));
                } else if (feedCloudMeta$StLiteBanner.business_type.get() != 7 && feedCloudMeta$StLiteBanner.business_type.get() != 8) {
                    if (!TextUtils.isEmpty(str2) && str2.toLowerCase().contains(QCircleDaTongConstant.ElementParamKey.UNIFIED.toLowerCase())) {
                        Map<String, String> p16 = p1(feedCloudMeta$StLiteBanner.jumpUrl.get());
                        if (p16.containsKey("xsj_material_type")) {
                            hashMap.put("xsj_material_type", p16.get("xsj_material_type"));
                        }
                        if (p16.containsKey("xsj_material_id")) {
                            hashMap.put("xsj_material_id", p16.get("xsj_material_id"));
                        }
                        if (feedCloudMeta$StLiteBanner.style_type.get() == 3) {
                            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MATERIAL_NAME, feedCloudMeta$StLiteBanner.title.get());
                        } else {
                            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MATERIAL_NAME, feedCloudMeta$StLiteBanner.title.get().substring(3));
                        }
                        hashMap.putAll(p1(feedCloudMeta$StLiteBanner.jumpUrl.get()));
                        str = QCircleDaTongConstant.ElementId.EM_XSJ_SAME_BUTTON;
                    } else if (feedCloudMeta$StLiteBanner.style_type.get() == 5) {
                        m1(hashMap, feedCloudMeta$StLiteBanner);
                        str = QCircleDaTongConstant.ElementId.EM_XSJ_GUIDE_PANEL;
                    } else {
                        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_ID, feedCloudMeta$StLiteBanner.activityID.get());
                        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, Integer.valueOf(feedCloudMeta$StLiteBanner.business_type.get()));
                        hashMap.put("come_from", QCirclePluginUtil.getValueFromListEntry(feedCloudMeta$StLiteBanner.extInfo.get(), "appID"));
                        hashMap.put("xsj_guide_text", feedCloudMeta$StLiteBanner.title.get());
                        str = QCircleDaTongConstant.ElementId.EM_XSJ_ACTIVITY_BUTTON;
                    }
                } else {
                    if (feedCloudMeta$StFeed.feedExtraInfo.inner_jump.qq_group_source.get() == 1) {
                        i3 = 3;
                    } else if (feedCloudMeta$StFeed.feedExtraInfo.inner_jump.qq_group_source.get() == 2) {
                        i3 = 4;
                    } else {
                        i3 = 1;
                    }
                    hashMap.put("xsj_publish_source", Integer.valueOf(i3));
                    hashMap.put("xsj_publish_source_name", feedCloudMeta$StLiteBanner.title.get());
                    hashMap.put("xsj_publish_source_id", String.valueOf(feedCloudMeta$StFeed.feedExtraInfo.inner_jump.qq_group_id.get()));
                    hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID, String.valueOf(feedCloudMeta$StFeed.feedExtraInfo.inner_jump.qq_group_id.get()));
                }
                str = QCircleDaTongConstant.ElementId.EM_XSJ_PUBLISH_SOURCE_EXPOSED;
            }
            hashMap.put("xsj_resource_type", 3);
            String j3 = com.tencent.biz.qqcircle.utils.cy.j(feedCloudMeta$StLiteBanner.jumpUrl.get());
            if (!TextUtils.isEmpty(j3)) {
                hashMap.put("xsj_template_id", j3);
            }
            String l3 = com.tencent.biz.qqcircle.utils.cy.l(feedCloudMeta$StLiteBanner.jumpUrl.get());
            if (!TextUtils.isEmpty(l3)) {
                hashMap.put("xsj_operation_activity_id", l3);
            }
            hashMap.put("xsj_url", feedCloudMeta$StLiteBanner.jumpUrl.get());
            VideoReport.setElementId(view, str);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            hashMap2.putAll(hashMap);
            String str3 = str + this.E.g().f398449id.get();
            VideoReport.setElementReuseIdentifier(view, str3);
            VideoReport.setElementParams(view, hashMap2);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            VideoReport.setElementClickPolicy(view, clickPolicy);
            if (view == this.Q && (view2 = this.U) != null) {
                VideoReport.setElementId(view2, str);
                VideoReport.setElementReuseIdentifier(this.U, str3);
                VideoReport.setElementParams(this.U, hashMap2);
                VideoReport.setElementExposePolicy(this.U, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementEndExposePolicy(this.U, EndExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(this.U, clickPolicy);
            }
        }
    }

    private boolean I1(View view, FeedCloudMeta$StEShopGoods feedCloudMeta$StEShopGoods) {
        FeedCloudMeta$StEShopGoodsInfo feedCloudMeta$StEShopGoodsInfo;
        if (feedCloudMeta$StEShopGoods == null || feedCloudMeta$StEShopGoods.goodsInfos.size() == 0 || (feedCloudMeta$StEShopGoodsInfo = feedCloudMeta$StEShopGoods.goodsInfos.get(0)) == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_ID, feedCloudMeta$StEShopGoodsInfo.f398448id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_TITLE, feedCloudMeta$StEShopGoodsInfo.name.get());
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_IF_PRODUCTS_PROMOTION);
        VideoReport.setElementParams(view, hashMap);
        return true;
    }

    private static boolean K1(int i3) {
        if (i3 == 2 && com.tencent.biz.qqcircle.immersive.utils.a.b()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void M1() {
        String str;
        T t16 = this.f85017h;
        if (t16 == 0) {
            return;
        }
        if (((FeedCloudMeta$StFeed) t16).liteBanner != null && ((FeedCloudMeta$StFeed) t16).liteBanner.jumpUrl.get() != null) {
            str = ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpUrl.get();
        } else {
            str = "";
        }
        boolean n3 = com.tencent.biz.qqcircle.utils.cy.n(str);
        boolean m3 = com.tencent.biz.qqcircle.utils.cy.m(str);
        QLog.d("QFSFeedChildLiteBannerPresenter", 1, "isPublishSchema:" + n3 + ", isFeedPublishSchema:" + m3);
        if (n3 || m3) {
            com.tencent.biz.qqcircle.utils.k.j("exp_qq_shoot_same_video_new_link_new");
        }
    }

    private void N1(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (view == null || feedCloudMeta$StFeed == null || I1(view, feedCloudMeta$StFeed.eShopGoods)) {
            return;
        }
        H1(view, feedCloudMeta$StFeed);
        X1(101);
        o1(feedCloudMeta$StFeed.liteBanner.jumpUrl.get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void O1(int i3, int i16) {
        String str;
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).liteBanner.get() != null && TextUtils.isEmpty(((FeedCloudMeta$StFeed) this.f85017h).liteBanner.activityID.get())) {
            String str2 = ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpUrl.get();
            if (!TextUtils.isEmpty(str2) && str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_UNIFIEDTAGFLOW)) {
                Map<String, String> p16 = p1(str2);
                String str3 = "";
                if (!p16.containsKey("xsj_material_id")) {
                    str = "";
                } else {
                    str = p16.get("xsj_material_id");
                }
                if (p16.containsKey("xsj_material_type")) {
                    str3 = p16.get("xsj_material_type");
                }
                l1(i3, i16, str3, str);
            }
        }
    }

    private void P1(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_material_type", QCircleDaTongConstant.ElementParamValue.SAME_STATUS);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_SAME_BUTTON);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
        hashMap2.putAll(hashMap);
        VideoReport.setElementReuseIdentifier(view, QCircleDaTongConstant.ElementId.EM_XSJ_SAME_BUTTON + this.E.g().f398449id.get());
        VideoReport.setElementParams(view, hashMap2);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void Q1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TOAST);
        buildElementParams.put("xsj_toast_content", m0().getResources().getString(R.string.f185213nz));
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void R1(FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner) {
        if (feedCloudMeta$StLiteBanner != null && this.J != null) {
            String str = feedCloudMeta$StLiteBanner.icon.picUrl.get();
            if (!TextUtils.isEmpty(str)) {
                this.J.setVisibility(0);
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(this.J.getLayoutParams().width).setRequestHeight(this.J.getLayoutParams().height).setUrl(str).setTargetView(this.J).setSupportRecycler(true));
            } else {
                this.J.setVisibility(8);
            }
            S1(feedCloudMeta$StLiteBanner.title.get());
        }
    }

    private void S1(String str) {
        String str2;
        String str3;
        int i3;
        if (this.L != null && this.N != null && this.M != null && this.K != null && !TextUtils.isEmpty(str)) {
            String[] split = str.split("\u00b7");
            TextView textView = this.L;
            int i16 = 0;
            String str4 = "";
            if (split.length <= 0) {
                str2 = "";
            } else {
                str2 = split[0];
            }
            textView.setText(str2);
            TextView textView2 = this.M;
            if (split.length <= 1) {
                str3 = "";
            } else {
                str3 = split[1];
            }
            textView2.setText(str3);
            TextView textView3 = this.K;
            if (split.length > 2) {
                str4 = split[2];
            }
            textView3.setText(str4);
            View view = this.N;
            if (split.length > 1) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            TextView textView4 = this.K;
            if (split.length <= 2) {
                i16 = 8;
            }
            textView4.setVisibility(i16);
            this.M.requestLayout();
            return;
        }
        QLog.e("QFSFeedChildLiteBannerPresenter", 1, "[setBannerText] LiteBanner seems not inflate. bannerString: " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void T1() {
        int i3;
        String str;
        long j3;
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).liteBanner != null && ((FeedCloudMeta$StFeed) t16).liteBanner.extInfo != null) {
            List<FeedCloudCommon$Entry> list = ((FeedCloudMeta$StFeed) t16).liteBanner.extInfo.get();
            int i16 = -1;
            long j16 = -1;
            if (list != null) {
                long j17 = -1;
                str = "";
                long j18 = -1;
                int i17 = -1;
                for (int i18 = 0; i18 < list.size(); i18++) {
                    FeedCloudCommon$Entry feedCloudCommon$Entry = list.get(i18);
                    try {
                        if (TextUtils.equals(feedCloudCommon$Entry.key.get(), "qq_state_origin_ID")) {
                            i16 = Integer.parseInt(feedCloudCommon$Entry.value.get());
                        } else if (TextUtils.equals(feedCloudCommon$Entry.key.get(), "qq_state_rich_ID")) {
                            j18 = Long.parseLong(feedCloudCommon$Entry.value.get());
                        } else if (TextUtils.equals(feedCloudCommon$Entry.key.get(), "qq_state_face_text")) {
                            str = feedCloudCommon$Entry.value.get();
                        } else if (TextUtils.equals(feedCloudCommon$Entry.key.get(), "qq_state_face_type")) {
                            i17 = Integer.parseInt(feedCloudCommon$Entry.value.get());
                        } else if (TextUtils.equals(feedCloudCommon$Entry.key.get(), "qq_state_face_index")) {
                            j17 = Long.parseLong(feedCloudCommon$Entry.value.get());
                        }
                    } catch (Exception unused) {
                        QLog.e("QFSFeedChildLiteBannerPresenter", 1, "\u7c7b\u578b\u8f6c\u6362\u5f02\u5e38" + feedCloudCommon$Entry.value.get());
                    }
                }
                i3 = i16;
                i16 = i17;
                j16 = j17;
                j3 = j18;
            } else {
                i3 = -1;
                str = "";
                j3 = -1;
            }
            QCircleToast.o("\u72b6\u6001\u8bbe\u7f6e\u6210\u529f", 0);
            Q1();
            ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).updateDiyOnlineStatus(AppRuntime.Status.build(i3), j3, new DiyStatusEmoInfo(i16, j16, str));
        }
    }

    private boolean U1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (feedCloudMeta$StFeed.liteBanner.style_type.get() != 3 && feedCloudMeta$StFeed.liteBanner.style_type.get() != 5) {
            return false;
        }
        if (feedCloudMeta$StFeed.liteBanner.business_type.get() == 3) {
            if (this.f85018i < feedCloudMeta$StFeed.liteBanner.startActionIndex.get() - 1 || !B1() || w1() || TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.postPicture.picUrl.get()) || TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get())) {
                return false;
            }
            return true;
        }
        if (w1() || TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.postPicture.picUrl.get()) || TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1() {
        View view;
        if (this.U != null && (view = this.Q) != null && this.P != null) {
            view.setVisibility(8);
            this.U.setVisibility(0);
            AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(m0(), R.anim.f154902t7);
            animationSet.setAnimationListener(new e());
            this.P.startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1() {
        if (this.P == null) {
            return;
        }
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(m0(), R.anim.f154901t6);
        animationSet.setAnimationListener(new d());
        this.P.startAnimation(animationSet);
        uq3.k.a().n("sp_key_home_banner_timestamp", System.currentTimeMillis());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X1(int i3) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).liteBanner.tianshuEntry.has()) {
            com.tencent.biz.qqcircle.immersive.utils.az.a(((FeedCloudMeta$StFeed) this.f85017h).liteBanner.tianshuEntry.value.lst.get(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(final View view, LoadState loadState, Option option) {
        final ViewGroup.LayoutParams layoutParams;
        if (view == null || loadState == null || option == null || loadState != LoadState.STATE_SUCCESS || option.getResultBitMap() == null || option.getResultBitMap().getHeight() <= 0 || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = (layoutParams.height * option.getResultBitMap().getWidth()) / option.getResultBitMap().getHeight();
        x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildLiteBannerPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(layoutParams);
            }
        });
    }

    private void a2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        x1();
        if (s0() != null && s0().getMInitBean() != null && TextUtils.equals(s0().getMInitBean().getLayerBizAssemblerType(), "biz_mini_game")) {
            return;
        }
        if (feedCloudMeta$StFeed.liteBanner.style_type.get() == 0) {
            s1(feedCloudMeta$StFeed);
            return;
        }
        if (feedCloudMeta$StFeed.liteBanner.style_type.get() != 3 && feedCloudMeta$StFeed.liteBanner.style_type.get() != 5) {
            if (feedCloudMeta$StFeed.liteBanner.style_type.get() == 6) {
                u1(feedCloudMeta$StFeed);
                return;
            }
            return;
        }
        r1(feedCloudMeta$StFeed);
    }

    private void c2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.postPicture.picUrl.get()) && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get()) && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.postPicture.picUrl.get())) {
            View view = this.I;
            if (view != null) {
                view.setVisibility(8);
            }
            this.P.setVisibility(0);
            this.U.setVisibility(8);
            this.Q.setVisibility(0);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(this.R.getLayoutParams().width).setRequestHeight(this.R.getLayoutParams().height).setUrl(feedCloudMeta$StFeed.liteBanner.icon.picUrl.get()).setTargetView(this.R));
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feedCloudMeta$StFeed.liteBanner.picture.picUrl.get()).setTargetView(this.S), new a());
            this.T.setText(feedCloudMeta$StFeed.liteBanner.title.get());
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feedCloudMeta$StFeed.liteBanner.postPicture.picUrl.get()).setTargetView(this.V), new b());
            this.X.setText(feedCloudMeta$StFeed.liteBanner.title.get());
            N1(this.Q, feedCloudMeta$StFeed);
            return;
        }
        x1();
    }

    private void d2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.postPicture.picUrl.get()) && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get())) {
            View view = this.I;
            if (view != null) {
                view.setVisibility(8);
            }
            this.P.setVisibility(0);
            this.U.setVisibility(0);
            this.Q.setVisibility(8);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feedCloudMeta$StFeed.liteBanner.postPicture.picUrl.get()).setTargetView(this.V), new c());
            this.X.setText(feedCloudMeta$StFeed.liteBanner.title.get());
            N1(this.U, feedCloudMeta$StFeed);
            return;
        }
        x1();
    }

    private void e2(FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner) {
        if (feedCloudMeta$StLiteBanner != null && this.f85113a0 != null && this.f85114b0 != null) {
            String str = feedCloudMeta$StLiteBanner.icon.picUrl.get();
            if (!TextUtils.isEmpty(str)) {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(this.f85113a0.getLayoutParams().width).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(25.0f)).setUrl(str).setTargetView(this.f85113a0));
            }
            this.f85114b0.setText(feedCloudMeta$StLiteBanner.title.get());
        }
    }

    private void l1(final int i3, final int i16, final String str, final String str2) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildLiteBannerPresenter.8
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                T t16 = QFSFeedChildLiteBannerPresenter.this.f85017h;
                if (t16 == 0) {
                    return;
                }
                QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c((FeedCloudMeta$StFeed) t16)).setActionType(i3).setSubActionType(i16).setExt4(str).setExt5(str2).setPageId(QFSFeedChildLiteBannerPresenter.this.y0()));
            }
        });
    }

    private void m1(@NonNull Map<String, Object> map, @NonNull FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner) {
        int i3;
        if (feedCloudMeta$StLiteBanner.tianshuEntry.has()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUIDE_PANEL_SOURCE, Integer.valueOf(i3));
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_CUSTOMIZED_BUSINESS_TYPE, Integer.valueOf(feedCloudMeta$StLiteBanner.business_type.get()));
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_TASK_ID, feedCloudMeta$StLiteBanner.activityID.get());
        com.tencent.biz.qqcircle.utils.aj.d(feedCloudMeta$StLiteBanner.extInfo.get(), map, new String[]{"xsj_operation_activity_id"});
    }

    private String n1(String str) {
        if (str.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_UNIFIEDTAGFLOW)) {
            String k3 = com.tencent.biz.qqcircle.utils.cy.k(str, QCircleSchemeAttr.UnifiedTagFlow.UNIFIED_TYPE);
            String k16 = com.tencent.biz.qqcircle.utils.cy.k(str, QCircleSchemeAttr.UnifiedTagFlow.UNIFIED_ID);
            if (!TextUtils.isEmpty(k3) && !TextUtils.isEmpty(k16)) {
                com.tencent.biz.qqcircle.wink.e eVar = com.tencent.biz.qqcircle.wink.e.f93946a;
                eVar.e(k3, k16);
                return com.tencent.biz.qqcircle.utils.cy.b(str, eVar.s().getFeedId());
            }
            return str;
        }
        return str;
    }

    private void o1(String str) {
        if (str.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_UNIFIEDTAGFLOW)) {
            String k3 = com.tencent.biz.qqcircle.utils.cy.k(str, QCircleSchemeAttr.UnifiedTagFlow.UNIFIED_TYPE);
            String k16 = com.tencent.biz.qqcircle.utils.cy.k(str, QCircleSchemeAttr.UnifiedTagFlow.UNIFIED_ID);
            if (!TextUtils.isEmpty(k3) && !TextUtils.isEmpty(k16)) {
                com.tencent.biz.qqcircle.wink.e.f93946a.f(k3, k16);
            }
        }
    }

    public static Map<String, String> p1(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1).split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split[0].contains(QCircleDaTongConstant.ElementParamKey.UNIFIED) && split.length == 2) {
                hashMap.put(split[0].replace(QCircleDaTongConstant.ElementParamKey.UNIFIED, "xsj_material_"), split[1]);
            }
        }
        return hashMap;
    }

    private String q1() {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && this.E.g().liteBanner != null && this.E.g().liteBanner.business_type.get() == 2) {
            String str = this.E.g().liteBanner.title.get();
            if (this.E.g().liteBanner.style_type.get() != 3 && this.E.g().liteBanner.style_type.get() != 5) {
                return str.substring(str.indexOf("\u00b7") + 1);
            }
            return str;
        }
        return "";
    }

    private void r1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        y1();
        if (w1()) {
            d2(feedCloudMeta$StFeed);
        } else {
            c2(feedCloudMeta$StFeed);
        }
    }

    private void s1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        boolean z16;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner) != null && (feedCloudMeta$StImage = feedCloudMeta$StLiteBanner.icon) != null) {
            if (!TextUtils.isEmpty(feedCloudMeta$StImage.picUrl.get()) && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get())) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean k3 = com.tencent.biz.qqcircle.immersive.utils.au.k(feedCloudMeta$StFeed);
            if (!z16 && !k3) {
                QLog.d("QFSFeedChildLiteBannerPresenter", 1, "[handleDefaultBanner] liteBanner.icon.picUrl=" + feedCloudMeta$StFeed.liteBanner.icon.picUrl.get() + " | liteBanner.title=" + feedCloudMeta$StFeed.liteBanner.title.get());
                x1();
                return;
            }
            z1();
            View view = this.I;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.P;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            R1(feedCloudMeta$StFeed.liteBanner);
            N1(this.I, feedCloudMeta$StFeed);
            return;
        }
        QLog.e("QFSFeedChildLiteBannerPresenter", 1, "[handleDefaultBanner] data == null || data.liteBanner == null || data.liteBanner.icon == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t1(QFSModifyFeedEvent qFSModifyFeedEvent) {
        if (qFSModifyFeedEvent != null && this.f85017h != 0 && TextUtils.equals(qFSModifyFeedEvent.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            String groupName = qFSModifyFeedEvent.getGroupName();
            long groupId = qFSModifyFeedEvent.getGroupId();
            ((FeedCloudMeta$StFeed) this.f85017h).feedExtraInfo.inner_jump.qq_group_id.set(groupId);
            if (TextUtils.isEmpty(groupName) && ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.get() == 7) {
                QLog.d("QFSFeedChildLiteBannerPresenter", 1, "[handleModifyFeedInnerJumpEvent] hide banner.");
                ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.title.set("");
                x1();
                return;
            }
            if (!TextUtils.isEmpty(groupName)) {
                ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.icon.picUrl.set(uq3.c.j2());
                ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.title.set("QQ\u7fa4\u00b7" + groupName);
                ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.business_type.set(7);
                ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.style_type.set(0);
                s1((FeedCloudMeta$StFeed) this.f85017h);
                ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpUrl.set(QCircleScheme.AIO_SCHEMA_PREFIX + "uin" + ContainerUtils.KEY_VALUE_DELIMITER + groupId + ContainerUtils.FIELD_DELIMITER + "type" + ContainerUtils.KEY_VALUE_DELIMITER + 1 + ContainerUtils.FIELD_DELIMITER + "halfscreen" + ContainerUtils.KEY_VALUE_DELIMITER + "1");
                T0(new com.tencent.biz.qqcircle.immersive.feed.event.ai());
                return;
            }
            return;
        }
        QLog.d("QFSFeedChildLiteBannerPresenter", 1, "[handleModifyFeedInnerJumpEvent] is not the same feed.");
    }

    private void u1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.icon.picUrl.get()) && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get())) {
            A1();
            View view = this.Z;
            if (view != null) {
                view.setVisibility(0);
            }
            e2(feedCloudMeta$StFeed.liteBanner);
            return;
        }
        if (feedCloudMeta$StFeed != null) {
            QLog.d("QFSFeedChildLiteBannerPresenter", 1, "[handleWangzheBanner] liteBanner.icon.picUrl=" + feedCloudMeta$StFeed.liteBanner.icon.picUrl.get() + " | liteBanner.title=" + feedCloudMeta$StFeed.liteBanner.title.get());
        }
        x1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v1(View view) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).liteBanner.business_type.get() == 14) {
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpUrl.get());
        }
    }

    private boolean w1() {
        e30.b bVar = this.E;
        if (bVar == null) {
            return false;
        }
        Object b16 = bVar.b("banner_has_rolled");
        if (!(b16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) b16).booleanValue();
    }

    private void x1() {
        View view = this.I;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.P;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.U;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.Q;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.Z;
        if (view5 != null) {
            view5.setVisibility(8);
        }
    }

    private void y1() {
        if (this.P != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f3514112)).inflate();
        this.P = inflate;
        View findViewById = inflate.findViewById(R.id.f3515113);
        this.Q = findViewById;
        findViewById.setOnClickListener(this);
        this.R = (ImageView) this.P.findViewById(R.id.f47921yl);
        this.S = (ImageView) this.P.findViewById(R.id.f47931ym);
        this.T = (TextView) this.P.findViewById(R.id.f47911yk);
        View findViewById2 = this.P.findViewById(R.id.f3516114);
        this.U = findViewById2;
        findViewById2.setOnClickListener(this);
        this.V = (ImageView) this.P.findViewById(R.id.f494122m);
        this.X = (TextView) this.P.findViewById(R.id.f494022l);
        this.W = (ImageView) this.P.findViewById(R.id.f493922k);
    }

    private void z1() {
        if (this.I != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f40691f2)).inflate();
        this.I = inflate;
        if (inflate != null) {
            inflate.setOnClickListener(this);
            this.J = (ImageView) this.I.findViewById(R.id.f40651ey);
            this.L = (TextView) this.I.findViewById(R.id.f40681f1);
            this.M = (TextView) this.I.findViewById(R.id.f40641ex);
            this.N = this.I.findViewById(R.id.f40671f0);
            this.K = (TextView) this.I.findViewById(R.id.f40661ez);
            return;
        }
        QLog.e("QFSFeedChildLiteBannerPresenter", 1, "[inflateLiteBannerWrapper] mLiteBannerWrapper is null");
    }

    public boolean J1() {
        return !QCircleHostGlobalInfo.isCurrentTabActive();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        a2(feedCloudMeta$StFeed);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.Y = (g70.a) A0(g70.a.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSModifyFeedEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.f40691f2 && view.getId() != R.id.f3516114 && view.getId() != R.id.f3515113) {
            if (view.getId() == R.id.f57532nk) {
                v1(view);
            }
        } else {
            C1(view);
            SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
            X1(102);
            O1(500, 2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (U1((FeedCloudMeta$StFeed) this.f85017h)) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f85115c0);
            RFWThreadManager.getUIHandler().postDelayed(this.f85115c0, ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.stylePlayTime.get() * 1000);
        }
        O1(500, 1);
        M1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85115c0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSModifyFeedEvent) {
            t1((QFSModifyFeedEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildLiteBannerPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedChildLiteBannerPresenter.this.V1();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
