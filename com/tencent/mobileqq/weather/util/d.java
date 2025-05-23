package com.tencent.mobileqq.weather.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.weather.hippy.WeatherMainHippyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J2\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J$\u0010!\u001a\u00020\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0006\u0010\"\u001a\u00020\u001bJ0\u0010$\u001a\u0004\u0018\u00010\u00022&\u0010#\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0015J\u0010\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%J\u0010\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020)J\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020,R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/weather/util/d;", "", "", "url", "o", "Lorg/json/JSONArray;", "jsonArray", "", "f", "Lcom/tencent/mobileqq/weather/webpage/a;", "ark", "d", "", "index", "k", "metaList", "j", "waterfallArk", "Lcom/tencent/mobileqq/weather/util/a;", "weatherEntryInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lcom/tencent/common/app/AppInterface;", "app", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "map", tl.h.F, "Lcom/tencent/mobileqq/persistence/Entity;", "mr", "", "l", "Lq91/a;", "arkMessage", "i", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "callback", "g", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f313638a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43844);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f313638a = new d();
            TAG = "WeatherJumpHelper";
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(TAG, 1, "[handleBlockResp] setMsgRead: result=" + i3 + ", errMsg=" + msg2);
    }

    private final String d(com.tencent.mobileqq.weather.webpage.a ark) {
        try {
            String optString = new JSONObject(ark.b()).optJSONObject("qq_weather").optString("adcode", "");
            Intrinsics.checkNotNullExpressionValue(optString, "weather.optString(\"adcode\", \"\")");
            return optString;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, th5, new Object[0]);
            return "";
        }
    }

    private final List<String> f(JSONArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jsonArray.optString(i3));
            }
        }
        return arrayList;
    }

    private final String k(com.tencent.mobileqq.weather.webpage.a ark, int index) {
        if (ark.a().size() <= index) {
            return "";
        }
        return ark.a().get(index);
    }

    @JvmStatic
    @Nullable
    public static final String o(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = url.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] encode = PluginBaseInfoHelper.Base64Helper.encode(bytes, 0);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(url.toByteArray(c\u20268\")), Base64Util.DEFAULT)");
            return "mqqapi://forward/url?src_type=web&version=1&url_prefix=" + new String(encode, Charsets.UTF_8);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "transFormUrlToScheme", th5);
            return null;
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, "u_vmmIQZ3yUOpBlO2DISdO2g", ""), new IOperateCallback() { // from class: com.tencent.mobileqq.weather.util.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    d.c(i3, str);
                }
            });
        } catch (Throwable th5) {
            QLog.d(TAG, 1, th5, new Object[0]);
        }
    }

    @NotNull
    public final HashMap<String, String> e(@NotNull com.tencent.mobileqq.weather.webpage.a waterfallArk, @NotNull a weatherEntryInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) waterfallArk, (Object) weatherEntryInfo);
        }
        Intrinsics.checkNotNullParameter(waterfallArk, "waterfallArk");
        Intrinsics.checkNotNullParameter(weatherEntryInfo, "weatherEntryInfo");
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(waterfallArk.f()) && !weatherEntryInfo.e()) {
            hashMap.put("first_pos_id", k(waterfallArk, 0));
        }
        if (!TextUtils.isEmpty(weatherEntryInfo.c())) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "hippy week share url, startNewWeatherWebPageActivity-->shareUrl : " + weatherEntryInfo + ".shareUrl");
            }
            hashMap.put("url", weatherEntryInfo.c());
        }
        hashMap.put("adcode", d(waterfallArk));
        if (weatherEntryInfo.e()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("isFromShare", str);
        hashMap.put("ad_id", weatherEntryInfo.a());
        return hashMap;
    }

    public final void g(@NotNull IPublicAccountCommonMrg.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).asyncGetUnReadCnt4PA("u_vmmIQZ3yUOpBlO2DISdO2g", callback);
        }
    }

    @Nullable
    public final String h(@Nullable HashMap<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
        }
        if (map == null) {
            return "";
        }
        if (map.containsKey("page_url")) {
            return map.get("page_url");
        }
        if (!map.containsKey("url")) {
            return "";
        }
        return map.get("url");
    }

    @Nullable
    public final com.tencent.mobileqq.weather.webpage.a i(@NotNull q91.a arkMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.weather.webpage.a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) arkMessage);
        }
        Intrinsics.checkNotNullParameter(arkMessage, "arkMessage");
        try {
            if (!TextUtils.isEmpty(arkMessage.getMetaList())) {
                return j(arkMessage.getMetaList());
            }
            return null;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, th5, new Object[0]);
            return null;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.weather.webpage.a j(@Nullable String metaList) {
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.weather.webpage.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) metaList);
        }
        if (metaList == null) {
            return null;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(metaList).optJSONObject("weather");
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("waterfall_ark")) == null) {
                return null;
            }
            String app = optJSONObject.optString("app");
            String meta = optJSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            String view = optJSONObject.optString("view");
            String ver = optJSONObject.optString("ver");
            int optInt = optJSONObject.optInt(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE);
            String pageUrl = optJSONObject.optString("page_url");
            List<String> f16 = f(optJSONObject.optJSONArray("adv_pos_ids"));
            Intrinsics.checkNotNullExpressionValue(app, "app");
            Intrinsics.checkNotNullExpressionValue(meta, "meta");
            Intrinsics.checkNotNullExpressionValue(ver, "ver");
            Intrinsics.checkNotNullExpressionValue(view, "view");
            Intrinsics.checkNotNullExpressionValue(pageUrl, "pageUrl");
            return new com.tencent.mobileqq.weather.webpage.a(app, meta, ver, view, optInt, pageUrl, f16);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getWaterFallArkFromMeta", th5);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(@Nullable Entity mr5) {
        com.tencent.mobileqq.weather.webpage.a i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) mr5)).booleanValue();
        }
        if (!(mr5 instanceof q91.a) || (i3 = i((q91.a) mr5)) == null || TextUtils.isEmpty(i3.c()) || TextUtils.isEmpty(i3.e()) || TextUtils.isEmpty(i3.d()) || TextUtils.isEmpty(i3.b())) {
            return false;
        }
        return true;
    }

    public final void m(@Nullable com.tencent.mobileqq.weather.webpage.a waterfallArk, @Nullable MsgRecord msg2, @Nullable AppInterface app) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, waterfallArk, msg2, app);
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (msg2 != null) {
            serverTime -= msg2.msgTime;
        }
        if (waterfallArk != null) {
            num = Integer.valueOf(waterfallArk.g());
        } else {
            num = null;
        }
        com.tencent.mobileqq.weather.b.a().f(app, "new_folder_push_open_timegap", serverTime + "||" + num);
    }

    public final void n(@NotNull Context context, @NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (AppSetting.t(context)) {
            com.tencent.mobileqq.pad.i.e(context, intent.getExtras(), WeatherMainHippyFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).a());
        } else {
            QPublicFragmentActivity.start(context, intent, WeatherMainHippyFragment.class);
        }
    }
}
