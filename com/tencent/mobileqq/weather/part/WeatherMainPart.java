package com.tencent.mobileqq.weather.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.jungle.weather.proto.WeatherInfo$Weather;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.weather.adapter.WeatherPagerAdapter;
import com.tencent.mobileqq.weather.event.WeatherRequestAdCodeEvent;
import com.tencent.mobileqq.weather.event.WeatherViewPageSelectChangeEvent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001B\u0018\u0000 H2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 0\u001fH\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010'R#\u00103\u001a\n .*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R#\u00108\u001a\n .*\u0004\u0018\u000104048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherMainPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "X9", "S9", "aa", "", "", "R9", "Y9", "Z9", "U9", "index", "V9", "adCode", "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "d", "Z", "mIsRegisteredReceiver", "e", "I", "mTargetCityAdCode", "f", "mIsPermissionJustGranted", tl.h.F, "mLastRequestAdPage", "Lcom/tencent/mobileqq/weather/mvvm/f;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "P9", "()Lcom/tencent/mobileqq/weather/mvvm/f;", "mMainViewModel", "Lcom/tencent/mobileqq/weather/mvvm/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q9", "()Lcom/tencent/mobileqq/weather/mvvm/e;", "mTitleModel", "Landroidx/viewpager2/widget/ViewPager2;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "D", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mWeatherDataList", "com/tencent/mobileqq/weather/part/WeatherMainPart$mMultiCityChangeReceiver$1", "E", "Lcom/tencent/mobileqq/weather/part/WeatherMainPart$mMultiCityChangeReceiver$1;", "mMultiCityChangeReceiver", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherMainPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ViewPager2 mViewPager;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<weather$GetConcernWeatherReply> mWeatherDataList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private WeatherMainPart$mMultiCityChangeReceiver$1 mMultiCityChangeReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRegisteredReceiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mTargetCityAdCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsPermissionJustGranted;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile int mLastRequestAdPage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMainViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTitleModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherMainPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.WeatherMainPart$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherMainPart$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherMainPart.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            super.onPageSelected(position);
            Integer value = WeatherMainPart.this.Q9().O1().getValue();
            if (value == null || value.intValue() != position) {
                com.tencent.mobileqq.weather.util.report.j.f313683a.b();
            }
            WeatherMainPart.this.Q9().O1().postValue(Integer.valueOf(position));
            if (WeatherMainPart.this.mWeatherDataList.size() > position) {
                WeatherMainPart.this.Q9().M1().postValue(((weather$GetConcernWeatherReply) WeatherMainPart.this.mWeatherDataList.get(position)).config);
                WeatherMainPart.this.Q9().S1().postValue(((weather$GetConcernWeatherReply) WeatherMainPart.this.mWeatherDataList.get(position)).weather);
                if (!WeatherMainPart.this.mWeatherDataList.isEmpty()) {
                    str = String.valueOf(((weather$GetConcernWeatherReply) WeatherMainPart.this.mWeatherDataList.get(0)).weather.adcode.get());
                } else {
                    str = "";
                }
                WeatherMainPart.this.Q9().N1().postValue(str);
                WeatherMainPart.this.Q9().R1().postValue(WeatherMainPart.this.R9());
                WeatherMainPart weatherMainPart = WeatherMainPart.this;
                weatherMainPart.mTargetCityAdCode = ((weather$GetConcernWeatherReply) weatherMainPart.mWeatherDataList.get(position)).weather.adcode.get();
            }
            SimpleEventBus.getInstance().dispatchEvent(new WeatherViewPageSelectChangeEvent(position, WeatherMainPart.this.mLastRequestAdPage));
            WeatherMainPart.this.mLastRequestAdPage = position;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherMainPart$c", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends LbsManagerServiceOnLocationChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            super("qq_weather", false);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherMainPart.this);
            }
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, @Nullable SosoLbsInfo info) {
            float f16;
            String str;
            float f17;
            SosoLocation sosoLocation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, errCode, (Object) info);
                return;
            }
            QLog.d("WeatherMainPart", 1, "reqFirstWeather onLocationFinish");
            if (errCode == 0 && info != null && (sosoLocation = info.mLocation) != null && (str = sosoLocation.cityCode) != null) {
                Intrinsics.checkNotNullExpressionValue(str, "info.mLocation.cityCode");
                if (Math.abs(info.mLocation.mLat02) > 1.0E-6d && Math.abs(info.mLocation.mLon02) > 1.0E-6d) {
                    SosoLocation sosoLocation2 = info.mLocation;
                    double[] a16 = com.tencent.mobileqq.ark.util.g.a(sosoLocation2.mLon02, sosoLocation2.mLat02);
                    SosoLocation sosoLocation3 = info.mLocation;
                    sosoLocation3.mLat84 = a16[1];
                    sosoLocation3.mLon84 = a16[0];
                }
                SosoLocation sosoLocation4 = info.mLocation;
                f16 = (float) sosoLocation4.mLat84;
                f17 = (float) sosoLocation4.mLon84;
            } else {
                f16 = 0.0f;
                str = "";
                f17 = 0.0f;
            }
            if (TextUtils.isEmpty(str)) {
                str = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
                Intrinsics.checkNotNullExpressionValue(str, "api(ILbsManagerServiceApi::class.java).cityCode");
                if (TextUtils.isEmpty(str)) {
                    str = String.valueOf(com.tencent.mobileqq.weather.data.f.f313296a.i());
                }
                if (TextUtils.isEmpty(str) && WeatherMainPart.this.getActivity() != null) {
                    QQToast.makeText(WeatherMainPart.this.getActivity(), HardCodeUtil.qqStr(R.string.f238537k1), 0).show();
                    WeatherMainPart.this.P9().M1(BusinessInfoCheckUpdateItem.UIAPPID_MINI_APP_PANEL);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str) && com.tencent.mobileqq.weather.util.b.f(WeatherMainPart.this.getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    com.tencent.mobileqq.weather.data.f fVar = com.tencent.mobileqq.weather.data.f.f313296a;
                    if (fVar.p() && fVar.i() == parseInt) {
                        return;
                    }
                    QLog.d("WeatherMainPart", 1, "reqFirstWeather current request:curAdCode:" + str + ", curLat:" + f16 + ", curLon:" + f17);
                    if (WeatherMainPart.this.mIsPermissionJustGranted) {
                        WeatherMainPart.this.mTargetCityAdCode = parseInt;
                    }
                    WeatherMainPart.this.P9().N1(parseInt, f16, f17);
                    fVar.s(parseInt);
                    fVar.u(f16);
                    fVar.v(f17);
                    fVar.y();
                } catch (Throwable th5) {
                    QLog.e("WeatherMainPart", 1, "send adcode to hippy failed, errCode \uff1a" + errCode + ", exception : " + th5);
                }
            }
            QLog.i("WeatherMainPart", 1, "errCode \uff1a" + errCode + ", curAdCode: " + str);
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherMainPart$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "deniedPermissions", "", "isShowGuide", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherMainPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) deniedPermissions)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            WeatherMainPart.this.mIsPermissionJustGranted = true;
            WeatherMainPart.this.Y9();
            SimpleEventBus.getInstance().dispatchEvent(new WeatherRequestAdCodeEvent(1));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
            } else {
                super.onDenied(permissions, results);
                SimpleEventBus.getInstance().dispatchEvent(new WeatherRequestAdCodeEvent(2));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mobileqq.weather.part.WeatherMainPart$mMultiCityChangeReceiver$1] */
    public WeatherMainPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.weather.mvvm.f>() { // from class: com.tencent.mobileqq.weather.part.WeatherMainPart$mMainViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherMainPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.weather.mvvm.f invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.weather.mvvm.f) WeatherMainPart.this.getViewModel(com.tencent.mobileqq.weather.mvvm.f.class) : (com.tencent.mobileqq.weather.mvvm.f) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mMainViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.weather.mvvm.e>() { // from class: com.tencent.mobileqq.weather.part.WeatherMainPart$mTitleModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherMainPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.weather.mvvm.e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.weather.mvvm.e) WeatherMainPart.this.getViewModel(com.tencent.mobileqq.weather.mvvm.e.class) : (com.tencent.mobileqq.weather.mvvm.e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mTitleModel = lazy2;
            this.mWeatherDataList = new CopyOnWriteArrayList<>();
            this.mMultiCityChangeReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.weather.part.WeatherMainPart$mMultiCityChangeReceiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherMainPart.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    String stringExtra;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (intent != null && Intrinsics.areEqual("openMultipleHippyPage", intent.getStringExtra("event")) && (stringExtra = intent.getStringExtra("data")) != null) {
                        try {
                            int optInt = new JSONObject(stringExtra).optInt("adcode");
                            if (optInt != 0) {
                                WeatherMainPart.this.mTargetCityAdCode = optInt;
                            }
                            WeatherMainPart.this.aa();
                        } catch (JSONException e16) {
                            QLog.e("WeatherMainPart", 1, "mMultiCityChangeReceiver onReceive parse data error:", e16);
                        }
                    }
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final int O9(int adCode) {
        Iterator<weather$GetConcernWeatherReply> it = this.mWeatherDataList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            if (it.next().weather.adcode.get() == adCode) {
                return i3;
            }
            i3 = i16;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.weather.mvvm.f P9() {
        return (com.tencent.mobileqq.weather.mvvm.f) this.mMainViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.weather.mvvm.e Q9() {
        return (com.tencent.mobileqq.weather.mvvm.e) this.mTitleModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Integer> R9() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator<weather$GetConcernWeatherReply> it = this.mWeatherDataList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            weather$GetConcernWeatherReply next = it.next();
            if (i3 != 0) {
                Intrinsics.checkNotNullExpressionValue(next.weather.warning_list.lst_warning.get(), "item.weather.warning_list.lst_warning.get()");
                if (!r4.isEmpty()) {
                    copyOnWriteArrayList.add(Integer.valueOf(i3));
                }
            }
            i3 = i16;
        }
        return copyOnWriteArrayList;
    }

    private final void S9() {
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(1);
            viewPager2.registerOnPageChangeCallback(new b());
        }
        ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 != null) {
            viewPager22.setAdapter(new WeatherPagerAdapter());
        }
        MutableLiveData<weather$GetConcernWeatherReply> L1 = P9().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<weather$GetConcernWeatherReply, Unit> function1 = new Function1<weather$GetConcernWeatherReply, Unit>() { // from class: com.tencent.mobileqq.weather.part.WeatherMainPart$initViewPager$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherMainPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(weather$GetConcernWeatherReply weather_getconcernweatherreply) {
                invoke2(weather_getconcernweatherreply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(weather$GetConcernWeatherReply weather_getconcernweatherreply) {
                ArrayList arrayListOf;
                ViewPager2 viewPager23;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) weather_getconcernweatherreply);
                    return;
                }
                if (weather_getconcernweatherreply.weather.adcode.get() == 0) {
                    return;
                }
                com.tencent.mobileqq.weather.data.f.f313296a.w(weather_getconcernweatherreply);
                WeatherMainPart weatherMainPart = WeatherMainPart.this;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(weather_getconcernweatherreply);
                weatherMainPart.mWeatherDataList = new CopyOnWriteArrayList(arrayListOf);
                for (WeatherInfo$Weather weatherInfo$Weather : weather_getconcernweatherreply.concernWeathers.get()) {
                    weather$GetConcernWeatherReply weather_getconcernweatherreply2 = new weather$GetConcernWeatherReply();
                    weather_getconcernweatherreply2.set(weather_getconcernweatherreply);
                    weather_getconcernweatherreply2.weather = weatherInfo$Weather;
                    WeatherMainPart.this.mWeatherDataList.add(weather_getconcernweatherreply2);
                }
                WeatherMainPart.this.Q9().N1().postValue(String.valueOf(weather_getconcernweatherreply.weather.adcode.get()));
                WeatherMainPart.this.Q9().L1().postValue(Integer.valueOf(WeatherMainPart.this.mWeatherDataList.size()));
                viewPager23 = WeatherMainPart.this.mViewPager;
                RecyclerView.Adapter adapter = viewPager23 != null ? viewPager23.getAdapter() : null;
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.weather.adapter.WeatherPagerAdapter");
                ((WeatherPagerAdapter) adapter).updateData(WeatherMainPart.this.mWeatherDataList);
                WeatherMainPart.this.Q9().S1().postValue(weather_getconcernweatherreply.weather);
                WeatherMainPart.this.Q9().M1().postValue(weather_getconcernweatherreply.config);
                if (!WeatherMainPart.this.mIsPermissionJustGranted) {
                    WeatherMainPart.this.U9();
                }
                if (WeatherMainPart.this.mIsPermissionJustGranted) {
                    WeatherMainPart.this.mIsPermissionJustGranted = false;
                }
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.weather.part.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherMainPart.T9(Function1.this, obj);
            }
        });
        Integer value = Q9().O1().getValue();
        if (value == null || value.intValue() != 0) {
            return;
        }
        aa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9() {
        QLog.d("WeatherMainPart", 1, "jumpToTargetCity adCode:", Integer.valueOf(this.mTargetCityAdCode));
        V9(O9(this.mTargetCityAdCode));
    }

    private final void V9(final int index) {
        RecyclerView.Adapter adapter;
        final ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 != null && (adapter = viewPager2.getAdapter()) != null && index < adapter.getNUM_BACKGOURND_ICON()) {
            QLog.d("WeatherMainPart", 1, "jumpToTargetCity index:", Integer.valueOf(index));
            viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.weather.part.r
                @Override // java.lang.Runnable
                public final void run() {
                    WeatherMainPart.W9(ViewPager2.this, index);
                }
            });
        }
        if (index < this.mWeatherDataList.size()) {
            Q9().S1().postValue(this.mWeatherDataList.get(index).weather);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(ViewPager2 it, int i3) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.setCurrentItem(i3);
    }

    private final void X9() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        getContext().registerReceiver(this.mMultiCityChangeReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        this.mIsRegisteredReceiver = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        boolean z16;
        QLog.d("WeatherMainPart", 1, "reqFirstWeather requestAdCode");
        com.tencent.mobileqq.weather.data.f fVar = com.tencent.mobileqq.weather.data.f.f313296a;
        if (fVar.p()) {
            int i3 = fVar.i();
            float k3 = fVar.k();
            float l3 = fVar.l();
            if (i3 != 0) {
                boolean z17 = false;
                if (k3 == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (l3 == 0.0f) {
                        z17 = true;
                    }
                    if (!z17) {
                        QLog.d("WeatherMainPart", 1, "reqFirstWeather useCache:curAdCode:" + i3 + ", curLat:" + k3 + ", curLon:" + l3);
                        P9().N1(i3, k3, l3);
                    }
                }
            }
        }
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new c());
    }

    private final void Z9() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEATHER, QQPermissionConstants.Business.SCENE.DRAWER_WEATHER));
        if (qQPermission != null) {
            qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa() {
        QLog.d("WeatherMainPart", 1, "requestWeatherData target city adCode:", Integer.valueOf(this.mTargetCityAdCode));
        boolean f16 = com.tencent.mobileqq.weather.util.b.f(getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5);
        QLog.d("WeatherMainPart", 1, "get adCode: has location permission:", Boolean.valueOf(f16));
        if (f16) {
            Y9();
            return;
        }
        P9().M1(BusinessInfoCheckUpdateItem.UIAPPID_MINI_APP_PANEL);
        com.tencent.mobileqq.weather.data.f fVar = com.tencent.mobileqq.weather.data.f.f313296a;
        if (fVar.b()) {
            Z9();
            fVar.x();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherRequestAdCodeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            this.mViewPager = (ViewPager2) rootView.findViewById(R.id.f1196277c);
        }
        S9();
        this.mLastRequestAdPage = 0;
        X9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.weather.util.g.f313646a.a();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.mIsRegisteredReceiver) {
            try {
                getContext().unregisterReceiver(this.mMultiCityChangeReceiver);
                this.mIsRegisteredReceiver = false;
            } catch (Exception e16) {
                QLog.e("WeatherMainPart", 1, "onDestroy(), unregisterReceiver error:", e16);
            }
        }
        QQPermission.exitModule("biz_src_qqweather");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            ee2.d.b("weather");
            super.onPartPause(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        ee2.d.a("weather");
        QQPermission.enterModule("biz_src_qqweather");
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
        } else if ((event instanceof WeatherRequestAdCodeEvent) && ((WeatherRequestAdCodeEvent) event).getPermissionState() == 0) {
            Z9();
        }
    }
}
