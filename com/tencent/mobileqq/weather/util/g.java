package com.tencent.mobileqq.weather.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.jungle.weather.proto.WeatherInfo$Weather;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherWarningDetail;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.weather.util.report.j;
import com.tencent.mobileqq.weather.util.report.l;
import com.tencent.mobileqq.weather.util.report.n;
import com.tencent.mobileqq.weather.util.report.q;
import com.tencent.mobileqq.weather.util.report.s;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bi\u0010jJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u001f\u0010\u0016\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0013J\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0005J\"\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0002J\"\u0010$\u001a\u0004\u0018\u00010\"2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002J\u001e\u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013J\u0016\u0010*\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0013J\u0016\u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0005J\u0016\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0005J\u0016\u00101\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0016\u00103\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u00104\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u00105\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0002J\u0006\u00108\u001a\u00020\u0005J\u0010\u0010;\u001a\u00020\u00132\b\u0010:\u001a\u0004\u0018\u000109J\u001a\u0010>\u001a\u00020\u00132\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050<J\u0006\u0010?\u001a\u00020\u0013J\u0010\u0010@\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\u0005J\u0018\u0010B\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\u0013J\u001e\u0010E\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005J\u0010\u0010F\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\u0005J\u000e\u0010G\u001a\u00020\u00052\u0006\u0010:\u001a\u000209J\u0006\u0010H\u001a\u00020\u0002J\u0006\u0010I\u001a\u00020\u0013J\u0006\u0010J\u001a\u00020.J \u0010P\u001a\u00020.2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010NJ\u0006\u0010Q\u001a\u00020\u0013J\u0006\u0010R\u001a\u00020\u0013R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00050S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010TR0\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050Vj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010XR0\u0010[\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050Vj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010XR0\u0010]\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020Vj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010XR0\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050Vj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010XR0\u0010`\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050Vj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010XR0\u0010a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050Vj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010XR\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00050b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010c\u001a\u0004\bZ\u0010dR3\u0010g\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Vj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`W8\u0006\u00a2\u0006\f\n\u0004\b$\u0010X\u001a\u0004\b\\\u0010fR3\u0010h\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Vj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`W8\u0006\u00a2\u0006\f\n\u0004\bH\u0010X\u001a\u0004\b^\u0010f\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/weather/util/g;", "", "", "warnType", "warnLevel", "", "B", "b", GdtGetUserInfoHandler.KEY_AREA, "city", "province", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "publishTime", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "timeString", "dayOffSet", "", "t", "weatherType", "", "K", "isNight", "w", "(Ljava/lang/Integer;Z)Ljava/lang/String;", "lastPrefix", "o", "y", "p", "newcastingWeatherType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "replyData", "pagePos", "Lcom/tencent/mobileqq/weather/part/briefwarning/a;", "i", "j", tl.h.F, "name", "isSelected", "isNightTheme", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/content/Context;", "context", "url", "", "O", "P", "N", DomainData.DOMAIN_NAME, "r", ReportConstant.COSTREPORT_PREFIX, "u", "airQuality", "c", HippyTKDListViewAdapter.X, "Lcom/tencent/jungle/weather/proto/WeatherInfo$Weather;", "weather", "E", "", "dataMap", "G", "H", "L", "isFromShare", "I", VasWebviewConstants.KEY_PAGE_URL, "isAuth", BdhLogUtil.LogTag.Tag_Conn, "M", "v", "k", "J", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "eventId", "Lorg/json/JSONObject;", "params", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, UserInfo.SEX_FEMALE, "D", "", "[Ljava/lang/String;", "weekDays", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "weatherTitleBgMap", "d", "weatherTitleSupportNightMap", "e", "nowcastingWeatherMap", "f", "warnLevelColorMap", "warningLevelNameMap", "warningTypeNameMap", "", "Ljava/util/List;", "()Ljava/util/List;", "astroNameList", "()Ljava/util/HashMap;", "astroToDateMap", "astroToNameMap", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f313646a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] weekDays;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> weatherTitleBgMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> weatherTitleSupportNightMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> nowcastingWeatherMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> warnLevelColorMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> warningLevelNameMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> warningTypeNameMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> astroNameList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> astroToDateMap;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> astroToNameMap;

    static {
        HashMap<Integer, String> hashMapOf;
        HashMap<Integer, String> hashMapOf2;
        HashMap<Integer, Integer> hashMapOf3;
        HashMap<Integer, String> hashMapOf4;
        HashMap<Integer, String> hashMapOf5;
        HashMap<Integer, String> hashMapOf6;
        List<String> listOf;
        HashMap<String, String> hashMapOf7;
        HashMap<String, String> hashMapOf8;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 39)) {
            redirector.redirect((short) 39);
            return;
        }
        f313646a = new g();
        weekDays = new String[]{"\u661f\u671f\u65e5", "\u661f\u671f\u4e00", "\u661f\u671f\u4e8c", "\u661f\u671f\u4e09", "\u661f\u671f\u56db", "\u661f\u671f\u4e94", "\u661f\u671f\u516d"};
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, "sunny"), TuplesKt.to(2, "cloudy"), TuplesKt.to(3, "overcast"), TuplesKt.to(4, "light_rain"), TuplesKt.to(5, "thunder_shower"), TuplesKt.to(6, "sleet"), TuplesKt.to(7, "moderate_rain"), TuplesKt.to(8, "heavy_rain"), TuplesKt.to(9, "torrential_rain"), TuplesKt.to(10, "light_snow"), TuplesKt.to(11, "moderate_snow"), TuplesKt.to(12, "heavy_snow"), TuplesKt.to(13, "torrential_snow"), TuplesKt.to(14, "fog"), TuplesKt.to(15, "freezing_rain"), TuplesKt.to(16, "sand"), TuplesKt.to(17, "light_haze"), TuplesKt.to(18, "moderate_haze"), TuplesKt.to(19, "heavy_haze"));
        weatherTitleBgMap = hashMapOf;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, "sunny"), TuplesKt.to(2, "cloudy"));
        weatherTitleSupportNightMap = hashMapOf2;
        hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 4), TuplesKt.to(3, 7), TuplesKt.to(4, 8), TuplesKt.to(5, 9), TuplesKt.to(6, 10), TuplesKt.to(7, 11), TuplesKt.to(8, 12), TuplesKt.to(9, 13));
        nowcastingWeatherMap = hashMapOf3;
        hashMapOf4 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, "#22AFFF"), TuplesKt.to(2, "#FFA800"), TuplesKt.to(3, "#FF7A00"), TuplesKt.to(4, "#D71100"), TuplesKt.to(5, "#BFBFBF"));
        warnLevelColorMap = hashMapOf4;
        hashMapOf5 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, "blue"), TuplesKt.to(2, "yellow"), TuplesKt.to(3, "orange"), TuplesKt.to(4, "red"), TuplesKt.to(5, "white"));
        warningLevelNameMap = hashMapOf5;
        hashMapOf6 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, "typhoon"), TuplesKt.to(2, "rainstorm"), TuplesKt.to(3, "heat"), TuplesKt.to(4, "coldwave"), TuplesKt.to(5, "gale"), TuplesKt.to(6, "fog"), TuplesKt.to(7, "hail"), TuplesKt.to(8, "thunder"), TuplesKt.to(9, "drought"), TuplesKt.to(10, "haze"), TuplesKt.to(11, "fire"), TuplesKt.to(12, "blizzard"), TuplesKt.to(13, "sandstorm"), TuplesKt.to(14, "frost"), TuplesKt.to(15, "icyroad"));
        warningTypeNameMap = hashMapOf6;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7", "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7"});
        astroNameList = listOf;
        hashMapOf7 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("\u767d\u7f8a\u5ea7", "03.21-04.19"), TuplesKt.to("\u91d1\u725b\u5ea7", "04.20-05.20"), TuplesKt.to("\u53cc\u5b50\u5ea7", "05.21-06.21"), TuplesKt.to("\u5de8\u87f9\u5ea7", "06.22-07.22"), TuplesKt.to("\u72ee\u5b50\u5ea7", "07.23-08.22"), TuplesKt.to("\u5904\u5973\u5ea7", "08.23-09.22"), TuplesKt.to("\u5929\u79e4\u5ea7", "09.23-10.23"), TuplesKt.to("\u5929\u874e\u5ea7", "10.24-11.22"), TuplesKt.to("\u5c04\u624b\u5ea7", "11.23-12.21"), TuplesKt.to("\u6469\u7faf\u5ea7", "12.22-01.19"), TuplesKt.to("\u6c34\u74f6\u5ea7", "01.20-02.18"), TuplesKt.to("\u53cc\u9c7c\u5ea7", "02.19-03.20"));
        astroToDateMap = hashMapOf7;
        hashMapOf8 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("\u767d\u7f8a\u5ea7", "baiyang"), TuplesKt.to("\u91d1\u725b\u5ea7", "jinniu"), TuplesKt.to("\u53cc\u5b50\u5ea7", "shuangzi"), TuplesKt.to("\u5de8\u87f9\u5ea7", "juxie"), TuplesKt.to("\u72ee\u5b50\u5ea7", "shizi"), TuplesKt.to("\u5904\u5973\u5ea7", "chunv"), TuplesKt.to("\u5929\u79e4\u5ea7", "tianping"), TuplesKt.to("\u5929\u874e\u5ea7", "tianxie"), TuplesKt.to("\u5c04\u624b\u5ea7", "sheshou"), TuplesKt.to("\u6469\u7faf\u5ea7", "mojie"), TuplesKt.to("\u6c34\u74f6\u5ea7", "shuiping"), TuplesKt.to("\u53cc\u9c7c\u5ea7", "shuangyu"));
        astroToNameMap = hashMapOf8;
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String A(int publishTime) {
        return new SimpleDateFormat("MM\u6708dd\u65e5 HH:mm", Locale.getDefault()).format(new Date(publishTime * 1000)) + "\u53d1\u5e03";
    }

    private final String B(int warnType, int warnLevel) {
        String str;
        HashMap<Integer, String> hashMap = warningTypeNameMap;
        String str2 = "default";
        if (!hashMap.containsKey(Integer.valueOf(warnType))) {
            str = "default";
        } else {
            str = hashMap.get(Integer.valueOf(warnType));
        }
        HashMap<Integer, String> hashMap2 = warningLevelNameMap;
        if (hashMap2.containsKey(Integer.valueOf(warnLevel))) {
            str2 = hashMap2.get(Integer.valueOf(warnLevel));
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/" + str2 + "/" + str + ".png";
    }

    private final boolean K(int weatherType) {
        return weatherTitleSupportNightMap.containsKey(Integer.valueOf(weatherType));
    }

    private final String b(int warnLevel) {
        HashMap<Integer, String> hashMap = warnLevelColorMap;
        if (hashMap.containsKey(Integer.valueOf(warnLevel))) {
            return String.valueOf(hashMap.get(Integer.valueOf(warnLevel)));
        }
        return String.valueOf(hashMap.get(5));
    }

    private final long t(String timeString, int dayOffSet) {
        if (!TextUtils.isEmpty(timeString) && timeString.length() >= 5) {
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
            calendar.set(6, calendar.get(6) + dayOffSet);
            String substring = timeString.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            calendar.set(11, Integer.parseInt(substring));
            String substring2 = timeString.substring(3, 5);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            calendar.set(12, Integer.parseInt(substring2));
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() / 1000;
        }
        return 0L;
    }

    private final String z(String area, String city, String province) {
        if (!TextUtils.isEmpty(area)) {
            return area;
        }
        if (!TextUtils.isEmpty(city)) {
            return city;
        }
        if (!TextUtils.isEmpty(province)) {
            return province;
        }
        return "";
    }

    @NotNull
    public final String C(@NotNull String pageUrl, @NotNull String isFromShare, @NotNull String isAuth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, this, pageUrl, isFromShare, isAuth);
        }
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        Intrinsics.checkNotNullParameter(isFromShare, "isFromShare");
        Intrinsics.checkNotNullParameter(isAuth, "isAuth");
        StringBuilder sb5 = new StringBuilder("mqqapi://kuikly/open?page_name=QQWeatherWeek&bundle_name=qqweatherkuikly&version=1&src_type=web");
        try {
            sb5.append("&src_url=");
            sb5.append(URLEncoder.encode(pageUrl, "utf-8"));
        } catch (UnsupportedEncodingException e16) {
            QLog.e("WeatherMainPageHelper", 1, "getWeatherWeekKuiklyUrl error:", e16);
        }
        sb5.append("&hasredpoint=");
        sb5.append(b.b(pageUrl, "hasredpoint"));
        sb5.append("&is_from_share=");
        sb5.append(isFromShare);
        sb5.append("&is_auth=");
        sb5.append(isAuth);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "schemaUrl.toString()");
        return sb6;
    }

    public final boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105836", false);
    }

    public final boolean E(@Nullable WeatherInfo$Weather weather) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) weather)).booleanValue();
        }
        boolean z16 = false;
        if (weather == null) {
            return false;
        }
        String str = weather.weather_info.sunset.get();
        Intrinsics.checkNotNullExpressionValue(str, "weather.weather_info.sunset.get()");
        long s16 = s(str, 0);
        String str2 = weather.weather_info.sunrise.get();
        Intrinsics.checkNotNullExpressionValue(str2, "weather.weather_info.sunrise.get()");
        long r16 = r(str2, 0);
        long currentTimeMillis = (int) (((float) System.currentTimeMillis()) / 1000.0f);
        if (r16 <= currentTimeMillis && currentTimeMillis < s16) {
            z16 = true;
        }
        return !z16;
    }

    public final boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101552", true);
    }

    public final boolean G(@NotNull Map<String, String> dataMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) dataMap)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dataMap, "dataMap");
        String str = dataMap.get("p");
        if (str == null) {
            str = "0";
        }
        boolean areEqual = Intrinsics.areEqual(str, "1");
        if (H() && !areEqual) {
            return true;
        }
        return false;
    }

    public final boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (com.tencent.mobileqq.weather.debug.g.f313380a.c()) {
            return true;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101549", true);
    }

    public final boolean I(@Nullable String url, boolean isFromShare) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, this, url, Boolean.valueOf(isFromShare))).booleanValue();
        }
        if (!L(url)) {
            return false;
        }
        if (com.tencent.mobileqq.weather.data.f.f313296a.h() != 1 && !isFromShare) {
            return false;
        }
        return true;
    }

    public final boolean J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        if (k() == 2) {
            return true;
        }
        return false;
    }

    public final boolean L(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) url)).booleanValue();
        }
        return Intrinsics.areEqual(b.c(url, 1), WidgetCacheLunarData.WEEK);
    }

    public final boolean M(@Nullable String url) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) url)).booleanValue();
        }
        if (url != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "push_type=5&hasredpoint=1", false, 2, (Object) null);
            if (true != contains$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void N(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", "biz_src_gzh_weather");
            intent.putExtras(bundle);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e16) {
            QLog.e("WeatherMainPageHelper", 1, "openSchema error:", e16);
        }
    }

    public final void O(@NotNull Context context, @NotNull String url) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (!TextUtils.isEmpty(url)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://", false, 2, null);
            if (startsWith$default) {
                try {
                    QLog.d("WeatherMainPageHelper", 1, "openWeatherWeb: by scheme");
                    Intent intent = new Intent();
                    intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(url));
                    context.startActivity(intent);
                    return;
                } catch (Exception e16) {
                    QLog.e("WeatherMainPageHelper", 1, "openWeatherWeb error:", e16);
                }
            }
            QLog.d("WeatherMainPageHelper", 1, "openWeatherWeb: by url");
            P(context, url);
        }
    }

    public final void P(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra("url", url);
            context.startActivity(intent);
        } catch (Exception e16) {
            QLog.e("WeatherMainPageHelper", 1, "openWeb error:", e16);
        }
    }

    public final void Q(@NotNull MaskAdvName businessName, @NotNull String eventId, @Nullable JSONObject params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, businessName, eventId, params);
            return;
        }
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(businessName, eventId, params);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        com.tencent.mobileqq.weather.util.report.c.f313670a.a();
        com.tencent.mobileqq.weather.util.report.g.f313677a.a();
        n.f313689a.a();
        s.f313696a.a();
        com.tencent.mobileqq.weather.util.report.h.f313679a.a();
        com.tencent.mobileqq.weather.util.report.i.f313681a.a();
        com.tencent.mobileqq.weather.util.report.f.f313674a.a();
        j.f313683a.a();
        l.f313686a.a();
        com.tencent.mobileqq.weather.mvvm.h.f313416a.b();
        com.tencent.mobileqq.weather.data.f.f313296a.c();
        q.f313693a.a();
    }

    @NotNull
    public final String c(int airQuality) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, airQuality);
        }
        boolean z26 = true;
        if (airQuality >= 0 && airQuality < 51) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "\u4f18";
        }
        if (51 <= airQuality && airQuality < 101) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return "\u826f";
        }
        if (101 <= airQuality && airQuality < 151) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return "\u8f7b\u5ea6\u6c61\u67d3";
        }
        if (151 <= airQuality && airQuality < 201) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return "\u4e2d\u5ea6\u6c61\u67d3";
        }
        if (201 > airQuality || airQuality >= 301) {
            z26 = false;
        }
        if (z26) {
            return "\u91cd\u5ea6\u6c61\u67d3";
        }
        return "\u4e25\u91cd\u6c61\u67d3";
    }

    @NotNull
    public final List<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return astroNameList;
    }

    @NotNull
    public final HashMap<String, String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return astroToDateMap;
    }

    @NotNull
    public final HashMap<String, String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return astroToNameMap;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.mobileqq.weather.data.f fVar = com.tencent.mobileqq.weather.data.f.f313296a;
        return "https://weather.mp.qq.com/page/rain?_wv=16777219&adcode=" + fVar.i() + "&lat=" + fVar.k() + "&lon=" + fVar.l();
    }

    public final int h(int newcastingWeatherType) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, newcastingWeatherType)).intValue();
        }
        HashMap<Integer, Integer> hashMap = nowcastingWeatherMap;
        if (!hashMap.containsKey(Integer.valueOf(newcastingWeatherType)) || (num = hashMap.get(Integer.valueOf(newcastingWeatherType))) == null) {
            return 1;
        }
        int intValue = num.intValue();
        boolean z16 = false;
        if (4 <= intValue && intValue < 10) {
            z16 = true;
        }
        if (z16) {
            return 1;
        }
        if (intValue >= 10) {
            return 2;
        }
        return 3;
    }

    @Nullable
    public final com.tencent.mobileqq.weather.part.briefwarning.a i(@Nullable weather$GetConcernWeatherReply replyData, boolean isNight, int pagePos) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.weather.part.briefwarning.a) iPatchRedirector.redirect((short) 11, this, replyData, Boolean.valueOf(isNight), Integer.valueOf(pagePos));
        }
        if (com.tencent.mobileqq.weather.debug.g.f313380a.b()) {
            return j(replyData, isNight, pagePos);
        }
        if (replyData == null) {
            return null;
        }
        String q16 = q(replyData.nowcastWeather.get(), isNight);
        String briefText = replyData.nowcasting.get();
        String g16 = g();
        int h16 = h(replyData.nowcastWeather.get());
        ArrayList arrayList = new ArrayList();
        for (WeatherReportStore$WeatherWarningDetail weatherReportStore$WeatherWarningDetail : replyData.weather.warning_list.lst_warning.get()) {
            String B = B(weatherReportStore$WeatherWarningDetail.type.get(), weatherReportStore$WeatherWarningDetail.level.get());
            String str = weatherReportStore$WeatherWarningDetail.type_name.get() + weatherReportStore$WeatherWarningDetail.level_name.get() + "\u9884\u8b66";
            String str2 = weatherReportStore$WeatherWarningDetail.area.get();
            Intrinsics.checkNotNullExpressionValue(str2, "warningDetail.area.get()");
            String str3 = weatherReportStore$WeatherWarningDetail.city.get();
            Intrinsics.checkNotNullExpressionValue(str3, "warningDetail.city.get()");
            String str4 = weatherReportStore$WeatherWarningDetail.province.get();
            Intrinsics.checkNotNullExpressionValue(str4, "warningDetail.province.get()");
            String z17 = z(str2, str3, str4);
            String A = A(weatherReportStore$WeatherWarningDetail.pub_time.get());
            String b16 = b(weatherReportStore$WeatherWarningDetail.level.get());
            String warningJumpUrl = weatherReportStore$WeatherWarningDetail.jump_schema.get();
            Intrinsics.checkNotNullExpressionValue(warningJumpUrl, "warningJumpUrl");
            arrayList.add(new com.tencent.mobileqq.weather.part.briefwarning.e(pagePos, B, str, z17, A, b16, warningJumpUrl));
        }
        Intrinsics.checkNotNullExpressionValue(briefText, "briefText");
        if (pagePos == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new com.tencent.mobileqq.weather.part.briefwarning.a(q16, briefText, g16, h16, z16, arrayList);
    }

    @Nullable
    public final com.tencent.mobileqq.weather.part.briefwarning.a j(@Nullable weather$GetConcernWeatherReply replyData, boolean isNight, int pagePos) {
        boolean z16;
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.weather.part.briefwarning.a) iPatchRedirector.redirect((short) 12, this, replyData, Boolean.valueOf(isNight), Integer.valueOf(pagePos));
        }
        if (replyData == null) {
            return null;
        }
        String q16 = q(4, isNight);
        String g16 = g();
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < 4; i16++) {
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            str = "";
                        } else {
                            str = "\u66b4\u96ea\u9ec4\u8272\u9884\u8b66";
                        }
                    } else {
                        str = "\u5927\u98ce\u84dd\u8272\u9884\u8b66";
                    }
                } else {
                    str = "\u66b4\u96e8\u7ea2\u8272\u9884\u8b66";
                }
            } else {
                str = "\u66b4\u96e8\u6a59\u8272\u9884\u8b66";
            }
            String str2 = str;
            int i17 = 5;
            if (i16 != 0 && i16 != 1) {
                if (i16 != 2 && i16 == 3) {
                    i3 = 12;
                } else {
                    i3 = 5;
                }
            } else {
                i3 = 2;
            }
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            i17 = 2;
                        }
                    } else {
                        i17 = 1;
                    }
                } else {
                    i17 = 4;
                }
            } else {
                i17 = 3;
            }
            arrayList.add(new com.tencent.mobileqq.weather.part.briefwarning.e(pagePos, B(i3, i17), str2, "\u5357\u5c71\u533a", A(1695027952), b(i17), "https://e.weather.com.cn/alarmMap/detail.html?file=1011904-20230913092152-0202.html"));
        }
        if (pagePos == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new com.tencent.mobileqq.weather.part.briefwarning.a(q16, "\u77ed\u4e34\u964d\u96e8\u4fe1\u606f\u77ed\u4e34\u964d\u96e8\u4fe1\u606f", g16, 1, z16, arrayList);
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return SimpleUIUtil.getCurrentMode(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
    }

    @NotNull
    public final String l(@NotNull String name, boolean isNightTheme) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, name, Boolean.valueOf(isNightTheme));
        }
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap<String, String> hashMap = astroToNameMap;
        if (!hashMap.containsKey(name)) {
            return "";
        }
        String str2 = hashMap.get(name);
        if (isNightTheme) {
            str = "-dark";
        } else {
            str = "-light";
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/astros/" + str2 + "-bg" + str + ".png";
    }

    @NotNull
    public final String m(@NotNull String name, boolean isSelected, boolean isNightTheme) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, this, name, Boolean.valueOf(isSelected), Boolean.valueOf(isNightTheme));
        }
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap<String, String> hashMap = astroToNameMap;
        String str2 = "";
        if (!hashMap.containsKey(name)) {
            return "";
        }
        String str3 = hashMap.get(name);
        if (isNightTheme) {
            str = "-dark";
        } else {
            str = "-light";
        }
        if (isSelected) {
            str2 = str;
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/astros/" + str3 + str2 + ".png";
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return new SimpleDateFormat("yyyyMMddHH", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + "00";
    }

    @NotNull
    public final String o(int weatherType, @NotNull String lastPrefix, boolean isNight) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(weatherType), lastPrefix, Boolean.valueOf(isNight));
        }
        Intrinsics.checkNotNullParameter(lastPrefix, "lastPrefix");
        HashMap<Integer, String> hashMap = weatherTitleBgMap;
        if (hashMap.containsKey(Integer.valueOf(weatherType))) {
            str = hashMap.get(Integer.valueOf(weatherType));
        } else {
            str = "sunny";
        }
        if (isNight && K(weatherType)) {
            str2 = "-night";
        } else {
            str2 = "";
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/top-bar/" + str + "_refresh" + str2 + lastPrefix;
    }

    @NotNull
    public final String p(int weatherType) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, weatherType);
        }
        HashMap<Integer, String> hashMap = weatherTitleBgMap;
        if (hashMap.containsKey(Integer.valueOf(weatherType))) {
            str = hashMap.get(Integer.valueOf(weatherType));
        } else {
            str = "sunny";
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/weather-icon/" + str + ".png";
    }

    @NotNull
    public final String q(int newcastingWeatherType, boolean isNight) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(newcastingWeatherType), Boolean.valueOf(isNight));
        }
        HashMap<Integer, Integer> hashMap = nowcastingWeatherMap;
        String str2 = "";
        if (!hashMap.containsKey(Integer.valueOf(newcastingWeatherType))) {
            return "";
        }
        Integer num = hashMap.get(Integer.valueOf(newcastingWeatherType));
        HashMap<Integer, String> hashMap2 = weatherTitleBgMap;
        if (hashMap2.containsKey(num)) {
            str = hashMap2.get(num);
        } else {
            str = "sunny";
        }
        if (isNight) {
            Intrinsics.checkNotNull(num);
            if (K(num.intValue())) {
                str2 = "-night";
            }
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/weather-icon/" + str + str2 + ".png";
    }

    public final long r(@NotNull String timeString, int dayOffSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this, (Object) timeString, dayOffSet)).longValue();
        }
        Intrinsics.checkNotNullParameter(timeString, "timeString");
        if (!TextUtils.isEmpty(timeString) && timeString.length() >= 5) {
            return t(timeString, dayOffSet);
        }
        return t("06:00", dayOffSet);
    }

    public final long s(@NotNull String timeString, int dayOffSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this, (Object) timeString, dayOffSet)).longValue();
        }
        Intrinsics.checkNotNullParameter(timeString, "timeString");
        if (!TextUtils.isEmpty(timeString) && timeString.length() >= 5) {
            return t(timeString, dayOffSet);
        }
        return t("18:00", dayOffSet);
    }

    public final long u(@NotNull String timeString) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this, (Object) timeString)).longValue();
        }
        Intrinsics.checkNotNullParameter(timeString, "timeString");
        if (timeString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0L;
        }
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_12).parse(timeString).getTime() / 1000;
    }

    @NotNull
    public final String v(@NotNull WeatherInfo$Weather weather) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this, (Object) weather);
        }
        Intrinsics.checkNotNullParameter(weather, "weather");
        String title = weather.city.get();
        String str = weather.area.get();
        Intrinsics.checkNotNullExpressionValue(str, "weather.area.get()");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            title = weather.city.get() + weather.area.get();
        }
        Intrinsics.checkNotNullExpressionValue(title, "title");
        return title;
    }

    @NotNull
    public final String w(@Nullable Integer weatherType, boolean isNight) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, weatherType, Boolean.valueOf(isNight));
        }
        String str2 = "";
        if (weatherType == null) {
            return "";
        }
        HashMap<Integer, String> hashMap = weatherTitleBgMap;
        if (hashMap.containsKey(weatherType)) {
            str = hashMap.get(weatherType);
        } else {
            str = "sunny";
        }
        if (isNight && K(weatherType.intValue())) {
            str2 = "-night";
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/top-bar/" + str + "_bar" + str2 + ".png";
    }

    @NotNull
    public final String x() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.add(5, 1);
        int i3 = calendar.get(5);
        int i16 = calendar.get(2) + 1;
        int i17 = calendar.get(7);
        if (i17 > 0) {
            int i18 = i17 - 1;
            String[] strArr = weekDays;
            if (i18 < strArr.length) {
                str = strArr[i18];
                return i16 + "/" + i3 + " " + str;
            }
        }
        str = "";
        return i16 + "/" + i3 + " " + str;
    }

    @NotNull
    public final String y(int weatherType, @NotNull String lastPrefix, boolean isNight) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(weatherType), lastPrefix, Boolean.valueOf(isNight));
        }
        Intrinsics.checkNotNullParameter(lastPrefix, "lastPrefix");
        HashMap<Integer, String> hashMap = weatherTitleBgMap;
        if (hashMap.containsKey(Integer.valueOf(weatherType))) {
            str = hashMap.get(Integer.valueOf(weatherType));
        } else {
            str = "sunny";
        }
        if (isNight && K(weatherType)) {
            str2 = "-night";
        } else {
            str2 = "";
        }
        return "https://qq-weather.cdn-go.cn/hippy-weather/latest/weather-offline/" + str + str2 + lastPrefix;
    }
}
