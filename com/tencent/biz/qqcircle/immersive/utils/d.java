package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.request.QFSUserActionReportRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qqcircle.QQCircleCommercialDataworksReport$UserActionReportReq;
import qqcircle.QQCircleCommercialDataworksReport$UserActionReportRsp;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\bJ \u0010\u001b\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u001e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002J \u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010(R&\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\n0*j\b\u0012\u0004\u0012\u00020\n`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,R\u0016\u00100\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00103R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/d;", "", "", "actionType", "subActionType", "Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;", "extraTypeInfo", "feedType2", "", tl.h.F, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "l", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "d", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "i", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "ad", "c", "key", "value", DomainData.DOMAIN_NAME, "k", "jsonKey", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "action", "feedPosition", "f", "url", "", "selectTime", "unSelectTime", "j", "b", "Ljava/lang/String;", "mRequestId", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mProcessorProxy", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mReportedAdSet", "e", "J", "mLastExposeReportTime", "Ljava/util/concurrent/ConcurrentHashMap;", "Lorg/json/JSONObject;", "Ljava/util/concurrent/ConcurrentHashMap;", "mAttachParamsMap", "g", "Lorg/json/JSONObject;", "mStyleParams", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long mLastExposeReportTime;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f90201a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mRequestId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GdtThirdProcessorProxy mProcessorProxy = new GdtThirdProcessorProxy();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashSet<String> mReportedAdSet = new HashSet<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, JSONObject> mAttachParamsMap = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static JSONObject mStyleParams = new JSONObject();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/immersive/utils/d$a", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqqcircle/QQCircleCommercialDataworksReport$UserActionReportRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "response", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleCommercialDataworksReport$UserActionReportRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f90208a;

        a(int i3) {
            this.f90208a = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@NotNull BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable QQCircleCommercialDataworksReport$UserActionReportRsp response) {
            Intrinsics.checkNotNullParameter(request, "request");
            QLog.d("QFSAdReportUtils", 1, "[reportAdEvent] onReceive: action=" + this.f90208a + ", traceId=" + request.getTraceId() + ", isSuccess=" + isSuccess + ", retCode=" + retCode + ", errMsg=" + errMsg);
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String reportUrl) {
        Intrinsics.checkNotNullParameter(reportUrl, "$reportUrl");
        try {
            URLConnection openConnection = new URL(reportUrl).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
            QLog.i("QFSAdReportUtils", 1, "reportAd rspCode" + httpURLConnection.getResponseCode());
        } catch (Throwable th5) {
            QLog.e("QFSAdReportUtils", 1, "reportAd error, url = " + reportUrl, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(GdtAd ad5, int i3, Ref.ObjectRef attach, int i16) {
        Intrinsics.checkNotNullParameter(ad5, "$ad");
        Intrinsics.checkNotNullParameter(attach, "$attach");
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101583", true)) {
            QQCircleCommercialDataworksReport$UserActionReportReq qQCircleCommercialDataworksReport$UserActionReportReq = new QQCircleCommercialDataworksReport$UserActionReportReq();
            qQCircleCommercialDataworksReport$UserActionReportReq.busi_type.set(j.f90213a.p(String.valueOf(ad5.getPosId())));
            qQCircleCommercialDataworksReport$UserActionReportReq.adid.set(String.valueOf(ad5.getAId()));
            qQCircleCommercialDataworksReport$UserActionReportReq.action_time.set(System.currentTimeMillis() / 1000);
            qQCircleCommercialDataworksReport$UserActionReportReq.feeds_index.set(i3);
            qQCircleCommercialDataworksReport$UserActionReportReq.attachment.set((String) attach.element);
            qQCircleCommercialDataworksReport$UserActionReportReq.adpos_id.set(String.valueOf(ad5.getPosId()));
            qQCircleCommercialDataworksReport$UserActionReportReq.trace_id.set(String.valueOf(ad5.getTraceId()));
            qQCircleCommercialDataworksReport$UserActionReportReq.action_type.set(i16);
            VSNetworkHelper.getInstance().sendRequest(new QFSUserActionReportRequest(qQCircleCommercialDataworksReport$UserActionReportReq), new a(i16));
            return;
        }
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(j.f90213a.p(String.valueOf(ad5.getPosId())));
        build.setAid(String.valueOf(ad5.getAId()));
        build.setActionType(i16);
        build.setActionTime(System.currentTimeMillis() / 1000);
        build.setFeedsIndex(i3);
        build.setAdPosId(String.valueOf(ad5.getPosId()));
        build.setTraceId(String.valueOf(ad5.getTraceId()));
        build.setAttachment((String) attach.element);
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }

    public final void c(@NotNull FeedCloudMeta$StFeed feed, @NotNull GdtAd ad5) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        String traceId = ad5.getTraceId();
        if (traceId != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", HostDataTransUtils.getAccount());
            jSONObject.put("platform", "android");
            jSONObject.put("app_version", AppSetting.f99551k);
            jSONObject.put("style", "");
            jSONObject.put("xsj_feed_id", feed.f398449id.get());
            jSONObject.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            jSONObject.put("adpos_id", ad5.getPosId());
            jSONObject.put("adgroup_id", String.valueOf(ad5.getAId()));
            jSONObject.put("trace_id", traceId);
            jSONObject.put("action", "0");
            mAttachParamsMap.put(traceId, jSONObject);
        }
        mStyleParams = new JSONObject();
    }

    public final void d(@NotNull final String reportUrl) {
        Intrinsics.checkNotNullParameter(reportUrl, "reportUrl");
        if (TextUtils.isEmpty(reportUrl)) {
            QLog.e("QFSAdReportUtils", 1, "reportAd cancel, url is empty");
        } else {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(reportUrl);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object, java.lang.String] */
    public final void f(@NotNull final GdtAd ad5, final int action, final int feedPosition) {
        String traceId;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        if (action == 3 && (traceId = ad5.getTraceId()) != null) {
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = mAttachParamsMap;
            JSONObject jSONObject = concurrentHashMap.get(traceId);
            if (jSONObject != null) {
                jSONObject.put("event_time", String.valueOf(System.currentTimeMillis()));
            }
            JSONObject jSONObject2 = concurrentHashMap.get(traceId);
            if (jSONObject2 != null) {
                jSONObject2.put("style", mStyleParams.toString());
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (action == 3) {
            try {
                JSONObject jSONObject3 = mAttachParamsMap.get(ad5.getTraceId());
                if (jSONObject3 != null) {
                    ?? jSONObject4 = jSONObject3.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "it.toString()");
                    objectRef.element = jSONObject4;
                }
            } catch (Exception e16) {
                QLog.e("QFSAdReportUtils", 1, "reportAdEvent error ", e16);
            }
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                d.g(GdtAd.this, feedPosition, objectRef, action);
            }
        });
    }

    public final void h(int actionType, int subActionType, @Nullable QCircleExtraTypeInfo extraTypeInfo, int feedType2) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (extraTypeInfo != null) {
            feedCloudMeta$StFeed = extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSAdReportUtils", 1, "extraTypeInfo is null or lost feed,actionType:" + actionType + ",subActionType:" + subActionType);
            return;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(extraTypeInfo.mFeed));
        dataBuilder.setActionType(actionType).setSubActionType(subActionType).setPosition(extraTypeInfo.mDataPosition).setPlayScene(extraTypeInfo.mPlayScene).setSealTransfer(extraTypeInfo.mFeed.recomInfo.recomTrace.get()).setRequestId(mRequestId).setFeedType1(5).setFeedType2(feedType2);
        QCircleLpReportDc05507.report(dataBuilder);
    }

    public final void i(@Nullable GdtAd gdtAd) {
        String str;
        boolean contains;
        String traceId;
        HashSet<String> hashSet = mReportedAdSet;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = null;
        if (gdtAd != null) {
            str = gdtAd.getTraceId();
        } else {
            str = null;
        }
        contains = CollectionsKt___CollectionsKt.contains(hashSet, str);
        if (contains) {
            QLog.e("QFSAdReportUtils", 1, "ad has Exposed, cancel expose");
            return;
        }
        if (mReportedAdSet.size() > 200) {
            mReportedAdSet.clear();
        }
        if (gdtAd != null && (traceId = gdtAd.getTraceId()) != null) {
            mReportedAdSet.add(traceId);
        }
        GdtThirdProcessorProxy gdtThirdProcessorProxy = mProcessorProxy;
        if (gdtAd != null) {
            adInfo = gdtAd.info;
        }
        gdtThirdProcessorProxy.c2sReportAsync(2, 4, adInfo);
    }

    public final void j(@Nullable String url, long selectTime, long unSelectTime) {
        String replace$default;
        String replace$default2;
        QLog.e("QFSAdReportUtils", 2, "url is " + url + "first " + selectTime + "last " + unSelectTime);
        if (url == null) {
            QLog.e("QFSAdReportUtils", 1, "url is null, cancel reportAdShowTime");
            return;
        }
        if (selectTime != 0 && unSelectTime != 0) {
            if (System.currentTimeMillis() - mLastExposeReportTime < 900) {
                QLog.e("QFSAdReportUtils", 1, "time limit, cancel reportAdShowTime");
                return;
            }
            mLastExposeReportTime = System.currentTimeMillis();
            replace$default = StringsKt__StringsJVMKt.replace$default(url, "__S_TS__", String.valueOf(selectTime), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "__E_TS__", String.valueOf(unSelectTime), false, 4, (Object) null);
            d(replace$default2);
            return;
        }
        QLog.e("QFSAdReportUtils", 1, "time error, cancel reportAdShowTime");
    }

    public final void k() {
        mStyleParams = new JSONObject();
    }

    public final void l(@NotNull String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        mRequestId = requestId;
    }

    public final void m(@Nullable String key, @NotNull String jsonKey, @NotNull String value) {
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        Intrinsics.checkNotNullParameter(value, "value");
        if (TextUtils.isEmpty(key)) {
            QLog.e("QFSAdReportUtils", 1, "[updateAttachParams] key: " + key, new NullPointerException());
            return;
        }
        JSONObject jSONObject = mAttachParamsMap.get(key);
        if (jSONObject != null) {
            jSONObject.put(jsonKey, value);
        }
    }

    public final void n(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        mStyleParams.put(key, value);
    }
}
