package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.StatusVisibleFragment;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment;
import com.tencent.mobileqq.onlinestatus.view.u;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherModel;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010?\u001a\u000208\u0012\b\u0010\u009a\u0001\u001a\u00030\u0099\u0001\u0012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001\u00a2\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J>\u0010\u0015\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0017H\u0007J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0014J\b\u0010#\u001a\u00020\u0004H\u0016J\u001c\u0010'\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u001a2\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\b\u0010(\u001a\u00020\u000fH\u0014J\"\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u001e\u00102\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f00H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u000bH\u0014J\u0012\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105H\u0016R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0018\u0010V\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010OR\u0018\u0010X\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010OR\u0018\u0010[\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010OR\u0018\u0010_\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010OR\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010ZR\u0014\u0010g\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010ZR\u0018\u0010i\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010OR\u0018\u0010k\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010OR\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010YR\u0016\u0010x\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010YR,\u0010\u0081\u0001\u001a\n z*\u0004\u0018\u00010y0y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R)\u0010\u0088\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R)\u0010\u008c\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u0083\u0001\u001a\u0006\b\u008a\u0001\u0010\u0085\u0001\"\u0006\b\u008b\u0001\u0010\u0087\u0001R*\u0010\u0094\u0001\u001a\u00030\u008d\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0098\u0001\u001a\u00020\u00138\u0006\u00a2\u0006\u000f\n\u0005\b\u0095\u0001\u0010s\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/WeatherView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment;", "Lcom/tencent/mobileqq/onlinestatus/manager/OnlineStatusPermissionManager$b;", "Lcom/tencent/mobileqq/onlinestatus/StatusVisibleFragment$b;", "", "initData", "", "change", "bi", "hasPartPermission", "Rh", "", "url", "Landroid/widget/ImageView;", "view", "", "corner", "outWidth", "outHeight", "Landroid/graphics/drawable/Drawable;", "drawable", "Yh", "ai", "Lcom/tencent/mobileqq/onlinestatus/weather/OnlineStatusWeatherModel;", "Xh", "rh", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "weatherModel", "Th", "", "time", "Zh", "show", "qh", DKHippyEvent.EVENT_STOP, "targetView", "", "cardRect", "Ah", "xh", "requestCode", AdMetricTag.RESPONSE_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusFriendsPermissionItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "smartSelectedList", Constants.SIM_INFO, "Eh", "yh", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionChecker$OnlineStatusPermissionItem;", "permissionItem", "Zb", "Lcom/tencent/mobileqq/app/QBaseActivity;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/app/QBaseActivity;", "Wh", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "setActivity", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "viewWeatherIcon", ExifInterface.LATITUDE_SOUTH, "viewWeatherBg", "Landroid/widget/Button;", "T", "Landroid/widget/Button;", "getViewSelectStatus", "()Landroid/widget/Button;", "setViewSelectStatus", "(Landroid/widget/Button;)V", "viewSelectStatus", "Landroid/widget/TextView;", "U", "Landroid/widget/TextView;", "viewTemperature", "V", "viewWeatherName", "W", "viewWeatherHint", "X", "viewAddress", "Y", "viewDate", "Z", "Landroid/view/View;", "nightThemeBg", "a0", "viewSelectFriends", "b0", "viewChangeFriends", "Lwc2/c;", "c0", "Lwc2/c;", "weatherObserver", "d0", "contentView", "e0", "weatherRootView", "f0", "viewMainTitle", "g0", "viewSubTitle", "h0", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionChecker$OnlineStatusPermissionItem;", "Lmqq/app/AppRuntime;", "i0", "Lmqq/app/AppRuntime;", "app", "j0", "Landroid/graphics/drawable/Drawable;", "defaultWeatherDrawable", "k0", "needSwitchOnlineStatus", "l0", "needCallbackOnStop", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "m0", "Lcom/tencent/qphone/base/util/BaseApplication;", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "appContext", "n0", "I", "getWidthBg", "()I", "setWidthBg", "(I)V", "widthBg", "o0", "getHeightBg", "setHeightBg", "heightBg", "", "p0", UserInfo.SEX_FEMALE, "getCornerBg", "()F", "setCornerBg", "(F)V", "cornerBg", "q0", "getTRANSPARENT", "()Landroid/graphics/drawable/Drawable;", "TRANSPARENT", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment$a;", "dismissCallback", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment$a;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class WeatherView extends BaseStatusCardViewFragment implements OnlineStatusPermissionManager.b, StatusVisibleFragment.b {

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private QBaseActivity activity;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ImageView viewWeatherIcon;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ImageView viewWeatherBg;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Button viewSelectStatus;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private TextView viewTemperature;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private TextView viewWeatherName;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView viewWeatherHint;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TextView viewAddress;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private TextView viewDate;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private View nightThemeBg;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView viewSelectFriends;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView viewChangeFriends;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private wc2.c weatherObserver;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View contentView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View weatherRootView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView viewMainTitle;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView viewSubTitle;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OnlineStatusPermissionChecker.OnlineStatusPermissionItem permissionItem;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime app;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable defaultWeatherDrawable;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean needSwitchOnlineStatus;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean needCallbackOnStop;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private BaseApplication appContext;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private int widthBg;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private int heightBg;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private float cornerBg;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable TRANSPARENT;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/WeatherView$a", "Lwc2/c;", "", "success", "Landroid/os/Bundle;", "bundle", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends wc2.c {
        a() {
        }

        @Override // wc2.c
        public void a(boolean success, @Nullable Bundle bundle) {
            OnlineStatusWeatherModel onlineStatusWeatherModel;
            super.a(success, bundle);
            if (QLog.isColorLevel()) {
                QLog.d(QPublicBaseFragment.TAG, 2, "receiveReqWeather: called. ", "bundle: " + bundle, " success: " + success);
            }
            if (success) {
                if (bundle != null) {
                    onlineStatusWeatherModel = (OnlineStatusWeatherModel) bundle.getParcelable("weatherModel");
                } else {
                    onlineStatusWeatherModel = null;
                }
                WeatherView weatherView = WeatherView.this;
                if (onlineStatusWeatherModel == null) {
                    onlineStatusWeatherModel = weatherView.Xh();
                }
                weatherView.Th(onlineStatusWeatherModel);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/WeatherView$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "deniedPermissions", "", "isShowGuide", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
            ((OnlineStatusDataManager) manager).O(9);
            WeatherView.this.show();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            if (com.tencent.mobileqq.weather.util.i.a(WeatherView.this.getActivity(), QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
                com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
                ((OnlineStatusDataManager) manager).O(9);
                WeatherView.this.show();
                return;
            }
            WeatherView.this.J.L0(AppRuntime.Status.online, 1030);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherView(@NotNull QBaseActivity activity, @NotNull OnLineStatusBlurBg onLineStatusBlurBg, @NotNull BaseStatusCardViewFragment.a dismissCallback) {
        super(activity, dismissCallback);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onLineStatusBlurBg, "onLineStatusBlurBg");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        this.activity = activity;
        AppRuntime appRuntime = activity.getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(appRuntime, "activity.appRuntime");
        this.app = appRuntime;
        this.needSwitchOnlineStatus = true;
        this.appContext = BaseApplication.context;
        this.TRANSPARENT = new ColorDrawable(0);
        this.I = 1;
        View createView = createView();
        this.contentView = createView;
        this.N = onLineStatusBlurBg;
        createView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeatherView.Oh(WeatherView.this, view);
            }
        });
        View findViewById = createView.findViewById(R.id.f121617bq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.weather_root)");
        this.weatherRootView = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.br
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeatherView.Ph(view);
            }
        });
        this.C = createView;
        this.D = findViewById;
        initData();
        this.widthBg = this.appContext.getResources().getDisplayMetrics().widthPixels - Utils.n(80.0f, this.appContext.getResources());
        this.heightBg = Utils.n(211.0f, this.appContext.getResources());
        this.cornerBg = 12 * com.tencent.mobileqq.utils.ah.q();
        Bitmap j3 = com.tencent.mobileqq.util.j.j(this.appContext.getResources(), R.drawable.k65, this.widthBg, this.heightBg);
        if (j3 != null) {
            this.defaultWeatherDrawable = new BitmapDrawable(this.appContext.getResources(), BaseImageUtil.getHalfRoundedBitmap(j3, this.cornerBg, this.widthBg, this.heightBg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(WeatherView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sh();
        this$0.J.L0(AppRuntime.Status.online, 1030);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Rh(final boolean hasPartPermission) {
        Resources resources = this.appContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "appContext.resources");
        String string = resources.getString(R.string.zpl);
        Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.c\u2026atus_all_friends_visible)");
        if (hasPartPermission) {
            string = resources.getString(R.string.zpr);
            Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.c\u2026tus_part_friends_visible)");
        }
        String string2 = resources.getString(R.string.zpq);
        Intrinsics.checkNotNullExpressionValue(string2, "res.getString(R.string.c\u2026iends_visible_modify_tip)");
        TextView textView = this.viewSelectFriends;
        if (textView != null) {
            textView.setText(string);
            textView.setContentDescription(string);
        }
        TextView textView2 = this.viewChangeFriends;
        if (textView2 != null) {
            textView2.setText(string2);
            textView2.setClickable(true);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherView.Sh(hasPartPermission, this, view);
                }
            });
            textView2.setOnTouchListener(new u.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(boolean z16, WeatherView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            bv.e("0X800AF49", 2, null, null, 12, null);
        } else {
            bv.e("0X800AF49", 1, null, null, 12, null);
        }
        StatusVisibleFragment.sh(this$0.activity, this$0.permissionItem, 2, 1030, this$0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(WeatherView this$0, OnlineStatusWeatherModel weatherModel, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(weatherModel, "$weatherModel");
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(this$0.activity, 1, R.string.hpk, 0).show();
            this$0.J.L0(AppRuntime.Status.online, 1030);
        } else {
            IRuntimeService runtimeService = this$0.app.getRuntimeService(IOnlineStatusManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
            com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
            OnlineStatusDataManager onlineStatusDataManager = (OnlineStatusDataManager) manager;
            Intent intent = new Intent();
            OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = this$0.permissionItem;
            if (onlineStatusPermissionItem != null) {
                intent.putExtra("online_status_permission_item", onlineStatusPermissionItem);
            }
            intent.putExtra("from_modify", !this$0.needSwitchOnlineStatus);
            if (QLog.isColorLevel()) {
                QLog.d(QPublicBaseFragment.TAG, 2, "bindView: called. ", "needSwitchOnlineStatus: " + this$0.needSwitchOnlineStatus);
            }
            onlineStatusDataManager.K(8, intent, weatherModel);
        }
        this$0.J.G0(AppRuntime.Status.online, 1030L);
        this$0.sh();
        bv.e("0X800AF48", 0, null, null, 14, null);
        if (com.tencent.mobileqq.onlinestatus.be.p()) {
            if (((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(1030)) {
                str = "0";
            } else {
                str = "1";
            }
            bv.e("0X8009DE0", 1030, str, null, 8, null);
        } else {
            bv.e("0X8009DE0", 1030, null, null, 12, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(WeatherView this$0, com.tencent.mobileqq.config.business.af afVar, OnlineStatusWeatherModel weatherModel, Drawable drawable) {
        String str;
        int measuredWidth;
        jc2.c b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(weatherModel, "$weatherModel");
        if (afVar != null && (b16 = afVar.b(weatherModel.getWeatherTypeId())) != null) {
            str = b16.f409786c;
        } else {
            str = null;
        }
        String str2 = str;
        ImageView imageView = this$0.viewWeatherBg;
        int i3 = (int) this$0.cornerBg;
        if (imageView == null) {
            measuredWidth = this$0.widthBg;
        } else {
            Intrinsics.checkNotNull(imageView);
            measuredWidth = imageView.getMeasuredWidth();
        }
        this$0.Yh(str2, imageView, i3, measuredWidth, this$0.heightBg, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OnlineStatusWeatherModel Xh() {
        OnlineStatusWeatherModel onlineStatusWeatherModel = new OnlineStatusWeatherModel();
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = com.tencent.mobileqq.onlinestatus.bs.H(QPublicBaseFragment.TAG);
        if (H != null) {
            onlineStatusWeatherModel.s(H.d0());
            onlineStatusWeatherModel.y(H.o0());
            onlineStatusWeatherModel.z(H.p0());
            onlineStatusWeatherModel.A(H.q0());
            onlineStatusWeatherModel.x(H.n0());
            onlineStatusWeatherModel.t(H.j0());
            onlineStatusWeatherModel.u(H.k0());
            onlineStatusWeatherModel.r(H.f());
            onlineStatusWeatherModel.q(H.e());
            onlineStatusWeatherModel.p(H.c());
            onlineStatusWeatherModel.v(H.l0());
            onlineStatusWeatherModel.w(H.m0());
        }
        return onlineStatusWeatherModel;
    }

    private final void Yh(String url, ImageView view, int corner, int outWidth, int outHeight, Drawable drawable) {
        boolean z16;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mRequestWidth = outWidth;
        obtain.mRequestHeight = outHeight;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (view != null) {
                view.setImageDrawable(obtain.mFailedDrawable);
                return;
            }
            return;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        if (corner > 0) {
            drawable2.setTag(com.tencent.mobileqq.onlinestatus.utils.ah.a(obtain.mRequestWidth, obtain.mRequestHeight, corner));
            drawable2.setDecodeHandler(com.tencent.mobileqq.onlinestatus.utils.ah.f256342b);
        }
        if (view != null) {
            view.setImageDrawable(drawable2);
        }
    }

    private final void ai() {
        boolean z16;
        boolean z17;
        OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = this.permissionItem;
        if (onlineStatusPermissionItem != null) {
            z16 = !onlineStatusPermissionItem.isAllHasPermission();
            IRuntimeService runtimeService = this.app.getRuntimeService(IOnlineStatusManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
            com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager");
            z17 = ((OnlineStatusPermissionManager) manager).E(this.permissionItem, this);
        } else {
            z16 = false;
            z17 = false;
        }
        Rh(z16);
        bi(z17);
    }

    private final void bi(boolean change) {
        int i3;
        Button button = this.viewSelectStatus;
        if (button != null) {
            IRuntimeService runtimeService = this.app.getRuntimeService(IOnlineStatusService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
            if (((IOnlineStatusService) runtimeService).getExtOnlineStatus() == 1030) {
                if (change) {
                    i3 = R.string.zpn;
                } else {
                    i3 = R.string.cne;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QPublicBaseFragment.TAG, 2, "updateButtonText: called. ", "change: " + change);
                }
                this.needSwitchOnlineStatus = !change;
                button.setText(this.app.getApp().getText(i3));
                button.setEnabled(change);
                return;
            }
            button.setText(this.app.getApp().getText(R.string.f171175cx0));
            button.setEnabled(true);
        }
    }

    private final void initData() {
        this.weatherObserver = new a();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected void Ah(@Nullable View targetView, @Nullable int[] cardRect) {
        if (cardRect != null) {
            if (targetView != null && targetView.getWidth() != 0 && targetView.getHeight() != 0) {
                cardRect[0] = targetView.getWidth();
                cardRect[1] = targetView.getHeight();
            } else {
                cardRect[0] = this.widthBg;
                cardRect[1] = Utils.n(430.0f, this.D.getResources());
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    public void Eh() {
        QQPermissionFactory.getQQPermission(this.activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ONLINE_STATUS_WEATHER_ID, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)).requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new b());
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.b
    public void G6(@NotNull OnlineStatusFriendsPermissionItem item, @NotNull List<Integer> smartSelectedList) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(smartSelectedList, "smartSelectedList");
        if (this.permissionItem == null) {
            this.permissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, item.allHasPermission, item.permissionUins);
            ai();
        }
        if (OnlineStatusToggleUtils.w()) {
            ai();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void Th(@NotNull final OnlineStatusWeatherModel weatherModel) {
        String str;
        boolean z16;
        jc2.c b16;
        Intrinsics.checkNotNullParameter(weatherModel, "weatherModel");
        TextView textView = this.viewWeatherHint;
        if (textView != null) {
            String weatherTip = weatherModel.getWeatherTip();
            if (weatherTip == null) {
                weatherTip = "";
            }
            textView.setText(weatherTip);
        }
        TextView textView2 = this.viewWeatherName;
        if (textView2 != null) {
            String weatherType = weatherModel.getWeatherType();
            if (weatherType == null) {
                weatherType = "";
            }
            textView2.setText(weatherType);
        }
        TextView textView3 = this.viewAddress;
        if (textView3 != null) {
            String city = weatherModel.getCity();
            if (city == null) {
                city = "";
            }
            String str2 = weatherModel.getCom.tencent.gdtad.jsbridge.GdtGetUserInfoHandler.KEY_AREA java.lang.String();
            if (str2 == null) {
                str2 = "";
            }
            textView3.setText(city + str2);
        }
        TextView textView4 = this.viewTemperature;
        if (textView4 != null) {
            String temper = weatherModel.getTemper();
            if (temper == null) {
                temper = "";
            }
            textView4.setText(temper);
        }
        Button button = this.viewSelectStatus;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherView.Uh(WeatherView.this, weatherModel, view);
                }
            });
        }
        boolean z17 = true;
        this.needSwitchOnlineStatus = true;
        bi(false);
        final com.tencent.mobileqq.config.business.af a16 = com.tencent.mobileqq.config.business.ah.f202497a.a();
        int n3 = Utils.n(26.0f, this.appContext.getResources());
        if (a16 != null && (b16 = a16.b(weatherModel.getWeatherTypeId())) != null) {
            str = b16.f409785b;
        } else {
            str = null;
        }
        String str3 = str;
        ImageView imageView = this.viewWeatherIcon;
        final Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        Yh(str3, imageView, 0, n3, n3, drawable);
        Drawable drawable2 = this.defaultWeatherDrawable;
        if (drawable2 != null) {
            drawable = drawable2;
        }
        ImageView imageView2 = this.viewWeatherBg;
        if (imageView2 != null) {
            imageView2.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.bu
                @Override // java.lang.Runnable
                public final void run() {
                    WeatherView.Vh(WeatherView.this, a16, weatherModel, drawable);
                }
            });
        }
        long weatherUpdateTime = weatherModel.getWeatherUpdateTime();
        if (weatherUpdateTime <= 0) {
            TextView textView5 = this.viewDate;
            if (textView5 != null) {
                textView5.setText("");
            }
        } else {
            TextView textView6 = this.viewDate;
            if (textView6 != null) {
                textView6.setText(Zh(weatherUpdateTime * 1000));
            }
        }
        String temper2 = weatherModel.getTemper();
        if (temper2 != null && temper2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            TextView textView7 = this.viewTemperature;
            if (textView7 != null) {
                textView7.setText("");
            }
        } else {
            TextView textView8 = this.viewTemperature;
            if (textView8 != null) {
                textView8.setText(temper2 + "\u2103");
            }
        }
        IRuntimeService runtimeService = this.app.getRuntimeService(IOnlineStatusManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
        com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager");
        OnlineStatusPermissionManager onlineStatusPermissionManager = (OnlineStatusPermissionManager) manager;
        OnlineStatusFriendsPermissionItem D = onlineStatusPermissionManager.D(40001L, false, this);
        if (D == null || D.allHasPermission) {
            z17 = false;
        }
        if (OnlineStatusToggleUtils.w()) {
            onlineStatusPermissionManager.I(40001L, false);
        }
        Rh(z17);
        if (AppSetting.f99565y) {
            AccessibilityUtil.m(this.viewTemperature);
        }
    }

    @NotNull
    /* renamed from: Wh, reason: from getter */
    public final QBaseActivity getActivity() {
        return this.activity;
    }

    @Override // com.tencent.mobileqq.onlinestatus.StatusVisibleFragment.b
    public void Zb(@Nullable OnlineStatusPermissionChecker.OnlineStatusPermissionItem permissionItem) {
        this.permissionItem = permissionItem;
        ai();
    }

    @NotNull
    public final String Zh(long time) {
        String format = kc2.c.j().format(new Date(time));
        Intrinsics.checkNotNullExpressionValue(format, "defaultDateFormat.format(date)");
        return format;
    }

    @NotNull
    public final View createView() {
        View view = View.inflate(BaseApplication.context, R.layout.f168885h55, null);
        this.viewWeatherIcon = (ImageView) view.findViewById(R.id.f121017a4);
        this.viewWeatherBg = (ImageView) view.findViewById(R.id.yw7);
        this.viewTemperature = (TextView) view.findViewById(R.id.jcz);
        this.viewWeatherName = (TextView) view.findViewById(R.id.f121137af);
        this.viewSelectStatus = (Button) view.findViewById(R.id.f82444gw);
        this.viewWeatherHint = (TextView) view.findViewById(R.id.f120977a0);
        this.viewSelectFriends = (TextView) view.findViewById(R.id.f82144g3);
        this.viewChangeFriends = (TextView) view.findViewById(R.id.f82034fs);
        this.viewAddress = (TextView) view.findViewById(R.id.f164042i9);
        this.viewDate = (TextView) view.findViewById(R.id.bdk);
        this.nightThemeBg = view.findViewById(R.id.zrj);
        this.viewMainTitle = (TextView) view.findViewById(R.id.ywk);
        this.viewSubTitle = (TextView) view.findViewById(R.id.f166931j64);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int responseCode, @Nullable Intent data) {
        if (requestCode == 1030 && responseCode == -1 && data != null && data.getSerializableExtra("online_status_permission_item") != null) {
            Serializable serializableExtra = data.getSerializableExtra("online_status_permission_item");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem");
            this.permissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) serializableExtra;
            ai();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.needCallbackOnStop) {
            this.J.L0(AppRuntime.Status.online, 1030);
        }
        this.needCallbackOnStop = false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected void qh() {
        this.app.unRegistObserver(this.weatherObserver);
        this.needCallbackOnStop = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    public void rh() {
        if (QQTheme.isNowThemeIsNight()) {
            this.weatherRootView.setBackgroundResource(R.drawable.kxv);
            v3(false, null, Color.parseColor("#FF010101"));
            View view = this.nightThemeBg;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        this.weatherRootView.setBackgroundResource(R.drawable.qq_status_card_background);
        View view2 = this.nightThemeBg;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        super.rh();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.onlinestatus.y
    public void show() {
        this.app.registObserver(this.weatherObserver);
        this.permissionItem = null;
        this.needCallbackOnStop = true;
        Th(Xh());
        rh();
        try {
            Hh(this.viewMainTitle);
            Hh(this.viewSubTitle);
            super.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(QPublicBaseFragment.TAG, 2, "show: called. ", "", e16);
            }
        }
        Gh(true);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected int xh() {
        return Utils.n(430.0f, this.D.getResources());
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    @NotNull
    protected String yh() {
        String name = WeatherView.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "WeatherView::class.java.name");
        return name;
    }
}
