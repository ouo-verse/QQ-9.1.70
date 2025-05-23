package nk;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.qzone.reborn.intimate.event.QZIntimateVipInfoUpdateEvent;
import com.qzone.reborn.intimate.request.QZIntimateGetVipInfoRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qzone.qzoneUnifiedStore$GetMemberShipRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J2\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u00020\u0002H\u0016RD\u0010%\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u001dj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014`\u001e0\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010+\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R$\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010+\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/\u00a8\u0006E"}, d2 = {"Lnk/l;", "Lcom/qzone/reborn/base/n;", "", "avatarSettingStr", "", "W1", "praiseSettingStr", "X1", "vipGuideLinkStr", "Z1", "Lij/f;", "requestBean", "", "isSuccess", "", "retCode", "errMsg", "Lqzone/qzoneUnifiedStore$GetMemberShipRsp;", "rsp", "Q1", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "bean", "b2", "styleResourcesString", ICustomDataEditor.STRING_ARRAY_PARAM_2, "T1", "R1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "setVipInfoData", "(Landroidx/lifecycle/MutableLiveData;)V", "vipInfoData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getUserHasSweetPairVip", "setUserHasSweetPairVip", "userHasSweetPairVip", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getVip", "()Ljava/lang/String;", "setVip", "(Ljava/lang/String;)V", "vip", "Lorg/json/JSONObject;", "D", "Lorg/json/JSONObject;", "O1", "()Lorg/json/JSONObject;", "setAvatarSetting", "(Lorg/json/JSONObject;)V", "avatarSetting", "E", "getPraiseSetting", "setPraiseSetting", "praiseSetting", UserInfo.SEX_FEMALE, "getVipGuideLink", "setVipGuideLink", "vipGuideLink", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends com.qzone.reborn.base.n {

    /* renamed from: D, reason: from kotlin metadata */
    private JSONObject avatarSetting;

    /* renamed from: E, reason: from kotlin metadata */
    private String praiseSetting;

    /* renamed from: F, reason: from kotlin metadata */
    private String vipGuideLink;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<HashMap<String, QZIntimateSpaceVipInfoBean>> vipInfoData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> userHasSweetPairVip = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private String vip = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(l this$0, ij.f requestBean, BaseRequest baseRequest, boolean z16, long j3, String errMsg, qzoneUnifiedStore$GetMemberShipRsp qzoneunifiedstore_getmembershiprsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.Q1(requestBean, z16, j3, errMsg, qzoneunifiedstore_getmembershiprsp);
    }

    private final void W1(String avatarSettingStr) {
        if (TextUtils.isEmpty(avatarSettingStr)) {
            QLog.e("QZIntimateMainPageVipInfoViewModel", 1, "avatar setting is empty");
            return;
        }
        QLog.i("QZIntimateMainPageVipInfoViewModel", 1, "avatarSettingStr is " + avatarSettingStr);
        try {
            this.avatarSetting = new JSONObject(avatarSettingStr);
        } catch (Exception e16) {
            QLog.e("QZIntimateMainPageVipInfoViewModel", 1, "exception is " + e16);
        }
    }

    private final void X1(String praiseSettingStr) {
        if (TextUtils.isEmpty(praiseSettingStr)) {
            QLog.e("QZIntimateMainPageVipInfoViewModel", 1, "praiseSettingStr is empty");
            return;
        }
        QLog.i("QZIntimateMainPageVipInfoViewModel", 1, "praiseSettingStr is " + praiseSettingStr);
        this.praiseSetting = praiseSettingStr;
    }

    private final void Z1(String vipGuideLinkStr) {
        if (TextUtils.isEmpty(vipGuideLinkStr)) {
            QLog.e("QZIntimateMainPageVipInfoViewModel", 1, "vipGuideLinkStr is empty");
            return;
        }
        QLog.i("QZIntimateMainPageVipInfoViewModel", 1, "vipGuideLinkStr is " + vipGuideLinkStr);
        this.vipGuideLink = vipGuideLinkStr;
    }

    private final void b2(QZIntimateSpaceVipInfoBean bean) {
        bk.a.f28490a.g(bean);
    }

    /* renamed from: O1, reason: from getter */
    public final JSONObject getAvatarSetting() {
        return this.avatarSetting;
    }

    public final MutableLiveData<HashMap<String, QZIntimateSpaceVipInfoBean>> P1() {
        return this.vipInfoData;
    }

    public final void R1() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        final int i3 = 1383;
        tianShuAdPosItemData.mPosId = 1383;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, new TianShuGetAdvCallback() { // from class: nk.j
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                l.S1(i3, z16, getAdsRsp);
            }
        });
    }

    public final void T1(final ij.f requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (gd.a.f401926a.c("KEY_MAIN_PAGE_VIP", false)) {
            QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean = new QZIntimateSpaceVipInfoBean();
            qZIntimateSpaceVipInfoBean.t(requestBean.getSpaceId());
            HashMap<String, QZIntimateSpaceVipInfoBean> value = this.vipInfoData.getValue();
            if (value == null) {
                value = new HashMap<>();
            }
            JSONObject jSONObject = this.avatarSetting;
            qZIntimateSpaceVipInfoBean.p(String.valueOf(jSONObject != null ? jSONObject.getString("manage_avatar") : null));
            JSONObject jSONObject2 = this.avatarSetting;
            qZIntimateSpaceVipInfoBean.o(String.valueOf(jSONObject2 != null ? jSONObject2.getString("space_avatar") : null));
            JSONObject jSONObject3 = this.avatarSetting;
            qZIntimateSpaceVipInfoBean.m(String.valueOf(jSONObject3 != null ? jSONObject3.getString("feed_avatar") : null));
            String str = this.praiseSetting;
            if (str == null) {
                str = "";
            }
            qZIntimateSpaceVipInfoBean.n(str);
            qZIntimateSpaceVipInfoBean.r(0);
            value.put(requestBean.getSpaceId(), qZIntimateSpaceVipInfoBean);
            b2(qZIntimateSpaceVipInfoBean);
            this.vipInfoData.postValue(value);
            if (qZIntimateSpaceVipInfoBean.k()) {
                SimpleEventBus.getInstance().dispatchEvent(new QZIntimateVipInfoUpdateEvent(qZIntimateSpaceVipInfoBean));
                return;
            }
            return;
        }
        sendRequest(new QZIntimateGetVipInfoRequest(requestBean.getSpaceId()), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.k
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                l.U1(l.this, requestBean, baseRequest, z16, j3, str2, (qzoneUnifiedStore$GetMemberShipRsp) obj);
            }
        });
    }

    public final void a2(String styleResourcesString) {
        Intrinsics.checkNotNullParameter(styleResourcesString, "styleResourcesString");
        if (TextUtils.isEmpty(styleResourcesString)) {
            QLog.e("QZIntimateMainPageVipInfoViewModel", 1, "styleResourcesString is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(styleResourcesString).getJSONObject("vip");
            String jSONObject2 = jSONObject.getJSONObject("avatar").toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject(JSON_AVATAR).toString()");
            W1(jSONObject2);
            String string = jSONObject.getString("praise_anim");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(JSON_PRAISE)");
            X1(string);
            String string2 = jSONObject.getString("vip_guide_link");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(JSON_VIP_GUIDE_LINK)");
            Z1(string2);
        } catch (Exception e16) {
            QLog.e("QZIntimateMainPageVipInfoViewModel", 1, "exception is " + e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZIntimateMainPageVipInfoViewModel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(int i3, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        if (getAdsRsp == null) {
            return;
        }
        List<TianShuAccess.RspEntry> ads = getAdsRsp.mapAds.get();
        Intrinsics.checkNotNullExpressionValue(ads, "ads");
        for (TianShuAccess.RspEntry rspEntry : ads) {
            if (rspEntry.key.get() == i3 && (pBRepeatMessageField = (adPlacementInfo = rspEntry.value.get()).lst) != null && pBRepeatMessageField.size() > 0) {
                TianShuAccess.AdItem adItem = adPlacementInfo.lst.get(0);
                Intrinsics.checkNotNullExpressionValue(adItem, "infos.lst.get(0)");
                TianShuAccess.AdItem adItem2 = adItem;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SsoReporter.POS_ID_KEY, i3);
                jSONObject.put("ad_id", adItem2.iAdId.get());
                jSONObject.put("trace_info", adItem2.traceinfo.get());
                List<TianShuAccess.MapEntry> list = adItem2.argList.get();
                Intrinsics.checkNotNullExpressionValue(list, "adItem.argList.get()");
                for (TianShuAccess.MapEntry mapEntry : list) {
                    jSONObject.put(mapEntry.key.get(), mapEntry.value.get());
                }
                IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "param.toString()");
                iVasKuiklyApi.setMqqToKuiklyData("vas_ad_qid", jSONObject2);
                String kuiklyUrl = jSONObject.getString("kuikly_url");
                IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                BaseApplication baseApplication = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(kuiklyUrl, "kuiklyUrl");
                iVasHybridRoute.openSchema(baseApplication, kuiklyUrl);
                return;
            }
        }
    }

    private final void Q1(ij.f requestBean, boolean isSuccess, long retCode, String errMsg, qzoneUnifiedStore$GetMemberShipRsp rsp) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        if (isSuccess && rsp != null && retCode == 0) {
            QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean = new QZIntimateSpaceVipInfoBean();
            qZIntimateSpaceVipInfoBean.t(requestBean.getSpaceId());
            qZIntimateSpaceVipInfoBean.u(requestBean.getSpaceType());
            JSONObject jSONObject = this.avatarSetting;
            if (jSONObject == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(jSONObject != null ? jSONObject.getString("manage_avatar") : null);
            }
            qZIntimateSpaceVipInfoBean.p(valueOf);
            JSONObject jSONObject2 = this.avatarSetting;
            if (jSONObject2 == null) {
                valueOf2 = "";
            } else {
                valueOf2 = String.valueOf(jSONObject2 != null ? jSONObject2.getString("space_avatar") : null);
            }
            qZIntimateSpaceVipInfoBean.o(valueOf2);
            JSONObject jSONObject3 = this.avatarSetting;
            if (jSONObject3 == null) {
                valueOf3 = "";
            } else {
                valueOf3 = String.valueOf(jSONObject3 != null ? jSONObject3.getString("feed_avatar") : null);
            }
            qZIntimateSpaceVipInfoBean.m(valueOf3);
            String str = this.praiseSetting;
            qZIntimateSpaceVipInfoBean.n(str != null ? str : "");
            qZIntimateSpaceVipInfoBean.r(rsp.member_ship.member_status.get());
            String str2 = rsp.member_ship.member_code.get();
            Intrinsics.checkNotNullExpressionValue(str2, "rsp.member_ship.member_code.get()");
            qZIntimateSpaceVipInfoBean.q(str2);
            qZIntimateSpaceVipInfoBean.l(rsp.member_ship.expiration_time.get());
            qZIntimateSpaceVipInfoBean.s(rsp.member_ship.remain_signing.get());
            HashMap<String, QZIntimateSpaceVipInfoBean> value = this.vipInfoData.getValue();
            if (value == null) {
                value = new HashMap<>();
            }
            value.put(requestBean.getSpaceId(), qZIntimateSpaceVipInfoBean);
            b2(qZIntimateSpaceVipInfoBean);
            this.vipInfoData.postValue(value);
            if (qZIntimateSpaceVipInfoBean.k()) {
                SimpleEventBus.getInstance().dispatchEvent(new QZIntimateVipInfoUpdateEvent(qZIntimateSpaceVipInfoBean));
                return;
            }
            return;
        }
        QLog.e("QZIntimateMainPageVipInfoViewModel", 1, "handleGetMemberShipRsp rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
    }
}
