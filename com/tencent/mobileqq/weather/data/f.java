package com.tencent.mobileqq.weather.data;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bN\u0010OJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\u0010\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\u0012J\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bR$\u0010-\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00103\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00109\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010<\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\"\u0010C\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010F\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010.\u001a\u0004\b=\u00100\"\u0004\bE\u00102R>\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160Gj\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016`H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010I\u001a\u0004\bD\u0010J\"\u0004\bK\u0010L\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/weather/data/f;", "", "Landroid/content/Context;", "e", "", "bytes", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "a", "", "y", "", DomainData.DOMAIN_NAME, "", "p", "", "city", "t", "j", "", "adCode", ReportConstant.COSTREPORT_PREFIX, "i", "", "latitude", "u", "k", "longitude", "v", "l", "data", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "b", "page", "r", tl.h.F, "o", "c", "d", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "getWeatherReplyData", "()Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "setWeatherReplyData", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;)V", "weatherReplyData", "I", "getCurrentAdCode", "()I", "setCurrentAdCode", "(I)V", "currentAdCode", UserInfo.SEX_FEMALE, "getCurrentLatitude", "()F", "setCurrentLatitude", "(F)V", "currentLatitude", "getCurrentLongitude", "setCurrentLongitude", "currentLongitude", "f", "Ljava/lang/String;", "getCurrentCity", "()Ljava/lang/String;", "setCurrentCity", "(Ljava/lang/String;)V", "currentCity", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "currentPendantAdId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setPAGE_DAY_VISIBLE_PERCENT_MAP", "(Ljava/util/HashMap;)V", "PAGE_DAY_VISIBLE_PERCENT_MAP", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f313296a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static weather$GetConcernWeatherReply weatherReplyData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentAdCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static float currentLatitude;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static float currentLongitude;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String currentCity;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int currentPendantAdId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<Integer, Float> PAGE_DAY_VISIBLE_PERCENT_MAP;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20060);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
            return;
        }
        f313296a = new f();
        currentCity = "\u5b9a\u4f4d\u4e2d";
        PAGE_DAY_VISIBLE_PERCENT_MAP = new HashMap<>();
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final weather$GetConcernWeatherReply a(byte[] bytes) {
        weather$GetConcernWeatherReply weather_getconcernweatherreply = new weather$GetConcernWeatherReply();
        try {
            weather_getconcernweatherreply.mergeFrom(bytes);
        } catch (Throwable th5) {
            QLog.d("WeatherDataCache", 1, "bytesToWeatherData error:", th5);
        }
        return weather_getconcernweatherreply;
    }

    private final Context e() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        if (System.currentTimeMillis() - from.decodeLong("key_weather_permission_time", 0L) > 1800000) {
            return true;
        }
        return false;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            d();
            PAGE_DAY_VISIBLE_PERCENT_MAP.clear();
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            currentPendantAdId = 0;
        }
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return currentPendantAdId;
    }

    @NotNull
    public final HashMap<Integer, Float> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (HashMap) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return PAGE_DAY_VISIBLE_PERCENT_MAP;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeInt("key_weather_user_page_selection" + VasUtil.getCurrentUin(), 0);
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int i3 = currentAdCode;
        if (i3 != 0) {
            return i3;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeInt("key_weather_current_adcode_cache", BusinessInfoCheckUpdateItem.UIAPPID_MINI_APP_PANEL);
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (!TextUtils.equals(currentCity, "\u5b9a\u4f4d\u4e2d")) {
            return currentCity;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        String decodeString = from.decodeString("key_weather_current_city_name_cache", "\u5b9a\u4f4d\u4e2d");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(KEY_\u2026CACHE, DEFAULT_CITY_NAME)");
        return decodeString;
    }

    public final float k() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Float) iPatchRedirector.redirect((short) 24, (Object) this)).floatValue();
        }
        float f16 = currentLatitude;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return f16;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeFloat("key_weather_current_latitude_cache", 0.0f);
    }

    public final float l() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Float) iPatchRedirector.redirect((short) 26, (Object) this)).floatValue();
        }
        float f16 = currentLongitude;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return f16;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeFloat("key_weather_current_longitude_cache", 0.0f);
    }

    @NotNull
    public final weather$GetConcernWeatherReply m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (weather$GetConcernWeatherReply) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        if (weatherReplyData != null && com.tencent.mobileqq.weather.util.b.f(QBaseActivity.sTopActivity, QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
            weather$GetConcernWeatherReply weather_getconcernweatherreply = weatherReplyData;
            Intrinsics.checkNotNull(weather_getconcernweatherreply, "null cannot be cast to non-null type com.tencent.jungle.weather.proto.weather.GetConcernWeatherReply");
            return weather_getconcernweatherreply;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        byte[] dataBytes = from.decodeBytes("key_weather_reply_data_cache", new weather$GetConcernWeatherReply().toByteArray());
        Intrinsics.checkNotNullExpressionValue(dataBytes, "dataBytes");
        return a(dataBytes);
    }

    public final long n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeLong("key_weather_lbs_cache_valid_time_ms", 0L);
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.containsKey("key_weather_current_adcode_cache");
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long n3 = n();
        if (n3 != 0 && currentTimeMillis - n3 < 600000) {
            return true;
        }
        return false;
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            currentPendantAdId = i3;
        }
    }

    public final void r(int page) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, page);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeInt("key_weather_user_page_selection" + VasUtil.getCurrentUin(), page);
    }

    public final void s(int adCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, adCode);
            return;
        }
        currentAdCode = adCode;
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeInt("key_weather_current_adcode_cache", adCode);
    }

    public final void t(@NotNull String city) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) city);
            return;
        }
        Intrinsics.checkNotNullParameter(city, "city");
        currentCity = city;
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeString("key_weather_current_city_name_cache", city);
    }

    public final void u(float latitude) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(latitude));
            return;
        }
        currentLatitude = latitude;
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeFloat("key_weather_current_latitude_cache", latitude);
    }

    public final void v(float longitude) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Float.valueOf(longitude));
            return;
        }
        currentLongitude = longitude;
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeFloat("key_weather_current_longitude_cache", longitude);
    }

    public final void w(@Nullable weather$GetConcernWeatherReply data) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) data);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        if (data != null) {
            bArr = data.toByteArray();
        } else {
            bArr = null;
        }
        from.encodeBytes("key_weather_reply_data_cache", bArr);
        weatherReplyData = data;
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeLong("key_weather_permission_time", System.currentTimeMillis());
    }

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MMKVOptionEntity from = QMMKV.from(e(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeLong("key_weather_lbs_cache_valid_time_ms", currentTimeMillis);
    }
}
