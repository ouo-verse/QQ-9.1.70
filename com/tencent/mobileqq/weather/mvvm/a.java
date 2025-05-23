package com.tencent.mobileqq.weather.mvvm;

import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdLoadHelper;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdReportHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R*\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR*\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR&\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001ej\b\u0012\u0004\u0012\u00020\u0012`\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R2\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\"j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/a;", "", "", "e", "g", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "Lcom/tencent/mobileqq/weather/mvvm/a$a;", "adListener", "f", "", "needRequestMask", tl.h.F, "", "c", "d", "", "aid", "b", "Ljava/lang/String;", "mMaskPosId", "mTianShuPosId", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mMaskAdInfoList", "mTianShuAdInfoList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mCachedAidSet", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mCachedFilePathMap", "<init>", "()V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f313393a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mMaskPosId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mTianShuPosId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ArrayList<JSONObject> mMaskAdInfoList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ArrayList<JSONObject> mTianShuAdInfoList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashSet<Long> mCachedAidSet;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<Long, String> mCachedFilePathMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/a$a;", "", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAds", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.mvvm.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8965a {
        void a(@NotNull List<? extends GdtAd> gdtAds, @Nullable access.UserActionReportInfo userActionReportInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/weather/mvvm/a$b", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "", "msg", "", "onRsp", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements VasAdCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC8965a f313400a;

        b(InterfaceC8965a interfaceC8965a) {
            this.f313400a = interfaceC8965a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) interfaceC8965a);
            }
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp rsp, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(retCode), rsp, msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("WeatherAdReqManager", 1, "reqFirstScreenAd onRsp");
            a.f313393a.f(retCode, rsp, this.f313400a);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31191);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f313393a = new a();
        mCachedAidSet = new HashSet<>();
        mCachedFilePathMap = new HashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e() {
        ArrayList<JSONObject> arrayList = mMaskAdInfoList;
        if (arrayList != null) {
            Iterator<JSONObject> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong = next.optLong("aid", 0L);
                if (optLong != 0) {
                    mCachedAidSet.add(Long.valueOf(optLong));
                    HashMap<Long, String> hashMap = mCachedFilePathMap;
                    Long valueOf = Long.valueOf(optLong);
                    String optString = next.optString(AdHippyFragment.RES_PATH, "");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(RES_PATH, \"\")");
                    hashMap.put(valueOf, optString);
                }
            }
        }
        ArrayList<JSONObject> arrayList2 = mTianShuAdInfoList;
        if (arrayList2 != null) {
            Iterator<JSONObject> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                JSONObject next2 = it5.next();
                long optLong2 = next2.optLong("aid", 0L);
                if (optLong2 != 0) {
                    mCachedAidSet.add(Long.valueOf(optLong2));
                    HashMap<Long, String> hashMap2 = mCachedFilePathMap;
                    Long valueOf2 = Long.valueOf(optLong2);
                    String optString2 = next2.optString(AdHippyFragment.RES_PATH, "");
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(RES_PATH, \"\")");
                    hashMap2.put(valueOf2, optString2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:53:0x0041, B:55:0x0045, B:57:0x0049, B:17:0x0055, B:18:0x005e, B:20:0x0065, B:22:0x0071, B:30:0x007e, B:26:0x0093, B:35:0x00b2, B:38:0x00c4, B:39:0x00bc, B:40:0x00c7, B:42:0x00d7, B:44:0x00db, B:45:0x00df), top: B:52:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(int retCode, access.AdGetRsp rsp, InterfaceC8965a adListener) {
        String str;
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
        PBStringField pBStringField;
        access.UserActionReportInfo userActionReportInfo;
        access.RetMsg retMsg;
        PBStringField pBStringField2;
        String str2 = null;
        if (rsp != null && (retMsg = rsp.ret_msg) != null && (pBStringField2 = retMsg.err_msg) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        QLog.d("WeatherAdReqManager", 1, "onAdRsp retCode:" + retCode + ", retMsg:" + str);
        if (retCode != 0 && adListener != null) {
            adListener.a(new ArrayList<>(), null);
        }
        if (rsp != null) {
            try {
                qq_ad_get.QQAdGetRsp qQAdGetRsp = rsp.qq_ad_get_rsp;
                if (qQAdGetRsp != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null) {
                    list = pBRepeatMessageField.get();
                    if (list != null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo : list) {
                        if (posAdInfo.has() && !posAdInfo.ads_info.get().isEmpty()) {
                            arrayList.add(new GdtAd(posAdInfo.ads_info.get().get(0)));
                        }
                        QLog.d("WeatherAdReqManager", 2, "show maskAd, adInfo inValid\uff0cpos_id is" + posAdInfo.pos_id.get());
                    }
                    if (adListener != null) {
                        if (rsp.action_report_infos.isEmpty()) {
                            userActionReportInfo = null;
                        } else {
                            userActionReportInfo = rsp.action_report_infos.get(0);
                        }
                        adListener.a(arrayList, userActionReportInfo);
                    }
                    com.tencent.mobileqq.weather.b a16 = com.tencent.mobileqq.weather.b.a();
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
                    access.RetMsg retMsg2 = rsp.ret_msg;
                    if (retMsg2 != null && (pBStringField = retMsg2.err_msg) != null) {
                        str2 = pBStringField.get();
                    }
                    a16.c(appInterface, retCode, str2);
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("WeatherAdReqManager", 1, "onAdRsp parse ad error:", th5);
                return;
            }
        }
        list = null;
        if (list != null) {
        }
    }

    private final void g() {
        MaskAdReportHelper.INSTANCE.reportAction("new_folder_splashad_requestwithsource", "", "", "1", "");
    }

    @Nullable
    public final String b(long aid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, aid);
        }
        return mCachedFilePathMap.get(Long.valueOf(aid));
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return mMaskPosId;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return mTianShuPosId;
    }

    public final void h(@Nullable InterfaceC8965a adListener, boolean needRequestMask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, adListener, Boolean.valueOf(needRequestMask));
            return;
        }
        QLog.d("WeatherAdReqManager", 1, "reqFirstScreenAd");
        mMaskPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherFirstPosId();
        mTianShuPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherTianShuPosId();
        IVasMaskAdvPreloadApi iVasMaskAdvPreloadApi = (IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class);
        MaskAdvName maskAdvName = MaskAdvName.QQ_WEATHER;
        mMaskAdInfoList = iVasMaskAdvPreloadApi.getMaskAdInfoList(maskAdvName);
        mTianShuAdInfoList = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.TIANSHU);
        e();
        b bVar = new b(adListener);
        com.tencent.mobileqq.weather.util.h.f313657a.d();
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        ArrayList<String> advPos = build.getAdvPos();
        String str = mMaskPosId;
        Intrinsics.checkNotNull(str);
        advPos.add(str);
        build.getAdvPos().add(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherSecondPosId());
        ArrayList<String> advPos2 = build.getAdvPos();
        String str2 = mTianShuPosId;
        Intrinsics.checkNotNull(str2);
        advPos2.add(str2);
        build.setUin(MaskAdLoadHelper.INSTANCE.getCurrentUin());
        build.setBusiType(10);
        if (needRequestMask) {
            build.setSpecifiedAdsJsonList(mMaskAdInfoList);
            build.setSpecifiedTianShuAdsJsonList(mTianShuAdInfoList);
            build.setTargetPosId(mMaskPosId);
            build.setTianShuPosId(mTianShuPosId);
        }
        build.setDisableMaskReq(com.tencent.mobileqq.vas.adv.maskad.a.f308093a.b());
        iVasAdvApi.requestAd(build, bVar);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AdHippyFragment.AID_SET, mCachedAidSet.toString());
        com.tencent.mobileqq.weather.util.g.f313646a.Q(maskAdvName, AdHippyFragment.MASK_AD_DISPLAY_REQUEST_START, jSONObject);
        com.tencent.mobileqq.weather.b.a().b((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
        ArrayList<JSONObject> arrayList = mMaskAdInfoList;
        if (arrayList == null || arrayList.isEmpty()) {
            z16 = true;
        }
        if (!z16) {
            g();
        }
    }
}
