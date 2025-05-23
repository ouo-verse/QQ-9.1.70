package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.feed.ad.ae;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.af;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<String> f91278a;

    /* renamed from: b, reason: collision with root package name */
    private static Set<Integer> f91279b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f91280a;

        /* renamed from: b, reason: collision with root package name */
        public long f91281b;

        /* renamed from: c, reason: collision with root package name */
        public int f91282c;
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f91278a = sparseArray;
        sparseArray.put(0, "noNet");
        sparseArray.put(5, "cable");
        sparseArray.put(2, QADNetStatus.G_2);
        sparseArray.put(3, QADNetStatus.G_3);
        sparseArray.put(4, QADNetStatus.G_4);
        sparseArray.put(6, QADNetStatus.G_5);
        sparseArray.put(1, "wifi");
        v();
    }

    public static boolean A(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        Iterator<FeedCloudCommon$Entry> it = feedCloudMeta$StFeed.clientInfo.clientMap.get().iterator();
        while (it.hasNext()) {
            if (it.next().key.get().equals("is_single_user_feed")) {
                return true;
            }
        }
        return false;
    }

    public static boolean B(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.type.get() == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map C(String str) {
        QFSVideoView qFSVideoView;
        FeedCloudMeta$StFeed data;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null && (qFSVideoView = weakReference.get()) != null && (data = qFSVideoView.getData()) != null) {
            buildElementParams.put("xsj_feed_id", af.a(data.f398449id.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, data.poster.f398463id.get());
        }
        return buildElementParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(QCircleInitBean qCircleInitBean, View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setUserSource(t(qCircleInitBean));
        com.tencent.biz.qqcircle.launcher.c.y0(view.getContext(), qFSSearchBean);
        EventCollector.getInstance().onViewClicked(view2);
    }

    public static void E(e30.b bVar, View view, int i3, int i16) {
        GdtAd gdtAd = new GdtAd(com.tencent.biz.qqcircle.immersive.feed.ad.u.e(bVar));
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(gdtAd, view, i3, ae.b(bVar.g(), i3), i16);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        ae.d(gdtAd, buildElementParams);
        ua0.i.j(view, QCircleDaTongConstant.ElementId.EM_XSJ_AD_FEED, buildElementParams);
    }

    public static Integer F(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (IllegalArgumentException e16) {
            QLog.w("QFSSearchUtil", 1, e16.getMessage(), e16);
            return null;
        }
    }

    public static ImageView G(final View view, final QCircleInitBean qCircleInitBean) {
        if (!com.tencent.biz.qqcircle.utils.k.g("exp_xsj_search_button", "exp_xsj_search_button_B")) {
            RFWLog.w("QFSSearchUtil", RFWLog.USR, "[tryInflateCommonSearchBtn] return: not hit exp");
            return null;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.va9);
        if (viewStub == null) {
            RFWLog.w("QFSSearchUtil", RFWLog.USR, "[tryInflateCommonSearchBtn] return: vsSearchBtn = null");
            return null;
        }
        ImageView imageView = (ImageView) viewStub.inflate();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(21);
            layoutParams2.rightMargin = cx.a(8.0f);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.D(QCircleInitBean.this, view, view2);
            }
        });
        d(imageView);
        return imageView;
    }

    public static void H(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (feedCloudMeta$StFeed.live.liveExtInfo.isEmpty()) {
            return;
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudMeta$StFeed.live.liveExtInfo.get()) {
            if (TextUtils.equals("live_status", feedCloudCommon$Entry.key.get())) {
                feedCloudCommon$Entry.value.set(String.valueOf(i3));
            }
        }
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + " " + str2;
    }

    public static void d(View view) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_BUTTON);
        VideoReport.setEventDynamicParams(view, new IDynamicParams() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.o
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map C;
                C = p.C(str);
                return C;
            }
        });
    }

    public static Map<String, String> e(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static e30.b f(Collection<e30.b> collection, String str) {
        FeedCloudMeta$StFeed c16;
        if (collection == null) {
            return null;
        }
        for (e30.b bVar : collection) {
            FeedCloudMeta$StFeed g16 = bVar.g();
            if (g16 != null) {
                if (TextUtils.equals(g16.f398449id.get(), str)) {
                    return bVar;
                }
                if (w(g16) && (c16 = com.tencent.biz.qqcircle.immersive.feed.ad.u.c(bVar)) != null && TextUtils.equals(c16.f398449id.get(), str)) {
                    return new e30.b(c16);
                }
            }
        }
        return null;
    }

    public static e30.b g(UIStateData<List<e30.b>> uIStateData, String str) {
        FeedCloudMeta$StFeed c16;
        if (uIStateData == null) {
            return null;
        }
        for (e30.b bVar : uIStateData.getData()) {
            FeedCloudMeta$StFeed g16 = bVar.g();
            if (g16 != null) {
                if (TextUtils.equals(g16.f398449id.get(), str)) {
                    return bVar;
                }
                if (w(g16) && (c16 = com.tencent.biz.qqcircle.immersive.feed.ad.u.c(bVar)) != null && TextUtils.equals(c16.f398449id.get(), str)) {
                    return new e30.b(c16);
                }
            }
        }
        return null;
    }

    private static String h() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_disable_search_correction_query_source_9115", "8,24");
    }

    @Nullable
    public static String i(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (!TextUtils.isEmpty(str) && feedCloudMeta$StFeed != null && !feedCloudMeta$StFeed.live.liveExtInfo.isEmpty()) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudMeta$StFeed.live.liveExtInfo.get()) {
                if (TextUtils.equals(str, feedCloudCommon$Entry.key.get())) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return null;
    }

    public static int j(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String i3 = i(feedCloudMeta$StFeed, "live_status");
        if (!TextUtils.isEmpty(i3)) {
            try {
                return Integer.parseInt(i3);
            } catch (NumberFormatException e16) {
                QLog.w("QFSSearchUtil", 1, e16.getMessage(), e16);
                return -1;
            }
        }
        return -1;
    }

    public static a k(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        a aVar = new a();
        aVar.f91280a = RFWVideoUtils.getPredictSpeedWithOutDownGrade(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        long j3 = (feedCloudMeta$StFeed.video.videoRate.get() / 1000) / 8;
        aVar.f91281b = j3;
        long j16 = aVar.f91280a;
        if (j16 > 4 * j3) {
            aVar.f91282c = 5;
        } else if (j16 > j3 * 2) {
            aVar.f91282c = 3;
        } else {
            aVar.f91282c = 1;
        }
        return aVar;
    }

    public static String l() {
        String str = f91278a.get(NetworkUtil.getSystemNetwork(QCircleApplication.getAPP()));
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        return str;
    }

    public static String m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str = feedCloudMeta$StFeed.video.playUrl.get();
        if (TextUtils.isEmpty(str) && y(feedCloudMeta$StFeed)) {
            if (feedCloudMeta$StFeed.live.room.isUseFlvUrl.get()) {
                return feedCloudMeta$StFeed.live.room.flvUrl.get();
            }
            return feedCloudMeta$StFeed.live.room.rtmpUrl.get();
        }
        return str;
    }

    public static String n() {
        return String.valueOf(QCircleReportHelper.getQQCirclePageStackNum());
    }

    public static Map<String, String> o(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.recomInfo.recomAttachInfo.get().toStringUtf8();
        } else {
            str = "";
        }
        return e(str);
    }

    public static long p(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return 0L;
        }
        String i3 = i(feedCloudMeta$StFeed, "live_roomid");
        if (!TextUtils.isEmpty(i3)) {
            try {
                return Long.parseLong(i3);
            } catch (NumberFormatException e16) {
                QLog.w("QFSSearchUtil", 1, e16.getMessage(), e16);
            }
        }
        return 0L;
    }

    public static QFSSearchBean q(Context context) {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            return null;
        }
        return (QFSSearchBean) qCircleInitBean;
    }

    public static String r() {
        return QCircleNativeSessionManager.g().getSession();
    }

    public static int s(Context context) {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            return 0;
        }
        return ((QFSSearchBean) qCircleInitBean).getUserSource();
    }

    public static int t(QCircleInitBean qCircleInitBean) {
        QCircleInitBean transInitBean;
        if (!(qCircleInitBean instanceof QCircleLayerBean) || (transInitBean = ((QCircleLayerBean) qCircleInitBean).getTransInitBean()) == null || !(transInitBean instanceof QFSSearchBean)) {
            return 0;
        }
        return ((QFSSearchBean) transInitBean).getUserSource();
    }

    public static boolean u(Context context, int i3) {
        if (context == null || context.hashCode() != i3) {
            return false;
        }
        return true;
    }

    private static void v() {
        String[] split = h().split(",");
        f91279b = new HashSet(split.length);
        for (String str : split) {
            try {
                f91279b.add(Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception unused) {
                RFWLog.w("QFSSearchUtil", RFWLog.USR, "[initDisableSearchCorrectionQuerySourceList] parseInt error, str=" + str);
            }
        }
    }

    public static boolean w(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.feedType.get() != 4) {
            return false;
        }
        return true;
    }

    public static boolean x(int i3) {
        return f91279b.contains(Integer.valueOf(i3));
    }

    public static boolean y(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (feedCloudMeta$StFeed.type.get() == 4) {
            return true;
        }
        return !TextUtils.isEmpty(i(feedCloudMeta$StFeed, "live_status"));
    }

    public static boolean z(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        Iterator<FeedCloudCommon$Entry> it = feedCloudMeta$StFeed.clientInfo.clientMap.get().iterator();
        while (it.hasNext()) {
            if (it.next().key.get().equals("is_single_hot_feed")) {
                return true;
            }
        }
        return false;
    }
}
