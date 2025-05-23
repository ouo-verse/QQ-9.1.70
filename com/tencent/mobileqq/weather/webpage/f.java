package com.tencent.mobileqq.weather.webpage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.weather.api.IWeatherTempApi;
import com.tencent.mobileqq.weather.part.WeatherMainPartFragment;
import com.tencent.mobileqq.weather.util.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.util.URLUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007J\"\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0007J\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\bH\u0007J\n\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0007J \u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J8\u0010$\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010#\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\"H\u0007J8\u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010#\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\"H\u0007J\u0010\u0010&\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0016\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\bR\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/weather/webpage/f;", "", "Landroid/content/Context;", "context", "Lcom/tencent/common/app/AppInterface;", "app", "", "from", "", "url", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "adCode", "businessId", "j", "adId", "", "l", "Lcom/tencent/mobileqq/weather/util/a;", "weatherEntryInfo", "k", "Lcom/tencent/mobileqq/weather/webpage/a;", "waterfallArk", "b", "g", "shareUrl", "e", "messageArk", "d", ZPlanPublishSource.FROM_SCHEME, h.F, "f", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", DomainData.DOMAIN_NAME, "o", "c", "source", "p", "Ljava/lang/String;", "encodedDeviceInfo", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f313714a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String encodedDeviceInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/webpage/f$a", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", QzoneIPCModule.RESULT_CODE, "", "unreadCnt", "", "c", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends IPublicAccountCommonMrg.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.weather.webpage.a f313716b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.weather.util.a f313717c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<com.tencent.mobileqq.weather.webpage.a> f313718d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f313719e;

        a(com.tencent.mobileqq.weather.webpage.a aVar, com.tencent.mobileqq.weather.util.a aVar2, Ref.ObjectRef<com.tencent.mobileqq.weather.webpage.a> objectRef, Context context) {
            this.f313716b = aVar;
            this.f313717c = aVar2;
            this.f313718d = objectRef;
            this.f313719e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, aVar2, objectRef, context);
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void c(int resultCode, long unreadCnt) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(resultCode), Long.valueOf(unreadCnt));
                return;
            }
            com.tencent.mobileqq.weather.util.d dVar = com.tencent.mobileqq.weather.util.d.f313638a;
            HashMap<String, String> e16 = dVar.e(this.f313716b, this.f313717c);
            if (unreadCnt > 0) {
                z16 = true;
            }
            if (!TextUtils.isEmpty(this.f313718d.element.f()) && !this.f313717c.e()) {
                if (QLog.isColorLevel()) {
                    QLog.d("WeatherWebPageHelper", 2, "hippy week page url, startNewWeatherWebPageActivity-->page url :  " + this.f313718d.element.f() + ";redpoint : " + z16);
                }
                String f16 = this.f313718d.element.f();
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                e16.put("page_url", f16 + "&hasredpoint=" + str);
            }
            String h16 = dVar.h(e16);
            if (z16 && g.f313646a.L(h16)) {
                com.tencent.mobileqq.weather.data.f.f313296a.r(1);
            }
            if (g.f313646a.G(e16)) {
                f.o(this.f313719e, e16);
            } else {
                f.n(this.f313719e, e16);
            }
            dVar.b();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f313714a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(Context context, com.tencent.mobileqq.weather.webpage.a waterfallArk) {
        int i3;
        JSONObject jSONObject;
        if (com.tencent.mobileqq.weather.util.b.f(context, QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        JSONObject jSONObject2 = new JSONObject(waterfallArk.b());
        JSONObject optJSONObject = jSONObject2.optJSONObject("qq_weather");
        if (optJSONObject != null) {
            jSONObject = optJSONObject.put("author_status", i3);
        } else {
            jSONObject = null;
        }
        jSONObject2.put("qq_weather", jSONObject);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "appMetaObj.toString()");
        waterfallArk.h(jSONObject3);
    }

    @JvmStatic
    @Nullable
    public static final com.tencent.mobileqq.weather.webpage.a d(@Nullable com.tencent.mobileqq.weather.webpage.a messageArk, @Nullable String shareUrl) {
        if (TextUtils.isEmpty(shareUrl)) {
            QLog.i("WeatherWebPageHelper", 1, "buildShareWaterFallArk shareUrl == null");
            return messageArk;
        }
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(shareUrl);
        Intrinsics.checkNotNullExpressionValue(argumentsFromURL, "getArgumentsFromURL(shareUrl)");
        String str = argumentsFromURL.get("adcode");
        if (str == null) {
            str = "";
        }
        String str2 = argumentsFromURL.get("scene");
        if (str2 == null) {
            str2 = "1";
        }
        String str3 = "{\"qq_weather\": {\"adcode\": " + str + ",\"scene\": " + str2 + "}}";
        QLog.i("WeatherWebPageHelper", 1, "buildShareWaterFallArk shareUrl == " + shareUrl + " adcode = " + str + " scene = " + str2);
        if (messageArk == null) {
            return new com.tencent.mobileqq.weather.webpage.a("com.tencent.weather_v2", str3, AskAnonymouslyUtil.ARK_APP_VER, "qq_weather", 0, "", new ArrayList());
        }
        messageArk.h(str3);
        return messageArk;
    }

    private final boolean e(String shareUrl) {
        if (TextUtils.isEmpty(shareUrl)) {
            QLog.i("WeatherWebPageHelper", 1, "checkShareUrlParam false shareUrl == null");
            return true;
        }
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(shareUrl);
        Intrinsics.checkNotNullExpressionValue(argumentsFromURL, "getArgumentsFromURL(shareUrl)");
        String str = argumentsFromURL.get("adcode");
        String str2 = argumentsFromURL.get("scene");
        if (!TextUtils.isEmpty(str) && !Intrinsics.areEqual("0", str) && !TextUtils.isEmpty(str2)) {
            return false;
        }
        QLog.i("WeatherWebPageHelper", 1, "checkShareUrlParam false  shareUrl == " + shareUrl + " ");
        return true;
    }

    @JvmStatic
    @Nullable
    public static final String f() {
        if (QLog.isColorLevel()) {
            QLog.d("WeatherWebPageHelper", 2, "gdt device info for weather 2.0 retrieved: " + encodedDeviceInfo);
        }
        return encodedDeviceInfo;
    }

    private final String g(String adCode) {
        if (TextUtils.isEmpty(adCode)) {
            adCode = "0";
        }
        String str = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherWebUrl() + adCode;
        if (QLog.isColorLevel()) {
            QLog.d("WeatherWebPageHelper", 2, "getWeatherWebUrl -> url: " + str);
        }
        return str;
    }

    @JvmStatic
    public static final void h(@NotNull Context context, @NotNull String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(scheme));
        intent.setPackage(BaseApplication.getContext().getPackageName());
        context.startActivity(intent);
    }

    @JvmStatic
    public static final void i(@NotNull Context context, @NotNull String adCode, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        Intrinsics.checkNotNullParameter(url, "url");
        if (QLog.isColorLevel()) {
            QLog.d("WeatherWebPageHelper", 2, "load hippy failed, openWeatherWeb: adcode, " + adCode);
        }
        if (TextUtils.isEmpty(url)) {
            url = f313714a.g(adCode);
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("key_isReadModeEnabled", true);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final void j(@NotNull Context context, @NotNull String adCode, @NotNull String businessId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        if (QLog.isColorLevel()) {
            QLog.d("WeatherWebPageHelper", 2, "openWeatherWebPage: adcode, " + adCode + ", businessId, " + businessId);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("adcode", adCode);
        hashMap.put("isFromShare", "1");
        n(context, hashMap);
        com.tencent.mobileqq.weather.b.a().d(MobileQQ.sMobileQQ.waitAppRuntime(null), "new_folder_apicall", "AND", "", businessId);
    }

    @JvmStatic
    public static final boolean k(@NotNull final Context context, @Nullable final AppInterface app, @NotNull final com.tencent.mobileqq.weather.util.a weatherEntryInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(weatherEntryInfo, "weatherEntryInfo");
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(weatherEntryInfo.c());
        final String str = argumentsFromURL.get("adcode");
        final String str2 = argumentsFromURL.get("businessId");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean e16 = weatherEntryInfo.e();
        booleanRef.element = e16;
        if (e16 && f313714a.e(weatherEntryInfo.c())) {
            booleanRef.element = false;
        }
        ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(new Contact(1, "u_vmmIQZ3yUOpBlO2DISdO2g", ""), 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.weather.webpage.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str3, ArrayList arrayList) {
                f.m(AppInterface.this, booleanRef, weatherEntryInfo, str, context, str2, i3, str3, arrayList);
            }
        });
        return true;
    }

    @JvmStatic
    public static final boolean l(@NotNull Context context, @NotNull AppInterface app, @NotNull String adId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(adId, "adId");
        com.tencent.mobileqq.weather.util.h.f313657a.a();
        return k(context, app, new com.tencent.mobileqq.weather.util.a(false, "", false, "", adId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.tencent.mobileqq.weather.webpage.a] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r5v25, types: [T, com.tencent.mobileqq.weather.webpage.a] */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, com.tencent.mobileqq.weather.webpage.a] */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, com.tencent.mobileqq.weather.webpage.a] */
    public static final void m(AppInterface appInterface, Ref.BooleanRef isFromShare, com.tencent.mobileqq.weather.util.a weatherEntryInfo, String str, Context context, String str2, int i3, String str3, ArrayList msgList) {
        MsgRecord msgRecord;
        ?? r26;
        String str4;
        com.tencent.mobileqq.weather.webpage.a aVar;
        String f16;
        Intrinsics.checkNotNullParameter(isFromShare, "$isFromShare");
        Intrinsics.checkNotNullParameter(weatherEntryInfo, "$weatherEntryInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        String str5 = null;
        if (!msgList.isEmpty()) {
            msgRecord = (MsgRecord) msgList.get(0);
        } else {
            msgRecord = null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (msgRecord != null) {
            r26 = com.tencent.mobileqq.weather.util.d.f313638a.j(((IWeatherTempApi) QRoute.api(IWeatherTempApi.class)).getMetaFromArkMsgRecord(msgRecord));
        } else {
            r26 = 0;
        }
        objectRef.element = r26;
        com.tencent.mobileqq.weather.util.d dVar = com.tencent.mobileqq.weather.util.d.f313638a;
        dVar.m(r26, msgRecord, appInterface);
        if (isFromShare.element) {
            objectRef.element = d((com.tencent.mobileqq.weather.webpage.a) objectRef.element, weatherEntryInfo.c());
        } else if (weatherEntryInfo.d()) {
            objectRef.element = f313714a.c(weatherEntryInfo.b());
        } else if (objectRef.element == 0) {
            objectRef.element = f313714a.c(str);
        }
        com.tencent.mobileqq.weather.webpage.a aVar2 = (com.tencent.mobileqq.weather.webpage.a) objectRef.element;
        if (aVar2 != null) {
            str4 = aVar2.f();
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            com.tencent.mobileqq.weather.webpage.a aVar3 = (com.tencent.mobileqq.weather.webpage.a) objectRef.element;
            if (aVar3 != null) {
                str5 = aVar3.f();
            }
            if (!com.tencent.mobileqq.weather.util.b.h(str5) && (aVar = (com.tencent.mobileqq.weather.webpage.a) objectRef.element) != null && (f16 = aVar.f()) != null) {
                i(context, "", f16);
                dVar.b();
                return;
            }
        }
        com.tencent.mobileqq.weather.webpage.a aVar4 = (com.tencent.mobileqq.weather.webpage.a) objectRef.element;
        if (aVar4 != null) {
            f313714a.b(context, aVar4);
            dVar.g(new a(aVar4, weatherEntryInfo, objectRef, context));
            if (str2 != null) {
                com.tencent.mobileqq.weather.b.a().d(appInterface, "new_folder_apicall", "AND", "", str2);
            }
        }
        if (objectRef.element == 0) {
            dVar.b();
        }
    }

    @JvmStatic
    public static final void n(@NotNull Context context, @Nullable HashMap<String, String> dataMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        SerializableMap serializableMap = new SerializableMap();
        if (dataMap != null) {
            serializableMap.wrapMap(dataMap);
        }
        bundle.putString("bundleName", HippyQQConstants.ModuleName.QQ_WEATHER);
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, true);
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE, true);
        bundle.putSerializable("qqWeatherParams", serializableMap);
        bundle.putString("domain", "mp.qq.com");
        bundle.putInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, 1);
        com.tencent.mobileqq.weather.util.d dVar = com.tencent.mobileqq.weather.util.d.f313638a;
        bundle.putString("url", dVar.h(dataMap));
        Intent intent = new Intent();
        intent.putExtra("params", bundle);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setFlags(268435456);
        dVar.n(context, intent);
    }

    @JvmStatic
    public static final void o(@NotNull Context context, @Nullable HashMap<String, String> dataMap) {
        String str;
        String str2;
        List listOf;
        String str3;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z16 = true;
        com.tencent.mobileqq.weather.mvvm.d.E.P1(true, false, 0);
        Bundle bundle = new Bundle();
        String h16 = com.tencent.mobileqq.weather.util.d.f313638a.h(dataMap);
        if (dataMap == null || (str = dataMap.get("isFromShare")) == null) {
            str = "0";
        }
        String str4 = "";
        if (dataMap == null || (str2 = dataMap.get("ad_id")) == null) {
            str2 = "";
        }
        bundle.putString("url", h16);
        bundle.putString("isFromShare", str);
        if (dataMap != null && (str3 = dataMap.get("adcode")) != null) {
            str4 = str3;
        }
        bundle.putString("adcode", str4);
        if (g.f313646a.I(h16, Intrinsics.areEqual(str, "1"))) {
            QRouteApi api = QRoute.api(IVasAdvApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasAdvApi::class.java)");
            listOf = CollectionsKt__CollectionsJVMKt.listOf("4094349949158937");
            IVasAdvApi.a.b((IVasAdvApi) api, listOf, false, null, 6, null);
        }
        Intent intent = new Intent();
        intent.putExtra("params", bundle);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("params", bundle);
        intent.putExtra("negative_feedback_business_id", "weather");
        if (str2.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("ad_id", str2);
            Unit unit = Unit.INSTANCE;
            intent.putExtra("negative_feedback_business_extras", bundle2);
        }
        intent.setFlags(268435456);
        QPublicFragmentActivity.start(context, intent, WeatherMainPartFragment.class);
    }

    @JvmStatic
    public static final void q(@NotNull Context context, @NotNull AppInterface app, int from, @Nullable String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        if (url == null) {
            url = "";
        }
        if (!k(context, app, new com.tencent.mobileqq.weather.util.a(true, url, false, "", null, 16, null))) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            intent.setComponent(new ComponentName(context, (Class<?>) ((IChatActivityApi) QRoute.api(IChatActivityApi.class)).getChatActivityClass()));
            bundle.putString("uin", "2658655094");
            bundle.putInt("uintype", 1008);
            bundle.putString("uinname", "QQ\u5929\u6c14");
            intent.putExtras(bundle);
            intent.setFlags(67108864);
            intent.putExtra("jump_from", from);
            context.startActivity(intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r9 == null) goto L12;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.mobileqq.weather.webpage.a c(@Nullable String adCode) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.weather.webpage.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) adCode);
        }
        QLog.i("WeatherWebPageHelper", 1, "buildNoPushWaterArk");
        if (adCode != null) {
            str = "{\"qq_weather\": {\"adcode\": " + adCode + ",\"scene\": 1}}";
        }
        str = "{\"qq_weather\": {}}";
        return new com.tencent.mobileqq.weather.webpage.a("com.tencent.weather_v2", str, AskAnonymouslyUtil.ARK_APP_VER, "qq_weather", 0, "", new ArrayList());
    }

    public final void p(@NotNull Context context, @NotNull String source) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) source);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        QRouteApi api = QRoute.api(IVasAdvApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasAdvApi::class.java)");
        listOf = CollectionsKt__CollectionsJVMKt.listOf("7075765881355084");
        IVasAdvApi.a.b((IVasAdvApi) api, listOf, false, null, 6, null);
        StringBuilder sb5 = new StringBuilder("mqqapi://kuikly/open?page_name=QQWeatherRainFall&bundle_name=qqweatherkuikly&version=1&src_type=web");
        sb5.append("&clicktime=" + System.currentTimeMillis());
        com.tencent.mobileqq.weather.data.f fVar = com.tencent.mobileqq.weather.data.f.f313296a;
        sb5.append("&lat=" + fVar.k());
        sb5.append("&lng=" + fVar.l());
        sb5.append("&adcode=" + fVar.i());
        sb5.append("&warningSource=" + source);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "schemeUrl.toString()");
        QLog.i("WeatherWebPageHelper", 1, "openKuiklySchema " + sb6);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(context, sb6);
    }
}
