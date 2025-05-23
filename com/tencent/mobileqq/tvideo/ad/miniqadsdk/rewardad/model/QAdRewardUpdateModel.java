package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model;

import com.google.gson.JsonObject;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.loader.a;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.QAdRewardBusinessConst$ContentUnlockKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.RewardVrReportData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardFunnelReport;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdRequestContextInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateRequest;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateResponse;
import dx2.g;
import fx2.b;
import hx2.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import pw2.i;
import pw2.n;
import pw2.r;
import pw2.w;
import pw2.y;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00010B\u0011\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\bJ\u0010HJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J7\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00072\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJC\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\n2\u0006\u0010\u0017\u001a\u00020\u00072\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J \u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!H\u0002J!\u0010&\u001a\u00020\r\"\b\b\u0000\u0010$*\u00020#2\b\u0010%\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b&\u0010'J\u001c\u0010)\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u001c\u0010/\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00104R\u0016\u00109\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R \u0010C\u001a\f\u0012\u0006\b\u0001\u0012\u00020#\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010BR$\u0010I\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardUpdateModel;", "Lpv2/a;", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateRequest;", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateResponse;", "Lcom/tencent/ams/xsad/rewarded/loader/a;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", HippyTKDListViewAdapter.X, "j", "", "o", "response", "", "u", "errorCode", "errorMsg", "v", "i", "g", "k", "", "p", "requestStatus", "commonParams", "l", "(ILjava/util/Map;Ljava/lang/Integer;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(ILjava/util/Map;Ljava/lang/Integer;)Ljava/util/Map;", "", h.F, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "y", "Lfx2/b;", "T", "adLoadInfo", "r", "(Lfx2/b;)V", Const.BUNDLE_KEY_REQUEST, "t", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "rewardAd", "Lcom/tencent/ams/xsad/rewarded/loader/a$a;", "loadHander", "c", "a", "Lcom/tencent/ams/xsad/rewarded/loader/a$a;", "mLoadListener", "b", "I", "mRequestId", "mTimeOutStatus", "d", "J", "mTimeRequestStart", "", "e", "Ljava/util/List;", "mRequestIdList", "f", "Lfx2/b;", "mAdLoadInfo", "Ldx2/b;", "Ldx2/b;", "mDataGenerator", "Ljava/lang/Integer;", DomainData.DOMAIN_NAME, "()Ljava/lang/Integer;", "setOrientation", "(Ljava/lang/Integer;)V", "orientation", "<init>", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class QAdRewardUpdateModel implements pv2.a<RewardAdNewUpdateRequest, RewardAdNewUpdateResponse>, com.tencent.ams.xsad.rewarded.loader.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a.InterfaceC0704a mLoadListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mTimeOutStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile long mTimeRequestStart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b mAdLoadInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private dx2.b<? extends b> mDataGenerator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer orientation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mRequestId = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<Integer> mRequestIdList = new ArrayList();

    public QAdRewardUpdateModel(@Nullable Integer num) {
        this.orientation = num;
    }

    private final synchronized void g(int requestId) {
        this.mRequestIdList.add(Integer.valueOf(requestId));
    }

    private final synchronized long h() {
        return System.currentTimeMillis() - this.mTimeRequestStart;
    }

    private final synchronized void i() {
        this.mRequestIdList.clear();
    }

    private final RewardAdNewUpdateRequest j(String requestId) {
        String str;
        HashMap<String, String> a16;
        String it;
        Map<String, String> o16 = o();
        if (o16 == null) {
            o16 = new HashMap<>();
        }
        b bVar = this.mAdLoadInfo;
        if (bVar != null && (a16 = bVar.a()) != null && (it = a16.get("dynamic_ad_request_id")) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            o16.put("dynamic_ad_request_id", it);
        }
        ModuleInfo c16 = com.tencent.ams.xsad.rewarded.dynamic.b.c();
        if (c16 != null) {
            str = c16.getVersion();
        } else {
            str = null;
        }
        if (str != null) {
            o16.put("dynamic_version", str);
        }
        AdRequestContextInfo requestInfo = r.d(requestId, null);
        dx2.b<? extends b> bVar2 = this.mDataGenerator;
        if (bVar2 == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(requestInfo, "requestInfo");
        return bVar2.a(requestInfo);
    }

    private final void k(String requestId) {
        Map<String, Object> map;
        RewardVrReportData mVrReportData;
        b bVar = this.mAdLoadInfo;
        if (bVar != null && (mVrReportData = bVar.getMVrReportData()) != null) {
            map = mVrReportData.b();
        } else {
            map = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.putAll(p(requestId));
        w.i(QAdVrReport.ReportEvent.AD_RW_TERMINAL_SENDRQST_SSP_REQUEST, linkedHashMap);
    }

    private final void l(int requestStatus, Map<String, String> commonParams, Integer errorCode) {
        Map<String, Object> map;
        RewardVrReportData mVrReportData;
        b bVar = this.mAdLoadInfo;
        if (bVar != null && (mVrReportData = bVar.getMVrReportData()) != null) {
            map = mVrReportData.b();
        } else {
            map = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.putAll(q(requestStatus, commonParams, errorCode));
        w.i(QAdVrReport.ReportEvent.AD_RW_TERMINAL_RECEIVE_VSSP, linkedHashMap);
    }

    private final Map<String, String> m(RewardAdNewUpdateResponse response) {
        AdOrderItem b16 = c.f406571a.b(response);
        if (b16 != null) {
            return QAdVrReport.b(b16);
        }
        return null;
    }

    private final Map<String, String> o() {
        RewardVrReportData mVrReportData;
        b bVar = this.mAdLoadInfo;
        if (bVar != null && (mVrReportData = bVar.getMVrReportData()) != null) {
            return mVrReportData.a();
        }
        return null;
    }

    private final Map<String, Object> p(String requestId) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("business", "ad");
        if (requestId != null) {
            linkedHashMap.put("ad_request_id", requestId);
        }
        return linkedHashMap;
    }

    private final Map<String, Object> q(int requestStatus, Map<String, String> commonParams, Integer errorCode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(VRReportDefine$ReportParam.IS_SUCCESS, Integer.valueOf(requestStatus));
        linkedHashMap.put(VRReportDefine$ReportParam.IS_TIMEOUT, Integer.valueOf(this.mTimeOutStatus));
        linkedHashMap.put(VRReportDefine$ReportParam.TIME_CONSUMING, Long.valueOf(h()));
        if (commonParams != null) {
            linkedHashMap.putAll(commonParams);
        }
        if (errorCode != null) {
            linkedHashMap.put("error_code", Integer.valueOf(errorCode.intValue()));
        }
        return linkedHashMap;
    }

    private final void u(final RewardAdNewUpdateResponse response) {
        n.e("[RewardAd]QAdRewardUpdateModel", "processResponse");
        i();
        if (response != null && (!y.h(response.reward_info_list) || response.unlocked_info != null)) {
            l(1, m(response), null);
            c cVar = c.f406571a;
            if (cVar.i(response)) {
                n.e("[RewardAd]QAdRewardUpdateModel", "onPbResponseSucc, has reach frequency");
                v(1005, cVar.d(response));
                return;
            }
            dx2.b<? extends b> bVar = this.mDataGenerator;
            if (bVar != null && bVar.b(response.unlocked_info)) {
                n.e("[RewardAd]QAdRewardUpdateModel", "onPbResponseSucc, has unlock");
                v(1002, i.s(response.unlocked_info));
                return;
            } else {
                QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardUpdateModel$processResponse$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.InterfaceC0704a interfaceC0704a;
                        Map<String, String> map;
                        Map<? extends String, ? extends String> y16;
                        Map<String, Object> map2;
                        RewardedAdData e16 = g.f395163a.e(QAdRewardUpdateModel.this.getOrientation(), response);
                        if (e16 != null && (map2 = e16.f71702p) != null) {
                            map2.put(QAdRewardDefine$VideoParams.UNLOCK_INFO, response.unlocked_info);
                        }
                        if (e16 != null && (map = e16.f71704r) != null) {
                            y16 = QAdRewardUpdateModel.this.y();
                            map.putAll(y16);
                        }
                        interfaceC0704a = QAdRewardUpdateModel.this.mLoadListener;
                        if (interfaceC0704a != null) {
                            interfaceC0704a.b(null, e16);
                        }
                        QAdRewardUpdateModel.this.mLoadListener = null;
                    }
                });
                return;
            }
        }
        n.e("[RewardAd]QAdRewardUpdateModel", "onPbResponseSucc, response is null");
        l(0, null, 1001);
        v(1001, "response params error");
    }

    private final void v(final int errorCode, final String errorMsg) {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardUpdateModel$pushLoadAdFail$1
            @Override // java.lang.Runnable
            public final void run() {
                a.InterfaceC0704a interfaceC0704a;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("code", Integer.valueOf(errorCode));
                jsonObject.addProperty("message", errorMsg);
                RewardedAdError rewardedAdError = new RewardedAdError(errorCode, jsonObject.toString());
                interfaceC0704a = QAdRewardUpdateModel.this.mLoadListener;
                if (interfaceC0704a != null) {
                    interfaceC0704a.c(null, rewardedAdError.toString());
                }
                QAdRewardUpdateModel.this.mLoadListener = null;
            }
        });
    }

    private final synchronized void w() {
        this.mTimeOutStatus = 0;
        this.mTimeRequestStart = 0L;
    }

    private final int x(String requestId) {
        w();
        RewardAdNewUpdateRequest j3 = j(requestId);
        k(requestId);
        QAdRewardFunnelReport.f304329b.b();
        return ev2.i.b(j3, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> y() {
        ex2.a mSwitchAdInnerInfo;
        HashMap hashMap = new HashMap();
        b bVar = this.mAdLoadInfo;
        if (bVar != null && (mSwitchAdInnerInfo = bVar.getMSwitchAdInnerInfo()) != null) {
            hashMap.put(QAdRewardBusinessConst$ContentUnlockKey.totalAdNum, String.valueOf(mSwitchAdInnerInfo.getTotal()));
            hashMap.put(QAdRewardBusinessConst$ContentUnlockKey.processAdNum, String.valueOf(mSwitchAdInnerInfo.getProcess()));
        }
        return hashMap;
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.a
    public void c(@Nullable final RewardedAd rewardAd, @Nullable a.InterfaceC0704a loadHander) {
        Object obj;
        RewardedAd.a i3;
        Map<String, Object> map;
        n.e("[RewardAd]QAdRewardUpdateModel", "start loadAsync");
        this.mLoadListener = loadHander;
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardUpdateModel$loadAsync$1
            @Override // java.lang.Runnable
            public final void run() {
                a.InterfaceC0704a interfaceC0704a;
                interfaceC0704a = QAdRewardUpdateModel.this.mLoadListener;
                if (interfaceC0704a != null) {
                    interfaceC0704a.a(rewardAd);
                }
            }
        });
        Object obj2 = null;
        if (rewardAd != null && (i3 = rewardAd.i()) != null && (map = i3.f71682d) != null) {
            obj = map.get(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            obj2 = obj;
        }
        g(this.mRequestId);
        this.mRequestId = x((String) obj2);
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final Integer getOrientation() {
        return this.orientation;
    }

    public final <T extends b> void r(@Nullable T adLoadInfo) {
        this.mAdLoadInfo = adLoadInfo;
        this.mDataGenerator = dx2.c.f395159a.b(adLoadInfo);
    }

    @Override // pv2.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void b(@Nullable RewardAdNewUpdateRequest request, @Nullable RewardAdNewUpdateResponse response, int errorCode) {
        n.e("[RewardAd]QAdRewardUpdateModel", "onPbResponseFail, errorCode = " + errorCode);
        l(0, null, Integer.valueOf(errorCode));
        if (c.f406571a.j(errorCode)) {
            this.mTimeOutStatus = 1;
            v(1003, "request outOfTime");
        } else {
            v(1000, "network error code = " + errorCode);
        }
    }

    @Override // pv2.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void a(@Nullable RewardAdNewUpdateRequest request, @Nullable RewardAdNewUpdateResponse response) {
        u(response);
    }
}
