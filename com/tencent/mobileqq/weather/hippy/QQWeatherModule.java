package com.tencent.mobileqq.weather.hippy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderHelper;
import com.tencent.mobileqq.weather.api.IWeatherTempApi;
import com.tencent.mobileqq.weather.hippy.QQWeatherModule;
import com.tencent.mobileqq.weather.util.calendar.CalendarUtils;
import com.tencent.mobileqq.weather.util.i;
import com.tencent.mobileqq.weather.webpage.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQWeatherModule.NAME)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/weather/hippy/QQWeatherModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", "getWeatherArkModels", "getLatestAdCode", "requestLocationPermission", "", "jsonStr", "sendAdPositionInScreen", "setMessageTabTop", "isMessageTabTop", "Lcom/tencent/mtt/hippy/common/HippyMap;", "data", "addRemindInfoToCalendar", "", "CALENDAR_PERMISSIONS", "[Ljava/lang/String;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQWeatherModule extends QQBaseModule {

    @NotNull
    private static final String AD_CODE = "adcode";

    @NotNull
    private static final String CITY = "city";

    @NotNull
    private static final String DISTRICT = "district";

    @NotNull
    private static final String LAT = "lat";

    @NotNull
    private static final String LON = "lon";

    @NotNull
    public static final String NAME = "QQWeatherModule";

    @NotNull
    private static final String PROVINCE = "province";

    @NotNull
    private static final String TAG = "QQWeatherNativeModule";

    @NotNull
    private final String[] CALENDAR_PERMISSIONS;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/weather/hippy/QQWeatherModule$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "deniedPermissions", "", "isShowGuide", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyMap f313384a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f313385b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/weather/hippy/QQWeatherModule$b$a", "Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils$a;", "", "result", "", "callback", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a implements CalendarUtils.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Promise f313386a;

            a(Promise promise) {
                this.f313386a = promise;
            }

            @Override // com.tencent.mobileqq.weather.util.calendar.CalendarUtils.a
            public void callback(int result) {
                this.f313386a.resolve(Integer.valueOf(result));
            }
        }

        b(HippyMap hippyMap, Promise promise) {
            this.f313384a = hippyMap;
            this.f313385b = promise;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            CalendarUtils.f313630a.c(this.f313384a, new a(this.f313385b));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            this.f313385b.resolve(-2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/hippy/QQWeatherModule$c", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f313387a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQWeatherModule f313388b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Promise promise, QQWeatherModule qQWeatherModule) {
            super("qq_weather", false);
            this.f313387a = promise;
            this.f313388b = qQWeatherModule;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, @Nullable SosoLbsInfo info) {
            SosoLocation sosoLocation;
            HippyMap hippyMap = new HippyMap();
            if (errCode == 0 && info != null && (sosoLocation = info.mLocation) != null) {
                try {
                    hippyMap.pushString(QQWeatherModule.AD_CODE, sosoLocation.cityCode);
                    hippyMap.pushString("lat", String.valueOf(sosoLocation.mLat02));
                    hippyMap.pushString("lon", String.valueOf(sosoLocation.mLon02));
                    hippyMap.pushString("province", sosoLocation.province);
                    hippyMap.pushString("city", sosoLocation.city);
                    hippyMap.pushString(QQWeatherModule.DISTRICT, sosoLocation.district);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e(QQWeatherModule.TAG, 2, th5, new Object[0]);
                    }
                    this.f313387a.reject(th5.toString());
                }
            }
            try {
                if (hippyMap.size() == 0 && this.f313388b.getActivity() != null) {
                    QQToast.makeText(this.f313388b.getActivity(), HardCodeUtil.qqStr(R.string.f238537k1), 0).show();
                }
                this.f313387a.resolve(hippyMap);
            } catch (Throwable th6) {
                QLog.i(QQWeatherModule.TAG, 1, "ark.arkNotify", th6);
                this.f313387a.reject(th6.toString());
            }
            QLog.i(QQWeatherModule.TAG, 1, "errCode \uff1a" + errCode + ", jsonObject: " + hippyMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/hippy/QQWeatherModule$d", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", QzoneIPCModule.RESULT_CODE, "", "isTop", "", "b", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d extends IPublicAccountCommonMrg.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f313389b;

        d(Promise promise) {
            this.f313389b = promise;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void b(int resultCode, boolean isTop) {
            String str;
            Promise promise = this.f313389b;
            HippyMap hippyMap = new HippyMap();
            if (isTop) {
                str = "1";
            } else {
                str = "0";
            }
            hippyMap.pushString("isMessageTop", str);
            promise.resolve(hippyMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/weather/hippy/QQWeatherModule$e", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "deniedPermissions", "", "isShowGuide", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f313390a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQWeatherModule f313391b;

        e(Promise promise, QQWeatherModule qQWeatherModule) {
            this.f313390a = promise;
            this.f313391b = qQWeatherModule;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f313390a.resolve("0");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            if (i.a(this.f313391b.getBaseActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
                this.f313390a.resolve("0");
            } else {
                this.f313390a.resolve("2");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQWeatherModule(@NotNull HippyEngineContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CALENDAR_PERMISSIONS = new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getWeatherArkModels$lambda$2(Promise promise, int i3, String str, ArrayList msgList) {
        MsgRecord msgRecord;
        a aVar;
        String valueOf;
        String b16;
        Intrinsics.checkNotNullParameter(promise, "$promise");
        try {
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            JSONObject jSONObject = null;
            if (!msgList.isEmpty()) {
                msgRecord = (MsgRecord) msgList.get(0);
            } else {
                msgRecord = null;
            }
            if (msgRecord != null) {
                aVar = com.tencent.mobileqq.weather.util.d.f313638a.j(((IWeatherTempApi) QRoute.api(IWeatherTempApi.class)).getMetaFromArkMsgRecord(msgRecord));
            } else {
                aVar = null;
            }
            if (aVar != null && (b16 = aVar.b()) != null) {
                jSONObject = new JSONObject(b16).getJSONObject("qq_weather");
            }
            if (TextUtils.isEmpty(String.valueOf(jSONObject))) {
                valueOf = "{}";
            } else {
                valueOf = String.valueOf(jSONObject);
            }
            promise.resolve(valueOf);
        } catch (Exception e16) {
            promise.reject(e16.toString());
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMessageTabTop$lambda$3(HippyMap res, Promise promise, int i3, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(res, "$res");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        QLog.i(TAG, 1, "setMessageTabTop " + i3 + str);
        if (i3 == 0) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        res.pushString("isSuccess", str2);
        promise.resolve(res);
    }

    @HippyMethod(name = "addRemindInfoToCalendar")
    public final void addRemindInfoToCalendar(@NotNull HippyMap data, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEATHER, QQPermissionConstants.Business.SCENE.WEATHER_WEEK));
        if (qQPermission != null) {
            qQPermission.requestPermissions(this.CALENDAR_PERMISSIONS, 2, new b(data, promise));
        }
    }

    @HippyMethod(name = "getLatestAdCode")
    public final void getLatestAdCode(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 1, "hippy call getLatestAdCode");
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new c(promise, this));
    }

    @HippyMethod(name = "getWeatherArkModels")
    public final void getWeatherArkModels(@NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(new Contact(1, "u_vmmIQZ3yUOpBlO2DISdO2g", ""), 1, new IMsgOperateCallback() { // from class: q43.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                QQWeatherModule.getWeatherArkModels$lambda$2(Promise.this, i3, str, arrayList);
            }
        });
    }

    @HippyMethod(name = "isMessageTabTop")
    public final void isMessageTabTop(@NotNull String jsonStr, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 1, "hippy call isMessageTabTop");
        try {
            if (!TextUtils.isEmpty(new JSONObject(jsonStr).getString("messageKey"))) {
                ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).getTopState("u_vmmIQZ3yUOpBlO2DISdO2g", new d(promise));
            }
        } catch (Throwable unused) {
            QLog.i(TAG, 1, "can't get pUin");
        }
    }

    @HippyMethod(name = "requestLocationPermission")
    public final void requestLocationPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEATHER, QQPermissionConstants.Business.SCENE.DRAWER_WEATHER));
        if (qQPermission != null) {
            qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new e(promise, this));
        }
    }

    @HippyMethod(name = "sendAdPositionInScreen")
    public final void sendAdPositionInScreen(@NotNull String jsonStr, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        JSONObject jSONObject = new JSONObject(jsonStr);
        MaskAdRenderHelper.INSTANCE.getMMaskAdSizeMap().put(MaskAdvName.QQ_WEATHER, new Pair<>(Integer.valueOf(jSONObject.getInt("height")), Integer.valueOf(jSONObject.getInt("top"))));
    }

    @HippyMethod(name = "setMessageTabTop")
    public final void setMessageTabTop(@NotNull String jsonStr, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 1, "hippy call setMessageTabTop");
        final HippyMap hippyMap = new HippyMap();
        try {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).setTop(Long.parseLong("2658655094"), "u_vmmIQZ3yUOpBlO2DISdO2g", true, new IOperateCallback() { // from class: q43.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQWeatherModule.setMessageTabTop$lambda$3(HippyMap.this, promise, i3, str);
                }
            });
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "can't get pUin");
            promise.reject(th5.toString());
        }
    }
}
